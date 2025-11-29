package androidx.arch.core.executor;

import androidx.annotation.RestrictTo;
import com.honey.account.h.a;
import com.honey.account.h.b;
import java.util.concurrent.Executor;

@RestrictTo
public class ArchTaskExecutor extends TaskExecutor {
    public static volatile ArchTaskExecutor c;
    public static final Executor d = new a();
    public static final Executor e = new b();

    /* renamed from: a  reason: collision with root package name */
    public TaskExecutor f378a;
    public final TaskExecutor b;

    public ArchTaskExecutor() {
        DefaultTaskExecutor defaultTaskExecutor = new DefaultTaskExecutor();
        this.b = defaultTaskExecutor;
        this.f378a = defaultTaskExecutor;
    }

    public static Executor g() {
        return e;
    }

    public static ArchTaskExecutor h() {
        if (c != null) {
            return c;
        }
        synchronized (ArchTaskExecutor.class) {
            try {
                if (c == null) {
                    c = new ArchTaskExecutor();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return c;
    }

    public void a(Runnable runnable) {
        this.f378a.a(runnable);
    }

    public boolean c() {
        return this.f378a.c();
    }

    public void d(Runnable runnable) {
        this.f378a.d(runnable);
    }
}
