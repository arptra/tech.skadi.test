package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Landroidx/work/impl/constraints/trackers/StorageNotLowTracker;", "Landroidx/work/impl/constraints/trackers/BroadcastReceiverConstraintTracker;", "", "Landroid/content/Context;", "context", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "taskExecutor", "<init>", "(Landroid/content/Context;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;)V", "l", "()Ljava/lang/Boolean;", "Landroid/content/Intent;", "intent", "", "k", "(Landroid/content/Intent;)V", "Landroid/content/IntentFilter;", "j", "()Landroid/content/IntentFilter;", "intentFilter", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
@RestrictTo
public final class StorageNotLowTracker extends BroadcastReceiverConstraintTracker<Boolean> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StorageNotLowTracker(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(taskExecutor, "taskExecutor");
    }

    public IntentFilter j() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        return intentFilter;
    }

    public void k(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent.getAction() != null) {
            Logger e = Logger.e();
            String a2 = StorageNotLowTrackerKt.f2152a;
            e.a(a2, "Received " + intent.getAction());
            String action = intent.getAction();
            if (action != null) {
                int hashCode = action.hashCode();
                if (hashCode != -1181163412) {
                    if (hashCode == -730838620 && action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                        g(Boolean.TRUE);
                    }
                } else if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
                    g(Boolean.FALSE);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0033, code lost:
        if (r4.equals("android.intent.action.DEVICE_STORAGE_OK") == false) goto L_0x003c;
     */
    /* renamed from: l */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Boolean e() {
        /*
            r4 = this;
            android.content.Context r0 = r4.d()
            r1 = 0
            android.content.IntentFilter r4 = r4.j()
            android.content.Intent r4 = r0.registerReceiver(r1, r4)
            r0 = 1
            if (r4 == 0) goto L_0x003d
            java.lang.String r1 = r4.getAction()
            if (r1 != 0) goto L_0x0017
            goto L_0x003d
        L_0x0017:
            java.lang.String r4 = r4.getAction()
            r1 = 0
            if (r4 == 0) goto L_0x003c
            int r2 = r4.hashCode()
            r3 = -1181163412(0xffffffffb998e06c, float:-2.9158907E-4)
            if (r2 == r3) goto L_0x0036
            r3 = -730838620(0xffffffffd47049a4, float:-4.12811054E12)
            if (r2 == r3) goto L_0x002d
            goto L_0x003c
        L_0x002d:
            java.lang.String r2 = "android.intent.action.DEVICE_STORAGE_OK"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L_0x003d
            goto L_0x003c
        L_0x0036:
            java.lang.String r0 = "android.intent.action.DEVICE_STORAGE_LOW"
            boolean r4 = r4.equals(r0)
        L_0x003c:
            r0 = r1
        L_0x003d:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.constraints.trackers.StorageNotLowTracker.e():java.lang.Boolean");
    }
}
