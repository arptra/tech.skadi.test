package com.honey.account.c7;

import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import java.util.function.Predicate;

public final /* synthetic */ class a implements Predicate {
    public final boolean test(Object obj) {
        return ((StConnectDevice) obj).isProtocolConnected(1);
    }
}
