package com.xjsd.ai.assistant.phone.tts;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.upuphone.ai.ttsengine.OnStatusChange;
import com.upuphone.ai.ttsengine.TtsSdk;
import com.xjsd.ai.assistant.common.AudioFocusManager;
import com.xjsd.ai.assistant.common.Communicator;
import com.xjsd.ai.assistant.connect.SendMsgCallback;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.core.api.tts.TtsAbility;
import com.xjsd.ai.assistant.core.api.tts.TtsData;
import com.xjsd.ai.assistant.core.api.tts.TtsListener;
import com.xjsd.ai.assistant.core.util.DeviceUtils;
import com.xjsd.ai.assistant.core.util.DotUtil;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.VoiceAssistantApi;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Semaphore;
import kotlin.Pair;

public class PhoneTtsAbility implements TtsAbility {
    private static final String TAG = "PhoneTtsAbility";
    private Context mContext;
    /* access modifiers changed from: private */
    public String mCurrentPlayTaskId = null;
    private Handler mHandler;
    private int mRequestAudioFocusId = -1;
    /* access modifiers changed from: private */
    public final Semaphore mSemaphore = new Semaphore(1);
    /* access modifiers changed from: private */
    public final Set<String> mTaskIdSet = new HashSet();
    private final HandlerThread mWorker = new HandlerThread("TtsPlayDispatcher");

    public final class TtsPlayTask implements Runnable, OnStatusChange {

        /* renamed from: a  reason: collision with root package name */
        public final String f8604a;
        public final String b;
        public final String c;
        public final String d;
        public final TtsListener e;

        public TtsPlayTask(String str, String str2, String str3, String str4, TtsListener ttsListener) {
            this.f8604a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = ttsListener;
        }

        private void b() {
            PhoneTtsAbility.this.requestAudioFocus();
            Bundle bundle = new Bundle();
            bundle.putString("utteranceId", this.f8604a);
            bundle.putString("emotionType", this.c);
            bundle.putInt("caller_priority", 1);
            bundle.putInt("audio_focus_type", 0);
            if (!VoiceAssistantApi.isOversea) {
                bundle.putString("voice_id", this.d);
            }
            TtsSdk.f5490a.p(PhoneTtsAbility.TAG, this.b, 0, bundle, this.f8604a, this);
        }

        public void a(int i, int i2) {
            if (i == 0) {
                ILog.c(PhoneTtsAbility.TAG, "onChange: taskId->%s, play started", this.f8604a);
                DotUtil.d("phone_tts_start", new Pair(AssistantConstants.Key.SESSION_ID, this.f8604a));
                DotUtil.a("phone_tts", "tts播报首帧耗时", new Pair(AssistantConstants.Key.SESSION_ID, this.f8604a));
                DotUtil.a("vad_end", "用户体感耗时", new Pair(AssistantConstants.Key.SESSION_ID, this.f8604a));
                if (!DeviceUtils.d()) {
                    Communicator.b(120, (Object) null, (SendMsgCallback) null);
                }
                TtsListener ttsListener = this.e;
                if (ttsListener != null) {
                    ttsListener.onSpeakStart();
                }
            } else if (i == 1) {
                ILog.c(PhoneTtsAbility.TAG, "onChange: taskId->%s, play end", new Pair(AssistantConstants.Key.SESSION_ID, this.f8604a));
                DotUtil.d("phone_tts_end", new Pair(AssistantConstants.Key.SESSION_ID, this.f8604a));
                DotUtil.a("phone_tts_start", "tts播报时长", new Pair(AssistantConstants.Key.SESSION_ID, this.f8604a));
                c();
                TtsListener ttsListener2 = this.e;
                if (ttsListener2 != null) {
                    ttsListener2.onSpeakEnd();
                }
            } else if (i == 2) {
                ILog.c(PhoneTtsAbility.TAG, "onChange: taskId->%s, play error, code->%d", this.f8604a, Integer.valueOf(i2));
                DotUtil.d("phone_tts_error", new Pair(AssistantConstants.Key.SESSION_ID, this.f8604a));
                boolean z = !PhoneTtsAbility.this.mTaskIdSet.contains(this.f8604a);
                c();
                TtsListener ttsListener3 = this.e;
                if (ttsListener3 == null) {
                    return;
                }
                if (z) {
                    ILog.a(PhoneTtsAbility.TAG, "run: taskId->" + this.f8604a + ", play task canceled");
                    this.e.onDiscard();
                    return;
                }
                ttsListener3.onSpeakError(String.valueOf(i2));
            }
        }

