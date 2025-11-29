package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.internal.DescriptorSchemaCache;
import kotlinx.serialization.json.internal.TreeJsonDecoderKt;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00172\u00020\u0001:\u0001\u001cB\u0019\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R \u0010\u001b\u001a\u00020\u00158\u0000X\u0004¢\u0006\u0012\n\u0004\b\u0013\u0010\u0016\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018\u0001\u0002\u001d\u001e¨\u0006\u001f"}, d2 = {"Lkotlinx/serialization/json/Json;", "Lkotlinx/serialization/StringFormat;", "Lkotlinx/serialization/json/JsonConfiguration;", "configuration", "Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "<init>", "(Lkotlinx/serialization/json/JsonConfiguration;Lkotlinx/serialization/modules/SerializersModule;)V", "T", "Lkotlinx/serialization/DeserializationStrategy;", "deserializer", "Lkotlinx/serialization/json/JsonElement;", "element", "a", "(Lkotlinx/serialization/DeserializationStrategy;Lkotlinx/serialization/json/JsonElement;)Ljava/lang/Object;", "Lkotlinx/serialization/json/JsonConfiguration;", "b", "()Lkotlinx/serialization/json/JsonConfiguration;", "Lkotlinx/serialization/modules/SerializersModule;", "c", "()Lkotlinx/serialization/modules/SerializersModule;", "Lkotlinx/serialization/json/internal/DescriptorSchemaCache;", "Lkotlinx/serialization/json/internal/DescriptorSchemaCache;", "d", "()Lkotlinx/serialization/json/internal/DescriptorSchemaCache;", "get_schemaCache$kotlinx_serialization_json$annotations", "()V", "_schemaCache", "Default", "Lkotlinx/serialization/json/Json$Default;", "Lkotlinx/serialization/json/JsonImpl;", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
public abstract class Json implements StringFormat {
    public static final Default d = new Default((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final JsonConfiguration f4074a;
    public final SerializersModule b;
    public final DescriptorSchemaCache c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/serialization/json/Json$Default;", "Lkotlinx/serialization/json/Json;", "()V", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Default extends Json {
        public /* synthetic */ Default(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Default() {
            /*
                r20 = this;
                kotlinx.serialization.json.JsonConfiguration r15 = new kotlinx.serialization.json.JsonConfiguration
                r0 = r15
                r17 = 65535(0xffff, float:9.1834E-41)
                r18 = 0
                r1 = 0
                r2 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r16 = 0
                r19 = r15
                r15 = r16
                r16 = 0
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
                kotlinx.serialization.modules.SerializersModule r0 = kotlinx.serialization.modules.SerializersModuleBuildersKt.a()
                r1 = 0
                r2 = r20
                r3 = r19
                r2.<init>(r3, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.Json.Default.<init>():void");
        }
    }

    public /* synthetic */ Json(JsonConfiguration jsonConfiguration, SerializersModule serializersModule, DefaultConstructorMarker defaultConstructorMarker) {
        this(jsonConfiguration, serializersModule);
    }

    public final Object a(DeserializationStrategy deserializationStrategy, JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        Intrinsics.checkNotNullParameter(jsonElement, "element");
        return TreeJsonDecoderKt.a(this, jsonElement, deserializationStrategy);
    }

    public final JsonConfiguration b() {
        return this.f4074a;
    }

    public SerializersModule c() {
        return this.b;
    }

    public final DescriptorSchemaCache d() {
        return this.c;
    }

    public Json(JsonConfiguration jsonConfiguration, SerializersModule serializersModule) {
        this.f4074a = jsonConfiguration;
        this.b = serializersModule;
        this.c = new DescriptorSchemaCache();
    }
}
