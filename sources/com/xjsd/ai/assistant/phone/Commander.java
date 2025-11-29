package com.xjsd.ai.assistant.phone;

import android.app.Application;
import android.content.Context;
import com.honey.account.ha.a;
import com.honey.account.ha.b;
import com.honey.account.ha.c;
import com.honey.account.ha.d;
import com.honey.account.ha.e;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.xjsd.ai.assistant.adapt.ImDelegator;
import com.xjsd.ai.assistant.adapt.MainPlatformAdapter;
import com.xjsd.ai.assistant.asr.AsrComponent;
import com.xjsd.ai.assistant.audio.AudioRecordComponent;
import com.xjsd.ai.assistant.cache.CacheComponent;
import com.xjsd.ai.assistant.cloud.CloudComponent;
import com.xjsd.ai.assistant.common.Communicator;
import com.xjsd.ai.assistant.common.ContinuousDialogDispatcher;
import com.xjsd.ai.assistant.common.UnSupportFeatureManager;
import com.xjsd.ai.assistant.common.handler.CmdHandler;
import com.xjsd.ai.assistant.common.manager.BusinessHandlerManager;
import com.xjsd.ai.assistant.common.manager.CmdHandlerManager;
import com.xjsd.ai.assistant.common.manager.VuiHandlerManager;
import com.xjsd.ai.assistant.connect.InterconnectAbility;
import com.xjsd.ai.assistant.connect.InterconnectComponent;
import com.xjsd.ai.assistant.connect.SendMsgCallback;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.Component;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.core.factory.ThreadPoolFactory;
import com.xjsd.ai.assistant.core.util.DeviceUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.log.ULogger;
import com.xjsd.ai.assistant.nlg.NlgComponent;
import com.xjsd.ai.assistant.nlu.NluComponent;
import com.xjsd.ai.assistant.phone.business.SettingsBusinessHandler;
import com.xjsd.ai.assistant.phone.business.WechatBusinessHandler;
import com.xjsd.ai.assistant.phone.cmd.AccessibilityShotCmdHandler;
import com.xjsd.ai.assistant.phone.cmd.AudioDataTransCmdHandler;
import com.xjsd.ai.assistant.phone.cmd.HotWordTransCmdHandler;
import com.xjsd.ai.assistant.phone.cmd.RequestAudioFocusCmdHandler;
import com.xjsd.ai.assistant.phone.cmd.ResetVadStatusCmdHandler;
import com.xjsd.ai.assistant.phone.cmd.ResetVrListeningTimeCmdHandler;
import com.xjsd.ai.assistant.phone.cmd.SyncSysInfoReqCmdHandler;
import com.xjsd.ai.assistant.phone.cmd.TtsPlayReqCmdHandler;
import com.xjsd.ai.assistant.phone.cmd.VadEventTransCmdHandler;
import com.xjsd.ai.assistant.phone.cmd.VoiceWakeupCmdHandler;
import com.xjsd.ai.assistant.phone.cmd.WakeupAudioCmdHandler;
import com.xjsd.ai.assistant.phone.cmd.WakeupAudioStateCmdHandler;
import com.xjsd.ai.assistant.phone.cmd.WakeupReqCmdHandler;
import com.xjsd.ai.assistant.phone.event.ComponentsInitOverEvent;
import com.xjsd.ai.assistant.phone.event.NetworkEvent;
import com.xjsd.ai.assistant.phone.export.AmrWbStrategy;
import com.xjsd.ai.assistant.phone.export.FeedAudioDataToCloudStrategy;
import com.xjsd.ai.assistant.phone.export.OpusStrategy;
import com.xjsd.ai.assistant.phone.helper.AssistantSettingUtils;
import com.xjsd.ai.assistant.phone.helper.HotWordMaintainer;
import com.xjsd.ai.assistant.phone.helper.WakeupVoiceStorage;
import com.xjsd.ai.assistant.phone.vad.VadComponent;
import com.xjsd.ai.assistant.phone.vui.ApplicationVuiHandler;
import com.xjsd.ai.assistant.phone.vui.ChatVuiHandler;
import com.xjsd.ai.assistant.phone.vui.GlobalVuiHandler;
import com.xjsd.ai.assistant.phone.vui.LlmVuiHandler;
import com.xjsd.ai.assistant.phone.vui.MediaVuiHandler;
import com.xjsd.ai.assistant.phone.vui.SettingsVuiHandler;
import com.xjsd.ai.assistant.phone.vui.TranslateVuiHandler;
import com.xjsd.ai.assistant.phone.vui.VspErrorVuiHandler;
import com.xjsd.ai.assistant.phone.vui.WeatherVuiHandler;
import com.xjsd.ai.assistant.phone.vui.WechatVuiHandler;
import com.xjsd.ai.assistant.phone.vui.interceptor.DomainCrossInterceptor;
import com.xjsd.ai.assistant.phone.vui.interceptor.LlmInterceptor;
import com.xjsd.ai.assistant.phone.vui.interceptor.STKSInterceptor;
import com.xjsd.ai.assistant.phone.vui.interceptor.SpecialVuiInterceptor;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import com.xjsd.ai.assistant.protocol.BusinessData;
import com.xjsd.ai.assistant.protocol.Cmd;
import com.xjsd.ai.assistant.protocol.sys.SyncSysInfoReq;
import com.xjsd.ai.assistant.protocol.sys.SyncSysInfoRes;
import com.xjsd.ai.assistant.protocol.wakeup.WakeupControl;
import com.xjsd.ai.assistant.skill.alarm.AlarmBusinessHandler;
import com.xjsd.ai.assistant.skill.alarm.AlarmVuiHandler;
import com.xjsd.ai.assistant.skill.call.PhoneCallBusinessHandler;
import com.xjsd.ai.assistant.skill.call.PhoneCallVuiHandler;
import com.xjsd.ai.assistant.skill.navigation.NavigationBusinessHandler;
import com.xjsd.ai.assistant.skill.navigation.NavigationVuiHandler;
import com.xjsd.ai.assistant.skill.schedule.ScheduleBusinessHandler;
import com.xjsd.ai.assistant.skill.schedule.ScheduleVuiHandler;
import com.xjsd.ai.assistant.skill.todo.TodoBusinessHandler;
import com.xjsd.ai.assistant.skill.todo.TodoVuiHandler;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class Commander implements CmdHandler {
    private static final String TAG = "Commander";
    private volatile boolean isInit = false;
    private boolean isInterconnected = false;
    private boolean isNetworkAvailable = false;
    private final BusinessHandlerManager mBusinessHandlerManager = new BusinessHandlerManager();
    private CacheAbility mCacheAbility;
    private final CmdHandlerManager mCmdHandlerManager = new CmdHandlerManager();
    private Context mContext;
    private InterconnectAbility mInterconnectAbility;
    private final SuperAppAbilityManager mSuperAppAbilityManager = SuperAppAbilityManager.e();
    private final VuiHandlerManager mVuiHandlerManager = VuiHandlerManager.d;

    /* access modifiers changed from: private */
    public void handleDeviceConnection(StarryNetDevice starryNetDevice, boolean z) {
        ILog.a(TAG, "收到设备连接状态回调，设备->" + starryNetDevice + "，是否已连接->" + z);
        this.isInterconnected = z;
        String modelId = starryNetDevice.getModelId();
        if (z) {
            this.mCacheAbility.cache("isAir", Boolean.valueOf("1003".equals(modelId)));
            this.mCacheAbility.cache("glassType", modelId);
            this.mCacheAbility.getPersistValue("IotDeviceId");
            syncPhoneInfo2Glass();
            this.mSuperAppAbilityManager.l();
            HotWordMaintainer.f8564a.h();
            WakeupVoiceStorage.INSTANCE.sync();
        } else {
            WakeupControlDelegate.g.i(new WakeupControl(0));
            this.mCacheAbility.remove("isAir");
            HotWordMaintainer.f8564a.c();
        }
        ImDelegator.f8381a.d().e(z);
    }

    /* access modifiers changed from: private */
    public void handleReceiveRemoteMsg(StarryNetMessage starryNetMessage) {
        if (starryNetMessage.getSenderPkg().equals(AssistantConstants.APPLICATION_ID)) {
            try {
                Cmd parse = Cmd.parse(starryNetMessage.getMessage());
                if (parse != null) {
                    this.mCmdHandlerManager.c(starryNetMessage, parse);
                } else {
                    ILog.a(TAG, "解析Cmd对象为空");
                }
            } catch (Exception e) {
                ILog.h(TAG, "解析数据为Cmd数据失败，尝试解析为其他应用转发消息", e);
            }
        }
    }

    private void initBusinessHandlers() {
        this.mBusinessHandlerManager.a(new PhoneCallBusinessHandler());
        this.mBusinessHandlerManager.a(new WechatBusinessHandler());
        this.mBusinessHandlerManager.a(new NavigationBusinessHandler());
        this.mBusinessHandlerManager.a(new AlarmBusinessHandler());
        this.mBusinessHandlerManager.a(new SettingsBusinessHandler());
        this.mBusinessHandlerManager.a(new ScheduleBusinessHandler());
        this.mBusinessHandlerManager.a(new TodoBusinessHandler());
    }

    private void initCmdHandlers() {
        this.mCmdHandlerManager.a(this);
        this.mCmdHandlerManager.a(new SyncSysInfoReqCmdHandler());
        this.mCmdHandlerManager.a(new WakeupReqCmdHandler());
        this.mCmdHandlerManager.a(new AccessibilityShotCmdHandler());
        this.mCmdHandlerManager.a(new TtsPlayReqCmdHandler());
        this.mCmdHandlerManager.a(new HotWordTransCmdHandler());
        this.mCmdHandlerManager.a(new VadEventTransCmdHandler());
        this.mCmdHandlerManager.a(AudioDataTransCmdHandler.a());
        this.mCmdHandlerManager.a(new ResetVadStatusCmdHandler());
        this.mCmdHandlerManager.a(new VoiceWakeupCmdHandler());
        this.mCmdHandlerManager.a(new ResetVrListeningTimeCmdHandler());
        this.mCmdHandlerManager.a(new RequestAudioFocusCmdHandler());
        this.mCmdHandlerManager.a(new WakeupAudioCmdHandler());
        this.mCmdHandlerManager.a(new WakeupAudioStateCmdHandler());
    }

    private void initComponents(Application application) {
        ExecutorService a2 = ThreadPoolFactory.a("Init");
        ArrayList<Component> arrayList = new ArrayList<>();
        arrayList.add(new CacheComponent());
        arrayList.add(new InterconnectComponent());
        arrayList.add(new AsrComponent());
        arrayList.add(new NluComponent());
        arrayList.add(new VadComponent());
        arrayList.add(new AppComponent());
        arrayList.add(new CloudComponent());
        arrayList.add(new NlgComponent());
        arrayList.add(new AudioRecordComponent());
        CountDownLatch countDownLatch = new CountDownLatch(arrayList.size());
        for (Component component : arrayList) {
            if (component.b()) {
                a2.execute(new a(component, application, countDownLatch));
            } else {
                component.d(application);
                countDownLatch.countDown();
            }
        }
        a2.execute(new b(this, countDownLatch, application));
    }

    private void initVuiHandlers() {
        this.mVuiHandlerManager.a(new SettingsVuiHandler());
        this.mVuiHandlerManager.a(new GlobalVuiHandler());
        this.mVuiHandlerManager.a(new ApplicationVuiHandler());
        this.mVuiHandlerManager.a(new NavigationVuiHandler(this.mContext));
        this.mVuiHandlerManager.a(new PhoneCallVuiHandler());
        this.mVuiHandlerManager.a(new WeatherVuiHandler());
        this.mVuiHandlerManager.a(new TranslateVuiHandler());
        this.mVuiHandlerManager.a(new ChatVuiHandler());
        this.mVuiHandlerManager.a(new VspErrorVuiHandler());
        this.mVuiHandlerManager.a(new LlmVuiHandler());
        this.mVuiHandlerManager.a(new TodoVuiHandler());
        this.mVuiHandlerManager.a(new ScheduleVuiHandler());
        if (!VoiceAssistantApi.isOversea) {
            this.mVuiHandlerManager.a(new WechatVuiHandler());
            this.mVuiHandlerManager.a(new MediaVuiHandler());
            this.mVuiHandlerManager.a(new AlarmVuiHandler());
        }
        this.mVuiHandlerManager.b(new STKSInterceptor()).b(new DomainCrossInterceptor()).b(new LlmInterceptor()).b(new SpecialVuiInterceptor());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$initComponents$0(Component component, Application application, CountDownLatch countDownLatch) {
        component.d(application);
        countDownLatch.countDown();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initComponents$1(CountDownLatch countDownLatch, Application application) {
        try {
            countDownLatch.await();
            ILog.a(TAG, "所有组件初始化完毕");
            onComponentInitOver();
            SuperLiteStateMonitor.f8526a.f(application);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onComponentInitOver$2(boolean z) {
        if (z == this.isNetworkAvailable) {
            ILog.a(TAG, "收到网络状态变化通知，网络状态未改变，不通知->" + z);
            return;
        }
        ILog.a(TAG, "收到网络状态变化通知，网络可用->" + z);
        EventBus.c().k(new NetworkEvent(z));
        this.isNetworkAvailable = z;
        CacheAbility cacheAbility = this.mCacheAbility;
        if (cacheAbility != null) {
            cacheAbility.cache("isNetworkAvailable", Boolean.valueOf(z));
        }
        syncPhoneInfo2Glass();
    }

    private void onComponentInitOver() {
        EventBus.c().k(new ComponentsInitOverEvent());
        AbilityManager abilityManager = AbilityManager.b;
        this.mInterconnectAbility = (InterconnectAbility) abilityManager.b(InterconnectAbility.class);
        this.mCacheAbility = (CacheAbility) abilityManager.b(CacheAbility.class);
        this.mInterconnectAbility.init(this.mContext, AssistantConstants.APPLICATION_ID, 1);
        this.mSuperAppAbilityManager.k(this.mInterconnectAbility.getOperatorManager());
        this.mInterconnectAbility.registerOnDeviceStateChangeListener(new c(this));
        this.mInterconnectAbility.registerOnReceiveRemoteMsgListener(new d(this));
        this.mCacheAbility.cache("isThirdPlatform", BuildConfig.b);
        this.mCacheAbility.cache("phoneAssistantVersion", "2.9.5-SNAPSHOT");
        CacheAbility cacheAbility = this.mCacheAbility;
        boolean z = VoiceAssistantApi.isOversea;
        cacheAbility.cache("isOversea", Boolean.valueOf(z));
        AssistantSettingUtils.b.a(this.mContext);
        FeedAudioDataToCloudStrategy amrWbStrategy = z ? new AmrWbStrategy() : new OpusStrategy();
        this.mCacheAbility.cache("FeedAudioDataToCloudStrategy", amrWbStrategy);
        this.mCacheAbility.cache("feedAudioDataType", amrWbStrategy.e());
        this.mCacheAbility.cache("isNetworkAvailable", Boolean.FALSE);
        new NetworkMonitor(this.mContext).c(new e(this));
    }

    private void syncPhoneInfo2Glass() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        if (this.isInterconnected) {
            CacheAbility cacheAbility = this.mCacheAbility;
            boolean z7 = false;
            boolean z8 = true;
            if (cacheAbility != null) {
                Boolean bool = Boolean.TRUE;
                z6 = ((Boolean) cacheAbility.getCacheWithDefault("low_power_wakeup", bool)).booleanValue();
                CacheAbility cacheAbility2 = this.mCacheAbility;
                Boolean bool2 = Boolean.FALSE;
                boolean booleanValue = ((Boolean) cacheAbility2.getCacheWithDefault("low_power_wakeup_screen_off", bool2)).booleanValue();
                z3 = ((Boolean) this.mCacheAbility.getCacheWithDefault("continuous_dialogue", bool2)).booleanValue();
                z2 = ((Boolean) this.mCacheAbility.getCacheWithDefault("asr_result_screen", bool)).booleanValue();
                z = ((Boolean) this.mCacheAbility.getCacheWithDefault("chat_gpt_tts_play", bool)).booleanValue();
                boolean booleanValue2 = ((Boolean) this.mCacheAbility.getCacheWithDefault("chat_gpt_card_display", bool)).booleanValue();
                int intValue = ((Integer) this.mCacheAbility.getCacheWithDefault("tts_timbre", 0)).intValue();
                z4 = ((Boolean) this.mCacheAbility.getCacheWithDefault(WakeupVoiceStorage.KEY_WAKEUP_RECORDING, bool2)).booleanValue();
                boolean z9 = booleanValue2;
                i = intValue;
                z7 = booleanValue;
                z5 = z9;
            } else {
                i = 0;
                z4 = false;
                z3 = false;
                z6 = true;
                z5 = true;
                z2 = true;
                z = true;
            }
            if (!DeviceUtils.c() && !DeviceUtils.i()) {
                z8 = z7;
            }
            SyncSysInfoRes syncSysInfoRes = new SyncSysInfoRes();
            syncSysInfoRes.setNetworkAvailable(this.isNetworkAvailable);
            syncSysInfoRes.setLowPowerWakeupEnable(z6);
            syncSysInfoRes.setLowPowerWakeupScreenOffEnable(z8);
            syncSysInfoRes.setContinuousDialogueEnable(z3);
            syncSysInfoRes.setAsrResultScreenEnable(z2);
            syncSysInfoRes.setChatGptTTSPlayEnable(z);
            syncSysInfoRes.setChatGptCardDisplayEnable(z5);
            syncSysInfoRes.setTtsTimbreValue(i);
            syncSysInfoRes.setWakeupVoiceRecording(z4);
            syncSysInfoRes.setHasWakeupVoicePrint(WakeupVoiceStorage.INSTANCE.has());
            Communicator.b(2, syncSysInfoRes, new SendMsgCallback() {
                public void onFail(int i, String str) {
                    ILog.a(Commander.TAG, "同步系统信息至眼镜失败，msg->" + str);
                }

                public void onSuccess() {
                    ILog.a(Commander.TAG, "同步系统信息至眼镜成功");
                }
            });
        }
    }

    public int getHandleCode() {
        return 103;
    }

    public void handle(StarryNetMessage starryNetMessage, Cmd cmd) {
        ILog.a(TAG, "收到业务数据->" + starryNetMessage.getMessage());
        this.mBusinessHandlerManager.b((BusinessData) cmd.parsePayload(BusinessData.class));
    }

    public void init(Application application) {
        if (this.isInit) {
            ILog.a(TAG, "已经执行过初始化");
            return;
        }
        ILog.l(new ULogger(application));
        ILog.a(TAG, "版本构建时间：2025-04-23 20:49:39");
        ILog.a(TAG, "语音助理版本：2.9.5-SNAPSHOT");
        ILog.a(TAG, "是否适配海外：" + VoiceAssistantApi.isOversea);
        this.isInit = true;
        this.mContext = application;
        ContextHelper.e(application, true);
        new MainPlatformAdapter().a(application);
        ImDelegator.f8381a.d().d(application);
        PhoneUnSupportFeatureHandler phoneUnSupportFeatureHandler = new PhoneUnSupportFeatureHandler();
        ContinuousDialogDispatcher.e(phoneUnSupportFeatureHandler);
        UnSupportFeatureManager.f8414a.e(phoneUnSupportFeatureHandler);
        EventBus.c().o(this);
        initBusinessHandlers();
        initVuiHandlers();
        initCmdHandlers();
        initComponents(application);
    }

    @Subscribe
    public void onReceiveSyncSysInfoReq(SyncSysInfoReq syncSysInfoReq) {
        syncPhoneInfo2Glass();
    }
}
