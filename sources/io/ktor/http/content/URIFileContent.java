package io.ktor.http.content;

import io.ktor.http.ContentType;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.ReadingKt;
import java.io.InputStream;
import java.net.URI;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\u000f\u001a\u00020\u000b8\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00108\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0006\u0010\u0013¨\u0006\u0015"}, d2 = {"Lio/ktor/http/content/URIFileContent;", "Lio/ktor/http/content/OutgoingContent$ReadChannelContent;", "Lio/ktor/utils/io/ByteReadChannel;", "d", "()Lio/ktor/utils/io/ByteReadChannel;", "Ljava/net/URI;", "a", "Ljava/net/URI;", "getUri", "()Ljava/net/URI;", "uri", "Lio/ktor/http/ContentType;", "b", "Lio/ktor/http/ContentType;", "()Lio/ktor/http/ContentType;", "contentType", "", "c", "Ljava/lang/Long;", "()Ljava/lang/Long;", "contentLength", "ktor-http"}, k = 1, mv = {1, 8, 0})
public final class URIFileContent extends OutgoingContent.ReadChannelContent {

    /* renamed from: a  reason: collision with root package name */
    public final URI f8998a;
    public final ContentType b;
    public final Long c;

    public Long a() {
        return this.c;
    }

    public ContentType b() {
        return this.b;
    }

    public ByteReadChannel d() {
        InputStream openStream = this.f8998a.toURL().openStream();
        Intrinsics.checkNotNullExpressionValue(openStream, "uri.toURL().openStream()");
        return ReadingKt.c(openStream, (CoroutineContext) null, ByteBufferPoolKt.a(), 1, (Object) null);
    }
}
