package com.upuphone.runasone.uupcast.api;

import android.os.Bundle;
import android.util.Log;
import com.google.gson.Gson;
import com.upuphone.hub.Hub;
import com.upuphone.starryiccoaproto.UCarMessage;

public final class IHandleReceiverCarMessageListenerProxy implements IHandleReceiverCarMessageListener {
    private static final String TAG = "IHandleReceiverCarMessageListenerProxy";
    private final Gson gson = new Gson();
    private final Hub hub;

    public IHandleReceiverCarMessageListenerProxy(Hub hub2) {
        this.hub = hub2;
    }

    public void handleReceiverCarMessage(UCarMessage uCarMessage) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "handleReceiverCarMessage");
        bundle.putString("message", this.gson.toJson((Object) uCarMessage));
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }
}
