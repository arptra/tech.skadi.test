package com.honey.account.c8;

import android.view.View;
import com.upuphone.xr.sapp.adapter.TodoListAdapter;
import com.upuphone.xr.sapp.adapter.VH;

public final /* synthetic */ class y implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TodoListAdapter f4229a;
    public final /* synthetic */ VH b;

    public /* synthetic */ y(TodoListAdapter todoListAdapter, VH vh) {
        this.f4229a = todoListAdapter;
        this.b = vh;
    }

    public final void onClick(View view) {
        TodoListAdapter.G(this.f4229a, this.b, view);
    }
}
