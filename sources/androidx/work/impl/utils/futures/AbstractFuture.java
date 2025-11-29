package androidx.work.impl.utils.futures;

import androidx.annotation.RestrictTo;
import com.google.common.util.concurrent.ListenableFuture;
import com.honey.account.i.a;
import com.meizu.common.widget.MzContactsContract;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.BooleanUtils;

@RestrictTo
public abstract class AbstractFuture<V> implements ListenableFuture<V> {
    public static final boolean d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", BooleanUtils.FALSE));
    public static final Logger e;
    public static final AtomicHelper f;
    public static final Object g = new Object();

    /* renamed from: a  reason: collision with root package name */
    public volatile Object f2253a;
    public volatile Listener b;
    public volatile Waiter c;

    public static abstract class AtomicHelper {
        public AtomicHelper() {
        }

        public abstract boolean a(AbstractFuture abstractFuture, Listener listener, Listener listener2);

        public abstract boolean b(AbstractFuture abstractFuture, Object obj, Object obj2);

        public abstract boolean c(AbstractFuture abstractFuture, Waiter waiter, Waiter waiter2);

        public abstract void d(Waiter waiter, Waiter waiter2);

        public abstract void e(Waiter waiter, Thread thread);
    }

    public static final class Cancellation {
        public static final Cancellation c;
        public static final Cancellation d;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f2254a;
        public final Throwable b;

        static {
            if (AbstractFuture.d) {
                d = null;
                c = null;
                return;
            }
            d = new Cancellation(false, (Throwable) null);
            c = new Cancellation(true, (Throwable) null);
        }

        public Cancellation(boolean z, Throwable th) {
            this.f2254a = z;
            this.b = th;
        }
    }

    public static final class Failure {
        public static final Failure b = new Failure(new Throwable("Failure occurred while trying to finish a future.") {
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f2255a;

        public Failure(Throwable th) {
            this.f2255a = (Throwable) AbstractFuture.d(th);
        }
    }

    public static final class Listener {
        public static final Listener d = new Listener((Runnable) null, (Executor) null);

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f2256a;
        public final Executor b;
        public Listener c;

        public Listener(Runnable runnable, Executor executor) {
            this.f2256a = runnable;
            this.b = executor;
        }
    }

    public static final class SafeAtomicHelper extends AtomicHelper {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f2257a;
        public final AtomicReferenceFieldUpdater b;
        public final AtomicReferenceFieldUpdater c;
        public final AtomicReferenceFieldUpdater d;
        public final AtomicReferenceFieldUpdater e;

        public SafeAtomicHelper(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super();
            this.f2257a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.c = atomicReferenceFieldUpdater3;
            this.d = atomicReferenceFieldUpdater4;
            this.e = atomicReferenceFieldUpdater5;
        }

        public boolean a(AbstractFuture abstractFuture, Listener listener, Listener listener2) {
            return a.a(this.d, abstractFuture, listener, listener2);
        }

        public boolean b(AbstractFuture abstractFuture, Object obj, Object obj2) {
            return a.a(this.e, abstractFuture, obj, obj2);
        }

        public boolean c(AbstractFuture abstractFuture, Waiter waiter, Waiter waiter2) {
            return a.a(this.c, abstractFuture, waiter, waiter2);
        }

        public void d(Waiter waiter, Waiter waiter2) {
            this.b.lazySet(waiter, waiter2);
        }

        public void e(Waiter waiter, Thread thread) {
            this.f2257a.lazySet(waiter, thread);
        }
    }

    public static final class SetFuture<V> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final AbstractFuture f2258a;
        public final ListenableFuture b;

        public SetFuture(AbstractFuture abstractFuture, ListenableFuture listenableFuture) {
            this.f2258a = abstractFuture;
            this.b = listenableFuture;
        }

        public void run() {
            if (this.f2258a.f2253a == this) {
                if (AbstractFuture.f.b(this.f2258a, this, AbstractFuture.i(this.b))) {
                    AbstractFuture.f(this.f2258a);
                }
            }
        }
    }

    public static final class SynchronizedHelper extends AtomicHelper {
        public SynchronizedHelper() {
            super();
        }

