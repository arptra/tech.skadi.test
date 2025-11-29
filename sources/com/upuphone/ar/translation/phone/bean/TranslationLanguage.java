package com.upuphone.ar.translation.phone.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/upuphone/ar/translation/phone/bean/TranslationLanguage;", "", "src", "Lcom/upuphone/ar/translation/phone/bean/LanguageBean;", "dst", "(Lcom/upuphone/ar/translation/phone/bean/LanguageBean;Lcom/upuphone/ar/translation/phone/bean/LanguageBean;)V", "getDst", "()Lcom/upuphone/ar/translation/phone/bean/LanguageBean;", "getSrc", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranslationLanguage {
    @NotNull
    private final LanguageBean dst;
    @NotNull
    private final LanguageBean src;

    public TranslationLanguage(@NotNull LanguageBean languageBean, @NotNull LanguageBean languageBean2) {
        Intrinsics.checkNotNullParameter(languageBean, "src");
        Intrinsics.checkNotNullParameter(languageBean2, "dst");
        this.src = languageBean;
        this.dst = languageBean2;
    }

    public static /* synthetic */ TranslationLanguage copy$default(TranslationLanguage translationLanguage, LanguageBean languageBean, LanguageBean languageBean2, int i, Object obj) {
        if ((i & 1) != 0) {
            languageBean = translationLanguage.src;
        }
        if ((i & 2) != 0) {
            languageBean2 = translationLanguage.dst;
        }
        return translationLanguage.copy(languageBean, languageBean2);
    }

    @NotNull
    public final LanguageBean component1() {
        return this.src;
    }

    @NotNull
    public final LanguageBean component2() {
        return this.dst;
    }

    @NotNull
    public final TranslationLanguage copy(@NotNull LanguageBean languageBean, @NotNull LanguageBean languageBean2) {
        Intrinsics.checkNotNullParameter(languageBean, "src");
        Intrinsics.checkNotNullParameter(languageBean2, "dst");
        return new TranslationLanguage(languageBean, languageBean2);
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
    public final LanguageBean getDst() {
        return this.dst;
    }

    @NotNull
    public final LanguageBean getSrc() {
        return this.src;
    }

    public int hashCode() {
        return (this.src.hashCode() * 31) + this.dst.hashCode();
    }

    @NotNull
    public String toString() {
        LanguageBean languageBean = this.src;
        LanguageBean languageBean2 = this.dst;
        return "TranslationLanguage(src=" + languageBean + ", dst=" + languageBean2 + ")";
    }
}
