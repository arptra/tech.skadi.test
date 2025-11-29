package com.upuphone.xr.sapp.fragment;

import android.os.SystemClock;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.upuphone.xr.sapp.databinding.FragmentVoiceprintSepatateRoleRecordBinding;
import com.upuphone.xr.sapp.vm.RoleVprintViewModel;
import com.xjsd.xr.sapp.asr.dao.AsrResult;
import com.xjsd.xr.sapp.asr.dao.Src;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.VoiceprintSrRecordFragment$handleAsrResult$1", f = "VoiceprintSrRecordFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VoiceprintSrRecordFragment$handleAsrResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AsrResult $asrResult;
    int label;
    final /* synthetic */ VoiceprintSrRecordFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoiceprintSrRecordFragment$handleAsrResult$1(AsrResult asrResult, VoiceprintSrRecordFragment voiceprintSrRecordFragment, Continuation<? super VoiceprintSrRecordFragment$handleAsrResult$1> continuation) {
        super(2, continuation);
        this.$asrResult = asrResult;
        this.this$0 = voiceprintSrRecordFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VoiceprintSrRecordFragment$handleAsrResult$1(this.$asrResult, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Src src = this.$asrResult.getSrc();
            if (src != null) {
                VoiceprintSrRecordFragment voiceprintSrRecordFragment = this.this$0;
                voiceprintSrRecordFragment.q = SystemClock.elapsedRealtime();
                RoleVprintViewModel N0 = voiceprintSrRecordFragment.e1();
                FragmentVoiceprintSepatateRoleRecordBinding H0 = voiceprintSrRecordFragment.k;
                FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding = null;
                if (H0 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    H0 = null;
                }
                NestedScrollView nestedScrollView = H0.b.d;
                Intrinsics.checkNotNullExpressionValue(nestedScrollView, "svSpoken");
                FragmentVoiceprintSepatateRoleRecordBinding H02 = voiceprintSrRecordFragment.k;
                if (H02 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    H02 = null;
                }
                TextView textView = H02.b.f;
                Intrinsics.checkNotNullExpressionValue(textView, "tvSpoken");
                N0.O(nestedScrollView, textView, src.getContent(), src.getType());
                if (src.getType() == 0) {
                    FragmentVoiceprintSepatateRoleRecordBinding H03 = voiceprintSrRecordFragment.k;
                    if (H03 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    } else {
                        fragmentVoiceprintSepatateRoleRecordBinding = H03;
                    }
                    fragmentVoiceprintSepatateRoleRecordBinding.b.b.setEnabled(true);
                    voiceprintSrRecordFragment.e1().l0();
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VoiceprintSrRecordFragment$handleAsrResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
