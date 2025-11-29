package com.upuphone.xr.sapp.fragment;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentVoiceprintSepatateRoleRecordBinding;
import com.upuphone.xr.sapp.view.SappTitleBar;
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

@SourceDebugExtension({"SMAP\nVoiceprintSrRecordFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceprintSrRecordFragment.kt\ncom/upuphone/xr/sapp/fragment/VoiceprintSrRecordFragment$startRecordFailed$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,598:1\n256#2,2:599\n256#2,2:601\n*S KotlinDebug\n*F\n+ 1 VoiceprintSrRecordFragment.kt\ncom/upuphone/xr/sapp/fragment/VoiceprintSrRecordFragment$startRecordFailed$1\n*L\n330#1:599,2\n331#1:601,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.VoiceprintSrRecordFragment$startRecordFailed$1", f = "VoiceprintSrRecordFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VoiceprintSrRecordFragment$startRecordFailed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isNetworkError;
    int label;
    final /* synthetic */ VoiceprintSrRecordFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoiceprintSrRecordFragment$startRecordFailed$1(VoiceprintSrRecordFragment voiceprintSrRecordFragment, boolean z, Continuation<? super VoiceprintSrRecordFragment$startRecordFailed$1> continuation) {
        super(2, continuation);
        this.this$0 = voiceprintSrRecordFragment;
        this.$isNetworkError = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VoiceprintSrRecordFragment$startRecordFailed$1(this.this$0, this.$isNetworkError, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.m1("startRecordFailed isNetworkError=" + this.$isNetworkError);
            FragmentVoiceprintSepatateRoleRecordBinding H0 = this.this$0.k;
            FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding = null;
            if (H0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                H0 = null;
            }
            SappTitleBar sappTitleBar = H0.e;
            String string = this.this$0.getString(R.string.word_exit);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            sappTitleBar.setBackText(string);
            FragmentVoiceprintSepatateRoleRecordBinding H02 = this.this$0.k;
            if (H02 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                H02 = null;
            }
            ConstraintLayout b = H02.b.getRoot();
            Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
            b.setVisibility(8);
            FragmentVoiceprintSepatateRoleRecordBinding H03 = this.this$0.k;
            if (H03 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                fragmentVoiceprintSepatateRoleRecordBinding = H03;
            }
            ConstraintLayout b2 = fragmentVoiceprintSepatateRoleRecordBinding.d.getRoot();
            Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
            b2.setVisibility(0);
            FragmentActivity activity = this.this$0.getActivity();
            if (activity != null) {
                boolean z = this.$isNetworkError;
                VoiceprintSrRecordFragment voiceprintSrRecordFragment = this.this$0;
                if (z) {
                    voiceprintSrRecordFragment.e1().c0(activity);
                }
            }
            this.this$0.e1().a0(1);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VoiceprintSrRecordFragment$startRecordFailed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
