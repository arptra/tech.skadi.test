package com.honey.account.rc;

import org.zeromq.proto.ZNeedle;
import zmq.util.function.Supplier;

public final /* synthetic */ class a implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3230a;

    public /* synthetic */ a(int i) {
        this.f3230a = i;
    }

    public final Object get() {
        return ZNeedle.c(this.f3230a);
    }
}
