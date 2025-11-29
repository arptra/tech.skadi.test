package com.upuphone.ar.transcribe.phone.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/bean/TransRecord;", "", "()V", "pContent", "", "getPContent", "()Ljava/lang/String;", "setPContent", "(Ljava/lang/String;)V", "pTime", "getPTime", "setPTime", "rContent", "getRContent", "setRContent", "rContentDisplay", "", "getRContentDisplay", "()Z", "setRContentDisplay", "(Z)V", "rTime", "getRTime", "setRTime", "toString", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TransRecord {
    @NotNull
    private String pContent = "";
    @NotNull
    private String pTime = "";
    @NotNull
    private String rContent = "";
    private boolean rContentDisplay = true;
    @NotNull
    private String rTime = "";

    @NotNull
    public final String getPContent() {
        return this.pContent;
    }

    @NotNull
    public final String getPTime() {
        return this.pTime;
    }

    @NotNull
    public final String getRContent() {
        return this.rContent;
    }

    public final boolean getRContentDisplay() {
        return this.rContentDisplay;
    }

    @NotNull
    public final String getRTime() {
        return this.rTime;
    }

    public final void setPContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pContent = str;
    }

    public final void setPTime(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pTime = str;
    }

    public final void setRContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rContent = str;
    }

    public final void setRContentDisplay(boolean z) {
        this.rContentDisplay = z;
    }

    public final void setRTime(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rTime = str;
    }

    @NotNull
    public String toString() {
        String str = this.rTime;
        String str2 = this.rContent;
        boolean z = this.rContentDisplay;
        String str3 = this.pTime;
        String str4 = this.pContent;
        return "TransRecord(rTime='" + str + "', rContent='" + str2 + "', rContentDisplay=" + z + ", pTime='" + str3 + "', pContent='" + str4 + "')";
    }
}
