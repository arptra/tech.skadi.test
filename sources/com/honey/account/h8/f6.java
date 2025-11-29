package com.honey.account.h8;

import android.view.View;
import com.upuphone.xr.sapp.fragment.MediaSelectFragment;

public final /* synthetic */ class f6 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediaSelectFragment.GridAdapter f4597a;
    public final /* synthetic */ MediaSelectFragment.GridAdapter.ViewHolder b;
    public final /* synthetic */ int c;

    public /* synthetic */ f6(MediaSelectFragment.GridAdapter gridAdapter, MediaSelectFragment.GridAdapter.ViewHolder viewHolder, int i) {
        this.f4597a = gridAdapter;
        this.b = viewHolder;
        this.c = i;
    }

    public final void onClick(View view) {
        MediaSelectFragment.GridAdapter.l(this.f4597a, this.b, this.c, view);
    }
}
