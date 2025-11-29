package io.ktor.http.content;

import io.ktor.http.ContentType;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R8\u0010\u000e\u001a#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007¢\u0006\u0002\b\u000b8\u0002X\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0013\u001a\u00020\u000f8\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00148\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\f\u0010\u0017\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lio/ktor/http/content/OutputStreamContent;", "Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "", "d", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function2;", "Ljava/io/OutputStream;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "a", "Lkotlin/jvm/functions/Function2;", "body", "Lio/ktor/http/ContentType;", "b", "Lio/ktor/http/ContentType;", "()Lio/ktor/http/ContentType;", "contentType", "", "c", "Ljava/lang/Long;", "()Ljava/lang/Long;", "contentLength", "ktor-http"}, k = 1, mv = {1, 8, 0})
public final class OutputStreamContent extends OutgoingContent.WriteChannelContent {

    /* renamed from: a  reason: collision with root package name */
    public final Function2 f8995a;
    public final ContentType b;
    public final Long c;

    public Long a() {
        return this.c;
    }

    public ContentType b() {
        return this.b;
    }

    public Object d(ByteWriteChannel byteWriteChannel, Continuation continuation) {
        Object c2 = BlockingBridgeKt.c(new OutputStreamContent$writeTo$2(byteWriteChannel, this, (Continuation<? super OutputStreamContent$writeTo$2>) null), continuation);
        return c2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? c2 : Unit.INSTANCE;
    }
}
