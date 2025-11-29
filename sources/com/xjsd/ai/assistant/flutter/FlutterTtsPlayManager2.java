package com.xjsd.ai.assistant.flutter;

import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.honey.account.ca.t;
import com.honey.account.ca.u;
import com.upuphone.ai.ttsengine.OnStatusChange;
import com.upuphone.ai.ttsengine.TtsSdk;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.flutter.AndroidAssistantApi;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00112\u00020\u0001:\u0003 !\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R8\u0010\u001c\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u00060\u0018R\u00020\u00000\u0017j\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u00060\u0018R\u00020\u0000`\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/FlutterTtsPlayManager2;", "", "<init>", "()V", "", "id", "text", "", "playMode", "f", "(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;", "taskId", "", "h", "(Ljava/lang/String;)V", "e", "state", "d", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/HandlerThread;", "a", "Landroid/os/HandlerThread;", "mWorker", "Ljava/util/HashMap;", "Lcom/xjsd/ai/assistant/flutter/FlutterTtsPlayManager2$TtsPlayTask;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "mTtsPlayTaskMap", "c", "Ljava/lang/String;", "mLastTtsPlayTaskId", "Companion", "PlayState", "TtsPlayTask", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class FlutterTtsPlayManager2 {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final HandlerThread f8478a;
    public final HashMap b = new HashMap();
    public String c;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/FlutterTtsPlayManager2$Companion;", "", "()V", "TAG", "", "TTS_PLAY_STATE_DISCARD", "TTS_PLAY_STATE_END", "TTS_PLAY_STATE_ERROR", "TTS_PLAY_STATE_START", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.TYPE, AnnotationTarget.LOCAL_VARIABLE})
    @Retention(AnnotationRetention.BINARY)
    @java.lang.annotation.Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/FlutterTtsPlayManager2$PlayState;", "", "<init>", "()V", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
    @java.lang.annotation.Retention(RetentionPolicy.CLASS)
    public @interface PlayState {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/FlutterTtsPlayManager2$PlayState$Companion;", "", "<init>", "()V", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
        public static final class Companion {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ Companion f8479a = new Companion();
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u000eJ\u000f\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\u000eJ\u001f\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\u000eJ\u000f\u0010\u001c\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001c\u0010\u000eJ\u000f\u0010\u001d\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001eR\u001c\u0010#\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030$8\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010)R\u0016\u0010,\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010+R\u0016\u0010-\u001a\u00020(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010)R\u0016\u0010.\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010+R\u0014\u00102\u001a\u00020/8\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u00067"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/FlutterTtsPlayManager2$TtsPlayTask;", "Lcom/upuphone/ai/ttsengine/OnStatusChange;", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "", "taskId", "<init>", "(Lcom/xjsd/ai/assistant/flutter/FlutterTtsPlayManager2;Ljava/lang/String;)V", "tts", "", "playMode", "", "d", "(Ljava/lang/String;I)V", "l", "()V", "status", "errorCode", "a", "(II)V", "focusChange", "onAudioFocusChange", "(I)V", "k", "j", "state", "m", "(Ljava/lang/String;Ljava/lang/String;)V", "g", "e", "f", "Ljava/lang/String;", "Landroid/media/AudioFocusRequest;", "kotlin.jvm.PlatformType", "b", "Landroid/media/AudioFocusRequest;", "mAudioFocusRequest", "Ljava/util/concurrent/LinkedBlockingQueue;", "c", "Ljava/util/concurrent/LinkedBlockingQueue;", "mTextQueue", "", "Z", "mAudioFocusRequestTag", "I", "mPlayState", "isStopped", "mPlayMode", "Landroid/os/Handler;", "h", "Landroid/os/Handler;", "mHandler", "Ljava/lang/Runnable;", "i", "Ljava/lang/Runnable;", "playOverCheckTask", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class TtsPlayTask implements OnStatusChange, AudioManager.OnAudioFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final String f8480a;
        public final AudioFocusRequest b = new AudioFocusRequest.Builder(2).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this).build();
        public final LinkedBlockingQueue c = new LinkedBlockingQueue();
        public boolean d;
        public int e;
        public boolean f;
        public int g;
        public final Handler h;
        public final Runnable i;
        public final /* synthetic */ FlutterTtsPlayManager2 j;

        public TtsPlayTask(FlutterTtsPlayManager2 flutterTtsPlayManager2, String str) {
            Intrinsics.checkNotNullParameter(str, "taskId");
            this.j = flutterTtsPlayManager2;
            this.f8480a = str;
            this.h = new Handler(flutterTtsPlayManager2.f8478a.getLooper());
            this.i = new t(this);
        }

        public static final void h(TtsPlayTask ttsPlayTask) {
            Intrinsics.checkNotNullParameter(ttsPlayTask, "this$0");
            ttsPlayTask.e();
        }

        public static final void i(TtsPlayTask ttsPlayTask) {
            Intrinsics.checkNotNullParameter(ttsPlayTask, "this$0");
            ILog.a("FlutterTtsPlayManager2", "2S后自动回调播报结束");
            ttsPlayTask.m(ttsPlayTask.f8480a, "tts_play_end");
        }

        public void a(int i2, int i3) {
            if (i2 == 0) {
                ILog.a("FlutterTtsPlayManager2", "onChange: 开始播报");
                this.e = 1;
                m(this.f8480a, "tts_play_start");
            } else if (i2 == 1) {
                ILog.a("FlutterTtsPlayManager2", "onChange: 播报结束");
                m(this.f8480a, "tts_play_end");
            } else if (i2 == 2) {
                ILog.a("FlutterTtsPlayManager2", "onChange: 播报出错->" + i3);
                if (this.g == 0) {
                    m(this.f8480a, "tts_play_error");
                } else if (this.e == 2) {
                    ILog.a("FlutterTtsPlayManager2", "onChange: 追加播报模式，忽略错误回调");
                } else {
                    m(this.f8480a, "tts_play_error");
                }
            }
        }

        public final void d(String str, int i2) {
            Intrinsics.checkNotNullParameter(str, "tts");
            this.c.offer(str);
            this.g = i2;
            k();
        }

        public final void e() {
            String str = (String) this.c.poll();
            if (str != null) {
                this.h.removeCallbacks(this.i);
                if (this.e < 2) {
                    Bundle bundle = new Bundle();
                    bundle.putString("utteranceId", this.f8480a);
                    bundle.putString("emotionType", "");
                    bundle.putInt("caller_priority", 2);
                    bundle.putInt("audio_focus_type", 0);
                    TtsSdk.f5490a.p("FlutterTtsPlayManager2", str, this.g == 0 ? 0 : 3, bundle, this.f8480a, this);
                    return;
                }
                ILog.a("FlutterTtsPlayManager2", "invokeTtsSdkPlay: ignore the tts play, text->" + str);
            }
        }

        public final void f() {
            this.e = 0;
            ILog.a("FlutterTtsPlayManager2", "invokeTtsSdkPlay: 2S后检测是否没有播报任务");
            this.h.postDelayed(this.i, AssistantConstants.TIMEOUT_VAD_MUTE);
        }

        public final void g() {
            this.h.post(new u(this));
        }

        public final void j() {
            Object systemService = ContextHelper.a().getSystemService("audio");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            int abandonAudioFocusRequest = ((AudioManager) systemService).abandonAudioFocusRequest(this.b);
            ILog.a("FlutterTtsPlayManager2", "releaseAudioFocus: 释放音频焦点->" + abandonAudioFocusRequest);
        }

        public final void k() {
            if (this.d) {
                ILog.a("FlutterTtsPlayManager2", "requestAudioFocus: 追加方式，触发读取");
                g();
                return;
            }
            this.d = true;
            Object systemService = ContextHelper.a().getSystemService("audio");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            AudioManager audioManager = (AudioManager) systemService;
            int requestAudioFocus = audioManager.requestAudioFocus(this.b);
            int mode = audioManager.getMode();
            ILog.a("FlutterTtsPlayManager2", "requestAudioFocus: audio mode->" + mode + ", result->" + requestAudioFocus);
            if (requestAudioFocus != 1 || mode == 2 || mode == 3) {
                ILog.a("FlutterTtsPlayManager2", "requestAudioFocus: 申请音频焦点失败");
                m(this.f8480a, "tts_play_error");
                return;
            }
            ILog.a("FlutterTtsPlayManager2", "requestAudioFocus: 申请音频焦点成功");
            g();
        }

        public final void l() {
            this.f = true;
            this.j.d(this.f8480a, "tts_play_discard");
            j();
            this.j.e(this.f8480a);
            TtsSdk.f5490a.s("FlutterTtsPlayManager2", this.f8480a);
        }

        public final void m(String str, String str2) {
            if (this.f) {
                ILog.a("FlutterTtsPlayManager2", "tryNotifyFlutterPlayStatus: 拦截->" + str + "/" + str2);
                return;
            }
            this.j.d(str, str2);
            if (Intrinsics.areEqual((Object) str2, (Object) "tts_play_end") || Intrinsics.areEqual((Object) str2, (Object) "tts_play_error")) {
                this.e = 3;
                this.j.c = null;
                j();
                this.j.e(str);
            }
        }

        public void onAudioFocusChange(int i2) {
            ILog.j("FlutterTtsPlayManager2", "onAudioFocusChange: focusChange->" + i2);
            if (i2 == -3) {
                ILog.a("FlutterTtsPlayManager2", "暂时性失去焦点，但可以降低音量播放");
            } else if (i2 == -2) {
                ILog.a("FlutterTtsPlayManager2", "暂时性失去焦点");
                this.e = 2;
                l();
            } else if (i2 == -1) {
                ILog.a("FlutterTtsPlayManager2", "永久失去焦点");
                m(this.f8480a, "tts_play_error");
            } else if (i2 == 1) {
                ILog.a("FlutterTtsPlayManager2", "获取音频焦点->AUDIOFOCUS_GAIN");
                f();
            } else if (i2 != 2) {
                ILog.a("FlutterTtsPlayManager2", "不处理该focusChange类型->" + i2);
            } else {
                ILog.a("FlutterTtsPlayManager2", "获取音频焦点->AUDIOFOCUS_GAIN_TRANSIENT");
                f();
            }
        }
    }

    public FlutterTtsPlayManager2() {
        HandlerThread handlerThread = new HandlerThread("flutter-tts");
        this.f8478a = handlerThread;
        handlerThread.start();
    }

    public static /* synthetic */ String g(FlutterTtsPlayManager2 flutterTtsPlayManager2, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return flutterTtsPlayManager2.f(str, str2, i);
    }

    public final void d(String str, String str2) {
        ILog.a("FlutterTtsPlayManager2", "notifyFlutterPlayStatus: taskId->" + str + ", state->" + str2);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", (Object) str);
        jSONObject.put("state", (Object) str2);
        AndroidAssistantApi.NotifyEvent notifyEvent = new AndroidAssistantApi.NotifyEvent();
        notifyEvent.c("tts_play_state");
        notifyEvent.b(jSONObject.toJSONString());
        AndroidAssistantApiHandler.INSTANCE.broadcastEventToFlutter(notifyEvent);
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.b.remove(str);
    }

    public final String f(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "text");
        TtsPlayTask ttsPlayTask = (TtsPlayTask) this.b.get(str);
        if (ttsPlayTask == null) {
            String str3 = this.c;
            if (str3 != null) {
                Intrinsics.checkNotNull(str3);
                h(str3);
            }
            ttsPlayTask = new TtsPlayTask(this, str);
            this.b.put(str, ttsPlayTask);
        }
        this.c = str;
        ttsPlayTask.d(str2, i);
        return str;
    }

    public final void h(String str) {
        Intrinsics.checkNotNullParameter(str, "taskId");
        ILog.a("FlutterTtsPlayManager2", "stopPlayTts: taskId->" + str);
        if (TextUtils.isEmpty(str)) {
            str = this.c;
        }
        if (Intrinsics.areEqual((Object) str, (Object) this.c)) {
            this.c = null;
        }
        TtsPlayTask ttsPlayTask = (TtsPlayTask) this.b.get(str);
        if (ttsPlayTask != null) {
            ttsPlayTask.l();
        }
    }
}
