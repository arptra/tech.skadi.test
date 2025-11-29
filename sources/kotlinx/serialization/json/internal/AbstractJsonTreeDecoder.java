package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.NamedValueDecoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0011\u001a\u00020\u0010*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J#\u0010\u0019\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tH\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020$2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\tH\u0004¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\tH$¢\u0006\u0004\b-\u0010.J\u001f\u00101\u001a\u0002002\u0006\u0010*\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u001fH\u0014¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020'2\u0006\u0010*\u001a\u00020\tH\u0014¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020'2\u0006\u0010*\u001a\u00020\tH\u0014¢\u0006\u0004\b5\u00104J\u0017\u00107\u001a\u0002062\u0006\u0010*\u001a\u00020\tH\u0014¢\u0006\u0004\b7\u00108J\u0017\u0010:\u001a\u0002092\u0006\u0010*\u001a\u00020\tH\u0014¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u0002002\u0006\u0010*\u001a\u00020\tH\u0014¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020>2\u0006\u0010*\u001a\u00020\tH\u0014¢\u0006\u0004\b?\u0010@J\u0017\u0010B\u001a\u00020A2\u0006\u0010*\u001a\u00020\tH\u0014¢\u0006\u0004\bB\u0010CJ\u0017\u0010E\u001a\u00020D2\u0006\u0010*\u001a\u00020\tH\u0014¢\u0006\u0004\bE\u0010FJ\u0017\u0010H\u001a\u00020G2\u0006\u0010*\u001a\u00020\tH\u0014¢\u0006\u0004\bH\u0010IJ\u0017\u0010J\u001a\u00020\t2\u0006\u0010*\u001a\u00020\tH\u0014¢\u0006\u0004\bJ\u0010KJ\u001f\u0010N\u001a\u00020M2\u0006\u0010*\u001a\u00020\t2\u0006\u0010L\u001a\u00020\u001fH\u0014¢\u0006\u0004\bN\u0010OJ\u0017\u0010P\u001a\u00020M2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\bP\u0010QR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010R\u001a\u0004\bS\u0010TR\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0004¢\u0006\f\n\u0004\bS\u0010U\u001a\u0004\bV\u0010\u0014R\u0014\u0010Z\u001a\u00020W8\u0004X\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010^\u001a\u00020[8VX\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010]\u0001\u0003_`a¨\u0006b"}, d2 = {"Lkotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "Lkotlinx/serialization/internal/NamedValueDecoder;", "Lkotlinx/serialization/json/JsonDecoder;", "Lkotlinx/serialization/json/Json;", "json", "Lkotlinx/serialization/json/JsonElement;", "value", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonElement;)V", "", "primitive", "", "w0", "(Ljava/lang/String;)Ljava/lang/Void;", "Lkotlinx/serialization/json/JsonPrimitive;", "type", "Lkotlinx/serialization/json/JsonLiteral;", "f0", "(Lkotlinx/serialization/json/JsonPrimitive;Ljava/lang/String;)Lkotlinx/serialization/json/JsonLiteral;", "h0", "()Lkotlinx/serialization/json/JsonElement;", "t", "T", "Lkotlinx/serialization/DeserializationStrategy;", "deserializer", "G", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "parentName", "childName", "b0", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/encoding/CompositeDecoder;", "b", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeDecoder;", "", "c", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "D", "()Z", "tag", "u0", "(Ljava/lang/String;)Lkotlinx/serialization/json/JsonPrimitive;", "g0", "(Ljava/lang/String;)Lkotlinx/serialization/json/JsonElement;", "enumDescriptor", "", "m0", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "r0", "(Ljava/lang/String;)Z", "i0", "", "j0", "(Ljava/lang/String;)B", "", "s0", "(Ljava/lang/String;)S", "p0", "(Ljava/lang/String;)I", "", "q0", "(Ljava/lang/String;)J", "", "n0", "(Ljava/lang/String;)F", "", "l0", "(Ljava/lang/String;)D", "", "k0", "(Ljava/lang/String;)C", "t0", "(Ljava/lang/String;)Ljava/lang/String;", "inlineDescriptor", "Lkotlinx/serialization/encoding/Decoder;", "o0", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Decoder;", "x", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Decoder;", "Lkotlinx/serialization/json/Json;", "d", "()Lkotlinx/serialization/json/Json;", "Lkotlinx/serialization/json/JsonElement;", "v0", "Lkotlinx/serialization/json/JsonConfiguration;", "e", "Lkotlinx/serialization/json/JsonConfiguration;", "configuration", "Lkotlinx/serialization/modules/SerializersModule;", "a", "()Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "Lkotlinx/serialization/json/internal/JsonPrimitiveDecoder;", "Lkotlinx/serialization/json/internal/JsonTreeDecoder;", "Lkotlinx/serialization/json/internal/JsonTreeListDecoder;", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTreeJsonDecoder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TreeJsonDecoder.kt\nkotlinx/serialization/json/internal/AbstractJsonTreeDecoder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 TreeJsonEncoder.kt\nkotlinx/serialization/json/internal/TreeJsonEncoderKt\n+ 4 WriteMode.kt\nkotlinx/serialization/json/internal/WriteModeKt\n*L\n1#1,326:1\n129#1,4:364\n129#1,4:368\n129#1,4:372\n129#1,4:376\n129#1,4:380\n129#1,4:384\n129#1,4:388\n129#1,4:392\n1#2:327\n252#3,7:328\n252#3,7:340\n252#3,7:349\n252#3,7:357\n36#4,5:335\n41#4,2:347\n44#4:356\n*S KotlinDebug\n*F\n+ 1 TreeJsonDecoder.kt\nkotlinx/serialization/json/internal/AbstractJsonTreeDecoder\n*L\n94#1:364,4\n97#1:368,4\n103#1:372,4\n109#1:376,4\n110#1:380,4\n113#1:384,4\n120#1:388,4\n126#1:392,4\n60#1:328,7\n63#1:340,7\n64#1:349,7\n66#1:357,7\n61#1:335,5\n61#1:347,2\n61#1:356\n*E\n"})
abstract class AbstractJsonTreeDecoder extends NamedValueDecoder implements JsonDecoder {
    public final Json c;
    public final JsonElement d;
    public final JsonConfiguration e;

