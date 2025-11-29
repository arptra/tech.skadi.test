package com.upuphone.ar.fastrecord.phone.ui.activity;

import com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nFastRecordIngDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordIngDetailActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordIngDetailActivity$initViewModel$2\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,152:1\n262#2,2:153\n262#2,2:155\n*S KotlinDebug\n*F\n+ 1 FastRecordIngDetailActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordIngDetailActivity$initViewModel$2\n*L\n95#1:153,2\n107#1:155,2\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/ar/fastrecord/phone/starrynet/bean/glass/RecordGlassStatus;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordIngDetailActivity$initViewModel$2 extends Lambda implements Function1<RecordGlassStatus, Unit> {
    final /* synthetic */ FastRecordIngDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordIngDetailActivity$initViewModel$2(FastRecordIngDetailActivity fastRecordIngDetailActivity) {
        super(1);
        this.this$0 = fastRecordIngDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RecordGlassStatus) obj);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0032, code lost:
        if (r0 != 5) goto L_0x00c7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.Nullable com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassStatus r4) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x00ce
            com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordIngDetailActivity r3 = r3.this$0
            int r0 = r4.getState()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "recordIngStatus recordGlassStatus.state = "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "FastRecordIngDetailActivity"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logW(r0, r1)
            int r0 = r4.getState()
            r1 = 1
            java.lang.String r2 = "tvRecordResume"
            if (r0 == r1) goto L_0x0090
            r1 = 2
            if (r0 == r1) goto L_0x006d
            r1 = 3
            if (r0 == r1) goto L_0x0036
            r1 = 4
            if (r0 == r1) goto L_0x0090
            r1 = 5
            if (r0 == r1) goto L_0x006d
            goto L_0x00c7
        L_0x0036:
            com.upuphone.ar.fastrecord.databinding.FastRecordDuringDetailActivityBinding r0 = r3.getLayout()
            com.upuphone.ar.fastrecord.databinding.FastRecordDuringDetailBottomLayoutBinding r0 = r0.b
            android.widget.ImageView r0 = r0.c
            java.lang.String r1 = "TAG_RESUME"
            r0.setTag(r1)
            com.upuphone.ar.fastrecord.databinding.FastRecordDuringDetailActivityBinding r0 = r3.getLayout()
            com.upuphone.ar.fastrecord.databinding.FastRecordDuringDetailBottomLayoutBinding r0 = r0.b
            android.widget.TextView r0 = r0.d
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r1 = 0
            r0.setVisibility(r1)
            com.upuphone.ar.fastrecord.databinding.FastRecordDuringDetailActivityBinding r0 = r3.getLayout()
            com.upuphone.ar.fastrecord.databinding.FastRecordDuringDetailBottomLayoutBinding r0 = r0.b
            android.widget.ImageView r0 = r0.c
            int r1 = com.upuphone.ar.fastrecord.R.drawable.ic_fast_record_detail_resume_center
            android.graphics.drawable.Drawable r1 = androidx.core.content.ContextCompat.getDrawable(r3, r1)
            r0.setImageDrawable(r1)
            com.upuphone.ar.fastrecord.databinding.FastRecordDuringDetailActivityBinding r0 = r3.getLayout()
            com.upuphone.ar.fastrecord.phone.ui.widget.RecordIngDetailSoundVisualizerView r0 = r0.f
            r0.stopVisualizing()
            goto L_0x00c7
        L_0x006d:
            com.upuphone.ar.fastrecord.databinding.FastRecordDuringDetailActivityBinding r0 = r3.getLayout()
            com.upuphone.ar.fastrecord.phone.ui.widget.RecordIngDetailSoundVisualizerView r0 = r0.f
            r0.stopVisualizing()
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.recording.FastRecordDetailRecordIngViewModel r0 = r3.viewModel
            if (r0 != 0) goto L_0x0083
            java.lang.String r0 = "viewModel"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = 0
        L_0x0083:
            int r1 = r4.getState()
            com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordIngDetailActivity$initViewModel$2$1$1 r2 = new com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordIngDetailActivity$initViewModel$2$1$1
            r2.<init>(r3)
            r0.changeRecordFinishState(r1, r2)
            goto L_0x00c7
        L_0x0090:
            com.upuphone.ar.fastrecord.databinding.FastRecordDuringDetailActivityBinding r0 = r3.getLayout()
            com.upuphone.ar.fastrecord.databinding.FastRecordDuringDetailBottomLayoutBinding r0 = r0.b
            android.widget.TextView r0 = r0.d
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r1 = 8
            r0.setVisibility(r1)
            com.upuphone.ar.fastrecord.databinding.FastRecordDuringDetailActivityBinding r0 = r3.getLayout()
            com.upuphone.ar.fastrecord.databinding.FastRecordDuringDetailBottomLayoutBinding r0 = r0.b
            android.widget.ImageView r0 = r0.c
            java.lang.String r1 = "TAG_PAUSE"
            r0.setTag(r1)
            com.upuphone.ar.fastrecord.databinding.FastRecordDuringDetailActivityBinding r0 = r3.getLayout()
            com.upuphone.ar.fastrecord.databinding.FastRecordDuringDetailBottomLayoutBinding r0 = r0.b
            android.widget.ImageView r0 = r0.c
            int r1 = com.upuphone.ar.fastrecord.R.drawable.ic_fast_record_pause_btn
            android.graphics.drawable.Drawable r1 = androidx.core.content.ContextCompat.getDrawable(r3, r1)
            r0.setImageDrawable(r1)
            com.upuphone.ar.fastrecord.databinding.FastRecordDuringDetailActivityBinding r0 = r3.getLayout()
            com.upuphone.ar.fastrecord.phone.ui.widget.RecordIngDetailSoundVisualizerView r0 = r0.f
            r0.startVisualizing()
        L_0x00c7:
            long r0 = r4.getId()
            r3.finishPageWhenRecordIdChange(r0)
        L_0x00ce:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordIngDetailActivity$initViewModel$2.invoke(com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassStatus):void");
    }
}
