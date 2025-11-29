package com.upuphone.runasone.uupcast.api;

import android.os.Bundle;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.upuphone.hub.Hub;
import com.upuphone.runasone.uupcast.CastAudioAttributes;
import java.lang.reflect.Type;

public final class ISinkAudioListenerProxy implements ISinkAudioListener {
    private static final String TAG = "ISinkAudioListenerProxy";
    private final Gson gson = new Gson();
    private final Hub hub;

    public ISinkAudioListenerProxy(Hub hub2) {
        this.hub = hub2;
    }

    public CastAudioAttributes convertAudioAttributes(int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "convertAudioAttributes");
        bundle.putInt("audioType", i);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
        Type type = new TypeToken<CastAudioAttributes>() {
        }.getType();
        return (CastAudioAttributes) this.gson.fromJson(bundle2.getString("result"), type);
    }

    public void onForceMuteStart(int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onForceMuteStart");
        bundle.putInt("audioTypeMask", i);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }

    public void onForceMuteStop(int i) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onForceMuteStop");
        bundle.putInt("audioTypeMask", i);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }
}
