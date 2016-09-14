package com.gianghoang.service;


import com.gianghoang.service.servicescaller.NetioI;

import java.util.Random;

/**
 * Created by MinhTu on 8/16/2016.
 */

public class NetioService implements NetioI {
    private static final String CHAR_LIST =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    @Override
    public String getString(int length) {
            generateRamdomWords(length);
        return  generateRamdomWords(length);
    }
    private String generateRamdomWords(int length) {
        StringBuffer randStr = new StringBuffer();
        for(int i=0; i < length; i++){
            int number = getRandomNumber();
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }
    private int getRandomNumber() {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }
//
//    public String getStringByKb() {
//
//    }
}
