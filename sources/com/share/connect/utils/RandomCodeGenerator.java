package com.share.connect.utils;

import java.util.Random;

public class RandomCodeGenerator {
    public static String a(int i) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        if (i > 0) {
            for (int i2 = 0; i2 < i; i2++) {
                sb.append(random.nextInt(10));
            }
        }
        return sb.toString();
    }
}
