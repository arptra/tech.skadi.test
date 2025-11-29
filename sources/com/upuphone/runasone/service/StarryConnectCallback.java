package com.upuphone.runasone.service;

import android.text.TextUtils;
import com.honey.account.constant.AccountConstantKt;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.runasone.channel.virtual.IBridgeConnectCallback;
import com.upuphone.runasone.connection.gateway.IGateWay;
import com.upuphone.runasone.device.DeviceManagerImpl;
import com.upuphone.runasone.device.IDeviceListenerInner;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.utils.LogUtil;
import com.upuphone.runasone.utils.Utils;
import com.upuphone.starrynet.api.ILanConnectCallback;
import com.upuphone.starrynet.api.IStarryConnectCallback;
import com.upuphone.starrynet.api.bean.StDevice;
import java.util.ArrayList;
import java.util.List;

public class StarryConnectCallback implements IStarryConnectCallback, ILanConnectCallback, IBridgeConnectCallback {
    private List<IGateWay.OnGateWayStateChanged> connectCallback = new ArrayList();
    private IDeviceListenerInner deviceListenerInner;

    public void addConnectCallback(IGateWay.OnGateWayStateChanged onGateWayStateChanged) {
        this.connectCallback.add(onGateWayStateChanged);
    }

    public boolean isLanGcConnected(StDevice stDevice) {
        LogUtil.i("isLanGcConnected");
        IDeviceListenerInner iDeviceListenerInner = this.deviceListenerInner;
        if (iDeviceListenerInner == null) {
            return false;
        }
        return iDeviceListenerInner.isLanConnected(Utils.bytes2HexString(stDevice.getIdentifier()));
    }

    public void onApConnected(StDevice stDevice, String str) {
        LogUtil.i("onApConnected : " + stDevice + " address: " + str);
        StarryDevice convert = Utils.convert(stDevice);
        for (IGateWay.OnGateWayStateChanged onApConnected : this.connectCallback) {
            onApConnected.onApConnected(convert, str);
        }
        IDeviceListenerInner iDeviceListenerInner = this.deviceListenerInner;
        if (iDeviceListenerInner != null) {
            iDeviceListenerInner.onApConnectedChanged(convert.getId(), true);
        }
    }

    public void onApCreated(int i) {
        LogUtil.i("onApCreated" + i);
        for (IGateWay.OnGateWayStateChanged onApCreated : this.connectCallback) {
            onApCreated.onApCreated(i);
        }
        IDeviceListenerInner iDeviceListenerInner = this.deviceListenerInner;
        if (iDeviceListenerInner != null) {
            iDeviceListenerInner.onApCreated(i);
        }
    }

    public void onApDisconnected(StDevice stDevice) {
        LogUtil.i("onApDisconnected: " + stDevice);
        StarryDevice convert = Utils.convert(stDevice);
        for (IGateWay.OnGateWayStateChanged onApDisconnected : this.connectCallback) {
            onApDisconnected.onApDisconnected(convert);
        }
        IDeviceListenerInner iDeviceListenerInner = this.deviceListenerInner;
        if (iDeviceListenerInner != null) {
            iDeviceListenerInner.onApConnectedChanged(convert.getId(), true);
        }
    }

    public void onApRemoved() {
        LogUtil.i("onApRemoved");
        for (IGateWay.OnGateWayStateChanged onApRemoved : this.connectCallback) {
            onApRemoved.onApRemoved();
        }
        IDeviceListenerInner iDeviceListenerInner = this.deviceListenerInner;
        if (iDeviceListenerInner != null) {
            iDeviceListenerInner.onApRemoved();
        }
    }

    public void onAuth(StDevice stDevice) {
        LogUtil.d(stDevice);
        StarryDevice convert = Utils.convert(stDevice);
        IDeviceListenerInner iDeviceListenerInner = this.deviceListenerInner;
        if (iDeviceListenerInner != null) {
            iDeviceListenerInner.onAuth(convert);
        }
    }

