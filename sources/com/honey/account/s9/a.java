package com.honey.account.s9;

import com.upuphone.xr.interconnect.OperatorManagerCreateCallback;
import com.upuphone.xr.interconnect.api.OperatorManager;
import com.xjmz.myvu.flutter.pigeon.impl.Ring2MessageApiHandler;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a implements OperatorManagerCreateCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f7612a;
    public final /* synthetic */ Ring2MessageApiHandler b;
    public final /* synthetic */ Function1 c;

    public /* synthetic */ a(String str, Ring2MessageApiHandler ring2MessageApiHandler, Function1 function1) {
        this.f7612a = str;
        this.b = ring2MessageApiHandler;
        this.c = function1;
    }

    public final void onOperatorManagerCreated(OperatorManager operatorManager) {
        Ring2MessageApiHandler.n(this.f7612a, this.b, this.c, operatorManager);
    }
}
