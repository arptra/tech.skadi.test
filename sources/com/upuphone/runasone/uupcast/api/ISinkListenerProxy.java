package com.upuphone.runasone.uupcast.api;

import android.os.Bundle;
import android.util.Log;
import com.google.gson.Gson;
import com.upuphone.hub.Hub;
import com.upuphone.runasone.uupcast.SourceDisplayConfig;

public final class ISinkListenerProxy implements ISinkListener {
    private static final String TAG = "ISinkListenerProxy";
    private final Gson gson = new Gson();
    private final Hub hub;

    public ISinkListenerProxy(Hub hub2) {
        this.hub = hub2;
    }

    public void onSinkConnected() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onSinkConnected");
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onSinkDisconnected() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onSinkDisconnected");
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onSinkError(int i, String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onSinkError");
        bundle.putInt("error", i);
        bundle.putString("message", str);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onSinkEvent(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = new Bundle();
        bundle2.putString("method", "onSinkEvent");
        bundle2.putInt("event", i);
        bundle2.putParcelable("bundle", bundle);
        try {
            this.hub.transfer(bundle2, bundle3);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onSinkStart() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onSinkStart");
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onSinkStartWithConfig(SourceDisplayConfig sourceDisplayConfig) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onSinkStartWithConfig");
        bundle.putString("config", this.gson.toJson((Object) sourceDisplayConfig));
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onSinkSyncError(int i, String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onSinkSyncError");
        bundle.putInt("errorCode", i);
        bundle.putString("message", str);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onSinkSyncEvent(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = new Bundle();
        bundle2.putString("method", "onSinkSyncEvent");
        bundle2.putInt("eventCode", i);
        bundle2.putParcelable("bundle", bundle);
        try {
            this.hub.transfer(bundle2, bundle3);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }
}
