package rxhttp.wrapper.callback;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rxhttp.wrapper.utils.Speeder;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lrxhttp/wrapper/callback/ProgressCallbackHelper;", "", "", "minPeriod", "Lrxhttp/wrapper/callback/ProgressCallback;", "callback", "<init>", "(ILrxhttp/wrapper/callback/ProgressCallback;)V", "", "offSize", "", "b", "(J)V", "onceByteLength", "contentLength", "a", "(JJ)V", "I", "Lrxhttp/wrapper/callback/ProgressCallback;", "c", "J", "currentLength", "d", "lastTime", "Lrxhttp/wrapper/utils/Speeder;", "e", "Lrxhttp/wrapper/utils/Speeder;", "speeder", "rxhttp"}, k = 1, mv = {1, 9, 0})
public final class ProgressCallbackHelper {

    /* renamed from: a  reason: collision with root package name */
    public final int f3541a;
    public ProgressCallback b;
    public long c;
    public long d;
    public Speeder e;

    public ProgressCallbackHelper(int i, ProgressCallback progressCallback) {
        Intrinsics.checkNotNullParameter(progressCallback, "callback");
        this.f3541a = i;
        this.b = progressCallback;
    }

    public final void a(long j, long j2) {
        int i = (j > -1 ? 1 : (j == -1 ? 0 : -1));
        if (i != 0) {
            this.c += j;
        }
        boolean z = this.c == j2 || i == 0;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.d >= ((long) this.f3541a) || z) {
            Speeder speeder = this.e;
            if (speeder == null) {
                Intrinsics.throwUninitializedPropertyAccessException("speeder");
                speeder = null;
            }
            this.b.a(this.c, z ? this.c : j2, speeder.b(this.c, elapsedRealtime, z));
            this.d = elapsedRealtime;
        }
    }

    public final void b(long j) {
        this.c = j;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.d = elapsedRealtime;
        this.e = new Speeder(j, elapsedRealtime);
    }
}
