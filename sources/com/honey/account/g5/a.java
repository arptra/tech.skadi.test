package com.honey.account.g5;

import com.upuphone.ar.translation.phone.helper.EarlyInterConnectHelper;
import com.upuphone.xr.interconnect.OperatorManagerCreateCallback;
import com.upuphone.xr.interconnect.api.OperatorManager;

public final /* synthetic */ class a implements OperatorManagerCreateCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EarlyInterConnectHelper f4463a;

    public /* synthetic */ a(EarlyInterConnectHelper earlyInterConnectHelper) {
        this.f4463a = earlyInterConnectHelper;
    }

    public final void onOperatorManagerCreated(OperatorManager operatorManager) {
        EarlyInterConnectHelper._init_$lambda$0(this.f4463a, operatorManager);
    }
}
