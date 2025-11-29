package com.upuphone.xr.sapp.common;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/app/Application$ActivityLifecycleCallbacks;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ActivityLifecycleManager$onActivitySaveInstanceState$1 extends Lambda implements Function1<Application.ActivityLifecycleCallbacks, Unit> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Bundle $outState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActivityLifecycleManager$onActivitySaveInstanceState$1(Activity activity, Bundle bundle) {
        super(1);
        this.$activity = activity;
        this.$outState = bundle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Application.ActivityLifecycleCallbacks) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        Intrinsics.checkNotNullParameter(activityLifecycleCallbacks, "$this$dispatchCallback");
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.$activity, this.$outState);
    }
}
