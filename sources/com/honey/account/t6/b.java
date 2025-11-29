package com.honey.account.t6;

import com.upuphone.starrynet.core.ble.client.BleConnectMaster;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BleConnectMaster f5151a;

    public /* synthetic */ b(BleConnectMaster bleConnectMaster) {
        this.f5151a = bleConnectMaster;
    }

    public final void run() {
        this.f5151a.lambda$stopMasterLooper$0();
    }
}
