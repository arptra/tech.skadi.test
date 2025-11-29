package com.upuphone.ai.ttsengine;

import android.app.Application;
import android.media.MediaRouter;
import android.os.Bundle;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.ai.ttsengine.base.ITtsAgent;
import com.upuphone.ai.ttsengine.base.TtsManager;
import com.upuphone.ai.ttsengine.base.service.TtsSpeakerImpl;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import com.upuphone.ai.ttsengine.base.utils.AudioFocusManager;
import com.upuphone.ai.ttsengine.base.utils.ExtentionUtilsKt;
import com.upuphone.ai.ttsengine.flavor.FlavorManager;
import com.upuphone.ai.ttsengine.flavor.service.RemoteService;
import com.upuphone.ai.ttsengine.helper.NlgHelper;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.xr.sapp.context.SdkContext;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0001>\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u0003JG\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u001b\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010#\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0000¢\u0006\u0004\b#\u0010$J\u001b\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060%H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'J#\u0010(\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b(\u0010)R\u001c\u0010.\u001a\n +*\u0004\u0018\u00010*0*8\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u001d0/8\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R \u00106\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0016038\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\t0;8\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u00101R\u0014\u0010A\u001a\u00020>8\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020\u00048\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001f\u0010BR\u0016\u0010F\u001a\u00020D8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b&\u0010ER\u0018\u0010H\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010GR\u0018\u0010K\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020L8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010MR\u0018\u0010Q\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010PR\"\u0010T\u001a\u00020\t8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010G\u001a\u0004\bI\u0010R\"\u0004\bS\u0010\fR\u0016\u0010W\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bU\u0010V\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006X"}, d2 = {"Lcom/upuphone/ai/ttsengine/TtsSdk;", "", "<init>", "()V", "Landroid/app/Application;", "context", "", "l", "(Landroid/app/Application;)V", "", "id", "n", "(Ljava/lang/String;)V", "m", "caller", "", "text", "", "queueMode", "Landroid/os/Bundle;", "params", "utteranceId", "Lcom/upuphone/ai/ttsengine/OnStatusChange;", "callback", "", "p", "(Ljava/lang/String;Ljava/lang/CharSequence;ILandroid/os/Bundle;Ljava/lang/String;Lcom/upuphone/ai/ttsengine/OnStatusChange;)Z", "s", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/upuphone/ai/ttsengine/TtsCallback;", "listener", "h", "(Lcom/upuphone/ai/ttsengine/TtsCallback;)Z", "priority", "stopType", "t", "(II)V", "Lkotlin/Result;", "i", "()Ljava/lang/Object;", "j", "(Ljava/lang/String;Landroid/os/Bundle;)Ljava/lang/String;", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "kotlin.jvm.PlatformType", "b", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "aiLog", "", "c", "Ljava/util/List;", "callbacks", "Ljava/util/concurrent/ConcurrentHashMap;", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "callbackMap", "Ljava/util/concurrent/atomic/AtomicBoolean;", "e", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInitializing", "", "f", "routeLimitCaller", "com/upuphone/ai/ttsengine/TtsSdk$statusCallBack$1", "g", "Lcom/upuphone/ai/ttsengine/TtsSdk$statusCallBack$1;", "statusCallBack", "Landroid/app/Application;", "applicationContext", "Lcom/upuphone/ai/ttsengine/base/service/TtsSpeakerImpl;", "Lcom/upuphone/ai/ttsengine/base/service/TtsSpeakerImpl;", "speaker", "Ljava/lang/String;", "timeoutErrorId", "k", "Ljava/lang/CharSequence;", "speakingText", "", "J", "startingTime", "Landroid/media/MediaRouter;", "Landroid/media/MediaRouter;", "mediaRouter", "()Ljava/lang/String;", "setVoiceId$aar_intlRelease", "voiceId", "o", "Z", "hasInitialized", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTtsSdk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TtsSdk.kt\ncom/upuphone/ai/ttsengine/TtsSdk\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,416:1\n1855#2,2:417\n1#3:419\n*S KotlinDebug\n*F\n+ 1 TtsSdk.kt\ncom/upuphone/ai/ttsengine/TtsSdk\n*L\n189#1:417,2\n*E\n"})
public final class TtsSdk {

    /* renamed from: a  reason: collision with root package name */
    public static final TtsSdk f5490a = new TtsSdk();
    public static final AILOG b = AILOG.a("TtsSdk");
    public static final List c = new ArrayList();
    public static final ConcurrentHashMap d = new ConcurrentHashMap();
    public static final AtomicBoolean e = new AtomicBoolean(false);
    public static final List f = CollectionsKt.listOf("com.tts.call", "com.tts.notification", "com.tts.dialog", "com.tts.wechat");
    public static final TtsSdk$statusCallBack$1 g = new TtsSdk$statusCallBack$1();
    public static Application h;
    public static TtsSpeakerImpl i;
    public static String j;
    public static CharSequence k;
    public static long l;
    public static MediaRouter m;
    public static String n = "BV700_streaming";
    public static volatile boolean o;

