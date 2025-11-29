package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/utils/io/LookAheadSession;", "", "", "n", "", "r", "(I)V", "skip", "atLeast", "Ljava/nio/ByteBuffer;", "a", "(II)Ljava/nio/ByteBuffer;", "ktor-io"}, k = 1, mv = {1, 8, 0})
@Deprecated(message = "Use read { } instead.")
public interface LookAheadSession {
    ByteBuffer a(int i, int i2);

    void r(int i);
}
