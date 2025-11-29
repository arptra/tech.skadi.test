package com.xjsd.ai.assistant.skill.schedule;

import com.xjsd.ai.assistant.common.UnSupportFeatureManager;
import com.xjsd.ai.assistant.common.handler.BusinessHandler;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.protocol.BusinessData;
import com.xjsd.ai.assistant.protocol.BusinessDataType;
import com.xjsd.ai.assistant.protocol.schedule.Schedule;
import com.xjsd.ai.assistant.protocol.schedule.ScheduleBusinessData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/xjsd/ai/assistant/skill/schedule/ScheduleBusinessHandler;", "Lcom/xjsd/ai/assistant/common/handler/BusinessHandler;", "<init>", "()V", "Lcom/xjsd/ai/assistant/protocol/BusinessDataType;", "getHandleType", "()Lcom/xjsd/ai/assistant/protocol/BusinessDataType;", "Lcom/xjsd/ai/assistant/protocol/BusinessData;", "businessData", "", "a", "(Lcom/xjsd/ai/assistant/protocol/BusinessData;)V", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ScheduleBusinessHandler implements BusinessHandler {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f8694a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/skill/schedule/ScheduleBusinessHandler$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public void a(BusinessData businessData) {
        Intrinsics.checkNotNullParameter(businessData, "businessData");
        Object data = businessData.getData();
        ILog.a("ScheduleBusinessHandler", "收到日程业务数据->" + data);
        ScheduleBusinessData scheduleBusinessData = (ScheduleBusinessData) businessData.parseData(ScheduleBusinessData.class);
        try {
            int type = scheduleBusinessData.getType();
            if (type == 3 || type == 4) {
                EventBus.c().k(scheduleBusinessData);
            } else if (type != 5) {
                int type2 = scheduleBusinessData.getType();
                ILog.a("ScheduleBusinessHandler", "un support handle schedule type->" + type2);
                UnSupportFeatureManager.f8414a.c();
            } else {
                ScheduleRepository.f8699a.k((Schedule) GsonUtils.a(GsonUtils.e(scheduleBusinessData.getPayload()), Schedule.class));
            }
        } catch (Exception e) {
            ILog.h("ScheduleBusinessHandler", "处理日程业务数据error", e);
            UnSupportFeatureManager.f8414a.c();
        }
    }

    public BusinessDataType getHandleType() {
        return BusinessDataType.SCHEDULE;
    }
}
