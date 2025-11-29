package kotlinx.serialization.json.internal;

import com.honey.account.constant.AccountConstantKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.NamedValueEncoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0002\r\u0012\b3\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\"\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\"\u0010#J\u001f\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0006H&¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0006H&¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0007H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0007H\u0016¢\u0006\u0004\b+\u0010*J\u0017\u0010,\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b,\u0010-J\u001f\u0010/\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u0016H\u0014¢\u0006\u0004\b/\u00100J\u001f\u00102\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010.\u001a\u000201H\u0014¢\u0006\u0004\b2\u00103J\u001f\u00105\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010.\u001a\u000204H\u0014¢\u0006\u0004\b5\u00106J\u001f\u00108\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010.\u001a\u000207H\u0014¢\u0006\u0004\b8\u00109J\u001f\u0010;\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020:H\u0014¢\u0006\u0004\b;\u0010<J+\u0010@\u001a\u00020\u0007\"\u0004\b\u0000\u0010=2\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000>2\u0006\u0010.\u001a\u00028\u0000H\u0016¢\u0006\u0004\b@\u0010AJ\u001f\u0010C\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020BH\u0014¢\u0006\u0004\bC\u0010DJ\u001f\u0010E\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u001dH\u0014¢\u0006\u0004\bE\u0010FJ\u001f\u0010H\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020GH\u0014¢\u0006\u0004\bH\u0010IJ\u001f\u0010J\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000bH\u0014¢\u0006\u0004\bJ\u0010KJ'\u0010N\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020\u00102\u0006\u0010M\u001a\u00020\u0016H\u0014¢\u0006\u0004\bN\u0010OJ\u001f\u0010Q\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020PH\u0014¢\u0006\u0004\bQ\u0010RJ\u001f\u0010T\u001a\u00020S2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\bT\u0010UJ\u0017\u0010V\u001a\u00020S2\u0006\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0004\bV\u0010WJ\u0017\u0010Y\u001a\u00020X2\u0006\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0004\bY\u0010ZJ\u0017\u0010[\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0010H\u0014¢\u0006\u0004\b[\u0010\\R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\bY\u0010]\u001a\u0004\b^\u0010_R&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0004X\u0004¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010cR\u0014\u0010f\u001a\u00020d8\u0004X\u0004¢\u0006\u0006\n\u0004\b^\u0010eR\u0018\u0010h\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010gR\u0011\u0010l\u001a\u00020i8F¢\u0006\u0006\u001a\u0004\bj\u0010k\u0001\u0003mno¨\u0006p"}, d2 = {"Lkotlinx/serialization/json/internal/AbstractJsonTreeEncoder;", "Lkotlinx/serialization/internal/NamedValueEncoder;", "Lkotlinx/serialization/json/JsonEncoder;", "Lkotlinx/serialization/json/Json;", "json", "Lkotlin/Function1;", "Lkotlinx/serialization/json/JsonElement;", "", "nodeConsumer", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlin/jvm/functions/Function1;)V", "", "tag", "kotlinx/serialization/json/internal/AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1", "y0", "(Ljava/lang/String;)Lkotlinx/serialization/json/internal/AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "inlineDescriptor", "kotlinx/serialization/json/internal/AbstractJsonTreeEncoder$inlineUnquotedLiteralEncoder$1", "x0", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/json/internal/AbstractJsonTreeEncoder$inlineUnquotedLiteralEncoder$1;", "descriptor", "", "index", "e0", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/String;", "element", "r", "(Lkotlinx/serialization/json/JsonElement;)V", "", "q", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", "parentName", "childName", "d0", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "key", "z0", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;)V", "v0", "()Lkotlinx/serialization/json/JsonElement;", "E", "()V", "B", "r0", "(Ljava/lang/String;)V", "value", "p0", "(Ljava/lang/String;I)V", "", "j0", "(Ljava/lang/String;B)V", "", "s0", "(Ljava/lang/String;S)V", "", "q0", "(Ljava/lang/String;J)V", "", "n0", "(Ljava/lang/String;F)V", "T", "Lkotlinx/serialization/SerializationStrategy;", "serializer", "e", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "", "l0", "(Ljava/lang/String;D)V", "i0", "(Ljava/lang/String;Z)V", "", "k0", "(Ljava/lang/String;C)V", "t0", "(Ljava/lang/String;Ljava/lang/String;)V", "enumDescriptor", "ordinal", "m0", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;I)V", "", "u0", "(Ljava/lang/String;Ljava/lang/Object;)V", "Lkotlinx/serialization/encoding/Encoder;", "o0", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Encoder;", "h", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Encoder;", "Lkotlinx/serialization/encoding/CompositeEncoder;", "b", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeEncoder;", "X", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "Lkotlinx/serialization/json/Json;", "d", "()Lkotlinx/serialization/json/Json;", "c", "Lkotlin/jvm/functions/Function1;", "w0", "()Lkotlin/jvm/functions/Function1;", "Lkotlinx/serialization/json/JsonConfiguration;", "Lkotlinx/serialization/json/JsonConfiguration;", "configuration", "Ljava/lang/String;", "polymorphicDiscriminator", "Lkotlinx/serialization/modules/SerializersModule;", "a", "()Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "Lkotlinx/serialization/json/internal/JsonPrimitiveEncoder;", "Lkotlinx/serialization/json/internal/JsonTreeEncoder;", "Lkotlinx/serialization/json/internal/JsonTreeListEncoder;", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTreeJsonEncoder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TreeJsonEncoder.kt\nkotlinx/serialization/json/internal/AbstractJsonTreeEncoder\n+ 2 Polymorphic.kt\nkotlinx/serialization/json/internal/PolymorphicKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 WriteMode.kt\nkotlinx/serialization/json/internal/WriteModeKt\n*L\n1#1,260:1\n21#2,12:261\n35#2,13:274\n1#3:273\n36#4,9:287\n*S KotlinDebug\n*F\n+ 1 TreeJsonEncoder.kt\nkotlinx/serialization/json/internal/AbstractJsonTreeEncoder\n*L\n80#1:261,12\n80#1:274,13\n80#1:273\n143#1:287,9\n*E\n"})
@ExperimentalSerializationApi
abstract class AbstractJsonTreeEncoder extends NamedValueEncoder implements JsonEncoder {
    public final Json b;
    public final Function1 c;
    public final JsonConfiguration d;
    public String e;

