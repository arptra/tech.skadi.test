package com.xjsd.ai.assistant.phone.session;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.xjsd.ai.assistant.asr.AsrAbility;
import com.xjsd.ai.assistant.chatgpt.ChatGptAbility;
import com.xjsd.ai.assistant.cloud.CloudAbility;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.core.api.tts.TtsAbility;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.nlu.NluAbility;
import com.xjsd.ai.assistant.phone.cmd.AudioDataTransCmdHandler;
import com.xjsd.ai.assistant.phone.helper.ExitTimer;
import com.xjsd.ai.assistant.phone.session.interceptor.AudioDataInterceptor;
import com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor;
import com.xjsd.ai.assistant.phone.session.interceptor.TtsInterceptor;
import com.xjsd.ai.assistant.phone.session.interceptor.TtsInterceptor2;
import com.xjsd.ai.assistant.phone.session.interceptor.VadInterceptor;
import com.xjsd.ai.assistant.phone.session.utils.ASyncLifecycleRegistry;
import com.xjsd.ai.assistant.phone.session.utils.SeesionExtensionsKt;
import com.xjsd.ai.assistant.phone.tts.TtsManager;
import com.xjsd.ai.assistant.phone.vad.VadAbility;
import com.xjsd.ai.assistant.protocol.wakeup.WakeupControl;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0002!\"B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\b\u0010\u0005J\r\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\nJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u000eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0005R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0015R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/xjsd/ai/assistant/phone/session/Session;", "Landroidx/lifecycle/LifecycleOwner;", "", "id", "<init>", "(Ljava/lang/String;)V", "sessionId", "", "g", "i", "()V", "a", "", "d", "()Z", "e", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setId", "Lcom/xjsd/ai/assistant/phone/session/utils/ASyncLifecycleRegistry;", "Lcom/xjsd/ai/assistant/phone/session/utils/ASyncLifecycleRegistry;", "lifecycleRegistry", "Ljava/util/concurrent/atomic/AtomicReference;", "", "c", "Ljava/util/concurrent/atomic/AtomicReference;", "()Ljava/util/concurrent/atomic/AtomicReference;", "sessionScopeRef", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "lifecycle", "Builder", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class Session implements LifecycleOwner {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public String f8575a;
    public final ASyncLifecycleRegistry b = new ASyncLifecycleRegistry(this);
    public final AtomicReference c = new AtomicReference();

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/xjsd/ai/assistant/phone/session/Session$Builder;", "", "<init>", "()V", "Lcom/xjsd/ai/assistant/protocol/wakeup/WakeupControl;", "wakeupControl", "", "c", "(Lcom/xjsd/ai/assistant/protocol/wakeup/WakeupControl;)V", "", "id", "b", "(Ljava/lang/String;)V", "Lcom/xjsd/ai/assistant/phone/session/Session;", "a", "()Lcom/xjsd/ai/assistant/phone/session/Session;", "", "I", "controlType", "Ljava/lang/String;", "sessionId", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public int f8576a = 1;
        public String b;

        public final Session a() {
            AbilityManager abilityManager = AbilityManager.b;
            VadAbility vadAbility = (VadAbility) abilityManager.b(VadAbility.class);
            if (vadAbility == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            } else if (((AsrAbility) abilityManager.b(AsrAbility.class)) != null) {
                NluAbility nluAbility = (NluAbility) abilityManager.b(NluAbility.class);
                if (nluAbility != null) {
                    TtsAbility ttsAbility = (TtsAbility) abilityManager.b(TtsAbility.class);
                    if (ttsAbility != null) {
                        CacheAbility cacheAbility = (CacheAbility) abilityManager.b(CacheAbility.class);
                        if (cacheAbility != null) {
                            CloudAbility cloudAbility = (CloudAbility) abilityManager.b(CloudAbility.class);
                            if (cloudAbility != null) {
                                String str = this.b;
                                if (str == null) {
                                    str = String.valueOf(System.currentTimeMillis());
                                }
                                Session session = new Session(str);
                                Lifecycle lifecycle = session.getLifecycle();
                                ILog.a(RtspHeaders.Names.SESSION, "session lifecycle instance: " + lifecycle);
                                TtsManager ttsManager = TtsManager.g;
                                new TtsInterceptor(session, ttsManager.e(), ttsAbility, cacheAbility);
                                new TtsInterceptor2(session, ttsManager.d(), ttsAbility, cacheAbility);
                                AudioDataTransCmdHandler a2 = AudioDataTransCmdHandler.a();
                                Intrinsics.checkNotNullExpressionValue(a2, "getInstance(...)");
                                VadInterceptor vadInterceptor = new VadInterceptor(session, new AudioDataInterceptor(session, a2).m(), vadAbility, cacheAbility, cloudAbility);
                                new OverallInterceptor(session, vadInterceptor.q(), vadInterceptor.s(), vadInterceptor.r(), cloudAbility, cacheAbility, nluAbility);
                                if (this.f8576a != 3) {
                                    ttsManager.g(session);
                                }
                                return session;
                            }
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }

        public final void b(String str) {
            Intrinsics.checkNotNullParameter(str, "id");
            this.b = str;
        }

        public final void c(WakeupControl wakeupControl) {
            Intrinsics.checkNotNullParameter(wakeupControl, "wakeupControl");
            this.f8576a = wakeupControl.getControl();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/phone/session/Session$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public Session(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.f8575a = str;
    }

    public static /* synthetic */ void h(Session session, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        session.g(str);
    }

    public final void a() {
        ILog.a(RtspHeaders.Names.SESSION, "cancel session call");
        this.b.i(Lifecycle.Event.ON_DESTROY);
        TtsManager.g.g((Session) null);
        ExitTimer.f8563a.c();
        CoroutineScopeKt.e(SeesionExtensionsKt.a(this), (CancellationException) null, 1, (Object) null);
        ChatGptAbility chatGptAbility = (ChatGptAbility) AbilityManager.b.b(ChatGptAbility.class);
        if (chatGptAbility != null) {
            chatGptAbility.cancel(this.f8575a);
        }
        String str = this.f8575a;
        ILog.a(RtspHeaders.Names.SESSION, "session: " + str + " canceled");
    }

    public final String b() {
        return this.f8575a;
    }

    public final AtomicReference c() {
        return this.c;
    }

    public final boolean d() {
        Lifecycle.State b2 = this.b.b();
        boolean h = CoroutineScopeKt.h(SeesionExtensionsKt.a(this));
        ILog.a(RtspHeaders.Names.SESSION, "isActive lifecycle state: " + b2 + ", scope status: " + h);
        return this.b.b().isAtLeast(Lifecycle.State.RESUMED) && CoroutineScopeKt.h(SeesionExtensionsKt.a(this));
    }

    public final boolean e() {
        Lifecycle.State b2 = this.b.b();
        boolean h = CoroutineScopeKt.h(SeesionExtensionsKt.a(this));
        ILog.a(RtspHeaders.Names.SESSION, "isCanceled lifecycle state: " + b2 + ", scope status: " + h);
        return this.b.b() == Lifecycle.State.DESTROYED && !CoroutineScopeKt.h(SeesionExtensionsKt.a(this));
    }

    public final void f() {
        h(this, (String) null, 1, (Object) null);
    }

    public final void g(String str) {
        if (str != null && str.length() > 0) {
            this.f8575a = str;
        }
        ILog.a(RtspHeaders.Names.SESSION, "session launch call");
        this.b.i(Lifecycle.Event.ON_RESUME);
        String str2 = this.f8575a;
        ILog.a(RtspHeaders.Names.SESSION, "session: " + str2 + " launched");
    }

    public Lifecycle getLifecycle() {
        return this.b;
    }

    public final void i() {
        ILog.a(RtspHeaders.Names.SESSION, "session stop call");
        this.b.i(Lifecycle.Event.ON_STOP);
    }
}
