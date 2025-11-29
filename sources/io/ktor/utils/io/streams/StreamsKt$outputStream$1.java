package io.ktor.utils.io.streams;

import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.OutputKt;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"io/ktor/utils/io/streams/StreamsKt$outputStream$1", "Ljava/io/OutputStream;", "", "b", "", "write", "(I)V", "", "off", "len", "([BII)V", "close", "()V", "ktor-io"}, k = 1, mv = {1, 8, 0})
public final class StreamsKt$outputStream$1 extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BytePacketBuilder f9123a;

    public void close() {
    }

    public void write(int i) {
        this.f9123a.i0((byte) i);
    }

    public void write(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "b");
        OutputKt.b(this.f9123a, bArr, i, i2);
    }
}
