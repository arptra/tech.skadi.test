package com.honey.account.p1;

import android.view.View;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.search.SearchView;

public final /* synthetic */ class k implements ViewUtils.OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchView f9790a;

    public /* synthetic */ k(SearchView searchView) {
        this.f9790a = searchView;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
        return this.f9790a.lambda$setUpToolbarInsetListener$4(view, windowInsetsCompat, relativePadding);
    }
}
