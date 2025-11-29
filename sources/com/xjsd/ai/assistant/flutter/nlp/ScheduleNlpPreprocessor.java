package com.xjsd.ai.assistant.flutter.nlp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.upuphone.xr.interconnect.common.IPermissonResult;
import com.xjsd.ai.assistant.common.util.DeviceBrandUtil;
import com.xjsd.ai.assistant.connect.InterconnectAbility;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.flutter.AndroidAssistantApiHandler;
import com.xjsd.ai.assistant.flutter.NlpCompact;
import com.xjsd.ai.assistant.flutter.event.FlutterScheduleEvent;
import com.xjsd.ai.assistant.flutter.nlp.NlpPreprocessor;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.net.ws.protocol.CloudResType;
import com.xjsd.ai.assistant.net.ws.protocol.EndToEndResponse;
import com.xjsd.ai.assistant.nlu.bean.HeaderData;
import com.xjsd.ai.assistant.nlu.bean.NluResponse;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import com.xjsd.ai.assistant.protocol.schedule.Schedule;
import com.xjsd.ai.assistant.protocol.schedule.ScheduleNlpParam;
import com.xjsd.ai.assistant.skill.schedule.ScheduleException;
import com.xjsd.ai.assistant.skill.schedule.ScheduleModifyProcessor;
import com.xjsd.ai.assistant.skill.schedule.ScheduleRepository;
import com.xjsd.ai.assistant.skill.schedule.ScheduleUtils;
import com.xjsd.ai.assistant.template.TtsAlarmTemplate;
import com.xjsd.ai.assistant.template.TtsCalTemplate;
import com.xjsd.ai.assistant.template.TtsGlobalTemplate;
import com.xjsd.ai.assistant.template.TtsTemplate;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b!\u0018\u0000 S2\u00020\u0001:\u0001TB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J-\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010'J?\u0010.\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\n\u0010*\u001a\u00060(j\u0002`)2\b\b\u0002\u0010\b\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00062\b\b\u0002\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b.\u0010/J\u001d\u00102\u001a\u00020\u00042\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000600H\u0002¢\u0006\u0004\b2\u00103J\u0017\u00106\u001a\u00020\u00042\u0006\u00105\u001a\u000204H\u0007¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0006H\u0016¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b:\u0010;J\u0018\u0010<\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH@¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u0004H\u0016¢\u0006\u0004\b>\u0010\u0003J\u001f\u0010A\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u0006H\u0016¢\u0006\u0004\bA\u0010BR(\u0010H\u001a\u0004\u0018\u00010\u00132\b\u0010C\u001a\u0004\u0018\u00010\u00138\u0002@BX\u000e¢\u0006\f\n\u0004\bD\u0010E\"\u0004\bF\u0010GR(\u0010L\u001a\u0004\u0018\u00010\u001a2\b\u0010C\u001a\u0004\u0018\u00010\u001a8\u0002@BX\u000e¢\u0006\f\n\u0004\b8\u0010I\"\u0004\bJ\u0010KR\u0018\u0010O\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u001e\u0010R\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010Q¨\u0006U"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/nlp/ScheduleNlpPreprocessor;", "Lcom/xjsd/ai/assistant/flutter/nlp/NlpPreprocessor;", "<init>", "()V", "", "s", "", "intent", "time", "", "array", "q", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;", "nluResponse", "Lcom/xjsd/ai/assistant/skill/schedule/ScheduleParams;", "params", "n", "(Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;Ljava/lang/String;Lcom/xjsd/ai/assistant/skill/schedule/ScheduleParams;)V", "Lcom/xjsd/ai/assistant/protocol/schedule/Schedule;", "schedule", "j", "(Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;Lcom/xjsd/ai/assistant/protocol/schedule/Schedule;)V", "type", "l", "(Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;Lcom/xjsd/ai/assistant/protocol/schedule/Schedule;Ljava/lang/String;)V", "Lcom/xjsd/ai/assistant/protocol/schedule/ScheduleNlpParam;", "param", "x", "(Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;Lcom/xjsd/ai/assistant/protocol/schedule/Schedule;Lcom/xjsd/ai/assistant/protocol/schedule/ScheduleNlpParam;)V", "", "readOnly", "y", "(Z)V", "formatDate", "Ljava/util/Date;", "k", "(Ljava/lang/String;)Ljava/util/Date;", "z", "(Ljava/lang/String;)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "cmd", "", "existedSchedule", "o", "(Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;Ljava/lang/Exception;Ljava/lang/String;Ljava/lang/String;I)V", "", "permissions", "r", "(Ljava/util/List;)V", "Lcom/xjsd/ai/assistant/flutter/event/FlutterScheduleEvent;", "event", "onReceiveFlutterScheduleEvent", "(Lcom/xjsd/ai/assistant/flutter/event/FlutterScheduleEvent;)V", "b", "()Ljava/lang/String;", "g", "(Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;)Z", "i", "(Lcom/xjsd/ai/assistant/nlu/bean/NluResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clean", "lastDomain", "currentDomain", "f", "(Ljava/lang/String;Ljava/lang/String;)V", "value", "a", "Lcom/xjsd/ai/assistant/protocol/schedule/Schedule;", "t", "(Lcom/xjsd/ai/assistant/protocol/schedule/Schedule;)V", "mContextSchedule", "Lcom/xjsd/ai/assistant/protocol/schedule/ScheduleNlpParam;", "u", "(Lcom/xjsd/ai/assistant/protocol/schedule/ScheduleNlpParam;)V", "mModifyScheduleNlpParam", "c", "Ljava/lang/String;", "mLastIntent", "d", "Ljava/util/List;", "mContextScheduleList", "e", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ScheduleNlpPreprocessor implements NlpPreprocessor {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public Schedule f8490a;
    public ScheduleNlpParam b;
    public String c;
    public List d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/nlp/ScheduleNlpPreprocessor$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public ScheduleNlpPreprocessor() {
        EventBus.c().o(this);
    }

    public static /* synthetic */ void m(ScheduleNlpPreprocessor scheduleNlpPreprocessor, NluResponse nluResponse, Schedule schedule, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "";
        }
        scheduleNlpPreprocessor.l(nluResponse, schedule, str);
    }

    public static /* synthetic */ void p(ScheduleNlpPreprocessor scheduleNlpPreprocessor, NluResponse nluResponse, Exception exc, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str = "";
        }
        String str3 = str;
        if ((i2 & 16) != 0) {
            i = 0;
        }
        scheduleNlpPreprocessor.o(nluResponse, exc, str3, str2, i);
    }

    public void a(NluResponse nluResponse) {
        NlpPreprocessor.DefaultImpls.i(this, nluResponse);
    }

    public String b() {
        return VuiModelType.SCHEDULE;
    }

    public Object c(NluResponse nluResponse, Continuation continuation) {
        return NlpPreprocessor.DefaultImpls.e(this, nluResponse, continuation);
    }

    public void clean() {
        ILog.a("ScheduleNlpPreprocessor", "clean: 清除日程临时数据");
        s();
    }

    public void d(NluResponse nluResponse, int i) {
        NlpPreprocessor.DefaultImpls.j(this, nluResponse, i);
    }

    public void e(NluResponse nluResponse, TtsTemplate ttsTemplate) {
        NlpPreprocessor.DefaultImpls.k(this, nluResponse, ttsTemplate);
    }

    public void f(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "lastDomain");
        Intrinsics.checkNotNullParameter(str2, "currentDomain");
        if (Intrinsics.areEqual((Object) str, (Object) b())) {
            clean();
        }
    }

    public boolean g(NluResponse nluResponse) {
        Intrinsics.checkNotNullParameter(nluResponse, "nluResponse");
        return false;
    }

    public void h(NluResponse nluResponse, String str) {
        NlpPreprocessor.DefaultImpls.l(this, nluResponse, str);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b4, code lost:
        if (r10.equals("Update") == false) goto L_0x0203;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00bc, code lost:
        if (r10.equals("Select") == false) goto L_0x0203;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00c0, code lost:
        r3 = r2.getString("time_text");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00c7, code lost:
        if (r3 == null) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c9, code lost:
        r3 = r3.toLowerCase(java.util.Locale.ROOT);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "toLowerCase(...)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00d5, code lost:
        if (r3 != null) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00d8, code lost:
        r12 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00da, code lost:
        r3 = com.xjsd.ai.assistant.core.ContextHelper.b(com.xjsd.ai.assistant.phone.R.string.tts_schedule_latest_week, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) "Delete");
        r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) "Update");
        r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) "Select");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00f0, code lost:
        if (r3 != false) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00f2, code lost:
        if (r5 != false) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00f4, code lost:
        if (r4 == false) goto L_0x016d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00f6, code lost:
        r3 = r16.getPayload().getString("index");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0100, code lost:
        if (r4 == false) goto L_0x0113;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0102, code lost:
        if (r3 == null) goto L_0x0113;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0108, code lost:
        if (kotlin.text.StringsKt.isBlank(r3) == false) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x010b, code lost:
        w(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x010e, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x010f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0110, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0113, code lost:
        if (r3 == null) goto L_0x016d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0119, code lost:
        if (kotlin.text.StringsKt.isBlank(r3) == false) goto L_0x011c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0122, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) "current") != false) goto L_0x016d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x012a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) "all") != false) goto L_0x016d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x012c, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r3);
        r0 = java.lang.Integer.parseInt(r3);
        r1 = r7.d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0135, code lost:
        if (r1 == null) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0137, code lost:
        if (r0 <= 0) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0139, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0140, code lost:
        if (r0 <= r1.size()) goto L_0x0143;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0143, code lost:
        r1 = r7.d;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r3 = (com.xjsd.ai.assistant.protocol.schedule.Schedule) r1.get(r0 - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002b, code lost:
        if (r10.equals("Delete") == false) goto L_0x0203;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0150, code lost:
        if (r5 == false) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0152, code lost:
        r0 = r7.b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (r0 != null) goto L_0x015b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0156, code lost:
        r0 = new com.xjsd.ai.assistant.protocol.schedule.ScheduleNlpParam();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x015b, code lost:
        x(r9, r3, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x015f, code lost:
        m(r15, r16, r3, (java.lang.String) null, 4, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0168, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0169, code lost:
        w(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x016c, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x016d, code lost:
        r3 = r2.getString(io.netty.handler.codec.rtsp.RtspHeaders.Values.TIME);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0176, code lost:
        if (r3 != null) goto L_0x0179;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0178, code lost:
        r3 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        r5 = r2.getString("target");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0180, code lost:
        if (r5 != null) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0182, code lost:
        r5 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0187, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r1) == false) goto L_0x018b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0035, code lost:
        if (r10.equals("Create") == false) goto L_0x0203;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0189, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x018f, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r0) == false) goto L_0x0193;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0191, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0193, code lost:
        r0 = new java.lang.String[]{"", ""};
        kotlin.jvm.internal.Intrinsics.checkNotNull(r10);
        q(r10, r3, r0);
        r14 = r0[0];
        r1 = r0[1];
        r0 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01a4, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
        r3 = new com.xjsd.ai.assistant.skill.schedule.ScheduleParams(r2);
        r3.h(r5);
        r3.g(r0);
        r3.f(r1);
        kotlin.jvm.internal.Intrinsics.checkNotNull(r12);
        r3.i(r12);
        com.xjsd.ai.assistant.log.ILog.a("ScheduleNlpPreprocessor", "process: 日程参数->" + r3);
        kotlin.jvm.internal.Intrinsics.checkNotNull(r10);
        n(r9, r10, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01d6, code lost:
        com.xjsd.ai.assistant.log.ILog.h("ScheduleNlpPreprocessor", "process: " + r10 + " 日程异常", r3);
        kotlin.jvm.internal.Intrinsics.checkNotNull(r12);
        kotlin.jvm.internal.Intrinsics.checkNotNull(r10);
        p(r15, r16, r3, r12, r10, 0, 16, (java.lang.Object) null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object i(com.xjsd.ai.assistant.nlu.bean.NluResponse r16, kotlin.coroutines.Continuation r17) {
        /*
            r15 = this;
            r7 = r15
            r9 = r16
            java.lang.String r8 = "ScheduleNlpPreprocessor"
            java.lang.String r0 = "past"
            java.lang.String r1 = "invalid"
            com.xjsd.ai.assistant.nlu.bean.HeaderData r2 = r16.getHeader()
            java.lang.String r10 = r2.getName()
            com.alibaba.fastjson.JSONObject r2 = r16.getPayload()
            if (r10 == 0) goto L_0x0203
            int r3 = r10.hashCode()
            java.lang.String r4 = "Select"
            java.lang.String r5 = "Update"
            java.lang.String r6 = "Delete"
            r11 = 0
            switch(r3) {
                case -1822154468: goto L_0x00b8;
                case -1754979095: goto L_0x00b0;
                case 196606070: goto L_0x008f;
                case 197090197: goto L_0x005a;
                case 1646047235: goto L_0x004d;
                case 2011110042: goto L_0x0039;
                case 2026540316: goto L_0x002f;
                case 2043376075: goto L_0x0027;
                default: goto L_0x0025;
            }
        L_0x0025:
            goto L_0x0203
        L_0x0027:
            boolean r3 = r10.equals(r6)
            if (r3 != 0) goto L_0x00c0
            goto L_0x0203
        L_0x002f:
            java.lang.String r3 = "Create"
            boolean r3 = r10.equals(r3)
            if (r3 != 0) goto L_0x00c0
            goto L_0x0203
        L_0x0039:
            java.lang.String r0 = "Cancel"
            boolean r0 = r10.equals(r0)
            if (r0 != 0) goto L_0x0043
            goto L_0x0203
        L_0x0043:
            com.xjsd.ai.assistant.template.TtsGlobalTemplate r0 = com.xjsd.ai.assistant.template.TtsGlobalTemplate.GLOBAL06_P01
            r15.e(r9, r0)
            com.xjsd.ai.assistant.flutter.NlpCompact.a()
            goto L_0x0209
        L_0x004d:
            java.lang.String r0 = "SwitchPage"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L_0x0203
            r15.w(r16)
            goto L_0x0209
        L_0x005a:
            java.lang.String r0 = "QueryTime"
            boolean r0 = r10.equals(r0)
            if (r0 != 0) goto L_0x0064
            goto L_0x0203
        L_0x0064:
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            int r1 = com.xjsd.ai.assistant.phone.R.string.tts_schedule_time
            java.lang.Object[] r2 = new java.lang.Object[r11]
            java.lang.String r1 = com.xjsd.ai.assistant.core.ContextHelper.b(r1, r2)
            r0.<init>(r1)
            java.util.Calendar r1 = java.util.Calendar.getInstance()
            java.util.Date r1 = r1.getTime()
            java.lang.String r0 = r0.format(r1)
            com.xjsd.ai.assistant.template.TtsCalTemplate r1 = com.xjsd.ai.assistant.template.TtsCalTemplate.CAL05_R06
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r0 = r1.getTts(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r15.h(r9, r0)
            goto L_0x0209
        L_0x008f:
            java.lang.String r0 = "QueryDate"
            boolean r0 = r10.equals(r0)
            if (r0 != 0) goto L_0x0099
            goto L_0x0203
        L_0x0099:
            java.lang.String r0 = "utterance"
            com.alibaba.fastjson.JSONObject r0 = r2.getJSONObject(r0)
            java.lang.String r1 = "speech"
            java.lang.String r0 = r0.getString(r1)
            java.lang.String r1 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r15.h(r9, r0)
            goto L_0x0209
        L_0x00b0:
            boolean r3 = r10.equals(r5)
            if (r3 != 0) goto L_0x00c0
            goto L_0x0203
        L_0x00b8:
            boolean r3 = r10.equals(r4)
            if (r3 != 0) goto L_0x00c0
            goto L_0x0203
        L_0x00c0:
            java.lang.String r3 = "time_text"
            java.lang.String r3 = r2.getString(r3)
            if (r3 == 0) goto L_0x00da
            java.util.Locale r12 = java.util.Locale.ROOT
            java.lang.String r3 = r3.toLowerCase(r12)
            java.lang.String r12 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r12)
            if (r3 != 0) goto L_0x00d8
            goto L_0x00da
        L_0x00d8:
            r12 = r3
            goto L_0x00e3
        L_0x00da:
            int r3 = com.xjsd.ai.assistant.phone.R.string.tts_schedule_latest_week
            java.lang.Object[] r12 = new java.lang.Object[r11]
            java.lang.String r3 = com.xjsd.ai.assistant.core.ContextHelper.b(r3, r12)
            goto L_0x00d8
        L_0x00e3:
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r6)     // Catch:{ Exception -> 0x010f }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r5)     // Catch:{ Exception -> 0x010f }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r4)     // Catch:{ Exception -> 0x010f }
            r6 = 1
            if (r3 != 0) goto L_0x00f6
            if (r5 != 0) goto L_0x00f6
            if (r4 == 0) goto L_0x016d
        L_0x00f6:
            com.alibaba.fastjson.JSONObject r3 = r16.getPayload()     // Catch:{ Exception -> 0x010f }
            java.lang.String r13 = "index"
            java.lang.String r3 = r3.getString(r13)     // Catch:{ Exception -> 0x010f }
            if (r4 == 0) goto L_0x0113
            if (r3 == 0) goto L_0x0113
            boolean r4 = kotlin.text.StringsKt.isBlank(r3)     // Catch:{ Exception -> 0x010f }
            if (r4 == 0) goto L_0x010b
            goto L_0x0113
        L_0x010b:
            r15.w(r16)     // Catch:{ Exception -> 0x010f }
            return r9
        L_0x010f:
            r0 = move-exception
            r3 = r0
            goto L_0x01d6
        L_0x0113:
            if (r3 == 0) goto L_0x016d
            boolean r4 = kotlin.text.StringsKt.isBlank(r3)     // Catch:{ Exception -> 0x010f }
            if (r4 == 0) goto L_0x011c
            goto L_0x016d
        L_0x011c:
            java.lang.String r4 = "current"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)     // Catch:{ Exception -> 0x010f }
            if (r4 != 0) goto L_0x016d
            java.lang.String r4 = "all"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)     // Catch:{ Exception -> 0x010f }
            if (r4 != 0) goto L_0x016d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)     // Catch:{ Exception -> 0x010f }
            int r0 = java.lang.Integer.parseInt(r3)     // Catch:{ Exception -> 0x010f }
            java.util.List r1 = r7.d     // Catch:{ Exception -> 0x010f }
            if (r1 == 0) goto L_0x0169
            if (r0 <= 0) goto L_0x0169
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch:{ Exception -> 0x010f }
            int r1 = r1.size()     // Catch:{ Exception -> 0x010f }
            if (r0 <= r1) goto L_0x0143
            goto L_0x0169
        L_0x0143:
            java.util.List r1 = r7.d     // Catch:{ Exception -> 0x010f }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch:{ Exception -> 0x010f }
            int r0 = r0 - r6
            java.lang.Object r0 = r1.get(r0)     // Catch:{ Exception -> 0x010f }
            r3 = r0
            com.xjsd.ai.assistant.protocol.schedule.Schedule r3 = (com.xjsd.ai.assistant.protocol.schedule.Schedule) r3     // Catch:{ Exception -> 0x010f }
            if (r5 == 0) goto L_0x015f
            com.xjsd.ai.assistant.protocol.schedule.ScheduleNlpParam r0 = r7.b     // Catch:{ Exception -> 0x010f }
            if (r0 != 0) goto L_0x015b
            com.xjsd.ai.assistant.protocol.schedule.ScheduleNlpParam r0 = new com.xjsd.ai.assistant.protocol.schedule.ScheduleNlpParam     // Catch:{ Exception -> 0x010f }
            r0.<init>()     // Catch:{ Exception -> 0x010f }
        L_0x015b:
            r15.x(r9, r3, r0)     // Catch:{ Exception -> 0x010f }
            goto L_0x0168
        L_0x015f:
            r5 = 4
            r6 = 0
            r4 = 0
            r1 = r15
            r2 = r16
            m(r1, r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x010f }
        L_0x0168:
            return r9
        L_0x0169:
            r15.w(r16)     // Catch:{ Exception -> 0x010f }
            return r9
        L_0x016d:
            java.lang.String r3 = "time"
            java.lang.String r3 = r2.getString(r3)     // Catch:{ Exception -> 0x010f }
            java.lang.String r4 = ""
            if (r3 != 0) goto L_0x0179
            r3 = r4
        L_0x0179:
            java.lang.String r5 = "target"
            java.lang.String r5 = r2.getString(r5)     // Catch:{ Exception -> 0x010f }
            if (r5 != 0) goto L_0x0183
            r5 = r4
        L_0x0183:
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r1)     // Catch:{ Exception -> 0x010f }
            if (r13 == 0) goto L_0x018b
            r0 = r1
            goto L_0x01a4
        L_0x018b:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r0)     // Catch:{ Exception -> 0x010f }
            if (r1 == 0) goto L_0x0193
            r1 = r0
            goto L_0x01a4
        L_0x0193:
            java.lang.String[] r0 = new java.lang.String[]{r4, r4}     // Catch:{ Exception -> 0x010f }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)     // Catch:{ Exception -> 0x010f }
            r15.q(r10, r3, r0)     // Catch:{ Exception -> 0x010f }
            r1 = r0[r11]     // Catch:{ Exception -> 0x010f }
            r0 = r0[r6]     // Catch:{ Exception -> 0x010f }
            r14 = r1
            r1 = r0
            r0 = r14
        L_0x01a4:
            com.xjsd.ai.assistant.skill.schedule.ScheduleParams r3 = new com.xjsd.ai.assistant.skill.schedule.ScheduleParams     // Catch:{ Exception -> 0x010f }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)     // Catch:{ Exception -> 0x010f }
            r3.<init>(r2)     // Catch:{ Exception -> 0x010f }
            r3.h(r5)     // Catch:{ Exception -> 0x010f }
            r3.g(r0)     // Catch:{ Exception -> 0x010f }
            r3.f(r1)     // Catch:{ Exception -> 0x010f }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)     // Catch:{ Exception -> 0x010f }
            r3.i(r12)     // Catch:{ Exception -> 0x010f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010f }
            r0.<init>()     // Catch:{ Exception -> 0x010f }
            java.lang.String r1 = "process: 日程参数->"
            r0.append(r1)     // Catch:{ Exception -> 0x010f }
            r0.append(r3)     // Catch:{ Exception -> 0x010f }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x010f }
            com.xjsd.ai.assistant.log.ILog.a(r8, r0)     // Catch:{ Exception -> 0x010f }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)     // Catch:{ Exception -> 0x010f }
            r15.n(r9, r10, r3)     // Catch:{ Exception -> 0x010f }
            goto L_0x0209
        L_0x01d6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "process: "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r1 = " 日程异常"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.xjsd.ai.assistant.log.ILog.h(r8, r0, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            r0 = 16
            r8 = 0
            r6 = 0
            r1 = r15
            r2 = r16
            r4 = r12
            r5 = r10
            r7 = r0
            p(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0209
        L_0x0203:
            r15.w(r16)
            com.xjsd.ai.assistant.flutter.NlpCompact.a()
        L_0x0209:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.flutter.nlp.ScheduleNlpPreprocessor.i(com.xjsd.ai.assistant.nlu.bean.NluResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void j(NluResponse nluResponse, Schedule schedule) {
        ScheduleRepository scheduleRepository = ScheduleRepository.f8699a;
        Object a2 = scheduleRepository.a(schedule);
        if (Result.m27isSuccessimpl(a2)) {
            long longValue = ((Number) a2).longValue();
            ILog.a("ScheduleNlpPreprocessor", "createSchedule: success, eventId->" + longValue + "}");
            long dtStart = schedule.getDtStart();
            Long dtEnd = schedule.getDtEnd();
            Intrinsics.checkNotNull(dtEnd);
            Schedule g = scheduleRepository.g(longValue, dtStart, dtEnd.longValue());
            if (g != null) {
                String timeInfo = g.timeInfo();
                t(g);
                JSONObject payload = nluResponse.getPayload();
                Intrinsics.checkNotNullExpressionValue(payload, "getPayload(...)");
                payload.put("result", GsonUtils.e(CollectionsKt.listOf(g)));
                String tts = TtsCalTemplate.CAL02_R05.getTts(timeInfo);
                Intrinsics.checkNotNullExpressionValue(tts, "getTts(...)");
                h(nluResponse, tts);
            } else {
                String timeInfo2 = schedule.timeInfo();
                t(schedule);
                JSONObject payload2 = nluResponse.getPayload();
                Intrinsics.checkNotNullExpressionValue(payload2, "getPayload(...)");
                payload2.put("result", GsonUtils.e(CollectionsKt.listOf(schedule)));
                String tts2 = TtsCalTemplate.CAL02_R05.getTts(timeInfo2);
                Intrinsics.checkNotNullExpressionValue(tts2, "getTts(...)");
                h(nluResponse, tts2);
            }
        }
        if (Result.m23exceptionOrNullimpl(a2) != null) {
            e(nluResponse, TtsCalTemplate.CAL02_R06);
            NlpCompact.a();
        }
    }

    public final Date k(String str) {
        z(str);
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

    public final void l(NluResponse nluResponse, Schedule schedule, String str) {
        String e2 = GsonUtils.e(schedule);
        ILog.a("ScheduleNlpPreprocessor", "deleteSchedule: deleteType->" + str + ", data->" + e2);
        if (DeviceBrandUtil.f()) {
            str = "whole";
        }
        String duration = schedule.getDuration();
        if (duration == null || duration.length() == 0 || Intrinsics.areEqual((Object) str, (Object) "current") || Intrinsics.areEqual((Object) str, (Object) "all") || Intrinsics.areEqual((Object) str, (Object) "whole")) {
            s();
            if (ScheduleRepository.f8699a.b(schedule, str)) {
                v(nluResponse);
                e(nluResponse, TtsCalTemplate.CAL04_R03);
                return;
            }
            e(nluResponse, TtsCalTemplate.CAL04_R04);
            return;
        }
        t(schedule);
        e(nluResponse, TtsCalTemplate.CAL04_R02);
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x029f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n(com.xjsd.ai.assistant.nlu.bean.NluResponse r21, java.lang.String r22, com.xjsd.ai.assistant.skill.schedule.ScheduleParams r23) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            int r3 = r22.hashCode()
            java.lang.String r4 = "ScheduleNlpPreprocessor"
            java.lang.String r5 = "index"
            java.lang.String r6 = "result"
            java.lang.String r7 = "getPayload(...)"
            java.lang.String r8 = ""
            r9 = 1
            java.lang.String r10 = "getTts(...)"
            r11 = 0
            switch(r3) {
                case -1822154468: goto L_0x031d;
                case -1754979095: goto L_0x0189;
                case 2026540316: goto L_0x00b2;
                case 2043376075: goto L_0x001d;
                default: goto L_0x001b;
            }
        L_0x001b:
            goto L_0x042e
        L_0x001d:
            java.lang.String r3 = "Delete"
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L_0x0027
            goto L_0x042e
        L_0x0027:
            r0.y(r11)
            com.alibaba.fastjson.JSONObject r3 = r23.b()
            java.lang.String r3 = r3.getString(r5)
            if (r3 != 0) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            r8 = r3
        L_0x0036:
            com.xjsd.ai.assistant.protocol.schedule.Schedule r3 = r0.f8490a
            if (r3 == 0) goto L_0x0042
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r0.l(r1, r3, r8)
            goto L_0x042e
        L_0x0042:
            java.lang.String r3 = r23.c()
            java.util.Date r13 = r0.k(r3)
            java.lang.String r3 = r23.a()
            java.util.Date r14 = r0.k(r3)
            java.lang.String r15 = r23.d()
            java.lang.String r3 = r23.e()
            r20.s()
            com.xjsd.ai.assistant.skill.schedule.ScheduleRepository r12 = com.xjsd.ai.assistant.skill.schedule.ScheduleRepository.f8699a
            r17 = 8
            r18 = 0
            r16 = 0
            java.util.List r4 = com.xjsd.ai.assistant.skill.schedule.ScheduleRepository.i(r12, r13, r14, r15, r16, r17, r18)
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L_0x0081
            com.xjsd.ai.assistant.template.TtsCalTemplate r2 = com.xjsd.ai.assistant.template.TtsCalTemplate.CAL01_R04
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.String r2 = r2.getTts(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r10)
            r0.h(r1, r2)
            goto L_0x042e
        L_0x0081:
            int r3 = r4.size()
            if (r3 != r9) goto L_0x0099
            java.lang.Object r2 = r4.get(r11)
            com.xjsd.ai.assistant.protocol.schedule.Schedule r2 = (com.xjsd.ai.assistant.protocol.schedule.Schedule) r2
            r4 = 4
            r5 = 0
            r3 = 0
            r0 = r20
            r1 = r21
            m(r0, r1, r2, r3, r4, r5)
            goto L_0x042e
        L_0x0099:
            r0.c = r2
            r0.d = r4
            com.alibaba.fastjson.JSONObject r2 = r21.getPayload()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)
            java.lang.String r3 = com.xjsd.ai.assistant.json.GsonUtils.e(r4)
            r2.put(r6, r3)
            com.xjsd.ai.assistant.template.TtsCalTemplate r2 = com.xjsd.ai.assistant.template.TtsCalTemplate.CAL04_R01
            r0.e(r1, r2)
            goto L_0x042e
        L_0x00b2:
            java.lang.String r3 = "Create"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x00bc
            goto L_0x042e
        L_0x00bc:
            r0.y(r11)
            com.alibaba.fastjson.JSONObject r2 = r23.b()
            java.lang.String r3 = "confirm"
            boolean r2 = r2.containsKey(r3)
            r20.s()
            java.lang.String r3 = r23.c()
            java.util.Date r3 = r0.k(r3)
            java.lang.String r5 = r23.a()
            java.util.Date r5 = r0.k(r5)
            java.lang.String r12 = r23.d()
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r12)
            if (r8 == 0) goto L_0x00f0
            int r8 = com.xjsd.ai.assistant.phone.R.string.tts_schedule_def_title
            java.lang.Object[] r11 = new java.lang.Object[r11]
            java.lang.String r8 = com.xjsd.ai.assistant.core.ContextHelper.b(r8, r11)
        L_0x00ee:
            r12 = r8
            goto L_0x00f5
        L_0x00f0:
            java.lang.String r8 = r23.d()
            goto L_0x00ee
        L_0x00f5:
            if (r2 != 0) goto L_0x0173
            boolean r2 = com.xjsd.ai.assistant.skill.call.util.PhoneCallUtil.c()
            if (r2 == 0) goto L_0x0173
            com.xjsd.ai.assistant.skill.schedule.ScheduleRepository r2 = com.xjsd.ai.assistant.skill.schedule.ScheduleRepository.f8699a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            java.util.List r2 = r2.h(r3, r5, r12, r9)
            boolean r8 = r2.isEmpty()
            r8 = r8 ^ r9
            if (r8 == 0) goto L_0x0173
            java.util.Iterator r2 = r2.iterator()
        L_0x0111:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L_0x0173
            java.lang.Object r8 = r2.next()
            com.xjsd.ai.assistant.protocol.schedule.Schedule r8 = (com.xjsd.ai.assistant.protocol.schedule.Schedule) r8
            long r13 = r8.getInstanceBegin()
            long r15 = r3.getTime()
            int r9 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r9 != 0) goto L_0x0111
            long r13 = r8.getInstanceEnd()
            long r15 = r5.getTime()
            int r9 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r9 != 0) goto L_0x0111
            java.lang.String r9 = r8.getTitle()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r12)
            if (r9 == 0) goto L_0x0111
            java.lang.String r2 = "handleCreateCommand: 已有重复日程，直接更新"
            com.xjsd.ai.assistant.log.ILog.a(r4, r2)
            com.xjsd.ai.assistant.skill.schedule.ScheduleRepository r2 = com.xjsd.ai.assistant.skill.schedule.ScheduleRepository.f8699a
            r2.f(r8)
            java.lang.String r2 = r8.timeInfo()
            r0.t(r8)
            com.alibaba.fastjson.JSONObject r3 = r21.getPayload()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            java.util.List r4 = kotlin.collections.CollectionsKt.listOf(r8)
            java.lang.String r4 = com.xjsd.ai.assistant.json.GsonUtils.e(r4)
            r3.put(r6, r4)
            com.xjsd.ai.assistant.template.TtsCalTemplate r3 = com.xjsd.ai.assistant.template.TtsCalTemplate.CAL02_R05
            java.lang.Object[] r2 = new java.lang.Object[]{r2}
            java.lang.String r2 = r3.getTts(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r10)
            r0.h(r1, r2)
            return
        L_0x0173:
            com.xjsd.ai.assistant.protocol.schedule.Schedule r2 = new com.xjsd.ai.assistant.protocol.schedule.Schedule
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            long r13 = r3.getTime()
            long r15 = r5.getTime()
            r11 = r2
            r11.<init>(r12, r13, r15)
            r0.j(r1, r2)
            goto L_0x042e
        L_0x0189:
            java.lang.String r3 = "Update"
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L_0x0193
            goto L_0x042e
        L_0x0193:
            com.alibaba.fastjson.JSONObject r3 = r23.b()
            com.xjsd.ai.assistant.protocol.schedule.ScheduleNlpParam r4 = new com.xjsd.ai.assistant.protocol.schedule.ScheduleNlpParam
            r4.<init>()
            java.lang.String r5 = r3.getString(r5)
            if (r5 != 0) goto L_0x01a3
            r5 = r8
        L_0x01a3:
            r4.setIndex(r5)
            java.lang.String r5 = "duration"
            java.lang.String r5 = r3.getString(r5)
            if (r5 != 0) goto L_0x01af
            r5 = r8
        L_0x01af:
            r4.setDuration(r5)
            java.lang.String r5 = r23.d()
            r4.setTarget(r5)
            java.lang.String r5 = r23.e()
            r4.setOriginTime(r5)
            java.lang.String r5 = r23.c()
            r4.setStartTime(r5)
            java.lang.String r5 = r23.a()
            r4.setEndTime(r5)
            java.lang.String r5 = "old_target"
            java.lang.String r5 = r3.getString(r5)
            if (r5 != 0) goto L_0x01d7
            r5 = r8
        L_0x01d7:
            r4.setOldTarget(r5)
            java.lang.String r5 = "old_time"
            java.lang.String r3 = r3.getString(r5)
            if (r3 == 0) goto L_0x01f3
            java.util.Locale r5 = java.util.Locale.ROOT
            java.lang.String r3 = r3.toLowerCase(r5)
            java.lang.String r5 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            if (r3 != 0) goto L_0x01f1
            goto L_0x01f3
        L_0x01f1:
            r12 = r3
            goto L_0x01f4
        L_0x01f3:
            r12 = r8
        L_0x01f4:
            java.lang.String r3 = "invalid"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r3)
            if (r5 == 0) goto L_0x0204
            r4.setOldStartTime(r3)
            r4.setOldEndTime(r3)
            goto L_0x0278
        L_0x0204:
            java.lang.String r3 = "past"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r12)
            if (r5 == 0) goto L_0x0213
            r4.setOldStartTime(r3)
            r4.setOldEndTime(r3)
            goto L_0x0278
        L_0x0213:
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r12)
            r18 = 604800000(0x240c8400, double:2.988109026E-315)
            if (r3 == 0) goto L_0x023c
            java.util.Date r3 = new java.util.Date
            r3.<init>()
            com.xjsd.ai.assistant.skill.schedule.ScheduleUtils r5 = com.xjsd.ai.assistant.skill.schedule.ScheduleUtils.f8700a
            long r12 = r3.getTime()
            java.lang.String r8 = r5.e(r12)
            r4.setOldStartTime(r8)
            long r12 = r3.getTime()
            long r12 = r12 + r18
            java.lang.String r3 = r5.e(r12)
            r4.setOldEndTime(r3)
            goto L_0x0278
        L_0x023c:
            java.lang.String r3 = ","
            java.lang.String[] r13 = new java.lang.String[]{r3}
            r16 = 6
            r17 = 0
            r14 = 0
            r15 = 0
            java.util.List r3 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r12, (java.lang.String[]) r13, (boolean) r14, (int) r15, (int) r16, (java.lang.Object) r17)
            java.lang.Object r5 = r3.get(r11)
            java.lang.String r5 = (java.lang.String) r5
            r4.setOldStartTime(r5)
            int r5 = r3.size()
            if (r5 <= r9) goto L_0x0265
            java.lang.Object r3 = r3.get(r9)
            java.lang.String r3 = (java.lang.String) r3
            r4.setOldEndTime(r3)
            goto L_0x0278
        L_0x0265:
            com.xjsd.ai.assistant.skill.schedule.ScheduleUtils r3 = com.xjsd.ai.assistant.skill.schedule.ScheduleUtils.f8700a
            java.lang.String r5 = r4.getOldStartTime()
            long r12 = r3.d(r5)
            long r12 = r12 + r18
            java.lang.String r3 = r3.e(r12)
            r4.setOldEndTime(r3)
        L_0x0278:
            r4.calTime()
            r0.y(r11)
            com.xjsd.ai.assistant.protocol.schedule.Schedule r3 = r0.f8490a
            if (r3 == 0) goto L_0x029f
            com.xjsd.ai.assistant.protocol.schedule.ScheduleNlpParam r2 = r0.b
            if (r2 != 0) goto L_0x028a
            r0.u(r4)
            goto L_0x0290
        L_0x028a:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r2.update(r4)
        L_0x0290:
            com.xjsd.ai.assistant.protocol.schedule.Schedule r2 = r0.f8490a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            com.xjsd.ai.assistant.protocol.schedule.ScheduleNlpParam r3 = r0.b
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r0.x(r1, r2, r3)
            goto L_0x042e
        L_0x029f:
            java.lang.String r3 = r4.getOldStartTime()
            java.util.Date r13 = r0.k(r3)
            java.lang.String r3 = r4.getOldEndTime()
            java.util.Date r14 = r0.k(r3)
            com.xjsd.ai.assistant.protocol.schedule.ScheduleNlpParam r3 = r0.b
            if (r3 != 0) goto L_0x02b7
            r0.u(r4)
            goto L_0x02bd
        L_0x02b7:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r3.update(r4)
        L_0x02bd:
            java.lang.String r15 = r4.getOldTarget()
            com.xjsd.ai.assistant.protocol.schedule.ScheduleNlpParam r3 = r0.b
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.String r3 = r3.getOriginTime()
            com.xjsd.ai.assistant.skill.schedule.ScheduleRepository r12 = com.xjsd.ai.assistant.skill.schedule.ScheduleRepository.f8699a
            r17 = 8
            r18 = 0
            r16 = 0
            java.util.List r4 = com.xjsd.ai.assistant.skill.schedule.ScheduleRepository.i(r12, r13, r14, r15, r16, r17, r18)
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L_0x02ee
            com.xjsd.ai.assistant.template.TtsCalTemplate r2 = com.xjsd.ai.assistant.template.TtsCalTemplate.CAL01_R04
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.String r2 = r2.getTts(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r10)
            r0.h(r1, r2)
            goto L_0x042e
        L_0x02ee:
            int r3 = r4.size()
            if (r3 != r9) goto L_0x0304
            com.xjsd.ai.assistant.protocol.schedule.ScheduleNlpParam r2 = r0.b
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.Object r3 = r4.get(r11)
            com.xjsd.ai.assistant.protocol.schedule.Schedule r3 = (com.xjsd.ai.assistant.protocol.schedule.Schedule) r3
            r0.x(r1, r3, r2)
            goto L_0x042e
        L_0x0304:
            r0.c = r2
            r0.d = r4
            com.alibaba.fastjson.JSONObject r2 = r21.getPayload()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)
            java.lang.String r3 = com.xjsd.ai.assistant.json.GsonUtils.e(r4)
            r2.put(r6, r3)
            com.xjsd.ai.assistant.template.TtsCalTemplate r2 = com.xjsd.ai.assistant.template.TtsCalTemplate.CAL05_R01
            r0.e(r1, r2)
            goto L_0x042e
        L_0x031d:
            java.lang.String r3 = "Select"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0327
            goto L_0x042e
        L_0x0327:
            r0.y(r9)
            r20.s()
            java.lang.String r2 = r23.c()
            java.util.Date r13 = r0.k(r2)
            java.lang.String r2 = r23.a()
            java.util.Date r14 = r0.k(r2)
            java.lang.String r2 = r23.e()
            java.lang.String r15 = r23.d()
            com.xjsd.ai.assistant.skill.schedule.ScheduleRepository r3 = com.xjsd.ai.assistant.skill.schedule.ScheduleRepository.f8699a
            r17 = 8
            r18 = 0
            r16 = 0
            r12 = r3
            java.util.List r5 = com.xjsd.ai.assistant.skill.schedule.ScheduleRepository.i(r12, r13, r14, r15, r16, r17, r18)
            int r8 = r5.size()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "execute: 查询日程返回个数->"
            r12.append(r13)
            r12.append(r8)
            java.lang.String r8 = r12.toString()
            com.xjsd.ai.assistant.log.ILog.a(r4, r8)
            boolean r4 = r5.isEmpty()
            if (r4 == 0) goto L_0x0382
            com.xjsd.ai.assistant.template.TtsCalTemplate r3 = com.xjsd.ai.assistant.template.TtsCalTemplate.CAL01_R04
            java.lang.Object[] r2 = new java.lang.Object[]{r2}
            java.lang.String r2 = r3.getTts(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r10)
            r0.h(r1, r2)
            goto L_0x042e
        L_0x0382:
            int r4 = r5.size()
            if (r4 != r9) goto L_0x03be
            java.lang.Object r2 = r5.get(r11)
            com.xjsd.ai.assistant.protocol.schedule.Schedule r2 = (com.xjsd.ai.assistant.protocol.schedule.Schedule) r2
            java.lang.String r3 = r2.timeInfo()
            com.xjsd.ai.assistant.skill.schedule.ScheduleModifyProcessor$Companion r4 = com.xjsd.ai.assistant.skill.schedule.ScheduleModifyProcessor.b
            java.lang.String r8 = r2.getTitle()
            java.lang.String r4 = r4.a(r8)
            r0.t(r2)
            com.alibaba.fastjson.JSONObject r2 = r21.getPayload()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)
            java.lang.String r5 = com.xjsd.ai.assistant.json.GsonUtils.e(r5)
            r2.put(r6, r5)
            com.xjsd.ai.assistant.template.TtsCalTemplate r2 = com.xjsd.ai.assistant.template.TtsCalTemplate.CAL01_R03
            java.lang.Object[] r3 = new java.lang.Object[]{r3, r4}
            java.lang.String r2 = r2.getTts(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r10)
            r0.h(r1, r2)
            goto L_0x042e
        L_0x03be:
            java.lang.Object r4 = r5.get(r11)
            com.xjsd.ai.assistant.protocol.schedule.Schedule r4 = (com.xjsd.ai.assistant.protocol.schedule.Schedule) r4
            int r8 = r5.size()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.String r9 = r4.timeInfo()
            com.xjsd.ai.assistant.skill.schedule.ScheduleModifyProcessor$Companion r11 = com.xjsd.ai.assistant.skill.schedule.ScheduleModifyProcessor.b
            java.lang.String r4 = r4.getTitle()
            java.lang.String r4 = r11.a(r4)
            r0.d = r5
            com.alibaba.fastjson.JSONObject r11 = r21.getPayload()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r7)
            java.lang.String r7 = com.xjsd.ai.assistant.json.GsonUtils.e(r5)
            r11.put(r6, r7)
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            if (r6 == 0) goto L_0x0401
            com.xjsd.ai.assistant.template.TtsCalTemplate r2 = com.xjsd.ai.assistant.template.TtsCalTemplate.CAL01_R02
            java.lang.Object[] r3 = new java.lang.Object[]{r8, r9, r4}
            java.lang.String r2 = r2.getTts(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r10)
            r0.h(r1, r2)
            goto L_0x042e
        L_0x0401:
            com.xjsd.ai.assistant.protocol.schedule.Schedule r3 = r3.c()
            if (r3 == 0) goto L_0x041e
            boolean r3 = r5.contains(r3)
            if (r3 == 0) goto L_0x041e
            com.xjsd.ai.assistant.template.TtsCalTemplate r3 = com.xjsd.ai.assistant.template.TtsCalTemplate.CAL01_R05
            java.lang.Object[] r2 = new java.lang.Object[]{r2, r8, r9, r4}
            java.lang.String r2 = r3.getTts(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r10)
            r0.h(r1, r2)
            goto L_0x042e
        L_0x041e:
            com.xjsd.ai.assistant.template.TtsCalTemplate r3 = com.xjsd.ai.assistant.template.TtsCalTemplate.CAL01_R06
            java.lang.Object[] r2 = new java.lang.Object[]{r2, r8}
            java.lang.String r2 = r3.getTts(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r10)
            r0.h(r1, r2)
        L_0x042e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.flutter.nlp.ScheduleNlpPreprocessor.n(com.xjsd.ai.assistant.nlu.bean.NluResponse, java.lang.String, com.xjsd.ai.assistant.skill.schedule.ScheduleParams):void");
    }

    public final void o(NluResponse nluResponse, Exception exc, String str, String str2, int i) {
        if (exc instanceof ScheduleException.TimeNoInfoException) {
            e(nluResponse, TtsCalTemplate.CAL02_R02);
        } else if (exc instanceof ScheduleException.TimeFormatException) {
            e(nluResponse, TtsCalTemplate.CAL02_R03);
        } else if (exc instanceof ScheduleException.TimePassedException) {
            switch (str2.hashCode()) {
                case -1822154468:
                    if (str2.equals("Select")) {
                        e(nluResponse, TtsCalTemplate.CAL01_R01);
                        return;
                    }
                    return;
                case -1754979095:
                    if (!str2.equals("Update")) {
                        return;
                    }
                    break;
                case 2026540316:
                    if (str2.equals("Create")) {
                        e(nluResponse, TtsCalTemplate.CAL02_R04);
                        return;
                    }
                    return;
                case 2043376075:
                    if (!str2.equals("Delete")) {
                        return;
                    }
                    break;
                default:
                    return;
            }
            e(nluResponse, TtsCalTemplate.CAL02_R03);
        } else if (exc instanceof ScheduleException.ScheduleCreateWithSqlException) {
            e(nluResponse, TtsAlarmTemplate.ALARM02_R03);
        } else if (exc instanceof ScheduleException.ScheduleExistInTimeException) {
            String tts = TtsCalTemplate.CAL02_R01.getTts(str, String.valueOf(i));
            Intrinsics.checkNotNullExpressionValue(tts, "getTts(...)");
            h(nluResponse, tts);
        } else if (exc instanceof ScheduleException.ScheduleReadPermissionException) {
            e(nluResponse, TtsGlobalTemplate.GLOBAL02_R11);
            r(CollectionsKt.mutableListOf("android.permission.READ_CALENDAR"));
            NlpCompact.a();
        } else if (exc instanceof ScheduleException.ScheduleWritePermissionException) {
            e(nluResponse, TtsGlobalTemplate.GLOBAL02_R11);
            r(CollectionsKt.mutableListOf("android.permission.WRITE_CALENDAR"));
            NlpCompact.a();
        } else if (exc instanceof ScheduleException.ScheduleReadAndWritePermissionException) {
            e(nluResponse, TtsGlobalTemplate.GLOBAL02_R11);
            r(CollectionsKt.mutableListOf("android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"));
            NlpCompact.a();
        } else {
            e(nluResponse, TtsGlobalTemplate.GLOBAL01_P06);
            NlpCompact.a();
        }
    }

    @Subscribe
    public final void onReceiveFlutterScheduleEvent(@NotNull FlutterScheduleEvent flutterScheduleEvent) {
        Schedule schedule;
        Intrinsics.checkNotNullParameter(flutterScheduleEvent, "event");
        JSONObject parseObject = JSON.parseObject(flutterScheduleEvent.a());
        String string = parseObject.getString("id");
        String string2 = parseObject.getString("data");
        NluResponse nluResponse = new NluResponse();
        HeaderData headerData = new HeaderData();
        headerData.setName(this.c);
        headerData.setNamespace(VuiModelType.SCHEDULE);
        nluResponse.setHeader(headerData);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("utterance", new JSONObject());
        nluResponse.setPayload(jSONObject);
        EndToEndResponse endToEndResponse = new EndToEndResponse();
        endToEndResponse.setType(CloudResType.NLU_RESULT);
        endToEndResponse.setRequestId(string);
        if (this.d == null || (!Intrinsics.areEqual((Object) this.c, (Object) "Update") && !Intrinsics.areEqual((Object) this.c, (Object) "Delete"))) {
            w(nluResponse);
            endToEndResponse.setPayload(nluResponse);
            AndroidAssistantApiHandler.INSTANCE.mockSendNlpToFlutter(endToEndResponse);
            return;
        }
        List list = this.d;
        Intrinsics.checkNotNull(list);
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                schedule = null;
                break;
            }
            Schedule schedule2 = (Schedule) it.next();
            if (Intrinsics.areEqual((Object) schedule2.getId(), (Object) string2)) {
                schedule = schedule2;
                break;
            }
        }
        if (schedule == null) {
            w(nluResponse);
            endToEndResponse.setPayload(nluResponse);
            AndroidAssistantApiHandler.INSTANCE.mockSendNlpToFlutter(endToEndResponse);
            return;
        }
        if (Intrinsics.areEqual((Object) this.c, (Object) "Delete")) {
            m(this, nluResponse, schedule, (String) null, 4, (Object) null);
            endToEndResponse.setPayload(nluResponse);
        } else {
            ScheduleNlpParam scheduleNlpParam = this.b;
            Intrinsics.checkNotNull(scheduleNlpParam);
            x(nluResponse, schedule, scheduleNlpParam);
            endToEndResponse.setPayload(nluResponse);
        }
        AndroidAssistantApiHandler.INSTANCE.mockSendNlpToFlutter(endToEndResponse);
    }

    /* JADX WARNING: type inference failed for: r15v0, types: [java.lang.String[]] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void q(java.lang.String r13, java.lang.String r14, java.lang.String[] r15) {
        /*
            r12 = this;
            int r2 = r13.hashCode()
            java.lang.String r3 = ","
            r6 = 604800000(0x240c8400, double:2.988109026E-315)
            r8 = 2
            java.lang.String r9 = ""
            r10 = 0
            r11 = 1
            switch(r2) {
                case -1822154468: goto L_0x0113;
                case -1754979095: goto L_0x00d6;
                case 2026540316: goto L_0x0076;
                case 2043376075: goto L_0x0013;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x011b
        L_0x0013:
            java.lang.String r2 = "Delete"
            boolean r0 = r13.equals(r2)
            if (r0 != 0) goto L_0x001d
            goto L_0x011b
        L_0x001d:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r14)
            if (r0 == 0) goto L_0x0041
            java.util.Date r0 = new java.util.Date
            r0.<init>()
            com.xjsd.ai.assistant.skill.schedule.ScheduleUtils r1 = com.xjsd.ai.assistant.skill.schedule.ScheduleUtils.f8700a
            long r2 = r0.getTime()
            java.lang.String r2 = r1.e(r2)
            r15[r10] = r2
            long r2 = r0.getTime()
            long r2 = r2 + r6
            java.lang.String r0 = r1.e(r2)
            r15[r11] = r0
            goto L_0x0175
        L_0x0041:
            java.lang.String[] r2 = new java.lang.String[]{r3}
            r4 = 6
            r5 = 0
            r3 = 0
            r9 = 0
            r0 = r14
            r1 = r2
            r2 = r3
            r3 = r9
            java.util.List r0 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r0, (java.lang.String[]) r1, (boolean) r2, (int) r3, (int) r4, (java.lang.Object) r5)
            java.lang.Object r1 = r0.get(r10)
            java.lang.String r1 = (java.lang.String) r1
            r15[r10] = r1
            int r2 = r0.size()
            if (r2 != r8) goto L_0x0067
            java.lang.Object r0 = r0.get(r11)
            r15[r11] = r0
            goto L_0x0175
        L_0x0067:
            com.xjsd.ai.assistant.skill.schedule.ScheduleUtils r0 = com.xjsd.ai.assistant.skill.schedule.ScheduleUtils.f8700a
            long r1 = r0.d(r1)
            long r1 = r1 + r6
            java.lang.String r0 = r0.e(r1)
            r15[r11] = r0
            goto L_0x0175
        L_0x0076:
            java.lang.String r2 = "Create"
            boolean r0 = r13.equals(r2)
            if (r0 != 0) goto L_0x0080
            goto L_0x011b
        L_0x0080:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r14)
            if (r0 != 0) goto L_0x00d0
            java.lang.String r0 = "00:00:00"
            r2 = 0
            boolean r0 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r14, (java.lang.CharSequence) r0, (boolean) r10, (int) r8, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x0098
            java.lang.String r0 = "23:59:59"
            boolean r0 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r14, (java.lang.CharSequence) r0, (boolean) r10, (int) r8, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x0098
            goto L_0x00d0
        L_0x0098:
            java.lang.String[] r2 = new java.lang.String[]{r3}
            r4 = 6
            r5 = 0
            r3 = 0
            r6 = 0
            r0 = r14
            r1 = r2
            r2 = r3
            r3 = r6
            java.util.List r0 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r0, (java.lang.String[]) r1, (boolean) r2, (int) r3, (int) r4, (java.lang.Object) r5)
            java.lang.Object r1 = r0.get(r10)
            java.lang.String r1 = (java.lang.String) r1
            r15[r10] = r1
            int r2 = r0.size()
            if (r2 != r8) goto L_0x00be
            java.lang.Object r0 = r0.get(r11)
            r15[r11] = r0
            goto L_0x0175
        L_0x00be:
            com.xjsd.ai.assistant.skill.schedule.ScheduleUtils r0 = com.xjsd.ai.assistant.skill.schedule.ScheduleUtils.f8700a
            long r1 = r0.d(r1)
            r3 = 3600000(0x36ee80, double:1.7786363E-317)
            long r1 = r1 + r3
            java.lang.String r0 = r0.e(r1)
            r15[r11] = r0
            goto L_0x0175
        L_0x00d0:
            r15[r10] = r9
            r15[r11] = r9
            goto L_0x0175
        L_0x00d6:
            java.lang.String r2 = "Update"
            boolean r0 = r13.equals(r2)
            if (r0 != 0) goto L_0x00df
            goto L_0x011b
        L_0x00df:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r14)
            if (r0 == 0) goto L_0x00eb
            r15[r10] = r9
            r15[r11] = r9
            goto L_0x0175
        L_0x00eb:
            java.lang.String[] r2 = new java.lang.String[]{r3}
            r4 = 6
            r5 = 0
            r3 = 0
            r6 = 0
            r0 = r14
            r1 = r2
            r2 = r3
            r3 = r6
            java.util.List r0 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r0, (java.lang.String[]) r1, (boolean) r2, (int) r3, (int) r4, (java.lang.Object) r5)
            java.lang.Object r1 = r0.get(r10)
            java.lang.String r1 = (java.lang.String) r1
            r15[r10] = r1
            int r1 = r0.size()
            if (r1 != r11) goto L_0x010c
            r15[r11] = r9
            goto L_0x0175
        L_0x010c:
            java.lang.Object r0 = r0.get(r11)
            r15[r11] = r0
            goto L_0x0175
        L_0x0113:
            java.lang.String r2 = "Select"
            boolean r0 = r13.equals(r2)
            if (r0 != 0) goto L_0x0120
        L_0x011b:
            r15[r10] = r9
            r15[r11] = r9
            goto L_0x0175
        L_0x0120:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r14)
            if (r0 == 0) goto L_0x0143
            java.util.Date r0 = new java.util.Date
            r0.<init>()
            com.xjsd.ai.assistant.skill.schedule.ScheduleUtils r1 = com.xjsd.ai.assistant.skill.schedule.ScheduleUtils.f8700a
            long r2 = r0.getTime()
            java.lang.String r2 = r1.e(r2)
            r15[r10] = r2
            long r2 = r0.getTime()
            long r2 = r2 + r6
            java.lang.String r0 = r1.e(r2)
            r15[r11] = r0
            goto L_0x0175
        L_0x0143:
            java.lang.String[] r2 = new java.lang.String[]{r3}
            r4 = 6
            r5 = 0
            r3 = 0
            r9 = 0
            r0 = r14
            r1 = r2
            r2 = r3
            r3 = r9
            java.util.List r0 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r0, (java.lang.String[]) r1, (boolean) r2, (int) r3, (int) r4, (java.lang.Object) r5)
            java.lang.Object r1 = r0.get(r10)
            java.lang.String r1 = (java.lang.String) r1
            r15[r10] = r1
            int r2 = r0.size()
            if (r2 != r8) goto L_0x0168
            java.lang.Object r0 = r0.get(r11)
            r15[r11] = r0
            goto L_0x0175
        L_0x0168:
            com.xjsd.ai.assistant.skill.schedule.ScheduleUtils r0 = com.xjsd.ai.assistant.skill.schedule.ScheduleUtils.f8700a
            long r1 = r0.d(r1)
            long r1 = r1 + r6
            java.lang.String r0 = r0.e(r1)
            r15[r11] = r0
        L_0x0175:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.flutter.nlp.ScheduleNlpPreprocessor.q(java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    public final void r(List list) {
        InterconnectAbility interconnectAbility = (InterconnectAbility) AbilityManager.b.b(InterconnectAbility.class);
        if (interconnectAbility != null) {
            interconnectAbility.getOperatorManager().getSappAbilityOperator().requestPermission(list, (IPermissonResult) null);
        }
    }

    public final void s() {
        t((Schedule) null);
        u((ScheduleNlpParam) null);
        this.c = null;
        this.d = null;
    }

    public final void t(Schedule schedule) {
        this.f8490a = schedule;
        if (schedule != null) {
            String e2 = GsonUtils.e(schedule);
            ILog.a("ScheduleNlpPreprocessor", "上下文日程->" + e2);
        }
    }

    public final void u(ScheduleNlpParam scheduleNlpParam) {
        this.b = scheduleNlpParam;
        if (scheduleNlpParam != null) {
            String e2 = GsonUtils.e(scheduleNlpParam);
            ILog.a("ScheduleNlpPreprocessor", "修改日程参数->" + e2);
        }
    }

    public void v(NluResponse nluResponse) {
        NlpPreprocessor.DefaultImpls.g(this, nluResponse);
    }

    public void w(NluResponse nluResponse) {
        NlpPreprocessor.DefaultImpls.h(this, nluResponse);
    }

    public final void x(NluResponse nluResponse, Schedule schedule, ScheduleNlpParam scheduleNlpParam) {
        String e2 = GsonUtils.e(schedule);
        String e3 = GsonUtils.e(scheduleNlpParam);
        ILog.a("ScheduleNlpPreprocessor", "updateSchedule: schedule->" + e2 + ",param->" + e3);
        if (!Intrinsics.areEqual((Object) scheduleNlpParam.getStartTime(), (Object) "") || !Intrinsics.areEqual((Object) scheduleNlpParam.getEndTime(), (Object) "") || !Intrinsics.areEqual((Object) scheduleNlpParam.getTarget(), (Object) "") || !Intrinsics.areEqual((Object) scheduleNlpParam.getDuration(), (Object) "")) {
            z(scheduleNlpParam.getStartTime());
            z(scheduleNlpParam.getEndTime());
            s();
            Schedule b2 = ScheduleModifyProcessor.b.b(scheduleNlpParam, schedule);
            ScheduleRepository scheduleRepository = ScheduleRepository.f8699a;
            if (scheduleRepository.f(b2)) {
                long parseLong = Long.parseLong(b2.getId());
                if (b2.isRepeatSchedule() && b2.getDtEnd() == null) {
                    b2.setDtEnd(Long.valueOf(b2.getDtStart() + (((long) b2.parseDurationValue(b2.getDuration())) * 1000)));
                }
                long dtStart = b2.getDtStart();
                Long dtEnd = b2.getDtEnd();
                Intrinsics.checkNotNull(dtEnd);
                Schedule g = scheduleRepository.g(parseLong, dtStart, dtEnd.longValue());
                if (g != null) {
                    b2 = g;
                }
                t(b2);
                JSONObject payload = nluResponse.getPayload();
                Intrinsics.checkNotNullExpressionValue(payload, "getPayload(...)");
                payload.put("result", GsonUtils.e(CollectionsKt.listOf(this.f8490a)));
                e(nluResponse, TtsCalTemplate.CAL05_R04);
                return;
            }
            e(nluResponse, TtsCalTemplate.CAL05_R05);
            return;
        }
        t(schedule);
        JSONObject payload2 = nluResponse.getPayload();
        Intrinsics.checkNotNullExpressionValue(payload2, "getPayload(...)");
        payload2.put("result", GsonUtils.e(CollectionsKt.listOf(schedule)));
        e(nluResponse, TtsCalTemplate.CAL05_R02);
    }

    public final void y(boolean z) {
        if (ContextHelper.f("android.permission.READ_CALENDAR")) {
            throw new ScheduleException.ScheduleReadPermissionException();
        } else if (!z && ContextHelper.f("android.permission.WRITE_CALENDAR")) {
            throw new ScheduleException.ScheduleWritePermissionException();
        }
    }

    public final void z(String str) {
        if (Intrinsics.areEqual((Object) "past", (Object) str)) {
            throw new ScheduleException.TimePassedException();
        } else if (Intrinsics.areEqual((Object) "invalid", (Object) str)) {
            throw new ScheduleException.TimeFormatException();
        }
    }
}
