package io.netty.resolver.dns;

import io.netty.channel.ChannelFuture;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsResponseCode;
import io.netty.util.internal.ObjectUtil;
import java.net.InetSocketAddress;
import java.util.List;
import org.extra.tools.a;

public final class BiDnsQueryLifecycleObserver implements DnsQueryLifecycleObserver {

    /* renamed from: a  reason: collision with root package name */
    private final DnsQueryLifecycleObserver f3687a;
    private final DnsQueryLifecycleObserver b;

    public BiDnsQueryLifecycleObserver(DnsQueryLifecycleObserver dnsQueryLifecycleObserver, DnsQueryLifecycleObserver dnsQueryLifecycleObserver2) {
        this.f3687a = (DnsQueryLifecycleObserver) ObjectUtil.checkNotNull(dnsQueryLifecycleObserver, a.f3359a);
        this.b = (DnsQueryLifecycleObserver) ObjectUtil.checkNotNull(dnsQueryLifecycleObserver2, "b");
    }

    public DnsQueryLifecycleObserver queryCNAMEd(DnsQuestion dnsQuestion) {
        try {
            this.f3687a.queryCNAMEd(dnsQuestion);
            return this;
        } finally {
            this.b.queryCNAMEd(dnsQuestion);
        }
    }

    public void queryCancelled(int i) {
        try {
            this.f3687a.queryCancelled(i);
        } finally {
            this.b.queryCancelled(i);
        }
    }

    public void queryFailed(Throwable th) {
        try {
            this.f3687a.queryFailed(th);
        } finally {
            this.b.queryFailed(th);
        }
    }

    public DnsQueryLifecycleObserver queryNoAnswer(DnsResponseCode dnsResponseCode) {
        try {
            this.f3687a.queryNoAnswer(dnsResponseCode);
            return this;
        } finally {
            this.b.queryNoAnswer(dnsResponseCode);
        }
    }

    public DnsQueryLifecycleObserver queryRedirected(List<InetSocketAddress> list) {
        try {
            this.f3687a.queryRedirected(list);
            return this;
        } finally {
            this.b.queryRedirected(list);
        }
    }

    public void querySucceed() {
        try {
            this.f3687a.querySucceed();
        } finally {
            this.b.querySucceed();
        }
    }

    public void queryWritten(InetSocketAddress inetSocketAddress, ChannelFuture channelFuture) {
        try {
            this.f3687a.queryWritten(inetSocketAddress, channelFuture);
        } finally {
            this.b.queryWritten(inetSocketAddress, channelFuture);
        }
    }
}
