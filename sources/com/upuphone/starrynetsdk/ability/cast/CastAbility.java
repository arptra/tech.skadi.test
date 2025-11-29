package com.upuphone.starrynetsdk.ability.cast;

import com.upuphone.hub.Hub;
import com.upuphone.runasone.uupcast.api.IUupCastProxy;
import com.upuphone.starrynetsdk.api.Ability;
import com.upuphone.starrynetsdk.api.Camp;
import com.upuphone.starrynetsdk.api.SNSLog;

abstract class CastAbility extends Ability {
    private static final String TAG = "CastAbility";
    private boolean isRunAsOneRebooted = false;
    protected String sessionTag = "";
    protected final IUupCastProxy starryCast = new IUupCastProxy();

    public CastAbility() {
        Camp.getInstance().addSentry(this);
    }

    public abstract int getCastSessionId();

    public abstract int initCastSession(String str);

    public void onInstalled(Hub hub) {
        super.onInstalled(hub);
        this.starryCast.setHub(hub);
        if (this.isRunAsOneRebooted) {
            String str = this.sessionTag;
            if (str == null || str.isEmpty()) {
                SNSLog.e(TAG, "sessionTag is empty");
            } else if (initCastSession(this.sessionTag) == 0) {
                SNSLog.d(TAG, "re initCastSession ok!");
            } else {
                SNSLog.d(TAG, "re initCastSession error!");
            }
        }
        this.isRunAsOneRebooted = false;
    }

    public void onUninstalled() {
        super.onUninstalled();
        this.isRunAsOneRebooted = true;
    }
}
