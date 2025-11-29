package io.netty.handler.ipfilter;

import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SocketUtils;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public final class IpSubnetFilterRule implements IpFilterRule, Comparable<IpSubnetFilterRule> {
    private final IpFilterRule filterRule;
    private final String ipAddress;

    public static final class Ip4SubnetFilterRule implements IpFilterRule {
        /* access modifiers changed from: private */
        public final int networkAddress;
        private final IpFilterRuleType ruleType;
        /* access modifiers changed from: private */
        public final int subnetMask;

        private static int prefixToSubnetMask(int i) {
            return (int) (-1 << (32 - i));
        }

        public boolean matches(InetSocketAddress inetSocketAddress) {
            InetAddress address = inetSocketAddress.getAddress();
            return (address instanceof Inet4Address) && (NetUtil.ipv4AddressToInt((Inet4Address) address) & this.subnetMask) == this.networkAddress;
        }

        public IpFilterRuleType ruleType() {
            return this.ruleType;
        }

        private Ip4SubnetFilterRule(Inet4Address inet4Address, int i, IpFilterRuleType ipFilterRuleType) {
            if (i < 0 || i > 32) {
                throw new IllegalArgumentException(String.format("IPv4 requires the subnet prefix to be in range of [0,32]. The prefix was: %d", new Object[]{Integer.valueOf(i)}));
            }
            int prefixToSubnetMask = prefixToSubnetMask(i);
            this.subnetMask = prefixToSubnetMask;
            this.networkAddress = NetUtil.ipv4AddressToInt(inet4Address) & prefixToSubnetMask;
            this.ruleType = ipFilterRuleType;
        }
    }

    public static final class Ip6SubnetFilterRule implements IpFilterRule {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final BigInteger MINUS_ONE = BigInteger.valueOf(-1);
        /* access modifiers changed from: private */
        public final BigInteger networkAddress;
        private final IpFilterRuleType ruleType;
        private final BigInteger subnetMask;

        /* access modifiers changed from: private */
        public static BigInteger ipToInt(Inet6Address inet6Address) {
            return new BigInteger(inet6Address.getAddress());
        }

        private static BigInteger prefixToSubnetMask(int i) {
            return MINUS_ONE.shiftLeft(128 - i);
        }

        public boolean matches(InetSocketAddress inetSocketAddress) {
            InetAddress address = inetSocketAddress.getAddress();
            if (!(address instanceof Inet6Address)) {
                return false;
            }
            BigInteger ipToInt = ipToInt((Inet6Address) address);
            return ipToInt.and(this.subnetMask).equals(this.subnetMask) || ipToInt.and(this.subnetMask).equals(this.networkAddress);
        }

        public IpFilterRuleType ruleType() {
            return this.ruleType;
        }

        private Ip6SubnetFilterRule(Inet6Address inet6Address, int i, IpFilterRuleType ipFilterRuleType) {
            if (i < 0 || i > 128) {
                throw new IllegalArgumentException(String.format("IPv6 requires the subnet prefix to be in range of [0,128]. The prefix was: %d", new Object[]{Integer.valueOf(i)}));
            }
            BigInteger prefixToSubnetMask = prefixToSubnetMask(i);
            this.subnetMask = prefixToSubnetMask;
            this.networkAddress = ipToInt(inet6Address).and(prefixToSubnetMask);
            this.ruleType = ipFilterRuleType;
        }
    }

    public IpSubnetFilterRule(String str, int i, IpFilterRuleType ipFilterRuleType) {
        try {
            this.ipAddress = str;
            this.filterRule = selectFilterRule(SocketUtils.addressByName(str), i, ipFilterRuleType);
        } catch (UnknownHostException e) {
            throw new IllegalArgumentException("ipAddress", e);
        }
    }

    private static int compareInt(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    private static IpFilterRule selectFilterRule(InetAddress inetAddress, int i, IpFilterRuleType ipFilterRuleType) {
        ObjectUtil.checkNotNull(inetAddress, "ipAddress");
        ObjectUtil.checkNotNull(ipFilterRuleType, "ruleType");
        if (inetAddress instanceof Inet4Address) {
            return new Ip4SubnetFilterRule((Inet4Address) inetAddress, i, ipFilterRuleType);
        }
        if (inetAddress instanceof Inet6Address) {
            return new Ip6SubnetFilterRule((Inet6Address) inetAddress, i, ipFilterRuleType);
        }
        throw new IllegalArgumentException("Only IPv4 and IPv6 addresses are supported");
    }

    public IpFilterRule getFilterRule() {
        return this.filterRule;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public boolean matches(InetSocketAddress inetSocketAddress) {
        return this.filterRule.matches(inetSocketAddress);
    }

    public IpFilterRuleType ruleType() {
        return this.filterRule.ruleType();
    }

    public int compareTo(IpSubnetFilterRule ipSubnetFilterRule) {
        IpFilterRule ipFilterRule = this.filterRule;
        if (ipFilterRule instanceof Ip4SubnetFilterRule) {
            return compareInt(((Ip4SubnetFilterRule) ipFilterRule).networkAddress, ((Ip4SubnetFilterRule) ipSubnetFilterRule.filterRule).networkAddress);
        }
        return ((Ip6SubnetFilterRule) ipFilterRule).networkAddress.compareTo(((Ip6SubnetFilterRule) ipSubnetFilterRule.filterRule).networkAddress);
    }

    public IpSubnetFilterRule(InetAddress inetAddress, int i, IpFilterRuleType ipFilterRuleType) {
        this.ipAddress = inetAddress.getHostAddress();
        this.filterRule = selectFilterRule(inetAddress, i, ipFilterRuleType);
    }

    public int compareTo(InetSocketAddress inetSocketAddress) {
        IpFilterRule ipFilterRule = this.filterRule;
        if (ipFilterRule instanceof Ip4SubnetFilterRule) {
            Ip4SubnetFilterRule ip4SubnetFilterRule = (Ip4SubnetFilterRule) ipFilterRule;
            return compareInt(ip4SubnetFilterRule.networkAddress, ip4SubnetFilterRule.subnetMask & NetUtil.ipv4AddressToInt((Inet4Address) inetSocketAddress.getAddress()));
        }
        Ip6SubnetFilterRule ip6SubnetFilterRule = (Ip6SubnetFilterRule) ipFilterRule;
        return ip6SubnetFilterRule.networkAddress.compareTo(Ip6SubnetFilterRule.ipToInt((Inet6Address) inetSocketAddress.getAddress()).and(ip6SubnetFilterRule.networkAddress));
    }
}
