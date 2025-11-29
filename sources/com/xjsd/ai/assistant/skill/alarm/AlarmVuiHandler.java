package com.xjsd.ai.assistant.skill.alarm;

import com.xjsd.ai.assistant.common.UnSupportFeatureManager;
import com.xjsd.ai.assistant.common.handler.VuiHandler;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u0003R$\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000ej\b\u0012\u0004\u0012\u00020\u0004`\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/xjsd/ai/assistant/skill/alarm/AlarmVuiHandler;", "Lcom/xjsd/ai/assistant/common/handler/VuiHandler;", "<init>", "()V", "", "getHandleType", "()Ljava/lang/String;", "Lcom/xjsd/ai/assistant/protocol/VuiModel;", "model", "", "a", "(Lcom/xjsd/ai/assistant/protocol/VuiModel;)Z", "", "b", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "mSupportIntent", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AlarmVuiHandler implements VuiHandler {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f8669a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/skill/alarm/AlarmVuiHandler$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public AlarmVuiHandler() {
        HashSet hashSet = new HashSet();
        this.f8669a = hashSet;
        hashSet.add("Create");
        hashSet.add("Delete");
        hashSet.add("Update");
        hashSet.add("Select");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.xjsd.ai.assistant.protocol.VuiModel r14) {
        /*
            r13 = this;
            java.lang.String r0 = "model"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "handle: 闹钟垂域数据->"
            r0.append(r1)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "AlarmVuiHandler"
            com.xjsd.ai.assistant.log.ILog.a(r1, r0)
            boolean r0 = com.xjsd.ai.assistant.skill.call.util.PhoneCallUtil.d()
            r2 = 1
            if (r0 == 0) goto L_0x0026
            r13.b()
            return r2
        L_0x0026:
            com.xjsd.ai.assistant.protocol.vui.Header r0 = r14.getHeader()
            java.lang.String r0 = r0.getName()
            java.util.HashSet r3 = r13.f8669a
            boolean r3 = r3.contains(r0)
            r4 = 0
            if (r3 != 0) goto L_0x0038
            return r4
        L_0x0038:
            com.alibaba.fastjson.JSONObject r14 = r14.getPayload()
            java.lang.String r3 = "target"
            java.lang.String r3 = r14.getString(r3)
            java.lang.String r5 = ""
            if (r3 != 0) goto L_0x0049
            r8 = r5
            goto L_0x004a
        L_0x0049:
            r8 = r3
        L_0x004a:
            if (r0 == 0) goto L_0x00fe
            int r3 = r0.hashCode()
            java.lang.String r6 = "week_time"
            java.lang.String r7 = "time"
            switch(r3) {
                case -1822154468: goto L_0x00ce;
                case -1754979095: goto L_0x00ae;
                case 2026540316: goto L_0x0092;
                case 2043376075: goto L_0x005b;
                default: goto L_0x0059;
            }
        L_0x0059:
            goto L_0x00fe
        L_0x005b:
            java.lang.String r3 = "Delete"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0065
            goto L_0x00fe
        L_0x0065:
            java.lang.String r13 = "index"
            java.lang.String r13 = r14.getString(r13)
            if (r13 != 0) goto L_0x006e
            goto L_0x006f
        L_0x006e:
            r5 = r13
        L_0x006f:
            boolean r13 = android.text.TextUtils.isEmpty(r5)
            if (r13 == 0) goto L_0x007c
            com.xjsd.ai.assistant.skill.alarm.AlarmHelper r13 = com.xjsd.ai.assistant.skill.alarm.AlarmHelper.f8665a
            r13.g(r8)
            goto L_0x0101
        L_0x007c:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "删除日程流转到眼镜处理index->"
            r13.append(r14)
            r13.append(r5)
            java.lang.String r13 = r13.toString()
            com.xjsd.ai.assistant.log.ILog.a(r1, r13)
            return r4
        L_0x0092:
            java.lang.String r1 = "Create"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x009c
            goto L_0x00fe
        L_0x009c:
            java.lang.String r13 = r14.getString(r7)
            if (r13 != 0) goto L_0x00a3
            goto L_0x00a4
        L_0x00a3:
            r5 = r13
        L_0x00a4:
            int r13 = r14.getIntValue(r6)
            com.xjsd.ai.assistant.skill.alarm.AlarmHelper r14 = com.xjsd.ai.assistant.skill.alarm.AlarmHelper.f8665a
            r14.f(r5, r8, r13)
            goto L_0x0101
        L_0x00ae:
            java.lang.String r1 = "Update"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00b7
            goto L_0x00fe
        L_0x00b7:
            java.lang.String r13 = r14.getString(r7)
            if (r13 != 0) goto L_0x00bf
            r7 = r5
            goto L_0x00c0
        L_0x00bf:
            r7 = r13
        L_0x00c0:
            int r9 = r14.getIntValue(r6)
            com.xjsd.ai.assistant.skill.alarm.AlarmHelper r6 = com.xjsd.ai.assistant.skill.alarm.AlarmHelper.f8665a
            r11 = 8
            r12 = 0
            r10 = 0
            com.xjsd.ai.assistant.skill.alarm.AlarmHelper.j(r6, r7, r8, r9, r10, r11, r12)
            goto L_0x0101
        L_0x00ce:
            java.lang.String r1 = "Select"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00d7
            goto L_0x00fe
        L_0x00d7:
            java.lang.String r13 = "directive"
            boolean r13 = r14.containsKey(r13)
            if (r13 == 0) goto L_0x00e0
            return r4
        L_0x00e0:
            java.lang.String r13 = "enable"
            java.lang.String r13 = r14.getString(r13)
            if (r13 == 0) goto L_0x00f8
            java.util.Locale r14 = java.util.Locale.ROOT
            java.lang.String r13 = r13.toLowerCase(r14)
            java.lang.String r14 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)
            if (r13 != 0) goto L_0x00f7
            goto L_0x00f8
        L_0x00f7:
            r5 = r13
        L_0x00f8:
            com.xjsd.ai.assistant.skill.alarm.AlarmHelper r13 = com.xjsd.ai.assistant.skill.alarm.AlarmHelper.f8665a
            r13.h(r5, r8)
            goto L_0x0101
        L_0x00fe:
            r13.b()
        L_0x0101:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.skill.alarm.AlarmVuiHandler.a(com.xjsd.ai.assistant.protocol.VuiModel):boolean");
    }

    public final void b() {
        UnSupportFeatureManager.f8414a.c();
    }

    public String getHandleType() {
        return VuiModelType.ALARM;
    }
}
