package org.greenrobot.eventbus;

import java.lang.reflect.Method;

public class SubscriberMethod {

    /* renamed from: a  reason: collision with root package name */
    public final Method f3377a;
    public final ThreadMode b;
    public final Class c;
    public final int d;
    public final boolean e;
    public String f;

    public SubscriberMethod(Method method, Class cls, ThreadMode threadMode, int i, boolean z) {
        this.f3377a = method;
        this.b = threadMode;
        this.c = cls;
        this.d = i;
        this.e = z;
    }

    public final synchronized void a() {
        if (this.f == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f3377a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f3377a.getName());
            sb.append('(');
            sb.append(this.c.getName());
            this.f = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SubscriberMethod)) {
            return false;
        }
        a();
        SubscriberMethod subscriberMethod = (SubscriberMethod) obj;
        subscriberMethod.a();
        return this.f.equals(subscriberMethod.f);
    }

    public int hashCode() {
        return this.f3377a.hashCode();
    }
}
