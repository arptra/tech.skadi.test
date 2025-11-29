package org.java_websocket.util;

import com.meizu.common.util.LunarCalendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedThreadFactory implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final ThreadFactory f3409a = Executors.defaultThreadFactory();
    public final AtomicInteger b = new AtomicInteger(1);
    public final String c;

    public NamedThreadFactory(String str) {
        this.c = str;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f3409a.newThread(runnable);
        newThread.setName(this.c + LunarCalendar.DATE_SEPARATOR + this.b);
        return newThread;
    }
}
