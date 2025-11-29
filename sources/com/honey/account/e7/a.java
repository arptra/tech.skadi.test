package com.honey.account.e7;

import com.upuphone.starrynet.strategy.connector.manager.CarStarryNetConnector;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CarStarryNetConnector f4359a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public /* synthetic */ a(CarStarryNetConnector carStarryNetConnector, int i, int i2) {
        this.f4359a = carStarryNetConnector;
        this.b = i;
        this.c = i2;
    }

    public final void run() {
        this.f4359a.lambda$connectP2pUntilP2pEnable$0(this.b, this.c);
    }
}
