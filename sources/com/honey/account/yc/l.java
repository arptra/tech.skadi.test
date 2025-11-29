package com.honey.account.yc;

import zmq.Msg;
import zmq.io.StreamEngine;
import zmq.util.function.Function;

public final /* synthetic */ class l implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StreamEngine f3244a;

    public /* synthetic */ l(StreamEngine streamEngine) {
        this.f3244a = streamEngine;
    }

    public final Object apply(Object obj) {
        return Boolean.valueOf(this.f3244a.X((Msg) obj));
    }
}
