package io.ktor.http.content;

import io.ktor.http.ContentType;
import io.ktor.http.content.OutgoingContent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u000e¨\u0006\u0010"}, d2 = {"Lio/ktor/http/content/ByteArrayContent;", "Lio/ktor/http/content/OutgoingContent$ByteArrayContent;", "", "d", "()[B", "a", "[B", "bytes", "Lio/ktor/http/ContentType;", "b", "Lio/ktor/http/ContentType;", "()Lio/ktor/http/ContentType;", "contentType", "", "()Ljava/lang/Long;", "contentLength", "ktor-http"}, k = 1, mv = {1, 8, 0})
public final class ByteArrayContent extends OutgoingContent.ByteArrayContent {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f8987a;
    public final ContentType b;

    public Long a() {
        return Long.valueOf((long) this.f8987a.length);
    }

    public ContentType b() {
        return this.b;
    }

    public byte[] d() {
        return this.f8987a;
    }
}
