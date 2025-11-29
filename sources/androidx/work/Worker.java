package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;

public abstract class Worker extends ListenableWorker {
    public SettableFuture e;

    public Worker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public ListenableFuture c() {
        final SettableFuture s = SettableFuture.s();
        b().execute(new Runnable() {
            public void run() {
                try {
                    s.o(Worker.this.q());
                } catch (Throwable th) {
                    s.p(th);
                }
            }
        });
        return s;
    }

    public final ListenableFuture n() {
        this.e = SettableFuture.s();
        b().execute(new Runnable() {
            public void run() {
                try {
                    Worker.this.e.o(Worker.this.p());
                } catch (Throwable th) {
                    Worker.this.e.p(th);
                }
            }
        });
        return this.e;
    }

    public abstract ListenableWorker.Result p();

    public ForegroundInfo q() {
        throw new IllegalStateException("Expedited WorkRequests require a Worker to provide an implementation for \n `getForegroundInfo()`");
    }
}
