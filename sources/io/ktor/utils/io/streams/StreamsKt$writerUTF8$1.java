package io.ktor.utils.io.streams;

import io.ktor.utils.io.core.BytePacketBuilder;
import java.io.Writer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\n\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"io/ktor/utils/io/streams/StreamsKt$writerUTF8$1", "Ljava/io/Writer;", "", "cbuf", "", "off", "len", "", "write", "([CII)V", "flush", "()V", "close", "ktor-io"}, k = 1, mv = {1, 8, 0})
public final class StreamsKt$writerUTF8$1 extends Writer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BytePacketBuilder f9125a;

    public void close() {
    }

    public void flush() {
    }

    public void write(char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "cbuf");
        this.f9125a.i(cArr, i, i2 + i);
    }
}
