package com.upuphone.xr.sapp.utils;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.upuphone.runasone.constant.Constants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rJ)\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/upuphone/xr/sapp/utils/DeviceHelper;", "", "<init>", "()V", "Landroidx/fragment/app/FragmentActivity;", "activity", "", "deviceId", "Lkotlin/Function1;", "", "", "callback", "a", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "b", "(Landroidx/fragment/app/FragmentActivity;Lkotlin/jvm/functions/Function1;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class DeviceHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final DeviceHelper f7878a = new DeviceHelper();

    public final void a(FragmentActivity fragmentActivity, String str, Function1 function1) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(function1, "callback");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(fragmentActivity), (CoroutineContext) null, (CoroutineStart) null, new DeviceHelper$unbindAirGlassWithAsk$1(fragmentActivity, str, function1, (Continuation<? super DeviceHelper$unbindAirGlassWithAsk$1>) null), 3, (Object) null);
    }

    public final void b(FragmentActivity fragmentActivity, Function1 function1) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Intrinsics.checkNotNullParameter(function1, "callback");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(fragmentActivity), (CoroutineContext) null, (CoroutineStart) null, new DeviceHelper$unbindViewWithAsk$1(fragmentActivity, function1, (Continuation<? super DeviceHelper$unbindViewWithAsk$1>) null), 3, (Object) null);
    }
}
