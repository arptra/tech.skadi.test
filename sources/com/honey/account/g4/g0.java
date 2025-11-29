package com.honey.account.g4;

import com.upuphone.ar.navi.lite.base.PlaceBean;
import com.upuphone.ar.navi.lite.fragment.SearchFragment;
import com.upuphone.ar.navi.lite.model.IPlace;
import java.util.List;

public final /* synthetic */ class g0 implements IPlace {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchFragment f4436a;
    public final /* synthetic */ PlaceBean b;

    public /* synthetic */ g0(SearchFragment searchFragment, PlaceBean placeBean) {
        this.f4436a = searchFragment;
        this.b = placeBean;
    }

    public final void a(List list) {
        this.f4436a.x3(this.b, list);
    }
}
