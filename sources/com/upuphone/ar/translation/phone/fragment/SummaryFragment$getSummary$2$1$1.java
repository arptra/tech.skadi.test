package com.upuphone.ar.translation.phone.fragment;

import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.helper.InterConnectHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.fragment.SummaryFragment$getSummary$2$1$1", f = "SummaryFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SummaryFragment$getSummary$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NoteBean $noteBean;
    final /* synthetic */ SummaryFragment $this_run;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SummaryFragment$getSummary$2$1$1(SummaryFragment summaryFragment, NoteBean noteBean, Continuation<? super SummaryFragment$getSummary$2$1$1> continuation) {
        super(2, continuation);
        this.$this_run = summaryFragment;
        this.$noteBean = noteBean;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SummaryFragment$getSummary$2$1$1(this.$this_run, this.$noteBean, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            InterConnectHelper a2 = InterConnectHelper.c.a();
            final SummaryFragment summaryFragment = this.$this_run;
            final NoteBean noteBean = this.$noteBean;
            a2.t(new Function1<Boolean, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    if (z) {
                        summaryFragment.y0(noteBean);
                    } else {
                        summaryFragment.N0(noteBean);
                    }
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SummaryFragment$getSummary$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
