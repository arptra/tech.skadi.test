package com.honey.account.ha;

import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.xjsd.ai.assistant.connect.OnReceiveRemoteMsgListener;
import com.xjsd.ai.assistant.phone.Commander;

public final /* synthetic */ class d implements OnReceiveRemoteMsgListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Commander f7334a;

    public /* synthetic */ d(Commander commander) {
        this.f7334a = commander;
    }

    public final void a(StarryNetMessage starryNetMessage) {
        this.f7334a.handleReceiveRemoteMsg(starryNetMessage);
    }
}
