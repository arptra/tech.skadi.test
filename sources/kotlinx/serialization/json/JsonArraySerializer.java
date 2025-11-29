package kotlinx.serialization.json;

import com.honey.account.constant.AccountConstantKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@PublishedApi
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\u000f8\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lkotlinx/serialization/json/JsonArraySerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonArray;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "", "f", "(Lkotlinx/serialization/encoding/Encoder;Lkotlinx/serialization/json/JsonArray;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "e", "(Lkotlinx/serialization/encoding/Decoder;)Lkotlinx/serialization/json/JsonArray;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "b", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "JsonArrayDescriptor", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
public final class JsonArraySerializer implements KSerializer<JsonArray> {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonArraySerializer f4076a = new JsonArraySerializer();
    public static final SerialDescriptor b = JsonArrayDescriptor.b;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0013\u0010\u0014R \u0010\u0019\u001a\u00020\f8\u0016XD¢\u0006\u0012\n\u0004\b\u000e\u0010\u0015\u0012\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068VX\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u00048\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u00128VX\u0005¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\u00128VX\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010!R\u0014\u0010'\u001a\u00020$8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"Lkotlinx/serialization/json/JsonArraySerializer$JsonArrayDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "<init>", "()V", "", "index", "", "", "g", "(I)Ljava/util/List;", "d", "(I)Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "name", "c", "(Ljava/lang/String;)I", "f", "(I)Ljava/lang/String;", "", "i", "(I)Z", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "getSerialName$annotations", "serialName", "getAnnotations", "()Ljava/util/List;", "annotations", "e", "()I", "elementsCount", "isInline", "()Z", "b", "isNullable", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "kind", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
    public static final class JsonArrayDescriptor implements SerialDescriptor {
        public static final JsonArrayDescriptor b = new JsonArrayDescriptor();
        public static final String c = "kotlinx.serialization.json.JsonArray";

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SerialDescriptor f4077a = BuiltinSerializersKt.h(JsonElementSerializer.f4081a).getDescriptor();

        public boolean b() {
            return this.f4077a.b();
        }

        public int c(String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            return this.f4077a.c(str);
        }

        public SerialDescriptor d(int i) {
            return this.f4077a.d(i);
        }

        public int e() {
            return this.f4077a.e();
        }

        public String f(int i) {
            return this.f4077a.f(i);
        }

        public List g(int i) {
            return this.f4077a.g(i);
        }

        public List getAnnotations() {
            return this.f4077a.getAnnotations();
        }

        public SerialKind getKind() {
            return this.f4077a.getKind();
        }

        public String h() {
            return c;
        }

        public boolean i(int i) {
            return this.f4077a.i(i);
        }

        public boolean isInline() {
            return this.f4077a.isInline();
        }
    }

    /* renamed from: e */
    public JsonArray c(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonElementSerializersKt.g(decoder);
        return new JsonArray((List) BuiltinSerializersKt.h(JsonElementSerializer.f4081a).c(decoder));
    }

    /* renamed from: f */
    public void a(Encoder encoder, JsonArray jsonArray) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(jsonArray, AccountConstantKt.RESPONSE_VALUE);
        JsonElementSerializersKt.h(encoder);
        BuiltinSerializersKt.h(JsonElementSerializer.f4081a).a(encoder, jsonArray);
    }

    public SerialDescriptor getDescriptor() {
        return b;
    }
}
