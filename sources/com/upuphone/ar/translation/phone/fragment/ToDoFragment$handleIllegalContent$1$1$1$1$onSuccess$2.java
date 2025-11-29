package com.upuphone.ar.translation.phone.fragment;

import android.widget.TextView;
import com.upuphone.ar.translation.phone.databinding.FragmentToDoBinding;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nToDoFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ToDoFragment.kt\ncom/upuphone/ar/translation/phone/fragment/ToDoFragment$handleIllegalContent$1$1$1$1$onSuccess$2\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,817:1\n262#2,2:818\n*S KotlinDebug\n*F\n+ 1 ToDoFragment.kt\ncom/upuphone/ar/translation/phone/fragment/ToDoFragment$handleIllegalContent$1$1$1$1$onSuccess$2\n*L\n764#1:818,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.fragment.ToDoFragment$handleIllegalContent$1$1$1$1$onSuccess$2", f = "ToDoFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ToDoFragment$handleIllegalContent$1$1$1$1$onSuccess$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ToDoFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToDoFragment$handleIllegalContent$1$1$1$1$onSuccess$2(ToDoFragment toDoFragment, Continuation<? super ToDoFragment$handleIllegalContent$1$1$1$1$onSuccess$2> continuation) {
        super(2, continuation);
        this.this$0 = toDoFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ToDoFragment$handleIllegalContent$1$1$1$1$onSuccess$2(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FragmentToDoBinding m0 = this.this$0.f6287a;
            FragmentToDoBinding fragmentToDoBinding = null;
            if (m0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                m0 = null;
            }
            m0.j.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
            FragmentToDoBinding m02 = this.this$0.f6287a;
            if (m02 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                fragmentToDoBinding = m02;
            }
            TextView textView = fragmentToDoBinding.k;
            Intrinsics.checkNotNullExpressionValue(textView, "tvOuterReported");
            textView.setVisibility(0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ToDoFragment$handleIllegalContent$1$1$1$1$onSuccess$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
