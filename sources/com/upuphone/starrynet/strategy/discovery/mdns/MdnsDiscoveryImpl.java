package com.upuphone.starrynet.strategy.discovery.mdns;

import android.content.Context;
import android.net.nsd.NsdServiceInfo;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import com.google.gson.Gson;
import com.upuphone.starrynet.api.StConstant;
import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.common.utils.Utils;
import com.upuphone.starrynet.core.dns.NsdLog;
import com.upuphone.starrynet.core.dns.NsdServiceCallback;
import com.upuphone.starrynet.core.dns.NsdServiceManager;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Map;

public class MdnsDiscoveryImpl extends NsdServiceCallback {
    private static final String TAG = "MdnsDiscoveryImpl";
    private volatile boolean mIsDiscovery = false;
    private final NsdServiceManager mNsdServiceManager;
    @GuardedBy
    private volatile boolean mStartDisStatus = false;
    private final Object mStartDiscoverySync = new Object();
    @GuardedBy
    private volatile boolean mStopDisStatus = false;
    private final Object mStopDiscoverySync = new Object();
    private final String serviceType = "_http._tcp";

    public MdnsDiscoveryImpl(Context context) {
        this.mNsdServiceManager = new NsdServiceManager(context, this);
    }

    public void onServiceFound(NsdServiceInfo nsdServiceInfo) {
        NsdLog.LOG.debug(TAG, "onServiceFound>>serviceInfo=%s", nsdServiceInfo != null ? nsdServiceInfo.toString() : "null");
        if (nsdServiceInfo != null && nsdServiceInfo.getServiceName() != null && nsdServiceInfo.getServiceName().length() == 12) {
            NsdLog.LOG.debug(TAG, "begin resolvedService>>serviceInfo=%s", nsdServiceInfo.toString());
            this.mNsdServiceManager.resolvedService(nsdServiceInfo);
        }
    }

    public void onServiceLost(NsdServiceInfo nsdServiceInfo) {
        NsdLog.LOG.debug(TAG, "onServiceLost>>serviceInfo=%s", nsdServiceInfo != null ? nsdServiceInfo.toString() : "null");
    }

    public void onServiceResolvedStatus(NsdServiceInfo nsdServiceInfo, int i, boolean z) {
        if (nsdServiceInfo == null) {
            NsdLog.LOG.debug(TAG, "onServiceResolved Status>>>%s serviceInfo is null", String.valueOf(z));
            return;
        }
        NsdLog.LOG.debug(TAG, "onServiceResolved Status>>>%s serviceInfo=%s", String.valueOf(z), nsdServiceInfo.toString());
        if (z) {
            Map<String, byte[]> attributes = nsdServiceInfo.getAttributes();
            MdnsData mdnsData = null;
            byte[] bArr = attributes != null ? attributes.get(StConstant.HUD_PAYLOAD_KEY) : null;
            if (bArr != null) {
                try {
                    String str = new String(bArr);
                    NsdLog.LOG.debug(TAG, "onServiceResolved strData=%s", str);
                    mdnsData = (MdnsData) new Gson().fromJson(str, MdnsData.class);
                } catch (Exception e) {
                    NsdLog.LOG.error(TAG, "onServiceResolved parse payload fail!!");
                    e.printStackTrace();
                }
                if (mdnsData == null || !(mdnsData.getTerminalType() == 7 || mdnsData.getTerminalType() == 10)) {
                    NsdLog.LOG.debug(TAG, "find new device but is null", "");
                } else if (ByteUtils.byteEquals(StarryNetData.getInstance().getOwnDevice().getIdentifier(), Utils.hexString2Bytes(mdnsData.getIdentifier()))) {
                    NsdLog.LOG.debug(TAG, "self find self,so return; Identifier=%s", mdnsData.getIdentifier());
                } else {
                    NsdLog.LOG.debug(TAG, "find new device Identifier=%s", mdnsData.getIdentifier());
                    InetAddress host = nsdServiceInfo.getHost();
                    if (host instanceof Inet4Address) {
                        StDiscoveryDevice stDiscoveryDevice = new StDiscoveryDevice();
                        int port = nsdServiceInfo.getPort();
                        int ip = mdnsData.getIp();
                        String ipIntToString = IPUtils.ipIntToString(ip);
                        String hostAddress = host.getHostAddress();
                        NsdLog.LOG.debug(TAG, "find new device => ip=%s payload_ip=%s nsd_ip=%s", Integer.valueOf(ip), ipIntToString, hostAddress);
                        if (!TextUtils.equals(ipIntToString, hostAddress)) {
                            NsdLog.LOG.error(TAG, "payload_ip and nsd_ip is diff");
                        }
                        stDiscoveryDevice.setDeviceName(mdnsData.getDeviceName());
                        stDiscoveryDevice.setDeviceType((byte) 1);
                        stDiscoveryDevice.setDiscType((byte) 2);
                        stDiscoveryDevice.setTerminalType(mdnsData.getTerminalType());
                        stDiscoveryDevice.setIdentifier(Utils.hexString2Bytes(mdnsData.getIdentifier()));
                        stDiscoveryDevice.setPort(port);
                        if (ip == 0) {
                            ipIntToString = hostAddress;
                        }
                        stDiscoveryDevice.setIpAddress(ipIntToString);
                        DirectConnector.getInstance().connect(stDiscoveryDevice);
                        NsdLog.LOG.debug(TAG, "find new device>>ip=%s port=%s", stDiscoveryDevice.getIpAddress(), String.valueOf(stDiscoveryDevice.getPort()));
                        return;
                    }
                    NsdLog.LOG.debug(TAG, "find new device but IP is ipV6", "");
                }
            }
        } else {
            NsdLog.LOG.debug(TAG, "Service resolved fail");
        }
    }

