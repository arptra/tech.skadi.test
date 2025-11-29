package com.xjsd.ai.assistant.phone.vad;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0006\u0010\u0018\u001a\u00020\u0014J\u0006\u0010\u0019\u001a\u00020\u0014J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/xjsd/ai/assistant/phone/vad/OfflineAsrResult;", "", "originalSentence", "", "sentence", "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getOriginalSentence", "()Ljava/lang/String;", "setOriginalSentence", "(Ljava/lang/String;)V", "getSentence", "setSentence", "getType", "setType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "isEmpty", "isFinal", "toString", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class OfflineAsrResult {
    @NotNull
    private String originalSentence;
    @Nullable
    private String sentence;
    @NotNull
    private String type;

    public OfflineAsrResult(@NotNull String str, @Nullable String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "originalSentence");
        Intrinsics.checkNotNullParameter(str3, "type");
        this.originalSentence = str;
        this.sentence = str2;
        this.type = str3;
    }

    public static /* synthetic */ OfflineAsrResult copy$default(OfflineAsrResult offlineAsrResult, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = offlineAsrResult.originalSentence;
        }
        if ((i & 2) != 0) {
            str2 = offlineAsrResult.sentence;
        }
        if ((i & 4) != 0) {
            str3 = offlineAsrResult.type;
        }
        return offlineAsrResult.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.originalSentence;
    }

    @Nullable
    public final String component2() {
        return this.sentence;
    }

    @NotNull
    public final String component3() {
        return this.type;
    }

    @NotNull
    public final OfflineAsrResult copy(@NotNull String str, @Nullable String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "originalSentence");
        Intrinsics.checkNotNullParameter(str3, "type");
        return new OfflineAsrResult(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfflineAsrResult)) {
            return false;
        }
        OfflineAsrResult offlineAsrResult = (OfflineAsrResult) obj;
        return Intrinsics.areEqual((Object) this.originalSentence, (Object) offlineAsrResult.originalSentence) && Intrinsics.areEqual((Object) this.sentence, (Object) offlineAsrResult.sentence) && Intrinsics.areEqual((Object) this.type, (Object) offlineAsrResult.type);
    }

    @NotNull
    public final String getOriginalSentence() {
        return this.originalSentence;
    }

    @Nullable
    public final String getSentence() {
        return this.sentence;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = this.originalSentence.hashCode() * 31;
        String str = this.sentence;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.type.hashCode();
    }

    public final boolean isEmpty() {
        return this.originalSentence.length() == 0;
    }

    public final boolean isFinal() {
        return Intrinsics.areEqual((Object) this.type, (Object) "final_result");
    }

    public final void setOriginalSentence(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.originalSentence = str;
    }

    public final void setSentence(@Nullable String str) {
        this.sentence = str;
    }

    public final void setType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    @NotNull
    public String toString() {
        String str = this.originalSentence;
        String str2 = this.sentence;
        String str3 = this.type;
        return "OfflineAsrResult(originalSentence=" + str + ", sentence=" + str2 + ", type=" + str3 + ")";
    }
}
