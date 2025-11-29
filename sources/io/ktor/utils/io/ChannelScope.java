package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lio/ktor/utils/io/ChannelScope;", "Lio/ktor/utils/io/ReaderScope;", "Lio/ktor/utils/io/WriterScope;", "Lkotlinx/coroutines/CoroutineScope;", "delegate", "Lio/ktor/utils/io/ByteChannel;", "channel", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lio/ktor/utils/io/ByteChannel;)V", "a", "Lio/ktor/utils/io/ByteChannel;", "()Lio/ktor/utils/io/ByteChannel;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "ktor-io"}, k = 1, mv = {1, 8, 0})
final class ChannelScope implements ReaderScope, WriterScope, CoroutineScope {

    /* renamed from: a  reason: collision with root package name */
    public final ByteChannel f9080a;
    public final /* synthetic */ CoroutineScope b;

    public ChannelScope(CoroutineScope coroutineScope, ByteChannel byteChannel) {
        Intrinsics.checkNotNullParameter(coroutineScope, "delegate");
        Intrinsics.checkNotNullParameter(byteChannel, "channel");
        this.f9080a = byteChannel;
        this.b = coroutineScope;
    }

    /* renamed from: a */
    public ByteChannel b() {
        return this.f9080a;
    }

    public CoroutineContext getCoroutineContext() {
        return this.b.getCoroutineContext();
    }
}
