package com.honey.account.h8;

import android.view.View;
import com.upuphone.xr.sapp.fragment.MediaSelectFragment;

public final /* synthetic */ class e6 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediaSelectFragment.GridAdapter f4585a;
    public final /* synthetic */ int b;

    public /* synthetic */ e6(MediaSelectFragment.GridAdapter gridAdapter, int i) {
        this.f4585a = gridAdapter;
        this.b = i;
    }

    public final void onClick(View view) {
        MediaSelectFragment.GridAdapter.k(this.f4585a, this.b, view);
    }
}
