package androidx.concurrent.futures;

import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class CallbackToFutureAdapter {

    public static final class Completer<T> {

        /* renamed from: a  reason: collision with root package name */
        public Object f474a;
        public SafeFuture b;
        public ResolvableFuture c;
        public boolean d;

        public void a() {
            this.f474a = null;
            this.b = null;
            this.c.o((Object) null);
        }

        public boolean b(Object obj) {
            boolean z = true;
            this.d = true;
            SafeFuture safeFuture = this.b;
            if (safeFuture == null || !safeFuture.a(obj)) {
                z = false;
            }
            if (z) {
                c();
            }
            return z;
        }

        public final void c() {
            this.f474a = null;
            this.b = null;
            this.c = null;
        }

        public boolean d(Throwable th) {
            boolean z = true;
            this.d = true;
            SafeFuture safeFuture = this.b;
            if (safeFuture == null || !safeFuture.b(th)) {
                z = false;
            }
            if (z) {
                c();
            }
            return z;
        }

        public void finalize() {
            ResolvableFuture resolvableFuture;
            SafeFuture safeFuture = this.b;
            if (safeFuture != null && !safeFuture.isDone()) {
                safeFuture.b(new FutureGarbageCollectedException("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f474a));
            }
            if (!this.d && (resolvableFuture = this.c) != null) {
                resolvableFuture.o((Object) null);
            }
        }
    }

    public static final class FutureGarbageCollectedException extends Throwable {
        public FutureGarbageCollectedException(String str) {
            super(str);
        }

        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    public interface Resolver<T> {
    }

    public static final class SafeFuture<T> implements ListenableFuture<T> {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference f475a;
        public final AbstractResolvableFuture b;

        /* renamed from: androidx.concurrent.futures.CallbackToFutureAdapter$SafeFuture$1  reason: invalid class name */
        public class AnonymousClass1 extends AbstractResolvableFuture<T> {
            public final /* synthetic */ SafeFuture h;

            public String l() {
                Completer completer = (Completer) this.h.f475a.get();
                if (completer == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + completer.f474a + "]";
            }
        }

        public boolean a(Object obj) {
            return this.b.o(obj);
        }

        public void addListener(Runnable runnable, Executor executor) {
            this.b.addListener(runnable, executor);
        }

        public boolean b(Throwable th) {
            return this.b.p(th);
        }

        public boolean cancel(boolean z) {
            Completer completer = (Completer) this.f475a.get();
            boolean cancel = this.b.cancel(z);
            if (cancel && completer != null) {
                completer.a();
            }
            return cancel;
        }

        public Object get() {
            return this.b.get();
        }

        public boolean isCancelled() {
            return this.b.isCancelled();
        }

        public boolean isDone() {
            return this.b.isDone();
        }

        public String toString() {
            return this.b.toString();
        }

        public Object get(long j, TimeUnit timeUnit) {
            return this.b.get(j, timeUnit);
        }
    }
}
