package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.ReadingKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00058\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u001a\u0010\u000e\u001a\u00020\n8\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r¨\u0006\u000f"}, d2 = {"io/ktor/client/plugins/DefaultTransformersJvmKt$platformRequestDefaultTransform$1", "Lio/ktor/http/content/OutgoingContent$ReadChannelContent;", "Lio/ktor/utils/io/ByteReadChannel;", "d", "()Lio/ktor/utils/io/ByteReadChannel;", "", "a", "Ljava/lang/Long;", "()Ljava/lang/Long;", "contentLength", "Lio/ktor/http/ContentType;", "b", "Lio/ktor/http/ContentType;", "()Lio/ktor/http/ContentType;", "contentType", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class DefaultTransformersJvmKt$platformRequestDefaultTransform$1 extends OutgoingContent.ReadChannelContent {

    /* renamed from: a  reason: collision with root package name */
    public final Long f8840a;
    public final ContentType b;
    public final /* synthetic */ Object c;

    public DefaultTransformersJvmKt$platformRequestDefaultTransform$1(HttpRequestBuilder httpRequestBuilder, ContentType contentType, Object obj) {
        this.c = obj;
        String h = httpRequestBuilder.a().h(HttpHeaders.f8966a.j());
        this.f8840a = h != null ? Long.valueOf(Long.parseLong(h)) : null;
        this.b = contentType == null ? ContentType.Application.f8945a.a() : contentType;
    }

    public Long a() {
        return this.f8840a;
    }

    public ContentType b() {
        return this.b;
    }

    public ByteReadChannel d() {
        return ReadingKt.e((InputStream) this.c, (CoroutineContext) null, (ObjectPool) null, 3, (Object) null);
    }
}
