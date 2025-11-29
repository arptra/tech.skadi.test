package com.upuphone.runasone;

import android.os.Bundle;
import com.upuphone.runasone.core.api.sys.LifecycleApiAdapter;
import com.upuphone.runasone.host.api.IAbility;
import com.upuphone.runasone.lifecycle.LifecycleApiImp;
import com.upuphone.runasone.lifecycle.manager.LifecycleManager;

public class LifecycleAbility implements IAbility {
    LifecycleApiAdapter adapter = new LifecycleApiAdapter(new LifecycleApiImp());

    public void appStateChanged(int i, String str, String str2, int i2) {
        if (i2 == 0) {
            LifecycleManager.getInstance().onAppDied(str);
        }
    }

    public void transfer(Bundle bundle, Bundle bundle2) {
        if (bundle != null && bundle2 != null) {
            this.adapter.adapt(bundle, bundle2);
        }
    }
}
