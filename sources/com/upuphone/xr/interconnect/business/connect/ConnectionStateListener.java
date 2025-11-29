package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, d2 = {"Lcom/upuphone/xr/interconnect/business/connect/ConnectionStateListener;", "", "onConnectionBinding", "", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "onConnectionBound", "onConnectionConnecting", "Lcom/upuphone/runasone/device/StarryDevice;", "onConnectionUnbound", "onPrimaryConnectionConnected", "onPrimaryConnectionDisconnected", "onSecondaryConnectionConnected", "onSecondaryConnectionDisconnected", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ConnectionStateListener {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onConnectionBinding(@NotNull ConnectionStateListener connectionStateListener, @NotNull StarryNetDevice starryNetDevice) {
            Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        }

        public static void onConnectionBound(@NotNull ConnectionStateListener connectionStateListener, @NotNull StarryNetDevice starryNetDevice) {
            Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        }

        public static void onConnectionConnecting(@NotNull ConnectionStateListener connectionStateListener, @NotNull StarryDevice starryDevice) {
            Intrinsics.checkNotNullParameter(starryDevice, "device");
        }

        public static void onConnectionUnbound(@NotNull ConnectionStateListener connectionStateListener, @NotNull StarryNetDevice starryNetDevice) {
            Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        }

        public static void onPrimaryConnectionConnected(@NotNull ConnectionStateListener connectionStateListener, @NotNull StarryNetDevice starryNetDevice) {
            Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        }

        public static void onPrimaryConnectionDisconnected(@NotNull ConnectionStateListener connectionStateListener, @NotNull StarryNetDevice starryNetDevice) {
            Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        }

        public static void onSecondaryConnectionConnected(@NotNull ConnectionStateListener connectionStateListener, @NotNull StarryNetDevice starryNetDevice) {
            Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        }

        public static void onSecondaryConnectionDisconnected(@NotNull ConnectionStateListener connectionStateListener, @NotNull StarryNetDevice starryNetDevice) {
            Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        }
    }

    void onConnectionBinding(@NotNull StarryNetDevice starryNetDevice);

    void onConnectionBound(@NotNull StarryNetDevice starryNetDevice);

    void onConnectionConnecting(@NotNull StarryDevice starryDevice);

    void onConnectionUnbound(@NotNull StarryNetDevice starryNetDevice);

    void onPrimaryConnectionConnected(@NotNull StarryNetDevice starryNetDevice);

    void onPrimaryConnectionDisconnected(@NotNull StarryNetDevice starryNetDevice);

    void onSecondaryConnectionConnected(@NotNull StarryNetDevice starryNetDevice);

    void onSecondaryConnectionDisconnected(@NotNull StarryNetDevice starryNetDevice);
}
