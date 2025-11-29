package com.xjsd.ai.assistant.phone.session.interceptor;

import com.xjsd.ai.assistant.phone.cmd.AudioDataTransCmdHandler;
import kotlinx.coroutines.channels.ProducerScope;

public final /* synthetic */ class a implements AudioDataTransCmdHandler.OnDataListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProducerScope f8600a;

    public /* synthetic */ a(ProducerScope producerScope) {
        this.f8600a = producerScope;
    }

    public final void b(byte[] bArr) {
        AudioDataInterceptor$onCreate$flow$1.invokeSuspend$lambda$0(this.f8600a, bArr);
    }
}
