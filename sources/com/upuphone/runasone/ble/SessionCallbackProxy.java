package com.upuphone.runasone.ble;

import android.os.Bundle;
import com.google.gson.Gson;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.hub.Hub;
import com.upuphone.hub.HubException;

public final class SessionCallbackProxy implements SessionCallback {
    private static final String TAG = "SessionCallbackProxy";
    private final Gson gson = new Gson();
    private final Hub hub;

    public SessionCallbackProxy(Hub hub2) {
        this.hub = hub2;
    }

    public void onNotify(String str, byte[] bArr) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "onNotify");
        bundle.putString("notifyUUID", str);
        bundle.putByteArray(AccountConstantKt.RESPONSE_VALUE, bArr);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            throw new HubException((Throwable) e);
        }
    }
}
