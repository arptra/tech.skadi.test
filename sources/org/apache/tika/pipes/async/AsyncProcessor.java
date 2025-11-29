package org.apache.tika.pipes.async;

import com.here.odnp.config.OdnpConfigStatic;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.tika.pipes.FetchEmitTuple;
import org.apache.tika.pipes.PipesClient;
import org.apache.tika.pipes.PipesResult;
import org.apache.tika.pipes.pipesiterator.PipesIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsyncProcessor implements Closeable {
    public static final Logger d = LoggerFactory.k(AsyncProcessor.class);
    public static long e = OdnpConfigStatic.OEM_MAX_HIGH_POWER_INTERVAL;

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f3301a;
    public final AsyncConfig b;
    public final AtomicLong c;

    public class FetchEmitWorker implements Callable<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final AsyncConfig f3302a;
        public final ArrayBlockingQueue b;
        public final ArrayBlockingQueue c;
        public final /* synthetic */ AsyncProcessor d;

        /* renamed from: a */
        public Integer call() {
            PipesResult pipesResult;
            PipesClient pipesClient = new PipesClient(this.f3302a);
            while (true) {
                try {
                    FetchEmitTuple fetchEmitTuple = (FetchEmitTuple) this.b.poll(1, TimeUnit.SECONDS);
                    if (fetchEmitTuple == null) {
                        if (AsyncProcessor.d.isTraceEnabled()) {
                            AsyncProcessor.d.trace("null fetch emit tuple");
                        }
                    } else if (fetchEmitTuple == PipesIterator.m) {
                        if (AsyncProcessor.d.isTraceEnabled()) {
                            AsyncProcessor.d.trace("hit completed semaphore");
                        }
                        pipesClient.close();
                        return 1;
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            pipesResult = pipesClient.u(fetchEmitTuple);
                        } catch (IOException e) {
                            AsyncProcessor.d.warn("pipesClient crash", (Throwable) e);
                            pipesResult = PipesResult.g;
                        }
                        if (AsyncProcessor.d.isTraceEnabled()) {
                            AsyncProcessor.d.trace("timer -- pipes client process: {} ms", (Object) Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        }
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if ((pipesResult.b() == PipesResult.STATUS.PARSE_SUCCESS || pipesResult.b() == PipesResult.STATUS.PARSE_SUCCESS_WITH_EXCEPTION) && !this.c.offer(pipesResult.a(), AsyncProcessor.e, TimeUnit.MILLISECONDS)) {
                            throw new RuntimeException("Couldn't offer emit data to queue within " + AsyncProcessor.e + " ms");
                        }
                        if (AsyncProcessor.d.isTraceEnabled()) {
                            AsyncProcessor.d.trace("timer -- offered: {} ms", (Object) Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                        }
                        this.f3302a.r0().a(fetchEmitTuple, pipesResult, System.currentTimeMillis() - currentTimeMillis);
                        this.d.c.incrementAndGet();
                    }
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            }
            throw th;
        }
    }

    public void close() {
        this.f3301a.shutdownNow();
        this.b.r0().close();
    }
}
