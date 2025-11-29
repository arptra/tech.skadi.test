package com.here.odnp.adaptations;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.here.odnp.util.Log;
import com.meizu.common.widget.MzContactsContract;

public class BatteryManager {
    private static final String TAG = "odnp.adaptations.BatteryManager";
    private int mBatteryLevel = -1;
    private final Context mContext;
    private final IListener mListener;
    private BroadcastReceiver mReceiver;

    public interface IListener {
        void onBatteryLevelChanged(int i);
    }

    public BatteryManager(Context context, IListener iListener) {
        Log.v(TAG, "BatteryManager", new Object[0]);
        if (iListener != null) {
            this.mContext = context;
            this.mListener = iListener;
            return;
        }
        throw new IllegalArgumentException("listener is null");
    }

    /* access modifiers changed from: private */
    public void updateBatteryLevel(Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("level", -1);
            int intExtra2 = intent.getIntExtra("scale", -1);
            if (intExtra >= 0 && intExtra2 != 0 && intExtra2 >= intExtra) {
                int i = (intExtra * 100) / intExtra2;
                this.mBatteryLevel = i;
                Log.v(TAG, "updateBatteryLevel: %d%%", Integer.valueOf(i));
                this.mListener.onBatteryLevelChanged(this.mBatteryLevel);
            }
        }
    }

    public int getLevel() {
        return this.mBatteryLevel;
    }

    public void start() {
        Log.v(TAG, MzContactsContract.START_PARAM_KEY, new Object[0]);
        if (this.mReceiver == null) {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
            AnonymousClass1 r1 = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                        BatteryManager.this.updateBatteryLevel(intent);
                    }
                }
            };
            this.mReceiver = r1;
            updateBatteryLevel(this.mContext.registerReceiver(r1, intentFilter));
        }
    }

    public void stop() {
        Log.v(TAG, "stop", new Object[0]);
        BroadcastReceiver broadcastReceiver = this.mReceiver;
        if (broadcastReceiver != null) {
            this.mContext.unregisterReceiver(broadcastReceiver);
            this.mReceiver = null;
        }
    }
}
