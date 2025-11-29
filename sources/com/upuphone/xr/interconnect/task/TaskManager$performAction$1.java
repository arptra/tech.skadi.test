package com.upuphone.xr.interconnect.task;

import com.upuphone.xr.interconnect.common.ITaskManager;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/upuphone/xr/interconnect/task/TaskManager$performAction$1", "Lcom/upuphone/xr/interconnect/listener/SendMessageListener;", "onFail", "", "msgId", "", "errorCode", "", "onSuccess", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TaskManager$performAction$1 extends SendMessageListener {
    final /* synthetic */ String $action;
    final /* synthetic */ String $deviceId;
    final /* synthetic */ int $taskId;

    public TaskManager$performAction$1(String str, int i, String str2) {
        this.$action = str;
        this.$taskId = i;
        this.$deviceId = str2;
    }

    public void onFail(@Nullable String str, int i) {
        String str2 = this.$action;
        int i2 = this.$taskId;
        String str3 = this.$deviceId;
        ILog.d(ITaskManager.TAG, "Message to perform action " + str2 + "(" + i2 + ") on " + str3 + " not sent due to error " + i + ": " + str + ".");
    }

    public void onSuccess(@Nullable String str) {
        String str2 = this.$action;
        int i = this.$taskId;
        String str3 = this.$deviceId;
        ILog.d(ITaskManager.TAG, "Message to perform action " + str2 + "(" + i + ") on " + str3 + " successfully sent.");
    }
}
