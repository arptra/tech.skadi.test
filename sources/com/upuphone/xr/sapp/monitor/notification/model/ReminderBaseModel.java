package com.upuphone.xr.sapp.monitor.notification.model;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\b\u0017\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/model/ReminderBaseModel;", "", "id", "", "crateTime", "", "reminderType", "packageName", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getCrateTime", "()J", "getId", "()Ljava/lang/String;", "getPackageName", "getReminderType", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public class ReminderBaseModel {
    private final long crateTime;
    @NotNull
    private final String id;
    @NotNull
    private final String packageName;
    @NotNull
    private final String reminderType;

    public ReminderBaseModel(@NotNull String str, long j, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "reminderType");
        Intrinsics.checkNotNullParameter(str3, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        this.id = str;
        this.crateTime = j;
        this.reminderType = str2;
        this.packageName = str3;
    }

    public final long getCrateTime() {
        return this.crateTime;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    @NotNull
    public final String getReminderType() {
        return this.reminderType;
    }
}
