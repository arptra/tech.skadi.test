package okio;

import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nPipe.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Pipe.kt\nokio/Pipe$source$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,257:1\n1#2:258\n*E\n"})
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u0002\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"okio/Pipe$source$1", "Lokio/Source;", "timeout", "Lokio/Timeout;", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Pipe$source$1 implements Source {
    final /* synthetic */ Pipe this$0;
    @NotNull
    private final Timeout timeout = new Timeout();

    public Pipe$source$1(Pipe pipe) {
        this.this$0 = pipe;
    }

    public void close() {
        ReentrantLock lock = this.this$0.getLock();
        Pipe pipe = this.this$0;
        lock.lock();
        try {
            pipe.setSourceClosed$okio(true);
            pipe.getCondition().signalAll();
            Unit unit = Unit.INSTANCE;
        } finally {
            lock.unlock();
        }
    }

    public long read(@NotNull Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        ReentrantLock lock = this.this$0.getLock();
        Pipe pipe = this.this$0;
        lock.lock();
        try {
            if (!(!pipe.getSourceClosed$okio())) {
                throw new IllegalStateException("closed".toString());
            } else if (!pipe.getCanceled$okio()) {
                while (pipe.getBuffer$okio().size() == 0) {
                    if (pipe.getSinkClosed$okio()) {
                        lock.unlock();
                        return -1;
                    }
                    this.timeout.awaitSignal(pipe.getCondition());
                    if (pipe.getCanceled$okio()) {
                        throw new IOException("canceled");
                    }
                }
                long read = pipe.getBuffer$okio().read(buffer, j);
                pipe.getCondition().signalAll();
                lock.unlock();
                return read;
            } else {
                throw new IOException("canceled");
            }
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    @NotNull
    public Timeout timeout() {
        return this.timeout;
    }
}
