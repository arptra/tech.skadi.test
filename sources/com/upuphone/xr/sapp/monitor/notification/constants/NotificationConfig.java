package com.upuphone.xr.sapp.monitor.notification.constants;

import androidx.annotation.Keep;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001e\b\u0007\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0002\u0010\u0010R\u001a\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001a\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001c¨\u0006,"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/constants/NotificationConfig;", "", "notificationControlState", "", "reminderScenesControlState", "reminderOpenState", "", "", "notificationDisplayTime", "", "notificationBroadcast", "notificationBrightenScreen", "callNotificationState", "scheduleDisplayTime", "", "notificationBroadcastPauseType", "(ZZLjava/util/Map;Ljava/lang/Long;ZZZII)V", "getCallNotificationState", "()Z", "setCallNotificationState", "(Z)V", "getNotificationBrightenScreen", "setNotificationBrightenScreen", "getNotificationBroadcast", "setNotificationBroadcast", "getNotificationBroadcastPauseType", "()I", "setNotificationBroadcastPauseType", "(I)V", "getNotificationControlState", "setNotificationControlState", "getNotificationDisplayTime", "()Ljava/lang/Long;", "setNotificationDisplayTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getReminderOpenState", "()Ljava/util/Map;", "setReminderOpenState", "(Ljava/util/Map;)V", "getReminderScenesControlState", "setReminderScenesControlState", "getScheduleDisplayTime", "setScheduleDisplayTime", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class NotificationConfig {
    private boolean callNotificationState;
    private boolean notificationBrightenScreen;
    private boolean notificationBroadcast;
    private int notificationBroadcastPauseType;
    private boolean notificationControlState;
    @Nullable
    private Long notificationDisplayTime;
    @NotNull
    private Map<String, Boolean> reminderOpenState;
    private boolean reminderScenesControlState;
    private int scheduleDisplayTime;

    public NotificationConfig(boolean z, boolean z2, @NotNull Map<String, Boolean> map, @Nullable Long l, boolean z3, boolean z4, boolean z5, int i, int i2) {
        Intrinsics.checkNotNullParameter(map, "reminderOpenState");
        this.notificationControlState = z;
        this.reminderScenesControlState = z2;
        this.reminderOpenState = map;
        this.notificationDisplayTime = l;
        this.notificationBroadcast = z3;
        this.notificationBrightenScreen = z4;
        this.callNotificationState = z5;
        this.scheduleDisplayTime = i;
        this.notificationBroadcastPauseType = i2;
    }

    public final boolean getCallNotificationState() {
        return this.callNotificationState;
    }

    public final boolean getNotificationBrightenScreen() {
        return this.notificationBrightenScreen;
    }

    public final boolean getNotificationBroadcast() {
        return this.notificationBroadcast;
    }

    public final int getNotificationBroadcastPauseType() {
        return this.notificationBroadcastPauseType;
    }

    public final boolean getNotificationControlState() {
        return this.notificationControlState;
    }

    @Nullable
    public final Long getNotificationDisplayTime() {
        return this.notificationDisplayTime;
    }

    @NotNull
    public final Map<String, Boolean> getReminderOpenState() {
        return this.reminderOpenState;
    }

    public final boolean getReminderScenesControlState() {
        return this.reminderScenesControlState;
    }

    public final int getScheduleDisplayTime() {
        return this.scheduleDisplayTime;
    }

    public final void setCallNotificationState(boolean z) {
        this.callNotificationState = z;
    }

    public final void setNotificationBrightenScreen(boolean z) {
        this.notificationBrightenScreen = z;
    }

    public final void setNotificationBroadcast(boolean z) {
        this.notificationBroadcast = z;
    }

    public final void setNotificationBroadcastPauseType(int i) {
        this.notificationBroadcastPauseType = i;
    }

    public final void setNotificationControlState(boolean z) {
        this.notificationControlState = z;
    }

    public final void setNotificationDisplayTime(@Nullable Long l) {
        this.notificationDisplayTime = l;
    }

    public final void setReminderOpenState(@NotNull Map<String, Boolean> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.reminderOpenState = map;
    }

    public final void setReminderScenesControlState(boolean z) {
        this.reminderScenesControlState = z;
    }

    public final void setScheduleDisplayTime(int i) {
        this.scheduleDisplayTime = i;
    }
}
