package com.honey.account.rb;

import java.io.IOException;
import java.util.function.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Exception f7608a;

    public /* synthetic */ b(Exception exc) {
        this.f7608a = exc;
    }

    public final void accept(Object obj) {
        this.f7608a.addSuppressed((IOException) obj);
    }
}
