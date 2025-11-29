package com.upuphone.runasone.share.api;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.gson.Gson;
import com.upuphone.hub.Hub;

public final class IHubUupShareStatusCallbackProxy implements IHubUupShareStatusCallback {
    private static final String TAG = "IHubUupShareStatusCallbackProxy";
    private final Gson gson = new Gson();
    private final Hub hub;

    public IHubUupShareStatusCallbackProxy(Hub hub2) {
        this.hub = hub2;
    }

    public void onFailure(String str, boolean z, int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onFailure");
        bundle.putString("id", str);
        bundle.putBoolean("isRemote", z);
        bundle.putInt("errorCode", i);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onFinish(String str, Uri uri, Uri uri2) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onFinish");
        bundle.putString("id", str);
        bundle.putParcelable("oldUri", uri);
        bundle.putParcelable("newUri", uri2);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onProgressChanged(String str, int i, Uri uri) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onProgressChanged");
        bundle.putString("id", str);
        bundle.putInt("currentProgress", i);
        bundle.putParcelable("uri", uri);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onStart(String str, String str2) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onStart");
        bundle.putString("id", str);
        bundle.putString("extra", str2);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onSuccess(String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onSuccess");
        bundle.putString("id", str);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }
}
