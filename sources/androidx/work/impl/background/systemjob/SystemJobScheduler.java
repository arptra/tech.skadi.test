package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Consumer;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoKt;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.IdGenerator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@RequiresApi
@RestrictTo
public class SystemJobScheduler implements Scheduler {
    public static final String f = Logger.i("SystemJobScheduler");

    /* renamed from: a  reason: collision with root package name */
    public final Context f2133a;
    public final JobScheduler b;
    public final SystemJobInfoConverter c;
    public final WorkDatabase d;
    public final Configuration e;

    public SystemJobScheduler(Context context, WorkDatabase workDatabase, Configuration configuration) {
        this(context, workDatabase, configuration, (JobScheduler) context.getSystemService("jobscheduler"), new SystemJobInfoConverter(context, configuration.a()));
    }

    public static void c(Context context) {
        List<JobInfo> f2;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null && (f2 = f(context, jobScheduler)) != null && !f2.isEmpty()) {
            for (JobInfo id : f2) {
                d(jobScheduler, id.getId());
            }
        }
    }

    public static void d(JobScheduler jobScheduler, int i) {
        try {
            jobScheduler.cancel(i);
        } catch (Throwable th) {
            Logger.e().d(f, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", new Object[]{Integer.valueOf(i)}), th);
        }
    }

    public static List e(Context context, JobScheduler jobScheduler, String str) {
        List<JobInfo> f2 = f(context, jobScheduler);
        if (f2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo jobInfo : f2) {
            WorkGenerationalId g = g(jobInfo);
            if (g != null && str.equals(g.b())) {
                arrayList.add(Integer.valueOf(jobInfo.getId()));
            }
        }
        return arrayList;
    }

    public static List f(Context context, JobScheduler jobScheduler) {
        List<JobInfo> list;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            Logger.e().d(f, "getAllPendingJobs() is not reliable on this device.", th);
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ComponentName componentName = new ComponentName(context, SystemJobService.class);
        for (JobInfo next : list) {
            if (componentName.equals(next.getService())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static WorkGenerationalId g(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (!extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new WorkGenerationalId(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION", 0));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public static boolean h(Context context, WorkDatabase workDatabase) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        List<JobInfo> f2 = f(context, jobScheduler);
        List<String> f3 = workDatabase.g().f();
        boolean z = false;
        HashSet hashSet = new HashSet(f2 != null ? f2.size() : 0);
        if (f2 != null && !f2.isEmpty()) {
            for (JobInfo jobInfo : f2) {
                WorkGenerationalId g = g(jobInfo);
                if (g != null) {
                    hashSet.add(g.b());
                } else {
                    d(jobScheduler, jobInfo.getId());
                }
            }
        }
        Iterator it = f3.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!hashSet.contains((String) it.next())) {
                    Logger.e().a(f, "Reconciling jobs");
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (z) {
            workDatabase.beginTransaction();
            try {
                WorkSpecDao j = workDatabase.j();
                for (String A : f3) {
                    j.A(A, -1);
                }
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
        return z;
    }

    public boolean a() {
        return true;
    }

    public void b(WorkSpec... workSpecArr) {
        IdGenerator idGenerator = new IdGenerator(this.d);
        int length = workSpecArr.length;
        int i = 0;
        while (i < length) {
            WorkSpec workSpec = workSpecArr[i];
            this.d.beginTransaction();
            try {
                WorkSpec y = this.d.j().y(workSpec.f2184a);
                if (y == null) {
                    Logger e2 = Logger.e();
                    String str = f;
                    e2.k(str, "Skipping scheduling " + workSpec.f2184a + " because it's no longer in the DB");
                    this.d.setTransactionSuccessful();
                } else if (y.b != WorkInfo.State.ENQUEUED) {
                    Logger e3 = Logger.e();
                    String str2 = f;
                    e3.k(str2, "Skipping scheduling " + workSpec.f2184a + " because it is no longer enqueued");
                    this.d.setTransactionSuccessful();
                } else {
                    WorkGenerationalId a2 = WorkSpecKt.a(workSpec);
                    SystemIdInfo e4 = this.d.g().e(a2);
                    int e5 = e4 != null ? e4.c : idGenerator.e(this.e.i(), this.e.g());
                    if (e4 == null) {
                        this.d.g().d(SystemIdInfoKt.a(a2, e5));
                    }
                    i(workSpec, e5);
                    this.d.setTransactionSuccessful();
                }
                i++;
            } finally {
                this.d.endTransaction();
            }
        }
    }

    public void cancel(String str) {
        List<Integer> e2 = e(this.f2133a, this.b, str);
        if (e2 != null && !e2.isEmpty()) {
            for (Integer intValue : e2) {
                d(this.b, intValue.intValue());
            }
            this.d.g().i(str);
        }
    }

    public void i(WorkSpec workSpec, int i) {
        JobInfo a2 = this.c.a(workSpec, i);
        Logger e2 = Logger.e();
        String str = f;
        e2.a(str, "Scheduling work ID " + workSpec.f2184a + "Job ID " + i);
        int i2 = 0;
        try {
            if (this.b.schedule(a2) == 0) {
                Logger e3 = Logger.e();
                e3.k(str, "Unable to schedule work ID " + workSpec.f2184a);
                if (workSpec.q && workSpec.r == OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST) {
                    workSpec.q = false;
                    Logger.e().a(str, String.format("Scheduling a non-expedited job (work ID %s)", new Object[]{workSpec.f2184a}));
                    i(workSpec, i);
                }
            }
        } catch (IllegalStateException e4) {
            List f2 = f(this.f2133a, this.b);
            if (f2 != null) {
                i2 = f2.size();
            }
            String format = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", new Object[]{Integer.valueOf(i2), Integer.valueOf(this.d.j().w().size()), Integer.valueOf(this.e.h())});
            Logger.e().c(f, format);
            IllegalStateException illegalStateException = new IllegalStateException(format, e4);
            Consumer l = this.e.l();
            if (l != null) {
                l.accept(illegalStateException);
                return;
            }
            throw illegalStateException;
        } catch (Throwable th) {
            Logger e5 = Logger.e();
            String str2 = f;
            e5.d(str2, "Unable to schedule " + workSpec, th);
        }
    }

    public SystemJobScheduler(Context context, WorkDatabase workDatabase, Configuration configuration, JobScheduler jobScheduler, SystemJobInfoConverter systemJobInfoConverter) {
        this.f2133a = context;
        this.b = jobScheduler;
        this.c = systemJobInfoConverter;
        this.d = workDatabase;
        this.e = configuration;
    }
}
