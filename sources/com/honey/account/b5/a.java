package com.honey.account.b5;

import com.upuphone.ar.transcribe.statemachine.handler.XunFeiChannelHandler$mWebSocketMsgListener$1;
import com.upuphone.oggopus.OggOpus;
import com.xjsd.xr.sapp.asr.dao.TtsData;

public final /* synthetic */ class a implements OggOpus.OnDataListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TtsData f4187a;

    public /* synthetic */ a(TtsData ttsData) {
        this.f4187a = ttsData;
    }

    public final void onData(byte[] bArr, long j) {
        XunFeiChannelHandler$mWebSocketMsgListener$1.b(this.f4187a, bArr, j);
    }
}
