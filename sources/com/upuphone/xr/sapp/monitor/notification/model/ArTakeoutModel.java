package com.upuphone.xr.sapp.monitor.notification.model;

import androidx.annotation.Keep;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.upuphone.xr.sapp.monitor.notification.constants.ReminderType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u001a\b\u0007\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u001e\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/model/ArTakeoutModel;", "", "id", "", "crateTime", "", "reminderType", "packageName", "takeoutState", "takeoutStateDesc", "estimatedDeliveryTime", "showText", "restaurantName", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCrateTime", "()J", "getEstimatedDeliveryTime", "()Ljava/lang/String;", "setEstimatedDeliveryTime", "(Ljava/lang/String;)V", "getId", "getPackageName", "getReminderType", "getRestaurantName", "setRestaurantName", "getShowText", "setShowText", "getTakeoutState", "setTakeoutState", "getTakeoutStateDesc", "setTakeoutStateDesc", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
@Entity
public final class ArTakeoutModel {
    @ColumnInfo
    private final long crateTime;
    @ColumnInfo
    @NotNull
    private String estimatedDeliveryTime;
    @ColumnInfo
    @NotNull
    @PrimaryKey
    private final String id;
    @ColumnInfo
    @NotNull
    private final String packageName;
    @ColumnInfo
    @NotNull
    private final String reminderType;
    @ColumnInfo
    @NotNull
    private String restaurantName;
    @ColumnInfo
    @NotNull
    private String showText;
    @ColumnInfo
    @NotNull
    private String takeoutState;
    @ColumnInfo
    @NotNull
    private String takeoutStateDesc;

    public ArTakeoutModel(@NotNull String str, long j, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "reminderType");
        Intrinsics.checkNotNullParameter(str3, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(str4, "takeoutState");
        Intrinsics.checkNotNullParameter(str5, "takeoutStateDesc");
        Intrinsics.checkNotNullParameter(str6, "estimatedDeliveryTime");
        Intrinsics.checkNotNullParameter(str7, "showText");
        Intrinsics.checkNotNullParameter(str8, "restaurantName");
        this.id = str;
        this.crateTime = j;
        this.reminderType = str2;
        this.packageName = str3;
        this.takeoutState = str4;
        this.takeoutStateDesc = str5;
        this.estimatedDeliveryTime = str6;
        this.showText = str7;
        this.restaurantName = str8;
    }

    public final long getCrateTime() {
        return this.crateTime;
    }

    @NotNull
    public final String getEstimatedDeliveryTime() {
        return this.estimatedDeliveryTime;
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

    @NotNull
    public final String getRestaurantName() {
        return this.restaurantName;
    }

    @NotNull
    public final String getShowText() {
        return this.showText;
    }

    @NotNull
    public final String getTakeoutState() {
        return this.takeoutState;
    }

    @NotNull
    public final String getTakeoutStateDesc() {
        return this.takeoutStateDesc;
    }

    public final void setEstimatedDeliveryTime(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.estimatedDeliveryTime = str;
    }

    public final void setRestaurantName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.restaurantName = str;
    }

    public final void setShowText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.showText = str;
    }

    public final void setTakeoutState(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.takeoutState = str;
    }

    public final void setTakeoutStateDesc(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.takeoutStateDesc = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ArTakeoutModel(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, (i & 4) != 0 ? ReminderType.MSG_TYPE_TAKEOUT : str2, str3, str4, str5, str6, str7, str8);
    }
}
