package com.ucar.protocol.channel.socket;

import com.ucar.protocol.ProtocolConfig;
import com.ucar.protocol.UCarMessage;
import com.ucar.protocol.channel.FutureCallback;
import com.ucar.protocol.log.ProtocolLogger;

class DefaultFutureCallback implements FutureCallback<UCarMessage> {

    /* renamed from: a  reason: collision with root package name */
    public static final DefaultFutureCallback f9643a = new DefaultFutureCallback();

    public void c(Exception exc) {
        ProtocolLogger b = ProtocolConfig.b();
        b.e("DefaultFutureCallback", "request error: " + exc.getMessage(), exc);
    }

    /* renamed from: e */
    public void a(UCarMessage uCarMessage) {
    }

    /* renamed from: f */
    public UCarMessage b(UCarMessage uCarMessage) {
        return uCarMessage;
    }
}
