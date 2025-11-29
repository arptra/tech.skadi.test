package androidx.work.impl;

import androidx.work.WorkerParameters;
import com.upuphone.runasone.uupcast.CastErrorCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u000fø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Landroidx/work/impl/WorkLauncher;", "", "Landroidx/work/impl/StartStopToken;", "workSpecId", "", "b", "(Landroidx/work/impl/StartStopToken;)V", "Landroidx/work/WorkerParameters$RuntimeExtras;", "runtimeExtras", "c", "(Landroidx/work/impl/StartStopToken;Landroidx/work/WorkerParameters$RuntimeExtras;)V", "e", "", "reason", "d", "(Landroidx/work/impl/StartStopToken;I)V", "a", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
public interface WorkLauncher {
    void a(StartStopToken startStopToken, int i) {
        Intrinsics.checkNotNullParameter(startStopToken, "workSpecId");
        d(startStopToken, i);
    }

    void b(StartStopToken startStopToken) {
        Intrinsics.checkNotNullParameter(startStopToken, "workSpecId");
        c(startStopToken, (WorkerParameters.RuntimeExtras) null);
    }

    void c(StartStopToken startStopToken, WorkerParameters.RuntimeExtras runtimeExtras);

    void d(StartStopToken startStopToken, int i);

    void e(StartStopToken startStopToken) {
        Intrinsics.checkNotNullParameter(startStopToken, "workSpecId");
        d(startStopToken, CastErrorCode.SOURCE_PEER_DEVICE_NOT_ATTACHED);
    }
}
