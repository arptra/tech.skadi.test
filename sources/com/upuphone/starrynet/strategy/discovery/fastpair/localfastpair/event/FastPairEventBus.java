package com.upuphone.starrynet.strategy.discovery.fastpair.localfastpair.event;

import com.honey.account.f7.a;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.event.EventReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FastPairEventBus {
    private static final String TAG = "FastPairEventBus";
    private Map<Class<?>, ArrayList<EventReceiver>> mReceivers = new HashMap();

    public static class Holder {
        static final FastPairEventBus INSTANCE = new FastPairEventBus();

        private Holder() {
        }
    }

    public static FastPairEventBus get() {
        return Holder.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ArrayList lambda$register$0(Class cls) {
        return new ArrayList();
    }

    public void post(Object obj) {
        if (obj != null) {
            ArrayList arrayList = this.mReceivers.get(obj.getClass());
            if (arrayList == null || arrayList.isEmpty()) {
                StLog.e(TAG, "post event(%s),but no event receiver!", obj.getClass().getSimpleName());
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                EventReceiver eventReceiver = (EventReceiver) it.next();
                StLog.v(TAG, "post event :" + eventReceiver.getClass().getSimpleName());
                eventReceiver.onEvent(obj);
            }
        }
    }

    public void register(Class<?> cls, EventReceiver eventReceiver) {
        if (cls == null || eventReceiver == null) {
            StLog.e(TAG, "register, cls is null or receiver is null,ignore it");
        } else {
            this.mReceivers.computeIfAbsent(cls, new a()).add(eventReceiver);
        }
    }

    public void unregister(Class<?> cls, EventReceiver eventReceiver) {
        if (cls == null || eventReceiver == null) {
            StLog.e(TAG, "unregister, cls is null or receiver is null,ignore it");
        }
        ArrayList arrayList = this.mReceivers.get(cls);
        if (arrayList != null && !arrayList.isEmpty()) {
            arrayList.remove(eventReceiver);
        }
    }
}
