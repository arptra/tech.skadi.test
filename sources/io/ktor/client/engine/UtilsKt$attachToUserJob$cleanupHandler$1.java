package io.ktor.client.engine;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "cause", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\nio/ktor/client/engine/UtilsKt$attachToUserJob$cleanupHandler$1\n*L\n1#1,107:1\n*E\n"})
public final class UtilsKt$attachToUserJob$cleanupHandler$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ Job $callJob;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UtilsKt$attachToUserJob$cleanupHandler$1(Job job) {
        super(1);
        this.$callJob = job;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th) {
        if (th != null) {
            this.$callJob.a(new CancellationException(th.getMessage()));
        }
    }
}
