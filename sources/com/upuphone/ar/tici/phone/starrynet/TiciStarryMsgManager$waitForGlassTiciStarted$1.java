package com.upuphone.ar.tici.phone.starrynet;

import com.upuphone.ar.tici.phone.data.OpenTiciConfig;
import com.upuphone.ar.tici.phone.data.OpenTiciConfigKt;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTiciStarryMsgManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciStarryMsgManager.kt\ncom/upuphone/ar/tici/phone/starrynet/TiciStarryMsgManager$waitForGlassTiciStarted$1\n+ 2 TiciMessageHelper.kt\ncom/upuphone/ar/tici/phone/starrynet/TiciMessageHelper\n*L\n1#1,728:1\n334#2:729\n*S KotlinDebug\n*F\n+ 1 TiciStarryMsgManager.kt\ncom/upuphone/ar/tici/phone/starrynet/TiciStarryMsgManager$waitForGlassTiciStarted$1\n*L\n315#1:729\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager$waitForGlassTiciStarted$1", f = "TiciStarryMsgManager.kt", i = {0}, l = {729}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class TiciStarryMsgManager$waitForGlassTiciStarted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $sendContentDelay;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TiciStarryMsgManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciStarryMsgManager$waitForGlassTiciStarted$1(long j, TiciStarryMsgManager ticiStarryMsgManager, Continuation<? super TiciStarryMsgManager$waitForGlassTiciStarted$1> continuation) {
        super(2, continuation);
        this.$sendContentDelay = j;
        this.this$0 = ticiStarryMsgManager;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TiciStarryMsgManager$waitForGlassTiciStarted$1 ticiStarryMsgManager$waitForGlassTiciStarted$1 = new TiciStarryMsgManager$waitForGlassTiciStarted$1(this.$sendContentDelay, this.this$0, continuation);
        ticiStarryMsgManager$waitForGlassTiciStarted$1.L$0 = obj;
        return ticiStarryMsgManager$waitForGlassTiciStarted$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            long j = this.$sendContentDelay;
            CommonExtKt.e("waitForGlassTiciStarted, start, delay: " + j, "TiciStarryMsgManager");
            TiciMessageHelper ticiMessageHelper = TiciMessageHelper.f5973a;
            long j2 = this.$sendContentDelay;
            TiciStarryMsgManager$waitForGlassTiciStarted$1$invokeSuspend$$inlined$waitForReplyMsg$1 ticiStarryMsgManager$waitForGlassTiciStarted$1$invokeSuspend$$inlined$waitForReplyMsg$1 = new TiciStarryMsgManager$waitForGlassTiciStarted$1$invokeSuspend$$inlined$waitForReplyMsg$1(BaseActionMsg.MSG_GLASS_TICI_STARTED, (Continuation) null);
            this.L$0 = coroutineScope;
            this.label = 1;
            if (TimeoutKt.c(j2, ticiStarryMsgManager$waitForGlassTiciStarted$1$invokeSuspend$$inlined$waitForReplyMsg$1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (TimeoutCancellationException e) {
                CommonExtKt.e("waitForGlassTiciStarted, timeout: " + e, "TiciStarryMsgManager");
            } catch (Exception e2) {
                CommonExtKt.e("waitForGlassTiciStarted, error: " + e2, "TiciStarryMsgManager");
                return Unit.INSTANCE;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        CommonExtKt.e("waitForGlassTiciStarted, end", "TiciStarryMsgManager");
        OpenTiciConfig access$getWaitingTiciConfig$p = this.this$0.waitingTiciConfig;
        if (access$getWaitingTiciConfig$p == null) {
            CommonExtKt.d("waitForGlassTiciStarted, waitingTiciConfig is null", "TiciStarryMsgManager", (Throwable) null, 2, (Object) null);
            return Unit.INSTANCE;
        }
        this.this$0.sendTiciContentPart(OpenTiciConfigKt.a(access$getWaitingTiciConfig$p), OpenTiciConfigKt.d(access$getWaitingTiciConfig$p), access$getWaitingTiciConfig$p.d().getTotalPart(), access$getWaitingTiciConfig$p.b());
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciStarryMsgManager$waitForGlassTiciStarted$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
