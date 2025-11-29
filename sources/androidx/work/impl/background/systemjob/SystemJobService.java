package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.net.Network;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkLauncher;
import androidx.work.impl.WorkLauncherImpl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkGenerationalId;
import com.upuphone.runasone.uupcast.CastErrorCode;
import java.util.HashMap;
import java.util.Map;

@RequiresApi
@RestrictTo
public class SystemJobService extends JobService implements ExecutionListener {
    public static final String e = Logger.i("SystemJobService");

    /* renamed from: a  reason: collision with root package name */
    public WorkManagerImpl f2134a;
    public final Map b = new HashMap();
    public final StartStopTokens c = new StartStopTokens();
    public WorkLauncher d;

    @RequiresApi
    public static class Api24Impl {
        @DoNotInline
        public static String[] a(JobParameters jobParameters) {
            return jobParameters.getTriggeredContentAuthorities();
        }

        @DoNotInline
        public static Uri[] b(JobParameters jobParameters) {
            return jobParameters.getTriggeredContentUris();
        }
    }

    @RequiresApi
    public static class Api28Impl {
        @DoNotInline
        public static Network a(JobParameters jobParameters) {
            return jobParameters.getNetwork();
        }
    }

    @RequiresApi
    public static class Api31Impl {
        @DoNotInline
        public static int a(JobParameters jobParameters) {
            return SystemJobService.a(jobParameters.getStopReason());
        }
    }

