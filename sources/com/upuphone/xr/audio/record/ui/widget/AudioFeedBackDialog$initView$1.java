package com.upuphone.xr.audio.record.ui.widget;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.audio.record.ui.adpter.AudioRecordFeedBackViewAdapter;
import com.upuphone.xr.sapp.audio.record.databinding.AudioRecordFeedBackDialogBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/upuphone/xr/audio/record/ui/widget/AudioFeedBackDialog$initView$1", "Lcom/upuphone/xr/audio/record/ui/adpter/AudioRecordFeedBackViewAdapter$ItemClickListener;", "", "position", "", "onItemClick", "(I)V", "onLongClick", "lib_audio_record_release"}, k = 1, mv = {1, 9, 0})
public final class AudioFeedBackDialog$initView$1 implements AudioRecordFeedBackViewAdapter.ItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AudioFeedBackDialog f6566a;

    public AudioFeedBackDialog$initView$1(AudioFeedBackDialog audioFeedBackDialog) {
        this.f6566a = audioFeedBackDialog;
    }

    public void onItemClick(int i) {
        ULog.f6446a.c("AudioFeedBackDialog", "onItemClick position");
        AudioRecordFeedBackViewAdapter m0 = this.f6566a.b;
        AudioRecordFeedBackDialogBinding audioRecordFeedBackDialogBinding = null;
        if (m0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            m0 = null;
        }
        m0.k(i);
        AudioRecordFeedBackDialogBinding l0 = this.f6566a.f6565a;
        if (l0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            l0 = null;
        }
        l0.c.setAlpha(1.0f);
        AudioRecordFeedBackDialogBinding l02 = this.f6566a.f6565a;
        if (l02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            audioRecordFeedBackDialogBinding = l02;
        }
        audioRecordFeedBackDialogBinding.c.setClickable(true);
    }

    public void onLongClick(int i) {
    }
}
