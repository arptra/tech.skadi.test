package androidx.work.impl;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.Clock;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.PackageManagerHelper;
import com.honey.account.j0.d;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

@RestrictTo
public class Schedulers {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2092a = Logger.i("Schedulers");

    public static Scheduler c(Context context, WorkDatabase workDatabase, Configuration configuration) {
        SystemJobScheduler systemJobScheduler = new SystemJobScheduler(context, workDatabase, configuration);
        PackageManagerHelper.c(context, SystemJobService.class, true);
        Logger.e().a(f2092a, "Created SystemJobScheduler and enabled SystemJobService");
        return systemJobScheduler;
    }

    public static /* synthetic */ void d(List list, WorkGenerationalId workGenerationalId, Configuration configuration, WorkDatabase workDatabase) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Scheduler) it.next()).cancel(workGenerationalId.b());
        }
        h(configuration, workDatabase, list);
    }

    public static void f(WorkSpecDao workSpecDao, Clock clock, List list) {
        if (list.size() > 0) {
            long currentTimeMillis = clock.currentTimeMillis();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                workSpecDao.A(((WorkSpec) it.next()).f2184a, currentTimeMillis);
            }
        }
    }

    public static void g(List list, Processor processor, Executor executor, WorkDatabase workDatabase, Configuration configuration) {
        processor.e(new d(executor, list, configuration, workDatabase));
    }

    public static void h(Configuration configuration, WorkDatabase workDatabase, List list) {
        if (list != null && list.size() != 0) {
            WorkSpecDao j = workDatabase.j();
            workDatabase.beginTransaction();
            try {
                List p = j.p();
                f(j, configuration.a(), p);
                List C = j.C(configuration.h());
                f(j, configuration.a(), C);
                if (p != null) {
                    C.addAll(p);
                }
                List k = j.k(200);
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
                if (C.size() > 0) {
                    WorkSpec[] workSpecArr = (WorkSpec[]) C.toArray(new WorkSpec[C.size()]);
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        Scheduler scheduler = (Scheduler) it.next();
                        if (scheduler.a()) {
                            scheduler.b(workSpecArr);
                        }
                    }
                }
                if (k.size() > 0) {
                    WorkSpec[] workSpecArr2 = (WorkSpec[]) k.toArray(new WorkSpec[k.size()]);
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        Scheduler scheduler2 = (Scheduler) it2.next();
                        if (!scheduler2.a()) {
                            scheduler2.b(workSpecArr2);
                        }
                    }
                }
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }
}
