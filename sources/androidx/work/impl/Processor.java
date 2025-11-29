package androidx.work.impl;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.work.Configuration;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import com.honey.account.j0.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

@RestrictTo
public class Processor implements ForegroundProcessor {
    public static final String l = Logger.i("Processor");

    /* renamed from: a  reason: collision with root package name */
    public PowerManager.WakeLock f2090a = null;
    public Context b;
    public Configuration c;
    public TaskExecutor d;
    public WorkDatabase e;
    public Map f = new HashMap();
    public Map g = new HashMap();
    public Map h = new HashMap();
    public Set i = new HashSet();
    public final List j = new ArrayList();
    public final Object k = new Object();

    public Processor(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase) {
        this.b = context;
        this.c = configuration;
        this.d = taskExecutor;
        this.e = workDatabase;
    }

    public static boolean i(String str, WorkerWrapper workerWrapper, int i2) {
        if (workerWrapper != null) {
            workerWrapper.g(i2);
            Logger e2 = Logger.e();
            String str2 = l;
            e2.a(str2, "WorkerWrapper interrupted for " + str);
            return true;
        }
        Logger e3 = Logger.e();
        String str3 = l;
        e3.a(str3, "WorkerWrapper could not be found for " + str);
        return false;
    }

    public void a(String str, ForegroundInfo foregroundInfo) {
        synchronized (this.k) {
            try {
                Logger e2 = Logger.e();
                String str2 = l;
                e2.f(str2, "Moving WorkSpec (" + str + ") to the foreground");
                WorkerWrapper workerWrapper = (WorkerWrapper) this.g.remove(str);
                if (workerWrapper != null) {
                    if (this.f2090a == null) {
                        PowerManager.WakeLock b2 = WakeLocks.b(this.b, "ProcessorForegroundLck");
                        this.f2090a = b2;
                        b2.acquire();
                    }
                    this.f.put(str, workerWrapper);
                    ContextCompat.startForegroundService(this.b, SystemForegroundDispatcher.f(this.b, workerWrapper.d(), foregroundInfo));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e(ExecutionListener executionListener) {
        synchronized (this.k) {
            this.j.add(executionListener);
        }
    }

    public final WorkerWrapper f(String str) {
        WorkerWrapper workerWrapper = (WorkerWrapper) this.f.remove(str);
        boolean z = workerWrapper != null;
        if (!z) {
            workerWrapper = (WorkerWrapper) this.g.remove(str);
        }
        this.h.remove(str);
        if (z) {
            u();
        }
        return workerWrapper;
    }

    public WorkSpec g(String str) {
        synchronized (this.k) {
            try {
                WorkerWrapper h2 = h(str);
                if (h2 == null) {
                    return null;
                }
                WorkSpec e2 = h2.e();
                return e2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final WorkerWrapper h(String str) {
        WorkerWrapper workerWrapper = (WorkerWrapper) this.f.get(str);
        return workerWrapper == null ? (WorkerWrapper) this.g.get(str) : workerWrapper;
    }

    public boolean j(String str) {
        boolean contains;
        synchronized (this.k) {
            contains = this.i.contains(str);
        }
        return contains;
    }

    public boolean k(String str) {
        boolean z;
        synchronized (this.k) {
            z = h(str) != null;
        }
        return z;
    }

    public final /* synthetic */ void l(WorkGenerationalId workGenerationalId, boolean z) {
        synchronized (this.k) {
            try {
                for (ExecutionListener c2 : this.j) {
                    c2.c(workGenerationalId, z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ WorkSpec m(ArrayList arrayList, String str) {
        arrayList.addAll(this.e.k().c(str));
        return this.e.j().y(str);
    }

    public final /* synthetic */ void n(ListenableFuture listenableFuture, WorkerWrapper workerWrapper) {
        boolean z;
        try {
            z = ((Boolean) listenableFuture.get()).booleanValue();
        } catch (InterruptedException | ExecutionException unused) {
            z = true;
        }
        o(workerWrapper, z);
    }

    public final void o(WorkerWrapper workerWrapper, boolean z) {
        synchronized (this.k) {
            try {
                WorkGenerationalId d2 = workerWrapper.d();
                String b2 = d2.b();
                if (h(b2) == workerWrapper) {
                    f(b2);
                }
                Logger e2 = Logger.e();
                String str = l;
                e2.a(str, getClass().getSimpleName() + " " + b2 + " executed; reschedule = " + z);
                for (ExecutionListener c2 : this.j) {
                    c2.c(d2, z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void p(ExecutionListener executionListener) {
        synchronized (this.k) {
            this.j.remove(executionListener);
        }
    }

    public final void q(WorkGenerationalId workGenerationalId, boolean z) {
        this.d.c().execute(new c(this, workGenerationalId, z));
    }

    public boolean r(StartStopToken startStopToken) {
        return s(startStopToken, (WorkerParameters.RuntimeExtras) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x008f, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean s(androidx.work.impl.StartStopToken r13, androidx.work.WorkerParameters.RuntimeExtras r14) {
        /*
            r12 = this;
            androidx.work.impl.model.WorkGenerationalId r0 = r13.a()
            java.lang.String r1 = r0.b()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            androidx.work.impl.WorkDatabase r2 = r12.e
            com.honey.account.j0.a r3 = new com.honey.account.j0.a
            r3.<init>(r12, r9, r1)
            java.lang.Object r2 = r2.runInTransaction(r3)
            r8 = r2
            androidx.work.impl.model.WorkSpec r8 = (androidx.work.impl.model.WorkSpec) r8
            r2 = 0
            if (r8 != 0) goto L_0x003c
            androidx.work.Logger r13 = androidx.work.Logger.e()
            java.lang.String r14 = l
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Didn't find WorkSpec for id "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            r13.k(r14, r1)
            r12.q(r0, r2)
            return r2
        L_0x003c:
            java.lang.Object r10 = r12.k
            monitor-enter(r10)
            boolean r3 = r12.k(r1)     // Catch:{ all -> 0x0088 }
            if (r3 == 0) goto L_0x0090
            java.util.Map r14 = r12.h     // Catch:{ all -> 0x0088 }
            java.lang.Object r14 = r14.get(r1)     // Catch:{ all -> 0x0088 }
            java.util.Set r14 = (java.util.Set) r14     // Catch:{ all -> 0x0088 }
            java.util.Iterator r1 = r14.iterator()     // Catch:{ all -> 0x0088 }
            java.lang.Object r1 = r1.next()     // Catch:{ all -> 0x0088 }
            androidx.work.impl.StartStopToken r1 = (androidx.work.impl.StartStopToken) r1     // Catch:{ all -> 0x0088 }
            androidx.work.impl.model.WorkGenerationalId r1 = r1.a()     // Catch:{ all -> 0x0088 }
            int r1 = r1.a()     // Catch:{ all -> 0x0088 }
            int r3 = r0.a()     // Catch:{ all -> 0x0088 }
            if (r1 != r3) goto L_0x008b
            r14.add(r13)     // Catch:{ all -> 0x0088 }
            androidx.work.Logger r12 = androidx.work.Logger.e()     // Catch:{ all -> 0x0088 }
            java.lang.String r13 = l     // Catch:{ all -> 0x0088 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0088 }
            r14.<init>()     // Catch:{ all -> 0x0088 }
            java.lang.String r1 = "Work "
            r14.append(r1)     // Catch:{ all -> 0x0088 }
            r14.append(r0)     // Catch:{ all -> 0x0088 }
            java.lang.String r0 = " is already enqueued for processing"
            r14.append(r0)     // Catch:{ all -> 0x0088 }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x0088 }
            r12.a(r13, r14)     // Catch:{ all -> 0x0088 }
            goto L_0x008e
        L_0x0088:
            r12 = move-exception
            goto L_0x010b
        L_0x008b:
            r12.q(r0, r2)     // Catch:{ all -> 0x0088 }
        L_0x008e:
            monitor-exit(r10)     // Catch:{ all -> 0x0088 }
            return r2
        L_0x0090:
            int r3 = r8.d()     // Catch:{ all -> 0x0088 }
            int r4 = r0.a()     // Catch:{ all -> 0x0088 }
            if (r3 == r4) goto L_0x009f
            r12.q(r0, r2)     // Catch:{ all -> 0x0088 }
            monitor-exit(r10)     // Catch:{ all -> 0x0088 }
            return r2
        L_0x009f:
            androidx.work.impl.WorkerWrapper$Builder r11 = new androidx.work.impl.WorkerWrapper$Builder     // Catch:{ all -> 0x0088 }
            android.content.Context r3 = r12.b     // Catch:{ all -> 0x0088 }
            androidx.work.Configuration r4 = r12.c     // Catch:{ all -> 0x0088 }
            androidx.work.impl.utils.taskexecutor.TaskExecutor r5 = r12.d     // Catch:{ all -> 0x0088 }
            androidx.work.impl.WorkDatabase r7 = r12.e     // Catch:{ all -> 0x0088 }
            r2 = r11
            r6 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0088 }
            androidx.work.impl.WorkerWrapper$Builder r14 = r11.c(r14)     // Catch:{ all -> 0x0088 }
            androidx.work.impl.WorkerWrapper r14 = r14.b()     // Catch:{ all -> 0x0088 }
            com.google.common.util.concurrent.ListenableFuture r2 = r14.c()     // Catch:{ all -> 0x0088 }
            com.honey.account.j0.b r3 = new com.honey.account.j0.b     // Catch:{ all -> 0x0088 }
            r3.<init>(r12, r2, r14)     // Catch:{ all -> 0x0088 }
            androidx.work.impl.utils.taskexecutor.TaskExecutor r4 = r12.d     // Catch:{ all -> 0x0088 }
            java.util.concurrent.Executor r4 = r4.c()     // Catch:{ all -> 0x0088 }
            r2.addListener(r3, r4)     // Catch:{ all -> 0x0088 }
            java.util.Map r2 = r12.g     // Catch:{ all -> 0x0088 }
            r2.put(r1, r14)     // Catch:{ all -> 0x0088 }
            java.util.HashSet r2 = new java.util.HashSet     // Catch:{ all -> 0x0088 }
            r2.<init>()     // Catch:{ all -> 0x0088 }
            r2.add(r13)     // Catch:{ all -> 0x0088 }
            java.util.Map r13 = r12.h     // Catch:{ all -> 0x0088 }
            r13.put(r1, r2)     // Catch:{ all -> 0x0088 }
            monitor-exit(r10)     // Catch:{ all -> 0x0088 }
            androidx.work.impl.utils.taskexecutor.TaskExecutor r13 = r12.d
            androidx.work.impl.utils.taskexecutor.SerialExecutor r13 = r13.d()
            r13.execute(r14)
            androidx.work.Logger r13 = androidx.work.Logger.e()
            java.lang.String r14 = l
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.Class r12 = r12.getClass()
            java.lang.String r12 = r12.getSimpleName()
            r1.append(r12)
            java.lang.String r12 = ": processing "
            r1.append(r12)
            r1.append(r0)
            java.lang.String r12 = r1.toString()
            r13.a(r14, r12)
            r12 = 1
            return r12
        L_0x010b:
            monitor-exit(r10)     // Catch:{ all -> 0x0088 }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.Processor.s(androidx.work.impl.StartStopToken, androidx.work.WorkerParameters$RuntimeExtras):boolean");
    }

    public boolean t(String str, int i2) {
        WorkerWrapper f2;
        synchronized (this.k) {
            Logger e2 = Logger.e();
            String str2 = l;
            e2.a(str2, "Processor cancelling " + str);
            this.i.add(str);
            f2 = f(str);
        }
        return i(str, f2, i2);
    }

    public final void u() {
        synchronized (this.k) {
            try {
                if (!(!this.f.isEmpty())) {
                    this.b.startService(SystemForegroundDispatcher.g(this.b));
                    PowerManager.WakeLock wakeLock = this.f2090a;
                    if (wakeLock != null) {
                        wakeLock.release();
                        this.f2090a = null;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean v(StartStopToken startStopToken, int i2) {
        WorkerWrapper f2;
        String b2 = startStopToken.a().b();
        synchronized (this.k) {
            f2 = f(b2);
        }
        return i(b2, f2, i2);
    }

    public boolean w(StartStopToken startStopToken, int i2) {
        String b2 = startStopToken.a().b();
        synchronized (this.k) {
            try {
                if (this.f.get(b2) != null) {
                    Logger e2 = Logger.e();
                    String str = l;
                    e2.a(str, "Ignored stopWork. WorkerWrapper " + b2 + " is in foreground");
                    return false;
                }
                Set set = (Set) this.h.get(b2);
                if (set != null) {
                    if (set.contains(startStopToken)) {
                        WorkerWrapper f2 = f(b2);
                        return i(b2, f2, i2);
                    }
                }
                return false;
            } finally {
            }
        }
    }
}
