package com.upuphone.xr.sapp.common;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/upuphone/xr/sapp/common/GlobalViewStoreOwner$bindLifecycle$1", "Landroidx/lifecycle/LifecycleEventObserver;", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GlobalViewStoreOwner$bindLifecycle$1 implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f6659a;

    public GlobalViewStoreOwner$bindLifecycle$1(String str) {
        this.f6659a = str;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            GlobalViewStoreOwner globalViewStoreOwner = GlobalViewStoreOwner.f6658a;
            if (globalViewStoreOwner.f(this.f6659a) <= 0) {
                globalViewStoreOwner.e();
            }
        } else if (event == Lifecycle.Event.ON_CREATE) {
            int unused = GlobalViewStoreOwner.f6658a.i(this.f6659a);
        }
    }
}
