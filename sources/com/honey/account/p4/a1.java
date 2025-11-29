package com.honey.account.p4;

import android.view.MotionEvent;
import android.view.View;
import com.upuphone.ar.tici.phone.TiciSettingActivity;

public final /* synthetic */ class a1 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TiciSettingActivity f5024a;

    public /* synthetic */ a1(TiciSettingActivity ticiSettingActivity) {
        this.f5024a = ticiSettingActivity;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return TiciSettingActivity.T0(this.f5024a, view, motionEvent);
    }
}
