package com.honey.account.j4;

import com.here.sdk.navigation.JunctionViewLaneAssistance;
import com.here.sdk.navigation.JunctionViewLaneAssistanceListener;
import com.upuphone.ar.navi.lite.navi.HereNaviManager;

public final /* synthetic */ class b implements JunctionViewLaneAssistanceListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HereNaviManager f4866a;

    public /* synthetic */ b(HereNaviManager hereNaviManager) {
        this.f4866a = hereNaviManager;
    }

    public final void onLaneAssistanceUpdated(JunctionViewLaneAssistance junctionViewLaneAssistance) {
        this.f4866a.c1(junctionViewLaneAssistance);
    }
}
