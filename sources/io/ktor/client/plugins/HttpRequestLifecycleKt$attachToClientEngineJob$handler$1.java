package io.ktor.client.plugins;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "cause", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class HttpRequestLifecycleKt$attachToClientEngineJob$handler$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ CompletableJob $requestJob;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpRequestLifecycleKt$attachToClientEngineJob$handler$1(CompletableJob completableJob) {
        super(1);
        this.$requestJob = completableJob;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th) {
        if (th != null) {
            Logger b = HttpRequestLifecycleKt.f8855a;
            b.trace("Cancelling request because engine Job failed with error: " + th);
            JobKt.d(this.$requestJob, "Engine failed", th);
            return;
        }
        HttpRequestLifecycleKt.f8855a.trace("Cancelling request because engine Job completed");
        this.$requestJob.complete();
    }
}
