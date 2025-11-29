package com.upuphone.ar.translation.phone.helper;

import com.xjsd.ai.voice.VoiceListenerAdapter;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/upuphone/ar/translation/phone/helper/TelephoneTransHelper$init$1$2$1", "Lcom/xjsd/ai/voice/VoiceListenerAdapter;", "onData", "", "iSta", "", "data", "", "wavId", "chanIdx", "fIntensity", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TelephoneTransHelper$init$1$2$1 extends VoiceListenerAdapter {
    public void onData(int i, byte[] bArr, int i2, int i3, float f) {
        super.onData(i, bArr, i2, i3, f);
        if (bArr != null) {
            TelephoneTransHelper.f6305a.x(i);
        }
    }
}
