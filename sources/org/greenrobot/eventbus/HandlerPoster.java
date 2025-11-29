package org.greenrobot.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

public class HandlerPoster extends Handler implements Poster {

    /* renamed from: a  reason: collision with root package name */
    public final PendingPostQueue f3371a = new PendingPostQueue();
    public final int b;
    public final EventBus c;
    public boolean d;

    public HandlerPoster(EventBus eventBus, Looper looper, int i) {
        super(looper);
        this.c = eventBus;
        this.b = i;
    }

    public void a(Subscription subscription, Object obj) {
        PendingPost a2 = PendingPost.a(subscription, obj);
        synchronized (this) {
            try {
                this.f3371a.a(a2);
                if (!this.d) {
                    this.d = true;
                    if (!sendMessage(obtainMessage())) {
                        throw new EventBusException("Could not send handler message");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                PendingPost b2 = this.f3371a.b();
                if (b2 == null) {
                    synchronized (this) {
                        b2 = this.f3371a.b();
                        if (b2 == null) {
                            this.d = false;
                            return;
                        }
                    }
                }
                this.c.g(b2);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.b));
            if (sendMessage(obtainMessage())) {
                this.d = true;
                return;
            }
            throw new EventBusException("Could not send handler message");
        } catch (Throwable th) {
            this.d = false;
            throw th;
        }
    }
}
