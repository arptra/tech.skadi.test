package com.xjsd.ai.assistant.skill.schedule;

import com.alibaba.fastjson.JSONObject;
import com.xjsd.ai.assistant.common.Communicator;
import com.xjsd.ai.assistant.common.UnSupportFeatureManager;
import com.xjsd.ai.assistant.common.handler.VuiHandler;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.R;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.protocol.BusinessDataType;
import com.xjsd.ai.assistant.protocol.VuiModel;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import com.xjsd.ai.assistant.protocol.schedule.ScheduleBusinessData;
import com.xjsd.ai.assistant.template.TtsCalTemplate;
import com.xjsd.ai.assistant.template.TtsGlobalTemplate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR$\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\fj\b\u0012\u0004\u0012\u00020\u0004`\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000eR0\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011`\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/xjsd/ai/assistant/skill/schedule/ScheduleVuiHandler;", "Lcom/xjsd/ai/assistant/common/handler/VuiHandler;", "<init>", "()V", "", "getHandleType", "()Ljava/lang/String;", "Lcom/xjsd/ai/assistant/protocol/VuiModel;", "model", "", "a", "(Lcom/xjsd/ai/assistant/protocol/VuiModel;)Z", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "mPhoneSupportedCommandSet", "Ljava/util/HashMap;", "Lcom/xjsd/ai/assistant/skill/schedule/ScheduleProcessor;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "mScheduleProcessorMap", "c", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ScheduleVuiHandler implements VuiHandler {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f8701a = SetsKt.hashSetOf("QueryTime", "QueryDate", "Create", "Delete", "Update", "Select", "Cancel");
    public final HashMap b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/skill/schedule/ScheduleVuiHandler$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public ScheduleVuiHandler() {
        HashMap hashMap = new HashMap();
        this.b = hashMap;
        hashMap.put("Create", new ScheduleCreateProcessor());
        hashMap.put("Delete", new ScheduleDeleteProcessor());
        hashMap.put("Update", new ScheduleModifyProcessor());
        hashMap.put("Select", new ScheduleQueryProcessor());
    }

    public boolean a(VuiModel vuiModel) {
        Intrinsics.checkNotNullParameter(vuiModel, "model");
        String e = GsonUtils.e(vuiModel);
        ILog.a("ScheduleVuiHandler", "handle: 日程垂域数据->" + e);
        String name = vuiModel.getHeader().getName();
        if (!this.f8701a.contains(name)) {
            return false;
        }
        JSONObject payload = vuiModel.getPayload();
        if (name != null) {
            switch (name.hashCode()) {
                case -1822154468:
                    if (name.equals("Select")) {
                        String string = payload.getString("index");
                        if (string == null || StringsKt.isBlank(string)) {
                            ScheduleProcessor scheduleProcessor = (ScheduleProcessor) this.b.get(name);
                            if (scheduleProcessor == null) {
                                return true;
                            }
                            Intrinsics.checkNotNull(payload);
                            scheduleProcessor.h(payload);
                            return true;
                        }
                        ILog.a("ScheduleVuiHandler", "handle: select todo index->" + string + "，由眼镜执行");
                        return false;
                    }
                    break;
                case -1754979095:
                    if (name.equals("Update")) {
                        String string2 = payload.getString("index");
                        if (string2 == null || StringsKt.isBlank(string2) || Intrinsics.areEqual((Object) string2, (Object) "current") || Intrinsics.areEqual((Object) string2, (Object) "all")) {
                            ScheduleProcessor scheduleProcessor2 = (ScheduleProcessor) this.b.get(name);
                            if (scheduleProcessor2 == null) {
                                return true;
                            }
                            Intrinsics.checkNotNull(payload);
                            scheduleProcessor2.h(payload);
                            return true;
                        }
                        ILog.a("ScheduleVuiHandler", "handle: update todo index->" + string2 + "，由眼镜执行");
                        return false;
                    }
                    break;
                case 196606070:
                    if (name.equals("QueryDate")) {
                        PhoneTtsPlayBuilder phoneTtsPlayBuilder = new PhoneTtsPlayBuilder();
                        String speech = vuiModel.getUtterance().getSpeech();
                        Intrinsics.checkNotNullExpressionValue(speech, "getSpeech(...)");
                        phoneTtsPlayBuilder.f(speech).a().c();
                        return true;
                    }
                    break;
                case 197090197:
                    if (name.equals("QueryTime")) {
                        String format = new SimpleDateFormat(ContextHelper.b(R.string.tts_schedule_time, new Object[0])).format(Calendar.getInstance().getTime());
                        PhoneTtsPlayBuilder phoneTtsPlayBuilder2 = new PhoneTtsPlayBuilder();
                        String tts = TtsCalTemplate.CAL05_R06.getTts(format);
                        Intrinsics.checkNotNullExpressionValue(tts, "getTts(...)");
                        phoneTtsPlayBuilder2.f(tts).a().c();
                        return true;
                    }
                    break;
                case 2011110042:
                    if (name.equals("Cancel")) {
                        ScheduleBusinessData scheduleBusinessData = new ScheduleBusinessData(7);
                        scheduleBusinessData.setPayload(new ArrayList());
                        Communicator.a(BusinessDataType.SCHEDULE, scheduleBusinessData, new ScheduleVuiHandler$handle$2());
                        new PhoneTtsPlayBuilder().e(TtsGlobalTemplate.GLOBAL06_P01).a().c();
                        return true;
                    }
                    break;
                case 2026540316:
                    if (name.equals("Create")) {
                        ScheduleProcessor scheduleProcessor3 = (ScheduleProcessor) this.b.get(name);
                        if (scheduleProcessor3 == null) {
                            return true;
                        }
                        Intrinsics.checkNotNull(payload);
                        scheduleProcessor3.h(payload);
                        return true;
                    }
                    break;
                case 2043376075:
                    if (name.equals("Delete")) {
                        String string3 = payload.getString("index");
                        if (string3 == null || StringsKt.isBlank(string3) || Intrinsics.areEqual((Object) string3, (Object) "current") || Intrinsics.areEqual((Object) string3, (Object) "all")) {
                            ScheduleProcessor scheduleProcessor4 = (ScheduleProcessor) this.b.get(name);
                            if (scheduleProcessor4 == null) {
                                return true;
                            }
                            Intrinsics.checkNotNull(payload);
                            scheduleProcessor4.h(payload);
                            return true;
                        }
                        ILog.a("ScheduleVuiHandler", "handle: delete todo index->" + string3 + "，由眼镜执行");
                        return false;
                    }
                    break;
            }
        }
        UnSupportFeatureManager.f8414a.c();
        return true;
    }

    public String getHandleType() {
        return VuiModelType.SCHEDULE;
    }
}
