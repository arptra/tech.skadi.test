package com.upuphone.ar.translation.phone.helper;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class NetworkTimeHelper$getNetworkTime$1 extends Lambda implements Function2<Long, Long, Unit> {
    public static final NetworkTimeHelper$getNetworkTime$1 INSTANCE = new NetworkTimeHelper$getNetworkTime$1();

    public NetworkTimeHelper$getNetworkTime$1() {
        super(2);
    }

    public final void invoke(long j, long j2) {
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).longValue(), ((Number) obj2).longValue());
        return Unit.INSTANCE;
    }
}
