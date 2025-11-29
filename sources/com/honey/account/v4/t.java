package com.honey.account.v4;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment;

public final /* synthetic */ class t implements OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranscribeRecordFragment f5274a;

    public /* synthetic */ t(TranscribeRecordFragment transcribeRecordFragment) {
        this.f5274a = transcribeRecordFragment;
    }

    public final boolean a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        return TranscribeRecordFragment.initAdapter$lambda$6(this.f5274a, baseQuickAdapter, view, i);
    }
}
