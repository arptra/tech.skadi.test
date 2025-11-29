package com.xjsd.ai.assistant.phone.cmd;

import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.xjsd.ai.assistant.common.Communicator;
import com.xjsd.ai.assistant.common.SessionHelper;
import com.xjsd.ai.assistant.common.handler.CmdHandler;
import com.xjsd.ai.assistant.connect.SendMsgCallback;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.tts.TtsAbility;
import com.xjsd.ai.assistant.core.api.tts.TtsData;
import com.xjsd.ai.assistant.core.api.tts.TtsListener;
import com.xjsd.ai.assistant.core.util.DeviceUtils;
import com.xjsd.ai.assistant.core.util.DotUtil;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.AudioFocusManageDelegate;
import com.xjsd.ai.assistant.phone.WakeupControlDelegate;
import com.xjsd.ai.assistant.phone.helper.ExitTimer;
import com.xjsd.ai.assistant.phone.tts.TtsDataTransform;
import com.xjsd.ai.assistant.phone.vad.VadAbility;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import com.xjsd.ai.assistant.protocol.Cmd;
import com.xjsd.ai.assistant.protocol.tts.TtsPlayReq;
import com.xjsd.ai.assistant.protocol.tts.TtsPlayRes;
import com.xjsd.ai.assistant.protocol.wakeup.WakeupControl;
import kotlin.Pair;
import org.greenrobot.eventbus.EventBus;

public class TtsPlayReqCmdHandler implements CmdHandler {

    public static final class TtsPlayCallback implements TtsListener {

        /* renamed from: a  reason: collision with root package name */
        public final TtsPlayReq f8547a;
        public final TtsPlayRes b;

        public final void a(final int i) {
            this.b.setPlayState(i);
            Communicator.b(6, this.b, new SendMsgCallback() {
                public void onFail(int i, String str) {
                    ILog.c("TtsPlayReqCmdHandler", "发送TTS播报状态->%d，失败->%s", Integer.valueOf(i), str);
                }

                public void onSuccess() {
                    ILog.c("TtsPlayReqCmdHandler", "发送TTS播报状态->%d，成功", Integer.valueOf(i));
                }
            });
        }

        public final void b(int i) {
            ExitTimer.f8563a.d();
            a(i);
            WakeupControl wakeupControl = this.f8547a.getWakeupControl();
            if (wakeupControl != null) {
                WakeupControlDelegate.g.i(wakeupControl);
            }
        }

        public void onDiscard() {
        }

        public void onSpeakEnd() {
            AudioFocusManageDelegate.a(2);
            if (this.f8547a.isWakeup()) {
                ILog.f("wake_up_on_speak_element_completed");
            } else {
                ILog.f("on_speak_element_completed");
            }
            if (TtsPlayReqCmdHandler.b(this.f8547a)) {
                ILog.c("TtsPlayReqCmdHandler", "session->%s过期，不用通知TTS播报状态", this.f8547a.getTtsData().getSessionId());
            } else {
                b(2);
            }
        }

        public void onSpeakError(String str) {
            AudioFocusManageDelegate.a(2);
            if (this.f8547a.isWakeup()) {
                ILog.f("wake_up_on_speak_element_completed");
            } else {
                ILog.f("on_speak_element_completed");
            }
            if (TtsPlayReqCmdHandler.b(this.f8547a)) {
                ILog.c("TtsPlayReqCmdHandler", "session->%s过期，不用通知TTS播报状态", this.f8547a.getTtsData().getSessionId());
            } else if (DeviceUtils.d()) {
                b(3);
            } else {
                a(3);
            }
        }

        public void onSpeakStart() {
            if (this.f8547a.isWakeup()) {
                ILog.f("wake_up_on_speak_element_started");
            } else {
                ILog.f("on_speak_element_started");
            }
            if (TtsPlayReqCmdHandler.b(this.f8547a)) {
                ILog.c("TtsPlayReqCmdHandler", "session->%s过期，此次播报请求被中断", this.f8547a.getTtsData().getSessionId());
                ((TtsAbility) AbilityManager.b.b(TtsAbility.class)).stopSpeak();
                return;
            }
            ExitTimer.f8563a.c();
            a(1);
        }

        public TtsPlayCallback(TtsPlayReq ttsPlayReq) {
            this.f8547a = ttsPlayReq;
            TtsPlayRes ttsPlayRes = new TtsPlayRes();
            this.b = ttsPlayRes;
            ttsPlayRes.setId(ttsPlayReq.getId());
            ttsPlayRes.setContinuous(ttsPlayReq.isContinuous());
            ttsPlayRes.setMulti(ttsPlayReq.isMulti());
            ttsPlayRes.setWakeup(ttsPlayReq.isWakeup());
        }
    }

    public static boolean b(TtsPlayReq ttsPlayReq) {
        if (DeviceUtils.d() || ttsPlayReq.isWakeup()) {
            return false;
        }
        return SessionHelper.f8413a.b(ttsPlayReq.getTtsData().getSessionId());
    }

    public int getHandleCode() {
        return 5;
    }

    public void handle(StarryNetMessage starryNetMessage, Cmd cmd) {
        VadAbility vadAbility;
        ILog.a("TtsPlayReqCmdHandler", "收到语音播报请求->" + starryNetMessage.getMessage());
        TtsPlayReq ttsPlayReq = (TtsPlayReq) cmd.parsePayload(TtsPlayReq.class);
        TtsData ttsData = ttsPlayReq.getTtsData();
        if (ttsData.getSource() != 0) {
            TtsDataTransform.f8607a.b(ttsData);
            EventBus.c().k(ttsData);
            return;
        }
        String sessionId = ttsPlayReq.getTtsData().getSessionId();
        if (sessionId == null) {
            sessionId = SessionHelper.f8413a.a();
        }
        DotUtil.d("receive_tts_req", new Pair(AssistantConstants.Key.SESSION_ID, sessionId));
        if (b(ttsPlayReq)) {
            ILog.c("TtsPlayReqCmdHandler", "session->%s过期，此次播报请求被中断", ttsData.getSessionId());
            return;
        }
        AbilityManager abilityManager = AbilityManager.b;
        TtsAbility ttsAbility = (TtsAbility) abilityManager.b(TtsAbility.class);
        if (ttsAbility != null) {
            ttsAbility.stopSpeak();
        }
        TtsDataTransform.f8607a.a(ttsData, ttsPlayReq.isWakeup());
        if (ttsAbility != null) {
            AudioFocusManageDelegate.a(1);
            if (ttsPlayReq.isWakeup() && (vadAbility = (VadAbility) abilityManager.b(VadAbility.class)) != null) {
                vadAbility.start();
            }
            ttsAbility.startSpeak(ttsData, new TtsPlayCallback(ttsPlayReq));
        }
    }
}
