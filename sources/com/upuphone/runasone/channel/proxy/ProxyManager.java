package com.upuphone.runasone.channel.proxy;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.honey.account.u5.a;
import com.upuphone.runasone.channel.proxy.client.SocksProxyHandler;
import com.upuphone.runasone.channel.proxy.client.UDPHandler;
import com.upuphone.runasone.channel.proxy.client.adapter.Socks5Adapter;
import com.upuphone.runasone.channel.proxy.client.service.LocalVpnService;
import com.upuphone.runasone.channel.proxy.client.util.DebugLog;
import com.upuphone.runasone.channel.proxy.client.util.Global;
import com.upuphone.runasone.channel.proxy.client.util.Iptool;
import com.upuphone.runasone.channel.proxy.config.IConfigChangedListener;
import com.upuphone.runasone.channel.proxy.config.VpnConfig;
import com.upuphone.runasone.channel.proxy.config.VpnConfigUtils;
import com.upuphone.runasone.channel.proxy.server.Socks5Server;
import com.upuphone.runasone.utils.LogUtil;
import com.upuphone.runasone.utils.Utils;
import java.net.InetSocketAddress;

public class ProxyManager {
    private static final String TAG = "VPNConfig-ProxyManager";
    private static String[] disallowedVpnApps = {"com.upuphone.starrynet"};
    private static ProxyManager manager;
    private final int START_VPN_SERVICE_REQUEST_CODE = 1985;
    private Class activityClazz;
    private IConfigChangedListener configChangedListener = new a(this);
    private Context mContext = Utils.getContext();
    private ContentResolver mCr;
    private Handler mHandler = new Handler(this.mContext.getMainLooper());
    /* access modifiers changed from: private */
    public ProxyServerInfo mVpnServerInfo = new ProxyServerInfo();

    public static class ProxyServerInfo implements Cloneable {
        public int allowMode = -1;
        public String ip = "";
        public int tcpPort = 0;
        public int udpPort = 0;

        public void init(String str, int i, int i2, int i3) {
            this.ip = str;
            this.tcpPort = i;
            this.udpPort = i2;
            this.allowMode = i3;
        }

        public boolean isValid() {
            return !TextUtils.isEmpty(this.ip) && this.tcpPort > 0 && this.udpPort > 0;
        }

        public String toString() {
            return "ProxyServerInfo{ip='" + this.ip + '\'' + ", tcpPort=" + this.tcpPort + ", udpPort=" + this.udpPort + ", allowMode=" + this.allowMode + '}';
        }

        @NonNull
        public ProxyServerInfo clone() throws CloneNotSupportedException {
            return (ProxyServerInfo) super.clone();
        }
    }

    public class VPNContentObserver extends ContentObserver {
        public VPNContentObserver(Handler handler) {
            super(handler);
        }

        public void onChange(boolean z, Uri uri) {
            try {
                DebugLog.i("%s: Settings onChange %s\n", ProxyManager.TAG, uri.toString());
                ProxyManager.this.p2pVpnEnable(ProxyManager.this.getWifiP2pVpnEnabled());
            } catch (Exception unused) {
                ProxyManager.this.mVpnServerInfo.init("", 0, 0, 0);
                DebugLog.e("%s: exception = %s!\n", ProxyManager.TAG, toString());
            }
        }
    }

    private ProxyManager() {
        ContentResolver contentResolver = this.mContext.getContentResolver();
        this.mCr = contentResolver;
        contentResolver.registerContentObserver(Settings.Global.getUriFor("vpn_enable_wifi_p2p"), false, new VPNContentObserver(this.mHandler));
        VpnConfigUtils.regVpnConfigChangedListener(this.configChangedListener);
    }

    public static synchronized ProxyManager getInstance() {
        ProxyManager proxyManager;
        synchronized (ProxyManager.class) {
            try {
                if (manager == null) {
                    manager = new ProxyManager();
                }
                proxyManager = manager;
            } catch (Throwable th) {
                throw th;
            }
        }
        return proxyManager;
    }

