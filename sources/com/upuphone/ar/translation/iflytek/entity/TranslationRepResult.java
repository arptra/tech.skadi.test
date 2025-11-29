package com.upuphone.ar.translation.iflytek.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/upuphone/ar/translation/iflytek/entity/TranslationRepResult;", "", "src", "Lcom/upuphone/ar/translation/iflytek/entity/Src;", "dst", "Lcom/upuphone/ar/translation/iflytek/entity/Dst;", "(Lcom/upuphone/ar/translation/iflytek/entity/Src;Lcom/upuphone/ar/translation/iflytek/entity/Dst;)V", "getDst", "()Lcom/upuphone/ar/translation/iflytek/entity/Dst;", "getSrc", "()Lcom/upuphone/ar/translation/iflytek/entity/Src;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranslationRepResult {
    @SerializedName("dst")
    @Nullable
    private final Dst dst;
    @SerializedName("src")
    @Nullable
    private final Src src;

    public TranslationRepResult() {
        this((Src) null, (Dst) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TranslationRepResult copy$default(TranslationRepResult translationRepResult, Src src2, Dst dst2, int i, Object obj) {
        if ((i & 1) != 0) {
            src2 = translationRepResult.src;
        }
        if ((i & 2) != 0) {
            dst2 = translationRepResult.dst;
        }
        return translationRepResult.copy(src2, dst2);
    }

    @Nullable
    public final Src component1() {
        return this.src;
    }

    @Nullable
    public final Dst component2() {
        return this.dst;
    }

    @NotNull
    public final TranslationRepResult copy(@Nullable Src src2, @Nullable Dst dst2) {
        return new TranslationRepResult(src2, dst2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TranslationRepResult)) {
            return false;
        }
        TranslationRepResult translationRepResult = (TranslationRepResult) obj;
        return Intrinsics.areEqual((Object) this.src, (Object) translationRepResult.src) && Intrinsics.areEqual((Object) this.dst, (Object) translationRepResult.dst);
    }

    @Nullable
    public final Dst getDst() {
        return this.dst;
    }

    @Nullable
    public final Src getSrc() {
        return this.src;
    }

    public int hashCode() {
        Src src2 = this.src;
        int i = 0;
        int hashCode = (src2 == null ? 0 : src2.hashCode()) * 31;
        Dst dst2 = this.dst;
        if (dst2 != null) {
            i = dst2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        Src src2 = this.src;
        Dst dst2 = this.dst;
        return "TranslationRepResult(src=" + src2 + ", dst=" + dst2 + ")";
    }

    public TranslationRepResult(@Nullable Src src2, @Nullable Dst dst2) {
        this.src = src2;
        this.dst = dst2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TranslationRepResult(Src src2, Dst dst2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : src2, (i & 2) != 0 ? null : dst2);
    }
}
