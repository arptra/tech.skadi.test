package com.upuphone.xr.sapp.monitor.schedule;

import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/upuphone/xr/sapp/monitor/schedule/ScheduleWorker$querySchedule$2$1$1", "Lcom/upuphone/xr/sapp/monitor/schedule/ScheduleUpdateListener;", "", "Lcom/upuphone/xr/sapp/monitor/notification/model/ArReminderModel;", "schedule", "", "a", "(Ljava/util/List;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ScheduleWorker$querySchedule$2$1$1 implements ScheduleUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f7782a;

    public ScheduleWorker$querySchedule$2$1$1(CancellableContinuation cancellableContinuation) {
        this.f7782a = cancellableContinuation;
    }

    public void a(List list) {
        this.f7782a.resumeWith(Result.m20constructorimpl(list));
    }
}
