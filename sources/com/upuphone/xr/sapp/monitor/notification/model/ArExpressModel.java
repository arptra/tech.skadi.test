package com.upuphone.xr.sapp.monitor.notification.model;

import androidx.annotation.Keep;
import com.upuphone.xr.sapp.monitor.notification.constants.ReminderType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/model/ArExpressModel;", "Lcom/upuphone/xr/sapp/monitor/notification/model/ReminderBaseModel;", "id", "", "packageName", "crateTime", "", "title", "content", "expressState", "expressStateDesc", "lastModifyTime", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getContent", "()Ljava/lang/String;", "getExpressState", "getExpressStateDesc", "getLastModifyTime", "()J", "getTitle", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class ArExpressModel extends ReminderBaseModel {
    @NotNull
    private final String content;
    @NotNull
    private final String expressState;
    @NotNull
    private final String expressStateDesc;
    private final long lastModifyTime;
    @NotNull
    private final String title;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArExpressModel(@NotNull String str, @NotNull String str2, long j, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, long j2) {
        super(str, j, ReminderType.MSG_TYPE_EXPRESS, str2);
        String str7 = str3;
        String str8 = str4;
        String str9 = str5;
        String str10 = str6;
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(str7, "title");
        Intrinsics.checkNotNullParameter(str8, "content");
        Intrinsics.checkNotNullParameter(str9, "expressState");
        Intrinsics.checkNotNullParameter(str10, "expressStateDesc");
        this.title = str7;
        this.content = str8;
        this.expressState = str9;
        this.expressStateDesc = str10;
        this.lastModifyTime = j2;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final String getExpressState() {
        return this.expressState;
    }

    @NotNull
    public final String getExpressStateDesc() {
        return this.expressStateDesc;
    }

    public final long getLastModifyTime() {
        return this.lastModifyTime;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
