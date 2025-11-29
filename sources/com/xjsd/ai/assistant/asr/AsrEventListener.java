package com.xjsd.ai.assistant.asr;

import com.xjsd.ai.assistant.asr.bean.AsrResult;

public interface AsrEventListener {
    void a(String str, String str2);

    void b(AsrResult asrResult);
}
