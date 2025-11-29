package androidx.work.impl.background.systemjob;

import android.annotation.SuppressLint;
import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.work.BackoffPolicy;
import androidx.work.Clock;
import androidx.work.Constraints;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.model.WorkSpec;

@RequiresApi
@SuppressLint({"ClassVerificationFailure"})
@RestrictTo
class SystemJobInfoConverter {
    public static final String c = Logger.i("SystemJobInfoConverter");

    /* renamed from: a  reason: collision with root package name */
    public final ComponentName f2131a;
    public final Clock b;

    /* renamed from: androidx.work.impl.background.systemjob.SystemJobInfoConverter$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f2132a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.work.NetworkType[] r0 = androidx.work.NetworkType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2132a = r0
                androidx.work.NetworkType r1 = androidx.work.NetworkType.NOT_REQUIRED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f2132a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.work.NetworkType r1 = androidx.work.NetworkType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f2132a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.work.NetworkType r1 = androidx.work.NetworkType.UNMETERED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f2132a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.work.NetworkType r1 = androidx.work.NetworkType.NOT_ROAMING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f2132a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.work.NetworkType r1 = androidx.work.NetworkType.METERED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobInfoConverter.AnonymousClass1.<clinit>():void");
        }
    }

    public SystemJobInfoConverter(Context context, Clock clock) {
        this.b = clock;
        this.f2131a = new ComponentName(context.getApplicationContext(), SystemJobService.class);
    }

    public static JobInfo.TriggerContentUri b(Constraints.ContentUriTrigger contentUriTrigger) {
        return new JobInfo.TriggerContentUri(contentUriTrigger.a(), contentUriTrigger.b() ? 1 : 0);
    }

    public static int c(NetworkType networkType) {
        int i = AnonymousClass1.f2132a[networkType.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 2;
        }
        if (i == 4) {
            return 3;
        }
        if (i == 5) {
            return 4;
        }
        Logger e = Logger.e();
        String str = c;
        e.a(str, "API version too low. Cannot convert network type value " + networkType);
        return 1;
    }

    public static void d(JobInfo.Builder builder, NetworkType networkType) {
        if (Build.VERSION.SDK_INT < 30 || networkType != NetworkType.TEMPORARILY_UNMETERED) {
            builder.setRequiredNetworkType(c(networkType));
        } else {
            builder.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
        }
    }

    public JobInfo a(WorkSpec workSpec, int i) {
        Constraints constraints = workSpec.j;
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", workSpec.f2184a);
        persistableBundle.putInt("EXTRA_WORK_SPEC_GENERATION", workSpec.d());
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", workSpec.k());
        JobInfo.Builder extras = new JobInfo.Builder(i, this.f2131a).setRequiresCharging(constraints.g()).setRequiresDeviceIdle(constraints.h()).setExtras(persistableBundle);
        d(extras, constraints.d());
        boolean z = false;
        if (!constraints.h()) {
            extras.setBackoffCriteria(workSpec.m, workSpec.l == BackoffPolicy.LINEAR ? 0 : 1);
        }
        long max = Math.max(workSpec.c() - this.b.currentTimeMillis(), 0);
        if (max > 0) {
            extras.setMinimumLatency(max);
        } else if (!workSpec.q) {
            extras.setImportantWhileForeground(true);
        }
        if (constraints.e()) {
            for (Constraints.ContentUriTrigger b2 : constraints.c()) {
                extras.addTriggerContentUri(b(b2));
            }
            extras.setTriggerContentUpdateDelay(constraints.b());
            extras.setTriggerContentMaxDelay(constraints.a());
        }
        extras.setPersisted(false);
        int i2 = Build.VERSION.SDK_INT;
        extras.setRequiresBatteryNotLow(constraints.f());
        extras.setRequiresStorageNotLow(constraints.i());
        boolean z2 = workSpec.k > 0;
        if (max > 0) {
            z = true;
        }
        if (i2 >= 31 && workSpec.q && !z2 && !z) {
            JobInfo.Builder unused = extras.setExpedited(true);
        }
        return extras.build();
    }
}
