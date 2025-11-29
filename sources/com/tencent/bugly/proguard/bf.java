package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public final class bf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final Handler f9564a;
    long b;
    boolean c;
    long d;
    private final String e;
    private final List<ba> f = new LinkedList();
    private final long g;

    public bf(Handler handler, String str) {
        this.f9564a = handler;
        this.e = str;
        this.b = 5000;
        this.g = 5000;
        this.c = true;
    }

    private Thread e() {
        return this.f9564a.getLooper().getThread();
    }

    public final boolean a() {
        return !this.c && SystemClock.uptimeMillis() >= this.d + this.b;
    }

    public final long b() {
        return SystemClock.uptimeMillis() - this.d;
    }

    public final List<ba> c() {
        ArrayList arrayList;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f) {
            try {
                arrayList = new ArrayList(this.f.size());
                for (int i = 0; i < this.f.size(); i++) {
                    ba baVar = this.f.get(i);
                    if (!baVar.e && currentTimeMillis - baVar.b < 200000) {
                        arrayList.add(baVar);
                        baVar.e = true;
                    }
                }
            } finally {
            }
        }
        return arrayList;
    }

    public final void d() {
        StringBuilder sb = new StringBuilder(1024);
        long nanoTime = System.nanoTime();
        try {
            StackTraceElement[] stackTrace = e().getStackTrace();
            if (stackTrace.length == 0) {
                sb.append("Thread does not have stack trace.\n");
            } else {
                for (StackTraceElement append : stackTrace) {
                    sb.append(append);
                    sb.append(StringUtils.LF);
                }
            }
        } catch (SecurityException e2) {
            sb.append("getStackTrace() encountered:\n");
            sb.append(e2.getMessage());
            sb.append(StringUtils.LF);
            al.a(e2);
        }
        long nanoTime2 = System.nanoTime();
        ba baVar = new ba(sb.toString(), System.currentTimeMillis());
        baVar.d = nanoTime2 - nanoTime;
        String name = e().getName();
        if (name == null) {
            name = "";
        }
        baVar.f9559a = name;
        synchronized (this.f) {
            while (this.f.size() >= 32) {
                try {
                    this.f.remove(0);
                } finally {
                }
            }
            this.f.add(baVar);
        }
    }

    public final void run() {
        this.c = true;
        this.b = this.g;
    }
}
