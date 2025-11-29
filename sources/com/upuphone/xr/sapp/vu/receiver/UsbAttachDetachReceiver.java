package com.upuphone.xr.sapp.vu.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.os.Build;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.vu.utils.VuGlassesHelper;
import com.upuphone.xr.sapp.vu.vm.VuGlassControlModel;
import com.upuphone.xr.sapp.vu.vm.VuGlassesDeviceModel;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/vu/receiver/UsbAttachDetachReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Landroid/hardware/usb/UsbDevice;", "device", "a", "(Landroid/hardware/usb/UsbDevice;)V", "b", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/upuphone/xr/sapp/vu/receiver/ViewGlassesConnectListener;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "listeners", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nUsbAttachDetachReceiver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UsbAttachDetachReceiver.kt\ncom/upuphone/xr/sapp/vu/receiver/UsbAttachDetachReceiver\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,74:1\n1855#2,2:75\n1855#2,2:77\n*S KotlinDebug\n*F\n+ 1 UsbAttachDetachReceiver.kt\ncom/upuphone/xr/sapp/vu/receiver/UsbAttachDetachReceiver\n*L\n65#1:75,2\n72#1:77,2\n*E\n"})
public final class UsbAttachDetachReceiver extends BroadcastReceiver {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArraySet f8086a;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/sapp/vu/receiver/UsbAttachDetachReceiver$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "a", "(Landroid/content/Context;)V", "", "TAG", "Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
            intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
            context.registerReceiver(new UsbAttachDetachReceiver(), intentFilter);
        }

        public Companion() {
        }
    }

    public UsbAttachDetachReceiver() {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        this.f8086a = copyOnWriteArraySet;
        copyOnWriteArraySet.add(VuGlassesDeviceModel.f8113a);
        copyOnWriteArraySet.add(VuGlassControlModel.f8109a);
    }

    public final void a(UsbDevice usbDevice) {
        if (VuGlassesHelper.f8099a.f(usbDevice)) {
            for (ViewGlassesConnectListener b2 : this.f8086a) {
                b2.b(usbDevice);
            }
        }
    }

    public final void b(UsbDevice usbDevice) {
        if (VuGlassesHelper.f8099a.f(usbDevice)) {
            for (ViewGlassesConnectListener a2 : this.f8086a) {
                a2.a(usbDevice);
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        ULog.Delegate delegate = ULog.f6446a;
        String action = intent.getAction();
        delegate.g("UsbAttachDetachReceiver", "action received: " + action);
        Class<UsbDevice> cls = UsbDevice.class;
        if (Intrinsics.areEqual((Object) intent.getAction(), (Object) "android.hardware.usb.action.USB_DEVICE_ATTACHED")) {
            UsbDevice usbDevice = Build.VERSION.SDK_INT >= 33 ? (UsbDevice) intent.getParcelableExtra("device", cls) : (UsbDevice) intent.getParcelableExtra("device");
            if (usbDevice != null) {
                a(usbDevice);
            }
        } else if (Intrinsics.areEqual((Object) intent.getAction(), (Object) "android.hardware.usb.action.USB_DEVICE_DETACHED")) {
            UsbDevice usbDevice2 = Build.VERSION.SDK_INT >= 33 ? (UsbDevice) intent.getParcelableExtra("device", cls) : (UsbDevice) intent.getParcelableExtra("device");
            if (usbDevice2 != null) {
                b(usbDevice2);
            }
        }
    }
}
