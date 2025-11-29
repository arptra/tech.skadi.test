package com.here.posclient;

import android.content.Context;
import androidx.annotation.NonNull;

public class PosApplicationInfo {
    public static String getPackageName(@NonNull Context context) {
        return context.getPackageName();
    }
}
