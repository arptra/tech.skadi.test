package com.upuphone.ar.tici.phone.starrynet;

import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.ar.tici.phone.utils.ConstantsKt;
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
@DebugMetadata(c = "com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager$sendOpenAppMsgAndWait$1", f = "TiciStarryMsgManager.kt", i = {}, l = {432}, m = "invokeSuspend", n = {}, s = {})
public final class TiciStarryMsgManager$sendOpenAppMsgAndWait$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $waitTime;
    int label;
    final /* synthetic */ TiciStarryMsgManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciStarryMsgManager$sendOpenAppMsgAndWait$1(long j, TiciStarryMsgManager ticiStarryMsgManager, Continuation<? super TiciStarryMsgManager$sendOpenAppMsgAndWait$1> continuation) {
        super(2, continuation);
        this.$waitTime = j;
        this.this$0 = ticiStarryMsgManager;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciStarryMsgManager$sendOpenAppMsgAndWait$1(this.$waitTime, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CommonExtKt.e("sendOpenAppMsgAndWait-> start wait", "TiciStarryMsgManager");
            long j = this.$waitTime;
            this.label = 1;
            if (DelayKt.b(j, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        CommonExtKt.e("sendOpenAppMsgAndWait-> wait timeout", "TiciStarryMsgManager");
        this.this$0.dispatchOpenTiciResult(ConstantsKt.h());
        this.this$0.cancelPendingJob();
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciStarryMsgManager$sendOpenAppMsgAndWait$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
