package com.honey.account.z8;

import com.upuphone.xr.sapp.vm.DeviceControlModel;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceControlModel f7718a;
    public final /* synthetic */ String b;

    public /* synthetic */ c(DeviceControlModel deviceControlModel, String str) {
        this.f7718a = deviceControlModel;
        this.b = str;
    }

    public final void run() {
        DeviceControlModel.G(this.f7718a, this.b);
    }
}
