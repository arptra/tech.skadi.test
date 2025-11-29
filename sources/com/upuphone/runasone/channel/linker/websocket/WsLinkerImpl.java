package com.upuphone.runasone.channel.linker.websocket;

import android.text.TextUtils;
import com.upuphone.runasone.StreamReq;
import com.upuphone.runasone.channel.bean.auth.AuthParameter;
import com.upuphone.runasone.channel.bean.stream.StreamBuilder;
import com.upuphone.runasone.channel.linker.EnumLinker;
import com.upuphone.runasone.channel.linker.ILinker;
import com.upuphone.runasone.channel.linker.starrystack.XdpNetStackManager;
import com.upuphone.runasone.channel.linker.websocket.client.WsClient;
import com.upuphone.runasone.channel.linker.websocket.server.WsServer;
import com.upuphone.runasone.device.DeviceManagerImpl;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.message.ChannelMessage;
import com.upuphone.runasone.service.StarrynetApiImpl;
import com.upuphone.runasone.utils.LogUtil;

public class WsLinkerImpl implements ILinker {
    private static final String TAG = "WsLinkerImpl";
    private boolean bLink = false;
    private boolean bServer;
    private String mDeviceId;
    private EnumLinker mLinkerType;
    private ILinker.LinkerStreamObserver mStreamObserver;
    private WsClient mWebSocketClient;
    private String selfId;
    private String session;

    public WsLinkerImpl(EnumLinker enumLinker) {
        this.mLinkerType = enumLinker;
    }

    private boolean allocClient(StarryDevice starryDevice, AuthParameter authParameter) {
        String str = TAG;
        LogUtil.d(str, (Object) "WsClient open findStarryDevice getSelfId:" + starryDevice.getSelfId() + " getId:" + starryDevice.getId() + " getAddress:" + starryDevice.getAddress() + " getPort:" + starryDevice.getPort());
        String selfId2 = starryDevice.getSelfId();
        if (TextUtils.isEmpty(selfId2)) {
            selfId2 = StarrynetApiImpl.getInstance().getSelfId();
        }
        this.mWebSocketClient = new WsClient(selfId2, this.mDeviceId, starryDevice.getTerminalType(), starryDevice.getAddress(), starryDevice.getPort(), this.mStreamObserver, getLinkerType(), authParameter);
        LogUtil.d("WsClient alloc success");
        return true;
    }

    private boolean allocClientWrap(StarryDevice starryDevice, AuthParameter authParameter) {
        if (XdpNetStackManager.isP2pAddr(starryDevice.getAddress()) && XdpNetStackManager.getInstance().isXdpAvailable(XdpNetStackManager.INIT_SOURCE_WS_LINKER_OPEN, (byte) 1)) {
            XdpNetStackManager.getInstance().init(XdpNetStackManager.INIT_SOURCE_WS_LINKER_OPEN);
        }
        return allocClient(starryDevice, authParameter);
    }

    private EnumLinker getLinkerType() {
        return this.mLinkerType;
    }

    private boolean linkServer(StarryDevice starryDevice, AuthParameter authParameter) {
        WsServer.getInstance().link(starryDevice.getSelfId(), this.mDeviceId, getLinkerType(), this.mStreamObserver, authParameter);
        return true;
    }

    private void releaseClient() {
        WsClient wsClient = this.mWebSocketClient;
        if (wsClient != null) {
            wsClient.close();
            this.mWebSocketClient = null;
        }
        if (XdpNetStackManager.getInstance().isXdpAvailable(XdpNetStackManager.SOURCE_WS_CLIENT_CLOSE, (byte) 1)) {
            XdpNetStackManager.getInstance().unloadP2p0(XdpNetStackManager.SOURCE_WS_CLIENT_CLOSE);
        }
    }

    private void unlinkServer() {
        WsServer.getInstance().unlink(this.mDeviceId);
    }

