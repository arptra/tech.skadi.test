package io.netty.resolver.dns;

import io.netty.channel.AddressedEnvelope;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.dns.AbstractDnsOptPseudoRrRecord;
import io.netty.handler.codec.dns.DnsQuery;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsRecordType;
import io.netty.handler.codec.dns.DnsResponse;
import io.netty.handler.codec.dns.DnsSection;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

abstract class DnsQueryContext implements FutureListener<AddressedEnvelope<DnsResponse, InetSocketAddress>> {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DnsQueryContext.class);
    private final DnsRecord[] additionals;
    private final int id;
    private final InetSocketAddress nameServerAddr;
    private final DnsRecord optResource;
    private final DnsNameResolver parent;
    /* access modifiers changed from: private */
    public final Promise<AddressedEnvelope<DnsResponse, InetSocketAddress>> promise;
    private final DnsQuestion question;
    private final boolean recursionDesired;
    private volatile Future<?> timeoutFuture;

    public DnsQueryContext(DnsNameResolver dnsNameResolver, InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, DnsRecord[] dnsRecordArr, Promise<AddressedEnvelope<DnsResponse, InetSocketAddress>> promise2) {
        this.parent = (DnsNameResolver) ObjectUtil.checkNotNull(dnsNameResolver, "parent");
        this.nameServerAddr = (InetSocketAddress) ObjectUtil.checkNotNull(inetSocketAddress, "nameServerAddr");
        this.question = (DnsQuestion) ObjectUtil.checkNotNull(dnsQuestion, "question");
        this.additionals = (DnsRecord[]) ObjectUtil.checkNotNull(dnsRecordArr, "additionals");
        this.promise = (Promise) ObjectUtil.checkNotNull(promise2, "promise");
        this.recursionDesired = dnsNameResolver.isRecursionDesired();
        this.id = dnsNameResolver.queryContextManager.add(this);
        promise2.addListener(this);
        if (!dnsNameResolver.isOptResourceEnabled() || hasOptRecord(dnsRecordArr)) {
            this.optResource = null;
        } else {
            this.optResource = new AbstractDnsOptPseudoRrRecord(dnsNameResolver.maxPayloadSize(), 0, 0) {
            };
        }
    }

    /* access modifiers changed from: private */
    public void failQuery(DnsQuery dnsQuery, Throwable th, ChannelPromise channelPromise) {
        try {
            this.promise.tryFailure(th);
            channelPromise.setFailure(th);
        } finally {
            ReferenceCountUtil.release(dnsQuery);
        }
    }

    private static boolean hasOptRecord(DnsRecord[] dnsRecordArr) {
        if (dnsRecordArr != null && dnsRecordArr.length > 0) {
            for (DnsRecord type : dnsRecordArr) {
                if (type.type() == DnsRecordType.OPT) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void onQueryWriteCompletion(ChannelFuture channelFuture) {
        if (!channelFuture.isSuccess()) {
            tryFailure("failed to send a query via " + protocol(), channelFuture.cause(), false);
            return;
        }
        final long queryTimeoutMillis = this.parent.queryTimeoutMillis();
        if (queryTimeoutMillis > 0) {
            this.timeoutFuture = this.parent.ch.eventLoop().schedule((Runnable) new Runnable() {
                public void run() {
                    if (!DnsQueryContext.this.promise.isDone()) {
                        DnsQueryContext dnsQueryContext = DnsQueryContext.this;
                        dnsQueryContext.tryFailure("query via " + DnsQueryContext.this.protocol() + " timed out after " + queryTimeoutMillis + " milliseconds", (Throwable) null, true);
                    }
                }
            }, queryTimeoutMillis, TimeUnit.MILLISECONDS);
        }
    }

    private void sendQuery(final DnsQuery dnsQuery, boolean z, final ChannelPromise channelPromise) {
        if (this.parent.channelReadyPromise.isSuccess()) {
            writeQuery(dnsQuery, z, channelPromise);
            return;
        }
        Throwable cause = this.parent.channelReadyPromise.cause();
        if (cause != null) {
            failQuery(dnsQuery, cause, channelPromise);
        } else {
            this.parent.channelReadyPromise.addListener(new GenericFutureListener<Future<? super Channel>>() {
                public void operationComplete(Future<? super Channel> future) {
                    if (future.isSuccess()) {
                        DnsQueryContext.this.writeQuery(dnsQuery, true, channelPromise);
                        return;
                    }
                    DnsQueryContext.this.failQuery(dnsQuery, future.cause(), channelPromise);
                }
            });
        }
    }

    private boolean trySuccess(AddressedEnvelope<? extends DnsResponse, InetSocketAddress> addressedEnvelope) {
        return this.promise.trySuccess(addressedEnvelope);
    }

    /* access modifiers changed from: private */
    public void writeQuery(DnsQuery dnsQuery, boolean z, ChannelPromise channelPromise) {
        final ChannelFuture writeAndFlush = z ? channel().writeAndFlush(dnsQuery, channelPromise) : channel().write(dnsQuery, channelPromise);
        if (writeAndFlush.isDone()) {
            onQueryWriteCompletion(writeAndFlush);
        } else {
            writeAndFlush.addListener(new ChannelFutureListener() {
                public void operationComplete(ChannelFuture channelFuture) {
                    DnsQueryContext.this.onQueryWriteCompletion(writeAndFlush);
                }
            });
        }
    }

    public abstract Channel channel();

    public void finish(AddressedEnvelope<? extends DnsResponse, InetSocketAddress> addressedEnvelope) {
        DnsResponse dnsResponse = (DnsResponse) addressedEnvelope.content();
        DnsSection dnsSection = DnsSection.QUESTION;
        if (dnsResponse.count(dnsSection) != 1) {
            logger.warn("Received a DNS response with invalid number of questions: {}", (Object) addressedEnvelope);
        } else if (!question().equals(dnsResponse.recordAt(dnsSection))) {
            logger.warn("Received a mismatching DNS response: {}", (Object) addressedEnvelope);
        } else if (trySuccess(addressedEnvelope)) {
            return;
        }
        addressedEnvelope.release();
    }

    public InetSocketAddress nameServerAddr() {
        return this.nameServerAddr;
    }

    public abstract DnsQuery newQuery(int i);

    public void operationComplete(Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> future) {
        Future<?> future2 = this.timeoutFuture;
        if (future2 != null) {
            this.timeoutFuture = null;
            future2.cancel(false);
        }
        this.parent.queryContextManager.remove(this.nameServerAddr, this.id);
    }

    public DnsNameResolver parent() {
        return this.parent;
    }

    public abstract String protocol();

    public void query(boolean z, ChannelPromise channelPromise) {
        DnsQuestion question2 = question();
        InetSocketAddress nameServerAddr2 = nameServerAddr();
        DnsQuery newQuery = newQuery(this.id);
        newQuery.setRecursionDesired(this.recursionDesired);
        newQuery.addRecord(DnsSection.QUESTION, question2);
        for (DnsRecord addRecord : this.additionals) {
            newQuery.addRecord(DnsSection.ADDITIONAL, addRecord);
        }
        DnsRecord dnsRecord = this.optResource;
        if (dnsRecord != null) {
            newQuery.addRecord(DnsSection.ADDITIONAL, dnsRecord);
        }
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("{} WRITE: {}, [{}: {}], {}", channel(), protocol(), Integer.valueOf(this.id), nameServerAddr2, question2);
        }
        sendQuery(newQuery, z, channelPromise);
    }

    public DnsQuestion question() {
        return this.question;
    }

    public boolean tryFailure(String str, Throwable th, boolean z) {
        if (this.promise.isDone()) {
            return false;
        }
        InetSocketAddress nameServerAddr2 = nameServerAddr();
        StringBuilder sb = new StringBuilder(str.length() + 64);
        sb.append('[');
        sb.append(nameServerAddr2);
        sb.append("] ");
        sb.append(str);
        sb.append(" (no stack trace available)");
        return this.promise.tryFailure(z ? new DnsNameResolverTimeoutException(nameServerAddr2, question(), sb.toString()) : new DnsNameResolverException(nameServerAddr2, question(), sb.toString(), th));
    }
}
