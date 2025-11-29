package com.xjsd.ai.assistant.asr.engine;

import com.xjsd.ai.assistant.asr.engine.protocol.AsrCloudResponse;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/xjsd/ai/assistant/asr/engine/AsrWsClientListener;", "", "Lcom/xjsd/ai/assistant/asr/engine/protocol/AsrCloudResponse;", "response", "", "a", "(Lcom/xjsd/ai/assistant/asr/engine/protocol/AsrCloudResponse;)V", "", "code", "", "msg", "onError", "(ILjava/lang/String;)V", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public interface AsrWsClientListener {
    void a(AsrCloudResponse asrCloudResponse);

    void onError(int i, String str);
}
