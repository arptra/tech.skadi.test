package com.upuphone.xr.sapp.vu.utils;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.vu.utils.VuGlassesEventDispatcher;
import com.xjmz.glasses.usb.hid.IGlassesEventCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nVuGlassesEventDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VuGlassesEventDispatcher.kt\ncom/upuphone/xr/sapp/vu/utils/VuGlassesEventDispatcher$glassesEventCallback$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,138:1\n1855#2,2:139\n1855#2,2:141\n*S KotlinDebug\n*F\n+ 1 VuGlassesEventDispatcher.kt\ncom/upuphone/xr/sapp/vu/utils/VuGlassesEventDispatcher$glassesEventCallback$1\n*L\n31#1:139,2\n38#1:141,2\n*E\n"})
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J(\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0016¨\u0006\u0019"}, d2 = {"com/upuphone/xr/sapp/vu/utils/VuGlassesEventDispatcher$glassesEventCallback$1", "Lcom/xjmz/glasses/usb/hid/IGlassesEventCallback$Stub;", "on7911StatusChanged", "", "rate", "", "resolution", "output", "onBrightnessChanged", "brightness", "onHidChannelConnectionStatusChanged", "status", "onKeyEvent", "keyCode", "action", "onLog", "p0", "", "onUpgradeProgressChanged", "curProgress", "totalProgress", "type", "onWearingStatusChanged", "isWear", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class VuGlassesEventDispatcher$glassesEventCallback$1 extends IGlassesEventCallback.Stub {
    public void on7911StatusChanged(int i, int i2, int i3) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassesEventDispatcher", "on7911StatusChanged: " + i + ", " + i2 + ", " + i3);
    }

    public void onBrightnessChanged(int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassesEventDispatcher", "onBrightnessChanged: " + i);
        if (i < 100) {
            VuGlassesEventDispatcher.f8098a.i(i);
        }
    }

    public void onHidChannelConnectionStatusChanged(int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassesEventDispatcher", "onHidChannelConnectionStatusChanged: " + i);
    }

    public void onKeyEvent(int i, int i2) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassesEventDispatcher", "onKeyEvent: " + i + ", " + i2);
        VuGlassesEventDispatcher.f8098a.j(i, i2);
    }

    public void onLog(@Nullable String str) {
        ULog.f6446a.g("ViewGlasses", str);
    }

    public void onUpgradeProgressChanged(int i, int i2, int i3, int i4) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassesEventDispatcher", "onUpgradeProgressChanged: " + i + ", " + i2 + ", " + i3 + ", status: " + i4);
        for (VuGlassesEventDispatcher.OnUpgradeStateChangeListener a2 : VuGlassesEventDispatcher.d) {
            a2.a(i, i2, i3, i4);
        }
    }

    public void onWearingStatusChanged(boolean z) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassesEventDispatcher", "onWearingStatusChanged: " + z);
        for (VuGlassesEventDispatcher.OnWearStateChangeListener a2 : VuGlassesEventDispatcher.c) {
            a2.a(z);
        }
    }
}
