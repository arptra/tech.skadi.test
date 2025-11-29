package org.apache.tika.pipes.async;

import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.pipes.emitter.EmitData;
import org.apache.tika.pipes.emitter.EmitKey;
import org.apache.tika.pipes.emitter.Emitter;
import org.apache.tika.pipes.emitter.EmitterManager;
import org.apache.tika.pipes.emitter.TikaEmitterException;
import org.apache.tika.utils.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsyncEmitter implements Callable<Integer> {
    public static final EmitData e = new EmitData((EmitKey) null, (List<Metadata>) null);
    public static final Logger f = LoggerFactory.k(AsyncEmitter.class);

    /* renamed from: a  reason: collision with root package name */
    public final AsyncConfig f3299a;
    public final EmitterManager b;
    public final ArrayBlockingQueue c;
    public Instant d;

    public class EmitDataCache {

        /* renamed from: a  reason: collision with root package name */
        public final long f3300a;
        public long b = 0;
        public int c = 0;
        public Map d = new HashMap();

        public EmitDataCache(long j) {
            this.f3300a = j;
        }

        public static /* synthetic */ List e(String str) {
            return new ArrayList();
        }

        public void c(EmitData emitData) {
            this.c++;
            long estimatedSizeBytes = emitData.getEstimatedSizeBytes();
            if (this.b + estimatedSizeBytes > this.f3300a) {
                AsyncEmitter.f.debug("estimated size ({}) > maxBytes({}), going to emitAll", Long.valueOf(this.b + estimatedSizeBytes), Long.valueOf(this.f3300a));
                d();
            }
            g(estimatedSizeBytes);
            ((List) this.d.computeIfAbsent(emitData.getEmitKey().getEmitterName(), new a())).add(emitData);
        }

        public final void d() {
            AsyncEmitter.f.debug("about to emit {} files, {} estimated bytes", Integer.valueOf(this.c), Long.valueOf(this.b));
            int i = 0;
            for (Map.Entry entry : this.d.entrySet()) {
                f(AsyncEmitter.this.b.J((String) entry.getKey()), (List) entry.getValue());
                i += ((List) entry.getValue()).size();
            }
            AsyncEmitter.f.debug("emitted: {} files", (Object) Integer.valueOf(i));
            this.b = 0;
            this.c = 0;
            this.d.clear();
            AsyncEmitter.this.d = Instant.now();
        }

        public final void f(Emitter emitter, List list) {
            try {
                emitter.a(list);
            } catch (IOException | TikaEmitterException e2) {
                AsyncEmitter.f.warn("emitter class ({}): {}", emitter.getClass(), ExceptionUtils.b(e2));
            }
        }

        public void g(long j) {
            this.b += j;
        }
    }

    /* renamed from: c */
    public Integer call() {
        EmitDataCache emitDataCache = new EmitDataCache(this.f3299a.p0());
        while (true) {
            EmitData emitData = (EmitData) this.c.poll(500, TimeUnit.MILLISECONDS);
            if (emitData == e) {
                emitDataCache.d();
                return 2;
            }
            if (emitData != null) {
                emitDataCache.c(emitData);
            } else {
                f.trace("Nothing on the async queue");
            }
            Logger logger = f;
            logger.debug("cache size: ({}) bytes and extract count: {}", Long.valueOf(emitDataCache.b), Integer.valueOf(emitDataCache.c));
            long between = ChronoUnit.MILLIS.between(this.d, Instant.now());
            if (between > this.f3299a.q0()) {
                logger.debug("{} elapsed > {}, going to emitAll", Long.valueOf(between), Long.valueOf(this.f3299a.q0()));
                emitDataCache.d();
            }
        }
    }
}
