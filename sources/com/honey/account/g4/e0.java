package com.honey.account.g4;

import android.view.View;
import com.upuphone.ar.navi.lite.base.CommonAddress;
import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.ar.navi.lite.dao.NaviDatabase;
import com.upuphone.ar.navi.lite.fragment.SearchFragment;
import com.upuphone.ar.navi.lite.view.CustomDialog;

public final /* synthetic */ class e0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchFragment f4432a;
    public final /* synthetic */ CustomDialog b;
    public final /* synthetic */ NaviDatabase c;
    public final /* synthetic */ SearchModel d;
    public final /* synthetic */ CommonAddress e;

    public /* synthetic */ e0(SearchFragment searchFragment, CustomDialog customDialog, NaviDatabase naviDatabase, SearchModel searchModel, CommonAddress commonAddress) {
        this.f4432a = searchFragment;
        this.b = customDialog;
        this.c = naviDatabase;
        this.d = searchModel;
        this.e = commonAddress;
    }

    public final void onClick(View view) {
        this.f4432a.A3(this.b, this.c, this.d, this.e, view);
    }
}
