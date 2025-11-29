package com.honey.account.p1;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.material.search.SearchView;

public final /* synthetic */ class p implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchView f9794a;

    public /* synthetic */ p(SearchView searchView) {
        this.f9794a = searchView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f9794a.lambda$setUpContentOnTouchListener$3(view, motionEvent);
    }
}
