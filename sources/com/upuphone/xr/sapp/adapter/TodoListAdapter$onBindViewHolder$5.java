package com.upuphone.xr.sapp.adapter;

import com.upuphone.xr.sapp.adapter.TodoListAdapter;
import com.upuphone.xr.sapp.view.MultiFuncEditText;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/upuphone/xr/sapp/adapter/TodoListAdapter$onBindViewHolder$5", "Lcom/upuphone/xr/sapp/view/MultiFuncEditText$OnEditTextCopiedListener;", "", "a", "()V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TodoListAdapter$onBindViewHolder$5 implements MultiFuncEditText.OnEditTextCopiedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TodoListAdapter f6627a;

    public TodoListAdapter$onBindViewHolder$5(TodoListAdapter todoListAdapter) {
        this.f6627a = todoListAdapter;
    }

    public void a() {
        TodoListAdapter.TodoListStateListener y = this.f6627a.y();
        if (y != null) {
            y.c();
        }
    }
}
