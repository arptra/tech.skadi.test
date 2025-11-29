package io.netty.resolver.dns;

import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.logging.LogLevel;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogLevel;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

public final class LoggingDnsQueryLifeCycleObserverFactory implements DnsQueryLifecycleObserverFactory {
    private static final InternalLogger DEFAULT_LOGGER = InternalLoggerFactory.getInstance((Class<?>) LoggingDnsQueryLifeCycleObserverFactory.class);
    private final InternalLogLevel level;
    private final InternalLogger logger;

    public LoggingDnsQueryLifeCycleObserverFactory() {
        this(LogLevel.DEBUG);
    }

    private static InternalLogLevel checkAndConvertLevel(LogLevel logLevel) {
        return ((LogLevel) ObjectUtil.checkNotNull(logLevel, "level")).toInternalLevel();
    }

    public DnsQueryLifecycleObserver newDnsQueryLifecycleObserver(DnsQuestion dnsQuestion) {
        return new LoggingDnsQueryLifecycleObserver(dnsQuestion, this.logger, this.level);
    }

    public LoggingDnsQueryLifeCycleObserverFactory(LogLevel logLevel) {
        this.level = checkAndConvertLevel(logLevel);
        this.logger = DEFAULT_LOGGER;
    }

    public LoggingDnsQueryLifeCycleObserverFactory(Class<?> cls, LogLevel logLevel) {
        this.level = checkAndConvertLevel(logLevel);
        this.logger = InternalLoggerFactory.getInstance((Class<?>) (Class) ObjectUtil.checkNotNull(cls, "classContext"));
    }

    public LoggingDnsQueryLifeCycleObserverFactory(String str, LogLevel logLevel) {
        this.level = checkAndConvertLevel(logLevel);
        this.logger = InternalLoggerFactory.getInstance((String) ObjectUtil.checkNotNull(str, "name"));
    }
}
