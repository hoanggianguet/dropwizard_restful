package com.gianghoang.service;

import com.gianghoang.service.servicescaller.IString;
import org.apache.commons.lang3.RandomStringUtils;
import org.jvnet.hk2.annotations.Service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by MinhTu on 8/15/2016.
 */
@Service
public class StringService implements IString {

    private static final String CHAR_LIST =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public String createRamdomWords(int quantity, int length) {
        for (int i = 0; i< quantity; i++){
            generateRamdomWords(length);
            System.out.println(generateRamdomWords(length));
        }
        return "ok";
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


    public String createRamdomFile() {
        for (int i = 0; i < 50; i++) {
            List<String> lines = Arrays.asList(RandomStringUtils.randomAlphanumeric(1024), "The second line");
                java.nio.file.Path file = Paths.get("disk 50k 10k/50k10k " + i + ".txt");
                try {
                Files.write(file, lines, Charset.forName("UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "ok";
    }
}
