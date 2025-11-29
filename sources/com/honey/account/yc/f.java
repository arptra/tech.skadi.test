package com.honey.account.yc;

import zmq.io.StreamEngine;
import zmq.util.function.Supplier;

public final /* synthetic */ class f implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StreamEngine f3238a;

    public /* synthetic */ f(StreamEngine streamEngine) {
        this.f3238a = streamEngine;
    }

    public final Object get() {
        return this.f3238a.E();
    }
}
