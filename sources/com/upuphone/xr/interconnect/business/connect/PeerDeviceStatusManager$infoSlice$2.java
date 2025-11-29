package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.DataBinderSlice;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/upuphone/xr/interconnect/api/DataBinderSlice;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PeerDeviceStatusManager$infoSlice$2 extends Lambda implements Function0<DataBinderSlice> {
    public static final PeerDeviceStatusManager$infoSlice$2 INSTANCE = new PeerDeviceStatusManager$infoSlice$2();

    public PeerDeviceStatusManager$infoSlice$2() {
        super(0);
    }

    @NotNull
    public final DataBinderSlice invoke() {
        return InterconnectManager.getInstance().getDataBinderManager().getSlice("info");
    }
}
