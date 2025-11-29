package com.google.android.material.search;

import android.view.View;
import com.google.android.material.appbar.AppBarLayout;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchBarAnimationHelper f9673a;
    public final /* synthetic */ SearchBar b;
    public final /* synthetic */ View c;
    public final /* synthetic */ AppBarLayout d;
    public final /* synthetic */ boolean e;

    public /* synthetic */ c(SearchBarAnimationHelper searchBarAnimationHelper, SearchBar searchBar, View view, AppBarLayout appBarLayout, boolean z) {
        this.f9673a = searchBarAnimationHelper;
        this.b = searchBar;
        this.c = view;
        this.d = appBarLayout;
        this.e = z;
    }

    public final void run() {
        this.f9673a.lambda$startExpandAnimation$0(this.b, this.c, this.d, this.e);
    }
}
