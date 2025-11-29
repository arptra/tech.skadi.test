package com.honey.account.v7;

import com.upuphone.starrynetsdk.ability.relay.BypassListener;
import com.upuphone.xr.interconnect.business.messenger.IpcMessageDispatcher$transporter$1;

public final /* synthetic */ class a implements BypassListener {
    public final void onMessage(String str, String str2, String str3, byte[] bArr, int i) {
        IpcMessageDispatcher$transporter$1.registerRingMessageReceiver$lambda$0(str, str2, str3, bArr, i);
    }
}
