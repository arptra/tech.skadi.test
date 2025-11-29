package com.upuphone.xr.sapp.monitor.notification.model;

import androidx.annotation.Keep;
import com.upuphone.xr.sapp.monitor.notification.constants.ReminderType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b#\b\u0007\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0012\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0019\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u001a\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001cR\u001a\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0012R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0015R\u001a\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0015¨\u0006("}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/model/ArTaxiModel;", "", "id", "", "crateTime", "", "reminderType", "packageName", "appName", "taxiState", "taxiStateDesc", "carNumber", "carBrand", "driverArriveTime", "lastUpdateTime", "notificationContent", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;)V", "getAppName", "()Ljava/lang/String;", "getCarBrand", "setCarBrand", "(Ljava/lang/String;)V", "getCarNumber", "setCarNumber", "getCrateTime", "()J", "getDriverArriveTime", "setDriverArriveTime", "(J)V", "getId", "getLastUpdateTime", "setLastUpdateTime", "getNotificationContent", "setNotificationContent", "getPackageName", "getReminderType", "getTaxiState", "setTaxiState", "getTaxiStateDesc", "setTaxiStateDesc", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class ArTaxiModel {
    @NotNull
    private final String appName;
    @NotNull
    private String carBrand;
    @NotNull
    private String carNumber;
    private final long crateTime;
    private long driverArriveTime;
    @NotNull
    private final String id;
    private long lastUpdateTime;
    @NotNull
    private String notificationContent;
    @NotNull
    private final String packageName;
    @NotNull
    private final String reminderType;
    @NotNull
    private String taxiState;
    @NotNull
    private String taxiStateDesc;

    public ArTaxiModel(@NotNull String str, long j, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, long j2, long j3, @NotNull String str9) {
        String str10 = str2;
        String str11 = str3;
        String str12 = str4;
        String str13 = str5;
        String str14 = str6;
        String str15 = str7;
        String str16 = str8;
        String str17 = str9;
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str10, "reminderType");
        Intrinsics.checkNotNullParameter(str11, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(str12, "appName");
        Intrinsics.checkNotNullParameter(str13, "taxiState");
        Intrinsics.checkNotNullParameter(str14, "taxiStateDesc");
        Intrinsics.checkNotNullParameter(str15, "carNumber");
        Intrinsics.checkNotNullParameter(str16, "carBrand");
        Intrinsics.checkNotNullParameter(str17, "notificationContent");
        this.id = str;
        this.crateTime = j;
        this.reminderType = str10;
        this.packageName = str11;
        this.appName = str12;
        this.taxiState = str13;
        this.taxiStateDesc = str14;
        this.carNumber = str15;
        this.carBrand = str16;
        this.driverArriveTime = j2;
        this.lastUpdateTime = j3;
        this.notificationContent = str17;
    }

    @NotNull
    public final String getAppName() {
        return this.appName;
    }

    @NotNull
    public final String getCarBrand() {
        return this.carBrand;
    }

    @NotNull
    public final String getCarNumber() {
        return this.carNumber;
    }

    public final long getCrateTime() {
        return this.crateTime;
    }

    public final long getDriverArriveTime() {
        return this.driverArriveTime;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    @NotNull
    public final String getNotificationContent() {
        return this.notificationContent;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    @NotNull
    public final String getReminderType() {
        return this.reminderType;
    }

    @NotNull
    public final String getTaxiState() {
        return this.taxiState;
    }

    @NotNull
    public final String getTaxiStateDesc() {
        return this.taxiStateDesc;
    }

    public final void setCarBrand(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.carBrand = str;
    }

    public final void setCarNumber(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.carNumber = str;
    }

    public final void setDriverArriveTime(long j) {
        this.driverArriveTime = j;
    }

    public final void setLastUpdateTime(long j) {
        this.lastUpdateTime = j;
    }

    public final void setNotificationContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.notificationContent = str;
    }

    public final void setTaxiState(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.taxiState = str;
    }

    public final void setTaxiStateDesc(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.taxiStateDesc = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ArTaxiModel(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, long j2, long j3, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, (i & 4) != 0 ? ReminderType.MSG_TYPE_TAXI : str2, str3, (i & 16) != 0 ? "" : str4, str5, str6, str7, str8, j2, j3, str9);
    }
}
