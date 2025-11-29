package io.netty.util.internal;

import com.geetest.sdk.utils.n;
import com.here.posclient.UpdateOptions;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.Thread;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class ThreadLocalRandom extends Random {
    private static final long addend = 11;
    private static volatile long initialSeedUniquifier = 0;
    /* access modifiers changed from: private */
    public static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ThreadLocalRandom.class);
    private static final long mask = 281474976710655L;
    private static final long multiplier = 25214903917L;
    /* access modifiers changed from: private */
    public static volatile long seedGeneratorEndTime = 0;
    private static final long seedGeneratorStartTime;
    private static final Thread seedGeneratorThread;
    /* access modifiers changed from: private */
    public static final BlockingQueue<Long> seedQueue;
    private static final AtomicLong seedUniquifier = new AtomicLong();
    private static final long serialVersionUID = -5851777807851030925L;
    boolean initialized = true;
    private long pad0;
    private long pad1;
    private long pad2;
    private long pad3;
    private long pad4;
    private long pad5;
    private long pad6;
    private long pad7;
    private long rnd;

    static {
        initialSeedUniquifier = SystemPropertyUtil.getLong("io.netty.initialSeedUniquifier", 0);
        if (initialSeedUniquifier != 0) {
            seedGeneratorThread = null;
            seedQueue = null;
            seedGeneratorStartTime = 0;
        } else if (SystemPropertyUtil.getBoolean("java.util.secureRandomSeed", false)) {
            seedQueue = new LinkedBlockingQueue();
            seedGeneratorStartTime = System.nanoTime();
            AnonymousClass1 r0 = new Thread("initialSeedUniquifierGenerator") {
                public void run() {
                    byte[] generateSeed = new SecureRandom().generateSeed(8);
                    long unused = ThreadLocalRandom.seedGeneratorEndTime = System.nanoTime();
                    ThreadLocalRandom.seedQueue.add(Long.valueOf(((((long) generateSeed[0]) & 255) << 56) | ((((long) generateSeed[1]) & 255) << 48) | ((((long) generateSeed[2]) & 255) << 40) | ((((long) generateSeed[3]) & 255) << 32) | ((((long) generateSeed[4]) & 255) << 24) | ((((long) generateSeed[5]) & 255) << 16) | ((((long) generateSeed[6]) & 255) << 8) | (((long) generateSeed[7]) & 255)));
                }
            };
            seedGeneratorThread = r0;
            r0.setDaemon(true);
            r0.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                public void uncaughtException(Thread thread, Throwable th) {
                    ThreadLocalRandom.logger.debug("An exception has been raised by {}", thread.getName(), th);
                }
            });
            r0.start();
        } else {
            initialSeedUniquifier = mix64(System.currentTimeMillis()) ^ mix64(System.nanoTime());
            seedGeneratorThread = null;
            seedQueue = null;
            seedGeneratorStartTime = 0;
        }
    }

    public ThreadLocalRandom() {
        super(newSeed());
    }

    public static ThreadLocalRandom current() {
        return InternalThreadLocalMap.get().random();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        seedGeneratorThread.interrupt();
        logger.warn("Failed to generate a seed from SecureRandom within {} seconds. Not enough entropy?", (java.lang.Object) 3L);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008e, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long getInitialSeedUniquifier() {
        /*
            long r0 = initialSeedUniquifier
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0009
            return r0
        L_0x0009:
            java.lang.Class<io.netty.util.internal.ThreadLocalRandom> r0 = io.netty.util.internal.ThreadLocalRandom.class
            monitor-enter(r0)
            long r4 = initialSeedUniquifier     // Catch:{ all -> 0x0014 }
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 == 0) goto L_0x0017
            monitor-exit(r0)     // Catch:{ all -> 0x0014 }
            return r4
        L_0x0014:
            r1 = move-exception
            goto L_0x008f
        L_0x0017:
            long r6 = seedGeneratorStartTime     // Catch:{ all -> 0x0014 }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x0014 }
            r8 = 3
            long r10 = r1.toNanos(r8)     // Catch:{ all -> 0x0014 }
            long r6 = r6 + r10
        L_0x0022:
            long r10 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0014 }
            long r10 = r6 - r10
            int r1 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r1 > 0) goto L_0x0035
            java.util.concurrent.BlockingQueue<java.lang.Long> r10 = seedQueue     // Catch:{ InterruptedException -> 0x005a }
            java.lang.Object r10 = r10.poll()     // Catch:{ InterruptedException -> 0x005a }
            java.lang.Long r10 = (java.lang.Long) r10     // Catch:{ InterruptedException -> 0x005a }
            goto L_0x003f
        L_0x0035:
            java.util.concurrent.BlockingQueue<java.lang.Long> r12 = seedQueue     // Catch:{ InterruptedException -> 0x005a }
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ InterruptedException -> 0x005a }
            java.lang.Object r10 = r12.poll(r10, r13)     // Catch:{ InterruptedException -> 0x005a }
            java.lang.Long r10 = (java.lang.Long) r10     // Catch:{ InterruptedException -> 0x005a }
        L_0x003f:
            r11 = 0
            if (r10 == 0) goto L_0x0047
            long r4 = r10.longValue()     // Catch:{ InterruptedException -> 0x005a }
            goto L_0x0062
        L_0x0047:
            if (r1 > 0) goto L_0x0022
            java.lang.Thread r1 = seedGeneratorThread     // Catch:{ all -> 0x0014 }
            r1.interrupt()     // Catch:{ all -> 0x0014 }
            io.netty.util.internal.logging.InternalLogger r1 = logger     // Catch:{ all -> 0x0014 }
            java.lang.String r6 = "Failed to generate a seed from SecureRandom within {} seconds. Not enough entropy?"
            java.lang.Long r7 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0014 }
            r1.warn((java.lang.String) r6, (java.lang.Object) r7)     // Catch:{ all -> 0x0014 }
            goto L_0x0062
        L_0x005a:
            io.netty.util.internal.logging.InternalLogger r1 = logger     // Catch:{ all -> 0x0014 }
            java.lang.String r6 = "Failed to generate a seed from SecureRandom due to an InterruptedException."
            r1.warn((java.lang.String) r6)     // Catch:{ all -> 0x0014 }
            r11 = 1
        L_0x0062:
            r6 = 3627065505421648153(0x3255ecdc33bae119, double:3.253008663204319E-66)
            long r4 = r4 ^ r6
            long r6 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0014 }
            long r6 = java.lang.Long.reverse(r6)     // Catch:{ all -> 0x0014 }
            long r4 = r4 ^ r6
            initialSeedUniquifier = r4     // Catch:{ all -> 0x0014 }
            if (r11 == 0) goto L_0x0081
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0014 }
            r1.interrupt()     // Catch:{ all -> 0x0014 }
            java.lang.Thread r1 = seedGeneratorThread     // Catch:{ all -> 0x0014 }
            r1.interrupt()     // Catch:{ all -> 0x0014 }
        L_0x0081:
            long r6 = seedGeneratorEndTime     // Catch:{ all -> 0x0014 }
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x008d
            long r1 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0014 }
            seedGeneratorEndTime = r1     // Catch:{ all -> 0x0014 }
        L_0x008d:
            monitor-exit(r0)     // Catch:{ all -> 0x0014 }
            return r4
        L_0x008f:
            monitor-exit(r0)     // Catch:{ all -> 0x0014 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.ThreadLocalRandom.getInitialSeedUniquifier():long");
    }

    private static long mix64(long j) {
        long j2 = (j ^ (j >>> 33)) * -49064778989728563L;
        long j3 = (j2 ^ (j2 >>> 33)) * -4265267296055464877L;
        return j3 ^ (j3 >>> 33);
    }

    private static long newSeed() {
        AtomicLong atomicLong;
        long j;
        int i;
        long initialSeedUniquifier2;
        long j2;
        do {
            atomicLong = seedUniquifier;
            j = atomicLong.get();
            i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            initialSeedUniquifier2 = i != 0 ? j : getInitialSeedUniquifier();
            j2 = 181783497276652981L * initialSeedUniquifier2;
        } while (!atomicLong.compareAndSet(j, j2));
        if (i == 0) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                if (seedGeneratorEndTime != 0) {
                    internalLogger.debug(String.format("-Dio.netty.initialSeedUniquifier: 0x%016x (took %d ms)", new Object[]{Long.valueOf(initialSeedUniquifier2), Long.valueOf(TimeUnit.NANOSECONDS.toMillis(seedGeneratorEndTime - seedGeneratorStartTime))}));
                } else {
                    internalLogger.debug(String.format("-Dio.netty.initialSeedUniquifier: 0x%016x", new Object[]{Long.valueOf(initialSeedUniquifier2)}));
                }
            }
        }
        return System.nanoTime() ^ j2;
    }

    public static void setInitialSeedUniquifier(long j) {
        initialSeedUniquifier = j;
    }

    public int next(int i) {
        long j = ((this.rnd * multiplier) + addend) & mask;
        this.rnd = j;
        return (int) (j >>> (48 - i));
    }

    public double nextDouble(double d) {
        ObjectUtil.checkPositive(d, n.f2968a);
        return nextDouble() * d;
    }

    public int nextInt(int i, int i2) {
        if (i < i2) {
            return nextInt(i2 - i) + i;
        }
        throw new IllegalArgumentException();
    }

    public long nextLong(long j) {
        ObjectUtil.checkPositive(j, n.f2968a);
        long j2 = 0;
        while (j >= UpdateOptions.SOURCE_ANY) {
            int next = next(2);
            long j3 = j >>> 1;
            if ((next & 2) != 0) {
                j3 = j - j3;
            }
            if ((next & 1) == 0) {
                j2 += j - j3;
            }
            j = j3;
        }
        return j2 + ((long) nextInt((int) j));
    }

    public void setSeed(long j) {
        if (!this.initialized) {
            this.rnd = (j ^ multiplier) & mask;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public double nextDouble(double d, double d2) {
        if (d < d2) {
            return (nextDouble() * (d2 - d)) + d;
        }
        throw new IllegalArgumentException();
    }

    public long nextLong(long j, long j2) {
        if (j < j2) {
            return nextLong(j2 - j) + j;
        }
        throw new IllegalArgumentException();
    }
}
