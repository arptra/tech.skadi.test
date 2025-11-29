package com.honey.account.n3;

import android.os.Handler;
import android.os.Message;
import com.upuphone.ai.ttsengine.base.player.PcmPlayer;

public final /* synthetic */ class e implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PcmPlayer f4954a;

    public /* synthetic */ e(PcmPlayer pcmPlayer) {
        this.f4954a = pcmPlayer;
    }

    public final boolean handleMessage(Message message) {
        return PcmPlayer.r(this.f4954a, message);
    }
}
