package com.honey.account.p5;

import com.upuphone.runasone.channel.ChannelImpl;
import com.upuphone.runasone.channel.IChannel;
import com.upuphone.runasone.channel.linker.EnumLinker;
import java.util.function.BiConsumer;

public final /* synthetic */ class b implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EnumLinker f5086a;

    public /* synthetic */ b(EnumLinker enumLinker) {
        this.f5086a = enumLinker;
    }

    public final void accept(Object obj, Object obj2) {
        ChannelImpl.lambda$notifyDeviceDown$0(this.f5086a, (String) obj, (IChannel) obj2);
    }
}
