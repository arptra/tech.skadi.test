package io.netty.resolver.dns;

import com.meizu.common.widget.MzContactsContract;
import io.netty.util.internal.ObjectUtil;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class DnsServerAddresses {
    @Deprecated
    public static List<InetSocketAddress> defaultAddressList() {
        return DefaultDnsServerAddressStreamProvider.defaultAddressList();
    }

    @Deprecated
    public static DnsServerAddresses defaultAddresses() {
        return DefaultDnsServerAddressStreamProvider.defaultAddresses();
    }

    public static DnsServerAddresses rotational(Iterable<? extends InetSocketAddress> iterable) {
        return rotational0(sanitize(iterable));
    }

    private static DnsServerAddresses rotational0(List<InetSocketAddress> list) {
        return list.size() == 1 ? singleton(list.get(0)) : new RotationalDnsServerAddresses(list);
    }

    private static List<InetSocketAddress> sanitize(Iterable<? extends InetSocketAddress> iterable) {
        ArrayList arrayList;
        InetSocketAddress inetSocketAddress;
        ObjectUtil.checkNotNull(iterable, "addresses");
        if (iterable instanceof Collection) {
            arrayList = new ArrayList(((Collection) iterable).size());
        } else {
            arrayList = new ArrayList(4);
        }
        Iterator<? extends InetSocketAddress> it = iterable.iterator();
        while (it.hasNext() && (inetSocketAddress = (InetSocketAddress) it.next()) != null) {
            if (!inetSocketAddress.isUnresolved()) {
                arrayList.add(inetSocketAddress);
            } else {
                throw new IllegalArgumentException("cannot use an unresolved DNS server address: " + inetSocketAddress);
            }
        }
        return (List) ObjectUtil.checkNonEmpty(arrayList, "list");
    }

    public static DnsServerAddresses sequential(Iterable<? extends InetSocketAddress> iterable) {
        return sequential0(sanitize(iterable));
    }

    private static DnsServerAddresses sequential0(List<InetSocketAddress> list) {
        return list.size() == 1 ? singleton(list.get(0)) : new DefaultDnsServerAddresses("sequential", list) {
            public DnsServerAddressStream stream() {
                return new SequentialDnsServerAddressStream(this.addresses, 0);
            }
        };
    }

    public static DnsServerAddresses shuffled(Iterable<? extends InetSocketAddress> iterable) {
        return shuffled0(sanitize(iterable));
    }

    private static DnsServerAddresses shuffled0(List<InetSocketAddress> list) {
        return list.size() == 1 ? singleton(list.get(0)) : new DefaultDnsServerAddresses("shuffled", list) {
            public DnsServerAddressStream stream() {
                return new ShuffledDnsServerAddressStream(this.addresses);
            }
        };
    }

    public static DnsServerAddresses singleton(InetSocketAddress inetSocketAddress) {
        ObjectUtil.checkNotNull(inetSocketAddress, MzContactsContract.MzContactColumns.ADDRESS);
        if (!inetSocketAddress.isUnresolved()) {
            return new SingletonDnsServerAddresses(inetSocketAddress);
        }
        throw new IllegalArgumentException("cannot use an unresolved DNS server address: " + inetSocketAddress);
    }

    public abstract DnsServerAddressStream stream();

    public static DnsServerAddresses rotational(InetSocketAddress... inetSocketAddressArr) {
        return rotational0(sanitize(inetSocketAddressArr));
    }

    public static DnsServerAddresses sequential(InetSocketAddress... inetSocketAddressArr) {
        return sequential0(sanitize(inetSocketAddressArr));
    }

    public static DnsServerAddresses shuffled(InetSocketAddress... inetSocketAddressArr) {
        return shuffled0(sanitize(inetSocketAddressArr));
    }

    private static List<InetSocketAddress> sanitize(InetSocketAddress[] inetSocketAddressArr) {
        ObjectUtil.checkNotNull(inetSocketAddressArr, "addresses");
        ArrayList arrayList = new ArrayList(inetSocketAddressArr.length);
        int length = inetSocketAddressArr.length;
        int i = 0;
        while (i < length) {
            InetSocketAddress inetSocketAddress = inetSocketAddressArr[i];
            if (inetSocketAddress == null) {
                break;
            } else if (!inetSocketAddress.isUnresolved()) {
                arrayList.add(inetSocketAddress);
                i++;
            } else {
                throw new IllegalArgumentException("cannot use an unresolved DNS server address: " + inetSocketAddress);
            }
        }
        return arrayList.isEmpty() ? DefaultDnsServerAddressStreamProvider.defaultAddressList() : arrayList;
    }
}
