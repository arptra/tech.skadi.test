package com.upuphone.runasone.channel.linker.starrystack;

import android.os.Bundle;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.runasone.device.DeviceManagerImpl;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.service.StarrynetApiImpl;
import com.upuphone.runasone.utils.LogUtil;
import com.upuphone.starrynet.api.StConstant;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.strategy.netstack.XdpLinkManager;
import java.util.List;

public class XdpNetStackManager {
    public static final String INIT_SOURCE_WS_LINKER_OPEN = "WsLinker调用Open分配Client端";
    public static final int LOAD_ERROR = -1001;
    public static final int LOAD_ERROR_EXCEPTION = -1002;
    public static final int LOAD_ERROR_NOT_SUPPORT = -1003;
    public static final int LOAD_ERROR_NO_P2P_ADDRESS = -1004;
    public static final String LOAD_SOURCE_DEVICE_LISTENER_P2P_CONNECTED = "DeviceListener中p2p连接回调";
    public static final String LOAD_SOURCE_INIT = "私有协议栈首次初始化";
    public static final String LOAD_SOURCE_SERVER_ON_P2P_CONNECTED = "server端p2p连接回调";
    public static final String SOURCE_WS_CLIENT_CLOSE = "WsClient调用Close";
    public static final String SOURCE_WS_CLIENT_INIT = "WsClient initChannel初始化";
    public static final String SOURCE_WS_SERVER_CLOSE = "WsServer调用Close";
    public static final String SOURCE_WS_SERVER_INIT = "WsServer init初始化";
    public static final String SOURCE_WS_SERVER_INIT_AGAIN = "WsServer再次initInner初始化";
    public static final String SOURCE_WS_SERVER_INIT_WEBSOCKET_SERVER = "WsServer初始化WebSocketServer";

    public static class Holder {
        /* access modifiers changed from: private */
        public static final XdpNetStackManager INSTANCE = new XdpNetStackManager();

        private Holder() {
        }
    }

    public static XdpNetStackManager getInstance() {
        return Holder.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r0 = com.upuphone.starrynet.strategy.netstack.XdpLinkManager.getLocalP2PAddress();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isP2pAddr(java.lang.String r4) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 != 0) goto L_0x005a
            java.lang.String r0 = "UnKnown"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0010
            goto L_0x005a
        L_0x0010:
            java.lang.String r0 = com.upuphone.starrynet.strategy.netstack.XdpLinkManager.getLocalP2PAddress()
            java.lang.String r2 = "."
            int r2 = r0.lastIndexOf(r2)
            r3 = -1
            if (r2 != r3) goto L_0x001e
            return r1
        L_0x001e:
            java.lang.String r0 = r0.substring(r1, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "maskAddr : "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.upuphone.runasone.utils.LogUtil.d(r2)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L_0x003d
            return r1
        L_0x003d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "ipAddr.startsWith : "
            r1.append(r2)
            boolean r2 = r4.startsWith(r0)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.upuphone.runasone.utils.LogUtil.d(r1)
            boolean r4 = r4.startsWith(r0)
            return r4
        L_0x005a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.channel.linker.starrystack.XdpNetStackManager.isP2pAddr(java.lang.String):boolean");
    }

    public void init(String str) {
        LogUtil.i(str + "_initXdp开始初始化私有协议栈");
        LogUtil.i(str + "_initXdp初始化私有协议栈完成，开始接管p2p网卡");
        loadP2p0(str + AccountConstantKt.DEFAULT_SEGMENT + LOAD_SOURCE_INIT);
    }

    public boolean isXdpAvailable(String str, byte b) {
        if (!XdpLinkManager.getInstance().isSupportStarryNetStack()) {
            LogUtil.i("current device is not support xdp!");
            return false;
        }
        List<StarryDevice> connectedDevices = DeviceManagerImpl.getInstance().getConnectedDevices(1);
        if (connectedDevices == null || connectedDevices.size() < 1) {
            LogUtil.i("has no connected devices.");
            return false;
        }
        LogUtil.i("remoteDeviceList detail:" + connectedDevices.get(0));
        if (!connectedDevices.get(0).getStarryDevice().isSupportStarryNetStack(b)) {
            LogUtil.i("remoteDevice is not support xdp capacity:" + XdpLinkManager.getInstance().transCapByteToString(b));
            return false;
        }
        LogUtil.i(str + "_私有协议栈可用.");
        return true;
    }

    public boolean isXdpAvailableForUnload() {
        if (XdpLinkManager.getInstance().isSupportStarryNetStack()) {
            return true;
        }
        LogUtil.i("current device is not support xdp!");
        return false;
    }

    public int loadP2p0(String str) {
        List<StarryDevice> connectedDevices = DeviceManagerImpl.getInstance().getConnectedDevices(1);
        if (connectedDevices == null || connectedDevices.size() < 1) {
            LogUtil.i("loadP2p0:has no connected devices.");
            return -1;
        }
        LogUtil.i("loadP2p0 remoteDeviceList detail:" + connectedDevices.get(0));
        Bundle bundle = new Bundle();
        bundle.putString(StConstant.STARRY_NET_STACK_IFACE_NAME, "p2p0");
        bundle.putInt(StConstant.STARRY_NET_STACK_MTU, StConstant.STARRY_NET_STACK_MTU_VAL);
        return StarrynetApiImpl.getInstance().starryNetStackActionCmd(0, bundle, connectedDevices.get(0).getStarryDevice()) ? 0 : -1;
    }

    public void unloadP2p0(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(StConstant.STARRY_NET_STACK_IFACE_NAME, "p2p0");
        boolean starryNetStackActionCmd = StarrynetApiImpl.getInstance().starryNetStackActionCmd(1, bundle, (StDevice) null);
        LogUtil.i("unloadP2p0 return : " + starryNetStackActionCmd);
    }

    private XdpNetStackManager() {
    }
}
