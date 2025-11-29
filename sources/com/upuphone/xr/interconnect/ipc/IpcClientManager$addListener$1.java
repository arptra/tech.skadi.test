package com.upuphone.xr.interconnect.ipc;

import com.upuphone.xr.interconnect.remote.BinderClientDiedCallback;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class IpcClientManager$addListener$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BinderClientDiedCallback $listener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IpcClientManager$addListener$1(BinderClientDiedCallback binderClientDiedCallback) {
        super(0);
        this.$listener = binderClientDiedCallback;
    }

    public final void invoke() {
        String access$getTag = IpcClientManager.INSTANCE.getTag();
        BinderClientDiedCallback binderClientDiedCallback = this.$listener;
        ILog.d(access$getTag, "Subscribing on client lifecycle: " + binderClientDiedCallback + ".");
        IpcClientManager.listeners.add(this.$listener);
    }
}
