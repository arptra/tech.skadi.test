package com.upuphone.ar.transcribe.phone.vm;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.vm.TranscribeEditViewModel$changeModel$1", f = "TranscribeEditViewModel.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
public final class TranscribeEditViewModel$changeModel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $edit;
    int label;
    final /* synthetic */ TranscribeEditViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranscribeEditViewModel$changeModel$1(TranscribeEditViewModel transcribeEditViewModel, boolean z, Continuation<? super TranscribeEditViewModel$changeModel$1> continuation) {
        super(2, continuation);
        this.this$0 = transcribeEditViewModel;
        this.$edit = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranscribeEditViewModel$changeModel$1(this.this$0, this.$edit, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableSharedFlow l = this.this$0.l();
            Boolean boxBoolean = Boxing.boxBoolean(this.$edit);
            this.label = 1;
            if (l.emit(boxBoolean, this) == coroutine_suspended) {
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
        return ((TranscribeEditViewModel$changeModel$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
