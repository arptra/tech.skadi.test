package com.honey.account.c8;

import android.view.View;
import com.upuphone.xr.sapp.adapter.TodoItem;
import com.upuphone.xr.sapp.adapter.TodoListAdapter;

public final /* synthetic */ class a0 implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TodoItem f4201a;
    public final /* synthetic */ TodoListAdapter b;

    public /* synthetic */ a0(TodoItem todoItem, TodoListAdapter todoListAdapter) {
        this.f4201a = todoItem;
        this.b = todoListAdapter;
    }

    public final void onFocusChange(View view, boolean z) {
        TodoListAdapter.C(this.f4201a, this.b, view, z);
    }
}
