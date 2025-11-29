package com.honey.account.j4;

import com.here.sdk.navigation.ManeuverViewLaneAssistance;
import com.here.sdk.navigation.ManeuverViewLaneAssistanceListener;
import com.upuphone.ar.navi.lite.navi.HereNaviManager;

public final /* synthetic */ class s implements ManeuverViewLaneAssistanceListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HereNaviManager f4881a;

    public /* synthetic */ s(HereNaviManager hereNaviManager) {
        this.f4881a = hereNaviManager;
    }

    public final void onLaneAssistanceUpdated(ManeuverViewLaneAssistance maneuverViewLaneAssistance) {
        this.f4881a.b1(maneuverViewLaneAssistance);
    }
}
