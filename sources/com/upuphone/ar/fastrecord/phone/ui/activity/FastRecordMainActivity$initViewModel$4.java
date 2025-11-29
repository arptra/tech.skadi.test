package com.upuphone.ar.fastrecord.phone.ui.activity;

import com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/ar/fastrecord/phone/starrynet/bean/glass/RecordGlassStatus;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordMainActivity$initViewModel$4 extends Lambda implements Function1<RecordGlassStatus, Unit> {
    final /* synthetic */ FastRecordMainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordMainActivity$initViewModel$4(FastRecordMainActivity fastRecordMainActivity) {
        super(1);
        this.this$0 = fastRecordMainActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RecordGlassStatus) obj);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: type inference failed for: r3v4, types: [java.lang.Long] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.Nullable com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassStatus r11) {
        /*
            r10 = this;
            if (r11 == 0) goto L_0x00ea
            com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordMainActivity r10 = r10.this$0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "recordIngStatus recordGlassStatus.state = "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "FastRecordMainActivity"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logW(r0, r1)
            int r0 = r11.getState()
            r2 = 2
            if (r0 == r2) goto L_0x00cc
            r2 = 5
            if (r0 == r2) goto L_0x00cc
            com.upuphone.ar.fastrecord.databinding.FastRecordMainActivityBinding r0 = r10.getLayout()
            com.upuphone.ar.fastrecord.databinding.FastRecordBottomCommandLayoutBinding r0 = r0.d
            android.widget.ImageView r0 = r0.b
            java.lang.String r2 = "TAG_DO_NOT_START"
            r0.setTag(r2)
            com.upuphone.ar.fastrecord.databinding.FastRecordMainActivityBinding r0 = r10.getLayout()
            com.upuphone.ar.fastrecord.databinding.FastRecordBottomCommandLayoutBinding r0 = r0.d
            android.widget.ImageView r0 = r0.b
            int r2 = com.upuphone.ar.fastrecord.R.drawable.ic_fast_record_stop_btn
            android.graphics.drawable.Drawable r2 = androidx.core.content.ContextCompat.getDrawable(r10, r2)
            r0.setImageDrawable(r2)
            int r0 = r11.getState()
            r2 = 1
            r3 = 0
            if (r0 != r2) goto L_0x0066
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel r0 = r10.viewModel
            if (r0 != 0) goto L_0x0057
            java.lang.String r0 = "viewModel"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto L_0x0058
        L_0x0057:
            r3 = r0
        L_0x0058:
            long r0 = r11.getId()
            com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordMainActivity$initViewModel$4$1$1 r2 = new com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordMainActivity$initViewModel$4$1$1
            r2.<init>(r10, r11)
            r3.checkIsNewRecordItem(r0, r2)
            goto L_0x00ea
        L_0x0066:
            int r0 = r11.getState()
            r2 = 3
            if (r0 != r2) goto L_0x00ea
            com.upuphone.ar.fastrecord.phone.utils.RecordDataSaveUtil r0 = com.upuphone.ar.fastrecord.phone.utils.RecordDataSaveUtil.INSTANCE
            com.upuphone.ar.fastrecord.phone.bean.CacheAmplitudeInfo r2 = r0.getRecordAmplitudeForDetail()
            long r4 = r0.getNeedToDetailAfterConnect()
            if (r2 == 0) goto L_0x0081
            long r6 = r2.getRecordId()
            java.lang.Long r3 = java.lang.Long.valueOf(r6)
        L_0x0081:
            long r6 = r11.getId()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "recordIngStatus needToDetail = "
            r8.append(r9)
            r8.append(r4)
            java.lang.String r9 = " cacheAudioAmp record id = "
            r8.append(r9)
            r8.append(r3)
            java.lang.String r3 = " ,cur id = "
            r8.append(r3)
            r8.append(r6)
            java.lang.String r3 = r8.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logW(r3, r1)
            if (r2 == 0) goto L_0x00ea
            long r1 = r2.getRecordId()
            long r6 = r11.getId()
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 != 0) goto L_0x00ea
            long r1 = r11.getId()
            int r1 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x00ea
            long r1 = r11.getId()
            r10.gotoRecordIngDetail(r1)
            r10 = -1
            r0.setNeedToDetailAfterConnect(r10)
            goto L_0x00ea
        L_0x00cc:
            com.upuphone.ar.fastrecord.databinding.FastRecordMainActivityBinding r11 = r10.getLayout()
            com.upuphone.ar.fastrecord.databinding.FastRecordBottomCommandLayoutBinding r11 = r11.d
            android.widget.ImageView r11 = r11.b
            java.lang.String r0 = "tag_start"
            r11.setTag(r0)
            com.upuphone.ar.fastrecord.databinding.FastRecordMainActivityBinding r11 = r10.getLayout()
            com.upuphone.ar.fastrecord.databinding.FastRecordBottomCommandLayoutBinding r11 = r11.d
            android.widget.ImageView r11 = r11.b
            int r0 = com.upuphone.ar.fastrecord.R.drawable.ic_fast_record_play_btn
            android.graphics.drawable.Drawable r10 = androidx.core.content.ContextCompat.getDrawable(r10, r0)
            r11.setImageDrawable(r10)
        L_0x00ea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordMainActivity$initViewModel$4.invoke(com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassStatus):void");
    }
}
