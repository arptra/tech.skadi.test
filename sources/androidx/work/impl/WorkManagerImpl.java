package androidx.work.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.CancelWorkRunnable;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.LiveDataUtils;
import androidx.work.impl.utils.PreferenceUtils;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestrictTo
public class WorkManagerImpl extends WorkManager {
    public static final String k = Logger.i("WorkManagerImpl");
    public static WorkManagerImpl l = null;
    public static WorkManagerImpl m = null;
    public static final Object n = new Object();

    /* renamed from: a  reason: collision with root package name */
    public Context f2105a;
    public Configuration b;
    public WorkDatabase c;
    public TaskExecutor d;
    public List e;
    public Processor f;
    public PreferenceUtils g;
    public boolean h = false;
    public BroadcastReceiver.PendingResult i;
    public final Trackers j;

    /* renamed from: androidx.work.impl.WorkManagerImpl$1  reason: invalid class name */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SettableFuture f2106a;
        public final /* synthetic */ PreferenceUtils b;

        public void run() {
            try {
                this.f2106a.o(Long.valueOf(this.b.a()));
            } catch (Throwable th) {
                this.f2106a.p(th);
            }
        }
    }

    @RequiresApi
    public static class Api24Impl {
        @DoNotInline
        public static boolean a(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    public WorkManagerImpl(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, List list, Processor processor, Trackers trackers) {
        Context applicationContext = context.getApplicationContext();
        if (!Api24Impl.a(applicationContext)) {
            Logger.h(new Logger.LogcatLogger(configuration.j()));
            this.f2105a = applicationContext;
            this.d = taskExecutor;
            this.c = workDatabase;
            this.f = processor;
            this.j = trackers;
            this.b = configuration;
            this.e = list;
            this.g = new PreferenceUtils(workDatabase);
            Schedulers.g(list, this.f, taskExecutor.d(), this.c, configuration);
            this.d.b(new ForceStopRunnable(applicationContext, this));
            return;
        }
        throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
    }

    public static void f(Context context, Configuration configuration) {
        synchronized (n) {
            try {
                WorkManagerImpl workManagerImpl = l;
                if (workManagerImpl != null) {
                    if (m != null) {
                        throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                    }
                }
                if (workManagerImpl == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (m == null) {
                        m = WorkManagerImplExtKt.c(applicationContext, configuration);
                    }
                    l = m;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static WorkManagerImpl j() {
        synchronized (n) {
            try {
                WorkManagerImpl workManagerImpl = l;
                if (workManagerImpl != null) {
                    return workManagerImpl;
                }
                WorkManagerImpl workManagerImpl2 = m;
                return workManagerImpl2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static WorkManagerImpl k(Context context) {
        WorkManagerImpl j2;
        synchronized (n) {
            try {
                j2 = j();
                if (j2 == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext instanceof Configuration.Provider) {
                        f(applicationContext, ((Configuration.Provider) applicationContext).a());
                        j2 = k(applicationContext);
                    } else {
                        throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return j2;
    }

    public Operation a(String str) {
        CancelWorkRunnable d2 = CancelWorkRunnable.d(str, this);
        this.d.b(d2);
        return d2.e();
    }

    public Operation c(List list) {
        if (!list.isEmpty()) {
            return new WorkContinuationImpl(this, list).a();
        }
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }

    public LiveData e(UUID uuid) {
        return LiveDataUtils.a(this.c.j().r(Collections.singletonList(uuid.toString())), new Function<List<WorkSpec.WorkInfoPojo>, WorkInfo>() {
            /* renamed from: a */
            public WorkInfo apply(List list) {
                if (list == null || list.size() <= 0) {
                    return null;
                }
                return ((WorkSpec.WorkInfoPojo) list.get(0)).e();
            }
        }, this.d);
    }

    public Operation g(UUID uuid) {
        CancelWorkRunnable b2 = CancelWorkRunnable.b(uuid, this);
        this.d.b(b2);
        return b2.e();
    }

    public Context h() {
        return this.f2105a;
    }

    public Configuration i() {
        return this.b;
    }

    public PreferenceUtils l() {
        return this.g;
    }

    public Processor m() {
        return this.f;
    }

    public List n() {
        return this.e;
    }

    public Trackers o() {
        return this.j;
    }

    public WorkDatabase p() {
        return this.c;
    }

    public TaskExecutor q() {
        return this.d;
    }

    public void r() {
        synchronized (n) {
            try {
                this.h = true;
                BroadcastReceiver.PendingResult pendingResult = this.i;
                if (pendingResult != null) {
                    pendingResult.finish();
                    this.i = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void s() {
        SystemJobScheduler.c(h());
        p().j().z();
        Schedulers.h(i(), p(), n());
    }

    public void t(BroadcastReceiver.PendingResult pendingResult) {
        synchronized (n) {
            try {
                BroadcastReceiver.PendingResult pendingResult2 = this.i;
                if (pendingResult2 != null) {
                    pendingResult2.finish();
                }
                this.i = pendingResult;
                if (this.h) {
                    pendingResult.finish();
                    this.i = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void u(WorkGenerationalId workGenerationalId) {
        this.d.b(new StopWorkRunnable(this.f, new StartStopToken(workGenerationalId), true));
    }
}
