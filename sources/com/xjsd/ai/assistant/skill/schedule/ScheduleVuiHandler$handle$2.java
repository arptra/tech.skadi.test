package com.xjsd.ai.assistant.skill.schedule;

import com.xjsd.ai.assistant.connect.SendMsgCallback;
import com.xjsd.ai.assistant.log.ILog;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/xjsd/ai/assistant/skill/schedule/ScheduleVuiHandler$handle$2", "Lcom/xjsd/ai/assistant/connect/SendMsgCallback;", "onFail", "", "error", "", "msg", "", "onSuccess", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ScheduleVuiHandler$handle$2 implements SendMsgCallback {
    public void onFail(int i, String str) {
        ILog.a("ScheduleVuiHandler", "发送日程业务数据SCHEDULE_DISMISS，失败->" + str);
    }

    public void onSuccess() {
        ILog.a("ScheduleVuiHandler", "发送日程业务数据SCHEDULE_DISMISS成功");
    }
}
