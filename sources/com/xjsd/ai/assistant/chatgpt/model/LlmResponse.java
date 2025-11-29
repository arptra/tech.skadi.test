package com.xjsd.ai.assistant.chatgpt.model;

import androidx.annotation.Keep;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 72\u00020\u0001:\u000267BQ\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rB7\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000eJ\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J;\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\u0013\u0010*\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020\u0006HÖ\u0001J&\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204HÁ\u0001¢\u0006\u0002\b5R$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\b\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0010\u001a\u0004\b\b\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R$\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b!\u0010\u0010\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014¨\u00068"}, d2 = {"Lcom/xjsd/ai/assistant/chatgpt/model/LlmResponse;", "", "seen1", "", "base_status", "answer", "", "version_code", "isCmd", "", "sessionId", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getAnswer$annotations", "()V", "getAnswer", "()Ljava/lang/String;", "setAnswer", "(Ljava/lang/String;)V", "getBase_status$annotations", "getBase_status", "()I", "setBase_status", "(I)V", "isCmd$annotations", "()Z", "setCmd", "(Z)V", "getSessionId$annotations", "getSessionId", "setSessionId", "getVersion_code$annotations", "getVersion_code", "setVersion_code", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$ar_assistant_intlRelease", "$serializer", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
public final class LlmResponse {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private String answer;
    private int base_status;
    private boolean isCmd;
    @NotNull
    private String sessionId;
    @NotNull
    private String version_code;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/xjsd/ai/assistant/chatgpt/model/LlmResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/xjsd/ai/assistant/chatgpt/model/LlmResponse;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final KSerializer<LlmResponse> serializer() {
            return LlmResponse$$serializer.f8397a;
        }

        public Companion() {
        }
    }

    public LlmResponse() {
        this(0, (String) null, (String) null, false, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ LlmResponse copy$default(LlmResponse llmResponse, int i, String str, String str2, boolean z, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = llmResponse.base_status;
        }
        if ((i2 & 2) != 0) {
            str = llmResponse.answer;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            str2 = llmResponse.version_code;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            z = llmResponse.isCmd;
        }
        boolean z2 = z;
        if ((i2 & 16) != 0) {
            str3 = llmResponse.sessionId;
        }
        return llmResponse.copy(i, str4, str5, z2, str3);
    }

    @SerialName
    public static /* synthetic */ void getAnswer$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getBase_status$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getSessionId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getVersion_code$annotations() {
    }

    @SerialName
    public static /* synthetic */ void isCmd$annotations() {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$ar_assistant_intlRelease(LlmResponse llmResponse, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.q(serialDescriptor, 0) || llmResponse.base_status != 0) {
            compositeEncoder.n(serialDescriptor, 0, llmResponse.base_status);
        }
        if (compositeEncoder.q(serialDescriptor, 1) || !Intrinsics.areEqual((Object) llmResponse.answer, (Object) "")) {
            compositeEncoder.p(serialDescriptor, 1, llmResponse.answer);
        }
        if (compositeEncoder.q(serialDescriptor, 2) || !Intrinsics.areEqual((Object) llmResponse.version_code, (Object) "")) {
            compositeEncoder.p(serialDescriptor, 2, llmResponse.version_code);
        }
        if (compositeEncoder.q(serialDescriptor, 3) || llmResponse.isCmd) {
            compositeEncoder.o(serialDescriptor, 3, llmResponse.isCmd);
        }
        if (compositeEncoder.q(serialDescriptor, 4) || !Intrinsics.areEqual((Object) llmResponse.sessionId, (Object) "")) {
            compositeEncoder.p(serialDescriptor, 4, llmResponse.sessionId);
        }
    }

    public final int component1() {
        return this.base_status;
    }

    @NotNull
    public final String component2() {
        return this.answer;
    }

    @NotNull
    public final String component3() {
        return this.version_code;
    }

    public final boolean component4() {
        return this.isCmd;
    }

    @NotNull
    public final String component5() {
        return this.sessionId;
    }

    @NotNull
    public final LlmResponse copy(int i, @NotNull String str, @NotNull String str2, boolean z, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "answer");
        Intrinsics.checkNotNullParameter(str2, "version_code");
        Intrinsics.checkNotNullParameter(str3, AssistantConstants.Key.SESSION_ID);
        return new LlmResponse(i, str, str2, z, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LlmResponse)) {
            return false;
        }
        LlmResponse llmResponse = (LlmResponse) obj;
        return this.base_status == llmResponse.base_status && Intrinsics.areEqual((Object) this.answer, (Object) llmResponse.answer) && Intrinsics.areEqual((Object) this.version_code, (Object) llmResponse.version_code) && this.isCmd == llmResponse.isCmd && Intrinsics.areEqual((Object) this.sessionId, (Object) llmResponse.sessionId);
    }

    @NotNull
    public final String getAnswer() {
        return this.answer;
    }

    public final int getBase_status() {
        return this.base_status;
    }

    @NotNull
    public final String getSessionId() {
        return this.sessionId;
    }

    @NotNull
    public final String getVersion_code() {
        return this.version_code;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.base_status) * 31) + this.answer.hashCode()) * 31) + this.version_code.hashCode()) * 31) + Boolean.hashCode(this.isCmd)) * 31) + this.sessionId.hashCode();
    }

    public final boolean isCmd() {
        return this.isCmd;
    }

    public final void setAnswer(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.answer = str;
    }

    public final void setBase_status(int i) {
        this.base_status = i;
    }

    public final void setCmd(boolean z) {
        this.isCmd = z;
    }

    public final void setSessionId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sessionId = str;
    }

    public final void setVersion_code(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.version_code = str;
    }

    @NotNull
    public String toString() {
        int i = this.base_status;
        String str = this.answer;
        String str2 = this.version_code;
        boolean z = this.isCmd;
        String str3 = this.sessionId;
        return "LlmResponse(base_status=" + i + ", answer=" + str + ", version_code=" + str2 + ", isCmd=" + z + ", sessionId=" + str3 + ")";
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ LlmResponse(int i, @SerialName int i2, @SerialName String str, @SerialName String str2, @SerialName boolean z, @SerialName String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.base_status = 0;
        } else {
            this.base_status = i2;
        }
        if ((i & 2) == 0) {
            this.answer = "";
        } else {
            this.answer = str;
        }
        if ((i & 4) == 0) {
            this.version_code = "";
        } else {
            this.version_code = str2;
        }
        if ((i & 8) == 0) {
            this.isCmd = false;
        } else {
            this.isCmd = z;
        }
        if ((i & 16) == 0) {
            this.sessionId = "";
        } else {
            this.sessionId = str3;
        }
    }

    public LlmResponse(int i, @NotNull String str, @NotNull String str2, boolean z, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "answer");
        Intrinsics.checkNotNullParameter(str2, "version_code");
        Intrinsics.checkNotNullParameter(str3, AssistantConstants.Key.SESSION_ID);
        this.base_status = i;
        this.answer = str;
        this.version_code = str2;
        this.isCmd = z;
        this.sessionId = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LlmResponse(int i, String str, String str2, boolean z, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? "" : str3);
    }
}
