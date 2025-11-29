package com.upuphone.starrynet.strategy.discovery.fastpair.judgment;

import android.os.Handler;
import androidx.annotation.NonNull;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;

class BaseJudgment {
    protected static final int DEVICE_STATUS_BOND = 1;
    protected static final int DEVICE_STATUS_BOND_OTHER = 2;
    protected static final int DEVICE_STATUS_CONNECTED = -1;
    protected static final int DEVICE_STATUS_UN_BOND = 0;
    protected static final String TAG = "BaseJudgment";
    protected final FastPairJudgment mJudgment;
    protected final String mModelId;

    public BaseJudgment(FastPairJudgment fastPairJudgment, String str) {
        this.mJudgment = fastPairJudgment;
        this.mModelId = str;
    }

    public void addPairRecord(StDiscoveryDevice stDiscoveryDevice) {
        this.mJudgment.addPairRecord(stDiscoveryDevice);
    }

    public void dealDelayJudgment(StDiscoveryDevice stDiscoveryDevice, int i, int i2) {
    }

    public void dealFastPairJudgment(StDiscoveryDevice stDiscoveryDevice) {
    }

    public int getDeviceBondInfoResult(StDiscoveryDevice stDiscoveryDevice) {
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDiscoveryDevice.getIdentifier());
        if (connectDevice != null) {
            if (connectDevice.getDevice().isBleConnected()) {
                return -1;
            }
            if (connectDevice.getBleBondStatus() == 4) {
                return 1;
            }
        }
        return StarryDeviceManager.getInstance().getBondInfoByTerminal(stDiscoveryDevice.getTerminalType()).isEmpty() ? 0 : 2;
    }

    public int getFastPairStatus(StDiscoveryDevice stDiscoveryDevice) {
        return this.mJudgment.getFastPairStatus(stDiscoveryDevice);
    }

    @NonNull
    public Handler getHandler() {
        return this.mJudgment.getHandler();
    }

    public int getPairRecord(String str) {
        return this.mJudgment.getPairRecord(str);
    }

    public boolean isJudged(StDiscoveryDevice stDiscoveryDevice) {
        return this.mJudgment.isJudged(stDiscoveryDevice);
    }

    public boolean needOfflineRemoveBond(StDiscoveryDevice stDiscoveryDevice) {
        StConnectDevice connectDevice;
        if (stDiscoveryDevice == null || stDiscoveryDevice.getTerminalType() == 1 || stDiscoveryDevice.getTerminalType() == 9 || (connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDiscoveryDevice.getIdentifier())) == null || connectDevice.getBleBondStatus() != 4) {
            return false;
        }
        byte[] bArr = stDiscoveryDevice.getDeviceDetail().get((byte) 15);
        if (bArr != null && bArr[0] == 4) {
            return false;
        }
        StLog.i(TAG, "startAppFastPair offline remove bond");
        StarryDeviceManager.getInstance().updateBondInfo(connectDevice, 0);
        return true;
    }

    public void removePairRecord(String str) {
        this.mJudgment.removePairRecord(str);
    }

    public void sendResult(StDiscoveryDevice stDiscoveryDevice, int i) {
        this.mJudgment.sendResult(stDiscoveryDevice, i);
    }

    public boolean startFastPair(StDiscoveryDevice stDiscoveryDevice) {
        return false;
    }

    public boolean startLocalFastPair(StDiscoveryDevice stDiscoveryDevice) {
        return false;
    }
}
