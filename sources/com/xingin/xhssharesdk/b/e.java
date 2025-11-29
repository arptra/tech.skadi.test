package com.xingin.xhssharesdk.b;

public final class e extends d {
    public static volatile e g;

    public static e h() {
        if (g == null) {
            synchronized (e.class) {
                try {
                    if (g == null) {
                        g = new e();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return g;
    }
}
