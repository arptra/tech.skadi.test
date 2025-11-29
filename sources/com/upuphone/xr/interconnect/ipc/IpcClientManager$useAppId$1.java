package com.upuphone.xr.interconnect.ipc;

import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class IpcClientManager$useAppId$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<String, Unit> $action;
    final /* synthetic */ int $pid;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IpcClientManager$useAppId$1(int i, Function1<? super String, Unit> function1) {
        super(0);
        this.$pid = i;
        this.$action = function1;
    }

    public final void invoke() {
        Unit unit;
        String str = (String) IpcClientManager.pidToAppIdMap.get(Integer.valueOf(this.$pid));
        if (str != null) {
            this.$action.invoke(str);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            String access$getTag = IpcClientManager.INSTANCE.getTag();
            int i = this.$pid;
            ILog.w(access$getTag, "Unsupported usage of nonexistent pid " + i + "!");
        }
    }
}
