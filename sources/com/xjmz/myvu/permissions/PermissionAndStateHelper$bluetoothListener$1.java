package com.xjmz.myvu.permissions;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.bluetooth.BluetoothHelper;
import com.upuphone.xr.sapp.bluetooth.BluetoothListener;
import com.xjmz.myvu.exception.ContinuationException;
import kotlin.Metadata;
import kotlinx.coroutines.Deferred;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"com/xjmz/myvu/permissions/PermissionAndStateHelper$bluetoothListener$1", "Lcom/upuphone/xr/sapp/bluetooth/BluetoothListener;", "", "oldState", "newState", "", "a", "(II)V", "b", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class PermissionAndStateHelper$bluetoothListener$1 implements BluetoothListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PermissionAndStateHelper f8372a;

    public PermissionAndStateHelper$bluetoothListener$1(PermissionAndStateHelper permissionAndStateHelper) {
        this.f8372a = permissionAndStateHelper;
    }

    public void a(int i, int i2) {
        Deferred b;
        ULog.Delegate delegate = ULog.f6446a;
        BluetoothHelper bluetoothHelper = BluetoothHelper.f6650a;
        String i3 = bluetoothHelper.i(i);
        String i4 = bluetoothHelper.i(i2);
        delegate.g("PermissionAndStateHelper", "onStateChanged, oldState: " + i3 + ", newState: " + i4);
        if (i2 == 12 && (b = this.f8372a.h) != null && b.isActive()) {
            delegate.g("PermissionAndStateHelper", "onStateChanged, waitBluetoothStateJob.cancel");
            Deferred b2 = this.f8372a.h;
            if (b2 != null) {
                b2.a(new ContinuationException("Bluetooth enabled"));
            }
        }
    }

    public void b(int i, int i2) {
    }
}