    public void onAuthMessage(StDevice stDevice, byte[] bArr, int i) {
        LogUtil.d(stDevice + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + bArr.length);
        StarryDevice convert = Utils.convert(stDevice);
        IDeviceListenerInner iDeviceListenerInner = this.deviceListenerInner;
        if (iDeviceListenerInner != null) {
            iDeviceListenerInner.onAuthMessage(convert, bArr, i);
        }
    }

    public void onBind(StDevice stDevice) {
    }

    public void onBleBridgeConnected(StarryDevice starryDevice) {
        LogUtil.i("onBleBridgeConnected: " + starryDevice);
        for (IGateWay.OnGateWayStateChanged onBleConnected : this.connectCallback) {
            onBleConnected.onBleConnected(starryDevice);
        }
    }

    public void onBleBridgeDisconnected(StarryDevice starryDevice) {
        LogUtil.i("onBleBridgeDisconnected: " + starryDevice);
        for (IGateWay.OnGateWayStateChanged onBleDisconnected : this.connectCallback) {
            onBleDisconnected.onBleDisconnected(starryDevice);
        }
    }

    public void onBleConnected(StDevice stDevice) {
        LogUtil.i("onBleConnected: " + stDevice);
        StarryDevice convert = Utils.convert(stDevice);
        for (IGateWay.OnGateWayStateChanged onBleConnected : this.connectCallback) {
            onBleConnected.onBleConnected(convert);
        }
        IDeviceListenerInner iDeviceListenerInner = this.deviceListenerInner;
        if (iDeviceListenerInner != null) {
            iDeviceListenerInner.onBleConnectedChanged(convert.getId(), false);
        }
    }

    public void onBleDisconnected(StDevice stDevice) {
        LogUtil.i("onBleDisconnected: " + stDevice);
        StarryDevice convert = Utils.convert(stDevice);
        for (IGateWay.OnGateWayStateChanged onBleDisconnected : this.connectCallback) {
            onBleDisconnected.onBleDisconnected(convert);
        }
        IDeviceListenerInner iDeviceListenerInner = this.deviceListenerInner;
        if (iDeviceListenerInner != null) {
            iDeviceListenerInner.onBleConnectedChanged(convert.getId(), false);
        }
    }

    public void onBleServerConnected(StDevice stDevice) {
        LogUtil.i("onBleServerConnected: " + stDevice);
        StarryDevice convert = Utils.convert(stDevice);
        for (IGateWay.OnGateWayStateChanged onBleServerConnected : this.connectCallback) {
            onBleServerConnected.onBleServerConnected(convert);
        }
        IDeviceListenerInner iDeviceListenerInner = this.deviceListenerInner;
        if (iDeviceListenerInner != null) {
            iDeviceListenerInner.onBleConnectedChanged(convert.getId(), true);
        }
    }

    public void onBleServerDisconnected(StDevice stDevice) {
        LogUtil.i("onBleServerDisconnected :" + stDevice);
        StarryDevice convert = Utils.convert(stDevice);
        for (IGateWay.OnGateWayStateChanged onBleServerDisconnected : this.connectCallback) {
            onBleServerDisconnected.onBleServerDisconnected(convert);
        }
        IDeviceListenerInner iDeviceListenerInner = this.deviceListenerInner;
        if (iDeviceListenerInner != null) {
            iDeviceListenerInner.onBleConnectedChanged(convert.getId(), true);
        }
    }

    public void onBondStateChanged(int i, int i2, StDevice stDevice) {
        LogUtil.i("onBondStateChanged: " + i2 + " to " + i + ", " + stDevice);
        StarryDevice convert = Utils.convert(stDevice);
        IDeviceListenerInner iDeviceListenerInner = this.deviceListenerInner;
        if (iDeviceListenerInner != null) {
            iDeviceListenerInner.onBondStateChanged(i, i2, convert);
        }
    }

