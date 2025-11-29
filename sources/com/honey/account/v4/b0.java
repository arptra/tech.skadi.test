package com.honey.account.v4;

import android.view.MotionEvent;
import android.view.View;
import com.upuphone.ar.transcribe.phone.activity.TranscribeSearchActivity;

public final /* synthetic */ class b0 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranscribeSearchActivity f5244a;

    public /* synthetic */ b0(TranscribeSearchActivity transcribeSearchActivity) {
        this.f5244a = transcribeSearchActivity;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return TranscribeSearchActivity.initViews$lambda$4(this.f5244a, view, motionEvent);
    }
}
