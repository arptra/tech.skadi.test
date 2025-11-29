package com.upuphone.starrynet.strategy.pair.ble;

import Starry.StarryLinkEncrypt;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.common.utils.tracker.TrackerManager;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.discovery.IStarryNetDiscoverer;
import com.upuphone.starrynet.strategy.encrypt.StarryLinkProtocolDataParseHelper;
import com.upuphone.starrynet.strategy.encrypt.StarryNetDecryptHelper;
import com.upuphone.starrynet.strategy.encrypt.StarryNetEncryptData;
import com.upuphone.starrynet.strategy.encrypt.StarryNetEncryptHelper;
import com.upuphone.starrynet.strategy.encrypt.bean.KeyPair;
import com.upuphone.starrynet.strategy.encrypt.utils.EncryptionUtil;
import com.upuphone.starrynet.strategy.pair.IChannelModulePair;
import com.upuphone.starrynet.strategy.pair.IPairChannel;
import com.upuphone.starrynet.strategy.pair.IPairMsgCallback;
import com.upuphone.starrynet.strategy.pair.IPairStatusCallback;
import com.upuphone.starrynet.strategy.pair.StarryNetPairProcess;
import com.upuphone.starrynet.strategy.pair.StarryNetPairUtil;
import com.upuphone.starrynet.strategy.protocol.ProtocolManager;
import java.util.Arrays;

public abstract class BleChannelPair implements IPairMsgCallback, IChannelModulePair {
    private static final String TAG = "BleChannelPair";
    /* access modifiers changed from: private */
    public final IPairChannel mChannel;
    protected final PairMsgHandler mPairMsgHandler = new PairMsgHandler(Looper.getMainLooper());
    private final StarryNetPairProcess mPairProcess;
    /* access modifiers changed from: private */
    public final IPairStatusCallback mPairStatusCallback;

