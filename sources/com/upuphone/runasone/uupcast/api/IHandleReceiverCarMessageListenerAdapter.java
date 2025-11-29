package com.upuphone.runasone.uupcast.api;

import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.honey.account.p6.f;
import com.upuphone.hub.Hub;
import com.upuphone.hub.MainThread;
import com.upuphone.starryiccoaproto.UCarMessage;
import java.lang.reflect.Type;

public final class IHandleReceiverCarMessageListenerAdapter extends Hub.Stub {
    private final IHandleReceiverCarMessageListener adaptee;
    private final Gson gson = new Gson();

    public IHandleReceiverCarMessageListenerAdapter(IHandleReceiverCarMessageListener iHandleReceiverCarMessageListener) {
        this.adaptee = iHandleReceiverCarMessageListener;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$adapt$0(UCarMessage uCarMessage) {
        this.adaptee.handleReceiverCarMessage(uCarMessage);
    }

    public void adapt(Bundle bundle, Bundle bundle2) {
        if ("handleReceiverCarMessage".equals(bundle.getString("method"))) {
            Type type = new TypeToken<UCarMessage>() {
            }.getType();
            MainThread.a(new f(this, (UCarMessage) this.gson.fromJson(bundle.getString("message"), type)));
            return;
        }
        throw new UnsupportedOperationException("target method not found");
    }

    public void transfer(Bundle bundle, Bundle bundle2) {
        bundle.setClassLoader(IHandleReceiverCarMessageListenerAdapter.class.getClassLoader());
        adapt(bundle, bundle2);
    }
}
