package io.ktor.utils.io.bits;

import java.nio.ByteBuffer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H&ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\t\u0010\n\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lio/ktor/utils/io/bits/Allocator;", "", "", "size", "Lio/ktor/utils/io/bits/Memory;", "b", "(I)Ljava/nio/ByteBuffer;", "instance", "", "a", "(Ljava/nio/ByteBuffer;)V", "ktor-io"}, k = 1, mv = {1, 8, 0})
public interface Allocator {
    void a(ByteBuffer byteBuffer);

    ByteBuffer b(int i);
}