        public final void c() {
            PhoneTtsAbility.this.mCurrentPlayTaskId = null;
            PhoneTtsAbility.this.releaseAudioFocus();
            PhoneTtsAbility.this.mSemaphore.release();
            PhoneTtsAbility.this.mTaskIdSet.remove(this.f8604a);
        }

        public void run() {
            try {
                PhoneTtsAbility.this.mSemaphore.acquire();
                if (PhoneTtsAbility.this.mTaskIdSet.contains(this.f8604a)) {
                    PhoneTtsAbility.this.mCurrentPlayTaskId = this.f8604a;
                    b();
                    return;
                }
                ILog.a(PhoneTtsAbility.TAG, "run: taskId->" + this.f8604a + ", play task canceled");
                TtsListener ttsListener = this.e;
                if (ttsListener != null) {
                    ttsListener.onDiscard();
                }
                PhoneTtsAbility.this.mSemaphore.release();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* access modifiers changed from: private */
    public void releaseAudioFocus() {
        if (!DeviceUtils.d() && this.mRequestAudioFocusId != -1) {
            AudioFocusManager.a().d(this.mContext, this.mRequestAudioFocusId);
            this.mRequestAudioFocusId = -1;
        }
    }

    /* access modifiers changed from: private */
    public void requestAudioFocus() {
        if (!DeviceUtils.d()) {
            releaseAudioFocus();
            this.mRequestAudioFocusId = AudioFocusManager.a().g(this.mContext, (AudioFocusManager.RequestAudioFocusCallback) null);
        }
    }

    public boolean cancelSpeak(@NonNull String str) {
        ILog.a(TAG, "cancelSpeak: taskId->" + str);
        releaseAudioFocus();
        boolean remove = this.mTaskIdSet.remove(str);
        String str2 = this.mCurrentPlayTaskId;
        if (str2 != null && str2.equals(str)) {
            TtsSdk.f5490a.s(TAG, str);
        }
        return remove;
    }

    public void init(Application application) {
        this.mContext = application;
        TtsSdk.f5490a.l(application);
        this.mWorker.start();
        this.mHandler = new Handler(this.mWorker.getLooper());
    }

    public /* bridge */ /* synthetic */ boolean isProxyInstance() {
        return super.isProxyInstance();
    }

    public boolean isSpeaking() {
        return this.mCurrentPlayTaskId != null;
    }

    public /* bridge */ /* synthetic */ void register() {
        super.register();
    }

    public String startSpeak(@NonNull TtsData ttsData, @Nullable TtsListener ttsListener) {
        String sessionId = ttsData.getSessionId();
        DotUtil.d("phone_tts", new Pair(AssistantConstants.Key.SESSION_ID, sessionId));
        if (TextUtils.isEmpty(sessionId)) {
            sessionId = UUID.randomUUID().toString();
        }
        this.mTaskIdSet.add(sessionId);
        ILog.a(TAG, "startSpeak: taskId->" + sessionId + ", listener->" + ttsListener);
        String timbre = ttsData.getTimbre();
        if (timbre == null) {
            timbre = (String) ((CacheAbility) AbilityManager.b.b(CacheAbility.class)).getCacheWithDefault("tts_timbre_type", "BT_BV700");
        }
        String str = sessionId;
        this.mHandler.post(new TtsPlayTask(str, ttsData.getText(), ttsData.getEmotionType(), timbre, ttsListener));
        return sessionId;
    }

    public void stopSpeak() {
        ILog.a(TAG, "停止所有播报");
        this.mTaskIdSet.clear();
        TtsSdk.f5490a.r(TAG);
        releaseAudioFocus();
    }
}
