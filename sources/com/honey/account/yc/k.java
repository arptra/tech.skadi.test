package com.honey.account.yc;

import zmq.Msg;
import zmq.io.StreamEngine;
import zmq.util.function.Function;

public final /* synthetic */ class k implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StreamEngine f3243a;

    public /* synthetic */ k(StreamEngine streamEngine) {
        this.f3243a = streamEngine;
    }

    public final Object apply(Object obj) {
        return Boolean.valueOf(this.f3243a.S((Msg) obj));
    }
}
