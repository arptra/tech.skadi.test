package com.upuphone.starrynet.strategy.channel.spp;

import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.spp.SppClientChannel;
import java.util.function.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean[] f6537a;

    public /* synthetic */ b(boolean[] zArr) {
        this.f6537a = zArr;
    }

    public final void accept(Object obj) {
        SppClientChannel.AnonymousClass1.lambda$removeConnectionEventListenerIfNeed$1(this.f6537a, (StConnectDevice) obj);
    }
}
