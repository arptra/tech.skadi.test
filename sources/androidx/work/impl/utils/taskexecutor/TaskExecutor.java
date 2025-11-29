package androidx.work.impl.utils.taskexecutor;

import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

@RestrictTo
public interface TaskExecutor {
    CoroutineDispatcher a() {
        return ExecutorsKt.a(d());
    }

    void b(Runnable runnable) {
        d().execute(runnable);
    }

    Executor c();

    SerialExecutor d();
}
