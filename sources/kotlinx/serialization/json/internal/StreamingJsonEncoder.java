package kotlinx.serialization.json.internal;

import com.honey.account.constant.AccountConstantKt;
import io.netty.handler.codec.rtsp.RtspHeaders;
import io.netty.util.internal.StringUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001d\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\"\u0010#J\u001f\u0010$\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b$\u0010\u0018JA\u0010&\u001a\u00020\u000f\"\b\b\u0000\u0010\u0019*\u00020%2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020(2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u000fH\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0016H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020/H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u000202H\u0016¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0014H\u0016¢\u0006\u0004\b5\u00106J\u0017\u00108\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u000207H\u0016¢\u0006\u0004\b8\u00109J\u0017\u0010;\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020:H\u0016¢\u0006\u0004\b;\u0010<J\u0017\u0010>\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020=H\u0016¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020@H\u0016¢\u0006\u0004\bA\u0010BJ\u0017\u0010D\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020CH\u0016¢\u0006\u0004\bD\u0010EJ\u001f\u0010G\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\bG\u0010HJ\u0017\u0010I\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\bI\u0010#R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0004¢\u0006\f\n\u0004\b \u0010L\u001a\u0004\bM\u0010NR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010OR\u001e\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t8\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010PR\u001a\u0010T\u001a\u00020Q8\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010R\u001a\u0004\bJ\u0010SR\u0014\u0010W\u001a\u00020U8\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u0010VR\u0016\u0010Y\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010XR\u0018\u0010[\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010Z¨\u0006\\"}, d2 = {"Lkotlinx/serialization/json/internal/StreamingJsonEncoder;", "Lkotlinx/serialization/json/JsonEncoder;", "Lkotlinx/serialization/encoding/AbstractEncoder;", "Lkotlinx/serialization/json/internal/Composer;", "composer", "Lkotlinx/serialization/json/Json;", "json", "Lkotlinx/serialization/json/internal/WriteMode;", "mode", "", "modeReuseCache", "<init>", "(Lkotlinx/serialization/json/internal/Composer;Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;[Lkotlinx/serialization/json/JsonEncoder;)V", "Lkotlinx/serialization/json/JsonElement;", "element", "", "r", "(Lkotlinx/serialization/json/JsonElement;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "index", "", "q", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", "T", "Lkotlinx/serialization/SerializationStrategy;", "serializer", "value", "e", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "Lkotlinx/serialization/encoding/CompositeEncoder;", "b", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeEncoder;", "c", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "H", "", "y", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "Lkotlinx/serialization/encoding/Encoder;", "h", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Encoder;", "B", "()V", "l", "(Z)V", "", "f", "(B)V", "", "k", "(S)V", "s", "(I)V", "", "A", "(J)V", "", "m", "(F)V", "", "x", "(D)V", "", "D", "(C)V", "", "v", "(Ljava/lang/String;)V", "enumDescriptor", "g", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)V", "K", "a", "Lkotlinx/serialization/json/internal/Composer;", "Lkotlinx/serialization/json/Json;", "d", "()Lkotlinx/serialization/json/Json;", "Lkotlinx/serialization/json/internal/WriteMode;", "[Lkotlinx/serialization/json/JsonEncoder;", "Lkotlinx/serialization/modules/SerializersModule;", "Lkotlinx/serialization/modules/SerializersModule;", "()Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "Lkotlinx/serialization/json/JsonConfiguration;", "Lkotlinx/serialization/json/JsonConfiguration;", "configuration", "Z", "forceQuoting", "Ljava/lang/String;", "polymorphicDiscriminator", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nStreamingJsonEncoder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamingJsonEncoder.kt\nkotlinx/serialization/json/internal/StreamingJsonEncoder\n+ 2 Polymorphic.kt\nkotlinx/serialization/json/internal/PolymorphicKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,224:1\n170#1,2:251\n170#1,2:253\n21#2,12:225\n35#2,13:238\n1#3:237\n*S KotlinDebug\n*F\n+ 1 StreamingJsonEncoder.kt\nkotlinx/serialization/json/internal/StreamingJsonEncoder\n*L\n161#1:251,2\n162#1:253,2\n64#1:225,12\n64#1:238,13\n64#1:237\n*E\n"})
public final class StreamingJsonEncoder extends AbstractEncoder implements JsonEncoder {

    /* renamed from: a  reason: collision with root package name */
    public final Composer f4118a;
    public final Json b;
    public final WriteMode c;
    public final JsonEncoder[] d;
    public final SerializersModule e = d().c();
    public final JsonConfiguration f = d().b();
    public boolean g;
    public String h;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
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
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.StreamingJsonEncoder.WhenMappings.<clinit>():void");
        }
    }

    public StreamingJsonEncoder(Composer composer, Json json, WriteMode writeMode, JsonEncoder[] jsonEncoderArr) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(writeMode, RtspHeaders.Values.MODE);
        this.f4118a = composer;
        this.b = json;
        this.c = writeMode;
        this.d = jsonEncoderArr;
        int ordinal = writeMode.ordinal();
        if (jsonEncoderArr != null) {
            JsonEncoder jsonEncoder = jsonEncoderArr[ordinal];
            if (jsonEncoder != null || jsonEncoder != this) {
                jsonEncoderArr[ordinal] = this;
            }
        }
    }

    public void A(long j) {
        if (this.g) {
            v(String.valueOf(j));
        } else {
            this.f4118a.j(j);
        }
    }

    public void B() {
        this.f4118a.k("null");
    }

    public void D(char c2) {
        v(String.valueOf(c2));
    }

    public boolean H(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.c.ordinal()];
        if (i2 != 1) {
            boolean z = false;
            if (i2 != 2) {
                if (i2 != 3) {
                    if (!this.f4118a.a()) {
                        this.f4118a.f(StringUtil.COMMA);
                    }
                    this.f4118a.c();
                    v(JsonNamesMapKt.g(serialDescriptor, d(), i));
                    this.f4118a.f(':');
                    this.f4118a.p();
                } else {
                    if (i == 0) {
                        this.g = true;
                    }
                    if (i == 1) {
                        this.f4118a.f(StringUtil.COMMA);
                        this.f4118a.p();
                        this.g = false;
                    }
                }
            } else if (!this.f4118a.a()) {
                if (i % 2 == 0) {
                    this.f4118a.f(StringUtil.COMMA);
                    this.f4118a.c();
                    z = true;
                } else {
                    this.f4118a.f(':');
                    this.f4118a.p();
                }
                this.g = z;
            } else {
                this.g = true;
                this.f4118a.c();
            }
        } else {
            if (!this.f4118a.a()) {
                this.f4118a.f(StringUtil.COMMA);
            }
            this.f4118a.c();
        }
        return true;
    }

    public final void K(SerialDescriptor serialDescriptor) {
        this.f4118a.c();
        String str = this.h;
        Intrinsics.checkNotNull(str);
        v(str);
        this.f4118a.f(':');
        this.f4118a.p();
        v(serialDescriptor.h());
    }

    public SerializersModule a() {
        return this.e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
        r4 = r4[r0.ordinal()];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlinx.serialization.encoding.CompositeEncoder b(kotlinx.serialization.descriptors.SerialDescriptor r4) {
        /*
            r3 = this;
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlinx.serialization.json.Json r0 = r3.d()
            kotlinx.serialization.json.internal.WriteMode r0 = kotlinx.serialization.json.internal.WriteModeKt.b(r0, r4)
            char r1 = r0.begin
            if (r1 == 0) goto L_0x001b
            kotlinx.serialization.json.internal.Composer r2 = r3.f4118a
            r2.f(r1)
            kotlinx.serialization.json.internal.Composer r1 = r3.f4118a
            r1.b()
        L_0x001b:
            java.lang.String r1 = r3.h
            if (r1 == 0) goto L_0x0025
            r3.K(r4)
            r4 = 0
            r3.h = r4
        L_0x0025:
            kotlinx.serialization.json.internal.WriteMode r4 = r3.c
            if (r4 != r0) goto L_0x002a
            return r3
        L_0x002a:
            kotlinx.serialization.json.JsonEncoder[] r4 = r3.d
            if (r4 == 0) goto L_0x0037
            int r1 = r0.ordinal()
            r4 = r4[r1]
            if (r4 == 0) goto L_0x0037
            goto L_0x0044
        L_0x0037:
            kotlinx.serialization.json.internal.StreamingJsonEncoder r4 = new kotlinx.serialization.json.internal.StreamingJsonEncoder
            kotlinx.serialization.json.internal.Composer r1 = r3.f4118a
            kotlinx.serialization.json.Json r2 = r3.d()
            kotlinx.serialization.json.JsonEncoder[] r3 = r3.d
            r4.<init>(r1, r2, r0, r3)
        L_0x0044:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.StreamingJsonEncoder.b(kotlinx.serialization.descriptors.SerialDescriptor):kotlinx.serialization.encoding.CompositeEncoder");
    }

    public void c(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (this.c.end != 0) {
            this.f4118a.q();
            this.f4118a.d();
            this.f4118a.f(this.c.end);
        }
    }

    public Json d() {
        return this.b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0060, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) kotlinx.serialization.descriptors.StructureKind.OBJECT.f4011a) == false) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002a, code lost:
        if (d().b().e() != kotlinx.serialization.json.ClassDiscriminatorMode.NONE) goto L_0x0062;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(kotlinx.serialization.SerializationStrategy r4, java.lang.Object r5) {
        /*
            r3 = this;
            java.lang.String r0 = "serializer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlinx.serialization.json.Json r0 = r3.d()
            kotlinx.serialization.json.JsonConfiguration r0 = r0.b()
            boolean r0 = r0.n()
            if (r0 == 0) goto L_0x0018
            r4.a(r3, r5)
            goto L_0x00c3
        L_0x0018:
            boolean r0 = r4 instanceof kotlinx.serialization.internal.AbstractPolymorphicSerializer
            if (r0 == 0) goto L_0x002d
            kotlinx.serialization.json.Json r1 = r3.d()
            kotlinx.serialization.json.JsonConfiguration r1 = r1.b()
            kotlinx.serialization.json.ClassDiscriminatorMode r1 = r1.e()
            kotlinx.serialization.json.ClassDiscriminatorMode r2 = kotlinx.serialization.json.ClassDiscriminatorMode.NONE
            if (r1 == r2) goto L_0x0075
            goto L_0x0062
        L_0x002d:
            kotlinx.serialization.json.Json r1 = r3.d()
            kotlinx.serialization.json.JsonConfiguration r1 = r1.b()
            kotlinx.serialization.json.ClassDiscriminatorMode r1 = r1.e()
            int[] r2 = kotlinx.serialization.json.internal.PolymorphicKt.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r2 = 1
            if (r1 == r2) goto L_0x0075
            r2 = 2
            if (r1 == r2) goto L_0x0075
            r2 = 3
            if (r1 != r2) goto L_0x006f
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r4.getDescriptor()
            kotlinx.serialization.descriptors.SerialKind r1 = r1.getKind()
            kotlinx.serialization.descriptors.StructureKind$CLASS r2 = kotlinx.serialization.descriptors.StructureKind.CLASS.f4008a
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 != 0) goto L_0x0062
            kotlinx.serialization.descriptors.StructureKind$OBJECT r2 = kotlinx.serialization.descriptors.StructureKind.OBJECT.f4011a
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x0075
        L_0x0062:
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r4.getDescriptor()
            kotlinx.serialization.json.Json r2 = r3.d()
            java.lang.String r1 = kotlinx.serialization.json.internal.PolymorphicKt.c(r1, r2)
            goto L_0x0076
        L_0x006f:
            kotlin.NoWhenBranchMatchedException r3 = new kotlin.NoWhenBranchMatchedException
            r3.<init>()
            throw r3
        L_0x0075:
            r1 = 0
        L_0x0076:
            if (r0 == 0) goto L_0x00bc
            r0 = r4
            kotlinx.serialization.internal.AbstractPolymorphicSerializer r0 = (kotlinx.serialization.internal.AbstractPolymorphicSerializer) r0
            if (r5 == 0) goto L_0x0098
            kotlinx.serialization.SerializationStrategy r0 = kotlinx.serialization.PolymorphicSerializerKt.b(r0, r3, r5)
            if (r1 == 0) goto L_0x0086
            kotlinx.serialization.json.internal.PolymorphicKt.e(r4, r0, r1)
        L_0x0086:
            kotlinx.serialization.descriptors.SerialDescriptor r4 = r0.getDescriptor()
            kotlinx.serialization.descriptors.SerialKind r4 = r4.getKind()
            kotlinx.serialization.json.internal.PolymorphicKt.b(r4)
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.encodePolymorphically>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r4)
            r4 = r0
            goto L_0x00bc
        L_0x0098:
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
        L_0x00bc:
            if (r1 == 0) goto L_0x00c0
            r3.h = r1
        L_0x00c0:
            r4.a(r3, r5)
        L_0x00c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.StreamingJsonEncoder.e(kotlinx.serialization.SerializationStrategy, java.lang.Object):void");
    }

    public void f(byte b2) {
        if (this.g) {
            v(String.valueOf(b2));
        } else {
            this.f4118a.e(b2);
        }
    }

    public void g(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "enumDescriptor");
        v(serialDescriptor.f(i));
    }

    public Encoder h(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (StreamingJsonEncoderKt.b(serialDescriptor)) {
            Composer composer = this.f4118a;
            if (!(composer instanceof ComposerForUnsignedNumbers)) {
                composer = new ComposerForUnsignedNumbers(composer.f4102a, this.g);
            }
            return new StreamingJsonEncoder(composer, d(), this.c, (JsonEncoder[]) null);
        } else if (!StreamingJsonEncoderKt.a(serialDescriptor)) {
            return super.h(serialDescriptor);
        } else {
            Composer composer2 = this.f4118a;
            if (!(composer2 instanceof ComposerForUnquotedLiterals)) {
                composer2 = new ComposerForUnquotedLiterals(composer2.f4102a, this.g);
            }
            return new StreamingJsonEncoder(composer2, d(), this.c, (JsonEncoder[]) null);
        }
    }

    public void k(short s) {
        if (this.g) {
            v(String.valueOf(s));
        } else {
            this.f4118a.l(s);
        }
    }

    public void l(boolean z) {
        if (this.g) {
            v(String.valueOf(z));
        } else {
            this.f4118a.m(z);
        }
    }

    public void m(float f2) {
        if (this.g) {
            v(String.valueOf(f2));
        } else {
            this.f4118a.h(f2);
        }
        if (this.f.a()) {
            return;
        }
        if (Float.isInfinite(f2) || Float.isNaN(f2)) {
            throw JsonExceptionsKt.b(Float.valueOf(f2), this.f4118a.f4102a.toString());
        }
    }

    public boolean q(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return this.f.h();
    }

    public void r(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "element");
        e(JsonElementSerializer.f4081a, jsonElement);
    }

    public void s(int i) {
        if (this.g) {
            v(String.valueOf(i));
        } else {
            this.f4118a.i(i);
        }
    }

    public void v(String str) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
        this.f4118a.n(str);
    }

    public void x(double d2) {
        if (this.g) {
            v(String.valueOf(d2));
        } else {
            this.f4118a.g(d2);
        }
        if (this.f.a()) {
            return;
        }
        if (Double.isInfinite(d2) || Double.isNaN(d2)) {
            throw JsonExceptionsKt.b(Double.valueOf(d2), this.f4118a.f4102a.toString());
        }
    }

    public void y(SerialDescriptor serialDescriptor, int i, SerializationStrategy serializationStrategy, Object obj) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        if (obj != null || this.f.i()) {
            super.y(serialDescriptor, i, serializationStrategy, obj);
        }
    }
}
