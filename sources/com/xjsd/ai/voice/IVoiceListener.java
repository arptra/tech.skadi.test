package com.xjsd.ai.voice;

import androidx.annotation.Keep;

@Keep
public interface IVoiceListener {
    void onData(int i, byte[] bArr, int i2);

    void onData(int i, byte[] bArr, int i2, int i3, float f);

    void onMsg(String str, int i);

    void onWakeup(String str, int i);

    void oneshotCallBack(int i, int i2, int i3);
}
