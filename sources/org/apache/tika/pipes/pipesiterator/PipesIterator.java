package org.apache.tika.pipes.pipesiterator;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.tika.config.ConfigBase;
import org.apache.tika.config.Initializable;
import org.apache.tika.config.InitializableProblemHandler;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.pipes.FetchEmitTuple;
import org.apache.tika.pipes.HandlerConfig;
import org.apache.tika.pipes.emitter.EmitKey;
import org.apache.tika.pipes.fetcher.FetchKey;
import org.apache.tika.sax.BasicContentHandlerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class PipesIterator extends ConfigBase implements Callable<Integer>, Iterable<FetchEmitTuple>, Initializable {
    public static final FetchEmitTuple m = new FetchEmitTuple((String) null, (FetchKey) null, (EmitKey) null, (Metadata) null, (HandlerConfig) null, (FetchEmitTuple.ON_PARSE_EXCEPTION) null);
    public static final Logger n = LoggerFactory.k(PipesIterator.class);

    /* renamed from: a  reason: collision with root package name */
    public long f3307a;
    public ArrayBlockingQueue b;
    public int c;
    public String d;
    public String e;
    public FetchEmitTuple.ON_PARSE_EXCEPTION f;
    public BasicContentHandlerFactory.HANDLER_TYPE g;
    public HandlerConfig.PARSE_MODE h;
    public int i;
    public int j;
    public int k;
    public FutureTask l;

    public class TupleIterator implements Iterator<FetchEmitTuple> {

        /* renamed from: a  reason: collision with root package name */
        public FetchEmitTuple f3308a;

        public TupleIterator() {
            this.f3308a = null;
        }

        public final void a() {
            if (PipesIterator.this.l.isDone()) {
                try {
                    PipesIterator.this.l.get();
                } catch (ExecutionException e) {
                    throw new RuntimeException(e.getCause());
                }
            }
        }

        /* renamed from: b */
        public FetchEmitTuple next() {
            FetchEmitTuple fetchEmitTuple = this.f3308a;
            if (fetchEmitTuple != PipesIterator.m) {
                this.f3308a = c();
                return fetchEmitTuple;
            }
            throw new IllegalStateException("don't call next() after hasNext() has returned false!");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: org.apache.tika.pipes.FetchEmitTuple} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final org.apache.tika.pipes.FetchEmitTuple c() {
            /*
                r7 = this;
                long r0 = java.lang.System.currentTimeMillis()
                long r2 = java.lang.System.currentTimeMillis()     // Catch:{ InterruptedException -> 0x0055 }
                long r2 = r2 - r0
                r4 = 0
            L_0x000a:
                if (r4 != 0) goto L_0x0030
                org.apache.tika.pipes.pipesiterator.PipesIterator r5 = org.apache.tika.pipes.pipesiterator.PipesIterator.this     // Catch:{ InterruptedException -> 0x0055 }
                long r5 = r5.f3307a     // Catch:{ InterruptedException -> 0x0055 }
                int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r2 >= 0) goto L_0x0030
                r7.a()     // Catch:{ InterruptedException -> 0x0055 }
                org.apache.tika.pipes.pipesiterator.PipesIterator r2 = org.apache.tika.pipes.pipesiterator.PipesIterator.this     // Catch:{ InterruptedException -> 0x0055 }
                java.util.concurrent.ArrayBlockingQueue r2 = r2.b     // Catch:{ InterruptedException -> 0x0055 }
                java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x0055 }
                r4 = 100
                java.lang.Object r2 = r2.poll(r4, r3)     // Catch:{ InterruptedException -> 0x0055 }
                r4 = r2
                org.apache.tika.pipes.FetchEmitTuple r4 = (org.apache.tika.pipes.FetchEmitTuple) r4     // Catch:{ InterruptedException -> 0x0055 }
                long r2 = java.lang.System.currentTimeMillis()     // Catch:{ InterruptedException -> 0x0055 }
                long r2 = r2 - r0
                goto L_0x000a
            L_0x0030:
                if (r4 == 0) goto L_0x0033
                return r4
            L_0x0033:
                org.apache.tika.exception.TikaTimeoutException r0 = new org.apache.tika.exception.TikaTimeoutException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "waited longer than "
                r1.append(r2)
                org.apache.tika.pipes.pipesiterator.PipesIterator r7 = org.apache.tika.pipes.pipesiterator.PipesIterator.this
                long r2 = r7.f3307a
                r1.append(r2)
                java.lang.String r7 = "ms for the next tuple"
                r1.append(r7)
                java.lang.String r7 = r1.toString()
                r0.<init>(r7)
                throw r0
            L_0x0055:
                org.slf4j.Logger r7 = org.apache.tika.pipes.pipesiterator.PipesIterator.n
                java.lang.String r0 = "interrupted"
                r7.warn(r0)
                org.apache.tika.pipes.FetchEmitTuple r7 = org.apache.tika.pipes.pipesiterator.PipesIterator.m
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.pipes.pipesiterator.PipesIterator.TupleIterator.c():org.apache.tika.pipes.FetchEmitTuple");
        }

        public boolean hasNext() {
            if (this.f3308a == null) {
                this.f3308a = c();
            }
            return this.f3308a != PipesIterator.m;
        }
    }

    /* renamed from: U */
    public Integer call() {
        c0();
        q0(m);
        return Integer.valueOf(this.k);
    }

    public abstract void c0();

    public void checkInitialization(InitializableProblemHandler initializableProblemHandler) {
    }

    public String d0() {
        return this.e;
    }

    public String f0() {
        return this.d;
    }

    public HandlerConfig i0() {
        return new HandlerConfig(this.g, this.h, this.i, this.j, false);
    }

    public void initialize(Map map) {
    }

    public Iterator iterator() {
        if (this.l == null) {
            this.l = new FutureTask(this);
            this.b = new ArrayBlockingQueue(this.c);
            new Thread(this.l).start();
            return new TupleIterator();
        }
        throw new IllegalStateException("Can't call iterator more than once!");
    }

    public FetchEmitTuple.ON_PARSE_EXCEPTION p0() {
        return this.f;
    }

    public void q0(FetchEmitTuple fetchEmitTuple) {
        this.k++;
        if (!this.b.offer(fetchEmitTuple, this.f3307a, TimeUnit.MILLISECONDS)) {
            throw new TimeoutException("timed out while offering");
        }
    }
}
