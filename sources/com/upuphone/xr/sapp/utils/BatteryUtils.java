package com.upuphone.xr.sapp.utils;

import android.os.BatteryManager;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.entity.BatteryInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/sapp/utils/BatteryUtils;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/entity/BatteryInfo;", "b", "()Lcom/upuphone/xr/sapp/entity/BatteryInfo;", "Landroid/os/BatteryManager;", "a", "Landroid/os/BatteryManager;", "mBatteryManager", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class BatteryUtils {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);
    public static final Lazy c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, BatteryUtils$Companion$instance$2.INSTANCE);

    /* renamed from: a  reason: collision with root package name */
    public BatteryManager f7848a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/upuphone/xr/sapp/utils/BatteryUtils$Companion;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/utils/BatteryUtils;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/upuphone/xr/sapp/utils/BatteryUtils;", "instance", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BatteryUtils a() {
            return (BatteryUtils) BatteryUtils.c.getValue();
        }

        public Companion() {
        }
    }

    public BatteryUtils() {
        Object systemService = MainApplication.k.f().getSystemService("batterymanager");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.BatteryManager");
        this.f7848a = (BatteryManager) systemService;
    }

    public final BatteryInfo b() {
        BatteryManager batteryManager = this.f7848a;
        if (batteryManager == null) {
            return null;
        }
        return new BatteryInfo(batteryManager.getIntProperty(4), batteryManager.getIntProperty(6) == 2);
    }
}
