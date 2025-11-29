package kotlinx.serialization.json;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00078\u0016XD¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n¨\u0006\f"}, d2 = {"Lkotlinx/serialization/json/JsonNull;", "Lkotlinx/serialization/json/JsonPrimitive;", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "content", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
@Serializable(with = JsonNullSerializer.class)
public final class JsonNull extends JsonPrimitive {
    @NotNull
    public static final JsonNull INSTANCE = new JsonNull();

    /* renamed from: a  reason: collision with root package name */
    public static final String f4086a = "null";
    public static final /* synthetic */ Lazy b = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, AnonymousClass1.INSTANCE);

    public JsonNull() {
        super((DefaultConstructorMarker) null);
    }

    public String a() {
        return f4086a;
    }

    public final /* synthetic */ KSerializer c() {
        return (KSerializer) b.getValue();
    }

    @NotNull
    public final KSerializer<JsonNull> serializer() {
        return c();
    }
}
