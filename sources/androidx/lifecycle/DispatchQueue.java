package androidx.lifecycle;

import com.honey.account.x.a;
import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0015R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Landroidx/lifecycle/DispatchQueue;", "", "<init>", "()V", "", "h", "i", "g", "e", "", "b", "()Z", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "runnable", "c", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "f", "(Ljava/lang/Runnable;)V", "a", "Z", "paused", "finished", "isDraining", "Ljava/util/Queue;", "d", "Ljava/util/Queue;", "queue", "lifecycle-common"}, k = 1, mv = {1, 8, 0})
public final class DispatchQueue {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1353a = true;
    public boolean b;
    public boolean c;
    public final Queue d = new ArrayDeque();

    public static final void d(DispatchQueue dispatchQueue, Runnable runnable) {
        Intrinsics.checkNotNullParameter(dispatchQueue, "this$0");
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        dispatchQueue.f(runnable);
    }

    public final boolean b() {
        return this.b || !this.f1353a;
    }

    public final void c(CoroutineContext coroutineContext, Runnable runnable) {
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        MainCoroutineDispatcher immediate = Dispatchers.c().getImmediate();
        if (immediate.isDispatchNeeded(coroutineContext) || b()) {
            immediate.dispatch(coroutineContext, new a(this, runnable));
        } else {
            f(runnable);
        }
    }

    public final void e() {
        if (!this.c) {
            boolean z = false;
            z = true;
            try {
                while (true) {
                    if (!(this.d.isEmpty() ^ z)) {
                        break;
                    } else if (!b()) {
                        break;
                    } else {
                        Runnable runnable = (Runnable) this.d.poll();
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                }
                this.c = z;
            } finally {
                this.c = z;
            }
        }
    }

    public final void f(Runnable runnable) {
        if (this.d.offer(runnable)) {
            e();
            return;
        }
        throw new IllegalStateException("cannot enqueue any more runnables".toString());
    }

    public final void g() {
        this.b = true;
        e();
    }

    public final void h() {
        this.f1353a = true;
    }

    public final void i() {
        if (this.f1353a) {
            if (!this.b) {
                this.f1353a = false;
                e();
                return;
            }
            throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
        }
    }
}
