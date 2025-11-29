package com.xjmz.arabic;

public class NativeLib {
    static {
        System.loadLibrary("arabic");
    }

    public static native byte[] transform(byte[] bArr);
}
