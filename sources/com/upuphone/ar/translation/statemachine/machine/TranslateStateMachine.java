package com.upuphone.ar.translation.statemachine.machine;

import android.os.Message;
import android.text.TextUtils;
import com.upuphone.ar.translation.ext.InterconnectMsgCodExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.statemachine.annotation.MSG;
import com.upuphone.ar.translation.statemachine.core.IState;
import com.upuphone.ar.translation.statemachine.core.State;
import com.upuphone.ar.translation.statemachine.core.StateMachine;
import com.upuphone.ar.translation.statemachine.handler.RecordStateHandler;
import com.upuphone.ar.translation.statemachine.handler.TranslatorUiHandler;
import com.upuphone.ar.translation.statemachine.handler.XunFeiChannelHandler;

public class TranslateStateMachine extends StateMachine {
    public final State d = new NotStartState();
    public final State e = new PreparingState();
    public final State f = new RunningState();
    public final State g = new StoppingState();
    public final State h = new EndState();
    public final RecordStateHandler i;
    public final XunFeiChannelHandler j;
    public final TranslatorUiHandler k;
    public int l = 0;
    public Boolean m;
    public Boolean n;
    public int o;

    public class EndState extends State {
        public EndState() {
        }

        public void a() {
            TranslateStateMachine translateStateMachine = TranslateStateMachine.this;
            translateStateMachine.k1("TranslateStateMachine#End", "entering, State=" + getName());
            TranslateStateMachine.this.i.b();
        }

        public void b() {
            TranslateStateMachine translateStateMachine = TranslateStateMachine.this;
            translateStateMachine.k1("TranslateStateMachine#End", "exiting, State=" + getName());
        }

        public boolean c(Message message) {
            int i = message.what;
            IState f0 = TranslateStateMachine.this.e();
            TranslateStateMachine translateStateMachine = TranslateStateMachine.this;
            translateStateMachine.k1("TranslateStateMachine#End", "processMessage msgId=" + StateMachineExtKt.a(i) + ", State=" + getName());
            if (i == 1001) {
                TranslateStateMachine.this.i1();
                return true;
            } else if (i != 8001) {
                TranslateStateMachine.this.G0(i, f0);
                return true;
            } else {
                TranslateStateMachine translateStateMachine2 = TranslateStateMachine.this;
                translateStateMachine2.Q0(translateStateMachine2.h0(getName()), message.arg1);
                return true;
            }
        }

        public String getName() {
            return "End";
        }
    }

    public class NotStartState extends State {
        public NotStartState() {
        }

        public void a() {
            TranslateStateMachine translateStateMachine = TranslateStateMachine.this;
            translateStateMachine.k1("TranslateStateMachine#NotStart", "entering, State=" + getName());
            TranslateStateMachine.this.Q0(1, -1);
            TranslateStateMachine.this.j.z();
        }

        public void b() {
            TranslateStateMachine translateStateMachine = TranslateStateMachine.this;
            translateStateMachine.k1("TranslateStateMachine#NotStart", "exiting, State=" + getName());
            TranslateStateMachine.this.j.J();
            TranslateStateMachine.this.T0();
        }

        public boolean c(Message message) {
            int i = message.what;
            IState a0 = TranslateStateMachine.this.e();
            TranslateStateMachine translateStateMachine = TranslateStateMachine.this;
            translateStateMachine.k1("TranslateStateMachine#NotStart", "processMessage msgId=" + StateMachineExtKt.a(i) + ", State=" + getName());
            if (i == 1001) {
                TranslateStateMachine.this.i1();
                return true;
            } else if (i != 2005) {
                TranslateStateMachine.this.G0(i, a0);
                return true;
            } else {
                TranslateStateMachine.this.A0(a0);
                return true;
            }
        }

        public String getName() {
            return "NotStart";
        }
    }

    public class PreparingState extends State {
        public PreparingState() {
        }

