package com.honey.account.b4;

import android.view.View;
import com.upuphone.ar.fastrecord.phone.ui.widget.labels.RecordDetailInputTagView;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecordDetailInputTagView f4186a;
    public final /* synthetic */ View b;

    public /* synthetic */ g(RecordDetailInputTagView recordDetailInputTagView, View view) {
        this.f4186a = recordDetailInputTagView;
        this.b = view;
    }

    public final void run() {
        this.f4186a.lambda$addEditTextView$2(this.b);
    }
}
