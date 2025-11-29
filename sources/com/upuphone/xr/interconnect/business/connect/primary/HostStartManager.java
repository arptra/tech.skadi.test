package com.upuphone.xr.interconnect.business.connect.primary;

import com.upuphone.runasone.constant.Constants;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.HashMap;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u0016\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/interconnect/business/connect/primary/HostStartManager;", "", "()V", "jobScope", "Lkotlinx/coroutines/CoroutineScope;", "startHostJobMap", "Ljava/util/HashMap;", "", "Lkotlinx/coroutines/Job;", "Lkotlin/collections/HashMap;", "cancelHostStartJob", "", "deviceId", "launchHostStartJob", "logTag", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHostStartManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HostStartManager.kt\ncom/upuphone/xr/interconnect/business/connect/primary/HostStartManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,32:1\n1#2:33\n*E\n"})
public final class HostStartManager {
    @NotNull
    private final CoroutineScope jobScope = CoroutineScopeKt.a(Dispatchers.a().plus(SupervisorKt.b((Job) null, 1, (Object) null)));
    @NotNull
    private final HashMap<String, Job> startHostJobMap = new HashMap<>();

    public final void cancelHostStartJob(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Job remove = this.startHostJobMap.remove(str);
        if (remove != null) {
            Job.DefaultImpls.a(remove, (CancellationException) null, 1, (Object) null);
        }
    }

    public final void launchHostStartJob(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "logTag");
        Job job = this.startHostJobMap.get(str);
        if (job == null || !job.isActive()) {
            ILog.d(str2, "Starting remote host start job.");
            this.startHostJobMap.put(str, BuildersKt__Builders_commonKt.d(this.jobScope, (CoroutineContext) null, (CoroutineStart) null, new HostStartManager$launchHostStartJob$2(str2, str, (Continuation<? super HostStartManager$launchHostStartJob$2>) null), 3, (Object) null));
        }
    }
}
