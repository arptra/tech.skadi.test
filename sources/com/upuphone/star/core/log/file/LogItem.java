package com.upuphone.star.core.log.file;

import android.os.Process;

public class LogItem {

    /* renamed from: a  reason: collision with root package name */
    public long f6449a;
    public int b;
    public String c;
    public String d;
    public int e = Process.myPid();
    public String f = Thread.currentThread().toString();

    public LogItem(long j, int i, String str, String str2) {
        this.f6449a = j;
        this.b = i;
        this.c = str;
        this.d = str2;
    }
}
