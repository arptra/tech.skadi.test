package com.honey.account.m8;

import com.upuphone.xr.sapp.keeplive.server.SuperService;
import com.upuphone.xr.sapp.keeplive.server.SuperService$registerDeviceConnectCallback$1;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperService f4950a;

    public /* synthetic */ a(SuperService superService) {
        this.f4950a = superService;
    }

    public final void run() {
        SuperService$registerDeviceConnectCallback$1.onDeviceConnected$lambda$0(this.f4950a);
    }
}
