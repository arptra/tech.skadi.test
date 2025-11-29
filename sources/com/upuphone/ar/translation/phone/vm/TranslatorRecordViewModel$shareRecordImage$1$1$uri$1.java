package com.upuphone.ar.translation.phone.vm;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.upuphone.ar.translation.ext.ContextExtKt;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.databinding.ShareTransRecordMarkBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Landroid/net/Uri;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$shareRecordImage$1$1$uri$1", f = "TranslatorRecordViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TranslatorRecordViewModel$shareRecordImage$1$1$uri$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Uri>, Object> {
    final /* synthetic */ NoteBean $noteBean;
    final /* synthetic */ RecyclerView $recyclerView;
    final /* synthetic */ Activity $this_run;
    final /* synthetic */ View $view;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorRecordViewModel$shareRecordImage$1$1$uri$1(NoteBean noteBean, Activity activity, RecyclerView recyclerView, View view, Continuation<? super TranslatorRecordViewModel$shareRecordImage$1$1$uri$1> continuation) {
        super(2, continuation);
        this.$noteBean = noteBean;
        this.$this_run = activity;
        this.$recyclerView = recyclerView;
        this.$view = view;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslatorRecordViewModel$shareRecordImage$1$1$uri$1(this.$noteBean, this.$this_run, this.$recyclerView, this.$view, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$noteBean.getXrType() != 1) {
                Activity activity = this.$this_run;
                RecyclerView recyclerView = this.$recyclerView;
                ConstraintLayout b = ShareTransRecordMarkBinding.c(activity.getLayoutInflater()).getRoot();
                Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
                return ContextExtKt.P(activity, recyclerView, ContextExtKt.b(b, this.$this_run));
            } else if (this.$noteBean.getTransType() == 3) {
                Activity activity2 = this.$this_run;
                RecyclerView recyclerView2 = this.$recyclerView;
                ConstraintLayout b2 = ShareTransRecordMarkBinding.c(activity2.getLayoutInflater()).getRoot();
                Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
                return ContextExtKt.P(activity2, recyclerView2, ContextExtKt.b(b2, this.$this_run));
            } else {
                Activity activity3 = this.$this_run;
                View view = this.$view;
                ConstraintLayout b3 = ShareTransRecordMarkBinding.c(activity3.getLayoutInflater()).getRoot();
                Intrinsics.checkNotNullExpressionValue(b3, "getRoot(...)");
                return ContextExtKt.O(activity3, view, ContextExtKt.b(b3, this.$this_run));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Uri> continuation) {
        return ((TranslatorRecordViewModel$shareRecordImage$1$1$uri$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
