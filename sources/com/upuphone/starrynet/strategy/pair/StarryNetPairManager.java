package com.upuphone.starrynet.strategy.pair;

import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.pair.ble.BleClientPair;
import com.upuphone.starrynet.strategy.pair.ble.BleServerPair;
import com.upuphone.starrynet.strategy.pair.p2p.P2pGcPair;
import com.upuphone.starrynet.strategy.pair.p2p.P2pGoPair;

public class StarryNetPairManager {
    private static final String TAG = "StarryNetPairManager";
    private IChannelModulePair gcChannelModulePair;
    private IChannelModulePair goChannelModulePair;
    private final IPairStatusCallback mCallback = new IPairStatusCallback() {
        public void onPairStatus(int i, int i2) {
            if (i == 0) {
                synchronized (StarryNetPairManager.this.mSyncIsPair) {
                    try {
                        if (StarryNetPairManager.this.mIsPair) {
                            boolean unused = StarryNetPairManager.this.mIsPair = false;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            if (i == 0) {
                synchronized (StarryNetPairManager.this.mSyncIsUnPair) {
                    try {
                        if (StarryNetPairManager.this.mIsUnPair) {
                            boolean unused2 = StarryNetPairManager.this.mIsUnPair = false;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public volatile boolean mIsPair = false;
    /* access modifiers changed from: private */
    public volatile boolean mIsUnPair = false;
    private final IPairChannel mPairChannel;
    /* access modifiers changed from: private */
    public final Object mSyncIsPair = new Object();
    /* access modifiers changed from: private */
    public final Object mSyncIsUnPair = new Object();

    public StarryNetPairManager(IPairChannel iPairChannel) {
        this.mPairChannel = iPairChannel;
    }

    public void createBond(StDevice stDevice, int i) {
        IChannelModulePair bleClientPair = i == 1 ? new BleClientPair(this.mPairChannel, this.mCallback) : i == 2 ? new BleServerPair(this.mPairChannel, this.mCallback) : null;
        if (bleClientPair != null) {
            bleClientPair.createBond(stDevice, (byte[]) null);
        }
    }

    public void onEvent(String str, byte[] bArr, int i) {
        IChannelModulePair iChannelModulePair;
        if (i == 1) {
            iChannelModulePair = new BleClientPair(this.mPairChannel, this.mCallback);
        } else if (i == 2) {
            iChannelModulePair = new BleServerPair(this.mPairChannel, this.mCallback);
        } else if (i == 10) {
            if (this.goChannelModulePair == null) {
                this.goChannelModulePair = new P2pGoPair(this.mPairChannel, this.mCallback);
            }
            iChannelModulePair = this.goChannelModulePair;
        } else if (i == 11) {
            if (this.gcChannelModulePair == null) {
                this.gcChannelModulePair = new P2pGcPair(this.mPairChannel, this.mCallback);
            }
            iChannelModulePair = this.gcChannelModulePair;
        } else {
            StLog.d(TAG, "no channel can deal with");
            iChannelModulePair = null;
        }
        if (iChannelModulePair != null) {
            iChannelModulePair.onEvent(str, bArr);
        }
    }

    public void removeBond(StConnectDevice stConnectDevice, int i) {
        IChannelModulePair iChannelModulePair;
        if (stConnectDevice == null) {
            StLog.d(TAG, "removeBond the bondInfo is null");
            return;
        }
        if (i == 1) {
            iChannelModulePair = new BleClientPair(this.mPairChannel, this.mCallback);
        } else if (i == 2) {
            iChannelModulePair = new BleServerPair(this.mPairChannel, this.mCallback);
        } else if (i == 11) {
            if (this.gcChannelModulePair == null) {
                this.gcChannelModulePair = new P2pGcPair(this.mPairChannel, this.mCallback);
            }
            iChannelModulePair = this.gcChannelModulePair;
        } else if (i == 10) {
            if (this.goChannelModulePair == null) {
                this.goChannelModulePair = new P2pGoPair(this.mPairChannel, this.mCallback);
            }
            iChannelModulePair = this.goChannelModulePair;
        } else {
            StLog.d(TAG, "no channel can removeBond");
            iChannelModulePair = null;
        }
        if (iChannelModulePair != null) {
            iChannelModulePair.removeBond(stConnectDevice, (byte[]) null);
        }
    }
}
