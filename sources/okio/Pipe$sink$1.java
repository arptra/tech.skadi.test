package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nPipe.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Pipe.kt\nokio/Pipe$sink$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Pipe.kt\nokio/Pipe\n+ 4 Timeout.kt\nokio/Timeout\n*L\n1#1,257:1\n1#2:258\n217#3:259\n218#3:286\n217#3:287\n218#3:314\n217#3:315\n218#3:342\n268#4,26:260\n268#4,26:288\n268#4,26:316\n*S KotlinDebug\n*F\n+ 1 Pipe.kt\nokio/Pipe$sink$1\n*L\n87#1:259\n87#1:286\n106#1:287\n106#1:314\n124#1:315\n124#1:342\n87#1:260,26\n106#1:288,26\n124#1:316,26\n*E\n"})
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"okio/Pipe$sink$1", "Lokio/Sink;", "timeout", "Lokio/Timeout;", "close", "", "flush", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Pipe$sink$1 implements Sink {
    final /* synthetic */ Pipe this$0;
    @NotNull
    private final Timeout timeout = new Timeout();

    public Pipe$sink$1(Pipe pipe) {
        this.this$0 = pipe;
    }

    public void close() {
        ReentrantLock lock = this.this$0.getLock();
        Pipe pipe = this.this$0;
        lock.lock();
        try {
            if (pipe.getSinkClosed$okio()) {
                lock.unlock();
                return;
            }
            Sink foldedSink$okio = pipe.getFoldedSink$okio();
            if (foldedSink$okio == null) {
                if (pipe.getSourceClosed$okio()) {
                    if (pipe.getBuffer$okio().size() > 0) {
                        throw new IOException("source is closed");
                    }
                }
                pipe.setSinkClosed$okio(true);
                pipe.getCondition().signalAll();
                foldedSink$okio = null;
            }
            Unit unit = Unit.INSTANCE;
            lock.unlock();
            if (foldedSink$okio != null) {
                Pipe pipe2 = this.this$0;
                Timeout timeout2 = foldedSink$okio.timeout();
                Timeout timeout3 = pipe2.sink().timeout();
                long timeoutNanos = timeout2.timeoutNanos();
                long minTimeout = Timeout.Companion.minTimeout(timeout3.timeoutNanos(), timeout2.timeoutNanos());
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                timeout2.timeout(minTimeout, timeUnit);
                if (timeout2.hasDeadline()) {
                    long deadlineNanoTime = timeout2.deadlineNanoTime();
                    if (timeout3.hasDeadline()) {
                        timeout2.deadlineNanoTime(Math.min(timeout2.deadlineNanoTime(), timeout3.deadlineNanoTime()));
                    }
                    try {
                        foldedSink$okio.close();
                        timeout2.timeout(timeoutNanos, timeUnit);
                        if (timeout3.hasDeadline()) {
                            timeout2.deadlineNanoTime(deadlineNanoTime);
                        }
                    } catch (Throwable th) {
                        timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                        if (timeout3.hasDeadline()) {
                            timeout2.deadlineNanoTime(deadlineNanoTime);
                        }
                        throw th;
                    }
                } else {
                    if (timeout3.hasDeadline()) {
                        timeout2.deadlineNanoTime(timeout3.deadlineNanoTime());
                    }
                    try {
                        foldedSink$okio.close();
                        timeout2.timeout(timeoutNanos, timeUnit);
                        if (timeout3.hasDeadline()) {
                            timeout2.clearDeadline();
                        }
                    } catch (Throwable th2) {
                        timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                        if (timeout3.hasDeadline()) {
                            timeout2.clearDeadline();
                        }
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            lock.unlock();
            throw th3;
        }
    }

    public void flush() {
        ReentrantLock lock = this.this$0.getLock();
        Pipe pipe = this.this$0;
        lock.lock();
        try {
            if (!(!pipe.getSinkClosed$okio())) {
                throw new IllegalStateException("closed".toString());
            } else if (!pipe.getCanceled$okio()) {
                Sink foldedSink$okio = pipe.getFoldedSink$okio();
                if (foldedSink$okio == null) {
                    if (pipe.getSourceClosed$okio()) {
                        if (pipe.getBuffer$okio().size() > 0) {
                            throw new IOException("source is closed");
                        }
                    }
                    foldedSink$okio = null;
                }
                Unit unit = Unit.INSTANCE;
                lock.unlock();
                if (foldedSink$okio != null) {
                    Pipe pipe2 = this.this$0;
                    Timeout timeout2 = foldedSink$okio.timeout();
                    Timeout timeout3 = pipe2.sink().timeout();
                    long timeoutNanos = timeout2.timeoutNanos();
                    long minTimeout = Timeout.Companion.minTimeout(timeout3.timeoutNanos(), timeout2.timeoutNanos());
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    timeout2.timeout(minTimeout, timeUnit);
                    if (timeout2.hasDeadline()) {
                        long deadlineNanoTime = timeout2.deadlineNanoTime();
                        if (timeout3.hasDeadline()) {
                            timeout2.deadlineNanoTime(Math.min(timeout2.deadlineNanoTime(), timeout3.deadlineNanoTime()));
                        }
                        try {
                            foldedSink$okio.flush();
                            timeout2.timeout(timeoutNanos, timeUnit);
                            if (timeout3.hasDeadline()) {
                                timeout2.deadlineNanoTime(deadlineNanoTime);
                            }
                        } catch (Throwable th) {
                            timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout3.hasDeadline()) {
                                timeout2.deadlineNanoTime(deadlineNanoTime);
                            }
                            throw th;
                        }
                    } else {
                        if (timeout3.hasDeadline()) {
                            timeout2.deadlineNanoTime(timeout3.deadlineNanoTime());
                        }
                        try {
                            foldedSink$okio.flush();
                            timeout2.timeout(timeoutNanos, timeUnit);
                            if (timeout3.hasDeadline()) {
                                timeout2.clearDeadline();
                            }
                        } catch (Throwable th2) {
                            timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout3.hasDeadline()) {
                                timeout2.clearDeadline();
                            }
                            throw th2;
                        }
                    }
                }
            } else {
                throw new IOException("canceled");
            }
        } catch (Throwable th3) {
            lock.unlock();
            throw th3;
        }
    }

    @NotNull
    public Timeout timeout() {
        return this.timeout;
    }

    public void write(@NotNull Buffer buffer, long j) {
        Sink sink;
        Intrinsics.checkNotNullParameter(buffer, "source");
        ReentrantLock lock = this.this$0.getLock();
        Pipe pipe = this.this$0;
        lock.lock();
        try {
            if (!(!pipe.getSinkClosed$okio())) {
                throw new IllegalStateException("closed".toString());
            } else if (!pipe.getCanceled$okio()) {
                while (true) {
                    if (j <= 0) {
                        sink = null;
                        break;
                    }
                    sink = pipe.getFoldedSink$okio();
                    if (sink != null) {
                        break;
                    } else if (!pipe.getSourceClosed$okio()) {
                        long maxBufferSize$okio = pipe.getMaxBufferSize$okio() - pipe.getBuffer$okio().size();
                        if (maxBufferSize$okio == 0) {
                            this.timeout.awaitSignal(pipe.getCondition());
                            if (pipe.getCanceled$okio()) {
                                throw new IOException("canceled");
                            }
                        } else {
                            long min = Math.min(maxBufferSize$okio, j);
                            pipe.getBuffer$okio().write(buffer, min);
                            j -= min;
                            pipe.getCondition().signalAll();
                        }
                    } else {
                        throw new IOException("source is closed");
                    }
                }
                Unit unit = Unit.INSTANCE;
                lock.unlock();
                if (sink != null) {
                    Pipe pipe2 = this.this$0;
                    Timeout timeout2 = sink.timeout();
                    Timeout timeout3 = pipe2.sink().timeout();
                    long timeoutNanos = timeout2.timeoutNanos();
                    long minTimeout = Timeout.Companion.minTimeout(timeout3.timeoutNanos(), timeout2.timeoutNanos());
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    timeout2.timeout(minTimeout, timeUnit);
                    if (timeout2.hasDeadline()) {
                        long deadlineNanoTime = timeout2.deadlineNanoTime();
                        if (timeout3.hasDeadline()) {
                            timeout2.deadlineNanoTime(Math.min(timeout2.deadlineNanoTime(), timeout3.deadlineNanoTime()));
                        }
                        try {
                            sink.write(buffer, j);
                            timeout2.timeout(timeoutNanos, timeUnit);
                            if (timeout3.hasDeadline()) {
                                timeout2.deadlineNanoTime(deadlineNanoTime);
                            }
                        } catch (Throwable th) {
                            timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout3.hasDeadline()) {
                                timeout2.deadlineNanoTime(deadlineNanoTime);
                            }
                            throw th;
                        }
                    } else {
                        if (timeout3.hasDeadline()) {
                            timeout2.deadlineNanoTime(timeout3.deadlineNanoTime());
                        }
                        try {
                            sink.write(buffer, j);
                            timeout2.timeout(timeoutNanos, timeUnit);
                            if (timeout3.hasDeadline()) {
                                timeout2.clearDeadline();
                            }
                        } catch (Throwable th2) {
                            timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout3.hasDeadline()) {
                                timeout2.clearDeadline();
                            }
                            throw th2;
                        }
                    }
                }
            } else {
                throw new IOException("canceled");
            }
        } catch (Throwable th3) {
            lock.unlock();
            throw th3;
        }
    }
}