    public /* synthetic */ AbstractJsonTreeEncoder(Json json, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(json, function1);
    }

    public static final /* synthetic */ String h0(AbstractJsonTreeEncoder abstractJsonTreeEncoder) {
        return (String) abstractJsonTreeEncoder.Y();
    }

    public void B() {
        String str = (String) Z();
        if (str == null) {
            this.c.invoke(JsonNull.INSTANCE);
        } else {
            T(str);
        }
    }

    public void E() {
    }

    public void X(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        this.c.invoke(v0());
    }

    public final SerializersModule a() {
        return this.b.c();
    }

    public CompositeEncoder b(SerialDescriptor serialDescriptor) {
        AbstractJsonTreeEncoder abstractJsonTreeEncoder;
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Function1 abstractJsonTreeEncoder$beginStructure$consumer$1 = Z() == null ? this.c : new AbstractJsonTreeEncoder$beginStructure$consumer$1(this);
        SerialKind kind = serialDescriptor.getKind();
        if (Intrinsics.areEqual((Object) kind, (Object) StructureKind.LIST.f4009a) ? true : kind instanceof PolymorphicKind) {
            abstractJsonTreeEncoder = new JsonTreeListEncoder(this.b, abstractJsonTreeEncoder$beginStructure$consumer$1);
        } else if (Intrinsics.areEqual((Object) kind, (Object) StructureKind.MAP.f4010a)) {
            Json json = this.b;
            SerialDescriptor a2 = WriteModeKt.a(serialDescriptor.d(0), json.c());
            SerialKind kind2 = a2.getKind();
            if ((kind2 instanceof PrimitiveKind) || Intrinsics.areEqual((Object) kind2, (Object) SerialKind.ENUM.f4007a)) {
                abstractJsonTreeEncoder = new JsonTreeMapEncoder(this.b, abstractJsonTreeEncoder$beginStructure$consumer$1);
            } else if (json.b().b()) {
                abstractJsonTreeEncoder = new JsonTreeListEncoder(this.b, abstractJsonTreeEncoder$beginStructure$consumer$1);
            } else {
                throw JsonExceptionsKt.d(a2);
            }
        } else {
            abstractJsonTreeEncoder = new JsonTreeEncoder(this.b, abstractJsonTreeEncoder$beginStructure$consumer$1);
        }
        String str = this.e;
        if (str != null) {
            Intrinsics.checkNotNull(str);
            abstractJsonTreeEncoder.z0(str, JsonElementKt.c(serialDescriptor.h()));
            this.e = null;
        }
        return abstractJsonTreeEncoder;
    }

    public final Json d() {
        return this.b;
    }

