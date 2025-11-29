package androidx.work.impl.utils;

import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import java.util.List;

@RestrictTo
public class EnqueueRunnable implements Runnable {
    public static final String c = Logger.i("EnqueueRunnable");

    /* renamed from: a  reason: collision with root package name */
    public final WorkContinuationImpl f2228a;
    public final OperationImpl b;

    public EnqueueRunnable(WorkContinuationImpl workContinuationImpl) {
        this(workContinuationImpl, new OperationImpl());
    }

    public static boolean b(WorkContinuationImpl workContinuationImpl) {
        boolean c2 = c(workContinuationImpl.g(), workContinuationImpl.f(), (String[]) WorkContinuationImpl.l(workContinuationImpl).toArray(new String[0]), workContinuationImpl.d(), workContinuationImpl.b());
        workContinuationImpl.k();
        return c2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0163  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean c(androidx.work.impl.WorkManagerImpl r18, java.util.List r19, java.lang.String[] r20, java.lang.String r21, androidx.work.ExistingWorkPolicy r22) {
        /*
            r0 = r20
            r1 = r21
            r2 = r22
            androidx.work.Configuration r3 = r18.i()
            androidx.work.Clock r3 = r3.a()
            long r3 = r3.currentTimeMillis()
            androidx.work.impl.WorkDatabase r5 = r18.p()
            r6 = 1
            r7 = 0
            if (r0 == 0) goto L_0x001f
            int r8 = r0.length
            if (r8 <= 0) goto L_0x001f
            r8 = r6
            goto L_0x0020
        L_0x001f:
            r8 = r7
        L_0x0020:
            if (r8 == 0) goto L_0x006d
            int r9 = r0.length
            r11 = r6
            r10 = r7
            r12 = r10
            r13 = r12
        L_0x0027:
            if (r10 >= r9) goto L_0x0070
            r14 = r0[r10]
            androidx.work.impl.model.WorkSpecDao r15 = r5.j()
            androidx.work.impl.model.WorkSpec r15 = r15.y(r14)
            if (r15 != 0) goto L_0x0055
            androidx.work.Logger r0 = androidx.work.Logger.e()
            java.lang.String r1 = c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Prerequisite "
            r2.append(r3)
            r2.append(r14)
            java.lang.String r3 = " doesn't exist; not enqueuing"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.c(r1, r2)
            return r7
        L_0x0055:
            androidx.work.WorkInfo$State r14 = r15.b
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.SUCCEEDED
            if (r14 != r15) goto L_0x005d
            r15 = r6
            goto L_0x005e
        L_0x005d:
            r15 = r7
        L_0x005e:
            r11 = r11 & r15
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.FAILED
            if (r14 != r15) goto L_0x0065
            r13 = r6
            goto L_0x006a
        L_0x0065:
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.CANCELLED
            if (r14 != r15) goto L_0x006a
            r12 = r6
        L_0x006a:
            int r10 = r10 + 1
            goto L_0x0027
        L_0x006d:
            r11 = r6
            r12 = r7
            r13 = r12
        L_0x0070:
            boolean r9 = android.text.TextUtils.isEmpty(r21)
            r9 = r9 ^ r6
            if (r9 == 0) goto L_0x0156
            if (r8 != 0) goto L_0x0156
            androidx.work.impl.model.WorkSpecDao r10 = r5.j()
            java.util.List r10 = r10.B(r1)
            boolean r14 = r10.isEmpty()
            if (r14 != 0) goto L_0x0156
            androidx.work.ExistingWorkPolicy r14 = androidx.work.ExistingWorkPolicy.APPEND
            if (r2 == r14) goto L_0x008f
            androidx.work.ExistingWorkPolicy r14 = androidx.work.ExistingWorkPolicy.APPEND_OR_REPLACE
            if (r2 != r14) goto L_0x0092
        L_0x008f:
            r14 = r18
            goto L_0x00d4
        L_0x0092:
            androidx.work.ExistingWorkPolicy r14 = androidx.work.ExistingWorkPolicy.KEEP
            if (r2 != r14) goto L_0x00b1
            java.util.Iterator r2 = r10.iterator()
        L_0x009a:
            boolean r14 = r2.hasNext()
            if (r14 == 0) goto L_0x00b1
            java.lang.Object r14 = r2.next()
            androidx.work.impl.model.WorkSpec$IdAndState r14 = (androidx.work.impl.model.WorkSpec.IdAndState) r14
            androidx.work.WorkInfo$State r14 = r14.b
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.ENQUEUED
            if (r14 == r15) goto L_0x00b0
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.RUNNING
            if (r14 != r15) goto L_0x009a
        L_0x00b0:
            return r7
        L_0x00b1:
            r14 = r18
            androidx.work.impl.utils.CancelWorkRunnable r2 = androidx.work.impl.utils.CancelWorkRunnable.c(r1, r14, r7)
            r2.run()
            androidx.work.impl.model.WorkSpecDao r2 = r5.j()
            java.util.Iterator r10 = r10.iterator()
        L_0x00c2:
            boolean r15 = r10.hasNext()
            if (r15 == 0) goto L_0x0159
            java.lang.Object r15 = r10.next()
            androidx.work.impl.model.WorkSpec$IdAndState r15 = (androidx.work.impl.model.WorkSpec.IdAndState) r15
            java.lang.String r15 = r15.f2185a
            r2.a(r15)
            goto L_0x00c2
        L_0x00d4:
            androidx.work.impl.model.DependencyDao r8 = r5.d()
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.Iterator r10 = r10.iterator()
        L_0x00e1:
            boolean r16 = r10.hasNext()
            if (r16 == 0) goto L_0x011c
            java.lang.Object r16 = r10.next()
            r6 = r16
            androidx.work.impl.model.WorkSpec$IdAndState r6 = (androidx.work.impl.model.WorkSpec.IdAndState) r6
            java.lang.String r7 = r6.f2185a
            boolean r7 = r8.d(r7)
            if (r7 != 0) goto L_0x0115
            androidx.work.WorkInfo$State r7 = r6.b
            r17 = r8
            androidx.work.WorkInfo$State r8 = androidx.work.WorkInfo.State.SUCCEEDED
            if (r7 != r8) goto L_0x0101
            r8 = 1
            goto L_0x0102
        L_0x0101:
            r8 = 0
        L_0x0102:
            r8 = r8 & r11
            androidx.work.WorkInfo$State r11 = androidx.work.WorkInfo.State.FAILED
            if (r7 != r11) goto L_0x0109
            r13 = 1
            goto L_0x010e
        L_0x0109:
            androidx.work.WorkInfo$State r11 = androidx.work.WorkInfo.State.CANCELLED
            if (r7 != r11) goto L_0x010e
            r12 = 1
        L_0x010e:
            java.lang.String r6 = r6.f2185a
            r15.add(r6)
            r11 = r8
            goto L_0x0117
        L_0x0115:
            r17 = r8
        L_0x0117:
            r8 = r17
            r6 = 1
            r7 = 0
            goto L_0x00e1
        L_0x011c:
            androidx.work.ExistingWorkPolicy r6 = androidx.work.ExistingWorkPolicy.APPEND_OR_REPLACE
            if (r2 != r6) goto L_0x0148
            if (r12 != 0) goto L_0x0124
            if (r13 == 0) goto L_0x0148
        L_0x0124:
            androidx.work.impl.model.WorkSpecDao r2 = r5.j()
            java.util.List r6 = r2.B(r1)
            java.util.Iterator r6 = r6.iterator()
        L_0x0130:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0142
            java.lang.Object r7 = r6.next()
            androidx.work.impl.model.WorkSpec$IdAndState r7 = (androidx.work.impl.model.WorkSpec.IdAndState) r7
            java.lang.String r7 = r7.f2185a
            r2.a(r7)
            goto L_0x0130
        L_0x0142:
            java.util.List r15 = java.util.Collections.emptyList()
            r12 = 0
            r13 = 0
        L_0x0148:
            java.lang.Object[] r0 = r15.toArray(r0)
            java.lang.String[] r0 = (java.lang.String[]) r0
            int r2 = r0.length
            if (r2 <= 0) goto L_0x0153
            r8 = 1
            goto L_0x0154
        L_0x0153:
            r8 = 0
        L_0x0154:
            r6 = 0
            goto L_0x0159
        L_0x0156:
            r14 = r18
            goto L_0x0154
        L_0x0159:
            java.util.Iterator r2 = r19.iterator()
        L_0x015d:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x01ea
            java.lang.Object r7 = r2.next()
            androidx.work.WorkRequest r7 = (androidx.work.WorkRequest) r7
            androidx.work.impl.model.WorkSpec r10 = r7.d()
            if (r8 == 0) goto L_0x0184
            if (r11 != 0) goto L_0x0184
            if (r13 == 0) goto L_0x0178
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.FAILED
            r10.b = r15
            goto L_0x0186
        L_0x0178:
            if (r12 == 0) goto L_0x017f
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.CANCELLED
            r10.b = r15
            goto L_0x0186
        L_0x017f:
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.BLOCKED
            r10.b = r15
            goto L_0x0186
        L_0x0184:
            r10.n = r3
        L_0x0186:
            androidx.work.WorkInfo$State r15 = r10.b
            r19 = r2
            androidx.work.WorkInfo$State r2 = androidx.work.WorkInfo.State.ENQUEUED
            if (r15 != r2) goto L_0x018f
            r6 = 1
        L_0x018f:
            androidx.work.impl.model.WorkSpecDao r2 = r5.j()
            java.util.List r15 = r18.n()
            androidx.work.impl.model.WorkSpec r10 = androidx.work.impl.utils.EnqueueUtilsKt.b(r15, r10)
            r2.d(r10)
            if (r8 == 0) goto L_0x01c1
            int r2 = r0.length
            r10 = 0
        L_0x01a2:
            if (r10 >= r2) goto L_0x01c1
            r15 = r0[r10]
            r17 = r0
            androidx.work.impl.model.Dependency r0 = new androidx.work.impl.model.Dependency
            r20 = r2
            java.lang.String r2 = r7.b()
            r0.<init>(r2, r15)
            androidx.work.impl.model.DependencyDao r2 = r5.d()
            r2.a(r0)
            int r10 = r10 + 1
            r2 = r20
            r0 = r17
            goto L_0x01a2
        L_0x01c1:
            r17 = r0
            androidx.work.impl.model.WorkTagDao r0 = r5.k()
            java.lang.String r2 = r7.b()
            java.util.Set r10 = r7.c()
            r0.b(r2, r10)
            if (r9 == 0) goto L_0x01e4
            androidx.work.impl.model.WorkNameDao r0 = r5.h()
            androidx.work.impl.model.WorkName r2 = new androidx.work.impl.model.WorkName
            java.lang.String r7 = r7.b()
            r2.<init>(r1, r7)
            r0.a(r2)
        L_0x01e4:
            r2 = r19
            r0 = r17
            goto L_0x015d
        L_0x01ea:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.EnqueueRunnable.c(androidx.work.impl.WorkManagerImpl, java.util.List, java.lang.String[], java.lang.String, androidx.work.ExistingWorkPolicy):boolean");
    }

    public static boolean e(WorkContinuationImpl workContinuationImpl) {
        List<WorkContinuationImpl> e = workContinuationImpl.e();
        boolean z = false;
        if (e != null) {
            for (WorkContinuationImpl workContinuationImpl2 : e) {
                if (!workContinuationImpl2.j()) {
                    z |= e(workContinuationImpl2);
                } else {
                    Logger e2 = Logger.e();
                    String str = c;
                    e2.k(str, "Already enqueued work ids (" + TextUtils.join(", ", workContinuationImpl2.c()) + ")");
                }
            }
        }
        return b(workContinuationImpl) | z;
    }

    public boolean a() {
        WorkManagerImpl g = this.f2228a.g();
        WorkDatabase p = g.p();
        p.beginTransaction();
        try {
            EnqueueUtilsKt.a(p, g.i(), this.f2228a);
            boolean e = e(this.f2228a);
            p.setTransactionSuccessful();
            return e;
        } finally {
            p.endTransaction();
        }
    }

    public Operation d() {
        return this.b;
    }

    public void f() {
        WorkManagerImpl g = this.f2228a.g();
        Schedulers.h(g.i(), g.p(), g.n());
    }

    public void run() {
        try {
            if (!this.f2228a.h()) {
                if (a()) {
                    PackageManagerHelper.c(this.f2228a.g().h(), RescheduleReceiver.class, true);
                    f();
                }
                this.b.a(Operation.f2064a);
                return;
            }
            throw new IllegalStateException("WorkContinuation has cycles (" + this.f2228a + ")");
        } catch (Throwable th) {
            this.b.a(new Operation.State.FAILURE(th));
        }
    }

    public EnqueueRunnable(WorkContinuationImpl workContinuationImpl, OperationImpl operationImpl) {
        this.f2228a = workContinuationImpl;
        this.b = operationImpl;
    }
}
