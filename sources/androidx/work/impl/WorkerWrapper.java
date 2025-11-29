package androidx.work.impl;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.Clock;
import androidx.work.Configuration;
import androidx.work.Data;
import androidx.work.InputMerger;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.PackageManagerHelper;
import androidx.work.impl.utils.SynchronousExecutor;
import androidx.work.impl.utils.WorkForegroundRunnable;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.WorkProgressUpdater;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import com.honey.account.j0.g;
import com.upuphone.runasone.uupcast.CastErrorCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

@RestrictTo
public class WorkerWrapper implements Runnable {
    public static final String s = Logger.i("WorkerWrapper");

    /* renamed from: a  reason: collision with root package name */
    public Context f2109a;
    public final String b;
    public WorkerParameters.RuntimeExtras c;
    public WorkSpec d;
    public ListenableWorker e;
    public TaskExecutor f;
    public ListenableWorker.Result g = ListenableWorker.Result.a();
    public Configuration h;
    public Clock i;
    public ForegroundProcessor j;
    public WorkDatabase k;
    public WorkSpecDao l;
    public DependencyDao m;
    public List n;
    public String o;
    public SettableFuture p = SettableFuture.s();
    public final SettableFuture q = SettableFuture.s();
    public volatile int r = -256;

    @RestrictTo
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public Context f2112a;
        public ListenableWorker b;
        public ForegroundProcessor c;
        public TaskExecutor d;
        public Configuration e;
        public WorkDatabase f;
        public WorkSpec g;
        public final List h;
        public WorkerParameters.RuntimeExtras i = new WorkerParameters.RuntimeExtras();

        public Builder(Context context, Configuration configuration, TaskExecutor taskExecutor, ForegroundProcessor foregroundProcessor, WorkDatabase workDatabase, WorkSpec workSpec, List list) {
            this.f2112a = context.getApplicationContext();
            this.d = taskExecutor;
            this.c = foregroundProcessor;
            this.e = configuration;
            this.f = workDatabase;
            this.g = workSpec;
            this.h = list;
        }

        public WorkerWrapper b() {
            return new WorkerWrapper(this);
        }

