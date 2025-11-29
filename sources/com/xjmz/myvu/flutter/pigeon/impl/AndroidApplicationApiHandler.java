package com.xjmz.myvu.flutter.pigeon.impl;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.upuphone.star.core.log.ULog;
import com.xjmz.myvu.flutter.pigeon.AndroidApplicationApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/AndroidApplicationApiHandler;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidApplicationApi$ApplicationApi;", "<init>", "()V", "Lcom/xjmz/myvu/flutter/pigeon/AndroidApplicationApi$ApplicationState;", "d", "()Lcom/xjmz/myvu/flutter/pigeon/AndroidApplicationApi$ApplicationState;", "a", "Lcom/xjmz/myvu/flutter/pigeon/AndroidApplicationApi$ApplicationState;", "currentState", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AndroidApplicationApiHandler implements AndroidApplicationApi.ApplicationApi {

    /* renamed from: a  reason: collision with root package name */
    public AndroidApplicationApi.ApplicationState f8342a = AndroidApplicationApi.ApplicationState.ACTIVE;

    public AndroidApplicationApiHandler() {
        ProcessLifecycleOwner.i.a().getLifecycle().a(new DefaultLifecycleObserver(this) {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AndroidApplicationApiHandler f8343a;

            {
                this.f8343a = r1;
            }

            public void onStart(LifecycleOwner lifecycleOwner) {
                Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
                ULog.f6446a.g("AndroidApplicationApiHandler", "onStart");
                this.f8343a.f8342a = AndroidApplicationApi.ApplicationState.ACTIVE;
            }

            public void onStop(LifecycleOwner lifecycleOwner) {
                Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
                ULog.f6446a.g("AndroidApplicationApiHandler", "onStop");
                this.f8343a.f8342a = AndroidApplicationApi.ApplicationState.BACKGROUND;
            }
        });
    }

    public AndroidApplicationApi.ApplicationState d() {
        ULog.Delegate delegate = ULog.f6446a;
        AndroidApplicationApi.ApplicationState applicationState = this.f8342a;
        delegate.g("AndroidApplicationApiHandler", "currentApplicationState: " + applicationState);
        return this.f8342a;
    }
}
