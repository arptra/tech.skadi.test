package com.honey.account.b7;

import androidx.core.util.Consumer;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.strategy.channel.simpleble.SimpleBleClientChannel;
import java.util.UUID;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBleClientChannel f4190a;
    public final /* synthetic */ StDevice b;
    public final /* synthetic */ UUID c;

    public /* synthetic */ b(SimpleBleClientChannel simpleBleClientChannel, StDevice stDevice, UUID uuid) {
        this.f4190a = simpleBleClientChannel;
        this.b = stDevice;
        this.c = uuid;
    }

    public final void accept(Object obj) {
        this.f4190a.lambda$checkNotify$0(this.b, this.c, (Boolean) obj);
    }
}
