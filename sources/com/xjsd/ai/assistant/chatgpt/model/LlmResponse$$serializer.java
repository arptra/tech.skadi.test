package com.xjsd.ai.assistant.chatgpt.model;

import com.honey.account.constant.AccountConstantKt;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/xjsd/ai/assistant/chatgpt/model/LlmResponse.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/xjsd/ai/assistant/chatgpt/model/LlmResponse;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "d", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "e", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/xjsd/ai/assistant/chatgpt/model/LlmResponse;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "", "f", "(Lkotlinx/serialization/encoding/Encoder;Lcom/xjsd/ai/assistant/chatgpt/model/LlmResponse;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class LlmResponse$$serializer implements GeneratedSerializer<LlmResponse> {

    /* renamed from: a  reason: collision with root package name */
    public static final LlmResponse$$serializer f8397a;
    public static final /* synthetic */ PluginGeneratedSerialDescriptor b;

    static {
        LlmResponse$$serializer llmResponse$$serializer = new LlmResponse$$serializer();
        f8397a = llmResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.xjsd.ai.assistant.chatgpt.model.LlmResponse", llmResponse$$serializer, 5);
        pluginGeneratedSerialDescriptor.k("base_status", true);
        pluginGeneratedSerialDescriptor.k("answer", true);
        pluginGeneratedSerialDescriptor.k("version_code", true);
        pluginGeneratedSerialDescriptor.k("isCmd", true);
        pluginGeneratedSerialDescriptor.k(AssistantConstants.Key.SESSION_ID, true);
        b = pluginGeneratedSerialDescriptor;
    }

    public KSerializer[] b() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }

    public KSerializer[] d() {
        StringSerializer stringSerializer = StringSerializer.f4060a;
        return new KSerializer[]{IntSerializer.f4036a, stringSerializer, stringSerializer, BooleanSerializer.f4015a, stringSerializer};
    }

    /* renamed from: e */
    public LlmResponse c(Decoder decoder) {
        String str;
        boolean z;
        String str2;
        String str3;
        int i;
        int i2;
        Decoder decoder2 = decoder;
        Intrinsics.checkNotNullParameter(decoder2, "decoder");
        SerialDescriptor descriptor = getDescriptor();
        CompositeDecoder b2 = decoder2.b(descriptor);
        if (b2.k()) {
            int f = b2.f(descriptor, 0);
            String i3 = b2.i(descriptor, 1);
            String i4 = b2.i(descriptor, 2);
            i = f;
            z = b2.C(descriptor, 3);
            str = b2.i(descriptor, 4);
            str2 = i4;
            str3 = i3;
            i2 = 31;
        } else {
            String str4 = null;
            String str5 = null;
            String str6 = null;
            boolean z2 = true;
            int i5 = 0;
            boolean z3 = false;
            int i6 = 0;
            while (z2) {
                int w = b2.w(descriptor);
                if (w == -1) {
                    z2 = false;
                } else if (w == 0) {
                    i5 = b2.f(descriptor, 0);
                    i6 |= 1;
                } else if (w == 1) {
                    str6 = b2.i(descriptor, 1);
                    i6 |= 2;
                } else if (w == 2) {
                    str5 = b2.i(descriptor, 2);
                    i6 |= 4;
                } else if (w == 3) {
                    z3 = b2.C(descriptor, 3);
                    i6 |= 8;
                } else if (w == 4) {
                    str4 = b2.i(descriptor, 4);
                    i6 |= 16;
                } else {
                    throw new UnknownFieldException(w);
                }
            }
            i = i5;
            z = z3;
            str = str4;
            str2 = str5;
            str3 = str6;
            i2 = i6;
        }
        b2.c(descriptor);
        return new LlmResponse(i2, i, str3, str2, z, str, (SerializationConstructorMarker) null);
    }

    /* renamed from: f */
    public void a(Encoder encoder, LlmResponse llmResponse) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(llmResponse, AccountConstantKt.RESPONSE_VALUE);
        SerialDescriptor descriptor = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor);
        LlmResponse.write$Self$ar_assistant_intlRelease(llmResponse, b2, descriptor);
        b2.c(descriptor);
    }

    public SerialDescriptor getDescriptor() {
        return b;
    }
}
