package com.upuphone.starrynet.common.utils;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

public class RandomPwdHelper {
    private static final String LOW_STR = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUM_STR = "0123456789";
    private static final String SPECIAL_STR = "~!@#$%^&*()_+/-=[]{};:'<>?.";

    private RandomPwdHelper() {
    }

    private static char getLowChar() {
        return getRandomChar(LOW_STR);
    }

    private static char getNumChar() {
        return getRandomChar(NUM_STR);
    }

    private static char getRandomChar(String str) {
        return str.charAt(new SecureRandom().nextInt(str.length()));
    }

    public static String getRandomPwd(int i) {
        if (i > 20 || i < 8) {
            return "";
        }
        ArrayList<Character> arrayList = new ArrayList<>(i);
        arrayList.add(Character.valueOf(getLowChar()));
        arrayList.add(Character.valueOf(getUpperChar()));
        arrayList.add(Character.valueOf(getNumChar()));
        arrayList.add(Character.valueOf(getSpecialChar()));
        for (int i2 = 4; i2 < i; i2++) {
            arrayList.add(Character.valueOf(getRandomChar(new SecureRandom().nextInt(4))));
        }
        Collections.shuffle(arrayList);
        StringBuilder sb = new StringBuilder(arrayList.size());
        for (Character append : arrayList) {
            sb.append(append);
        }
        return sb.toString();
    }

    private static char getSpecialChar() {
        return getRandomChar(SPECIAL_STR);
    }

    private static char getUpperChar() {
        return Character.toUpperCase(getLowChar());
    }

    private static char getRandomChar(int i) {
        if (i == 0) {
            return getLowChar();
        }
        if (i == 1) {
            return getUpperChar();
        }
        if (i != 2) {
            return getSpecialChar();
        }
        return getNumChar();
    }
}
