package com.upuphone.runasone.core.api.sys;

import android.os.Bundle;
import android.util.Log;
import com.google.gson.Gson;
import com.upuphone.hub.Hub;

public final class SystemCallBackProxy implements SystemCallBack {
    private static final String TAG = "SystemCallBackProxy";
    private final Gson gson = new Gson();
    private final Hub hub;

    public SystemCallBackProxy(Hub hub2) {
        this.hub = hub2;
    }

    public void callBackData(SysCallData sysCallData) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "callBackData");
        bundle.putString("data", this.gson.toJson((Object) sysCallData));
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (Exception e) {
            Log.e(TAG, "transfer failed.", e);
        }
    }
}
