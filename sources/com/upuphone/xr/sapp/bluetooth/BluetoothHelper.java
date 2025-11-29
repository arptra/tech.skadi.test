package com.upuphone.xr.sapp.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.IntentFilter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.xr.sapp.MainApplication;
import com.xjmz.myvu.ext.ContextExtKt;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u001d\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\bJ\u0011\u0010\u0010\u001a\u00020\u000f*\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u0015\u001a\u00020\u00062\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0012¢\u0006\u0002\b\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0018R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u001eR\u0011\u0010#\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010'\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010)\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b(\u0010&¨\u0006*"}, d2 = {"Lcom/upuphone/xr/sapp/bluetooth/BluetoothHelper;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/bluetooth/BluetoothListener;", "listener", "", "c", "(Lcom/upuphone/xr/sapp/bluetooth/BluetoothListener;)V", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "b", "(Landroidx/lifecycle/LifecycleOwner;Lcom/upuphone/xr/sapp/bluetooth/BluetoothListener;)V", "h", "", "", "i", "(I)Ljava/lang/String;", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "action", "d", "(Lkotlin/jvm/functions/Function1;)V", "Landroid/bluetooth/BluetoothAdapter;", "Landroid/bluetooth/BluetoothAdapter;", "bluetoothAdapter", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "bluetoothListeners", "com/upuphone/xr/sapp/bluetooth/BluetoothHelper$broadcastReceiver$1", "Lcom/upuphone/xr/sapp/bluetooth/BluetoothHelper$broadcastReceiver$1;", "broadcastReceiver", "Landroid/content/Context;", "e", "()Landroid/content/Context;", "context", "", "f", "()Z", "isBluetoothEnabled", "g", "isBluetoothOff", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nBluetoothHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BluetoothHelper.kt\ncom/upuphone/xr/sapp/bluetooth/BluetoothHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,148:1\n1855#2,2:149\n*S KotlinDebug\n*F\n+ 1 BluetoothHelper.kt\ncom/upuphone/xr/sapp/bluetooth/BluetoothHelper\n*L\n73#1:149,2\n*E\n"})
public final class BluetoothHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final BluetoothHelper f6650a;
    public static final BluetoothAdapter b;
    public static final CopyOnWriteArraySet c = new CopyOnWriteArraySet();
    public static final BluetoothHelper$broadcastReceiver$1 d;

    static {
        BluetoothHelper bluetoothHelper = new BluetoothHelper();
        f6650a = bluetoothHelper;
        BluetoothHelper$broadcastReceiver$1 bluetoothHelper$broadcastReceiver$1 = new BluetoothHelper$broadcastReceiver$1();
        d = bluetoothHelper$broadcastReceiver$1;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        BluetoothAdapter adapter = ((BluetoothManager) bluetoothHelper.e().getSystemService(BluetoothManager.class)).getAdapter();
        Intrinsics.checkNotNullExpressionValue(adapter, "getAdapter(...)");
        b = adapter;
        ContextExtKt.a(bluetoothHelper.e(), bluetoothHelper$broadcastReceiver$1, intentFilter);
    }

    public final void b(LifecycleOwner lifecycleOwner, BluetoothListener bluetoothListener) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(bluetoothListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (lifecycleOwner.getLifecycle().b().isAtLeast(Lifecycle.State.CREATED)) {
            c(bluetoothListener);
            lifecycleOwner.getLifecycle().a(new BluetoothHelper$addBluetoothListener$1(bluetoothListener));
        }
    }

    public final void c(BluetoothListener bluetoothListener) {
        Intrinsics.checkNotNullParameter(bluetoothListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        c.add(bluetoothListener);
    }

    public final void d(Function1 function1) {
        for (BluetoothListener bluetoothListener : c) {
            Intrinsics.checkNotNull(bluetoothListener);
            function1.invoke(bluetoothListener);
        }
    }

    public final Context e() {
        Context applicationContext = MainApplication.k.f().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return applicationContext;
    }

    public final boolean f() {
        return b.isEnabled();
    }

    public final boolean g() {
        return b.getState() == 10;
    }

    public final void h(BluetoothListener bluetoothListener) {
        Intrinsics.checkNotNullParameter(bluetoothListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        c.remove(bluetoothListener);
    }

    public final String i(int i) {
        switch (i) {
            case 10:
                return "STATE_OFF";
            case 11:
                return "STATE_TURNING_ON";
            case 12:
                return "STATE_ON";
            case 13:
                return "STATE_TURNING_OFF";
            default:
                return "unknown(" + i + ")";
        }
    }
}
