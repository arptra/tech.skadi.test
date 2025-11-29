package com.upuphone.xr.sapp.monitor.notification.model;

import androidx.annotation.Keep;
import com.upuphone.xr.sapp.monitor.notification.constants.ReminderType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f¢\u0006\u0002\u0010\rJ\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0000R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/model/ArReminderModel;", "Lcom/upuphone/xr/sapp/monitor/notification/model/ReminderBaseModel;", "id", "", "crateTime", "", "packageName", "title", "startTime", "endTime", "userId", "reminders", "", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;)V", "getEndTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getReminders", "()Ljava/util/List;", "setReminders", "(Ljava/util/List;)V", "getStartTime", "getTitle", "()Ljava/lang/String;", "getUserId", "equals", "", "other", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class ArReminderModel extends ReminderBaseModel {
    @Nullable
    private final Long endTime;
    @NotNull
    private List<Long> reminders;
    @Nullable
    private final Long startTime;
    @NotNull
    private final String title;
    @NotNull
    private final String userId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArReminderModel(@NotNull String str, long j, @NotNull String str2, @NotNull String str3, @Nullable Long l, @Nullable Long l2, @NotNull String str4, @NotNull List<Long> list) {
        super(str, j, ReminderType.MSG_TYPE_REMINDER, str2);
        String str5 = str4;
        List<Long> list2 = list;
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(str5, "userId");
        Intrinsics.checkNotNullParameter(list2, "reminders");
        this.title = str3;
        this.startTime = l;
        this.endTime = l2;
        this.userId = str5;
        this.reminders = list2;
    }

    public final boolean equals(@NotNull ArReminderModel arReminderModel) {
        Intrinsics.checkNotNullParameter(arReminderModel, "other");
        return Intrinsics.areEqual((Object) this.title, (Object) arReminderModel.title) && Intrinsics.areEqual((Object) this.startTime, (Object) arReminderModel.startTime) && Intrinsics.areEqual((Object) this.endTime, (Object) arReminderModel.endTime) && Intrinsics.areEqual((Object) CollectionsKt.joinToString$default(this.reminders, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, ArReminderModel$equals$1.INSTANCE, 31, (Object) null), (Object) CollectionsKt.joinToString$default(arReminderModel.reminders, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, ArReminderModel$equals$2.INSTANCE, 31, (Object) null));
    }

    @Nullable
    public final Long getEndTime() {
        return this.endTime;
    }

    @NotNull
    public final List<Long> getReminders() {
        return this.reminders;
    }

    @Nullable
    public final Long getStartTime() {
        return this.startTime;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    public final void setReminders(@NotNull List<Long> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.reminders = list;
    }
}
