package com.upuphone.runasone.ble;

import android.os.Bundle;
import android.util.Log;
import com.google.gson.Gson;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.hub.Hub;

public final class ReadCallbackProxy implements ReadCallback {
    private static final String TAG = "ReadCallbackProxy";
    private final Gson gson = new Gson();
    private final Hub hub;

    public ReadCallbackProxy(Hub hub2) {
        this.hub = hub2;
    }

    public void onRead(int i, byte[] bArr) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onRead");
        bundle.putInt("status", i);
        bundle.putByteArray(AccountConstantKt.RESPONSE_VALUE, bArr);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }
}
