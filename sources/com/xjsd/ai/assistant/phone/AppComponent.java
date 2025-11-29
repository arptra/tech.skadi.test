package com.xjsd.ai.assistant.phone;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.xjsd.ai.assistant.audio.AudioDataUtil;
import com.xjsd.ai.assistant.common.Communicator;
import com.xjsd.ai.assistant.common.stks.IntentFuncManager;
import com.xjsd.ai.assistant.connect.SendMsgCallback;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.Component;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.core.api.track.TrackAbility;
import com.xjsd.ai.assistant.env.UnifiedEnvAbility;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.event.ComponentsInitOverEvent;
import com.xjsd.ai.assistant.phone.helper.VrStateSynchronizer;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsAbility;
import com.xjsd.ai.assistant.protocol.wakeup.WakeupControl;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class AppComponent extends Component {

    /* renamed from: a  reason: collision with root package name */
    public Context f8513a;
    public BroadcastReceiver b = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                action.hashCode();
                char c = 65535;
                switch (action.hashCode()) {
                    case -2128145023:
                        if (action.equals("android.intent.action.SCREEN_OFF")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -2111188979:
                        if (action.equals("com.upuphone.com.CLOSE_AI_ASSISTANT_ACTION")) {
                            c = 1;
                            break;
                        }
                        break;
                    case -2036068430:
                        if (action.equals("com.xjsd.ai.assistant.intent.action.STOP_RECORD_AIR_AUDIO")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1454123155:
                        if (action.equals("android.intent.action.SCREEN_ON")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 823795052:
                        if (action.equals("android.intent.action.USER_PRESENT")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 874595676:
                        if (action.equals("com.upuphone.com.LAUNCH_AI_ASSISTANT_ACTION")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 1014540654:
                        if (action.equals("com.xjsd.ai.assistant.intent.action.START_RECORD_AIR_AUDIO")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 1116894768:
                        if (action.equals("action_notify_foreground")) {
                            c = 7;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        ILog.a("AppComponent", "锁屏了");
                        return;
                    case 1:
                        ILog.a("AppComponent", "收到手机端关闭语音助理广播");
                        WakeupControlDelegate.g.i(new WakeupControl(0));
                        VrStateSynchronizer.b(0);
                        return;
                    case 2:
                        AudioDataUtil.h();
                        return;
                    case 3:
                        ILog.a("AppComponent", "亮屏了");
                        return;
                    case 4:
                        ILog.a("AppComponent", "用户解锁了");
                        return;
                    case 5:
                        ILog.a("AppComponent", "收到手机端唤醒语音助理广播");
                        Communicator.b(110, (Object) null, new SendMsgCallback() {
                            public void onFail(int i, String str) {
                                ILog.a("AppComponent", "发送拉起眼镜端语音助理命令失败->" + str);
                            }

                            public void onSuccess() {
                                ILog.a("AppComponent", "发送拉起眼镜端语音助理命令成功");
                            }
                        });
                        return;
                    case 6:
                        AudioDataUtil.g(false);
                        return;
                    case 7:
                        ((CacheAbility) AbilityManager.b.b(CacheAbility.class)).cache("XJ_APP_IN_FOREGROUND", Boolean.valueOf(intent.getBooleanExtra("foreground_state", false)));
                        return;
                    default:
                        ILog.a("AppComponent", "收到广播->" + action);
                        return;
                }
            }
        }
    };

    public AppComponent() {
        EventBus.c().o(this);
    }

    public void a(Application application) {
        this.f8513a = application;
        PhoneTtsAbility phoneTtsAbility = new PhoneTtsAbility();
        phoneTtsAbility.init(application);
        phoneTtsAbility.register();
        new TrackAbility() {
            public /* bridge */ /* synthetic */ boolean isProxyInstance() {
                return super.isProxyInstance();
            }

            public /* bridge */ /* synthetic */ void register() {
                super.register();
            }

            public void track(String str, Map<String, Object> map) {
            }
        }.register();
        new UnifiedEnvAbility().register();
        ILog.j("AppComponent", "预加载IntentFunc资源->" + IntentFuncManager.b);
    }

    public String c() {
        return "AppComponent";
    }

    public final IntentFilter e() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.upuphone.com.LAUNCH_AI_ASSISTANT_ACTION");
        intentFilter.addAction("com.upuphone.com.CLOSE_AI_ASSISTANT_ACTION");
        intentFilter.addAction("com.xjsd.ai.assistant.intent.action.START_RECORD_AIR_AUDIO");
        intentFilter.addAction("com.xjsd.ai.assistant.intent.action.STOP_RECORD_AIR_AUDIO");
        intentFilter.addAction("action_notify_foreground");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        return intentFilter;
    }

    @Subscribe
    public void onReceiveComponentsInitOverEvent(ComponentsInitOverEvent componentsInitOverEvent) {
        ILog.a("AppComponent", "onReceiveComponentsInitOverEvent: 收到组件初始初始化完毕事件");
        this.f8513a.registerReceiver(this.b, e(), 2);
    }
}
