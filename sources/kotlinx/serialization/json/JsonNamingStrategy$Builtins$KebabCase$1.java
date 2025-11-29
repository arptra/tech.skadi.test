package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonNamingStrategy;
import org.apache.commons.codec.language.Soundex;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"kotlinx/serialization/json/JsonNamingStrategy$Builtins$KebabCase$1", "Lkotlinx/serialization/json/JsonNamingStrategy;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "elementIndex", "", "serialName", "a", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILjava/lang/String;)Ljava/lang/String;", "toString", "()Ljava/lang/String;", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
public final class JsonNamingStrategy$Builtins$KebabCase$1 implements JsonNamingStrategy {
    public String a(SerialDescriptor serialDescriptor, int i, String str) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(str, "serialName");
        return JsonNamingStrategy.Builtins.f4085a.b(str, Soundex.SILENT_MARKER);
    }

    public String toString() {
        return "kotlinx.serialization.json.JsonNamingStrategy.KebabCase";
    }
}
