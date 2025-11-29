package com.xjsd.ai.voice;

import androidx.annotation.Keep;

@Keep
public abstract class VoiceListenerAdapter implements IVoiceListener {
    public void onData(int i, byte[] bArr, int i2) {
    }

    public void onMsg(String str, int i) {
    }

    public void onWakeup(String str, int i) {
    }

    public void oneshotCallBack(int i, int i2, int i3) {
    }

    public void onData(int i, byte[] bArr, int i2, int i3, float f) {
    }
}
