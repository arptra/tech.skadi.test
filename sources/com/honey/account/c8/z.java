package com.honey.account.c8;

import android.view.View;
import com.upuphone.xr.sapp.adapter.TodoListAdapter;

public final /* synthetic */ class z implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TodoListAdapter f4230a;

    public /* synthetic */ z(TodoListAdapter todoListAdapter) {
        this.f4230a = todoListAdapter;
    }

    public final boolean onLongClick(View view) {
        return TodoListAdapter.B(this.f4230a, view);
    }
}
