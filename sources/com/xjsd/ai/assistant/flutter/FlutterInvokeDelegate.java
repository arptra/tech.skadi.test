package com.xjsd.ai.assistant.flutter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xjsd.ai.assistant.flutter.AndroidAssistantApi;
import com.xjsd.ai.assistant.flutter.event.FlutterNavigationEvent;
import com.xjsd.ai.assistant.flutter.event.FlutterScheduleEvent;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/FlutterInvokeDelegate;", "", "<init>", "()V", "Lcom/xjsd/ai/assistant/flutter/AndroidAssistantApi$InvokeRequest;", "request", "Lcom/xjsd/ai/assistant/flutter/AndroidAssistantApi$Result;", "Lcom/xjsd/ai/assistant/flutter/AndroidAssistantApi$InvokeResult;", "result", "", "a", "(Lcom/xjsd/ai/assistant/flutter/AndroidAssistantApi$InvokeRequest;Lcom/xjsd/ai/assistant/flutter/AndroidAssistantApi$Result;)V", "Lcom/xjsd/ai/assistant/flutter/FlutterTtsPlayManager2;", "b", "Lcom/xjsd/ai/assistant/flutter/FlutterTtsPlayManager2;", "flutterTtsPlayManager", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class FlutterInvokeDelegate {

    /* renamed from: a  reason: collision with root package name */
    public static final FlutterInvokeDelegate f8477a = new FlutterInvokeDelegate();
    public static final FlutterTtsPlayManager2 b = new FlutterTtsPlayManager2();

    public final void a(AndroidAssistantApi.InvokeRequest invokeRequest, AndroidAssistantApi.Result result) {
        String str;
        Intrinsics.checkNotNullParameter(invokeRequest, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        String b2 = invokeRequest.b();
        String c = invokeRequest.c();
        Intrinsics.checkNotNullExpressionValue(c, "getTarget(...)");
        switch (c.hashCode()) {
            case -1778357315:
                if (c.equals("stopPlayTts")) {
                    ILog.a("FlutterInvokeDelegate", "invokeGenericMethod: 停止tts播报->" + b2);
                    if (b2 != null) {
                        b.h(b2);
                    }
                    AndroidAssistantApi.InvokeResult invokeResult = new AndroidAssistantApi.InvokeResult();
                    invokeResult.b(200L);
                    invokeResult.c("好的");
                    result.success(invokeResult);
                    return;
                }
                break;
            case -532015082:
                if (c.equals("startNavigation")) {
                    ILog.a("FlutterInvokeDelegate", "invokeGenericMethod: 发起导航->" + b2);
                    if (b2 != null) {
                        EventBus.c().k(new FlutterNavigationEvent(b2));
                        AndroidAssistantApi.InvokeResult invokeResult2 = new AndroidAssistantApi.InvokeResult();
                        invokeResult2.b(200L);
                        invokeResult2.c("好的");
                        result.success(invokeResult2);
                        return;
                    }
                    return;
                }
                break;
            case -493583841:
                if (c.equals("playTts")) {
                    ILog.a("FlutterInvokeDelegate", "invokeGenericMethod: 播报tts->" + b2);
                    if (b2 != null) {
                        JSONObject parseObject = JSON.parseObject(b2);
                        if (Intrinsics.areEqual((Object) parseObject.getString("name"), (Object) "MediaDirective") || Intrinsics.areEqual((Object) parseObject.getString("namespace"), (Object) VuiModelType.MEDIA)) {
                            ILog.a("FlutterInvokeDelegate", "invokeGenericMethod: 音乐控制指令，特殊处理，拦截播报");
                            String string = parseObject.getString("id");
                            if (string == null) {
                                string = UUID.randomUUID().toString();
                                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                            } else {
                                Intrinsics.checkNotNull(string);
                            }
                            AndroidAssistantApi.InvokeResult invokeResult3 = new AndroidAssistantApi.InvokeResult();
                            invokeResult3.b(200L);
                            invokeResult3.c(string);
                            result.success(invokeResult3);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("id", (Object) string);
                            jSONObject.put("state", (Object) "tts_play_error");
                            AndroidAssistantApi.NotifyEvent notifyEvent = new AndroidAssistantApi.NotifyEvent();
                            notifyEvent.c("tts_play_state");
                            notifyEvent.b(jSONObject.toJSONString());
                            AndroidAssistantApiHandler.INSTANCE.broadcastEventToFlutter(notifyEvent);
                            return;
                        }
                        try {
                            String string2 = parseObject.getString("id");
                            String string3 = parseObject.getString("text");
                            int intValue = parseObject.getIntValue("playMode");
                            FlutterTtsPlayManager2 flutterTtsPlayManager2 = b;
                            Intrinsics.checkNotNull(string2);
                            Intrinsics.checkNotNull(string3);
                            str = flutterTtsPlayManager2.f(string2, string3, intValue);
                        } catch (Exception unused) {
                            String uuid = UUID.randomUUID().toString();
                            Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
                            str = FlutterTtsPlayManager2.g(b, uuid, b2, 0, 4, (Object) null);
                        }
                        AndroidAssistantApi.InvokeResult invokeResult4 = new AndroidAssistantApi.InvokeResult();
                        invokeResult4.b(200L);
                        invokeResult4.c(str);
                        result.success(invokeResult4);
                        return;
                    }
                    return;
                }
                break;
            case 254373811:
                if (c.equals("selectSchedule")) {
                    ILog.a("FlutterInvokeDelegate", "invokeGenericMethod: 点击选择日程->" + b2);
                    if (b2 != null) {
                        EventBus.c().k(new FlutterScheduleEvent(b2));
                    }
                    AndroidAssistantApi.InvokeResult invokeResult5 = new AndroidAssistantApi.InvokeResult();
                    invokeResult5.b(200L);
                    invokeResult5.c("好的");
                    result.success(invokeResult5);
                    return;
                }
                break;
        }
        ILog.a("FlutterInvokeDelegate", "invokeGenericMethod: 当前不支持->" + c);
        AndroidAssistantApi.InvokeResult invokeResult6 = new AndroidAssistantApi.InvokeResult();
        invokeResult6.b(500L);
        invokeResult6.c("当前不支持此调用");
        result.success(invokeResult6);
    }
}