    public /* synthetic */ AbstractJsonTreeDecoder(Json json, JsonElement jsonElement, DefaultConstructorMarker defaultConstructorMarker) {
        this(json, jsonElement);
    }

    public boolean D() {
        return !(h0() instanceof JsonNull);
    }

    public Object G(DeserializationStrategy deserializationStrategy) {
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        return PolymorphicKt.d(this, deserializationStrategy);
    }

    public SerializersModule a() {
        return d().c();
    }

    public CompositeDecoder b(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        JsonElement h0 = h0();
        SerialKind kind = serialDescriptor.getKind();
        Class<JsonArray> cls = JsonArray.class;
        if (Intrinsics.areEqual((Object) kind, (Object) StructureKind.LIST.f4009a) ? true : kind instanceof PolymorphicKind) {
            Json d2 = d();
            if (h0 instanceof JsonArray) {
                return new JsonTreeListDecoder(d2, (JsonArray) h0);
            }
            throw JsonExceptionsKt.e(-1, "Expected " + Reflection.getOrCreateKotlinClass(cls) + " as the serialized body of " + serialDescriptor.h() + ", but had " + Reflection.getOrCreateKotlinClass(h0.getClass()));
        }
        Class<JsonObject> cls2 = JsonObject.class;
        if (Intrinsics.areEqual((Object) kind, (Object) StructureKind.MAP.f4010a)) {
            Json d3 = d();
            SerialDescriptor a2 = WriteModeKt.a(serialDescriptor.d(0), d3.c());
            SerialKind kind2 = a2.getKind();
            if ((kind2 instanceof PrimitiveKind) || Intrinsics.areEqual((Object) kind2, (Object) SerialKind.ENUM.f4007a)) {
                Json d4 = d();
                if (h0 instanceof JsonObject) {
                    return new JsonTreeMapDecoder(d4, (JsonObject) h0);
                }
                throw JsonExceptionsKt.e(-1, "Expected " + Reflection.getOrCreateKotlinClass(cls2) + " as the serialized body of " + serialDescriptor.h() + ", but had " + Reflection.getOrCreateKotlinClass(h0.getClass()));
            } else if (d3.b().b()) {
                Json d5 = d();
                if (h0 instanceof JsonArray) {
                    return new JsonTreeListDecoder(d5, (JsonArray) h0);
                }
                throw JsonExceptionsKt.e(-1, "Expected " + Reflection.getOrCreateKotlinClass(cls) + " as the serialized body of " + serialDescriptor.h() + ", but had " + Reflection.getOrCreateKotlinClass(h0.getClass()));
            } else {
                throw JsonExceptionsKt.d(a2);
            }
        } else {
            Json d6 = d();
            if (h0 instanceof JsonObject) {
                return new JsonTreeDecoder(d6, (JsonObject) h0, (String) null, (SerialDescriptor) null, 12, (DefaultConstructorMarker) null);
            }
            throw JsonExceptionsKt.e(-1, "Expected " + Reflection.getOrCreateKotlinClass(cls2) + " as the serialized body of " + serialDescriptor.h() + ", but had " + Reflection.getOrCreateKotlinClass(h0.getClass()));
        }
    }

