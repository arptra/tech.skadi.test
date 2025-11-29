package com.upuphone.starrynet.strategy.discovery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.upuphone.starrynet.common.StLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DiscoveryActionObserver {
    private static final String ACTION_BT_OPP_DATA_CHANGED = "android.btopp.intent.action.BT_OPP_DATA_CHANGE";
    private static final int DIRECTION_BLUETOOTH_COMPLETED = 2;
    private static final int DIRECTION_BLUETOOTH_INCOMING = 0;
    private static final int DIRECTION_BLUETOOTH_OUTGOING = 1;
    private static final int DIRECTION_BLUETOOTH_UNKOWN = -1;
    private static final String EXTRA_BT_OPP_TRANSFER_DIRECTION = "android.nfc.handover.intent.extra.TRANSFER_DIRECTION";
    private static final String TAG = "DiscoveryActionObserver";
    /* access modifiers changed from: private */
    public final List<DiscoveryStateChangeCallback> mStateChangeCallback = new CopyOnWriteArrayList();

    public class DiscoveryActionReceiver extends BroadcastReceiver {
        private DiscoveryActionReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            StLog.i(DiscoveryActionObserver.TAG, "onReceive : " + action);
            if (DiscoveryActionObserver.ACTION_BT_OPP_DATA_CHANGED.equals(intent.getAction())) {
                int intExtra = intent.getIntExtra(DiscoveryActionObserver.EXTRA_BT_OPP_TRANSFER_DIRECTION, -1);
                if (intExtra == 0 || intExtra == 1) {
                    for (DiscoveryStateChangeCallback onReduceBLEScanFreq : DiscoveryActionObserver.this.mStateChangeCallback) {
                        onReduceBLEScanFreq.onReduceBLEScanFreq();
                    }
                } else if (intExtra == 2) {
                    for (DiscoveryStateChangeCallback onRecoverBLEScanFreq : DiscoveryActionObserver.this.mStateChangeCallback) {
                        onRecoverBLEScanFreq.onRecoverBLEScanFreq();
                    }
                }
            }
        }
    }

    public static abstract class DiscoveryStateChangeCallback {
        public void onRecoverBLEScanFreq() {
        }

        public void onReduceBLEScanFreq() {
        }
    }

    public static class Holder {
        /* access modifiers changed from: private */
        public static final DiscoveryActionObserver INSTANCE = new DiscoveryActionObserver();

        private Holder() {
        }
    }

    public static DiscoveryActionObserver getInstance() {
        return Holder.INSTANCE;
    }

    public void init(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_BT_OPP_DATA_CHANGED);
        context.registerReceiver(new DiscoveryActionReceiver(), intentFilter);
    }

    public void regDiscoveryActionCallback(DiscoveryStateChangeCallback discoveryStateChangeCallback) {
        if (discoveryStateChangeCallback != null && !this.mStateChangeCallback.contains(discoveryStateChangeCallback)) {
            this.mStateChangeCallback.add(discoveryStateChangeCallback);
        }
    }

    public void unregDiscoveryActionCallback(DiscoveryStateChangeCallback discoveryStateChangeCallback) {
        this.mStateChangeCallback.remove(discoveryStateChangeCallback);
    }
}