    public static int a(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return i;
            default:
                return CastErrorCode.SOURCE_PEER_DEVICE_NOT_ATTACHED;
        }
    }

    public static WorkGenerationalId b(JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new WorkGenerationalId(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION"));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public void c(WorkGenerationalId workGenerationalId, boolean z) {
        JobParameters jobParameters;
        Logger e2 = Logger.e();
        String str = e;
        e2.a(str, workGenerationalId.b() + " executed on JobScheduler");
        synchronized (this.b) {
            jobParameters = (JobParameters) this.b.remove(workGenerationalId);
        }
        this.c.b(workGenerationalId);
        if (jobParameters != null) {
            jobFinished(jobParameters, z);
        }
    }

    public void onCreate() {
        super.onCreate();
        try {
            WorkManagerImpl k = WorkManagerImpl.k(getApplicationContext());
            this.f2134a = k;
            Processor m = k.m();
            this.d = new WorkLauncherImpl(m, this.f2134a.q());
            m.e(this);
        } catch (IllegalStateException e2) {
            if (Application.class.equals(getApplication().getClass())) {
                Logger.e().k(e, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.");
                return;
            }
            throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e2);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        WorkManagerImpl workManagerImpl = this.f2134a;
        if (workManagerImpl != null) {
            workManagerImpl.m().p(this);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        r2 = new androidx.work.WorkerParameters.RuntimeExtras();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0079, code lost:
        if (androidx.work.impl.background.systemjob.SystemJobService.Api24Impl.b(r8) == null) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007b, code lost:
        r2.b = java.util.Arrays.asList(androidx.work.impl.background.systemjob.SystemJobService.Api24Impl.b(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0089, code lost:
        if (androidx.work.impl.background.systemjob.SystemJobService.Api24Impl.a(r8) == null) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008b, code lost:
        r2.f2076a = java.util.Arrays.asList(androidx.work.impl.background.systemjob.SystemJobService.Api24Impl.a(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0095, code lost:
        r2.c = androidx.work.impl.background.systemjob.SystemJobService.Api28Impl.a(r8);
        r7.d.c(r7.c.d(r0), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a6, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onStartJob(android.app.job.JobParameters r8) {
        /*
            r7 = this;
            androidx.work.impl.WorkManagerImpl r0 = r7.f2134a
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0015
            androidx.work.Logger r0 = androidx.work.Logger.e()
            java.lang.String r3 = e
            java.lang.String r4 = "WorkManager is not initialized; requesting retry."
            r0.a(r3, r4)
            r7.jobFinished(r8, r1)
            return r2
        L_0x0015:
            androidx.work.impl.model.WorkGenerationalId r0 = b(r8)
            if (r0 != 0) goto L_0x0027
            androidx.work.Logger r7 = androidx.work.Logger.e()
            java.lang.String r8 = e
            java.lang.String r0 = "WorkSpec id not found!"
            r7.c(r8, r0)
            return r2
        L_0x0027:
            java.util.Map r3 = r7.b
            monitor-enter(r3)
            java.util.Map r4 = r7.b     // Catch:{ all -> 0x004e }
            boolean r4 = r4.containsKey(r0)     // Catch:{ all -> 0x004e }
            if (r4 == 0) goto L_0x0050
            androidx.work.Logger r7 = androidx.work.Logger.e()     // Catch:{ all -> 0x004e }
            java.lang.String r8 = e     // Catch:{ all -> 0x004e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x004e }
            r1.<init>()     // Catch:{ all -> 0x004e }
            java.lang.String r4 = "Job is already being executed by SystemJobService: "
            r1.append(r4)     // Catch:{ all -> 0x004e }
            r1.append(r0)     // Catch:{ all -> 0x004e }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x004e }
            r7.a(r8, r0)     // Catch:{ all -> 0x004e }
            monitor-exit(r3)     // Catch:{ all -> 0x004e }
            return r2
        L_0x004e:
            r7 = move-exception
            goto L_0x00a7
        L_0x0050:
            androidx.work.Logger r2 = androidx.work.Logger.e()     // Catch:{ all -> 0x004e }
            java.lang.String r4 = e     // Catch:{ all -> 0x004e }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x004e }
            r5.<init>()     // Catch:{ all -> 0x004e }
            java.lang.String r6 = "onStartJob for "
            r5.append(r6)     // Catch:{ all -> 0x004e }
            r5.append(r0)     // Catch:{ all -> 0x004e }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x004e }
            r2.a(r4, r5)     // Catch:{ all -> 0x004e }
            java.util.Map r2 = r7.b     // Catch:{ all -> 0x004e }
            r2.put(r0, r8)     // Catch:{ all -> 0x004e }
            monitor-exit(r3)     // Catch:{ all -> 0x004e }
            androidx.work.WorkerParameters$RuntimeExtras r2 = new androidx.work.WorkerParameters$RuntimeExtras
            r2.<init>()
            android.net.Uri[] r3 = androidx.work.impl.background.systemjob.SystemJobService.Api24Impl.b(r8)
            if (r3 == 0) goto L_0x0085
            android.net.Uri[] r3 = androidx.work.impl.background.systemjob.SystemJobService.Api24Impl.b(r8)
            java.util.List r3 = java.util.Arrays.asList(r3)
            r2.b = r3
        L_0x0085:
            java.lang.String[] r3 = androidx.work.impl.background.systemjob.SystemJobService.Api24Impl.a(r8)
            if (r3 == 0) goto L_0x0095
            java.lang.String[] r3 = androidx.work.impl.background.systemjob.SystemJobService.Api24Impl.a(r8)
            java.util.List r3 = java.util.Arrays.asList(r3)
            r2.f2076a = r3
        L_0x0095:
            android.net.Network r8 = androidx.work.impl.background.systemjob.SystemJobService.Api28Impl.a(r8)
            r2.c = r8
            androidx.work.impl.WorkLauncher r8 = r7.d
            androidx.work.impl.StartStopTokens r7 = r7.c
            androidx.work.impl.StartStopToken r7 = r7.d(r0)
            r8.c(r7, r2)
            return r1
        L_0x00a7:
            monitor-exit(r3)     // Catch:{ all -> 0x004e }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobService.onStartJob(android.app.job.JobParameters):boolean");
    }

    public boolean onStopJob(JobParameters jobParameters) {
        if (this.f2134a == null) {
            Logger.e().a(e, "WorkManager is not initialized; requesting retry.");
            return true;
        }
        WorkGenerationalId b2 = b(jobParameters);
        if (b2 == null) {
            Logger.e().c(e, "WorkSpec id not found!");
            return false;
        }
        Logger e2 = Logger.e();
        String str = e;
        e2.a(str, "onStopJob for " + b2);
        synchronized (this.b) {
            this.b.remove(b2);
        }
        StartStopToken b3 = this.c.b(b2);
        if (b3 != null) {
            this.d.a(b3, Build.VERSION.SDK_INT >= 31 ? Api31Impl.a(jobParameters) : CastErrorCode.SOURCE_PEER_DEVICE_NOT_ATTACHED);
        }
        return !this.f2134a.m().j(b2.b());
    }
}
