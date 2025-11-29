package com.upuphone.ai.ttsengine.engines.wav;

import android.app.Application;
import androidx.annotation.Keep;
import com.upuphone.ai.ttsengine.base.AbsTtsAgent;
import com.upuphone.ai.ttsengine.base.ITtsStatusListener;
import com.upuphone.ai.ttsengine.base.bean.CacheKey;
import com.upuphone.ai.ttsengine.base.enums.TtsAgentType;
import com.upuphone.ai.ttsengine.engines.wav.internal.PcmTtsAgent;
import com.upuphone.ai.ttsengine.engines.wav.internal.WavTtsAgent;
import com.upuphone.runasone.relay.api.IntentKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/upuphone/ai/ttsengine/engines/wav/FileTtsAgent;", "Lcom/upuphone/ai/ttsengine/base/AbsTtsAgent;", "()V", "fileAgents", "", "getAgentType", "Lcom/upuphone/ai/ttsengine/base/enums/TtsAgentType;", "init", "", "context", "Landroid/app/Application;", "isSpeaking", "isSupport", "key", "Lcom/upuphone/ai/ttsengine/base/bean/CacheKey;", "pauseTTS", "prepare", "", "resumeTTS", "setListener", "listener", "Lcom/upuphone/ai/ttsengine/base/ITtsStatusListener;", "startSpeak", "paramString", "", "streamtype", "", "stopTTS", "ttsAgentDestroy", "aar_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFileTtsAgent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileTtsAgent.kt\ncom/upuphone/ai/ttsengine/engines/wav/FileTtsAgent\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,72:1\n1855#2,2:73\n1855#2,2:75\n1855#2,2:77\n288#2,2:79\n288#2,2:81\n766#2:83\n857#2,2:84\n1855#2,2:86\n1855#2,2:88\n1#3:90\n*S KotlinDebug\n*F\n+ 1 FileTtsAgent.kt\ncom/upuphone/ai/ttsengine/engines/wav/FileTtsAgent\n*L\n21#1:73,2\n26#1:75,2\n33#1:77,2\n45#1:79,2\n49#1:81,2\n53#1:83\n53#1:84,2\n53#1:86,2\n58#1:88,2\n*E\n"})
@Keep
public final class FileTtsAgent extends AbsTtsAgent {
    @NotNull
    private final List<AbsTtsAgent> fileAgents = new ArrayList();

    @NotNull
    public TtsAgentType getAgentType() {
        return TtsAgentType.LOCAL_FILE;
    }

    public /* bridge */ /* synthetic */ int getPriority() {
        return super.getPriority();
    }

    public boolean init(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        super.init(application);
        this.fileAgents.add(new PcmTtsAgent());
        this.fileAgents.add(new WavTtsAgent());
        for (AbsTtsAgent init : this.fileAgents) {
            init.init(application);
        }
        return true;
    }

    public boolean isSpeaking() {
        T t;
        Iterator<T> it = this.fileAgents.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (((AbsTtsAgent) t).isSpeaking()) {
                break;
            }
        }
        return t != null;
    }

    public boolean isSupport(@NotNull CacheKey cacheKey) {
        T t;
        Intrinsics.checkNotNullParameter(cacheKey, IntentKey.ACTIVITY.ACTION_KEY);
        Iterator<T> it = this.fileAgents.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (((AbsTtsAgent) t).isSupport(cacheKey)) {
                break;
            }
        }
        return t != null;
    }

    public boolean pauseTTS() {
        T t;
        Iterator<T> it = this.fileAgents.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (((AbsTtsAgent) t).isSpeaking()) {
                break;
            }
        }
        AbsTtsAgent absTtsAgent = (AbsTtsAgent) t;
        if (absTtsAgent != null) {
            return absTtsAgent.pauseTTS();
        }
        return false;
    }

    public void prepare() {
        for (AbsTtsAgent prepare : this.fileAgents) {
            prepare.prepare();
        }
    }

    public /* bridge */ /* synthetic */ void reload() {
        super.reload();
    }

    public boolean resumeTTS() {
        T t;
        Iterator<T> it = this.fileAgents.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (((AbsTtsAgent) t).isSpeaking()) {
                break;
            }
        }
        AbsTtsAgent absTtsAgent = (AbsTtsAgent) t;
        if (absTtsAgent != null) {
            return absTtsAgent.resumeTTS();
        }
        return false;
    }

    public boolean setListener(@Nullable ITtsStatusListener iTtsStatusListener) {
        for (AbsTtsAgent listener : this.fileAgents) {
            listener.setListener(iTtsStatusListener);
        }
        return true;
    }

    public boolean startSpeak(@NotNull String str, int i) {
        T t;
        Intrinsics.checkNotNullParameter(str, "paramString");
        Iterator<T> it = this.fileAgents.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (((AbsTtsAgent) t).isSupport(new CacheKey("BV700_streaming", "", str))) {
                break;
            }
        }
        AbsTtsAgent absTtsAgent = (AbsTtsAgent) t;
        if (absTtsAgent != null) {
            return absTtsAgent.startSpeak(str, i);
        }
        return false;
    }

    public boolean stopTTS() {
        List<AbsTtsAgent> list = this.fileAgents;
        ArrayList<AbsTtsAgent> arrayList = new ArrayList<>();
        for (T next : list) {
            if (((AbsTtsAgent) next).isSpeaking()) {
                arrayList.add(next);
            }
        }
        for (AbsTtsAgent stopTTS : arrayList) {
            stopTTS.stopTTS();
        }
        return true;
    }

    public void ttsAgentDestroy() {
        for (AbsTtsAgent ttsAgentDestroy : this.fileAgents) {
            ttsAgentDestroy.ttsAgentDestroy();
        }
    }
}
