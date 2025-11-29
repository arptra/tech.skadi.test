package com.xjsd.nbs.common.util;

import java.io.PrintStream;

public class LogUtil {
    public static void a(String str, String str2) {
        PrintStream printStream = System.out;
        printStream.println(str + " [error] :" + str2);
    }
}
