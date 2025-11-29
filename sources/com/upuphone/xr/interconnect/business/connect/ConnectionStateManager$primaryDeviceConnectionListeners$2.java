package com.upuphone.xr.interconnect.business.connect;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/upuphone/xr/interconnect/business/connect/BlePrimaryDeviceConnectionListener;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectionStateManager$primaryDeviceConnectionListeners$2 extends Lambda implements Function0<Set<? extends BlePrimaryDeviceConnectionListener>> {
    final /* synthetic */ ListenerLinkingCollector<BlePrimaryDeviceConnectionListener> $primaryDeviceConnectionListenerLinkingCollector;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionStateManager$primaryDeviceConnectionListeners$2(ListenerLinkingCollector<BlePrimaryDeviceConnectionListener> listenerLinkingCollector) {
        super(0);
        this.$primaryDeviceConnectionListenerLinkingCollector = listenerLinkingCollector;
    }

    @NotNull
    public final Set<BlePrimaryDeviceConnectionListener> invoke() {
        return this.$primaryDeviceConnectionListenerLinkingCollector.get();
    }
}
