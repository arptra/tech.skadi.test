package com.upuphone.runasone.channel.linker.bt;

import com.upuphone.runasone.QosLevel;
import com.upuphone.runasone.StreamReq;
import com.upuphone.runasone.ability.Constant;
import com.upuphone.runasone.channel.bean.auth.AuthParameter;
import com.upuphone.runasone.channel.bean.stream.StreamBuilder;
import com.upuphone.runasone.channel.linker.EnumLinker;
import com.upuphone.runasone.channel.linker.ILinker;
import com.upuphone.runasone.device.DeviceManagerImpl;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.host.core.api.AbilityMessage;
import com.upuphone.runasone.host.core.api.myconst.TlvCodeConst;
import com.upuphone.runasone.host.core.api.util.TlvBox;
import com.upuphone.runasone.message.ChannelMessage;
import com.upuphone.runasone.utils.LogUtil;
import java.io.IOException;

public class BtLinkerImpl implements ILinker {
    private static final String TAG = "BtLinkerImpl";
    private boolean bLink;
    private BtServer btServer;
    private String mDeviceId;
    private byte[] mIdentifier;
    private EnumLinker mLinkerType;
    private String mSelfId;
    /* access modifiers changed from: private */
    public ILinker.LinkerStreamObserver mStreamObserver;

    public BtLinkerImpl(EnumLinker enumLinker) {
        this.mLinkerType = enumLinker;
        this.btServer = enumLinker == EnumLinker.TYPE_LINK_SPP ? BtServer.getSppServer() : BtServer.getBtServer();
    }

