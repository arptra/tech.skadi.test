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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.interconnect.business.connect.DeviceConnectionLevelManager$informFail$1$1", f = "DeviceConnectionLevelManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DeviceConnectionLevelManager$informFail$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $code;
    final /* synthetic */ IRequestCallback $it;
    final /* synthetic */ String $message;
    int label;
    final /* synthetic */ DeviceConnectionLevelManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceConnectionLevelManager$informFail$1$1(IRequestCallback iRequestCallback, DeviceConnectionLevelManager deviceConnectionLevelManager, int i, String str, Continuation<? super DeviceConnectionLevelManager$informFail$1$1> continuation) {
        super(2, continuation);
        this.$it = iRequestCallback;
        this.this$0 = deviceConnectionLevelManager;
        this.$code = i;
        this.$message = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DeviceConnectionLevelManager$informFail$1$1(this.$it, this.this$0, this.$code, this.$message, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            IRequestCallback iRequestCallback = this.$it;
            String access$getTag = this.this$0.getTag();
            final int i = this.$code;
            final String str = this.$message;
            HostAlienCallExtKt.safeAlienCall(iRequestCallback, access$getTag, new Function1<IRequestCallback, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((IRequestCallback) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull IRequestCallback iRequestCallback) {
                    Intrinsics.checkNotNullParameter(iRequestCallback, "$this$safeAlienCall");
                    iRequestCallback.onFail(i, str);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DeviceConnectionLevelManager$informFail$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
