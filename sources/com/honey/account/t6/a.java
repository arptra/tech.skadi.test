package com.honey.account.t6;

import com.upuphone.starrynet.core.ble.client.BleConnectMaster;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BleConnectMaster f5150a;

    public /* synthetic */ a(BleConnectMaster bleConnectMaster) {
        this.f5150a = bleConnectMaster;
    }

    public final void run() {
        this.f5150a.lambda$prepareCheckAlive$1();
    }
}
