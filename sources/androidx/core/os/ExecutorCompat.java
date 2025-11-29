package androidx.core.os;

import android.os.Handler;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class ExecutorCompat {

    public static class HandlerExecutor implements Executor {

        /* renamed from: a  reason: collision with root package name */
        public final Handler f772a;

        public void execute(Runnable runnable) {
            if (!this.f772a.post((Runnable) Preconditions.h(runnable))) {
                throw new RejectedExecutionException(this.f772a + " is shutting down");
            }
        }
    }
}
