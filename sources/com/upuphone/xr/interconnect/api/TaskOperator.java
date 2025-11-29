package com.upuphone.xr.interconnect.api;

import com.upuphone.xr.interconnect.common.ITaskExecutor;
import com.upuphone.xr.interconnect.entity.ResourceDescription;
import com.upuphone.xr.interconnect.entity.RunningTask;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\"\u0010\t\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H&J.\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/interconnect/api/TaskOperator;", "", "getRunning", "Lcom/upuphone/xr/interconnect/api/RunningTaskDelegate;", "deviceId", "", "executorName", "occupiedResource", "Lcom/upuphone/xr/interconnect/entity/ResourceDescription;", "performAction", "", "taskId", "", "action", "queryRunning", "Lcom/upuphone/xr/interconnect/entity/RunningTask;", "registerExecutor", "name", "executor", "Lcom/upuphone/xr/interconnect/common/ITaskExecutor;", "removeRunning", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface TaskOperator {

    @SourceDebugExtension({"SMAP\nTaskOperator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskOperator.kt\ncom/upuphone/xr/interconnect/api/TaskOperator$DefaultImpls\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,23:1\n1#2:24\n*E\n"})
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Nullable
        public static RunningTaskDelegate getRunning(@NotNull TaskOperator taskOperator, @Nullable String str, @Nullable String str2, @Nullable ResourceDescription resourceDescription) {
            RunningTask queryRunning = taskOperator.queryRunning(str, str2, resourceDescription);
            if (queryRunning != null) {
                return new RunningTaskDelegate(queryRunning, str, taskOperator);
            }
            return null;
        }

        public static /* synthetic */ RunningTaskDelegate getRunning$default(TaskOperator taskOperator, String str, String str2, ResourceDescription resourceDescription, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                if ((i & 2) != 0) {
                    str2 = null;
                }
                if ((i & 4) != 0) {
                    resourceDescription = null;
                }
                return taskOperator.getRunning(str, str2, resourceDescription);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRunning");
        }

        public static /* synthetic */ RunningTask queryRunning$default(TaskOperator taskOperator, String str, String str2, ResourceDescription resourceDescription, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                if ((i & 2) != 0) {
                    str2 = null;
                }
                if ((i & 4) != 0) {
                    resourceDescription = null;
                }
                return taskOperator.queryRunning(str, str2, resourceDescription);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryRunning");
        }
    }

    @Nullable
    RunningTaskDelegate getRunning(@Nullable String str, @Nullable String str2, @Nullable ResourceDescription resourceDescription);

    void performAction(@Nullable String str, int i, @NotNull String str2);

    @Nullable
    RunningTask queryRunning(@Nullable String str, @Nullable String str2, @Nullable ResourceDescription resourceDescription);

    void registerExecutor(@NotNull String str, @NotNull ITaskExecutor iTaskExecutor);

    void removeRunning(int i);
}
