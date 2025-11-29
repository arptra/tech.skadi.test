package com.xjsd.ai.assistant.phone.vad;

import android.app.Application;
import com.alibaba.fastjson.JSON;
import com.upuphone.runasone.uupcast.CastErrorCode;
import com.xjsd.ai.annotation.AudioConfigFile;
import com.xjsd.ai.assistant.adapt.OfflineAsrDelegate;
import com.xjsd.ai.assistant.adapt.OfflineAsrDelegator;
import com.xjsd.ai.assistant.audio.AudioDataUtil;
import com.xjsd.ai.assistant.common.SessionHelper;
import com.xjsd.ai.assistant.common.util.OpusUtil;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.core.factory.ThreadPoolFactory;
import com.xjsd.ai.assistant.core.util.DeviceUtils;
import com.xjsd.ai.assistant.core.util.DotUtil;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.NewFunctionCompact;
import com.xjsd.ai.assistant.phone.VoiceAssistantApi;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import com.xjsd.ai.assistant.protocol.Scene;
import com.xjsd.ai.voice.VoiceAdapter;
import com.xjsd.ai.voice.VoiceListenerAdapter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.Unit;

class VadDetector extends VoiceListenerAdapter implements VadAbility {
    private static final String TAG = "VadDetector";
    private static final int UNIT_PACK_SIZE = 512;
    private final VoiceAdapter adapter = new VoiceAdapter();
    private byte[] cache = new byte[512];
    private final AtomicInteger consumeCount = new AtomicInteger(0);
    private volatile boolean hadVadEnd = false;
    private volatile boolean hadVadStart = false;
    private volatile boolean isCanceled = false;
    private volatile boolean isOneShot = false;
    private long lastBroadcastTime = 0;
    private final ExecutorService mEventPostThreadPool = ThreadPoolFactory.b("VadNotify");
    private final ExecutorService mFeedDataThreadPool = ThreadPoolFactory.b("AudioVad");
    private final OfflineAsrDelegate mOfflineAsrDelegate = OfflineAsrDelegator.f8382a.b();
    private final OpusDecoder mOpusDecoder = new OpusDecoder();
    private OpusUtil mOpusUtil;
    private VadEventListener mVadEventListener;
    private long muteTimeout = 3000;
    private boolean needCheckMute = false;
    private final AtomicInteger produceCount = new AtomicInteger(0);
    private volatile boolean sourceInitialed;
    private int tempStoreSize = 0;
    private final AtomicInteger vadEndTimes = new AtomicInteger(0);
    private volatile long vadStartTimestamp = 0;

