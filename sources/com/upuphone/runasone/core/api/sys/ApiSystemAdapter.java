package com.upuphone.runasone.core.api.sys;

import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.honey.account.view.web.WebJs;
import com.upuphone.hub.Hub;
import com.upuphone.runasone.device.StarryDevice;
import java.lang.reflect.Type;

public final class ApiSystemAdapter {
    private final ApiSystem adaptee;
    private final Gson gson = new Gson();

    public ApiSystemAdapter(ApiSystem apiSystem) {
        this.adaptee = apiSystem;
    }

    public void adapt(Bundle bundle, Bundle bundle2) {
        String string = bundle.getString("method");
        if ("switchAudioPlayDevice".equals(string)) {
            Type type = new TypeToken<StarryDevice>() {
            }.getType();
            bundle2.putInt("result", this.adaptee.switchAudioPlayDevice((StarryDevice) this.gson.fromJson(bundle.getString("device"), type)));
        } else if ("getAudioPlayDevice".equals(string)) {
            bundle2.putString("result", this.gson.toJson((Object) this.adaptee.getAudioPlayDevice()));
        } else if ("getListBrDevice".equals(string)) {
            bundle2.putString("result", this.gson.toJson((Object) this.adaptee.getListBrDevice()));
        } else if ("getCallState".equals(string)) {
            bundle2.putInt("result", this.adaptee.getCallState());
        } else if ("dial".equals(string)) {
            this.adaptee.dial(bundle.getString("number"));
        } else if ("operateAction".equals(string)) {
            this.adaptee.operateAction(bundle.getInt("type"), bundle.getInt(WebJs.ACTION));
        } else if ("registerCallBack".equals(string)) {
            Hub asInterface = Hub.Stub.asInterface(bundle.getBinder("callBack"));
            this.adaptee.registerCallBack(asInterface != null ? new SystemCallBackProxy(asInterface) : null);
        } else if ("unRegisterCallBack".equals(string)) {
            Type type2 = new TypeToken<SystemCallBack>() {
            }.getType();
            this.adaptee.unRegisterCallBack((SystemCallBack) this.gson.fromJson(bundle.getString("callBack"), type2));
        } else {
            throw new UnsupportedOperationException("target method not found");
        }
    }
}
