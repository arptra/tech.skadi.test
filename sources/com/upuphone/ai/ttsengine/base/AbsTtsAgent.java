package com.upuphone.ai.ttsengine.base;

import android.app.Application;
import com.upuphone.ai.ttsengine.base.bean.CacheKey;
import com.upuphone.ai.ttsengine.base.bean.SpeakerInfo;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import com.upuphone.runasone.relay.api.IntentKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b&\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0003J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0003J\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010 \u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b \u0010!J\u001f\u0010$\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000bH\u0016¢\u0006\u0004\b$\u0010%J\u001f\u0010$\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020&H\u0016¢\u0006\u0004\b$\u0010'J%\u0010+\u001a\u00020\u001b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020&0(2\u0006\u0010*\u001a\u00020\u000bH\u0016¢\u0006\u0004\b+\u0010,J\u001f\u0010/\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000bH\u0016¢\u0006\u0004\b/\u0010%J\u0017\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100H\u0016¢\u0006\u0004\b2\u00103J\u0011\u00104\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b4\u00105J\u0011\u00106\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b6\u00105J\u000f\u00107\u001a\u00020\u0004H\u0016¢\u0006\u0004\b7\u0010\u0003J\u000f\u00108\u001a\u00020\u001bH\u0016¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u001bH\u0016¢\u0006\u0004\b:\u00109J\u000f\u0010;\u001a\u00020\u0004H\u0016¢\u0006\u0004\b;\u0010\u0003J\u000f\u0010<\u001a\u00020\u001bH\u0016¢\u0006\u0004\b<\u00109J\u000f\u0010=\u001a\u00020\u001bH\u0016¢\u0006\u0004\b=\u00109J\u0017\u0010@\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b@\u0010AJ\u001f\u0010+\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020&2\u0006\u0010B\u001a\u00020\u000bH&¢\u0006\u0004\b+\u0010CJ\u000f\u0010D\u001a\u00020\u001bH&¢\u0006\u0004\bD\u00109R\u001a\u0010F\u001a\u00020E8\u0004X\u0004¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010J\u001a\u0004\bK\u0010L\"\u0004\b \u0010MR\"\u0010N\u001a\u00020\u000b8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010\u000eR\"\u0010S\u001a\u00020\u001b8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bS\u00109\"\u0004\bU\u0010VR$\u0010W\u001a\u0004\u0018\u00010\u00198\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010]\u001a\u00020&8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR$\u0010c\u001a\u0004\u0018\u00010&8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\bc\u0010^\u001a\u0004\bd\u0010`\"\u0004\be\u0010bR\"\u0010f\u001a\u00020\u001b8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\bf\u0010T\u001a\u0004\bf\u00109\"\u0004\bg\u0010VR\"\u0010h\u001a\u00020\u001b8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\bh\u0010T\u001a\u0004\bi\u00109\"\u0004\bj\u0010V¨\u0006k"}, d2 = {"Lcom/upuphone/ai/ttsengine/base/AbsTtsAgent;", "Lcom/upuphone/ai/ttsengine/base/ITtsAgent;", "<init>", "()V", "", "onPlayStart", "onPlaySoundStart", "onPlayPause", "onPlayResume", "onPlayInterrupted", "onPlayEnd", "", "errorCode", "onPlayError", "(I)V", "arg1", "arg2", "percent", "onPlayProgress", "(III)V", "", "bytes", "sampleRate", "onPlaySynthesizedData", "([BI)V", "Landroid/app/Application;", "context", "", "init", "(Landroid/app/Application;)Z", "Lcom/upuphone/ai/ttsengine/base/ITtsStatusListener;", "listener", "setListener", "(Lcom/upuphone/ai/ttsengine/base/ITtsStatusListener;)Z", "paramInt1", "paramInt2", "setParam", "(II)Z", "", "(ILjava/lang/String;)Z", "", "paramString", "streamtype", "startSpeak", "(Ljava/util/List;I)Z", "usage", "contenttype", "setAudioAttributes", "", "Lcom/upuphone/ai/ttsengine/base/bean/SpeakerInfo;", "getSpeakerInfos", "()Ljava/util/List;", "getCurrentSpeakerInfo", "()Lcom/upuphone/ai/ttsengine/base/bean/SpeakerInfo;", "getDefaultSpeakerInfo", "prepare", "pauseTTS", "()Z", "resumeTTS", "ttsAgentDestroy", "isPaused", "isSpeaking", "Lcom/upuphone/ai/ttsengine/base/bean/CacheKey;", "key", "isSupport", "(Lcom/upuphone/ai/ttsengine/base/bean/CacheKey;)Z", "streamType", "(Ljava/lang/String;I)Z", "stopTTS", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "aiLog", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "getAiLog", "()Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "Lcom/upuphone/ai/ttsengine/base/ITtsStatusListener;", "getListener", "()Lcom/upuphone/ai/ttsengine/base/ITtsStatusListener;", "(Lcom/upuphone/ai/ttsengine/base/ITtsStatusListener;)V", "callingState", "I", "getCallingState", "()I", "setCallingState", "isAudioPlaying", "Z", "setAudioPlaying", "(Z)V", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "setApplication", "(Landroid/app/Application;)V", "voiceId", "Ljava/lang/String;", "getVoiceId", "()Ljava/lang/String;", "setVoiceId", "(Ljava/lang/String;)V", "language", "getLanguage", "setLanguage", "isTestTool", "setTestTool", "disableBT", "getDisableBT", "setDisableBT", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nAbsTtsAgent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbsTtsAgent.kt\ncom/upuphone/ai/ttsengine/base/AbsTtsAgent\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,126:1\n1#2:127\n*E\n"})
public abstract class AbsTtsAgent implements ITtsAgent {
    @NotNull
    private final AILOG aiLog;
    @Nullable
    private Application application;
    private int callingState;
    private boolean disableBT;
    private volatile boolean isAudioPlaying;
    private boolean isTestTool;
    @Nullable
    private String language;
    @Nullable
    private ITtsStatusListener listener;
    @NotNull
    private String voiceId = "BV700_streaming";

