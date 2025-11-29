package io.ktor.client.plugins;

import io.ktor.client.network.sockets.ConnectTimeoutException;
import io.ktor.client.network.sockets.SocketTimeoutException;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import io.ktor.util.AttributeKey;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import kotlin.Metadata;
import org.slf4j.Logger;

@Metadata(d1 = {"\u0000`\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\"\u0018\u0010\b\u001a\u00060\u0004j\u0002`\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007\"\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f\"7\u0010\u0014\u001a%\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u00120\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\f\"7\u0010\u0017\u001a%\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u00120\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\f\"1\u0010\u001c\u001a\u001f\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001a0\u0018¢\u0006\u0002\b\u00120\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\f\"1\u0010 \u001a\u001f\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001e0\u0018¢\u0006\u0002\b\u00120\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\f¨\u0006!"}, d2 = {"", "", "h", "(Ljava/lang/Throwable;)Z", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "a", "Lorg/slf4j/Logger;", "LOGGER", "Lio/ktor/util/AttributeKey;", "", "b", "Lio/ktor/util/AttributeKey;", "MaxRetriesPerRequestAttributeKey", "Lkotlin/Function3;", "Lio/ktor/client/plugins/HttpRequestRetry$ShouldRetryContext;", "Lio/ktor/client/request/HttpRequest;", "Lio/ktor/client/statement/HttpResponse;", "Lkotlin/ExtensionFunctionType;", "c", "ShouldRetryPerRequestAttributeKey", "Lio/ktor/client/request/HttpRequestBuilder;", "d", "ShouldRetryOnExceptionPerRequestAttributeKey", "Lkotlin/Function2;", "Lio/ktor/client/plugins/HttpRequestRetry$ModifyRequestContext;", "", "e", "ModifyRequestPerRequestAttributeKey", "Lio/ktor/client/plugins/HttpRequestRetry$DelayContext;", "", "f", "RetryDelayPerRequestAttributeKey", "ktor-client-core"}, k = 2, mv = {1, 8, 0})
public final class HttpRequestRetryKt {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f8862a = KtorSimpleLoggerJvmKt.a("io.ktor.client.plugins.HttpRequestRetry");
    public static final AttributeKey b = new AttributeKey("MaxRetriesPerRequestAttributeKey");
    public static final AttributeKey c = new AttributeKey("ShouldRetryPerRequestAttributeKey");
    public static final AttributeKey d = new AttributeKey("ShouldRetryOnExceptionPerRequestAttributeKey");
    public static final AttributeKey e = new AttributeKey("ModifyRequestPerRequestAttributeKey");
    public static final AttributeKey f = new AttributeKey("RetryDelayPerRequestAttributeKey");

    public static final boolean h(Throwable th) {
        Throwable a2 = ExceptionUtilsJvmKt.a(th);
        return (a2 instanceof HttpRequestTimeoutException) || (a2 instanceof ConnectTimeoutException) || (a2 instanceof SocketTimeoutException);
    }
}
