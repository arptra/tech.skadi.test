package com.honey.account.yc;

import zmq.Msg;
import zmq.io.StreamEngine;
import zmq.util.function.Function;

public final /* synthetic */ class a implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StreamEngine f3233a;

    public /* synthetic */ a(StreamEngine streamEngine) {
        this.f3233a = streamEngine;
    }

    public final Object apply(Object obj) {
        return Boolean.valueOf(this.f3233a.L((Msg) obj));
    }
}
