package com.honey.account.yc;

import zmq.io.StreamEngine;
import zmq.util.function.Supplier;

public final /* synthetic */ class b implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StreamEngine f3234a;

    public /* synthetic */ b(StreamEngine streamEngine) {
        this.f3234a = streamEngine;
    }

    public final Object get() {
        return this.f3234a.O();
    }
}
