package com.upuphone.runasone.channel.linker.simplified;

import android.os.Bundle;
import com.upuphone.runasone.ability.EnumAbility;
import com.upuphone.runasone.channel.bean.auth.AuthParameter;
import com.upuphone.runasone.channel.linker.EnumLinker;
import com.upuphone.runasone.channel.linker.ILinker;
import com.upuphone.runasone.device.DeviceManagerImpl;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.host.core.api.AbilityMessage;
import com.upuphone.runasone.host.core.api.EnumLinkStrategy;
import com.upuphone.runasone.message.ChannelMessage;
import com.upuphone.runasone.service.StarrynetApiImpl;
import com.upuphone.runasone.utils.LogUtil;
import com.upuphone.starrynet.api.StConstant;
import com.upuphone.starrynet.api.message.IMessageResponseListener;
import com.upuphone.starrynet.api.message.IReceivePayloadMessageListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimplifiedLinkerImpl implements ILinker {
    /* access modifiers changed from: private */
    public static final String TAG = "SimplifiedLinkerImpl";
    private static final IReceivePayloadMessageListener listener = new IReceivePayloadMessageListener() {
        public void receivePlayloadMessage(Bundle bundle) {
            byte[] byteArray = bundle.getByteArray("bytes");
            String string = bundle.getString(StConstant.KEY_PAYLOAD_MESSAGE_BLE_MAC);
            String string2 = bundle.getString(StConstant.KEY_PAYLOAD_MESSAGE_SERVICE_UUID);
            String string3 = bundle.getString(StConstant.KEY_PAYLOAD_MESSAGE_CHARACTER_UUID);
            int i = bundle.getInt(StConstant.KEY_PAYLOAD_MESSAGE_MSG_TYPE);
            if (byteArray != null && string != null && string2 != null && string3 != null) {
                ChannelMessage build = ChannelMessage.newBuilder().setId(string).setAbilityMessage(new AbilityMessage(string2, string3, i, byteArray)).setCategory(EnumAbility.RELAY_BYPASS.getName()).setLinkStrategy(EnumLinkStrategy.STRATEGY_SIMPLIFIED).build();
                SimplifiedMessageListener simplifiedMessageListener = (SimplifiedMessageListener) SimplifiedLinkerImpl.listenerMap.get(string);
                if (simplifiedMessageListener != null) {
                    simplifiedMessageListener.receivePlayloadMessage(build);
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public static final Map<String, SimplifiedMessageListener> listenerMap = new ConcurrentHashMap();
    private boolean bLink;
    private String mDeviceId;
    private EnumLinker mLinkerType;
    /* access modifiers changed from: private */
    public ILinker.LinkerStreamObserver mStreamObserver;
    private SimplifiedMessageListener simplifiedListener = new SimplifiedMessageListener() {
        public void receivePlayloadMessage(ChannelMessage channelMessage) {
            SimplifiedLinkerImpl.this.mStreamObserver.input(SimplifiedLinkerImpl.this.getLinkerType(), channelMessage);
        }
    };

    public SimplifiedLinkerImpl(EnumLinker enumLinker) {
        this.mLinkerType = enumLinker;
    }

    public static String bytes2HexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public EnumLinker getLinkerType() {
        return this.mLinkerType;
    }

    public void close() {
        if (this.bLink) {
            this.bLink = false;
            ILinker.LinkerStreamObserver linkerStreamObserver = this.mStreamObserver;
            if (linkerStreamObserver != null) {
                linkerStreamObserver.onStreamClose(getLinkerType());
                return;
            }
            return;
        }
        LogUtil.e(TAG, (Object) "SimplifiedLinkerImpl is already closed ");
    }

    public boolean isAuthTransition() {
        return false;
    }

    public void notifyTearDownSync() {
    }

    public boolean open(boolean z, AuthParameter authParameter) {
        String str = TAG;
        LogUtil.dPrimary(str, "SimplifiedLinkerImpl open:" + this.mDeviceId + " server:" + z);
        this.bLink = true;
        ILinker.LinkerStreamObserver linkerStreamObserver = this.mStreamObserver;
        if (linkerStreamObserver != null) {
            linkerStreamObserver.onStreamOpen(getLinkerType(), (AuthParameter) null);
        }
        return true;
    }

    public boolean output(ChannelMessage channelMessage) {
        AbilityMessage abilityMessage = channelMessage.getAbilityMessage();
        if (abilityMessage.getMessageType() != AbilityMessage.MessageType.SIMPLIFIED) {
            LogUtil.e("SimplifiedLinkerImpl output fail, abilityMessage must be Simplified !!!");
            return false;
        }
        Bundle bundle = new Bundle();
        StarryDevice findConnectDevice = DeviceManagerImpl.getInstance().findConnectDevice(this.mDeviceId);
        if (findConnectDevice == null) {
            LogUtil.e("findStarryDeviceBle <" + this.mDeviceId + "> is null");
            return false;
        } else if (!findConnectDevice.checkStatus(1)) {
            LogUtil.e("findStarryDeviceOnP2P device status is " + findConnectDevice.getStatus());
            return false;
        } else {
            byte[] identifier = findConnectDevice.getStarryDevice().getIdentifier();
            bundle.putByteArray("bytes", abilityMessage.getBypass());
            bundle.putString(StConstant.KEY_PAYLOAD_MESSAGE_BLE_MAC, bytes2HexString(identifier));
            bundle.putString(StConstant.KEY_PAYLOAD_MESSAGE_SERVICE_UUID, abilityMessage.getServiceUuid());
            bundle.putString(StConstant.KEY_PAYLOAD_MESSAGE_CHARACTER_UUID, abilityMessage.getCharacterUuid());
            bundle.putInt(StConstant.KEY_PAYLOAD_MESSAGE_MSG_TYPE, abilityMessage.getMsgType());
            StarrynetApiImpl.getInstance().sendPayloadMessage(bundle, new IMessageResponseListener() {
                public void onFail(int i, String str) {
                    String access$300 = SimplifiedLinkerImpl.TAG;
                    LogUtil.e(access$300, (Object) "onFail " + i + " s:" + str);
                }

                public void onSuccess() {
                    LogUtil.dPrimary(SimplifiedLinkerImpl.TAG, "onSuccess");
                }
            });
            return true;
        }
    }

    public void setSession(String str) {
    }

    public void shutdown() {
        LogUtil.dPrimary(TAG, "SimplifiedLinkerImpl shutdown ");
        close();
        listenerMap.remove(this.mDeviceId);
        this.mDeviceId = null;
        this.mStreamObserver = null;
    }

    public void startup(String str, ILinker.LinkerStreamObserver linkerStreamObserver) {
        this.mDeviceId = str;
        this.mStreamObserver = linkerStreamObserver;
        listenerMap.put(str, this.simplifiedListener);
        StarrynetApiImpl.getInstance().registerReceivePayloadMessageListener(listener);
    }

    public void triggerAck(long j) {
    }

    public boolean triggerRetransmission(long j, long j2) {
        return false;
    }
}
