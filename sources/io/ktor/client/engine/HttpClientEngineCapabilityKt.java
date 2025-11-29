package io.ktor.client.engine;

import io.ktor.client.plugins.HttpTimeout;
import io.ktor.util.AttributeKey;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\"0\u0010\u0007\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u00010\u00008\u0000X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\"\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lio/ktor/util/AttributeKey;", "", "Lio/ktor/client/engine/HttpClientEngineCapability;", "", "a", "Lio/ktor/util/AttributeKey;", "()Lio/ktor/util/AttributeKey;", "ENGINE_CAPABILITIES_KEY", "", "Lio/ktor/client/plugins/HttpTimeout$Plugin;", "b", "Ljava/util/Set;", "getDEFAULT_CAPABILITIES", "()Ljava/util/Set;", "DEFAULT_CAPABILITIES", "ktor-client-core"}, k = 2, mv = {1, 8, 0})
public final class HttpClientEngineCapabilityKt {

    /* renamed from: a  reason: collision with root package name */
    public static final AttributeKey f8824a = new AttributeKey("EngineCapabilities");
    public static final Set b = SetsKt.setOf(HttpTimeout.d);

    public static final AttributeKey a() {
        return f8824a;
    }
}
