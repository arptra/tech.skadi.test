package org.greenrobot.eventbus;

final class Subscription {

    /* renamed from: a  reason: collision with root package name */
    public final Object f3380a;
    public final SubscriberMethod b;
    public volatile boolean c = true;

    public Subscription(Object obj, SubscriberMethod subscriberMethod) {
        this.f3380a = obj;
        this.b = subscriberMethod;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Subscription)) {
            return false;
        }
        Subscription subscription = (Subscription) obj;
        return this.f3380a == subscription.f3380a && this.b.equals(subscription.b);
    }

    public int hashCode() {
        return this.f3380a.hashCode() + this.b.f.hashCode();
    }
}
