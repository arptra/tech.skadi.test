package com.honey.account.ub;

import java.util.function.Consumer;
import org.apache.commons.io.function.IOConsumer;
import org.apache.commons.io.function.IOFunction;

public final /* synthetic */ class g implements IOConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IOFunction f7632a;
    public final /* synthetic */ Consumer b;

    public /* synthetic */ g(IOFunction iOFunction, Consumer consumer) {
        this.f7632a = iOFunction;
        this.b = consumer;
    }

    public final void accept(Object obj) {
        this.f7632a.lambda$andThen$7(this.b, obj);
    }
}
