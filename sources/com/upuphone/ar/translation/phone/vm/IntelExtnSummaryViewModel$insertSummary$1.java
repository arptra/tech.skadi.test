package com.upuphone.ar.translation.phone.vm;

import androidx.lifecycle.MutableLiveData;
import com.upuphone.ar.translation.ext.AnyExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.bean.IntelExtnSummary;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.IntelExtnSummaryViewModel$insertSummary$1", f = "IntelExtnSummaryViewModel.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
public final class IntelExtnSummaryViewModel$insertSummary$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IntelExtnSummary $summary;
    int label;
    final /* synthetic */ IntelExtnSummaryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntelExtnSummaryViewModel$insertSummary$1(IntelExtnSummaryViewModel intelExtnSummaryViewModel, IntelExtnSummary intelExtnSummary, Continuation<? super IntelExtnSummaryViewModel$insertSummary$1> continuation) {
        super(2, continuation);
        this.this$0 = intelExtnSummaryViewModel;
        this.$summary = intelExtnSummary;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new IntelExtnSummaryViewModel$insertSummary$1(this.this$0, this.$summary, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher b = Dispatchers.b();
            IntelExtnSummaryViewModel$insertSummary$1$ids$1 intelExtnSummaryViewModel$insertSummary$1$ids$1 = new IntelExtnSummaryViewModel$insertSummary$1$ids$1(this.$summary, (Continuation<? super IntelExtnSummaryViewModel$insertSummary$1$ids$1>) null);
            this.label = 1;
            obj = BuildersKt.g(b, intelExtnSummaryViewModel$insertSummary$1$ids$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List list = (List) obj;
        LogExt.j("insertSummary summaryId=" + list, "IntelExtnSummaryViewModel");
        if (!list.isEmpty()) {
            MutableLiveData d = this.this$0.d;
            Object a2 = AnyExtKt.a(this.$summary, IntelExtnSummary.class);
            IntelExtnSummary intelExtnSummary = (IntelExtnSummary) a2;
            intelExtnSummary.setId(((Number) list.get(0)).longValue());
            LogExt.j("insertSummary summary=" + intelExtnSummary, "IntelExtnSummaryViewModel");
            d.setValue(a2);
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((IntelExtnSummaryViewModel$insertSummary$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
