package androidx.work.impl.utils;

import androidx.annotation.RestrictTo;
import androidx.work.Operation;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.WorkManagerImpl;

@RestrictTo
public class PruneWorkRunnable implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final WorkManagerImpl f2237a;
    public final OperationImpl b;

    public void run() {
        try {
            this.f2237a.p().j().b();
            this.b.a(Operation.f2064a);
        } catch (Throwable th) {
            this.b.a(new Operation.State.FAILURE(th));
        }
    }
}
