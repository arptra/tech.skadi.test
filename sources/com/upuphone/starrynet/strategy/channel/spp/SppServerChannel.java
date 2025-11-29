package com.upuphone.starrynet.strategy.channel.spp;

import android.bluetooth.BluetoothSocket;
import com.honey.account.c7.a;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.utils.UUIDUtils;
import com.upuphone.starrynet.core.spp.SPPConnectionManager;
import com.upuphone.starrynet.core.spp.callback.ICommonServerListener;
import com.upuphone.starrynet.core.spp.callback.IConnectionEventListener;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.IMessageCallback;
import com.upuphone.starrynet.strategy.channel.spp.coder.SppMessageCoder;
import com.upuphone.starrynet.strategy.channel.spp.negotiate.SPPNegotiateProtocolManager;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.message.MessageManagerV2;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class SppServerChannel extends SppChannel {
    private static final int SERVER_RETRY_LIMIT = 5;
    /* access modifiers changed from: private */
    public static final String TAG = "SppServerChannel";
    private final IConnectionEventListener mIConnectionEventListener = new IConnectionEventListener() {
        private void dispatchConnectionStateChanged(String str, int i) {
            StConnectDevice connectDeviceByBrEdrMac = StarryDeviceManager.getInstance().getConnectDeviceByBrEdrMac(str);
            if (connectDeviceByBrEdrMac != null && connectDeviceByBrEdrMac.isSppServer()) {
                if (i == 101) {
                    SppServerChannel sppServerChannel = SppServerChannel.this;
                    sppServerChannel.mIChannelCallback.onConnected(connectDeviceByBrEdrMac, sppServerChannel);
                } else if (i == 100) {
                    SppServerChannel sppServerChannel2 = SppServerChannel.this;
                    sppServerChannel2.mIChannelCallback.onDisconnected(connectDeviceByBrEdrMac, sppServerChannel2);
                }
            }
        }

        private void dispatchMessageDispatched(int i) {
            IMessageCallback iMessageCallback = SppServerChannel.this.mMessageCallback;
            if (iMessageCallback != null) {
                if (i == 201) {
                    iMessageCallback.onResult(0);
                } else {
                    iMessageCallback.onResult(-1);
                }
            }
        }

        private void dispatchMessageReceived(String str, byte[] bArr) {
            MessageManagerV2.getInstance().receiveStMessage(SppMessageCoder.decode(bArr, str));
        }

        public void onConnectionStateChanged(String str, int i) {
            dispatchConnectionStateChanged(str, i);
        }

        public void onMessageDispatched(String str, byte[] bArr, int i) {
            dispatchMessageDispatched(i);
        }

        public void onMessageReceived(String str, byte[] bArr) {
            dispatchMessageReceived(str, bArr);
        }
    };

    public int connect(StDevice stDevice) {
        if (SPPNegotiateProtocolManager.getInstance().startServerRequestConnect(stDevice) == 0) {
            return 0;
        }
        StarryDeviceManager.getInstance().connectFail(stDevice, StErrorCode.CONNECT_CORE_SPP_SERVER_FAIL_REQUEST_CONNECT, getProfile());
        return 0;
    }

    public int disconnect(StDevice stDevice) {
        SPPConnectionManager.getInstance().disconnect(stDevice.getBrEdrMac());
        return 0;
    }

    public int getProfile() {
        return 24;
    }

    public void onBleDisconnected(StDevice stDevice) {
        if (!StarryDeviceManager.getInstance().getBleConnectedDevices().stream().anyMatch(new a())) {
            SPPConnectionManager.getInstance().stopServerListen();
            SPPConnectionManager.getInstance().removeConnectionEventListener(this.mIConnectionEventListener);
        }
        super.onBleDisconnected(stDevice);
    }

    public void startSppServerListen(final StDevice stDevice) {
        Optional<UUID> fetchUUIDListening = SPPConnectionManager.getInstance().fetchUUIDListening();
        if (fetchUUIDListening.isPresent()) {
            SPPNegotiateProtocolManager.getInstance().startServerUUIDSync(stDevice, fetchUUIDListening.get());
            return;
        }
        int generateAvailableUUID = SPPNegotiateProtocolManager.getInstance().generateAvailableUUID();
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        SPPConnectionManager.getInstance().startServerListen(UUIDUtils.makeUUID(generateAvailableUUID), new ICommonServerListener() {
            private void dealWithAdvertiseFail(UUID uuid) {
                if (atomicInteger.getAndIncrement() > 5) {
                    StLog.d(SppServerChannel.TAG, "startServerListen fail, retry count reach limit.");
                    return;
                }
                SPPNegotiateProtocolManager.getInstance().addConflictServerUUID(UUIDUtils.getShortUUIDOfInt(uuid));
                SPPConnectionManager.getInstance().startServerListen(UUIDUtils.makeUUID(SPPNegotiateProtocolManager.getInstance().generateAvailableUUID()), this);
            }

            public void onAdvertiseFail(UUID uuid) {
                dealWithAdvertiseFail(uuid);
            }

            public void onAdvertiseSuccess(UUID uuid) {
                SPPNegotiateProtocolManager.getInstance().startServerUUIDSync(stDevice, uuid);
            }

            public void onConnectionAccepted(String str, BluetoothSocket bluetoothSocket) {
            }
        });
        SPPConnectionManager.getInstance().addConnectionEventListener(this.mIConnectionEventListener);
    }
}
