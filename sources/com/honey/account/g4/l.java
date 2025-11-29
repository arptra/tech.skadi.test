package com.honey.account.g4;

import android.widget.AutoCompleteTextView;
import com.upuphone.ar.navi.lite.fragment.NaviFragment;
import com.upuphone.ar.navi.lite.model.IPlace;
import java.util.List;

public final /* synthetic */ class l implements IPlace {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NaviFragment f4444a;
    public final /* synthetic */ AutoCompleteTextView b;

    public /* synthetic */ l(NaviFragment naviFragment, AutoCompleteTextView autoCompleteTextView) {
        this.f4444a = naviFragment;
        this.b = autoCompleteTextView;
    }

    public final void a(List list) {
        this.f4444a.s2(this.b, list);
    }
}
