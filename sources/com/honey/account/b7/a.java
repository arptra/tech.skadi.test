package com.honey.account.b7;

import androidx.core.util.Consumer;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.strategy.channel.simpleble.MyvuRingBleClientChannel;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyvuRingBleClientChannel f4189a;
    public final /* synthetic */ StDevice b;

    public /* synthetic */ a(MyvuRingBleClientChannel myvuRingBleClientChannel, StDevice stDevice) {
        this.f4189a = myvuRingBleClientChannel;
        this.b = stDevice;
    }

    public final void accept(Object obj) {
        this.f4189a.lambda$checkAndOpenNotify$0(this.b, (Boolean) obj);
    }
}
