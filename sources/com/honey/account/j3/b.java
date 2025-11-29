package com.honey.account.j3;

import com.ucar.protocol.UCarMessage;
import com.ucar.vehiclesdk.control.ControlManager;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ControlManager f4864a;
    public final /* synthetic */ UCarMessage b;

    public /* synthetic */ b(ControlManager controlManager, UCarMessage uCarMessage) {
        this.f4864a = controlManager;
        this.b = uCarMessage;
    }

    public final void run() {
        this.f4864a.I(this.b);
    }
}
