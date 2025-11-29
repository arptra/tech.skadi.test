package com.xjsd.ai.assistant.phone.helper;

import com.upuphone.xr.interconnect.common.IAIModelResult;
import com.upuphone.xr.interconnect.entity.AIModelResult;
import com.xjsd.ai.assistant.log.ILog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/xjsd/ai/assistant/phone/helper/AssistantProtocolHelper$isUserAgreeLlmAgreement$2$1", "Lcom/upuphone/xr/interconnect/common/IAIModelResult$Stub;", "aiResult", "", "result", "Lcom/upuphone/xr/interconnect/entity/AIModelResult;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AssistantProtocolHelper$isUserAgreeLlmAgreement$2$1 extends IAIModelResult.Stub {
    final /* synthetic */ CancellableContinuation<Boolean> $it;

    public AssistantProtocolHelper$isUserAgreeLlmAgreement$2$1(CancellableContinuation<? super Boolean> cancellableContinuation) {
        this.$it = cancellableContinuation;
    }

    public void aiResult(@Nullable AIModelResult aIModelResult) {
        Unit unit;
        if (aIModelResult != null) {
            CancellableContinuation<Boolean> cancellableContinuation = this.$it;
            int state = aIModelResult.getState();
            ILog.a("AssistantProtocolHelper", "语音助理大模型协议是否授权->" + state);
            if (Integer.parseInt("1") == aIModelResult.getState()) {
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m20constructorimpl(Boolean.TRUE));
            } else {
                Result.Companion companion2 = Result.Companion;
                cancellableContinuation.resumeWith(Result.m20constructorimpl(Boolean.FALSE));
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            CancellableContinuation<Boolean> cancellableContinuation2 = this.$it;
            Result.Companion companion3 = Result.Companion;
            cancellableContinuation2.resumeWith(Result.m20constructorimpl(Boolean.FALSE));
        }
    }
}
