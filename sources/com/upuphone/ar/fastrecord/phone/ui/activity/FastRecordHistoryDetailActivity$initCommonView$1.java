package com.upuphone.ar.fastrecord.phone.ui.activity;

import android.media.MediaPlayer;
import android.view.View;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.star.common.phone.UToast;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordHistoryDetailActivity$initCommonView$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ FastRecordHistoryDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordHistoryDetailActivity$initCommonView$1(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity) {
        super(1);
        this.this$0 = fastRecordHistoryDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        int i = 0;
        if (this.this$0.getViewModel().isPlayIng()) {
            MediaPlayer access$getMMediaPlayer$p = this.this$0.mMediaPlayer;
            if (access$getMMediaPlayer$p != null) {
                access$getMMediaPlayer$p.pause();
            }
            FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity = this.this$0;
            MediaPlayer access$getMMediaPlayer$p2 = fastRecordHistoryDetailActivity.mMediaPlayer;
            fastRecordHistoryDetailActivity.curPlayerPosition = access$getMMediaPlayer$p2 != null ? access$getMMediaPlayer$p2.getCurrentPosition() : 0;
            this.this$0.getViewModel().updatePlayState(false);
        } else if (FastRecordManager.Companion.getInstance().appViewModel().isRecordingDuring()) {
            LogExt.logE("ivPlayOrPause isRecordingDuring is true return", "FastRecordHistoryDetailActivity");
            UToast.f6444a.b(this.this$0, R.string.fast_record_recording_can_not_play);
            return;
        } else {
            this.this$0.playAndSetSpeed();
            MediaPlayer access$getMMediaPlayer$p3 = this.this$0.mMediaPlayer;
            if (access$getMMediaPlayer$p3 != null) {
                i = access$getMMediaPlayer$p3.getDuration();
            }
            if (1 <= i && i < 2001) {
                this.this$0.curPlayerPosition = (int) (((float) (Random.Default.nextInt(20, 90) * i)) / 100.0f);
            }
            int access$getCurPlayerPosition$p = this.this$0.curPlayerPosition;
            LogExt.logE("ivPlayOrPause play curPlayerPosition = " + access$getCurPlayerPosition$p + ",duration = " + i, "FastRecordHistoryDetailActivity");
            if (this.this$0.curPlayerPosition != 0) {
                MediaPlayer access$getMMediaPlayer$p4 = this.this$0.mMediaPlayer;
                if (access$getMMediaPlayer$p4 != null) {
                    access$getMMediaPlayer$p4.seekTo(this.this$0.curPlayerPosition);
                }
                FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity2 = this.this$0;
                fastRecordHistoryDetailActivity2.setRecordPlayTime((long) fastRecordHistoryDetailActivity2.curPlayerPosition);
            }
            this.this$0.getViewModel().updatePlayState(true);
            this.this$0.startUpdatePosition();
        }
        this.this$0.resetTagShow();
    }
}
