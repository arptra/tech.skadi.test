package com.honey.account.b4;

import android.view.View;
import com.upuphone.ar.fastrecord.phone.ui.widget.labels.RecordDetailInputTagView;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecordDetailInputTagView f4182a;
    public final /* synthetic */ View b;

    public /* synthetic */ c(RecordDetailInputTagView recordDetailInputTagView, View view) {
        this.f4182a = recordDetailInputTagView;
        this.b = view;
    }

    public final void run() {
        this.f4182a.lambda$addViewForIndex$0(this.b);
    }
}
