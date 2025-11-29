package com.upuphone.runasone.share.api;

import android.net.Uri;
import android.os.Bundle;
import com.google.gson.Gson;
import com.upuphone.hub.Hub;
import java.util.ArrayList;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

public final class IHubUupShareAdapter {
    private final IHubUupShare adaptee;
    private final Gson gson = new Gson();

    public IHubUupShareAdapter(IHubUupShare iHubUupShare) {
        this.adaptee = iHubUupShare;
    }

    public void adapt(Bundle bundle, Bundle bundle2) {
        Bundle bundle3 = bundle;
        Bundle bundle4 = bundle2;
        String string = bundle3.getString("method");
        if ("sendFile".equals(string)) {
            String string2 = bundle3.getString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
            ArrayList parcelableArrayList = bundle3.getParcelableArrayList("uris");
            String string3 = bundle3.getString("id");
            String string4 = bundle3.getString("extra");
            bundle4.putString("result", this.adaptee.sendFile(string2, (Uri[]) parcelableArrayList.toArray(new Uri[parcelableArrayList.size()]), string3, string4));
        } else if ("cancel".equals(string)) {
            this.adaptee.cancel(bundle3.getString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME), bundle3.getString("id"));
        } else if ("setPath".equals(string)) {
            this.adaptee.setPath(bundle3.getString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME), bundle3.getString("path"));
        } else {
            IHubUupShareStatusCallbackProxy iHubUupShareStatusCallbackProxy = null;
            if ("registerReceiveCallBack".equals(string)) {
                String string5 = bundle3.getString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
                Hub asInterface = Hub.Stub.asInterface(bundle3.getBinder("callback"));
                if (asInterface != null) {
                    iHubUupShareStatusCallbackProxy = new IHubUupShareStatusCallbackProxy(asInterface);
                }
                this.adaptee.registerReceiveCallBack(string5, iHubUupShareStatusCallbackProxy);
            } else if ("registerSendCallBack".equals(string)) {
                String string6 = bundle3.getString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
                Hub asInterface2 = Hub.Stub.asInterface(bundle3.getBinder("callback"));
                if (asInterface2 != null) {
                    iHubUupShareStatusCallbackProxy = new IHubUupShareStatusCallbackProxy(asInterface2);
                }
                this.adaptee.registerSendCallBack(string6, iHubUupShareStatusCallbackProxy);
            } else if ("confirmReceive".equals(string)) {
                this.adaptee.confirmReceive(bundle3.getString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME), bundle3.getString("taskId"));
            } else if ("cancelReceive".equals(string)) {
                this.adaptee.cancelReceive(bundle3.getString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME), bundle3.getString("taskId"), bundle3.getString("reason"));
            } else if ("pull".equals(string)) {
                String string7 = bundle3.getString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
                ArrayList parcelableArrayList2 = bundle3.getParcelableArrayList("uris");
                bundle4.putString("result", this.adaptee.pull(string7, (Uri[]) parcelableArrayList2.toArray(new Uri[parcelableArrayList2.size()])));
            } else if ("unRegisterReceiveCallBack".equals(string)) {
                this.adaptee.unRegisterReceiveCallBack(bundle3.getString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME));
            } else if ("unRegisterSendCallBack".equals(string)) {
                this.adaptee.unRegisterSendCallBack(bundle3.getString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME));
            } else if ("reTry".equals(string)) {
                String string8 = bundle3.getString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
                ArrayList parcelableArrayList3 = bundle3.getParcelableArrayList("uris");
                String string9 = bundle3.getString("taskId");
                String string10 = bundle3.getString("id");
                String string11 = bundle3.getString("extra");
                bundle4.putBoolean("result", this.adaptee.reTry(string8, (Uri[]) parcelableArrayList3.toArray(new Uri[parcelableArrayList3.size()]), string9, string10, string11));
            } else if ("sendFileByBle".equals(string)) {
                String string12 = bundle3.getString("id");
                String string13 = bundle3.getString("extra");
                bundle4.putString("result", this.adaptee.sendFileByBle(bundle3.getString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME), (Uri) bundle3.getParcelable("uri"), string12, string13));
            } else if ("isTransferring".equals(string)) {
                bundle4.putBoolean("result", this.adaptee.isTransferring(bundle3.getString("taskId")));
            } else {
                throw new UnsupportedOperationException("target method not found");
            }
        }
    }
}
