package com.honey.account.p3;

import com.upuphone.ai.ttsengine.base.utils.AudioFocusManager;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConcurrentHashMap f5021a;
    public final /* synthetic */ HashMap b;
    public final /* synthetic */ String c;

    public /* synthetic */ e(ConcurrentHashMap concurrentHashMap, HashMap hashMap, String str) {
        this.f5021a = concurrentHashMap;
        this.b = hashMap;
        this.c = str;
    }

    public final void run() {
        AudioFocusManager.p(this.f5021a, this.b, this.c);
    }
}
