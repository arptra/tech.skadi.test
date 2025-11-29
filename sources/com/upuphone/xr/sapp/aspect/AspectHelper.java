package com.upuphone.xr.sapp.aspect;

import androidx.annotation.Keep;
import androidx.lifecycle.LifecycleOwner;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/upuphone/xr/sapp/aspect/AspectHelper;", "", "()V", "TAG", "", "connectListener", "com/upuphone/xr/sapp/aspect/AspectHelper$connectListener$1", "Lcom/upuphone/xr/sapp/aspect/AspectHelper$connectListener$1;", "deviceConnect", "", "getDeviceConnect", "()Z", "setDeviceConnect", "(Z)V", "bindLifecycle", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "create", "release", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class AspectHelper {
    @NotNull
    public static final AspectHelper INSTANCE = new AspectHelper();
    @NotNull
    public static final String TAG = "AspectHelper";
    @NotNull
    private static final AspectHelper$connectListener$1 connectListener = new AspectHelper$connectListener$1();
    private static boolean deviceConnect;

    private AspectHelper() {
    }

    /* access modifiers changed from: private */
    public final void create() {
        ULog.f6446a.a(TAG, "registerDeviceConnectionListener");
        InterconnectManager.getInstance().getStarryNetDeviceManager().registerDeviceConnectionListener(connectListener);
    }

    /* access modifiers changed from: private */
    public final void release() {
        ULog.f6446a.a(TAG, "unregisterDeviceConnectionListener");
        InterconnectManager.getInstance().getStarryNetDeviceManager().unregisterDeviceConnectionListener(connectListener);
    }

    public final void bindLifecycle(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        lifecycleOwner.getLifecycle().a(new AspectHelper$bindLifecycle$1());
    }

    public final boolean getDeviceConnect() {
        return deviceConnect;
    }

    public final void setDeviceConnect(boolean z) {
        deviceConnect = z;
    }
}
