package com.honey.account.v3;

import android.widget.EditText;
import com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordTodoViewAdapter;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditText f5233a;
    public final /* synthetic */ FastRecordTodoViewAdapter b;

    public /* synthetic */ e(EditText editText, FastRecordTodoViewAdapter fastRecordTodoViewAdapter) {
        this.f5233a = editText;
        this.b = fastRecordTodoViewAdapter;
    }

    public final void run() {
        FastRecordTodoViewAdapter.requestSoftInput$lambda$2(this.f5233a, this.b);
    }
}
