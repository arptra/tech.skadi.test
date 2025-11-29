package com.honey.account.yc;

import zmq.io.StreamEngine;
import zmq.util.function.Supplier;

public final /* synthetic */ class j implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StreamEngine f3242a;

    public /* synthetic */ j(StreamEngine streamEngine) {
        this.f3242a = streamEngine;
    }

    public final Object get() {
        return this.f3242a.P();
    }
}
