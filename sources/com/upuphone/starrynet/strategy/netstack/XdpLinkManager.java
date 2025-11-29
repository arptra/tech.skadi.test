package com.upuphone.starrynet.strategy.netstack;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import com.upuphone.runasone.channel.linker.starrystack.NetworkUtils;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.Utils;
import com.upuphone.starrynet.strategy.channel.StarryNetChannelManager;
import com.upuphone.starrynet.strategy.channel.p2p.GcChannel;
import java.net.Inet4Address;
import java.net.NetworkInterface;
import java.util.Collections;
import vendor.upuphone.net.starrynetstack.IStarryNetStack;

public final class XdpLinkManager {
    private static final int DURATION_TIME_RETRY = 5000;
    public static final int ERROR_BUSY = -653;
    public static final int ERROR_INVALID_PARAM = -2;
    public static final int ERROR_NO_HAL_SERVICE = -1;
    private static final String HAL_INSTANCE_NAME = (IStarryNetStack.DESCRIPTOR + "/default");
    private static final String IFNAME_P2P = "p2p0";
    public static final int INVALID = -1;
    private static final int MAX_RETRY_COUNT = 5;
    private static final int MSG_RETRY_BIND = 0;
    public static final int REMOTE_ERROR = -2;
    public static final int RESULT_SUCCESS = 1;
    private static final String STATUS_SNET_FUNC = "snet_func";
    private static final String TAG = "CXdpLinkManager";
    private static XdpLinkManager instance;
    /* access modifiers changed from: private */
    public static volatile boolean isLoad = false;
    private IStarryNetStack iStarryNetStack;
    /* access modifiers changed from: private */
    public boolean isInit = false;
    private StarryDeathRecipient mBindDeadListener;
    /* access modifiers changed from: private */
    public int mRetryCount = 0;
    private byte mSnetFuncMode = 0;
    /* access modifiers changed from: private */
    public Handler mXdpHanlder = null;

    public class StarryDeathRecipient implements IBinder.DeathRecipient {
        public StarryDeathRecipient() {
        }

        public void binderDied() {
            StLog.d(XdpLinkManager.TAG, "binder died");
            boolean unused = XdpLinkManager.this.isInit = false;
            boolean unused2 = XdpLinkManager.isLoad = false;
            XdpLinkManager.this.retryInit();
        }
    }

    private XdpLinkManager() {
    }

