package com.upuphone.xr.interconnect.business.messenger;

import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.main.dispatcher.MessageDispatcher;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/upuphone/xr/interconnect/business/messenger/MainMessageDispatcher;", "", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dispatch", "", "logTag", "", "message", "Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;", "dispatchers", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/upuphone/xr/interconnect/main/dispatcher/MessageDispatcher;", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MainMessageDispatcher {
    @NotNull
    public static final MainMessageDispatcher INSTANCE = new MainMessageDispatcher();
    @NotNull
    private static final CoroutineScope scope = CoroutineScopeKt.a(Dispatchers.a());

    private MainMessageDispatcher() {
    }

    public final void dispatch(@NotNull String str, @NotNull StarryNetMessage starryNetMessage, @NotNull CopyOnWriteArraySet<MessageDispatcher> copyOnWriteArraySet) {
        Intrinsics.checkNotNullParameter(str, "logTag");
        Intrinsics.checkNotNullParameter(starryNetMessage, "message");
        Intrinsics.checkNotNullParameter(copyOnWriteArraySet, "dispatchers");
        Job unused = BuildersKt__Builders_commonKt.d(scope, (CoroutineContext) null, (CoroutineStart) null, new MainMessageDispatcher$dispatch$1(copyOnWriteArraySet, str, starryNetMessage, (Continuation<? super MainMessageDispatcher$dispatch$1>) null), 3, (Object) null);
    }
}
