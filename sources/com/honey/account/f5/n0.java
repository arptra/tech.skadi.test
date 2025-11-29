package com.honey.account.f5;

import android.view.MotionEvent;
import android.view.View;
import com.upuphone.ar.translation.phone.fragment.ToDoFragment;

public final /* synthetic */ class n0 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ToDoFragment f4395a;

    public /* synthetic */ n0(ToDoFragment toDoFragment) {
        this.f4395a = toDoFragment;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return ToDoFragment.R0(this.f4395a, view, motionEvent);
    }
}
