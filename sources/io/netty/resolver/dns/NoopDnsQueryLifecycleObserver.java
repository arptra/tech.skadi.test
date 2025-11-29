package io.netty.resolver.dns;

import io.netty.channel.ChannelFuture;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsResponseCode;
import java.net.InetSocketAddress;
import java.util.List;

final class NoopDnsQueryLifecycleObserver implements DnsQueryLifecycleObserver {
    static final NoopDnsQueryLifecycleObserver INSTANCE = new NoopDnsQueryLifecycleObserver();

    private NoopDnsQueryLifecycleObserver() {
    }

    public DnsQueryLifecycleObserver queryCNAMEd(DnsQuestion dnsQuestion) {
        return this;
    }

    public void queryCancelled(int i) {
    }

    public void queryFailed(Throwable th) {
    }

    public DnsQueryLifecycleObserver queryNoAnswer(DnsResponseCode dnsResponseCode) {
        return this;
    }

    public DnsQueryLifecycleObserver queryRedirected(List<InetSocketAddress> list) {
        return this;
    }

    public void querySucceed() {
    }

    public void queryWritten(InetSocketAddress inetSocketAddress, ChannelFuture channelFuture) {
    }
}
