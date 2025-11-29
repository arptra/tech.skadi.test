package com.honey.account.t6;

import com.upuphone.starrynet.core.ble.client.BleWorker;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BleWorker f5152a;
    public final /* synthetic */ int b;

    public /* synthetic */ c(BleWorker bleWorker, int i) {
        this.f5152a = bleWorker;
        this.b = i;
    }

    public final void run() {
        this.f5152a.lambda$releaseAfterDisconnected$0(this.b);
    }
}
