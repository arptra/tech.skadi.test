package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.EventBusException;
import org.greenrobot.eventbus.SubscriberMethod;
import org.greenrobot.eventbus.ThreadMode;

public abstract class AbstractSubscriberInfo implements SubscriberInfo {

    /* renamed from: a  reason: collision with root package name */
    public final Class f3383a;
    public final Class b;

    public Class b() {
        return this.f3383a;
    }

    public SubscriberInfo c() {
        Class cls = this.b;
        if (cls == null) {
            return null;
        }
        try {
            return (SubscriberInfo) cls.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        }
    }

    public SubscriberMethod d(String str, Class cls, ThreadMode threadMode, int i, boolean z) {
        try {
            return new SubscriberMethod(this.f3383a.getDeclaredMethod(str, new Class[]{cls}), cls, threadMode, i, z);
        } catch (NoSuchMethodException e) {
            throw new EventBusException("Could not find subscriber method in " + this.f3383a + ". Maybe a missing ProGuard rule?", e);
        }
    }
}
