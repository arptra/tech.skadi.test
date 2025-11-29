package com.upuphone.ar.transcribe.phone.vm;

import com.upuphone.ar.transcribe.phone.helper.TranscribeDBHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.vm.TranscribeEditViewModel$delete$1", f = "TranscribeEditViewModel.kt", i = {}, l = {26, 27}, m = "invokeSuspend", n = {}, s = {})
public final class TranscribeEditViewModel$delete$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TranscribeEditViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranscribeEditViewModel$delete$1(TranscribeEditViewModel transcribeEditViewModel, Continuation<? super TranscribeEditViewModel$delete$1> continuation) {
        super(2, continuation);
        this.this$0 = transcribeEditViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranscribeEditViewModel$delete$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TranscribeDBHelper.f6108a.e(CollectionsKt.toLongArray(this.this$0.f));
            this.this$0.f.clear();
            this.this$0.g = 0;
            this.this$0.w(false);
            MutableSharedFlow k = this.this$0.k();
            Boolean boxBoolean = Boxing.boxBoolean(true);
            this.label = 1;
            if (k.emit(boxBoolean, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        MutableSharedFlow l = this.this$0.l();
        Boolean boxBoolean2 = Boxing.boxBoolean(false);
        this.label = 2;
        if (l.emit(boxBoolean2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranscribeEditViewModel$delete$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
