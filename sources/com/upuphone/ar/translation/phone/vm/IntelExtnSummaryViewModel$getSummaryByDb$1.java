package com.upuphone.ar.translation.phone.vm;

import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.bean.IntelExtnSummary;
import com.upuphone.ar.translation.phone.bean.NoteBean;
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
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.IntelExtnSummaryViewModel$getSummaryByDb$1", f = "IntelExtnSummaryViewModel.kt", i = {}, l = {146}, m = "invokeSuspend", n = {}, s = {})
public final class IntelExtnSummaryViewModel$getSummaryByDb$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NoteBean $noteBean;
    int label;
    final /* synthetic */ IntelExtnSummaryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntelExtnSummaryViewModel$getSummaryByDb$1(IntelExtnSummaryViewModel intelExtnSummaryViewModel, NoteBean noteBean, Continuation<? super IntelExtnSummaryViewModel$getSummaryByDb$1> continuation) {
        super(2, continuation);
        this.this$0 = intelExtnSummaryViewModel;
        this.$noteBean = noteBean;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new IntelExtnSummaryViewModel$getSummaryByDb$1(this.this$0, this.$noteBean, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher b = Dispatchers.b();
            IntelExtnSummaryViewModel$getSummaryByDb$1$summary$1 intelExtnSummaryViewModel$getSummaryByDb$1$summary$1 = new IntelExtnSummaryViewModel$getSummaryByDb$1$summary$1(this.$noteBean, (Continuation<? super IntelExtnSummaryViewModel$getSummaryByDb$1$summary$1>) null);
            this.label = 1;
            obj = BuildersKt.g(b, intelExtnSummaryViewModel$getSummaryByDb$1$summary$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        IntelExtnSummary intelExtnSummary = (IntelExtnSummary) obj;
        LogExt.j("getSummaryByDb summary=" + intelExtnSummary, "IntelExtnSummaryViewModel");
        this.this$0.d.setValue(intelExtnSummary);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((IntelExtnSummaryViewModel$getSummaryByDb$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
