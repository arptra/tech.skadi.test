package com.ucar.protocol;

import com.honey.account.f3.d;
import com.ucar.protocol.channel.ChannelType;
import com.ucar.protocol.log.DefaultProtocolLogger;
import com.ucar.protocol.log.ProtocolLogger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ProtocolConfig {

    /* renamed from: a  reason: collision with root package name */
    public static ProtocolLogger f9635a = new DefaultProtocolLogger();
    public static final ConcurrentHashMap b = new ConcurrentHashMap();
    public static final ExecutorService c = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, new ArrayBlockingQueue(5), new ThreadFactory() {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f9636a = new AtomicInteger(0);

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "proto-req-" + this.f9636a.getAndIncrement());
            thread.setDaemon(true);
            return thread;
        }
    }, new ThreadPoolExecutor.DiscardOldestPolicy());

    public static ProtocolLogger b() {
        if (f9635a == null) {
            f9635a = new DefaultProtocolLogger();
        }
        return f9635a;
    }

    public static ExecutorService c(ChannelType channelType) {
        ConcurrentHashMap concurrentHashMap = b;
        if (concurrentHashMap.containsKey(channelType)) {
            return (ExecutorService) concurrentHashMap.get(channelType);
        }
        concurrentHashMap.put(channelType, Executors.newSingleThreadExecutor(new d(channelType)));
        return (ExecutorService) concurrentHashMap.get(channelType);
    }

    public static ExecutorService d() {
        return c;
    }

    public static SourceDevice e() {
        return UCarProtocol.f();
    }

    public static /* synthetic */ Thread f(ChannelType channelType, Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("proto-msg-" + channelType);
        thread.setDaemon(true);
        return thread;
    }

    public static void g(ProtocolLogger protocolLogger) {
        if (protocolLogger != null) {
            f9635a = protocolLogger;
            ProtocolLogger b2 = b();
            b2.i("ProtocolConfig", "Set logger to: " + protocolLogger.getClass().getCanonicalName());
            return;
        }
        b().e("ProtocolConfig", "Set logger error, logger is null.");
    }

    public static void h(SourceDevice sourceDevice) {
        UCarProtocol.i(sourceDevice);
    }
}
