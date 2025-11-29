package com.upuphone.ar.tici.phone.starrynet;

import com.google.gson.reflect.TypeToken;
import com.upuphone.ar.tici.phone.TiciApp;
import com.upuphone.ar.tici.phone.utils.JsonUtils;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTiciMessageHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciMessageHelper.kt\ncom/upuphone/ar/tici/phone/starrynet/TiciMessageHelper$waitForReplyMsg$2\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,364:1\n314#2,11:365\n*S KotlinDebug\n*F\n+ 1 TiciMessageHelper.kt\ncom/upuphone/ar/tici/phone/starrynet/TiciMessageHelper$waitForReplyMsg$2\n*L\n335#1:365,11\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H@¨\u0006\u0003"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;", "com/upuphone/ar/tici/phone/starrynet/TiciMessageHelper$waitForReplyMsg$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$waitForReplyMsg$2", f = "TiciMessageHelper.kt", i = {}, l = {365}, m = "invokeSuspend", n = {}, s = {})
public final class TiciStarryMsgManager$waitForGlassTiciStarted$1$invokeSuspend$$inlined$waitForReplyMsg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $replyAction;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciStarryMsgManager$waitForGlassTiciStarted$1$invokeSuspend$$inlined$waitForReplyMsg$1(String str, Continuation continuation) {
        super(2, continuation);
        this.$replyAction = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciStarryMsgManager$waitForGlassTiciStarted$1$invokeSuspend$$inlined$waitForReplyMsg$1(this.$replyAction, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final String str = this.$replyAction;
            this.L$0 = str;
            this.label = 1;
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
            cancellableContinuationImpl.x();
            final AnonymousClass1 r2 = new Function1<BaseActionMsg, Unit>() {
                public void a(BaseActionMsg baseActionMsg) {
                    Object obj;
                    Intrinsics.checkNotNullParameter(baseActionMsg, "actionMsg");
                    JsonUtils jsonUtils = JsonUtils.f5992a;
                    String value = baseActionMsg.getValue();
                    Type type = new TypeToken<Unit>() {
                    }.getType();
                    if (Intrinsics.areEqual((Object) type, (Object) Unit.INSTANCE.getClass()) || Intrinsics.areEqual((Object) type, (Object) Void.class)) {
                        Intrinsics.checkNotNull(type);
                        obj = jsonUtils.a("{}", type);
                    } else {
                        Intrinsics.checkNotNull(type);
                        obj = jsonUtils.a(value, type);
                    }
                    TiciApp.b.q().getReceiveMsgHandler().s(str, this);
                    if (cancellableContinuationImpl.isActive()) {
                        cancellableContinuationImpl.resumeWith(Result.m20constructorimpl(obj));
                    }
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((BaseActionMsg) obj);
                    return Unit.INSTANCE;
                }
            };
            TiciApp.b.q().getReceiveMsgHandler().c(str, r2);
            cancellableContinuationImpl.E(new Function1<Throwable, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Throwable th) {
                    TiciApp.b.q().getReceiveMsgHandler().s(str, r2);
                }
            });
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
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciStarryMsgManager$waitForGlassTiciStarted$1$invokeSuspend$$inlined$waitForReplyMsg$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
