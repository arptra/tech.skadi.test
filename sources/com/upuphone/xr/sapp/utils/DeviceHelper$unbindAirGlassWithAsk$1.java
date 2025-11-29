package com.upuphone.xr.sapp.utils;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.asm.Opcodes;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.datatrack.ReminderDataTrackEvent;
import com.upuphone.xr.sapp.glass.GlassUpdateHelper;
import com.upuphone.xr.sapp.permission.PermissionHelper;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.GenericWindowResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.utils.DeviceHelper$unbindAirGlassWithAsk$1", f = "DeviceHelper.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
public final class DeviceHelper$unbindAirGlassWithAsk$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ String $deviceId;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceHelper$unbindAirGlassWithAsk$1(FragmentActivity fragmentActivity, String str, Function1<? super Boolean, Unit> function1, Continuation<? super DeviceHelper$unbindAirGlassWithAsk$1> continuation) {
        super(2, continuation);
        this.$activity = fragmentActivity;
        this.$deviceId = str;
        this.$callback = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DeviceHelper$unbindAirGlassWithAsk$1(this.$activity, this.$deviceId, this.$callback, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (GlassUpdateHelper.b.c0(this.$activity)) {
                ULog.f6446a.a("DeviceHelper", "unbindAirGlassWithAsk, glass is updating");
                return Unit.INSTANCE;
            } else if (AppUpdateHelper.f7841a.u()) {
                ULog.f6446a.a("DeviceHelper", "unbindAirGlassWithAsk, app need update");
                return Unit.INSTANCE;
            } else {
                Boolean bool = BuildConfig.b;
                Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
                if (bool.booleanValue()) {
                    if (OSHelper.f7904a.d()) {
                        if (!PermissionHelper.f7819a.n(this.$activity, PermissionAndStateCheckUtils.f7907a.A())) {
                            ULog.f6446a.a("DeviceHelper", "unbindAirGlassWithAsk, no location permission");
                            ContextExtKt.e(R.string.permission_reminder_title_location, 0, 2, (Object) null);
                            return Unit.INSTANCE;
                        }
                    } else if (!PermissionHelper.f7819a.n(this.$activity, PermissionAndStateCheckUtils.f7907a.z())) {
                        ULog.f6446a.a("DeviceHelper", "unbindAirGlassWithAsk, no bluetooth permission");
                        ContextExtKt.e(R.string.permission_reminder_title_bluetooth, 0, 2, (Object) null);
                        return Unit.INSTANCE;
                    }
                }
                DataStoreUtils.Companion companion = DataStoreUtils.e;
                int intValue = ((Number) DataStoreUtils.i(companion.a(), "unpair_times", Boxing.boxInt(1), (Context) null, 4, (Object) null)).intValue();
                DataTrackUtil.f7875a.i(ReminderDataTrackEvent.APP_GLASSES_SETTING, MapsKt.mapOf(TuplesKt.to("unpair_times", String.valueOf(intValue))));
                companion.a().o("unpair_times", Boxing.boxInt(intValue + 1));
                FragmentActivity fragmentActivity = this.$activity;
                this.label = 1;
                obj = GenericWindowExtKt.b(fragmentActivity, Opcodes.DCMPL, (Object) null, true, true, this, 2, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        GenericWindowResult.ButtonAction buttonAction = (GenericWindowResult.ButtonAction) obj;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("DeviceHelper", "unbindAirGlassWithAsk, dialogResult: " + buttonAction);
        if (buttonAction.getActionType() == 1101) {
            boolean X = StaticMethodUtilsKt.X(this.$deviceId);
            delegate.a("DeviceHelper", "unbindAirGlassWithAsk, result: " + X);
            this.$callback.invoke(Boxing.boxBoolean(X));
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DeviceHelper$unbindAirGlassWithAsk$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