        public boolean a(AbstractFuture abstractFuture, Listener listener, Listener listener2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.b != listener) {
                        return false;
                    }
                    abstractFuture.b = listener2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public boolean b(AbstractFuture abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.f2253a != obj) {
                        return false;
                    }
                    abstractFuture.f2253a = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public boolean c(AbstractFuture abstractFuture, Waiter waiter, Waiter waiter2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.c != waiter) {
                        return false;
                    }
                    abstractFuture.c = waiter2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void d(Waiter waiter, Waiter waiter2) {
            waiter.b = waiter2;
        }

        public void e(Waiter waiter, Thread thread) {
            waiter.f2259a = thread;
        }
    }

    public static final class Waiter {
        public static final Waiter c = new Waiter(false);

        /* renamed from: a  reason: collision with root package name */
        public volatile Thread f2259a;
        public volatile Waiter b;

        public Waiter(boolean z) {
        }

        public void a(Waiter waiter) {
            AbstractFuture.f.d(this, waiter);
        }

        public void b() {
            Thread thread = this.f2259a;
            if (thread != null) {
                this.f2259a = null;
                LockSupport.unpark(thread);
            }
        }

        public Waiter() {
            AbstractFuture.f.e(this, Thread.currentThread());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: androidx.work.impl.utils.futures.AbstractFuture$SafeAtomicHelper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: androidx.work.impl.utils.futures.AbstractFuture$SynchronizedHelper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: androidx.work.impl.utils.futures.AbstractFuture$SafeAtomicHelper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: androidx.work.impl.utils.futures.AbstractFuture$SafeAtomicHelper} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.String r0 = "b"
            java.lang.String r1 = "a"
            java.lang.Class<androidx.work.impl.utils.futures.AbstractFuture$Waiter> r2 = androidx.work.impl.utils.futures.AbstractFuture.Waiter.class
            java.lang.String r3 = "guava.concurrent.generate_cancellation_cause"
            java.lang.String r4 = "false"
            java.lang.String r3 = java.lang.System.getProperty(r3, r4)
            boolean r3 = java.lang.Boolean.parseBoolean(r3)
            d = r3
            java.lang.Class<androidx.work.impl.utils.futures.AbstractFuture> r3 = androidx.work.impl.utils.futures.AbstractFuture.class
            java.lang.String r4 = r3.getName()
            java.util.logging.Logger r4 = java.util.logging.Logger.getLogger(r4)
            e = r4
            androidx.work.impl.utils.futures.AbstractFuture$SafeAtomicHelper r4 = new androidx.work.impl.utils.futures.AbstractFuture$SafeAtomicHelper     // Catch:{ all -> 0x0044 }
            java.lang.Class<java.lang.Thread> r5 = java.lang.Thread.class
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r2, r5, r1)     // Catch:{ all -> 0x0044 }
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r2, r2, r0)     // Catch:{ all -> 0x0044 }
            java.lang.String r5 = "c"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r8 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r3, r2, r5)     // Catch:{ all -> 0x0044 }
            java.lang.Class<androidx.work.impl.utils.futures.AbstractFuture$Listener> r2 = androidx.work.impl.utils.futures.AbstractFuture.Listener.class
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r9 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r3, r2, r0)     // Catch:{ all -> 0x0044 }
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r10 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r3, r0, r1)     // Catch:{ all -> 0x0044 }
            r5 = r4
            r5.<init>(r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0044 }
            r0 = 0
            goto L_0x004a
        L_0x0044:
            r0 = move-exception
            androidx.work.impl.utils.futures.AbstractFuture$SynchronizedHelper r4 = new androidx.work.impl.utils.futures.AbstractFuture$SynchronizedHelper
            r4.<init>()
        L_0x004a:
            f = r4
            if (r0 == 0) goto L_0x0057
            java.util.logging.Logger r1 = e
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE
            java.lang.String r3 = "SafeAtomicHelper is broken!"
            r1.log(r2, r3, r0)
        L_0x0057:
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            g = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.futures.AbstractFuture.<clinit>():void");
    }

    private void a(StringBuilder sb) {
        try {
            Object j = j(this);
            sb.append("SUCCESS, result=[");
            sb.append(r(j));
            sb.append("]");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e3) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e3.getClass());
            sb.append(" thrown from get()]");
        }
    }

    private static CancellationException c(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public static Object d(Object obj) {
        obj.getClass();
        return obj;
    }

    public static void f(AbstractFuture abstractFuture) {
        Listener listener = null;
        while (true) {
            abstractFuture.m();
            abstractFuture.b();
            Listener e2 = abstractFuture.e(listener);
            while (true) {
                if (e2 != null) {
                    listener = e2.c;
                    Runnable runnable = e2.f2256a;
                    if (runnable instanceof SetFuture) {
                        SetFuture setFuture = (SetFuture) runnable;
                        abstractFuture = setFuture.f2258a;
                        if (abstractFuture.f2253a == setFuture) {
                            if (f.b(abstractFuture, setFuture, i(setFuture.b))) {
                            }
                        } else {
                            continue;
                        }
                    } else {
                        g(runnable, e2.b);
                    }
                    e2 = listener;
                } else {
                    return;
                }
            }
        }
    }

    private static void g(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = e;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e2);
        }
    }

    private Object h(Object obj) {
        if (obj instanceof Cancellation) {
            throw c("Task was cancelled.", ((Cancellation) obj).b);
        } else if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f2255a);
        } else if (obj == g) {
            return null;
        } else {
            return obj;
        }
    }

    public static Object i(ListenableFuture listenableFuture) {
        if (listenableFuture instanceof AbstractFuture) {
            Object obj = ((AbstractFuture) listenableFuture).f2253a;
            if (!(obj instanceof Cancellation)) {
                return obj;
            }
            Cancellation cancellation = (Cancellation) obj;
            return cancellation.f2254a ? cancellation.b != null ? new Cancellation(false, cancellation.b) : Cancellation.d : obj;
        }
        boolean isCancelled = listenableFuture.isCancelled();
        if ((!d) && isCancelled) {
            return Cancellation.d;
        }
        try {
            Object j = j(listenableFuture);
            return j == null ? g : j;
        } catch (ExecutionException e2) {
            return new Failure(e2.getCause());
        } catch (CancellationException e3) {
            if (isCancelled) {
                return new Cancellation(false, e3);
            }
            return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e3));
        } catch (Throwable th) {
            return new Failure(th);
        }
    }

    private static Object j(Future future) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    private void m() {
        Waiter waiter;
        do {
            waiter = this.c;
        } while (!f.c(this, waiter, Waiter.c));
        while (waiter != null) {
            waiter.b();
            waiter = waiter.b;
        }
    }

    private String r(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    public final void addListener(Runnable runnable, Executor executor) {
        d(runnable);
        d(executor);
        Listener listener = this.b;
        if (listener != Listener.d) {
            Listener listener2 = new Listener(runnable, executor);
            do {
                listener2.c = listener;
                if (!f.a(this, listener, listener2)) {
                    listener = this.b;
                } else {
                    return;
                }
            } while (listener != Listener.d);
        }
        g(runnable, executor);
    }

    public void b() {
    }

    public final boolean cancel(boolean z) {
        Object obj = this.f2253a;
        if (!(obj == null) && !(obj instanceof SetFuture)) {
            return false;
        }
        Cancellation cancellation = d ? new Cancellation(z, new CancellationException("Future.cancel() was called.")) : z ? Cancellation.c : Cancellation.d;
        boolean z2 = false;
        while (true) {
            if (f.b(this, obj, cancellation)) {
                if (z) {
                    this.k();
                }
                f(this);
                if (!(obj instanceof SetFuture)) {
                    return true;
                }
                ListenableFuture listenableFuture = ((SetFuture) obj).b;
                if (listenableFuture instanceof AbstractFuture) {
                    this = (AbstractFuture) listenableFuture;
                    obj = this.f2253a;
                    if (!(obj == null) && !(obj instanceof SetFuture)) {
                        return true;
                    }
                    z2 = true;
                } else {
                    listenableFuture.cancel(z);
                    return true;
                }
            } else {
                obj = this.f2253a;
                if (!(obj instanceof SetFuture)) {
                    return z2;
                }
            }
        }
    }

    public final Listener e(Listener listener) {
        Listener listener2;
        do {
            listener2 = this.b;
        } while (!f.a(this, listener2, Listener.d));
        while (true) {
            Listener listener3 = listener;
            listener = listener2;
            if (listener == null) {
                return listener3;
            }
            listener2 = listener.c;
            listener.c = listener3;
        }
    }

    public final Object get(long j, TimeUnit timeUnit) {
        long j2 = j;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j2);
        if (!Thread.interrupted()) {
            Object obj = this.f2253a;
            if ((obj != null) && (!(obj instanceof SetFuture))) {
                return h(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                Waiter waiter = this.c;
                if (waiter != Waiter.c) {
                    Waiter waiter2 = new Waiter();
                    do {
                        waiter2.a(waiter);
                        if (f.c(this, waiter, waiter2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f2253a;
                                    if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                                        return h(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    n(waiter2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            n(waiter2);
                        } else {
                            waiter = this.c;
                        }
                    } while (waiter != Waiter.c);
                }
                return h(this.f2253a);
            }
            while (nanos > 0) {
                Object obj3 = this.f2253a;
                if ((obj3 != null) && (!(obj3 instanceof SetFuture))) {
                    return h(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String abstractFuture = toString();
            String obj4 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = obj4.toLowerCase(locale);
            String str = "Waited " + j2 + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String str2 = str + " (plus ";
                long j3 = -nanos;
                long convert = timeUnit2.convert(j3, TimeUnit.NANOSECONDS);
                long nanos2 = j3 - timeUnit2.toNanos(convert);
                int i = (convert > 0 ? 1 : (convert == 0 ? 0 : -1));
                boolean z = i == 0 || nanos2 > 1000;
                if (i > 0) {
                    String str3 = str2 + convert + " " + lowerCase;
                    if (z) {
                        str3 = str3 + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA;
                    }
                    str2 = str3 + " ";
                }
                if (z) {
                    str2 = str2 + nanos2 + " nanoseconds ";
                }
                str = str2 + "delay)";
            }
            if (isDone()) {
                throw new TimeoutException(str + " but future completed as timeout expired");
            }
            throw new TimeoutException(str + " for " + abstractFuture);
        }
        throw new InterruptedException();
    }

    public final boolean isCancelled() {
        return this.f2253a instanceof Cancellation;
    }

    public final boolean isDone() {
        Object obj = this.f2253a;
        return (!(obj instanceof SetFuture)) & (obj != null);
    }

    public void k() {
    }

    public String l() {
        Object obj = this.f2253a;
        if (obj instanceof SetFuture) {
            return "setFuture=[" + r(((SetFuture) obj).b) + "]";
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
    }

    public final void n(Waiter waiter) {
        waiter.f2259a = null;
        while (true) {
            Waiter waiter2 = this.c;
            if (waiter2 != Waiter.c) {
                Waiter waiter3 = null;
                while (waiter2 != null) {
                    Waiter waiter4 = waiter2.b;
                    if (waiter2.f2259a != null) {
                        waiter3 = waiter2;
                    } else if (waiter3 != null) {
                        waiter3.b = waiter4;
                        if (waiter3.f2259a == null) {
                        }
                    } else if (!f.c(this, waiter2, waiter4)) {
                    }
                    waiter2 = waiter4;
                }
                return;
            }
            return;
        }
    }

    public boolean o(Object obj) {
        if (obj == null) {
            obj = g;
        }
        if (!f.b(this, (Object) null, obj)) {
            return false;
        }
        f(this);
        return true;
    }

    public boolean p(Throwable th) {
        if (!f.b(this, (Object) null, new Failure((Throwable) d(th)))) {
            return false;
        }
        f(this);
        return true;
    }

    public boolean q(ListenableFuture listenableFuture) {
        SetFuture setFuture;
        Failure failure;
        d(listenableFuture);
        Object obj = this.f2253a;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!f.b(this, (Object) null, i(listenableFuture))) {
                    return false;
                }
                f(this);
                return true;
            }
            setFuture = new SetFuture(this, listenableFuture);
            if (f.b(this, (Object) null, setFuture)) {
                try {
                    listenableFuture.addListener(setFuture, DirectExecutor.INSTANCE);
                } catch (Throwable unused) {
                    failure = Failure.b;
                }
                return true;
            }
            obj = this.f2253a;
        }
        if (obj instanceof Cancellation) {
            listenableFuture.cancel(((Cancellation) obj).f2254a);
        }
        return false;
        f.b(this, setFuture, failure);
        return true;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                str = l();
            } catch (RuntimeException e2) {
                str = "Exception thrown from implementation: " + e2.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public final Object get() {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f2253a;
            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                return h(obj2);
            }
            Waiter waiter = this.c;
            if (waiter != Waiter.c) {
                Waiter waiter2 = new Waiter();
                do {
                    waiter2.a(waiter);
                    if (f.c(this, waiter, waiter2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f2253a;
                            } else {
                                n(waiter2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof SetFuture))));
                        return h(obj);
                    }
                    waiter = this.c;
                } while (waiter != Waiter.c);
            }
            return h(this.f2253a);
        }
        throw new InterruptedException();
    }
}
