package com.upuphone.ar.translation.phone.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/upuphone/ar/translation/phone/bean/NoteDetailUpdateBean;", "", "()V", "dst", "", "getDst", "()Ljava/lang/String;", "setDst", "(Ljava/lang/String;)V", "src", "getSrc", "setSrc", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NoteDetailUpdateBean {
    @NotNull
    private String dst = "";
    @NotNull
    private String src = "";

    @NotNull
    public final String getDst() {
        return this.dst;
    }

    @NotNull
    public final String getSrc() {
        return this.src;
    }

    public final void setDst(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dst = str;
    }

    public final void setSrc(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.src = str;
    }
}
