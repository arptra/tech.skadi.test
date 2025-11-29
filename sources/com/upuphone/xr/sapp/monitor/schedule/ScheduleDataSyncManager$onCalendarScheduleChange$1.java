package com.upuphone.xr.sapp.monitor.schedule;

import com.meizu.common.widget.MzContactsContract;
import com.upuphone.xr.sapp.monitor.notification.model.ArReminderModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/monitor/notification/model/ArReminderModel;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ScheduleDataSyncManager$onCalendarScheduleChange$1 extends Lambda implements Function1<ArReminderModel, CharSequence> {
    public static final ScheduleDataSyncManager$onCalendarScheduleChange$1 INSTANCE = new ScheduleDataSyncManager$onCalendarScheduleChange$1();

    public ScheduleDataSyncManager$onCalendarScheduleChange$1() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull ArReminderModel arReminderModel) {
        Intrinsics.checkNotNullParameter(arReminderModel, "it");
        String title = arReminderModel.getTitle();
        return title + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML;
    }
}
