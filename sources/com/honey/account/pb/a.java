package com.honey.account.pb;

import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.internal.Util;

public final /* synthetic */ class a implements EventListener.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EventListener f3684a;

    public /* synthetic */ a(EventListener eventListener) {
        this.f3684a = eventListener;
    }

    public final EventListener create(Call call) {
        return Util.asFactory$lambda$8(this.f3684a, call);
    }
}
