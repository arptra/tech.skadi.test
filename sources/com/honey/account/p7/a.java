package com.honey.account.p7;

import android.view.View;
import com.upuphone.xr.audio.record.ui.adpter.AudioRecordFeedBackViewAdapter;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AudioRecordFeedBackViewAdapter f5104a;
    public final /* synthetic */ AudioRecordFeedBackViewAdapter.FeedBackViewHolder b;

    public /* synthetic */ a(AudioRecordFeedBackViewAdapter audioRecordFeedBackViewAdapter, AudioRecordFeedBackViewAdapter.FeedBackViewHolder feedBackViewHolder) {
        this.f5104a = audioRecordFeedBackViewAdapter;
        this.b = feedBackViewHolder;
    }

    public final void onClick(View view) {
        AudioRecordFeedBackViewAdapter.FeedBackViewHolder.c(this.f5104a, this.b, view);
    }
}
