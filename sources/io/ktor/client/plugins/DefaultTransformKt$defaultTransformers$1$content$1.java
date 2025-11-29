package io.ktor.client.plugins;

import io.ktor.http.ContentType;
import io.ktor.http.content.OutgoingContent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00058\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\u000e\u001a\u00020\u000b8\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\f\u001a\u0004\b\u0006\u0010\r¨\u0006\u000f"}, d2 = {"io/ktor/client/plugins/DefaultTransformKt$defaultTransformers$1$content$1", "Lio/ktor/http/content/OutgoingContent$ByteArrayContent;", "", "d", "()[B", "Lio/ktor/http/ContentType;", "a", "Lio/ktor/http/ContentType;", "b", "()Lio/ktor/http/ContentType;", "contentType", "", "J", "()Ljava/lang/Long;", "contentLength", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class DefaultTransformKt$defaultTransformers$1$content$1 extends OutgoingContent.ByteArrayContent {

    /* renamed from: a  reason: collision with root package name */
    public final ContentType f8838a;
    public final long b;
    public final /* synthetic */ Object c;

    public DefaultTransformKt$defaultTransformers$1$content$1(ContentType contentType, Object obj) {
        this.c = obj;
        this.f8838a = contentType == null ? ContentType.Application.f8945a.a() : contentType;
        this.b = (long) ((byte[]) obj).length;
    }

    public Long a() {
        return Long.valueOf(this.b);
    }

    public ContentType b() {
        return this.f8838a;
    }

    public byte[] d() {
        return (byte[]) this.c;
    }
}
