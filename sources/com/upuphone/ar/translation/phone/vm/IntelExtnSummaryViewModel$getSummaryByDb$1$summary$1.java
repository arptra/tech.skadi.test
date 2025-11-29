package com.upuphone.ar.translation.phone.vm;

import com.upuphone.ar.translation.phone.bean.IntelExtnSummary;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.helper.TranslatorDbHelper;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/upuphone/ar/translation/phone/bean/IntelExtnSummary;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.IntelExtnSummaryViewModel$getSummaryByDb$1$summary$1", f = "IntelExtnSummaryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class IntelExtnSummaryViewModel$getSummaryByDb$1$summary$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super IntelExtnSummary>, Object> {
    final /* synthetic */ NoteBean $noteBean;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntelExtnSummaryViewModel$getSummaryByDb$1$summary$1(NoteBean noteBean, Continuation<? super IntelExtnSummaryViewModel$getSummaryByDb$1$summary$1> continuation) {
        super(2, continuation);
        this.$noteBean = noteBean;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new IntelExtnSummaryViewModel$getSummaryByDb$1$summary$1(this.$noteBean, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return TranslatorDbHelper.f6307a.a().b(this.$noteBean.getAccountId(), this.$noteBean.getRecognizeId());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super IntelExtnSummary> continuation) {
        return ((IntelExtnSummaryViewModel$getSummaryByDb$1$summary$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
