package com.upuphone.starrynetsdk.ability.lifecycle;

import com.upuphone.hub.Hub;
import com.upuphone.runasone.core.api.sys.LifecycleApiProxy;
import com.upuphone.starrynetsdk.api.Ability;
import com.upuphone.starrynetsdk.api.Camp;
import com.upuphone.starrynetsdk.api.ErrorCode;
import com.upuphone.starrynetsdk.api.SNSLog;

public class LifecycleAbility extends Ability {
    private static final String TAG = "LifecycleAbility";
    private final LifecycleApiProxy api = new LifecycleApiProxy();

    public LifecycleAbility() {
        Camp.getInstance().addSentry(this);
    }

    public void onInstalled(Hub hub) {
        super.onInstalled(hub);
        this.api.setHub(hub);
    }

    public int registerLifecycleObserver(String str) {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,closeGroupMessage failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        this.api.registerLifecycleObserver(str);
        return 0;
    }

    public int unRegisterLifecycleObserver(String str) {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable,closeGroupMessage failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        this.api.unRegisterLifecycleObserver(str);
        return 0;
    }
}