        public void a() {
            TranslateStateMachine translateStateMachine = TranslateStateMachine.this;
            translateStateMachine.k1("TranslateStateMachine#Preparing", "entering, State=" + getName());
            TranslateStateMachine.this.Q0(3, -1);
            TranslateStateMachine.this.j.D();
            TranslateStateMachine.this.i.a();
        }

        public void b() {
            TranslateStateMachine translateStateMachine = TranslateStateMachine.this;
            translateStateMachine.k1("TranslateStateMachine#Preparing", "exiting, State=" + getName());
            TranslateStateMachine.this.j.r();
        }

        public boolean c(Message message) {
            int i = message.what;
            IState b0 = TranslateStateMachine.this.e();
            TranslateStateMachine translateStateMachine = TranslateStateMachine.this;
            translateStateMachine.k1("TranslateStateMachine#Preparing", "processMessage msgId=" + StateMachineExtKt.a(i) + ", State=" + getName());
            if (i == 1001) {
                return true;
            }
            if (i == 1012) {
                TranslateStateMachine.this.h1(b0, 31);
                return true;
            } else if (i != 4003) {
                switch (i) {
                    case MSG.MSG_PREPARING_SUCCESS:
                        TranslateStateMachine.this.D0(b0);
                        return true;
                    case MSG.MSG_IFLY_CONNECT_FAILED:
                        TranslateStateMachine.this.B0(message, b0);
                        return true;
                    case MSG.MSG_PREPARING_RETRY:
                        TranslateStateMachine.this.C0(b0);
                        return true;
                    case MSG.MSG_PREPARING_SHOW_WAITING:
                        TranslateStateMachine.this.S0(b0);
                        return true;
                    default:
                        TranslateStateMachine.this.G0(i, b0);
                        return true;
                }
            } else {
                TranslateStateMachine.this.P0(message.obj);
                return true;
            }
        }

        public String getName() {
            return "Preparing";
        }
    }

    public class RunningState extends State {
        public RunningState() {
        }

        public void a() {
            TranslateStateMachine translateStateMachine = TranslateStateMachine.this;
            translateStateMachine.k1("TranslateStateMachine#Running", "entering, State=" + getName() + " ,voiceSetup=" + TranslateStateMachine.this.m);
            TranslateStateMachine.this.Q0(4, -1);
            if (!TranslateStateMachine.this.m.booleanValue()) {
                TranslateStateMachine.this.i.c();
                return;
            }
            TranslateStateMachine.this.Q0(4, 21);
            TranslateStateMachine translateStateMachine2 = TranslateStateMachine.this;
            translateStateMachine2.Y0(translateStateMachine2.e());
        }

        public void b() {
            TranslateStateMachine translateStateMachine = TranslateStateMachine.this;
            translateStateMachine.k1("TranslateStateMachine#Running", "exiting, State=" + getName());
            TranslateStateMachine.this.i.d();
            TranslateStateMachine.this.w0();
        }

