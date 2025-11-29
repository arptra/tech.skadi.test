package com.upuphone.starrycommon.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import kotlin.jvm.internal.LongCompanionObject;

public class UpCounter extends HandlerThread {

    /* renamed from: a  reason: collision with root package name */
    public String f6501a;
    public String b;
    public long c;
    public long d;
    public long e;
    public final long f;
    public long g;
    public long h;
    public int i;
    public int j;

    public final void c() {
        int i2 = this.j;
        if (i2 == 0) {
            StarryCastLog.d("Statistics", this.f6501a + " no frame in this seconds");
            return;
        }
        long j2 = this.g / ((long) i2);
        this.e = j2;
        this.h += j2;
        this.i++;
        this.g = 0;
        StarryCastLog.d("Statistics", "TAG-" + this.f6501a + " " + this.b + " ==min:" + this.c + " ,max:" + this.d + " ,avg:" + this.e + " ,total avg:" + (this.h / ((long) this.i)) + ", frameCount:" + this.j);
        this.d = Long.MIN_VALUE;
        this.c = LongCompanionObject.MAX_VALUE;
        this.j = 0;
    }

    public void onLooperPrepared() {
        new Handler(getLooper()) {
            public void handleMessage(Message message) {
                UpCounter.this.c();
                sendEmptyMessageDelayed(0, UpCounter.this.f);
            }
        }.sendEmptyMessageDelayed(0, this.f);
    }
}
