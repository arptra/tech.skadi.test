package com.upuphone.ar.tici.phone;

import com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyV2;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.TiciAppViewModel$handleOpenResultV2$1", f = "TiciAppViewModel.kt", i = {}, l = {667}, m = "invokeSuspend", n = {}, s = {})
public final class TiciAppViewModel$handleOpenResultV2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OpenTiciMsgReplyV2 $openTiciMsgReply;
    int label;
    final /* synthetic */ TiciAppViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciAppViewModel$handleOpenResultV2$1(TiciAppViewModel ticiAppViewModel, OpenTiciMsgReplyV2 openTiciMsgReplyV2, Continuation<? super TiciAppViewModel$handleOpenResultV2$1> continuation) {
        super(2, continuation);
        this.this$0 = ticiAppViewModel;
        this.$openTiciMsgReply = openTiciMsgReplyV2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciAppViewModel$handleOpenResultV2$1(this.this$0, this.$openTiciMsgReply, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableSharedFlow p = this.this$0.w;
            OpenTiciMsgReplyV2 openTiciMsgReplyV2 = this.$openTiciMsgReply;
            this.label = 1;
            if (p.emit(openTiciMsgReplyV2, this) == coroutine_suspended) {
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
        return ((TiciAppViewModel$handleOpenResultV2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
