package com.upuphone.ar.tici.phone.viewmodel;

import com.upuphone.ar.tici.phone.TiciApp;
import com.upuphone.ar.tici.phone.data.TiciHistory;
import com.upuphone.ar.tici.phone.db.TiciDBHelper;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
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
@DebugMetadata(c = "com.upuphone.ar.tici.phone.viewmodel.TiciHistoryViewModel$deleteTiciHistory$1", f = "TiciHistoryViewModel.kt", i = {}, l = {57, 60}, m = "invokeSuspend", n = {}, s = {})
public final class TiciHistoryViewModel$deleteTiciHistory$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TiciHistory $ticiHistory;
    int label;
    final /* synthetic */ TiciHistoryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciHistoryViewModel$deleteTiciHistory$1(TiciHistory ticiHistory, TiciHistoryViewModel ticiHistoryViewModel, Continuation<? super TiciHistoryViewModel$deleteTiciHistory$1> continuation) {
        super(2, continuation);
        this.$ticiHistory = ticiHistory;
        this.this$0 = ticiHistoryViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciHistoryViewModel$deleteTiciHistory$1(this.$ticiHistory, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TiciHistory ticiHistory = this.$ticiHistory;
            CommonExtKt.e("deleteTiciHistory, " + ticiHistory, "TiciHistoryViewModel");
            TiciDBHelper ticiDBHelper = TiciDBHelper.f5925a;
            long id = this.$ticiHistory.getId();
            this.label = 1;
            if (ticiDBHelper.b(id, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            TiciApp.b.c().A0(this.$ticiHistory.getId());
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (this.this$0.e.remove(this.$ticiHistory)) {
            TiciHistoryViewModel ticiHistoryViewModel = this.this$0;
            List e = ticiHistoryViewModel.e;
            this.label = 2;
            if (ticiHistoryViewModel.h(e, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        TiciApp.b.c().A0(this.$ticiHistory.getId());
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciHistoryViewModel$deleteTiciHistory$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
