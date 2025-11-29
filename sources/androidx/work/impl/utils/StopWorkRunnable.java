package androidx.work.impl.utils;

import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopToken;
import com.upuphone.runasone.api.ApiConstant;
import com.upuphone.runasone.uupcast.CastErrorCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/work/impl/utils/StopWorkRunnable;", "Ljava/lang/Runnable;", "Landroidx/work/impl/Processor;", "processor", "Landroidx/work/impl/StartStopToken;", "token", "", "stopInForeground", "", "reason", "<init>", "(Landroidx/work/impl/Processor;Landroidx/work/impl/StartStopToken;ZI)V", "(Landroidx/work/impl/Processor;Landroidx/work/impl/StartStopToken;Z)V", "", "run", "()V", "a", "Landroidx/work/impl/Processor;", "b", "Landroidx/work/impl/StartStopToken;", "c", "Z", "d", "I", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
@RestrictTo
public final class StopWorkRunnable implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final Processor f2242a;
    public final StartStopToken b;
    public final boolean c;
    public final int d;

    public StopWorkRunnable(Processor processor, StartStopToken startStopToken, boolean z, int i) {
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(startStopToken, ApiConstant.KEY_TOKEN);
        this.f2242a = processor;
        this.b = startStopToken;
        this.c = z;
        this.d = i;
    }

    public void run() {
        boolean v = this.c ? this.f2242a.v(this.b, this.d) : this.f2242a.w(this.b, this.d);
        Logger e = Logger.e();
        String i = Logger.i("StopWorkRunnable");
        e.a(i, "StopWorkRunnable for " + this.b.a().b() + "; Processor.stopWork = " + v);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StopWorkRunnable(Processor processor, StartStopToken startStopToken, boolean z) {
        this(processor, startStopToken, z, CastErrorCode.SOURCE_PEER_DEVICE_NOT_ATTACHED);
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(startStopToken, ApiConstant.KEY_TOKEN);
    }
}
