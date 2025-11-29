package com.upuphone.xr.interconnect.main.dispatcher;

import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/interconnect/main/dispatcher/MessageDispatcher;", "", "dispatch", "", "message", "Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;", "(Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface MessageDispatcher {
    @Nullable
    Object dispatch(@NotNull StarryNetMessage starryNetMessage, @NotNull Continuation<? super Boolean> continuation);
}
