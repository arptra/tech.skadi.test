package com.upuphone.starrynet.strategy.pair;

import com.honey.account.h7.a;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.event.EventReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class StPairEventBus {
    private static final String TAG = "StPairEventBus";
    private Map<Class<?>, ArrayList<EventReceiver>> mReceivers;

    public static class Holder {
        static final StPairEventBus INSTANCE = new StPairEventBus();

        private Holder() {
        }
    }

    public static StPairEventBus get() {
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
                StLog.d(TAG, "post event :" + eventReceiver.getClass().getSimpleName());
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

    private StPairEventBus() {
        this.mReceivers = new HashMap();
    }
}