    private boolean doLink(final boolean z, AuthParameter authParameter) {
        StarryDevice findConnectDevice = DeviceManagerImpl.getInstance().findConnectDevice(this.mDeviceId);
        if (findConnectDevice == null) {
            LogUtil.e("findStarryDeviceBle <" + this.mDeviceId + "> is null");
            return false;
        } else if (!findConnectDevice.checkStatus(1)) {
            LogUtil.e("findStarryDeviceOnP2P device status is " + findConnectDevice.getStatus());
            return false;
        } else {
            this.mSelfId = findConnectDevice.getSelfId();
            byte[] identifier = findConnectDevice.getStarryDevice().getIdentifier();
            this.mIdentifier = identifier;
            try {
                this.btServer.link(this.mDeviceId, this.mSelfId, identifier, z, authParameter, new BtServerListener() {
                    public void input(ChannelMessage channelMessage) {
                        if (BtLinkerImpl.this.mStreamObserver != null) {
                            BtLinkerImpl.this.mStreamObserver.input(BtLinkerImpl.this.getLinkerType(), channelMessage);
                        } else {
                            LogUtil.e("input ... listener is null");
                        }
                    }

                    public void onAuth(String str, AuthParameter authParameter) {
                        LogUtil.d("onAuth bServer:" + z);
                        if (BtLinkerImpl.this.mStreamObserver != null) {
                            BtLinkerImpl.this.mStreamObserver.onStreamOpen(BtLinkerImpl.this.getLinkerType(), authParameter);
                        } else {
                            LogUtil.e("onAuth ... listener is null");
                        }
                    }

                    public void onClose() {
                        LogUtil.d("onClose ");
                        if (BtLinkerImpl.this.mStreamObserver != null) {
                            BtLinkerImpl.this.mStreamObserver.onStreamClose(BtLinkerImpl.this.getLinkerType());
                        } else {
                            LogUtil.e("onClose ... listener is null");
                        }
                    }

                    public void onError(int i) {
                        LogUtil.d("onError " + i);
                        if (BtLinkerImpl.this.mStreamObserver != null) {
                            BtLinkerImpl.this.mStreamObserver.onStreamError(BtLinkerImpl.this.getLinkerType(), i);
                        } else {
                            LogUtil.e("onError ... listener is null");
                        }
                    }

                    public void onRetransmission(long j, long j2) {
                        LogUtil.d("onRetransmission reqId:" + j + " length:" + j2);
                        if (BtLinkerImpl.this.mStreamObserver != null) {
                            BtLinkerImpl.this.mStreamObserver.onRetransmission(BtLinkerImpl.this.getLinkerType(), j, j2);
                        } else {
                            LogUtil.e("onRetransmission ... listener is null");
                        }
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    private void doUnlink() {
        String str = this.mDeviceId;
        if (str != null) {
            this.btServer.unlink(str);
        }
    }

    /* access modifiers changed from: private */
    public EnumLinker getLinkerType() {
        return this.mLinkerType;
    }

    public void close() {
        if (this.bLink) {
            this.bLink = false;
            LogUtil.d(TAG, (Object) "BtLinkerImpl close ");
            doUnlink();
            return;
        }
        LogUtil.e(TAG, (Object) "BtLinkerImpl is already close ");
    }

    public boolean isAuthTransition() {
        return this.btServer.isAuthTransition(this.mDeviceId);
    }

    public void notifyTearDownSync() {
    }

    public boolean open(boolean z, AuthParameter authParameter) {
        String str = TAG;
        LogUtil.d(str, (Object) "BtLinkerImpl open:" + this.mDeviceId + " server:" + z);
        boolean doLink = doLink(z, authParameter);
        this.bLink = doLink;
        return doLink;
    }

    public boolean output(ChannelMessage channelMessage) {
        AbilityMessage abilityMessage = channelMessage.getAbilityMessage();
        if (abilityMessage == null || !channelMessage.isSendTlv()) {
            StreamReq genByPass = StreamBuilder.genByPass(channelMessage);
            String str = TAG;
            LogUtil.dPrimary(str, "BLE output selfId: " + this.mSelfId + " destId:" + this.mDeviceId + " reqId:" + genByPass.getReqId() + " getBypass Length:" + genByPass.getBypass().toByteArray().length + "  isSendTlv= " + channelMessage.isSendTlv() + " timeStamp:" + genByPass.getTimeStamp() + " total Length:" + genByPass.toByteArray().length);
            return this.btServer.output(this.mSelfId, this.mDeviceId, this.mIdentifier, genByPass.toByteArray(), channelMessage.isSendTlv(), QosLevel.QOS_3 == channelMessage.getQos());
        }
        TlvBox create = TlvBox.create();
        Byte b = Constant.ABILITY_TO_MAPPING.get(channelMessage.getCategory());
        if (b != null) {
            create.put(Byte.valueOf(TlvCodeConst.category), b.byteValue());
        } else {
            LogUtil.ePrimary(TAG, "tlv  category is null");
        }
        create.put(Byte.valueOf(TlvCodeConst.payload), abilityMessage.getBypass());
        String str2 = TAG;
        LogUtil.dPrimary(str2, "BLE output selfId: " + this.mSelfId + " destId:" + this.mDeviceId + " code:" + b + "  isSendTlv= " + channelMessage.isSendTlv() + " payload Length:" + abilityMessage.getBypass().length);
        return this.btServer.output(this.mSelfId, this.mDeviceId, this.mIdentifier, create.serialize(), channelMessage.isSendTlv(), QosLevel.QOS_3 == channelMessage.getQos());
    }

    public void setSession(String str) {
        this.btServer.setSession(this.mDeviceId, str);
    }

    public void shutdown() {
        LogUtil.d(TAG, (Object) "BtLinkerImpl shutdown ");
        close();
        this.mDeviceId = null;
        this.mStreamObserver = null;
    }

    public void startup(String str, ILinker.LinkerStreamObserver linkerStreamObserver) {
        this.mDeviceId = str;
        this.mStreamObserver = linkerStreamObserver;
    }

    public void triggerAck(long j) {
    }

    public boolean triggerRetransmission(long j, long j2) {
        return this.btServer.triggerRetransmission(this.mSelfId, this.mDeviceId, this.mIdentifier, j, j2);
    }
}
