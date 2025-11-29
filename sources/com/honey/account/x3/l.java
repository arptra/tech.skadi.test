package com.honey.account.x3;

import android.view.MotionEvent;
import android.view.View;
import com.upuphone.ar.fastrecord.phone.ui.fragment.FastRecordTodoFragment;

public final /* synthetic */ class l implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FastRecordTodoFragment f5304a;

    public /* synthetic */ l(FastRecordTodoFragment fastRecordTodoFragment) {
        this.f5304a = fastRecordTodoFragment;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return FastRecordTodoFragment.viewTouchListener$lambda$5(this.f5304a, view, motionEvent);
    }
}
