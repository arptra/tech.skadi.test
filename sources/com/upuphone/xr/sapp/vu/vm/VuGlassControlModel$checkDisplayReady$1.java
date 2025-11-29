package com.upuphone.xr.sapp.vu.vm;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.vu.vm.VuGlassControlModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.vm.VuGlassControlModel$checkDisplayReady$1", f = "VuGlassControlModel.kt", i = {}, l = {316}, m = "invokeSuspend", n = {}, s = {})
public final class VuGlassControlModel$checkDisplayReady$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public VuGlassControlModel$checkDisplayReady$1(Continuation<? super VuGlassControlModel$checkDisplayReady$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VuGlassControlModel$checkDisplayReady$1(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long g = VuGlassControlModel.f8109a.r();
            this.label = 1;
            if (DelayKt.b(g, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        VuGlassControlModel.ViewGlassesInfo viewGlassesInfo = (VuGlassControlModel.ViewGlassesInfo) VuGlassControlModel.b.getValue();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuGlassControlModel", "checkDisplayReady: current glassInfo: " + viewGlassesInfo);
        if ((viewGlassesInfo != null ? viewGlassesInfo.c() : null) != null && viewGlassesInfo.a() == 0) {
            VuGlassControlModel.ViewGlassesInfo viewGlassesInfo2 = new VuGlassControlModel.ViewGlassesInfo(viewGlassesInfo.c(), -1, viewGlassesInfo.b(), 0, 0, 24, (DefaultConstructorMarker) null);
            VuGlassControlModel.b.postValue(viewGlassesInfo2);
            DataStoreUtils.e.a().o("vu_connected_view_glass", viewGlassesInfo2.m());
        }
        VuGlassControlModel.g = null;
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VuGlassControlModel$checkDisplayReady$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
