package com.honey.account.qa;

import dagger.hilt.android.internal.lifecycle.RetainedLifecycleImpl;
import java.io.Closeable;

public final /* synthetic */ class a implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RetainedLifecycleImpl f7514a;

    public /* synthetic */ a(RetainedLifecycleImpl retainedLifecycleImpl) {
        this.f7514a = retainedLifecycleImpl;
    }

    public final void close() {
        this.f7514a.dispatchOnCleared();
    }
}
