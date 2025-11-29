package com.upuphone.starrynet.strategy.protocol.starrynet;

import android.os.Handler;
import android.os.Message;
import com.honey.account.j7.e;
import com.honey.account.j7.f;
import com.honey.account.j7.g;
import com.honey.account.j7.h;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.BluetoothConstants;
import com.upuphone.starrynet.core.ble.client.BleClientCache;
import com.upuphone.starrynet.core.ble.client.BleConnectManager;
import com.upuphone.starrynet.core.ble.client.response.BleRequestMtuResponse;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.IConnectChannel;
import com.upuphone.starrynet.strategy.channel.IMessageCallback;
import com.upuphone.starrynet.strategy.channel.IMessageChannel;
import com.upuphone.starrynet.strategy.channel.IStarryNetChannel;
import com.upuphone.starrynet.strategy.channel.ble.BleClientChannel;
import com.upuphone.starrynet.strategy.channel.bredr.BrEdrChannel;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.encrypt.StarryNetDecryptHelper;
import com.upuphone.starrynet.strategy.encrypt.StarryNetEncryptHelper;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersions;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersionsCache;
import com.upuphone.starrynet.strategy.protocol.starrynet.StarryNetProtocolMessage;
import java.util.UUID;

public class PhoneStarryNetProtocol extends StarryNetProtocol {
    private static final int DELAY_TIME_BOND_BR = 2000;
    private static final int MSG_WAIT_SWITCH_VERSIONS_TIMEOUT = 10;
    private static final String TAG = "PhoneStarryNetProtocol";
    protected static final int WAIT_RESPONSE_INTERVAL = 5000;

