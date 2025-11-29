package com.upuphone.ar.fastrecord.phone.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/bean/TranslationLanguage;", "", "src", "Lcom/upuphone/ar/fastrecord/phone/bean/FastRecordLanguageBean;", "dst", "(Lcom/upuphone/ar/fastrecord/phone/bean/FastRecordLanguageBean;Lcom/upuphone/ar/fastrecord/phone/bean/FastRecordLanguageBean;)V", "getDst", "()Lcom/upuphone/ar/fastrecord/phone/bean/FastRecordLanguageBean;", "getSrc", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranslationLanguage {
    @NotNull
    private final FastRecordLanguageBean dst;
    @NotNull
    private final FastRecordLanguageBean src;

    public TranslationLanguage(@NotNull FastRecordLanguageBean fastRecordLanguageBean, @NotNull FastRecordLanguageBean fastRecordLanguageBean2) {
        Intrinsics.checkNotNullParameter(fastRecordLanguageBean, "src");
        Intrinsics.checkNotNullParameter(fastRecordLanguageBean2, "dst");
        this.src = fastRecordLanguageBean;
        this.dst = fastRecordLanguageBean2;
    }

    public static /* synthetic */ TranslationLanguage copy$default(TranslationLanguage translationLanguage, FastRecordLanguageBean fastRecordLanguageBean, FastRecordLanguageBean fastRecordLanguageBean2, int i, Object obj) {
        if ((i & 1) != 0) {
            fastRecordLanguageBean = translationLanguage.src;
        }
        if ((i & 2) != 0) {
            fastRecordLanguageBean2 = translationLanguage.dst;
        }
        return translationLanguage.copy(fastRecordLanguageBean, fastRecordLanguageBean2);
    }

    @NotNull
    public final FastRecordLanguageBean component1() {
        return this.src;
    }

    @NotNull
    public final FastRecordLanguageBean component2() {
        return this.dst;
    }

    @NotNull
    public final TranslationLanguage copy(@NotNull FastRecordLanguageBean fastRecordLanguageBean, @NotNull FastRecordLanguageBean fastRecordLanguageBean2) {
        Intrinsics.checkNotNullParameter(fastRecordLanguageBean, "src");
        Intrinsics.checkNotNullParameter(fastRecordLanguageBean2, "dst");
        return new TranslationLanguage(fastRecordLanguageBean, fastRecordLanguageBean2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TranslationLanguage)) {
            return false;
        }
        TranslationLanguage translationLanguage = (TranslationLanguage) obj;
        return Intrinsics.areEqual((Object) this.src, (Object) translationLanguage.src) && Intrinsics.areEqual((Object) this.dst, (Object) translationLanguage.dst);
    }

    @NotNull
    public final FastRecordLanguageBean getDst() {
        return this.dst;
    }

    @NotNull
    public final FastRecordLanguageBean getSrc() {
        return this.src;
    }

    public int hashCode() {
        return (this.src.hashCode() * 31) + this.dst.hashCode();
    }

    @NotNull
    public String toString() {
        FastRecordLanguageBean fastRecordLanguageBean = this.src;
        FastRecordLanguageBean fastRecordLanguageBean2 = this.dst;
        return "TranslationLanguage(src=" + fastRecordLanguageBean + ", dst=" + fastRecordLanguageBean2 + ")";
    }
}
