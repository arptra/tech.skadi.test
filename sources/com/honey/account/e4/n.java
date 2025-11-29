package com.honey.account.e4;

import android.widget.TextView;
import com.upuphone.ar.navi.lite.adapter.SearchViewHolder;
import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.ar.navi.lite.model.IPlace;
import java.util.List;

public final /* synthetic */ class n implements IPlace {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f4349a;
    public final /* synthetic */ TextView b;
    public final /* synthetic */ SearchModel c;

    public /* synthetic */ n(boolean z, TextView textView, SearchModel searchModel) {
        this.f4349a = z;
        this.b = textView;
        this.c = searchModel;
    }

    public final void a(List list) {
        SearchViewHolder.k(this.f4349a, this.b, this.c, list);
    }
}
