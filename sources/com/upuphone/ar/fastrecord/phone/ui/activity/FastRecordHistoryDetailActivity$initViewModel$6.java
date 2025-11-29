package com.upuphone.ar.fastrecord.phone.ui.activity;

import android.media.MediaPlayer;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/ar/fastrecord/phone/starrynet/bean/glass/RecordGlassStatus;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordHistoryDetailActivity$initViewModel$6 extends Lambda implements Function1<RecordGlassStatus, Unit> {
    final /* synthetic */ FastRecordHistoryDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordHistoryDetailActivity$initViewModel$6(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity) {
        super(1);
        this.this$0 = fastRecordHistoryDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RecordGlassStatus) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable RecordGlassStatus recordGlassStatus) {
        if (recordGlassStatus != null) {
            FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity = this.this$0;
            int state = recordGlassStatus.getState();
            LogExt.logW("recordIngStatus recordGlassStatus.state = " + state, "FastRecordHistoryDetailActivity");
            if (recordGlassStatus.getState() == 1 || recordGlassStatus.getState() == 4) {
                MediaPlayer access$getMMediaPlayer$p = fastRecordHistoryDetailActivity.mMediaPlayer;
                if (access$getMMediaPlayer$p != null) {
                    access$getMMediaPlayer$p.pause();
                }
                MediaPlayer access$getMMediaPlayer$p2 = fastRecordHistoryDetailActivity.mMediaPlayer;
                fastRecordHistoryDetailActivity.curPlayerPosition = access$getMMediaPlayer$p2 != null ? access$getMMediaPlayer$p2.getCurrentPosition() : 0;
                fastRecordHistoryDetailActivity.getViewModel().updatePlayState(false);
            }
        }
    }
}
