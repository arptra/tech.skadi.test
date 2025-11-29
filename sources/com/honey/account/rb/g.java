package com.honey.account.rb;

import java.io.IOException;
import java.util.function.Consumer;

public final /* synthetic */ class g implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IOException f7610a;

    public /* synthetic */ g(IOException iOException) {
        this.f7610a = iOException;
    }

    public final void accept(Object obj) {
        this.f7610a.addSuppressed((IOException) obj);
    }
}
