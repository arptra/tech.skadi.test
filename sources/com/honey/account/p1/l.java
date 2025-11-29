package com.honey.account.p1;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.search.SearchView;

public final /* synthetic */ class l implements OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchView f9791a;

    public /* synthetic */ l(SearchView searchView) {
        this.f9791a = searchView;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return this.f9791a.lambda$setUpStatusBarSpacerInsetListener$5(view, windowInsetsCompat);
    }
}