    public class PairMsgHandler extends Handler {
        public PairMsgHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                Bundle data = message.getData();
                byte[] byteArray = data.getByteArray("pairData");
                String string = data.getString("pairMac");
                StarryNetDecryptHelper parse = StarryNetDecryptHelper.parse(byteArray);
                if (parse == null) {
                    BleChannelPair.this.mPairStatusCallback.onPairStatus(0, 4);
                    StLog.e(BleChannelPair.TAG, "The pair message form client is null");
                    return;
                }
                BleChannelPair.this.handleMsgFromClient(parse, string);
            } else if (i == 1) {
                byte[] byteArray2 = message.getData().getByteArray("pairData");
                String str = (String) message.obj;
                StarryNetDecryptHelper parse2 = StarryNetDecryptHelper.parse(byteArray2);
                if (parse2 == null) {
                    StLog.d(BleChannelPair.TAG, "The pair message form client is null");
                    BleChannelPair.this.mPairStatusCallback.onPairStatus(0, 4);
                    return;
                }
                StConnectDevice connectDeviceByBleMac = StarryDeviceManager.getInstance().getConnectDeviceByBleMac(str);
                if (connectDeviceByBleMac == null) {
                    StLog.d(BleChannelPair.TAG, "The bondInfo message form client is null");
                    BleChannelPair.this.mPairStatusCallback.onPairStatus(0, 4);
                    return;
                }
                BleChannelPair.this.handleMsgFromServer(parse2, connectDeviceByBleMac.getDevice());
            } else if (i == 4) {
                Object obj = message.obj;
                if (obj instanceof StDevice) {
                    StDevice stDevice = (StDevice) obj;
                    BleChannelPair.this.mChannel.disconnect(stDevice);
                    BleChannelPair.this.mPairStatusCallback.onPairStatus(0, 4);
                    BleChannelPair.this.onAuthResult(stDevice, StErrorCode.CONNECT_STRATEGY_BLE_BOND_FAIL, 0);
                    return;
                }
                StLog.d(BleChannelPair.TAG, "STARRYNET_CHANNEL_BONDREQ_TIMEOUT device is null");
            } else if (i == 5) {
                Object obj2 = message.obj;
                if (obj2 instanceof StDevice) {
                    StDevice stDevice2 = (StDevice) obj2;
                    BleChannelPair.this.trackRemoveBondResult(stDevice2, true);
                    StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice2.getIdentifier());
                    if (connectDevice != null) {
                        StarryDeviceManager.getInstance().updateBondInfo(connectDevice, 0);
                    }
                    BleChannelPair.this.mChannel.disconnect(stDevice2);
                    BleChannelPair.this.mPairStatusCallback.onPairStatus(0, 0);
                    BleChannelPair.this.onAuthResult(stDevice2, StErrorCode.CONNECT_STRATEGY_BLE_UN_BOND_FAIL, 0);
                    return;
                }
                StLog.d(BleChannelPair.TAG, "STARRYNET_CHANNEL_UNBONDREQ_TIMEOUT device is null");
            }
        }
    }

    public BleChannelPair(IPairChannel iPairChannel, IPairStatusCallback iPairStatusCallback) {
        this.mPairProcess = new StarryNetPairProcess(iPairChannel);
        this.mPairStatusCallback = iPairStatusCallback;
        this.mChannel = iPairChannel;
    }

    private void handleBondMsgFromClient(StarryNetDecryptHelper starryNetDecryptHelper) {
        StDevice stDevice;
        byte[] data = starryNetDecryptHelper.getData();
        if (data.length < 2) {
            StLog.d(TAG, "receiveMsg: data is invalid");
            return;
        }
        byte b = data[0];
        byte b2 = data[1];
        byte[] bArr = new byte[(data.length - 2)];
        System.arraycopy(data, 2, bArr, 0, data.length - 2);
        if (b2 == 3) {
            StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(bArr);
            if (connectDevice != null) {
                connectDevice.setSecretAndParam((byte[]) null, (byte[]) null);
                stDevice = connectDevice.getDevice();
            } else {
                stDevice = null;
            }
            if (stDevice == null) {
                stDevice = StarryDeviceManager.getInstance().getDevice(bArr);
            }
            createBond(stDevice, (byte[]) null);
        }
    }

    private void handleBondMsgFromServer(StarryNetDecryptHelper starryNetDecryptHelper) {
        StDevice stDevice;
        byte[] data = starryNetDecryptHelper.getData();
        if (data.length < 2) {
            StLog.d(TAG, "receiveMsg: data is invalid");
            return;
        }
        byte b = data[0];
        byte b2 = data[1];
        byte[] bArr = new byte[(data.length - 2)];
        System.arraycopy(data, 2, bArr, 0, data.length - 2);
        if (b2 == 1) {
            StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(bArr);
            if (connectDevice != null) {
                if (connectDevice.isBleConnected()) {
                    StLog.d(TAG, "handleBondMsgFromServer device is connected");
                    return;
                } else if (connectDevice.getBleBondStatus() == 4) {
                    StLog.d(TAG, "handleBondMsgFromServer device is bonded");
                    connectDevice.setStatus(0);
                    StarryDeviceManager.getInstance().updateBondInfo(connectDevice);
                }
            }
            createBond(StarryDeviceManager.getInstance().getDevice(bArr), (byte[]) null);
        } else if (b2 == 2) {
            StConnectDevice connectDevice2 = StarryDeviceManager.getInstance().getConnectDevice(bArr);
            if (connectDevice2 != null) {
                TrackerManager.getInstance().getUnpairDeviceTracker().startUnpair(connectDevice2.getTerminalType(), connectDevice2.getIdentifier2String()).way(0);
            }
            removeBond(connectDevice2, (byte[]) null);
        } else if (b2 == 3) {
            StConnectDevice connectDevice3 = StarryDeviceManager.getInstance().getConnectDevice(bArr);
            if (connectDevice3 != null) {
                connectDevice3.setSecretAndParam((byte[]) null, (byte[]) null);
                stDevice = connectDevice3.getDevice();
            } else {
                stDevice = null;
            }
            if (stDevice == null) {
                stDevice = StarryDeviceManager.getInstance().getDevice(bArr);
            }
            createBond(stDevice, (byte[]) null);
        }
    }

    private void handleClientInfoMsg(StarryNetDecryptHelper starryNetDecryptHelper, String str) {
        byte[] identifier = starryNetDecryptHelper.getIdentifier();
        final StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(identifier);
        if (connectDevice == null) {
            StLog.d(TAG, "onWriteInfo info is null");
            createBond(StarryDeviceManager.getInstance().getDevice(identifier), (byte[]) null);
        } else if (connectDevice.getBleBondStatus() == 0) {
            StLog.d(TAG, "onWriteInfo, need to removeBond");
            serverRemoveBond(connectDevice);
        } else {
            StLog.d(TAG, "handleClientInfoMsg process");
            StarryLinkEncrypt.WriteSwitchInfo writeInfo = starryNetDecryptHelper.getWriteInfo(connectDevice.getCipher(), connectDevice.getEncrypt());
            if (writeInfo == null) {
                StLog.d(TAG, "switch info is null");
                createBond(StarryDeviceManager.getInstance().getDevice(identifier), (byte[]) null);
                return;
            }
            IStarryNetDiscoverer discoveryManager = StarryNetData.getInstance().getDiscoveryManager();
            if (discoveryManager == null || discoveryManager.getReconnectEnable()) {
                StarryLinkEncrypt.DeviceInfo parseDeviceInfo = StarryLinkProtocolDataParseHelper.parseDeviceInfo(StarryNetDecryptHelper.decryptInfo(writeInfo.getInfo().toByteArray(), connectDevice.getCipher(), connectDevice.getEncrypt()));
                connectDevice.setCompanyID(parseDeviceInfo.getCompanyId());
                connectDevice.setCategoryID(parseDeviceInfo.getCategoryId());
                connectDevice.setModelID(parseDeviceInfo.getModelId());
                connectDevice.setDeviceName(parseDeviceInfo.getName().toStringUtf8());
                connectDevice.setBleMac(str);
                if (connectDevice.getTerminalType() != 6) {
                    connectDevice.setBrEdrMac(parseDeviceInfo.getBtMac());
                }
                if (connectDevice.getBleBondStatus() == 4) {
                    this.mChannel.sendMsg(connectDevice.getDevice(), 1, StarryNetPairUtil.handleWriteInfo(connectDevice), new IPairMsgCallback() {
                        public void onResponse(StDevice stDevice, byte[] bArr, int i) {
                            BleChannelPair.this.trackSwitchInfoResult(stDevice, 1, i);
                            if (i != 0) {
                                StLog.d(BleChannelPair.TAG, "send message fail");
                                BleChannelPair.this.onAuthResult(stDevice, StErrorCode.CONNECT_STRATEGY_BLE_BOND_SEND_FAIL, 1);
                                BleChannelPair.this.mChannel.updateBondStateChanged(connectDevice.getDevice(), 0);
                                BleChannelPair.this.processPairFailMsg(1, 1, stDevice);
                                BleChannelPair.this.mPairStatusCallback.onPairStatus(0, 4);
                            }
                        }
                    });
                }
                StarryDeviceManager.getInstance().updateBondInfo(connectDevice, 4);
                this.mChannel.updateBondStateChanged(connectDevice.getDevice(), 4);
                return;
            }
            StLog.w(TAG, "forbidden reConnect, disconnect");
            discoveryManager.setCarActiveDisconnect(connectDevice.getIdentifier2String());
            ProtocolManager.getInstance().getStarryNetProtocol().sendStarryNetMsg(connectDevice.getDevice(), StarryNetEncryptHelper.generateDisconnectBle());
        }
    }

    private void handleClientKeyMsg(StarryNetDecryptHelper starryNetDecryptHelper) {
        byte[] byteArray = starryNetDecryptHelper.getWriteKey().getKey().toByteArray();
        final StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(starryNetDecryptHelper.getWriteKey().getInfo().toByteArray());
        if (connectDevice == null) {
            StLog.d(TAG, "Device is not connected");
            this.mPairStatusCallback.onPairStatus(0, 4);
            return;
        }
        this.mChannel.sendMsg(connectDevice.getDevice(), 1, StarryNetPairUtil.handleWriteKey(byteArray, connectDevice), new IPairMsgCallback() {
            public void onResponse(StDevice stDevice, byte[] bArr, int i) {
                BleChannelPair.this.trackSwitchKeyResult(stDevice, 1, i);
                if (i != 0) {
                    StLog.d(BleChannelPair.TAG, "send message fail");
                    BleChannelPair.this.onAuthResult(stDevice, StErrorCode.CONNECT_STRATEGY_BLE_BOND_SEND_FAIL, 1);
                    StarryDeviceManager.getInstance().updateBondInfo(connectDevice, 0);
                    BleChannelPair.this.mChannel.updateBondStateChanged(stDevice, 0);
                    BleChannelPair.this.processPairFailMsg(1, 1, stDevice);
                    BleChannelPair.this.mPairStatusCallback.onPairStatus(0, 4);
                    return;
                }
                StarryDeviceManager.getInstance().updateBondInfo(connectDevice, 3);
                BleChannelPair.this.mChannel.updateBondStateChanged(stDevice, 3);
            }
        });
    }

    private void handleClientUnPair(StarryNetDecryptHelper starryNetDecryptHelper, String str) {
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(starryNetDecryptHelper.getIdentifier());
        if (connectDevice == null) {
            StLog.d(TAG, "onUnBond info is null");
            this.mPairStatusCallback.onPairStatus(0, 4);
            return;
        }
        StarryDeviceManager.getInstance().updateBondInfo(connectDevice, 0);
        this.mChannel.updateBondStateChanged(connectDevice.getDevice(), 0);
        this.mPairStatusCallback.onPairStatus(0, 0);
    }

    /* access modifiers changed from: private */
    public void handleMsgFromClient(StarryNetDecryptHelper starryNetDecryptHelper, String str) {
        StarryLinkEncrypt.COMMAND command = starryNetDecryptHelper.getCommand();
        if (command == StarryLinkEncrypt.COMMAND.WRITE_SWITCH_KEY) {
            handleClientKeyMsg(starryNetDecryptHelper);
        } else if (command == StarryLinkEncrypt.COMMAND.WRITE_SWITCH_INFO) {
            handleClientInfoMsg(starryNetDecryptHelper, str);
        } else if (command == StarryLinkEncrypt.COMMAND.UN_BONDED) {
            handleClientUnPair(starryNetDecryptHelper, str);
        } else if (command == StarryLinkEncrypt.COMMAND.BOND_MSG_CHANGE) {
            handleBondMsgFromClient(starryNetDecryptHelper);
        }
    }

    /* access modifiers changed from: private */
    public void handleMsgFromServer(StarryNetDecryptHelper starryNetDecryptHelper, StDevice stDevice) {
        StarryLinkEncrypt.COMMAND command = starryNetDecryptHelper.getCommand();
        if (command == StarryLinkEncrypt.COMMAND.WRITE_SWITCH_KEY) {
            handleServerKeyMsg(starryNetDecryptHelper, stDevice);
        } else if (command == StarryLinkEncrypt.COMMAND.BOND_MSG_CHANGE) {
            handleBondMsgFromServer(starryNetDecryptHelper);
        } else if (command == StarryLinkEncrypt.COMMAND.WRITE_SWITCH_INFO) {
            handleServerInfoMsg(starryNetDecryptHelper, stDevice.getBleMac());
        }
    }

    private void handleServerInfoMsg(StarryNetDecryptHelper starryNetDecryptHelper, String str) {
        byte[] identifier = starryNetDecryptHelper.getIdentifier();
        StLog.d(TAG, "handleServerInfoMsg identifier is " + Arrays.toString(identifier));
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(identifier);
        if (connectDevice == null) {
            StLog.d(TAG, "handleServerInfoMsg info is null");
            createBond(StarryDeviceManager.getInstance().getDevice(identifier), (byte[]) null);
            return;
        }
        StarryLinkEncrypt.WriteSwitchInfo writeInfo = starryNetDecryptHelper.getWriteInfo(connectDevice.getCipher(), connectDevice.getEncrypt());
        if (writeInfo == null) {
            StLog.d(TAG, "handleServerInfoMsg switch info is null");
            createBond(StarryDeviceManager.getInstance().getDevice(identifier), (byte[]) null);
            return;
        }
        StarryLinkEncrypt.DeviceInfo parseDeviceInfo = StarryLinkProtocolDataParseHelper.parseDeviceInfo(StarryNetDecryptHelper.decryptInfo(writeInfo.getInfo().toByteArray(), connectDevice.getCipher(), connectDevice.getEncrypt()));
        connectDevice.setBrEdrMac(parseDeviceInfo.getBtMac());
        connectDevice.setCompanyID(parseDeviceInfo.getCompanyId());
        connectDevice.setCategoryID(parseDeviceInfo.getCategoryId());
        connectDevice.setModelID(parseDeviceInfo.getModelId());
        connectDevice.setDeviceName(parseDeviceInfo.getName().toStringUtf8());
        connectDevice.setBleMac(str);
        trackSwitchInfoResult(connectDevice.getDevice(), 0, 0);
        StarryDeviceManager.getInstance().updateBondInfo(connectDevice, 4);
        this.mChannel.updateBondStateChanged(connectDevice.getDevice(), 4);
    }

    private void handleServerKeyMsg(StarryNetDecryptHelper starryNetDecryptHelper, StDevice stDevice) {
        StarryLinkEncrypt.WriteSwitchKey writeKey = starryNetDecryptHelper.getWriteKey();
        if (writeKey == null) {
            StLog.d(TAG, "Write keyInfo form server is null");
            trackSwitchKeyResult(stDevice, 0, -38);
            onAuthResult(stDevice, StErrorCode.CONNECT_STRATEGY_BLE_BOND_FAIL, 0);
            processPairFailMsg(0, 1, stDevice);
            this.mPairStatusCallback.onPairStatus(0, 0);
            return;
        }
        byte[] byteArray = writeKey.getKey().toByteArray();
        byte[] subArray = ByteUtils.subArray(byteArray, byteArray.length - 16);
        byte[] subArray2 = ByteUtils.subArray(byteArray, 0, byteArray.length - 16);
        KeyPair keyPair = StarryNetEncryptData.getInstance().getKeyPair(stDevice.getIdentifier2String());
        if (keyPair == null) {
            StLog.d(TAG, "handleServerKeyMsg KeyPair is null, mac = " + stDevice.getIdentifier2String());
            trackSwitchKeyResult(stDevice, 0, -38);
            onAuthResult(stDevice, StErrorCode.CONNECT_STRATEGY_BLE_BOND_STATUS_ERROR, 0);
            processPairFailMsg(0, 1, stDevice);
            this.mPairStatusCallback.onPairStatus(0, 0);
            return;
        }
        final StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
        if (connectDevice == null) {
            StLog.d(TAG, "Client BondInfo is null");
            trackSwitchKeyResult(stDevice, 0, -6);
            onAuthResult(stDevice, StErrorCode.CONNECT_STRATEGY_BLE_BOND_STATUS_ERROR, 0);
            processPairFailMsg(0, 1, stDevice);
            this.mPairStatusCallback.onPairStatus(0, 0);
            return;
        }
        byte[] secretKey = EncryptionUtil.getSecretKey(subArray2, keyPair.getPrivateKey());
        byte[] decrypt = EncryptionUtil.decrypt(writeKey.getInfo().toByteArray(), secretKey, subArray, connectDevice.getEncrypt());
        if (decrypt == null) {
            StLog.d(TAG, "Client BondInfo is cipher error");
            trackSwitchKeyResult(stDevice, 0, -33);
            onAuthResult(stDevice, StErrorCode.CONNECT_STRATEGY_BLE_BOND_STATUS_ERROR, 0);
            processPairFailMsg(0, 1, stDevice);
            this.mPairStatusCallback.onPairStatus(0, 0);
            return;
        }
        StarryLinkEncrypt.DeviceInfo parseDeviceInfo = StarryLinkProtocolDataParseHelper.parseDeviceInfo(decrypt);
        if (parseDeviceInfo == null) {
            StLog.d(TAG, "peer device is null");
            trackSwitchKeyResult(stDevice, 0, -32);
            onAuthResult(stDevice, StErrorCode.CONNECT_STRATEGY_BLE_BOND_STATUS_ERROR, 0);
            processPairFailMsg(0, 1, stDevice);
            this.mPairStatusCallback.onPairStatus(0, 0);
            return;
        }
        connectDevice.setSecretAndParam(secretKey, subArray);
        connectDevice.setIdentifier(stDevice.getIdentifier());
        connectDevice.setBrEdrMac(parseDeviceInfo.getBtMac());
        connectDevice.setCategoryID(parseDeviceInfo.getCategoryId());
        connectDevice.setCompanyID(parseDeviceInfo.getCompanyId());
        connectDevice.setModelID(parseDeviceInfo.getModelId());
        connectDevice.setDeviceName(parseDeviceInfo.getName().toStringUtf8());
        StarryDeviceManager.getInstance().updateBondInfo(connectDevice);
        this.mChannel.sendMsg(stDevice, 0, StarryNetPairUtil.handleWriteInfo(connectDevice), new IPairMsgCallback() {
            public void onResponse(StDevice stDevice, byte[] bArr, int i) {
                BleChannelPair.this.trackSwitchKeyResult(stDevice, 0, i);
                if (i != 0) {
                    StLog.d(BleChannelPair.TAG, "send message fail");
                    BleChannelPair.this.onAuthResult(stDevice, StErrorCode.CONNECT_STRATEGY_BLE_BOND_SEND_FAIL, 0);
                    StarryDeviceManager.getInstance().updateBondInfo(connectDevice, 0);
                    BleChannelPair.this.mChannel.updateBondStateChanged(connectDevice.getDevice(), 0);
                    BleChannelPair.this.processPairFailMsg(0, 1, stDevice);
                    BleChannelPair.this.mPairStatusCallback.onPairStatus(0, 0);
                } else if (StarryLinkProtocolDataParseHelper.parseLinkProtocolData(bArr) == null) {
                    StLog.d(BleChannelPair.TAG, "StarryNetDecryptHelper parse null");
                    BleChannelPair.this.onAuthResult(stDevice, StErrorCode.CONNECT_STRATEGY_BLE_BOND_FAIL, 0);
                    BleChannelPair.this.processPairFailMsg(0, 1, stDevice);
                    StarryDeviceManager.getInstance().updateBondInfo(connectDevice, 0);
                    BleChannelPair.this.mChannel.updateBondStateChanged(connectDevice.getDevice(), 0);
                    BleChannelPair.this.mPairStatusCallback.onPairStatus(0, 0);
                } else {
                    StLog.d(BleChannelPair.TAG, "handleServerKeyMsg State changed to Bonded");
                    StarryDeviceManager.getInstance().updateBondInfo(connectDevice, 4);
                    BleChannelPair.this.mChannel.updateBondStateChanged(connectDevice.getDevice(), 4);
                    BleChannelPair.this.mPairStatusCallback.onPairStatus(0, 4);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void onAuthResult(StDevice stDevice, int i, int i2) {
        StarryDeviceManager.getInstance().connectFail(stDevice, i, 1);
    }

    /* access modifiers changed from: private */
    public void processPairFailMsg(int i, int i2, StDevice stDevice) {
        if (i2 == 1) {
            this.mChannel.disconnect(stDevice);
        } else if (i2 == 2) {
            updateKey(stDevice, i, (byte[]) null);
        }
    }

    private void startTimer(int i, int i2, StDevice stDevice) {
        if (this.mPairMsgHandler.hasMessages(i)) {
            this.mPairMsgHandler.removeMessages(i);
        }
        PairMsgHandler pairMsgHandler = this.mPairMsgHandler;
        pairMsgHandler.sendMessageDelayed(pairMsgHandler.obtainMessage(i, stDevice), (long) i2);
    }

    /* access modifiers changed from: private */
    public void stopTimer(int i) {
        if (this.mPairMsgHandler.hasMessages(i)) {
            this.mPairMsgHandler.removeMessages(i);
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

    /* access modifiers changed from: private */
    public void trackSwitchInfoResult(StDevice stDevice, int i, int i2) {
        if (stDevice.getTerminalType() == 2) {
            TrackerManager.getInstance().getDeviceSwitchStateTracker().bleSwitchInfoResult(stDevice.getTerminalType(), stDevice.getIdentifier2String(), i, i2).peerModelID(stDevice.getModelID()).startReport();
        }
    }

    /* access modifiers changed from: private */
    public void trackSwitchKeyResult(StDevice stDevice, int i, int i2) {
        if (stDevice.getTerminalType() == 2) {
            TrackerManager.getInstance().getDeviceSwitchStateTracker().bleSwitchKeyResult(stDevice.getTerminalType(), stDevice.getIdentifier2String(), i, i2).peerModelID(stDevice.getModelID()).startReport();
        }
    }

    private void updateKey(StDevice stDevice, final int i, byte[] bArr) {
        if (bArr == null) {
            StLog.d(TAG, "update key data is null");
            return;
        }
        byte[] identifier = StarryNetData.getInstance().getIdentifier();
        byte[] bArr2 = new byte[(identifier.length + bArr.length)];
        System.arraycopy(identifier, 0, bArr2, 0, identifier.length);
        System.arraycopy(bArr, 0, bArr2, identifier.length, bArr.length);
        byte[] switchExMsg = StarryNetPairUtil.switchExMsg((byte) i, (byte) 3, bArr2);
        startTimer(6, 5000, stDevice);
        this.mChannel.sendMsg(stDevice, i, switchExMsg, new IPairMsgCallback() {
            public void onResponse(StDevice stDevice, byte[] bArr, int i) {
                BleChannelPair.this.stopTimer(6);
                if (i != 0) {
                    BleChannelPair.this.onAuthResult(stDevice, StErrorCode.CONNECT_STRATEGY_BLE_BOND_STATUS_ERROR, i);
                    BleChannelPair.this.mPairStatusCallback.onPairStatus(0, 4);
                    StLog.d(BleChannelPair.TAG, "update key send fail");
                }
            }
        });
    }

    public void clientCreateBond(StDevice stDevice, byte[] bArr) {
        byte[] bArr2;
        StLog.d(TAG, "clientCreateBond");
        String identifier2String = StarryNetData.getInstance().getOwnDevice().getIdentifier2String();
        final StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
        if (connectDevice == null || connectDevice.getBleBondStatus() != 4) {
            bArr2 = StarryNetPairUtil.writeKey(stDevice.getIdentifier2String(), identifier2String);
            this.mChannel.updateBondStateChanged(stDevice, 3);
            StarryDeviceManager.getInstance().updateBondInfo(connectDevice, 3);
        } else {
            bArr2 = StarryNetPairUtil.switchInfo(connectDevice);
        }
        startTimer(4, 5000, stDevice);
        this.mPairProcess.sendMsgWithRsp(stDevice, 0, bArr2, new IPairMsgCallback((byte) 0) {
            public void onResponse(StDevice stDevice, byte[] bArr, int i) {
                BleChannelPair.this.stopTimer(4);
                if (i != 0) {
                    StConnectDevice stConnectDevice = connectDevice;
                    if (stConnectDevice == null || stConnectDevice.getBleBondStatus() != 4) {
                        BleChannelPair.this.trackSwitchKeyResult(stDevice, (byte) 0, i);
                    } else {
                        BleChannelPair.this.trackSwitchInfoResult(stDevice, (byte) 0, i);
                    }
                    BleChannelPair.this.onAuthResult(stDevice, StErrorCode.CONNECT_STRATEGY_BLE_BOND_SEND_FAIL, (byte) 0);
                    BleChannelPair.this.processPairFailMsg(0, 1, stDevice);
                    BleChannelPair.this.mPairStatusCallback.onPairStatus(0, 0);
                }
            }
        });
    }

    public void clientRemoveBond(final StConnectDevice stConnectDevice) {
        byte[] unPair = StarryNetPairUtil.unPair();
        startTimer(5, 5000, stConnectDevice.getDevice());
        this.mChannel.sendMsg(stConnectDevice.getDevice(), 0, unPair, new IPairMsgCallback() {
            public void onResponse(StDevice stDevice, byte[] bArr, int i) {
                BleChannelPair.this.stopTimer(5);
                boolean z = false;
                StarryDeviceManager.getInstance().updateBondInfo(stConnectDevice, 0);
                BleChannelPair.this.mChannel.updateBondStateChanged(stConnectDevice.getDevice(), 0);
                BleChannelPair.this.mPairStatusCallback.onPairStatus(0, 0);
                BleChannelPair.this.processPairFailMsg(0, 1, stConnectDevice.getDevice());
                BleChannelPair bleChannelPair = BleChannelPair.this;
                if (i != 0) {
                    z = true;
                }
                bleChannelPair.trackRemoveBondResult(stDevice, z);
            }
        });
    }

    public void createBond(StDevice stDevice, byte[] bArr) {
    }

    public void onResponse(StDevice stDevice, byte[] bArr, int i) {
    }

    public void removeBond(StConnectDevice stConnectDevice, byte[] bArr) {
        StLog.d(TAG, "removeBond");
        if (stConnectDevice == null) {
            StLog.i(TAG, "removeBond the bondInfo is null");
            this.mPairStatusCallback.onPairStatus(0, 4);
            return;
        }
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stConnectDevice.getIdentifier());
        if (connectDevice == null || !connectDevice.isBleConnected()) {
            StLog.i(TAG, "remove Bond when ble disconnected");
            StarryDeviceManager.getInstance().updateBondInfo(stConnectDevice, 0);
            this.mChannel.updateBondStateChanged(stConnectDevice.getDevice(), 0);
            this.mPairStatusCallback.onPairStatus(0, 0);
        }
    }

    public void serverCreateBond(StDevice stDevice, byte[] bArr) {
        StLog.d(TAG, "serverCreateBond");
        byte[] switchExMsg = StarryNetPairUtil.switchExMsg((byte) 1, (byte) 1, StarryNetData.getInstance().getOwnDevice().getIdentifier());
        startTimer(4, 5000, stDevice);
        this.mPairProcess.sendMsgWithRsp(stDevice, 1, switchExMsg, new IPairMsgCallback((byte) 1) {
            public void onResponse(StDevice stDevice, byte[] bArr, int i) {
                BleChannelPair.this.stopTimer(4);
                if (i != 0) {
                    StLog.i(BleChannelPair.TAG, " send message fail");
                    BleChannelPair.this.processPairFailMsg((byte) 1, 1, stDevice);
                    BleChannelPair.this.onAuthResult(stDevice, StErrorCode.CONNECT_STRATEGY_BLE_BOND_SEND_FAIL, (byte) 1);
                    BleChannelPair.this.mPairStatusCallback.onPairStatus(0, 0);
                    return;
                }
                BleChannelPair.this.mChannel.updateBondStateChanged(stDevice, 3);
            }
        });
    }

    public void serverRemoveBond(final StConnectDevice stConnectDevice) {
        startTimer(5, 5000, stConnectDevice.getDevice());
        this.mChannel.sendMsg(stConnectDevice.getDevice(), 1, StarryNetPairUtil.switchExMsg((byte) 1, (byte) 2, StarryNetData.getInstance().getOwnDevice().getIdentifier()), new IPairMsgCallback() {
            public void onResponse(StDevice stDevice, byte[] bArr, int i) {
                BleChannelPair.this.stopTimer(5);
                boolean z = true;
                if (i != 0) {
                    StarryDeviceManager.getInstance().updateBondInfo(stConnectDevice, 0);
                    BleChannelPair.this.processPairFailMsg(1, 1, stDevice);
                    BleChannelPair.this.mPairStatusCallback.onPairStatus(0, 4);
                }
                BleChannelPair bleChannelPair = BleChannelPair.this;
                if (i == 0) {
                    z = false;
                }
                bleChannelPair.trackRemoveBondResult(stDevice, z);
            }
        });
    }
}
