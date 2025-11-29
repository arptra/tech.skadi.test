package com.xjmz.myvu.modules.home;

import com.upuphone.xr.sapp.utils.DataTrackUtil;
import com.upuphone.xr.sapp.utils.NpsUtils;
import com.xjmz.myvu.flutter.pigeon.AndroidBindingDeviceApi;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjmz.myvu.modules.home.HomeFragment$requestRingNpsExist$1$success$1", f = "HomeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class HomeFragment$requestRingNpsExist$1$success$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AndroidBindingDeviceApi.Ring2DeviceInfo $result;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragment$requestRingNpsExist$1$success$1(AndroidBindingDeviceApi.Ring2DeviceInfo ring2DeviceInfo, Continuation<? super HomeFragment$requestRingNpsExist$1$success$1> continuation) {
        super(2, continuation);
        this.$result = ring2DeviceInfo;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new HomeFragment$requestRingNpsExist$1$success$1(this.$result, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            DataTrackUtil dataTrackUtil = DataTrackUtil.f7875a;
            String b = this.$result.b();
            Intrinsics.checkNotNullExpressionValue(b, "getModel(...)");
            String c = this.$result.c();
            Intrinsics.checkNotNullExpressionValue(c, "getSn(...)");
            String d = this.$result.d();
            Intrinsics.checkNotNullExpressionValue(d, "getVersion(...)");
            dataTrackUtil.x(b, c, d);
            NpsUtils.b().g(String.valueOf(System.currentTimeMillis()), this.$result.b());
            NpsUtils.b().h(this.$result.b(), this.$result.c());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((HomeFragment$requestRingNpsExist$1$success$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
