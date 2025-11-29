package com.xjsd.ai.natives;

import com.xjsd.ai.voice.IVoiceListener;

public class NativeLib {
    private IVoiceListener m_IVoiceListener = null;

    static {
        System.loadLibrary("xj-voice-jni");
    }

    public native void AddKwsWords(String str, float f);

    public native void Destory(int i);

    public native int Feed(byte[] bArr);

    public native int FeedWithLen(byte[] bArr, int i);

    public native int GetSizePerSend();

    public native int Init(String str) throws Exception;

    public native float Itensity(byte[] bArr);

    public native void Reset();

    public native void SetKwsGrams(short s, short s2, short s3, short s4);

    public native void SetKwsThreshold(float f);

    public native void SetPttEvent();

    public native void SetVadPause(int i);

    public native int Start();

    public native void Stop();

    public native void Switch(int i);

    public native String Version();

    public native float WakeupConfidence();

    public void onNativeData(int i, byte[] bArr, int i2, int i3, float f) {
        IVoiceListener iVoiceListener = this.m_IVoiceListener;
        if (iVoiceListener != null) {
            iVoiceListener.onData(i, bArr, i2);
            this.m_IVoiceListener.onData(i, bArr, i2, i3, f);
        }
    }

    public void onNativeMsg(String str, int i) {
        IVoiceListener iVoiceListener = this.m_IVoiceListener;
        if (iVoiceListener != null) {
            iVoiceListener.onMsg(str, i);
        }
    }

    public void onNativeWakeupMsg(String str, int i) {
        IVoiceListener iVoiceListener = this.m_IVoiceListener;
        if (iVoiceListener != null) {
            iVoiceListener.onWakeup(str, i);
        }
    }

    public void oneShotCallBack(int i, int i2, int i3) {
        IVoiceListener iVoiceListener = this.m_IVoiceListener;
        if (iVoiceListener != null) {
            iVoiceListener.oneshotCallBack(i, i2, i3);
        }
    }

    public void registerListener(IVoiceListener iVoiceListener) {
        this.m_IVoiceListener = iVoiceListener;
    }

    public void unregisterListener() {
        this.m_IVoiceListener = null;
    }
}
