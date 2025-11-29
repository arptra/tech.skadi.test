package com.upuphone.xr.interconnect.inner;

import com.upuphone.xr.interconnect.api.OperatorManager;

public class InnerOperatorManagerCreator implements OperatorManagerCreator {
    public OperatorManager create(String str) {
        return new InnerOperatorManager(str);
    }
}
