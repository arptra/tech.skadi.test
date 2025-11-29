package com.upuphone.starrynet.strategy.pair.p2p;

import Starry.StarryLinkEncrypt;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.tracker.TrackerManager;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.encrypt.StarryNetDecryptHelper;
import com.upuphone.starrynet.strategy.pair.IChannelModulePair;
import com.upuphone.starrynet.strategy.pair.IPairChannel;
import com.upuphone.starrynet.strategy.pair.IPairStatusCallback;
import com.upuphone.starrynet.strategy.pair.StarryNetPairUtil;

public abstract class P2pChannelPair implements IChannelModulePair {
    private static final String TAG = "P2pChannelPair";
    /* access modifiers changed from: private */
    public final IPairChannel mChannel;
    protected final PairP2pMsgHandler mP2pPairMsgHandler = new PairP2pMsgHandler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final IPairStatusCallback mPairStatusCallback;

    public class PairP2pMsgHandler extends Handler {
        public PairP2pMsgHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            StLog.d(P2pChannelPair.TAG, "handleMessage :" + message.what);
            int i = message.what;
            if (i == 2) {
                byte[] byteArray = message.getData().getByteArray("pairData");
                String str = (String) message.obj;
                StarryNetDecryptHelper parse = StarryNetDecryptHelper.parse(byteArray);
                if (parse == null) {
                    StLog.d(P2pChannelPair.TAG, "The pair message form GC is null");
                    P2pChannelPair.this.mPairStatusCallback.onPairStatus(0, 4);
                    return;
                }
                P2pChannelPair.this.handleMsgFromGc(parse);
            } else if (i == 3) {
                byte[] byteArray2 = message.getData().getByteArray("pairData");
                String str2 = (String) message.obj;
                StarryNetDecryptHelper parse2 = StarryNetDecryptHelper.parse(byteArray2);
                if (parse2 == null) {
                    StLog.d(P2pChannelPair.TAG, "The pair message form GO is null");
                    P2pChannelPair.this.mPairStatusCallback.onPairStatus(0, 4);
                    return;
                }
                P2pChannelPair.this.handleMsgFromGo(parse2);
            } else if (i == 5) {
                Object obj = message.obj;
                if (obj instanceof StDevice) {
                    StDevice stDevice = (StDevice) obj;
                    if (stDevice.isP2pConnected()) {
                        P2pChannelPair.this.mChannel.disconnectP2p(stDevice);
                    }
                    P2pChannelPair.this.trackRemoveBondResult(stDevice, true);
                    return;
                }
                StLog.d(P2pChannelPair.TAG, "STARRYNET_CHANNEL_UNBONDREQ_TIMEOUT device is null");
            }
        }
    }

    public P2pChannelPair(IPairChannel iPairChannel, IPairStatusCallback iPairStatusCallback) {
        this.mChannel = iPairChannel;
        this.mPairStatusCallback = iPairStatusCallback;
    }

    private void handleGcUnBondMsg(StarryNetDecryptHelper starryNetDecryptHelper) {
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(starryNetDecryptHelper.getIdentifier());
        if (connectDevice == null) {
            StLog.d(TAG, "onUnBond info is null");
            this.mPairStatusCallback.onPairStatus(0, 4);
            return;
        }
        StarryDeviceManager.getInstance().updateBondInfo(connectDevice, 0);
        this.mChannel.updateBondStateChanged(connectDevice.getDevice(), 0);
        this.mPairStatusCallback.onPairStatus(0, 0);
        if (this.mChannel.sendP2pMsg(connectDevice, StarryNetPairUtil.unPair())) {
            StLog.d(TAG, "send unPair by P2P succeed");
            trackRemoveBondResult(connectDevice.getDevice(), false);
            return;
        }
        trackRemoveBondResult(connectDevice.getDevice(), true);
        this.mChannel.disconnectP2p(connectDevice.getDevice());
    }

    private void handleGoUnBondMsg(StarryNetDecryptHelper starryNetDecryptHelper) {
        stopTimer(5);
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(starryNetDecryptHelper.getIdentifier());
        if (connectDevice == null) {
            StLog.d(TAG, "onUnBond info is null");
            this.mPairStatusCallback.onPairStatus(0, 4);
            return;
        }
        StarryDeviceManager.getInstance().updateBondInfo(connectDevice, 0);
        this.mChannel.updateBondStateChanged(connectDevice.getDevice(), 0);
        this.mChannel.disconnectP2p(connectDevice.getDevice());
        this.mPairStatusCallback.onPairStatus(0, 0);
        trackRemoveBondResult(connectDevice.getDevice(), false);
    }

    /* access modifiers changed from: private */
    public void handleMsgFromGc(StarryNetDecryptHelper starryNetDecryptHelper) {
        if (starryNetDecryptHelper.getCommand() == StarryLinkEncrypt.COMMAND.UN_BONDED) {
            handleGcUnBondMsg(starryNetDecryptHelper);
        }
    }

    /* access modifiers changed from: private */
    public void handleMsgFromGo(StarryNetDecryptHelper starryNetDecryptHelper) {
        if (starryNetDecryptHelper.getCommand() == StarryLinkEncrypt.COMMAND.UN_BONDED) {
            handleGoUnBondMsg(starryNetDecryptHelper);
        }
    }

    private void startTimer(int i, int i2, StDevice stDevice) {
        if (this.mP2pPairMsgHandler.hasMessages(i)) {
            this.mP2pPairMsgHandler.removeMessages(i);
        }
        PairP2pMsgHandler pairP2pMsgHandler = this.mP2pPairMsgHandler;
        pairP2pMsgHandler.sendMessageDelayed(pairP2pMsgHandler.obtainMessage(i, stDevice), (long) i2);
    }

    private void stopTimer(int i) {
        if (this.mP2pPairMsgHandler.hasMessages(i)) {
            this.mP2pPairMsgHandler.removeMessages(i);
        }
    }

    /* access modifiers changed from: private */
    public void trackRemoveBondResult(StDevice stDevice, boolean z) {
        byte terminalType = StarryNetData.getInstance().getOwnDevice().getTerminalType();
        if (z) {
            TrackerManager.getInstance().getUnpairDeviceTracker().peerModelID(stDevice.getModelID()).result(stDevice.getTerminalType(), stDevice.getIdentifier2String(), terminalType == 2 ? 0 : 1).startReport();
        } else {
            TrackerManager.getInstance().getUnpairDeviceTracker().peerModelID(stDevice.getModelID()).result(stDevice.getTerminalType(), stDevice.getIdentifier2String(), 2).startReport();
        }
    }

    public void createBond(StDevice stDevice, byte[] bArr) {
    }

    public void removeBond(StConnectDevice stConnectDevice, byte[] bArr) {
        if (stConnectDevice == null) {
            StLog.i(TAG, "removeBond the bondInfo is null");
            this.mPairStatusCallback.onPairStatus(0, 4);
            return;
        }
        StarryDeviceManager.getInstance().updateBondInfo(stConnectDevice, 0);
        this.mChannel.updateBondStateChanged(stConnectDevice.getDevice(), 0);
        this.mPairStatusCallback.onPairStatus(0, 0);
        if (!stConnectDevice.isP2pConnected()) {
            StLog.i(TAG, "remove Bond when P2P disconnected");
        } else if (this.mChannel.sendP2pMsg(stConnectDevice, StarryNetPairUtil.unPair())) {
            StLog.d(TAG, "removeBond by P2P send succeed");
            if (stConnectDevice.isProtocolConnected(4)) {
                trackRemoveBondResult(stConnectDevice.getDevice(), false);
            } else if (stConnectDevice.isProtocolConnected(8)) {
                startTimer(5, 5000, stConnectDevice.getDevice());
            }
        } else {
            StLog.d(TAG, "removeBond by P2P send failed");
            trackRemoveBondResult(stConnectDevice.getDevice(), true);
            this.mChannel.disconnectP2p(stConnectDevice.getDevice());
        }
    }
}
