package com.meizu.common.util;

import android.annotation.SuppressLint;
import android.text.util.Linkify;
import android.widget.TextView;
import androidx.annotation.NonNull;

public class FlymeLinkify {
    public static final int SEM_WEB_URLS_CJK = 4096;

    @SuppressLint({"WrongConstant"})
    public static boolean optimizeWebLink(@NonNull TextView textView, int i) {
        if ((i & 1) != 0) {
            i = (i & -2) | 4096;
        }
        return Linkify.addLinks(textView, i);
    }
}
