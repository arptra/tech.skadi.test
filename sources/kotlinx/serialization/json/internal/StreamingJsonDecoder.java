package kotlinx.serialization.json.internal;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.encoding.ChunkedDecoder;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001lB1\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\u00020\u0012*\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0010H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u001aH\u0002¢\u0006\u0004\b%\u0010\u001cJ\u000f\u0010&\u001a\u00020\u0010H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*J#\u0010.\u001a\u00028\u0000\"\u0004\b\u0000\u0010+2\f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000,H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u0002002\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b3\u0010\u0017J\u000f\u00104\u001a\u00020\u0012H\u0016¢\u0006\u0004\b4\u00105J\u0011\u00107\u001a\u0004\u0018\u000106H\u0016¢\u0006\u0004\b7\u00108J=\u0010:\u001a\u00028\u0000\"\u0004\b\u0000\u0010+2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001a2\f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000,2\b\u00109\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b<\u0010!J\u000f\u0010=\u001a\u00020\u0012H\u0016¢\u0006\u0004\b=\u00105J\u000f\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b?\u0010@J\u000f\u0010B\u001a\u00020AH\u0016¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\u001aH\u0016¢\u0006\u0004\bD\u0010\u001cJ\u000f\u0010F\u001a\u00020EH\u0016¢\u0006\u0004\bF\u0010GJ\u000f\u0010I\u001a\u00020HH\u0016¢\u0006\u0004\bI\u0010JJ\u000f\u0010L\u001a\u00020KH\u0016¢\u0006\u0004\bL\u0010MJ\u000f\u0010O\u001a\u00020NH\u0016¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\u0010H\u0016¢\u0006\u0004\bQ\u0010'J\u0017\u0010S\u001a\u00020R2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\bS\u0010TJ\u0017\u0010V\u001a\u00020\u001a2\u0006\u0010U\u001a\u00020\nH\u0016¢\u0006\u0004\bV\u0010!R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u0010[R\u0014\u0010\t\u001a\u00020\b8\u0000X\u0004¢\u0006\u0006\n\u0004\b3\u0010\\R\u001a\u0010`\u001a\u00020]8\u0016X\u0004¢\u0006\f\n\u0004\bY\u0010^\u001a\u0004\bW\u0010_R\u0016\u0010c\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010h\u001a\u00020f8\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u0010gR\u0016\u0010k\u001a\u0004\u0018\u00010i8\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010j¨\u0006m"}, d2 = {"Lkotlinx/serialization/json/internal/StreamingJsonDecoder;", "Lkotlinx/serialization/json/JsonDecoder;", "Lkotlinx/serialization/encoding/ChunkedDecoder;", "Lkotlinx/serialization/encoding/AbstractDecoder;", "Lkotlinx/serialization/json/Json;", "json", "Lkotlinx/serialization/json/internal/WriteMode;", "mode", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "lexer", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/json/internal/StreamingJsonDecoder$DiscriminatorHolder;", "discriminatorHolder", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;Lkotlinx/serialization/json/internal/AbstractJsonLexer;Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/json/internal/StreamingJsonDecoder$DiscriminatorHolder;)V", "", "unknownKey", "", "S", "(Lkotlinx/serialization/json/internal/StreamingJsonDecoder$DiscriminatorHolder;Ljava/lang/String;)Z", "", "R", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "K", "()V", "", "N", "()I", "index", "L", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", "O", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "key", "Q", "(Ljava/lang/String;)Z", "M", "P", "()Ljava/lang/String;", "Lkotlinx/serialization/json/JsonElement;", "t", "()Lkotlinx/serialization/json/JsonElement;", "T", "Lkotlinx/serialization/DeserializationStrategy;", "deserializer", "G", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "Lkotlinx/serialization/encoding/CompositeDecoder;", "b", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeDecoder;", "c", "D", "()Z", "", "g", "()Ljava/lang/Void;", "previousValue", "p", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "w", "A", "", "H", "()B", "", "m", "()S", "u", "", "h", "()J", "", "y", "()F", "", "n", "()D", "", "o", "()C", "q", "Lkotlinx/serialization/encoding/Decoder;", "x", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Decoder;", "enumDescriptor", "s", "a", "Lkotlinx/serialization/json/Json;", "d", "()Lkotlinx/serialization/json/Json;", "Lkotlinx/serialization/json/internal/WriteMode;", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "Lkotlinx/serialization/modules/SerializersModule;", "Lkotlinx/serialization/modules/SerializersModule;", "()Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "e", "I", "currentIndex", "f", "Lkotlinx/serialization/json/internal/StreamingJsonDecoder$DiscriminatorHolder;", "Lkotlinx/serialization/json/JsonConfiguration;", "Lkotlinx/serialization/json/JsonConfiguration;", "configuration", "Lkotlinx/serialization/json/internal/JsonElementMarker;", "Lkotlinx/serialization/json/internal/JsonElementMarker;", "elementMarker", "DiscriminatorHolder", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nStreamingJsonDecoder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamingJsonDecoder.kt\nkotlinx/serialization/json/internal/StreamingJsonDecoder\n+ 2 AbstractJsonLexer.kt\nkotlinx/serialization/json/internal/AbstractJsonLexer\n+ 3 JsonNamesMap.kt\nkotlinx/serialization/json/internal/JsonNamesMapKt\n+ 4 StreamingJsonDecoder.kt\nkotlinx/serialization/json/internal/StreamingJsonDecoderKt\n*L\n1#1,391:1\n531#2,3:392\n531#2,3:395\n119#3,17:398\n384#4,5:415\n384#4,5:420\n*S KotlinDebug\n*F\n+ 1 StreamingJsonDecoder.kt\nkotlinx/serialization/json/internal/StreamingJsonDecoder\n*L\n202#1:392,3\n203#1:395,3\n215#1:398,17\n308#1:415,5\n315#1:420,5\n*E\n"})
public class StreamingJsonDecoder extends AbstractDecoder implements JsonDecoder, ChunkedDecoder {

