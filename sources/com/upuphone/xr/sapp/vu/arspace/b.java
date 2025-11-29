package com.upuphone.xr.sapp.vu.arspace;

import android.os.IBinder;
import com.upuphone.xr.sapp.vu.arspace.ArSpaceMockService;

public final /* synthetic */ class b implements IBinder.DeathRecipient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArSpaceMockService.ArSpaceBridgerImpl f8058a;
    public final /* synthetic */ IOnBrightnessChangeListener b;

    public /* synthetic */ b(ArSpaceMockService.ArSpaceBridgerImpl arSpaceBridgerImpl, IOnBrightnessChangeListener iOnBrightnessChangeListener) {
        this.f8058a = arSpaceBridgerImpl;
        this.b = iOnBrightnessChangeListener;
    }

    public final void binderDied() {
        this.f8058a.lambda$addOnBrightnessChangeListener$1(this.b);
    }
}
