package com.upuphone.runasone.channel.proxy.config;

import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.upuphone.runasone.QosLevel;
import com.upuphone.runasone.StreamType;
import com.upuphone.runasone.channel.core.OutputCore;
import com.upuphone.runasone.channel.core.bean.ActionBean;
import com.upuphone.runasone.channel.proxy.ProxyManager;
import com.upuphone.runasone.host.core.api.AbilityMessage;
import com.upuphone.runasone.utils.LogUtil;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

class VpnConfigSyncer {
    public static final String TAG = "VPNConfig-VPNConfigSyncer";
    private static VpnConfigSyncer syncer = new VpnConfigSyncer();
    private IConfigChangedListener mConfigChangedListener;
    private ConcurrentHashMap<String, IConfigResponseListener> responses = new ConcurrentHashMap<>();

    private VpnConfigSyncer() {
    }

    public static VpnConfigSyncer get() {
        return syncer;
    }

    private void handlerRequest(String str, VpnConfigCmd vpnConfigCmd) {
        VpnConfig vpnConfig;
        ProxyManager.ProxyServerInfo proxyServerInfo = ProxyManager.getInstance().getProxyServerInfo();
        LogUtil.d(TAG, (Object) "返回VPN配置 info = " + proxyServerInfo.toString());
        if (proxyServerInfo.isValid()) {
            vpnConfig = new VpnConfig();
            vpnConfig.ip = proxyServerInfo.ip;
            vpnConfig.tcpPort = proxyServerInfo.tcpPort;
            vpnConfig.udpPort = proxyServerInfo.udpPort;
            vpnConfig.allowMode = proxyServerInfo.allowMode;
        } else {
            vpnConfig = null;
        }
        VpnConfigCmd vpnConfigCmd2 = new VpnConfigCmd();
        vpnConfigCmd2.cmdType = 2;
        vpnConfigCmd2.config = vpnConfig;
        vpnConfigCmd2.ackNumber = vpnConfigCmd.seqNumber;
        output(str, vpnConfigCmd2);
    }

    public void handlerResponse(String str, VpnConfigCmd vpnConfigCmd) {
        IConfigResponseListener remove = this.responses.remove(vpnConfigCmd.ackNumber);
        if (remove == null) {
            LogUtil.e(TAG, (Object) "没有注册mConfigResponse or 返回消息超时");
            return;
        }
        LogUtil.e(TAG, (Object) "handlerResponse");
        remove.onResponse(vpnConfigCmd.config);
    }

    public synchronized void handlerStatusChanged(String str, VpnConfigCmd vpnConfigCmd) {
        IConfigChangedListener iConfigChangedListener = this.mConfigChangedListener;
        if (iConfigChangedListener == null) {
            LogUtil.e(TAG, (Object) "没有注册mConfigChangedListener");
        } else {
            iConfigChangedListener.onChanged(vpnConfigCmd.config);
        }
    }

    public boolean input(String str, String str2) {
        try {
            VpnConfigCmd vpnConfigCmd = (VpnConfigCmd) new Gson().fromJson(str2, VpnConfigCmd.class);
            if (vpnConfigCmd == null) {
                LogUtil.e(TAG, (Object) "无法识别命令");
                return false;
            }
            LogUtil.d(TAG, (Object) "cmd.cmdType=" + vpnConfigCmd.cmdType);
            int i = vpnConfigCmd.cmdType;
            if (i == 1) {
                handlerRequest(str, vpnConfigCmd);
            } else if (i == 2) {
                handlerResponse(str, vpnConfigCmd);
            } else if (i == 3) {
                LogUtil.d(TAG, (Object) "来自远程的VPN状态变化通知");
                handlerStatusChanged(str, vpnConfigCmd);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e(TAG, (Object) "无法解析json");
            return false;
        }
    }

    public boolean output(String str, VpnConfigCmd vpnConfigCmd) {
        if (vpnConfigCmd == null) {
            return false;
        }
        ActionBean actionBean = new ActionBean();
        actionBean.setActionType(4);
        actionBean.setData(new Gson().toJson((Object) vpnConfigCmd));
        String json = new Gson().toJson((Object) actionBean);
        int sendTo = OutputCore.getInstance().sendTo(str, str, QosLevel.QOS_0, new AbilityMessage(json.getBytes()), StreamType.ACTION);
        LogUtil.d(TAG, (Object) "Published!  errorCode=" + sendTo + " msg=" + json);
        return sendTo == 0;
    }

    public void removeConfigResponseListener(String str) {
        this.responses.remove(str);
    }

    public String requestConfig(String str, @NonNull IConfigResponseListener iConfigResponseListener) {
        VpnConfigCmd vpnConfigCmd = new VpnConfigCmd();
        vpnConfigCmd.cmdType = 1;
        String uuid = UUID.randomUUID().toString();
        vpnConfigCmd.seqNumber = uuid;
        this.responses.put(uuid, iConfigResponseListener);
        if (output(str, vpnConfigCmd)) {
            return vpnConfigCmd.seqNumber;
        }
        this.responses.remove(vpnConfigCmd.seqNumber);
        return null;
    }

    public void setConfigChangedListener(IConfigChangedListener iConfigChangedListener) {
        this.mConfigChangedListener = iConfigChangedListener;
    }
}
