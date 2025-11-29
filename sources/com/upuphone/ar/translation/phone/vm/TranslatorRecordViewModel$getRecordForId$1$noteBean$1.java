package com.upuphone.ar.translation.phone.vm;

import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.helper.TranslatorLitePalHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$getRecordForId$1$noteBean$1", f = "TranslatorRecordViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TranslatorRecordViewModel$getRecordForId$1$noteBean$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super NoteBean>, Object> {
    final /* synthetic */ long $recordId;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorRecordViewModel$getRecordForId$1$noteBean$1(long j, Continuation<? super TranslatorRecordViewModel$getRecordForId$1$noteBean$1> continuation) {
        super(2, continuation);
        this.$recordId = j;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslatorRecordViewModel$getRecordForId$1$noteBean$1(this.$recordId, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return TranslatorLitePalHelper.f6309a.f(this.$recordId);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super NoteBean> continuation) {
        return ((TranslatorRecordViewModel$getRecordForId$1$noteBean$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
