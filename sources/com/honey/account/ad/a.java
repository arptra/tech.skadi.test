package com.honey.account.ad;

import zmq.util.Utils;
import zmq.util.function.Supplier;

public final /* synthetic */ class a implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f3215a;

    public /* synthetic */ a(String str) {
        this.f3215a = str;
    }

    public final Object get() {
        return Utils.e(this.f3215a);
    }
}
