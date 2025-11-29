package io.netty.handler.ipfilter;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

@ChannelHandler.Sharable
public class RuleBasedIpFilter extends AbstractRemoteAddressFilter<InetSocketAddress> {
    private final boolean acceptIfNotFound;
    private final List<IpFilterRule> rules;

    public RuleBasedIpFilter(IpFilterRule... ipFilterRuleArr) {
        this(true, ipFilterRuleArr);
    }

    public RuleBasedIpFilter(boolean z, IpFilterRule... ipFilterRuleArr) {
        ObjectUtil.checkNotNull(ipFilterRuleArr, "rules");
        this.acceptIfNotFound = z;
        this.rules = new ArrayList(ipFilterRuleArr.length);
        for (IpFilterRule ipFilterRule : ipFilterRuleArr) {
            if (ipFilterRule != null) {
                this.rules.add(ipFilterRule);
            }
        }
    }

    public boolean accept(ChannelHandlerContext channelHandlerContext, InetSocketAddress inetSocketAddress) throws Exception {
        for (IpFilterRule next : this.rules) {
            if (next.matches(inetSocketAddress)) {
                return next.ruleType() == IpFilterRuleType.ACCEPT;
            }
        }
        return this.acceptIfNotFound;
    }
}
