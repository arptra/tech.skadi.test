package com.upuphone.ar.transcribe.statemachine.machine;

import android.os.Message;
import android.text.TextUtils;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.TranscribeManager;
import com.upuphone.ar.transcribe.statemachine.core.IState;
import com.upuphone.ar.transcribe.statemachine.core.State;
import com.upuphone.ar.transcribe.statemachine.core.StateMachine;
import com.upuphone.ar.transcribe.statemachine.handler.RecordStateHandler;
import com.upuphone.ar.transcribe.statemachine.handler.TranscribeResultHandler;
import com.upuphone.ar.transcribe.statemachine.handler.UiStateHandler;
import com.upuphone.ar.transcribe.statemachine.handler.XunFeiChannelHandler;

public class TranscribeStateMachine extends StateMachine {
    public final State d = new NotStartState();
    public final State e = new PreparingState();
    public final State f = new RunningState();
    public final State g = new StoppingState();
    public final State h = new EndState();
    public final TranscribeResultHandler i;
    public final RecordStateHandler j;
    public final XunFeiChannelHandler k;
    public final UiStateHandler l;
    public int m = 0;
    public Boolean n;
    public Boolean o;
    public int p;

    public class EndState extends State {
        public EndState() {
        }

        public void a() {
            TranscribeStateMachine transcribeStateMachine = TranscribeStateMachine.this;
            transcribeStateMachine.C1("TranslateStateMachine#End", "entering, State=" + getName());
            TranscribeStateMachine.this.j.b();
        }

        public void b() {
            TranscribeStateMachine transcribeStateMachine = TranscribeStateMachine.this;
            transcribeStateMachine.C1("TranslateStateMachine#End", "exiting, State=" + getName());
        }

        public boolean c(Message message) {
            int i = message.what;
            TranscribeStateMachine transcribeStateMachine = TranscribeStateMachine.this;
            transcribeStateMachine.C1("TranslateStateMachine#End", "processMessage msgId=" + i + ", State=" + getName());
            if (i == 1001) {
                TranscribeStateMachine.this.B1();
                return true;
            } else if (i == 1002) {
                TranscribeStateMachine.this.s();
                return true;
            } else if (i != 8001) {
                TranscribeStateMachine.this.V0(i);
                return true;
            } else {
                TranscribeStateMachine transcribeStateMachine2 = TranscribeStateMachine.this;
                transcribeStateMachine2.e1(transcribeStateMachine2.u0(getName()), message.arg1);
                return true;
            }
        }

        public String getName() {
            return "End";
        }
    }

    public static class MSG {
    }

    public class NotStartState extends State {
        public NotStartState() {
        }

        public void a() {
            TranscribeStateMachine transcribeStateMachine = TranscribeStateMachine.this;
            transcribeStateMachine.C1("TranslateStateMachine#NotStart", "entering, State=" + getName());
            TranscribeStateMachine.this.e1(1, -1);
        }

        public void b() {
            TranscribeStateMachine transcribeStateMachine = TranscribeStateMachine.this;
            transcribeStateMachine.C1("TranslateStateMachine#NotStart", "exiting, State=" + getName());
            TranscribeStateMachine.this.k1();
        }

