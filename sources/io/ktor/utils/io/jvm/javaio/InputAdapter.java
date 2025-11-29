package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import java.io.InputStream;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\b*\u0001\u0019\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ)\u0010\u000b\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lio/ktor/utils/io/jvm/javaio/InputAdapter;", "Ljava/io/InputStream;", "Lkotlinx/coroutines/Job;", "parent", "Lio/ktor/utils/io/ByteReadChannel;", "channel", "<init>", "(Lkotlinx/coroutines/Job;Lio/ktor/utils/io/ByteReadChannel;)V", "", "available", "()I", "read", "", "b", "off", "len", "([BII)I", "", "close", "()V", "a", "Lio/ktor/utils/io/ByteReadChannel;", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/CompletableJob;", "context", "io/ktor/utils/io/jvm/javaio/InputAdapter$loop$1", "c", "Lio/ktor/utils/io/jvm/javaio/InputAdapter$loop$1;", "loop", "d", "[B", "single", "ktor-io"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nBlocking.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Blocking.kt\nio/ktor/utils/io/jvm/javaio/InputAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,316:1\n1#2:317\n*E\n"})
final class InputAdapter extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    public final ByteReadChannel f9111a;
    public final CompletableJob b;
    public final InputAdapter$loop$1 c;
    public byte[] d;

    public InputAdapter(Job job, ByteReadChannel byteReadChannel) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "channel");
        this.f9111a = byteReadChannel;
        this.b = JobKt.a(job);
        this.c = new InputAdapter$loop$1(job, this);
    }

    public int available() {
        return this.f9111a.i();
    }

    public synchronized void close() {
        try {
            super.close();
            ByteReadChannelKt.a(this.f9111a);
            if (!this.b.isCompleted()) {
                Job.DefaultImpls.a(this.b, (CancellationException) null, 1, (Object) null);
            }
            this.c.k();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized int read() {
        try {
            byte[] bArr = this.d;
            if (bArr == null) {
                bArr = new byte[1];
                this.d = bArr;
            }
            int m = this.c.m(bArr, 0, 1);
            if (m == -1) {
                return -1;
            }
            if (m == 1) {
                return bArr[0] & 255;
            }
            throw new IllegalStateException(("Expected a single byte or EOF. Got " + m + " bytes.").toString());
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized int read(byte[] bArr, int i, int i2) {
        InputAdapter$loop$1 inputAdapter$loop$1;
        inputAdapter$loop$1 = this.c;
        Intrinsics.checkNotNull(bArr);
        return inputAdapter$loop$1.m(bArr, i, i2);
    }
}
