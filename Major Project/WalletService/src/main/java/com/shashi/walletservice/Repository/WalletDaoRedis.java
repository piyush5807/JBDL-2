package com.shashi.walletservice.Repository;

import com.shashi.walletservice.Model.User;
import com.shashi.walletservice.Model.Wallet;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shashi.walletservice.Model.WalletInRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class WalletDaoRedis {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    WalletRepository walletRepository;
    private static final String KEY = "wallet";
    public Boolean updateWallet(WalletInRedis wallet) {
        try {
            Map userHash = new ObjectMapper().convertValue(wallet, Map.class);
            redisTemplate.opsForHash().put(KEY, String.valueOf( wallet.getUid()), userHash);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public WalletInRedis getWallet(Integer uid) {

        String id = Integer.toString(uid);
        Map WalletMap = (Map) redisTemplate.opsForHash().get(KEY, id);
        WalletInRedis walletInRedis;

        if(WalletMap==null || WalletMap.equals(null) || WalletMap.isEmpty())
        {
            System.out.println("Fetching from DB");
            walletInRedis = new WalletInRedis();
            Wallet wallet = walletRepository.findWalletByUserId(uid);

            walletInRedis.setAmount(wallet.getBalance());
            walletInRedis.setUid(wallet.getUser_id());
            Map walletHash = new ObjectMapper().convertValue(walletInRedis, Map.class);
            redisTemplate.opsForHash().put(KEY, Integer.toString(walletInRedis.getUid()), walletHash);
        }
        else {
            System.out.println("Fetching from Cache");

            walletInRedis = new ObjectMapper().convertValue(WalletMap, WalletInRedis.class);
        }
        return walletInRedis;
    }
}
