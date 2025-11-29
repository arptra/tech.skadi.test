package com.xjsd.ai.assistant.nlu.util;

import com.honey.account.ga.a;
import java.util.Optional;

public class StringUtil {
    public static String b(String str, String str2) {
        return (String) Optional.ofNullable(str).filter(new a()).orElse(str2);
    }

    public static /* synthetic */ boolean c(String str) {
        return !str.isEmpty() && !str.trim().isEmpty();
    }
}
