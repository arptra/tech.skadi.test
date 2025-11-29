package com.upuphone.starrynet.strategy.discovery.fastpair.appfastpair;

import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.common.utils.Utils;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvertisePackUtil;
import com.upuphone.starrynet.strategy.discovery.fastpair.FastPairRecord;

public class BleAppJudgment {
    public static final int RSSI_FAST_PAIR_MIN = -90;
    public static final String TAG = "BleAppJudgment";
    protected StDiscoveryDevice mDevice;
    protected StarryDeviceManager mDeviceManager = StarryDeviceManager.getInstance();

    public BleAppJudgment(StDiscoveryDevice stDiscoveryDevice) {
        this.mDevice = stDiscoveryDevice;
    }

    private void changeToUnBondSate(StConnectDevice stConnectDevice) {
        StConnectDevice connectDevice = this.mDeviceManager.getConnectDevice(this.mDevice.getIdentifier());
        if (connectDevice == null || !connectDevice.isBleConnected()) {
            StLog.d(TAG, "fastPair update local database");
            this.mDeviceManager.updateBondInfo(stConnectDevice, 0);
            return;
        }
        StLog.d(TAG, "fastPair online remove bond ");
    }

    public int dealReceiveDefaultOrOtherMac(StConnectDevice stConnectDevice) {
        this.mDevice.getRssi();
        if (stConnectDevice != null && stConnectDevice.getBleBondStatus() == 4) {
            StLog.d(TAG, "fastPair update local database");
            changeToUnBondSate(stConnectDevice);
        }
        return 0;
    }

    public int dealReceivePeerMac(StConnectDevice stConnectDevice) {
        byte b;
        byte[] bArr = this.mDevice.getDeviceDetail().get((byte) 15);
        if (bArr != null) {
            StLog.d(TAG, "peer bond state is not null");
            b = bArr[0];
        } else {
            b = -1;
        }
        byte beaconId = this.mDevice.getBeaconId();
        int unsignedInt = Byte.toUnsignedInt(this.mDevice.getAdvType());
        StLog.d(TAG, "dealReceivePeerMac");
        if (FastPairRecord.getInstance().getNotifyLabel() && unsignedInt == 208) {
            FastPairRecord.getInstance().setNotifyLabel(false);
            StarryNetData.getInstance().getDiscoveryManager().stopNotifyAdv();
            return 1;
        } else if (stConnectDevice == null || stConnectDevice.getBleBondStatus() != 4) {
            if (b != 4) {
                return 3;
            }
            if (this.mDevice.getVersion() >= 2 && unsignedInt != 64) {
                return 3;
            }
            FastPairRecord.getInstance().addPairRecord(this.mDevice.getIdentifier(), beaconId);
            return resetBondState(stConnectDevice);
        } else if (b == 4) {
            StLog.d(TAG, "fastPair connect directly");
            FastPairRecord.getInstance().addPairRecord(this.mDevice.getIdentifier(), beaconId);
            return 1;
        } else {
            StLog.d(TAG, "fastPair update local database");
            changeToUnBondSate(stConnectDevice);
            return 0;
        }
    }

