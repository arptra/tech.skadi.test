package com.upuphone.xr.sapp.datatrack;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/upuphone/xr/sapp/datatrack/ReminderDataTrackEvent;", "", "()V", "APP_CLICK_REMIND_APP", "", "APP_CLICK_REMIND_APP_IMPORTANT", "APP_CLICK_REMIND_LIGHT", "APP_CLICK_REMIND_NOTICE", "APP_CLICK_REMIND_PERMISSION", "APP_CLICK_REMIND_POP", "APP_CLICK_REMIND_READ", "APP_CLICK_REMIND_REPEAT", "APP_GLASSES_SETTING", "APP_REMIND_APP_NOTICE", "APP_REMIND_APP_NOTICE_LIST", "APP_REMIND_PERMISSION", "APP_REMIND_POP", "APP_REMIND_SET", "APP_SMART_FLIGHT", "APP_SMART_NOTIFICATIONS", "APP_SMART_TAXI", "APP_STATUS_CALL_REMINDER", "APP_STATUS_CALL_TRANSFER", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class ReminderDataTrackEvent {
    @NotNull
    public static final String APP_CLICK_REMIND_APP = "app_click_remind_app";
    @NotNull
    public static final String APP_CLICK_REMIND_APP_IMPORTANT = "app_click_remind_app_important";
    @NotNull
    public static final String APP_CLICK_REMIND_LIGHT = "app_click_remind_light";
    @NotNull
    public static final String APP_CLICK_REMIND_NOTICE = "app_click_remind_notice";
    @NotNull
    public static final String APP_CLICK_REMIND_PERMISSION = "app_click_remind_permission";
    @NotNull
    public static final String APP_CLICK_REMIND_POP = "app_click_remind_pop";
    @NotNull
    public static final String APP_CLICK_REMIND_READ = "app_click_remind_read";
    @NotNull
    public static final String APP_CLICK_REMIND_REPEAT = "app_click_remind_repeat";
    @NotNull
    public static final String APP_GLASSES_SETTING = "app_glasses_setting";
    @NotNull
    public static final String APP_REMIND_APP_NOTICE = "app_remind_app_notice";
    @NotNull
    public static final String APP_REMIND_APP_NOTICE_LIST = "app_remind_app_notice_list";
    @NotNull
    public static final String APP_REMIND_PERMISSION = "app_remind_permission";
    @NotNull
    public static final String APP_REMIND_POP = "app_remind_pop";
    @NotNull
    public static final String APP_REMIND_SET = "app_remind_set";
    @NotNull
    public static final String APP_SMART_FLIGHT = "app_smart_flight";
    @NotNull
    public static final String APP_SMART_NOTIFICATIONS = "app_smart_notifications";
    @NotNull
    public static final String APP_SMART_TAXI = "app_smart_taxi";
    @NotNull
    public static final String APP_STATUS_CALL_REMINDER = "app_status_CallReminder";
    @NotNull
    public static final String APP_STATUS_CALL_TRANSFER = "app_status_CallTransfer";
    @NotNull
    public static final ReminderDataTrackEvent INSTANCE = new ReminderDataTrackEvent();

    private ReminderDataTrackEvent() {
    }
}
