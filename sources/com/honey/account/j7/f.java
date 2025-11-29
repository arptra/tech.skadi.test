package com.honey.account.j7;

import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.IMessageCallback;
import com.upuphone.starrynet.strategy.channel.IStarryNetChannel;
import com.upuphone.starrynet.strategy.protocol.starrynet.PhoneStarryNetProtocol;

public final /* synthetic */ class f implements IMessageCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IStarryNetChannel f4885a;
    public final /* synthetic */ StConnectDevice b;

    public /* synthetic */ f(IStarryNetChannel iStarryNetChannel, StConnectDevice stConnectDevice) {
        this.f4885a = iStarryNetChannel;
        this.b = stConnectDevice;
    }

    public final void onResult(int i) {
        PhoneStarryNetProtocol.lambda$sendClearBondData$0(this.f4885a, this.b, i);
    }
}
