package com.upuphone.xr.interconnect.business.messenger;

import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.main.dispatcher.MessageDispatcher;
import java.util.function.Consumer;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f6569a;
    public final /* synthetic */ StarryNetMessage b;

    public /* synthetic */ b(Ref.BooleanRef booleanRef, StarryNetMessage starryNetMessage) {
        this.f6569a = booleanRef;
        this.b = starryNetMessage;
    }

    public final void accept(Object obj) {
        MainMessageDispatcher$dispatch$1.invokeSuspend$lambda$0(this.f6569a, this.b, (MessageDispatcher) obj);
    }
}
