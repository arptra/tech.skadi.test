package com.upuphone.starrynet.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class LocalSharePreference extends BroadcastReceiver {
    public static final String ACTION_IOT_PREFERENCE_CHANGED = "ACTION.IOT.PREFERENCE.CHANGED";
    public static final String PREFERENCE_KEY = "LOCAL.PREFERENCE.KEY";
    private Context mContext;
    private SharedPreferences.OnSharedPreferenceChangeListener sharedPreferenceChangeListener;
    private SharedPreferences sharedPreferences;

    public LocalSharePreference(Context context, String str) {
        this.mContext = context;
        this.sharedPreferences = context.getSharedPreferences(str, 0);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_IOT_PREFERENCE_CHANGED);
        LocalBroadcastManager.b(this.mContext).c(this, intentFilter);
    }

    public void destroy() {
        LocalBroadcastManager.b(this.mContext).e(this);
    }

    public SharedPreferences.Editor getEditor() {
        return this.sharedPreferences.edit();
    }

    public SharedPreferences getSharedPreferences() {
        return this.sharedPreferences;
    }

    public void notifyLocalPreferenceChange(String str) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent(ACTION_IOT_PREFERENCE_CHANGED);
            intent.putExtra(PREFERENCE_KEY, str);
            LocalBroadcastManager.b(this.mContext).d(intent);
        }
    }

    public void onReceive(Context context, Intent intent) {
        SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener;
        if (ACTION_IOT_PREFERENCE_CHANGED.equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra(PREFERENCE_KEY);
            if (!TextUtils.isEmpty(stringExtra) && (onSharedPreferenceChangeListener = this.sharedPreferenceChangeListener) != null) {
                onSharedPreferenceChangeListener.onSharedPreferenceChanged(this.sharedPreferences, stringExtra);
            }
        }
    }

    public void setRemotePreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.sharedPreferenceChangeListener = onSharedPreferenceChangeListener;
    }
}
