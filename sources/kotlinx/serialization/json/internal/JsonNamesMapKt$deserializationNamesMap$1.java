package kotlinx.serialization.json.internal;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class JsonNamesMapKt$deserializationNamesMap$1 extends Lambda implements Function0<Map<String, ? extends Integer>> {
    final /* synthetic */ SerialDescriptor $descriptor;
    final /* synthetic */ Json $this_deserializationNamesMap;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonNamesMapKt$deserializationNamesMap$1(SerialDescriptor serialDescriptor, Json json) {
        super(0);
        this.$descriptor = serialDescriptor;
        this.$this_deserializationNamesMap = json;
    }

    @NotNull
    public final Map<String, Integer> invoke() {
        return JsonNamesMapKt.b(this.$descriptor, this.$this_deserializationNamesMap);
    }
}
