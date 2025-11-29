package kotlinx.serialization.json.internal;

import com.honey.account.constant.AccountConstantKt;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.internal.JsonInternalDependenciesKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNamingStrategy;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.json.JsonSchemaCacheKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\b\u0012\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010 \u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010!J\u001f\u0010\"\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\rH\u0002¢\u0006\u0004\b\"\u0010#R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u00062"}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeDecoder;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "Lkotlinx/serialization/json/Json;", "json", "Lkotlinx/serialization/json/JsonObject;", "value", "", "polyDiscriminator", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "polyDescriptor", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "descriptor", "", "w", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "", "D", "()Z", "index", "c0", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/String;", "tag", "Lkotlinx/serialization/json/JsonElement;", "g0", "(Ljava/lang/String;)Lkotlinx/serialization/json/JsonElement;", "Lkotlinx/serialization/encoding/CompositeDecoder;", "b", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeDecoder;", "", "c", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "y0", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILjava/lang/String;)Z", "x0", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", "f", "Lkotlinx/serialization/json/JsonObject;", "z0", "()Lkotlinx/serialization/json/JsonObject;", "g", "Ljava/lang/String;", "h", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "i", "I", "position", "j", "Z", "forceNull", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTreeJsonDecoder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TreeJsonDecoder.kt\nkotlinx/serialization/json/internal/JsonTreeDecoder\n+ 2 JsonNamesMap.kt\nkotlinx/serialization/json/internal/JsonNamesMapKt\n+ 3 JsonNamesMap.kt\nkotlinx/serialization/json/internal/JsonNamesMapKt$tryCoerceValue$1\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 TreeJsonEncoder.kt\nkotlinx/serialization/json/internal/TreeJsonEncoderKt\n*L\n1#1,326:1\n112#2,20:327\n132#2,4:348\n117#3:347\n1#4:352\n252#5,7:353\n*S KotlinDebug\n*F\n+ 1 TreeJsonDecoder.kt\nkotlinx/serialization/json/internal/JsonTreeDecoder\n*L\n192#1:327,20\n192#1:348,4\n192#1:347\n254#1:353,7\n*E\n"})
class JsonTreeDecoder extends AbstractJsonTreeDecoder {
    public final JsonObject f;
    public final String g;
    public final SerialDescriptor h;
    public int i;
    public boolean j;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JsonTreeDecoder(Json json, JsonObject jsonObject, String str, SerialDescriptor serialDescriptor, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(json, jsonObject, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : serialDescriptor);
    }

    public boolean D() {
        return !this.j && super.D();
    }

    public CompositeDecoder b(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (serialDescriptor != this.h) {
            return super.b(serialDescriptor);
        }
        Json d = d();
        JsonElement h0 = h0();
        SerialDescriptor serialDescriptor2 = this.h;
        if (h0 instanceof JsonObject) {
            return new JsonTreeDecoder(d, (JsonObject) h0, this.g, serialDescriptor2);
        }
        throw JsonExceptionsKt.e(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class) + " as the serialized body of " + serialDescriptor2.h() + ", but had " + Reflection.getOrCreateKotlinClass(h0.getClass()));
    }

    public void c(SerialDescriptor serialDescriptor) {
        Set set;
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (!this.e.j() && !(serialDescriptor.getKind() instanceof PolymorphicKind)) {
            JsonNamingStrategy l = JsonNamesMapKt.l(serialDescriptor, d());
            if (l == null && !this.e.m()) {
                set = JsonInternalDependenciesKt.a(serialDescriptor);
            } else if (l != null) {
                set = JsonNamesMapKt.e(d(), serialDescriptor).keySet();
            } else {
                Set a2 = JsonInternalDependenciesKt.a(serialDescriptor);
                Map map = (Map) JsonSchemaCacheKt.a(d()).a(serialDescriptor, JsonNamesMapKt.f());
                Set keySet = map != null ? map.keySet() : null;
                if (keySet == null) {
                    keySet = SetsKt.emptySet();
                }
                set = SetsKt.plus(a2, keySet);
            }
            for (String str : v0().keySet()) {
                if (!set.contains(str) && !Intrinsics.areEqual((Object) str, (Object) this.g)) {
                    throw JsonExceptionsKt.g(str, v0().toString());
                }
            }
        }
    }

    public String c0(SerialDescriptor serialDescriptor, int i2) {
        String str;
        Object obj;
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        JsonNamingStrategy l = JsonNamesMapKt.l(serialDescriptor, d());
        String f2 = serialDescriptor.f(i2);
        if (l == null && (!this.e.m() || v0().keySet().contains(f2))) {
            return f2;
        }
        Map e = JsonNamesMapKt.e(d(), serialDescriptor);
        Iterator it = v0().keySet().iterator();
        while (true) {
            str = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Integer num = (Integer) e.get((String) obj);
            if (num != null && num.intValue() == i2) {
                break;
            }
        }
        String str2 = (String) obj;
        if (str2 != null) {
            return str2;
        }
        if (l != null) {
            str = l.a(serialDescriptor, i2, f2);
        }
        return str == null ? f2 : str;
    }

    public JsonElement g0(String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        return (JsonElement) MapsKt.getValue(v0(), str);
    }

    public int w(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        while (this.i < serialDescriptor.e()) {
            int i2 = this.i;
            this.i = i2 + 1;
            String d0 = X(serialDescriptor, i2);
            int i3 = this.i - 1;
            this.j = false;
            if ((v0().containsKey(d0) || x0(serialDescriptor, i3)) && (!this.e.f() || !y0(serialDescriptor, i3, d0))) {
                return i3;
            }
        }
        return -1;
    }

    public final boolean x0(SerialDescriptor serialDescriptor, int i2) {
        boolean z = !d().b().i() && !serialDescriptor.i(i2) && serialDescriptor.d(i2).b();
        this.j = z;
        return z;
    }

    public final boolean y0(SerialDescriptor serialDescriptor, int i2, String str) {
        Json d = d();
        if (!serialDescriptor.i(i2)) {
            return false;
        }
        SerialDescriptor d2 = serialDescriptor.d(i2);
        if (d2.b() || !(g0(str) instanceof JsonNull)) {
            if (!Intrinsics.areEqual((Object) d2.getKind(), (Object) SerialKind.ENUM.f4007a)) {
                return false;
            }
            if (d2.b() && (g0(str) instanceof JsonNull)) {
                return false;
            }
            JsonElement g0 = g0(str);
            String str2 = null;
            JsonPrimitive jsonPrimitive = g0 instanceof JsonPrimitive ? (JsonPrimitive) g0 : null;
            if (jsonPrimitive != null) {
                str2 = JsonElementKt.f(jsonPrimitive);
            }
            if (str2 == null || JsonNamesMapKt.h(d2, d, str2) != -3) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: z0 */
    public JsonObject v0() {
        return this.f;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonTreeDecoder(Json json, JsonObject jsonObject, String str, SerialDescriptor serialDescriptor) {
        super(json, jsonObject, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(jsonObject, AccountConstantKt.RESPONSE_VALUE);
        this.f = jsonObject;
        this.g = str;
        this.h = serialDescriptor;
    }
}
