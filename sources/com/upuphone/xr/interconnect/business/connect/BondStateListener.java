package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/upuphone/xr/interconnect/business/connect/BondStateListener;", "", "onBinding", "", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "onBound", "onUnbound", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface BondStateListener {
    void onBinding(@NotNull StarryNetDevice starryNetDevice);

    void onBound(@NotNull StarryNetDevice starryNetDevice);

    void onUnbound(@NotNull StarryNetDevice starryNetDevice);
}
