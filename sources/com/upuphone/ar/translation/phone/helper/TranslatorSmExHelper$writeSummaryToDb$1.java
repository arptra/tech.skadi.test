package com.upuphone.ar.translation.phone.helper;

import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.bean.IntelExtnSummary;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.dao.IntelExtnSummaryDao;
import com.xjsd.xr.sapp.asr.dao.SmartExSummary;
import java.util.List;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.helper.TranslatorSmExHelper$writeSummaryToDb$1", f = "TranslatorSmExHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TranslatorSmExHelper$writeSummaryToDb$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NoteBean $noteBean;
    final /* synthetic */ SmartExSummary $resSummary;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorSmExHelper$writeSummaryToDb$1(SmartExSummary smartExSummary, NoteBean noteBean, Continuation<? super TranslatorSmExHelper$writeSummaryToDb$1> continuation) {
        super(2, continuation);
        this.$resSummary = smartExSummary;
        this.$noteBean = noteBean;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslatorSmExHelper$writeSummaryToDb$1(this.$resSummary, this.$noteBean, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String summary = this.$resSummary.getSummary();
            IntelExtnSummaryDao a2 = TranslatorDbHelper.f6307a.a();
            IntelExtnSummary intelExtnSummary = new IntelExtnSummary();
            NoteBean noteBean = this.$noteBean;
            SmartExSummary smartExSummary = this.$resSummary;
            intelExtnSummary.setAccountId(noteBean.getAccountId());
            intelExtnSummary.setRecognizeId(noteBean.getRecognizeId());
            intelExtnSummary.setSummary(summary);
            intelExtnSummary.setOriginalSummary(summary);
            intelExtnSummary.setRequestId(smartExSummary.getRequestId());
            Unit unit = Unit.INSTANCE;
            List a3 = a2.a(intelExtnSummary);
            LogExt.j("writeSummaryToDb success ids=" + a3, "TranslatorSmExHelper");
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranslatorSmExHelper$writeSummaryToDb$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
