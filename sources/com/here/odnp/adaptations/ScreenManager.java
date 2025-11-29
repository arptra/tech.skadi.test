package com.here.odnp.adaptations;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.here.odnp.util.Log;
import com.meizu.common.widget.MzContactsContract;

public class ScreenManager {
    private static final String TAG = "odnp.adaptations.ScreenManager";
    private final Context mContext;
    private final IListener mListener;
    private BroadcastReceiver mReceiver;
    private boolean mScreenOn;

    public interface IListener {
        void onScreenOff();

        void onScreenOn();
    }

    public ScreenManager(Context context, IListener iListener) {
        Log.v(TAG, "ScreenManager", new Object[0]);
        if (iListener != null) {
            this.mContext = context;
            this.mListener = iListener;
            this.mScreenOn = isScreenOn();
            return;
        }
        throw new IllegalArgumentException("listener is null");
    }

    /* access modifiers changed from: private */
    public void handleScreenOff() {
        Log.v(TAG, "handleScreenOff", new Object[0]);
        this.mScreenOn = false;
        IListener iListener = this.mListener;
        if (iListener != null) {
            iListener.onScreenOff();
        }
    }

    /* access modifiers changed from: private */
    public void handleScreenOn() {
        Log.v(TAG, "handleScreenOn", new Object[0]);
        this.mScreenOn = true;
        IListener iListener = this.mListener;
        if (iListener != null) {
            iListener.onScreenOn();
        }
    }

    private boolean isScreenOn() {
        return ((PowerManager) this.mContext.getSystemService("power")).isInteractive();
    }

    public boolean getScreenOnState() {
        return this.mScreenOn;
    }

    public void start() {
        Log.v(TAG, MzContactsContract.START_PARAM_KEY, new Object[0]);
        if (this.mReceiver == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            AnonymousClass1 r1 = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    if (intent != null) {
                        if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                            ScreenManager.this.handleScreenOn();
                        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                            ScreenManager.this.handleScreenOff();
                        }
                    }
                }
            };
            this.mReceiver = r1;
            Context context = this.mContext;
            r1.onReceive(context, context.registerReceiver(r1, intentFilter));
        }
    }

    public void stop() {
        BroadcastReceiver broadcastReceiver = this.mReceiver;
        if (broadcastReceiver != null) {
            this.mContext.unregisterReceiver(broadcastReceiver);
            this.mReceiver = null;
        }
    }
}