        public boolean c(Message message) {
            int i = message.what;
            IState d0 = TranslateStateMachine.this.e();
            TranslateStateMachine translateStateMachine = TranslateStateMachine.this;
            translateStateMachine.k1("TranslateStateMachine#Running", "processMessage msgId=" + StateMachineExtKt.a(i) + ", State=" + getName());
            if (i == 1001) {
                TranslateStateMachine.this.g1(d0);
                return true;
            } else if (i == 1013) {
                TranslateStateMachine.this.z0(message, d0);
                return true;
            } else if (i == 2005) {
                TranslateStateMachine.this.A0(d0);
                return true;
            } else if (i == 2001) {
                TranslateStateMachine.this.F0(d0);
                return true;
            } else if (i != 2002) {
                switch (i) {
                    case MSG.MSG_VOICE_MUTE:
                        return true;
                    case MSG.MSG_VOICE_NOT_MUTE:
                        TranslateStateMachine.this.W0(d0);
                        return true;
                    case MSG.MSG_VOICE_REDUCE_TWO_SECS:
                        TranslateStateMachine.this.Z0(d0);
                        return true;
                    case MSG.MSG_VOICE_REDUCE_FIVE_SECS:
                        TranslateStateMachine.this.Y0(d0);
                        return true;
                    case MSG.MSG_VOICE_REDUCE_FIVE_MINS:
                        TranslateStateMachine.this.X0(d0);
                        return true;
                    default:
                        switch (i) {
                            case MSG.REMOTE_MSG_TRANSLATE_RESULT_SHOW:
                                TranslateStateMachine.this.V0(d0, message);
                                return true;
                            case MSG.PROXIMAL_MSG_TRANSLATE_RESULT_SHOW:
                                TranslateStateMachine.this.U0(d0, message);
                                return true;
                            case MSG.SERVER_MSG_TRANSLATE_RUNNING_STATE:
                                TranslateStateMachine.this.P0(message.obj);
                                return true;
                            default:
                                TranslateStateMachine.this.G0(i, d0);
                                return true;
                        }
                }
            } else {
                TranslateStateMachine.this.E0(d0, message);
                return true;
            }
        }

        public String getName() {
            return "Running";
        }
    }

    public class StoppingState extends State {
        public StoppingState() {
        }

        public void a() {
            TranslateStateMachine translateStateMachine = TranslateStateMachine.this;
            translateStateMachine.k1("TranslateStateMachine#Stopping", "entering, State=" + getName());
            TranslateStateMachine.this.Q0(6, -1);
        }

        public void b() {
            TranslateStateMachine translateStateMachine = TranslateStateMachine.this;
            translateStateMachine.k1("TranslateStateMachine#Stopping", "exiting, State=" + getName());
        }

        public boolean c(Message message) {
            int i = message.what;
            IState e0 = TranslateStateMachine.this.e();
            TranslateStateMachine translateStateMachine = TranslateStateMachine.this;
            translateStateMachine.k1("TranslateStateMachine#Stopping", "processMessage msgId=" + StateMachineExtKt.a(i) + ", State=" + getName());
            if (i != 1001) {
                TranslateStateMachine.this.G0(i, e0);
                return true;
            }
            TranslateStateMachine.this.i1();
            return true;
        }

        public String getName() {
            return "Stopping";
        }
    }

    public TranslateStateMachine(RecordStateHandler recordStateHandler, XunFeiChannelHandler xunFeiChannelHandler, TranslatorUiHandler translatorUiHandler) {
        super("ARTranslatorStateMachine");
        Boolean bool = Boolean.FALSE;
        this.m = bool;
        this.n = bool;
        this.o = 0;
        this.i = recordStateHandler;
        this.j = xunFeiChannelHandler;
        this.k = translatorUiHandler;
        i0();
    }

    public final void A0(IState iState) {
        if (iState == null) {
            j1("handleHintWaiting state is null");
        } else {
            Q0(h0(iState.getName()), 17);
        }
    }

    public final void B0(Message message, IState iState) {
        int i2 = message.arg1;
        int i3 = message.arg2;
        j1("handlePreparingFailed arg1=" + i2 + " ,arg2=" + i3);
        if (i2 == 100) {
            g1(iState);
        } else if (iState == this.e) {
            g1(iState);
        } else {
            State state = this.g;
            if (iState != state) {
                x(state);
            }
        }
        if (i3 == 0) {
            Q0(h0(iState.getName()), 18);
        }
    }

    public final void C0(IState iState) {
        g1(iState);
    }

    public final void D0(IState iState) {
        j1("handlePreparingSuccess mPhoneCallState=" + g0() + " ,mVoiceSetup=" + this.m + " ,mWechatReply=" + this.n);
        if ((K0() && !this.j.A(true)) || L0()) {
            h1(e(), 23);
        } else if (this.n.booleanValue()) {
            h1(e(), 24);
        } else {
            State state = this.f;
            if (iState != state) {
                x(state);
            } else {
                j1("in running state. not transition.");
            }
        }
    }

