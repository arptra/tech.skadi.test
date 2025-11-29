package com.upuphone.xr.interconnect.ipc;

import com.upuphone.xr.interconnect.remote.BinderClient;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nIpcClientManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IpcClientManager.kt\ncom/upuphone/xr/interconnect/ipc/IpcClientManager$remove$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,44:1\n1#2:45\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class IpcClientManager$remove$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $pid;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IpcClientManager$remove$1(int i) {
        super(0);
        this.$pid = i;
    }

    public final void invoke() {
        BinderClient binderClient;
        IpcClientManager ipcClientManager = IpcClientManager.INSTANCE;
        String access$getTag = ipcClientManager.getTag();
        int i = this.$pid;
        ILog.d(access$getTag, "#" + i + " has disconnected.");
        String str = (String) IpcClientManager.pidToAppIdMap.remove(Integer.valueOf(this.$pid));
        if (!(str == null || (binderClient = (BinderClient) IpcClientManager.appIdToClientMap.remove(str)) == null)) {
            Intrinsics.checkNotNull(binderClient);
            ipcClientManager.notifyClientDied(binderClient);
        }
        String access$getTag2 = ipcClientManager.getTag();
        HashMap access$getPidToAppIdMap$p = IpcClientManager.pidToAppIdMap;
        ILog.v(access$getTag2, "Clients: " + access$getPidToAppIdMap$p + ".");
    }
}
