package org.slf4j.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

public class SubstituteLoggerFactory implements ILoggerFactory {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f3464a = false;
    public final Map b = new ConcurrentHashMap();
    public final LinkedBlockingQueue c = new LinkedBlockingQueue();

    public void a() {
        this.b.clear();
        this.c.clear();
    }

    public LinkedBlockingQueue b() {
        return this.c;
    }

    public List c() {
        return new ArrayList(this.b.values());
    }

    public void d() {
        this.f3464a = true;
    }

    public synchronized Logger getLogger(String str) {
        SubstituteLogger substituteLogger;
        substituteLogger = (SubstituteLogger) this.b.get(str);
        if (substituteLogger == null) {
            substituteLogger = new SubstituteLogger(str, this.c, this.f3464a);
            this.b.put(str, substituteLogger);
        }
        return substituteLogger;
    }
}
