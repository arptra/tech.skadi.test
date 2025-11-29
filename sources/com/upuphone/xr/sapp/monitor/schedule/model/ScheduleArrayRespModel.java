package com.upuphone.xr.sapp.monitor.schedule.model;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/ScheduleArrayRespModel;", "", "calendarDdResultPO", "Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel;", "calendarFsResultPO", "Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel;", "(Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel;Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel;)V", "getCalendarDdResultPO", "()Lcom/upuphone/xr/sapp/monitor/schedule/model/DdScheduleArrayRespModel;", "getCalendarFsResultPO", "()Lcom/upuphone/xr/sapp/monitor/schedule/model/FsScheduleArrayRespModel;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class ScheduleArrayRespModel {
    @Nullable
    private final DdScheduleArrayRespModel calendarDdResultPO;
    @Nullable
    private final FsScheduleArrayRespModel calendarFsResultPO;

    public ScheduleArrayRespModel(@Nullable DdScheduleArrayRespModel ddScheduleArrayRespModel, @Nullable FsScheduleArrayRespModel fsScheduleArrayRespModel) {
        this.calendarDdResultPO = ddScheduleArrayRespModel;
        this.calendarFsResultPO = fsScheduleArrayRespModel;
    }

    public static /* synthetic */ ScheduleArrayRespModel copy$default(ScheduleArrayRespModel scheduleArrayRespModel, DdScheduleArrayRespModel ddScheduleArrayRespModel, FsScheduleArrayRespModel fsScheduleArrayRespModel, int i, Object obj) {
        if ((i & 1) != 0) {
            ddScheduleArrayRespModel = scheduleArrayRespModel.calendarDdResultPO;
        }
        if ((i & 2) != 0) {
            fsScheduleArrayRespModel = scheduleArrayRespModel.calendarFsResultPO;
        }
        return scheduleArrayRespModel.copy(ddScheduleArrayRespModel, fsScheduleArrayRespModel);
    }

    @Nullable
    public final DdScheduleArrayRespModel component1() {
        return this.calendarDdResultPO;
    }

    @Nullable
    public final FsScheduleArrayRespModel component2() {
        return this.calendarFsResultPO;
    }

    @NotNull
    public final ScheduleArrayRespModel copy(@Nullable DdScheduleArrayRespModel ddScheduleArrayRespModel, @Nullable FsScheduleArrayRespModel fsScheduleArrayRespModel) {
        return new ScheduleArrayRespModel(ddScheduleArrayRespModel, fsScheduleArrayRespModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScheduleArrayRespModel)) {
            return false;
        }
        ScheduleArrayRespModel scheduleArrayRespModel = (ScheduleArrayRespModel) obj;
        return Intrinsics.areEqual((Object) this.calendarDdResultPO, (Object) scheduleArrayRespModel.calendarDdResultPO) && Intrinsics.areEqual((Object) this.calendarFsResultPO, (Object) scheduleArrayRespModel.calendarFsResultPO);
    }

    @Nullable
    public final DdScheduleArrayRespModel getCalendarDdResultPO() {
        return this.calendarDdResultPO;
    }

    @Nullable
    public final FsScheduleArrayRespModel getCalendarFsResultPO() {
        return this.calendarFsResultPO;
    }

    public int hashCode() {
        DdScheduleArrayRespModel ddScheduleArrayRespModel = this.calendarDdResultPO;
        int i = 0;
        int hashCode = (ddScheduleArrayRespModel == null ? 0 : ddScheduleArrayRespModel.hashCode()) * 31;
        FsScheduleArrayRespModel fsScheduleArrayRespModel = this.calendarFsResultPO;
        if (fsScheduleArrayRespModel != null) {
            i = fsScheduleArrayRespModel.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        DdScheduleArrayRespModel ddScheduleArrayRespModel = this.calendarDdResultPO;
        FsScheduleArrayRespModel fsScheduleArrayRespModel = this.calendarFsResultPO;
        return "ScheduleArrayRespModel(calendarDdResultPO=" + ddScheduleArrayRespModel + ", calendarFsResultPO=" + fsScheduleArrayRespModel + ")";
    }
}