    private void feedToFspEngine(byte[] bArr) {
        if (!this.hadVadEnd && !this.isCanceled) {
            this.mFeedDataThreadPool.execute(new b(this, bArr));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$feedData$3(byte[] bArr) {
        AudioDataUtil.d(bArr);
        processFeedData(bArr);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$feedToFspEngine$5(byte[] bArr) {
        if (this.isCanceled || this.hadVadEnd) {
            ILog.j(TAG, "consumerRunnable is break!!! Reason: hasVadEnd?" + this.hadVadEnd + ", isCanceled?" + this.isCanceled);
            return;
        }
        this.consumeCount.incrementAndGet();
        this.adapter.Feed(bArr);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$notifyVadEventListener$4(int i, VadEventListener vadEventListener) {
        if (i == 0) {
            vadEventListener.f();
        } else if (i == 1) {
            vadEventListener.c();
        } else if (i == 2) {
            vadEventListener.a();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onData$1(byte[] bArr, VadEventListener vadEventListener) {
        this.mOfflineAsrDelegate.c(bArr);
        vadEventListener.b(bArr);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onOfflineAsrResult$0(OfflineAsrResult offlineAsrResult) {
        VadEventListener vadEventListener = this.mVadEventListener;
        if (vadEventListener != null) {
            vadEventListener.e(offlineAsrResult);
        }
    }

    private void notifyVadEventListener(int i) {
        VadEventListener vadEventListener = this.mVadEventListener;
        if (vadEventListener != null) {
            this.mEventPostThreadPool.execute(new a(i, vadEventListener));
        }
    }

    /* access modifiers changed from: private */
    public void onOfflineAsrResult(OfflineAsrResult offlineAsrResult) {
        this.mEventPostThreadPool.execute(new e(this, offlineAsrResult));
    }

    private void processFeedData(byte[] bArr) {
        if (!this.hadVadEnd && !this.isCanceled) {
            int i = this.tempStoreSize;
            if (bArr.length + i >= 512) {
                int i2 = 512 - i;
                System.arraycopy(bArr, 0, this.cache, i, i2);
                feedToFspEngine(this.cache);
                int length = bArr.length - i2;
                while (length >= 512) {
                    byte[] bArr2 = new byte[512];
                    this.cache = bArr2;
                    System.arraycopy(bArr, i2, bArr2, 0, 512);
                    feedToFspEngine(this.cache);
                    i2 += 512;
                    length += CastErrorCode.SOURCE_PEER_DEVICE_NOT_ATTACHED;
                }
                byte[] bArr3 = new byte[512];
                this.cache = bArr3;
                this.tempStoreSize = length;
                if (length > 0) {
                    System.arraycopy(bArr, i2, bArr3, 0, length);
                    return;
                }
                return;
            }
            System.arraycopy(bArr, 0, this.cache, i, bArr.length);
            this.tempStoreSize += bArr.length;
        }
    }

    private void setVadParseDuration() {
        CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
        Boolean bool = Boolean.FALSE;
        if (!((Boolean) cacheAbility.getCacheWithDefault("isAsrOnlyWakeup", bool)).booleanValue()) {
            if (((Boolean) cacheAbility.getCacheWithDefault("isChatGptWakeup", bool)).booleanValue()) {
                boolean booleanValue = ((Boolean) cacheAbility.getCacheWithDefault("isInChatGptScene", bool)).booleanValue();
                ILog.a(TAG, "chatGpt vadDetect start isInChatGptScene:" + booleanValue);
                if (booleanValue) {
                    ILog.a(TAG, "chatGpt set vad pause time 1200ms");
                    this.adapter.setVadPause(1200);
                    return;
                }
            }
            if (((Boolean) cacheAbility.getCacheWithDefault("wechat_transfer", bool)).booleanValue()) {
                ILog.a(TAG, "set vad pause time 2.5s");
                this.adapter.setVadPause(2500);
            } else if (((Boolean) cacheAbility.getCacheWithDefault("todo_multi_wakeup", bool)).booleanValue()) {
                ILog.a(TAG, "set vad pause time 3s");
                this.adapter.setVadPause(3000);
            } else {
                ILog.a(TAG, "set vad pause time 600ms");
                this.adapter.setVadPause(600);
            }
        } else if (((String) cacheAbility.getCacheWithDefault(AssistantConstants.Key.SCENE_ID, Scene.NORMAL)).equalsIgnoreCase(Scene.WECHAT_TRANSFER)) {
            ILog.a(TAG, "set vad pause time 2.5s");
            this.adapter.setVadPause(2500);
        } else {
            ILog.a(TAG, "set vad pause time 600ms");
            this.adapter.setVadPause(600);
        }
    }

    public void destroy() {
        stop();
        this.adapter.Destory();
        this.mOfflineAsrDelegate.destroy();
    }

    public void feedData(byte[] bArr) {
        if (DeviceUtils.e() || DeviceUtils.j()) {
            if (this.mOpusUtil == null) {
                this.mOpusUtil = new OpusUtil();
            }
            byte[] a2 = this.mOpusUtil.a(bArr);
            AudioDataUtil.d(a2);
            processFeedData(a2);
            return;
        }
        this.mOpusDecoder.c(bArr, bArr.length, new f(this));
    }

    public void init(Application application) {
        if (this.sourceInitialed) {
            ILog.j(TAG, "fsp source is already processed");
            return;
        }
        String Version = this.adapter.Version();
        try {
            if (VoiceAssistantApi.isOversea) {
                this.adapter.init(application, AudioConfigFile.GLOABLE_ASSISTANT_AIR_EN);
            } else {
                this.adapter.init(application, AudioConfigFile.GLOABLE_ASSISTANT_AIR);
            }
            ILog.j(TAG, "fsp " + Version + ", init success");
            this.adapter.registerListener(this);
            this.adapter.Start();
            this.sourceInitialed = true;
        } catch (Exception e) {
            ILog.h(TAG, "fsp " + Version + ", init error:", e);
            this.sourceInitialed = false;
        }
        this.mOfflineAsrDelegate.init(application);
    }

    public /* bridge */ /* synthetic */ boolean isProxyInstance() {
        return super.isProxyInstance();
    }

    public void onData(int i, byte[] bArr, int i2) {
        VadEventListener vadEventListener;
        int i3 = i;
        this.produceCount.incrementAndGet();
        if (i3 != 1) {
            if (i3 == 2) {
                ILog.j(TAG, "vad start，VoiceAdapter消费原始音频个数->" + this.consumeCount.get() + "，生产降噪数据个数->" + this.produceCount.get());
                Pair pair = new Pair(AssistantConstants.Key.SESSION_ID, SessionHelper.f8413a.a());
                DotUtil.a("response_wakeup", "检测到说话", pair);
                DotUtil.d("vad_start", pair);
                ILog.f("ts_speech_detected");
                this.needCheckMute = false;
                this.hadVadStart = true;
                this.vadStartTimestamp = System.currentTimeMillis();
                notifyVadEventListener(1);
            } else if (i3 == 4) {
                ILog.j(TAG, "vad end，VoiceAdapter消费原始音频个数->" + this.consumeCount.get() + "，生产降噪数据个数->" + this.produceCount.get() + "，vad start状态->" + this.hadVadStart);
                Pair pair2 = new Pair(AssistantConstants.Key.SESSION_ID, SessionHelper.f8413a.a());
                DotUtil.a("vad_start", "拾音", pair2);
                DotUtil.d("vad_end", pair2);
                ILog.f("ts_phone_recog_end");
                this.vadEndTimes.incrementAndGet();
                if (!this.isOneShot) {
                    this.needCheckMute = false;
                    this.adapter.switchOff();
                    this.hadVadEnd = true;
                    notifyVadEventListener(2);
                    this.mOfflineAsrDelegate.b();
                } else if (System.currentTimeMillis() - this.vadStartTimestamp >= 3000 || this.vadEndTimes.get() > 1) {
                    this.needCheckMute = false;
                    this.adapter.switchOff();
                    this.hadVadEnd = true;
                    notifyVadEventListener(2);
                } else {
                    ILog.a(TAG, "oneshot场景，vad事件间隔过短或未达到两次vad end事件上报");
                }
            }
        } else if (this.needCheckMute) {
            if (DeviceUtils.d()) {
                ILog.j(TAG, "vad mute，消费原始音频个数->" + this.consumeCount.get() + "，生产降噪数据个数->" + this.produceCount.get());
                notifyVadEventListener(0);
                this.needCheckMute = false;
            } else {
                if (this.lastBroadcastTime == 0) {
                    this.lastBroadcastTime = System.currentTimeMillis();
                }
                long currentTimeMillis = System.currentTimeMillis() - this.lastBroadcastTime;
                long j = this.muteTimeout;
                if (currentTimeMillis > j - 500 && currentTimeMillis < j + 500) {
                    ILog.j(TAG, "vad mute，VoiceAdapter消费原始音频个数->" + this.consumeCount.get() + "，生产降噪数据个数->" + this.produceCount.get());
                    notifyVadEventListener(0);
                    this.lastBroadcastTime = 0;
                    this.needCheckMute = false;
                }
            }
        }
        if (!this.hadVadEnd && (vadEventListener = this.mVadEventListener) != null) {
            this.mEventPostThreadPool.execute(new c(this, bArr, vadEventListener));
        }
    }

    public void onMsg(String str, int i) {
        ILog.j(TAG, "fsp onMsg->" + str);
        VadEventListener vadEventListener = this.mVadEventListener;
        if (DeviceUtils.b() && !NewFunctionCompact.b() && vadEventListener != null) {
            String string = JSON.parseObject(str).getString("sentence");
            this.needCheckMute = false;
            this.mEventPostThreadPool.execute(new d(vadEventListener, string));
        }
    }

    public void onWakeup(String str, int i) {
        ILog.j(TAG, "fsp onWakeup->" + str);
    }

    public void oneshotCallBack(int i, int i2, int i3) {
        ILog.j(TAG, "fsp oneshotCallBack->" + i);
    }

    public /* bridge */ /* synthetic */ void register() {
        super.register();
    }

    public void setOneShotFlag() {
        ILog.a(TAG, "设置one shot flag");
        this.isOneShot = true;
        this.vadStartTimestamp = System.currentTimeMillis();
    }

    public void setVadEventListener(VadEventListener vadEventListener) {
        this.mVadEventListener = vadEventListener;
    }

    public void start() {
        ILog.j(TAG, "start fsp engine");
        this.muteTimeout = ((Long) ((CacheAbility) AbilityManager.b.b(CacheAbility.class)).getCacheWithDefault("muteTimeout", Long.valueOf(AssistantConstants.TIMEOUT_VAD_MUTE))).longValue();
        this.isOneShot = false;
        this.vadEndTimes.set(0);
        this.isCanceled = false;
        this.hadVadStart = false;
        this.hadVadEnd = false;
        this.needCheckMute = true;
        this.cache = new byte[512];
        this.lastBroadcastTime = 0;
        this.consumeCount.set(0);
        this.produceCount.set(0);
        if (this.sourceInitialed) {
            this.adapter.Reset();
            ILog.j(TAG, "fsp adapter Reset over");
            this.adapter.switchOn();
            ILog.j(TAG, "fsp adapter switchOn over");
        } else {
            this.adapter.Start();
        }
        setVadParseDuration();
        this.mOfflineAsrDelegate.a(new g(this));
        this.mOfflineAsrDelegate.start();
    }

    public void stop() {
        ILog.j(TAG, "stop fsp engine");
        this.isCanceled = true;
        this.hadVadStart = false;
        this.hadVadEnd = false;
        this.tempStoreSize = 0;
        this.adapter.switchOff();
        OpusUtil opusUtil = this.mOpusUtil;
        if (opusUtil != null) {
            opusUtil.c();
            this.mOpusUtil = null;
        }
    }
}
