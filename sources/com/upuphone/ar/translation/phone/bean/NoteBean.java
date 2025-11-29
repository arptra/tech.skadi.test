package com.upuphone.ar.translation.phone.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.litepal.annotation.Column;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010>\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR\u001a\u0010&\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001b\"\u0004\b(\u0010\u001dR\u001a\u0010)\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR\u001a\u0010,\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR\u001a\u0010/\u001a\u000200X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\bR\u001a\u00108\u001a\u000200X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00102\"\u0004\b:\u00104R\u001a\u0010;\u001a\u000200X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00102\"\u0004\b=\u00104¨\u0006?"}, d2 = {"Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "Lcom/upuphone/ar/translation/phone/bean/BaseLitePalSupport;", "()V", "accountId", "", "getAccountId", "()Ljava/lang/String;", "setAccountId", "(Ljava/lang/String;)V", "content", "getContent", "setContent", "dstContent", "getDstContent", "setDstContent", "dstLanguage", "getDstLanguage", "setDstLanguage", "geoAddress", "getGeoAddress", "setGeoAddress", "geoLocation", "getGeoLocation", "setGeoLocation", "id", "", "getId", "()J", "setId", "(J)V", "isDeleted", "", "()Z", "setDeleted", "(Z)V", "recognizeId", "getRecognizeId", "setRecognizeId", "recordTime", "getRecordTime", "setRecordTime", "srcContent", "getSrcContent", "setSrcContent", "srcLanguage", "getSrcLanguage", "setSrcLanguage", "telephoneTrans", "", "getTelephoneTrans", "()I", "setTelephoneTrans", "(I)V", "title", "getTitle", "setTitle", "transType", "getTransType", "setTransType", "xrType", "getXrType", "setXrType", "toString", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NoteBean extends BaseLitePalSupport {
    @NotNull
    private String accountId = "";
    @NotNull
    @Column(ignore = true)
    private String content = "";
    @NotNull
    private String dstContent = "";
    @NotNull
    private String dstLanguage = "";
    @NotNull
    private String geoAddress = "";
    @NotNull
    private String geoLocation = "";
    private long id = -1;
    @Column(ignore = true)
    private boolean isDeleted;
    @NotNull
    private String recognizeId = "";
    private long recordTime;
    @NotNull
    private String srcContent = "";
    @NotNull
    private String srcLanguage = "";
    private int telephoneTrans;
    @NotNull
    private String title = "";
    private int transType = 2;
    private int xrType;

    @NotNull
    public final String getAccountId() {
        return this.accountId;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final String getDstContent() {
        return this.dstContent;
    }

    @NotNull
    public final String getDstLanguage() {
        return this.dstLanguage;
    }

    @NotNull
    public final String getGeoAddress() {
        return this.geoAddress;
    }

    @NotNull
    public final String getGeoLocation() {
        return this.geoLocation;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getRecognizeId() {
        return this.recognizeId;
    }

    public final long getRecordTime() {
        return this.recordTime;
    }

    @NotNull
    public final String getSrcContent() {
        return this.srcContent;
    }

    @NotNull
    public final String getSrcLanguage() {
        return this.srcLanguage;
    }

    public final int getTelephoneTrans() {
        return this.telephoneTrans;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final int getTransType() {
        return this.transType;
    }

    public final int getXrType() {
        return this.xrType;
    }

    public final boolean isDeleted() {
        return this.isDeleted;
    }

    public final void setAccountId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.accountId = str;
    }

    public final void setContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final void setDeleted(boolean z) {
        this.isDeleted = z;
    }

    public final void setDstContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dstContent = str;
    }

    public final void setDstLanguage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dstLanguage = str;
    }

    public final void setGeoAddress(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.geoAddress = str;
    }

    public final void setGeoLocation(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.geoLocation = str;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final void setRecognizeId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.recognizeId = str;
    }

    public final void setRecordTime(long j) {
        this.recordTime = j;
    }

    public final void setSrcContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.srcContent = str;
    }

    public final void setSrcLanguage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.srcLanguage = str;
    }

    public final void setTelephoneTrans(int i) {
        this.telephoneTrans = i;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void setTransType(int i) {
        this.transType = i;
    }

    public final void setXrType(int i) {
        this.xrType = i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        long j = this.id;
        sb.append("1. id=" + j);
        long j2 = this.recordTime;
        sb.append(", recordTime=" + j2);
        int i = this.transType;
        sb.append(", transType=" + i);
        int i2 = this.xrType;
        sb.append(", xrType=" + i2);
        int i3 = this.telephoneTrans;
        sb.append(", telephoneTrans=" + i3);
        String str = this.title;
        sb.append(", title=" + str);
        String str2 = this.content;
        sb.append(", content=" + str2);
        String str3 = this.geoLocation;
        sb.append(", geoLocation=" + str3);
        String str4 = this.geoAddress;
        sb.append(", geoAddress=" + str4);
        String str5 = this.recognizeId;
        sb.append(", recognizeId=" + str5);
        String str6 = this.accountId;
        sb.append(", accountId=" + str6);
        boolean z = this.isDeleted;
        sb.append(", isDeleted=" + z);
        String str7 = this.srcLanguage;
        sb.append(", srcLanguage=" + str7);
        String str8 = this.dstLanguage;
        sb.append(", dstLanguage=" + str8);
        sb.append(StringUtils.LF);
        String str9 = this.srcContent;
        sb.append("2. srcContent=" + str9);
        sb.append(StringUtils.LF);
        String str10 = this.dstContent;
        sb.append("3. dstContent=" + str10);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
