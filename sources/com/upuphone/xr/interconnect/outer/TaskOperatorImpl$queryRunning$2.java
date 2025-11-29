package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.common.ITaskManager;
import com.upuphone.xr.interconnect.entity.ResourceDescription;
import com.upuphone.xr.interconnect.entity.RunningTask;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\n \u0002*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/upuphone/xr/interconnect/entity/RunningTask;", "kotlin.jvm.PlatformType", "Lcom/upuphone/xr/interconnect/common/ITaskManager;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class TaskOperatorImpl$queryRunning$2 extends Lambda implements Function1<ITaskManager, RunningTask> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ String $executorName;
    final /* synthetic */ ResourceDescription $occupiedResource;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TaskOperatorImpl$queryRunning$2(String str, String str2, ResourceDescription resourceDescription) {
        super(1);
        this.$deviceId = str;
        this.$executorName = str2;
        this.$occupiedResource = resourceDescription;
    }

    public final RunningTask invoke(ITaskManager iTaskManager) {
        return iTaskManager.queryRunning(this.$deviceId, this.$executorName, this.$occupiedResource);
    }
}
