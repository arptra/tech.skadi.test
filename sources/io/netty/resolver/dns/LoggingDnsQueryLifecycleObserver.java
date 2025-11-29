package io.netty.resolver.dns;

import io.netty.channel.ChannelFuture;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsResponseCode;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogLevel;
import io.netty.util.internal.logging.InternalLogger;
import java.net.InetSocketAddress;
import java.util.List;

final class LoggingDnsQueryLifecycleObserver implements DnsQueryLifecycleObserver {
    private InetSocketAddress dnsServerAddress;
    private final InternalLogLevel level;
    private final InternalLogger logger;
    private final DnsQuestion question;

    public LoggingDnsQueryLifecycleObserver(DnsQuestion dnsQuestion, InternalLogger internalLogger, InternalLogLevel internalLogLevel) {
        this.question = (DnsQuestion) ObjectUtil.checkNotNull(dnsQuestion, "question");
        this.logger = (InternalLogger) ObjectUtil.checkNotNull(internalLogger, "logger");
        this.level = (InternalLogLevel) ObjectUtil.checkNotNull(internalLogLevel, "level");
    }

    public DnsQueryLifecycleObserver queryCNAMEd(DnsQuestion dnsQuestion) {
        this.logger.log(this.level, "from {} : {} CNAME question {}", this.dnsServerAddress, this.question, dnsQuestion);
        return this;
    }

    public void queryCancelled(int i) {
        InetSocketAddress inetSocketAddress = this.dnsServerAddress;
        if (inetSocketAddress != null) {
            this.logger.log(this.level, "from {} : {} cancelled with {} queries remaining", inetSocketAddress, this.question, Integer.valueOf(i));
        } else {
            this.logger.log(this.level, "{} query never written and cancelled with {} queries remaining", this.question, Integer.valueOf(i));
        }
    }

    public void queryFailed(Throwable th) {
        InetSocketAddress inetSocketAddress = this.dnsServerAddress;
        if (inetSocketAddress != null) {
            this.logger.log(this.level, "from {} : {} failure", inetSocketAddress, this.question, th);
        } else {
            this.logger.log(this.level, "{} query never written and failed", this.question, th);
        }
    }

    public DnsQueryLifecycleObserver queryNoAnswer(DnsResponseCode dnsResponseCode) {
        this.logger.log(this.level, "from {} : {} no answer {}", this.dnsServerAddress, this.question, dnsResponseCode);
        return this;
    }

    public DnsQueryLifecycleObserver queryRedirected(List<InetSocketAddress> list) {
        this.logger.log(this.level, "from {} : {} redirected", this.dnsServerAddress, this.question);
        return this;
    }

    public void querySucceed() {
    }

    public void queryWritten(InetSocketAddress inetSocketAddress, ChannelFuture channelFuture) {
        this.dnsServerAddress = inetSocketAddress;
    }
}
