package com.honey.account.c8;

import android.widget.CompoundButton;
import com.upuphone.xr.sapp.adapter.TodoListAdapter;

public final /* synthetic */ class b0 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TodoListAdapter f4203a;

    public /* synthetic */ b0(TodoListAdapter todoListAdapter) {
        this.f4203a = todoListAdapter;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        TodoListAdapter.D(this.f4203a, compoundButton, z);
    }
}
