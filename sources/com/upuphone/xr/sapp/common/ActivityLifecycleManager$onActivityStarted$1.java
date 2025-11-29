package com.upuphone.xr.sapp.common;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/upuphone/xr/sapp/common/ApplicationVisibilityCallback;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ActivityLifecycleManager$onActivityStarted$1 extends Lambda implements Function1<ApplicationVisibilityCallback, Unit> {
    public static final ActivityLifecycleManager$onActivityStarted$1 INSTANCE = new ActivityLifecycleManager$onActivityStarted$1();

    public ActivityLifecycleManager$onActivityStarted$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ApplicationVisibilityCallback) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ApplicationVisibilityCallback applicationVisibilityCallback) {
        Intrinsics.checkNotNullParameter(applicationVisibilityCallback, "$this$dispatchApplicationCallback");
        applicationVisibilityCallback.a();
    }
}