    public void onStartDiscoveryStatus(String str, int i, boolean z) {
        NsdLog.LOG.debug(TAG, "finish start discovery>>status=%s", String.valueOf(z));
        this.mStartDisStatus = z;
        synchronized (this.mStartDiscoverySync) {
            this.mStartDiscoverySync.notifyAll();
        }
    }

    public void onStopDiscoveryStatus(String str, int i, boolean z) {
        NsdLog.LOG.debug(TAG, "finish stop discovery>>status=%s", String.valueOf(z));
        this.mStopDisStatus = z;
        synchronized (this.mStopDiscoverySync) {
            this.mStopDiscoverySync.notifyAll();
        }
    }

    public boolean startDiscovery() {
        if (!this.mIsDiscovery) {
            NsdLog.LOG.debug(TAG, "startDiscovery begin");
            this.mNsdServiceManager.startDiscovery("_http._tcp");
            try {
                synchronized (this.mStartDiscoverySync) {
                    this.mStartDiscoverySync.wait(5000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                NsdLog nsdLog = NsdLog.LOG;
                nsdLog.error(TAG, "startDiscovery lock: " + e);
            }
            if (!this.mStartDisStatus) {
                try {
                    this.mNsdServiceManager.stopDiscovery();
                } catch (Exception unused) {
                    NsdLog.LOG.error(TAG, "mdns has stop discovery");
                }
            }
            this.mIsDiscovery = this.mStartDisStatus;
        } else {
            NsdLog.LOG.debug(TAG, "discovery is run,do nothing");
        }
        return this.mStartDisStatus;
    }

    public boolean stopDiscovery() {
        if (!this.mIsDiscovery) {
            NsdLog.LOG.error(TAG, "discovery had stop");
            return false;
        }
        NsdLog.LOG.error(TAG, "stop discovery begin");
        try {
            this.mNsdServiceManager.stopDiscovery();
        } catch (Exception unused) {
            NsdLog.LOG.error(TAG, "mdns has stop discovery");
        }
        try {
            synchronized (this.mStopDiscoverySync) {
                this.mStopDiscoverySync.wait(5000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            NsdLog nsdLog = NsdLog.LOG;
            nsdLog.error(TAG, "stopDiscovery lock: " + e);
        }
        this.mIsDiscovery = false;
        return this.mStopDisStatus;
    }
}
