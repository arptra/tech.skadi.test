package androidx.work;

import androidx.core.util.Consumer;
import androidx.work.impl.DefaultRunnableScheduler;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 @2\u00020\u0001:\u0003ABCB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000e\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\nR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0007\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010#\u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\b\u001c\u0010 \u001a\u0004\b!\u0010\"R\u001f\u0010)\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b\u001a\u0010(R\u001f\u0010,\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$8\u0006¢\u0006\f\n\u0004\b*\u0010'\u001a\u0004\b+\u0010(R\u0019\u00101\u001a\u0004\u0018\u00010-8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b\u0010\u00100R\u0017\u00106\u001a\u0002028G¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b3\u00105R\u0017\u00107\u001a\u0002028\u0006¢\u0006\f\n\u0004\b!\u00104\u001a\u0004\b.\u00105R\u0017\u00108\u001a\u0002028\u0006¢\u0006\f\n\u0004\b+\u00104\u001a\u0004\b&\u00105R\u0017\u00109\u001a\u0002028\u0006¢\u0006\f\n\u0004\b\r\u00104\u001a\u0004\b\f\u00105R\u0017\u0010:\u001a\u0002028G¢\u0006\f\n\u0004\b\u0016\u00104\u001a\u0004\b*\u00105R\u0017\u0010>\u001a\u00020;8G¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?¨\u0006D"}, d2 = {"Landroidx/work/Configuration;", "", "Landroidx/work/Configuration$Builder;", "builder", "<init>", "(Landroidx/work/Configuration$Builder;)V", "Ljava/util/concurrent/Executor;", "a", "Ljava/util/concurrent/Executor;", "d", "()Ljava/util/concurrent/Executor;", "executor", "b", "m", "taskExecutor", "Landroidx/work/Clock;", "c", "Landroidx/work/Clock;", "()Landroidx/work/Clock;", "clock", "Landroidx/work/WorkerFactory;", "Landroidx/work/WorkerFactory;", "n", "()Landroidx/work/WorkerFactory;", "workerFactory", "Landroidx/work/InputMergerFactory;", "e", "Landroidx/work/InputMergerFactory;", "f", "()Landroidx/work/InputMergerFactory;", "inputMergerFactory", "Landroidx/work/RunnableScheduler;", "Landroidx/work/RunnableScheduler;", "k", "()Landroidx/work/RunnableScheduler;", "runnableScheduler", "Landroidx/core/util/Consumer;", "", "g", "Landroidx/core/util/Consumer;", "()Landroidx/core/util/Consumer;", "initializationExceptionHandler", "h", "l", "schedulingExceptionHandler", "", "i", "Ljava/lang/String;", "()Ljava/lang/String;", "defaultProcessName", "", "j", "I", "()I", "minimumLoggingLevel", "minJobSchedulerId", "maxJobSchedulerId", "contentUriTriggerWorkersLimit", "maxSchedulerLimit", "", "o", "Z", "isUsingDefaultTaskExecutor", "()Z", "p", "Builder", "Companion", "Provider", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
public final class Configuration {
    public static final Companion p = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Executor f2047a;
    public final Executor b;
    public final Clock c;
    public final WorkerFactory d;
    public final InputMergerFactory e;
    public final RunnableScheduler f;
    public final Consumer g;
    public final Consumer h;
    public final String i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final boolean o;

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\r\u001a\u0004\u0018\u00010\u00078\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010!\u001a\u0004\u0018\u00010\u00078\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\b\u001a\u0004\b\u001f\u0010\n\"\u0004\b \u0010\fR$\u0010'\u001a\u0004\u0018\u00010\"8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\t\u0010#\u001a\u0004\b\u000f\u0010$\"\u0004\b%\u0010&R$\u0010/\u001a\u0004\u0018\u00010(8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R*\u00106\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0019\u00102\u001a\u0004\b)\u00103\"\u0004\b4\u00105R*\u0010:\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b7\u00102\u001a\u0004\b8\u00103\"\u0004\b9\u00105R$\u0010A\u001a\u0004\u0018\u00010;8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b\u001e\u0010>\"\u0004\b?\u0010@R\"\u0010H\u001a\u00020B8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\b7\u0010E\"\u0004\bF\u0010GR\"\u0010K\u001a\u00020B8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bI\u0010D\u001a\u0004\bI\u0010E\"\u0004\bJ\u0010GR\"\u0010M\u001a\u00020B8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b+\u0010D\u001a\u0004\b<\u0010E\"\u0004\bL\u0010GR\"\u0010O\u001a\u00020B8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b8\u0010D\u001a\u0004\bC\u0010E\"\u0004\bN\u0010GR\"\u0010Q\u001a\u00020B8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010D\u001a\u0004\b\u0017\u0010E\"\u0004\bP\u0010G¨\u0006R"}, d2 = {"Landroidx/work/Configuration$Builder;", "", "<init>", "()V", "Landroidx/work/Configuration;", "a", "()Landroidx/work/Configuration;", "Ljava/util/concurrent/Executor;", "Ljava/util/concurrent/Executor;", "e", "()Ljava/util/concurrent/Executor;", "setExecutor$work_runtime_release", "(Ljava/util/concurrent/Executor;)V", "executor", "Landroidx/work/WorkerFactory;", "b", "Landroidx/work/WorkerFactory;", "o", "()Landroidx/work/WorkerFactory;", "setWorkerFactory$work_runtime_release", "(Landroidx/work/WorkerFactory;)V", "workerFactory", "Landroidx/work/InputMergerFactory;", "c", "Landroidx/work/InputMergerFactory;", "g", "()Landroidx/work/InputMergerFactory;", "setInputMergerFactory$work_runtime_release", "(Landroidx/work/InputMergerFactory;)V", "inputMergerFactory", "d", "n", "setTaskExecutor$work_runtime_release", "taskExecutor", "Landroidx/work/Clock;", "Landroidx/work/Clock;", "()Landroidx/work/Clock;", "setClock$work_runtime_release", "(Landroidx/work/Clock;)V", "clock", "Landroidx/work/RunnableScheduler;", "f", "Landroidx/work/RunnableScheduler;", "l", "()Landroidx/work/RunnableScheduler;", "setRunnableScheduler$work_runtime_release", "(Landroidx/work/RunnableScheduler;)V", "runnableScheduler", "Landroidx/core/util/Consumer;", "", "Landroidx/core/util/Consumer;", "()Landroidx/core/util/Consumer;", "setInitializationExceptionHandler$work_runtime_release", "(Landroidx/core/util/Consumer;)V", "initializationExceptionHandler", "h", "m", "setSchedulingExceptionHandler$work_runtime_release", "schedulingExceptionHandler", "", "i", "Ljava/lang/String;", "()Ljava/lang/String;", "setDefaultProcessName$work_runtime_release", "(Ljava/lang/String;)V", "defaultProcessName", "", "j", "I", "()I", "setLoggingLevel$work_runtime_release", "(I)V", "loggingLevel", "k", "setMinJobSchedulerId$work_runtime_release", "minJobSchedulerId", "setMaxJobSchedulerId$work_runtime_release", "maxJobSchedulerId", "setMaxSchedulerLimit$work_runtime_release", "maxSchedulerLimit", "setContentUriTriggerWorkersLimit$work_runtime_release", "contentUriTriggerWorkersLimit", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public Executor f2048a;
        public WorkerFactory b;
        public InputMergerFactory c;
        public Executor d;
        public Clock e;
        public RunnableScheduler f;
        public Consumer g;
        public Consumer h;
        public String i;
        public int j = 4;
        public int k;
        public int l = Integer.MAX_VALUE;
        public int m = 20;
        public int n = ConfigurationKt.c();

        public final Configuration a() {
            return new Configuration(this);
        }

        public final Clock b() {
            return this.e;
        }

        public final int c() {
            return this.n;
        }

        public final String d() {
            return this.i;
        }

        public final Executor e() {
            return this.f2048a;
        }

        public final Consumer f() {
            return this.g;
        }

        public final InputMergerFactory g() {
            return this.c;
        }

        public final int h() {
            return this.j;
        }

        public final int i() {
            return this.l;
        }

        public final int j() {
            return this.m;
        }

        public final int k() {
            return this.k;
        }

        public final RunnableScheduler l() {
            return this.f;
        }

        public final Consumer m() {
            return this.h;
        }

        public final Executor n() {
            return this.d;
        }

        public final WorkerFactory o() {
            return this.b;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/work/Configuration$Companion;", "", "()V", "MIN_SCHEDULER_LIMIT", "", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/work/Configuration$Provider;", "", "Landroidx/work/Configuration;", "a", "()Landroidx/work/Configuration;", "workManagerConfiguration", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
    public interface Provider {
        Configuration a();
    }

    public Configuration(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Executor e2 = builder.e();
        boolean z = false;
        this.f2047a = e2 == null ? ConfigurationKt.b(false) : e2;
        this.o = builder.n() == null ? true : z;
        Executor n2 = builder.n();
        this.b = n2 == null ? ConfigurationKt.b(true) : n2;
        Clock b2 = builder.b();
        this.c = b2 == null ? new SystemClock() : b2;
        WorkerFactory o2 = builder.o();
        if (o2 == null) {
            o2 = WorkerFactory.c();
            Intrinsics.checkNotNullExpressionValue(o2, "getDefaultWorkerFactory()");
        }
        this.d = o2;
        InputMergerFactory g2 = builder.g();
        this.e = g2 == null ? NoOpInputMergerFactory.f2063a : g2;
        RunnableScheduler l2 = builder.l();
        this.f = l2 == null ? new DefaultRunnableScheduler() : l2;
        this.j = builder.h();
        this.k = builder.k();
        this.l = builder.i();
        this.n = builder.j();
        this.g = builder.f();
        this.h = builder.m();
        this.i = builder.d();
        this.m = builder.c();
    }

    public final Clock a() {
        return this.c;
    }

    public final int b() {
        return this.m;
    }

    public final String c() {
        return this.i;
    }

    public final Executor d() {
        return this.f2047a;
    }

    public final Consumer e() {
        return this.g;
    }

    public final InputMergerFactory f() {
        return this.e;
    }

    public final int g() {
        return this.l;
    }

    public final int h() {
        return this.n;
    }

    public final int i() {
        return this.k;
    }

    public final int j() {
        return this.j;
    }

    public final RunnableScheduler k() {
        return this.f;
    }

    public final Consumer l() {
        return this.h;
    }

    public final Executor m() {
        return this.b;
    }

    public final WorkerFactory n() {
        return this.d;
    }
}
