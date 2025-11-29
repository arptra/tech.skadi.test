package com.geetest.sdk;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class am {
    public static String a(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(j));
    }
}
