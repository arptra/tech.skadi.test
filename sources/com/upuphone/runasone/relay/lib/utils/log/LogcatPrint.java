package com.upuphone.runasone.relay.lib.utils.log;

import android.util.Log;

public class LogcatPrint implements ILogPrinter {
    public void println(int i, String str, String str2) {
        Log.println(i, str, str2);
    }
}
