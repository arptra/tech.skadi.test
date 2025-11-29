package com.honey.account.p1;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.search.SearchView;

public final /* synthetic */ class i implements OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup.MarginLayoutParams f9788a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public /* synthetic */ i(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2) {
        this.f9788a = marginLayoutParams;
        this.b = i;
        this.c = i2;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return SearchView.lambda$setUpDividerInsetListener$6(this.f9788a, this.b, this.c, view, windowInsetsCompat);
    }
}
