package com.honey.account.v4;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.upuphone.ar.transcribe.phone.activity.TranscribeSearchActivity;

public final /* synthetic */ class a0 implements OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranscribeSearchActivity f5242a;

    public /* synthetic */ a0(TranscribeSearchActivity transcribeSearchActivity) {
        this.f5242a = transcribeSearchActivity;
    }

    public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        TranscribeSearchActivity.initViews$lambda$2(this.f5242a, baseQuickAdapter, view, i);
    }
}