    /* renamed from: com.upuphone.starrynet.strategy.protocol.starrynet.PhoneStarryNetProtocol$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
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
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.DISCONNECT_BLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x001d }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.SEVER_REQUEST_CLIENT_DISCONNECT_CONNECTION     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.strategy.protocol.starrynet.PhoneStarryNetProtocol.AnonymousClass3.<clinit>():void");
        }
    }

    private void doReady(StConnectDevice stConnectDevice, IStarryNetChannel iStarryNetChannel) {
        if (stConnectDevice.getVersion() < 3) {
            iStarryNetChannel.disconnect(stConnectDevice.getDevice());
            StLog.w(TAG, "doReady ADV version is invalid");
            return;
        }
        openNotify(stConnectDevice, iStarryNetChannel);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$openNotify$1(UUID uuid, StConnectDevice stConnectDevice, IStarryNetChannel iStarryNetChannel, int i, Void voidR) {
        StLog.d(TAG, "open notify(%s) code=%d", uuid.toString(), Integer.valueOf(i));
        onMessageReady(stConnectDevice, iStarryNetChannel);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendClearBondData$0(IStarryNetChannel iStarryNetChannel, StConnectDevice stConnectDevice, int i) {
        iStarryNetChannel.disconnect(stConnectDevice.getDevice());
        StarryDeviceManager.getInstance().connectFail(stConnectDevice.getDevice(), -1, 1);
    }

    private void onMessageReady(final StConnectDevice stConnectDevice, final IStarryNetChannel iStarryNetChannel) {
        if (stConnectDevice.isBleConnected()) {
            StLog.d(TAG, "ble already connected, not exchange vesion");
            return;
        }
        byte[] buildBytesFromVersions = ProtocolVersions.buildBytesFromVersions(ProtocolVersions.buildOwnVersions());
        StLog.d(TAG, "onMessageReady,send own ProtocolVersions data =" + buildBytesFromVersions.length);
        iStarryNetChannel.sendMsg(stConnectDevice.getDevice(), false, buildBytesFromVersions, 11, new IMessageCallback() {
            public void onResult(int i) {
                if (i != 0) {
                    StLog.i(PhoneStarryNetProtocol.TAG, "onMessageReady fail");
                    iStarryNetChannel.disconnect(stConnectDevice.getDevice());
                    return;
                }
                PhoneStarryNetProtocol.this.mHandler.sendMessageDelayed(PhoneStarryNetProtocol.this.mHandler.obtainMessage(10, stConnectDevice.getDevice()), 5000);
            }
        });
    }

    private void openNotify(StConnectDevice stConnectDevice, IStarryNetChannel iStarryNetChannel) {
        int characterCategory = BleClientCache.getInstance().getCharacterCategory(stConnectDevice.getBleMac());
        UUID uuid = BluetoothConstants.STARRY_NET_MULTI_WRITE_UUID;
        if (characterCategory == 2) {
            uuid = BluetoothConstants.STARRY_NET_AIR_INTERNAL_MESSAGE_UUID;
        }
        BleConnectManager.getInstance().notify(stConnectDevice.getBleMac(), BluetoothConstants.STARRY_NET_SERVICE_UUID, uuid, new h(this, uuid, stConnectDevice, iStarryNetChannel));
    }

    private void openNotify4Config(String str) {
        BleConnectManager.getInstance().notify(str, BluetoothConstants.STARRY_NET_SERVICE_UUID, BluetoothConstants.STARRY_NET_READ_CONFIG_UUID, new e());
    }

    private void sendClearBondData(StConnectDevice stConnectDevice, IStarryNetChannel iStarryNetChannel) {
        stConnectDevice.setStatus(0);
        StarryDeviceManager.getInstance().updateBondInfo(stConnectDevice);
        iStarryNetChannel.sendMsg(stConnectDevice.getDevice(), StarryNetEncryptHelper.generateClearData(), 10, new f(iStarryNetChannel, stConnectDevice));
    }

    public void dealStarryNetMsg(StConnectDevice stConnectDevice, IMessageChannel iMessageChannel, StarryNetDecryptHelper starryNetDecryptHelper) {
        int i = AnonymousClass3.$SwitchMap$Starry$StarryLinkEncrypt$COMMAND[starryNetDecryptHelper.getCommand().ordinal()];
        if (i == 1 || i == 2) {
            disconnect(stConnectDevice.getDevice(), 1);
        } else {
            super.dealStarryNetMsg(stConnectDevice, iMessageChannel, starryNetDecryptHelper);
        }
    }

    public int getProtocolConnectVersion() {
        return 3;
    }

    public void onBrEdrBondStateChange(StConnectDevice stConnectDevice, int i, int i2) {
        super.onBrEdrBondStateChange(stConnectDevice, i, i2);
        if (stConnectDevice.getTerminalType() == 2) {
            if (i == 16 && i2 == 48 && stConnectDevice.getBleBondStatus() == 4) {
                removeBond(stConnectDevice.getDevice());
            }
            if (stConnectDevice.getBleBondStatus() == 0 && i == 48) {
                BrEdrChannel.removeBondBrEdr(stConnectDevice.getDevice());
            }
        }
    }

    public boolean onConnected(StConnectDevice stConnectDevice, IConnectChannel iConnectChannel) {
        if (!(iConnectChannel instanceof BleClientChannel)) {
            return super.onConnected(stConnectDevice, iConnectChannel);
        }
        doReady(stConnectDevice, (IStarryNetChannel) iConnectChannel);
        return true;
    }

    public boolean onDealVersionData(ProtocolVersions protocolVersions, final StConnectDevice stConnectDevice, final IStarryNetChannel iStarryNetChannel) {
        this.mHandler.removeMessages(10);
        if (protocolVersions.getConnectVersion() < 2 || protocolVersions.getEncryptType() == 0) {
            StLog.w(TAG, "version incompatible， version = " + protocolVersions.getConnectVersion() + " encrypt = " + protocolVersions.getEncryptType());
            iStarryNetChannel.disconnect(stConnectDevice.getDevice());
            return false;
        }
        ProtocolVersionsCache.updateProtocolVersion(protocolVersions.getSelfIdentifier(), protocolVersions);
        if (!ProtocolVersionsCache.isSupportBleVersionV2Plus(protocolVersions.getSelfIdentifier())) {
            StLog.d(TAG, "remote device not support ble version v2, start open config!");
            openNotify4Config(stConnectDevice.getBleMac());
        }
        stConnectDevice.setEncrypt(protocolVersions.getEncryptType());
        stConnectDevice.setConnectVersion(protocolVersions.getConnectVersion());
        StarryDeviceManager.getInstance().updateBondInfo(stConnectDevice);
        int mtuSize = BleClientCache.getInstance().getMtuSize(stConnectDevice.getBleMac());
        if (mtuSize == 23 && mtuSize != protocolVersions.getMaxMtuSize()) {
            StLog.d(TAG, "current mtu=%d, remote exchange dest mtu =%d", Integer.valueOf(mtuSize), Integer.valueOf(protocolVersions.getMaxMtuSize()));
            BleConnectManager.getInstance().requestMtu(stConnectDevice.getBleMac(), Math.min(512, protocolVersions.getMaxMtuSize()), new BleRequestMtuResponse() {
                public void onResponse(int i, Integer num) {
                    if (i == 0) {
                        int intValue = num.intValue();
                        StLog.d(PhoneStarryNetProtocol.TAG, "put dest2 mtu=%d into BleClientCache", num);
                        BleClientCache.getInstance().updateMtu(stConnectDevice.getBleMac(), intValue);
                    } else {
                        BleClientCache.getInstance().clearMtu(stConnectDevice.getBleMac());
                    }
                    PhoneStarryNetProtocol.this.onReady(stConnectDevice, iStarryNetChannel);
                }
            });
            return false;
        } else if (mtuSize == 23 || mtuSize == protocolVersions.getMaxMtuSize()) {
            return true;
        } else {
            int min = Math.min(512, protocolVersions.getMaxMtuSize());
            StLog.d(TAG, "put dest1 mtu=%d into BleClientCache", Integer.valueOf(min));
            BleClientCache.getInstance().updateMtu(stConnectDevice.getBleMac(), min);
            return true;
        }
    }

    public boolean onHandleMessage(Message message) {
        int i = message.what;
        if (i == 10) {
            StLog.w(TAG, "wait remote device response switch versions info timeout, start disconnect !");
            disconnect((StDevice) message.obj, 1);
            return true;
        } else if (i != 4) {
            return super.onHandleMessage(message);
        } else {
            StDevice stDevice = (StDevice) message.obj;
            if (stDevice == null) {
                return true;
            }
            if (StarryDeviceManager.getInstance().getConnectedDeviceByTerminal(stDevice.getTerminalType()).size() == 0) {
                this.mCreateBondWaitRetry = 20;
                createBond(stDevice);
                return true;
            }
            int i2 = this.mCreateBondWaitRetry - 1;
            this.mCreateBondWaitRetry = i2;
            if (i2 >= 0) {
                Handler handler = this.mHandler;
                handler.sendMessageDelayed(Message.obtain(handler, 4, stDevice), 200);
            } else {
                this.mCreateBondWaitRetry = 20;
            }
            return true;
        }
    }

    public void onReady(StConnectDevice stConnectDevice, IStarryNetChannel iStarryNetChannel) {
        super.onReady(stConnectDevice, iStarryNetChannel);
        if (iStarryNetChannel.getProfile() == 1) {
            if (stConnectDevice == null) {
                StLog.d(TAG, "connectBle connect device is null");
                return;
            }
            BleClientCache.getInstance().putReadyClient(stConnectDevice.getBleMac(), true);
            int bleBondStatus = stConnectDevice.getBleBondStatus();
            if (bleBondStatus == 15) {
                sendClearBondData(stConnectDevice, iStarryNetChannel);
                return;
            }
            if (stConnectDevice.getTerminalType() == 3) {
                getP2pMacAddress();
            }
            if (StarryNetData.getInstance().getOwnDevice().getTerminalType() == 4 || bleBondStatus >= 2 || stConnectDevice.getTerminalType() != 3) {
                if (bleBondStatus != 4) {
                    StarryDeviceManager.getInstance().updateBondInfo(stConnectDevice, 2);
                }
                createBond(stConnectDevice.getDevice());
                return;
            }
            iStarryNetChannel.sendMsg(stConnectDevice.getDevice(), StarryNetEncryptHelper.generateAuthStatus(), 10);
            Message.obtain(this.mHandler, 3, new StarryNetProtocolMessage.MsgObj(stConnectDevice, iStarryNetChannel)).sendToTarget();
        }
    }

    private void openNotify(String str, UUID uuid) {
        BleConnectManager.getInstance().notify(str, BluetoothConstants.STARRY_NET_SERVICE_UUID, uuid, new g(uuid));
    }
}
