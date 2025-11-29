package com.upuphone.starrynet.strategy.utils;

import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.utils.tracker.TrackerManager;
import com.upuphone.starrynet.core.ble.utils.BluetoothUtils;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;

public class Ring2TrackUtils {
    public static void clearIotDeviceInfo() {
        TrackerManager.getInstance().getMyvuRingBleTracker().clearIotDeviceInfo();
    }

    public static String getRing2DeviceVersion(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null) {
            return "";
        }
        int i = 0;
        while (i < 4) {
            sb.append(Integer.toHexString(bArr[i] & 255));
            sb.append(i == 3 ? "" : ".");
            i++;
        }
        return sb.length() <= 0 ? "" : sb.toString();
    }

    public static void setIotDeviceFwVer(byte[] bArr) {
        TrackerManager.getInstance().getMyvuRingBleTracker().setIotDeviceRom(getRing2DeviceVersion(bArr));
    }

    public static void setIotDeviceIdAndModelId(byte[] bArr) {
        if (bArr != null && bArr.length > 28) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 28; i++) {
                byte b = bArr[i];
                if (b == 0) {
                    break;
                }
                sb.append((char) b);
            }
            String sb2 = sb.toString();
            if (!sb2.isEmpty() && sb2.contains("XAR")) {
                String[] split = sb2.split("XAR");
                if (split.length >= 2) {
                    TrackerManager.getInstance().getMyvuRingBleTracker().setIotDeviceId(split[0]);
                    TrackerManager.getInstance().getMyvuRingBleTracker().setIotDeviceModel("XAR" + split[1]);
                }
            }
        }
    }

    public static void trackAuthResult(StDevice stDevice, int i) {
        TrackerManager.getInstance().getMyvuRingBleTracker().peerModelID(stDevice.getModelID()).resultAuth(stDevice.getTerminalType(), stDevice.getIdentifier2String(), i).isFlymePhone().start3rdReport();
    }

    public static void trackConnectFail(StDevice stDevice, int i, String str, boolean z, int i2) {
        if (stDevice != null) {
            if (z) {
                TrackerManager.getInstance().getMyvuRingBleTracker().resultMatchFail(stDevice.getTerminalType(), stDevice.getIdentifier2String(), i, str, i2).peerModelID(stDevice.getModelID()).isFlymePhone().start3rdReport();
            } else {
                TrackerManager.getInstance().getMyvuRingBleTracker().resultBleConnect(false, stDevice.getTerminalType(), stDevice.getIdentifier2String(), i, str, i2).peerModelID(stDevice.getModelID()).isFlymePhone().start3rdReport();
            }
        }
    }

    public static void trackConnected(StDevice stDevice) {
        if (stDevice != null) {
            TrackerManager.getInstance().getMyvuRingBleTracker().resultBleConnect(true, stDevice.getTerminalType(), stDevice.getIdentifier2String(), 0, "", 0).peerModelID(stDevice.getModelID()).isFlymePhone().start3rdReport();
        }
    }

    public static void trackDisConnect(StConnectDevice stConnectDevice, int i, String str, boolean z, int i2) {
        if (z && stConnectDevice != null && stConnectDevice.getDevice() != null) {
            TrackerManager.getInstance().getMyvuRingBleTracker().resultBleDisconnect(stConnectDevice.getDevice().getTerminalType(), stConnectDevice.getDevice().getIdentifier2String(), BluetoothUtils.isBluetoothEnabled(), z, i, str, i2).peerModelID(stConnectDevice.getModelID()).isFlymePhone().start3rdReport();
        }
    }

    public static void trackRing2DataError(StDevice stDevice, int i, String str) {
        TrackerManager.getInstance().getMyvuRingBleTracker().peerModelID(stDevice.getModelID()).resultRing2DataError(stDevice.getTerminalType(), stDevice.getIdentifier2String(), i, str).isFlymePhone().start3rdReport();
    }

    public static void trackSecurityState(StDevice stDevice, int i) {
        TrackerManager.getInstance().getMyvuRingBleTracker().peerModelID(stDevice.getModelID()).resultSecurity(stDevice.getTerminalType(), stDevice.getIdentifier2String(), i).isFlymePhone().start3rdReport();
    }

    public static void trackStartMatchConnection(StDevice stDevice, boolean z) {
        if (stDevice != null) {
            TrackerManager.getInstance().getMyvuRingBleTracker().startMatchOrReConnect(z, stDevice.getTerminalType(), stDevice.getIdentifier2String()).isPhone(StarryNetData.getInstance().getOwnDevice().getTerminalType() != 5);
        }
    }

    public static void trackStartRemoveBond(StDevice stDevice, int i) {
        TrackerManager.getInstance().getMyvuRingBleTracker().startUnpair(stDevice.getTerminalType(), stDevice.getIdentifier2String(), i).peerModelID(stDevice.getModelID()).isFlymePhone().start3rdReport();
    }
}
