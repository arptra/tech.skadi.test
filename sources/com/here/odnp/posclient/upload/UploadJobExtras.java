package com.here.odnp.posclient.upload;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.here.odnp.posclient.upload.JobUploadStrategy;

public class UploadJobExtras {
    private static final String JOB_EXTRA_CREATE_TIME = "createTime";
    private static final String JOB_EXTRA_FLAGS = "flags";
    private static final String JOB_EXTRA_MIN_LATENCY = "minLatency";
    private static final String JOB_EXTRA_PRIORITY = "priority";
    private static final String JOB_EXTRA_UPDATE_TIME = "updateTime";
    private long mCreateTime;
    private int mMinLatencySecs;
    private JobUploadStrategy.UploadPriority mPriority;
    private long mUpdateTime;
    private long mUploadFlags;

    private UploadJobExtras() {
    }

    @RequiresApi
    public static UploadJobExtras parseJobExtras(@Nullable JobInfo jobInfo) {
        if (jobInfo != null) {
            return parseJobExtras(jobInfo.getExtras());
        }
        UploadJobExtras uploadJobExtras = new UploadJobExtras();
        uploadJobExtras.mPriority = JobUploadStrategy.UploadPriority.UNDEFINED;
        return uploadJobExtras;
    }

    public long createTime() {
        return this.mCreateTime;
    }

    @TargetApi(21)
    public PersistableBundle getBundle() {
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt(JOB_EXTRA_PRIORITY, this.mPriority.getValue());
        persistableBundle.putLong(JOB_EXTRA_FLAGS, this.mUploadFlags);
        persistableBundle.putLong(JOB_EXTRA_CREATE_TIME, this.mCreateTime);
        persistableBundle.putLong(JOB_EXTRA_UPDATE_TIME, this.mUpdateTime);
        persistableBundle.putInt(JOB_EXTRA_MIN_LATENCY, this.mMinLatencySecs);
        return persistableBundle;
    }

    public JobUploadStrategy.UploadPriority getPriority() {
        return this.mPriority;
    }

    public long getUploadFlags() {
        return this.mUploadFlags;
    }

    public int minLatency() {
        return this.mMinLatencySecs;
    }

    public void resetCreateTime() {
        this.mCreateTime = 0;
    }

    public void resetUpdateTime() {
        this.mUpdateTime = 0;
    }

    public long updateTime() {
        return this.mUpdateTime;
    }

    @VisibleForTesting
    public UploadJobExtras(JobUploadStrategy.UploadPriority uploadPriority, long j, long j2, long j3, int i) {
        this.mPriority = uploadPriority;
        this.mUploadFlags = j;
        this.mCreateTime = j2;
        this.mUpdateTime = j3;
        this.mMinLatencySecs = i;
    }

    @RequiresApi
    public static UploadJobExtras parseJobExtras(@NonNull PersistableBundle persistableBundle) {
        UploadJobExtras uploadJobExtras = new UploadJobExtras();
        uploadJobExtras.mPriority = JobUploadStrategy.UploadPriority.getPriorityByInt(persistableBundle.getInt(JOB_EXTRA_PRIORITY));
        uploadJobExtras.mUploadFlags = persistableBundle.getLong(JOB_EXTRA_FLAGS);
        uploadJobExtras.mCreateTime = persistableBundle.getLong(JOB_EXTRA_CREATE_TIME);
        uploadJobExtras.mUpdateTime = persistableBundle.getLong(JOB_EXTRA_UPDATE_TIME);
        uploadJobExtras.mMinLatencySecs = persistableBundle.getInt(JOB_EXTRA_MIN_LATENCY);
        return uploadJobExtras;
    }

    public UploadJobExtras(JobUploadStrategy.UploadPriority uploadPriority, UploadJobExtras uploadJobExtras, long j, int i) {
        this.mPriority = uploadPriority;
        this.mUploadFlags = uploadJobExtras.mUploadFlags;
        this.mCreateTime = uploadJobExtras.mCreateTime;
        this.mUpdateTime = j;
        this.mMinLatencySecs = i;
    }
}
