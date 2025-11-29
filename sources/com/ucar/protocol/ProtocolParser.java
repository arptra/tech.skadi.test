package com.ucar.protocol;

public class ProtocolParser {
    public static int a(int i) {
        return c(i)[3];
    }

    public static int b(int i) {
        return c(i)[2];
    }

    public static byte[] c(int i) {
        return new byte[]{(byte) ((i >>> 24) & 255), (byte) ((i >>> 16) & 255), (byte) ((i >>> 8) & 255), (byte) (i & 255)};
    }
}
