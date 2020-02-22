package com.example.Spring_Boot_App_1;

import java.util.HashMap;
import java.util.ServiceConfigurationError;

public class SearchService {
    private HashMap<String,String > dataStore;
    public SearchService(){
        dataStore = new HashMap<String,String>();
        dataStore.put("Sachin","A Great Batsman");
        dataStore.put("Ds-Algo","A must have skill");
    }

    public String search(String word){
        return dataStore.get(word);
    }
}
