package io.netty.handler.ipfilter;

import java.net.InetSocketAddress;
import java.util.Comparator;

final class IpSubnetFilterRuleComparator implements Comparator<Object> {
    static final IpSubnetFilterRuleComparator INSTANCE = new IpSubnetFilterRuleComparator();

    private IpSubnetFilterRuleComparator() {
    }

    public int compare(Object obj, Object obj2) {
        return ((IpSubnetFilterRule) obj).compareTo((InetSocketAddress) obj2);
    }
}
