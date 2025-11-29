package com.upuphone.starrynet.strategy.discovery.mdns;

import android.content.Context;
import android.net.nsd.NsdServiceInfo;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import com.google.gson.Gson;
import com.honey.account.constant.AccountConstantKt;
import com.meizu.common.widget.MzContactsContract;
import com.tencent.mmkv.MMKV;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StarryNetConstant;
import com.upuphone.starrynet.common.utils.Utils;
import com.upuphone.starrynet.core.dns.NsdLog;
import com.upuphone.starrynet.core.dns.NsdServiceCallback;
import com.upuphone.starrynet.core.dns.NsdServiceManager;
import com.upuphone.starrynet.strategy.StarryNetData;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLServerSocketFactory;

public class MdnsAdvertising extends NsdServiceCallback {
    private static final String TAG = "MdnsAdvertising";
    private final NsdServiceManager mNsdServiceManager;
    private volatile boolean mRepeat = false;
    @GuardedBy
    private volatile boolean mStartAdvStatus = false;
    private final Object mStartAdvertisingSync = new Object();
    @GuardedBy
    private volatile boolean mStopAdvStatus = false;
    private final Object mStopAdvertisingSync = new Object();
    private final String serviceType = "_http._tcp";

    public MdnsAdvertising(Context context) {
        this.mNsdServiceManager = new NsdServiceManager(context, this);
    }

    private String generateData() {
        StDevice ownDevice = StarryNetData.getInstance().getOwnDevice();
        MdnsData mdnsData = new MdnsData();
        if (StarryNetData.getInstance().isHUD()) {
            String networkInterfaceIPByName = getNetworkInterfaceIPByName("eth0");
            int ipStringToInt = IPUtils.ipStringToInt(networkInterfaceIPByName);
            NsdLog.LOG.debug(TAG, "eth0 ip => strIp=%s intIp=%s", networkInterfaceIPByName, String.valueOf(ipStringToInt));
            mdnsData.setIp(ipStringToInt);
        }
        mdnsData.setIdentifier(Utils.bytes2HexString(ownDevice.getIdentifier()));
        mdnsData.setDeviceName(ownDevice.getDeviceName());
        mdnsData.setTerminalType(ownDevice.getTerminalType());
        return new Gson().toJson((Object) mdnsData);
    }

    private int generateGoDefaultPort() {
        int testPortAvailable = testPortAvailable(takeCachePort());
        if (testPortAvailable > 0) {
            return testPortAvailable;
        }
        int nextInt = new SecureRandom().nextInt(15534) + 50000;
        while (nextInt < 65535) {
            int testPortAvailable2 = testPortAvailable(nextInt);
            if (testPortAvailable2 > 0) {
                saveCachePort(testPortAvailable2);
                return testPortAvailable2;
            }
            nextInt++;
            if (nextInt == 65534) {
                nextInt = 50000;
            }
        }
        return nextInt;
    }

    private String generateName() {
        return Utils.bytes2HexString(StarryNetData.getInstance().getOwnDevice().getIdentifier());
    }