    public final void E0(IState iState, Message message) {
        if (iState == null) {
            j1("handleRunningFailed state is null");
            return;
        }
        g1(iState);
        int i2 = message.arg2;
        j1("handleRunningFailed arg2=" + i2);
        if (i2 == 0) {
            Q0(h0(g()), 18);
        }
    }

    public final void F0(IState iState) {
        if (iState != this.f) {
            j1("handleRunningSuccess is not RunningState");
            return;
        }
        j1("handleRunningSuccess mPhoneCallState=" + g0() + " ,mVoiceSetup=" + this.m + " ,mWechatReply=" + this.n);
        if (K0() && !this.j.A(true)) {
            h1(e(), 23);
        } else if (this.n.booleanValue()) {
            h1(e(), 24);
        } else if (this.m.booleanValue() || L0()) {
            j1("handleRunningSuccess assistant is on");
        } else {
            this.i.c();
        }
    }

    public final void G0(int i2, IState iState) {
        if (i2 == 1002) {
            s();
        } else if (i2 == 6001) {
            p0(iState);
        } else if (i2 == 6003) {
            o0(iState);
        } else if (i2 == 1010) {
            J0(iState);
        } else if (i2 == 1011) {
            I0(iState);
        } else if (i2 == 5000) {
            v0(iState);
        } else if (i2 == 5001) {
            u0(iState);
        } else if (i2 == 5003) {
            H0(iState);
        } else if (i2 != 5004) {
            switch (i2) {
                case 1006:
                    r0(iState);
                    return;
                case 1007:
                    q0(iState);
                    return;
                case 1008:
                    s0(iState);
                    return;
                default:
                    return;
            }
        } else {
            t0(iState);
        }
    }

    public final void H0(IState iState) {
        if (iState == null) {
            j1("handleWeakNetwork state is null");
        } else {
            Q0(h0(iState.getName()), 12);
        }
    }

    public final void I0(IState iState) {
        m0();
        if (iState == null) {
            j1("handleWechatOff state is null");
            return;
        }
        String name = iState.getName();
        int h0 = h0(name);
        j1("handleWechatOff wechatOnState name=" + name + " ,stateCode=" + h0);
        if (h0 == 4 || h0 == 5) {
            j1("handleWechatOff mPhoneCallState=" + g0() + " ,mVoiceSetup=" + this.m + " ,isScreenOff=" + M0());
            if (!L0() && !this.m.booleanValue() && !M0()) {
                this.i.c();
                Q0(h0, 26);
            }
        }
    }

    public final void J0(IState iState) {
        k0();
        if (iState == null) {
            j1("handleWechatOn state is null");
        } else if (iState == this.f) {
            this.i.d();
            Q0(4, 25);
            Y0(iState);
        }
    }

    public final boolean K0() {
        return this.l == 2;
    }

    public final boolean L0() {
        return this.l == 1;
    }

    public final boolean M0() {
        return this.o == 2;
    }

    public final void N0(Object obj) {
        this.k.a(obj);
    }

    public final void O0(Object obj) {
        this.k.b(obj);
    }

    public final void P0(Object obj) {
        this.k.d(obj);
    }

    public final void Q0(int i2, int i3) {
        this.k.c(i2, i3);
    }

    public final void R0() {
        this.l = 0;
    }

    public final void S0(IState iState) {
        if (iState == null) {
            j1("preparingShowWaiting state is null");
        } else if (iState == this.e || iState == this.g) {
            Q0(h0(iState.getName()), 16);
        } else {
            j1("not int preparing or stopping state.");
        }
    }

    public final void T0() {
        j1("voice incoming wechat etc, state reset");
        l0();
        R0();
        m0();
        w0();
    }

    public final void U0(IState iState, Message message) {
        if (iState != this.f) {
            j1("proximal result error state=" + iState);
        } else if (this.m.booleanValue() || this.n.booleanValue() || L0()) {
            j1("proximal result voiceSetUp=" + this.m + " ,wechatReply=" + this.n + " ,mPhoneCallState=" + g0());
        } else {
            N0(message.obj);
        }
    }

