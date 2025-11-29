package com.honey.account.v4;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment;

public final /* synthetic */ class s implements OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranscribeRecordFragment f5272a;

    public /* synthetic */ s(TranscribeRecordFragment transcribeRecordFragment) {
        this.f5272a = transcribeRecordFragment;
    }

    public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        TranscribeRecordFragment.initAdapter$lambda$5(this.f5272a, baseQuickAdapter, view, i);
    }
}