    public AbsTtsAgent() {
        AILOG a2 = AILOG.a(getClass().getSimpleName());
        Intrinsics.checkNotNullExpressionValue(a2, "createLogger(...)");
        this.aiLog = a2;
    }

    @NotNull
    public final AILOG getAiLog() {
        return this.aiLog;
    }

    @Nullable
    public final Application getApplication() {
        return this.application;
    }

    public final int getCallingState() {
        return this.callingState;
    }

    @Nullable
    public SpeakerInfo getCurrentSpeakerInfo() {
        return null;
    }

    @Nullable
    public SpeakerInfo getDefaultSpeakerInfo() {
        return null;
    }

    public final boolean getDisableBT() {
        return this.disableBT;
    }

    @Nullable
    public final String getLanguage() {
        return this.language;
    }

    @Nullable
    public final ITtsStatusListener getListener() {
        return this.listener;
    }

    @Nullable
    public List<SpeakerInfo> getSpeakerInfos() {
        return null;
    }

    @NotNull
    public final String getVoiceId() {
        return this.voiceId;
    }

    public boolean init(Application application2) {
        Intrinsics.checkNotNullParameter(application2, "context");
        this.application = application2;
        return true;
    }

    public final boolean isAudioPlaying() {
        return this.isAudioPlaying;
    }

    public boolean isPaused() {
        return false;
    }

    public boolean isSpeaking() {
        return this.isAudioPlaying;
    }

