package com.upuphone.xr.sapp.bluetooth;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/upuphone/xr/sapp/bluetooth/BluetoothHelper$broadcastReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BluetoothHelper$broadcastReceiver$1 extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode != -1530327060) {
                if (hashCode == 1123270207 && action.equals("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED")) {
                    BluetoothHelper.f6650a.d(new BluetoothHelper$broadcastReceiver$1$onReceive$2(intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE", 0), intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", 0)));
                }
            } else if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                BluetoothHelper.f6650a.d(new BluetoothHelper$broadcastReceiver$1$onReceive$1(intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 10), intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10)));
            }
        }
    }
}
