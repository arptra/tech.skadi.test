package com.honey.account.s7;

import com.upuphone.xr.interconnect.api.StarryNetFileTransferImpl;
import com.upuphone.xr.interconnect.main.StarryNetAbilityManager;

public final /* synthetic */ class m implements StarryNetAbilityManager.OnStarryAbilityStateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StarryNetFileTransferImpl f5144a;

    public /* synthetic */ m(StarryNetFileTransferImpl starryNetFileTransferImpl) {
        this.f5144a = starryNetFileTransferImpl;
    }

    public final void onStateChanged(boolean z) {
        this.f5144a.lambda$new$0(z);
    }
}