    public static XdpLinkManager getInstance() {
        if (instance == null) {
            synchronized (XdpLinkManager.class) {
                try {
                    if (instance == null) {
                        instance = new XdpLinkManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    public static String getLocalP2PAddress() {
        try {
            for (T t : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (t.getName().contains("p2p")) {
                    for (T t2 : Collections.list(t.getInetAddresses())) {
                        if (!t2.isLoopbackAddress() && (t2 instanceof Inet4Address)) {
                            String upperCase = t2.getHostAddress().toUpperCase();
                            if (upperCase.contains("192.168.")) {
                                return upperCase;
                            }
                        }
                    }
                    continue;
                }
            }
            return NetworkUtils.UNKNOWN;
        } catch (Exception e) {
            e.printStackTrace();
            StLog.d(TAG, "error in parsing");
            return NetworkUtils.UNKNOWN;
        }
    }

    private byte[] getMacAddressByName(String str) {
        try {
            for (T t : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                StLog.d(TAG, "interface: " + t.toString());
                if (t.getName().contains(str)) {
                    byte[] hardwareAddress = t.getHardwareAddress();
                    StLog.d(TAG, "interface ifname: " + str);
                    return hardwareAddress == null ? new byte[0] : hardwareAddress;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            StLog.d(TAG, "getMacAddressByName ex:" + e.getStackTrace());
        }
        return new byte[0];
    }

    /* access modifiers changed from: private */
    public void retryInit() {
        try {
            this.mRetryCount++;
            StLog.d(TAG, "retryInit ...");
            IStarryNetStack asInterface = IStarryNetStack.Stub.asInterface((IBinder) Class.forName("android.os.ServiceManager").getMethod("waitForDeclaredService", new Class[]{String.class}).invoke((Object) null, new Object[]{HAL_INSTANCE_NAME}));
            this.iStarryNetStack = asInterface;
            asInterface.asBinder().linkToDeath(this.mBindDeadListener, 0);
            this.isInit = true;
            this.mRetryCount = 0;
        } catch (Exception unused) {
            StLog.d(TAG, "retryInit failed ! try again:" + this.mRetryCount);
            this.mXdpHanlder.sendEmptyMessageDelayed(0, 5000);
        }
    }

    public IBinder asBinder() {
        IStarryNetStack iStarryNetStack2 = this.iStarryNetStack;
        if (iStarryNetStack2 != null) {
            return iStarryNetStack2.asBinder();
        }
        return null;
    }

    public int attachHwif(int i, String str, int i2) throws RemoteException {
        IStarryNetStack iStarryNetStack2 = this.iStarryNetStack;
        if (iStarryNetStack2 == null) {
            StLog.d(TAG, "attachHwif : IStarryNetStack is null wait for service connected or service is disconnected");
            return -1;
        } else if (str == null) {
            return -2;
        } else {
            return iStarryNetStack2.attachHwif(i, str, i2);
        }
    }

    public int detachHwif(int i, String str) throws RemoteException {
        IStarryNetStack iStarryNetStack2 = this.iStarryNetStack;
        if (iStarryNetStack2 == null) {
            StLog.d(TAG, "detachHwif : IStarryNetStack is null wait for service connected or service is disconnected");
            return -1;
        } else if (str == null) {
            return -2;
        } else {
            return iStarryNetStack2.detachHwif(i, str);
        }
    }

    public int disableLinkAggregation(int i) throws RemoteException {
        IStarryNetStack iStarryNetStack2 = this.iStarryNetStack;
        if (iStarryNetStack2 != null) {
            return iStarryNetStack2.disableLinkAggregation(i);
        }
        StLog.d(TAG, "disableLinkAggregation : IStarryNetStack is null wait for service connected or service is disconnected");
        return -1;
    }

    public int disableLinkTransition(int i) throws RemoteException {
        IStarryNetStack iStarryNetStack2 = this.iStarryNetStack;
        if (iStarryNetStack2 == null) {
            StLog.d(TAG, "disableLinkTransition : IStarryNetStack is null wait for service connected or service is disconnected");
            return -1;
        }
        try {
            return iStarryNetStack2.disableLinkTransition(i);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int disableLossDetect(int i) throws RemoteException {
        IStarryNetStack iStarryNetStack2 = this.iStarryNetStack;
        if (iStarryNetStack2 == null) {
            StLog.d(TAG, "disableLossDetect : IStarryNetStack is null wait for service connected or service is disconnected");
            return -1;
        }
        try {
            return iStarryNetStack2.disableLossDetect(i);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int enableLinkAggregation(int i) throws RemoteException {
        IStarryNetStack iStarryNetStack2 = this.iStarryNetStack;
        if (iStarryNetStack2 != null) {
            return iStarryNetStack2.enableLinkAggregation(i);
        }
        StLog.d(TAG, "enableLinkAggregation : IStarryNetStack is null wait for service connected or service is disconnected");
        return -1;
    }

    public int enableLinkTransition(int i) {
        IStarryNetStack iStarryNetStack2 = this.iStarryNetStack;
        if (iStarryNetStack2 == null) {
            StLog.d(TAG, "enableLinkTransition : IStarryNetStack is null wait for service connected or service is disconnected");
            return -1;
        }
        try {
            return iStarryNetStack2.enableLinkTransition(i);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int enableLossDetect(int i, int i2, int i3) throws RemoteException {
        IStarryNetStack iStarryNetStack2 = this.iStarryNetStack;
        if (iStarryNetStack2 == null) {
            StLog.d(TAG, "enableLossDetect : IStarryNetStack is null wait for service connected or service is disconnected");
            return -1;
        }
        try {
            return iStarryNetStack2.enableLossDetect(i, i2, i3);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public byte getCapByteFromIfname(String str) {
        return IFNAME_P2P.equals(str) ? (byte) 1 : 0;
    }

    public String getIfaceName(int i) throws RemoteException {
        IStarryNetStack iStarryNetStack2 = this.iStarryNetStack;
        if (iStarryNetStack2 != null) {
            return iStarryNetStack2.getifacename(i);
        }
        StLog.d(TAG, "getIfaceName : IStarryNetStack is null wait for service connected or service is disconnected");
        return null;
    }

    public int getIndexbyname(String str) throws RemoteException {
        IStarryNetStack iStarryNetStack2 = this.iStarryNetStack;
        if (iStarryNetStack2 == null) {
            StLog.d(TAG, "getIndexbyname : IStarryNetStack is null wait for service connected or service is disconnected");
            return -1;
        } else if (str == null) {
            return -2;
        } else {
            return iStarryNetStack2.getindexbyname(str);
        }
    }

    public String getInterfaceHash() throws RemoteException {
        IStarryNetStack iStarryNetStack2 = this.iStarryNetStack;
        if (iStarryNetStack2 != null) {
            return iStarryNetStack2.getInterfaceHash();
        }
        StLog.d(TAG, "getInterfaceHash : IStarryNetStack is null wait for service connected or service is disconnected");
        return null;
    }

    public int getInterfaceVersion() throws RemoteException {
        IStarryNetStack iStarryNetStack2 = this.iStarryNetStack;
        if (iStarryNetStack2 != null) {
            return iStarryNetStack2.getInterfaceVersion();
        }
        StLog.d(TAG, "getInterfaceVersion : IStarryNetStack is null wait for service connected or service is disconnected");
        return -1;
    }

    public int getLoadNums() throws RemoteException {
        IStarryNetStack iStarryNetStack2 = this.iStarryNetStack;
        if (iStarryNetStack2 != null) {
            return iStarryNetStack2.getloadnums();
        }
        StLog.d(TAG, "getLoadNums : IStarryNetStack is null wait for service connected or service is disconnected");
        return -1;
    }

    public int getMtu(String str) throws RemoteException {
        IStarryNetStack iStarryNetStack2 = this.iStarryNetStack;
        if (iStarryNetStack2 == null) {
            StLog.d(TAG, "getMtu : IStarryNetStack is null wait for service connected or service is disconnected");
            return -1;
        } else if (str == null) {
            return -2;
        } else {
            return iStarryNetStack2.getmtu(str);
        }
    }

    public byte getOwnXdpCapacity() {
        return this.mSnetFuncMode;
    }

    public String getP2pMacAddress() {
        GcChannel gcChannel = (GcChannel) StarryNetChannelManager.getInstance().getConnectChannel(11);
        if (gcChannel == null) {
            return null;
        }
        return gcChannel.getP2pMacAddress();
    }

    public String getipaddress(String str) throws RemoteException {
        IStarryNetStack iStarryNetStack2 = this.iStarryNetStack;
        if (iStarryNetStack2 != null && str != null) {
            return iStarryNetStack2.getipaddress(str);
        }
        StLog.d(TAG, "getipaddress : IStarryNetStack is null wait for service connected or service is disconnected");
        return null;
    }

    public void init(Context context) throws Exception {
        if (getOwnXdpCapacity() == 0 || (getOwnXdpCapacity() & 8) != 0) {
            this.iStarryNetStack = null;
        } else {
            this.iStarryNetStack = IStarryNetStack.Stub.asInterface((IBinder) Class.forName("android.os.ServiceManager").getMethod("waitForDeclaredService", new Class[]{String.class}).invoke((Object) null, new Object[]{HAL_INSTANCE_NAME}));
            this.mBindDeadListener = new StarryDeathRecipient();
            this.iStarryNetStack.asBinder().linkToDeath(this.mBindDeadListener, 0);
        }
        this.isInit = true;
        this.mXdpHanlder = new Handler(Looper.myLooper()) {
            public void handleMessage(Message message) {
                XdpLinkManager.this.retryInit();
                if (XdpLinkManager.this.isInit || XdpLinkManager.this.mRetryCount > 5) {
                    XdpLinkManager.this.mXdpHanlder.removeMessages(0);
                }
            }
        };
        this.mSnetFuncMode = (byte) Settings.Global.getInt(context.getContentResolver(), STATUS_SNET_FUNC, 0);
    }

    public boolean isIsLoad() {
        return isLoad;
    }

    public boolean isSupportCapacity(byte b) {
        return (getOwnXdpCapacity() & b) != 0;
    }

    public boolean isSupportStarryNetStack() {
        if (this.mSnetFuncMode == 0) {
            return false;
        }
        if (getOwnXdpCapacity() == 8) {
            StLog.d(TAG, "work in no xdp mode!");
            return true;
        }
        if (this.iStarryNetStack == null) {
            StLog.d(TAG, "not isSupportStarryNet");
        }
        return this.iStarryNetStack != null;
    }

    public int load(String str, String str2, int i) throws RemoteException {
        if (this.iStarryNetStack == null) {
            StLog.d(TAG, "load : IStarryNetStack is null wait for service connected or service is disconnected");
            return -1;
        } else if (str == null || str2 == null) {
            return -2;
        } else {
            if (isLoad) {
                StLog.d(TAG, "is loaded.");
                return 1;
            } else if (NetworkUtils.UNKNOWN.equals(str2)) {
                return ERROR_BUSY;
            } else {
                StLog.d(TAG, "before load mac" + str + ", ipaddr:" + str2);
                String p2pMacAddress = getP2pMacAddress();
                StringBuilder sb = new StringBuilder();
                sb.append("load mac");
                sb.append(p2pMacAddress);
                StLog.d(TAG, sb.toString());
                int load = this.iStarryNetStack.load(str, str2, i, Utils.getBytesFromAddress(p2pMacAddress));
                if (load == 1) {
                    isLoad = true;
                }
                return load;
            }
        }
    }

    public int loadXdp(String str, String str2, int i) {
        int i2 = -1;
        try {
            if (isLoad) {
                return 1;
            }
            int unload = unload(str);
            StLog.d(TAG, "xdp unload ret:" + unload);
            int i3 = 0;
            while (true) {
                i2 = load(str, str2, i);
                if (i2 != -653) {
                    break;
                }
                StLog.d(TAG, "xdp load p2p0 busy just wait");
                if (i3 > 10) {
                    break;
                }
                if (NetworkUtils.UNKNOWN.equals(str2)) {
                    str2 = getLocalP2PAddress();
                }
                Thread.sleep(5);
                i3++;
            }
            StLog.d(TAG, "xdp load ret:" + i2);
            return i2;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String transCapByteToString(byte b) {
        String str = "";
        if ((b & 1) != 0) {
            str = str + "p2pCap ";
        }
        if ((b & 2) != 0) {
            str = str + "usbCap ";
        }
        if ((b & 8) == 0) {
            return str;
        }
        return str + "noXdpCap ";
    }

    public int unload(String str) throws RemoteException {
        if (this.iStarryNetStack == null) {
            StLog.d(TAG, "unload : IStarryNetStack is null wait for service connected or service is disconnected");
            return -1;
        } else if (str == null) {
            return -2;
        } else {
            isLoad = false;
            StLog.d(TAG, "unload :" + str);
            return this.iStarryNetStack.unload(str);
        }
    }

    public int updateIp(String str, String str2, String str3) throws RemoteException {
        IStarryNetStack iStarryNetStack2 = this.iStarryNetStack;
        if (iStarryNetStack2 == null) {
            StLog.d(TAG, "updateIp : IStarryNetStack is null wait for service connected or service is disconnected");
            return -1;
        } else if (str == null || str2 == null || str3 == null) {
            return -2;
        } else {
            return iStarryNetStack2.updateip(str, str2, str3);
        }
    }

    public int updateMtu(String str, int i) throws RemoteException {
        IStarryNetStack iStarryNetStack2 = this.iStarryNetStack;
        if (iStarryNetStack2 == null) {
            StLog.d(TAG, "updateMtu : IStarryNetStack is null wait for service connected or service is disconnected");
            return -1;
        } else if (str == null) {
            return -2;
        } else {
            return iStarryNetStack2.updatemtu(str, i);
        }
    }
}
