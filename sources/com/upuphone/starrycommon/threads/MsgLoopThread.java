package com.upuphone.starrycommon.threads;

import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class MsgLoopThread extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentLinkedQueue f6491a;

    public abstract boolean a(UupMsg uupMsg);

    public abstract boolean b();

    public abstract boolean c();

    public abstract void d(int i);

    public abstract void e();

    public void run() {
        if (c()) {
            while (true) {
                if (isInterrupted()) {
                    break;
                }
                boolean z = true;
                do {
                    UupMsg uupMsg = (UupMsg) this.f6491a.poll();
                    if (uupMsg == null) {
                        break;
                    }
                    Runnable runnable = uupMsg.f;
                    if (runnable != null) {
                        runnable.run();
                    } else {
                        z = a(uupMsg);
                    }
                    uupMsg.a();
                } while (z);
                if (z) {
                    if (!b()) {
                        d(8);
                        break;
                    }
                } else {
                    d(4);
                    break;
                }
            }
        } else {
            d(1);
        }
        if (isInterrupted()) {
            d(2);
        }
        e();
    }
}
