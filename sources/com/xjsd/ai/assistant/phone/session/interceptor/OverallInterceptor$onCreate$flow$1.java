package com.xjsd.ai.assistant.phone.session.interceptor;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.xjsd.ai.assistant.asr.bean.AsrResult;
import com.xjsd.ai.assistant.asr.engine.protocol.AsrCloudResponse;
import com.xjsd.ai.assistant.asr.engine.protocol.VadInfo;
import com.xjsd.ai.assistant.chatgpt.model.LlmResponse;
import com.xjsd.ai.assistant.chatgpt.model.minimax.LlmRecommend;
import com.xjsd.ai.assistant.cloud.CloudAbility;
import com.xjsd.ai.assistant.cloud.CloudEventListener;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.net.ws.protocol.CloudResType;
import com.xjsd.ai.assistant.net.ws.protocol.EndToEndResponse;
import com.xjsd.ai.assistant.nlu.NluDataCreator;
import com.xjsd.ai.assistant.nlu.bean.HeaderData;
import com.xjsd.ai.assistant.nlu.bean.NluResponse;
import com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import com.xjsd.xr.sapp.asr.constants.AsrConstants;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/xjsd/ai/assistant/phone/session/interceptor/OverallInterceptor$CloudResult;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$onCreate$flow$1", f = "OverallInterceptor.kt", i = {}, l = {337}, m = "invokeSuspend", n = {}, s = {})
public final class OverallInterceptor$onCreate$flow$1 extends SuspendLambda implements Function2<ProducerScope<? super OverallInterceptor.CloudResult>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OverallInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OverallInterceptor$onCreate$flow$1(OverallInterceptor overallInterceptor, Continuation<? super OverallInterceptor$onCreate$flow$1> continuation) {
        super(2, continuation);
        this.this$0 = overallInterceptor;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        OverallInterceptor$onCreate$flow$1 overallInterceptor$onCreate$flow$1 = new OverallInterceptor$onCreate$flow$1(this.this$0, continuation);
        overallInterceptor$onCreate$flow$1.L$0 = obj;
        return overallInterceptor$onCreate$flow$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            CloudAbility q = this.this$0.g;
            final OverallInterceptor overallInterceptor = this.this$0;
            q.setCloudEventListener(new CloudEventListener() {
                public void a(String str, String str2) {
                    Intrinsics.checkNotNullParameter(str, AssistantConstants.Key.SESSION_ID);
                    Intrinsics.checkNotNullParameter(str2, "code");
                    producerScope.q(new OverallInterceptor.CloudResult.CloudError(str, str2));
                }

                public void b(byte[] bArr) {
                    Intrinsics.checkNotNullParameter(bArr, "data");
                    ILog.a("OverallInterceptor", "onData: 不处理该二进制数据");
                }

                public void c(EndToEndResponse endToEndResponse) {
                    Intrinsics.checkNotNullParameter(endToEndResponse, "response");
                    if (!Intrinsics.areEqual((Object) endToEndResponse.getRequestId(), (Object) overallInterceptor.d().b())) {
                        ILog.a("OverallInterceptor", "onResponse: 云端返回数据与当前traceId不一致，拦截不处理");
                        return;
                    }
                    String type = endToEndResponse.getType();
                    if (type != null) {
                        switch (type.hashCode()) {
                            case -1996684826:
                                if (type.equals("sensitive_result")) {
                                    ILog.a("OverallInterceptor", "onResponse: 输出违规");
                                    NluResponse nluResponse = new NluResponse();
                                    ProducerScope producerScope = producerScope;
                                    HeaderData headerData = new HeaderData();
                                    headerData.setNamespace("llm");
                                    headerData.setName("default");
                                    nluResponse.setHeader(headerData);
                                    nluResponse.setPayload(new JSONObject());
                                    producerScope.q(new OverallInterceptor.CloudResult.CloudNluResult(nluResponse));
                                    LlmResponse llmResponse = new LlmResponse(0, (String) null, (String) null, false, (String) null, 31, (DefaultConstructorMarker) null);
                                    ProducerScope producerScope2 = producerScope;
                                    llmResponse.setBase_status(3);
                                    producerScope2.q(new OverallInterceptor.CloudResult.CloudLlmResult(llmResponse));
                                    return;
                                }
                                break;
                            case -1899280916:
                                if (type.equals(CloudResType.LLM_ANSWER_RESULT)) {
                                    LlmResponse llmResponse2 = (LlmResponse) endToEndResponse.parsePayload(LlmResponse.class);
                                    ProducerScope producerScope3 = producerScope;
                                    Intrinsics.checkNotNull(llmResponse2);
                                    producerScope3.q(new OverallInterceptor.CloudResult.CloudLlmResult(llmResponse2));
                                    return;
                                }
                                break;
                            case -1769541146:
                                if (type.equals("sensitive_request")) {
                                    ILog.a("OverallInterceptor", "onResponse: 输入违规");
                                    NluResponse a2 = NluDataCreator.a("NLU_INPUT_ERROR");
                                    JSONObject payload = a2.getPayload();
                                    Intrinsics.checkNotNullExpressionValue(payload, "getPayload(...)");
                                    payload.put("tts", ((JSONObject) endToEndResponse.parsePayload(JSONObject.class)).getString("riskDescription"));
                                    ProducerScope producerScope4 = producerScope;
                                    Intrinsics.checkNotNull(a2);
                                    producerScope4.q(new OverallInterceptor.CloudResult.CloudNluResult(a2));
                                    return;
                                }
                                break;
                            case -694846788:
                                if (type.equals("asr_result")) {
                                    AsrCloudResponse asrCloudResponse = (AsrCloudResponse) endToEndResponse.parsePayload(AsrCloudResponse.class);
                                    Intrinsics.checkNotNull(asrCloudResponse);
                                    e(asrCloudResponse);
                                    return;
                                }
                                break;
                            case 634366442:
                                if (type.equals(CloudResType.LLM_RECOMMEND_RESULT)) {
                                    LlmRecommend llmRecommend = (LlmRecommend) endToEndResponse.parsePayload(LlmRecommend.class);
                                    ProducerScope producerScope5 = producerScope;
                                    Intrinsics.checkNotNull(llmRecommend);
                                    producerScope5.q(new OverallInterceptor.CloudResult.CloudLlmRecommendResult(llmRecommend));
                                    return;
                                }
                                break;
                            case 1429442092:
                                if (type.equals(CloudResType.INIT_RESULT)) {
                                    ILog.a("OverallInterceptor", "onResponse: 初始化结果->" + endToEndResponse);
                                    return;
                                }
                                break;
                            case 1622070922:
                                if (type.equals(CloudResType.NLU_RESULT)) {
                                    NluResponse nluResponse2 = (NluResponse) endToEndResponse.parsePayload(NluResponse.class);
                                    overallInterceptor.L("receive_online_nlu", new Pair[0]);
                                    overallInterceptor.K("vad_end", "vad_end->nlu耗时", new Pair[0]);
                                    overallInterceptor.K("receive_final_asr", "asr_final->nlu耗时", new Pair[0]);
                                    ProducerScope producerScope6 = producerScope;
                                    Intrinsics.checkNotNull(nluResponse2);
                                    producerScope6.q(new OverallInterceptor.CloudResult.CloudNluResult(nluResponse2));
                                    return;
                                }
                                break;
                        }
                    }
                    ILog.a("OverallInterceptor", "onResponse: not support");
                }

                public final void d(String str, String str2, int i) {
                    AsrResult asrResult = new AsrResult();
                    ProducerScope producerScope = producerScope;
                    asrResult.e(str);
                    asrResult.f(str2);
                    asrResult.g(i);
                    producerScope.q(new OverallInterceptor.CloudResult.CloudAsrResult(asrResult));
                }

                public final void e(AsrCloudResponse asrCloudResponse) {
                    String requestId = asrCloudResponse.getRequestId();
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
                                    ILog.a("OverallInterceptor", AsrConstants.SYNC_AUDIO_INFO_SUCCESS);
                                    return;
                                }
                                return;
                            case 116505:
                                if (event.equals("vad")) {
                                    VadInfo vadInfo = asrCloudResponse.getVadInfo();
                                    ILog.a("OverallInterceptor", "云端vad识别结果->" + vadInfo);
                                    return;
                                }
                                return;
                            case 235005312:
                                if (event.equals(AsrConstants.ASR_RESULT_SUCCESS)) {
                                    if (asrCloudResponse.getData() == null || !Intrinsics.areEqual((Object) "0", (Object) asrCloudResponse.getCode())) {
                                        Intrinsics.checkNotNull(requestId);
                                        d(requestId, "", 1);
                                        return;
                                    } else if (!TextUtils.equals(overallInterceptor.d().b(), asrCloudResponse.getRequestId())) {
                                        ILog.j("OverallInterceptor", "requestId与请求时的不一致");
                                        return;
                                    } else {
                                        Boolean finish = asrCloudResponse.getFinish();
                                        Intrinsics.checkNotNull(finish);
                                        if (finish.booleanValue()) {
                                            overallInterceptor.L("receive_final_asr", new Pair[0]);
                                        } else if (!overallInterceptor.t.get()) {
                                            overallInterceptor.t.set(true);
                                            overallInterceptor.L("asr_first_frame", new Pair[0]);
                                            overallInterceptor.K("vad_start", "vad start->asr first frame耗时", new Pair[0]);
                                        }
                                        String requestId2 = asrCloudResponse.getRequestId();
                                        Intrinsics.checkNotNullExpressionValue(requestId2, "getRequestId(...)");
                                        String text = asrCloudResponse.getData().getText();
                                        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
                                        d(requestId2, text, finish.booleanValue() ? 1 : 0);
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
                        Intrinsics.checkNotNull(requestId);
                        String code = asrCloudResponse.getCode();
                        Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                        a(requestId, code);
                    }
                }
            });
            final OverallInterceptor overallInterceptor2 = this.this$0;
            AnonymousClass2 r1 = new Function0<Unit>() {
                public final void invoke() {
                    overallInterceptor2.g.setCloudEventListener((CloudEventListener) null);
                }
            };
            this.label = 1;
            if (ProduceKt.a(producerScope, r1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super OverallInterceptor.CloudResult> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((OverallInterceptor$onCreate$flow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
