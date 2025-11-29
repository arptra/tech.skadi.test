package com.ucar.protocol.channel;

import com.ucar.protocol.UCarMessage;

public interface SendFutureCallback extends FutureCallback<Boolean> {
    /* renamed from: d */
    void a(Boolean bool) {
    }

    Boolean b(UCarMessage uCarMessage) {
        if (uCarMessage != null) {
            uCarMessage.u();
        }
        return Boolean.valueOf(uCarMessage != null);
    }
}
