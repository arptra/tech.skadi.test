package com.upuphone.ar.navi.lite.car.keyboard;

import android.view.MotionEvent;
import android.view.View;
import com.upuphone.ar.navi.lite.car.keyboard.LicensePlateView;

public final /* synthetic */ class a implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LicensePlateView.KeyAdapter f5666a;
    public final /* synthetic */ LicensePlateView.KeyItem b;
    public final /* synthetic */ LicensePlateView.KeyAdapter.KeyViewHolder c;

    public /* synthetic */ a(LicensePlateView.KeyAdapter keyAdapter, LicensePlateView.KeyItem keyItem, LicensePlateView.KeyAdapter.KeyViewHolder keyViewHolder) {
        this.f5666a = keyAdapter;
        this.b = keyItem;
        this.c = keyViewHolder;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f5666a.i(this.b, this.c, view, motionEvent);
    }
}
