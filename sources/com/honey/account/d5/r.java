package com.honey.account.d5;

import android.view.MotionEvent;
import android.view.View;
import com.upuphone.ar.translation.phone.activity.TranslatorSearchActivity;

public final /* synthetic */ class r implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranslatorSearchActivity f4324a;

    public /* synthetic */ r(TranslatorSearchActivity translatorSearchActivity) {
        this.f4324a = translatorSearchActivity;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return TranslatorSearchActivity.initListener$lambda$6(this.f4324a, view, motionEvent);
    }
}
