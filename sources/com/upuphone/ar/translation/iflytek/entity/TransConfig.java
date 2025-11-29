package com.upuphone.ar.translation.iflytek.entity;

import com.upuphone.ar.translation.iflytek.ext.StringExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\b\u0010\u001a\u001a\u00020\u0003H\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/upuphone/ar/translation/iflytek/entity/TransConfig;", "", "url", "", "appKey", "appId", "srcLang", "dstLang", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getAppKey", "getDstLang", "getSrcLang", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TransConfig {
    @NotNull
    private final String appId;
    @NotNull
    private final String appKey;
    @NotNull
    private final String dstLang;
    @NotNull
    private final String srcLang;
    @NotNull
    private final String url;

    public TransConfig(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "appKey");
        Intrinsics.checkNotNullParameter(str3, "appId");
        Intrinsics.checkNotNullParameter(str4, "srcLang");
        Intrinsics.checkNotNullParameter(str5, "dstLang");
        this.url = str;
        this.appKey = str2;
        this.appId = str3;
        this.srcLang = str4;
        this.dstLang = str5;
    }

    public static /* synthetic */ TransConfig copy$default(TransConfig transConfig, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = transConfig.url;
        }
        if ((i & 2) != 0) {
            str2 = transConfig.appKey;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = transConfig.appId;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = transConfig.srcLang;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = transConfig.dstLang;
        }
        return transConfig.copy(str, str6, str7, str8, str5);
    }

    @NotNull
    public final String component1() {
        return this.url;
    }

    @NotNull
    public final String component2() {
        return this.appKey;
    }

    @NotNull
    public final String component3() {
        return this.appId;
    }

    @NotNull
    public final String component4() {
        return this.srcLang;
    }

    @NotNull
    public final String component5() {
        return this.dstLang;
    }

    @NotNull
    public final TransConfig copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "appKey");
        Intrinsics.checkNotNullParameter(str3, "appId");
        Intrinsics.checkNotNullParameter(str4, "srcLang");
        Intrinsics.checkNotNullParameter(str5, "dstLang");
        return new TransConfig(str, str2, str3, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransConfig)) {
            return false;
        }
        TransConfig transConfig = (TransConfig) obj;
        return Intrinsics.areEqual((Object) this.url, (Object) transConfig.url) && Intrinsics.areEqual((Object) this.appKey, (Object) transConfig.appKey) && Intrinsics.areEqual((Object) this.appId, (Object) transConfig.appId) && Intrinsics.areEqual((Object) this.srcLang, (Object) transConfig.srcLang) && Intrinsics.areEqual((Object) this.dstLang, (Object) transConfig.dstLang);
    }

    @NotNull
    public final String getAppId() {
        return this.appId;
    }

    @NotNull
    public final String getAppKey() {
        return this.appKey;
    }

    @NotNull
    public final String getDstLang() {
        return this.dstLang;
    }

    @NotNull
    public final String getSrcLang() {
        return this.srcLang;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((((((this.url.hashCode() * 31) + this.appKey.hashCode()) * 31) + this.appId.hashCode()) * 31) + this.srcLang.hashCode()) * 31) + this.dstLang.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.url;
        String k = StringExtKt.k(this.appKey);
        String k2 = StringExtKt.k(this.appId);
        String str2 = this.srcLang;
        String str3 = this.dstLang;
        return "TransConfig(url='" + str + "', appKey='" + k + "', appId='" + k2 + "', srcLang='" + str2 + "', dstLang='" + str3 + "')";
    }
}
