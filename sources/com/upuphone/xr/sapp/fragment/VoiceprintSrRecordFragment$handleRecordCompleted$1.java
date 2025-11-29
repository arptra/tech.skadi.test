package com.upuphone.xr.sapp.fragment;

import android.widget.TextView;
import com.meizu.common.widget.MzButton;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentVoiceprintSepatateRoleRecordBinding;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nVoiceprintSrRecordFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceprintSrRecordFragment.kt\ncom/upuphone/xr/sapp/fragment/VoiceprintSrRecordFragment$handleRecordCompleted$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,598:1\n256#2,2:599\n256#2,2:601\n*S KotlinDebug\n*F\n+ 1 VoiceprintSrRecordFragment.kt\ncom/upuphone/xr/sapp/fragment/VoiceprintSrRecordFragment$handleRecordCompleted$1\n*L\n400#1:599,2\n401#1:601,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.VoiceprintSrRecordFragment$handleRecordCompleted$1", f = "VoiceprintSrRecordFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VoiceprintSrRecordFragment$handleRecordCompleted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VoiceprintSrRecordFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoiceprintSrRecordFragment$handleRecordCompleted$1(VoiceprintSrRecordFragment voiceprintSrRecordFragment, Continuation<? super VoiceprintSrRecordFragment$handleRecordCompleted$1> continuation) {
        super(2, continuation);
        this.this$0 = voiceprintSrRecordFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VoiceprintSrRecordFragment$handleRecordCompleted$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FragmentVoiceprintSepatateRoleRecordBinding H0 = this.this$0.k;
            FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding = null;
            if (H0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                H0 = null;
            }
            TextView textView = H0.b.e;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%d s", Arrays.copyOf(new Object[]{Boxing.boxInt(this.this$0.n)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format);
            this.this$0.n1();
            if (this.this$0.n != 0) {
                return Unit.INSTANCE;
            }
            this.this$0.e1().m0();
            Job M0 = this.this$0.o;
            if (M0 != null) {
                Job.DefaultImpls.a(M0, (CancellationException) null, 1, (Object) null);
            }
            FragmentVoiceprintSepatateRoleRecordBinding H02 = this.this$0.k;
            if (H02 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                H02 = null;
            }
            H02.b.g.setText(this.this$0.getString(R.string.vp_separate_role_recording_completed));
            this.this$0.c1();
            FragmentVoiceprintSepatateRoleRecordBinding H03 = this.this$0.k;
            if (H03 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                H03 = null;
            }
            TextView textView2 = H03.b.e;
            Intrinsics.checkNotNullExpressionValue(textView2, "tvCountdown");
            textView2.setVisibility(8);
            FragmentVoiceprintSepatateRoleRecordBinding H04 = this.this$0.k;
            if (H04 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                fragmentVoiceprintSepatateRoleRecordBinding = H04;
            }
            MzButton mzButton = fragmentVoiceprintSepatateRoleRecordBinding.b.b;
            Intrinsics.checkNotNullExpressionValue(mzButton, "mbtNext");
            mzButton.setVisibility(0);
            this.this$0.e1().A();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VoiceprintSrRecordFragment$handleRecordCompleted$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
