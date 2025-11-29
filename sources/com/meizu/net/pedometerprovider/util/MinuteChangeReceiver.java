package com.meizu.net.pedometerprovider.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.meizu.net.pedometerprovider.listener.MinuteChangeListener;

public class MinuteChangeReceiver extends BroadcastReceiver {
    public static final String TAG = "MinuteChangeReceiver";
    private MinuteChangeListener mListener;

    public MinuteChangeReceiver(MinuteChangeListener minuteChangeListener) {
        this.mListener = minuteChangeListener;
    }

    public void onReceive(Context context, Intent intent) {
        MinuteChangeListener minuteChangeListener;
        if ("android.intent.action.TIME_TICK".equals(intent.getAction()) && (minuteChangeListener = this.mListener) != null) {
            minuteChangeListener.onMinuteChange();
        }
    }
}