    public String d0(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "parentName");
        Intrinsics.checkNotNullParameter(str2, "childName");
        return str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0051, code lost:
        if (d().b().e() != kotlinx.serialization.json.ClassDiscriminatorMode.NONE) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0087, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) kotlinx.serialization.descriptors.StructureKind.OBJECT.f4011a) == false) goto L_0x009c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(kotlinx.serialization.SerializationStrategy r4, java.lang.Object r5) {
        /*
            r3 = this;
            java.lang.String r0 = "serializer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.Object r0 = r3.Z()
            if (r0 != 0) goto L_0x002c
            kotlinx.serialization.descriptors.SerialDescriptor r0 = r4.getDescriptor()
            kotlinx.serialization.modules.SerializersModule r1 = r3.a()
            kotlinx.serialization.descriptors.SerialDescriptor r0 = kotlinx.serialization.json.internal.WriteModeKt.a(r0, r1)
            boolean r0 = kotlinx.serialization.json.internal.TreeJsonEncoderKt.b(r0)
            if (r0 != 0) goto L_0x001e
            goto L_0x002c
        L_0x001e:
            kotlinx.serialization.json.internal.JsonPrimitiveEncoder r0 = new kotlinx.serialization.json.internal.JsonPrimitiveEncoder
            kotlinx.serialization.json.Json r1 = r3.b
            kotlin.jvm.functions.Function1 r3 = r3.c
            r0.<init>(r1, r3)
            r0.e(r4, r5)
            goto L_0x00ea
        L_0x002c:
            kotlinx.serialization.json.Json r0 = r3.d()
            kotlinx.serialization.json.JsonConfiguration r0 = r0.b()
            boolean r0 = r0.n()
            if (r0 == 0) goto L_0x003f
            r4.a(r3, r5)
            goto L_0x00ea
        L_0x003f:
            boolean r0 = r4 instanceof kotlinx.serialization.internal.AbstractPolymorphicSerializer
            if (r0 == 0) goto L_0x0054
            kotlinx.serialization.json.Json r1 = r3.d()
            kotlinx.serialization.json.JsonConfiguration r1 = r1.b()
            kotlinx.serialization.json.ClassDiscriminatorMode r1 = r1.e()
            kotlinx.serialization.json.ClassDiscriminatorMode r2 = kotlinx.serialization.json.ClassDiscriminatorMode.NONE
            if (r1 == r2) goto L_0x009c
            goto L_0x0089
        L_0x0054:
            kotlinx.serialization.json.Json r1 = r3.d()
            kotlinx.serialization.json.JsonConfiguration r1 = r1.b()
            kotlinx.serialization.json.ClassDiscriminatorMode r1 = r1.e()
            int[] r2 = kotlinx.serialization.json.internal.PolymorphicKt.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r2 = 1
            if (r1 == r2) goto L_0x009c
            r2 = 2
            if (r1 == r2) goto L_0x009c
            r2 = 3
            if (r1 != r2) goto L_0x0096
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r4.getDescriptor()
            kotlinx.serialization.descriptors.SerialKind r1 = r1.getKind()
            kotlinx.serialization.descriptors.StructureKind$CLASS r2 = kotlinx.serialization.descriptors.StructureKind.CLASS.f4008a
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 != 0) goto L_0x0089
            kotlinx.serialization.descriptors.StructureKind$OBJECT r2 = kotlinx.serialization.descriptors.StructureKind.OBJECT.f4011a
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x009c
        L_0x0089:
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r4.getDescriptor()
            kotlinx.serialization.json.Json r2 = r3.d()
            java.lang.String r1 = kotlinx.serialization.json.internal.PolymorphicKt.c(r1, r2)
            goto L_0x009d
        L_0x0096:
            kotlin.NoWhenBranchMatchedException r3 = new kotlin.NoWhenBranchMatchedException
            r3.<init>()
            throw r3
        L_0x009c:
            r1 = 0
        L_0x009d:
            if (r0 == 0) goto L_0x00e3
            r0 = r4
            kotlinx.serialization.internal.AbstractPolymorphicSerializer r0 = (kotlinx.serialization.internal.AbstractPolymorphicSerializer) r0
            if (r5 == 0) goto L_0x00bf
            kotlinx.serialization.SerializationStrategy r0 = kotlinx.serialization.PolymorphicSerializerKt.b(r0, r3, r5)
            if (r1 == 0) goto L_0x00ad
            kotlinx.serialization.json.internal.PolymorphicKt.e(r4, r0, r1)
        L_0x00ad:
            kotlinx.serialization.descriptors.SerialDescriptor r4 = r0.getDescriptor()
            kotlinx.serialization.descriptors.SerialKind r4 = r4.getKind()
            kotlinx.serialization.json.internal.PolymorphicKt.b(r4)
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.encodePolymorphically>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r4)
            r4 = r0
            goto L_0x00e3
        L_0x00bf:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Value for serializer "
            r3.append(r5)
            kotlinx.serialization.descriptors.SerialDescriptor r4 = r4.getDescriptor()
            r3.append(r4)
            java.lang.String r4 = " should always be non-null. Please report issue to the kotlinx.serialization tracker."
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r3 = r3.toString()
            r4.<init>(r3)
            throw r4
        L_0x00e3:
            if (r1 == 0) goto L_0x00e7
            r3.e = r1
        L_0x00e7:
            r4.a(r3, r5)
        L_0x00ea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.AbstractJsonTreeEncoder.e(kotlinx.serialization.SerializationStrategy, java.lang.Object):void");
    }

    public String e0(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return JsonNamesMapKt.g(serialDescriptor, this.b, i);
    }

    public Encoder h(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return Z() != null ? super.h(serialDescriptor) : new JsonPrimitiveEncoder(this.b, this.c).h(serialDescriptor);
    }

    /* renamed from: i0 */
    public void J(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "tag");
        z0(str, JsonElementKt.a(Boolean.valueOf(z)));
    }

    /* renamed from: j0 */
    public void K(String str, byte b2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        z0(str, JsonElementKt.b(Byte.valueOf(b2)));
    }

    /* renamed from: k0 */
    public void L(String str, char c2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        z0(str, JsonElementKt.c(String.valueOf(c2)));
    }

    /* renamed from: l0 */
    public void M(String str, double d2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        z0(str, JsonElementKt.b(Double.valueOf(d2)));
        if (this.d.a()) {
            return;
        }
        if (Double.isInfinite(d2) || Double.isNaN(d2)) {
            throw JsonExceptionsKt.c(Double.valueOf(d2), str, v0().toString());
        }
    }

    /* renamed from: m0 */
    public void N(String str, SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(serialDescriptor, "enumDescriptor");
        z0(str, JsonElementKt.c(serialDescriptor.f(i)));
    }

    /* renamed from: n0 */
    public void O(String str, float f) {
        Intrinsics.checkNotNullParameter(str, "tag");
        z0(str, JsonElementKt.b(Float.valueOf(f)));
        if (this.d.a()) {
            return;
        }
        if (Float.isInfinite(f) || Float.isNaN(f)) {
            throw JsonExceptionsKt.c(Float.valueOf(f), str, v0().toString());
        }
    }

    /* renamed from: o0 */
    public Encoder P(String str, SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(serialDescriptor, "inlineDescriptor");
        return StreamingJsonEncoderKt.b(serialDescriptor) ? y0(str) : StreamingJsonEncoderKt.a(serialDescriptor) ? x0(str, serialDescriptor) : super.P(str, serialDescriptor);
    }

    /* renamed from: p0 */
    public void Q(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "tag");
        z0(str, JsonElementKt.b(Integer.valueOf(i)));
    }

    public boolean q(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return this.d.h();
    }

    /* renamed from: q0 */
    public void R(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "tag");
        z0(str, JsonElementKt.b(Long.valueOf(j)));
    }

    public void r(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "element");
        e(JsonElementSerializer.f4081a, jsonElement);
    }

    /* renamed from: r0 */
    public void T(String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        z0(str, JsonNull.INSTANCE);
    }

    /* renamed from: s0 */
    public void U(String str, short s) {
        Intrinsics.checkNotNullParameter(str, "tag");
        z0(str, JsonElementKt.b(Short.valueOf(s)));
    }

    /* renamed from: t0 */
    public void V(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, AccountConstantKt.RESPONSE_VALUE);
        z0(str, JsonElementKt.c(str2));
    }

    /* renamed from: u0 */
    public void W(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(obj, AccountConstantKt.RESPONSE_VALUE);
        z0(str, JsonElementKt.c(obj.toString()));
    }

    public abstract JsonElement v0();

    public final Function1 w0() {
        return this.c;
    }

    public final AbstractJsonTreeEncoder$inlineUnquotedLiteralEncoder$1 x0(String str, SerialDescriptor serialDescriptor) {
        return new AbstractJsonTreeEncoder$inlineUnquotedLiteralEncoder$1(this, str, serialDescriptor);
    }

    public final AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1 y0(String str) {
        return new AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1(this, str);
    }

    public abstract void z0(String str, JsonElement jsonElement);

    public AbstractJsonTreeEncoder(Json json, Function1 function1) {
        this.b = json;
        this.c = function1;
        this.d = json.b();
    }
}
