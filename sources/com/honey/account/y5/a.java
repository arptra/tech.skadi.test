package com.honey.account.y5;

import com.upuphone.runasone.channel.IChannel;
import com.upuphone.runasone.channel.virtual.VirtualDeviceNotify;
import com.upuphone.runasone.device.StarryDevice;
import java.util.function.BiConsumer;

public final /* synthetic */ class a implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f5327a;
    public final /* synthetic */ StarryDevice b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public /* synthetic */ a(String str, StarryDevice starryDevice, int i, int i2) {
        this.f5327a = str;
        this.b = starryDevice;
        this.c = i;
        this.d = i2;
    }

    public final void accept(Object obj, Object obj2) {
        VirtualDeviceNotify.lambda$sendBroadCast$0(this.f5327a, this.b, this.c, this.d, (String) obj, (IChannel) obj2);
    }
}
