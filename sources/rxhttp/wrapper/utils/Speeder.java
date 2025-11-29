package rxhttp.wrapper.utils;

import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lrxhttp/wrapper/utils/Speeder;", "", "", "lastLength", "lastTime", "<init>", "(JJ)V", "currentLength", "currentTime", "", "complete", "b", "(JJZ)J", "a", "()J", "J", "c", "Ljava/lang/Long;", "lastSpeed", "Ljava/util/concurrent/LinkedBlockingQueue;", "d", "Ljava/util/concurrent/LinkedBlockingQueue;", "queue", "rxhttp"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nSpeeder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Speeder.kt\nrxhttp/wrapper/utils/Speeder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,36:1\n1#2:37\n*E\n"})
public final class Speeder {

    /* renamed from: a  reason: collision with root package name */
    public long f3576a;
    public long b;
    public Long c;
    public final LinkedBlockingQueue d = new LinkedBlockingQueue(5);

    public Speeder(long j, long j2) {
        this.f3576a = j;
        this.b = j2;
    }

    public final long a() {
        Long l = this.c;
        if (l != null) {
            return l.longValue();
        }
        long averageOfLong = (long) CollectionsKt.averageOfLong(this.d);
        this.c = Long.valueOf(averageOfLong);
        return averageOfLong;
    }

    public final long b(long j, long j2, boolean z) {
        long j3 = j2 - this.b;
        if (j3 >= 1000 || z || this.d.isEmpty()) {
            if (j3 == 0) {
                j3 = 1;
            }
            long j4 = ((j - this.f3576a) * ((long) 1000)) / j3;
            while (!this.d.offer(Long.valueOf(j4))) {
                this.d.poll();
            }
            this.c = null;
            this.f3576a = j;
            this.b = j2;
        }
        return a();
    }
}
