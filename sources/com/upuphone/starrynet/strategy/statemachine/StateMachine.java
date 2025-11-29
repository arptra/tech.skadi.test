package com.upuphone.starrynet.strategy.statemachine;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.starrynet.common.StLog;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class StateMachine {
    public static final boolean HANDLED = true;
    public static final boolean NOT_HANDLED = false;
    private static final int SM_INIT_CMD = -2;
    private static final int SM_QUIT_CMD = -1;
    /* access modifiers changed from: private */
    public String mName;
    /* access modifiers changed from: private */
    public SmHandler mSmHandler;
    /* access modifiers changed from: private */
    public HandlerThread mSmThread;

    public static class LogRec {
        private IState mDstState;
        private String mInfo;
        private IState mOrgState;
        private StateMachine mSm;
        private IState mState;
        private long mTime;
        private int mWhat;

        public LogRec(StateMachine stateMachine, Message message, String str, IState iState, IState iState2, IState iState3) {
            update(stateMachine, message, str, iState, iState2, iState3);
        }

        public IState getDestState() {
            return this.mDstState;
        }

        public String getInfo() {
            return this.mInfo;
        }

        public IState getOriginalState() {
            return this.mOrgState;
        }

        public IState getState() {
            return this.mState;
        }

        public long getTime() {
            return this.mTime;
        }

        public long getWhat() {
            return (long) this.mWhat;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("time=");
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(this.mTime);
            sb.append(String.format("%tm-%td %tH:%tM:%tS.%tL", new Object[]{instance, instance, instance, instance, instance, instance}));
            sb.append(" processed=");
            IState iState = this.mState;
            String str = "<null>";
            sb.append(iState == null ? str : iState.getName());
            sb.append(" org=");
            IState iState2 = this.mOrgState;
            sb.append(iState2 == null ? str : iState2.getName());
            sb.append(" dest=");
            IState iState3 = this.mDstState;
            if (iState3 != null) {
                str = iState3.getName();
            }
            sb.append(str);
            sb.append(" what=");
            StateMachine stateMachine = this.mSm;
            String whatToString = stateMachine != null ? stateMachine.getWhatToString(this.mWhat) : "";
            if (TextUtils.isEmpty(whatToString)) {
                sb.append(this.mWhat);
                sb.append("(0x");
                sb.append(Integer.toHexString(this.mWhat));
                sb.append(")");
            } else {
                sb.append(whatToString);
            }
            if (!TextUtils.isEmpty(this.mInfo)) {
                sb.append(" ");
                sb.append(this.mInfo);
            }
            return sb.toString();
        }

        public void update(StateMachine stateMachine, Message message, String str, IState iState, IState iState2, IState iState3) {
            this.mSm = stateMachine;
            this.mTime = System.currentTimeMillis();
            this.mWhat = message != null ? message.what : 0;
            this.mInfo = str;
            this.mState = iState;
            this.mOrgState = iState2;
            this.mDstState = iState3;
        }
    }

    public static class LogRecords {
        private static final int DEFAULT_SIZE = 20;
        private int mCount;
        private boolean mLogOnlyTransitions;
        /* access modifiers changed from: private */
        public Vector<LogRec> mLogRecVector;
        private int mMaxSize;
        private int mOldestIndex;

        public synchronized void add(StateMachine stateMachine, Message message, String str, IState iState, IState iState2, IState iState3) {
            try {
                this.mCount++;
                if (this.mLogRecVector.size() < this.mMaxSize) {
                    this.mLogRecVector.add(new LogRec(stateMachine, message, str, iState, iState2, iState3));
                } else {
                    LogRec logRec = this.mLogRecVector.get(this.mOldestIndex);
                    int i = this.mOldestIndex + 1;
                    this.mOldestIndex = i;
                    if (i >= this.mMaxSize) {
                        this.mOldestIndex = 0;
                    }
                    logRec.update(stateMachine, message, str, iState, iState2, iState3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        public synchronized void cleanup() {
            this.mLogRecVector.clear();
        }

        public synchronized int count() {
            return this.mCount;
        }

        public synchronized LogRec get(int i) {
            int i2 = this.mOldestIndex + i;
            int i3 = this.mMaxSize;
            if (i2 >= i3) {
                i2 -= i3;
            }
            if (i2 >= size()) {
                return null;
            }
            return this.mLogRecVector.get(i2);
        }

        public synchronized boolean logOnlyTransitions() {
            return this.mLogOnlyTransitions;
        }

        public synchronized int maxSize() {
            return this.mMaxSize;
        }

        public synchronized void setLogOnlyTransitions(boolean z) {
            this.mLogOnlyTransitions = z;
        }

        public synchronized void setSize(int i) {
            this.mMaxSize = i;
            this.mOldestIndex = 0;
            this.mCount = 0;
            this.mLogRecVector.clear();
        }

        public synchronized int size() {
            return this.mLogRecVector.size();
        }

        private LogRecords() {
            this.mLogRecVector = new Vector<>();
            this.mMaxSize = 20;
            this.mOldestIndex = 0;
            this.mCount = 0;
            this.mLogOnlyTransitions = false;
        }
    }

    public static class SmHandler extends Handler {
        private static final Object mSmHandlerObj = new Object();
        /* access modifiers changed from: private */
        public boolean mDbg;
        /* access modifiers changed from: private */
        public ArrayList<Message> mDeferredMessages;
        /* access modifiers changed from: private */
        public State mDestState;
        /* access modifiers changed from: private */
        public HaltingState mHaltingState;
        private boolean mHasQuit;
        private State mInitialState;
        private boolean mIsConstructionCompleted;
        /* access modifiers changed from: private */
        public LogRecords mLogRecords;
        private Message mMsg;
        private QuittingState mQuittingState;
        /* access modifiers changed from: private */
        public StateMachine mSm;
        private HashMap<State, StateInfo> mStateInfo;
        /* access modifiers changed from: private */
        public StateInfo[] mStateStack;
        /* access modifiers changed from: private */
        public int mStateStackTopIndex;
        private StateInfo[] mTempStateStack;
        private int mTempStateStackCount;
        private boolean mTransitionInProgress;

        public class HaltingState extends State {
            private HaltingState() {
            }

            public boolean processMessage(Message message) {
                SmHandler.this.mSm.haltedProcessMessage(message);
                return true;
            }
        }

        public static class QuittingState extends State {
            private QuittingState() {
            }

            public boolean processMessage(Message message) {
                return false;
            }
        }

        public static class StateInfo {
            boolean active;
            StateInfo parentStateInfo;
            State state;

            private StateInfo() {
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("state=");
                sb.append(this.state.getName());
                sb.append(",active=");
                sb.append(this.active);
                sb.append(",parent=");
                StateInfo stateInfo = this.parentStateInfo;
                sb.append(stateInfo == null ? "null" : stateInfo.state.getName());
                return sb.toString();
            }
        }

        /* access modifiers changed from: private */
        public final StateInfo addState(State state, State state2) {
            StateInfo stateInfo;
            if (this.mDbg) {
                StateMachine stateMachine = this.mSm;
                StringBuilder sb = new StringBuilder();
                sb.append("addStateInternal: E state=");
                sb.append(state.getName());
                sb.append(",parent=");
                sb.append(state2 == null ? "" : state2.getName());
                stateMachine.log(sb.toString());
            }
            if (state2 != null) {
                stateInfo = this.mStateInfo.get(state2);
                if (stateInfo == null) {
                    stateInfo = addState(state2, (State) null);
                }
            } else {
                stateInfo = null;
            }
            StateInfo stateInfo2 = this.mStateInfo.get(state);
            if (stateInfo2 == null) {
                stateInfo2 = new StateInfo();
                this.mStateInfo.put(state, stateInfo2);
            }
            StateInfo stateInfo3 = stateInfo2.parentStateInfo;
            if (stateInfo3 == null || stateInfo3 == stateInfo) {
                stateInfo2.state = state;
                stateInfo2.parentStateInfo = stateInfo;
                stateInfo2.active = false;
                if (this.mDbg) {
                    this.mSm.log("addStateInternal: X stateInfo: " + stateInfo2);
                }
                return stateInfo2;
            }
            throw new RuntimeException("state already added");
        }

        private final void cleanupAfterQuitting() {
            if (this.mSm.mSmThread != null) {
                getLooper().quit();
                HandlerThread unused = this.mSm.mSmThread = null;
            }
            SmHandler unused2 = this.mSm.mSmHandler = null;
            this.mSm = null;
            this.mMsg = null;
            this.mLogRecords.cleanup();
            this.mStateStack = null;
            this.mTempStateStack = null;
            this.mStateInfo.clear();
            this.mInitialState = null;
            this.mDestState = null;
            this.mDeferredMessages.clear();
            this.mHasQuit = true;
        }

        /* access modifiers changed from: private */
        public final void completeConstruction() {
            if (this.mDbg) {
                this.mSm.log("completeConstruction: E");
            }
            int i = 0;
            for (StateInfo next : this.mStateInfo.values()) {
                int i2 = 0;
                while (next != null) {
                    next = next.parentStateInfo;
                    i2++;
                }
                if (i < i2) {
                    i = i2;
                }
            }
            if (this.mDbg) {
                this.mSm.log("completeConstruction: maxDepth=" + i);
            }
            this.mStateStack = new StateInfo[i];
            this.mTempStateStack = new StateInfo[i];
            setupInitialStateStack();
            sendMessageAtFrontOfQueue(obtainMessage(-2, mSmHandlerObj));
            if (this.mDbg) {
                this.mSm.log("completeConstruction: X");
            }
        }

        /* access modifiers changed from: private */
        public final void deferMessage(Message message) {
            if (this.mDbg) {
                StateMachine stateMachine = this.mSm;
                stateMachine.log("deferMessage: msg=" + message.what);
            }
            Message obtainMessage = obtainMessage();
            obtainMessage.copyFrom(message);
            this.mDeferredMessages.add(obtainMessage);
        }

        /* access modifiers changed from: private */
        public final Message getCurrentMessage() {
            return this.mMsg;
        }

        /* access modifiers changed from: private */
        public final IState getCurrentState() {
            return this.mStateStack[this.mStateStackTopIndex].state;
        }

        private final void invokeEnterMethods(int i) {
            int i2 = i;
            while (true) {
                int i3 = this.mStateStackTopIndex;
                if (i2 <= i3) {
                    if (i == i3) {
                        this.mTransitionInProgress = false;
                    }
                    if (this.mDbg) {
                        StateMachine stateMachine = this.mSm;
                        stateMachine.log("invokeEnterMethods: " + this.mStateStack[i2].state.getName());
                    }
                    this.mStateStack[i2].state.enter();
                    this.mStateStack[i2].active = true;
                    i2++;
                } else {
                    this.mTransitionInProgress = false;
                    return;
                }
            }
        }

        private final void invokeExitMethods(StateInfo stateInfo) {
            StateInfo stateInfo2;
            while (true) {
                int i = this.mStateStackTopIndex;
                if (i >= 0 && (stateInfo2 = this.mStateStack[i]) != stateInfo) {
                    State state = stateInfo2.state;
                    if (this.mDbg) {
                        StateMachine stateMachine = this.mSm;
                        stateMachine.log("invokeExitMethods: " + state.getName());
                    }
                    state.exit();
                    StateInfo[] stateInfoArr = this.mStateStack;
                    int i2 = this.mStateStackTopIndex;
                    stateInfoArr[i2].active = false;
                    this.mStateStackTopIndex = i2 - 1;
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: private */
        public final boolean isDbg() {
            return this.mDbg;
        }

        /* access modifiers changed from: private */
        public final boolean isQuit(Message message) {
            return message.what == -1 && message.obj == mSmHandlerObj;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$removeState$0(StateInfo stateInfo, StateInfo stateInfo2) {
            return stateInfo2.parentStateInfo == stateInfo;
        }

        private final void moveDeferredMessageAtFrontOfQueue() {
            for (int size = this.mDeferredMessages.size() - 1; size >= 0; size--) {
                Message message = this.mDeferredMessages.get(size);
                if (this.mDbg) {
                    this.mSm.log("moveDeferredMessageAtFrontOfQueue; what=" + message.what);
                }
                sendMessageAtFrontOfQueue(message);
            }
            this.mDeferredMessages.clear();
        }

        private final int moveTempStateStackToStateStack() {
            int i = this.mStateStackTopIndex + 1;
            int i2 = i;
            for (int i3 = this.mTempStateStackCount - 1; i3 >= 0; i3--) {
                if (this.mDbg) {
                    this.mSm.log("moveTempStackToStateStack: i=" + i3 + ",j=" + i2);
                }
                this.mStateStack[i2] = this.mTempStateStack[i3];
                i2++;
            }
            this.mStateStackTopIndex = i2 - 1;
            if (this.mDbg) {
                this.mSm.log("moveTempStackToStateStack: X mStateStackTop=" + this.mStateStackTopIndex + ",startingIndex=" + i + ",Top=" + this.mStateStack[this.mStateStackTopIndex].state.getName());
            }
            return i;
        }

        private void performTransitions(State state, Message message) {
            State state2 = this.mStateStack[this.mStateStackTopIndex].state;
            boolean z = this.mSm.recordLogRec(this.mMsg) && message.obj != mSmHandlerObj;
            if (this.mLogRecords.logOnlyTransitions()) {
                if (this.mDestState != null) {
                    LogRecords logRecords = this.mLogRecords;
                    StateMachine stateMachine = this.mSm;
                    Message message2 = this.mMsg;
                    logRecords.add(stateMachine, message2, stateMachine.getLogRecString(message2), state, state2, this.mDestState);
                }
            } else if (z) {
                LogRecords logRecords2 = this.mLogRecords;
                StateMachine stateMachine2 = this.mSm;
                Message message3 = this.mMsg;
                logRecords2.add(stateMachine2, message3, stateMachine2.getLogRecString(message3), state, state2, this.mDestState);
            }
            State state3 = this.mDestState;
            if (state3 != null) {
                while (true) {
                    if (this.mDbg) {
                        this.mSm.log("handleMessage: new destination call exit/enter");
                    }
                    StateInfo stateInfo = setupTempStateStackWithStatesToEnter(state3);
                    this.mTransitionInProgress = true;
                    invokeExitMethods(stateInfo);
                    invokeEnterMethods(moveTempStateStackToStateStack());
                    moveDeferredMessageAtFrontOfQueue();
                    State state4 = this.mDestState;
                    if (state3 == state4) {
                        break;
                    }
                    state3 = state4;
                }
                this.mDestState = null;
            }
            if (state3 == null) {
                return;
            }
            if (state3 == this.mQuittingState) {
                this.mSm.onQuitting();
                cleanupAfterQuitting();
            } else if (state3 == this.mHaltingState) {
                this.mSm.onHalting();
            }
        }

        private final State processMsg(Message message) {
            StateInfo stateInfo = this.mStateStack[this.mStateStackTopIndex];
            if (this.mDbg) {
                StateMachine stateMachine = this.mSm;
                stateMachine.log("processMsg: " + stateInfo.state.getName());
            }
            if (isQuit(message)) {
                transitionTo(this.mQuittingState);
            } else {
                while (true) {
                    if (stateInfo.state.processMessage(message)) {
                        break;
                    }
                    stateInfo = stateInfo.parentStateInfo;
                    if (stateInfo == null) {
                        this.mSm.unhandledMessage(message);
                        break;
                    } else if (this.mDbg) {
                        StateMachine stateMachine2 = this.mSm;
                        stateMachine2.log("processMsg: " + stateInfo.state.getName());
                    }
                }
            }
            if (stateInfo != null) {
                return stateInfo.state;
            }
            return null;
        }

        /* access modifiers changed from: private */
        public final void quit() {
            if (this.mDbg) {
                this.mSm.log("quit:");
            }
            sendMessage(obtainMessage(-1, mSmHandlerObj));
        }

        /* access modifiers changed from: private */
        public final void quitNow() {
            if (this.mDbg) {
                this.mSm.log("quitNow:");
            }
            sendMessageAtFrontOfQueue(obtainMessage(-1, mSmHandlerObj));
        }

        /* access modifiers changed from: private */
        public void removeState(State state) {
            StateInfo stateInfo = this.mStateInfo.get(state);
            if (stateInfo != null && !stateInfo.active && !this.mStateInfo.values().stream().filter(new a(stateInfo)).findAny().isPresent()) {
                this.mStateInfo.remove(state);
            }
        }

        /* access modifiers changed from: private */
        public final void setDbg(boolean z) {
            this.mDbg = z;
        }

        /* access modifiers changed from: private */
        public final void setInitialState(State state) {
            if (this.mDbg) {
                StateMachine stateMachine = this.mSm;
                stateMachine.log("setInitialState: initialState=" + state.getName());
            }
            this.mInitialState = state;
        }

        private final void setupInitialStateStack() {
            if (this.mDbg) {
                StateMachine stateMachine = this.mSm;
                stateMachine.log("setupInitialStateStack: E mInitialState=" + this.mInitialState.getName());
            }
            StateInfo stateInfo = this.mStateInfo.get(this.mInitialState);
            this.mTempStateStackCount = 0;
            while (stateInfo != null) {
                StateInfo[] stateInfoArr = this.mTempStateStack;
                int i = this.mTempStateStackCount;
                stateInfoArr[i] = stateInfo;
                stateInfo = stateInfo.parentStateInfo;
                this.mTempStateStackCount = i + 1;
            }
            this.mStateStackTopIndex = -1;
            moveTempStateStackToStateStack();
        }

        private final StateInfo setupTempStateStackWithStatesToEnter(State state) {
            this.mTempStateStackCount = 0;
            StateInfo stateInfo = this.mStateInfo.get(state);
            do {
                StateInfo[] stateInfoArr = this.mTempStateStack;
                int i = this.mTempStateStackCount;
                this.mTempStateStackCount = i + 1;
                stateInfoArr[i] = stateInfo;
                stateInfo = stateInfo.parentStateInfo;
                if (stateInfo == null || stateInfo.active) {
                }
                StateInfo[] stateInfoArr2 = this.mTempStateStack;
                int i2 = this.mTempStateStackCount;
                this.mTempStateStackCount = i2 + 1;
                stateInfoArr2[i2] = stateInfo;
                stateInfo = stateInfo.parentStateInfo;
                break;
            } while (stateInfo.active);
            if (this.mDbg) {
                StateMachine stateMachine = this.mSm;
                stateMachine.log("setupTempStateStackWithStatesToEnter: X mTempStateStackCount=" + this.mTempStateStackCount + ",curStateInfo: " + stateInfo);
            }
            return stateInfo;
        }

        /* access modifiers changed from: private */
        public final void transitionTo(IState iState) {
            if (this.mTransitionInProgress) {
                String access$700 = this.mSm.mName;
                StLog.w(access$700, "transitionTo called while transition already in progress to " + this.mDestState + ", new target state=" + iState);
            }
            this.mDestState = (State) iState;
            if (this.mDbg) {
                StateMachine stateMachine = this.mSm;
                stateMachine.log("transitionTo: destState=" + this.mDestState.getName());
            }
        }

        public final void handleMessage(Message message) {
            State state;
            int i;
            StateMachine stateMachine;
            int i2;
            int i3;
            if (!this.mHasQuit) {
                StateMachine stateMachine2 = this.mSm;
                if (!(stateMachine2 == null || (i3 = message.what) == -2 || i3 == -1)) {
                    stateMachine2.onPreHandleMessage(message);
                }
                StateMachine stateMachine3 = this.mSm;
                if (stateMachine3 != null && this.mDbg) {
                    stateMachine3.log("handleMessage: E msg.what=" + message.what);
                }
                this.mMsg = message;
                boolean z = this.mIsConstructionCompleted;
                if (z || (i2 = message.what) == -1) {
                    state = processMsg(message);
                } else if (!z && i2 == -2 && message.obj == mSmHandlerObj) {
                    this.mIsConstructionCompleted = true;
                    invokeEnterMethods(0);
                    state = null;
                } else {
                    throw new RuntimeException("StateMachine.handleMessage: The start method not called, received msg: " + message);
                }
                performTransitions(state, message);
                if (this.mDbg && (stateMachine = this.mSm) != null) {
                    stateMachine.log("handleMessage: X");
                }
                StateMachine stateMachine4 = this.mSm;
                if (stateMachine4 != null && (i = message.what) != -2 && i != -1) {
                    stateMachine4.onPostHandleMessage(message);
                }
            }
        }

        private SmHandler(Looper looper, StateMachine stateMachine) {
            super(looper);
            this.mHasQuit = false;
            this.mDbg = false;
            this.mLogRecords = new LogRecords();
            this.mStateStackTopIndex = -1;
            this.mHaltingState = new HaltingState();
            this.mQuittingState = new QuittingState();
            this.mStateInfo = new HashMap<>();
            this.mTransitionInProgress = false;
            this.mDeferredMessages = new ArrayList<>();
            this.mSm = stateMachine;
            addState(this.mHaltingState, (State) null);
            addState(this.mQuittingState, (State) null);
        }
    }

    public StateMachine(String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        this.mSmThread = handlerThread;
        handlerThread.start();
        initStateMachine(str, this.mSmThread.getLooper());
    }

    private void initStateMachine(String str, Looper looper) {
        this.mName = str;
        this.mSmHandler = new SmHandler(looper, this);
    }

    public void addLogRec(String str) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler != null) {
            smHandler.mLogRecords.add(this, smHandler.getCurrentMessage(), str, smHandler.getCurrentState(), smHandler.mStateStack[smHandler.mStateStackTopIndex].state, smHandler.mDestState);
        }
    }

    public final void addState(State state, State state2) {
        SmHandler.StateInfo unused = this.mSmHandler.addState(state, state2);
    }

    public final Collection<LogRec> copyLogRecs() {
        Vector vector = new Vector();
        SmHandler smHandler = this.mSmHandler;
        if (smHandler != null) {
            Iterator it = smHandler.mLogRecords.mLogRecVector.iterator();
            while (it.hasNext()) {
                vector.add((LogRec) it.next());
            }
        }
        return vector;
    }

    public final void deferMessage(Message message) {
        this.mSmHandler.deferMessage(message);
    }

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.println(getName() + AccountConstantKt.CODE_SEPARTOR);
        printWriter.println(" total records=" + getLogRecCount());
        for (int i = 0; i < getLogRecSize(); i++) {
            printWriter.println(" rec[" + i + "]: " + getLogRec(i));
            printWriter.flush();
        }
        IState currentState = getCurrentState();
        if (currentState != null) {
            printWriter.println("curState=" + currentState.getName());
        }
    }

    public final Message getCurrentMessage() {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return null;
        }
        return smHandler.getCurrentMessage();
    }

    public final IState getCurrentState() {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return null;
        }
        return smHandler.getCurrentState();
    }

    public final Handler getHandler() {
        return this.mSmHandler;
    }

    public final LogRec getLogRec(int i) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return null;
        }
        return smHandler.mLogRecords.get(i);
    }

    public final int getLogRecCount() {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return 0;
        }
        return smHandler.mLogRecords.count();
    }

    public final int getLogRecMaxSize() {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return 0;
        }
        return smHandler.mLogRecords.maxSize();
    }

    public final int getLogRecSize() {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return 0;
        }
        return smHandler.mLogRecords.size();
    }

    public String getLogRecString(Message message) {
        return "";
    }

    public final String getName() {
        return this.mName;
    }

    public String getWhatToString(int i) {
        return null;
    }

    public void haltedProcessMessage(Message message) {
    }

    public final boolean hasDeferredMessages(int i) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return false;
        }
        Iterator it = smHandler.mDeferredMessages.iterator();
        while (it.hasNext()) {
            if (((Message) it.next()).what == i) {
                return true;
            }
        }
        return false;
    }

    public final boolean hasMessages(int i) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return false;
        }
        return smHandler.hasMessages(i);
    }

    public boolean isDbg() {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler == null) {
            return false;
        }
        return smHandler.isDbg();
    }

    public final boolean isQuit(Message message) {
        SmHandler smHandler = this.mSmHandler;
        return smHandler == null ? message.what == -1 : smHandler.isQuit(message);
    }

    public void log(String str) {
        StLog.d(this.mName, str);
    }

    public void logAndAddLogRec(String str) {
        addLogRec(str);
        log(str);
    }

    public void logd(String str) {
        StLog.d(this.mName, str);
    }

    public void loge(String str) {
        StLog.e(this.mName, str);
    }

    public void logi(String str) {
        StLog.i(this.mName, str);
    }

    public void logv(String str) {
        StLog.v(this.mName, str);
    }

    public void logw(String str) {
        StLog.w(this.mName, str);
    }

    public final Message obtainMessage() {
        return Message.obtain(this.mSmHandler);
    }

    public void onHalting() {
    }

    public void onPostHandleMessage(Message message) {
    }

    public void onPreHandleMessage(Message message) {
    }

    public void onQuitting() {
    }

    public final void quit() {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler != null) {
            smHandler.quit();
        }
    }

    public final void quitNow() {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler != null) {
            smHandler.quitNow();
        }
    }

    public boolean recordLogRec(Message message) {
        return true;
    }

    public final void removeDeferredMessages(int i) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler != null) {
            Iterator it = smHandler.mDeferredMessages.iterator();
            while (it.hasNext()) {
                if (((Message) it.next()).what == i) {
                    it.remove();
                }
            }
        }
    }

    public final void removeMessages(int i) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler != null) {
            smHandler.removeMessages(i);
        }
    }

    public final void removeState(State state) {
        this.mSmHandler.removeState(state);
    }

    public void sendMessage(int i) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler != null) {
            smHandler.sendMessage(obtainMessage(i));
        }
    }

    public final void sendMessageAtFrontOfQueue(int i) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler != null) {
            smHandler.sendMessageAtFrontOfQueue(obtainMessage(i));
        }
    }

    public void sendMessageDelayed(int i, long j) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler != null) {
            smHandler.sendMessageDelayed(obtainMessage(i), j);
        }
    }

    public void setDbg(boolean z) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler != null) {
            smHandler.setDbg(z);
        }
    }

    public final void setInitialState(State state) {
        this.mSmHandler.setInitialState(state);
    }

    public final void setLogOnlyTransitions(boolean z) {
        this.mSmHandler.mLogRecords.setLogOnlyTransitions(z);
    }

    public final void setLogRecSize(int i) {
        this.mSmHandler.mLogRecords.setSize(i);
    }

    public void start() {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler != null) {
            smHandler.completeConstruction();
        }
    }

    public String toString() {
        String str;
        String str2 = "(null)";
        try {
            str = this.mName.toString();
            try {
                str2 = this.mSmHandler.getCurrentState().getName().toString();
            } catch (ArrayIndexOutOfBoundsException | NullPointerException unused) {
            }
        } catch (ArrayIndexOutOfBoundsException | NullPointerException unused2) {
            str = str2;
        }
        return "name=" + str + " state=" + str2;
    }

    public final void transitionTo(IState iState) {
        this.mSmHandler.transitionTo(iState);
    }

    public final void transitionToHaltingState() {
        SmHandler smHandler = this.mSmHandler;
        smHandler.transitionTo(smHandler.mHaltingState);
    }

    public void unhandledMessage(Message message) {
        if (this.mSmHandler.mDbg) {
            loge(" - unhandledMessage: msg.what=" + message.what);
        }
    }

    public final void addState(State state) {
        SmHandler.StateInfo unused = this.mSmHandler.addState(state, (State) null);
    }

    public void loge(String str, Throwable th) {
        StLog.e(this.mName, str, th);
    }

    public final Message obtainMessage(int i) {
        return Message.obtain(this.mSmHandler, i);
    }

    public final Message obtainMessage(int i, Object obj) {
        return Message.obtain(this.mSmHandler, i, obj);
    }

    public void sendMessage(int i, Object obj) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler != null) {
            smHandler.sendMessage(obtainMessage(i, obj));
        }
    }

    public final void sendMessageAtFrontOfQueue(int i, Object obj) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler != null) {
            smHandler.sendMessageAtFrontOfQueue(obtainMessage(i, obj));
        }
    }

    public void sendMessageDelayed(int i, Object obj, long j) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler != null) {
            smHandler.sendMessageDelayed(obtainMessage(i, obj), j);
        }
    }

    public final Message obtainMessage(int i, int i2) {
        return Message.obtain(this.mSmHandler, i, i2, 0);
    }

    public final Message obtainMessage(int i, int i2, int i3) {
        return Message.obtain(this.mSmHandler, i, i2, i3);
    }

    public void sendMessage(int i, int i2) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler != null) {
            smHandler.sendMessage(obtainMessage(i, i2));
        }
    }

    public final void sendMessageAtFrontOfQueue(int i, int i2) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler != null) {
            smHandler.sendMessageAtFrontOfQueue(obtainMessage(i, i2));
        }
    }

    public void sendMessageDelayed(int i, int i2, long j) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler != null) {
            smHandler.sendMessageDelayed(obtainMessage(i, i2), j);
        }
    }

    public StateMachine(String str, Looper looper) {
        initStateMachine(str, looper);
    }

    public final Message obtainMessage(int i, int i2, int i3, Object obj) {
        return Message.obtain(this.mSmHandler, i, i2, i3, obj);
    }

    public void sendMessage(int i, int i2, int i3) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler != null) {
            smHandler.sendMessage(obtainMessage(i, i2, i3));
        }
    }

    public final void sendMessageAtFrontOfQueue(int i, int i2, int i3) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler != null) {
            smHandler.sendMessageAtFrontOfQueue(obtainMessage(i, i2, i3));
        }
    }

    public void sendMessageDelayed(int i, int i2, int i3, long j) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler != null) {
            smHandler.sendMessageDelayed(obtainMessage(i, i2, i3), j);
        }
    }

    public StateMachine(String str, Handler handler) {
        initStateMachine(str, handler.getLooper());
    }

    public void sendMessage(int i, int i2, int i3, Object obj) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler != null) {
            smHandler.sendMessage(obtainMessage(i, i2, i3, obj));
        }
    }

    public final void sendMessageAtFrontOfQueue(int i, int i2, int i3, Object obj) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler != null) {
            smHandler.sendMessageAtFrontOfQueue(obtainMessage(i, i2, i3, obj));
        }
    }

    public void sendMessageDelayed(int i, int i2, int i3, Object obj, long j) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler != null) {
            smHandler.sendMessageDelayed(obtainMessage(i, i2, i3, obj), j);
        }
    }

    public void sendMessage(Message message) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler != null) {
            smHandler.sendMessage(message);
        }
    }

    public final void sendMessageAtFrontOfQueue(Message message) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler != null) {
            smHandler.sendMessageAtFrontOfQueue(message);
        }
    }

    public void sendMessageDelayed(Message message, long j) {
        SmHandler smHandler = this.mSmHandler;
        if (smHandler != null) {
            smHandler.sendMessageDelayed(message, j);
        }
    }
}
