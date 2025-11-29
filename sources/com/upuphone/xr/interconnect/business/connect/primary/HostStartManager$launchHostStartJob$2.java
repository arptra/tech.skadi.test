package com.upuphone.xr.interconnect.business.connect.primary;

import com.upuphone.xr.interconnect.util.ServiceExt;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.interconnect.business.connect.primary.HostStartManager$launchHostStartJob$2", f = "HostStartManager.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
public final class HostStartManager$launchHostStartJob$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ String $logTag;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HostStartManager$launchHostStartJob$2(String str, String str2, Continuation<? super HostStartManager$launchHostStartJob$2> continuation) {
        super(2, continuation);
        this.$logTag = str;
        this.$deviceId = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new HostStartManager$launchHostStartJob$2(this.$logTag, this.$deviceId, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0 || i == 1) {
            ResultKt.throwOnFailure(obj);
            do {
                ILog.d(this.$logTag, "Starting remote host.");
                ServiceExt.INSTANCE.startPhoneService(this.$deviceId);
                this.label = 1;
            } while (DelayKt.b(5000, this) != coroutine_suspended);
            return coroutine_suspended;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((HostStartManager$launchHostStartJob$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
