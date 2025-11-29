package com.honey.account.o3;

import android.os.Handler;
import android.os.Message;
import com.upuphone.ai.ttsengine.base.service.TtsStatusTimer;

public final /* synthetic */ class c implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TtsStatusTimer f4967a;

    public /* synthetic */ c(TtsStatusTimer ttsStatusTimer) {
        this.f4967a = ttsStatusTimer;
    }

    public final boolean handleMessage(Message message) {
        return TtsStatusTimer.b(this.f4967a, message);
    }
}
