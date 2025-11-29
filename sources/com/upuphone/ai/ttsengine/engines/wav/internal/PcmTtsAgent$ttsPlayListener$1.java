package com.upuphone.ai.ttsengine.engines.wav.internal;

import com.upuphone.ai.ttsengine.base.helper.TtsPlayListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004¨\u0006\t"}, d2 = {"com/upuphone/ai/ttsengine/engines/wav/internal/PcmTtsAgent$ttsPlayListener$1", "Lcom/upuphone/ai/ttsengine/base/helper/TtsPlayListener;", "", "d", "()V", "b", "c", "e", "a", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class PcmTtsAgent$ttsPlayListener$1 implements TtsPlayListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PcmTtsAgent f5558a;

    public PcmTtsAgent$ttsPlayListener$1(PcmTtsAgent pcmTtsAgent) {
        this.f5558a = pcmTtsAgent;
    }

    public void a() {
        this.f5558a.getAiLog().c("play end", new Object[0]);
        this.f5558a.onPlayEnd();
    }

    public void b() {
        this.f5558a.getAiLog().c("play pause", new Object[0]);
        this.f5558a.onPlayPause();
    }

    public void c() {
        this.f5558a.getAiLog().c("play resume", new Object[0]);
        this.f5558a.onPlayResume();
    }

    public void d() {
        this.f5558a.getAiLog().c("play start", new Object[0]);
        this.f5558a.onPlayStart();
    }

    public void e() {
        this.f5558a.getAiLog().c("play interrupted", new Object[0]);
        this.f5558a.onPlayError(3);
    }
}
