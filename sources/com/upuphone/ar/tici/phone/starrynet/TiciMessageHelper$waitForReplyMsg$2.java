package com.upuphone.ar.tici.phone.starrynet;

import com.upuphone.ar.tici.phone.TiciApp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTiciMessageHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciMessageHelper.kt\ncom/upuphone/ar/tici/phone/starrynet/TiciMessageHelper$waitForReplyMsg$2\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,364:1\n314#2,11:365\n*S KotlinDebug\n*F\n+ 1 TiciMessageHelper.kt\ncom/upuphone/ar/tici/phone/starrynet/TiciMessageHelper$waitForReplyMsg$2\n*L\n335#1:365,11\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 176)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$waitForReplyMsg$2", f = "TiciMessageHelper.kt", i = {}, l = {365}, m = "invokeSuspend", n = {}, s = {})
public final class TiciMessageHelper$waitForReplyMsg$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {
    final /* synthetic */ String $replyAction;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciMessageHelper$waitForReplyMsg$2(String str, Continuation<? super TiciMessageHelper$waitForReplyMsg$2> continuation) {
        super(2, continuation);
        this.$replyAction = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.needClassReification();
        return new TiciMessageHelper$waitForReplyMsg$2(this.$replyAction, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = this.$replyAction;
            this.L$0 = str;
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
            cancellableContinuationImpl.x();
            Intrinsics.needClassReification();
            TiciMessageHelper$waitForReplyMsg$2$1$msgListener$1 ticiMessageHelper$waitForReplyMsg$2$1$msgListener$1 = new TiciMessageHelper$waitForReplyMsg$2$1$msgListener$1(str, cancellableContinuationImpl);
            TiciApp.b.q().getReceiveMsgHandler().c(str, ticiMessageHelper$waitForReplyMsg$2$1$msgListener$1);
            cancellableContinuationImpl.E(new TiciMessageHelper$waitForReplyMsg$2$1$1(str, ticiMessageHelper$waitForReplyMsg$2$1$msgListener$1));
            obj = cancellableContinuationImpl.u();
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            String str2 = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<Object> continuation) {
        return ((TiciMessageHelper$waitForReplyMsg$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
