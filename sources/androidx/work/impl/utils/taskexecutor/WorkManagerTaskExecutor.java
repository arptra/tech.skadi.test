package androidx.work.impl.utils.taskexecutor;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RestrictTo;
import androidx.work.impl.utils.SerialExecutorImpl;
import java.util.concurrent.Executor;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

@RestrictTo
public class WorkManagerTaskExecutor implements TaskExecutor {

    /* renamed from: a  reason: collision with root package name */
    public final SerialExecutorImpl f2260a;
    public final CoroutineDispatcher b;
    public final Handler c = new Handler(Looper.getMainLooper());
    public final Executor d = new Executor() {
        public void execute(Runnable runnable) {
            WorkManagerTaskExecutor.this.c.post(runnable);
        }
    };

    public WorkManagerTaskExecutor(Executor executor) {
        SerialExecutorImpl serialExecutorImpl = new SerialExecutorImpl(executor);
        this.f2260a = serialExecutorImpl;
        this.b = ExecutorsKt.a(serialExecutorImpl);
    }

    public CoroutineDispatcher a() {
        return this.b;
    }

    public Executor c() {
        return this.d;
    }

    /* renamed from: e */
    public SerialExecutorImpl d() {
        return this.f2260a;
    }
}
