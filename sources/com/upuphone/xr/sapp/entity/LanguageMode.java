package com.upuphone.xr.sapp.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/entity/LanguageMode;", "", "languageStrId", "", "selectState", "", "language", "", "sort", "(IZLjava/lang/String;I)V", "getLanguage", "()Ljava/lang/String;", "getLanguageStrId", "()I", "getSelectState", "()Z", "setSelectState", "(Z)V", "getSort", "setSort", "(I)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LanguageMode {
    @NotNull
    private final String language;
    private final int languageStrId;
    private boolean selectState;
    private int sort;

    public LanguageMode(int i, boolean z, @NotNull String str, int i2) {
        Intrinsics.checkNotNullParameter(str, "language");
        this.languageStrId = i;
        this.selectState = z;
        this.language = str;
        this.sort = i2;
    }

    @NotNull
    public final String getLanguage() {
        return this.language;
    }

    public final int getLanguageStrId() {
        return this.languageStrId;
    }

    public final boolean getSelectState() {
        return this.selectState;
    }

    public final int getSort() {
        return this.sort;
    }

    public final void setSelectState(boolean z) {
        this.selectState = z;
    }

    public final void setSort(int i) {
        this.sort = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LanguageMode(int i, boolean z, String str, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? false : z, str, (i3 & 8) != 0 ? 0 : i2);
    }
}
