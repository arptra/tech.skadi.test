package com.upuphone.ar.transcribe.interconnect.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ.\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/upuphone/ar/transcribe/interconnect/entity/TranslationStateEntity;", "", "transState", "", "extCode", "ttsTime", "", "(IILjava/lang/Long;)V", "getExtCode", "()I", "getTransState", "getTtsTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(IILjava/lang/Long;)Lcom/upuphone/ar/transcribe/interconnect/entity/TranslationStateEntity;", "equals", "", "other", "hashCode", "toString", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranslationStateEntity {
    @SerializedName("extCode")
    private final int extCode;
    @SerializedName("transState")
    private final int transState;
    @Nullable
    private final Long ttsTime;

    public TranslationStateEntity(int i, int i2, @Nullable Long l) {
        this.transState = i;
        this.extCode = i2;
        this.ttsTime = l;
    }

    public static /* synthetic */ TranslationStateEntity copy$default(TranslationStateEntity translationStateEntity, int i, int i2, Long l, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = translationStateEntity.transState;
        }
        if ((i3 & 2) != 0) {
            i2 = translationStateEntity.extCode;
        }
        if ((i3 & 4) != 0) {
            l = translationStateEntity.ttsTime;
        }
        return translationStateEntity.copy(i, i2, l);
    }

    public final int component1() {
        return this.transState;
    }

    public final int component2() {
        return this.extCode;
    }

    @Nullable
    public final Long component3() {
        return this.ttsTime;
    }

    @NotNull
    public final TranslationStateEntity copy(int i, int i2, @Nullable Long l) {
        return new TranslationStateEntity(i, i2, l);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TranslationStateEntity)) {
            return false;
        }
        TranslationStateEntity translationStateEntity = (TranslationStateEntity) obj;
        return this.transState == translationStateEntity.transState && this.extCode == translationStateEntity.extCode && Intrinsics.areEqual((Object) this.ttsTime, (Object) translationStateEntity.ttsTime);
    }

    public final int getExtCode() {
        return this.extCode;
    }

    public final int getTransState() {
        return this.transState;
    }

    @Nullable
    public final Long getTtsTime() {
        return this.ttsTime;
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.transState) * 31) + Integer.hashCode(this.extCode)) * 31;
        Long l = this.ttsTime;
        return hashCode + (l == null ? 0 : l.hashCode());
    }

    @NotNull
    public String toString() {
        int i = this.transState;
        int i2 = this.extCode;
        return "TranslationStateEntity(transState=" + i + ", extCode=" + i2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TranslationStateEntity(int i, int i2, Long l, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? null : l);
    }
}
