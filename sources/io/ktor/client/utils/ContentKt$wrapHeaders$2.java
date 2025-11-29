package io.ktor.client.utils;

import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00058\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"io/ktor/client/utils/ContentKt$wrapHeaders$2", "Lio/ktor/http/content/OutgoingContent$ReadChannelContent;", "Lio/ktor/utils/io/ByteReadChannel;", "d", "()Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/http/Headers;", "a", "Lio/ktor/http/Headers;", "c", "()Lio/ktor/http/Headers;", "headers", "", "()Ljava/lang/Long;", "contentLength", "Lio/ktor/http/ContentType;", "b", "()Lio/ktor/http/ContentType;", "contentType", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class ContentKt$wrapHeaders$2 extends OutgoingContent.ReadChannelContent {

    /* renamed from: a  reason: collision with root package name */
    public final Headers f8932a;
    public final /* synthetic */ OutgoingContent b;

    public Long a() {
        return this.b.a();
    }

    public ContentType b() {
        return this.b.b();
    }

    public Headers c() {
        return this.f8932a;
    }

    public ByteReadChannel d() {
        return ((OutgoingContent.ReadChannelContent) this.b).d();
    }
}
