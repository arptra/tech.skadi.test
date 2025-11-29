package com.honey.account.d5;

import android.widget.EditText;
import com.upuphone.ar.translation.phone.activity.TranslatorSearchActivity;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f4322a;
    public final /* synthetic */ EditText b;
    public final /* synthetic */ TranslatorSearchActivity c;

    public /* synthetic */ p(boolean z, EditText editText, TranslatorSearchActivity translatorSearchActivity) {
        this.f4322a = z;
        this.b = editText;
        this.c = translatorSearchActivity;
    }

    public final void run() {
        TranslatorSearchActivity.showIme$lambda$9$lambda$8(this.f4322a, this.b, this.c);
    }
}
