package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.SubscriberMethod;

public class SimpleSubscriberInfo extends AbstractSubscriberInfo {
    public final SubscriberMethodInfo[] c;

    public synchronized SubscriberMethod[] a() {
        SubscriberMethod[] subscriberMethodArr;
        int length = this.c.length;
        subscriberMethodArr = new SubscriberMethod[length];
        for (int i = 0; i < length; i++) {
            SubscriberMethodInfo subscriberMethodInfo = this.c[i];
            subscriberMethodArr[i] = d(subscriberMethodInfo.f3384a, subscriberMethodInfo.c, subscriberMethodInfo.b, subscriberMethodInfo.d, subscriberMethodInfo.e);
        }
        return subscriberMethodArr;
    }
}
