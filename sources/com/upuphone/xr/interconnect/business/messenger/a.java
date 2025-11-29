package com.upuphone.xr.interconnect.business.messenger;

import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import java.util.Set;
import java.util.function.BiConsumer;

public final /* synthetic */ class a implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IpcMessageDispatcher f6568a;
    public final /* synthetic */ StarryNetMessage b;

    public /* synthetic */ a(IpcMessageDispatcher ipcMessageDispatcher, StarryNetMessage starryNetMessage) {
        this.f6568a = ipcMessageDispatcher;
        this.b = starryNetMessage;
    }

    public final void accept(Object obj, Object obj2) {
        IpcMessageDispatcher$dispatch$2.invoke$lambda$1(this.f6568a, this.b, (Integer) obj, (Set) obj2);
    }
}
