package androidx.work.impl.utils;

import androidx.annotation.RestrictTo;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpecDao;
import java.util.LinkedList;
import java.util.UUID;

@RestrictTo
public abstract class CancelWorkRunnable implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final OperationImpl f2227a = new OperationImpl();

    /* renamed from: androidx.work.impl.utils.CancelWorkRunnable$4  reason: invalid class name */
    class AnonymousClass4 extends CancelWorkRunnable {
        public final /* synthetic */ WorkManagerImpl b;

        public void h() {
            WorkDatabase p = this.b.p();
            p.beginTransaction();
            try {
                for (String a2 : p.j().n()) {
                    a(this.b, a2);
                }
                new PreferenceUtils(this.b.p()).e(this.b.i().a().currentTimeMillis());
                p.setTransactionSuccessful();
                p.endTransaction();
            } catch (Throwable th) {
                p.endTransaction();
                throw th;
            }
        }
    }

    public static CancelWorkRunnable b(final UUID uuid, final WorkManagerImpl workManagerImpl) {
        return new CancelWorkRunnable() {
            /* JADX INFO: finally extract failed */
            public void h() {
                WorkDatabase p = WorkManagerImpl.this.p();
                p.beginTransaction();
                try {
                    a(WorkManagerImpl.this, uuid.toString());
                    p.setTransactionSuccessful();
                    p.endTransaction();
                    g(WorkManagerImpl.this);
                } catch (Throwable th) {
                    p.endTransaction();
                    throw th;
                }
            }
        };
    }

    public static CancelWorkRunnable c(final String str, final WorkManagerImpl workManagerImpl, final boolean z) {
        return new CancelWorkRunnable() {
            public void h() {
                WorkDatabase p = WorkManagerImpl.this.p();
                p.beginTransaction();
                try {
                    for (String a2 : p.j().e(str)) {
                        a(WorkManagerImpl.this, a2);
                    }
                    p.setTransactionSuccessful();
                    p.endTransaction();
                    if (z) {
                        g(WorkManagerImpl.this);
                    }
                } catch (Throwable th) {
                    p.endTransaction();
                    throw th;
                }
            }
        };
    }

    public static CancelWorkRunnable d(final String str, final WorkManagerImpl workManagerImpl) {
        return new CancelWorkRunnable() {
            public void h() {
                WorkDatabase p = WorkManagerImpl.this.p();
                p.beginTransaction();
                try {
                    for (String a2 : p.j().h(str)) {
                        a(WorkManagerImpl.this, a2);
                    }
                    p.setTransactionSuccessful();
                    p.endTransaction();
                    g(WorkManagerImpl.this);
                } catch (Throwable th) {
                    p.endTransaction();
                    throw th;
                }
            }
        };
    }

    public void a(WorkManagerImpl workManagerImpl, String str) {
        f(workManagerImpl.p(), str);
        workManagerImpl.m().t(str, 1);
        for (Scheduler cancel : workManagerImpl.n()) {
            cancel.cancel(str);
        }
    }

    public Operation e() {
        return this.f2227a;
    }

    public final void f(WorkDatabase workDatabase, String str) {
        WorkSpecDao j = workDatabase.j();
        DependencyDao d = workDatabase.d();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            WorkInfo.State f = j.f(str2);
            if (!(f == WorkInfo.State.SUCCEEDED || f == WorkInfo.State.FAILED)) {
                j.g(str2);
            }
            linkedList.addAll(d.b(str2));
        }
    }

    public void g(WorkManagerImpl workManagerImpl) {
        Schedulers.h(workManagerImpl.i(), workManagerImpl.p(), workManagerImpl.n());
    }

    public abstract void h();

    public void run() {
        try {
            h();
            this.f2227a.a(Operation.f2064a);
        } catch (Throwable th) {
            this.f2227a.a(new Operation.State.FAILURE(th));
        }
    }
}
