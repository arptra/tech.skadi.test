package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonNames;
import kotlinx.serialization.json.JsonNamingStrategy;
import kotlinx.serialization.json.JsonSchemaCacheKt;
import kotlinx.serialization.json.internal.DescriptorSchemaCache;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u001a'\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003*\u00020\u00012\u0006\u0010\b\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\t\u0010\n\u001a)\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\r*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a#\u0010\u0011\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a#\u0010\u0016\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001b\u0010\u0019\u001a\u00020\u0018*\u00020\u00012\u0006\u0010\b\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a#\u0010\u001b\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u001b\u0010\u0017\u001a-\u0010\u001d\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u001d\u0010\u001e\",\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u001f8\u0000X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"&\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\r0\u001f8\u0000X\u0004¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b%\u0010#¨\u0006'"}, d2 = {"Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/json/Json;", "json", "", "", "", "b", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/json/Json;)Ljava/util/Map;", "descriptor", "e", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/descriptors/SerialDescriptor;)Ljava/util/Map;", "Lkotlinx/serialization/json/JsonNamingStrategy;", "strategy", "", "m", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonNamingStrategy;)[Ljava/lang/String;", "index", "g", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/json/Json;I)Ljava/lang/String;", "l", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/json/Json;)Lkotlinx/serialization/json/JsonNamingStrategy;", "name", "k", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/json/Json;Ljava/lang/String;)I", "", "d", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/descriptors/SerialDescriptor;)Z", "h", "suffix", "i", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/json/Json;Ljava/lang/String;Ljava/lang/String;)I", "Lkotlinx/serialization/json/internal/DescriptorSchemaCache$Key;", "a", "Lkotlinx/serialization/json/internal/DescriptorSchemaCache$Key;", "f", "()Lkotlinx/serialization/json/internal/DescriptorSchemaCache$Key;", "JsonDeserializationNamesKey", "getJsonSerializationNamesKey", "JsonSerializationNamesKey", "kotlinx-serialization-json"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nJsonNamesMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JsonNamesMap.kt\nkotlinx/serialization/json/internal/JsonNamesMapKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,137:1\n800#2,11:138\n13309#3,2:149\n1#4:151\n*S KotlinDebug\n*F\n+ 1 JsonNamesMap.kt\nkotlinx/serialization/json/internal/JsonNamesMapKt\n*L\n35#1:138,11\n35#1:149,2\n*E\n"})
public final class JsonNamesMapKt {

    /* renamed from: a  reason: collision with root package name */
    public static final DescriptorSchemaCache.Key f4109a = new DescriptorSchemaCache.Key();
    public static final DescriptorSchemaCache.Key b = new DescriptorSchemaCache.Key();

    public static final Map b(SerialDescriptor serialDescriptor, Json json) {
        String str;
        String[] names;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        boolean d = d(json, serialDescriptor);
        JsonNamingStrategy l = l(serialDescriptor, json);
        int e = serialDescriptor.e();
        for (int i = 0; i < e; i++) {
            List g = serialDescriptor.g(i);
            ArrayList arrayList = new ArrayList();
            for (Object next : g) {
                if (next instanceof JsonNames) {
                    arrayList.add(next);
                }
            }
            JsonNames jsonNames = (JsonNames) CollectionsKt.singleOrNull(arrayList);
            if (!(jsonNames == null || (names = jsonNames.names()) == null)) {
                for (String str2 : names) {
                    if (d) {
                        str2 = str2.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(str2, "toLowerCase(...)");
                    }
                    c(linkedHashMap, serialDescriptor, str2, i);
                }
            }
            if (d) {
                str = serialDescriptor.f(i).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
            } else {
                str = l != null ? l.a(serialDescriptor, i, serialDescriptor.f(i)) : null;
            }
            if (str != null) {
                c(linkedHashMap, serialDescriptor, str, i);
            }
        }
        return linkedHashMap.isEmpty() ? MapsKt.emptyMap() : linkedHashMap;
    }

    public static final void c(Map map, SerialDescriptor serialDescriptor, String str, int i) {
        String str2 = Intrinsics.areEqual((Object) serialDescriptor.getKind(), (Object) SerialKind.ENUM.f4007a) ? "enum value" : "property";
        if (!map.containsKey(str)) {
            map.put(str, Integer.valueOf(i));
            return;
        }
        throw new JsonException("The suggested name '" + str + "' for " + str2 + ' ' + serialDescriptor.f(i) + " is already one of the names for " + str2 + ' ' + serialDescriptor.f(((Number) MapsKt.getValue(map, str)).intValue()) + " in " + serialDescriptor);
    }

    public static final boolean d(Json json, SerialDescriptor serialDescriptor) {
        return json.b().g() && Intrinsics.areEqual((Object) serialDescriptor.getKind(), (Object) SerialKind.ENUM.f4007a);
    }

    public static final Map e(Json json, SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return (Map) JsonSchemaCacheKt.a(json).b(serialDescriptor, f4109a, new JsonNamesMapKt$deserializationNamesMap$1(serialDescriptor, json));
    }

    public static final DescriptorSchemaCache.Key f() {
        return f4109a;
    }

    public static final String g(SerialDescriptor serialDescriptor, Json json, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        JsonNamingStrategy l = l(serialDescriptor, json);
        return l == null ? serialDescriptor.f(i) : m(serialDescriptor, json, l)[i];
    }

    public static final int h(SerialDescriptor serialDescriptor, Json json, String str) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(str, "name");
        if (d(json, serialDescriptor)) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return k(serialDescriptor, json, lowerCase);
        } else if (l(serialDescriptor, json) != null) {
            return k(serialDescriptor, json, str);
        } else {
            int c = serialDescriptor.c(str);
            return (c == -3 && json.b().m()) ? k(serialDescriptor, json, str) : c;
        }
    }

    public static final int i(SerialDescriptor serialDescriptor, Json json, String str, String str2) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "suffix");
        int h = h(serialDescriptor, json, str);
        if (h != -3) {
            return h;
        }
        throw new SerializationException(serialDescriptor.h() + " does not contain element with name '" + str + '\'' + str2);
    }

    public static /* synthetic */ int j(SerialDescriptor serialDescriptor, Json json, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        return i(serialDescriptor, json, str, str2);
    }

    public static final int k(SerialDescriptor serialDescriptor, Json json, String str) {
        Integer num = (Integer) e(json, serialDescriptor).get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public static final JsonNamingStrategy l(SerialDescriptor serialDescriptor, Json json) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        if (Intrinsics.areEqual((Object) serialDescriptor.getKind(), (Object) StructureKind.CLASS.f4008a)) {
            return json.b().k();
        }
        return null;
    }

    public static final String[] m(SerialDescriptor serialDescriptor, Json json, JsonNamingStrategy jsonNamingStrategy) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(jsonNamingStrategy, "strategy");
        return (String[]) JsonSchemaCacheKt.a(json).b(serialDescriptor, b, new JsonNamesMapKt$serializationNamesIndices$1(serialDescriptor, jsonNamingStrategy));
    }
}
