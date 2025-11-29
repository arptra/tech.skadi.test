package com.upuphone.runasone.relay.lib.air;

import com.upuphone.runasone.relay.lib.air.AirPortMessageManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/upuphone/runasone/relay/lib/air/AirPortMessageManager$TimeOutHandler;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AirPortMessageManager$timeOut$2 extends Lambda implements Function0<AirPortMessageManager.TimeOutHandler> {
    public static final AirPortMessageManager$timeOut$2 INSTANCE = new AirPortMessageManager$timeOut$2();

    public AirPortMessageManager$timeOut$2() {
        super(0);
    }

    @NotNull
    public final AirPortMessageManager.TimeOutHandler invoke() {
        return new AirPortMessageManager.TimeOutHandler();
    }
}
