package com.upuphone.ar.fastrecord.phone.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/bean/FastRecordLanguageBean;", "", "langName", "", "langType", "(Ljava/lang/String;Ljava/lang/String;)V", "getLangName", "()Ljava/lang/String;", "getLangType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordLanguageBean {
    @NotNull
    private final String langName;
    @NotNull
    private final String langType;

    public FastRecordLanguageBean(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "langName");
        Intrinsics.checkNotNullParameter(str2, "langType");
        this.langName = str;
        this.langType = str2;
    }

    public static /* synthetic */ FastRecordLanguageBean copy$default(FastRecordLanguageBean fastRecordLanguageBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fastRecordLanguageBean.langName;
        }
        if ((i & 2) != 0) {
            str2 = fastRecordLanguageBean.langType;
        }
        return fastRecordLanguageBean.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.langName;
    }

    @NotNull
    public final String component2() {
        return this.langType;
    }

    @NotNull
    public final FastRecordLanguageBean copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "langName");
        Intrinsics.checkNotNullParameter(str2, "langType");
        return new FastRecordLanguageBean(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FastRecordLanguageBean)) {
            return false;
        }
        FastRecordLanguageBean fastRecordLanguageBean = (FastRecordLanguageBean) obj;
        return Intrinsics.areEqual((Object) this.langName, (Object) fastRecordLanguageBean.langName) && Intrinsics.areEqual((Object) this.langType, (Object) fastRecordLanguageBean.langType);
    }

    @NotNull
    public final String getLangName() {
        return this.langName;
    }

    @NotNull
    public final String getLangType() {
        return this.langType;
    }

    public int hashCode() {
        return (this.langName.hashCode() * 31) + this.langType.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.langName;
        String str2 = this.langType;
        return "LanguageBean(langName='" + str + "', langType='" + str2 + "')";
    }
}
