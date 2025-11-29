package io.ktor.client.content;

import io.ktor.http.ContentType;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.cio.FileChannelsKt;
import io.ktor.utils.io.ByteReadChannel;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\u000f\u001a\u00020\u000b8\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0011¨\u0006\u0013"}, d2 = {"Lio/ktor/client/content/LocalFileContent;", "Lio/ktor/http/content/OutgoingContent$ReadChannelContent;", "Lio/ktor/utils/io/ByteReadChannel;", "d", "()Lio/ktor/utils/io/ByteReadChannel;", "Ljava/io/File;", "a", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "file", "Lio/ktor/http/ContentType;", "b", "Lio/ktor/http/ContentType;", "()Lio/ktor/http/ContentType;", "contentType", "", "()Ljava/lang/Long;", "contentLength", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class LocalFileContent extends OutgoingContent.ReadChannelContent {

    /* renamed from: a  reason: collision with root package name */
    public final File f8821a;
    public final ContentType b;

    public Long a() {
        return Long.valueOf(this.f8821a.length());
    }

    public ContentType b() {
        return this.b;
    }

    public ByteReadChannel d() {
        return FileChannelsKt.b(this.f8821a, 0, 0, (CoroutineContext) null, 7, (Object) null);
    }
}
