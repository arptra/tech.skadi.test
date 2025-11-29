package com.honey.account.yc;

import zmq.Msg;
import zmq.io.StreamEngine;
import zmq.util.function.Function;

public final /* synthetic */ class c implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StreamEngine f3235a;

    public /* synthetic */ c(StreamEngine streamEngine) {
        this.f3235a = streamEngine;
    }

    public final Object apply(Object obj) {
        return Boolean.valueOf(this.f3235a.x((Msg) obj));
    }
}
