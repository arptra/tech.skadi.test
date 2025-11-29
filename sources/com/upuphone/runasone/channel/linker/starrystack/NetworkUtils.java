package com.upuphone.runasone.channel.linker.starrystack;

import android.os.Build;
import android.util.Log;
import com.honey.account.r5.a;
import com.honey.account.r5.b;
import com.upuphone.runasone.utils.LogUtil;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class NetworkUtils {
    private static final String TAG = "NetworkUtils";
    public static final String UNKNOWN = "UnKnown";

    public static List<NetworkInterface> getAllActiveNetworkInterfaces() {
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<T> it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                Log.d(TAG, "Analyzing network interface: " + networkInterface.getDisplayName());
                if (isUsableNetworkInterface(networkInterface)) {
                    Log.d(TAG, "Discovered usable network interface: " + networkInterface.getDisplayName());
                    synchronized (arrayList) {
                        arrayList.add(networkInterface);
                    }
                } else {
                    Log.d(TAG, "Ignoring non-usable network interface: " + networkInterface.getDisplayName());
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static List<InetAddress> getInetAddresses(NetworkInterface networkInterface) {
        return Collections.list(networkInterface.getInetAddresses());
    }

    public static byte[] getMacAddressByName(String str) {
        try {
            for (T t : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (t.getName().contains(str)) {
                    return t.getHardwareAddress();
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.v(TAG, "error in parsing");
            return null;
        }
    }

    public static String getP2PIpAddress() {
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
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.v(TAG, "error in parsing");
        }
        LogUtil.v(TAG, "returning empty ip address");
        return UNKNOWN;
    }

    private static NetworkInterface getSoftApInterface() {
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<T> it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (isUsableNetworkInterface(networkInterface)) {
                    String str = Build.HARDWARE;
                    Log.d(TAG, "hardware:" + str);
                    if (str.matches("mt\\d*")) {
                        Log.d(TAG, "MTK platform");
                        if (networkInterface.getName().startsWith("ap")) {
                            return networkInterface;
                        }
                    } else {
                        Log.d(TAG, "Qualcomm or other platform");
                        if (networkInterface.getName().startsWith("wlan")) {
                            arrayList.add(networkInterface);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (arrayList.size() <= 1) {
            return null;
        }
        arrayList.sort(new a());
        return (NetworkInterface) arrayList.get(arrayList.size() - 1);
    }

    public static String getSoftApIpAddress() {
        try {
            NetworkInterface softApInterface = getSoftApInterface();
            if (softApInterface == null) {
                return null;
            }
            ArrayList<T> list = Collections.list(softApInterface.getInetAddresses());
            if (!softApInterface.isUp()) {
                return null;
            }
            for (T t : list) {
                if (!t.isLoopbackAddress() && (t instanceof Inet4Address)) {
                    return t.getHostAddress();
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getWlanIpAddress() {
        try {
            NetworkInterface wlansInterface = getWlansInterface();
            if (wlansInterface == null) {
                return null;
            }
            ArrayList<T> list = Collections.list(wlansInterface.getInetAddresses());
            if (!wlansInterface.isUp()) {
                return null;
            }
            for (T t : list) {
                if (!t.isLoopbackAddress() && (t instanceof Inet4Address)) {
                    return t.getHostAddress();
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static NetworkInterface getWlansInterface() {
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<T> it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (isUsableNetworkInterface(networkInterface) && networkInterface.getName().startsWith("wlan")) {
                    arrayList.add(networkInterface);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        arrayList.sort(new b());
        if (arrayList.isEmpty()) {
            return null;
        }
        return (NetworkInterface) arrayList.get(0);
    }

    public static boolean isUsableNetworkInterface(NetworkInterface networkInterface) throws Exception {
        if (!networkInterface.isUp()) {
            Log.d(TAG, "Skipping network interface (down): " + networkInterface.getDisplayName());
            return false;
        } else if (getInetAddresses(networkInterface).size() == 0) {
            Log.d(TAG, "Skipping network interface without bound IP addresses: " + networkInterface.getDisplayName());
            return false;
        } else {
            String name = networkInterface.getName();
            Locale locale = Locale.ROOT;
            if (name.toLowerCase(locale).startsWith("vmnet") || (networkInterface.getDisplayName() != null && networkInterface.getDisplayName().toLowerCase(locale).contains("vmnet"))) {
                Log.d(TAG, "Skipping network interface (VMWare): " + networkInterface.getDisplayName());
                return false;
            } else if (networkInterface.getName().toLowerCase(locale).startsWith("vnic")) {
                Log.d(TAG, "Skipping network interface (Parallels): " + networkInterface.getDisplayName());
                return false;
            } else if (networkInterface.getName().toLowerCase(locale).startsWith("vboxnet")) {
                Log.d(TAG, "Skipping network interface (Virtual Box): " + networkInterface.getDisplayName());
                return false;
            } else if (networkInterface.getName().toLowerCase(locale).contains("virtual")) {
                Log.d(TAG, "Skipping network interface (named '*virtual*'): " + networkInterface.getDisplayName());
                return false;
            } else if (networkInterface.getName().toLowerCase(locale).startsWith("ppp")) {
                Log.d(TAG, "Skipping network interface (PPP): " + networkInterface.getDisplayName());
                return false;
            } else if (networkInterface.isLoopback()) {
                Log.d(TAG, "Skipping network interface (ignoring loopback): " + networkInterface.getDisplayName());
                return false;
            } else if (networkInterface.supportsMulticast()) {
                return true;
            } else {
                Log.d(TAG, "Network interface may not be multicast capable: " + networkInterface.getDisplayName());
                return true;
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$getSoftApInterface$0(NetworkInterface networkInterface, NetworkInterface networkInterface2) {
        return networkInterface.getIndex() < networkInterface2.getIndex() ? -1 : 0;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$getWlansInterface$1(NetworkInterface networkInterface, NetworkInterface networkInterface2) {
        return networkInterface.getIndex() < networkInterface2.getIndex() ? -1 : 0;
    }

    public static void logInterfaceInformation(NetworkInterface networkInterface) throws SocketException {
        Log.d(TAG, "---------------------------------------------------------------------------------");
        Log.d(TAG, String.format("Interface display name: %s", new Object[]{networkInterface.getDisplayName()}));
        if (networkInterface.getParent() != null) {
            Log.d(TAG, String.format("Parent Info: %s", new Object[]{networkInterface.getParent()}));
        }
        Log.d(TAG, String.format("Name: %s", new Object[]{networkInterface.getName()}));
        Iterator<T> it = Collections.list(networkInterface.getInetAddresses()).iterator();
        while (it.hasNext()) {
            Log.d(TAG, String.format("InetAddress: %s", new Object[]{(InetAddress) it.next()}));
        }
        for (InterfaceAddress next : networkInterface.getInterfaceAddresses()) {
            if (next == null) {
                Log.d(TAG, "Skipping null InterfaceAddress!");
            } else {
                Log.d(TAG, " Interface Address");
                Log.d(TAG, "  Address: " + next.getAddress());
                Log.d(TAG, "  Broadcast: " + next.getBroadcast());
                Log.d(TAG, "  Prefix length: " + next.getNetworkPrefixLength());
            }
        }
        Iterator<T> it2 = Collections.list(networkInterface.getSubInterfaces()).iterator();
        while (it2.hasNext()) {
            NetworkInterface networkInterface2 = (NetworkInterface) it2.next();
            if (networkInterface2 == null) {
                Log.d(TAG, "Skipping null NetworkInterface sub-interface");
            } else {
                Log.d(TAG, String.format("\tSub Interface Display name: %s", new Object[]{networkInterface2.getDisplayName()}));
                Log.d(TAG, String.format("\tSub Interface Name: %s", new Object[]{networkInterface2.getName()}));
            }
        }
        Log.d(TAG, String.format("Up? %s", new Object[]{Boolean.valueOf(networkInterface.isUp())}));
        Log.d(TAG, String.format("Loopback? %s", new Object[]{Boolean.valueOf(networkInterface.isLoopback())}));
        Log.d(TAG, String.format("PointToPoint? %s", new Object[]{Boolean.valueOf(networkInterface.isPointToPoint())}));
        Log.d(TAG, String.format("Supports multicast? %s", new Object[]{Boolean.valueOf(networkInterface.supportsMulticast())}));
        Log.d(TAG, String.format("Virtual? %s", new Object[]{Boolean.valueOf(networkInterface.isVirtual())}));
        Log.d(TAG, String.format("Hardware address: %s", new Object[]{Arrays.toString(networkInterface.getHardwareAddress())}));
        Log.d(TAG, String.format("MTU: %s", new Object[]{Integer.valueOf(networkInterface.getMTU())}));
    }

    public static String macByte2String(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (byte valueOf : bArr) {
            sb.append(String.format("%02X:", new Object[]{Byte.valueOf(valueOf)}));
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