    public String b0(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "parentName");
        Intrinsics.checkNotNullParameter(str2, "childName");
        return str2;
    }

    public void c(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
    }

    public Json d() {
        return this.c;
    }

    public final JsonLiteral f0(JsonPrimitive jsonPrimitive, String str) {
        JsonLiteral jsonLiteral = jsonPrimitive instanceof JsonLiteral ? (JsonLiteral) jsonPrimitive : null;
        if (jsonLiteral != null) {
            return jsonLiteral;
        }
        throw JsonExceptionsKt.e(-1, "Unexpected 'null' literal when non-nullable " + str + " was expected");
    }

    public abstract JsonElement g0(String str);

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = g0(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.serialization.json.JsonElement h0() {
        /*
            r1 = this;
            java.lang.Object r0 = r1.W()
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x000e
            kotlinx.serialization.json.JsonElement r0 = r1.g0(r0)
            if (r0 != 0) goto L_0x0012
        L_0x000e:
            kotlinx.serialization.json.JsonElement r0 = r1.v0()
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.AbstractJsonTreeDecoder.h0():kotlinx.serialization.json.JsonElement");
    }

    /* renamed from: i0 */
    public boolean J(String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        try {
            Boolean e2 = JsonElementKt.e(u0(str));
            if (e2 != null) {
                return e2.booleanValue();
            }
            w0("boolean");
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            w0("boolean");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: j0 */
    public byte K(String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        try {
            int i = JsonElementKt.i(u0(str));
            Byte valueOf = (-128 > i || i > 127) ? null : Byte.valueOf((byte) i);
            if (valueOf != null) {
                return valueOf.byteValue();
            }
            w0("byte");
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            w0("byte");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: k0 */
    public char L(String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        try {
            return StringsKt.single(u0(str).a());
        } catch (IllegalArgumentException unused) {
            w0("char");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: l0 */
    public double M(String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        try {
            double g = JsonElementKt.g(u0(str));
            if (d().b().a() || (!Double.isInfinite(g) && !Double.isNaN(g))) {
                return g;
            }
            throw JsonExceptionsKt.a(Double.valueOf(g), str, h0().toString());
        } catch (IllegalArgumentException unused) {
            w0("double");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: m0 */
    public int N(String str, SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(serialDescriptor, "enumDescriptor");
        return JsonNamesMapKt.j(serialDescriptor, d(), u0(str).a(), (String) null, 4, (Object) null);
    }

    /* renamed from: n0 */
    public float O(String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        try {
            float h = JsonElementKt.h(u0(str));
            if (d().b().a() || (!Float.isInfinite(h) && !Float.isNaN(h))) {
                return h;
            }
            throw JsonExceptionsKt.a(Float.valueOf(h), str, h0().toString());
        } catch (IllegalArgumentException unused) {
            w0("float");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: o0 */
    public Decoder P(String str, SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(serialDescriptor, "inlineDescriptor");
        return StreamingJsonEncoderKt.b(serialDescriptor) ? new JsonDecoderForUnsignedTypes(new StringJsonLexer(u0(str).a()), d()) : super.P(str, serialDescriptor);
    }

    /* renamed from: p0 */
    public int Q(String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        try {
            return JsonElementKt.i(u0(str));
        } catch (IllegalArgumentException unused) {
            w0("int");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: q0 */
    public long R(String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        try {
            return JsonElementKt.l(u0(str));
        } catch (IllegalArgumentException unused) {
            w0("long");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: r0 */
    public boolean S(String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        return g0(str) != JsonNull.INSTANCE;
    }

    /* renamed from: s0 */
    public short T(String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        try {
            int i = JsonElementKt.i(u0(str));
            Short valueOf = (-32768 > i || i > 32767) ? null : Short.valueOf((short) i);
            if (valueOf != null) {
                return valueOf.shortValue();
            }
            w0("short");
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            w0("short");
            throw new KotlinNothingValueException();
        }
    }

    public JsonElement t() {
        return h0();
    }

    /* renamed from: t0 */
    public String U(String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        JsonPrimitive u0 = u0(str);
        if (!d().b().o() && !f0(u0, "string").d()) {
            throw JsonExceptionsKt.f(-1, "String literal for key '" + str + "' should be quoted.\nUse 'isLenient = true' in 'Json {}' builder to accept non-compliant JSON.", h0().toString());
        } else if (!(u0 instanceof JsonNull)) {
            return u0.a();
        } else {
            throw JsonExceptionsKt.f(-1, "Unexpected 'null' value instead of string literal", h0().toString());
        }
    }

    public final JsonPrimitive u0(String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        JsonElement g0 = g0(str);
        JsonPrimitive jsonPrimitive = g0 instanceof JsonPrimitive ? (JsonPrimitive) g0 : null;
        if (jsonPrimitive != null) {
            return jsonPrimitive;
        }
        throw JsonExceptionsKt.f(-1, "Expected JsonPrimitive at " + str + ", found " + g0, h0().toString());
    }

    public JsonElement v0() {
        return this.d;
    }

    public final Void w0(String str) {
        throw JsonExceptionsKt.f(-1, "Failed to parse literal as '" + str + "' value", h0().toString());
    }

    public Decoder x(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return W() != null ? super.x(serialDescriptor) : new JsonPrimitiveDecoder(d(), v0()).x(serialDescriptor);
    }

    public AbstractJsonTreeDecoder(Json json, JsonElement jsonElement) {
        this.c = json;
        this.d = jsonElement;
        this.e = d().b();
    }
}
