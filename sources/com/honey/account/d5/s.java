package com.honey.account.d5;

import android.view.KeyEvent;
import android.widget.TextView;
import com.upuphone.ar.translation.phone.activity.TranslatorSearchActivity;

public final /* synthetic */ class s implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranslatorSearchActivity f4325a;

    public /* synthetic */ s(TranslatorSearchActivity translatorSearchActivity) {
        this.f4325a = translatorSearchActivity;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return TranslatorSearchActivity.initListener$lambda$7(this.f4325a, textView, i, keyEvent);
    }
}
