package com.upuphone.xr.interconnect.main;

import com.upuphone.xr.interconnect.entity.Function;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;

public class StarryNetMessageFactory {
    private StarryNetMessageFactory() {
    }

    public static StarryNetMessage createFunctionMessage(Function function) {
        StarryNetMessage createInnerMessage = createInnerMessage();
        createInnerMessage.setMessage(function.toString());
        return createInnerMessage;
    }

    public static StarryNetMessage createInnerMessage() {
        StarryNetMessage starryNetMessage = new StarryNetMessage();
        starryNetMessage.setReceiverPkg("com.upuphone.xr.interconnect");
        starryNetMessage.setSenderPkg("com.upuphone.xr.interconnect");
        return starryNetMessage;
    }
}
