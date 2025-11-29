package com.xjsd.ai.assistant.chatgpt.model.minimax;

import com.honey.account.constant.AccountConstantKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/xjsd/ai/assistant/chatgpt/model/minimax/LlmRecommend.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/xjsd/ai/assistant/chatgpt/model/minimax/LlmRecommend;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "d", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "e", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/xjsd/ai/assistant/chatgpt/model/minimax/LlmRecommend;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "", "f", "(Lkotlinx/serialization/encoding/Encoder;Lcom/xjsd/ai/assistant/chatgpt/model/minimax/LlmRecommend;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class LlmRecommend$$serializer implements GeneratedSerializer<LlmRecommend> {

    /* renamed from: a  reason: collision with root package name */
    public static final LlmRecommend$$serializer f8399a;
    public static final /* synthetic */ PluginGeneratedSerialDescriptor b;

    static {
        LlmRecommend$$serializer llmRecommend$$serializer = new LlmRecommend$$serializer();
        f8399a = llmRecommend$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.xjsd.ai.assistant.chatgpt.model.minimax.LlmRecommend", llmRecommend$$serializer, 2);
        pluginGeneratedSerialDescriptor.k("recommend_queries", true);
        pluginGeneratedSerialDescriptor.k("version_code", true);
        b = pluginGeneratedSerialDescriptor;
    }

    public KSerializer[] b() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }

    public KSerializer[] d() {
        return new KSerializer[]{BuiltinSerializersKt.t(LlmRecommend.$childSerializers[0]), BuiltinSerializersKt.t(StringSerializer.f4060a)};
    }

    /* renamed from: e */
    public LlmRecommend c(Decoder decoder) {
        int i;
        String str;
        String[] strArr;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor = getDescriptor();
        CompositeDecoder b2 = decoder.b(descriptor);
        KSerializer[] access$get$childSerializers$cp = LlmRecommend.$childSerializers;
        if (b2.k()) {
            strArr = (String[]) b2.j(descriptor, 0, access$get$childSerializers$cp[0], (Object) null);
            str = (String) b2.j(descriptor, 1, StringSerializer.f4060a, (Object) null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            String[] strArr2 = null;
            String str2 = null;
            while (z) {
                int w = b2.w(descriptor);
                if (w == -1) {
                    z = false;
                } else if (w == 0) {
                    strArr2 = (String[]) b2.j(descriptor, 0, access$get$childSerializers$cp[0], strArr2);
                    i2 |= 1;
                } else if (w == 1) {
                    str2 = (String) b2.j(descriptor, 1, StringSerializer.f4060a, str2);
                    i2 |= 2;
                } else {
                    throw new UnknownFieldException(w);
                }
            }
            strArr = strArr2;
            str = str2;
            i = i2;
        }
        b2.c(descriptor);
        return new LlmRecommend(i, strArr, str, (SerializationConstructorMarker) null);
    }

    /* renamed from: f */
    public void a(Encoder encoder, LlmRecommend llmRecommend) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(llmRecommend, AccountConstantKt.RESPONSE_VALUE);
        SerialDescriptor descriptor = getDescriptor();
        CompositeEncoder b2 = encoder.b(descriptor);
        LlmRecommend.write$Self$ar_assistant_intlRelease(llmRecommend, b2, descriptor);
        b2.c(descriptor);
    }

    public SerialDescriptor getDescriptor() {
        return b;
    }
}
