package com.upuphone.ai.ttsengine.flavor;

import com.upuphone.ai.ttsengine.base.FlavorInterface;
import com.upuphone.ai.ttsengine.base.enums.TtsAgentType;

public final class FlavorManager implements FlavorInterface {

    /* renamed from: a  reason: collision with root package name */
    public static final TtsAgentType[] f5559a = {TtsAgentType.LOCAL_FILE, TtsAgentType.CACHE, TtsAgentType.CLOUD};
    public static final FlavorManager b = new FlavorManager();

    public static FlavorManager c() {
        return b;
    }

    public boolean a() {
        return true;
    }

    public TtsAgentType[] b() {
        return f5559a;
    }
}
