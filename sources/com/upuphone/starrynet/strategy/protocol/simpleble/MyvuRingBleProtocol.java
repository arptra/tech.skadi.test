package com.upuphone.starrynet.strategy.protocol.simpleble;

import android.annotation.SuppressLint;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.IConnectChannel;
import com.upuphone.starrynet.strategy.channel.IMessageChannel;
import com.upuphone.starrynet.strategy.channel.IStarryNetChannel;
import com.upuphone.starrynet.strategy.channel.StarryNetChannelManager;
import com.upuphone.starrynet.strategy.channel.simpleble.MyvuRingBleClientChannel;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.message.payload.SimplePayloadMessageManager;
import com.upuphone.starrynet.strategy.pair.IMYVURingStatusCallback;
import com.upuphone.starrynet.strategy.pair.ble.RingSecurityPair;
import com.upuphone.starrynet.strategy.protocol.IProtocol;
import com.upuphone.starrynet.strategy.utils.Ring2TrackUtils;
import java.util.Arrays;

@SuppressLint({"MissingPermission"})
public class MyvuRingBleProtocol implements IProtocol, IMYVURingStatusCallback {
    public static final byte OPCODE_INTERNAL_CREATE_BOND = 33;
    public static final byte OPCODE_INTERNAL_GET_FW_VER = 38;
    public static final byte OPCODE_INTERNAL_GET_SN = 37;
    public static final byte OPCODE_INTERNAL_INTERNAL_INFO_ALL_GOT = 39;
    public static final byte OPCODE_RING_OPEN_ENCRYPTION = 35;
    public static final byte OPCODE_RING_SHUTDOWN_ENCRYPTION = 34;
    public static final byte PAIR_STATE_AUTH_FAIL = -1;
    public static final byte PAIR_STATE_AUTH_SUCCESS = 1;
    public static final byte STARRY_RING_INTERNAL_CMD = 2;
    public static final byte STARRY_RING_INTERNAL_MESSAGE = 1;
    private static final String TAG = "MyvuRingBleProtocol";
    private static final byte[] mProtocolOpcodeMap = {RingSecurityPair.OPCODE_RING_PAIR, 1, RingSecurityPair.OPCODE_RING_ENCRYPTED_DATA, RingSecurityPair.OPCODE_PHONE_START_REMOVE_BOND};
    private static final byte[] mProtocolOpcodeMapAlternative = {7, 3, 39};
    private static final byte[] mProtocolPlainOpCodeMap = {RingSecurityPair.OPCODE_PHONE_START_REMOVE_BOND, 7, 39};
    private boolean mEnableEncryptionMode = false;
    private boolean mInternalCmdDone = false;

    public MyvuRingBleProtocol() {
        StLog.d(TAG, "init");
        RingSecurityPair.getInstance().registerPairStatusCallback(this);
        StarryNetChannelManager.getInstance().addProtocol(this);
    }

    private boolean checkIfInternalProtocolMessage(byte b) {
        for (byte b2 : mProtocolOpcodeMap) {
            if (b2 == b) {
                return true;
            }
        }
        if (this.mInternalCmdDone) {
            return false;
        }
        StLog.d(TAG, "internal cmd process not complete");
        return checkIfInternalRingCmd(b);
    }

    private boolean checkIfInternalRingCmd(byte b) {
        for (byte b2 : mProtocolOpcodeMapAlternative) {
            if (b2 == b) {
                return true;
            }
        }
        return false;
    }

    private boolean checkIfPlainOpCode(byte b) {
        for (byte b2 : mProtocolPlainOpCodeMap) {
            if (b2 == b) {
                return true;
            }
        }
        return false;
    }

