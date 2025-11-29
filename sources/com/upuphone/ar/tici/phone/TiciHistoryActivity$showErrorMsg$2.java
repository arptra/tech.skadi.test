package com.upuphone.ar.tici.phone;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTiciHistoryActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciHistoryActivity.kt\ncom/upuphone/ar/tici/phone/TiciHistoryActivity$showErrorMsg$2\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,547:1\n262#2,2:548\n*S KotlinDebug\n*F\n+ 1 TiciHistoryActivity.kt\ncom/upuphone/ar/tici/phone/TiciHistoryActivity$showErrorMsg$2\n*L\n525#1:548,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.TiciHistoryActivity$showErrorMsg$2", f = "TiciHistoryActivity.kt", i = {}, l = {524}, m = "invokeSuspend", n = {}, s = {})
public final class TiciHistoryActivity$showErrorMsg$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TiciHistoryActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciHistoryActivity$showErrorMsg$2(TiciHistoryActivity ticiHistoryActivity, Continuation<? super TiciHistoryActivity$showErrorMsg$2> continuation) {
        super(2, continuation);
        this.this$0 = ticiHistoryActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciHistoryActivity$showErrorMsg$2(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.b(3000, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ConstraintLayout b = this.this$0.X0().c.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        b.setVisibility(8);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciHistoryActivity$showErrorMsg$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
