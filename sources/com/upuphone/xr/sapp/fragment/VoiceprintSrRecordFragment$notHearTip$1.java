package com.upuphone.xr.sapp.fragment;

import android.os.SystemClock;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentVoiceprintSepatateRoleRecordBinding;
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
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.VoiceprintSrRecordFragment$notHearTip$1", f = "VoiceprintSrRecordFragment.kt", i = {}, l = {434}, m = "invokeSuspend", n = {}, s = {})
public final class VoiceprintSrRecordFragment$notHearTip$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VoiceprintSrRecordFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoiceprintSrRecordFragment$notHearTip$1(VoiceprintSrRecordFragment voiceprintSrRecordFragment, Continuation<? super VoiceprintSrRecordFragment$notHearTip$1> continuation) {
        super(2, continuation);
        this.this$0 = voiceprintSrRecordFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VoiceprintSrRecordFragment$notHearTip$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Vibrator O0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding = null;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (SystemClock.elapsedRealtime() - this.this$0.q < 5000 || this.this$0.n == 0 || this.this$0.n == 20) {
                return Unit.INSTANCE;
            }
            this.this$0.q = SystemClock.elapsedRealtime();
            FragmentVoiceprintSepatateRoleRecordBinding H0 = this.this$0.k;
            if (H0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                H0 = null;
            }
            H0.b.g.setText(this.this$0.getString(R.string.vp_separate_role_no_valid_audio_tip));
            VibrationEffect createOneShot = VibrationEffect.createOneShot(1000, 1);
            VoiceprintSrRecordFragment voiceprintSrRecordFragment = this.this$0;
            if (voiceprintSrRecordFragment.s && (O0 = voiceprintSrRecordFragment.r) != null) {
                O0.vibrate(createOneShot);
            }
            this.label = 1;
            if (DelayKt.b(1000, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        FragmentVoiceprintSepatateRoleRecordBinding H02 = this.this$0.k;
        if (H02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentVoiceprintSepatateRoleRecordBinding = H02;
        }
        fragmentVoiceprintSepatateRoleRecordBinding.b.g.setText(this.this$0.getString(R.string.vp_separate_role_spoken_word_tip));
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VoiceprintSrRecordFragment$notHearTip$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
