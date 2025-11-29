package com.honey.account.yc;

import zmq.Msg;
import zmq.io.StreamEngine;
import zmq.util.function.Function;

public final /* synthetic */ class d implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StreamEngine f3236a;

    public /* synthetic */ d(StreamEngine streamEngine) {
        this.f3236a = streamEngine;
    }

    public final Object apply(Object obj) {
        return Boolean.valueOf(this.f3236a.R((Msg) obj));
    }
}
