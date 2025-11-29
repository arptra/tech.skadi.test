package com.honey.account.d5;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.upuphone.ar.translation.phone.activity.TranslatorBaseActivity;

public final /* synthetic */ class b implements OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranslatorBaseActivity f4304a;

    public /* synthetic */ b(TranslatorBaseActivity translatorBaseActivity) {
        this.f4304a = translatorBaseActivity;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return TranslatorBaseActivity.handleContentView$lambda$1$lambda$0(this.f4304a, view, windowInsetsCompat);
    }
}
