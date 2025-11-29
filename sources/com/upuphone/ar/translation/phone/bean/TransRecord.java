package com.upuphone.ar.translation.phone.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/upuphone/ar/translation/phone/bean/TransRecord;", "", "()V", "pContent", "", "getPContent", "()Ljava/lang/String;", "setPContent", "(Ljava/lang/String;)V", "rContent", "getRContent", "setRContent", "rContentDisplay", "", "getRContentDisplay", "()Z", "setRContentDisplay", "(Z)V", "rContentIndex", "getRContentIndex", "setRContentIndex", "toString", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TransRecord {
    @NotNull
    private String pContent = "";
    @NotNull
    private String rContent = "";
    private boolean rContentDisplay;
    @NotNull
    private String rContentIndex = "";

    @NotNull
    public final String getPContent() {
        return this.pContent;
    }

    @NotNull
    public final String getRContent() {
        return this.rContent;
    }

    public final boolean getRContentDisplay() {
        return this.rContentDisplay;
    }

    @NotNull
    public final String getRContentIndex() {
        return this.rContentIndex;
    }

    public final void setPContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pContent = str;
    }

    public final void setRContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rContent = str;
    }

    public final void setRContentDisplay(boolean z) {
        this.rContentDisplay = z;
    }

    public final void setRContentIndex(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rContentIndex = str;
    }

    @NotNull
    public String toString() {
        String str = this.rContent;
        boolean z = this.rContentDisplay;
        String str2 = this.rContentIndex;
        String str3 = this.pContent;
        return "TransRecord(rContent='" + str + "', rContentDisplay=" + z + ", rContentIndex='" + str2 + "', pContent='" + str3 + "')";
    }
}
