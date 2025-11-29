package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001BS\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0016\u0010\u0012R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0017\u0010\u0012¨\u0006\u0018"}, d2 = {"Landroidx/work/impl/constraints/trackers/Trackers;", "", "Landroid/content/Context;", "context", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "taskExecutor", "Landroidx/work/impl/constraints/trackers/ConstraintTracker;", "", "batteryChargingTracker", "Landroidx/work/impl/constraints/trackers/BatteryNotLowTracker;", "batteryNotLowTracker", "Landroidx/work/impl/constraints/NetworkState;", "networkStateTracker", "storageNotLowTracker", "<init>", "(Landroid/content/Context;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;Landroidx/work/impl/constraints/trackers/ConstraintTracker;Landroidx/work/impl/constraints/trackers/BatteryNotLowTracker;Landroidx/work/impl/constraints/trackers/ConstraintTracker;Landroidx/work/impl/constraints/trackers/ConstraintTracker;)V", "a", "Landroidx/work/impl/constraints/trackers/ConstraintTracker;", "()Landroidx/work/impl/constraints/trackers/ConstraintTracker;", "b", "Landroidx/work/impl/constraints/trackers/BatteryNotLowTracker;", "()Landroidx/work/impl/constraints/trackers/BatteryNotLowTracker;", "c", "d", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
@RestrictTo
public final class Trackers {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintTracker f2153a;
    public final BatteryNotLowTracker b;
    public final ConstraintTracker c;
    public final ConstraintTracker d;

    public Trackers(Context context, TaskExecutor taskExecutor, ConstraintTracker constraintTracker, BatteryNotLowTracker batteryNotLowTracker, ConstraintTracker constraintTracker2, ConstraintTracker constraintTracker3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(taskExecutor, "taskExecutor");
        Intrinsics.checkNotNullParameter(constraintTracker, "batteryChargingTracker");
        Intrinsics.checkNotNullParameter(batteryNotLowTracker, "batteryNotLowTracker");
        Intrinsics.checkNotNullParameter(constraintTracker2, "networkStateTracker");
        Intrinsics.checkNotNullParameter(constraintTracker3, "storageNotLowTracker");
        this.f2153a = constraintTracker;
        this.b = batteryNotLowTracker;
        this.c = constraintTracker2;
        this.d = constraintTracker3;
    }

    public final ConstraintTracker a() {
        return this.f2153a;
    }

    public final BatteryNotLowTracker b() {
        return this.b;
    }

    public final ConstraintTracker c() {
        return this.c;
    }

    public final ConstraintTracker d() {
        return this.d;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Trackers(android.content.Context r8, androidx.work.impl.utils.taskexecutor.TaskExecutor r9, androidx.work.impl.constraints.trackers.ConstraintTracker r10, androidx.work.impl.constraints.trackers.BatteryNotLowTracker r11, androidx.work.impl.constraints.trackers.ConstraintTracker r12, androidx.work.impl.constraints.trackers.ConstraintTracker r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r7 = this;
            r0 = r14 & 4
            java.lang.String r1 = "context.applicationContext"
            if (r0 == 0) goto L_0x0014
            androidx.work.impl.constraints.trackers.BatteryChargingTracker r0 = new androidx.work.impl.constraints.trackers.BatteryChargingTracker
            android.content.Context r3 = r8.getApplicationContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)
            r0.<init>(r3, r9)
            r3 = r0
            goto L_0x0015
        L_0x0014:
            r3 = r10
        L_0x0015:
            r0 = r14 & 8
            if (r0 == 0) goto L_0x0027
            androidx.work.impl.constraints.trackers.BatteryNotLowTracker r0 = new androidx.work.impl.constraints.trackers.BatteryNotLowTracker
            android.content.Context r4 = r8.getApplicationContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            r0.<init>(r4, r9)
            r4 = r0
            goto L_0x0028
        L_0x0027:
            r4 = r11
        L_0x0028:
            r0 = r14 & 16
            if (r0 == 0) goto L_0x0039
            android.content.Context r0 = r8.getApplicationContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            androidx.work.impl.constraints.trackers.ConstraintTracker r0 = androidx.work.impl.constraints.trackers.NetworkStateTrackerKt.a(r0, r9)
            r5 = r0
            goto L_0x003a
        L_0x0039:
            r5 = r12
        L_0x003a:
            r0 = r14 & 32
            if (r0 == 0) goto L_0x004c
            androidx.work.impl.constraints.trackers.StorageNotLowTracker r0 = new androidx.work.impl.constraints.trackers.StorageNotLowTracker
            android.content.Context r6 = r8.getApplicationContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
            r0.<init>(r6, r9)
            r6 = r0
            goto L_0x004d
        L_0x004c:
            r6 = r13
        L_0x004d:
            r0 = r7
            r1 = r8
            r2 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.constraints.trackers.Trackers.<init>(android.content.Context, androidx.work.impl.utils.taskexecutor.TaskExecutor, androidx.work.impl.constraints.trackers.ConstraintTracker, androidx.work.impl.constraints.trackers.BatteryNotLowTracker, androidx.work.impl.constraints.trackers.ConstraintTracker, androidx.work.impl.constraints.trackers.ConstraintTracker, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