    public void onConnectFail(int i, StDevice stDevice, int i2) {
        LogUtil.d(stDevice + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + i + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + i2);
        StarryDevice convert = Utils.convert(stDevice);
        IDeviceListenerInner iDeviceListenerInner = this.deviceListenerInner;
        if (iDeviceListenerInner != null) {
            iDeviceListenerInner.onConnectFail(i, convert, i2);
        }
    }

    public void onConnected(int i, StDevice stDevice) {
        LogUtil.i("onConnected" + i + ", " + stDevice);
        StarryDevice convert = Utils.convert(stDevice);
        for (IGateWay.OnGateWayStateChanged onConnected : this.connectCallback) {
            onConnected.onConnected(i, convert);
        }
        IDeviceListenerInner iDeviceListenerInner = this.deviceListenerInner;
        if (iDeviceListenerInner != null) {
            iDeviceListenerInner.onBRConnectedChanged(i, convert.getId());
        }
    }

    public void onDisconnected(int i, StDevice stDevice) {
        LogUtil.i("onDisconnected: " + i + ", " + stDevice);
        StarryDevice convert = Utils.convert(stDevice);
        for (IGateWay.OnGateWayStateChanged onDisconnected : this.connectCallback) {
            onDisconnected.onDisconnected(i, convert);
        }
        IDeviceListenerInner iDeviceListenerInner = this.deviceListenerInner;
        if (iDeviceListenerInner != null) {
            iDeviceListenerInner.onBRConnectedChanged(i, convert.getId());
        }
    }

    public void onLanDisconnected(StDevice stDevice) {
        LogUtil.i("onLanDisconnected");
        StarryDevice convert = Utils.convert(stDevice);
        for (IGateWay.OnGateWayStateChanged onLanDisconnected : this.connectCallback) {
            onLanDisconnected.onLanDisconnected(convert);
        }
        IDeviceListenerInner iDeviceListenerInner = this.deviceListenerInner;
        if (iDeviceListenerInner != null) {
            iDeviceListenerInner.onLanDisConnected(convert.getId());
        }
    }

    public void onLanGcConnected(int i, String str, StDevice stDevice) {
        LogUtil.i("onLanGcConnected " + str + AccountConstantKt.CODE_SEPARTOR + i);
        if (this.deviceListenerInner != null) {
            StarryDevice convert = Utils.convert(stDevice);
            convert.setConnectByMdns(true);
            for (IGateWay.OnGateWayStateChanged onLanGcConnected : this.connectCallback) {
                onLanGcConnected.onLanGcConnected(i, str, convert);
            }
            this.deviceListenerInner.onLanConnected(convert.getId(), false);
        }
    }

    public void onLanGoConnected(int i, String str, StDevice stDevice) {
        LogUtil.i("onLanGoConnected " + str + AccountConstantKt.CODE_SEPARTOR + i);
        StarryDevice convert = Utils.convert(stDevice);
        convert.setConnectByMdns(true);
        if (!TextUtils.isEmpty(str) && i > 0) {
            convert.setAddress(str);
            convert.setPort(i);
        }
        for (IGateWay.OnGateWayStateChanged onLanGoConnected : this.connectCallback) {
            onLanGoConnected.onLanGoConnected(convert);
        }
        IDeviceListenerInner iDeviceListenerInner = this.deviceListenerInner;
        if (iDeviceListenerInner != null) {
            iDeviceListenerInner.onLanConnected(convert.getId(), true);
        }
    }

    public void onP2PBridgeConnected(StarryDevice starryDevice) {
        starryDevice.setPort(0);
        StarryDevice findConnectDevice = DeviceManagerImpl.getInstance().findConnectDevice(starryDevice.getId());
        if (findConnectDevice != null) {
            findConnectDevice.setAddress(starryDevice.getAddress());
            starryDevice = findConnectDevice;
        }
        for (IGateWay.OnGateWayStateChanged onLanGoConnected : this.connectCallback) {
            onLanGoConnected.onLanGoConnected(starryDevice);
        }
    }

