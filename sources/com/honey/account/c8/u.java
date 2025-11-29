package com.honey.account.c8;

import android.view.View;
import com.upuphone.xr.sapp.adapter.TodoListAdapter;
import com.upuphone.xr.sapp.adapter.VH;

public final /* synthetic */ class u implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TodoListAdapter f4225a;
    public final /* synthetic */ VH b;

    public /* synthetic */ u(TodoListAdapter todoListAdapter, VH vh) {
        this.f4225a = todoListAdapter;
        this.b = vh;
    }

    public final void onClick(View view) {
        TodoListAdapter.E(this.f4225a, this.b, view);
    }
}