    /* access modifiers changed from: private */
    public int getWifiP2pVpnEnabled() {
        int i = Settings.Global.getInt(this.mContext.getContentResolver(), "vpn_enable_wifi_p2p", 0);
        DebugLog.i("%s: wifiP2pVpnEnable = %d\n", TAG, Integer.valueOf(i));
        return i;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(VpnConfig vpnConfig) {
        StringBuilder sb = new StringBuilder();
        sb.append("VPN信息变化，config=");
        sb.append(vpnConfig == null ? "NULL" : vpnConfig.toString());
        LogUtil.d(TAG, (Object) sb.toString());
        if (vpnConfig == null || !vpnConfig.isValid()) {
            this.mVpnServerInfo.init("", 0, 0, 0);
            disConnect();
            return;
        }
        updateVpnInfo(vpnConfig.ip, vpnConfig.tcpPort, vpnConfig.udpPort);
    }

    /* access modifiers changed from: private */
    public void p2pVpnEnable(int i) {
        DebugLog.i("%s: p2pVpnEnable = %d!\n", TAG, Integer.valueOf(i));
        if (Utils.isPad()) {
            if (i == 1) {
                VpnConfig requestVpnConfig = VpnConfigUtils.requestVpnConfig();
                StringBuilder sb = new StringBuilder();
                sb.append("获取的车机端VPN信息：");
                sb.append(requestVpnConfig == null ? "NULL" : requestVpnConfig.toString());
                LogUtil.d(TAG, (Object) sb.toString());
                if (requestVpnConfig == null || !requestVpnConfig.isValid()) {
                    LogUtil.e(TAG, (Object) "VPN配置信息不可用！！！");
                    this.mVpnServerInfo.init("", 0, 0, 0);
                    disConnect();
                    return;
                }
                connect(this.mContext, requestVpnConfig.ip, requestVpnConfig.tcpPort, requestVpnConfig.udpPort, requestVpnConfig.allowMode);
                return;
            }
            this.mVpnServerInfo.init("", 0, 0, 0);
            disConnect();
        } else if (!Utils.isCar()) {
        } else {
            if (i != 1 || !this.mVpnServerInfo.isValid()) {
                disConnect();
                return;
            }
            Context context = this.mContext;
            ProxyServerInfo proxyServerInfo = this.mVpnServerInfo;
            connect(context, proxyServerInfo.ip, proxyServerInfo.tcpPort, proxyServerInfo.udpPort, proxyServerInfo.allowMode);
        }
    }

    public void clearInfo() {
        this.mVpnServerInfo.init("", 0, 0, 0);
    }

    public boolean connect(Context context, String str, int i, int i2, int i3) {
        DebugLog.i("%s: VPN connect, ip = %s, TcpPort = %d, UdpPort = %d, allowMode = %d\n", TAG, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        this.mVpnServerInfo.init(str, i, i2, i3);
        if (getWifiP2pVpnEnabled() == 0) {
            DebugLog.i("%s: ignore vpn for wifiP2pVpnEnable = 0!\n", TAG);
            return false;
        } else if (Global.HOLDER.getVpnService() != null) {
            return false;
        } else {
            Global.HOLDER.setDataHandler(new SocksProxyHandler());
            Global.HOLDER.setPackHandler(new UDPHandler());
            Global.HOLDER.setAdapterClass(Socks5Adapter.class);
            Global.HOLDER.setInetSocketAddress(new InetSocketAddress(str, i));
            Global.HOLDER.setUdpServerPort(i2);
            this.activityClazz = context.getClass();
            Iptool.save("xjmz.wifi.vpn.enable", "1");
            try {
                context.startService(new Intent(context, LocalVpnService.class));
                return true;
            } catch (Exception e) {
                DebugLog.e("%s: e = %s\n", TAG, e);
                return true;
            }
        }
    }

    public void disConnect() {
        DebugLog.i("%s: VPN disConnect\n", TAG);
        LocalVpnService vpnService = Global.HOLDER.getVpnService();
        if (vpnService == null) {
            DebugLog.i("service = null\n", new Object[0]);
            return;
        }
        Iptool.save("xjmz.wifi.vpn.enable", "0");
        vpnService.stop();
    }

    public Class getActivityClazz() {
        return this.activityClazz;
    }

    public synchronized ProxyServerInfo getProxyServerInfo() {
        ProxyServerInfo proxyServerInfo = this.mVpnServerInfo;
        if (proxyServerInfo == null) {
            return null;
        }
        try {
            return proxyServerInfo.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public int getTcpPort() {
        if (!Socks5Server.getInstance().isRunning()) {
            return 0;
        }
        int tcpServerPort = Socks5Server.getInstance().getTcpServerPort();
        DebugLog.i("%s: getTcpPort, TcpPort = %d\n", TAG, Integer.valueOf(tcpServerPort));
        return tcpServerPort;
    }

    public int getUdpPort() {
        if (!Socks5Server.getInstance().isRunning()) {
            return 0;
        }
        int udpServerPort = Socks5Server.getInstance().getUdpServerPort();
        DebugLog.i("%s: getUdpPort, UdpPort = %d\n", TAG, Integer.valueOf(udpServerPort));
        return udpServerPort;
    }

    public void init() {
        LogUtil.d(TAG, (Object) "ProxyManger finish init!!!");
    }

    public boolean startServer(int i) {
        DebugLog.i("%s: startServer, Port = %d\n", TAG, Integer.valueOf(i));
        if (Socks5Server.getInstance().isRunning()) {
            return false;
        }
        Socks5Server.getInstance().start(i);
        return true;
    }

    public void stopServer() {
        DebugLog.i("%s: stopServer\n", TAG);
        if (Socks5Server.getInstance().isRunning()) {
            Socks5Server.getInstance().stop();
        }
    }

    public void updateVpnInfo(String str, int i, int i2) {
        LocalVpnService vpnService = Global.HOLDER.getVpnService();
        if (this.mVpnServerInfo.ip.equals(str)) {
            ProxyServerInfo proxyServerInfo = this.mVpnServerInfo;
            if (proxyServerInfo.tcpPort == i && proxyServerInfo.udpPort == i2) {
                DebugLog.i("%s: same vpn server is ignored!\n", TAG);
                return;
            }
        }
        if (!TextUtils.isEmpty(this.mVpnServerInfo.ip)) {
            if (vpnService != null) {
                DebugLog.v("%s:restart vpn .\n", TAG);
                disConnect();
                while (vpnService.isStopped()) {
                    DebugLog.v("%s: wait vpn stopped.\n", TAG);
                }
            } else {
                DebugLog.v("%s:start connect vpn .\n", TAG);
            }
        }
        connect(this.mContext, str, i, i2, -1);
    }
}
