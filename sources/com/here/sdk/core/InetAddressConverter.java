package com.here.sdk.core;

import java.net.InetAddress;
import java.net.UnknownHostException;

final class InetAddressConverter {
    public static InetAddress convertFromInternal(InetAddressInternal inetAddressInternal) {
        try {
            return InetAddress.getByName(inetAddressInternal.address);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static InetAddressInternal convertToInternal(InetAddress inetAddress) {
        return new InetAddressInternal(inetAddress.getHostAddress());
    }
}
