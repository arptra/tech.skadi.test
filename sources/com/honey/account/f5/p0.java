package com.honey.account.f5;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.upuphone.ar.translation.phone.fragment.ToDoFragment;

public final /* synthetic */ class p0 implements OnItemChildClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ToDoFragment f4399a;

    public /* synthetic */ p0(ToDoFragment toDoFragment) {
        this.f4399a = toDoFragment;
    }

    public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        ToDoFragment.T0(this.f4399a, baseQuickAdapter, view, i);
    }
}
