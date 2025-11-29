package com.upuphone.xr.interconnect.checknavi;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/interconnect/checknavi/CheckNaviSupportManager;", "", "()V", "callback", "Lcom/upuphone/xr/interconnect/checknavi/NaviNotSupportCallback;", "getCallBack", "registerCallback", "", "naviNotSupportCallback", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CheckNaviSupportManager {
    @NotNull
    public static final CheckNaviSupportManager INSTANCE = new CheckNaviSupportManager();
    @Nullable
    private static NaviNotSupportCallback callback;

    private CheckNaviSupportManager() {
    }

    @Nullable
    public final NaviNotSupportCallback getCallBack() {
        return callback;
    }

    public final void registerCallback(@NotNull NaviNotSupportCallback naviNotSupportCallback) {
        Intrinsics.checkNotNullParameter(naviNotSupportCallback, "naviNotSupportCallback");
        callback = naviNotSupportCallback;
    }
}
