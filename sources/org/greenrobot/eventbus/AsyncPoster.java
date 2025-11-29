package org.greenrobot.eventbus;

class AsyncPoster implements Runnable, Poster {

    /* renamed from: a  reason: collision with root package name */
    public final PendingPostQueue f3364a = new PendingPostQueue();
    public final EventBus b;

    public AsyncPoster(EventBus eventBus) {
        this.b = eventBus;
    }

    public void a(Subscription subscription, Object obj) {
        this.f3364a.a(PendingPost.a(subscription, obj));
        this.b.d().execute(this);
    }

    public void run() {
        PendingPost b2 = this.f3364a.b();
        if (b2 != null) {
            this.b.g(b2);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
