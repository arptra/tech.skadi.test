package com.upuphone.ai.ttsengine.base.utils;

import android.app.Application;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.p3.a;
import com.honey.account.p3.b;
import com.honey.account.p3.c;
import com.honey.account.p3.d;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u0003R\u001c\u0010 \u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R \u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0%8\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R0\u0010.\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020*0)j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020*`+8\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u00100R\u0018\u00103\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u00102R\u0018\u00106\u001a\u0004\u0018\u0001048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u00105R$\u00108\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u00107R\u0018\u0010:\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u00109R\u0016\u0010=\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006>"}, d2 = {"Lcom/upuphone/ai/ttsengine/base/utils/AudioFocusManager;", "", "<init>", "()V", "Landroid/app/Application;", "application", "", "j", "(Landroid/app/Application;)V", "Lkotlin/Function1;", "", "listener", "f", "(Lkotlin/jvm/functions/Function1;)V", "", "source", "focusType", "q", "(Ljava/lang/String;I)V", "", "delayed", "o", "(Ljava/lang/String;Z)V", "g", "(Ljava/lang/String;)V", "i", "(I)V", "h", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "kotlin.jvm.PlatformType", "b", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "aiLog", "Landroid/os/Handler;", "c", "Landroid/os/Handler;", "mTtsHandler", "Ljava/util/concurrent/ConcurrentHashMap;", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "mFocusSources", "Ljava/util/HashMap;", "Ljava/lang/Runnable;", "Lkotlin/collections/HashMap;", "e", "Ljava/util/HashMap;", "mReleasingFocusSources", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "mOnAudioFocusChangeListener", "Ljava/lang/Runnable;", "mReleaseFocusRunnable", "Landroid/media/AudioFocusRequest;", "Landroid/media/AudioFocusRequest;", "mFocusRequest", "Lkotlin/jvm/functions/Function1;", "mListener", "Landroid/app/Application;", "context", "k", "Z", "isHoldAudio", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AudioFocusManager {

    /* renamed from: a  reason: collision with root package name */
    public static final AudioFocusManager f5525a = new AudioFocusManager();
    public static final AILOG b = AILOG.a("AudioFocusManager");
    public static final Handler c = new Handler(Looper.getMainLooper());
    public static final ConcurrentHashMap d = new ConcurrentHashMap();
    public static final HashMap e = new HashMap();
    public static AudioManager.OnAudioFocusChangeListener f;
    public static Runnable g;
    public static AudioFocusRequest h;
    public static Function1 i;
    public static Application j;
    public static volatile boolean k;

    public static final void k(int i2) {
        AILOG ailog = b;
        ailog.m("onAudioFocusChange: " + i2, new Object[0]);
        if (i2 == -3) {
            ailog.c("==<audio>==> voice service onAudioFocusChange : AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK", new Object[0]);
        } else if (i2 == -2) {
            ailog.c("==<audio>==> voice service onAudioFocusChange : AUDIOFOCUS_LOSS_TRANSIENT", new Object[0]);
            c.post(new d());
        } else if (i2 == -1) {
            ailog.c("==<audio>==> voice service onAudioFocusChange : AUDIOFOCUS_LOSS", new Object[0]);
            c.post(new c());
        } else if (i2 == 1 || i2 == 2) {
            ailog.c("==<audio>==> voice service onAudioFocusChange : AUDIOFOCUS_GAIN", new Object[0]);
            k = true;
        } else {
            ailog.h("un support message", new Object[0]);
        }
        Function1 function1 = i;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(i2));
        }
    }

    public static final void l() {
        f5525a.h();
    }

    public static final void m() {
        f5525a.h();
    }

    public static final void n() {
        f5525a.h();
    }

    public static final void p(ConcurrentHashMap concurrentHashMap, HashMap hashMap, String str) {
        Intrinsics.checkNotNullParameter(concurrentHashMap, "$audioSources");
        Intrinsics.checkNotNullParameter(hashMap, "$releasingFocusSources");
        Intrinsics.checkNotNullParameter(str, "$source");
        AILOG ailog = b;
        int size = concurrentHashMap.size();
        int size2 = hashMap.size();
        ailog.m("Try Abandon audio focus (3s reaches). focus count=" + size + ", releasing focus count=" + size2 + ", source=" + str, new Object[0]);
        Runnable runnable = (Runnable) hashMap.remove(str);
        if (runnable != null) {
            c.removeCallbacks(runnable);
        }
        f5525a.g(str);
    }

    public final void f(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        i = function1;
    }

    public final void g(String str) {
        ConcurrentHashMap concurrentHashMap = d;
        int size = concurrentHashMap.size();
        concurrentHashMap.remove(str);
        int size2 = concurrentHashMap.size();
        if (size <= 0 || size2 > 0 || f == null) {
            AILOG ailog = b;
            ailog.c("release focus but other source need focus too: " + concurrentHashMap, new Object[0]);
            return;
        }
        Handler handler = c;
        Runnable runnable = g;
        Intrinsics.checkNotNull(runnable);
        handler.post(runnable);
    }

    public final void h() {
        AudioFocusRequest audioFocusRequest;
        Application application = j;
        AudioManager audioManager = null;
        Object systemService = application != null ? application.getSystemService("audio") : null;
        if (systemService instanceof AudioManager) {
            audioManager = (AudioManager) systemService;
        }
        if (!(audioManager == null || (audioFocusRequest = h) == null)) {
            Intrinsics.checkNotNull(audioFocusRequest);
            int abandonAudioFocusRequest = audioManager.abandonAudioFocusRequest(audioFocusRequest);
            AILOG ailog = b;
            ailog.c("=== > release audio focus result = " + abandonAudioFocusRequest, new Object[0]);
        }
        d.clear();
        k = false;
    }

    public final void i(int i2) {
        Application application = j;
        Integer num = null;
        Object systemService = application != null ? application.getSystemService("audio") : null;
        AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        AudioFocusRequest.Builder acceptsDelayedFocusGain = new AudioFocusRequest.Builder(i2).setAcceptsDelayedFocusGain(false);
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = f;
        Intrinsics.checkNotNull(onAudioFocusChangeListener);
        AudioFocusRequest build = acceptsDelayedFocusGain.setOnAudioFocusChangeListener(onAudioFocusChangeListener).build();
        h = build;
        if (audioManager != null) {
            Intrinsics.checkNotNull(build);
            num = Integer.valueOf(audioManager.requestAudioFocus(build));
        }
        AILOG ailog = b;
        ailog.c("=== > request audio focus result = " + num, new Object[0]);
        if (num != null && num.intValue() == 1) {
            k = true;
        } else {
            k = false;
        }
    }

    public final void j(Application application) {
        Intrinsics.checkNotNullParameter(application, VuiModelType.APPLICATION);
        j = application;
        f = new a();
        g = new b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x011a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void o(java.lang.String r8, boolean r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.String r0 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)     // Catch:{ all -> 0x0046 }
            com.upuphone.ai.ttsengine.base.utils.AILOG r0 = b     // Catch:{ all -> 0x0046 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0046 }
            r1.<init>()     // Catch:{ all -> 0x0046 }
            java.lang.String r2 = "release focus for source: "
            r1.append(r2)     // Catch:{ all -> 0x0046 }
            r1.append(r8)     // Catch:{ all -> 0x0046 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0046 }
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x0046 }
            r0.c(r1, r3)     // Catch:{ all -> 0x0046 }
            java.util.concurrent.ConcurrentHashMap r1 = d     // Catch:{ all -> 0x0046 }
            java.util.HashMap r3 = e     // Catch:{ all -> 0x0046 }
            boolean r4 = r1.containsKey(r8)     // Catch:{ all -> 0x0046 }
            if (r4 != 0) goto L_0x0049
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0046 }
            r9.<init>()     // Catch:{ all -> 0x0046 }
            java.lang.String r1 = "source: "
            r9.append(r1)     // Catch:{ all -> 0x0046 }
            r9.append(r8)     // Catch:{ all -> 0x0046 }
            java.lang.String r8 = " has not request"
            r9.append(r8)     // Catch:{ all -> 0x0046 }
            java.lang.String r8 = r9.toString()     // Catch:{ all -> 0x0046 }
            java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch:{ all -> 0x0046 }
            r0.c(r8, r9)     // Catch:{ all -> 0x0046 }
            monitor-exit(r7)
            return
        L_0x0046:
            r8 = move-exception
            goto L_0x011b
        L_0x0049:
            java.lang.Object r4 = r1.get(r8)     // Catch:{ all -> 0x0046 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x0046 }
            if (r4 != 0) goto L_0x0055
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0046 }
        L_0x0055:
            int r4 = r4.intValue()     // Catch:{ all -> 0x0046 }
            r5 = 1
            if (r4 <= r5) goto L_0x0095
            java.lang.Object r9 = r1.get(r8)     // Catch:{ all -> 0x0046 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0046 }
            r3.<init>()     // Catch:{ all -> 0x0046 }
            java.lang.String r4 = "source: "
            r3.append(r4)     // Catch:{ all -> 0x0046 }
            r3.append(r8)     // Catch:{ all -> 0x0046 }
            java.lang.String r4 = " has count = "
            r3.append(r4)     // Catch:{ all -> 0x0046 }
            r3.append(r9)     // Catch:{ all -> 0x0046 }
            java.lang.String r9 = r3.toString()     // Catch:{ all -> 0x0046 }
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x0046 }
            r0.c(r9, r3)     // Catch:{ all -> 0x0046 }
            java.lang.Object r9 = r1.get(r8)     // Catch:{ all -> 0x0046 }
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ all -> 0x0046 }
            if (r9 == 0) goto L_0x008c
            int r9 = r9.intValue()     // Catch:{ all -> 0x0046 }
            int r2 = r9 + -1
        L_0x008c:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0046 }
            r1.put(r8, r9)     // Catch:{ all -> 0x0046 }
            monitor-exit(r7)
            return
        L_0x0095:
            if (r9 != 0) goto L_0x00d6
            int r9 = r1.size()     // Catch:{ all -> 0x0046 }
            int r1 = r3.size()     // Catch:{ all -> 0x0046 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0046 }
            r4.<init>()     // Catch:{ all -> 0x0046 }
            java.lang.String r5 = "Try releaseAudioFocus immediately. focus count="
            r4.append(r5)     // Catch:{ all -> 0x0046 }
            r4.append(r9)     // Catch:{ all -> 0x0046 }
            java.lang.String r9 = ", releasing focus count="
            r4.append(r9)     // Catch:{ all -> 0x0046 }
            r4.append(r1)     // Catch:{ all -> 0x0046 }
            java.lang.String r9 = ", source="
            r4.append(r9)     // Catch:{ all -> 0x0046 }
            r4.append(r8)     // Catch:{ all -> 0x0046 }
            java.lang.String r9 = r4.toString()     // Catch:{ all -> 0x0046 }
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x0046 }
            r0.c(r9, r1)     // Catch:{ all -> 0x0046 }
            java.lang.Object r9 = r3.remove(r8)     // Catch:{ all -> 0x0046 }
            java.lang.Runnable r9 = (java.lang.Runnable) r9     // Catch:{ all -> 0x0046 }
            if (r9 == 0) goto L_0x00d2
            android.os.Handler r0 = c     // Catch:{ all -> 0x0046 }
            r0.removeCallbacks(r9)     // Catch:{ all -> 0x0046 }
        L_0x00d2:
            r7.g(r8)     // Catch:{ all -> 0x0046 }
            goto L_0x0119
        L_0x00d6:
            boolean r9 = r3.containsKey(r8)     // Catch:{ all -> 0x0046 }
            if (r9 != 0) goto L_0x0119
            int r9 = r1.size()     // Catch:{ all -> 0x0046 }
            int r4 = r3.size()     // Catch:{ all -> 0x0046 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0046 }
            r5.<init>()     // Catch:{ all -> 0x0046 }
            java.lang.String r6 = "Try releaseAudioFocus Continue audio focus for 3s more. focus count="
            r5.append(r6)     // Catch:{ all -> 0x0046 }
            r5.append(r9)     // Catch:{ all -> 0x0046 }
            java.lang.String r9 = ", releasing focus count="
            r5.append(r9)     // Catch:{ all -> 0x0046 }
            r5.append(r4)     // Catch:{ all -> 0x0046 }
            java.lang.String r9 = ", source="
            r5.append(r9)     // Catch:{ all -> 0x0046 }
            r5.append(r8)     // Catch:{ all -> 0x0046 }
            java.lang.String r9 = r5.toString()     // Catch:{ all -> 0x0046 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0046 }
            r0.c(r9, r2)     // Catch:{ all -> 0x0046 }
            com.honey.account.p3.e r9 = new com.honey.account.p3.e     // Catch:{ all -> 0x0046 }
            r9.<init>(r1, r3, r8)     // Catch:{ all -> 0x0046 }
            r3.put(r8, r9)     // Catch:{ all -> 0x0046 }
            android.os.Handler r8 = c     // Catch:{ all -> 0x0046 }
            r0 = 3000(0xbb8, double:1.482E-320)
            r8.postDelayed(r9, r0)     // Catch:{ all -> 0x0046 }
        L_0x0119:
            monitor-exit(r7)
            return
        L_0x011b:
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.ttsengine.base.utils.AudioFocusManager.o(java.lang.String, boolean):void");
    }

    public final synchronized void q(String str, int i2) {
        try {
            Intrinsics.checkNotNullParameter(str, "source");
            AILOG ailog = b;
            ailog.c("request for source: " + str, new Object[0]);
            Runnable runnable = (Runnable) e.remove(str);
            if (runnable != null) {
                c.removeCallbacks(runnable);
            }
            ConcurrentHashMap concurrentHashMap = d;
            int size = concurrentHashMap.size();
            Integer num = (Integer) concurrentHashMap.get(str);
            int i3 = 1;
            if (num != null) {
                i3 = 1 + num.intValue();
            }
            concurrentHashMap.put(str, Integer.valueOf(i3));
            int size2 = concurrentHashMap.size();
            if (k) {
                if (size > 0 || size2 <= 0) {
                    ailog.c("other source has already has focus", new Object[0]);
                }
            }
            Runnable runnable2 = g;
            if (runnable2 != null) {
                Handler handler = c;
                Intrinsics.checkNotNull(runnable2);
                handler.removeCallbacks(runnable2);
            }
            i(i2);
        } catch (Throwable th) {
            throw th;
        }
    }
}
