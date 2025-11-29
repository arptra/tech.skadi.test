package com.honey.account.v4;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.upuphone.ar.transcribe.phone.activity.AiToDoFragment;

public final /* synthetic */ class d implements OnItemChildClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AiToDoFragment f5246a;

    public /* synthetic */ d(AiToDoFragment aiToDoFragment) {
        this.f5246a = aiToDoFragment;
    }

    public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        AiToDoFragment.initViews$lambda$1(this.f5246a, baseQuickAdapter, view, i);
    }
}