        public Builder c(WorkerParameters.RuntimeExtras runtimeExtras) {
            if (runtimeExtras != null) {
                this.i = runtimeExtras;
            }
            return this;
        }
    }

    public WorkerWrapper(Builder builder) {
        this.f2109a = builder.f2112a;
        this.f = builder.d;
        this.j = builder.c;
        WorkSpec workSpec = builder.g;
        this.d = workSpec;
        this.b = workSpec.f2184a;
        this.c = builder.i;
        this.e = builder.b;
        Configuration configuration = builder.e;
        this.h = configuration;
        this.i = configuration.a();
        WorkDatabase workDatabase = builder.f;
        this.k = workDatabase;
        this.l = workDatabase.j();
        this.m = this.k.d();
        this.n = builder.h;
    }

    public final String b(List list) {
        StringBuilder sb = new StringBuilder("Work [ id=");
        sb.append(this.b);
        sb.append(", tags={ ");
        Iterator it = list.iterator();
        boolean z = true;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(" } ]");
        return sb.toString();
    }

    public ListenableFuture c() {
        return this.p;
    }

    public WorkGenerationalId d() {
        return WorkSpecKt.a(this.d);
    }

    public WorkSpec e() {
        return this.d;
    }

    public final void f(ListenableWorker.Result result) {
        if (result instanceof ListenableWorker.Result.Success) {
            Logger e2 = Logger.e();
            String str = s;
            e2.f(str, "Worker result SUCCESS for " + this.o);
            if (this.d.k()) {
                l();
            } else {
                q();
            }
        } else if (result instanceof ListenableWorker.Result.Retry) {
            Logger e3 = Logger.e();
            String str2 = s;
            e3.f(str2, "Worker result RETRY for " + this.o);
            k();
        } else {
            Logger e4 = Logger.e();
            String str3 = s;
            e4.f(str3, "Worker result FAILURE for " + this.o);
            if (this.d.k()) {
                l();
            } else {
                p();
            }
        }
    }

    public void g(int i2) {
        this.r = i2;
        r();
        this.q.cancel(true);
        if (this.e == null || !this.q.isCancelled()) {
            Logger.e().a(s, "WorkSpec " + this.d + " is already done. Not interrupting.");
            return;
        }
        this.e.o(i2);
    }

    public final void h(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (this.l.f(str2) != WorkInfo.State.CANCELLED) {
                this.l.l(WorkInfo.State.FAILED, str2);
            }
            linkedList.addAll(this.m.b(str2));
        }
    }

    public final /* synthetic */ void i(ListenableFuture listenableFuture) {
        if (this.q.isCancelled()) {
            listenableFuture.cancel(true);
        }
    }

    public void j() {
        if (!r()) {
            this.k.beginTransaction();
            try {
                WorkInfo.State f2 = this.l.f(this.b);
                this.k.i().a(this.b);
                if (f2 == null) {
                    m(false);
                } else if (f2 == WorkInfo.State.RUNNING) {
                    f(this.g);
                } else if (!f2.isFinished()) {
                    this.r = CastErrorCode.SOURCE_PEER_DEVICE_NOT_ATTACHED;
                    k();
                }
                this.k.setTransactionSuccessful();
                this.k.endTransaction();
            } catch (Throwable th) {
                this.k.endTransaction();
                throw th;
            }
        }
    }

    public final void k() {
        this.k.beginTransaction();
        try {
            this.l.l(WorkInfo.State.ENQUEUED, this.b);
            this.l.m(this.b, this.i.currentTimeMillis());
            this.l.t(this.b, this.d.f());
            this.l.A(this.b, -1);
            this.k.setTransactionSuccessful();
        } finally {
            this.k.endTransaction();
            m(true);
        }
    }

    public final void l() {
        this.k.beginTransaction();
        try {
            this.l.m(this.b, this.i.currentTimeMillis());
            this.l.l(WorkInfo.State.ENQUEUED, this.b);
            this.l.q(this.b);
            this.l.t(this.b, this.d.f());
            this.l.u(this.b);
            this.l.A(this.b, -1);
            this.k.setTransactionSuccessful();
        } finally {
            this.k.endTransaction();
            m(false);
        }
    }

    public final void m(boolean z) {
        this.k.beginTransaction();
        try {
            if (!this.k.j().o()) {
                PackageManagerHelper.c(this.f2109a, RescheduleReceiver.class, false);
            }
            if (z) {
                this.l.l(WorkInfo.State.ENQUEUED, this.b);
                this.l.c(this.b, this.r);
                this.l.A(this.b, -1);
            }
            this.k.setTransactionSuccessful();
            this.k.endTransaction();
            this.p.o(Boolean.valueOf(z));
        } catch (Throwable th) {
            this.k.endTransaction();
            throw th;
        }
    }

    public final void n() {
        WorkInfo.State f2 = this.l.f(this.b);
        if (f2 == WorkInfo.State.RUNNING) {
            Logger e2 = Logger.e();
            String str = s;
            e2.a(str, "Status for " + this.b + " is RUNNING; not doing any work and rescheduling for later execution");
            m(true);
            return;
        }
        Logger e3 = Logger.e();
        String str2 = s;
        e3.a(str2, "Status for " + this.b + " is " + f2 + " ; not doing any work");
        m(false);
    }

    public final void o() {
        Data a2;
        if (!r()) {
            this.k.beginTransaction();
            try {
                WorkSpec workSpec = this.d;
                if (workSpec.b != WorkInfo.State.ENQUEUED) {
                    n();
                    this.k.setTransactionSuccessful();
                    Logger e2 = Logger.e();
                    String str = s;
                    e2.a(str, this.d.c + " is not in ENQUEUED state. Nothing more to do");
                } else if ((workSpec.k() || this.d.j()) && this.i.currentTimeMillis() < this.d.c()) {
                    Logger.e().a(s, String.format("Delaying execution for %s because it is being executed before schedule.", new Object[]{this.d.c}));
                    m(true);
                    this.k.setTransactionSuccessful();
                    this.k.endTransaction();
                } else {
                    this.k.setTransactionSuccessful();
                    this.k.endTransaction();
                    if (this.d.k()) {
                        a2 = this.d.e;
                    } else {
                        InputMerger b2 = this.h.f().b(this.d.d);
                        if (b2 == null) {
                            Logger e3 = Logger.e();
                            String str2 = s;
                            e3.c(str2, "Could not create Input Merger " + this.d.d);
                            p();
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(this.d.e);
                        arrayList.addAll(this.l.i(this.b));
                        a2 = b2.a(arrayList);
                    }
                    Data data = a2;
                    UUID fromString = UUID.fromString(this.b);
                    List list = this.n;
                    WorkerParameters.RuntimeExtras runtimeExtras = this.c;
                    WorkSpec workSpec2 = this.d;
                    WorkerParameters workerParameters = new WorkerParameters(fromString, data, list, runtimeExtras, workSpec2.k, workSpec2.d(), this.h.d(), this.f, this.h.n(), new WorkProgressUpdater(this.k, this.f), new WorkForegroundUpdater(this.k, this.j, this.f));
                    if (this.e == null) {
                        this.e = this.h.n().b(this.f2109a, this.d.c, workerParameters);
                    }
                    ListenableWorker listenableWorker = this.e;
                    if (listenableWorker == null) {
                        Logger e4 = Logger.e();
                        String str3 = s;
                        e4.c(str3, "Could not create Worker " + this.d.c);
                        p();
                    } else if (listenableWorker.k()) {
                        Logger e5 = Logger.e();
                        String str4 = s;
                        e5.c(str4, "Received an already-used Worker " + this.d.c + "; Worker Factory should return new instances");
                        p();
                    } else {
                        this.e.m();
                        if (!s()) {
                            n();
                        } else if (!r()) {
                            WorkForegroundRunnable workForegroundRunnable = new WorkForegroundRunnable(this.f2109a, this.d, this.e, workerParameters.b(), this.f);
                            this.f.c().execute(workForegroundRunnable);
                            final ListenableFuture b3 = workForegroundRunnable.b();
                            this.q.addListener(new g(this, b3), new SynchronousExecutor());
                            b3.addListener(new Runnable() {
                                public void run() {
                                    if (!WorkerWrapper.this.q.isCancelled()) {
                                        try {
                                            b3.get();
                                            Logger e = Logger.e();
                                            String str = WorkerWrapper.s;
                                            e.a(str, "Starting work for " + WorkerWrapper.this.d.c);
                                            WorkerWrapper workerWrapper = WorkerWrapper.this;
                                            workerWrapper.q.q(workerWrapper.e.n());
                                        } catch (Throwable th) {
                                            WorkerWrapper.this.q.p(th);
                                        }
                                    }
                                }
                            }, this.f.c());
                            final String str5 = this.o;
                            this.q.addListener(new Runnable() {
                                public void run() {
                                    try {
                                        ListenableWorker.Result result = (ListenableWorker.Result) WorkerWrapper.this.q.get();
                                        if (result == null) {
                                            Logger e = Logger.e();
                                            String str = WorkerWrapper.s;
                                            e.c(str, WorkerWrapper.this.d.c + " returned a null result. Treating it as a failure.");
                                        } else {
                                            Logger e2 = Logger.e();
                                            String str2 = WorkerWrapper.s;
                                            e2.a(str2, WorkerWrapper.this.d.c + " returned a " + result + ".");
                                            WorkerWrapper.this.g = result;
                                        }
                                    } catch (CancellationException e3) {
                                        Logger e4 = Logger.e();
                                        String str3 = WorkerWrapper.s;
                                        e4.g(str3, str5 + " was cancelled", e3);
                                    } catch (InterruptedException | ExecutionException e5) {
                                        Logger e6 = Logger.e();
                                        String str4 = WorkerWrapper.s;
                                        e6.d(str4, str5 + " failed because it threw an exception/error", e5);
                                    } catch (Throwable th) {
                                        WorkerWrapper.this.j();
                                        throw th;
                                    }
                                    WorkerWrapper.this.j();
                                }
                            }, this.f.d());
                        }
                    }
                }
            } finally {
                this.k.endTransaction();
            }
        }
    }

    public void p() {
        this.k.beginTransaction();
        try {
            h(this.b);
            Data e2 = ((ListenableWorker.Result.Failure) this.g).e();
            this.l.t(this.b, this.d.f());
            this.l.D(this.b, e2);
            this.k.setTransactionSuccessful();
        } finally {
            this.k.endTransaction();
            m(false);
        }
    }

    public final void q() {
        this.k.beginTransaction();
        try {
            this.l.l(WorkInfo.State.SUCCEEDED, this.b);
            this.l.D(this.b, ((ListenableWorker.Result.Success) this.g).e());
            long currentTimeMillis = this.i.currentTimeMillis();
            for (String str : this.m.b(this.b)) {
                if (this.l.f(str) == WorkInfo.State.BLOCKED && this.m.c(str)) {
                    Logger e2 = Logger.e();
                    String str2 = s;
                    e2.f(str2, "Setting status to enqueued for " + str);
                    this.l.l(WorkInfo.State.ENQUEUED, str);
                    this.l.m(str, currentTimeMillis);
                }
            }
            this.k.setTransactionSuccessful();
            this.k.endTransaction();
            m(false);
        } catch (Throwable th) {
            this.k.endTransaction();
            m(false);
            throw th;
        }
    }

    public final boolean r() {
        if (this.r == -256) {
            return false;
        }
        Logger e2 = Logger.e();
        String str = s;
        e2.a(str, "Work interrupted for " + this.o);
        WorkInfo.State f2 = this.l.f(this.b);
        if (f2 == null) {
            m(false);
        } else {
            m(!f2.isFinished());
        }
        return true;
    }

    public void run() {
        this.o = b(this.n);
        o();
    }

    public final boolean s() {
        boolean z;
        this.k.beginTransaction();
        try {
            if (this.l.f(this.b) == WorkInfo.State.ENQUEUED) {
                this.l.l(WorkInfo.State.RUNNING, this.b);
                this.l.G(this.b);
                this.l.c(this.b, -256);
                z = true;
            } else {
                z = false;
            }
            this.k.setTransactionSuccessful();
            this.k.endTransaction();
            return z;
        } catch (Throwable th) {
            this.k.endTransaction();
            throw th;
        }
    }
}
