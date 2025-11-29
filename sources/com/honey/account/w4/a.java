package com.honey.account.w4;

import android.view.View;
import com.upuphone.ar.transcribe.phone.adapter.AiTodoAdapter;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AiTodoAdapter f5288a;

    public /* synthetic */ a(AiTodoAdapter aiTodoAdapter) {
        this.f5288a = aiTodoAdapter;
    }

    public final void onClick(View view) {
        AiTodoAdapter.AiReminderItemProvider.v(this.f5288a, view);
    }
}
