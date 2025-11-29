package com.here.odnp.posclient.crowdsource.hd;

import com.here.odnp.posclient.CloseableSession;
import com.here.odnp.posclient.PosClientManager;
import com.here.odnp.posclient.hd.IHdCrowdsourceSession;

public abstract class HdCrowdsourceSession extends CloseableSession implements IHdCrowdsourceSession {
    public HdCrowdsourceSession(PosClientManager posClientManager) {
        super(posClientManager);
    }

    public void onClose() {
        this.mPosClientManager.removeHdCrowdsourceSession(this);
    }

    public void onOpen() {
        this.mPosClientManager.addHdCrowdsourceSession(this);
    }
}
