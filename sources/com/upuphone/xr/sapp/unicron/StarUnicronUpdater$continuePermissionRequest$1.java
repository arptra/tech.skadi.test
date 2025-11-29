package com.upuphone.xr.sapp.unicron;

import com.xjmz.myvu.bridge.MainActivityInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/xjmz/myvu/bridge/MainActivityInterface;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class StarUnicronUpdater$continuePermissionRequest$1 extends Lambda implements Function1<MainActivityInterface, Unit> {
    public static final StarUnicronUpdater$continuePermissionRequest$1 INSTANCE = new StarUnicronUpdater$continuePermissionRequest$1();

    public StarUnicronUpdater$continuePermissionRequest$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((MainActivityInterface) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull MainActivityInterface mainActivityInterface) {
        Intrinsics.checkNotNullParameter(mainActivityInterface, "it");
        mainActivityInterface.m(new String[]{"android.permission.ACCESS_FINE_LOCATION"});
    }
}
