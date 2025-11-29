package com.xjsd.ai.assistant.chatgpt.model.minimax;

import androidx.annotation.Keep;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ReferenceArraySerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 &2\u00020\u0001:\u0002%&B7\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0001\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB#\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J,\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J&\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#HÁ\u0001¢\u0006\u0002\b$R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0010\n\u0002\u0010\u0010\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u0013¨\u0006'"}, d2 = {"Lcom/xjsd/ai/assistant/chatgpt/model/minimax/LlmRecommend;", "", "seen1", "", "recommend_queries", "", "", "version_code", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(I[Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "([Ljava/lang/String;Ljava/lang/String;)V", "getRecommend_queries$annotations", "()V", "getRecommend_queries", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getVersion_code$annotations", "getVersion_code", "()Ljava/lang/String;", "component1", "component2", "copy", "([Ljava/lang/String;Ljava/lang/String;)Lcom/xjsd/ai/assistant/chatgpt/model/minimax/LlmRecommend;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$ar_assistant_intlRelease", "$serializer", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
public final class LlmRecommend {
    /* access modifiers changed from: private */
    @NotNull
    @JvmField
    public static final KSerializer<Object>[] $childSerializers = {new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(String.class), StringSerializer.f4060a), null};
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private final String[] recommend_queries;
    @Nullable
    private final String version_code;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/xjsd/ai/assistant/chatgpt/model/minimax/LlmRecommend$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/xjsd/ai/assistant/chatgpt/model/minimax/LlmRecommend;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final KSerializer<LlmRecommend> serializer() {
            return LlmRecommend$$serializer.f8399a;
        }

        public Companion() {
        }
    }

    public LlmRecommend() {
        this((String[]) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ LlmRecommend copy$default(LlmRecommend llmRecommend, String[] strArr, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            strArr = llmRecommend.recommend_queries;
        }
        if ((i & 2) != 0) {
            str = llmRecommend.version_code;
        }
        return llmRecommend.copy(strArr, str);
    }

    @SerialName
    public static /* synthetic */ void getRecommend_queries$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getVersion_code$annotations() {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$ar_assistant_intlRelease(LlmRecommend llmRecommend, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (compositeEncoder.q(serialDescriptor, 0) || llmRecommend.recommend_queries != null) {
            compositeEncoder.y(serialDescriptor, 0, kSerializerArr[0], llmRecommend.recommend_queries);
        }
        if (compositeEncoder.q(serialDescriptor, 1) || llmRecommend.version_code != null) {
            compositeEncoder.y(serialDescriptor, 1, StringSerializer.f4060a, llmRecommend.version_code);
        }
    }

    @Nullable
    public final String[] component1() {
        return this.recommend_queries;
    }

    @Nullable
    public final String component2() {
        return this.version_code;
    }

    @NotNull
    public final LlmRecommend copy(@Nullable String[] strArr, @Nullable String str) {
        return new LlmRecommend(strArr, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LlmRecommend)) {
            return false;
        }
        LlmRecommend llmRecommend = (LlmRecommend) obj;
        return Intrinsics.areEqual((Object) this.recommend_queries, (Object) llmRecommend.recommend_queries) && Intrinsics.areEqual((Object) this.version_code, (Object) llmRecommend.version_code);
    }

    @Nullable
    public final String[] getRecommend_queries() {
        return this.recommend_queries;
    }

    @Nullable
    public final String getVersion_code() {
        return this.version_code;
    }

    public int hashCode() {
        String[] strArr = this.recommend_queries;
        int i = 0;
        int hashCode = (strArr == null ? 0 : Arrays.hashCode(strArr)) * 31;
        String str = this.version_code;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        String arrays = Arrays.toString(this.recommend_queries);
        String str = this.version_code;
        return "LlmRecommend(recommend_queries=" + arrays + ", version_code=" + str + ")";
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ LlmRecommend(int i, @SerialName String[] strArr, @SerialName String str, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.recommend_queries = null;
        } else {
            this.recommend_queries = strArr;
        }
        if ((i & 2) == 0) {
            this.version_code = null;
        } else {
            this.version_code = str;
        }
    }

    public LlmRecommend(@Nullable String[] strArr, @Nullable String str) {
        this.recommend_queries = strArr;
        this.version_code = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LlmRecommend(String[] strArr, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : strArr, (i & 2) != 0 ? null : str);
    }
}
