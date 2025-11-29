package com.xjsd.ai.assistant.asr.engine;

import android.app.Application;
import com.xjsd.ai.assistant.asr.AsrEventListener;
import java.util.List;

public interface AsrEngine {
    void feedData(byte[] bArr, int i);

    void flush();

    int getErrorCode();

    void init(Application application);

    boolean isReady();

    void setOnAsrEventListener(AsrEventListener asrEventListener);

    boolean startRecognize(String str, List list);

    void stopRecognize();
}
