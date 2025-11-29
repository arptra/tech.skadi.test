package com.xjsd.ai.assistant.phone;

import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.honey.account.ha.g;
import com.honey.account.ha.h;
import com.honey.account.ha.i;
import com.xjsd.ai.assistant.audio.AudioDataUtil;
import com.xjsd.ai.assistant.chatgpt.ChatGptAbility;
import com.xjsd.ai.assistant.common.Communicator;
import com.xjsd.ai.assistant.common.SessionHelper;
import com.xjsd.ai.assistant.common.manager.VuiHandlerManager;
import com.xjsd.ai.assistant.connect.SendMsgCallback;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.core.util.DotUtil;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.nlu.NluAbility;
import com.xjsd.ai.assistant.nlu.bean.NluResponse;
import com.xjsd.ai.assistant.nlu.bean.TalkInfo;
import com.xjsd.ai.assistant.phone.event.ComponentsInitOverEvent;
import com.xjsd.ai.assistant.phone.event.UserAbortEvent;
import com.xjsd.ai.assistant.phone.helper.AssistantProtocolHelper;
import com.xjsd.ai.assistant.phone.helper.ExitTimer;
import com.xjsd.ai.assistant.phone.helper.VrStateSynchronizer;
import com.xjsd.ai.assistant.phone.session.Session;
import com.xjsd.ai.assistant.phone.tts.UniqueTtsPlayBuilder;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import com.xjsd.ai.assistant.protocol.Scene;
import com.xjsd.ai.assistant.protocol.wakeup.WakeupControl;
import com.xjsd.ai.assistant.skill.navigation.NavManager;
import com.xjsd.ai.assistant.skill.navigation.custom.CustomizedNavManager;
import java.util.UUID;
import java.util.function.Consumer;
import kotlin.Pair;
import kotlin.Unit;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class WakeupControlDelegate implements Consumer<NluResponse> {
    public static final WakeupControlDelegate g = new WakeupControlDelegate();

    /* renamed from: a  reason: collision with root package name */
    public boolean f8538a = false;
    public CacheAbility b;
    public ChatGptAbility c;
    public volatile Session d = null;
    public HandlerThread e = new HandlerThread("WakeupControl");
    public Handler f;

    public WakeupControlDelegate() {
        EventBus.c().o(this);
        AbilityManager abilityManager = AbilityManager.b;
        this.b = (CacheAbility) abilityManager.b(CacheAbility.class);
        this.c = (ChatGptAbility) abilityManager.b(ChatGptAbility.class);
        this.e.start();
        this.f = new Handler(this.e.getLooper()) {
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1000) {
                    ILog.a("WakeupControlDelegate", "handleMessage: launch vr");
                    WakeupControlDelegate.this.h((WakeupControl) message.obj);
                    ILog.a("WakeupControlDelegate", "handleMessage: launch vr over");
                } else if (i != 1001) {
                    ILog.a("WakeupControlDelegate", "暂不支持处理此消息");
                } else {
                    ILog.a("WakeupControlDelegate", "handleMessage: stop vr");
                    WakeupControlDelegate.this.g();
                    ILog.a("WakeupControlDelegate", "handleMessage: stop vr over");
                }
            }
        };
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0014, code lost:
        r2 = com.xjsd.ai.assistant.phone.helper.NluDataParser.a(r3);
     */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void accept(com.xjsd.ai.assistant.nlu.bean.NluResponse r3) {
        /*
            r2 = this;
            r0 = 0
            r2.p(r0)
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r2 = r2.b
            java.lang.String r0 = "wechatCleanContextFlag"
            java.lang.String r1 = ""
            r2.cache(r0, r1)
            boolean r2 = com.xjsd.ai.assistant.core.util.DeviceUtils.d()
            if (r2 == 0) goto L_0x004f
            com.xjsd.ai.assistant.protocol.VuiModel r2 = com.xjsd.ai.assistant.phone.helper.NluDataParser.a(r3)
            com.xjsd.ai.assistant.protocol.vui.Header r3 = r2.getHeader()
            if (r3 == 0) goto L_0x004f
            java.lang.String r0 = r3.getNamespace()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x004f
            java.lang.String r0 = r3.getNamespace()
            java.lang.String r1 = "navigation"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x004f
            java.lang.String r0 = r3.getName()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x004f
            java.lang.String r3 = r3.getName()
            java.lang.String r0 = "NaviDirective"
            boolean r3 = r3.equalsIgnoreCase(r0)
            if (r3 == 0) goto L_0x004f
            com.xjsd.ai.assistant.common.manager.VuiHandlerManager r3 = com.xjsd.ai.assistant.common.manager.VuiHandlerManager.d
            r3.e(r2)
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.WakeupControlDelegate.accept(com.xjsd.ai.assistant.nlu.bean.NluResponse):void");
    }

    public final void g() {
        ExitTimer.f8563a.c();
        if (!this.f8538a) {
            ILog.a("WakeupControlDelegate", "handleClose: isVrRunning->false");
            return;
        }
        this.f8538a = false;
        this.b.cache(AssistantConstants.Key.SCENE_ID, "");
        CacheAbility cacheAbility = this.b;
        Boolean bool = Boolean.FALSE;
        cacheAbility.cache("isVrRunning", bool);
        this.b.cache("wechat_transfer", bool);
        SessionHelper.f8413a.c("-1");
        VuiHandlerManager.d.g((String) null);
        AudioDataUtil.h();
        o();
        p(true);
        if (((Boolean) this.b.getCacheWithDefault("continuous_dialogue", bool)).booleanValue() && ((Integer) this.b.getCacheWithDefault("rejectTimesInRound", 0)).intValue() > 0) {
            int intValue = ((Integer) this.b.getCacheWithDefault("roundTimes", 0)).intValue() + 1;
            this.b.cache("rejectRoundTimes", Integer.valueOf(intValue));
            this.b.cache("rejectTimesInRound", 0);
            Communicator.b(114, Integer.valueOf(intValue), new SendMsgCallback() {
                public void onFail(int i, String str) {
                    ILog.j("WakeupControlDelegate", "同步拒识轮数出错->" + str);
                }

                public void onSuccess() {
                    ILog.j("WakeupControlDelegate", "同步拒识轮数成功");
                }
            });
        }
        this.c.handleExit();
        EventBus.c().k(new UserAbortEvent());
        ILog.f("handle_close_finish");
    }

    public final void h(WakeupControl wakeupControl) {
        if (!AssistantProtocolHelper.g() || AssistantProtocolHelper.h()) {
            m(wakeupControl);
        } else {
            n();
        }
    }

    public void i(WakeupControl wakeupControl) {
        ILog.a("WakeupControlDelegate", "手机端处理唤醒流程，类型->" + wakeupControl.getControl());
        int control = wakeupControl.getControl();
        Intent intent = new Intent("com.ai.voice.assistant.WAKEUP_STATUS");
        intent.putExtra("isWakeup", control != 0);
        LocalBroadcastManager.b(ContextHelper.a()).d(intent);
        Message obtainMessage = this.f.obtainMessage();
        if (control == 0) {
            AudioFocusManageDelegate.a(0);
            obtainMessage.what = 1001;
        } else {
            DotUtil.e("receive_wakeup");
            obtainMessage.what = 1000;
            obtainMessage.obj = wakeupControl;
        }
        this.f.sendMessage(obtainMessage);
    }

    public final /* synthetic */ Unit k() {
        VrStateSynchronizer.b(0);
        AssistantProtocolHelper.j(4);
        i(new WakeupControl(0));
        return null;
    }

    public final /* synthetic */ Unit l() {
        VrStateSynchronizer.b(0);
        AssistantProtocolHelper.j(4);
        i(new WakeupControl(0));
        return null;
    }

    public final void m(WakeupControl wakeupControl) {
        int control = wakeupControl.getControl();
        this.f8538a = true;
        this.b.cache("isNavigating", Boolean.valueOf(SuperAppAbilityManager.e().f().isNaving()));
        CacheAbility cacheAbility = this.b;
        Boolean bool = Boolean.FALSE;
        cacheAbility.cache("isVadStart", bool);
        this.b.cache("isVrRunning", Boolean.TRUE);
        this.b.cache("wakeupTime", Long.valueOf(System.currentTimeMillis()));
        this.b.cache("lastWakeupType", Integer.valueOf(control));
        String uuid = UUID.randomUUID().toString();
        SessionHelper.f8413a.c(uuid);
        DotUtil.d("generate_trace_id", new Pair(AssistantConstants.Key.SESSION_ID, uuid));
        ILog.d("uuid", uuid);
        AudioDataUtil.g(false);
        if (control != 7) {
            q(wakeupControl);
        }
        if ((control == 2 || control == 6) && this.d != null && this.d.d()) {
            ILog.a("WakeupControlDelegate", "复用session->" + this.d.b());
            this.d.i();
            this.d.g(uuid);
            return;
        }
        boolean booleanValue = ((Boolean) this.b.getCacheWithDefault("isNetworkAvailable", bool)).booleanValue();
        if (control == 4 && booleanValue) {
            if (wakeupControl.getScene().equals(Scene.NAVIGATION)) {
                CustomizedNavManager.c().f(wakeupControl.getExtra());
            }
            String k = NavManager.j().k(wakeupControl.getExtra());
            ILog.c("WakeupControlDelegate", "performWakeup: 定制唤醒extra->%s", k);
            NluAbility nluAbility = (NluAbility) AbilityManager.b.b(NluAbility.class);
            if (nluAbility != null) {
                nluAbility.talkNlu(new TalkInfo(uuid, k, true), this);
            }
        }
        o();
        Session.Builder builder = new Session.Builder();
        builder.b(uuid);
        builder.c(wakeupControl);
        Session a2 = builder.a();
        a2.f();
        this.d = a2;
    }

    public final void n() {
        new UniqueTtsPlayBuilder().e(R.string.tts_refuse_protocol).h(new g()).f(new h(this)).g(new i(this)).a().d();
    }

    public final void o() {
        if (this.d != null) {
            ILog.a("WakeupControlDelegate", "release old session->" + this.d.b());
            if (!this.d.e()) {
                this.d.a();
            }
            this.d = null;
        }
    }

    @Subscribe
    public void onReceiveComponentsInitOverEvent(ComponentsInitOverEvent componentsInitOverEvent) {
        AbilityManager abilityManager = AbilityManager.b;
        this.b = (CacheAbility) abilityManager.b(CacheAbility.class);
        this.c = (ChatGptAbility) abilityManager.b(ChatGptAbility.class);
    }

    public void p(boolean z) {
        if (z) {
            this.b.cache(AssistantConstants.Key.CLEAN_CONTEXT, Boolean.TRUE);
            CacheAbility cacheAbility = this.b;
            Boolean bool = Boolean.FALSE;
            cacheAbility.cache("isInChatGptScene", bool);
            this.b.cache("isGptCosplay", bool);
            return;
        }
        this.b.cache(AssistantConstants.Key.CLEAN_CONTEXT, Boolean.FALSE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void q(com.xjsd.ai.assistant.protocol.wakeup.WakeupControl r15) {
        /*
            r14 = this;
            int r0 = r15.getControl()
            r1 = 2
            r2 = 11
            r3 = 3
            r4 = 4
            r5 = 1
            r6 = 0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            if (r0 != r1) goto L_0x0016
            r1 = r5
            r8 = r6
        L_0x0013:
            r9 = r8
        L_0x0014:
            r10 = r9
            goto L_0x0031
        L_0x0016:
            if (r0 != r4) goto L_0x001c
            r8 = r5
            r1 = r6
            r9 = r1
            goto L_0x0014
        L_0x001c:
            if (r0 == r3) goto L_0x002d
            if (r0 != r2) goto L_0x0021
            goto L_0x002d
        L_0x0021:
            r1 = 10
            if (r0 != r1) goto L_0x002a
            r10 = r5
            r1 = r6
            r8 = r1
            r9 = r8
            goto L_0x0031
        L_0x002a:
            r1 = r6
            r8 = r1
            goto L_0x0013
        L_0x002d:
            r9 = r5
            r1 = r6
            r8 = r1
            r10 = r8
        L_0x0031:
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r11 = r14.b
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            java.lang.String r13 = "canPlayTts"
            r11.cache(r13, r12)
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r11 = r14.b
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            java.lang.String r12 = "isMultiWakeup"
            r11.cache(r12, r1)
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r1 = r14.b
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            java.lang.String r11 = "isContinuousWakeup"
            r1.cache(r11, r8)
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r1 = r14.b
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r9)
            java.lang.String r9 = "isAsrOnlyWakeup"
            r1.cache(r9, r8)
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r1 = r14.b
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r10)
            java.lang.String r9 = "isChatGptWakeup"
            r1.cache(r9, r8)
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r1 = r14.b
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
            java.lang.String r9 = "wakeupType"
            r1.cache(r9, r8)
            java.lang.String r1 = r15.getScene()
            if (r0 == r5) goto L_0x0081
            r8 = 5
            if (r0 == r8) goto L_0x0081
            if (r0 == r3) goto L_0x0081
            if (r0 == r2) goto L_0x0081
            if (r0 != r4) goto L_0x0082
        L_0x0081:
            r6 = r5
        L_0x0082:
            java.lang.String r0 = "roundTimes"
            if (r6 == 0) goto L_0x00c1
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r2 = r14.b
            java.lang.String r3 = "sceneId"
            r2.cache(r3, r1)
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r1 = r14.b
            java.lang.String r2 = "muteTimeout"
            java.lang.Long r15 = r15.getMuteTimeout()
            r1.cache(r2, r15)
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r15 = r14.b
            java.lang.String r1 = "lastNluQuery"
            java.lang.String r2 = ""
            r15.cache(r1, r2)
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r15 = r14.b
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            java.lang.String r2 = "isSoundOpened"
            r15.cache(r2, r1)
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r15 = r14.b
            r15.cache(r0, r7)
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r15 = r14.b
            java.lang.String r0 = "rejectTimesInRound"
            r15.cache(r0, r7)
            com.xjsd.ai.assistant.skill.navigation.NavHelper.b()
            com.xjsd.ai.assistant.skill.navigation.custom.CustomizedNavManager r15 = com.xjsd.ai.assistant.skill.navigation.custom.CustomizedNavManager.c()
            r15.e()
            goto L_0x00d3
        L_0x00c1:
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r15 = r14.b
            java.lang.String r1 = "rejectRoundTimes"
            java.lang.Object r15 = r15.getCacheWithDefault(r1, r7)
            java.lang.Integer r15 = (java.lang.Integer) r15
            r15.intValue()
            com.xjsd.ai.assistant.core.api.cache.CacheAbility r1 = r14.b
            r1.cache(r0, r15)
        L_0x00d3:
            if (r6 == 0) goto L_0x00de
            boolean r15 = com.xjsd.ai.assistant.common.util.CacheUtil.c()
            if (r15 != 0) goto L_0x00de
            r14.p(r5)
        L_0x00de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.WakeupControlDelegate.q(com.xjsd.ai.assistant.protocol.wakeup.WakeupControl):void");
    }
}
