package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonNamingStrategy;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "", "invoke", "()[Ljava/lang/String;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class JsonNamesMapKt$serializationNamesIndices$1 extends Lambda implements Function0<String[]> {
    final /* synthetic */ JsonNamingStrategy $strategy;
    final /* synthetic */ SerialDescriptor $this_serializationNamesIndices;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonNamesMapKt$serializationNamesIndices$1(SerialDescriptor serialDescriptor, JsonNamingStrategy jsonNamingStrategy) {
        super(0);
        this.$this_serializationNamesIndices = serialDescriptor;
        this.$strategy = jsonNamingStrategy;
    }

    @NotNull
    public final String[] invoke() {
        int e = this.$this_serializationNamesIndices.e();
        String[] strArr = new String[e];
        for (int i = 0; i < e; i++) {
            strArr[i] = this.$strategy.a(this.$this_serializationNamesIndices, i, this.$this_serializationNamesIndices.f(i));
        }
        return strArr;
    }
}
