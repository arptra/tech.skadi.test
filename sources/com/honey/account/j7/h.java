package com.honey.account.j7;

import com.upuphone.starrynet.core.ble.client.response.BleNotifyResponse;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.IStarryNetChannel;
import com.upuphone.starrynet.strategy.protocol.starrynet.PhoneStarryNetProtocol;
import java.util.UUID;

public final /* synthetic */ class h implements BleNotifyResponse {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PhoneStarryNetProtocol f4887a;
    public final /* synthetic */ UUID b;
    public final /* synthetic */ StConnectDevice c;
    public final /* synthetic */ IStarryNetChannel d;

    public /* synthetic */ h(PhoneStarryNetProtocol phoneStarryNetProtocol, UUID uuid, StConnectDevice stConnectDevice, IStarryNetChannel iStarryNetChannel) {
        this.f4887a = phoneStarryNetProtocol;
        this.b = uuid;
        this.c = stConnectDevice;
        this.d = iStarryNetChannel;
    }

    public final void onResponse(int i, Object obj) {
        this.f4887a.lambda$openNotify$1(this.b, this.c, this.d, i, (Void) obj);
    }
}
