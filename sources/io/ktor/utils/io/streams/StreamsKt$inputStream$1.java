package io.ktor.utils.io.streams;

import com.here.posclient.UpdateOptions;
import io.ktor.utils.io.core.ByteReadPacket;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"io/ktor/utils/io/streams/StreamsKt$inputStream$1", "Ljava/io/InputStream;", "", "read", "()I", "available", "", "close", "()V", "ktor-io"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nStreams.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Streams.kt\nio/ktor/utils/io/streams/StreamsKt$inputStream$1\n+ 2 Packet.kt\nio/ktor/utils/io/core/PacketKt\n+ 3 Buffers.kt\nio/ktor/utils/io/core/BuffersKt\n*L\n1#1,155:1\n39#2:156\n94#3:157\n*S KotlinDebug\n*F\n+ 1 Streams.kt\nio/ktor/utils/io/streams/StreamsKt$inputStream$1\n*L\n81#1:156\n85#1:157\n*E\n"})
public final class StreamsKt$inputStream$1 extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ByteReadPacket f9122a;

    public int available() {
        return (int) Math.min(this.f9122a.r0(), UpdateOptions.SOURCE_ANY);
    }

    public void close() {
        this.f9122a.release();
    }

    public int read() {
        if (this.f9122a.c0()) {
            return -1;
        }
        return this.f9122a.readByte() & 255;
    }
}
