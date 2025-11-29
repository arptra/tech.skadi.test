package com.upuphone.starrynet.strategy.channel.bredr;

import com.upuphone.starrynet.core.bredr.manager.BrEdrMasterManager;

public class BrEdrMasterChannel extends BrEdrChannel {
    public BrEdrMasterChannel() {
        this.mManager = new BrEdrMasterManager(this.mContext);
        initListener();
    }

    public int getProfile() {
        return 20;
    }
}
