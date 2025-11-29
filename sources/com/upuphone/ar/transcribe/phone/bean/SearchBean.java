package com.upuphone.ar.transcribe.phone.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003JQ\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0006HÖ\u0001J\t\u0010#\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/bean/SearchBean;", "", "id", "", "recordTime", "type", "", "superTitle", "", "simpleLocation", "messageId", "message", "(JJILjava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getId", "()J", "getMessage", "()Ljava/lang/String;", "getMessageId", "getRecordTime", "getSimpleLocation", "getSuperTitle", "getType", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SearchBean {
    private final long id;
    @NotNull
    private final String message;
    private final long messageId;
    private final long recordTime;
    @Nullable
    private final String simpleLocation;
    @NotNull
    private final String superTitle;
    private final int type;

    public SearchBean(long j, long j2, int i, @NotNull String str, @Nullable String str2, long j3, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "superTitle");
        Intrinsics.checkNotNullParameter(str3, "message");
        this.id = j;
        this.recordTime = j2;
        this.type = i;
        this.superTitle = str;
        this.simpleLocation = str2;
        this.messageId = j3;
        this.message = str3;
    }

    public static /* synthetic */ SearchBean copy$default(SearchBean searchBean, long j, long j2, int i, String str, String str2, long j3, String str3, int i2, Object obj) {
        SearchBean searchBean2 = searchBean;
        return searchBean.copy((i2 & 1) != 0 ? searchBean2.id : j, (i2 & 2) != 0 ? searchBean2.recordTime : j2, (i2 & 4) != 0 ? searchBean2.type : i, (i2 & 8) != 0 ? searchBean2.superTitle : str, (i2 & 16) != 0 ? searchBean2.simpleLocation : str2, (i2 & 32) != 0 ? searchBean2.messageId : j3, (i2 & 64) != 0 ? searchBean2.message : str3);
    }

    public final long component1() {
        return this.id;
    }

    public final long component2() {
        return this.recordTime;
    }

    public final int component3() {
        return this.type;
    }

    @NotNull
    public final String component4() {
        return this.superTitle;
    }

    @Nullable
    public final String component5() {
        return this.simpleLocation;
    }

    public final long component6() {
        return this.messageId;
    }

    @NotNull
    public final String component7() {
        return this.message;
    }

    @NotNull
    public final SearchBean copy(long j, long j2, int i, @NotNull String str, @Nullable String str2, long j3, @NotNull String str3) {
        String str4 = str;
        Intrinsics.checkNotNullParameter(str4, "superTitle");
        String str5 = str3;
        Intrinsics.checkNotNullParameter(str5, "message");
        return new SearchBean(j, j2, i, str4, str2, j3, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchBean)) {
            return false;
        }
        SearchBean searchBean = (SearchBean) obj;
        return this.id == searchBean.id && this.recordTime == searchBean.recordTime && this.type == searchBean.type && Intrinsics.areEqual((Object) this.superTitle, (Object) searchBean.superTitle) && Intrinsics.areEqual((Object) this.simpleLocation, (Object) searchBean.simpleLocation) && this.messageId == searchBean.messageId && Intrinsics.areEqual((Object) this.message, (Object) searchBean.message);
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final long getRecordTime() {
        return this.recordTime;
    }

    @Nullable
    public final String getSimpleLocation() {
        return this.simpleLocation;
    }

    @NotNull
    public final String getSuperTitle() {
        return this.superTitle;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = ((((((Long.hashCode(this.id) * 31) + Long.hashCode(this.recordTime)) * 31) + Integer.hashCode(this.type)) * 31) + this.superTitle.hashCode()) * 31;
        String str = this.simpleLocation;
        return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.messageId)) * 31) + this.message.hashCode();
    }

    @NotNull
    public String toString() {
        long j = this.id;
        long j2 = this.recordTime;
        int i = this.type;
        String str = this.superTitle;
        String str2 = this.simpleLocation;
        long j3 = this.messageId;
        String str3 = this.message;
        return "SearchBean(id=" + j + ", recordTime=" + j2 + ", type=" + i + ", superTitle=" + str + ", simpleLocation=" + str2 + ", messageId=" + j3 + ", message=" + str3 + ")";
    }
}
