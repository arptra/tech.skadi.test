package com.upuphone.xr.interconnect.ipc;

import com.upuphone.xr.interconnect.remote.BinderClient;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class IpcClientManager$add$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $appId;
    final /* synthetic */ int $pid;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IpcClientManager$add$1(int i, String str) {
        super(0);
        this.$pid = i;
        this.$appId = str;
    }

    public final void invoke() {
        IpcClientManager ipcClientManager = IpcClientManager.INSTANCE;
        String access$getTag = ipcClientManager.getTag();
        int i = this.$pid;
        String str = this.$appId;
        ILog.d(access$getTag, "#" + i + " has connected as " + str + ".");
        IpcClientManager.pidToAppIdMap.put(Integer.valueOf(this.$pid), this.$appId);
        HashMap access$getAppIdToClientMap$p = IpcClientManager.appIdToClientMap;
        String str2 = this.$appId;
        access$getAppIdToClientMap$p.put(str2, new BinderClient(this.$pid, str2));
        String access$getTag2 = ipcClientManager.getTag();
        HashMap access$getPidToAppIdMap$p = IpcClientManager.pidToAppIdMap;
        ILog.v(access$getTag2, "Clients: " + access$getPidToAppIdMap$p + ".");
    }
}
