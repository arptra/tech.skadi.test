package com.upuphone.ar.translation.statemachine.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.upuphone.star.core.log.ULog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Vector;

public class StateMachine {

    /* renamed from: a  reason: collision with root package name */
    public String f6346a;
    public SmHandler b;
    public HandlerThread c;

    public static class LogRec {

        /* renamed from: a  reason: collision with root package name */
        public StateMachine f6347a;
        public long b;
        public int c;
        public String d;
        public IState e;
        public IState f;
        public IState g;

        public LogRec(StateMachine stateMachine, Message message, String str, IState iState, IState iState2, IState iState3) {
            a(stateMachine, message, str, iState, iState2, iState3);
        }

        public void a(StateMachine stateMachine, Message message, String str, IState iState, IState iState2, IState iState3) {
            this.f6347a = stateMachine;
            this.b = System.currentTimeMillis();
            this.c = message != null ? message.what : 0;
            this.d = str;
            this.e = iState;
            this.f = iState2;
            this.g = iState3;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("time=");
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(this.b);
            sb.append(String.format("%tm-%td %tH:%tM:%tS.%tL", new Object[]{instance, instance, instance, instance, instance, instance}));
            sb.append(" processed=");
            IState iState = this.e;
            String str = "<null>";
            sb.append(iState == null ? str : iState.getName());
            sb.append(" org=");
            IState iState2 = this.f;
            sb.append(iState2 == null ? str : iState2.getName());
            sb.append(" dest=");
            IState iState3 = this.g;
            if (iState3 != null) {
                str = iState3.getName();
            }
            sb.append(str);
            sb.append(" what=");
            StateMachine stateMachine = this.f6347a;
            String h = stateMachine != null ? stateMachine.h(this.c) : "";
            if (TextUtils.isEmpty(h)) {
                sb.append(this.c);
                sb.append("(0x");
                sb.append(Integer.toHexString(this.c));
                sb.append(")");
            } else {
                sb.append(h);
            }
            if (!TextUtils.isEmpty(this.d)) {
                sb.append(" ");
                sb.append(this.d);
            }
            return sb.toString();
        }
    }

    public static final class LogRecords {

        /* renamed from: a  reason: collision with root package name */
        public final Vector f6348a;
        public int b;
        public int c;
        public int d;
        public boolean e;

