package com.upuphone.xr.interconnect.task;

import com.honey.account.view.web.WebJs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/interconnect/task/RunningTaskActionRequest;", "", "executorName", "", "action", "(Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getExecutorName", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RunningTaskActionRequest {
    @NotNull
    private final String action;
    @NotNull
    private final String executorName;

    public RunningTaskActionRequest(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "executorName");
        Intrinsics.checkNotNullParameter(str2, WebJs.ACTION);
        this.executorName = str;
        this.action = str2;
    }

    @NotNull
    public final String getAction() {
        return this.action;
    }

    @NotNull
    public final String getExecutorName() {
        return this.executorName;
    }
}
