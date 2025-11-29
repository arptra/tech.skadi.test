package com.upuphone.ar.fastrecord.phone.utils;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/utils/PcmPlayer;", "", "()V", "AUDIO_FORMAT", "", "CHANNEL_CONFIG", "SAMPLE_RATE_IN_HZ", "TAG", "", "audioTrack", "Landroid/media/AudioTrack;", "createAudioTrackTo", "isSingle", "", "pauseTrack", "", "playInModeStream", "pcmPath", "resumeTrack", "stopTrack", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPcmPlayer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PcmPlayer.kt\ncom/upuphone/ar/fastrecord/phone/utils/PcmPlayer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,124:1\n1#2:125\n*E\n"})
public final class PcmPlayer {
    private static final int AUDIO_FORMAT = 2;
    private static final int CHANNEL_CONFIG = 16;
    @NotNull
    public static final PcmPlayer INSTANCE = new PcmPlayer();
    private static final int SAMPLE_RATE_IN_HZ = 16000;
    @NotNull
    private static final String TAG = "PcmPlayer";
    /* access modifiers changed from: private */
    @Nullable
    public static AudioTrack audioTrack;

    private PcmPlayer() {
    }

    private final AudioTrack createAudioTrackTo(boolean z) {
        int i = 12;
        int minBufferSize = AudioTrack.getMinBufferSize(16000, z ? 4 : 12, 2);
        if (minBufferSize > 0) {
            AudioTrack.Builder audioAttributes = new AudioTrack.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).setLegacyStreamType(3).build());
            AudioFormat.Builder sampleRate = new AudioFormat.Builder().setEncoding(2).setSampleRate(16000);
            if (z) {
                i = 4;
            }
            AudioTrack build = audioAttributes.setAudioFormat(sampleRate.setChannelMask(i).build()).setTransferMode(1).setBufferSizeInBytes(minBufferSize).build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            return build;
        }
        throw new IllegalStateException(("AudioTrack is not available " + minBufferSize).toString());
    }

    public final void pauseTrack() {
        AudioTrack audioTrack2 = audioTrack;
        if (audioTrack2 != null) {
            audioTrack2.pause();
        }
    }

    public final void playInModeStream(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "pcmPath");
        int minBufferSize = AudioTrack.getMinBufferSize(16000, z ? 4 : 12, 2);
        AudioTrack createAudioTrackTo = createAudioTrackTo(z);
        audioTrack = createAudioTrackTo;
        if (createAudioTrackTo != null) {
            createAudioTrackTo.play();
        }
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new PcmPlayer$playInModeStream$1(str, minBufferSize, (Continuation<? super PcmPlayer$playInModeStream$1>) null), 3, (Object) null);
    }

    public final void resumeTrack() {
        AudioTrack audioTrack2 = audioTrack;
        if (audioTrack2 != null) {
            audioTrack2.play();
        }
    }

    public final void stopTrack() {
        AudioTrack audioTrack2 = audioTrack;
        if (audioTrack2 != null) {
            audioTrack2.stop();
        }
        AudioTrack audioTrack3 = audioTrack;
        if (audioTrack3 != null) {
            audioTrack3.release();
        }
        audioTrack = null;
    }
}
