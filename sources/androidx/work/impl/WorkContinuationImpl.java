package androidx.work.impl;

import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.WorkContinuation;
import androidx.work.WorkRequest;
import androidx.work.impl.utils.EnqueueRunnable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.LongCompanionObject;

@RestrictTo
public class WorkContinuationImpl extends WorkContinuation {
    public static final String j = Logger.i("WorkContinuationImpl");

    /* renamed from: a  reason: collision with root package name */
    public final WorkManagerImpl f2095a;
    public final String b;
    public final ExistingWorkPolicy c;
    public final List d;
    public final List e;
    public final List f;
    public final List g;
    public boolean h;
    public Operation i;

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, List list) {
        this(workManagerImpl, (String) null, ExistingWorkPolicy.KEEP, list, (List) null);
    }

    public static boolean i(WorkContinuationImpl workContinuationImpl, Set set) {
        set.addAll(workContinuationImpl.c());
        Set l = l(workContinuationImpl);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (l.contains((String) it.next())) {
                return true;
            }
        }
        List<WorkContinuationImpl> e2 = workContinuationImpl.e();
        if (e2 != null && !e2.isEmpty()) {
            for (WorkContinuationImpl i2 : e2) {
                if (i(i2, set)) {
                    return true;
                }
            }
        }
        set.removeAll(workContinuationImpl.c());
        return false;
    }

    public static Set l(WorkContinuationImpl workContinuationImpl) {
        HashSet hashSet = new HashSet();
        List<WorkContinuationImpl> e2 = workContinuationImpl.e();
        if (e2 != null && !e2.isEmpty()) {
            for (WorkContinuationImpl c2 : e2) {
                hashSet.addAll(c2.c());
            }
        }
        return hashSet;
    }

    public Operation a() {
        if (!this.h) {
            EnqueueRunnable enqueueRunnable = new EnqueueRunnable(this);
            this.f2095a.q().b(enqueueRunnable);
            this.i = enqueueRunnable.d();
        } else {
            Logger e2 = Logger.e();
            String str = j;
            e2.k(str, "Already enqueued work ids (" + TextUtils.join(", ", this.e) + ")");
        }
        return this.i;
    }

    public ExistingWorkPolicy b() {
        return this.c;
    }

    public List c() {
        return this.e;
    }

    public String d() {
        return this.b;
    }

    public List e() {
        return this.g;
    }

    public List f() {
        return this.d;
    }

    public WorkManagerImpl g() {
        return this.f2095a;
    }

    public boolean h() {
        return i(this, new HashSet());
    }

    public boolean j() {
        return this.h;
    }

    public void k() {
        this.h = true;
    }

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, String str, ExistingWorkPolicy existingWorkPolicy, List list) {
        this(workManagerImpl, str, existingWorkPolicy, list, (List) null);
    }

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, String str, ExistingWorkPolicy existingWorkPolicy, List list, List list2) {
        this.f2095a = workManagerImpl;
        this.b = str;
        this.c = existingWorkPolicy;
        this.d = list;
        this.g = list2;
        this.e = new ArrayList(list.size());
        this.f = new ArrayList();
        if (list2 != null) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                this.f.addAll(((WorkContinuationImpl) it.next()).f);
            }
        }
        int i2 = 0;
        while (i2 < list.size()) {
            if (existingWorkPolicy != ExistingWorkPolicy.REPLACE || ((WorkRequest) list.get(i2)).d().e() == LongCompanionObject.MAX_VALUE) {
                String b2 = ((WorkRequest) list.get(i2)).b();
                this.e.add(b2);
                this.f.add(b2);
                i2++;
            } else {
                throw new IllegalArgumentException("Next Schedule Time Override must be used with ExistingPeriodicWorkPolicyUPDATE (preferably) or KEEP");
            }
        }
    }
}
