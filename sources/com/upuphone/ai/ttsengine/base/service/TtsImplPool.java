package com.upuphone.ai.ttsengine.base.service;

import android.content.Context;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import java.util.HashMap;
import java.util.Map;

public class TtsImplPool {
    public static volatile TtsImplPool d;

    /* renamed from: a  reason: collision with root package name */
    public final AILOG f5515a = AILOG.a("TtsImplPool");
    public final Context b;
    public final Map c;

    public TtsImplPool(Context context) {
        this.b = context;
        this.c = new HashMap();
    }

    public static TtsImplPool b(Context context) {
        if (d == null) {
            synchronized (TtsImplPool.class) {
                try {
                    if (d == null) {
                        d = new TtsImplPool(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    public synchronized TtsImpl a(String str) {
        TtsImpl ttsImpl;
        try {
            ttsImpl = (TtsImpl) this.c.get(str);
            if (ttsImpl == null) {
                ttsImpl = new TtsImpl(this.b, str);
                this.c.put(str, ttsImpl);
            }
            AILOG ailog = this.f5515a;
            ailog.b("createImpl: " + ttsImpl);
        } catch (Throwable th) {
            throw th;
        }
        return ttsImpl;
    }
}
