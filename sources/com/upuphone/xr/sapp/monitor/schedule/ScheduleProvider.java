package com.upuphone.xr.sapp.monitor.schedule;

import com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\u0005R$\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/ScheduleProvider;", "", "Lcom/upuphone/xr/sapp/monitor/schedule/model/LocalScheduleModel;", "account", "<init>", "(Lcom/upuphone/xr/sapp/monitor/schedule/model/LocalScheduleModel;)V", "", "c", "()V", "a", "Lcom/upuphone/xr/sapp/monitor/schedule/model/LocalScheduleModel;", "()Lcom/upuphone/xr/sapp/monitor/schedule/model/LocalScheduleModel;", "setAccount", "Lcom/upuphone/xr/sapp/monitor/schedule/ScheduleUpdateListener;", "b", "Lcom/upuphone/xr/sapp/monitor/schedule/ScheduleUpdateListener;", "()Lcom/upuphone/xr/sapp/monitor/schedule/ScheduleUpdateListener;", "d", "(Lcom/upuphone/xr/sapp/monitor/schedule/ScheduleUpdateListener;)V", "listener", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public abstract class ScheduleProvider {

    /* renamed from: a  reason: collision with root package name */
    public LocalScheduleModel f7780a;
    public ScheduleUpdateListener b;

    public ScheduleProvider(LocalScheduleModel localScheduleModel) {
        Intrinsics.checkNotNullParameter(localScheduleModel, "account");
        this.f7780a = localScheduleModel;
    }

    public final LocalScheduleModel a() {
        return this.f7780a;
    }

    public final ScheduleUpdateListener b() {
        return this.b;
    }

    public abstract void c();

    public final void d(ScheduleUpdateListener scheduleUpdateListener) {
        this.b = scheduleUpdateListener;
    }
}
