package io.ktor.client.utils;

import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\f\u001a\u00020\u00078\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u000eR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"io/ktor/client/utils/ContentKt$wrapHeaders$3", "Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "", "d", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/http/Headers;", "a", "Lio/ktor/http/Headers;", "c", "()Lio/ktor/http/Headers;", "headers", "", "()Ljava/lang/Long;", "contentLength", "Lio/ktor/http/ContentType;", "b", "()Lio/ktor/http/ContentType;", "contentType", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class ContentKt$wrapHeaders$3 extends OutgoingContent.WriteChannelContent {

    /* renamed from: a  reason: collision with root package name */
    public final Headers f8933a;
    public final /* synthetic */ OutgoingContent b;

    public Long a() {
        return this.b.a();
    }

    public ContentType b() {
        return this.b.b();
    }

    public Headers c() {
        return this.f8933a;
    }

    public Object d(ByteWriteChannel byteWriteChannel, Continuation continuation) {
        Object d = ((OutgoingContent.WriteChannelContent) this.b).d(byteWriteChannel, continuation);
        return d == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? d : Unit.INSTANCE;
    }
}
