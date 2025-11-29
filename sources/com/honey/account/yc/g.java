package com.honey.account.yc;

import zmq.Msg;
import zmq.io.StreamEngine;
import zmq.util.function.Function;

public final /* synthetic */ class g implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StreamEngine f3239a;

    public /* synthetic */ g(StreamEngine streamEngine) {
        this.f3239a = streamEngine;
    }

    public final Object apply(Object obj) {
        return Boolean.valueOf(this.f3239a.J((Msg) obj));
    }
}
