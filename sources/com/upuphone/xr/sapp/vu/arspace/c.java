package com.upuphone.xr.sapp.vu.arspace;

import android.os.IBinder;
import com.upuphone.xr.sapp.vu.arspace.ArSpaceMockService;

public final /* synthetic */ class c implements IBinder.DeathRecipient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArSpaceMockService.ArSpaceBridgerImpl f8059a;
    public final /* synthetic */ IOnDofModeChangeListener b;

    public /* synthetic */ c(ArSpaceMockService.ArSpaceBridgerImpl arSpaceBridgerImpl, IOnDofModeChangeListener iOnDofModeChangeListener) {
        this.f8059a = arSpaceBridgerImpl;
        this.b = iOnDofModeChangeListener;
    }

    public final void binderDied() {
        this.f8059a.lambda$addOnDofModeChangeListener$3(this.b);
    }
}