    public void onP2PBridgeDisconnected(StarryDevice starryDevice) {
        LogUtil.i("onP2PBridgeConnected");
        for (IGateWay.OnGateWayStateChanged onLanDisconnected : this.connectCallback) {
            onLanDisconnected.onLanDisconnected(starryDevice);
        }
    }

    public void onP2pGcConnected(int i, String str, StDevice stDevice) {
        LogUtil.i("onP2pGcConnected " + str + AccountConstantKt.CODE_SEPARTOR + i);
        StarryDevice convert = Utils.convert(stDevice);
        for (IGateWay.OnGateWayStateChanged onP2pGcConnected : this.connectCallback) {
            onP2pGcConnected.onP2pGcConnected(i, str, convert);
        }
        IDeviceListenerInner iDeviceListenerInner = this.deviceListenerInner;
        if (iDeviceListenerInner != null) {
            iDeviceListenerInner.onP2PConnectedChanged(convert.getId(), false);
        }
    }

    public void onP2pGcDisconnected(StDevice stDevice) {
        LogUtil.i("onP2pGcDisconnected");
        StarryDevice convert = Utils.convert(stDevice);
        for (IGateWay.OnGateWayStateChanged onP2pGcDisconnected : this.connectCallback) {
            onP2pGcDisconnected.onP2pGcDisconnected(convert);
        }
        IDeviceListenerInner iDeviceListenerInner = this.deviceListenerInner;
        if (iDeviceListenerInner != null) {
            iDeviceListenerInner.onP2PConnectedChanged(convert.getId(), false);
        }
    }

    public void onP2pGoConnected(StDevice stDevice) {
        LogUtil.i("onP2pGoConnected");
        StarryDevice convert = Utils.convert(stDevice);
        for (IGateWay.OnGateWayStateChanged onP2pGoConnected : this.connectCallback) {
            onP2pGoConnected.onP2pGoConnected(convert);
        }
        IDeviceListenerInner iDeviceListenerInner = this.deviceListenerInner;
        if (iDeviceListenerInner != null) {
            iDeviceListenerInner.onP2PConnectedChanged(convert.getId(), true);
        }
    }

    public void onP2pGoCreated(int i, String str) {
        LogUtil.i("onP2pGoCreated defaultProt: " + i);
        for (IGateWay.OnGateWayStateChanged onP2pGoCreated : this.connectCallback) {
            onP2pGoCreated.onP2pGoCreated(i, str);
        }
        StarrynetApiImpl.getInstance().setDefaultPort(i);
        IDeviceListenerInner iDeviceListenerInner = this.deviceListenerInner;
        if (iDeviceListenerInner != null) {
            iDeviceListenerInner.onP2pGoCreated(i);
        }
    }

    public void onP2pGoDisconnected(StDevice stDevice) {
        LogUtil.i("onP2pGoDisconnected");
        StarryDevice convert = Utils.convert(stDevice);
        for (IGateWay.OnGateWayStateChanged onP2pGoDisconnected : this.connectCallback) {
            onP2pGoDisconnected.onP2pGoDisconnected(convert);
        }
        IDeviceListenerInner iDeviceListenerInner = this.deviceListenerInner;
        if (iDeviceListenerInner != null) {
            iDeviceListenerInner.onP2PConnectedChanged(convert.getId(), true);
        }
    }

    public void onP2pGoRemoved() {
        LogUtil.i("onP2pGoRemoved");
        for (IGateWay.OnGateWayStateChanged onP2pGoRemoved : this.connectCallback) {
            onP2pGoRemoved.onP2pGoRemoved();
        }
        IDeviceListenerInner iDeviceListenerInner = this.deviceListenerInner;
        if (iDeviceListenerInner != null) {
            iDeviceListenerInner.onP2pGoRemoved();
        }
    }

    public void onRegister() {
    }

    public void onReset(StDevice stDevice) {
    }

