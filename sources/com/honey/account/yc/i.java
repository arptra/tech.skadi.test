package com.honey.account.yc;

import zmq.Msg;
import zmq.io.StreamEngine;
import zmq.util.function.Function;

public final /* synthetic */ class i implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StreamEngine f3241a;

    public /* synthetic */ i(StreamEngine streamEngine) {
        this.f3241a = streamEngine;
    }

    public final Object apply(Object obj) {
        return Boolean.valueOf(this.f3241a.Q((Msg) obj));
    }
}
