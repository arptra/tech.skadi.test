package androidx.work;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import java.util.concurrent.Executor;

public abstract class ListenableWorker {

    /* renamed from: a  reason: collision with root package name */
    public Context f2059a;
    public WorkerParameters b;
    public volatile int c = -256;
    public boolean d;

    public static abstract class Result {

        @RestrictTo
        public static final class Failure extends Result {

            /* renamed from: a  reason: collision with root package name */
            public final Data f2060a;

            public Failure() {
                this(Data.c);
            }

            public Data e() {
                return this.f2060a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Failure.class != obj.getClass()) {
                    return false;
                }
                return this.f2060a.equals(((Failure) obj).f2060a);
            }

            public int hashCode() {
                return (Failure.class.getName().hashCode() * 31) + this.f2060a.hashCode();
            }

            public String toString() {
                return "Failure {mOutputData=" + this.f2060a + '}';
            }

            public Failure(Data data) {
                this.f2060a = data;
            }
        }

        @RestrictTo
        public static final class Retry extends Result {
            /* JADX WARNING: Code restructure failed: missing block: B:4:0x0006, code lost:
                r1 = r2.getClass();
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean equals(java.lang.Object r2) {
                /*
                    r1 = this;
                    r0 = 1
                    if (r1 != r2) goto L_0x0004
                    return r0
                L_0x0004:
                    if (r2 == 0) goto L_0x000f
                    java.lang.Class r1 = r2.getClass()
                    java.lang.Class<androidx.work.ListenableWorker$Result$Retry> r2 = androidx.work.ListenableWorker.Result.Retry.class
                    if (r2 != r1) goto L_0x000f
                    goto L_0x0010
                L_0x000f:
                    r0 = 0
                L_0x0010:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.work.ListenableWorker.Result.Retry.equals(java.lang.Object):boolean");
            }

            public int hashCode() {
                return Retry.class.getName().hashCode();
            }

            public String toString() {
                return "Retry";
            }
        }

        @RestrictTo
        public static final class Success extends Result {

            /* renamed from: a  reason: collision with root package name */
            public final Data f2061a;

            public Success() {
                this(Data.c);
            }

            public Data e() {
                return this.f2061a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Success.class != obj.getClass()) {
                    return false;
                }
                return this.f2061a.equals(((Success) obj).f2061a);
            }

            public int hashCode() {
                return (Success.class.getName().hashCode() * 31) + this.f2061a.hashCode();
            }

            public String toString() {
                return "Success {mOutputData=" + this.f2061a + '}';
            }

            public Success(Data data) {
                this.f2061a = data;
            }
        }

        public static Result a() {
            return new Failure();
        }

        public static Result b() {
            return new Retry();
        }

        public static Result c() {
            return new Success();
        }

        public static Result d(Data data) {
            return new Success(data);
        }
    }

    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        } else if (workerParameters != null) {
            this.f2059a = context;
            this.b = workerParameters;
        } else {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
    }

    public final Context a() {
        return this.f2059a;
    }

    public Executor b() {
        return this.b.a();
    }

    public ListenableFuture c() {
        SettableFuture s = SettableFuture.s();
        s.p(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return s;
    }

    public final UUID e() {
        return this.b.c();
    }

    public final Data f() {
        return this.b.d();
    }

    public final int g() {
        return this.c;
    }

    public TaskExecutor h() {
        return this.b.e();
    }

    public WorkerFactory i() {
        return this.b.f();
    }

    public final boolean j() {
        return this.c != -256;
    }

    public final boolean k() {
        return this.d;
    }

    public void l() {
    }

    public final void m() {
        this.d = true;
    }

    public abstract ListenableFuture n();

    public final void o(int i) {
        this.c = i;
        l();
    }
}
