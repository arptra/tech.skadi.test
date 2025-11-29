package io.ktor.utils.io.streams;

import io.ktor.utils.io.core.ByteReadPacket;
import java.io.Reader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"io/ktor/utils/io/streams/StreamsKt$readerUTF8$1", "Ljava/io/Reader;", "", "close", "()V", "", "n", "skip", "(J)J", "", "cbuf", "", "off", "len", "read", "([CII)I", "ktor-io"}, k = 1, mv = {1, 8, 0})
public final class StreamsKt$readerUTF8$1 extends Reader {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ByteReadPacket f9124a;

    public void close() {
        this.f9124a.release();
    }

    public int read(char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "cbuf");
        return this.f9124a.H0(cArr, i, i2);
    }

    public long skip(long j) {
        int read;
        char[] a2 = StreamsKt.f9121a;
        int length = a2.length;
        long j2 = 0;
        while (j2 < j && (read = read(a2, 0, (int) Math.min((long) length, j - j2))) != -1) {
            j2 += (long) read;
        }
        return j2;
    }
}
