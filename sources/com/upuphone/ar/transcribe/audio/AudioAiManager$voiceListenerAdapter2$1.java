package com.upuphone.ar.transcribe.audio;

import com.xjsd.ai.voice.VoiceListenerAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/upuphone/ar/transcribe/audio/AudioAiManager$voiceListenerAdapter2$1", "Lcom/xjsd/ai/voice/VoiceListenerAdapter;", "onData", "", "iSta", "", "data", "", "wavId", "chanIdx", "fIntensity", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AudioAiManager$voiceListenerAdapter2$1 extends VoiceListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AudioAiManager f6021a;

    public AudioAiManager$voiceListenerAdapter2$1(AudioAiManager audioAiManager) {
        this.f6021a = audioAiManager;
    }

    public void onData(int i, byte[] bArr, int i2, int i3, float f) {
        Function2 d = this.f6021a.g;
        if (d != null) {
            d.invoke(Integer.valueOf(i), Integer.valueOf(i3));
        }
    }
}
