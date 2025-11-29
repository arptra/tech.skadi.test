package com.honey.account.p1;

import com.google.android.material.search.SearchView;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchView f9795a;

    public /* synthetic */ q(SearchView searchView) {
        this.f9795a = searchView;
    }

    public final void run() {
        this.f9795a.requestFocusAndShowKeyboardIfNeeded();
    }
}
