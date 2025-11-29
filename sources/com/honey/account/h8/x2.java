package com.honey.account.h8;

import android.view.View;
import com.upuphone.xr.sapp.fragment.GlassAppListFragment;

public final /* synthetic */ class x2 implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GlassAppListFragment.MyAdapter f4806a;
    public final /* synthetic */ GlassAppListFragment.MyAdapter.ViewHolder b;

    public /* synthetic */ x2(GlassAppListFragment.MyAdapter myAdapter, GlassAppListFragment.MyAdapter.ViewHolder viewHolder) {
        this.f4806a = myAdapter;
        this.b = viewHolder;
    }

    public final boolean onLongClick(View view) {
        return GlassAppListFragment.MyAdapter.k(this.f4806a, this.b, view);
    }
}