    public int isBlePop() {
        StConnectDevice connectDevice = this.mDeviceManager.getConnectDevice(this.mDevice.getIdentifier());
        if (StarryNetData.getInstance().getOwnDevice().getTerminalType() == 9) {
            return padBlePop(connectDevice);
        }
        byte[] peerMac = AdvertisePackUtil.getPeerMac(this.mDevice);
        StLog.v(TAG, "fastPair peer mac = " + Utils.getAddressStringFromByte(peerMac) + " name = " + this.mDevice.getDeviceName());
        return ByteUtils.equals(StarryNetData.getInstance().getIdentifier(), peerMac) ? dealReceivePeerMac(connectDevice) : dealReceiveDefaultOrOtherMac(connectDevice);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0023, code lost:
        if ((r0[0] & 1) == 1) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int padBlePop(com.upuphone.starrynet.strategy.bean.StConnectDevice r7) {
        /*
            r6 = this;
            com.upuphone.starrynet.strategy.bean.StDiscoveryDevice r0 = r6.mDevice
            java.util.HashMap r0 = r0.getDeviceDetail()
            r1 = 21
            java.lang.Byte r1 = java.lang.Byte.valueOf(r1)
            java.lang.Object r0 = r0.get(r1)
            byte[] r0 = (byte[]) r0
            com.upuphone.starrynet.strategy.bean.StDiscoveryDevice r1 = r6.mDevice
            byte r1 = r1.getAdvType()
            int r1 = java.lang.Byte.toUnsignedInt(r1)
            r2 = 1
            if (r0 == 0) goto L_0x0025
            r3 = 0
            byte r0 = r0[r3]
            r0 = r0 & r2
            if (r0 != r2) goto L_0x0026
        L_0x0025:
            r3 = r2
        L_0x0026:
            r0 = 144(0x90, float:2.02E-43)
            java.lang.String r4 = "BleAppJudgment"
            r5 = 4
            if (r1 == r0) goto L_0x0060
            r0 = 64
            if (r1 != r0) goto L_0x0032
            goto L_0x0060
        L_0x0032:
            r0 = 208(0xd0, float:2.91E-43)
            if (r1 != r0) goto L_0x005f
            com.upuphone.starrynet.strategy.StarryNetData r0 = com.upuphone.starrynet.strategy.StarryNetData.getInstance()
            byte[] r0 = r0.getIdentifier()
            com.upuphone.starrynet.strategy.bean.StDiscoveryDevice r6 = r6.mDevice
            byte[] r6 = com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvertisePackUtil.getPeerMac(r6)
            boolean r6 = com.upuphone.starrynet.common.utils.ByteUtils.equals((byte[]) r0, (byte[]) r6)
            if (r6 == 0) goto L_0x005f
            if (r7 == 0) goto L_0x0058
            int r6 = r7.getBleBondStatus()
            if (r6 != r5) goto L_0x0058
            java.lang.String r6 = "padBlePop, pad direct pair for connect adv"
            com.upuphone.starrynet.common.StLog.v(r4, r6)
            return r2
        L_0x0058:
            java.lang.String r6 = "padBlePop, pad dispatch for connect adv"
            com.upuphone.starrynet.common.StLog.v(r4, r6)
            r6 = 3
            return r6
        L_0x005f:
            return r5
        L_0x0060:
            if (r7 == 0) goto L_0x007c
            int r6 = r7.getBleBondStatus()
            if (r6 != r5) goto L_0x007c
            com.upuphone.starrynet.strategy.discovery.fastpair.FastPairRecord r6 = com.upuphone.starrynet.strategy.discovery.fastpair.FastPairRecord.getInstance()
            java.lang.String r0 = r7.getIdentifier2String()
            boolean r6 = r6.isActiveDisconnectPad(r0)
            if (r6 != 0) goto L_0x007c
            java.lang.String r6 = "padBlePop, pad direct pair"
            com.upuphone.starrynet.common.StLog.v(r4, r6)
            return r2
        L_0x007c:
            if (r7 == 0) goto L_0x008d
            int r6 = r7.getBleBondStatus()
            if (r6 != r5) goto L_0x008d
            if (r3 != 0) goto L_0x008d
            com.upuphone.starrynet.strategy.discovery.fastpair.FastPairRecord r6 = com.upuphone.starrynet.strategy.discovery.fastpair.FastPairRecord.getInstance()
            r6.removeAllActiveDisconnectPad()
        L_0x008d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.strategy.discovery.fastpair.appfastpair.BleAppJudgment.padBlePop(com.upuphone.starrynet.strategy.bean.StConnectDevice):int");
    }

    public int resetBondState(StConnectDevice stConnectDevice) {
        StLog.d(TAG, "fastPair update peer database");
        if (stConnectDevice == null) {
            stConnectDevice = StarryDeviceManager.getInstance().getConnectDevice(this.mDevice.getIdentifier());
            if (stConnectDevice == null) {
                stConnectDevice = new StConnectDevice();
            }
            stConnectDevice.setDevice(this.mDevice);
        }
        stConnectDevice.setStatus(15);
        this.mDeviceManager.updateBondInfo(stConnectDevice);
        return 1;
    }
}
