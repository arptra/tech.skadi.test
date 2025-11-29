package com.xjsd.ai.assistant.skill.alarm;

import com.alibaba.fastjson.JSON;
import com.xjsd.ai.assistant.common.UnSupportFeatureManager;
import com.xjsd.ai.assistant.common.handler.BusinessHandler;
import com.xjsd.ai.assistant.json.JsonUtil;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.protocol.BusinessData;
import com.xjsd.ai.assistant.protocol.BusinessDataType;
import com.xjsd.ai.assistant.protocol.alarm.AlarmBusinessData;
import com.xjsd.ai.assistant.protocol.alarm.AlarmExt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/xjsd/ai/assistant/skill/alarm/AlarmBusinessHandler;", "Lcom/xjsd/ai/assistant/common/handler/BusinessHandler;", "<init>", "()V", "Lcom/xjsd/ai/assistant/protocol/BusinessDataType;", "getHandleType", "()Lcom/xjsd/ai/assistant/protocol/BusinessDataType;", "Lcom/xjsd/ai/assistant/protocol/BusinessData;", "businessData", "", "a", "(Lcom/xjsd/ai/assistant/protocol/BusinessData;)V", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AlarmBusinessHandler implements BusinessHandler {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f8662a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/skill/alarm/AlarmBusinessHandler$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public void a(BusinessData businessData) {
        Intrinsics.checkNotNullParameter(businessData, "businessData");
        AlarmBusinessData alarmBusinessData = (AlarmBusinessData) businessData.parseData(AlarmBusinessData.class);
        String c = JsonUtil.c(alarmBusinessData);
        ILog.a("AlarmBusinessHandler", "收到闹钟业务数据->" + c);
        try {
            AlarmExt alarmExt = (AlarmExt) JSON.parseObject(JSON.toJSONString(alarmBusinessData.getPayload()), AlarmExt.class);
            int type = alarmBusinessData.getType();
            if (type == 3) {
                ILog.a("AlarmBusinessHandler", "ALARM_DELETE");
                AlarmDeleteProcessor b = AlarmHelper.f8665a.b();
                Intrinsics.checkNotNull(alarmExt);
                b.a(alarmExt);
            } else if (type == 4) {
                ILog.a("AlarmBusinessHandler", "ALARM_MODIFY");
                AlarmModifyProcessor c2 = AlarmHelper.f8665a.c();
                Intrinsics.checkNotNull(alarmExt);
                c2.b(alarmExt);
            } else if (type != 5) {
                int type2 = alarmBusinessData.getType();
                ILog.m("AlarmBusinessHandler", "do not support handle type->" + type2);
                UnSupportFeatureManager.f8414a.c();
            } else {
                ILog.a("AlarmBusinessHandler", "ALARM_SELECT");
                AlarmHelper.f8665a.m(alarmExt);
            }
        } catch (Exception e) {
            ILog.g("AlarmBusinessHandler", e.getMessage());
            UnSupportFeatureManager.f8414a.c();
        }
    }

    public BusinessDataType getHandleType() {
        return BusinessDataType.ALARM;
    }
}
