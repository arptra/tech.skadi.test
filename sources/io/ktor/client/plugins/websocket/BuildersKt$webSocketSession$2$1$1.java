package io.ktor.client.plugins.websocket;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CompletableDeferred;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class BuildersKt$webSocketSession$2$1$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ CompletableDeferred<Unit> $sessionCompleted;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BuildersKt$webSocketSession$2$1$1(CompletableDeferred<Unit> completableDeferred) {
        super(1);
        this.$sessionCompleted = completableDeferred;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th) {
        if (th != null) {
            this.$sessionCompleted.d(th);
        } else {
            this.$sessionCompleted.w(Unit.INSTANCE);
        }
    }
}
