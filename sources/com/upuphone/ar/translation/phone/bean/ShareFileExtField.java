package com.upuphone.ar.translation.phone.bean;

import com.google.gson.annotations.SerializedName;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/upuphone/ar/translation/phone/bean/ShareFileExtField;", "", "serviceProvider", "", "time", "contentID", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContentID", "()Ljava/lang/String;", "getServiceProvider", "getTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ShareFileExtField {
    @SerializedName("ContentID")
    @NotNull
    private final String contentID;
    @SerializedName("ServiceProvider")
    @NotNull
    private final String serviceProvider;
    @SerializedName("Time")
    @NotNull
    private final String time;

    public ShareFileExtField() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShareFileExtField copy$default(ShareFileExtField shareFileExtField, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shareFileExtField.serviceProvider;
        }
        if ((i & 2) != 0) {
            str2 = shareFileExtField.time;
        }
        if ((i & 4) != 0) {
            str3 = shareFileExtField.contentID;
        }
        return shareFileExtField.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.serviceProvider;
    }

    @NotNull
    public final String component2() {
        return this.time;
    }

    @NotNull
    public final String component3() {
        return this.contentID;
    }

    @NotNull
    public final ShareFileExtField copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "serviceProvider");
        Intrinsics.checkNotNullParameter(str2, RtspHeaders.Values.TIME);
        Intrinsics.checkNotNullParameter(str3, "contentID");
        return new ShareFileExtField(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShareFileExtField)) {
            return false;
        }
        ShareFileExtField shareFileExtField = (ShareFileExtField) obj;
        return Intrinsics.areEqual((Object) this.serviceProvider, (Object) shareFileExtField.serviceProvider) && Intrinsics.areEqual((Object) this.time, (Object) shareFileExtField.time) && Intrinsics.areEqual((Object) this.contentID, (Object) shareFileExtField.contentID);
    }

    @NotNull
    public final String getContentID() {
        return this.contentID;
    }

    @NotNull
    public final String getServiceProvider() {
        return this.serviceProvider;
    }

    @NotNull
    public final String getTime() {
        return this.time;
    }

    public int hashCode() {
        return (((this.serviceProvider.hashCode() * 31) + this.time.hashCode()) * 31) + this.contentID.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.serviceProvider;
        String str2 = this.time;
        String str3 = this.contentID;
        return "ShareFileExtField(serviceProvider=" + str + ", time=" + str2 + ", contentID=" + str3 + ")";
    }

    public ShareFileExtField(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "serviceProvider");
        Intrinsics.checkNotNullParameter(str2, RtspHeaders.Values.TIME);
        Intrinsics.checkNotNullParameter(str3, "contentID");
        this.serviceProvider = str;
        this.time = str2;
        this.contentID = str3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ShareFileExtField(java.lang.String r3, java.lang.String r4, java.lang.String r5, int r6, kotlin.jvm.internal.DefaultConstructorMarker r7) {
        /*
            r2 = this;
            r7 = r6 & 1
            if (r7 == 0) goto L_0x0006
            java.lang.String r3 = "DreamSmart"
        L_0x0006:
            r7 = r6 & 2
            if (r7 == 0) goto L_0x0019
            long r0 = com.upuphone.ar.translation.utils.DateUtils.e()
            r4 = 8
            java.lang.String r4 = com.upuphone.ar.translation.utils.DateUtils.c(r0, r4)
            java.lang.String r7 = "formatDateTime(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)
        L_0x0019:
            r6 = r6 & 4
            if (r6 == 0) goto L_0x002b
            java.util.UUID r5 = java.util.UUID.randomUUID()
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
        L_0x002b:
            r2.<init>(r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.bean.ShareFileExtField.<init>(java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