    /* renamed from: a  reason: collision with root package name */
    public final Json f4116a;
    public final WriteMode b;
    public final AbstractJsonLexer c;
    public final SerializersModule d;
    public int e = -1;
    public DiscriminatorHolder f;
    public final JsonConfiguration g;
    public final JsonElementMarker h;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlinx/serialization/json/internal/StreamingJsonDecoder$DiscriminatorHolder;", "", "", "discriminatorToSkip", "<init>", "(Ljava/lang/String;)V", "a", "Ljava/lang/String;", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
    public static final class DiscriminatorHolder {

        /* renamed from: a  reason: collision with root package name */
        public String f4117a;

        public DiscriminatorHolder(String str) {
            this.f4117a = str;
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                kotlinx.serialization.json.internal.WriteMode[] r0 = kotlinx.serialization.json.internal.WriteMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlinx.serialization.json.internal.WriteMode r1 = kotlinx.serialization.json.internal.WriteMode.LIST     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlinx.serialization.json.internal.WriteMode r1 = kotlinx.serialization.json.internal.WriteMode.MAP     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlinx.serialization.json.internal.WriteMode r1 = kotlinx.serialization.json.internal.WriteMode.POLY_OBJ     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                kotlinx.serialization.json.internal.WriteMode r1 = kotlinx.serialization.json.internal.WriteMode.OBJ     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.StreamingJsonDecoder.WhenMappings.<clinit>():void");
        }
    }

