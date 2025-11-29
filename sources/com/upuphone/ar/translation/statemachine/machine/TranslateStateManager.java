package com.upuphone.ar.translation.statemachine.machine;

import android.content.Context;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.statemachine.annotation.MSG;
import com.upuphone.ar.translation.statemachine.handler.RecordStateHandler;
import com.upuphone.ar.translation.statemachine.handler.TranslatorUiHandler;
import com.upuphone.ar.translation.statemachine.handler.XunFeiChannelHandler;
import com.upuphone.ar.translation.statemachine.listener.TranslatorUiListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001AB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u000eJ\r\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\fJ\r\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u000eJ\u0015\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\fJ\r\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001bJ\r\u0010\u001d\u001a\u00020\u0019¢\u0006\u0004\b\u001d\u0010\u001bJ\r\u0010\u001e\u001a\u00020\u0019¢\u0006\u0004\b\u001e\u0010\u001bJ\r\u0010\u001f\u001a\u00020\u0019¢\u0006\u0004\b\u001f\u0010\u001bJ\r\u0010 \u001a\u00020\u0019¢\u0006\u0004\b \u0010\u001bJ\r\u0010!\u001a\u00020\u0019¢\u0006\u0004\b!\u0010\u001bJ\r\u0010\"\u001a\u00020\u0019¢\u0006\u0004\b\"\u0010\u001bJ\r\u0010#\u001a\u00020\u0019¢\u0006\u0004\b#\u0010\u001bJ\r\u0010$\u001a\u00020\u0019¢\u0006\u0004\b$\u0010\u001bJ\r\u0010%\u001a\u00020\u0019¢\u0006\u0004\b%\u0010\u001bJ\u0015\u0010'\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u0001¢\u0006\u0004\b'\u0010(J\u0015\u0010)\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u0001¢\u0006\u0004\b)\u0010(J\u0015\u0010*\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u0001¢\u0006\u0004\b*\u0010(J\r\u0010+\u001a\u00020\u0019¢\u0006\u0004\b+\u0010\u001bJ\r\u0010,\u001a\u00020\u0019¢\u0006\u0004\b,\u0010\u001bJ\r\u0010-\u001a\u00020\u0019¢\u0006\u0004\b-\u0010\u001bJ\r\u0010.\u001a\u00020\u0019¢\u0006\u0004\b.\u0010\u001bJ\r\u0010/\u001a\u00020\u0019¢\u0006\u0004\b/\u0010\u001bJ\u0015\u00101\u001a\u00020\u00192\u0006\u00100\u001a\u00020\b¢\u0006\u0004\b1\u00102J\r\u00103\u001a\u00020\u0019¢\u0006\u0004\b3\u0010\u001bJ\r\u00104\u001a\u00020\u0019¢\u0006\u0004\b4\u0010\u001bJ\r\u00105\u001a\u00020\u0019¢\u0006\u0004\b5\u0010\u001bJ\r\u00106\u001a\u00020\u0019¢\u0006\u0004\b6\u0010\u001bJ\r\u00107\u001a\u00020\u0019¢\u0006\u0004\b7\u0010\u001bJ\u0015\u00108\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b8\u00102R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u00109\u001a\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010<R\u0016\u0010@\u001a\u00020>8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010?¨\u0006B"}, d2 = {"Lcom/upuphone/ar/translation/statemachine/machine/TranslateStateManager;", "", "Landroid/content/Context;", "context", "Lcom/upuphone/ar/translation/statemachine/listener/TranslatorUiListener;", "translatorUiListener", "<init>", "(Landroid/content/Context;Lcom/upuphone/ar/translation/statemachine/listener/TranslatorUiListener;)V", "", "state", "", "f", "(I)Z", "e", "()Z", "g", "h", "i", "c", "d", "b", "()I", "Lcom/upuphone/ar/translation/statemachine/handler/XunFeiChannelHandler;", "a", "()Lcom/upuphone/ar/translation/statemachine/handler/XunFeiChannelHandler;", "", "y", "()V", "n", "G", "C", "q", "p", "r", "B", "F", "E", "D", "obj", "x", "(Ljava/lang/Object;)V", "w", "A", "k", "j", "l", "m", "v", "netCode", "s", "(I)V", "u", "t", "I", "H", "z", "o", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/upuphone/ar/translation/statemachine/handler/XunFeiChannelHandler;", "mChannelHandler", "Lcom/upuphone/ar/translation/statemachine/machine/TranslateStateMachine;", "Lcom/upuphone/ar/translation/statemachine/machine/TranslateStateMachine;", "mStateMachine", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TranslateStateManager {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Context f6362a;
    public XunFeiChannelHandler b;
    public TranslateStateMachine c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/translation/statemachine/machine/TranslateStateManager$Companion;", "", "()V", "TAG", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public TranslateStateManager(Context context, TranslatorUiListener translatorUiListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(translatorUiListener, "translatorUiListener");
        this.f6362a = context;
        LogExt.j("[init] 初始化翻译官状态机管理器", "TranslateStateManager");
        this.b = new XunFeiChannelHandler(this, context);
        TranslateStateMachine translateStateMachine = new TranslateStateMachine(new RecordStateHandler(), this.b, new TranslatorUiHandler(translatorUiListener));
        this.c = translateStateMachine;
        translateStateMachine.w();
    }

    public final void A(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        this.c.f1(MSG.SERVER_MSG_TRANSLATE_RUNNING_STATE, obj);
    }

    public final void B() {
        this.c.c1(MSG.MSG_VOICE_NOT_MUTE);
    }

    public final void C() {
        this.c.c1(MSG.MSG_ASSISTANT_EXIT);
    }

    public final void D() {
        this.c.c1(MSG.MSG_VOICE_REDUCE_FIVE_MINS);
    }

    public final void E() {
        this.c.c1(MSG.MSG_VOICE_REDUCE_FIVE_SECS);
    }

    public final void F() {
        this.c.c1(MSG.MSG_VOICE_REDUCE_TWO_SECS);
    }

    public final void G() {
        this.c.c1(MSG.MSG_ASSISTANT_OPEN);
    }

    public final void H() {
        this.c.c1(1011);
    }

    public final void I() {
        this.c.c1(1010);
    }

    public final XunFeiChannelHandler a() {
        return this.b;
    }

    public final int b() {
        return this.c.n0();
    }

    public final boolean c() {
        return d(b());
    }

    public final boolean d(int i) {
        return i == 2;
    }

    public final boolean e() {
        return f(b());
    }

    public final boolean f(int i) {
        return i == 2 || i == 6 || i == 1 || i == -1;
    }

    public final boolean g() {
        return b() == 3;
    }

    public final boolean h() {
        return i(b());
    }

    public final boolean i(int i) {
        return i == 4;
    }

    public final void j() {
        this.c.c1(MSG.MSG_CONNECTED_OFF);
    }

    public final void k() {
        this.c.c1(5000);
    }

    public final void l() {
        this.c.c1(MSG.MSG_CONNECTED_LOSS_PACKAGE);
    }

    public final void m() {
        this.c.c1(MSG.MSG_CONNECTED_STATUS_GOOD);
    }

    public final void n() {
        this.c.a1();
    }

    public final void o(int i) {
        this.c.d1(MSG.MSG_GLASS_SCREEN_STATE, i);
    }

    public final void p() {
        this.c.c1(1007);
    }

    public final void q() {
        this.c.c1(1006);
    }

    public final void r() {
        this.c.c1(1008);
    }

    public final void s(int i) {
        this.c.e1(MSG.MSG_IFLY_CONNECT_FAILED, 100, i);
    }

    public final void t() {
        this.c.c1(MSG.MSG_PREPARING_HINT_WAITING);
    }

    public final void u() {
        this.c.c1(MSG.MSG_PREPARING_SHOW_WAITING);
    }

    public final void v() {
        this.c.c1(MSG.MSG_PREPARING_SUCCESS);
    }

    public final void w(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        this.c.f1(MSG.PROXIMAL_MSG_TRANSLATE_RESULT_SHOW, obj);
    }

    public final void x(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        this.c.f1(MSG.REMOTE_MSG_TRANSLATE_RESULT_SHOW, obj);
    }

    public final void y() {
        this.c.c1(1001);
    }

    public final void z() {
        this.c.c1(MSG.MSG_TELEPHONE_TRANS_LANGUAGE_NOT_SUPPORT);
    }
}
