package com.honey.account.r4;

import com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager;
import com.upuphone.xr.interconnect.OperatorManagerCreateCallback;
import com.upuphone.xr.interconnect.api.OperatorManager;

public final /* synthetic */ class a implements OperatorManagerCreateCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TiciStarryMsgManager f5116a;

    public /* synthetic */ a(TiciStarryMsgManager ticiStarryMsgManager) {
        this.f5116a = ticiStarryMsgManager;
    }

    public final void onOperatorManagerCreated(OperatorManager operatorManager) {
        TiciStarryMsgManager._init_$lambda$0(this.f5116a, operatorManager);
    }
}