        public boolean c(Message message) {
            int i = message.what;
            TranscribeStateMachine transcribeStateMachine = TranscribeStateMachine.this;
            transcribeStateMachine.C1("TranslateStateMachine#NotStart", "processMessage msgId=" + i + ", State=" + getName());
            if (i == 1001) {
                TranscribeStateMachine.this.B1();
                return true;
            } else if (i == 1002) {
                TranscribeStateMachine.this.s();
                return true;
            } else if (i == 2005) {
                TranscribeStateMachine.this.a1();
                return true;
            } else if (i == 5001) {
                return true;
            } else {
                TranscribeStateMachine.this.V0(i);
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
            TranscribeStateMachine transcribeStateMachine = TranscribeStateMachine.this;
            transcribeStateMachine.C1("TranslateStateMachine#Preparing", "entering, State=" + getName());
            TranscribeStateMachine.this.k.l();
            TranscribeStateMachine.this.e1(3, -1);
            TranscribeStateMachine.this.k.m();
            TranscribeStateMachine.this.j.a();
        }

        public void b() {
            TranscribeStateMachine transcribeStateMachine = TranscribeStateMachine.this;
            transcribeStateMachine.C1("TranslateStateMachine#Preparing", "exiting, State=" + getName());
            TranscribeStateMachine.this.k.q();
            TranscribeStateMachine.this.k.v();
        }

        public boolean c(Message message) {
            int i = message.what;
            IState m0 = TranscribeStateMachine.this.e();
            TranscribeStateMachine transcribeStateMachine = TranscribeStateMachine.this;
            transcribeStateMachine.C1("TranslateStateMachine#Preparing", "processMessage msgId=" + i + ", State=" + getName());
            if (i == 1001) {
                return true;
            }
            if (i == 1002) {
                TranscribeStateMachine.this.s();
                return true;
            } else if (i == 1010) {
                TranscribeStateMachine.this.Q0();
                return true;
            } else if (i == 1011) {
                TranscribeStateMachine.this.P0();
                return true;
            } else if (i == 4003) {
                TranscribeStateMachine.this.d1(message.obj);
                return true;
            } else if (i == 6001) {
                TranscribeStateMachine.this.C0();
                return true;
            } else if (i == 6003) {
                TranscribeStateMachine.this.B0();
                return true;
            } else if (i == 9001) {
                TranscribeStateMachine.this.A1(m0, 31);
                return true;
            } else if (i == 5000) {
                TranscribeStateMachine.this.Z0();
                return true;
            } else if (i == 5001) {
                TranscribeStateMachine.this.z1(m0);
                TranscribeStateMachine.this.Y0();
                return true;
            } else if (i == 5003) {
                TranscribeStateMachine.this.f1();
                return true;
            } else if (i != 5004) {
                switch (i) {
                    case 1006:
                        TranscribeStateMachine.this.E0();
                        return true;
                    case 1007:
                        TranscribeStateMachine.this.D0();
                        return true;
                    case 1008:
                        TranscribeStateMachine.this.F0();
                        return true;
                    default:
                        switch (i) {
                            case com.upuphone.ar.translation.statemachine.annotation.MSG.MSG_PREPARING_SUCCESS /*2001*/:
                                TranscribeStateMachine.this.M0(m0);
                                return true;
                            case com.upuphone.ar.translation.statemachine.annotation.MSG.MSG_IFLY_CONNECT_FAILED /*2002*/:
                                TranscribeStateMachine.this.K0(message, m0);
                                return true;
                            case com.upuphone.ar.translation.statemachine.annotation.MSG.MSG_PREPARING_RETRY /*2003*/:
                                TranscribeStateMachine.this.L0(m0);
                                return true;
                            case com.upuphone.ar.translation.statemachine.annotation.MSG.MSG_PREPARING_SHOW_WAITING /*2004*/:
                                TranscribeStateMachine.this.j1(m0);
                                return true;
                            default:
                                return false;
                        }
                }
            } else {
                TranscribeStateMachine.this.X0();
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
            TranscribeStateMachine transcribeStateMachine = TranscribeStateMachine.this;
            transcribeStateMachine.C1("TranslateStateMachine#Running", "entering, State=" + getName() + " ,voiceSetup=" + TranscribeStateMachine.this.n);
            TranscribeStateMachine.this.e1(4, -1);
            if (!TranscribeStateMachine.this.n.booleanValue()) {
                TranscribeStateMachine.this.j.c();
                return;
            }
            TranscribeStateMachine.this.e1(4, 21);
            TranscribeStateMachine transcribeStateMachine2 = TranscribeStateMachine.this;
            transcribeStateMachine2.p1(transcribeStateMachine2.e());
        }

        public void b() {
            TranscribeStateMachine transcribeStateMachine = TranscribeStateMachine.this;
            transcribeStateMachine.C1("TranslateStateMachine#Running", "exiting, State=" + getName());
            TranscribeStateMachine.this.j.d();
        }

        public boolean c(Message message) {
            int i = message.what;
            IState p0 = TranscribeStateMachine.this.e();
            TranscribeStateMachine transcribeStateMachine = TranscribeStateMachine.this;
            transcribeStateMachine.C1("TranslateStateMachine#Running", "processMessage msgId=" + i + ", State=" + getName());
            if (i == 1001) {
                TranscribeStateMachine.this.z1(p0);
                return true;
            } else if (i == 1002) {
                TranscribeStateMachine.this.s();
                return true;
            } else if (i == 1012) {
                TranscribeStateMachine.this.J0(message, p0);
                return true;
            } else if (i == 2005) {
                TranscribeStateMachine.this.a1();
                return true;
            } else if (i == 2001) {
                TranscribeStateMachine.this.O0(p0);
                return true;
            } else if (i != 2002) {
                switch (i) {
                    case com.upuphone.ar.translation.statemachine.annotation.MSG.MSG_VOICE_MUTE /*3001*/:
                        return true;
                    case com.upuphone.ar.translation.statemachine.annotation.MSG.MSG_VOICE_NOT_MUTE /*3002*/:
                        TranscribeStateMachine.this.n1(p0);
                        return true;
                    case com.upuphone.ar.translation.statemachine.annotation.MSG.MSG_VOICE_REDUCE_TWO_SECS /*3003*/:
                        TranscribeStateMachine.this.q1(p0);
                        return true;
                    case com.upuphone.ar.translation.statemachine.annotation.MSG.MSG_VOICE_REDUCE_FIVE_SECS /*3004*/:
                        TranscribeStateMachine.this.p1(p0);
                        return true;
                    case com.upuphone.ar.translation.statemachine.annotation.MSG.MSG_VOICE_REDUCE_FIVE_MINS /*3005*/:
                        TranscribeStateMachine.this.o1(p0);
                        return true;
                    default:
                        switch (i) {
                            case com.upuphone.ar.translation.statemachine.annotation.MSG.REMOTE_MSG_TRANSLATE_RESULT_SHOW /*4001*/:
                                TranscribeStateMachine.this.m1(p0, message);
                                return true;
                            case com.upuphone.ar.translation.statemachine.annotation.MSG.PROXIMAL_MSG_TRANSLATE_RESULT_SHOW /*4002*/:
                                TranscribeStateMachine.this.l1(p0, message);
                                return true;
                            case com.upuphone.ar.translation.statemachine.annotation.MSG.SERVER_MSG_TRANSLATE_RUNNING_STATE /*4003*/:
                                TranscribeStateMachine.this.d1(message.obj);
                                return true;
                            default:
                                TranscribeStateMachine.this.W0(i, p0, message);
                                return true;
                        }
                }
            } else {
                TranscribeStateMachine.this.N0(p0, message);
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
            TranscribeStateMachine transcribeStateMachine = TranscribeStateMachine.this;
            transcribeStateMachine.C1("TranslateStateMachine#Stopping", "entering, State=" + getName());
            TranscribeStateMachine.this.e1(6, -1);
        }

        public void b() {
            TranscribeStateMachine transcribeStateMachine = TranscribeStateMachine.this;
            transcribeStateMachine.C1("TranslateStateMachine#Stopping", "exiting, State=" + getName());
        }

        public boolean c(Message message) {
            int i = message.what;
            TranscribeStateMachine transcribeStateMachine = TranscribeStateMachine.this;
            transcribeStateMachine.C1("TranslateStateMachine#Stopping", "processMessage msgId=" + i + ", State=" + getName());
            if (i == 1001) {
                TranscribeStateMachine.this.B1();
                return true;
            } else if (i == 1002) {
                TranscribeStateMachine.this.s();
                return true;
            } else if (i == 5002 || i == 6002) {
                TranscribeStateMachine transcribeStateMachine2 = TranscribeStateMachine.this;
                transcribeStateMachine2.z1(transcribeStateMachine2.e());
                return true;
            } else {
                TranscribeStateMachine.this.V0(i);
                return true;
            }
        }

        public String getName() {
            return "Stopping";
        }
    }

    public TranscribeStateMachine(TranscribeResultHandler transcribeResultHandler, RecordStateHandler recordStateHandler, XunFeiChannelHandler xunFeiChannelHandler, UiStateHandler uiStateHandler) {
        super("ARTranslatorStateMachine");
        Boolean bool = Boolean.FALSE;
        this.n = bool;
        this.o = bool;
        this.p = 0;
        this.i = transcribeResultHandler;
        this.j = recordStateHandler;
        this.k = xunFeiChannelHandler;
        this.l = uiStateHandler;
        v0();
    }

    public int A0() {
        if (e() == null) {
            return 1;
        }
        return u0(e().getName());
    }

    public final void A1(IState iState, int i2) {
        if (iState == null) {
            C1("TranslateStateMachine", "toTransEndState is error, state is null!");
            return;
        }
        C1("TranslateStateMachine", "toTransEndState state=" + iState + " ,extCode=" + i2);
        State state = this.h;
        if (iState != state) {
            x(state);
        }
        s1(i2);
    }

    public final void B0() {
        IState e2 = e();
        if (e2 == null) {
            C1("TranslateStateMachine", "handleAssistantOff currentState is null");
            y0();
            return;
        }
        String name = e2.getName();
        int u0 = u0(name);
        C1("TranslateStateMachine", "handleAssistantOff voiceOnState name=" + name + " ,stateCode=" + u0);
        if (u0 == 4 || u0 == 5) {
            C1("TranslateStateMachine", "handleAssistantOff: mPhoneCallState=" + this.m + " ,mWechatReply=" + this.o + ", glass screen: " + this.p);
            if (S0() || R0() || this.o.booleanValue() || T0()) {
                y0();
                return;
            }
            this.j.c();
            e1(u0, 22);
            y0();
            return;
        }
        y0();
    }

    public final void B1() {
        C1("TranslateStateMachine", "transToPreparing mVoiceSetup=" + this.n + " ,mPhoneCallState=" + this.m + " ,mWechatReply=" + this.o);
        if (U0() && (R0() || S0())) {
            A1(e(), 23);
        } else if (this.o.booleanValue()) {
            A1(e(), 24);
        } else {
            x(this.e);
        }
    }

    public final void C0() {
        w0();
        IState e2 = e();
        if (e2 == null) {
            C1("TranslateStateMachine", "handleAssistantOn currentState is null");
            y0();
            return;
        }
        C1("TranslateStateMachine", "handleAssistantOn currentState name=" + e2.getName());
        if (e2 == this.f) {
            this.j.d();
            e1(u0(e2.getName()), 21);
            p1(e2);
        }
    }

    public final void C1(String str, String str2) {
        LogExt.g(str2, str);
    }

    public final void D0() {
        IState e2 = e();
        if (e2 == null) {
            C1("TranslateStateMachine", "handleCallStateIdle currentState is null");
            g1();
            return;
        }
        String name = e2.getName();
        int u0 = u0(name);
        C1("TranslateStateMachine", "handleCallStateIdle stateName=" + name + " ,stateCode=" + u0);
        if (u0 == 4 || u0 == 5) {
            C1("TranslateStateMachine", "handleCallStateIdle mVoiceSetup=" + this.n + " ,mWechatReply=" + this.o + ", glass screen: " + this.p);
            if (this.n.booleanValue() || this.o.booleanValue() || T0()) {
                g1();
                return;
            }
            this.j.c();
            e1(u0, 27);
            g1();
            return;
        }
        g1();
    }

    public final void E0() {
        h1();
        IState e2 = e();
        if (e2 == null) {
            C1("TranslateStateMachine", "handleCallStateRinging currentState is null");
            g1();
            return;
        }
        C1("TranslateStateMachine", "handleCallStateRinging currentState name=" + e2.getName());
        if (e2 == this.f) {
            this.j.d();
            int u0 = u0(e2.getName());
            e1(u0, 29);
            e1(u0, 23);
            p1(e2);
        }
    }

    public final void F0() {
        i1();
        IState e2 = e();
        if (e2 == null) {
            C1("TranslateStateMachine", "handleCallStateRinging currentState is null");
            g1();
            return;
        }
        C1("TranslateStateMachine", "handleCallStateRinging currentState name=" + e2.getName());
        if (e2 == this.f) {
            this.j.d();
            e1(u0(e2.getName()), 28);
            p1(e2);
        }
    }

    public final void G0() {
        this.p = 0;
    }

    public final void H0() {
        this.p = 2;
        this.j.d();
        this.k.h();
    }

    public final void I0() {
        this.p = 1;
        this.k.p();
        e1(4, 34);
    }

    public final void J0(Message message, IState iState) {
        if (iState == null) {
            C1("TranslateStateMachine", "handleGlassScreenState state is null");
        } else if (iState != this.f) {
            C1("TranslateStateMachine", "handleGlassScreenState state is not RunningState");
        } else {
            int i2 = message.arg1;
            C1("TranslateStateMachine", "handleGlassScreenState screenState: " + i2);
            if (i2 == 0) {
                G0();
            } else if (i2 == 1) {
                I0();
            } else if (i2 == 2) {
                H0();
            }
        }
    }

    public final void K0(Message message, IState iState) {
        int i2 = message.arg1;
        int i3 = message.arg2;
        C1("TranslateStateMachine", "handlePreparingFailed arg1=" + i2 + " ,arg2=" + i3);
        if (i2 == 100) {
            z1(iState);
        } else if (iState == this.e) {
            z1(iState);
        } else {
            State state = this.g;
            if (iState != state) {
                x(state);
            }
        }
        if (i3 == 0) {
            e1(u0(iState.getName()), 18);
        }
    }

    public final void L0(IState iState) {
        z1(iState);
    }

    public final void M0(IState iState) {
        C1("TranslateStateMachine", "handlePreparingSuccess mPhoneCallState=" + this.m + " ,mVoiceSetup=" + this.n + " ,mWechatReply=" + this.o);
        if (U0() && (R0() || S0())) {
            A1(e(), 23);
        } else if (this.o.booleanValue()) {
            A1(e(), 24);
        } else {
            State state = this.f;
            if (iState != state) {
                x(state);
            } else {
                C1("TranslateStateMachine", "in running state. not transition.");
            }
        }
    }

    public final void N0(IState iState, Message message) {
        if (iState == null) {
            C1("TranslateStateMachine", "handleRunningFailed state is null");
            return;
        }
        z1(iState);
        int i2 = message.arg2;
        C1("TranslateStateMachine", "handleRunningFailed arg2=" + i2);
        if (i2 == 0) {
            e1(u0(g()), 18);
        }
    }

    public final void O0(IState iState) {
        C1("TranslateStateMachine", "handleRunningSuccess mPhoneCallState=" + iState.getName() + " ,mVoiceSetup=" + this.n + " ,mWechatReply=" + this.o);
        if ((R0() && U0()) || S0()) {
            A1(e(), 23);
        } else if (this.o.booleanValue()) {
            A1(e(), 24);
        } else if (this.n.booleanValue()) {
            C1("TranslateStateMachine", "handleRunningSuccess assistant is on");
        } else {
            this.j.c();
        }
    }

    public final void P0() {
        IState e2 = e();
        if (e2 == null) {
            C1("TranslateStateMachine", "handleWechatOff currentState is null");
            z0();
            return;
        }
        String name = e2.getName();
        int u0 = u0(name);
        C1("TranslateStateMachine", "handleWechatOff wechatOnState name=" + name + " ,stateCode=" + u0);
        if (u0 == 4 || u0 == 5) {
            C1("TranslateStateMachine", "handleWechatOff mPhoneCallState=" + this.m + " ,mVoiceSetup=" + this.n + ", glass screen: " + this.p);
            if (S0() || this.n.booleanValue() || T0()) {
                z0();
                return;
            }
            this.j.c();
            e1(u0, 26);
            z0();
            return;
        }
        z0();
    }

    public final void Q0() {
        x0();
        IState e2 = e();
        if (e2 == null) {
            C1("TranslateStateMachine", "handleWechatOn currentState is null");
            z0();
            return;
        }
        C1("TranslateStateMachine", "handleWechatOn currentState name=" + e2.getName());
        if (e2 == this.f) {
            this.j.d();
            e1(u0(e2.getName()), 25);
            p1(e2);
        }
    }

    public final boolean R0() {
        return this.m == 2;
    }

    public final boolean S0() {
        return this.m == 1;
    }

    public final boolean T0() {
        return this.p == 2;
    }

    public final boolean U0() {
        return TranscribeManager.g().l() == 1;
    }

    public final void V0(int i2) {
        if (i2 == 1010) {
            Q0();
        } else if (i2 == 1011) {
            P0();
        } else if (i2 == 5000) {
            Z0();
        } else if (i2 == 5001) {
            z1(e());
            Y0();
        } else if (i2 == 5003) {
            f1();
        } else if (i2 == 5004) {
            X0();
        } else if (i2 == 6001) {
            C0();
        } else if (i2 != 6003) {
            switch (i2) {
                case 1005:
                case 1007:
                    D0();
                    return;
                case 1006:
                    E0();
                    return;
                case 1008:
                    F0();
                    return;
                default:
                    return;
            }
        } else {
            B0();
        }
    }

    public final void W0(int i2, IState iState, Message message) {
        if (i2 == 1010) {
            Q0();
        } else if (i2 == 1011) {
            P0();
        } else if (i2 == 2002) {
            z1(iState);
            int i3 = message.arg2;
            C1("TranslateStateMachine", "mutualExclusionToStop arg2=" + i3);
            if (i3 == 0) {
                e1(u0(iState.getName()), 18);
            }
        } else if (i2 == 6001) {
            C0();
        } else if (i2 == 6003) {
            B0();
        } else if (i2 == 5000) {
            this.k.o();
            Z0();
        } else if (i2 == 5001) {
            Y0();
        } else if (i2 == 5003) {
            f1();
        } else if (i2 != 5004) {
            switch (i2) {
                case 1005:
                case 1007:
                    D0();
                    return;
                case 1006:
                    E0();
                    return;
                case 1008:
                    if (this.p != 2) {
                        F0();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            X0();
        }
    }

    public final void X0() {
        if (e() != null) {
            e1(u0(e().getName()), 13);
        }
    }

    public final void Y0() {
        if (e() != null) {
            e1(u0(e().getName()), 11);
        }
    }

    public final void Z0() {
        if (e() != null) {
            e1(u0(e().getName()), 10);
        }
    }

    public final void a1() {
        if (e() != null) {
            e1(u0(e().getName()), 17);
        }
    }

    public final void b1(Object obj) {
        this.i.b(obj);
    }

    public final void c1(Object obj) {
        this.i.c(obj);
    }

    public final void d1(Object obj) {
        this.i.d(obj);
    }

    public final void e1(int i2, int i3) {
        this.l.b(i2, i3);
    }

    public final void f1() {
        IState e2 = e();
        if (e2 != null) {
            e1(u0(e2.getName()), 12);
        }
    }

    public final void g1() {
        this.m = 0;
    }

    public final void h1() {
        this.m = 2;
    }

    public void i(Message message) {
        C1("TranslateStateMachine", "haltedProcessMessage what=" + message.what);
    }

    public final void i1() {
        this.m = 1;
    }

    public final void j1(IState iState) {
        if (iState == this.e || iState == this.g) {
            e1(u0(iState.getName()), 16);
        } else {
            C1("TranslateStateMachine", "not int preparing or stopping state.");
        }
    }

    public final void k1() {
        C1("TranslateStateMachine", "voice incoming wechat etc, state reset");
        y0();
        g1();
        z0();
        this.p = 0;
    }

    public final void l1(IState iState, Message message) {
        if (iState != this.f) {
            C1("TranslateStateMachine", "proximal result error state=" + iState);
        } else if (this.n.booleanValue() || this.o.booleanValue() || S0()) {
            C1("TranslateStateMachine", "proximal result voiceSetUp=" + this.n + " ,wechatReply=" + this.o + " ,mPhoneCallState=" + this.m);
        } else {
            b1(message.obj);
        }
    }

    public final void m1(IState iState, Message message) {
        if (iState != this.f) {
            C1("TranslateStateMachine", "remote result error state=" + iState);
        } else if (this.n.booleanValue() || this.o.booleanValue() || S0()) {
            C1("TranslateStateMachine", "remote result voiceSetUp=" + this.n + " ,wechatReply=" + this.o + " ,mPhoneCallState=" + this.m);
        } else {
            c1(message.obj);
        }
    }

    public final void n1(IState iState) {
        if (iState != this.f) {
            C1("TranslateStateMachine", "runningVoiceNotMute not in running state!");
            return;
        }
        C1("TranslateStateMachine", "runningVoiceNotMute mVoiceSetup=" + this.n + " ,mWechatReply=" + this.o + " ,mPhoneCallState=" + this.m);
        if (!this.n.booleanValue() && !this.o.booleanValue() && !S0()) {
            e1(u0(iState.getName()), 20);
        }
    }

    public final void o1(IState iState) {
        if (iState == this.f) {
            A1(iState, 15);
        } else {
            C1("TranslateStateMachine", "not int running state!");
        }
    }

    public final void p1(IState iState) {
        if (iState == this.f) {
            e1(u0(iState.getName()), 19);
        } else {
            C1("TranslateStateMachine", "runningVoiceReduceFiveSecs not in running state");
        }
    }

    public final void q1(IState iState) {
        if (iState != this.f) {
            C1("TranslateStateMachine", "runningVoiceReduceTwoSecs not running state");
            return;
        }
        C1("TranslateStateMachine", "runningVoiceReduceTwoSecs mVoiceSetup=" + this.n + " ,mWechatReply=" + this.o + " ,mPhoneCallState=" + this.m);
        if (!this.n.booleanValue() && !this.o.booleanValue() && !S0()) {
            e1(u0(iState.getName()), 14);
        }
    }

    public void r1() {
        z1(e());
        t1(1002);
    }

    public final void s1(int i2) {
        u1(com.upuphone.ar.translation.statemachine.annotation.MSG.MSG_END_STATE_EXTCODE, i2);
    }

    public void t1(int i2) {
        u(m(i2));
    }

    public final int u0(String str) {
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

    public void u1(int i2, int i3) {
        u(n(i2, i3));
    }

    public final void v0() {
        d(this.d, (State) null);
        d(this.e, this.d);
        d(this.h, this.d);
        d(this.f, this.e);
        d(this.g, this.e);
        v(this.d);
    }

    public void v1(int i2, int i3, int i4) {
        u(o(i2, i3, i4));
    }

    public final void w0() {
        this.n = Boolean.TRUE;
    }

    public void w1(int i2, Object obj) {
        u(p(i2, obj));
    }

    public final void x0() {
        this.o = Boolean.TRUE;
    }

    public void x1() {
        t1(1001);
    }

    public final void y0() {
        this.n = Boolean.FALSE;
    }

    public void y1() {
        t1(com.upuphone.ar.translation.statemachine.annotation.MSG.MSG_VOICE_NOT_MUTE);
    }

    public final void z0() {
        this.o = Boolean.FALSE;
    }

    public final void z1(IState iState) {
        A1(iState, -1);
    }
}