    public void close() {
        if (this.bLink) {
            this.bLink = false;
            if (this.bServer) {
                LogUtil.d(TAG, (Object) "WebSocketServer close ");
                unlinkServer();
                return;
            }
            LogUtil.d(TAG, (Object) "WebSocketClient close ");
            releaseClient();
            return;
        }
        LogUtil.e("WsLinkerImpl bServer<" + this.bServer + "> is already closed");
    }

    public boolean isAuthTransition() {
        return false;
    }

    public void notifyTearDownSync() {
        if (this.bLink) {
            LogUtil.d("Channel <" + this.mDeviceId + "> Ws 通道准备卸载");
            StreamReq genTearDown = StreamBuilder.genTearDown(this.selfId, this.session);
            if (this.bServer ? WsServer.getInstance().notifyTearDownSync(this.mDeviceId, genTearDown) : this.mWebSocketClient.notifyTearDownSync(this.mDeviceId, genTearDown)) {
                LogUtil.d("Channel <" + this.mDeviceId + "> Ws 通道已卸载");
                return;
            }
            LogUtil.e("Channel <" + this.mDeviceId + "> Ws 通道卸载超时");
            return;
        }
        LogUtil.e("WsLinkerImpl notifyTearDownSync fail ... bServer<" + this.bServer + "> is already closed");
    }

    public boolean open(boolean z, AuthParameter authParameter) {
        LogUtil.d("open " + this.mDeviceId);
        StarryDevice findConnectDevice = DeviceManagerImpl.getInstance().findConnectDevice(this.mDeviceId);
        if (findConnectDevice == null) {
            LogUtil.e("findStarryDeviceOnP2P " + this.mDeviceId + "is null");
            return false;
        } else if (findConnectDevice.checkStatus(2) || findConnectDevice.checkStatus(4)) {
            this.bServer = z;
            this.selfId = findConnectDevice.getSelfId();
            if (this.bServer) {
                this.bLink = linkServer(findConnectDevice, authParameter);
            } else {
                this.bLink = allocClientWrap(findConnectDevice, authParameter);
            }
            return this.bLink;
        } else {
            LogUtil.e("findStarryDeviceOnP2P device status is " + findConnectDevice.getStatus());
            return false;
        }
    }

    public boolean output(ChannelMessage channelMessage) {
        if (this.bLink) {
            StreamReq genByPass = StreamBuilder.genByPass(channelMessage);
            return this.bServer ? WsServer.getInstance().output(this.mDeviceId, genByPass) : this.mWebSocketClient.output(genByPass);
        }
        LogUtil.e("Channel <" + this.mDeviceId + "> Ws 通道已关闭 output fail ！！！ ");
        return false;
    }

    public void setSession(String str) {
        this.session = str;
        if (this.bServer) {
            WsServer.getInstance().setSession(this.mDeviceId, str);
        } else {
            this.mWebSocketClient.setSession(this.mDeviceId, str);
        }
    }

    public void shutdown() {
        LogUtil.d(TAG, (Object) "WsLinkerImpl shutdown ");
        close();
    }

    public void startup(String str, ILinker.LinkerStreamObserver linkerStreamObserver) {
        this.mDeviceId = str;
        this.mStreamObserver = linkerStreamObserver;
    }

    public void triggerAck(long j) {
        StreamReq genAck = StreamBuilder.genAck(j, this.selfId, this.session);
        if (this.bServer) {
            WsServer.getInstance().trigger(this.mDeviceId, genAck);
        } else {
            this.mWebSocketClient.trigger(this.mDeviceId, genAck);
        }
    }

    public boolean triggerRetransmission(long j, long j2) {
        LogUtil.d("triggerRetransmission");
        StreamReq genRetransmission = StreamBuilder.genRetransmission(this.selfId, j, j2, this.session);
        return this.bServer ? WsServer.getInstance().trigger(this.mDeviceId, genRetransmission) : this.mWebSocketClient.trigger(this.mDeviceId, genRetransmission);
    }
}