    private void dealInternalRingCmd(byte b, StConnectDevice stConnectDevice) {
        switch (b) {
            case 33:
                StLog.d(TAG, "OPCODE_INTERNAL_CREATE_BOND ");
                this.mEnableEncryptionMode = false;
                this.mInternalCmdDone = false;
                RingSecurityPair.getInstance().clientCreateBond(stConnectDevice.getDevice());
                return;
            case 34:
                StLog.d(TAG, "OPCODE_RING_SHUTDOWN_ENCRYPTION ");
                RingSecurityPair.getInstance().setEncryptionMode(stConnectDevice, false);
                SimplePayloadMessageManager.getInstance().setEncryptionMode(false);
                this.mEnableEncryptionMode = false;
                this.mInternalCmdDone = false;
                return;
            case 35:
                StLog.d(TAG, "OPCODE_RING_OPEN_ENCRYPTION ");
                RingSecurityPair.getInstance().setEncryptionMode(stConnectDevice, true);
                SimplePayloadMessageManager.getInstance().setEncryptionMode(true);
                this.mEnableEncryptionMode = true;
                return;
            case 37:
                this.mInternalCmdDone = false;
                StLog.d(TAG, "OPCODE_INTERNAL_GET_SN ");
                RingSecurityPair.getInstance().getSN(stConnectDevice);
                return;
            case 38:
                this.mInternalCmdDone = false;
                StLog.d(TAG, "OPCODE_INTERNAL_GET_FW_VER ");
                RingSecurityPair.getInstance().getFwVer(stConnectDevice);
                return;
            case 39:
                StLog.d(TAG, "OPCODE_INTERNAL_INTERNAL_INFO_ALL_GOT ");
                this.mInternalCmdDone = true;
                return;
            default:
                return;
        }
    }

    public static String getHexString(byte b) {
        byte b2 = b & 255;
        Integer.toHexString(b2);
        return "0x" + Integer.toHexString(b2);
    }

    public int connect(StDevice stDevice, int i) {
        IConnectChannel connectChannel = StarryNetChannelManager.getInstance().getConnectChannel(i);
        return connectChannel == null ? StErrorCode.CONNECT_STRATEGY_BLE_PARAM_ERROR : connectChannel.connect(stDevice);
    }

    public int disconnect(StDevice stDevice, int i) {
        IConnectChannel connectChannel = StarryNetChannelManager.getInstance().getConnectChannel(i);
        return connectChannel == null ? StErrorCode.CONNECT_STRATEGY_BLE_PARAM_ERROR : connectChannel.disconnect(stDevice);
    }

    public StConnectDevice getConnectDevice(String str) {
        return ((MyvuRingBleClientChannel) StarryNetChannelManager.getInstance().getConnectChannel(25)).getConnectDevice(str);
    }

    public IMessageChannel getMessageChannel(StDevice stDevice) {
        return null;
    }

    public int getProfile() {
        return 5;
    }

    public void onBrEdrBondStateChange(StConnectDevice stConnectDevice, int i, int i2) {
    }

    public boolean onConnected(StConnectDevice stConnectDevice, IConnectChannel iConnectChannel) {
        StarryDeviceManager.getInstance().deviceConnected(stConnectDevice, 2);
        return true;
    }

    public boolean onDisconnected(StConnectDevice stConnectDevice, IConnectChannel iConnectChannel) {
        StarryDeviceManager.getInstance().deviceDisconnected(stConnectDevice, 2);
        return true;
    }

    public void onPairStatusChange(StDevice stDevice, int i, int i2) {
        StLog.d(TAG, "onPairStatusChange: action = " + i + ", state = " + i2);
        MyvuRingBleClientChannel myvuRingBleClientChannel = (MyvuRingBleClientChannel) StarryNetChannelManager.getInstance().getConnectChannel(25);
        if (myvuRingBleClientChannel != null && i == 0) {
            myvuRingBleClientChannel.notifyStarryBond(stDevice, i, i2);
        }
    }

    public void onPrivateCmdExchange(StDevice stDevice, int i, int i2) {
        StLog.d(TAG, "onPrivateCmdExchange: action = " + i + ", state = " + i2);
        MyvuRingBleClientChannel myvuRingBleClientChannel = (MyvuRingBleClientChannel) StarryNetChannelManager.getInstance().getConnectChannel(25);
        if (myvuRingBleClientChannel == null) {
            return;
        }
        if (i == -123) {
            if (i2 == 0) {
                myvuRingBleClientChannel.removeBond(stDevice);
            } else if (i2 == 4) {
                Ring2TrackUtils.trackStartRemoveBond(stDevice, 0);
                myvuRingBleClientChannel.removeBond(stDevice, Boolean.FALSE);
            }
        } else if (i == 3) {
            StLog.d(TAG, "encryption mode: " + i2);
            myvuRingBleClientChannel.onEncryptionModeChangeConfirm(stDevice, i2);
        } else if (i == 7) {
            StLog.d(TAG, "get sn done");
            myvuRingBleClientChannel.onGetSNCmdConfirm(stDevice, i2);
        } else if (i == 39) {
            StLog.d(TAG, "get fw version done");
            myvuRingBleClientChannel.onGetFWVerCmdConfirm(stDevice, i2);
        }
    }