        public synchronized void a(StateMachine stateMachine, Message message, String str, IState iState, IState iState2, IState iState3) {
            try {
                this.d++;
                if (this.f6348a.size() < this.b) {
                    this.f6348a.add(new LogRec(stateMachine, message, str, iState, iState2, iState3));
                } else {
                    LogRec logRec = (LogRec) this.f6348a.get(this.c);
                    int i = this.c + 1;
                    this.c = i;
                    if (i >= this.b) {
                        this.c = 0;
                    }
                    logRec.a(stateMachine, message, str, iState, iState2, iState3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        public synchronized void b() {
            this.f6348a.clear();
        }

        public synchronized boolean c() {
            return this.e;
        }

        public LogRecords() {
            this.f6348a = new Vector();
            this.b = 20;
            this.c = 0;
            this.d = 0;
            this.e = true;
        }
    }

    public static final class SmHandler extends Handler {
        public static final Object q = new Object();

        /* renamed from: a  reason: collision with root package name */
        public boolean f6349a;
        public boolean b;
        public Message c;
        public LogRecords d;
        public boolean e;
        public StateInfo[] f;
        public int g;
        public StateInfo[] h;
        public int i;
        public HaltingState j;
        public QuittingState k;
        public StateMachine l;
        public HashMap m;
        public State n;
        public State o;
        public ArrayList p;

        public class HaltingState extends State {
            public boolean c(Message message) {
                SmHandler.this.l.i(message);
                return true;
            }

            public HaltingState() {
            }
        }

        public static class QuittingState extends State {
            public boolean c(Message message) {
                return false;
            }

            public QuittingState() {
            }
        }

        public static class StateInfo {

            /* renamed from: a  reason: collision with root package name */
            public State f6351a;
            public StateInfo b;
            public boolean c;

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("state=");
                sb.append(this.f6351a.getName());
                sb.append(",active=");
                sb.append(this.c);
                sb.append(",parent=");
                StateInfo stateInfo = this.b;
                sb.append(stateInfo == null ? "null" : stateInfo.f6351a.getName());
                return sb.toString();
            }

            public StateInfo() {
            }
        }

        public static /* synthetic */ StateInfo q(State state) {
            return new StateInfo();
        }

        public final StateInfo A(State state) {
            this.i = 0;
            StateInfo stateInfo = (StateInfo) this.m.get(state);
            do {
                StateInfo[] stateInfoArr = this.h;
                int i2 = this.i;
                this.i = i2 + 1;
                stateInfoArr[i2] = stateInfo;
                stateInfo = stateInfo.b;
                if (stateInfo == null || stateInfo.c) {
                }
                StateInfo[] stateInfoArr2 = this.h;
                int i22 = this.i;
                this.i = i22 + 1;
                stateInfoArr2[i22] = stateInfo;
                stateInfo = stateInfo.b;
                break;
            } while (stateInfo.c);
            if (this.b) {
                StateMachine stateMachine = this.l;
                stateMachine.k("setupTempStateStackWithStatesToEnter: X mTempStateStackCount=" + this.i + ",curStateInfo: " + stateInfo);
            }
            return stateInfo;
        }

        public final void B(IState iState) {
            this.o = (State) iState;
            if (this.b) {
                StateMachine stateMachine = this.l;
                stateMachine.k("transitionTo: destState=" + this.o.getName());
            }
        }

        public void handleMessage(Message message) {
            State state;
            StateMachine stateMachine;
            if (!this.f6349a) {
                if (this.b) {
                    StateMachine stateMachine2 = this.l;
                    stateMachine2.k("handleMessage: E msg.what=" + message.what);
                }
                this.c = message;
                if (this.e) {
                    state = w(message);
                } else if (message.what == -2 && message.obj == q) {
                    this.e = true;
                    n(0);
                    state = null;
                } else {
                    throw new RuntimeException("StateMachine.handleMessage: The start method not called, received msg: " + message);
                }
                v(state, message);
                if (this.b && (stateMachine = this.l) != null) {
                    stateMachine.k("handleMessage: X");
                }
            }
        }

        public final StateInfo j(State state, State state2) {
            if (this.b) {
                StateMachine stateMachine = this.l;
                StringBuilder sb = new StringBuilder();
                sb.append("addStateInternal: E state=");
                sb.append(state.getName());
                sb.append(",parent=");
                sb.append(state2 == null ? "" : state2.getName());
                stateMachine.k(sb.toString());
            }
            StateInfo stateInfo = null;
            if (state2 != null) {
                StateInfo stateInfo2 = (StateInfo) this.m.get(state2);
                stateInfo = stateInfo2 == null ? j(state2, (State) null) : stateInfo2;
            }
            StateInfo stateInfo3 = (StateInfo) this.m.computeIfAbsent(state, new a());
            StateInfo stateInfo4 = stateInfo3.b;
            if (stateInfo4 == null || stateInfo4 == stateInfo) {
                stateInfo3.f6351a = state;
                stateInfo3.b = stateInfo;
                stateInfo3.c = false;
                if (this.b) {
                    StateMachine stateMachine2 = this.l;
                    stateMachine2.k("addStateInternal: X stateInfo: " + stateInfo3);
                }
                return stateInfo3;
            }
            throw new RuntimeException("state already added");
        }

        public final void k() {
            if (this.l.c != null) {
                getLooper().quit();
                this.l.c = null;
            }
            this.l.b = null;
            this.l = null;
            this.c = null;
            this.d.b();
            this.f = null;
            this.h = null;
            this.m.clear();
            this.n = null;
            this.o = null;
            this.p.clear();
            this.f6349a = true;
        }

        public final void l() {
            if (this.b) {
                this.l.k("completeConstruction: E");
            }
            int i2 = 0;
            for (StateInfo stateInfo : this.m.values()) {
                int i3 = 0;
                while (stateInfo != null) {
                    i3++;
                    stateInfo = stateInfo.b;
                }
                if (i2 < i3) {
                    i2 = i3;
                }
            }
            if (this.b) {
                this.l.k("completeConstruction: maxDepth=" + i2);
            }
            this.f = new StateInfo[i2];
            this.h = new StateInfo[i2];
            z();
            sendMessageAtFrontOfQueue(obtainMessage(-2, q));
            if (this.b) {
                this.l.k("completeConstruction: X");
            }
        }

        public final IState m() {
            return this.f[this.g].f6351a;
        }

        public final void n(int i2) {
            while (i2 <= this.g) {
                if (this.b) {
                    StateMachine stateMachine = this.l;
                    stateMachine.k("invokeEnterMethods: " + this.f[i2].f6351a.getName());
                }
                this.f[i2].f6351a.a();
                this.f[i2].c = true;
                i2++;
            }
        }

        public final void o(StateInfo stateInfo) {
            StateInfo stateInfo2;
            while (true) {
                int i2 = this.g;
                if (i2 >= 0 && (stateInfo2 = this.f[i2]) != stateInfo) {
                    State state = stateInfo2.f6351a;
                    if (this.b) {
                        StateMachine stateMachine = this.l;
                        stateMachine.k("invokeExitMethods: " + state.getName());
                    }
                    state.b();
                    StateInfo[] stateInfoArr = this.f;
                    int i3 = this.g;
                    stateInfoArr[i3].c = false;
                    this.g = i3 - 1;
                } else {
                    return;
                }
            }
        }

        public final boolean p(Message message) {
            return message.what == -1 && message.obj == q;
        }

        public final void r() {
            for (int size = this.p.size() - 1; size >= 0; size--) {
                Message message = (Message) this.p.get(size);
                if (this.b) {
                    this.l.k("moveDeferredMessageAtFrontOfQueue; what=" + message.what);
                }
                sendMessageAtFrontOfQueue(message);
            }
            this.p.clear();
        }

        public final int s() {
            int i2 = this.g + 1;
            int i3 = i2;
            for (int i4 = this.i - 1; i4 >= 0; i4--) {
                if (this.b) {
                    this.l.k("moveTempStackToStateStack: i=" + i4 + ",j=" + i3);
                }
                this.f[i3] = this.h[i4];
                i3++;
            }
            this.g = i3 - 1;
            if (this.b) {
                this.l.k("moveTempStackToStateStack: X mStateStackTop=" + this.g + ",startingIndex=" + i2 + ",Top=" + this.f[this.g].f6351a.getName());
            }
            return i2;
        }

        public final void t(State state, Message message) {
            State state2 = this.o;
            if (state2 != null) {
                while (true) {
                    if (this.b) {
                        this.l.k("handleMessage: new destination call exit/enter");
                    }
                    o(A(state2));
                    n(s());
                    r();
                    State state3 = this.o;
                    if (state2 == state3) {
                        break;
                    }
                    state2 = state3;
                }
                this.o = null;
            }
            if (state2 == null) {
                return;
            }
            if (state2 == this.k) {
                ULog.d("TrsP-StateMachine", "state machine cleanupAfterQuitting...");
                this.l.r();
                k();
            } else if (state2 == this.j) {
                this.l.q();
            }
        }

        public final void u(State state, Message message) {
            State state2 = this.f[this.g].f6351a;
            boolean z = this.l.t(this.c) && message.obj != q;
            if (this.d.c()) {
                if (this.o != null) {
                    LogRecords logRecords = this.d;
                    StateMachine stateMachine = this.l;
                    Message message2 = this.c;
                    logRecords.a(stateMachine, message2, stateMachine.f(message2), state, state2, this.o);
                }
            } else if (z) {
                LogRecords logRecords2 = this.d;
                StateMachine stateMachine2 = this.l;
                Message message3 = this.c;
                logRecords2.a(stateMachine2, message3, stateMachine2.f(message3), state, state2, this.o);
            }
        }

        public final void v(State state, Message message) {
            u(state, message);
            t(state, message);
        }

        public final State w(Message message) {
            StateInfo stateInfo = this.f[this.g];
            if (this.b) {
                StateMachine stateMachine = this.l;
                stateMachine.k("processMsg: " + stateInfo.f6351a.getName());
            }
            if (p(message)) {
                ULog.i("TrsP-StateMachine", "state machine do quit...");
                B(this.k);
            } else {
                while (true) {
                    if (stateInfo.f6351a.c(message)) {
                        break;
                    }
                    stateInfo = stateInfo.b;
                    if (stateInfo == null) {
                        this.l.y(message);
                        break;
                    } else if (this.b) {
                        StateMachine stateMachine2 = this.l;
                        stateMachine2.k("processMsg: " + stateInfo.f6351a.getName());
                    }
                }
            }
            if (stateInfo != null) {
                return stateInfo.f6351a;
            }
            return null;
        }

        public final void x() {
            if (this.b) {
                this.l.k("quitNow:");
            }
            sendMessageAtFrontOfQueue(obtainMessage(-1, q));
        }

        public final void y(State state) {
            if (this.b) {
                StateMachine stateMachine = this.l;
                stateMachine.k("setInitialState: initialState=" + state.getName());
            }
            this.n = state;
        }

        public final void z() {
            if (this.b) {
                StateMachine stateMachine = this.l;
                stateMachine.k("setupInitialStateStack: E mInitialState=" + this.n.getName());
            }
            StateInfo stateInfo = (StateInfo) this.m.get(this.n);
            this.i = 0;
            while (stateInfo != null) {
                StateInfo[] stateInfoArr = this.h;
                int i2 = this.i;
                stateInfoArr[i2] = stateInfo;
                stateInfo = stateInfo.b;
                this.i = i2 + 1;
            }
            this.g = -1;
            s();
        }

        public SmHandler(Looper looper, StateMachine stateMachine) {
            super(looper);
            this.f6349a = false;
            this.b = false;
            this.d = new LogRecords();
            this.g = -1;
            this.j = new HaltingState();
            this.k = new QuittingState();
            this.m = new HashMap();
            this.p = new ArrayList();
            this.l = stateMachine;
            j(this.j, (State) null);
            j(this.k, (State) null);
        }
    }

    public StateMachine(String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        this.c = handlerThread;
        handlerThread.start();
        j(str, this.c.getLooper());
    }

    public final void d(State state, State state2) {
        SmHandler.StateInfo unused = this.b.j(state, state2);
    }

    public final IState e() {
        SmHandler smHandler = this.b;
        if (smHandler != null) {
            return smHandler.m();
        }
        ULog.d("TrsP-StateMachine", "getCurrentStateCode:smh == null");
        return null;
    }

    public String f(Message message) {
        Log.i("getLogRecString", "msg=" + message);
        return "";
    }

    public final String g() {
        return this.f6346a;
    }

    public String h(int i) {
        Log.i("getWhatToString", "what=" + i);
        return null;
    }

    public void i(Message message) {
    }

    public final void j(String str, Looper looper) {
        this.f6346a = str;
        this.b = new SmHandler(looper, this);
    }

    public void k(String str) {
        ULog.i("TrsP-StateMachine" + this.f6346a, str);
    }

    public void l(String str) {
        Log.e(this.f6346a, str);
    }

    public final Message m(int i) {
        return Message.obtain(this.b, i);
    }

    public final Message n(int i, int i2) {
        return Message.obtain(this.b, i, i2, 0);
    }

    public final Message o(int i, int i2, int i3) {
        return Message.obtain(this.b, i, i2, i3);
    }

    public final Message p(int i, Object obj) {
        return Message.obtain(this.b, i, obj);
    }

    public void q() {
    }

    public void r() {
    }

    public final void s() {
        SmHandler smHandler = this.b;
        if (smHandler != null) {
            smHandler.x();
        }
    }

    public boolean t(Message message) {
        Log.i("recordLogRec", "msg=" + message);
        return true;
    }

    public final void u(Message message) {
        SmHandler smHandler = this.b;
        if (smHandler != null) {
            smHandler.sendMessage(message);
        }
    }

    public final void v(State state) {
        this.b.y(state);
    }

    public void w() {
        SmHandler smHandler = this.b;
        if (smHandler != null) {
            smHandler.l();
        }
    }

    public final void x(IState iState) {
        this.b.B(iState);
    }

    public void y(Message message) {
        if (this.b.b) {
            l(" - unhandledMessage: msg.what=" + message.what);
        }
    }
}
