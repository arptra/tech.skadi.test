package com.honey.account.j7;

import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.IMessageCallback;
import com.upuphone.starrynet.strategy.channel.IStarryNetChannel;
import com.upuphone.starrynet.strategy.protocol.starrynet.PadStarryNetProtocol;

public final /* synthetic */ class b implements IMessageCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IStarryNetChannel f4883a;
    public final /* synthetic */ StConnectDevice b;

    public /* synthetic */ b(IStarryNetChannel iStarryNetChannel, StConnectDevice stConnectDevice) {
        this.f4883a = iStarryNetChannel;
        this.b = stConnectDevice;
    }

    public final void onResult(int i) {
        PadStarryNetProtocol.lambda$sendClearBondData$0(this.f4883a, this.b, i);
    }
}