    public void onRecv(StConnectDevice stConnectDevice, byte[] bArr, int i, IStarryNetChannel iStarryNetChannel) {
        if (bArr == null) {
            StLog.e(TAG, "receivce INVALID data: " + RingSecurityPair.debugByteArray(bArr));
            Ring2TrackUtils.trackRing2DataError(stConnectDevice.getDevice(), 0, "");
            return;
        }
        byte[] bArr2 = null;
        byte b = 255;
        if (i == 1) {
            if (this.mEnableEncryptionMode && !checkIfPlainOpCode(bArr[0])) {
                if (bArr[0] == -54) {
                    if (bArr.length > 1) {
                        bArr2 = Arrays.copyOfRange(bArr, 2, bArr.length);
                        b = 255 & bArr[1];
                    }
                    byte[] ClientDataDecrypt = RingSecurityPair.getInstance().ClientDataDecrypt(bArr2, stConnectDevice);
                    if (bArr2 == null || ClientDataDecrypt == null || ClientDataDecrypt.length < b) {
                        StLog.e(TAG, "receive INVALID data encrypted: (len: %d) " + RingSecurityPair.debugByteArray(bArr), Integer.valueOf(b));
                        Ring2TrackUtils.trackRing2DataError(stConnectDevice.getDevice(), bArr.length, RingSecurityPair.debugByteArray(bArr));
                        SimplePayloadMessageManager.getInstance().uploadMessage(bArr, stConnectDevice.getBleMac());
                        return;
                    }
                    StLog.d(TAG, "receive data encrypted: (len: %d) ", Integer.valueOf(b));
                    bArr = ClientDataDecrypt;
                } else {
                    StLog.e(TAG, "under encrypted mode but plain text received");
                    return;
                }
            }
        } else if (i == 2) {
            dealInternalRingCmd(bArr[0], stConnectDevice);
            return;
        } else {
            bArr = null;
        }
        if (!checkIfInternalProtocolMessage(bArr[0])) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, b);
            StLog.d(TAG, "app message, upload len (%d), type: 0x" + getHexString(copyOfRange[0]), Integer.valueOf(b));
            SimplePayloadMessageManager.getInstance().uploadMessage(copyOfRange, stConnectDevice.getBleMac());
        } else if (!this.mInternalCmdDone && checkIfInternalRingCmd(bArr[0])) {
            StLog.d(TAG, "internal ring cmd: " + getHexString(bArr[0]));
            byte b2 = bArr[0];
            if (b2 == 7 && bArr[1] == 2) {
                Ring2TrackUtils.setIotDeviceIdAndModelId(Arrays.copyOfRange(bArr, 2, bArr.length));
                onPrivateCmdExchange(stConnectDevice.getDevice(), bArr[0], 0);
            } else if (b2 == 39) {
                Ring2TrackUtils.setIotDeviceFwVer(Arrays.copyOfRange(bArr, 1, bArr.length - 1));
                onPrivateCmdExchange(stConnectDevice.getDevice(), bArr[0], 0);
            } else if (b2 == 3) {
                onPrivateCmdExchange(stConnectDevice.getDevice(), bArr[0], bArr[10]);
            }
        } else if (!checkIfPlainOpCode(bArr[0])) {
            RingSecurityPair.getInstance().handleRingInternalMessage(stConnectDevice.getDevice(), bArr);
        } else if (bArr[0] == -123) {
            onPrivateCmdExchange(stConnectDevice.getDevice(), bArr[0], bArr[1]);
        }
    }

    public void removeBond(StDevice stDevice) {
        MyvuRingBleClientChannel myvuRingBleClientChannel = (MyvuRingBleClientChannel) StarryNetChannelManager.getInstance().getConnectChannel(25);
        if (myvuRingBleClientChannel != null) {
            Ring2TrackUtils.trackStartRemoveBond(stDevice, 1);
            myvuRingBleClientChannel.removeBond(stDevice);
        }
    }

    public void securityMessageSender(StDevice stDevice, byte[] bArr) {
        MyvuRingBleClientChannel myvuRingBleClientChannel = (MyvuRingBleClientChannel) StarryNetChannelManager.getInstance().getConnectChannel(25);
        if (myvuRingBleClientChannel != null) {
            myvuRingBleClientChannel.sendMessage(stDevice, bArr);
        }
    }

    public int sendMsg(StDevice stDevice, byte[] bArr) {
        return 0;
    }
}
