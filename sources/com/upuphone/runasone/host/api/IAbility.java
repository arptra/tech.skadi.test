package com.upuphone.runasone.host.api;

import android.os.Bundle;
import com.upuphone.hub.Hub;

public interface IAbility {
    void appStateChanged(int i, String str, String str2, int i2);

    void bindHub(Hub hub) {
    }

    void transfer(Bundle bundle, Bundle bundle2);
}
