package io.netty.resolver.dns;

import io.netty.util.internal.ObjectUtil;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Comparator;

public final class NameServerComparator implements Comparator<InetSocketAddress>, Serializable {
    private static final long serialVersionUID = 8372151874317596185L;
    private final Class<? extends InetAddress> preferredAddressType;

    public NameServerComparator(Class<? extends InetAddress> cls) {
        this.preferredAddressType = (Class) ObjectUtil.checkNotNull(cls, "preferredAddressType");
    }

    public int compare(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
        if (inetSocketAddress.equals(inetSocketAddress2)) {
            return 0;
        }
        if (inetSocketAddress.isUnresolved() || inetSocketAddress2.isUnresolved()) {
            if (inetSocketAddress.isUnresolved() && inetSocketAddress2.isUnresolved()) {
                return 0;
            }
            if (inetSocketAddress.isUnresolved()) {
                return 1;
            }
            return -1;
        } else if (inetSocketAddress.getAddress().getClass() == inetSocketAddress2.getAddress().getClass()) {
            return 0;
        } else {
            if (this.preferredAddressType.isAssignableFrom(inetSocketAddress.getAddress().getClass())) {
                return -1;
            }
            return 1;
        }
    }
}
