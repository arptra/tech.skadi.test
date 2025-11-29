package com.honey.account.b4;

import android.view.KeyEvent;
import android.widget.TextView;
import com.upuphone.ar.fastrecord.phone.ui.widget.labels.RecordDetailInputTagView;

public final /* synthetic */ class f implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecordDetailInputTagView f4185a;

    public /* synthetic */ f(RecordDetailInputTagView recordDetailInputTagView) {
        this.f4185a = recordDetailInputTagView;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return this.f4185a.lambda$addEditTextView$1(textView, i, keyEvent);
    }
}
