package com.upuphone.xr.interconnect.api;

import com.honey.account.view.web.WebJs;
import com.upuphone.xr.interconnect.entity.ResourceDescription;
import com.upuphone.xr.interconnect.entity.RunningTask;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/upuphone/xr/interconnect/api/RunningTaskDelegate;", "", "runningTask", "Lcom/upuphone/xr/interconnect/entity/RunningTask;", "deviceId", "", "taskOperator", "Lcom/upuphone/xr/interconnect/api/TaskOperator;", "(Lcom/upuphone/xr/interconnect/entity/RunningTask;Ljava/lang/String;Lcom/upuphone/xr/interconnect/api/TaskOperator;)V", "getDeviceId", "()Ljava/lang/String;", "getRunningTask", "()Lcom/upuphone/xr/interconnect/entity/RunningTask;", "getTaskOperator", "()Lcom/upuphone/xr/interconnect/api/TaskOperator;", "getOccupiedResource", "Lcom/upuphone/xr/interconnect/entity/ResourceDescription;", "type", "", "performAction", "", "action", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRunningTaskDelegate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RunningTaskDelegate.kt\ncom/upuphone/xr/interconnect/api/RunningTaskDelegate\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,22:1\n288#2,2:23\n*S KotlinDebug\n*F\n+ 1 RunningTaskDelegate.kt\ncom/upuphone/xr/interconnect/api/RunningTaskDelegate\n*L\n14#1:23,2\n*E\n"})
public final class RunningTaskDelegate {
    @Nullable
    private final String deviceId;
    @NotNull
    private final RunningTask runningTask;
    @NotNull
    private final TaskOperator taskOperator;

    public RunningTaskDelegate(@NotNull RunningTask runningTask2, @Nullable String str, @NotNull TaskOperator taskOperator2) {
        Intrinsics.checkNotNullParameter(runningTask2, "runningTask");
        Intrinsics.checkNotNullParameter(taskOperator2, "taskOperator");
        this.runningTask = runningTask2;
        this.deviceId = str;
        this.taskOperator = taskOperator2;
    }

    @Nullable
    public final String getDeviceId() {
        return this.deviceId;
    }

    @Nullable
    public final ResourceDescription getOccupiedResource(byte b) {
        List<ResourceDescription> list = this.runningTask.occupiedResources;
        T t = null;
        if (list == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (((ResourceDescription) next).type == b) {
                t = next;
                break;
            }
        }
        return (ResourceDescription) t;
    }

    @NotNull
    public final RunningTask getRunningTask() {
        return this.runningTask;
    }

    @NotNull
    public final TaskOperator getTaskOperator() {
        return this.taskOperator;
    }

    public final void performAction(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        this.taskOperator.performAction(this.deviceId, this.runningTask.id, str);
    }
}
