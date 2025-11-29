package com.xjsd.ai.assistant.skill.schedule;

import com.google.android.gms.actions.SearchIntents;
import com.upuphone.xr.interconnect.common.IPermissonResult;
import com.xjsd.ai.assistant.common.Communicator;
import com.xjsd.ai.assistant.connect.InterconnectAbility;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.protocol.BusinessDataType;
import com.xjsd.ai.assistant.protocol.schedule.Schedule;
import com.xjsd.ai.assistant.protocol.schedule.ScheduleBusinessData;
import com.xjsd.ai.assistant.protocol.schedule.ScheduleNlpParam;
import com.xjsd.ai.assistant.skill.schedule.ScheduleException;
import com.xjsd.ai.assistant.template.TtsAlarmTemplate;
import com.xjsd.ai.assistant.template.TtsCalTemplate;
import com.xjsd.ai.assistant.template.TtsGlobalTemplate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 \u001d2\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\t¢\u0006\u0004\b \u0010!J#\u0010'\u001a\u00020\u00062\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u0006¢\u0006\u0004\b)\u0010\u0003J\r\u0010*\u001a\u00020\u0006¢\u0006\u0004\b*\u0010\u0003J/\u0010/\u001a\u00020\u00062\n\u0010-\u001a\u00060+j\u0002`,2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010.\u001a\u00020%H\u0002¢\u0006\u0004\b/\u00100J\u001d\u00102\u001a\u00020\u00062\f\u00101\u001a\b\u0012\u0004\u0012\u00020\t0\"H\u0002¢\u0006\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/xjsd/ai/assistant/skill/schedule/ScheduleProcessor;", "", "<init>", "()V", "Lcom/alibaba/fastjson/JSONObject;", "payload", "", "h", "(Lcom/alibaba/fastjson/JSONObject;)V", "", "i", "()Ljava/lang/String;", "time", "", "array", "g", "(Ljava/lang/String;[Ljava/lang/String;)V", "Lcom/xjsd/ai/assistant/skill/schedule/ScheduleParams;", "params", "c", "(Lcom/xjsd/ai/assistant/skill/schedule/ScheduleParams;)V", "", "readOnly", "m", "(Z)V", "formatDate", "n", "(Ljava/lang/String;)V", "Ljava/util/Date;", "a", "(Ljava/lang/String;)Ljava/util/Date;", "dateStr", "f", "(Ljava/lang/String;)Z", "", "Lcom/xjsd/ai/assistant/protocol/schedule/Schedule;", "dataList", "", "type", "l", "(Ljava/util/List;I)V", "b", "k", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "existedSchedule", "d", "(Ljava/lang/Exception;Ljava/lang/String;I)V", "permissions", "j", "(Ljava/util/List;)V", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public abstract class ScheduleProcessor {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f8697a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/xjsd/ai/assistant/skill/schedule/ScheduleProcessor$Companion;", "", "()V", "ONE_HOUR_TIME", "", "ONE_WEEK_TIME", "TAG", "", "TYPE_SCHEDULE_CREATE", "TYPE_SCHEDULE_DELETE", "TYPE_SCHEDULE_MODIFY", "TYPE_SCHEDULE_QUERY", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static /* synthetic */ void e(ScheduleProcessor scheduleProcessor, Exception exc, String str, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                str = "";
            }
            if ((i2 & 4) != 0) {
                i = 0;
            }
            scheduleProcessor.d(exc, str, i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleException");
    }

    public final Date a(String str) {
        Intrinsics.checkNotNullParameter(str, "formatDate");
        n(str);
        if (!Intrinsics.areEqual((Object) "", (Object) str)) {
            try {
                return ScheduleUtils.f8700a.c(str);
            } catch (Exception unused) {
                throw new ScheduleException.TimeFormatException();
            }
        } else {
            throw new ScheduleException.TimeNoInfoException();
        }
    }

    public final void b() {
        l(new ArrayList(), 7);
    }

    public abstract void c(ScheduleParams scheduleParams);

    public final void d(Exception exc, String str, int i) {
        String i2 = i();
        if (exc instanceof ScheduleException.TimeNoInfoException) {
            new PhoneTtsPlayBuilder().e(TtsCalTemplate.CAL02_R02).g(2).a().c();
        } else if (exc instanceof ScheduleException.TimeFormatException) {
            new PhoneTtsPlayBuilder().e(TtsCalTemplate.CAL02_R03).g(2).a().c();
        } else if (exc instanceof ScheduleException.TimePassedException) {
            switch (i2.hashCode()) {
                case -1352294148:
                    if (i2.equals("create")) {
                        new PhoneTtsPlayBuilder().e(TtsCalTemplate.CAL02_R04).g(2).a().c();
                        return;
                    }
                    return;
                case -1335458389:
                    if (!i2.equals("delete")) {
                        return;
                    }
                    break;
                case -1068795718:
                    if (!i2.equals("modify")) {
                        return;
                    }
                    break;
                case 107944136:
                    if (i2.equals(SearchIntents.EXTRA_QUERY)) {
                        new PhoneTtsPlayBuilder().e(TtsCalTemplate.CAL01_R01).a().c();
                        return;
                    }
                    return;
                default:
                    return;
            }
            new PhoneTtsPlayBuilder().e(TtsCalTemplate.CAL02_R03).o(new String[0]).g(2).a().c();
        } else if (exc instanceof ScheduleException.ScheduleCreateWithSqlException) {
            new PhoneTtsPlayBuilder().e(TtsAlarmTemplate.ALARM02_R03).a().c();
        } else if (exc instanceof ScheduleException.ScheduleExistInTimeException) {
            new PhoneTtsPlayBuilder().e(TtsCalTemplate.CAL02_R01).o(str, String.valueOf(i)).k("startTime", str).k("num", String.valueOf(i)).g(2).a().c();
        } else if (exc instanceof ScheduleException.ScheduleReadPermissionException) {
            new PhoneTtsPlayBuilder().e(TtsGlobalTemplate.GLOBAL02_R11).a().c();
            j(CollectionsKt.mutableListOf("android.permission.READ_CALENDAR"));
        } else if (exc instanceof ScheduleException.ScheduleWritePermissionException) {
            new PhoneTtsPlayBuilder().e(TtsGlobalTemplate.GLOBAL02_R11).a().c();
            j(CollectionsKt.mutableListOf("android.permission.WRITE_CALENDAR"));
        } else if (exc instanceof ScheduleException.ScheduleReadAndWritePermissionException) {
            new PhoneTtsPlayBuilder().e(TtsGlobalTemplate.GLOBAL02_R11).a().c();
            j(CollectionsKt.mutableListOf("android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"));
        } else {
            new PhoneTtsPlayBuilder().e(TtsGlobalTemplate.GLOBAL01_P06).a().c();
        }
    }

    public final boolean f(String str) {
        Intrinsics.checkNotNullParameter(str, "dateStr");
        return StringsKt.contains$default((CharSequence) str, (CharSequence) "00:00:00", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str, (CharSequence) "23:59:59", false, 2, (Object) null);
    }

    public abstract void g(String str, String[] strArr);

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001d, code lost:
        if (r1 == null) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(com.alibaba.fastjson.JSONObject r10) {
        /*
            r9 = this;
            java.lang.String r0 = "ScheduleProcessor"
            java.lang.String r1 = "payload"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)
            java.lang.String r1 = "time_text"
            java.lang.String r1 = r10.getString(r1)
            r2 = 0
            if (r1 == 0) goto L_0x0022
            java.util.Locale r3 = java.util.Locale.ROOT
            java.lang.String r1 = r1.toLowerCase(r3)
            java.lang.String r3 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            if (r1 != 0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r5 = r1
            goto L_0x002b
        L_0x0022:
            int r1 = com.xjsd.ai.assistant.phone.R.string.tts_schedule_latest_week
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r1 = com.xjsd.ai.assistant.core.ContextHelper.b(r1, r3)
            goto L_0x0020
        L_0x002b:
            java.lang.String r1 = "time"
            java.lang.String r1 = r10.getString(r1)
            java.lang.String r3 = ""
            if (r1 != 0) goto L_0x0037
            r1 = r3
        L_0x0037:
            java.lang.String r4 = "target"
            java.lang.String r4 = r10.getString(r4)
            if (r4 != 0) goto L_0x0041
            r4 = r3
        L_0x0041:
            java.lang.String r6 = "invalid"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r6)
            if (r7 == 0) goto L_0x004b
        L_0x0049:
            r1 = r6
            goto L_0x0060
        L_0x004b:
            java.lang.String r6 = "past"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r6)
            if (r7 == 0) goto L_0x0054
            goto L_0x0049
        L_0x0054:
            java.lang.String[] r3 = new java.lang.String[]{r3, r3}
            r9.g(r1, r3)
            r6 = r3[r2]
            r1 = 1
            r1 = r3[r1]
        L_0x0060:
            com.xjsd.ai.assistant.skill.schedule.ScheduleParams r2 = new com.xjsd.ai.assistant.skill.schedule.ScheduleParams     // Catch:{ Exception -> 0x008c }
            r2.<init>(r10)     // Catch:{ Exception -> 0x008c }
            r2.h(r4)     // Catch:{ Exception -> 0x008c }
            r2.g(r6)     // Catch:{ Exception -> 0x008c }
            r2.f(r1)     // Catch:{ Exception -> 0x008c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)     // Catch:{ Exception -> 0x008c }
            r2.i(r5)     // Catch:{ Exception -> 0x008c }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008c }
            r10.<init>()     // Catch:{ Exception -> 0x008c }
            java.lang.String r1 = "process: 日程参数->"
            r10.append(r1)     // Catch:{ Exception -> 0x008c }
            r10.append(r2)     // Catch:{ Exception -> 0x008c }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x008c }
            com.xjsd.ai.assistant.log.ILog.a(r0, r10)     // Catch:{ Exception -> 0x008c }
            r9.c(r2)     // Catch:{ Exception -> 0x008c }
            goto L_0x00b6
        L_0x008c:
            r10 = move-exception
            r4 = r10
            java.lang.String r10 = r9.i()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "process: "
            r1.append(r2)
            r1.append(r10)
            java.lang.String r10 = "日程异常"
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            com.xjsd.ai.assistant.log.ILog.h(r0, r10, r4)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            r7 = 4
            r8 = 0
            r6 = 0
            r3 = r9
            e(r3, r4, r5, r6, r7, r8)
        L_0x00b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.skill.schedule.ScheduleProcessor.h(com.alibaba.fastjson.JSONObject):void");
    }

    public abstract String i();

    public final void j(List list) {
        InterconnectAbility interconnectAbility = (InterconnectAbility) AbilityManager.b.b(InterconnectAbility.class);
        if (interconnectAbility != null) {
            interconnectAbility.getOperatorManager().getSappAbilityOperator().requestPermission(list, (IPermissonResult) null);
        }
    }

    public final void k() {
        ScheduleRepository scheduleRepository = ScheduleRepository.f8699a;
        scheduleRepository.k((Schedule) null);
        scheduleRepository.j((ScheduleNlpParam) null);
    }

    public final void l(List list, int i) {
        Intrinsics.checkNotNullParameter(list, "dataList");
        ScheduleBusinessData scheduleBusinessData = new ScheduleBusinessData(i);
        scheduleBusinessData.setPayload(list);
        Communicator.a(BusinessDataType.SCHEDULE, scheduleBusinessData, new ScheduleProcessor$syncScheduleToGlass$1(i));
    }

    public final void m(boolean z) {
        if (ContextHelper.f("android.permission.READ_CALENDAR")) {
            throw new ScheduleException.ScheduleReadPermissionException();
        } else if (!z && ContextHelper.f("android.permission.WRITE_CALENDAR")) {
            throw new ScheduleException.ScheduleWritePermissionException();
        }
    }

    public final void n(String str) {
        Intrinsics.checkNotNullParameter(str, "formatDate");
        if (Intrinsics.areEqual((Object) "past", (Object) str)) {
            throw new ScheduleException.TimePassedException();
        } else if (Intrinsics.areEqual((Object) "invalid", (Object) str)) {
            throw new ScheduleException.TimeFormatException();
        }
    }
}
