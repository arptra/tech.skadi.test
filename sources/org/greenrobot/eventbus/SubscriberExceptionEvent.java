package org.greenrobot.eventbus;

public final class SubscriberExceptionEvent {

    /* renamed from: a  reason: collision with root package name */
    public final EventBus f3376a;
    public final Throwable b;
    public final Object c;
    public final Object d;

    public SubscriberExceptionEvent(EventBus eventBus, Throwable th, Object obj, Object obj2) {
        this.f3376a = eventBus;
        this.b = th;
        this.c = obj;
        this.d = obj2;
    }
}
