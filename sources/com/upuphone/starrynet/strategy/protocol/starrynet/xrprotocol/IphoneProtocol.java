package com.upuphone.starrynet.strategy.protocol.starrynet.xrprotocol;

import Starry.StarryLinkEncrypt;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.server.BleServerCache;
import com.upuphone.starrynet.core.bredr.BrEdrDeviceManager;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.IMessageChannel;
import com.upuphone.starrynet.strategy.channel.StarryNetChannelManager;
import com.upuphone.starrynet.strategy.channel.bredr.BrEdrChannel;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.encrypt.StarryNetDecryptHelper;
import com.upuphone.starrynet.strategy.encrypt.StarryNetEncryptHelper;
import com.upuphone.starrynet.strategy.pair.IPairMsgCallback;
import com.upuphone.starrynet.strategy.pair.StarryNetPairConstant;
import com.upuphone.starrynet.strategy.protocol.starrynet.XRStarryNetProtocol;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IphoneProtocol implements XrChildProtocol {
    private static final int MSG_IOS_CONNECT_TIMEOUT = 4118;
    private static final String TAG = "IphoneProtocol";
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(@NonNull Message message) {
            if (message.what == IphoneProtocol.MSG_IOS_CONNECT_TIMEOUT) {
                StConnectDevice stConnectDevice = (StConnectDevice) message.obj;
                StLog.d(IphoneProtocol.TAG, "handle ios connect bt timeout, timeout =" + message.arg1 + ",cycleCount=" + message.arg2 + ",name=" + stConnectDevice.getDeviceName());
                if (!TextUtils.isEmpty(stConnectDevice.getDeviceName())) {
                    IphoneProtocol.this.mIOSBondCancelOrTimeOutSet.remove(stConnectDevice.getDeviceName());
                }
                if (stConnectDevice.getBleBondStatus() == 0 && stConnectDevice.getBrEdrBondStatus() == 48) {
                    StLog.w(IphoneProtocol.TAG, "handle ios connect bt timeout, ble not bond ,bt bond ,then removeBond bt");
                    BrEdrDeviceManager.removeBrEdrBond(StarryDeviceManager.getInstance().getBluetoothDevice(stConnectDevice.getDevice()));
                }
                StarryDeviceManager.getInstance().connectFail(stConnectDevice.getDevice(), StErrorCode.CONNECT_STRATEGY_BLE_BOND_TIMEOUT, 1);
            }
        }
    };
    /* access modifiers changed from: private */
    public Set<String> mIOSBondCancelOrTimeOutSet = new HashSet();
    private XRStarryNetProtocol mXrProtocol;

    /* renamed from: com.upuphone.starrynet.strategy.protocol.starrynet.xrprotocol.IphoneProtocol$4  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$Starry$StarryLinkEncrypt$COMMAND;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                Starry.StarryLinkEncrypt$COMMAND[] r0 = Starry.StarryLinkEncrypt.COMMAND.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$Starry$StarryLinkEncrypt$COMMAND = r0
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.IOS_CONNECT_BT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x001d }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.REQUEST_STATUS_BT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.strategy.protocol.starrynet.xrprotocol.IphoneProtocol.AnonymousClass4.<clinit>():void");
        }
    }

    public IphoneProtocol(XRStarryNetProtocol xRStarryNetProtocol) {
        this.mXrProtocol = xRStarryNetProtocol;
    }

    private void dealBluetoothConnect(StConnectDevice stConnectDevice) {
        StLog.d(TAG, "dealBluetoothConnect for ios");
        if (stConnectDevice == null || stConnectDevice.getBrEdrMac() == null) {
            StLog.w(TAG, "deal ios BluetoothConnect, bredr mac is null");
        } else if (stConnectDevice.getBrEdrBondStatus() != 48) {
            StLog.w(TAG, "dealBluetoothConnect, ble bonded but not bond bredr");
            notifyBtStateToIos(stConnectDevice);
        } else if (stConnectDevice.getDevice().isBrEdrConnected()) {
            notifyBtStateToIos(stConnectDevice);
        }
    }

    @SuppressLint({"MissingPermission"})
    private BluetoothDevice findConnectIOSDevice(BrEdrChannel brEdrChannel, StarryLinkEncrypt.IOSConnectBt iOSConnectBt) {
        if (iOSConnectBt == null || TextUtils.isEmpty(iOSConnectBt.getDeviceName())) {
            StLog.d(TAG, "findConnectIOSDevice connectBt(pb) is null");
            return brEdrChannel.getActiveDevice();
        }
        Map<BluetoothDevice, Integer> brEdrConnectedDeviceList = brEdrChannel.getBrEdrConnectedDeviceList();
        if (brEdrConnectedDeviceList == null || brEdrConnectedDeviceList.size() <= 0) {
            StLog.w(TAG, "findConnectIOSDevice devices is empty!");
            return null;
        }
        for (Map.Entry next : brEdrConnectedDeviceList.entrySet()) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) next.getKey();
            int intValue = next.getValue() != null ? ((Integer) next.getValue()).intValue() : -1;
            StLog.d(TAG, "findConnectIOSDevice entry device(%s), profile =%d", bluetoothDevice.getName(), Integer.valueOf(intValue));
            if (intValue > 0 && bluetoothDevice.getName().equals(iOSConnectBt.getDeviceName())) {
                StLog.d(TAG, "findConnectIOSDevice match name:" + iOSConnectBt.getDeviceName());
                return bluetoothDevice;
            }
        }
        return null;
    }

    @SuppressLint({"MissingPermission"})
    private void handleConnectBrEdrFromClient(StarryNetDecryptHelper starryNetDecryptHelper) {
        byte[] identifier = starryNetDecryptHelper.getIdentifier();
        StLog.d(TAG, "handleConnectBrEdrFromClient identifier is " + Arrays.toString(identifier));
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(identifier);
        if (connectDevice == null) {
            StLog.w(TAG, "handleConnectBrEdrFromClient info is null");
            return;
        }
        StarryLinkEncrypt.IOSConnectBt iOSConnectBt = starryNetDecryptHelper.getIOSConnectBt();
        connectDevice.setTerminalType((byte) 6);
        if (connectDevice.getBleBondStatus() == 3) {
            StLog.w(TAG, "before ready, modify ble bond state =0");
            connectDevice.setStatus(0);
        }
        BrEdrChannel brEdrChannel = (BrEdrChannel) StarryNetChannelManager.getInstance().getConnectChannel(21);
        BluetoothDevice findConnectIOSDevice = findConnectIOSDevice(brEdrChannel, iOSConnectBt);
        if (findConnectIOSDevice != null) {
            syncIosBrEdrMac(connectDevice, findConnectIOSDevice, brEdrChannel);
            this.mXrProtocol.sendMsg(connectDevice.getDevice(), 1, StarryNetEncryptHelper.generateBtConnectStateData(true, connectDevice), new IPairMsgCallback() {
                public void onResponse(StDevice stDevice, byte[] bArr, int i) {
                    if (i != 0) {
                        StLog.w(IphoneProtocol.TAG, "handleConnectBrEdrFromClient, notify to ios connected fail!");
                    }
                }
            });
            brEdrChannel.setScanMode(21);
            connectDevice.setPreConnect(false);
            return;
        }
        brEdrChannel.setDiscoverableTimeout(StarryNetPairConstant.STARRYNET_DISCOVERABLE_TIMEOUT);
        brEdrChannel.setScanMode(23);
        if (connectDevice.getBleBondStatus() == 0) {
            handleIosConnectBt(connectDevice, iOSConnectBt);
            connectDevice.setPreConnect(true);
            if (iOSConnectBt != null && !TextUtils.isEmpty(iOSConnectBt.getDeviceName())) {
                connectDevice.setDeviceName(iOSConnectBt.getDeviceName());
            }
        }
        this.mXrProtocol.sendMsg(connectDevice.getDevice(), 1, StarryNetEncryptHelper.generateBtConnectStateData(false, connectDevice), new IPairMsgCallback() {
            public void onResponse(StDevice stDevice, byte[] bArr, int i) {
                if (i != 0) {
                    StLog.w(IphoneProtocol.TAG, "handleConnectBrEdrFromClient, notify to ios no Connected device fail!");
                }
            }
        });
    }

    private void handleIosConnectBt(StConnectDevice stConnectDevice, StarryLinkEncrypt.IOSConnectBt iOSConnectBt) {
        if (iOSConnectBt == null) {
            StLog.w(TAG, "handleIosConnect, connectBt object is null");
            return;
        }
        int timeout = iOSConnectBt.getTimeout();
        int cycleCount = iOSConnectBt.getCycleCount();
        boolean isFirstConnect = iOSConnectBt.getIsFirstConnect();
        StLog.d(TAG, "handleIosConnect, name = " + iOSConnectBt.getDeviceName() + ", isFirstConnect=" + isFirstConnect + ", timeout=" + timeout + ",cycleCount=" + cycleCount);
        if (cycleCount > 3) {
            cancelIosBtTimeout();
            StarryDeviceManager.getInstance().connectFail(stConnectDevice.getDevice(), StErrorCode.CONNECT_STRATEGY_BLE_BOND_TIMEOUT, 1);
            return;
        }
        if (this.mHandler.hasMessages(MSG_IOS_CONNECT_TIMEOUT)) {
            StLog.d(TAG, "handleIosConnect, exist ios connect timeout msg, remove it.");
            this.mHandler.removeMessages(MSG_IOS_CONNECT_TIMEOUT);
        }
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(MSG_IOS_CONNECT_TIMEOUT, timeout, cycleCount, stConnectDevice), (long) (timeout * 1000));
    }

    private void syncIosBrEdrMac(StConnectDevice stConnectDevice, BluetoothDevice bluetoothDevice, BrEdrChannel brEdrChannel) {
        stConnectDevice.setBrEdrMac(bluetoothDevice.getAddress());
        StarryDeviceManager.getInstance().updateBondInfo(stConnectDevice, 48);
        Map<BluetoothDevice, Integer> brEdrConnectedDeviceList = brEdrChannel.getBrEdrConnectedDeviceList();
        if (brEdrConnectedDeviceList == null || brEdrConnectedDeviceList.size() != 0) {
            int intValue = brEdrConnectedDeviceList.get(bluetoothDevice).intValue();
            if ((intValue & 512) != 0) {
                StarryDeviceManager.getInstance().deviceConnected(stConnectDevice, 64);
            }
            if ((intValue & 1024) != 0) {
                StarryDeviceManager.getInstance().deviceConnected(stConnectDevice, 128);
            }
            if ((intValue & 2048) != 0) {
                StarryDeviceManager.getInstance().deviceConnected(stConnectDevice, 256);
                return;
            }
            return;
        }
        StLog.w(TAG, "syncIosBrEdrMac, none Connected device!");
    }

    private boolean triggerBondCancelOrTimeout(StConnectDevice stConnectDevice) {
        if (stConnectDevice.getBrEdrBondStatus() == 48 || TextUtils.isEmpty(stConnectDevice.getDeviceName()) || !this.mIOSBondCancelOrTimeOutSet.remove(stConnectDevice.getDeviceName())) {
            return false;
        }
        StLog.d(TAG, "triggerBondCancelOrTimeout: edr bond cancel or timeout");
        this.mXrProtocol.sendMsg(stConnectDevice.getDevice(), StarryNetEncryptHelper.generateBtStateChangeData(49, stConnectDevice));
        return true;
    }

    public void cancelIosBtTimeout() {
        if (this.mHandler.hasMessages(MSG_IOS_CONNECT_TIMEOUT)) {
            StLog.d(TAG, "cancel ios bt timeout");
            this.mHandler.removeMessages(MSG_IOS_CONNECT_TIMEOUT);
        }
    }

    public boolean dealStarryNetMsg(StConnectDevice stConnectDevice, IMessageChannel iMessageChannel, StarryNetDecryptHelper starryNetDecryptHelper) {
        int i = AnonymousClass4.$SwitchMap$Starry$StarryLinkEncrypt$COMMAND[starryNetDecryptHelper.getCommand().ordinal()];
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            notifyBtStateToIos(stConnectDevice);
            return true;
        } else if (this.mXrProtocol.mPair == null) {
            StLog.d(TAG, "deal with ios connect bt command, mPair is null, return!!! ");
            return true;
        } else {
            if (triggerBondCancelOrTimeout(stConnectDevice)) {
                cancelIosBtTimeout();
                StarryDeviceManager.getInstance().connectFail(stConnectDevice.getDevice(), StErrorCode.CONNECT_STRATEGY_BLE_BOND_TIMEOUT, 1);
            } else if (iMessageChannel != null) {
                handleConnectBrEdrFromClient(starryNetDecryptHelper);
            }
            return true;
        }
    }

    public int getTargetTerminalType() {
        return 6;
    }

    public void notifyBtStateToIos(StConnectDevice stConnectDevice) {
        if (stConnectDevice.getBrEdrBondStatus() != 48) {
            this.mXrProtocol.sendMsg(stConnectDevice.getDevice(), StarryNetEncryptHelper.generateBtStateChangeData(stConnectDevice.getBrEdrBondStatus(), stConnectDevice));
            return;
        }
        int protocolStatus = stConnectDevice.getProtocolStatus();
        if ((protocolStatus & 64) != 0) {
            if ((protocolStatus & 128) != 0) {
                this.mXrProtocol.sendMsg(stConnectDevice.getDevice(), StarryNetEncryptHelper.generateBtStateChangeData(128, stConnectDevice));
            }
            if ((protocolStatus & 256) != 0) {
                this.mXrProtocol.sendMsg(stConnectDevice.getDevice(), StarryNetEncryptHelper.generateBtStateChangeData(256, stConnectDevice));
                return;
            }
            return;
        }
        this.mXrProtocol.sendMsg(stConnectDevice.getDevice(), StarryNetEncryptHelper.generateBtStateChangeData(48, stConnectDevice));
    }

    public void onBleServerConnected(StConnectDevice stConnectDevice) {
        StLog.d(TAG, "onBleServerConnected");
        dealBluetoothConnect(stConnectDevice);
        BleServerCache.getInstance().updateServerLogicConnected4IOS(stConnectDevice.getBleMac(), true);
        cancelIosBtTimeout();
    }

    public boolean onBleServerDisconnected(StConnectDevice stConnectDevice) {
        if (stConnectDevice.isPreConnect()) {
            StLog.d(TAG, "is ios pre connect");
            StarryDeviceManager.getInstance().connectFail(stConnectDevice.getDevice(), StErrorCode.CONNECT_STRATEGY_BLE_PRE_CONNECT, 1);
            return true;
        }
        StLog.d(TAG, "onBleServerDisconnected");
        cancelIosBtTimeout();
        return false;
    }

    public void onBrEdrBondStateChange(StConnectDevice stConnectDevice, int i, int i2) {
        if (i2 == 32 && i == 16) {
            StLog.w(TAG, "onBrEdrBondStateChange, cancel bond or bond timeout, " + stConnectDevice);
            if (!TextUtils.isEmpty(stConnectDevice.getDeviceName())) {
                this.mIOSBondCancelOrTimeOutSet.add(stConnectDevice.getDeviceName());
            }
        }
        int bluetoothDeviceType = stConnectDevice.getBluetoothDeviceType();
        StLog.d(TAG, "onBrEdrBondStateChange, sync state to ios, " + stConnectDevice.getDeviceName() + ", device type(2:ble)=" + bluetoothDeviceType);
        if (bluetoothDeviceType == 2) {
            byte[] generateBleStateChangeData = StarryNetEncryptHelper.generateBleStateChangeData(i, stConnectDevice);
            if (generateBleStateChangeData != null) {
                this.mXrProtocol.sendMsg(stConnectDevice.getDevice(), generateBleStateChangeData);
                return;
            }
            return;
        }
        this.mXrProtocol.sendMsg(stConnectDevice.getDevice(), StarryNetEncryptHelper.generateBtStateChangeData(i, stConnectDevice));
    }
}
