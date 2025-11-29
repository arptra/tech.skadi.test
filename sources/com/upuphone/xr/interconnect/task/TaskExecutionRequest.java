package com.upuphone.xr.interconnect.task;

import com.upuphone.xr.interconnect.entity.ResourceDescription;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/upuphone/xr/interconnect/task/TaskExecutionRequest;", "", "name", "", "resource", "Lcom/upuphone/xr/interconnect/entity/ResourceDescription;", "(Ljava/lang/String;Lcom/upuphone/xr/interconnect/entity/ResourceDescription;)V", "getName", "()Ljava/lang/String;", "getResource", "()Lcom/upuphone/xr/interconnect/entity/ResourceDescription;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TaskExecutionRequest {
    @NotNull
    private final String name;
    @Nullable
    private final ResourceDescription resource;

    public TaskExecutionRequest(@NotNull String str, @Nullable ResourceDescription resourceDescription) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
        this.resource = resourceDescription;
    }

    public static /* synthetic */ TaskExecutionRequest copy$default(TaskExecutionRequest taskExecutionRequest, String str, ResourceDescription resourceDescription, int i, Object obj) {
        if ((i & 1) != 0) {
            str = taskExecutionRequest.name;
        }
        if ((i & 2) != 0) {
            resourceDescription = taskExecutionRequest.resource;
        }
        return taskExecutionRequest.copy(str, resourceDescription);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @Nullable
    public final ResourceDescription component2() {
        return this.resource;
    }

    @NotNull
    public final TaskExecutionRequest copy(@NotNull String str, @Nullable ResourceDescription resourceDescription) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new TaskExecutionRequest(str, resourceDescription);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TaskExecutionRequest)) {
            return false;
        }
        TaskExecutionRequest taskExecutionRequest = (TaskExecutionRequest) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) taskExecutionRequest.name) && Intrinsics.areEqual((Object) this.resource, (Object) taskExecutionRequest.resource);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final ResourceDescription getResource() {
        return this.resource;
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        ResourceDescription resourceDescription = this.resource;
        return hashCode + (resourceDescription == null ? 0 : resourceDescription.hashCode());
    }

    @NotNull
    public String toString() {
        String str = this.name;
        ResourceDescription resourceDescription = this.resource;
        return "TaskExecutionRequest(name=" + str + ", resource=" + resourceDescription + ")";
    }
}
