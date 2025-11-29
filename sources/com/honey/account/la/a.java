package com.honey.account.la;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.xjsd.ai.assistant.phone.session.interceptor.AbsInterceptor;

public final /* synthetic */ class a implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbsInterceptor f7460a;

    public /* synthetic */ a(AbsInterceptor absInterceptor) {
        this.f7460a = absInterceptor;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        AbsInterceptor.e(this.f7460a, lifecycleOwner, event);
    }
}
