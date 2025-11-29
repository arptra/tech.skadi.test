package org.libpag;

import android.os.Handler;
import android.os.Looper;

class d extends Handler {

    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final b f3428a;
        private boolean b;
        private boolean c = false;

        public a(b bVar) {
            this.f3428a = bVar;
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x002d */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x002d A[LOOP:1: B:19:0x002d->B:32:0x002d, LOOP_START, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(android.os.Handler r7, long r8) {
            /*
                r6 = this;
                boolean r7 = r7.post(r6)
                r0 = 0
                if (r7 != 0) goto L_0x0008
                return r0
            L_0x0008:
                monitor-enter(r6)
                r1 = 0
                int r7 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                r3 = 1
                if (r7 <= 0) goto L_0x002d
                long r4 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x0027 }
                long r4 = r4 + r8
            L_0x0015:
                boolean r7 = r6.b     // Catch:{ all -> 0x0027 }
                if (r7 != 0) goto L_0x0035
                long r7 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x0027 }
                long r7 = r4 - r7
                int r9 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
                if (r9 > 0) goto L_0x0029
                r6.c = r3     // Catch:{ all -> 0x0027 }
                monitor-exit(r6)     // Catch:{ all -> 0x0027 }
                return r0
            L_0x0027:
                r7 = move-exception
                goto L_0x0037
            L_0x0029:
                r6.wait(r7)     // Catch:{ InterruptedException -> 0x0015 }
                goto L_0x0015
            L_0x002d:
                boolean r7 = r6.b     // Catch:{ all -> 0x0027 }
                if (r7 != 0) goto L_0x0035
                r6.wait()     // Catch:{ InterruptedException -> 0x002d }
                goto L_0x002d
            L_0x0035:
                monitor-exit(r6)     // Catch:{ all -> 0x0027 }
                return r3
            L_0x0037:
                monitor-exit(r6)     // Catch:{ all -> 0x0027 }
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: org.libpag.d.a.a(android.os.Handler, long):boolean");
        }

        public void run() {
            try {
                this.f3428a.run();
                synchronized (this) {
                    this.b = true;
                    notifyAll();
                    this.f3428a.a(this.c);
                }
            } catch (Throwable th) {
                synchronized (this) {
                    this.b = true;
                    notifyAll();
                    this.f3428a.a(this.c);
                    throw th;
                }
            }
        }
    }

    public interface b extends Runnable {
        void a(boolean z);
    }

    public d(Looper looper) {
        super(looper);
    }

    public final boolean a(b bVar, long j) {
        if (bVar == null) {
            throw new IllegalArgumentException("runnable must not be null");
        } else if (j < 0) {
            throw new IllegalArgumentException("timeout must be non-negative");
        } else if (Looper.myLooper() != getLooper()) {
            return new a(bVar).a(this, j);
        } else {
            bVar.run();
            return true;
        }
    }
}
