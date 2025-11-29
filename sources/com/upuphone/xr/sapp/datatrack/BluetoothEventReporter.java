package com.upuphone.xr.sapp.datatrack;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.bluetooth.BluetoothHelper;
import com.upuphone.xr.sapp.bluetooth.BluetoothListener;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/datatrack/BluetoothEventReporter;", "Lcom/upuphone/xr/sapp/bluetooth/BluetoothListener;", "<init>", "()V", "", "oldState", "newState", "", "a", "(II)V", "b", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class BluetoothEventReporter implements BluetoothListener {

    /* renamed from: a  reason: collision with root package name */
    public static final BluetoothEventReporter f6912a;

    static {
        BluetoothEventReporter bluetoothEventReporter = new BluetoothEventReporter();
        f6912a = bluetoothEventReporter;
        BluetoothHelper.f6650a.c(bluetoothEventReporter);
    }

    public void a(int i, int i2) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("BluetoothEventReporter", "onStateChanged, oldState: " + i + ", newState: " + i2);
        if (i2 == 10) {
            Job unused = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, (CoroutineContext) null, (CoroutineStart) null, new BluetoothEventReporter$onStateChanged$2((Continuation<? super BluetoothEventReporter$onStateChanged$2>) null), 3, (Object) null);
        } else if (i2 == 12) {
            Job unused2 = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, (CoroutineContext) null, (CoroutineStart) null, new BluetoothEventReporter$onStateChanged$1((Continuation<? super BluetoothEventReporter$onStateChanged$1>) null), 3, (Object) null);
        }
    }

    public void b(int i, int i2) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("BluetoothEventReporter", "onConnectionStateChanged, oldState: " + i + ", newState: " + i2);
    }
}
