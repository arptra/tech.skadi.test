package com.xjsd.ai.assistant.phone.session.interceptor;

import androidx.lifecycle.Lifecycle;
import com.xjsd.ai.assistant.common.ContinuousDialogDispatcher;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.core.api.tts.TtsAbility;
import com.xjsd.ai.assistant.core.api.tts.TtsData;
import com.xjsd.ai.assistant.core.api.tts.TtsListener;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.AudioFocusManageDelegate;
import com.xjsd.ai.assistant.phone.helper.VrStateHelper;
import com.xjsd.ai.assistant.phone.helper.VrStateSynchronizer;
import com.xjsd.ai.assistant.phone.session.Session;
import com.xjsd.ai.assistant.phone.session.utils.SeesionExtensionsKt;
import com.xjsd.ai.assistant.phone.tts.TtsDataTransform;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u0000 \u00122\u00020\u0001:\u0002\u001b\u001cB-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/xjsd/ai/assistant/phone/session/interceptor/TtsInterceptor;", "Lcom/xjsd/ai/assistant/phone/session/interceptor/AbsInterceptor;", "Lcom/xjsd/ai/assistant/phone/session/Session;", "lifecycle", "Lkotlinx/coroutines/flow/Flow;", "Lcom/xjsd/ai/assistant/core/api/tts/TtsData;", "ttsFlow", "Lcom/xjsd/ai/assistant/core/api/tts/TtsAbility;", "ttsAbility", "Lcom/xjsd/ai/assistant/core/api/cache/CacheAbility;", "cacheAbility", "<init>", "(Lcom/xjsd/ai/assistant/phone/session/Session;Lkotlinx/coroutines/flow/Flow;Lcom/xjsd/ai/assistant/core/api/tts/TtsAbility;Lcom/xjsd/ai/assistant/core/api/cache/CacheAbility;)V", "", "f", "()V", "h", "i", "g", "ttsData", "m", "(Lcom/xjsd/ai/assistant/core/api/tts/TtsData;)V", "d", "Lkotlinx/coroutines/flow/Flow;", "e", "Lcom/xjsd/ai/assistant/core/api/tts/TtsAbility;", "Lcom/xjsd/ai/assistant/core/api/cache/CacheAbility;", "Companion", "TtsPlayCallback", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TtsInterceptor extends AbsInterceptor {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);
    public final Flow d;
    public final TtsAbility e;
    public final CacheAbility f;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/phone/session/interceptor/TtsInterceptor$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\b2\b\b\u0001\u0010\u0014\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/xjsd/ai/assistant/phone/session/interceptor/TtsInterceptor$TtsPlayCallback;", "Lcom/xjsd/ai/assistant/core/api/tts/TtsListener;", "Lcom/xjsd/ai/assistant/phone/session/Session;", "session", "Lcom/xjsd/ai/assistant/core/api/tts/TtsData;", "ttsData", "<init>", "(Lcom/xjsd/ai/assistant/phone/session/Session;Lcom/xjsd/ai/assistant/core/api/tts/TtsData;)V", "", "onDiscard", "()V", "onSpeakStart", "onSpeakEnd", "", "error", "onSpeakError", "(Ljava/lang/String;)V", "", "d", "()Ljava/lang/Integer;", "state", "e", "(I)V", "a", "Lcom/xjsd/ai/assistant/core/api/tts/TtsData;", "Lkotlinx/coroutines/CoroutineScope;", "b", "Lkotlinx/coroutines/CoroutineScope;", "sessionScope", "Landroidx/lifecycle/Lifecycle;", "c", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class TtsPlayCallback implements TtsListener {

        /* renamed from: a  reason: collision with root package name */
        public final TtsData f8592a;
        public final CoroutineScope b;
        public final Lifecycle c;

        public TtsPlayCallback(Session session, TtsData ttsData) {
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(ttsData, "ttsData");
            this.f8592a = ttsData;
            this.b = SeesionExtensionsKt.a(session);
            this.c = session.getLifecycle();
        }

        public final Integer d() {
            int nextStep = this.f8592a.getNextStep();
            if (nextStep == 0) {
                ContinuousDialogDispatcher.d(false, 1, (Object) null);
                return null;
            } else if (nextStep == 1) {
                e(0);
                return 0;
            } else if (nextStep != 2) {
                return null;
            } else {
                e(1);
                return 2;
            }
        }

        public final void e(int i) {
            VrStateSynchronizer.b(i);
        }

        public void onDiscard() {
        }

        public void onSpeakEnd() {
            Job unused = BuildersKt__Builders_commonKt.d(this.b, (CoroutineContext) null, (CoroutineStart) null, new TtsInterceptor$TtsPlayCallback$onSpeakEnd$1(this, (Continuation<? super TtsInterceptor$TtsPlayCallback$onSpeakEnd$1>) null), 3, (Object) null);
        }

        public void onSpeakError(String str) {
            Intrinsics.checkNotNullParameter(str, "error");
            Job unused = BuildersKt__Builders_commonKt.d(this.b, (CoroutineContext) null, (CoroutineStart) null, new TtsInterceptor$TtsPlayCallback$onSpeakError$1(this, str, (Continuation<? super TtsInterceptor$TtsPlayCallback$onSpeakError$1>) null), 3, (Object) null);
        }

        public void onSpeakStart() {
            Job unused = BuildersKt__Builders_commonKt.d(this.b, (CoroutineContext) null, (CoroutineStart) null, new TtsInterceptor$TtsPlayCallback$onSpeakStart$1(this, (Continuation<? super TtsInterceptor$TtsPlayCallback$onSpeakStart$1>) null), 3, (Object) null);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TtsInterceptor(Session session, Flow flow, TtsAbility ttsAbility, CacheAbility cacheAbility) {
        super(session);
        Intrinsics.checkNotNullParameter(session, "lifecycle");
        Intrinsics.checkNotNullParameter(flow, "ttsFlow");
        Intrinsics.checkNotNullParameter(ttsAbility, "ttsAbility");
        Intrinsics.checkNotNullParameter(cacheAbility, "cacheAbility");
        this.d = flow;
        this.e = ttsAbility;
        this.f = cacheAbility;
    }

    public void f() {
        this.e.stopSpeak();
        b(this.d, new TtsInterceptor$onCreate$1(this, (Continuation<? super TtsInterceptor$onCreate$1>) null));
    }

    public void g() {
        this.e.stopSpeak();
    }

    public void h() {
    }

    public void i() {
    }

    public final void m(TtsData ttsData) {
        ILog.j("TtsInterceptor", "使用手机播报策略，播报内容->" + ttsData);
        TtsDataTransform.f8607a.a(ttsData, false);
        if (!VrStateHelper.f8567a.a()) {
            ILog.a("TtsInterceptor", "语音助理已经退出，不再播报TTS");
            return;
        }
        ttsData.setSessionId(d().b());
        TtsAbility ttsAbility = (TtsAbility) AbilityManager.b.b(TtsAbility.class);
        if (ttsAbility != null) {
            AudioFocusManageDelegate.a(1);
            ttsAbility.startSpeak(ttsData, new TtsPlayCallback(d(), ttsData));
        }
    }
}
