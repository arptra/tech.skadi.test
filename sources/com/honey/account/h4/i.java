package com.honey.account.h4;

import android.content.Context;
import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.ar.navi.lite.manger.NaviDataTrackManager;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f4505a;
    public final /* synthetic */ SearchModel b;

    public /* synthetic */ i(Context context, SearchModel searchModel) {
        this.f4505a = context;
        this.b = searchModel;
    }

    public final void run() {
        NaviDataTrackManager.reportCommonAddressesNavTaskForBackThread$lambda$5(this.f4505a, this.b);
    }
}
