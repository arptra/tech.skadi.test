package com.upuphone.ai.ttsengine.flavor.service;

import com.upuphone.ai.ttsengine.base.utils.AILOG;
import com.upuphone.ai.ttsengine.flavor.service.connect.Communicator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/upuphone/ai/ttsengine/flavor/service/RemoteService$initCommunicator$1", "Lcom/upuphone/ai/ttsengine/flavor/service/connect/Communicator$OnDataRcvListener;", "", "bytes", "", "a", "([B)V", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class RemoteService$initCommunicator$1 implements Communicator.OnDataRcvListener {
    public void a(byte[] bArr) {
        if (bArr != null) {
            if ((!(bArr.length == 0)) && bArr[0] == 10) {
                RemoteService.b.c("receive normal tts message", new Object[0]);
                byte[] copyOfRange = ArraysKt.copyOfRange(bArr, 2, bArr.length);
                byte b = bArr[1];
                if (b == 0) {
                    Object unused = RemoteService.f5563a.p(copyOfRange);
                } else if (b == 1) {
                    Object unused2 = RemoteService.f5563a.r(copyOfRange);
                } else {
                    AILOG b2 = RemoteService.b;
                    byte b3 = bArr[1];
                    b2.h("not support type: " + b3, new Object[0]);
                }
            }
        }
    }
}
