package com.airbnb.epoxy;

import android.util.Log;

class DebugTimer implements Timer {

    /* renamed from: a  reason: collision with root package name */
    public final String f2277a;
    public long b;
    public String c;

    public DebugTimer(String str) {
        this.f2277a = str;
        b();
    }

    public void a(String str) {
        if (this.b == -1) {
            this.b = System.nanoTime();
            this.c = str;
            return;
        }
        throw new IllegalStateException("Timer was already started");
    }

    public final void b() {
        this.b = -1;
        this.c = null;
    }

    public void stop() {
        if (this.b != -1) {
            String str = this.f2277a;
            Log.d(str, String.format(this.c + ": %.3fms", new Object[]{Float.valueOf(((float) (System.nanoTime() - this.b)) / 1000000.0f)}));
            b();
            return;
        }
        throw new IllegalStateException("Timer was not started");
    }
}
