package com.honey.account.f5;

import android.view.MotionEvent;
import android.view.View;
import com.upuphone.ar.translation.phone.fragment.ToDoFragment;

public final /* synthetic */ class o0 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ToDoFragment f4397a;

    public /* synthetic */ o0(ToDoFragment toDoFragment) {
        this.f4397a = toDoFragment;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return ToDoFragment.S0(this.f4397a, view, motionEvent);
    }
}
