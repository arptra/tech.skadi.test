package androidx.work.impl.utils;

import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;

@RestrictTo
public class SynchronousExecutor implements Executor {
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
