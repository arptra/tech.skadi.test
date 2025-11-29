package com.xjmz.myvu.location;

import android.content.IntentFilter;
import android.location.LocationManager;
import com.upuphone.xr.sapp.bluetooth.BluetoothHelper;
import com.xjmz.myvu.ext.ContextExtKt;
import kotlin.Metadata;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

@Metadata(d1 = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0005*\u0001\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\f8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\t\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/xjmz/myvu/location/LocationHelper;", "", "<init>", "()V", "", "c", "()Z", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "b", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_providerChangedEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "Lkotlinx/coroutines/flow/SharedFlow;", "()Lkotlinx/coroutines/flow/SharedFlow;", "providerChangedEvent", "com/xjmz/myvu/location/LocationHelper$broadcastReceiver$1", "d", "Lcom/xjmz/myvu/location/LocationHelper$broadcastReceiver$1;", "broadcastReceiver", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class LocationHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final LocationHelper f8361a = new LocationHelper();
    public static final MutableSharedFlow b;
    public static final SharedFlow c;
    public static final LocationHelper$broadcastReceiver$1 d;

    static {
        MutableSharedFlow b2 = SharedFlowKt.b(0, 1, BufferOverflow.DROP_OLDEST, 1, (Object) null);
        b = b2;
        c = FlowKt.b(b2);
        LocationHelper$broadcastReceiver$1 locationHelper$broadcastReceiver$1 = new LocationHelper$broadcastReceiver$1();
        d = locationHelper$broadcastReceiver$1;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.location.PROVIDERS_CHANGED");
        ContextExtKt.a(BluetoothHelper.f6650a.e(), locationHelper$broadcastReceiver$1, intentFilter);
    }

    public final SharedFlow b() {
        return c;
    }

    public final boolean c() {
        return ((LocationManager) BluetoothHelper.f6650a.e().getSystemService(LocationManager.class)).isProviderEnabled("gps");
    }
}
