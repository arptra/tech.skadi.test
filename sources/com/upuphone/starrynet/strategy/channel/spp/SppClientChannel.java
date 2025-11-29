package com.upuphone.starrynet.strategy.channel.spp;

import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.utils.UUIDUtils;
import com.upuphone.starrynet.core.spp.SPPConnectionManager;
import com.upuphone.starrynet.core.spp.callback.IConnectionEventListener;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.IMessageCallback;
import com.upuphone.starrynet.strategy.channel.spp.coder.SppMessageCoder;
import com.upuphone.starrynet.strategy.channel.spp.negotiate.SPPNegotiateProtocolManager;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.message.MessageManagerV2;
import java.util.Optional;

public class SppClientChannel extends SppChannel {
    private static final String TAG = "SppClientChannel";
    /* access modifiers changed from: private */
    public final IConnectionEventListener mIConnectionEventListener = new IConnectionEventListener() {
        private void dispatchConnectionStateChanged(String str, int i) {
            StConnectDevice connectDeviceByBrEdrMac = StarryDeviceManager.getInstance().getConnectDeviceByBrEdrMac(str);
            if (connectDeviceByBrEdrMac != null && connectDeviceByBrEdrMac.isSppClient()) {
                if (i == 101) {
                    SppClientChannel sppClientChannel = SppClientChannel.this;
                    sppClientChannel.mIChannelCallback.onConnected(connectDeviceByBrEdrMac, sppClientChannel);
                } else if (i == 100) {
                    SppClientChannel sppClientChannel2 = SppClientChannel.this;
                    sppClientChannel2.mIChannelCallback.onDisconnected(connectDeviceByBrEdrMac, sppClientChannel2);
                    removeConnectionEventListenerIfNeed();
                } else {
                    StarryDeviceManager.getInstance().connectFail(connectDeviceByBrEdrMac.getDevice(), StErrorCode.CONNECT_CORE_SPP_CLIENT_FAIL_SERVER_NOT_LISTEN, SppClientChannel.this.getProfile());
                }
            }
        }

        private void dispatchMessageDispatched(int i) {
            IMessageCallback iMessageCallback = SppClientChannel.this.mMessageCallback;
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

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$removeConnectionEventListenerIfNeed$1(boolean[] zArr, StConnectDevice stConnectDevice) {
            zArr[0] = true;
        }

        private void removeConnectionEventListenerIfNeed() {
            boolean[] zArr = {false};
            StarryDeviceManager.getInstance().getSppConnectedDevices().stream().filter(new a()).findFirst().ifPresent(new b(zArr));
            if (!zArr[0]) {
                SPPConnectionManager.getInstance().removeConnectionEventListener(SppClientChannel.this.mIConnectionEventListener);
            }
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
        if (StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier()).getBrEdrBondStatus() != 48) {
            StLog.d(TAG, "start spp client connect fail, br edr not bonded currently");
            return 0;
        }
        Optional<Integer> readyServerUUID = SPPNegotiateProtocolManager.getInstance().getReadyServerUUID(stDevice.getIdentifier());
        if (readyServerUUID.isPresent()) {
            SPPConnectionManager.getInstance().addConnectionEventListener(this.mIConnectionEventListener);
            String str = TAG;
            StLog.d(str, "start spp client connect, uuid:" + readyServerUUID.get());
            SPPConnectionManager.getInstance().connect(stDevice.getBrEdrMac(), UUIDUtils.makeUUID(readyServerUUID.get().intValue()));
        } else {
            StLog.d(TAG, "start spp client connect fail, cache uuid is null");
        }
        return 0;
    }

    public int disconnect(StDevice stDevice) {
        SPPConnectionManager.getInstance().disconnect(stDevice.getBrEdrMac());
        return 0;
    }

    public int getProfile() {
        return 23;
    }

    public void onBleDisconnected(StDevice stDevice) {
        SPPNegotiateProtocolManager.getInstance().removeReadyServerUUID(stDevice.getIdentifier());
        if (SPPConnectionManager.getInstance().isConnected(stDevice.getBrEdrMac())) {
            disconnect(stDevice);
            super.onBleDisconnected(stDevice);
        }
    }
}
