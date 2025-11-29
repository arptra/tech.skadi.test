package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.UStringsKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001e\u001a\u00020\u001a8\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0018\u0010\u001d¨\u0006\u001f"}, d2 = {"Lkotlinx/serialization/json/internal/JsonDecoderForUnsignedTypes;", "Lkotlinx/serialization/encoding/AbstractDecoder;", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "lexer", "Lkotlinx/serialization/json/Json;", "json", "<init>", "(Lkotlinx/serialization/json/internal/AbstractJsonLexer;Lkotlinx/serialization/json/Json;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "w", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "u", "()I", "", "h", "()J", "", "H", "()B", "", "m", "()S", "a", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "Lkotlinx/serialization/modules/SerializersModule;", "b", "Lkotlinx/serialization/modules/SerializersModule;", "()Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nStreamingJsonDecoder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamingJsonDecoder.kt\nkotlinx/serialization/json/internal/JsonDecoderForUnsignedTypes\n+ 2 StreamingJsonDecoder.kt\nkotlinx/serialization/json/internal/StreamingJsonDecoderKt\n*L\n1#1,391:1\n384#2,5:392\n384#2,5:397\n384#2,5:402\n384#2,5:407\n*S KotlinDebug\n*F\n+ 1 StreamingJsonDecoder.kt\nkotlinx/serialization/json/internal/JsonDecoderForUnsignedTypes\n*L\n377#1:392,5\n378#1:397,5\n379#1:402,5\n380#1:407,5\n*E\n"})
public final class JsonDecoderForUnsignedTypes extends AbstractDecoder {

    /* renamed from: a  reason: collision with root package name */
    public final AbstractJsonLexer f4105a;
    public final SerializersModule b;

    public JsonDecoderForUnsignedTypes(AbstractJsonLexer abstractJsonLexer, Json json) {
        Intrinsics.checkNotNullParameter(abstractJsonLexer, "lexer");
        Intrinsics.checkNotNullParameter(json, "json");
        this.f4105a = abstractJsonLexer;
        this.b = json.c();
    }

    public byte H() {
        AbstractJsonLexer abstractJsonLexer = this.f4105a;
        String q = abstractJsonLexer.q();
        try {
            return UStringsKt.toUByte(q);
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.x(abstractJsonLexer, "Failed to parse type '" + "UByte" + "' for input '" + q + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public SerializersModule a() {
        return this.b;
    }

    public long h() {
        AbstractJsonLexer abstractJsonLexer = this.f4105a;
        String q = abstractJsonLexer.q();
        try {
            return UStringsKt.toULong(q);
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.x(abstractJsonLexer, "Failed to parse type '" + "ULong" + "' for input '" + q + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public short m() {
        AbstractJsonLexer abstractJsonLexer = this.f4105a;
        String q = abstractJsonLexer.q();
        try {
            return UStringsKt.toUShort(q);
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.x(abstractJsonLexer, "Failed to parse type '" + "UShort" + "' for input '" + q + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public int u() {
        AbstractJsonLexer abstractJsonLexer = this.f4105a;
        String q = abstractJsonLexer.q();
        try {
            return UStringsKt.toUInt(q);
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.x(abstractJsonLexer, "Failed to parse type '" + "UInt" + "' for input '" + q + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public int w(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        throw new IllegalStateException("unsupported".toString());
    }
}
