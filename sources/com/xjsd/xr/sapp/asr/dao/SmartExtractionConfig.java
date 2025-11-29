package com.xjsd.xr.sapp.asr.dao;

import androidx.annotation.IntRange;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/xjsd/xr/sapp/asr/dao/SmartExtractionConfig;", "", "recognizeId", "", "sceneType", "", "(Ljava/lang/String;I)V", "getRecognizeId", "()Ljava/lang/String;", "getSceneType", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SmartExtractionConfig {
    @NotNull
    private final String recognizeId;
    private final int sceneType;

    public SmartExtractionConfig(@NotNull String str, @IntRange int i) {
        Intrinsics.checkNotNullParameter(str, "recognizeId");
        this.recognizeId = str;
        this.sceneType = i;
    }

    public static /* synthetic */ SmartExtractionConfig copy$default(SmartExtractionConfig smartExtractionConfig, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = smartExtractionConfig.recognizeId;
        }
        if ((i2 & 2) != 0) {
            i = smartExtractionConfig.sceneType;
        }
        return smartExtractionConfig.copy(str, i);
    }

    @NotNull
    public final String component1() {
        return this.recognizeId;
    }

    public final int component2() {
        return this.sceneType;
    }

    @NotNull
    public final SmartExtractionConfig copy(@NotNull String str, @IntRange int i) {
        Intrinsics.checkNotNullParameter(str, "recognizeId");
        return new SmartExtractionConfig(str, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SmartExtractionConfig)) {
            return false;
        }
        SmartExtractionConfig smartExtractionConfig = (SmartExtractionConfig) obj;
        return Intrinsics.areEqual((Object) this.recognizeId, (Object) smartExtractionConfig.recognizeId) && this.sceneType == smartExtractionConfig.sceneType;
    }

    @NotNull
    public final String getRecognizeId() {
        return this.recognizeId;
    }

    public final int getSceneType() {
        return this.sceneType;
    }

    public int hashCode() {
        return (this.recognizeId.hashCode() * 31) + Integer.hashCode(this.sceneType);
    }

    @NotNull
    public String toString() {
        return "SmartExtractionConfig(recognizeId='" + this.recognizeId + "', sceneType=" + this.sceneType + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SmartExtractionConfig(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 1 : i);
    }
}
