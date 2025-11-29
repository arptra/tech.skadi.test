package com.xjsd.ai.assistant.chatgpt.model.minimax;

import androidx.annotation.Keep;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B1\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J&\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fHÁ\u0001¢\u0006\u0002\b R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006#"}, d2 = {"Lcom/xjsd/ai/assistant/chatgpt/model/minimax/LlmRecommendCopy;", "", "seen1", "", "recommend_queries", "", "version_code", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "getRecommend_queries$annotations", "()V", "getRecommend_queries", "()Ljava/lang/String;", "getVersion_code$annotations", "getVersion_code", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$ar_assistant_intlRelease", "$serializer", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
public final class LlmRecommendCopy {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private final String recommend_queries;
    @Nullable
    private final String version_code;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/xjsd/ai/assistant/chatgpt/model/minimax/LlmRecommendCopy$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/xjsd/ai/assistant/chatgpt/model/minimax/LlmRecommendCopy;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final KSerializer<LlmRecommendCopy> serializer() {
            return LlmRecommendCopy$$serializer.f8400a;
        }

        public Companion() {
        }
    }

    public LlmRecommendCopy() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ LlmRecommendCopy copy$default(LlmRecommendCopy llmRecommendCopy, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = llmRecommendCopy.recommend_queries;
        }
        if ((i & 2) != 0) {
            str2 = llmRecommendCopy.version_code;
        }
        return llmRecommendCopy.copy(str, str2);
    }

    @SerialName
    public static /* synthetic */ void getRecommend_queries$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getVersion_code$annotations() {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$ar_assistant_intlRelease(LlmRecommendCopy llmRecommendCopy, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.q(serialDescriptor, 0) || llmRecommendCopy.recommend_queries != null) {
            compositeEncoder.y(serialDescriptor, 0, StringSerializer.f4060a, llmRecommendCopy.recommend_queries);
        }
        if (compositeEncoder.q(serialDescriptor, 1) || llmRecommendCopy.version_code != null) {
            compositeEncoder.y(serialDescriptor, 1, StringSerializer.f4060a, llmRecommendCopy.version_code);
        }
    }

    @Nullable
    public final String component1() {
        return this.recommend_queries;
    }

    @Nullable
    public final String component2() {
        return this.version_code;
    }

    @NotNull
    public final LlmRecommendCopy copy(@Nullable String str, @Nullable String str2) {
        return new LlmRecommendCopy(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LlmRecommendCopy)) {
            return false;
        }
        LlmRecommendCopy llmRecommendCopy = (LlmRecommendCopy) obj;
        return Intrinsics.areEqual((Object) this.recommend_queries, (Object) llmRecommendCopy.recommend_queries) && Intrinsics.areEqual((Object) this.version_code, (Object) llmRecommendCopy.version_code);
    }

    @Nullable
    public final String getRecommend_queries() {
        return this.recommend_queries;
    }

    @Nullable
    public final String getVersion_code() {
        return this.version_code;
    }

    public int hashCode() {
        String str = this.recommend_queries;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.version_code;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        String str = this.recommend_queries;
        String str2 = this.version_code;
        return "LlmRecommendCopy(recommend_queries=" + str + ", version_code=" + str2 + ")";
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ LlmRecommendCopy(int i, @SerialName String str, @SerialName String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.recommend_queries = null;
        } else {
            this.recommend_queries = str;
        }
        if ((i & 2) == 0) {
            this.version_code = null;
        } else {
            this.version_code = str2;
        }
    }

    public LlmRecommendCopy(@Nullable String str, @Nullable String str2) {
        this.recommend_queries = str;
        this.version_code = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LlmRecommendCopy(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }
}
