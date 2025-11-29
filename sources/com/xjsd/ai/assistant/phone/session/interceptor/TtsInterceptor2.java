package com.xjsd.ai.assistant.phone.session.interceptor;

import androidx.lifecycle.Lifecycle;
import com.xjsd.ai.assistant.common.ContinuousDialogDispatcher;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.core.api.tts.TtsAbility;
import com.xjsd.ai.assistant.core.api.tts.TtsData;
import com.xjsd.ai.assistant.core.api.tts.TtsListener;
import com.xjsd.ai.assistant.core.util.DeviceUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.AudioFocusManageDelegate;
import com.xjsd.ai.assistant.phone.WakeupControlDelegate;
import com.xjsd.ai.assistant.phone.helper.VrStateSynchronizer;
import com.xjsd.ai.assistant.phone.session.Session;
import com.xjsd.ai.assistant.phone.session.utils.SeesionExtensionsKt;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import com.xjsd.ai.assistant.phone.tts.TtsDataTransform;
import com.xjsd.ai.assistant.protocol.wakeup.WakeupControl;
import com.xjsd.ai.assistant.template.TtsTemplate;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u0000 \u00122\u00020\u0001:\u0002\u001b\u001cB-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/xjsd/ai/assistant/phone/session/interceptor/TtsInterceptor2;", "Lcom/xjsd/ai/assistant/phone/session/interceptor/AbsInterceptor;", "Lcom/xjsd/ai/assistant/phone/session/Session;", "lifecycle", "Lkotlinx/coroutines/flow/Flow;", "Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$PhoneTts;", "phoneTtsFlow", "Lcom/xjsd/ai/assistant/core/api/tts/TtsAbility;", "ttsAbility", "Lcom/xjsd/ai/assistant/core/api/cache/CacheAbility;", "cacheAbility", "<init>", "(Lcom/xjsd/ai/assistant/phone/session/Session;Lkotlinx/coroutines/flow/Flow;Lcom/xjsd/ai/assistant/core/api/tts/TtsAbility;Lcom/xjsd/ai/assistant/core/api/cache/CacheAbility;)V", "", "f", "()V", "h", "i", "g", "phoneTts", "m", "(Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$PhoneTts;)V", "d", "Lkotlinx/coroutines/flow/Flow;", "e", "Lcom/xjsd/ai/assistant/core/api/tts/TtsAbility;", "Lcom/xjsd/ai/assistant/core/api/cache/CacheAbility;", "Companion", "TtsPlayCallback", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTtsInterceptor2.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TtsInterceptor2.kt\ncom/xjsd/ai/assistant/phone/session/interceptor/TtsInterceptor2\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,192:1\n37#2,2:193\n*S KotlinDebug\n*F\n+ 1 TtsInterceptor2.kt\ncom/xjsd/ai/assistant/phone/session/interceptor/TtsInterceptor2\n*L\n81#1:193,2\n*E\n"})
public final class TtsInterceptor2 extends AbsInterceptor {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);
    public final Flow d;
    public final TtsAbility e;
    public final CacheAbility f;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/phone/session/interceptor/TtsInterceptor2$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\u00020\n2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0019\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/xjsd/ai/assistant/phone/session/interceptor/TtsInterceptor2$TtsPlayCallback;", "Lcom/xjsd/ai/assistant/core/api/tts/TtsListener;", "Lcom/xjsd/ai/assistant/phone/session/Session;", "session", "Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$PhoneTts;", "phoneTts", "<init>", "(Lcom/xjsd/ai/assistant/phone/session/Session;Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$PhoneTts;)V", "", "state", "", "g", "(I)V", "onDiscard", "()V", "onSpeakStart", "onSpeakEnd", "", "error", "onSpeakError", "(Ljava/lang/String;)V", "Lkotlin/Function0;", "block", "e", "(Lkotlin/jvm/functions/Function0;)V", "f", "a", "Lcom/xjsd/ai/assistant/phone/session/Session;", "b", "Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$PhoneTts;", "Lkotlinx/coroutines/CoroutineScope;", "c", "Lkotlinx/coroutines/CoroutineScope;", "sessionScope", "Landroidx/lifecycle/Lifecycle;", "d", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class TtsPlayCallback implements TtsListener {

        /* renamed from: a  reason: collision with root package name */
        public final Session f8593a;
        public final PhoneTtsPlayBuilder.PhoneTts b;
        public final CoroutineScope c;
        public final Lifecycle d;

        public TtsPlayCallback(Session session, PhoneTtsPlayBuilder.PhoneTts phoneTts) {
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(phoneTts, "phoneTts");
            this.f8593a = session;
            this.b = phoneTts;
            this.c = SeesionExtensionsKt.a(session);
            this.d = session.getLifecycle();
        }

        /* access modifiers changed from: private */
        public final void g(int i) {
            VrStateSynchronizer.b(i);
        }

        public final void e(Function0 function0) {
            Job unused = BuildersKt__Builders_commonKt.d(this.c, (CoroutineContext) null, (CoroutineStart) null, new TtsInterceptor2$TtsPlayCallback$launchAndRun$1(this, function0, (Continuation<? super TtsInterceptor2$TtsPlayCallback$launchAndRun$1>) null), 3, (Object) null);
        }

        public final void f() {
            int b2 = this.b.b();
            Integer num = null;
            if (b2 == 0) {
                ContinuousDialogDispatcher.d(false, 1, (Object) null);
            } else if (b2 == 1) {
                g(0);
                num = 0;
            } else if (b2 == 2) {
                if (DeviceUtils.d()) {
                    g(1);
                } else {
                    g(4);
                }
                num = 2;
            } else if (b2 == 3) {
                ILog.a("TtsInterceptor2", "tts播报end，由发起方进行流程控制");
            }
            if (num != null) {
                WakeupControlDelegate.g.i(new WakeupControl(num.intValue()));
            }
        }

        public void onDiscard() {
            String b2 = this.f8593a.b();
            ILog.a("TtsInterceptor2", "语音播报discard->" + b2);
            e(new TtsInterceptor2$TtsPlayCallback$onDiscard$1(this));
        }

        public void onSpeakEnd() {
            String b2 = this.f8593a.b();
            ILog.a("TtsInterceptor2", "语音播报end->" + b2);
            AudioFocusManageDelegate.a(2);
            e(new TtsInterceptor2$TtsPlayCallback$onSpeakEnd$1(this));
        }

        public void onSpeakError(String str) {
            Intrinsics.checkNotNullParameter(str, "error");
            String b2 = this.f8593a.b();
            ILog.a("TtsInterceptor2", "语音播报error->" + b2 + "，error->" + str);
            AudioFocusManageDelegate.a(2);
            e(new TtsInterceptor2$TtsPlayCallback$onSpeakError$1(this));
        }

        public void onSpeakStart() {
            String b2 = this.f8593a.b();
            ILog.a("TtsInterceptor2", "语音播报start->" + b2);
            e(new TtsInterceptor2$TtsPlayCallback$onSpeakStart$1(this));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TtsInterceptor2(Session session, Flow flow, TtsAbility ttsAbility, CacheAbility cacheAbility) {
        super(session);
        Intrinsics.checkNotNullParameter(session, "lifecycle");
        Intrinsics.checkNotNullParameter(flow, "phoneTtsFlow");
        Intrinsics.checkNotNullParameter(ttsAbility, "ttsAbility");
        Intrinsics.checkNotNullParameter(cacheAbility, "cacheAbility");
        this.d = flow;
        this.e = ttsAbility;
        this.f = cacheAbility;
    }

    public void f() {
        this.e.stopSpeak();
        b(this.d, new TtsInterceptor2$onCreate$1(this, (Continuation<? super TtsInterceptor2$onCreate$1>) null));
    }

    public void g() {
        this.e.stopSpeak();
    }

    public void h() {
    }

    public void i() {
    }

    public final void m(PhoneTtsPlayBuilder.PhoneTts phoneTts) {
        TtsData ttsData = new TtsData();
        ttsData.setEmotionType("");
        ttsData.setNextStep(phoneTts.b());
        if (phoneTts instanceof PhoneTtsPlayBuilder.StringResTts) {
            ttsData.setText(ContextHelper.b(((PhoneTtsPlayBuilder.StringResTts) phoneTts).k(), new Object[0]));
        } else if (phoneTts instanceof PhoneTtsPlayBuilder.TextTts) {
            ttsData.setText(((PhoneTtsPlayBuilder.TextTts) phoneTts).k());
        } else if (phoneTts instanceof PhoneTtsPlayBuilder.TemplateTts) {
            PhoneTtsPlayBuilder.TemplateTts templateTts = (PhoneTtsPlayBuilder.TemplateTts) phoneTts;
            TtsTemplate n = templateTts.n();
            String[] strArr = (String[]) templateTts.l().toArray(new String[0]);
            ttsData.setText(n.getTts(Arrays.copyOf(strArr, strArr.length)));
            ttsData.setFunctionId(templateTts.n().getFunctionId());
            ttsData.setSlots(templateTts.m());
        }
        ILog.j("TtsInterceptor2", "手机端播报TTS，内容->" + ttsData);
        TtsDataTransform.f8607a.a(ttsData, false);
        ttsData.setSessionId(d().b());
        AudioFocusManageDelegate.a(1);
        this.e.startSpeak(ttsData, new TtsPlayCallback(d(), phoneTts));
    }
}
