package org.apache.tika.pipes;

import org.apache.tika.extractor.DocumentSelector;
import org.apache.tika.metadata.Metadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PipesServer implements Runnable {
    public static final Logger g = LoggerFactory.k(PipesServer.class);

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f3297a;
    public long b;
    public final long c;
    public final long d;
    public volatile boolean e;
    public volatile long f;

    /* renamed from: org.apache.tika.pipes.PipesServer$1  reason: invalid class name */
    class AnonymousClass1 implements DocumentSelector {

        /* renamed from: a  reason: collision with root package name */
        public final int f3298a;
        public int b;

        public boolean a(Metadata metadata) {
            int i = this.f3298a;
            if (i < 0) {
                return true;
            }
            int i2 = this.b;
            this.b = i2 + 1;
            return i2 < i;
        }
    }

    public enum STATUS {
        READY,
        CALL,
        PING,
        FAILED_TO_START,
        FETCHER_NOT_FOUND,
        EMITTER_NOT_FOUND,
        FETCHER_INITIALIZATION_EXCEPTION,
        FETCH_EXCEPTION,
        PARSE_SUCCESS,
        PARSE_EXCEPTION_NO_EMIT,
        EMIT_SUCCESS,
        EMIT_SUCCESS_PARSE_EXCEPTION,
        EMIT_EXCEPTION,
        OOM,
        TIMEOUT,
        EMPTY_OUTPUT;

        public static STATUS lookup(int i) {
            int i2 = i - 1;
            if (i2 >= 0) {
                STATUS[] values = values();
                if (i2 < values.length) {
                    return values[i2];
                }
                throw new IllegalArgumentException("byte with index " + i2 + " must be < " + values.length);
            }
            throw new IllegalArgumentException("byte must be > 0");
        }

        public byte getByte() {
            return (byte) (ordinal() + 1);
        }
    }

    public final void a(int i) {
        if (i != 0) {
            g.error("exiting: {}", (Object) Integer.valueOf(i));
        } else {
            g.info("exiting: {}", (Object) Integer.valueOf(i));
        }
        System.exit(i);
    }

    public void run() {
        while (true) {
            try {
                synchronized (this.f3297a) {
                    long currentTimeMillis = System.currentTimeMillis() - this.f;
                    if (this.e && currentTimeMillis > this.c) {
                        g.warn("timeout server; elapsed {}  with {}", Long.valueOf(currentTimeMillis), Long.valueOf(this.c));
                        a(17);
                    } else if (!this.e) {
                        long j = this.d;
                        if (j > 0 && currentTimeMillis > j) {
                            g.info("closing down from inactivity");
                            a(0);
                        }
                    }
                }
                Thread.sleep(this.b);
            } catch (InterruptedException unused) {
                g.debug("interrupted");
                return;
            } catch (Throwable th) {
                while (true) {
                }
                throw th;
            }
        }
    }
}
