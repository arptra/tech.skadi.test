package com.honey.account.j4;

import com.here.sdk.navigation.RealisticViewWarning;
import com.here.sdk.navigation.RealisticViewWarningListener;
import com.upuphone.ar.navi.lite.navi.HereNaviManager;

public final /* synthetic */ class h implements RealisticViewWarningListener {
    public final void onRealisticViewWarningUpdated(RealisticViewWarning realisticViewWarning) {
        HereNaviManager.g1(realisticViewWarning);
    }
}
