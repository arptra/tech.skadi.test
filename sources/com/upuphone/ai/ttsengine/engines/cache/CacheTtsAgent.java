package com.upuphone.ai.ttsengine.engines.cache;

import android.app.Application;
import androidx.annotation.Keep;
import com.upuphone.ai.ttsengine.base.AbsTtsAgent;
import com.upuphone.ai.ttsengine.base.bean.CacheKey;
import com.upuphone.ai.ttsengine.base.enums.TtsAgentType;
import com.upuphone.ai.ttsengine.base.player.AbstractPlayer;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import com.upuphone.runasone.relay.api.IntentKey;
import java.io.File;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\n\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u000fH\u0016J\u0018\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0019H\u0016J\b\u0010$\u001a\u00020\u000fH\u0016J\b\u0010%\u001a\u00020\u0016H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006&"}, d2 = {"Lcom/upuphone/ai/ttsengine/engines/cache/CacheTtsAgent;", "Lcom/upuphone/ai/ttsengine/base/AbsTtsAgent;", "()V", "audioPlayer", "Lcom/upuphone/ai/ttsengine/base/player/AbstractPlayer;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "playingJob", "Lkotlinx/coroutines/Job;", "ttsPlayListener", "com/upuphone/ai/ttsengine/engines/cache/CacheTtsAgent$ttsPlayListener$1", "Lcom/upuphone/ai/ttsengine/engines/cache/CacheTtsAgent$ttsPlayListener$1;", "getAgentType", "Lcom/upuphone/ai/ttsengine/base/enums/TtsAgentType;", "init", "", "context", "Landroid/app/Application;", "isSupport", "key", "Lcom/upuphone/ai/ttsengine/base/bean/CacheKey;", "onPlayEnd", "", "onPlayError", "errorCode", "", "pauseTTS", "playMp3", "cacheFile", "Ljava/io/File;", "playPcm", "resumeTTS", "startSpeak", "paramString", "", "streamtype", "stopTTS", "ttsAgentDestroy", "aar_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCacheTtsAgent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CacheTtsAgent.kt\ncom/upuphone/ai/ttsengine/engines/cache/CacheTtsAgent\n+ 2 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n*L\n1#1,205:1\n48#2,4:206\n*S KotlinDebug\n*F\n+ 1 CacheTtsAgent.kt\ncom/upuphone/ai/ttsengine/engines/cache/CacheTtsAgent\n*L\n35#1:206,4\n*E\n"})
@Keep
public final class CacheTtsAgent extends AbsTtsAgent {
    /* access modifiers changed from: private */
    @Nullable
    public AbstractPlayer audioPlayer;
    @NotNull
    private final CoroutineScope coroutineScope = CoroutineScopeKt.a(SupervisorKt.b((Job) null, 1, (Object) null).plus(Dispatchers.b()).plus(new CacheTtsAgent$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.a0, this)));
    /* access modifiers changed from: private */
    @Nullable
    public Job playingJob;
    /* access modifiers changed from: private */
    @NotNull
    public final CacheTtsAgent$ttsPlayListener$1 ttsPlayListener = new CacheTtsAgent$ttsPlayListener$1(this);

    private final void playMp3(File file) {
        this.playingJob = BuildersKt__Builders_commonKt.d(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CacheTtsAgent$playMp3$1(this, file, (Continuation<? super CacheTtsAgent$playMp3$1>) null), 3, (Object) null);
    }

    private final void playPcm(File file) {
        this.playingJob = BuildersKt__Builders_commonKt.d(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CacheTtsAgent$playPcm$1(file, this, (Continuation<? super CacheTtsAgent$playPcm$1>) null), 3, (Object) null);
    }

    @NotNull
    public TtsAgentType getAgentType() {
        return TtsAgentType.CACHE;
    }

    public /* bridge */ /* synthetic */ int getPriority() {
        return super.getPriority();
    }

    public boolean init(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        getAiLog().c("init", new Object[0]);
        super.init(application);
        CacheManager.f5534a.f(application);
        return true;
    }

    public boolean isSupport(@NotNull CacheKey cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, IntentKey.ACTIVITY.ACTION_KEY);
        return CacheManager.f5534a.h(cacheKey);
    }

    public void onPlayEnd() {
        this.audioPlayer = null;
        super.onPlayEnd();
    }

    public void onPlayError(int i) {
        this.audioPlayer = null;
        super.onPlayError(i);
    }

    public boolean pauseTTS() {
        if (!isAudioPlaying()) {
            return false;
        }
        AbstractPlayer abstractPlayer = this.audioPlayer;
        if (abstractPlayer != null) {
            abstractPlayer.i();
        }
        return true;
    }

    public /* bridge */ /* synthetic */ void reload() {
        super.reload();
    }

    public boolean resumeTTS() {
        if (!isAudioPlaying()) {
            return false;
        }
        AbstractPlayer abstractPlayer = this.audioPlayer;
        if (abstractPlayer != null) {
            abstractPlayer.k();
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean startSpeak(@org.jetbrains.annotations.NotNull java.lang.String r8, int r9) {
        /*
            r7 = this;
            java.lang.String r9 = "paramString"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r9)
            com.upuphone.ai.ttsengine.base.utils.AILOG r9 = r7.getAiLog()
            boolean r0 = r7.isAudioPlaying()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "startSpeak: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r2 = ", isTtsPlaying:"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r9.c(r0, r2)
            r9 = 5
            r0 = 0
            boolean r2 = r7.isAudioPlaying()     // Catch:{ Exception -> 0x0038 }
            if (r2 == 0) goto L_0x003b
            r7.stopTTS()     // Catch:{ Exception -> 0x0038 }
            goto L_0x003b
        L_0x0038:
            r8 = move-exception
            goto L_0x00b2
        L_0x003b:
            com.upuphone.ai.ttsengine.engines.cache.CacheManager r2 = com.upuphone.ai.ttsengine.engines.cache.CacheManager.f5534a     // Catch:{ Exception -> 0x0038 }
            com.upuphone.ai.ttsengine.base.bean.CacheKey r3 = new com.upuphone.ai.ttsengine.base.bean.CacheKey     // Catch:{ Exception -> 0x0038 }
            java.lang.String r4 = r7.getVoiceId()     // Catch:{ Exception -> 0x0038 }
            java.lang.String r5 = r7.getLanguage()     // Catch:{ Exception -> 0x0038 }
            r3.<init>(r4, r5, r8)     // Catch:{ Exception -> 0x0038 }
            java.io.File r8 = r2.d(r3)     // Catch:{ Exception -> 0x0038 }
            com.upuphone.ai.ttsengine.base.utils.AILOG r2 = r7.getAiLog()     // Catch:{ Exception -> 0x0059 }
            if (r8 == 0) goto L_0x005e
            java.lang.String r3 = r8.getPath()     // Catch:{ Exception -> 0x0059 }
            goto L_0x005f
        L_0x0059:
            r0 = move-exception
            r6 = r0
            r0 = r8
            r8 = r6
            goto L_0x00b2
        L_0x005e:
            r3 = r0
        L_0x005f:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0059 }
            r4.<init>()     // Catch:{ Exception -> 0x0059 }
            java.lang.String r5 = "get cache file: "
            r4.append(r5)     // Catch:{ Exception -> 0x0059 }
            r4.append(r3)     // Catch:{ Exception -> 0x0059 }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x0059 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0059 }
            r2.c(r3, r4)     // Catch:{ Exception -> 0x0059 }
            if (r8 == 0) goto L_0x00a3
            boolean r2 = r8.exists()     // Catch:{ Exception -> 0x0059 }
            r3 = 1
            if (r2 != r3) goto L_0x00a3
            com.upuphone.ai.ttsengine.base.utils.AILOG r2 = r7.getAiLog()     // Catch:{ Exception -> 0x0059 }
            java.lang.String r4 = "start playAudio"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0059 }
            r2.c(r4, r5)     // Catch:{ Exception -> 0x0059 }
            java.lang.String r2 = r8.getPath()     // Catch:{ Exception -> 0x0059 }
            java.lang.String r4 = "getPath(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)     // Catch:{ Exception -> 0x0059 }
            java.lang.String r4 = ".mp3"
            r5 = 2
            boolean r0 = kotlin.text.StringsKt.endsWith$default(r2, r4, r1, r5, r0)     // Catch:{ Exception -> 0x0059 }
            if (r0 == 0) goto L_0x009f
            r7.playMp3(r8)     // Catch:{ Exception -> 0x0059 }
            goto L_0x00a2
        L_0x009f:
            r7.playPcm(r8)     // Catch:{ Exception -> 0x0059 }
        L_0x00a2:
            return r3
        L_0x00a3:
            com.upuphone.ai.ttsengine.base.utils.AILOG r0 = r7.getAiLog()     // Catch:{ Exception -> 0x0059 }
            java.lang.String r2 = "startSpeak but cache file not exit"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0059 }
            r0.c(r2, r3)     // Catch:{ Exception -> 0x0059 }
            r7.onPlayError(r9)     // Catch:{ Exception -> 0x0059 }
            return r1
        L_0x00b2:
            com.upuphone.ai.ttsengine.base.utils.AILOG r2 = r7.getAiLog()
            java.lang.String r8 = r8.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "start speak error: "
            r3.append(r4)
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            java.lang.Object[] r3 = new java.lang.Object[r1]
            r2.h(r8, r3)
            if (r0 == 0) goto L_0x00d5
            r0.delete()
        L_0x00d5:
            r7.onPlayError(r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.ttsengine.engines.cache.CacheTtsAgent.startSpeak(java.lang.String, int):boolean");
    }

    public boolean stopTTS() {
        Job job = this.playingJob;
        if (job != null && job.isActive()) {
            AILOG aiLog = getAiLog();
            Job job2 = this.playingJob;
            aiLog.c("stop tts for job: " + job2, new Object[0]);
            Object unused = BuildersKt__BuildersKt.b((CoroutineContext) null, new CacheTtsAgent$stopTTS$1(this, (Continuation<? super CacheTtsAgent$stopTTS$1>) null), 1, (Object) null);
        }
        if (isAudioPlaying()) {
            onPlayInterrupted();
            AbstractPlayer abstractPlayer = this.audioPlayer;
            if (abstractPlayer != null) {
                abstractPlayer.p();
            }
            AbstractPlayer abstractPlayer2 = this.audioPlayer;
            if (abstractPlayer2 != null) {
                abstractPlayer2.j();
            }
            this.audioPlayer = null;
            setAudioPlaying(false);
        }
        return true;
    }

    public void ttsAgentDestroy() {
        AbstractPlayer abstractPlayer = this.audioPlayer;
        if (abstractPlayer != null) {
            abstractPlayer.j();
        }
        CoroutineScopeKt.e(this.coroutineScope, (CancellationException) null, 1, (Object) null);
    }
}
