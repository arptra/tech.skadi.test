package com.honey.account.d5;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.upuphone.ar.translation.phone.activity.TranslatorSearchActivity;

public final /* synthetic */ class t implements OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranslatorSearchActivity f4326a;

    public /* synthetic */ t(TranslatorSearchActivity translatorSearchActivity) {
        this.f4326a = translatorSearchActivity;
    }

    public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        TranslatorSearchActivity.initRecordList$lambda$2$lambda$1(this.f4326a, baseQuickAdapter, view, i);
    }
}
