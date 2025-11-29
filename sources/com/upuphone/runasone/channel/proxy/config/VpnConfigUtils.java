package com.upuphone.runasone.channel.proxy.config;

import android.text.TextUtils;
import com.honey.account.w5.a;
import com.honey.account.w5.b;
import com.upuphone.runasone.channel.ChannelManagerImpl;
import com.upuphone.runasone.channel.IChannel;
import com.upuphone.runasone.channel.bean.auth.VpnParameter;
import com.upuphone.runasone.channel.proxy.ProxyManager;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.host.core.api.EnumLinkStrategy;
import com.upuphone.runasone.utils.CommonThreadPool;
import com.upuphone.runasone.utils.LogUtil;
import com.upuphone.runasone.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class VpnConfigUtils {
    private static final String TAG = "VPNConfig-VpnConfigUtils";

    public static void asyncRequestVpnConfig(IConfigResponseListener iConfigResponseListener) {
        CommonThreadPool.execute(new a(iConfigResponseListener));
    }

    private static void changeVpnProxyState(boolean z, StarryDevice starryDevice, VpnParameter vpnParameter) {
        LogUtil.d(TAG, (Object) "deviceId=" + starryDevice.toString());
        StringBuilder sb = new StringBuilder();
        sb.append("VPNParameter=");
        sb.append(vpnParameter == null ? "null" : vpnParameter.toString());
        LogUtil.d(TAG, (Object) sb.toString());
        if (z && Utils.isCar() && Utils.isPhoneOfRemoteDev(starryDevice) && vpnParameter != null && vpnParameter.isValid()) {
            ProxyManager.getInstance().connect(Utils.getContext(), vpnParameter.getIp(), vpnParameter.getTcpPort(), vpnParameter.getUdpPort(), 0);
            LogUtil.d(TAG, (Object) "车机手机高速通道连接成功后，在车机端连接vpn服务器");
        } else if (z && Utils.isPad() && vpnParameter != null && vpnParameter.isValid()) {
            ProxyManager.getInstance().connect(Utils.getContext(), vpnParameter.getIp(), vpnParameter.getTcpPort(), vpnParameter.getUdpPort(), 0);
            LogUtil.d(TAG, (Object) "车机 pad高速通道连接成功后，在pad端连接vpn服务器接");
        } else if (!z && Utils.isCar() && Utils.isPhoneOfRemoteDev(starryDevice)) {
            ProxyManager.getInstance().clearInfo();
            ProxyManager.getInstance().disConnect();
            LogUtil.d(TAG, (Object) "车机手机高速通道断开后，在车机端清除并断开vpn连接");
        } else if (!z && Utils.isPad()) {
            ProxyManager.getInstance().clearInfo();
            ProxyManager.getInstance().disConnect();
            LogUtil.d(TAG, (Object) "车机Pad高速通道断开后，在pad端清除并断开vpn连接");
        } else if (z || !Utils.isPhone()) {
            LogUtil.d(TAG, (Object) "不做任何操作 isUp=" + z + " selfType=" + Utils.getSelfTerminalType() + " remoteType=" + Utils.getDeviceTerminalType(starryDevice));
        } else {
            ProxyManager.getInstance().clearInfo();
            ProxyManager.getInstance().stopServer();
            LogUtil.d(TAG, (Object) "手机p2p断开后，在手机端停止ProxyServer");
        }
    }

    public static boolean handle(String str, String str2) {
        return VpnConfigSyncer.get().input(str, str2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$notifyVpnStateChangedWhenChannelStateChanged$2(StarryDevice starryDevice, VpnConfigCmd vpnConfigCmd, VpnConfig vpnConfig) {
        IChannel findChannelById = ChannelManagerImpl.getInstance().findChannelById(starryDevice.getId());
        if (findChannelById == null || !findChannelById.isLinkUp(EnumLinkStrategy.STRATEGY_HIGH_PERFORMANCE)) {
            vpnConfigCmd.config = null;
            LogUtil.d(TAG, (Object) "PAD状态变化,但是通道又已经关闭了，直接将vpn关掉吧");
        } else {
            vpnConfigCmd.config = vpnConfig;
            StringBuilder sb = new StringBuilder();
            sb.append("PAD状态变化，通知VPN状态变化 UP=true vpnCofig=");
            sb.append(vpnConfig == null ? "NULL" : vpnConfig.toString());
            LogUtil.d(TAG, (Object) sb.toString());
        }
        VpnConfigSyncer.get().handlerStatusChanged(starryDevice.getId(), vpnConfigCmd);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$requestVpnConfig$1(Object obj, VpnConfig[] vpnConfigArr, VpnConfig vpnConfig) {
        synchronized (obj) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("收到远程回复的vpn信息：config=");
                sb.append(vpnConfig == null ? "NULL" : vpnConfig.toString());
                LogUtil.d(TAG, (Object) sb.toString());
                vpnConfigArr[0] = vpnConfig;
                obj.notify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void notifyVpnStateChangedToPad(boolean z) {
        LogUtil.d(TAG, (Object) "通知Pad VPN状态变化");
        ArrayList<IChannel> arrayList = new ArrayList<>();
        for (Map.Entry<String, IChannel> value : ChannelManagerImpl.getInstance().findAllChannel().entrySet()) {
            IChannel iChannel = (IChannel) value.getValue();
            if (iChannel != null && iChannel.isLinkUp(EnumLinkStrategy.STRATEGY_HIGH_PERFORMANCE) && iChannel.getDevice().getTerminalType() == 9) {
                arrayList.add(iChannel);
            }
        }
        ProxyManager.ProxyServerInfo proxyServerInfo = ProxyManager.getInstance().getProxyServerInfo();
        for (IChannel iChannel2 : arrayList) {
            if (!(iChannel2 == null || !iChannel2.isLinkUp(EnumLinkStrategy.STRATEGY_HIGH_PERFORMANCE) || iChannel2.getDevice() == null || iChannel2.getDevice().getId() == null)) {
                VpnConfig vpnConfig = new VpnConfig();
                if (!z || proxyServerInfo == null || !proxyServerInfo.isValid()) {
                    vpnConfig = null;
                } else {
                    vpnConfig.ip = proxyServerInfo.ip;
                    vpnConfig.tcpPort = proxyServerInfo.tcpPort;
                    vpnConfig.udpPort = proxyServerInfo.udpPort;
                    vpnConfig.allowMode = proxyServerInfo.allowMode;
                }
                VpnConfigCmd vpnConfigCmd = new VpnConfigCmd();
                vpnConfigCmd.config = vpnConfig;
                vpnConfigCmd.cmdType = 3;
                VpnConfigSyncer.get().output(iChannel2.getDevice().getId(), vpnConfigCmd);
            }
        }
    }

    private static void notifyVpnStateChangedWhenChannelStateChanged(boolean z, StarryDevice starryDevice) {
        VpnConfigCmd vpnConfigCmd = new VpnConfigCmd();
        if (Utils.isPad()) {
            if (!z) {
                vpnConfigCmd.config = null;
                VpnConfigSyncer.get().handlerStatusChanged(starryDevice.getId(), vpnConfigCmd);
                return;
            }
            asyncRequestVpnConfig(new a(starryDevice, vpnConfigCmd));
        } else if (!Utils.isCar() || !Utils.isPhoneOfRemoteDev(starryDevice)) {
            LogUtil.d(TAG, (Object) "非目标设备，不调用notifyVpnStateChangedWhenChannelStateChanged");
        } else {
            LogUtil.d(TAG, (Object) "手机-车机高速通道状态变化->Channel Open:" + z);
            notifyVpnStateChangedToPad(z);
        }
    }

    public static void regVpnConfigChangedListener(IConfigChangedListener iConfigChangedListener) {
        VpnConfigSyncer.get().setConfigChangedListener(iConfigChangedListener);
    }

    public static VpnConfig requestVpnConfig() {
        String str;
        VpnConfig vpnConfig;
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<Map.Entry<String, IChannel>> it = ChannelManagerImpl.getInstance().findAllChannel().entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                str = null;
                break;
            }
            IChannel iChannel = (IChannel) it.next().getValue();
            if (iChannel != null && iChannel.isLinkUp(EnumLinkStrategy.STRATEGY_HIGH_PERFORMANCE) && iChannel.getDevice().getTerminalType() == 3) {
                str = iChannel.getDevice().getId();
                break;
            }
        }
        LogUtil.d(TAG, (Object) "开始请求车机<" + str + ">的VPN配置信息");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Object obj = new Object();
        VpnConfig[] vpnConfigArr = new VpnConfig[1];
        String requestConfig = VpnConfigSyncer.get().requestConfig(str, new b(obj, vpnConfigArr));
        if (TextUtils.isEmpty(requestConfig)) {
            LogUtil.d(TAG, (Object) "SeqNum is null");
            return null;
        }
        synchronized (obj) {
            try {
                obj.wait(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
                vpnConfigArr = null;
            }
        }
        VpnConfigSyncer.get().removeConfigResponseListener(requestConfig);
        LogUtil.d(TAG, (Object) "获取车机VPN配置用时" + (System.currentTimeMillis() - currentTimeMillis) + "毫秒");
        if (vpnConfigArr == null || (vpnConfig = vpnConfigArr[0]) == null) {
            return null;
        }
        return vpnConfig;
    }

    public static void unRegVpnConfigChangedListener() {
        VpnConfigSyncer.get().setConfigChangedListener((IConfigChangedListener) null);
    }

    public static void update(boolean z, StarryDevice starryDevice, VpnParameter vpnParameter) {
        changeVpnProxyState(z, starryDevice, vpnParameter);
        notifyVpnStateChangedWhenChannelStateChanged(z, starryDevice);
    }
}
