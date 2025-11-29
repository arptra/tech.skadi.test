package com.honey.account.f4;

import android.view.MotionEvent;
import android.view.View;
import com.upuphone.ar.navi.lite.car.view.VehicleInput;

public final /* synthetic */ class a implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VehicleInput f4371a;

    public /* synthetic */ a(VehicleInput vehicleInput) {
        this.f4371a = vehicleInput;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f4371a.i(view, motionEvent);
    }
}
