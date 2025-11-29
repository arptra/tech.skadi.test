package com.upuphone.xr.sapp.vu.arspace;

import android.os.IBinder;
import com.upuphone.xr.sapp.vu.arspace.ArSpaceMockService;
import java.util.function.BiConsumer;

public final /* synthetic */ class a implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f8057a;

    public /* synthetic */ a(int i) {
        this.f8057a = i;
    }

    public final void accept(Object obj, Object obj2) {
        ArSpaceMockService.ArSpaceBridgerImpl.lambda$setDofMode$2(this.f8057a, (IOnDofModeChangeListener) obj, (IBinder.DeathRecipient) obj2);
    }
}
