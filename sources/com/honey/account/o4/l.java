package com.honey.account.o4;

import android.view.ViewTreeObserver;
import com.upuphone.ar.navi.lite.view.ContentRecyclerView;

public final /* synthetic */ class l implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ContentRecyclerView f4979a;

    public /* synthetic */ l(ContentRecyclerView contentRecyclerView) {
        this.f4979a = contentRecyclerView;
    }

    public final void onGlobalLayout() {
        this.f4979a.c();
    }
}
