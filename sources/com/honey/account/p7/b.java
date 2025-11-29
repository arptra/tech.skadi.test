package com.honey.account.p7;

import android.view.View;
import com.upuphone.xr.audio.record.ui.adpter.AudioRecordFeedBackViewAdapter;

public final /* synthetic */ class b implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AudioRecordFeedBackViewAdapter f5105a;
    public final /* synthetic */ AudioRecordFeedBackViewAdapter.FeedBackViewHolder b;

    public /* synthetic */ b(AudioRecordFeedBackViewAdapter audioRecordFeedBackViewAdapter, AudioRecordFeedBackViewAdapter.FeedBackViewHolder feedBackViewHolder) {
        this.f5105a = audioRecordFeedBackViewAdapter;
        this.b = feedBackViewHolder;
    }

    public final boolean onLongClick(View view) {
        return AudioRecordFeedBackViewAdapter.FeedBackViewHolder.d(this.f5105a, this.b, view);
    }
}
