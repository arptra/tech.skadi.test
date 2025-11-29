package com.upuphone.starrynet.strategy.protocol.starrynet;

import Starry.StarryLinkEncrypt;
import android.annotation.SuppressLint;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.IMessageChannel;
import com.upuphone.starrynet.strategy.channel.IStarryNetChannel;
import com.upuphone.starrynet.strategy.channel.bredr.BrEdrChannel;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.encrypt.StarryNetDecryptHelper;
import com.upuphone.starrynet.strategy.protocol.starrynet.xrprotocol.IphoneProtocol;
import com.upuphone.starrynet.strategy.protocol.starrynet.xrprotocol.XrChildProtocol;
import java.util.Arrays;
import java.util.List;

public class XRStarryNetProtocol extends StarryNetProtocol {
    private static final String TAG = "XRStarryNetProtocol";
    private List<XrChildProtocol> mChildProtocols = Arrays.asList(new XrChildProtocol[]{new IphoneProtocol(this)});

    private XrChildProtocol getTargetProtocol(int i) {
        for (XrChildProtocol next : this.mChildProtocols) {
            if (next.getTargetTerminalType() == i) {
                return next;
            }
        }
        return null;
    }

    public void dealStarryNetMsg(StConnectDevice stConnectDevice, IMessageChannel iMessageChannel, StarryNetDecryptHelper starryNetDecryptHelper) {
        StarryLinkEncrypt.COMMAND command;
        byte terminalType = stConnectDevice.getTerminalType();
        if (terminalType == 0 && ((command = starryNetDecryptHelper.getCommand()) == StarryLinkEncrypt.COMMAND.IOS_CONNECT_BT || command == StarryLinkEncrypt.COMMAND.REQUEST_STATUS_BT)) {
            terminalType = 6;
            stConnectDevice.setTerminalType((byte) 6);
        }
        XrChildProtocol targetProtocol = getTargetProtocol(terminalType);
        if (targetProtocol == null) {
            super.dealStarryNetMsg(stConnectDevice, iMessageChannel, starryNetDecryptHelper);
        } else if (!targetProtocol.dealStarryNetMsg(stConnectDevice, iMessageChannel, starryNetDecryptHelper)) {
            super.dealStarryNetMsg(stConnectDevice, iMessageChannel, starryNetDecryptHelper);
        }
    }

    @SuppressLint({"MissingPermission"})
    public void onBrEdrBondStateChange(StConnectDevice stConnectDevice, int i, int i2) {
        byte terminalType = stConnectDevice.getTerminalType();
        XrChildProtocol targetProtocol = getTargetProtocol(terminalType);
        if (targetProtocol != null) {
            targetProtocol.onBrEdrBondStateChange(stConnectDevice, i, i2);
            return;
        }
        if (i2 == 32 && i == 16 && stConnectDevice.getTerminalType() == 4) {
            if (stConnectDevice.getBleBondStatus() == 0) {
                if (stConnectDevice.isCancelConfirm()) {
                    StLog.w(TAG, "third device, cancel confirm, ble bond none, ignore it's bonding -> bond none change event. ");
                    return;
                }
            } else if (stConnectDevice.getBleBondStatus() == 4) {
                removeBond(stConnectDevice.getDevice());
            }
        }
        super.onBrEdrBondStateChange(stConnectDevice, i, i2);
        if (terminalType != 3 && stConnectDevice.getBleBondStatus() == 0 && i == 48) {
            BrEdrChannel.removeBondBrEdr(stConnectDevice.getDevice());
        }
    }

    public void onConnected(StConnectDevice stConnectDevice, int i) {
        XrChildProtocol targetProtocol;
        super.onConnected(stConnectDevice, i);
        if (i == 1 && (targetProtocol = getTargetProtocol(stConnectDevice.getTerminalType())) != null) {
            targetProtocol.onBleServerConnected(stConnectDevice);
        }
    }

    public void onDisconnected(StConnectDevice stConnectDevice, int i) {
        XrChildProtocol targetProtocol;
        if (stConnectDevice != null) {
            if (i != 1 || (targetProtocol = getTargetProtocol(stConnectDevice.getTerminalType())) == null || !targetProtocol.onBleServerDisconnected(stConnectDevice)) {
                super.onDisconnected(stConnectDevice, i);
            }
        }
    }

    public void onReady(StConnectDevice stConnectDevice, IStarryNetChannel iStarryNetChannel) {
        StLog.d(TAG, "onReady " + stConnectDevice);
        if (!this.mReadyChannelMap.isEmpty()) {
            for (String connectDevice : this.mReadyChannelMap.keySet()) {
                StConnectDevice connectDevice2 = StarryDeviceManager.getInstance().getConnectDevice(connectDevice);
                if (connectDevice2 != null && connectDevice2.getBleBondStatus() != 4) {
                    iStarryNetChannel.disconnect(stConnectDevice.getDevice());
                    StLog.i(TAG, "onReady disconnect");
                    return;
                }
            }
        }
        super.onReady(stConnectDevice, iStarryNetChannel);
    }
}