    public StreamingJsonDecoder(Json json, WriteMode writeMode, AbstractJsonLexer abstractJsonLexer, SerialDescriptor serialDescriptor, DiscriminatorHolder discriminatorHolder) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(writeMode, RtspHeaders.Values.MODE);
        Intrinsics.checkNotNullParameter(abstractJsonLexer, "lexer");
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        this.f4116a = json;
        this.b = writeMode;
        this.c = abstractJsonLexer;
        this.d = json.c();
        this.f = discriminatorHolder;
        JsonConfiguration b2 = json.b();
        this.g = b2;
        this.h = b2.i() ? null : new JsonElementMarker(serialDescriptor);
    }

    public boolean A() {
        return this.c.g();
    }

    public boolean D() {
        JsonElementMarker jsonElementMarker = this.h;
        return !(jsonElementMarker != null ? jsonElementMarker.b() : false) && !AbstractJsonLexer.Q(this.c, false, 1, (Object) null);
    }

    public Object G(DeserializationStrategy deserializationStrategy) {
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        try {
            if (deserializationStrategy instanceof AbstractPolymorphicSerializer) {
                if (!this.f4116a.b().n()) {
                    String c2 = PolymorphicKt.c(deserializationStrategy.getDescriptor(), this.f4116a);
                    String G = this.c.G(c2, this.g.o());
                    if (G == null) {
                        return PolymorphicKt.d(this, deserializationStrategy);
                    }
                    DeserializationStrategy a2 = PolymorphicSerializerKt.a((AbstractPolymorphicSerializer) deserializationStrategy, this, G);
                    Intrinsics.checkNotNull(a2, "null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T of kotlinx.serialization.json.internal.StreamingJsonDecoder.decodeSerializableValue>");
                    this.f = new DiscriminatorHolder(c2);
                    return a2.c(this);
                }
            }
            return deserializationStrategy.c(this);
        } catch (SerializationException e2) {
            String message = e2.getMessage();
            Intrinsics.checkNotNull(message);
            String removeSuffix = StringsKt.removeSuffix(StringsKt.substringBefore$default(message, 10, (String) null, 2, (Object) null), (CharSequence) ".");
            String message2 = e2.getMessage();
            Intrinsics.checkNotNull(message2);
            AbstractJsonLexer.x(this.c, removeSuffix, 0, StringsKt.substringAfter(message2, 10, ""), 2, (Object) null);
            throw new KotlinNothingValueException();
        } catch (MissingFieldException e3) {
            String message3 = e3.getMessage();
            Intrinsics.checkNotNull(message3);
            if (StringsKt.contains$default((CharSequence) message3, (CharSequence) "at path", false, 2, (Object) null)) {
                throw e3;
            }
            List<String> missingFields = e3.getMissingFields();
            throw new MissingFieldException(missingFields, e3.getMessage() + " at path: " + this.c.b.a(), e3);
        }
    }

    public byte H() {
        long m = this.c.m();
        byte b2 = (byte) ((int) m);
        if (m == ((long) b2)) {
            return b2;
        }
        AbstractJsonLexer abstractJsonLexer = this.c;
        AbstractJsonLexer.x(abstractJsonLexer, "Failed to parse byte for input '" + m + '\'', 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public final void K() {
        if (this.c.H() == 4) {
            AbstractJsonLexer.x(this.c, "Unexpected leading comma", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public final boolean L(SerialDescriptor serialDescriptor, int i) {
        String I;
        Json json = this.f4116a;
        if (!serialDescriptor.i(i)) {
            return false;
        }
        SerialDescriptor d2 = serialDescriptor.d(i);
        if (d2.b() || !this.c.P(true)) {
            if (!Intrinsics.areEqual((Object) d2.getKind(), (Object) SerialKind.ENUM.f4007a)) {
                return false;
            }
            if ((d2.b() && this.c.P(false)) || (I = this.c.I(this.g.o())) == null || JsonNamesMapKt.h(d2, json, I) != -3) {
                return false;
            }
            this.c.o();
        }
        return true;
    }

    public final int M() {
        boolean O = this.c.O();
        if (this.c.e()) {
            int i = this.e;
            if (i == -1 || O) {
                int i2 = i + 1;
                this.e = i2;
                return i2;
            }
            AbstractJsonLexer.x(this.c, "Expected end of the array or comma", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        } else if (!O || this.f4116a.b().c()) {
            return -1;
        } else {
            JsonExceptionsKt.h(this.c, "array");
            throw new KotlinNothingValueException();
        }
    }

    public final int N() {
        int i = this.e;
        boolean z = false;
        boolean z2 = i % 2 != 0;
        if (!z2) {
            this.c.l(':');
        } else if (i != -1) {
            z = this.c.O();
        }
        if (this.c.e()) {
            if (z2) {
                if (this.e == -1) {
                    AbstractJsonLexer abstractJsonLexer = this.c;
                    boolean z3 = !z;
                    int i2 = abstractJsonLexer.f4093a;
                    if (!z3) {
                        AbstractJsonLexer.x(abstractJsonLexer, "Unexpected leading comma", i2, (String) null, 4, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                } else {
                    AbstractJsonLexer abstractJsonLexer2 = this.c;
                    int i3 = abstractJsonLexer2.f4093a;
                    if (!z) {
                        AbstractJsonLexer.x(abstractJsonLexer2, "Expected comma after the key-value pair", i3, (String) null, 4, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                }
            }
            int i4 = this.e + 1;
            this.e = i4;
            return i4;
        } else if (!z || this.f4116a.b().c()) {
            return -1;
        } else {
            JsonExceptionsKt.i(this.c, (String) null, 1, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public final int O(SerialDescriptor serialDescriptor) {
        int h2;
        boolean z;
        boolean O = this.c.O();
        while (true) {
            boolean z2 = true;
            if (this.c.e()) {
                String P = P();
                this.c.l(':');
                h2 = JsonNamesMapKt.h(serialDescriptor, this.f4116a, P);
                if (h2 == -3) {
                    z = false;
                } else if (!this.g.f() || !L(serialDescriptor, h2)) {
                    JsonElementMarker jsonElementMarker = this.h;
                } else {
                    z = this.c.O();
                    z2 = false;
                }
                O = z2 ? Q(P) : z;
            } else if (!O || this.f4116a.b().c()) {
                JsonElementMarker jsonElementMarker2 = this.h;
                if (jsonElementMarker2 != null) {
                    return jsonElementMarker2.d();
                }
                return -1;
            } else {
                JsonExceptionsKt.i(this.c, (String) null, 1, (Object) null);
                throw new KotlinNothingValueException();
            }
        }
        JsonElementMarker jsonElementMarker3 = this.h;
        if (jsonElementMarker3 != null) {
            jsonElementMarker3.c(h2);
        }
        return h2;
    }

    public final String P() {
        return this.g.o() ? this.c.r() : this.c.i();
    }

    public final boolean Q(String str) {
        if (this.g.j() || S(this.f, str)) {
            this.c.K(this.g.o());
        } else {
            this.c.A(str);
        }
        return this.c.O();
    }

    public final void R(SerialDescriptor serialDescriptor) {
        do {
        } while (w(serialDescriptor) != -1);
    }

    public final boolean S(DiscriminatorHolder discriminatorHolder, String str) {
        if (discriminatorHolder == null || !Intrinsics.areEqual((Object) discriminatorHolder.f4117a, (Object) str)) {
            return false;
        }
        discriminatorHolder.f4117a = null;
        return true;
    }

    public SerializersModule a() {
        return this.d;
    }

    public CompositeDecoder b(SerialDescriptor serialDescriptor) {
        StreamingJsonDecoder streamingJsonDecoder;
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        WriteMode b2 = WriteModeKt.b(this.f4116a, serialDescriptor);
        this.c.b.c(serialDescriptor);
        this.c.l(b2.begin);
        K();
        int i = WhenMappings.$EnumSwitchMapping$0[b2.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            streamingJsonDecoder = new StreamingJsonDecoder(this.f4116a, b2, this.c, serialDescriptor, this.f);
        } else if (this.b == b2 && this.f4116a.b().i()) {
            return this;
        } else {
            streamingJsonDecoder = new StreamingJsonDecoder(this.f4116a, b2, this.c, serialDescriptor, this.f);
        }
        return streamingJsonDecoder;
    }

    public void c(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (this.f4116a.b().j() && serialDescriptor.e() == 0) {
            R(serialDescriptor);
        }
        if (!this.c.O() || this.f4116a.b().c()) {
            this.c.l(this.b.end);
            this.c.b.b();
            return;
        }
        JsonExceptionsKt.h(this.c, "");
        throw new KotlinNothingValueException();
    }

    public final Json d() {
        return this.f4116a;
    }

    public Void g() {
        return null;
    }

    public long h() {
        return this.c.m();
    }

    public short m() {
        long m = this.c.m();
        short s = (short) ((int) m);
        if (m == ((long) s)) {
            return s;
        }
        AbstractJsonLexer abstractJsonLexer = this.c;
        AbstractJsonLexer.x(abstractJsonLexer, "Failed to parse short for input '" + m + '\'', 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public double n() {
        AbstractJsonLexer abstractJsonLexer = this.c;
        String q = abstractJsonLexer.q();
        try {
            double parseDouble = Double.parseDouble(q);
            if (this.f4116a.b().a() || (!Double.isInfinite(parseDouble) && !Double.isNaN(parseDouble))) {
                return parseDouble;
            }
            JsonExceptionsKt.l(this.c, Double.valueOf(parseDouble));
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.x(abstractJsonLexer, "Failed to parse type '" + "double" + "' for input '" + q + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public char o() {
        String q = this.c.q();
        if (q.length() == 1) {
            return q.charAt(0);
        }
        AbstractJsonLexer abstractJsonLexer = this.c;
        AbstractJsonLexer.x(abstractJsonLexer, "Expected single char, but got '" + q + '\'', 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public Object p(SerialDescriptor serialDescriptor, int i, DeserializationStrategy deserializationStrategy, Object obj) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        boolean z = this.b == WriteMode.MAP && (i & 1) == 0;
        if (z) {
            this.c.b.d();
        }
        Object p = super.p(serialDescriptor, i, deserializationStrategy, obj);
        if (z) {
            this.c.b.f(p);
        }
        return p;
    }

    public String q() {
        return this.g.o() ? this.c.r() : this.c.o();
    }

    public int s(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "enumDescriptor");
        Json json = this.f4116a;
        String q = q();
        return JsonNamesMapKt.i(serialDescriptor, json, q, " at path " + this.c.b.a());
    }

    public JsonElement t() {
        return new JsonTreeReader(this.f4116a.b(), this.c).e();
    }

    public int u() {
        long m = this.c.m();
        int i = (int) m;
        if (m == ((long) i)) {
            return i;
        }
        AbstractJsonLexer abstractJsonLexer = this.c;
        AbstractJsonLexer.x(abstractJsonLexer, "Failed to parse int for input '" + m + '\'', 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public int w(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        int i = WhenMappings.$EnumSwitchMapping$0[this.b.ordinal()];
        int M = i != 2 ? i != 4 ? M() : O(serialDescriptor) : N();
        if (this.b != WriteMode.MAP) {
            this.c.b.g(M);
        }
        return M;
    }

    public Decoder x(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return StreamingJsonEncoderKt.b(serialDescriptor) ? new JsonDecoderForUnsignedTypes(this.c, this.f4116a) : super.x(serialDescriptor);
    }

    public float y() {
        AbstractJsonLexer abstractJsonLexer = this.c;
        String q = abstractJsonLexer.q();
        try {
            float parseFloat = Float.parseFloat(q);
            if (this.f4116a.b().a() || (!Float.isInfinite(parseFloat) && !Float.isNaN(parseFloat))) {
                return parseFloat;
            }
            JsonExceptionsKt.l(this.c, Float.valueOf(parseFloat));
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.x(abstractJsonLexer, "Failed to parse type '" + "float" + "' for input '" + q + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }
}
