package com.upuphone.ai.ttsengine.engines.cloud;

import com.upuphone.ai.ttsengine.base.helper.TtsPlayListener;
import com.upuphone.ai.ttsengine.base.player.PcmPlayer;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004¨\u0006\t"}, d2 = {"com/upuphone/ai/ttsengine/engines/cloud/CloudEngine$ttsPlayListener$1", "Lcom/upuphone/ai/ttsengine/base/helper/TtsPlayListener;", "", "d", "()V", "b", "c", "e", "a", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class CloudEngine$ttsPlayListener$1 implements TtsPlayListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CloudEngine f5553a;

    public CloudEngine$ttsPlayListener$1(CloudEngine cloudEngine) {
        this.f5553a = cloudEngine;
    }

    public void a() {
        AILOG access$getAiLog = this.f5553a.getAiLog();
        PcmPlayer access$getAudioPlayer$p = this.f5553a.audioPlayer;
        access$getAiLog.c("TTS audio: " + access$getAudioPlayer$p + " 播报完成", new Object[0]);
        this.f5553a.onPlayEnd();
    }

    public void b() {
        AILOG access$getAiLog = this.f5553a.getAiLog();
        PcmPlayer access$getAudioPlayer$p = this.f5553a.audioPlayer;
        access$getAiLog.c("TTS audio: " + access$getAudioPlayer$p + " 播报暂停", new Object[0]);
        this.f5553a.onPlayPause();
    }

    public void c() {
        AILOG access$getAiLog = this.f5553a.getAiLog();
        PcmPlayer access$getAudioPlayer$p = this.f5553a.audioPlayer;
        access$getAiLog.c("TTS audio: " + access$getAudioPlayer$p + " 播报恢复", new Object[0]);
        this.f5553a.onPlayResume();
    }

    public void d() {
        AILOG access$getAiLog = this.f5553a.getAiLog();
        PcmPlayer access$getAudioPlayer$p = this.f5553a.audioPlayer;
        access$getAiLog.c("TTS audio: " + access$getAudioPlayer$p + " 开始播报", new Object[0]);
        if (this.f5553a.isAudioPlaying()) {
            this.f5553a.onPlayStart();
        } else {
            this.f5553a.getAiLog().h("Maybe stop was called before start", new Object[0]);
        }
    }

    public void e() {
        AILOG access$getAiLog = this.f5553a.getAiLog();
        PcmPlayer access$getAudioPlayer$p = this.f5553a.audioPlayer;
        access$getAiLog.c("TTS audio: " + access$getAudioPlayer$p + " 播报打断", new Object[0]);
        this.f5553a.onPlayError(3);
    }
}
