package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;

final class PendingPost {
    public static final List d = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public Object f3374a;
    public Subscription b;
    public PendingPost c;

    public PendingPost(Object obj, Subscription subscription) {
        this.f3374a = obj;
        this.b = subscription;
    }

    public static PendingPost a(Subscription subscription, Object obj) {
        List list = d;
        synchronized (list) {
            try {
                int size = list.size();
                if (size <= 0) {
                    return new PendingPost(obj, subscription);
                }
                PendingPost pendingPost = (PendingPost) list.remove(size - 1);
                pendingPost.f3374a = obj;
                pendingPost.b = subscription;
                pendingPost.c = null;
                return pendingPost;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public static void b(PendingPost pendingPost) {
        pendingPost.f3374a = null;
        pendingPost.b = null;
        pendingPost.c = null;
        List list = d;
        synchronized (list) {
            try {
                if (list.size() < 10000) {
                    list.add(pendingPost);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
