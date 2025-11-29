package com.honey.account.t3;

import com.upuphone.ar.fastrecord.phone.starrynet.RecordConnectManager;
import com.upuphone.xr.interconnect.OperatorManagerCreateCallback;
import com.upuphone.xr.interconnect.api.OperatorManager;

public final /* synthetic */ class a implements OperatorManagerCreateCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecordConnectManager f5145a;

    public /* synthetic */ a(RecordConnectManager recordConnectManager) {
        this.f5145a = recordConnectManager;
    }

    public final void onOperatorManagerCreated(OperatorManager operatorManager) {
        RecordConnectManager.initForCallback$lambda$2(this.f5145a, operatorManager);
    }
}
