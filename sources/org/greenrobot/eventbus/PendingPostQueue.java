package org.greenrobot.eventbus;

final class PendingPostQueue {

    /* renamed from: a  reason: collision with root package name */
    public PendingPost f3375a;
    public PendingPost b;

    public synchronized void a(PendingPost pendingPost) {
        if (pendingPost != null) {
            try {
                PendingPost pendingPost2 = this.b;
                if (pendingPost2 != null) {
                    pendingPost2.c = pendingPost;
                    this.b = pendingPost;
                } else if (this.f3375a == null) {
                    this.b = pendingPost;
                    this.f3375a = pendingPost;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new NullPointerException("null cannot be enqueued");
        }
    }

    public synchronized PendingPost b() {
        PendingPost pendingPost;
        pendingPost = this.f3375a;
        if (pendingPost != null) {
            PendingPost pendingPost2 = pendingPost.c;
            this.f3375a = pendingPost2;
            if (pendingPost2 == null) {
                this.b = null;
            }
        }
        return pendingPost;
    }

    public synchronized PendingPost c(int i) {
        try {
            if (this.f3375a == null) {
                wait((long) i);
            }
        } catch (Throwable th) {
            throw th;
        }
        return b();
    }
}
