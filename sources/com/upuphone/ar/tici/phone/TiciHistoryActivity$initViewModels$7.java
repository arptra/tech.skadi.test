package com.upuphone.ar.tici.phone;

import com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyV3;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.TiciHistoryActivity$initViewModels$7", f = "TiciHistoryActivity.kt", i = {}, l = {216}, m = "invokeSuspend", n = {}, s = {})
public final class TiciHistoryActivity$initViewModels$7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TiciHistoryActivity this$0;

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsgReplyV3;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.ar.tici.phone.TiciHistoryActivity$initViewModels$7$1", f = "TiciHistoryActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.ar.tici.phone.TiciHistoryActivity$initViewModels$7$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<OpenTiciMsgReplyV3, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(ticiHistoryActivity, continuation);
            r0.L$0 = obj;
            return r0;
        }

        @Nullable
        public final Object invoke(@NotNull OpenTiciMsgReplyV3 openTiciMsgReplyV3, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(openTiciMsgReplyV3, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ticiHistoryActivity.g1((OpenTiciMsgReplyV3) this.L$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciHistoryActivity$initViewModels$7(TiciHistoryActivity ticiHistoryActivity, Continuation<? super TiciHistoryActivity$initViewModels$7> continuation) {
        super(2, continuation);
        this.this$0 = ticiHistoryActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciHistoryActivity$initViewModels$7(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SharedFlow N = this.this$0.d.N();
            final TiciHistoryActivity ticiHistoryActivity = this.this$0;
            Flow L = FlowKt.L(N, new AnonymousClass1((Continuation<? super AnonymousClass1>) null));
            this.label = 1;
            if (FlowKt.j(L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciHistoryActivity$initViewModels$7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
