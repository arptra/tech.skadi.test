package com.honey.account.b4;

import android.widget.EditText;
import com.upuphone.ar.fastrecord.phone.ui.widget.labels.RecordDetailInputTagView;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecordDetailInputTagView f4183a;
    public final /* synthetic */ EditText b;

    public /* synthetic */ d(RecordDetailInputTagView recordDetailInputTagView, EditText editText) {
        this.f4183a = recordDetailInputTagView;
        this.b = editText;
    }

    public final void run() {
        this.f4183a.lambda$showInput$4(this.b);
    }
}
