package com.upuphone.xr.sapp.vu.arspace;

import android.os.IBinder;
import com.upuphone.xr.sapp.vu.arspace.ArSpaceMockService;
import java.util.function.BiConsumer;

public final /* synthetic */ class d implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f8060a;

    public /* synthetic */ d(int i) {
        this.f8060a = i;
    }

    public final void accept(Object obj, Object obj2) {
        ArSpaceMockService.ArSpaceBridgerImpl.lambda$setBrightness$0(this.f8060a, (IOnBrightnessChangeListener) obj, (IBinder.DeathRecipient) obj2);
    }
}
