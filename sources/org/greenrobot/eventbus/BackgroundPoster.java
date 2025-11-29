package org.greenrobot.eventbus;

import java.util.logging.Level;

final class BackgroundPoster implements Runnable, Poster {

    /* renamed from: a  reason: collision with root package name */
    public final PendingPostQueue f3365a = new PendingPostQueue();
    public final EventBus b;
    public volatile boolean c;

    public BackgroundPoster(EventBus eventBus) {
        this.b = eventBus;
    }

    public void a(Subscription subscription, Object obj) {
        PendingPost a2 = PendingPost.a(subscription, obj);
        synchronized (this) {
            try {
                this.f3365a.a(a2);
                if (!this.c) {
                    this.c = true;
                    this.b.d().execute(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void run() {
        while (true) {
            try {
                PendingPost c2 = this.f3365a.c(1000);
                if (c2 == null) {
                    synchronized (this) {
                        c2 = this.f3365a.b();
                        if (c2 == null) {
                            this.c = false;
                            this.c = false;
                            return;
                        }
                    }
                }
                this.b.g(c2);
            } catch (InterruptedException e) {
                try {
                    Logger e2 = this.b.e();
                    Level level = Level.WARNING;
                    e2.b(level, Thread.currentThread().getName() + " was interruppted", e);
                    this.c = false;
                    return;
                } catch (Throwable th) {
                    this.c = false;
                    throw th;
                }
            }
        }
    }
}
