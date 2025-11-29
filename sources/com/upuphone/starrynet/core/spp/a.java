package com.upuphone.starrynet.core.spp;

import java.util.UUID;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SPPConnection f6532a;
    public final /* synthetic */ UUID b;

    public /* synthetic */ a(SPPConnection sPPConnection, UUID uuid) {
        this.f6532a = sPPConnection;
        this.b = uuid;
    }

    public final void run() {
        this.f6532a.clientConnect(this.b);
    }
}
