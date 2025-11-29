package com.rousetime.android_startup.extensions;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u001f\u0010\u0003\u001a\u00020\u0002*\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0013\u0010\u0005\u001a\u00020\u0002*\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Ljava/lang/Class;", "Lcom/rousetime/android_startup/Startup;", "", "a", "(Ljava/lang/Class;)Ljava/lang/String;", "b", "(Ljava/lang/String;)Ljava/lang/String;", "android-startup_release"}, k = 2, mv = {1, 4, 0})
public final class StartupExtensionsKt {
    public static final String a(Class cls) {
        return "com.rousetime.android_startup.defaultKey:" + cls.getName();
    }

    public static final String b(String str) {
        return "com.rousetime.android_startup.defaultKey:" + str;
    }
}
