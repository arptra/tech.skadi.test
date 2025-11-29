package com.upuphone.xr.sapp.fragment;

import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.asm.Opcodes;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentFeedbackBinding;
import com.upuphone.xr.sapp.utils.GenericWindowManger;
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

@SourceDebugExtension({"SMAP\nFeedBackFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeedBackFragment.kt\ncom/upuphone/xr/sapp/fragment/FeedBackFragment$submitFeedBack$3\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,815:1\n256#2,2:816\n*S KotlinDebug\n*F\n+ 1 FeedBackFragment.kt\ncom/upuphone/xr/sapp/fragment/FeedBackFragment$submitFeedBack$3\n*L\n721#1:816,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.FeedBackFragment$submitFeedBack$3", f = "FeedBackFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FeedBackFragment$submitFeedBack$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $uploadResult;
    int label;
    final /* synthetic */ FeedBackFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedBackFragment$submitFeedBack$3(FeedBackFragment feedBackFragment, boolean z, Continuation<? super FeedBackFragment$submitFeedBack$3> continuation) {
        super(2, continuation);
        this.this$0 = feedBackFragment;
        this.$uploadResult = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedBackFragment$submitFeedBack$3(this.this$0, this.$uploadResult, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            GenericWindowManger.c.a().j(Opcodes.IF_ACMPEQ);
            FragmentFeedbackBinding N0 = this.this$0.j;
            if (N0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                N0 = null;
            }
            LinearLayout linearLayout = N0.q;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "submitSuccessLayout");
            linearLayout.setVisibility(this.$uploadResult ? 0 : 8);
            if (!this.$uploadResult) {
                UToast.Companion companion = UToast.f6444a;
                FragmentActivity requireActivity = this.this$0.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
                companion.b(requireActivity, R.string.status_transfer_fail);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedBackFragment$submitFeedBack$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
