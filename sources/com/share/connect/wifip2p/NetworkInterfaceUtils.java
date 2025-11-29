package com.share.connect.wifip2p;

import com.easy.logger.EasyLog;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

class NetworkInterfaceUtils {
    public static String a(NetworkInterface networkInterface) {
        Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
        while (inetAddresses != null && inetAddresses.hasMoreElements()) {
            InetAddress nextElement = inetAddresses.nextElement();
            if (nextElement.isLoopbackAddress() || !(nextElement instanceof Inet4Address)) {
                EasyLog.i("NetworkInterfaceUtils", "networkInterface=" + networkInterface.getDisplayName() + ",s InetAddress=" + nextElement + " not matches.");
            } else {
                String hostAddress = nextElement.getHostAddress();
                EasyLog.e("NetworkInterfaceUtils", "getHostAddressByInterface: networkInterface=" + networkInterface.getDisplayName() + ", hostAddress=" + hostAddress);
                return hostAddress;
            }
        }
        return null;
    }
}
