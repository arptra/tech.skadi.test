package com.honey.account.p4;

import android.view.MotionEvent;
import android.view.View;
import com.upuphone.ar.tici.phone.TiciMainActivity;

public final /* synthetic */ class k0 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TiciMainActivity f5053a;

    public /* synthetic */ k0(TiciMainActivity ticiMainActivity) {
        this.f5053a = ticiMainActivity;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return TiciMainActivity.z1(this.f5053a, view, motionEvent);
    }
}
