package com.upuphone.starrynet.strategy.protocol.simpleble;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import androidx.core.util.Consumer;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.common.utils.Utils;
import com.upuphone.starrynet.core.ble.utils.BluetoothUtils;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.IConnectChannel;
import com.upuphone.starrynet.strategy.channel.IMessageChannel;
import com.upuphone.starrynet.strategy.channel.IStarryNetChannel;
import com.upuphone.starrynet.strategy.channel.StarryNetChannelManager;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.message.payload.PayloadMessageManager;
import com.upuphone.starrynet.strategy.message.payload.handler.RingDataUtil;
import com.upuphone.starrynet.strategy.protocol.IProtocol;
import java.lang.reflect.InvocationTargetException;

@SuppressLint({"MissingPermission"})
public class SimpleBleProtocol implements IProtocol {
    private static final String TAG = "SimpleBleProtocol";

    public SimpleBleProtocol() {
        StarryNetChannelManager.getInstance().addProtocol(this);
    }

    /* access modifiers changed from: private */
    public void createOrRemoveBond(boolean z, BluetoothDevice bluetoothDevice) {
        try {
            BluetoothDevice.class.getMethod(z ? "createBond" : "removeBond", (Class[]) null).invoke(bluetoothDevice, (Object[]) null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
    }

    public int connect(StDevice stDevice, int i) {
        IConnectChannel connectChannel = StarryNetChannelManager.getInstance().getConnectChannel(i);
        return connectChannel == null ? StErrorCode.CONNECT_STRATEGY_BLE_PARAM_ERROR : connectChannel.connect(stDevice);
    }

    public void createBond(StDevice stDevice) {
        if (stDevice == null) {
            StLog.w(TAG, "createBond , StDevice is null, something may be wrong");
            return;
        }
        BluetoothDevice remoteDevice = BluetoothUtils.getRemoteDevice(stDevice.getBleMac());
        if (remoteDevice == null || remoteDevice.getBondState() == 12) {
            StLog.w(TAG, "bluetooth device(%s,%s)  in bond_bonded state ,so no need to create bond!", stDevice.getDeviceName(), stDevice.getBleMac());
        } else {
            createOrRemoveBond(true, remoteDevice);
        }
    }

    public int disconnect(StDevice stDevice, int i) {
        IConnectChannel connectChannel = StarryNetChannelManager.getInstance().getConnectChannel(i);
        return connectChannel == null ? StErrorCode.CONNECT_STRATEGY_BLE_PARAM_ERROR : connectChannel.disconnect(stDevice);
    }

    public IMessageChannel getMessageChannel(StDevice stDevice) {
        return null;
    }

    public int getProfile() {
        return 4;
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

    public void onRecv(StConnectDevice stConnectDevice, byte[] bArr, int i, IStarryNetChannel iStarryNetChannel) {
    }

    public void removeBond(StDevice stDevice) {
        if (stDevice == null) {
            StLog.w(TAG, "removeBond , StDevice is null, something may be wrong");
        } else if (stDevice.getTerminalType() == 5) {
            final BluetoothDevice remoteDevice = BluetoothUtils.getRemoteDevice(stDevice.getBleMac());
            if (remoteDevice.getBondState() == 12) {
                PayloadMessageManager.getInstance().sendInternalMessage(stDevice.getBleMac(), 1, (byte) 38, RingDataUtil.notifyReadyRemoveBond(Utils.getBytesFromAddress(stDevice.getBleMac())), new Consumer<byte[]>() {
                    public void accept(byte[] bArr) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("receive notify data =");
                        sb.append(bArr != null ? ByteUtils.byteToString(bArr) : "null");
                        StLog.d(SimpleBleProtocol.TAG, sb.toString());
                        SimpleBleProtocol.this.createOrRemoveBond(false, remoteDevice);
                    }
                });
                return;
            }
            StLog.w(TAG, "bluetooth device(%s,%s) not in bond_bonded state ,so no need to remove bond!", stDevice.getDeviceName(), stDevice.getBleMac());
        } else {
            StLog.w(TAG, "removeBond, not support terminal type :" + stDevice.getTerminalType());
        }
    }

    public int sendMsg(StDevice stDevice, byte[] bArr) {
        return 0;
    }
}
