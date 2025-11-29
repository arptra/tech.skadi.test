package com.upuphone.ar.tici.phone;

import com.upuphone.ar.tici.phone.starrynet.msg.CheckTiciStateReply;
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
@DebugMetadata(c = "com.upuphone.ar.tici.phone.TiciMainActivity$initViewModels$15", f = "TiciMainActivity.kt", i = {}, l = {425}, m = "invokeSuspend", n = {}, s = {})
public final class TiciMainActivity$initViewModels$15 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TiciMainActivity this$0;

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/ar/tici/phone/starrynet/msg/CheckTiciStateReply;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.ar.tici.phone.TiciMainActivity$initViewModels$15$1", f = "TiciMainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.ar.tici.phone.TiciMainActivity$initViewModels$15$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CheckTiciStateReply, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(ticiMainActivity, continuation);
            r0.L$0 = obj;
            return r0;
        }

        @Nullable
        public final Object invoke(@NotNull CheckTiciStateReply checkTiciStateReply, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(checkTiciStateReply, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ticiMainActivity.E1((CheckTiciStateReply) this.L$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciMainActivity$initViewModels$15(TiciMainActivity ticiMainActivity, Continuation<? super TiciMainActivity$initViewModels$15> continuation) {
        super(2, continuation);
        this.this$0 = ticiMainActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciMainActivity$initViewModels$15(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SharedFlow E = this.this$0.d.E();
            final TiciMainActivity ticiMainActivity = this.this$0;
            Flow L = FlowKt.L(E, new AnonymousClass1((Continuation<? super AnonymousClass1>) null));
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
        return ((TiciMainActivity$initViewModels$15) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
