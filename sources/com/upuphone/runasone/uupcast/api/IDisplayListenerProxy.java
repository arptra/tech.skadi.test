package com.upuphone.runasone.uupcast.api;

import android.os.Bundle;
import android.util.Log;
import com.google.gson.Gson;
import com.upuphone.hub.Hub;

public final class IDisplayListenerProxy implements IDisplayListener {
    private static final String TAG = "IDisplayListenerProxy";
    private final Gson gson = new Gson();
    private final Hub hub;

    public IDisplayListenerProxy(Hub hub2) {
        this.hub = hub2;
    }

    public void onDisplayConnected() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onDisplayConnected");
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onDisplayDisconnected() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onDisplayDisconnected");
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onDisplayError(int i, String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onDisplayError");
        bundle.putInt("error", i);
        bundle.putString("message", str);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onDisplayEvent(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = new Bundle();
        bundle2.putString("method", "onDisplayEvent");
        bundle2.putInt("event", i);
        bundle2.putParcelable("bundle", bundle);
        try {
            this.hub.transfer(bundle2, bundle3);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onDisplaySyncError(int i, String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onDisplaySyncError");
        bundle.putInt("errorCode", i);
        bundle.putString("message", str);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onDisplaySyncEvent(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = new Bundle();
        bundle2.putString("method", "onDisplaySyncEvent");
        bundle2.putInt("eventCode", i);
        bundle2.putParcelable("bundle", bundle);
        try {
            this.hub.transfer(bundle2, bundle3);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onUibcCustomEvent(String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onUibcCustomEvent");
        bundle.putString("message", str);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }
}
