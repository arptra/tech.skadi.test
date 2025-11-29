package com.upuphone.ai.ttsengine.engines.wav.internal;

import android.app.Application;
import androidx.annotation.Keep;
import com.upuphone.ai.ttsengine.base.AbsTtsAgent;
import com.upuphone.ai.ttsengine.base.bean.CacheKey;
import com.upuphone.ai.ttsengine.base.enums.TtsAgentType;
import com.upuphone.ai.ttsengine.base.player.PcmPlayer;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import com.upuphone.runasone.relay.api.IntentKey;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nPcmTtsAgent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PcmTtsAgent.kt\ncom/upuphone/ai/ttsengine/engines/wav/internal/PcmTtsAgent\n+ 2 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n*L\n1#1,204:1\n48#2,4:205\n*S KotlinDebug\n*F\n+ 1 PcmTtsAgent.kt\ncom/upuphone/ai/ttsengine/engines/wav/internal/PcmTtsAgent\n*L\n38#1:205,4\n*E\n"})
@Keep
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t*\u0001\r\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J%\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00192\u0006\u0010\u0013\u001a\u00020\u0014H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0012H\u0016J\b\u0010\"\u001a\u00020\u0012H\u0016J\u0018\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020 H\u0016J\b\u0010&\u001a\u00020\u0012H\u0016J\b\u0010'\u001a\u00020\u001aH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000e\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006)"}, d2 = {"Lcom/upuphone/ai/ttsengine/engines/wav/internal/PcmTtsAgent;", "Lcom/upuphone/ai/ttsengine/base/AbsTtsAgent;", "()V", "audioPlayer", "Lcom/upuphone/ai/ttsengine/base/player/PcmPlayer;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "playingJob", "Lkotlinx/coroutines/Job;", "supportWords", "", "", "ttsPlayListener", "com/upuphone/ai/ttsengine/engines/wav/internal/PcmTtsAgent$ttsPlayListener$1", "Lcom/upuphone/ai/ttsengine/engines/wav/internal/PcmTtsAgent$ttsPlayListener$1;", "getAgentType", "Lcom/upuphone/ai/ttsengine/base/enums/TtsAgentType;", "init", "", "context", "Landroid/app/Application;", "isSupport", "key", "Lcom/upuphone/ai/ttsengine/base/bean/CacheKey;", "loadSource", "Lkotlin/Result;", "", "loadSource-IoAF18A", "(Landroid/app/Application;)Ljava/lang/Object;", "onPlayEnd", "onPlayError", "errorCode", "", "pauseTTS", "resumeTTS", "startSpeak", "paramString", "streamtype", "stopTTS", "ttsAgentDestroy", "Companion", "aar_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PcmTtsAgent extends AbsTtsAgent {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String MAP_FILE_PATH = "pcm/words.map";
    @NotNull
    private static final String MAP_SPLIT_MARK = "&";
    /* access modifiers changed from: private */
    @Nullable
    public PcmPlayer audioPlayer;
    @NotNull
    private final CoroutineScope coroutineScope = CoroutineScopeKt.a(SupervisorKt.b((Job) null, 1, (Object) null).plus(Dispatchers.b()).plus(new PcmTtsAgent$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.a0, this)));
    /* access modifiers changed from: private */
    @Nullable
    public Job playingJob;
    /* access modifiers changed from: private */
    @NotNull
    public final Map<String, String> supportWords = new LinkedHashMap();
    /* access modifiers changed from: private */
    @NotNull
    public final PcmTtsAgent$ttsPlayListener$1 ttsPlayListener = new PcmTtsAgent$ttsPlayListener$1(this);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/ai/ttsengine/engines/wav/internal/PcmTtsAgent$Companion;", "", "()V", "MAP_FILE_PATH", "", "MAP_SPLIT_MARK", "aar_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r5, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0052, code lost:
        throw r0;
     */
    /* renamed from: loadSource-IoAF18A  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object m1663loadSourceIoAF18A(android.app.Application r5) {
        /*
            r4 = this;
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x004a }
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch:{ all -> 0x004a }
            java.lang.String r0 = "pcm/words.map"
            java.io.InputStream r5 = r5.open(r0)     // Catch:{ all -> 0x004a }
            r0 = 0
            if (r5 == 0) goto L_0x0053
            java.io.LineNumberReader r1 = new java.io.LineNumberReader     // Catch:{ all -> 0x004c }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x004c }
            r2.<init>(r5)     // Catch:{ all -> 0x004c }
            r1.<init>(r2)     // Catch:{ all -> 0x004c }
            com.upuphone.ai.ttsengine.engines.wav.internal.PcmTtsAgent$loadSource$1$1$1 r2 = new com.upuphone.ai.ttsengine.engines.wav.internal.PcmTtsAgent$loadSource$1$1$1     // Catch:{ all -> 0x004c }
            r2.<init>(r4)     // Catch:{ all -> 0x004c }
            kotlin.io.TextStreamsKt.forEachLine(r1, r2)     // Catch:{ all -> 0x004c }
            com.upuphone.ai.ttsengine.base.utils.AILOG r1 = r4.getAiLog()     // Catch:{ all -> 0x004c }
            java.util.Map<java.lang.String, java.lang.String> r4 = r4.supportWords     // Catch:{ all -> 0x004c }
            int r4 = r4.size()     // Catch:{ all -> 0x004c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x004c }
            r2.<init>()     // Catch:{ all -> 0x004c }
            java.lang.String r3 = "local pcm size: "
            r2.append(r3)     // Catch:{ all -> 0x004c }
            r2.append(r4)     // Catch:{ all -> 0x004c }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x004c }
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x004c }
            r1.c(r4, r2)     // Catch:{ all -> 0x004c }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004c }
            kotlin.io.CloseableKt.closeFinally(r5, r0)     // Catch:{ all -> 0x004a }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004a }
            goto L_0x0053
        L_0x004a:
            r4 = move-exception
            goto L_0x0058
        L_0x004c:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x004e }
        L_0x004e:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r5, r4)     // Catch:{ all -> 0x004a }
            throw r0     // Catch:{ all -> 0x004a }
        L_0x0053:
            java.lang.Object r4 = kotlin.Result.m20constructorimpl(r0)     // Catch:{ all -> 0x004a }
            goto L_0x0062
        L_0x0058:
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m20constructorimpl(r4)
        L_0x0062:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.ttsengine.engines.wav.internal.PcmTtsAgent.m1663loadSourceIoAF18A(android.app.Application):java.lang.Object");
    }

    @NotNull
    public TtsAgentType getAgentType() {
        return TtsAgentType.LOCAL_FILE;
    }

    public /* bridge */ /* synthetic */ int getPriority() {
        return super.getPriority();
    }

    public boolean init(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        getAiLog().c("init", new Object[0]);
        super.init(application);
        m1663loadSourceIoAF18A(application);
        return true;
    }

    public boolean isSupport(@NotNull CacheKey cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, IntentKey.ACTIVITY.ACTION_KEY);
        return this.supportWords.containsKey(StringsKt.trim((CharSequence) StringsKt.replace$default(cacheKey.c(), StringUtils.LF, " ", false, 4, (Object) null)).toString());
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
        PcmPlayer pcmPlayer = this.audioPlayer;
        if (pcmPlayer != null) {
            pcmPlayer.i();
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
        PcmPlayer pcmPlayer = this.audioPlayer;
        if (pcmPlayer != null) {
            pcmPlayer.k();
        }
        return true;
    }

    public boolean startSpeak(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "paramString");
        AILOG aiLog = getAiLog();
        boolean isAudioPlaying = isAudioPlaying();
        aiLog.c("startSpeak: " + str + ", isTtsPlaying:" + isAudioPlaying, new Object[0]);
        try {
            if (isAudioPlaying()) {
                stopTTS();
            }
            getAiLog().c("start playAudio", new Object[0]);
            this.playingJob = BuildersKt__Builders_commonKt.d(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new PcmTtsAgent$startSpeak$1(this, str, (Continuation<? super PcmTtsAgent$startSpeak$1>) null), 3, (Object) null);
            return true;
        } catch (Exception e) {
            AILOG aiLog2 = getAiLog();
            String message = e.getMessage();
            aiLog2.h("start speak error: " + message, new Object[0]);
            this.supportWords.remove(str);
            onPlayError(5);
            return false;
        }
    }

    public boolean stopTTS() {
        Job job = this.playingJob;
        if (job != null && job.isActive()) {
            AILOG aiLog = getAiLog();
            Job job2 = this.playingJob;
            aiLog.c("stop tts for job: " + job2, new Object[0]);
            Object unused = BuildersKt__BuildersKt.b((CoroutineContext) null, new PcmTtsAgent$stopTTS$1(this, (Continuation<? super PcmTtsAgent$stopTTS$1>) null), 1, (Object) null);
        }
        if (isAudioPlaying()) {
            onPlayInterrupted();
            PcmPlayer pcmPlayer = this.audioPlayer;
            if (pcmPlayer != null) {
                pcmPlayer.p();
            }
            setAudioPlaying(false);
        }
        return true;
    }

    public void ttsAgentDestroy() {
        PcmPlayer pcmPlayer = this.audioPlayer;
        if (pcmPlayer != null) {
            pcmPlayer.j();
        }
        CoroutineScopeKt.e(this.coroutineScope, (CancellationException) null, 1, (Object) null);
    }
}
