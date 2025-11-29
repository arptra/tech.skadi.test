package com.upuphone.ar.translation.phone.vm;

import com.upuphone.ar.translation.phone.bean.NoteBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$getRecordForId$1", f = "TranslatorRecordViewModel.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
public final class TranslatorRecordViewModel$getRecordForId$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<NoteBean, Unit> $callback;
    final /* synthetic */ long $recordId;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorRecordViewModel$getRecordForId$1(Function1<? super NoteBean, Unit> function1, long j, Continuation<? super TranslatorRecordViewModel$getRecordForId$1> continuation) {
        super(2, continuation);
        this.$callback = function1;
        this.$recordId = j;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslatorRecordViewModel$getRecordForId$1(this.$callback, this.$recordId, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher b = Dispatchers.b();
            TranslatorRecordViewModel$getRecordForId$1$noteBean$1 translatorRecordViewModel$getRecordForId$1$noteBean$1 = new TranslatorRecordViewModel$getRecordForId$1$noteBean$1(this.$recordId, (Continuation<? super TranslatorRecordViewModel$getRecordForId$1$noteBean$1>) null);
            this.label = 1;
            obj = BuildersKt.g(b, translatorRecordViewModel$getRecordForId$1$noteBean$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$callback.invoke((NoteBean) obj);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranslatorRecordViewModel$getRecordForId$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
