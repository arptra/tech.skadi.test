package androidx.work.impl.utils;

import androidx.annotation.RestrictTo;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import java.util.List;
import java.util.UUID;

@RestrictTo
public abstract class StatusRunnable<T> implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final SettableFuture f2241a;

    /* renamed from: androidx.work.impl.utils.StatusRunnable$1  reason: invalid class name */
    class AnonymousClass1 extends StatusRunnable<List<WorkInfo>> {
        public final /* synthetic */ WorkManagerImpl b;
        public final /* synthetic */ List c;

        /* renamed from: b */
        public List a() {
            return (List) WorkSpec.z.apply(this.b.p().j().H(this.c));
        }
    }

    /* renamed from: androidx.work.impl.utils.StatusRunnable$2  reason: invalid class name */
    class AnonymousClass2 extends StatusRunnable<WorkInfo> {
        public final /* synthetic */ WorkManagerImpl b;
        public final /* synthetic */ UUID c;

        /* renamed from: b */
        public WorkInfo a() {
            WorkSpec.WorkInfoPojo x = this.b.p().j().x(this.c.toString());
            if (x != null) {
                return x.e();
            }
            return null;
        }
    }

    /* renamed from: androidx.work.impl.utils.StatusRunnable$3  reason: invalid class name */
    class AnonymousClass3 extends StatusRunnable<List<WorkInfo>> {
        public final /* synthetic */ WorkManagerImpl b;
        public final /* synthetic */ String c;

        /* renamed from: b */
        public List a() {
            return (List) WorkSpec.z.apply(this.b.p().j().F(this.c));
        }
    }

    /* renamed from: androidx.work.impl.utils.StatusRunnable$4  reason: invalid class name */
    class AnonymousClass4 extends StatusRunnable<List<WorkInfo>> {
        public final /* synthetic */ WorkManagerImpl b;
        public final /* synthetic */ String c;

        /* renamed from: b */
        public List a() {
            return (List) WorkSpec.z.apply(this.b.p().j().j(this.c));
        }
    }

    /* renamed from: androidx.work.impl.utils.StatusRunnable$5  reason: invalid class name */
    class AnonymousClass5 extends StatusRunnable<List<WorkInfo>> {
        public final /* synthetic */ WorkManagerImpl b;
        public final /* synthetic */ WorkQuery c;

        /* renamed from: b */
        public List a() {
            return (List) WorkSpec.z.apply(this.b.p().f().a(RawQueries.b(this.c)));
        }
    }

    public abstract Object a();

    public void run() {
        try {
            this.f2241a.o(a());
        } catch (Throwable th) {
            this.f2241a.p(th);
        }
    }
}
