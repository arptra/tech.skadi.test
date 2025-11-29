package com.honey.account.f5;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.upuphone.ar.translation.phone.fragment.TransRecordFragment;

public final /* synthetic */ class s0 implements OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TransRecordFragment f4405a;

    public /* synthetic */ s0(TransRecordFragment transRecordFragment) {
        this.f4405a = transRecordFragment;
    }

    public final boolean a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        return TransRecordFragment.C0(this.f4405a, baseQuickAdapter, view, i);
    }
}
