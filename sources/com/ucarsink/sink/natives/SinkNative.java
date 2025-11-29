package com.ucarsink.sink.natives;

import java.util.HashMap;

public class SinkNative {

    /* renamed from: a  reason: collision with root package name */
    public static WfdListener f5484a;

    public interface WfdListener {
    }

    static {
        System.loadLibrary("ovmsink");
    }

    public static void a(WfdListener wfdListener) {
        f5484a = wfdListener;
    }

    public static void b() {
        f5484a = null;
    }

    public static native boolean onUibcEvent(String str, byte[] bArr);

    public static native boolean setParameter(String str, HashMap<String, String> hashMap);

    public static native boolean start(String str, int i, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3);

    public static native boolean stop(String str);
}
