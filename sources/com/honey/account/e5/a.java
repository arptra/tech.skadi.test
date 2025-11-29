package com.honey.account.e5;

import android.view.View;
import android.widget.CheckBox;
import com.upuphone.ar.translation.phone.adapter.IntelExtnTodoAdapter;
import com.upuphone.ar.translation.phone.bean.IntelExtnTodo;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IntelExtnTodoAdapter f4350a;
    public final /* synthetic */ int b;
    public final /* synthetic */ IntelExtnTodo c;
    public final /* synthetic */ CheckBox d;

    public /* synthetic */ a(IntelExtnTodoAdapter intelExtnTodoAdapter, int i, IntelExtnTodo intelExtnTodo, CheckBox checkBox) {
        this.f4350a = intelExtnTodoAdapter;
        this.b = i;
        this.c = intelExtnTodo;
        this.d = checkBox;
    }

    public final void onClick(View view) {
        IntelExtnTodoAdapter.TodoItemProvider.v(this.f4350a, this.b, this.c, this.d, view);
    }
}
