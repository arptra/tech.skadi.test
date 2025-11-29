package com.honey.account.r4;

import com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager;
import com.upuphone.xr.interconnect.OperatorManagerCreateCallback;
import com.upuphone.xr.interconnect.api.OperatorManager;

public final /* synthetic */ class b implements OperatorManagerCreateCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TiciStarryMsgManager f5117a;

    public /* synthetic */ b(TiciStarryMsgManager ticiStarryMsgManager) {
        this.f5117a = ticiStarryMsgManager;
    }

    public final void onOperatorManagerCreated(OperatorManager operatorManager) {
        TiciStarryMsgManager._init_$lambda$1(this.f5117a, operatorManager);
    }
}
