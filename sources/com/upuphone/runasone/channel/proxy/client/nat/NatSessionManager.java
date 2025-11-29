package com.upuphone.runasone.channel.proxy.client.nat;

import com.upuphone.runasone.channel.proxy.client.util.DebugLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class NatSessionManager {
    private static final long DUMP_SESSION_INTERVAL = 3000;
    private static final int MAX_SESSION_COUNT = 64;
    private static final long SESSION_TIME_OUT_MS = 120000;
    private static final String TAG = "NatSessionManager";
    private static final List<Short> clearKeys = new ArrayList();
    private static long lastDumpTime;
    private static final LinkedHashMap<Short, NatSession> mSessions = new LinkedHashMap<>();

    private static synchronized void clearExpiredSessions() {
        synchronized (NatSessionManager.class) {
            try {
                clearKeys.clear();
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                for (Map.Entry next : mSessions.entrySet()) {
                    if (currentTimeMillis - ((NatSession) next.getValue()).lastActivityTime.longValue() > 120000) {
                        clearKeys.add((Short) next.getKey());
                        i++;
                    }
                }
                for (Short remove : clearKeys) {
                    mSessions.remove(remove);
                }
                DebugLog.v("%s: session count down all count:%s", TAG, Integer.valueOf(getSessionCount()));
                if (i > 0) {
                    DebugLog.v("%s: session count down expired sessions total：%d", TAG, Integer.valueOf(i));
                }
            } finally {
            }
        }
    }

    public static synchronized void clearSession() {
        synchronized (NatSessionManager.class) {
            LinkedHashMap<Short, NatSession> linkedHashMap = mSessions;
            if (linkedHashMap != null) {
                linkedHashMap.clear();
            }
        }
    }

    public static synchronized NatSession createSession(short s, int i, short s2) {
        NatSession natSession;
        synchronized (NatSessionManager.class) {
            try {
                LinkedHashMap<Short, NatSession> linkedHashMap = mSessions;
                if (linkedHashMap.size() > 64) {
                    clearExpiredSessions();
                }
                natSession = new NatSession();
                natSession.key = s;
                natSession.lastNanoTime = System.nanoTime();
                natSession.remoteIP = i;
                natSession.remotePort = s2;
                natSession.lastActivityTime = Long.valueOf(System.currentTimeMillis());
                linkedHashMap.put(Short.valueOf(s), natSession);
            } catch (Throwable th) {
                throw th;
            }
        }
        return natSession;
    }

    private static void dumpNatSessions() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis >= 0 && currentTimeMillis - lastDumpTime >= DUMP_SESSION_INTERVAL) {
            lastDumpTime = currentTimeMillis;
            LinkedHashMap<Short, NatSession> linkedHashMap = mSessions;
            DebugLog.d("%s: dumpNatSessions(%d): { ", TAG, Integer.valueOf(linkedHashMap.size()));
            for (Map.Entry<Short, NatSession> value : linkedHashMap.entrySet()) {
                DebugLog.d("%s: [%s] \n", TAG, ((NatSession) value.getValue()).toString());
            }
            DebugLog.d("%s: } \n", TAG);
        }
    }

    public static synchronized NatSession getSession(short s) {
        NatSession natSession;
        synchronized (NatSessionManager.class) {
            natSession = mSessions.get(Short.valueOf(s));
        }
        return natSession;
    }

    public static synchronized int getSessionCount() {
        int size;
        synchronized (NatSessionManager.class) {
            size = mSessions.size();
        }
        return size;
    }

    @Deprecated
    public static synchronized void removeSession(NatSession natSession) {
        synchronized (NatSessionManager.class) {
            Short valueOf = Short.valueOf(natSession.key);
            LinkedHashMap<Short, NatSession> linkedHashMap = mSessions;
            DebugLog.d("remove session port=%d and cur session count is %s", valueOf, Integer.valueOf(linkedHashMap.size()));
            linkedHashMap.remove(Short.valueOf(natSession.key));
        }
    }
}
