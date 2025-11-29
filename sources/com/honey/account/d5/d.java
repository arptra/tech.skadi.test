package com.honey.account.d5;

import android.view.MotionEvent;
import android.view.View;
import com.upuphone.ar.translation.phone.activity.TranslatorIntelExtnActivity;

public final /* synthetic */ class d implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranslatorIntelExtnActivity f4308a;

    public /* synthetic */ d(TranslatorIntelExtnActivity translatorIntelExtnActivity) {
        this.f4308a = translatorIntelExtnActivity;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return TranslatorIntelExtnActivity.initListener$lambda$1(this.f4308a, view, motionEvent);
    }
}