    private String getNetworkInterfaceIPByName(String str) {
        try {
            ArrayList<T> list = Collections.list(NetworkInterface.getNetworkInterfaces());
            printNetInterface(list);
            for (T t : list) {
                if (TextUtils.equals(t.getName(), str)) {
                    for (T t2 : Collections.list(t.getInetAddresses())) {
                        if (!t2.isLoopbackAddress() && (t2 instanceof Inet4Address)) {
                            return t2.getHostAddress();
                        }
                    }
                    continue;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void printNetInterface(List<NetworkInterface> list) {
        NsdLog.LOG.debug(TAG, "--------print network interface start---------");
        try {
            Iterator<NetworkInterface> it = list.iterator();
            while (it.hasNext()) {
                NetworkInterface next = it.next();
                StringBuilder sb = new StringBuilder();
                sb.append(">>>>>");
                sb.append(next == null ? "NULL_INTERFACE" : next.getName());
                sb.append(AccountConstantKt.CODE_SEPARTOR);
                ArrayList<T> arrayList = new ArrayList<>();
                if (next != null) {
                    arrayList = Collections.list(next.getInetAddresses());
                }
                for (T t : arrayList) {
                    sb.append(t == null ? "NULL_ADDRESS" : t.getHostAddress());
                    sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
                }
                sb.append("\r\n");
                NsdLog.LOG.debug(TAG, sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        NsdLog.LOG.debug(TAG, "--------print network interface end---------");
    }

    private void saveCachePort(int i) {
        MMKV.n().r(StarryNetConstant.SAVE_LOCAL_CHANNEL_PORT, i);
    }

    private int takeCachePort() {
        return MMKV.n().e(StarryNetConstant.SAVE_LOCAL_CHANNEL_PORT, -1);
    }

    private int testPortAvailable(int i) {
        if (i <= 0) {
            return -1;
        }
        try {
            ServerSocket createServerSocket = SSLServerSocketFactory.getDefault().createServerSocket(i);
            int localPort = createServerSocket.getLocalPort();
            createServerSocket.close();
            return localPort;
        } catch (IOException e) {
            NsdLog.LOG.error(TAG, "IOException", (Throwable) e);
            return -1;
        }
    }

    public void onServiceRegisterStatus(NsdServiceInfo nsdServiceInfo, int i, boolean z) {
        this.mStartAdvStatus = z;
        synchronized (this.mStartAdvertisingSync) {
            this.mStartAdvertisingSync.notifyAll();
        }
    }

    public void onServiceUnregisterStatus(NsdServiceInfo nsdServiceInfo, int i, boolean z) {
        this.mStopAdvStatus = z;
        synchronized (this.mStopAdvertisingSync) {
            this.mStopAdvertisingSync.notifyAll();
        }
    }

    public boolean startAdvertising() {
        NsdLog.LOG.debug(TAG, "MdnsAdvertising begin start");
        if (!this.mRepeat) {
            int generateGoDefaultPort = generateGoDefaultPort();
            String generateData = generateData();
            String generateName = generateName();
            DirectConnector.getInstance().createServer(generateGoDefaultPort);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                NsdLog nsdLog = NsdLog.LOG;
                nsdLog.error(TAG, "startAdvertise sleep: " + e);
            }
            NsdLog.LOG.debug(TAG, "startAdvertising name=%s data=%s", generateName, generateData);
            this.mNsdServiceManager.registerService(generateName, "_http._tcp", generateGoDefaultPort, generateData);
            try {
                synchronized (this.mStartAdvertisingSync) {
                    this.mStartAdvertisingSync.wait(5000);
                }
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                NsdLog nsdLog2 = NsdLog.LOG;
                nsdLog2.error(TAG, "startAdvertise lock: " + e2);
            }
            if (!this.mStartAdvStatus) {
                try {
                    this.mNsdServiceManager.unRegisterService();
                } catch (Exception unused) {
                    NsdLog.LOG.error(TAG, "MdnsAdvertising force unRegisterService exception");
                }
            }
            this.mRepeat = this.mStartAdvStatus;
        } else {
            NsdLog.LOG.debug(TAG, "MdnsAdvertising has start, so do nothing");
        }
        NsdLog.LOG.debug(TAG, "MdnsAdvertising start success");
        return this.mStartAdvStatus;
    }

    public boolean stopAdvertising() {
        if (this.mRepeat) {
            try {
                this.mNsdServiceManager.unRegisterService();
            } catch (Exception unused) {
                NsdLog.LOG.error(TAG, "MdnsAdvertising has unRegisterService");
            }
            try {
                synchronized (this.mStopAdvertisingSync) {
                    this.mStopAdvertisingSync.wait(5000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                NsdLog nsdLog = NsdLog.LOG;
                nsdLog.error(TAG, "stopAdvertise lock: " + e);
            }
            this.mRepeat = false;
        } else {
            NsdLog.LOG.debug(TAG, "MdnsAdvertising is not start, so do nothing");
        }
        return this.mStopAdvStatus;
    }
}
