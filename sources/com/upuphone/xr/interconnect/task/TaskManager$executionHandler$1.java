package com.upuphone.xr.interconnect.task;

import com.upuphone.xr.interconnect.common.IDataBinder;
import com.upuphone.xr.interconnect.entity.Function;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.main.handler.MessageHandler;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"com/upuphone/xr/interconnect/task/TaskManager$executionHandler$1", "Lcom/upuphone/xr/interconnect/main/handler/MessageHandler;", "getHandleType", "", "handle", "", "message", "Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;", "function", "Lcom/upuphone/xr/interconnect/entity/Function;", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TaskManager$executionHandler$1 implements MessageHandler {
    final /* synthetic */ TaskManager this$0;

    public TaskManager$executionHandler$1(TaskManager taskManager) {
        this.this$0 = taskManager;
    }

    public int getHandleType() {
        return 18;
    }

    public void handle(@Nullable StarryNetMessage starryNetMessage, @Nullable Function function) {
        if (function != null && starryNetMessage != null) {
            TaskExecutionRequest taskExecutionRequest = (TaskExecutionRequest) function.parseData(TaskExecutionRequest.class);
            ILog.d(IDataBinder.TAG, "Handling task execution request " + taskExecutionRequest + ".");
            if (taskExecutionRequest != null) {
                this.this$0.execute((String) null, taskExecutionRequest.getName(), taskExecutionRequest.getResource());
            }
        }
    }
}