    public boolean isSupport(CacheKey cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, IntentKey.ACTIVITY.ACTION_KEY);
        return true;
    }

    public final boolean isTestTool() {
        return this.isTestTool;
    }

    public void onPlayEnd() {
        this.aiLog.c("onPlayEnd BEGIN", new Object[0]);
        this.isAudioPlaying = false;
        ITtsStatusListener iTtsStatusListener = this.listener;
        if (iTtsStatusListener != null) {
            iTtsStatusListener.a();
        }
    }

    public void onPlayError(int i) {
        this.aiLog.c("onPlayError BEGIN", new Object[0]);
        this.isAudioPlaying = false;
        ITtsStatusListener iTtsStatusListener = this.listener;
        if (iTtsStatusListener != null) {
            iTtsStatusListener.h(i);
        }
    }

    public final void onPlayInterrupted() {
        this.aiLog.c("onPlayInterrupted BEGIN", new Object[0]);
        ITtsStatusListener iTtsStatusListener = this.listener;
        if (iTtsStatusListener != null) {
            iTtsStatusListener.h(3);
        }
    }

    public final void onPlayPause() {
        this.aiLog.c("onPlayPause BEGIN", new Object[0]);
        ITtsStatusListener iTtsStatusListener = this.listener;
        if (iTtsStatusListener != null) {
            iTtsStatusListener.b();
        }
    }

    public final void onPlayProgress(int i, int i2, int i3) {
        ITtsStatusListener iTtsStatusListener = this.listener;
        if (iTtsStatusListener != null) {
            iTtsStatusListener.f(i, i2, i3);
        }
    }

    public final void onPlayResume() {
        this.aiLog.c("onPlayResume BEGIN", new Object[0]);
        ITtsStatusListener iTtsStatusListener = this.listener;
        if (iTtsStatusListener != null) {
            iTtsStatusListener.c();
        }
    }

    public final void onPlaySoundStart() {
        this.aiLog.c("onPlaySoundStart BEGIN", new Object[0]);
        ITtsStatusListener iTtsStatusListener = this.listener;
        if (iTtsStatusListener != null) {
            iTtsStatusListener.g();
        }
    }

    public final void onPlayStart() {
        this.aiLog.c("onPlayStart BEGIN", new Object[0]);
        ITtsStatusListener iTtsStatusListener = this.listener;
        if (iTtsStatusListener != null) {
            iTtsStatusListener.d();
        }
    }

    public final void onPlaySynthesizedData(@Nullable byte[] bArr, int i) {
        ITtsStatusListener iTtsStatusListener = this.listener;
        if (iTtsStatusListener != null) {
            iTtsStatusListener.e(bArr, i);
        }
    }

    public boolean pauseTTS() {
        return false;
    }

    public void prepare() {
    }

    public boolean resumeTTS() {
        return false;
    }

    public final void setApplication(@Nullable Application application2) {
        this.application = application2;
    }

    public boolean setAudioAttributes(int i, int i2) {
        return true;
    }

    public final void setAudioPlaying(boolean z) {
        this.isAudioPlaying = z;
    }

    public final void setCallingState(int i) {
        this.callingState = i;
    }

    public final void setDisableBT(boolean z) {
        this.disableBT = z;
    }

    public final void setLanguage(@Nullable String str) {
        this.language = str;
    }

    public final void setListener(@Nullable ITtsStatusListener iTtsStatusListener) {
        this.listener = iTtsStatusListener;
    }

    public boolean setParam(int i, int i2) {
        if (i != 1234567891) {
            boolean z = false;
            if (i == 1234567893) {
                if (i2 != 0) {
                    z = true;
                }
                this.isTestTool = z;
            } else if (i == 1234567896) {
                if (i2 != 0) {
                    z = true;
                }
                this.disableBT = z;
            }
        } else {
            this.callingState = i2;
        }
        return true;
    }

    public final void setTestTool(boolean z) {
        this.isTestTool = z;
    }

    public final void setVoiceId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.voiceId = str;
    }

    public abstract boolean startSpeak(String str, int i);

    public boolean startSpeak(@NotNull List<String> list, int i) {
        Intrinsics.checkNotNullParameter(list, "paramString");
        String str = (String) CollectionsKt.removeFirstOrNull(list);
        if (str == null) {
            return false;
        }
        return startSpeak(str, i);
    }

    public abstract boolean stopTTS();

    public void ttsAgentDestroy() {
    }

    /* renamed from: setListener  reason: collision with other method in class */
    public boolean m1661setListener(@Nullable ITtsStatusListener iTtsStatusListener) {
        this.listener = iTtsStatusListener;
        return true;
    }

    public boolean setParam(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "paramInt2");
        if (i == 1234567892) {
            if (StringsKt.isBlank(str)) {
                str = null;
            }
            this.language = str;
            return true;
        } else if (i != 1234567895) {
            return true;
        } else {
            this.voiceId = str;
            return true;
        }
    }
}
