package com.upuphone.ar.transcribe.statemachine.machine;

import android.content.Context;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.statemachine.handler.RecordStateHandler;
import com.upuphone.ar.transcribe.statemachine.handler.TranscribeResultHandler;
import com.upuphone.ar.transcribe.statemachine.handler.UiStateHandler;
import com.upuphone.ar.transcribe.statemachine.handler.XunFeiChannelHandler;
import com.upuphone.ar.transcribe.statemachine.listener.TranscribeResultListener;
import com.upuphone.ar.transcribe.statemachine.listener.UiStateListener;
import com.upuphone.ar.translation.statemachine.annotation.MSG;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001VB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J%\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u0003J\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u0011J\r\u0010\u0017\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0011J\r\u0010\u0018\u001a\u00020\u000f¢\u0006\u0004\b\u0018\u0010\u0011J\u0015\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u0015J\r\u0010\u001a\u001a\u00020\u000f¢\u0006\u0004\b\u001a\u0010\u0011J\u0015\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u001b\u0010\u0015J\r\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0012¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u0004¢\u0006\u0004\b!\u0010\u0003J\r\u0010\"\u001a\u00020\u0004¢\u0006\u0004\b\"\u0010\u0003J\r\u0010#\u001a\u00020\u0004¢\u0006\u0004\b#\u0010\u0003J\r\u0010$\u001a\u00020\u0004¢\u0006\u0004\b$\u0010\u0003J\r\u0010%\u001a\u00020\u0004¢\u0006\u0004\b%\u0010\u0003J\r\u0010&\u001a\u00020\u0004¢\u0006\u0004\b&\u0010\u0003J\r\u0010'\u001a\u00020\u0004¢\u0006\u0004\b'\u0010\u0003J\r\u0010(\u001a\u00020\u0004¢\u0006\u0004\b(\u0010\u0003J\r\u0010)\u001a\u00020\u0004¢\u0006\u0004\b)\u0010\u0003J\r\u0010*\u001a\u00020\u0004¢\u0006\u0004\b*\u0010\u0003J\r\u0010+\u001a\u00020\u0004¢\u0006\u0004\b+\u0010\u0003J\u0015\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0001¢\u0006\u0004\b-\u0010.J\u0015\u0010/\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0001¢\u0006\u0004\b/\u0010.J\u0015\u00100\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0001¢\u0006\u0004\b0\u0010.J\r\u00101\u001a\u00020\u0004¢\u0006\u0004\b1\u0010\u0003J\r\u00102\u001a\u00020\u0004¢\u0006\u0004\b2\u0010\u0003J\r\u00103\u001a\u00020\u0004¢\u0006\u0004\b3\u0010\u0003J\r\u00104\u001a\u00020\u0004¢\u0006\u0004\b4\u0010\u0003J\r\u00105\u001a\u00020\u0004¢\u0006\u0004\b5\u0010\u0003J\u0015\u00107\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u0012¢\u0006\u0004\b7\u00108J\r\u00109\u001a\u00020\u0004¢\u0006\u0004\b9\u0010\u0003J\r\u0010:\u001a\u00020\u0004¢\u0006\u0004\b:\u0010\u0003J\r\u0010;\u001a\u00020\u0004¢\u0006\u0004\b;\u0010\u0003J\r\u0010<\u001a\u00020\u0004¢\u0006\u0004\b<\u0010\u0003J\r\u0010=\u001a\u00020\u0004¢\u0006\u0004\b=\u0010\u0003J\r\u0010>\u001a\u00020\u0004¢\u0006\u0004\b>\u0010\u0003J\u0015\u0010?\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b?\u00108R\u0014\u0010C\u001a\u00020@8\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020L8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001d\u0010MR\u0016\u0010P\u001a\u00020\u001c8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001f\u0010OR\u0016\u0010S\u001a\u00020Q8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\f\u0010RR\u0016\u0010U\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010T¨\u0006W"}, d2 = {"Lcom/upuphone/ar/transcribe/statemachine/machine/TranscribeStateManager;", "", "<init>", "()V", "", "Q", "Landroid/content/Context;", "appContext", "Lcom/upuphone/ar/transcribe/statemachine/listener/TranscribeResultListener;", "transResultListener", "Lcom/upuphone/ar/transcribe/statemachine/listener/UiStateListener;", "uiStateListener", "f", "(Landroid/content/Context;Lcom/upuphone/ar/transcribe/statemachine/listener/TranscribeResultListener;Lcom/upuphone/ar/transcribe/statemachine/listener/UiStateListener;)V", "P", "", "n", "()Z", "", "state", "j", "(I)Z", "i", "k", "l", "m", "g", "h", "Lcom/upuphone/ar/transcribe/statemachine/handler/XunFeiChannelHandler;", "d", "()Lcom/upuphone/ar/transcribe/statemachine/handler/XunFeiChannelHandler;", "e", "()I", "E", "s", "M", "I", "w", "v", "x", "H", "L", "K", "J", "obj", "D", "(Ljava/lang/Object;)V", "C", "G", "p", "o", "q", "r", "B", "netCode", "y", "(I)V", "A", "z", "F", "O", "N", "u", "t", "Lkotlinx/coroutines/CoroutineScope;", "a", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lcom/upuphone/ar/transcribe/statemachine/handler/UiStateHandler;", "b", "Lcom/upuphone/ar/transcribe/statemachine/handler/UiStateHandler;", "uiStateHandler", "Lcom/upuphone/ar/transcribe/statemachine/handler/TranscribeResultHandler;", "c", "Lcom/upuphone/ar/transcribe/statemachine/handler/TranscribeResultHandler;", "translateResultHandler", "Lcom/upuphone/ar/transcribe/statemachine/handler/RecordStateHandler;", "Lcom/upuphone/ar/transcribe/statemachine/handler/RecordStateHandler;", "recordStateHandler", "Lcom/upuphone/ar/transcribe/statemachine/handler/XunFeiChannelHandler;", "channelInitHandler", "Lcom/upuphone/ar/transcribe/statemachine/machine/TranscribeStateMachine;", "Lcom/upuphone/ar/transcribe/statemachine/machine/TranscribeStateMachine;", "stateMachine", "Z", "mIsStateMachineStart", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TranscribeStateManager {
    public static final Companion h = new Companion((DefaultConstructorMarker) null);
    public static volatile TranscribeStateManager i;

    /* renamed from: a  reason: collision with root package name */
    public final CoroutineScope f6172a;
    public UiStateHandler b;
    public TranscribeResultHandler c;
    public RecordStateHandler d;
    public XunFeiChannelHandler e;
    public TranscribeStateMachine f;
    public boolean g;

    @SourceDebugExtension({"SMAP\nTranscribeStateManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranscribeStateManager.kt\ncom/upuphone/ar/transcribe/statemachine/machine/TranscribeStateManager$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,372:1\n1#2:373\n*E\n"})
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\u0003J\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/upuphone/ar/transcribe/statemachine/machine/TranscribeStateManager$Companion;", "", "<init>", "()V", "Lcom/upuphone/ar/transcribe/statemachine/machine/TranscribeStateManager;", "a", "()Lcom/upuphone/ar/transcribe/statemachine/machine/TranscribeStateManager;", "", "c", "", "b", "()Z", "", "TAG", "Ljava/lang/String;", "instance", "Lcom/upuphone/ar/transcribe/statemachine/machine/TranscribeStateManager;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TranscribeStateManager a() {
            TranscribeStateManager a2 = TranscribeStateManager.i;
            if (a2 == null) {
                synchronized (this) {
                    LogExt.g("ARTranslatorStateManager is created....", "TranslateStateManager");
                    a2 = TranscribeStateManager.i;
                    if (a2 == null) {
                        a2 = new TranscribeStateManager((DefaultConstructorMarker) null);
                        TranscribeStateManager.i = a2;
                    }
                }
            }
            return a2;
        }

        public final boolean b() {
            return TranscribeStateManager.i == null;
        }

        public final void c() {
            TranscribeStateManager a2 = TranscribeStateManager.i;
            if (a2 != null) {
                a2.Q();
            }
            TranscribeStateManager.i = null;
        }

        public Companion() {
        }
    }

    public /* synthetic */ TranscribeStateManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void A() {
        TranscribeStateMachine transcribeStateMachine = this.f;
        if (transcribeStateMachine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateMachine");
            transcribeStateMachine = null;
        }
        transcribeStateMachine.t1(MSG.MSG_PREPARING_SHOW_WAITING);
    }

    public final void B() {
        TranscribeStateMachine transcribeStateMachine = this.f;
        if (transcribeStateMachine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateMachine");
            transcribeStateMachine = null;
        }
        transcribeStateMachine.t1(MSG.MSG_PREPARING_SUCCESS);
    }

    public final void C(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        TranscribeStateMachine transcribeStateMachine = this.f;
        if (transcribeStateMachine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateMachine");
            transcribeStateMachine = null;
        }
        transcribeStateMachine.w1(MSG.PROXIMAL_MSG_TRANSLATE_RESULT_SHOW, obj);
    }

    public final void D(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        TranscribeStateMachine transcribeStateMachine = this.f;
        if (transcribeStateMachine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateMachine");
            transcribeStateMachine = null;
        }
        transcribeStateMachine.w1(MSG.REMOTE_MSG_TRANSLATE_RESULT_SHOW, obj);
    }

    public final void E() {
        TranscribeStateMachine transcribeStateMachine = this.f;
        if (transcribeStateMachine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateMachine");
            transcribeStateMachine = null;
        }
        transcribeStateMachine.x1();
    }

    public final void F() {
        TranscribeStateMachine transcribeStateMachine = this.f;
        if (transcribeStateMachine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateMachine");
            transcribeStateMachine = null;
        }
        transcribeStateMachine.t1(MSG.MSG_PREPARING_RETRY);
    }

    public final void G(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        TranscribeStateMachine transcribeStateMachine = this.f;
        if (transcribeStateMachine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateMachine");
            transcribeStateMachine = null;
        }
        transcribeStateMachine.w1(MSG.SERVER_MSG_TRANSLATE_RUNNING_STATE, obj);
    }

    public final void H() {
        TranscribeStateMachine transcribeStateMachine = this.f;
        if (transcribeStateMachine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateMachine");
            transcribeStateMachine = null;
        }
        transcribeStateMachine.y1();
    }

    public final void I() {
        TranscribeStateMachine transcribeStateMachine = this.f;
        if (transcribeStateMachine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateMachine");
            transcribeStateMachine = null;
        }
        transcribeStateMachine.t1(MSG.MSG_ASSISTANT_EXIT);
    }

    public final void J() {
        TranscribeStateMachine transcribeStateMachine = this.f;
        if (transcribeStateMachine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateMachine");
            transcribeStateMachine = null;
        }
        transcribeStateMachine.t1(MSG.MSG_VOICE_REDUCE_FIVE_MINS);
    }

    public final void K() {
        TranscribeStateMachine transcribeStateMachine = this.f;
        if (transcribeStateMachine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateMachine");
            transcribeStateMachine = null;
        }
        transcribeStateMachine.t1(MSG.MSG_VOICE_REDUCE_FIVE_SECS);
    }

    public final void L() {
        TranscribeStateMachine transcribeStateMachine = this.f;
        if (transcribeStateMachine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateMachine");
            transcribeStateMachine = null;
        }
        transcribeStateMachine.t1(MSG.MSG_VOICE_REDUCE_TWO_SECS);
    }

    public final void M() {
        TranscribeStateMachine transcribeStateMachine = this.f;
        if (transcribeStateMachine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateMachine");
            transcribeStateMachine = null;
        }
        transcribeStateMachine.t1(MSG.MSG_ASSISTANT_OPEN);
    }

    public final void N() {
        TranscribeStateMachine transcribeStateMachine = this.f;
        if (transcribeStateMachine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateMachine");
            transcribeStateMachine = null;
        }
        transcribeStateMachine.t1(1011);
    }

    public final void O() {
        TranscribeStateMachine transcribeStateMachine = this.f;
        if (transcribeStateMachine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateMachine");
            transcribeStateMachine = null;
        }
        transcribeStateMachine.t1(1010);
    }

    public final void P() {
        TranscribeStateMachine transcribeStateMachine = this.f;
        if (transcribeStateMachine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateMachine");
            transcribeStateMachine = null;
        }
        transcribeStateMachine.w();
        this.g = true;
    }

    public final void Q() {
        CoroutineScopeKt.e(this.f6172a, (CancellationException) null, 1, (Object) null);
        this.g = false;
    }

    public final XunFeiChannelHandler d() {
        XunFeiChannelHandler xunFeiChannelHandler = this.e;
        if (xunFeiChannelHandler != null) {
            return xunFeiChannelHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("channelInitHandler");
        return null;
    }

    public final int e() {
        if (h.b() || !n()) {
            return -1;
        }
        TranscribeStateMachine transcribeStateMachine = this.f;
        if (transcribeStateMachine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateMachine");
            transcribeStateMachine = null;
        }
        return transcribeStateMachine.A0();
    }

    public final void f(Context context, TranscribeResultListener transcribeResultListener, UiStateListener uiStateListener) {
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(transcribeResultListener, "transResultListener");
        Intrinsics.checkNotNullParameter(uiStateListener, "uiStateListener");
        this.c = new TranscribeResultHandler(this.f6172a, transcribeResultListener);
        this.b = new UiStateHandler(this.f6172a, uiStateListener);
        this.d = new RecordStateHandler();
        this.e = new XunFeiChannelHandler(this, context, this.f6172a);
        TranscribeResultHandler transcribeResultHandler = this.c;
        UiStateHandler uiStateHandler = null;
        if (transcribeResultHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("translateResultHandler");
            transcribeResultHandler = null;
        }
        RecordStateHandler recordStateHandler = this.d;
        if (recordStateHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recordStateHandler");
            recordStateHandler = null;
        }
        XunFeiChannelHandler xunFeiChannelHandler = this.e;
        if (xunFeiChannelHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelInitHandler");
            xunFeiChannelHandler = null;
        }
        UiStateHandler uiStateHandler2 = this.b;
        if (uiStateHandler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiStateHandler");
        } else {
            uiStateHandler = uiStateHandler2;
        }
        this.f = new TranscribeStateMachine(transcribeResultHandler, recordStateHandler, xunFeiChannelHandler, uiStateHandler);
    }

    public final boolean g() {
        return e() == 2;
    }

    public final boolean h(int i2) {
        return i2 == 2;
    }

    public final boolean i() {
        return j(e());
    }

    public final boolean j(int i2) {
        return i2 == 2 || i2 == 6 || i2 == 1 || i2 == -1;
    }

    public final boolean k() {
        return e() == 3;
    }

    public final boolean l() {
        return e() == 4;
    }

    public final boolean m(int i2) {
        return i2 == 4;
    }

    public final boolean n() {
        return this.g;
    }

    public final void o() {
        TranscribeStateMachine transcribeStateMachine = this.f;
        if (transcribeStateMachine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateMachine");
            transcribeStateMachine = null;
        }
        transcribeStateMachine.t1(MSG.MSG_CONNECTED_OFF);
    }

    public final void p() {
        TranscribeStateMachine transcribeStateMachine = this.f;
        if (transcribeStateMachine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateMachine");
            transcribeStateMachine = null;
        }
        transcribeStateMachine.t1(5000);
    }

    public final void q() {
        TranscribeStateMachine transcribeStateMachine = this.f;
        if (transcribeStateMachine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateMachine");
            transcribeStateMachine = null;
        }
        transcribeStateMachine.t1(MSG.MSG_CONNECTED_LOSS_PACKAGE);
    }

    public final void r() {
        TranscribeStateMachine transcribeStateMachine = this.f;
        if (transcribeStateMachine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateMachine");
            transcribeStateMachine = null;
        }
        transcribeStateMachine.t1(MSG.MSG_CONNECTED_STATUS_GOOD);
    }

    public final void s() {
        TranscribeStateMachine transcribeStateMachine = this.f;
        if (transcribeStateMachine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateMachine");
            transcribeStateMachine = null;
        }
        transcribeStateMachine.r1();
    }

    public final void t(int i2) {
        TranscribeStateMachine transcribeStateMachine = this.f;
        if (transcribeStateMachine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateMachine");
            transcribeStateMachine = null;
        }
        transcribeStateMachine.u1(MSG.MSG_TELEPHONE_TRANS_LANGUAGE_NOT_SUPPORT, i2);
    }

    public final void u() {
        TranscribeStateMachine transcribeStateMachine = this.f;
        if (transcribeStateMachine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateMachine");
            transcribeStateMachine = null;
        }
        transcribeStateMachine.t1(9001);
    }

    public final void v() {
        TranscribeStateMachine transcribeStateMachine = this.f;
        if (transcribeStateMachine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateMachine");
            transcribeStateMachine = null;
        }
        transcribeStateMachine.t1(1007);
    }

    public final void w() {
        TranscribeStateMachine transcribeStateMachine = this.f;
        if (transcribeStateMachine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateMachine");
            transcribeStateMachine = null;
        }
        transcribeStateMachine.t1(1006);
    }

    public final void x() {
        TranscribeStateMachine transcribeStateMachine = this.f;
        if (transcribeStateMachine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateMachine");
            transcribeStateMachine = null;
        }
        transcribeStateMachine.t1(1008);
    }

    public final void y(int i2) {
        TranscribeStateMachine transcribeStateMachine = this.f;
        if (transcribeStateMachine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateMachine");
            transcribeStateMachine = null;
        }
        transcribeStateMachine.v1(MSG.MSG_IFLY_CONNECT_FAILED, 100, i2);
    }

    public final void z() {
        TranscribeStateMachine transcribeStateMachine = this.f;
        if (transcribeStateMachine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateMachine");
            transcribeStateMachine = null;
        }
        transcribeStateMachine.t1(MSG.MSG_PREPARING_HINT_WAITING);
    }

    public TranscribeStateManager() {
        CompletableJob b2 = SupervisorKt.b((Job) null, 1, (Object) null);
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this.f6172a = CoroutineScopeKt.a(b2.plus(ExecutorsKt.b(newSingleThreadExecutor)));
    }
}