    public final void V0(IState iState, Message message) {
        if (iState != this.f) {
            j1("remote result error state=" + iState);
        } else if (this.m.booleanValue() || this.n.booleanValue() || L0()) {
            j1("remote result voiceSetUp=" + this.m + " ,wechatReply=" + this.n + " ,mPhoneCallState=" + g0());
        } else {
            O0(message.obj);
        }
    }

    public final void W0(IState iState) {
        if (iState != this.f) {
            j1("runningVoiceNotMute not in running state!");
            return;
        }
        j1("runningVoiceNotMute mVoiceSetup=" + this.m + " ,mWechatReply=" + this.n + " ,mPhoneCallState=" + g0());
        if (!this.m.booleanValue() && !this.n.booleanValue() && !L0()) {
            Q0(h0(iState.getName()), 20);
        }
    }

    public final void X0(IState iState) {
        if (iState == this.f) {
            h1(iState, 15);
        } else {
            j1("not int running state!");
        }
    }

    public final void Y0(IState iState) {
        if (iState == this.f) {
            Q0(h0(iState.getName()), 19);
        } else {
            j1("runningVoiceReduceFiveSecs not in running state");
        }
    }

    public final void Z0(IState iState) {
        if (iState != this.f) {
            j1("runningVoiceReduceTwoSecs not running state");
            return;
        }
        j1("runningVoiceReduceTwoSecs mVoiceSetup=" + this.m + " ,mWechatReply=" + this.n + " ,mPhoneCallState=" + g0());
        if (!this.m.booleanValue() && !this.n.booleanValue() && !L0()) {
            Q0(h0(iState.getName()), 14);
        }
    }

    public void a1() {
        g1(e());
        c1(1002);
    }

    public final void b1(int i2) {
        d1(MSG.MSG_END_STATE_EXTCODE, i2);
    }

    public void c1(int i2) {
        u(m(i2));
    }

    public void d1(int i2, int i3) {
        u(n(i2, i3));
    }

    public void e1(int i2, int i3, int i4) {
        u(o(i2, i3, i4));
    }

    public void f1(int i2, Object obj) {
        u(p(i2, obj));
    }

    public final String g0() {
        return InterconnectMsgCodExtKt.a(this.l);
    }

    public final void g1(IState iState) {
        h1(iState, -1);
    }

    public final int h0(String str) {
        if (TextUtils.equals(str, "Stopping")) {
            return 6;
        }
        if (TextUtils.equals(str, "Listening")) {
            return 5;
        }
        if (TextUtils.equals(str, "Running")) {
            return 4;
        }
        if (TextUtils.equals(str, "Preparing")) {
            return 3;
        }
        return TextUtils.equals(str, "End") ? 2 : 1;
    }

    public final void h1(IState iState, int i2) {
        if (iState == null) {
            j1("toTransEndState is error, state is null!");
            return;
        }
        j1("toTransEndState state=" + iState.getName() + " ,extCode=" + i2);
        State state = this.h;
        if (iState != state) {
            x(state);
        }
        b1(i2);
    }

    public void i(Message message) {
        j1("haltedProcessMessage what=" + message.what);
    }

    public final void i0() {
        d(this.d, (State) null);
        d(this.e, this.d);
        d(this.h, this.d);
        d(this.f, this.e);
        d(this.g, this.e);
        v(this.d);
    }

    public final void i1() {
        j1("transToPreparing mVoiceSetup=" + this.m + " ,mPhoneCallState=" + g0() + " ,mWechatReply=" + this.n);
        if ((K0() && !this.j.A(true)) || L0()) {
            h1(e(), 23);
        } else if (this.n.booleanValue()) {
            h1(e(), 24);
        } else {
            x(this.e);
        }
    }

