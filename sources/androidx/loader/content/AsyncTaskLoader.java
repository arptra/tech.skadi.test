package androidx.loader.content;

import android.os.Handler;
import android.os.SystemClock;
import androidx.core.os.OperationCanceledException;
import androidx.core.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public abstract class AsyncTaskLoader<D> extends Loader<D> {
    public final Executor j;
    public volatile LoadTask k;
    public volatile LoadTask l;
    public long m;
    public long n;
    public Handler o;

    public final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {
        public final CountDownLatch k = new CountDownLatch(1);
        public boolean l;

        public LoadTask() {
        }

        public void i(Object obj) {
            try {
                AsyncTaskLoader.this.A(this, obj);
            } finally {
                this.k.countDown();
            }
        }

        public void j(Object obj) {
            try {
                AsyncTaskLoader.this.B(this, obj);
            } finally {
                this.k.countDown();
            }
        }

        /* renamed from: o */
        public Object c(Void... voidArr) {
            try {
                return AsyncTaskLoader.this.G();
            } catch (OperationCanceledException e) {
                if (g()) {
                    return null;
                }
                throw e;
            }
        }

        public void run() {
            this.l = false;
            AsyncTaskLoader.this.C();
        }
    }

    public void A(LoadTask loadTask, Object obj) {
        F(obj);
        if (this.l == loadTask) {
            u();
            this.n = SystemClock.uptimeMillis();
            this.l = null;
            e();
            C();
        }
    }

    public void B(LoadTask loadTask, Object obj) {
        if (this.k != loadTask) {
            A(loadTask, obj);
        } else if (j()) {
            F(obj);
        } else {
            c();
            this.n = SystemClock.uptimeMillis();
            this.k = null;
            f(obj);
        }
    }

    public void C() {
        if (this.l == null && this.k != null) {
            if (this.k.l) {
                this.k.l = false;
                this.o.removeCallbacks(this.k);
            }
            if (this.m <= 0 || SystemClock.uptimeMillis() >= this.n + this.m) {
                this.k.d(this.j, (Object[]) null);
                return;
            }
            this.k.l = true;
            this.o.postAtTime(this.k, this.n + this.m);
        }
    }

    public boolean D() {
        return this.l != null;
    }

    public abstract Object E();

    public void F(Object obj) {
    }

    public Object G() {
        return E();
    }

    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.g(str, fileDescriptor, printWriter, strArr);
        if (this.k != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.k);
            printWriter.print(" waiting=");
            printWriter.println(this.k.l);
        }
        if (this.l != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.l);
            printWriter.print(" waiting=");
            printWriter.println(this.l.l);
        }
        if (this.m != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            TimeUtils.c(this.m, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            TimeUtils.b(this.n, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    public boolean n() {
        if (this.k == null) {
            return false;
        }
        if (!this.e) {
            this.h = true;
        }
        if (this.l != null) {
            if (this.k.l) {
                this.k.l = false;
                this.o.removeCallbacks(this.k);
            }
            this.k = null;
            return false;
        } else if (this.k.l) {
            this.k.l = false;
            this.o.removeCallbacks(this.k);
            this.k = null;
            return false;
        } else {
            boolean b = this.k.b(false);
            if (b) {
                this.l = this.k;
                z();
            }
            this.k = null;
            return b;
        }
    }

    public void p() {
        super.p();
        b();
        this.k = new LoadTask();
        C();
    }

    public void z() {
    }
}