    public static /* synthetic */ boolean q(TtsSdk ttsSdk, String str, CharSequence charSequence, int i2, Bundle bundle, String str2, OnStatusChange onStatusChange, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            onStatusChange = null;
        }
        return ttsSdk.p(str, charSequence, i2, bundle, str2, onStatusChange);
    }

    public static /* synthetic */ void u(TtsSdk ttsSdk, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        ttsSdk.s(str, str2);
    }

    public final boolean h(TtsCallback ttsCallback) {
        boolean add;
        Intrinsics.checkNotNullParameter(ttsCallback, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        List list = c;
        synchronized (list) {
            add = list.add(ttsCallback);
        }
        return add;
    }

    public final Object i() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            CharSequence charSequence = k;
            if (!(charSequence == null || charSequence.length() <= 0 || l == 0)) {
                SdkContext.f6675a.d().reportEvent("tts_phone", MapsKt.mapOf(TuplesKt.to("content", String.valueOf(k)), TuplesKt.to(RtspHeaders.Values.TIME, String.valueOf(System.currentTimeMillis() - l))));
            }
            k = null;
            l = 0;
            obj = Result.m20constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m20constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m23exceptionOrNullimpl(obj) != null) {
            b.h("dot error occurs", new Object[0]);
        }
        return obj;
    }

    public final String j(String str, Bundle bundle) {
        return NlgHelper.b(bundle.getString("nlg_id"), bundle.getString("function_id"), ExtentionUtilsKt.b(bundle.getBundle("slots")), str);
    }

    public final String k() {
        return n;
    }

    public final void l(Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        AILOG ailog = b;
        ailog.c("start init", new Object[0]);
        if (o) {
            ailog.c("TTS sdk has already been initialized", new Object[0]);
            return;
        }
        AtomicBoolean atomicBoolean = e;
        if (atomicBoolean.compareAndSet(false, true)) {
            h = application;
            AudioFocusManager audioFocusManager = AudioFocusManager.f5525a;
            audioFocusManager.j(application);
            TtsManager.c().d(application, FlavorManager.c());
            i = new TtsSpeakerImpl(application, g);
            RemoteService.f5563a.j(application);
            audioFocusManager.f(TtsSdk$init$1.INSTANCE);
            Object systemService = application.getSystemService("media_router");
            MediaRouter mediaRouter = systemService instanceof MediaRouter ? (MediaRouter) systemService : null;
            m = mediaRouter;
            if (mediaRouter != null) {
                mediaRouter.addCallback(1, new TtsSdk$init$2());
            }
            o = true;
            atomicBoolean.compareAndSet(true, false);
            ailog.c("init finished", new Object[0]);
            return;
        }
        ailog.c("already in starting", new Object[0]);
    }

    public final void m() {
        List<ITtsAgent> b2 = TtsManager.c().b();
        Intrinsics.checkNotNullExpressionValue(b2, "getAllAgents(...)");
        for (ITtsAgent prepare : b2) {
            prepare.prepare();
        }
    }

    public final void n(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        n = str;
    }

    public final boolean o(String str, CharSequence charSequence, int i2, Bundle bundle, String str2) {
        Intrinsics.checkNotNullParameter(str, "caller");
        Intrinsics.checkNotNullParameter(bundle, PayloadConstant.KEY_PARAMS);
        return q(this, str, charSequence, i2, bundle, str2, (OnStatusChange) null, 32, (Object) null);
    }

    /* JADX WARNING: type inference failed for: r9v5, types: [kotlin.Unit] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean p(java.lang.String r13, java.lang.CharSequence r14, int r15, android.os.Bundle r16, java.lang.String r17, com.upuphone.ai.ttsengine.OnStatusChange r18) {
        /*
            r12 = this;
            r1 = r13
            r0 = r14
            r4 = r16
            r2 = r17
            r3 = r18
            java.lang.String r5 = "caller"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r5)
            java.lang.String r5 = "params"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
            com.upuphone.ai.ttsengine.base.utils.AILOG r5 = b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "speak: "
            r6.append(r7)
            r6.append(r14)
            java.lang.String r7 = ", mode: "
            r6.append(r7)
            r7 = r15
            r6.append(r15)
            java.lang.String r8 = ", id: "
            r6.append(r8)
            r6.append(r2)
            java.lang.String r8 = ", caller: "
            r6.append(r8)
            r6.append(r13)
            java.lang.String r6 = r6.toString()
            r8 = 0
            java.lang.Object[] r9 = new java.lang.Object[r8]
            r5.c(r6, r9)
            boolean r6 = o
            if (r6 == 0) goto L_0x00f6
            android.media.MediaRouter r6 = m
            r9 = 0
            if (r6 == 0) goto L_0x0053
            r10 = 1
            android.media.MediaRouter$RouteInfo r6 = r6.getSelectedRoute(r10)
            goto L_0x0054
        L_0x0053:
            r6 = r9
        L_0x0054:
            java.util.List r10 = f
            boolean r10 = r10.contains(r13)
            r11 = 3
            if (r10 == 0) goto L_0x0095
            if (r6 == 0) goto L_0x0066
            int r10 = r6.getDeviceType()
            if (r10 != r11) goto L_0x0066
            goto L_0x0095
        L_0x0066:
            java.lang.String r0 = "selected media route is not bluetooth error"
            java.lang.Object[] r4 = new java.lang.Object[r8]
            r5.h(r0, r4)
            r0 = 14
            if (r3 == 0) goto L_0x0077
            r4 = 2
            r3.a(r4, r0)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
        L_0x0077:
            if (r9 != 0) goto L_0x007e
            com.upuphone.ai.ttsengine.TtsSdk$statusCallBack$1 r3 = g
            r3.onError(r13, r2, r0)
        L_0x007e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "route info: "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r8]
            r5.c(r0, r1)
            return r8
        L_0x0095:
            java.lang.String r5 = "audio_focus_type"
            int r5 = r4.getInt(r5, r11)
            if (r5 == 0) goto L_0x00a2
            com.upuphone.ai.ttsengine.base.utils.AudioFocusManager r6 = com.upuphone.ai.ttsengine.base.utils.AudioFocusManager.f5525a
            r6.q(r13, r5)
        L_0x00a2:
            if (r2 == 0) goto L_0x00ac
            int r5 = r17.length()
            if (r5 <= 0) goto L_0x00ac
        L_0x00aa:
            r5 = r2
            goto L_0x00b5
        L_0x00ac:
            long r5 = java.lang.System.currentTimeMillis()
            java.lang.String r2 = java.lang.String.valueOf(r5)
            goto L_0x00aa
        L_0x00b5:
            if (r3 == 0) goto L_0x00bc
            java.util.concurrent.ConcurrentHashMap r2 = d
            r2.put(r5, r3)
        L_0x00bc:
            com.upuphone.ai.ttsengine.helper.ParamsHelper r2 = com.upuphone.ai.ttsengine.helper.ParamsHelper.f5570a
            android.app.Application r3 = h
            if (r3 != 0) goto L_0x00c8
            java.lang.String r3 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r3 = r9
        L_0x00c8:
            r2.e(r3, r14, r5, r4)
            k = r0
            long r2 = java.lang.System.currentTimeMillis()
            l = r2
            com.upuphone.ai.ttsengine.base.service.TtsSpeakerImpl r2 = i
            if (r2 != 0) goto L_0x00dd
            java.lang.String r2 = "speaker"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r2 = r9
        L_0x00dd:
            if (r0 == 0) goto L_0x00e3
            java.lang.String r9 = r14.toString()
        L_0x00e3:
            r0 = r12
            java.lang.String r3 = r12.j(r9, r4)
            if (r3 != 0) goto L_0x00eb
            return r8
        L_0x00eb:
            r0 = r2
            r1 = r13
            r2 = r3
            r3 = r15
            r4 = r16
            boolean r8 = r0.q(r1, r2, r3, r4, r5)
            goto L_0x00fd
        L_0x00f6:
            java.lang.String r0 = "Tts sdk has not initialize or text null"
            java.lang.Object[] r1 = new java.lang.Object[r8]
            r5.h(r0, r1)
        L_0x00fd:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.ttsengine.TtsSdk.p(java.lang.String, java.lang.CharSequence, int, android.os.Bundle, java.lang.String, com.upuphone.ai.ttsengine.OnStatusChange):boolean");
    }

    public final void r(String str) {
        u(this, str, (String) null, 2, (Object) null);
    }

    public final void s(String str, String str2) {
        AILOG ailog = b;
        ailog.c("tts stop caller: " + str, new Object[0]);
        if (!o) {
            ailog.h("Tts sdk has not initialize", new Object[0]);
        } else if (str2 == null || str2.length() <= 0 || str != null) {
            TtsSpeakerImpl ttsSpeakerImpl = i;
            if (ttsSpeakerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("speaker");
                ttsSpeakerImpl = null;
            }
            ttsSpeakerImpl.s(str, str2);
        } else {
            throw new IllegalArgumentException("if you want to stop a id, the caller for the id will be needed".toString());
        }
    }

    public final void t(int i2, int i3) {
        AILOG ailog = b;
        ailog.c("tts stop priority=" + i2 + ", stop type=" + i3, new Object[0]);
        if (o) {
            TtsSpeakerImpl ttsSpeakerImpl = i;
            if (ttsSpeakerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("speaker");
                ttsSpeakerImpl = null;
            }
            ttsSpeakerImpl.r(i2, i3);
            return;
        }
        ailog.h("Tts sdk has not initialize", new Object[0]);
    }
}
