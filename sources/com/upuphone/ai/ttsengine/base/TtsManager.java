package com.upuphone.ai.ttsengine.base;

import android.app.Application;
import com.upuphone.ai.ttsengine.base.enums.TtsAgentType;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class TtsManager {
    public static volatile TtsManager f;

    /* renamed from: a  reason: collision with root package name */
    public final AILOG f5492a = AILOG.a("TtsManager");
    public final Map b = new ConcurrentHashMap();
    public AtomicBoolean c = new AtomicBoolean(false);
    public boolean d = false;
    public boolean e = false;

    public static TtsManager c() {
        if (f == null) {
            synchronized (TtsManager.class) {
                try {
                    if (f == null) {
                        f = new TtsManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f;
    }

    public final ITtsAgent a(TtsAgentType ttsAgentType) {
        try {
            String str = "com.upuphone.ai.ttsengine.bytedance.BytedanceTtsAgent";
            if (ttsAgentType != TtsAgentType.BYTEDANCE) {
                if (ttsAgentType == TtsAgentType.LOCAL_FILE) {
                    str = "com.upuphone.ai.ttsengine.engines.wav.FileTtsAgent";
                } else if (ttsAgentType == TtsAgentType.CACHE) {
                    str = "com.upuphone.ai.ttsengine.engines.cache.CacheTtsAgent";
                } else if (ttsAgentType == TtsAgentType.GOOGLE) {
                    str = "com.upuphone.ai.google.GoogleEngine";
                } else if (ttsAgentType == TtsAgentType.CLOUD) {
                    str = "com.upuphone.ai.ttsengine.engines.cloud.CloudEngine";
                }
            }
            return (ITtsAgent) Class.forName(str).newInstance();
        } catch (Exception e2) {
            AILOG ailog = this.f5492a;
            ailog.b("[TtsAgentFactory] Exception=" + e2.getMessage());
            return null;
        }
    }

    public List b() {
        return new ArrayList(this.b.values());
    }

    public void d(Application application, FlavorInterface flavorInterface) {
        this.f5492a.b("init");
        if (this.d) {
            this.f5492a.b("is already initialized");
            return;
        }
        if (this.c.compareAndSet(false, true)) {
            this.f5492a.b("real start init");
            this.e = flavorInterface.a();
            for (TtsAgentType ttsAgentType : flavorInterface.b()) {
                ITtsAgent a2 = a(ttsAgentType);
                if (a2 != null) {
                    a2.init(application);
                    this.b.put(ttsAgentType, a2);
                }
            }
            this.d = true;
            this.c.compareAndSet(true, false);
        }
        this.f5492a.b("init finished");
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        ITtsAgent iTtsAgent;
        Map map = this.b;
        if (map == null) {
            return true;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!(entry == null || (iTtsAgent = (ITtsAgent) entry.getValue()) == null || !iTtsAgent.isSpeaking())) {
                iTtsAgent.stopTTS();
            }
        }
        return true;
    }
}
