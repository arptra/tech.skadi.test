package com.honey.account.j7;

import com.upuphone.starrynet.core.ble.client.response.BleNotifyResponse;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.IStarryNetChannel;
import com.upuphone.starrynet.strategy.protocol.starrynet.PadStarryNetProtocol;
import java.util.UUID;

public final /* synthetic */ class c implements BleNotifyResponse {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PadStarryNetProtocol f4884a;
    public final /* synthetic */ UUID b;
    public final /* synthetic */ StConnectDevice c;
    public final /* synthetic */ IStarryNetChannel d;

    public /* synthetic */ c(PadStarryNetProtocol padStarryNetProtocol, UUID uuid, StConnectDevice stConnectDevice, IStarryNetChannel iStarryNetChannel) {
        this.f4884a = padStarryNetProtocol;
        this.b = uuid;
        this.c = stConnectDevice;
        this.d = iStarryNetChannel;
    }

    public final void onResponse(int i, Object obj) {
        this.f4884a.lambda$openNotify$1(this.b, this.c, this.d, i, (Void) obj);
    }
}
