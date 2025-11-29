package com.upuphone.xr.sapp.vu.utils;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Build;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.MainApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014R<\u0010\u001a\u001a*\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00170\u0015j\u0014\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0017`\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/upuphone/xr/sapp/vu/utils/UsbPermissionHelper;", "", "<init>", "()V", "", "vendorId", "productId", "", "a", "(II)Z", "Landroid/hardware/usb/UsbDevice;", "usbDevice", "b", "(Landroid/hardware/usb/UsbDevice;)Z", "Lcom/upuphone/xr/sapp/vu/utils/UsbPermissionHelper$OnGrantedResult;", "onGrantedResult", "", "d", "(Landroid/hardware/usb/UsbDevice;Lcom/upuphone/xr/sapp/vu/utils/UsbPermissionHelper$OnGrantedResult;)V", "c", "(II)V", "Ljava/util/HashMap;", "", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "grantedResultMap", "OnGrantedResult", "UsbPermissionReceiver", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nUsbPermissionHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UsbPermissionHelper.kt\ncom/upuphone/xr/sapp/vu/utils/UsbPermissionHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,136:1\n1855#2,2:137\n*S KotlinDebug\n*F\n+ 1 UsbPermissionHelper.kt\ncom/upuphone/xr/sapp/vu/utils/UsbPermissionHelper\n*L\n118#1:137,2\n*E\n"})
public final class UsbPermissionHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final UsbPermissionHelper f8095a = new UsbPermissionHelper();
    public static final HashMap b = new HashMap();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/vu/utils/UsbPermissionHelper$OnGrantedResult;", "", "", "granted", "", "a", "(Z)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface OnGrantedResult {
        void a(boolean z);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/vu/utils/UsbPermissionHelper$UsbPermissionReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class UsbPermissionReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            int intExtra = intent.getIntExtra("productId", 0);
            int intExtra2 = intent.getIntExtra("vendorId", 0);
            ULog.Delegate delegate = ULog.f6446a;
            String action = intent.getAction();
            delegate.a("UsbPermissionHelper", "onReceive action = " + action + ", productId: " + intExtra + ", vendorId: " + intExtra2);
            UsbPermissionHelper.f8095a.c(intExtra, intExtra2);
        }
    }

    static {
        MainApplication.k.f().registerReceiver(new UsbPermissionReceiver(), new IntentFilter("action.usb.permission.result"), 2);
    }

    public final boolean a(int i, int i2) {
        UsbDevice usbDevice;
        Iterator<UsbDevice> it = ((UsbManager) MainApplication.k.f().getSystemService(UsbManager.class)).getDeviceList().values().iterator();
        while (true) {
            if (it.hasNext()) {
                UsbDevice next = it.next();
                if (i2 == next.getProductId() && i == next.getVendorId()) {
                    usbDevice = next;
                    break;
                }
            } else {
                usbDevice = null;
                break;
            }
        }
        return b(usbDevice);
    }

    public final boolean b(UsbDevice usbDevice) {
        if (usbDevice == null) {
            return false;
        }
        boolean hasPermission = ((UsbManager) MainApplication.k.f().getSystemService(UsbManager.class)).hasPermission(usbDevice);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("UsbPermissionHelper", "hasPermission: " + hasPermission);
        return hasPermission;
    }

    public final void c(int i, int i2) {
        ULog.Delegate delegate = ULog.f6446a;
        HashMap hashMap = b;
        Integer valueOf = Integer.valueOf(hashMap.size());
        StringBuilder sb = new StringBuilder();
        sb.append(valueOf);
        delegate.a("UsbPermissionHelper", sb.toString());
        boolean a2 = a(i2, i);
        CopyOnWriteArraySet<OnGrantedResult> copyOnWriteArraySet = (CopyOnWriteArraySet) hashMap.remove(i + AccountConstantKt.DEFAULT_SEGMENT + i2);
        if (copyOnWriteArraySet != null) {
            for (OnGrantedResult a3 : copyOnWriteArraySet) {
                a3.a(a2);
            }
        }
        b.clear();
    }

    public final void d(UsbDevice usbDevice, OnGrantedResult onGrantedResult) {
        Intrinsics.checkNotNullParameter(onGrantedResult, "onGrantedResult");
        if (usbDevice == null) {
            ULog.f6446a.a("UsbPermissionHelper", "requestPermission= usbDevice == null");
            onGrantedResult.a(false);
            return;
        }
        int productId = usbDevice.getProductId();
        int vendorId = usbDevice.getVendorId();
        String str = productId + AccountConstantKt.DEFAULT_SEGMENT + vendorId;
        HashMap hashMap = b;
        CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) hashMap.get(str);
        if (copyOnWriteArraySet == null) {
            copyOnWriteArraySet = new CopyOnWriteArraySet();
            hashMap.put(str, copyOnWriteArraySet);
        }
        copyOnWriteArraySet.add(onGrantedResult);
        ULog.f6446a.a("UsbPermissionHelper", "requestPermission= usbDevice vendorId=" + Integer.valueOf(vendorId) + ", productId=" + productId);
        int i = Build.VERSION.SDK_INT >= 31 ? CaptureType.CAPTURE_TYPE_ICCOA : 0;
        MainApplication f = MainApplication.k.f();
        Intent intent = new Intent("action.usb.permission.result");
        intent.putExtra("productId", productId);
        intent.putExtra("vendorId", vendorId);
        ((UsbManager) f.getSystemService(UsbManager.class)).requestPermission(usbDevice, PendingIntent.getBroadcast(f, 0, intent, i));
    }
}
