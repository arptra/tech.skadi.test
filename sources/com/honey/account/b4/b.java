package com.honey.account.b4;

import android.view.KeyEvent;
import android.widget.TextView;
import com.upuphone.ar.fastrecord.phone.ui.widget.labels.RecordDetailInputTagView;

public final /* synthetic */ class b implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecordDetailInputTagView f4181a;

    public /* synthetic */ b(RecordDetailInputTagView recordDetailInputTagView) {
        this.f4181a = recordDetailInputTagView;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return this.f4181a.lambda$addLabel$3(textView, i, keyEvent);
    }
}
