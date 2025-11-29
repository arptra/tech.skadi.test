package com.honey.account.w4;

import android.view.View;
import android.widget.CheckBox;
import com.upuphone.ar.transcribe.phone.adapter.AiTodoAdapter;
import com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AiTodoAdapter f5289a;
    public final /* synthetic */ int b;
    public final /* synthetic */ AiTodoEntity c;
    public final /* synthetic */ CheckBox d;

    public /* synthetic */ b(AiTodoAdapter aiTodoAdapter, int i, AiTodoEntity aiTodoEntity, CheckBox checkBox) {
        this.f5289a = aiTodoAdapter;
        this.b = i;
        this.c = aiTodoEntity;
        this.d = checkBox;
    }

    public final void onClick(View view) {
        AiTodoAdapter.TodoItemProvider.x(this.f5289a, this.b, this.c, this.d, view);
    }
}
