package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.common.IRequestCallback;
import com.upuphone.xr.interconnect.util.HostAlienCallExtKt;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.upuphone.xr.interconnect.business.connect.DeviceConnectionLevelManager$informSuccess$1$1", f = "DeviceConnectionLevelManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DeviceConnectionLevelManager$informSuccess$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IRequestCallback $it;
    int label;
    final /* synthetic */ DeviceConnectionLevelManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceConnectionLevelManager$informSuccess$1$1(IRequestCallback iRequestCallback, DeviceConnectionLevelManager deviceConnectionLevelManager, Continuation<? super DeviceConnectionLevelManager$informSuccess$1$1> continuation) {
        super(2, continuation);
        this.$it = iRequestCallback;
        this.this$0 = deviceConnectionLevelManager;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DeviceConnectionLevelManager$informSuccess$1$1(this.$it, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            HostAlienCallExtKt.safeAlienCall(this.$it, this.this$0.getTag(), AnonymousClass1.INSTANCE);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DeviceConnectionLevelManager$informSuccess$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
