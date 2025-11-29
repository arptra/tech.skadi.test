package com.honey.account.y5;

import com.upuphone.runasone.channel.IChannel;
import com.upuphone.runasone.channel.virtual.VirtualDeviceNotify;
import java.util.function.BiConsumer;

public final /* synthetic */ class b implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f5328a;
    public final /* synthetic */ int b;

    public /* synthetic */ b(String str, int i) {
        this.f5328a = str;
        this.b = i;
    }

    public final void accept(Object obj, Object obj2) {
        VirtualDeviceNotify.lambda$sendBroadCast$1(this.f5328a, this.b, (String) obj, (IChannel) obj2);
    }
}
