package com.upuphone.ai.ttsengine.engines.wav.internal;

import android.app.Application;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import androidx.annotation.Keep;
import com.honey.account.q3.a;
import com.honey.account.q3.b;
import com.upuphone.ai.ttsengine.base.AbsTtsAgent;
import com.upuphone.ai.ttsengine.base.ITtsStatusListener;
import com.upuphone.ai.ttsengine.base.bean.CacheKey;
import com.upuphone.ai.ttsengine.base.bean.SpeakerInfo;
import com.upuphone.ai.ttsengine.base.enums.TtsAgentType;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import com.upuphone.runasone.relay.api.IntentKey;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J#\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0012\u001a\u00020\u0013H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u0011H\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\u0018\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0016J\u0012\u0010#\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0018\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020!H\u0016J\b\u0010)\u001a\u00020\u0011H\u0016J\b\u0010*\u001a\u00020\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006,"}, d2 = {"Lcom/upuphone/ai/ttsengine/engines/wav/internal/WavTtsAgent;", "Lcom/upuphone/ai/ttsengine/base/AbsTtsAgent;", "()V", "mediaPlayer", "Landroid/media/MediaPlayer;", "supportWords", "", "", "Landroid/content/res/AssetFileDescriptor;", "getAgentType", "Lcom/upuphone/ai/ttsengine/base/enums/TtsAgentType;", "getCurrentSpeakerInfo", "Lcom/upuphone/ai/ttsengine/base/bean/SpeakerInfo;", "getDefaultSpeakerInfo", "getSpeakerInfos", "", "init", "", "context", "Landroid/app/Application;", "isSupport", "key", "Lcom/upuphone/ai/ttsengine/base/bean/CacheKey;", "loadSource", "Lkotlin/Result;", "", "loadSource-IoAF18A", "(Landroid/app/Application;)Ljava/lang/Object;", "pauseTTS", "prepare", "resumeTTS", "setAudioAttributes", "usage", "", "contenttype", "setListener", "listener", "Lcom/upuphone/ai/ttsengine/base/ITtsStatusListener;", "startSpeak", "paramString", "streamtype", "stopTTS", "ttsAgentDestroy", "Companion", "aar_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class WavTtsAgent extends AbsTtsAgent {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String MAP_FILE_PATH = "wav/words.map";
    @NotNull
    private static final String MAP_SPLIT_MARK = "&";
    private MediaPlayer mediaPlayer;
    /* access modifiers changed from: private */
    @NotNull
    public final Map<String, AssetFileDescriptor> supportWords = new LinkedHashMap();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/ai/ttsengine/engines/wav/internal/WavTtsAgent$Companion;", "", "()V", "MAP_FILE_PATH", "", "MAP_SPLIT_MARK", "aar_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* access modifiers changed from: private */
    public static final void init$lambda$0(WavTtsAgent wavTtsAgent, MediaPlayer mediaPlayer2) {
        Intrinsics.checkNotNullParameter(wavTtsAgent, "this$0");
        wavTtsAgent.getAiLog().c("playAudio 结束", new Object[0]);
        wavTtsAgent.setAudioPlaying(false);
        wavTtsAgent.onPlayEnd();
        wavTtsAgent.stopTTS();
    }

    /* access modifiers changed from: private */
    public static final boolean init$lambda$1(WavTtsAgent wavTtsAgent, MediaPlayer mediaPlayer2, int i, int i2) {
        Intrinsics.checkNotNullParameter(wavTtsAgent, "this$0");
        AILOG aiLog = wavTtsAgent.getAiLog();
        aiLog.c("playAudio 出错 what:" + i + ", extra:" + i2, new Object[0]);
        wavTtsAgent.setAudioPlaying(false);
        wavTtsAgent.onPlayError(i);
        wavTtsAgent.stopTTS();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
        throw r4;
     */
    /* renamed from: loadSource-IoAF18A  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object m1664loadSourceIoAF18A(android.app.Application r4) {
        /*
            r3 = this;
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x002c }
            android.content.res.AssetManager r0 = r4.getAssets()     // Catch:{ all -> 0x002c }
            java.lang.String r1 = "wav/words.map"
            java.io.InputStream r0 = r0.open(r1)     // Catch:{ all -> 0x002c }
            java.io.LineNumberReader r1 = new java.io.LineNumberReader     // Catch:{ all -> 0x002e }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x002e }
            r2.<init>(r0)     // Catch:{ all -> 0x002e }
            r1.<init>(r2)     // Catch:{ all -> 0x002e }
            com.upuphone.ai.ttsengine.engines.wav.internal.WavTtsAgent$loadSource$1$1$1 r2 = new com.upuphone.ai.ttsengine.engines.wav.internal.WavTtsAgent$loadSource$1$1$1     // Catch:{ all -> 0x002e }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x002e }
            kotlin.io.TextStreamsKt.forEachLine(r1, r2)     // Catch:{ all -> 0x002e }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x002e }
            r3 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r3)     // Catch:{ all -> 0x002c }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x002c }
            java.lang.Object r3 = kotlin.Result.m20constructorimpl(r3)     // Catch:{ all -> 0x002c }
            goto L_0x003f
        L_0x002c:
            r3 = move-exception
            goto L_0x0035
        L_0x002e:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0030 }
        L_0x0030:
            r4 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r3)     // Catch:{ all -> 0x002c }
            throw r4     // Catch:{ all -> 0x002c }
        L_0x0035:
            kotlin.Result$Companion r4 = kotlin.Result.Companion
            java.lang.Object r3 = kotlin.ResultKt.createFailure(r3)
            java.lang.Object r3 = kotlin.Result.m20constructorimpl(r3)
        L_0x003f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.ttsengine.engines.wav.internal.WavTtsAgent.m1664loadSourceIoAF18A(android.app.Application):java.lang.Object");
    }

    @NotNull
    public TtsAgentType getAgentType() {
        return TtsAgentType.LOCAL_FILE;
    }

    @Nullable
    public SpeakerInfo getCurrentSpeakerInfo() {
        return null;
    }

    @Nullable
    public SpeakerInfo getDefaultSpeakerInfo() {
        return null;
    }

    public /* bridge */ /* synthetic */ int getPriority() {
        return super.getPriority();
    }

    @Nullable
    public List<SpeakerInfo> getSpeakerInfos() {
        return null;
    }

    public boolean init(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        getAiLog().c("创建mMediaPlayer对象", new Object[0]);
        super.init(application);
        MediaPlayer mediaPlayer2 = new MediaPlayer();
        this.mediaPlayer = mediaPlayer2;
        mediaPlayer2.setAudioAttributes(new AudioAttributes.Builder().setContentType(2).build());
        MediaPlayer mediaPlayer3 = this.mediaPlayer;
        MediaPlayer mediaPlayer4 = null;
        if (mediaPlayer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
            mediaPlayer3 = null;
        }
        mediaPlayer3.setOnCompletionListener(new a(this));
        MediaPlayer mediaPlayer5 = this.mediaPlayer;
        if (mediaPlayer5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
        } else {
            mediaPlayer4 = mediaPlayer5;
        }
        mediaPlayer4.setOnErrorListener(new b(this));
        m1664loadSourceIoAF18A(application);
        return true;
    }

    public boolean isSupport(@NotNull CacheKey cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, IntentKey.ACTIVITY.ACTION_KEY);
        return this.supportWords.containsKey(StringsKt.trim((CharSequence) cacheKey.c()).toString());
    }

    public boolean pauseTTS() {
        boolean z;
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        MediaPlayer mediaPlayer3 = null;
        if (mediaPlayer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
            mediaPlayer2 = null;
        }
        synchronized (mediaPlayer2) {
            try {
                if (isAudioPlaying()) {
                    MediaPlayer mediaPlayer4 = this.mediaPlayer;
                    if (mediaPlayer4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
                    } else {
                        mediaPlayer3 = mediaPlayer4;
                    }
                    mediaPlayer3.pause();
                    z = true;
                } else {
                    z = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public void prepare() {
        getAiLog().c("prepare", new Object[0]);
    }

    public /* bridge */ /* synthetic */ void reload() {
        super.reload();
    }

    public boolean resumeTTS() {
        boolean z;
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        MediaPlayer mediaPlayer3 = null;
        if (mediaPlayer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
            mediaPlayer2 = null;
        }
        synchronized (mediaPlayer2) {
            try {
                if (isAudioPlaying()) {
                    MediaPlayer mediaPlayer4 = this.mediaPlayer;
                    if (mediaPlayer4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
                    } else {
                        mediaPlayer3 = mediaPlayer4;
                    }
                    mediaPlayer3.start();
                    z = true;
                } else {
                    z = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public boolean setAudioAttributes(int i, int i2) {
        return true;
    }

    public boolean setListener(@Nullable ITtsStatusListener iTtsStatusListener) {
        setListener(iTtsStatusListener);
        return true;
    }

    public boolean startSpeak(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "paramString");
        getAiLog().c("startSpeak: " + str + ", isTtsPlaying:" + isAudioPlaying(), new Object[0]);
        try {
            AssetFileDescriptor assetFileDescriptor = this.supportWords.get(StringsKt.trim((CharSequence) str).toString());
            if (assetFileDescriptor == null) {
                getAiLog().h("not support word: " + str, new Object[0]);
                onPlayError(7);
                return false;
            }
            if (isAudioPlaying()) {
                stopTTS();
            }
            MediaPlayer mediaPlayer2 = this.mediaPlayer;
            MediaPlayer mediaPlayer3 = null;
            if (mediaPlayer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
                mediaPlayer2 = null;
            }
            synchronized (mediaPlayer2) {
                getAiLog().c("playAudio 初始化", new Object[0]);
                setAudioPlaying(true);
                onPlayStart();
                MediaPlayer mediaPlayer4 = this.mediaPlayer;
                if (mediaPlayer4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
                    mediaPlayer4 = null;
                }
                mediaPlayer4.setDataSource(assetFileDescriptor);
                MediaPlayer mediaPlayer5 = this.mediaPlayer;
                if (mediaPlayer5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
                    mediaPlayer5 = null;
                }
                mediaPlayer5.prepare();
                MediaPlayer mediaPlayer6 = this.mediaPlayer;
                if (mediaPlayer6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
                } else {
                    mediaPlayer3 = mediaPlayer6;
                }
                mediaPlayer3.start();
                getAiLog().c("playAudio 开始", new Object[0]);
            }
            return true;
        } catch (Exception e) {
            getAiLog().h("start speak error: " + e.getMessage(), new Object[0]);
            onPlayError(9);
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean stopTTS() {
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        MediaPlayer mediaPlayer3 = null;
        if (mediaPlayer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
            mediaPlayer2 = null;
        }
        synchronized (mediaPlayer2) {
            try {
                MediaPlayer mediaPlayer4 = this.mediaPlayer;
                if (mediaPlayer4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
                    mediaPlayer4 = null;
                }
                mediaPlayer4.stop();
                MediaPlayer mediaPlayer5 = this.mediaPlayer;
                if (mediaPlayer5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
                } else {
                    mediaPlayer3 = mediaPlayer5;
                }
                mediaPlayer3.reset();
                if (isAudioPlaying()) {
                    onPlayInterrupted();
                }
                setAudioPlaying(false);
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    public void ttsAgentDestroy() {
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        MediaPlayer mediaPlayer3 = null;
        if (mediaPlayer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
            mediaPlayer2 = null;
        }
        synchronized (mediaPlayer2) {
            try {
                MediaPlayer mediaPlayer4 = this.mediaPlayer;
                if (mediaPlayer4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
                } else {
                    mediaPlayer3 = mediaPlayer4;
                }
                mediaPlayer3.release();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