    public final void j0() {
        this.m = Boolean.TRUE;
    }

    public final void j1(String str) {
        k1("TranslateStateMachine", str);
    }

    public final void k0() {
        this.n = Boolean.TRUE;
    }

    public final void k1(String str, String str2) {
        LogExt.j(str2, str);
    }

    public final void l0() {
        this.m = Boolean.FALSE;
    }

    public final void m0() {
        this.n = Boolean.FALSE;
    }

    public int n0() {
        if (e() == null) {
            return 1;
        }
        return h0(e().getName());
    }

    public final void o0(IState iState) {
        l0();
        if (iState == null) {
            j1("handleAssistantOff state is null");
            return;
        }
        String name = iState.getName();
        int h0 = h0(name);
        j1("handleAssistantOff voiceOnState name=" + name + " ,stateCode=" + h0);
        if (h0 == 4 || h0 == 5) {
            j1("handleAssistantOff mPhoneCallState=" + g0() + " ,mWechatReply=" + this.n + " ,isScreenOff=" + M0());
            if (!L0() && !this.n.booleanValue() && !M0()) {
                this.i.c();
                Q0(h0, 22);
            }
        }
    }

    public final void p0(IState iState) {
        j0();
        if (iState == null) {
            j1("handleAssistantOn state is null");
        } else if (iState == this.f) {
            this.i.d();
            Q0(4, 21);
            Y0(iState);
        }
    }

    public final void q0(IState iState) {
        R0();
        if (iState == null) {
            j1("handleCallStateIdle state is null");
            return;
        }
        String name = iState.getName();
        int h0 = h0(name);
        j1("handleCallStateIdle stateName=" + name + " ,stateCode=" + h0);
        if (h0 == 4 || h0 == 5) {
            j1("handleCallStateIdle mVoiceSetup=" + this.m + " ,mWechatReply=" + this.n + " ,screenOff=" + M0());
            if (!this.m.booleanValue() && !this.n.booleanValue() && !M0()) {
                this.i.c();
                Q0(h0, 27);
            }
        }
    }

    public final void r0(IState iState) {
        this.l = 2;
        if (iState == null) {
            j1("handleCallStateOffHook state is null");
        } else if (iState == this.f && !this.j.A(false)) {
            h1(iState, 23);
        }
    }

    public final void s0(IState iState) {
        this.l = 1;
        if (iState == null) {
            j1("handleCallStateRinging state is null");
        } else if (iState == this.f) {
            this.i.d();
            Q0(4, 28);
            Y0(iState);
        }
    }

    public final void t0(IState iState) {
        if (iState == null) {
            j1("handleConnectedGood state is null");
        } else {
            Q0(h0(iState.getName()), 13);
        }
    }

    public final void u0(IState iState) {
        if (iState == null) {
            j1("handleConnectedOff state is null");
            return;
        }
        if (iState != this.f) {
            g1(iState);
        }
        Q0(h0(iState.getName()), 11);
    }

    public final void v0(IState iState) {
        if (iState == null) {
            j1("handleConnectedOn state is null");
            return;
        }
        Q0(h0(iState.getName()), 10);
        if (iState == this.f) {
            this.j.C();
        }
    }

    public final void w0() {
        this.o = 0;
    }

    public final void x0() {
        this.o = 2;
        this.i.d();
        this.j.s();
        Q0(4, 35);
    }

    public final void y0() {
        this.o = 1;
        this.j.E();
        Q0(4, 34);
    }

    public final void z0(Message message, IState iState) {
        if (iState == null) {
            j1("handleGlassScreenState state is null");
        } else if (iState != this.f) {
            j1("handleGlassScreenState state is not RunningState");
        } else {
            int i2 = message.arg1;
            j1("handleGlassScreenState screenState" + InterconnectMsgCodExtKt.g(i2));
            if (i2 == 0) {
                w0();
            } else if (i2 == 1) {
                y0();
            } else if (i2 == 2) {
                x0();
            }
        }
    }
}
