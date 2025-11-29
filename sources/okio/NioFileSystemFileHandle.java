package okio;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\bH\u0014J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0014J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\rH\u0014J\b\u0010\u0014\u001a\u00020\rH\u0014J(\u0010\u0015\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lokio/NioFileSystemFileHandle;", "Lokio/FileHandle;", "readWrite", "", "fileChannel", "Ljava/nio/channels/FileChannel;", "(ZLjava/nio/channels/FileChannel;)V", "protectedClose", "", "protectedFlush", "protectedRead", "", "fileOffset", "", "array", "", "arrayOffset", "byteCount", "protectedResize", "size", "protectedSize", "protectedWrite", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NioFileSystemFileHandle extends FileHandle {
    @NotNull
    private final FileChannel fileChannel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NioFileSystemFileHandle(boolean z, @NotNull FileChannel fileChannel2) {
        super(z);
        Intrinsics.checkNotNullParameter(fileChannel2, "fileChannel");
        this.fileChannel = fileChannel2;
    }

    public synchronized void protectedClose() {
        this.fileChannel.close();
    }

    public synchronized void protectedFlush() {
        this.fileChannel.force(true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0024, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int protectedRead(long r2, @org.jetbrains.annotations.NotNull byte[] r4, int r5, int r6) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.lang.String r0 = "array"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)     // Catch:{ all -> 0x0021 }
            java.nio.channels.FileChannel r0 = r1.fileChannel     // Catch:{ all -> 0x0021 }
            r0.position(r2)     // Catch:{ all -> 0x0021 }
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.wrap(r4, r5, r6)     // Catch:{ all -> 0x0021 }
            r3 = 0
        L_0x0010:
            if (r3 >= r6) goto L_0x0023
            java.nio.channels.FileChannel r4 = r1.fileChannel     // Catch:{ all -> 0x0021 }
            int r4 = r4.read(r2)     // Catch:{ all -> 0x0021 }
            r5 = -1
            if (r4 != r5) goto L_0x001f
            if (r3 != 0) goto L_0x0023
            monitor-exit(r1)
            return r5
        L_0x001f:
            int r3 = r3 + r4
            goto L_0x0010
        L_0x0021:
            r2 = move-exception
            goto L_0x0025
        L_0x0023:
            monitor-exit(r1)
            return r3
        L_0x0025:
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.NioFileSystemFileHandle.protectedRead(long, byte[], int, int):int");
    }

    public synchronized void protectedResize(long j) {
        try {
            long size = size();
            long j2 = j - size;
            if (j2 > 0) {
                int i = (int) j2;
                protectedWrite(size, new byte[i], 0, i);
            } else {
                this.fileChannel.truncate(j);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized long protectedSize() {
        return this.fileChannel.size();
    }

    public synchronized void protectedWrite(long j, @NotNull byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "array");
        this.fileChannel.position(j);
        this.fileChannel.write(ByteBuffer.wrap(bArr, i, i2));
    }
}
