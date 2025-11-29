package com.upuphone.ar.transcribe.phone.activity;

import android.widget.LinearLayout;
import com.upuphone.ar.transcribe.databinding.ActivityTranscribeStartBinding;
import com.upuphone.xr.sapp.context.IPhoneCallStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nTranscribeStartActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranscribeStartActivity.kt\ncom/upuphone/ar/transcribe/phone/activity/TranscribeStartActivity$initListener$2\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,809:1\n262#2,2:810\n*S KotlinDebug\n*F\n+ 1 TranscribeStartActivity.kt\ncom/upuphone/ar/transcribe/phone/activity/TranscribeStartActivity$initListener$2\n*L\n300#1:810,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/context/IPhoneCallStatus;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranscribeStartActivity$initListener$2 extends Lambda implements Function1<IPhoneCallStatus, Unit> {
    final /* synthetic */ TranscribeStartActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranscribeStartActivity$initListener$2(TranscribeStartActivity transcribeStartActivity) {
        super(1);
        this.this$0 = transcribeStartActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IPhoneCallStatus) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(IPhoneCallStatus iPhoneCallStatus) {
        if (iPhoneCallStatus.getCallStatus() == 0) {
            ActivityTranscribeStartBinding access$getMBinding$p = this.this$0.mBinding;
            ActivityTranscribeStartBinding activityTranscribeStartBinding = null;
            if (access$getMBinding$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                access$getMBinding$p = null;
            }
            LinearLayout linearLayout = access$getMBinding$p.q;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "tipsContainer");
            linearLayout.setVisibility(8);
            ActivityTranscribeStartBinding access$getMBinding$p2 = this.this$0.mBinding;
            if (access$getMBinding$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                access$getMBinding$p2 = null;
            }
            access$getMBinding$p2.c.setEnabled(true);
            ActivityTranscribeStartBinding access$getMBinding$p3 = this.this$0.mBinding;
            if (access$getMBinding$p3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                activityTranscribeStartBinding = access$getMBinding$p3;
            }
            activityTranscribeStartBinding.x.setEnabled(true);
            this.this$0.mCurrentTransType = 1;
        }
    }
}
