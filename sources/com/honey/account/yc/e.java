package com.honey.account.yc;

import zmq.io.StreamEngine;
import zmq.util.function.Supplier;

public final /* synthetic */ class e implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StreamEngine f3237a;

    public /* synthetic */ e(StreamEngine streamEngine) {
        this.f3237a = streamEngine;
    }

    public final Object get() {
        return this.f3237a.M();
    }
}
