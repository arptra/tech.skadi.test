package com.upuphone.xr.sapp.monitor.notification.model;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\fHÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003Jo\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0013\u0010.\u001a\u00020\f2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016¨\u00063"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/model/ArNotificationModel;", "", "id", "", "title", "content", "crateTime", "", "type", "packageName", "appName", "canReply", "", "extra", "aiResult", "Lcom/upuphone/xr/sapp/monitor/notification/model/DiscernResultModel;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/upuphone/xr/sapp/monitor/notification/model/DiscernResultModel;)V", "getAiResult", "()Lcom/upuphone/xr/sapp/monitor/notification/model/DiscernResultModel;", "setAiResult", "(Lcom/upuphone/xr/sapp/monitor/notification/model/DiscernResultModel;)V", "getAppName", "()Ljava/lang/String;", "getCanReply", "()Z", "setCanReply", "(Z)V", "getContent", "getCrateTime", "()J", "getExtra", "getId", "getPackageName", "getTitle", "getType", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class ArNotificationModel {
    @Nullable
    private DiscernResultModel aiResult;
    @NotNull
    private final String appName;
    private boolean canReply;
    @NotNull
    private final String content;
    private final long crateTime;
    @NotNull
    private final String extra;
    @NotNull
    private final String id;
    @NotNull
    private final String packageName;
    @NotNull
    private final String title;
    @NotNull
    private final String type;

    public ArNotificationModel(@NotNull String str, @NotNull String str2, @NotNull String str3, long j, @NotNull String str4, @NotNull String str5, @NotNull String str6, boolean z, @NotNull String str7, @Nullable DiscernResultModel discernResultModel) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "content");
        Intrinsics.checkNotNullParameter(str4, "type");
        Intrinsics.checkNotNullParameter(str5, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(str6, "appName");
        Intrinsics.checkNotNullParameter(str7, "extra");
        this.id = str;
        this.title = str2;
        this.content = str3;
        this.crateTime = j;
        this.type = str4;
        this.packageName = str5;
        this.appName = str6;
        this.canReply = z;
        this.extra = str7;
        this.aiResult = discernResultModel;
    }

    public static /* synthetic */ ArNotificationModel copy$default(ArNotificationModel arNotificationModel, String str, String str2, String str3, long j, String str4, String str5, String str6, boolean z, String str7, DiscernResultModel discernResultModel, int i, Object obj) {
        ArNotificationModel arNotificationModel2 = arNotificationModel;
        int i2 = i;
        return arNotificationModel.copy((i2 & 1) != 0 ? arNotificationModel2.id : str, (i2 & 2) != 0 ? arNotificationModel2.title : str2, (i2 & 4) != 0 ? arNotificationModel2.content : str3, (i2 & 8) != 0 ? arNotificationModel2.crateTime : j, (i2 & 16) != 0 ? arNotificationModel2.type : str4, (i2 & 32) != 0 ? arNotificationModel2.packageName : str5, (i2 & 64) != 0 ? arNotificationModel2.appName : str6, (i2 & 128) != 0 ? arNotificationModel2.canReply : z, (i2 & 256) != 0 ? arNotificationModel2.extra : str7, (i2 & 512) != 0 ? arNotificationModel2.aiResult : discernResultModel);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @Nullable
    public final DiscernResultModel component10() {
        return this.aiResult;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final String component3() {
        return this.content;
    }

    public final long component4() {
        return this.crateTime;
    }

    @NotNull
    public final String component5() {
        return this.type;
    }

    @NotNull
    public final String component6() {
        return this.packageName;
    }

    @NotNull
    public final String component7() {
        return this.appName;
    }

    public final boolean component8() {
        return this.canReply;
    }

    @NotNull
    public final String component9() {
        return this.extra;
    }

    @NotNull
    public final ArNotificationModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3, long j, @NotNull String str4, @NotNull String str5, @NotNull String str6, boolean z, @NotNull String str7, @Nullable DiscernResultModel discernResultModel) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        String str8 = str3;
        Intrinsics.checkNotNullParameter(str8, "content");
        String str9 = str4;
        Intrinsics.checkNotNullParameter(str9, "type");
        String str10 = str5;
        Intrinsics.checkNotNullParameter(str10, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        String str11 = str6;
        Intrinsics.checkNotNullParameter(str11, "appName");
        String str12 = str7;
        Intrinsics.checkNotNullParameter(str12, "extra");
        return new ArNotificationModel(str, str2, str8, j, str9, str10, str11, z, str12, discernResultModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ArNotificationModel)) {
            return false;
        }
        ArNotificationModel arNotificationModel = (ArNotificationModel) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) arNotificationModel.id) && Intrinsics.areEqual((Object) this.title, (Object) arNotificationModel.title) && Intrinsics.areEqual((Object) this.content, (Object) arNotificationModel.content) && this.crateTime == arNotificationModel.crateTime && Intrinsics.areEqual((Object) this.type, (Object) arNotificationModel.type) && Intrinsics.areEqual((Object) this.packageName, (Object) arNotificationModel.packageName) && Intrinsics.areEqual((Object) this.appName, (Object) arNotificationModel.appName) && this.canReply == arNotificationModel.canReply && Intrinsics.areEqual((Object) this.extra, (Object) arNotificationModel.extra) && Intrinsics.areEqual((Object) this.aiResult, (Object) arNotificationModel.aiResult);
    }

    @Nullable
    public final DiscernResultModel getAiResult() {
        return this.aiResult;
    }

    @NotNull
    public final String getAppName() {
        return this.appName;
    }

    public final boolean getCanReply() {
        return this.canReply;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public final long getCrateTime() {
        return this.crateTime;
    }

    @NotNull
    public final String getExtra() {
        return this.extra;
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
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.content.hashCode()) * 31) + Long.hashCode(this.crateTime)) * 31) + this.type.hashCode()) * 31) + this.packageName.hashCode()) * 31) + this.appName.hashCode()) * 31) + Boolean.hashCode(this.canReply)) * 31) + this.extra.hashCode()) * 31;
        DiscernResultModel discernResultModel = this.aiResult;
        return hashCode + (discernResultModel == null ? 0 : discernResultModel.hashCode());
    }

    public final void setAiResult(@Nullable DiscernResultModel discernResultModel) {
        this.aiResult = discernResultModel;
    }

    public final void setCanReply(boolean z) {
        this.canReply = z;
    }

    @NotNull
    public String toString() {
        String str = this.id;
        String str2 = this.title;
        String str3 = this.content;
        long j = this.crateTime;
        String str4 = this.type;
        String str5 = this.packageName;
        String str6 = this.appName;
        boolean z = this.canReply;
        String str7 = this.extra;
        DiscernResultModel discernResultModel = this.aiResult;
        return "ArNotificationModel(id=" + str + ", title=" + str2 + ", content=" + str3 + ", crateTime=" + j + ", type=" + str4 + ", packageName=" + str5 + ", appName=" + str6 + ", canReply=" + z + ", extra=" + str7 + ", aiResult=" + discernResultModel + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ArNotificationModel(java.lang.String r15, java.lang.String r16, java.lang.String r17, long r18, java.lang.String r20, java.lang.String r21, java.lang.String r22, boolean r23, java.lang.String r24, com.upuphone.xr.sapp.monitor.notification.model.DiscernResultModel r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r14 = this;
            r0 = r26
            r1 = r0 & 16
            if (r1 == 0) goto L_0x000a
            java.lang.String r1 = "MSG_TYPE_NORMAL"
            r8 = r1
            goto L_0x000c
        L_0x000a:
            r8 = r20
        L_0x000c:
            r1 = r0 & 32
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0014
            r9 = r2
            goto L_0x0016
        L_0x0014:
            r9 = r21
        L_0x0016:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x001c
            r10 = r2
            goto L_0x001e
        L_0x001c:
            r10 = r22
        L_0x001e:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0025
            r1 = 0
            r11 = r1
            goto L_0x0027
        L_0x0025:
            r11 = r23
        L_0x0027:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0030
            java.lang.String r1 = "{}"
            r12 = r1
            goto L_0x0032
        L_0x0030:
            r12 = r24
        L_0x0032:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0039
            r0 = 0
            r13 = r0
            goto L_0x003b
        L_0x0039:
            r13 = r25
        L_0x003b:
            r2 = r14
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r2.<init>(r3, r4, r5, r6, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.monitor.notification.model.ArNotificationModel.<init>(java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, com.upuphone.xr.sapp.monitor.notification.model.DiscernResultModel, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
