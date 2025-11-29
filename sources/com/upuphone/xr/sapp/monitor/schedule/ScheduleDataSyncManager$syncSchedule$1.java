package com.upuphone.xr.sapp.monitor.schedule;

import androidx.work.WorkInfo;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "workInfo", "Landroidx/work/WorkInfo;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ScheduleDataSyncManager$syncSchedule$1 extends Lambda implements Function1<WorkInfo, Unit> {
    public static final ScheduleDataSyncManager$syncSchedule$1 INSTANCE = new ScheduleDataSyncManager$syncSchedule$1();

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                androidx.work.WorkInfo$State[] r0 = androidx.work.WorkInfo.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.work.WorkInfo$State r1 = androidx.work.WorkInfo.State.FAILED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.work.WorkInfo$State r1 = androidx.work.WorkInfo.State.SUCCEEDED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.monitor.schedule.ScheduleDataSyncManager$syncSchedule$1.WhenMappings.<clinit>():void");
        }
    }

    public ScheduleDataSyncManager$syncSchedule$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WorkInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(WorkInfo workInfo) {
        if (workInfo != null) {
            ULog.Delegate delegate = ULog.f6446a;
            String name = workInfo.a().name();
            boolean isFinished = workInfo.a().isFinished();
            delegate.a("Schedule-DataSyncManager", "syncSchedule state: " + name + " isFinished:" + isFinished);
            int i = WhenMappings.$EnumSwitchMapping$0[workInfo.a().ordinal()];
            if (i == 1 || i == 2) {
                ScheduleDataSyncManager scheduleDataSyncManager = ScheduleDataSyncManager.f7777a;
                scheduleDataSyncManager.l(60L);
                scheduleDataSyncManager.f();
            }
        }
    }
}
