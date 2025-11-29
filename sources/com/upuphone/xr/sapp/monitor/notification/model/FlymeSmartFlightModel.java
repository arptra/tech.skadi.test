package com.upuphone.xr.sapp.monitor.notification.model;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b!\b\u0007\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005¢\u0006\u0002\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\r\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001a\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u001a\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010#R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0013¨\u0006&"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/model/FlymeSmartFlightModel;", "", "id", "", "crateTime", "", "reminderType", "packageName", "flightNumber", "flightStateDesc", "flightDepartureTime", "flightDepartureAerodrome", "flightArrivalTime", "flightArrivalAerodrome", "lastUpdateTime", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getCrateTime", "()J", "getFlightArrivalAerodrome", "()Ljava/lang/String;", "setFlightArrivalAerodrome", "(Ljava/lang/String;)V", "getFlightArrivalTime", "setFlightArrivalTime", "getFlightDepartureAerodrome", "setFlightDepartureAerodrome", "getFlightDepartureTime", "setFlightDepartureTime", "getFlightNumber", "setFlightNumber", "getFlightStateDesc", "setFlightStateDesc", "getId", "getLastUpdateTime", "setLastUpdateTime", "(J)V", "getPackageName", "getReminderType", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class FlymeSmartFlightModel {
    private final long crateTime;
    @NotNull
    private String flightArrivalAerodrome;
    @NotNull
    private String flightArrivalTime;
    @NotNull
    private String flightDepartureAerodrome;
    @NotNull
    private String flightDepartureTime;
    @NotNull
    private String flightNumber;
    @NotNull
    private String flightStateDesc;
    @NotNull
    private final String id;
    private long lastUpdateTime;
    @NotNull
    private final String packageName;
    @NotNull
    private final String reminderType;

    public FlymeSmartFlightModel(@NotNull String str, long j, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, long j2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "reminderType");
        Intrinsics.checkNotNullParameter(str3, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(str4, "flightNumber");
        Intrinsics.checkNotNullParameter(str5, "flightStateDesc");
        Intrinsics.checkNotNullParameter(str6, "flightDepartureTime");
        Intrinsics.checkNotNullParameter(str7, "flightDepartureAerodrome");
        Intrinsics.checkNotNullParameter(str8, "flightArrivalTime");
        Intrinsics.checkNotNullParameter(str9, "flightArrivalAerodrome");
        this.id = str;
        this.crateTime = j;
        this.reminderType = str2;
        this.packageName = str3;
        this.flightNumber = str4;
        this.flightStateDesc = str5;
        this.flightDepartureTime = str6;
        this.flightDepartureAerodrome = str7;
        this.flightArrivalTime = str8;
        this.flightArrivalAerodrome = str9;
        this.lastUpdateTime = j2;
    }

    public final long getCrateTime() {
        return this.crateTime;
    }

    @NotNull
    public final String getFlightArrivalAerodrome() {
        return this.flightArrivalAerodrome;
    }

    @NotNull
    public final String getFlightArrivalTime() {
        return this.flightArrivalTime;
    }

    @NotNull
    public final String getFlightDepartureAerodrome() {
        return this.flightDepartureAerodrome;
    }

    @NotNull
    public final String getFlightDepartureTime() {
        return this.flightDepartureTime;
    }

    @NotNull
    public final String getFlightNumber() {
        return this.flightNumber;
    }

    @NotNull
    public final String getFlightStateDesc() {
        return this.flightStateDesc;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    @NotNull
    public final String getReminderType() {
        return this.reminderType;
    }

    public final void setFlightArrivalAerodrome(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.flightArrivalAerodrome = str;
    }

    public final void setFlightArrivalTime(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.flightArrivalTime = str;
    }

    public final void setFlightDepartureAerodrome(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.flightDepartureAerodrome = str;
    }

    public final void setFlightDepartureTime(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.flightDepartureTime = str;
    }

    public final void setFlightNumber(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.flightNumber = str;
    }

    public final void setFlightStateDesc(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.flightStateDesc = str;
    }

    public final void setLastUpdateTime(long j) {
        this.lastUpdateTime = j;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FlymeSmartFlightModel(java.lang.String r17, long r18, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, long r28, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
        /*
            r16 = this;
            r0 = r30
            r1 = r0 & 4
            if (r1 == 0) goto L_0x000a
            java.lang.String r1 = "MSG_TYPE_FLIGHT"
            r6 = r1
            goto L_0x000c
        L_0x000a:
            r6 = r20
        L_0x000c:
            r1 = r0 & 16
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0014
            r8 = r2
            goto L_0x0016
        L_0x0014:
            r8 = r22
        L_0x0016:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x001c
            r9 = r2
            goto L_0x001e
        L_0x001c:
            r9 = r23
        L_0x001e:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0024
            r10 = r2
            goto L_0x0026
        L_0x0024:
            r10 = r24
        L_0x0026:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x002c
            r11 = r2
            goto L_0x002e
        L_0x002c:
            r11 = r25
        L_0x002e:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0034
            r12 = r2
            goto L_0x0036
        L_0x0034:
            r12 = r26
        L_0x0036:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x003c
            r13 = r2
            goto L_0x003e
        L_0x003c:
            r13 = r27
        L_0x003e:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0046
            r0 = 0
            r14 = r0
            goto L_0x0048
        L_0x0046:
            r14 = r28
        L_0x0048:
            r2 = r16
            r3 = r17
            r4 = r18
            r7 = r21
            r2.<init>(r3, r4, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.monitor.notification.model.FlymeSmartFlightModel.<init>(java.lang.String, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
