package com.honey.account.yc;

import zmq.io.StreamEngine;
import zmq.util.function.Supplier;

public final /* synthetic */ class h implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StreamEngine f3240a;

    public /* synthetic */ h(StreamEngine streamEngine) {
        this.f3240a = streamEngine;
    }

    public final Object get() {
        return this.f3240a.H();
    }
}