    public void onSppClientConnected(StDevice stDevice) {
        LogUtil.i("onSppClientConnected: " + stDevice);
        StarryDevice convert = Utils.convert(stDevice);
        for (IGateWay.OnGateWayStateChanged onSppClientConnected : this.connectCallback) {
            onSppClientConnected.onSppClientConnected(convert);
        }
        IDeviceListenerInner iDeviceListenerInner = this.deviceListenerInner;
        if (iDeviceListenerInner != null) {
            iDeviceListenerInner.onSPPConnectedChanged(convert.getId(), false);
        }
    }

    public void onSppClientDisconnected(StDevice stDevice) {
        LogUtil.i("onSppClientDisconnected :" + stDevice);
        StarryDevice convert = Utils.convert(stDevice);
        for (IGateWay.OnGateWayStateChanged onSppClientDisconnected : this.connectCallback) {
            onSppClientDisconnected.onSppClientDisconnected(convert);
        }
        IDeviceListenerInner iDeviceListenerInner = this.deviceListenerInner;
        if (iDeviceListenerInner != null) {
            iDeviceListenerInner.onSPPConnectedChanged(convert.getId(), false);
        }
    }

    public void onSppServerConnected(StDevice stDevice) {
        LogUtil.i("onSppServerConnected: " + stDevice);
        StarryDevice convert = Utils.convert(stDevice);
        for (IGateWay.OnGateWayStateChanged onSppServerConnected : this.connectCallback) {
            onSppServerConnected.onSppServerConnected(convert);
        }
        IDeviceListenerInner iDeviceListenerInner = this.deviceListenerInner;
        if (iDeviceListenerInner != null) {
            iDeviceListenerInner.onSPPConnectedChanged(convert.getId(), true);
        }
    }

    public void onSppServerDisconnected(StDevice stDevice) {
        LogUtil.i("onSppServerDisconnected :" + stDevice);
        StarryDevice convert = Utils.convert(stDevice);
        for (IGateWay.OnGateWayStateChanged onSppServerDisconnected : this.connectCallback) {
            onSppServerDisconnected.onSppServerDisconnected(convert);
        }
        IDeviceListenerInner iDeviceListenerInner = this.deviceListenerInner;
        if (iDeviceListenerInner != null) {
            iDeviceListenerInner.onSPPConnectedChanged(convert.getId(), true);
        }
    }

    public void onStaConnected(int i, String str, StDevice stDevice) {
        LogUtil.i("onStaConnected: " + str + AccountConstantKt.CODE_SEPARTOR + i);
        StarryDevice convert = Utils.convert(stDevice);
        for (IGateWay.OnGateWayStateChanged onStaConnected : this.connectCallback) {
            onStaConnected.onStaConnected(i, str, convert);
        }
        IDeviceListenerInner iDeviceListenerInner = this.deviceListenerInner;
        if (iDeviceListenerInner != null) {
            iDeviceListenerInner.onApConnectedChanged(convert.getId(), false);
        }
    }

    public void onStaDisconnected(StDevice stDevice) {
        LogUtil.i("onStaDisconnected");
        StarryDevice convert = Utils.convert(stDevice);
        for (IGateWay.OnGateWayStateChanged onStaDisconnected : this.connectCallback) {
            onStaDisconnected.onStaDisconnected(convert);
        }
        IDeviceListenerInner iDeviceListenerInner = this.deviceListenerInner;
        if (iDeviceListenerInner != null) {
            iDeviceListenerInner.onApConnectedChanged(convert.getId(), false);
        }
    }

    public void onUnRegister() {
    }

    public void onUnbind(StDevice stDevice) {
    }

    public void registerDeviceListener(IDeviceListenerInner iDeviceListenerInner) {
        this.deviceListenerInner = iDeviceListenerInner;
    }

    public void reportOwnDevice(StDevice stDevice) {
        LogUtil.i("reportOwnDevice: " + stDevice);
        StarryDevice convert = Utils.convert(stDevice);
        for (IGateWay.OnGateWayStateChanged reportOwnDevice : this.connectCallback) {
            reportOwnDevice.reportOwnDevice(convert);
        }
    }
}
