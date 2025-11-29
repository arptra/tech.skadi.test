package com.upuphone.ar.translation.phone.bean;

import androidx.annotation.Keep;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.xjsd.xr.sapp.asr.utils.AsrExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010&\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\u001a\u0010\u001d\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\u001e\u0010 \u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\u001a\u0010#\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\b¨\u0006'"}, d2 = {"Lcom/upuphone/ar/translation/phone/bean/IntelExtnSummary;", "", "()V", "accountId", "", "getAccountId", "()Ljava/lang/String;", "setAccountId", "(Ljava/lang/String;)V", "deleteStatus", "", "getDeleteStatus", "()I", "setDeleteStatus", "(I)V", "id", "", "getId", "()J", "setId", "(J)V", "isReported", "", "()Z", "setReported", "(Z)V", "originalSummary", "getOriginalSummary", "setOriginalSummary", "recognizeId", "getRecognizeId", "setRecognizeId", "requestId", "getRequestId", "setRequestId", "summary", "getSummary", "setSummary", "toString", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
@Entity
public final class IntelExtnSummary {
    @NotNull
    private String accountId = "";
    @ColumnInfo
    private int deleteStatus;
    @PrimaryKey
    private long id;
    @ColumnInfo
    private boolean isReported;
    @ColumnInfo
    @NotNull
    private String originalSummary = "";
    @NotNull
    private String recognizeId = "";
    @ColumnInfo
    @NotNull
    private String requestId = "";
    @NotNull
    private String summary = "";

    @NotNull
    public final String getAccountId() {
        return this.accountId;
    }

    public final int getDeleteStatus() {
        return this.deleteStatus;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getOriginalSummary() {
        return this.originalSummary;
    }

    @NotNull
    public final String getRecognizeId() {
        return this.recognizeId;
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    @NotNull
    public final String getSummary() {
        return this.summary;
    }

    public final boolean isReported() {
        return this.isReported;
    }

    public final void setAccountId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.accountId = str;
    }

    public final void setDeleteStatus(int i) {
        this.deleteStatus = i;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final void setOriginalSummary(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.originalSummary = str;
    }

    public final void setRecognizeId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.recognizeId = str;
    }

    public final void setReported(boolean z) {
        this.isReported = z;
    }

    public final void setRequestId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.requestId = str;
    }

    public final void setSummary(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.summary = str;
    }

    @NotNull
    public String toString() {
        long j = this.id;
        String mixSpecialData = AsrExtKt.mixSpecialData(this.accountId);
        String str = this.recognizeId;
        String str2 = this.requestId;
        String str3 = this.summary;
        String str4 = this.originalSummary;
        int i = this.deleteStatus;
        boolean z = this.isReported;
        return "IntelExtnSummary(id=" + j + ", accountId='" + mixSpecialData + "', recognizeId='" + str + "', requestId='" + str2 + "', summary='" + str3 + "', originalSummary='" + str4 + "', deleteStatus=" + i + ", isReported=" + z + ")";
    }
}
