package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.xr.interconnect.api.StarryNetAppChangeListener;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nPeerAppStatusManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PeerAppStatusManager.kt\ncom/upuphone/xr/interconnect/business/connect/PeerAppStatusManager$warmUpListener$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,90:1\n1747#2,2:91\n1749#2:94\n1#3:93\n*S KotlinDebug\n*F\n+ 1 PeerAppStatusManager.kt\ncom/upuphone/xr/interconnect/business/connect/PeerAppStatusManager$warmUpListener$1\n*L\n48#1:91,2\n48#1:94\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PeerAppStatusManager$warmUpListener$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StarryNetAppChangeListener $listener;
    final /* synthetic */ PeerAppStatusManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PeerAppStatusManager$warmUpListener$1(PeerAppStatusManager peerAppStatusManager, StarryNetAppChangeListener starryNetAppChangeListener) {
        super(0);
        this.this$0 = peerAppStatusManager;
        this.$listener = starryNetAppChangeListener;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        StarryNetAppChangeListener starryNetAppChangeListener = this.$listener;
        ILog.d(access$getTag, "Warming up " + starryNetAppChangeListener + ".");
        if (this.$listener != null) {
            if (!(!this.this$0.confirmedAvailableDeviceIds.isEmpty())) {
                Collection<StarryDevice> values = this.this$0.baseConnectionManager.getGlassDeviceInfoMap().values();
                if (!(values instanceof Collection) || !values.isEmpty()) {
                    for (StarryDevice terminalType : values) {
                        byte terminalType2 = terminalType.getTerminalType();
                        if (terminalType2 != 4) {
                            if (terminalType2 == 6) {
                            }
                        }
                    }
                }
                this.$listener.onPeerAppRemoved();
                return;
            }
            this.$listener.onPeerAppInstalled();
        }
    }
}
