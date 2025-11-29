package com.honey.account.y;

import androidx.navigation.NavType;

public abstract /* synthetic */ class b {
    public static /* synthetic */ NavType a(NavType.Companion companion, String str, String str2) {
        if (str == null || !str.startsWith("java")) {
            return companion.a(str, str2);
        }
        try {
            return companion.a("j$" + str.substring(4), str2);
        } catch (RuntimeException e) {
            if (e.getCause() instanceof ClassNotFoundException) {
                return companion.a(str, str2);
            }
            throw e;
        }
    }
}
