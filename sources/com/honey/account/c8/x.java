package com.honey.account.c8;

import android.widget.CompoundButton;
import com.upuphone.xr.sapp.adapter.TodoListAdapter;
import com.xjsd.ai.assistant.phone.vui.todo.TodoEntry;

public final /* synthetic */ class x implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TodoEntry f4228a;

    public /* synthetic */ x(TodoEntry todoEntry) {
        this.f4228a = todoEntry;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        TodoListAdapter.F(this.f4228a, compoundButton, z);
    }
}
