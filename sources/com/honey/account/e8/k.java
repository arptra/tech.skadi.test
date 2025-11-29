package com.honey.account.e8;

import com.upuphone.xr.sapp.contract.ProtocolActivity;
import com.upuphone.xr.sapp.contract.ProtocolActivity$networkCallback$1;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProtocolActivity f4370a;

    public /* synthetic */ k(ProtocolActivity protocolActivity) {
        this.f4370a = protocolActivity;
    }

    public final void run() {
        ProtocolActivity$networkCallback$1.b(this.f4370a);
    }
}
