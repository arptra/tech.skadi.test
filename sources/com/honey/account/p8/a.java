package com.honey.account.p8;

import com.upuphone.xr.interconnect.OperatorManagerCreateCallback;
import com.upuphone.xr.interconnect.api.OperatorManager;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;

public final /* synthetic */ class a implements OperatorManagerCreateCallback {
    public final void onOperatorManagerCreated(OperatorManager operatorManager) {
        StarryMessageHelper.b(operatorManager);
    }
}
