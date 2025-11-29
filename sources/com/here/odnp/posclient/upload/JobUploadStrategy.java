package com.here.odnp.posclient.upload;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.here.odnp.util.Log;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class JobUploadStrategy implements IUploadScheduler {
    /* access modifiers changed from: private */
    public static final long DEADLINE_HIGH_PRIORITY = TimeUnit.DAYS.toMillis(11);
    /* access modifiers changed from: private */
    public static final long DEADLINE_LOW_PRIORITY;
    /* access modifiers changed from: private */
    public static final long DEADLINE_MEDIUM_PRIORITY;
    private static final long INITIAL_BACKOFF_MILLIS;
    private static final int JOB_SCHEDULE_ID_HIGH_1 = 33105;
    private static final int JOB_SCHEDULE_ID_HIGH_2 = 33106;
    private static final int JOB_SCHEDULE_ID_LOW = 33103;
    private static final int JOB_SCHEDULE_ID_MEDIUM = 33104;
    private static final int JOB_SCHEDULE_ID_UNDEFINED = 0;
    private static final int JOB_SCHEDULE_ID_UPLOAD_FP_BASE = 33100;
    private static final int JOB_SCHEDULE_ID_WAIT_1 = 33101;
    private static final int JOB_SCHEDULE_ID_WAIT_2 = 33102;
    private static final String TAG = "odnp.posclient.upload.JobUploadStrategy";
    private static final Object mLock = new Object();
    private static volatile JobUploadStrategy mSchedulerInstance;
    private UploadJobExtras mActiveJobExtra;

    /* renamed from: com.here.odnp.posclient.upload.JobUploadStrategy$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$here$odnp$posclient$upload$JobUploadStrategy$UploadPriority;

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
                com.here.odnp.posclient.upload.JobUploadStrategy$UploadPriority[] r0 = com.here.odnp.posclient.upload.JobUploadStrategy.UploadPriority.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$here$odnp$posclient$upload$JobUploadStrategy$UploadPriority = r0
                com.here.odnp.posclient.upload.JobUploadStrategy$UploadPriority r1 = com.here.odnp.posclient.upload.JobUploadStrategy.UploadPriority.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$here$odnp$posclient$upload$JobUploadStrategy$UploadPriority     // Catch:{ NoSuchFieldError -> 0x001d }
                com.here.odnp.posclient.upload.JobUploadStrategy$UploadPriority r1 = com.here.odnp.posclient.upload.JobUploadStrategy.UploadPriority.WAIT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$here$odnp$posclient$upload$JobUploadStrategy$UploadPriority     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.here.odnp.posclient.upload.JobUploadStrategy$UploadPriority r1 = com.here.odnp.posclient.upload.JobUploadStrategy.UploadPriority.LOW     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$here$odnp$posclient$upload$JobUploadStrategy$UploadPriority     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.here.odnp.posclient.upload.JobUploadStrategy$UploadPriority r1 = com.here.odnp.posclient.upload.JobUploadStrategy.UploadPriority.MEDIUM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$here$odnp$posclient$upload$JobUploadStrategy$UploadPriority     // Catch:{ NoSuchFieldError -> 0x003e }
                com.here.odnp.posclient.upload.JobUploadStrategy$UploadPriority r1 = com.here.odnp.posclient.upload.JobUploadStrategy.UploadPriority.HIGH     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.here.odnp.posclient.upload.JobUploadStrategy.AnonymousClass1.<clinit>():void");
        }
    }

    public enum UploadPriority {
        UNDEFINED(0, 0),
        WAIT(1, JobUploadStrategy.DEADLINE_LOW_PRIORITY),
        LOW(2, JobUploadStrategy.DEADLINE_LOW_PRIORITY),
        MEDIUM(3, JobUploadStrategy.DEADLINE_MEDIUM_PRIORITY),
        HIGH(4, JobUploadStrategy.DEADLINE_HIGH_PRIORITY);
        
        private final int id;
        /* access modifiers changed from: private */
        public long maxRunTime;

        private UploadPriority(int i, long j) {
            this.id = i;
            this.maxRunTime = j;
        }

        public static UploadPriority getPriorityByInt(int i) {
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? UNDEFINED : HIGH : MEDIUM : LOW : WAIT;
        }

        @TargetApi(21)
        public int getNextJobScheduleId(@Nullable JobInfo jobInfo) {
            int i = AnonymousClass1.$SwitchMap$com$here$odnp$posclient$upload$JobUploadStrategy$UploadPriority[ordinal()];
            if (i == 1 || i == 2) {
                return (jobInfo == null || jobInfo.getId() != JobUploadStrategy.JOB_SCHEDULE_ID_WAIT_1) ? JobUploadStrategy.JOB_SCHEDULE_ID_WAIT_1 : JobUploadStrategy.JOB_SCHEDULE_ID_WAIT_2;
            }
            if (i == 3) {
                return JobUploadStrategy.JOB_SCHEDULE_ID_LOW;
            }
            if (i == 4) {
                return JobUploadStrategy.JOB_SCHEDULE_ID_MEDIUM;
            }
            if (i != 5) {
                return 0;
            }
            return (jobInfo == null || jobInfo.getId() != JobUploadStrategy.JOB_SCHEDULE_ID_HIGH_1) ? JobUploadStrategy.JOB_SCHEDULE_ID_HIGH_1 : JobUploadStrategy.JOB_SCHEDULE_ID_HIGH_2;
        }

        public int getValue() {
            return this.id;
        }

        public boolean higherPriority(@NonNull UploadPriority uploadPriority) {
            return this.id > uploadPriority.id;
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        INITIAL_BACKOFF_MILLIS = timeUnit.toMillis(30);
        DEADLINE_LOW_PRIORITY = timeUnit.toMillis(480);
        DEADLINE_MEDIUM_PRIORITY = timeUnit.toMillis(960);
    }

    private JobUploadStrategy() {
    }

    @TargetApi(23)
    private void addPersistent(@NonNull Context context, @NonNull JobInfo.Builder builder) {
        if (context.checkSelfPermission("android.permission.RECEIVE_BOOT_COMPLETED") == 0) {
            builder.setPersisted(true);
        }
    }

    @TargetApi(21)
    private JobInfo buildJob(@NonNull Context context, @Nullable JobInfo jobInfo, @NonNull UploadJobExtras uploadJobExtras) {
        ComponentName componentName = getComponentName(context);
        UploadPriority priority = uploadJobExtras.getPriority();
        JobInfo.Builder builder = new JobInfo.Builder(priority.getNextJobScheduleId(jobInfo), componentName);
        builder.setExtras(uploadJobExtras.getBundle());
        setJobCriteria(builder, priority, TimeUnit.SECONDS.toMillis((long) uploadJobExtras.minLatency()));
        setBackOffCriteria(priority, builder);
        return buildJob_v26(context, builder);
    }

    @TargetApi(21)
    private JobInfo buildJob_v21(@NonNull JobInfo.Builder builder) {
        return builder.build();
    }

    @TargetApi(23)
    private JobInfo buildJob_v23(@NonNull Context context, @NonNull JobInfo.Builder builder) {
        addPersistent(context, builder);
        return builder.build();
    }

    @TargetApi(26)
    private JobInfo buildJob_v26(@NonNull Context context, @NonNull JobInfo.Builder builder) {
        addPersistent(context, builder);
        builder.setRequiresBatteryNotLow(true);
        return builder.build();
    }

    @TargetApi(21)
    private boolean callPlatformScheduler(@NonNull JobScheduler jobScheduler, @NonNull JobInfo jobInfo) {
        try {
            return jobScheduler.schedule(jobInfo) == 1;
        } catch (Exception e) {
            Log.e(TAG, "Failed to call jobScheduler: %s", e.getMessage());
            return false;
        }
    }

    private void checkTimestamps(@NonNull UploadJobExtras uploadJobExtras, long j) {
        if (j < uploadJobExtras.updateTime()) {
            Log.d(TAG, "Device reboot detected", new Object[0]);
            uploadJobExtras.resetCreateTime();
            uploadJobExtras.resetUpdateTime();
        }
    }

    private ComponentName getComponentName(@NonNull Context context) {
        return new ComponentName(context, "com.here.services.internal.UploadService");
    }

    @TargetApi(21)
    private JobInfo getCurrentJobInfo(@NonNull Context context, @NonNull JobScheduler jobScheduler) {
        List<JobInfo> allPendingJobs = jobScheduler.getAllPendingJobs();
        ComponentName componentName = getComponentName(context);
        for (JobInfo next : allPendingJobs) {
            if (componentName.equals(next.getService())) {
                return next;
            }
        }
        return null;
    }

    @VisibleForTesting
    public static long getMinLatency(int i) {
        return INITIAL_BACKOFF_MILLIS * ((long) (i > 9 ? 512 : i > 0 ? 1 << (i - 1) : 0));
    }

    private static long getMinTotalLatency(int i) {
        if (i > 0) {
            return getMinLatency(i + 1) - INITIAL_BACKOFF_MILLIS;
        }
        return 0;
    }

    @VisibleForTesting
    public static long getRemainingTime(@NonNull UploadJobExtras uploadJobExtras, long j, int i) {
        long j2;
        long j3;
        long j4;
        long updateTime = j - uploadJobExtras.updateTime();
        long minTotalLatency = getMinTotalLatency(i);
        long millis = TimeUnit.SECONDS.toMillis((long) uploadJobExtras.minLatency());
        int i2 = AnonymousClass1.$SwitchMap$com$here$odnp$posclient$upload$JobUploadStrategy$UploadPriority[uploadJobExtras.getPriority().ordinal()];
        if (i2 != 2) {
            if (i2 == 3) {
                j4 = DEADLINE_LOW_PRIORITY;
                j2 = j4 - updateTime;
            } else if (i2 == 4) {
                long j5 = DEADLINE_MEDIUM_PRIORITY;
                j2 = j5 - updateTime;
                j3 = (DEADLINE_LOW_PRIORITY + j5) - minTotalLatency;
            } else if (i2 != 5) {
                Log.e(TAG, "Illegal value for priority: %s", uploadJobExtras.getPriority().toString());
                j2 = 0;
                j3 = 0;
            } else {
                long j6 = DEADLINE_HIGH_PRIORITY;
                j2 = j6 - updateTime;
                j4 = j6 + DEADLINE_LOW_PRIORITY + DEADLINE_MEDIUM_PRIORITY;
            }
            j3 = j4 - minTotalLatency;
        } else {
            long j7 = DEADLINE_LOW_PRIORITY + millis;
            j2 = j7 - updateTime;
            j3 = j7 - minTotalLatency;
        }
        if (j2 < j3) {
            if (j2 > 0) {
                return j2;
            }
            return 0;
        } else if (j3 > 0) {
            return j3;
        } else {
            return 0;
        }
    }

    private static long getRemainingWaitTime(long j, @NonNull UploadJobExtras uploadJobExtras) {
        return TimeUnit.SECONDS.toMillis((long) uploadJobExtras.minLatency()) - (j - uploadJobExtras.updateTime());
    }

    public static JobUploadStrategy getUploadScheduler() {
        if (mSchedulerInstance == null) {
            synchronized (mLock) {
                try {
                    if (mSchedulerInstance == null) {
                        mSchedulerInstance = new JobUploadStrategy();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return mSchedulerInstance;
    }

    private UploadPriority nextPriority(@NonNull UploadPriority uploadPriority) {
        int i = AnonymousClass1.$SwitchMap$com$here$odnp$posclient$upload$JobUploadStrategy$UploadPriority[uploadPriority.ordinal()];
        if (i == 1) {
            return UploadPriority.WAIT;
        }
        if (i == 2) {
            return UploadPriority.MEDIUM;
        }
        if (i == 3) {
            return UploadPriority.MEDIUM;
        }
        if (i == 4) {
            return UploadPriority.HIGH;
        }
        if (i == 5) {
            return UploadPriority.HIGH;
        }
        Log.d("JobUploadStrategy", "Illegal parameter", new Object[0]);
        return UploadPriority.UNDEFINED;
    }

    @TargetApi(21)
    private void scheduleJob(@NonNull Context context, @NonNull UploadPriority uploadPriority, long j, int i) {
        JobInfo jobInfo;
        long j2;
        long j3;
        Context context2 = context;
        UploadPriority uploadPriority2 = uploadPriority;
        JobScheduler jobScheduler = (JobScheduler) context2.getSystemService("jobscheduler");
        JobInfo currentJobInfo = getCurrentJobInfo(context2, jobScheduler);
        UploadJobExtras parseJobExtras = UploadJobExtras.parseJobExtras(currentJobInfo);
        long millis = TimeUnit.SECONDS.toMillis((long) i);
        if (this.mActiveJobExtra != null && parseJobExtras.updateTime() == this.mActiveJobExtra.updateTime()) {
            jobInfo = null;
        } else if (parseJobExtras.getPriority() == UploadPriority.UNDEFINED || uploadPriority2.higherPriority(parseJobExtras.getPriority())) {
            jobInfo = currentJobInfo;
        } else {
            if (rescheduleJob(context, parseJobExtras, false, false, 0, millis) && currentJobInfo != null) {
                jobScheduler.cancel(currentJobInfo.getId());
            }
            this.mActiveJobExtra = null;
            return;
        }
        UploadPriority uploadPriority3 = UploadPriority.UNDEFINED;
        if (uploadPriority2 == uploadPriority3) {
            uploadPriority2 = UploadPriority.WAIT;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (jobInfo != null) {
            j3 = parseJobExtras.createTime();
            j2 = parseJobExtras.getUploadFlags();
        } else {
            j2 = j;
            j3 = elapsedRealtime;
        }
        UploadJobExtras uploadJobExtras = r11;
        UploadJobExtras uploadJobExtras2 = new UploadJobExtras(uploadPriority2, j2, j3, elapsedRealtime, i);
        if (callPlatformScheduler(jobScheduler, buildJob(context2, currentJobInfo, uploadJobExtras))) {
            Log.d(TAG, "scheduleJob: Priority %s", uploadPriority2.toString());
            if (!(parseJobExtras.getPriority() == uploadPriority3 || jobInfo == null)) {
                Log.d(TAG, "scheduleJob: Cancel priority %s", parseJobExtras.getPriority().toString());
                jobScheduler.cancel(jobInfo.getId());
            }
        } else {
            Log.d(TAG, "scheduleJob: Failed", new Object[0]);
        }
        this.mActiveJobExtra = null;
    }

    @TargetApi(21)
    private void setBackOffCriteria(@NonNull UploadPriority uploadPriority, @NonNull JobInfo.Builder builder) {
        if (uploadPriority != UploadPriority.HIGH) {
            builder.setRequiresDeviceIdle(true);
            return;
        }
        builder.setRequiresDeviceIdle(false);
        builder.setBackoffCriteria(INITIAL_BACKOFF_MILLIS, 1);
    }

    @TargetApi(21)
    private void setJobCriteria(@NonNull JobInfo.Builder builder, @NonNull UploadPriority uploadPriority, long j) {
        int i = AnonymousClass1.$SwitchMap$com$here$odnp$posclient$upload$JobUploadStrategy$UploadPriority[uploadPriority.ordinal()];
        if (i == 1) {
            throw new IllegalStateException();
        } else if (i == 2) {
            builder.setRequiredNetworkType(2).setRequiresCharging(true).setOverrideDeadline(DEADLINE_LOW_PRIORITY + j).setMinimumLatency(j);
        } else if (i == 3) {
            builder.setRequiredNetworkType(2).setRequiresCharging(true).setOverrideDeadline(DEADLINE_LOW_PRIORITY + j).setMinimumLatency(j);
        } else if (i == 4) {
            setNotRoamingNetwork(builder);
            builder.setRequiresCharging(true).setOverrideDeadline(DEADLINE_MEDIUM_PRIORITY + j).setMinimumLatency(j);
        } else if (i == 5) {
            setNotRoamingNetwork(builder);
            builder.setRequiresCharging(false).setOverrideDeadline(DEADLINE_HIGH_PRIORITY + j).setMinimumLatency(j);
        }
    }

    @TargetApi(21)
    private void setNotRoamingNetwork(@NonNull JobInfo.Builder builder) {
        builder.setEstimatedNetworkBytes(0, 100000);
        NetworkRequest.Builder builder2 = new NetworkRequest.Builder();
        builder2.addCapability(12);
        builder2.addCapability(16);
        builder2.removeCapability(15);
        builder2.addCapability(18);
        builder.setRequiredNetwork(builder2.build());
    }

    public void close() {
    }

    @TargetApi(21)
    public void dataUploaded(@NonNull Context context) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            JobInfo currentJobInfo = getCurrentJobInfo(context, jobScheduler);
            if (currentJobInfo != null) {
                this.mActiveJobExtra = UploadJobExtras.parseJobExtras(currentJobInfo);
            } else {
                this.mActiveJobExtra = null;
            }
        }
    }

    @TargetApi(21)
    public boolean rescheduleJob(@NonNull Context context, @NonNull UploadJobExtras uploadJobExtras, boolean z, boolean z2, int i, long j) {
        UploadPriority uploadPriority;
        JobInfo jobInfo;
        int i2;
        long j2;
        UploadPriority uploadPriority2;
        Context context2 = context;
        UploadJobExtras uploadJobExtras2 = uploadJobExtras;
        long j3 = j;
        JobScheduler jobScheduler = (JobScheduler) context2.getSystemService("jobscheduler");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        checkTimestamps(uploadJobExtras2, elapsedRealtime);
        long remainingTime = getRemainingTime(uploadJobExtras2, elapsedRealtime, i);
        JobInfo currentJobInfo = getCurrentJobInfo(context2, jobScheduler);
        if (z) {
            uploadPriority = nextPriority(uploadJobExtras.getPriority());
            jobInfo = buildJob(context2, currentJobInfo, new UploadJobExtras(uploadPriority, uploadJobExtras, SystemClock.elapsedRealtime(), 0));
        } else {
            long minLatency = getMinLatency(i);
            if (minLatency >= remainingTime) {
                UploadPriority nextPriority = nextPriority(uploadJobExtras.getPriority());
                j2 = elapsedRealtime + remainingTime;
                if (minLatency > nextPriority.maxRunTime) {
                    minLatency = nextPriority.maxRunTime;
                }
                uploadPriority = nextPriority;
                i2 = (int) TimeUnit.MILLISECONDS.toSeconds(minLatency);
            } else if (z2 || uploadJobExtras.getPriority() != (uploadPriority2 = UploadPriority.WAIT)) {
                return false;
            } else {
                long remainingWaitTime = getRemainingWaitTime(elapsedRealtime, uploadJobExtras2);
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                Log.d(TAG, "rescheduleJob: Remaining time %d minutes, requested %d minutes", Long.valueOf(timeUnit.toMinutes(remainingWaitTime)), Long.valueOf(timeUnit.toMinutes(j3)));
                long j4 = elapsedRealtime;
                if (remainingWaitTime <= TimeUnit.MINUTES.toMillis(2) + j3) {
                    return false;
                }
                i2 = (int) timeUnit.toSeconds(j3);
                uploadPriority = uploadPriority2;
                j2 = j4;
            }
            jobInfo = buildJob(context2, currentJobInfo, new UploadJobExtras(uploadPriority, uploadJobExtras, j2, i2));
        }
        boolean callPlatformScheduler = callPlatformScheduler(jobScheduler, jobInfo);
        Log.d(TAG, "rescheduleJob: Priority %s (%b)", uploadPriority.toString(), Boolean.valueOf(callPlatformScheduler));
        return callPlatformScheduler;
    }

    public void schedule(@NonNull Context context, @NonNull UploadPriority uploadPriority, long j, int i) {
        if (uploadPriority != UploadPriority.WAIT || i >= 1) {
            scheduleJob(context, uploadPriority, j, i);
            return;
        }
        scheduleJob(context, UploadPriority.LOW, j, 0);
    }

    public void schedule(@NonNull Context context, int i) {
        if (i < 1) {
            scheduleJob(context, UploadPriority.LOW, 0, 0);
            return;
        }
        scheduleJob(context, UploadPriority.WAIT, 0, i);
    }
}
