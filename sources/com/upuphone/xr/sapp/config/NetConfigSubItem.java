package com.upuphone.xr.sapp.config;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/upuphone/xr/sapp/config/NetConfigSubItem;", "", "()V", "id", "", "getId", "()I", "setId", "(I)V", "locale", "", "getLocale", "()Ljava/lang/String;", "setLocale", "(Ljava/lang/String;)V", "memo", "getMemo", "setMemo", "name", "getName", "setName", "timeZone", "getTimeZone", "setTimeZone", "url", "getUrl", "setUrl", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class NetConfigSubItem {
    private int id;
    @Nullable
    private String locale;
    @Nullable
    private String memo;
    @Nullable
    private String name;
    @Nullable
    private String timeZone;
    @Nullable
    private String url;

    public final int getId() {
        return this.id;
    }

    @Nullable
    public final String getLocale() {
        return this.locale;
    }

    @Nullable
    public final String getMemo() {
        return this.memo;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getTimeZone() {
        return this.timeZone;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setLocale(@Nullable String str) {
        this.locale = str;
    }

    public final void setMemo(@Nullable String str) {
        this.memo = str;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setTimeZone(@Nullable String str) {
        this.timeZone = str;
    }

    public final void setUrl(@Nullable String str) {
        this.url = str;
    }
}
