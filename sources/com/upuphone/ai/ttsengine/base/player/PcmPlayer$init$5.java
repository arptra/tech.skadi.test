package com.upuphone.ai.ttsengine.base.player;

import android.media.AudioTrack;
import com.upuphone.ai.ttsengine.base.helper.TtsPlayListener;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/upuphone/ai/ttsengine/base/player/PcmPlayer$init$5", "Landroid/media/AudioTrack$OnPlaybackPositionUpdateListener;", "onMarkerReached", "", "track", "Landroid/media/AudioTrack;", "onPeriodicNotification", "aar_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PcmPlayer$init$5 implements AudioTrack.OnPlaybackPositionUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PcmPlayer f5510a;

    public PcmPlayer$init$5(PcmPlayer pcmPlayer) {
        this.f5510a = pcmPlayer;
    }

    public void onMarkerReached(AudioTrack audioTrack) {
        Intrinsics.checkNotNullParameter(audioTrack, "track");
        this.f5510a.l.removeMessages(1);
        this.f5510a.k.c("**** onMarkerReached", new Object[0]);
        PcmPlayer pcmPlayer = this.f5510a;
        try {
            Result.Companion companion = Result.Companion;
            AudioTrack t = pcmPlayer.n;
            Integer valueOf = t != null ? Integer.valueOf(t.getPlaybackHeadPosition()) : null;
            AILOG s = pcmPlayer.k;
            s.c("on marker reached head : " + valueOf, new Object[0]);
            Result.m20constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m20constructorimpl(ResultKt.createFailure(th));
        }
        this.f5510a.A();
        TtsPlayListener e = this.f5510a.e();
        if (e != null) {
            e.a();
        }
    }

    public void onPeriodicNotification(AudioTrack audioTrack) {
        Intrinsics.checkNotNullParameter(audioTrack, "track");
        this.f5510a.k.c("onPeriodicNotification", new Object[0]);
    }
}
