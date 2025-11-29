package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.http.ContentType;
import io.ktor.http.content.OutgoingContent;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a+\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/client/HttpClient;", "", "b", "(Lio/ktor/client/HttpClient;)V", "Lio/ktor/http/ContentType;", "contentType", "Lio/ktor/client/request/HttpRequestBuilder;", "context", "", "body", "Lio/ktor/http/content/OutgoingContent;", "a", "(Lio/ktor/http/ContentType;Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/Object;)Lio/ktor/http/content/OutgoingContent;", "ktor-client-core"}, k = 2, mv = {1, 8, 0})
public final class DefaultTransformersJvmKt {
    public static final OutgoingContent a(ContentType contentType, HttpRequestBuilder httpRequestBuilder, Object obj) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "context");
        Intrinsics.checkNotNullParameter(obj, "body");
        if (obj instanceof InputStream) {
            return new DefaultTransformersJvmKt$platformRequestDefaultTransform$1(httpRequestBuilder, contentType, obj);
        }
        return null;
    }

    public static final void b(HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(httpClient, "<this>");
        httpClient.r().l(HttpResponsePipeline.g.a(), new DefaultTransformersJvmKt$platformResponseDefaultTransformers$1((Continuation<? super DefaultTransformersJvmKt$platformResponseDefaultTransformers$1>) null));
    }
}
