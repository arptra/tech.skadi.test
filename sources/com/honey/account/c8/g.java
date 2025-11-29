package com.honey.account.c8;

import android.view.View;
import com.upuphone.xr.sapp.adapter.LanguageAdapter;
import com.upuphone.xr.sapp.entity.LanguageMode;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LanguageAdapter f4212a;
    public final /* synthetic */ LanguageMode b;

    public /* synthetic */ g(LanguageAdapter languageAdapter, LanguageMode languageMode) {
        this.f4212a = languageAdapter;
        this.b = languageMode;
    }

    public final void onClick(View view) {
        LanguageAdapter.i(this.f4212a, this.b, view);
    }
}
