package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.common.ITaskManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lcom/upuphone/xr/interconnect/common/ITaskManager;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class TaskOperatorImpl$removeRunning$2 extends Lambda implements Function1<ITaskManager, Unit> {
    final /* synthetic */ int $taskId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TaskOperatorImpl$removeRunning$2(int i) {
        super(1);
        this.$taskId = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ITaskManager) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ITaskManager iTaskManager) {
        iTaskManager.removeRunning(this.$taskId);
    }
}
