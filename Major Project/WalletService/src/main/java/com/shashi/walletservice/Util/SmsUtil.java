package com.shashi.walletservice.Util;

import java.net.URISyntaxException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

public class SmsUtil {
    void sendSms()throws URISyntaxException, UnirestException {
        System.out.println("I am fine");
        HttpResponse response = Unirest.get("https://www.fast2sms.com/dev/bulk?authorization=64tJZ9QjIHos8cEe70agdDiM2mBFSNvAwp1LfVTbrlPWOqXKkULu20KyCJjAH9vcsTOp4V6k83SfbrgW&sender_id=FSTSMS&message=This%20is%20a%20test%20message&language=english&route=p&numbers=9205834773")
                .header("cache-control", "no-cache")
                .asString();
        System.out.println(response.getBody());
        System.out.println(response.getHeaders());

    }
}
