package com.upuphone.xr.sapp.vu.arspace;

import com.google.gson.Gson;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.permission.PermissionHelper;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.upuphone.xr.sapp.vu.VuTouchpadActivity;
import com.upuphone.xr.sapp.vu.monitor.VuWeatherMonitor;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.arspace.ArSpaceBridgerImpl$requestData$1", f = "ArSpaceBridgerImpl.kt", i = {}, l = {392}, m = "invokeSuspend", n = {}, s = {})
public final class ArSpaceBridgerImpl$requestData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ArSpaceBridgerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArSpaceBridgerImpl$requestData$1(ArSpaceBridgerImpl arSpaceBridgerImpl, Continuation<? super ArSpaceBridgerImpl$requestData$1> continuation) {
        super(2, continuation);
        this.this$0 = arSpaceBridgerImpl;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ArSpaceBridgerImpl$requestData$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PermissionHelper permissionHelper = PermissionHelper.f7819a;
            MainApplication.Companion companion = MainApplication.k;
            if (!permissionHelper.n(companion.f(), new String[]{"android.permission.ACCESS_COARSE_LOCATION"}) || PermissionAndStateCheckUtils.f7907a.f(companion.f())) {
                VuWeatherMonitor access$getWeatherMonitor$p = this.this$0.weatherMonitor;
                this.label = 1;
                obj = access$getWeatherMonitor$p.f(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                VuTouchpadActivity b = VuTouchpadActivity.w.b();
                if (b != null) {
                    b.D1();
                }
                return Unit.INSTANCE;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Pair pair = (Pair) obj;
        String json = new Gson().toJson(pair.getSecond());
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("ArSpaceBridgerImpl", "requestData: " + json);
        try {
            IOnDataResultListener access$getPendingWeatherListener$p = this.this$0.pendingWeatherListener;
            if (access$getPendingWeatherListener$p != null) {
                access$getPendingWeatherListener$p.onResult(VuiModelType.WEATHER, ((Number) pair.getFirst()).intValue(), json);
            }
        } catch (Exception e) {
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.c("ArSpaceBridgerImpl", "requestData: " + e);
        }
        this.this$0.pendingWeatherListener = null;
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ArSpaceBridgerImpl$requestData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
