package com.honey.account.r5;

import com.upuphone.runasone.channel.linker.starrystack.NetworkUtils;
import java.net.NetworkInterface;
import java.util.Comparator;

public final /* synthetic */ class b implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return NetworkUtils.lambda$getWlansInterface$1((NetworkInterface) obj, (NetworkInterface) obj2);
    }
}
