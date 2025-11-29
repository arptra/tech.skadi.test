package com.xjsd.ai.assistant.asr.engine;

import android.text.TextUtils;
import com.xjsd.ai.assistant.asr.AsrEventListener;
import com.xjsd.ai.assistant.asr.bean.AsrResult;
import com.xjsd.ai.assistant.asr.engine.protocol.AsrCloudResponse;
import com.xjsd.ai.assistant.asr.engine.protocol.VadInfo;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.xr.sapp.asr.constants.AsrConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\b\b\u0001\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"com/xjsd/ai/assistant/asr/engine/AsrEngineImpl$mAsrWsClientListener$1", "Lcom/xjsd/ai/assistant/asr/engine/AsrWsClientListener;", "Lcom/xjsd/ai/assistant/asr/engine/protocol/AsrCloudResponse;", "response", "", "a", "(Lcom/xjsd/ai/assistant/asr/engine/protocol/AsrCloudResponse;)V", "", "code", "", "msg", "onError", "(ILjava/lang/String;)V", "id", "text", "type", "b", "(Ljava/lang/String;Ljava/lang/String;I)V", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AsrEngineImpl$mAsrWsClientListener$1 implements AsrWsClientListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AsrEngineImpl f8386a;

    public AsrEngineImpl$mAsrWsClientListener$1(AsrEngineImpl asrEngineImpl) {
        this.f8386a = asrEngineImpl;
    }

    public void a(AsrCloudResponse asrCloudResponse) {
        Intrinsics.checkNotNullParameter(asrCloudResponse, "response");
        String event = asrCloudResponse.getEvent();
        if (event != null) {
            switch (event.hashCode()) {
                case -1935029919:
                    if (!event.equals("sync_audio_info_failed")) {
                        return;
                    }
                    break;
                case -636965025:
                    if (event.equals(AsrConstants.SYNC_AUDIO_INFO_SUCCESS)) {
                        ILog.a("AsrEngineImpl", AsrConstants.SYNC_AUDIO_INFO_SUCCESS);
                        return;
                    }
                    return;
                case 116505:
                    if (event.equals("vad")) {
                        VadInfo vadInfo = asrCloudResponse.getVadInfo();
                        ILog.a("AsrEngineImpl", "云端vad识别结果->" + vadInfo);
                        return;
                    }
                    return;
                case 235005312:
                    if (event.equals(AsrConstants.ASR_RESULT_SUCCESS)) {
                        if (asrCloudResponse.getData() == null || !Intrinsics.areEqual((Object) "0", (Object) asrCloudResponse.getCode())) {
                            b(this.f8386a.d, "", 1);
                            return;
                        } else if (!TextUtils.equals(this.f8386a.d, asrCloudResponse.getRequestId())) {
                            ILog.j("AsrEngineImpl", "requestId与请求时的不一致");
                            return;
                        } else {
                            Boolean finish = asrCloudResponse.getFinish();
                            String requestId = asrCloudResponse.getRequestId();
                            Intrinsics.checkNotNullExpressionValue(requestId, "getRequestId(...)");
                            String text = asrCloudResponse.getData().getText();
                            Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
                            Intrinsics.checkNotNull(finish);
                            b(requestId, text, finish.booleanValue() ? 1 : 0);
                            if (finish.booleanValue()) {
                                this.f8386a.d = "";
                                return;
                            }
                            return;
                        }
                    } else {
                        return;
                    }
                case 1198953831:
                    if (!event.equals("connection_error")) {
                        return;
                    }
                    break;
                case 1972423456:
                    if (!event.equals("asr_result_failed")) {
                        return;
                    }
                    break;
                default:
                    return;
            }
            AsrEventListener a2 = this.f8386a.e;
            if (a2 != null) {
                a2.a(this.f8386a.d, asrCloudResponse.getCode());
            }
        }
    }

    public final void b(String str, String str2, int i) {
        AsrResult asrResult = new AsrResult();
        asrResult.e(str);
        asrResult.f(str2);
        asrResult.g(i);
        AsrEventListener a2 = this.f8386a.e;
        if (a2 != null) {
            a2.b(asrResult);
        }
    }

    public void onError(int i, String str) {
        if (!TextUtils.isEmpty(this.f8386a.d)) {
            AsrEventListener a2 = this.f8386a.e;
            if (a2 != null) {
                a2.a(this.f8386a.d, String.valueOf(i));
            }
            this.f8386a.d = "";
        }
    }
}
