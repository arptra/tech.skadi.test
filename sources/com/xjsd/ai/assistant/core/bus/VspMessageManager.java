package com.xjsd.ai.assistant.core.bus;

import com.xjsd.ai.assistant.core.util.Cabinet;
import java.util.concurrent.atomic.AtomicInteger;

final class VspMessageManager {
    public static VspMessageManager c = new VspMessageManager();

    /* renamed from: a  reason: collision with root package name */
    public Cabinet f8456a = new Cabinet();
    public AtomicInteger b = new AtomicInteger(0);
}
