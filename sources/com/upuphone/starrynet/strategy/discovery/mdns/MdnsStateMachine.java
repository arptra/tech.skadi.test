package com.upuphone.starrynet.strategy.discovery.mdns;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import com.upuphone.starrynet.strategy.statemachine.State;
import com.upuphone.starrynet.strategy.statemachine.StateMachine;
import com.xjsd.ai.assistant.protocol.AssistantConstants;

public final class MdnsStateMachine extends StateMachine {
    public static final int MSG_RESTART_AVD = 5;
    public static final int MSG_RESTART_SCAN = 6;
    public static final int MSG_START_AVD = 1;
    public static final int MSG_START_SCAN = 2;
    public static final int MSG_STOP_AVD = 3;
    public static final int MSG_STOP_SCAN = 4;
    public static final String TAG = "MdnsStateMachine";
    private State activeState = new ActiveState();
    private final Context mContext;
    /* access modifiers changed from: private */
    public final MdnsAdvertising mMdnsAdvertising;
    /* access modifiers changed from: private */
    public final MdnsDiscoveryImpl mMdnsDiscovery;

    public class ActiveState extends State {
        public ActiveState() {
        }

        private void sleep(long j) {
            try {
                Thread.sleep(j);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }

        public boolean processMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                MdnsStateMachine.this.startAdvertising();
            } else if (i == 2) {
                MdnsStateMachine.this.startDiscovery();
            } else if (i == 5) {
                sleep(250);
                MdnsStateMachine.this.mMdnsAdvertising.stopAdvertising();
                sleep(250);
                MdnsStateMachine.this.startAdvertising();
            } else if (i == 6) {
                sleep(250);
                MdnsStateMachine.this.mMdnsDiscovery.stopDiscovery();
                sleep(250);
                MdnsStateMachine.this.startDiscovery();
            }
            return super.processMessage(message);
        }
    }

    private MdnsStateMachine(Context context, Looper looper) {
        super(TAG, looper);
        this.mContext = context;
        this.mMdnsDiscovery = new MdnsDiscoveryImpl(context);
        this.mMdnsAdvertising = new MdnsAdvertising(context);
        addState(this.activeState);
        setInitialState(this.activeState);
    }

    public static MdnsStateMachine make(Context context, Looper looper) {
        MdnsStateMachine mdnsStateMachine = new MdnsStateMachine(context, looper);
        mdnsStateMachine.start();
        return mdnsStateMachine;
    }

    /* access modifiers changed from: private */
    public void startAdvertising() {
        if (!this.mMdnsAdvertising.startAdvertising()) {
            Message obtainMessage = obtainMessage();
            obtainMessage.what = 1;
            sendMessageDelayed(obtainMessage, (long) AssistantConstants.TIMEOUT_VAD_MUTE);
        }
    }

    /* access modifiers changed from: private */
    public void startDiscovery() {
        if (!this.mMdnsDiscovery.startDiscovery()) {
            Message obtainMessage = obtainMessage();
            obtainMessage.what = 2;
            sendMessageDelayed(obtainMessage, (long) AssistantConstants.TIMEOUT_VAD_MUTE);
        }
    }
}
