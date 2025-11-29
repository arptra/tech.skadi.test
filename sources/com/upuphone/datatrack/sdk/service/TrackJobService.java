package com.upuphone.datatrack.sdk.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import com.upuphone.datatrack.base.utils.LogUtil;
import com.upuphone.datatrack.sdk.XJHttpManager;
import com.upuphone.datatrack.sdk.XJTriggerScan;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\t\u0010\b¨\u0006\f"}, d2 = {"Lcom/upuphone/datatrack/sdk/service/TrackJobService;", "Landroid/app/job/JobService;", "<init>", "()V", "Landroid/app/job/JobParameters;", "params", "", "onStartJob", "(Landroid/app/job/JobParameters;)Z", "onStopJob", "a", "Companion", "datatrack-sdk_release"}, k = 1, mv = {1, 7, 1})
public final class TrackJobService extends JobService {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f6424a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/upuphone/datatrack/sdk/service/TrackJobService$Companion;", "", "()V", "DEBUG_REPORT_INTERVAL", "", "RELEASE_REPORT_INTERVAL", "TAG", "", "TRACK_JOB_ID", "", "datatrack-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public boolean onStartJob(JobParameters jobParameters) {
        LogUtil.e("TrackJobService", "onStartJob ");
        XJHttpManager.g(getApplicationContext()).f();
        XJTriggerScan.g(getApplicationContext());
        return false;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        LogUtil.e("TrackJobService", "onStopJob ");
        return true;
    }
}
