package com.honey.account.e4;

import android.view.View;
import com.upuphone.ar.navi.lite.adapter.MapPoiListAdapter;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MapPoiListAdapter f4340a;
    public final /* synthetic */ View b;

    public /* synthetic */ e(MapPoiListAdapter mapPoiListAdapter, View view) {
        this.f4340a = mapPoiListAdapter;
        this.b = view;
    }

    public final void onClick(View view) {
        this.f4340a.i(this.b, view);
    }
}
