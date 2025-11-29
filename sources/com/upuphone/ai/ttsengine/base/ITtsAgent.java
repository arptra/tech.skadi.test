package com.upuphone.ai.ttsengine.base;

import android.app.Application;
import com.upuphone.ai.ttsengine.base.bean.CacheKey;
import com.upuphone.ai.ttsengine.base.enums.TtsAgentType;
import com.upuphone.ai.ttsengine.base.utils.AgentUtils;
import java.util.List;

public interface ITtsAgent {
    TtsAgentType getAgentType();

    int getPriority() {
        return AgentUtils.a(getAgentType());
    }

    boolean init(Application application);

    boolean isSpeaking();

    boolean isSupport(CacheKey cacheKey);

    void prepare();

    void reload() {
    }

    boolean setAudioAttributes(int i, int i2);

    boolean setListener(ITtsStatusListener iTtsStatusListener);

    boolean setParam(int i, int i2);

    boolean setParam(int i, String str);

    boolean startSpeak(List list, int i);

    boolean stopTTS();
}
