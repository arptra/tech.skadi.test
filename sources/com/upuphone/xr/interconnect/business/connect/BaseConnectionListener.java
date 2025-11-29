package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.device.StarryDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\nH\u0016J \u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\nH\u0016J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\nH\u0016J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\nH\u0016J \u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\nH\u0016J \u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\nH\u0016J \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016¨\u0006\u001d"}, d2 = {"Lcom/upuphone/xr/interconnect/business/connect/BaseConnectionListener;", "", "onGlassBleBinding", "", "deviceId", "", "device", "Lcom/upuphone/runasone/device/StarryDevice;", "onGlassBleBound", "isBrBound", "", "onGlassBleConnected", "isBrConnected", "onGlassBleConnectedDeviceUpdate", "onGlassBleDisconnected", "onGlassBleUnbound", "onGlassBrBound", "isBleBound", "onGlassBrConnected", "isBleConnected", "onGlassBrDisconnected", "onGlassBrUnbound", "onRingBinding", "onRingBound", "onRingConnected", "onRingConnectedDeviceUpdate", "onRingDisconnected", "onRingUnbound", "onSetAllConnectionDisconnected", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface BaseConnectionListener {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onGlassBleBinding(@NotNull BaseConnectionListener baseConnectionListener, @NotNull String str, @NotNull StarryDevice starryDevice) {
            Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
            Intrinsics.checkNotNullParameter(starryDevice, "device");
        }

        public static void onGlassBleBound(@NotNull BaseConnectionListener baseConnectionListener, @NotNull String str, @NotNull StarryDevice starryDevice, boolean z) {
            Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
            Intrinsics.checkNotNullParameter(starryDevice, "device");
        }

        public static void onGlassBleConnected(@NotNull BaseConnectionListener baseConnectionListener, @NotNull String str, @NotNull StarryDevice starryDevice, boolean z) {
            Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
            Intrinsics.checkNotNullParameter(starryDevice, "device");
        }

        public static void onGlassBleConnectedDeviceUpdate(@NotNull BaseConnectionListener baseConnectionListener, @NotNull String str, @NotNull StarryDevice starryDevice, boolean z) {
            Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
            Intrinsics.checkNotNullParameter(starryDevice, "device");
        }

        public static void onGlassBleDisconnected(@NotNull BaseConnectionListener baseConnectionListener, @NotNull String str, @NotNull StarryDevice starryDevice, boolean z) {
            Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
            Intrinsics.checkNotNullParameter(starryDevice, "device");
        }

        public static void onGlassBleUnbound(@NotNull BaseConnectionListener baseConnectionListener, @NotNull String str, @NotNull StarryDevice starryDevice, boolean z) {
            Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
            Intrinsics.checkNotNullParameter(starryDevice, "device");
        }

        public static void onGlassBrBound(@NotNull BaseConnectionListener baseConnectionListener, @NotNull String str, @NotNull StarryDevice starryDevice, boolean z) {
            Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
            Intrinsics.checkNotNullParameter(starryDevice, "device");
        }

        public static void onGlassBrConnected(@NotNull BaseConnectionListener baseConnectionListener, @NotNull String str, @NotNull StarryDevice starryDevice, boolean z) {
            Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
            Intrinsics.checkNotNullParameter(starryDevice, "device");
        }

        public static void onGlassBrDisconnected(@NotNull BaseConnectionListener baseConnectionListener, @NotNull String str, @NotNull StarryDevice starryDevice, boolean z) {
            Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
            Intrinsics.checkNotNullParameter(starryDevice, "device");
        }

        public static void onGlassBrUnbound(@NotNull BaseConnectionListener baseConnectionListener, @NotNull String str, @NotNull StarryDevice starryDevice, boolean z) {
            Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
            Intrinsics.checkNotNullParameter(starryDevice, "device");
        }

        public static void onRingBinding(@NotNull BaseConnectionListener baseConnectionListener, @NotNull String str, @NotNull StarryDevice starryDevice) {
            Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
            Intrinsics.checkNotNullParameter(starryDevice, "device");
        }

        public static void onRingBound(@NotNull BaseConnectionListener baseConnectionListener, @NotNull String str, @NotNull StarryDevice starryDevice) {
            Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
            Intrinsics.checkNotNullParameter(starryDevice, "device");
        }

        public static void onRingConnected(@NotNull BaseConnectionListener baseConnectionListener, @NotNull String str, @NotNull StarryDevice starryDevice) {
            Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
            Intrinsics.checkNotNullParameter(starryDevice, "device");
        }

        public static void onRingConnectedDeviceUpdate(@NotNull BaseConnectionListener baseConnectionListener, @NotNull String str, @NotNull StarryDevice starryDevice) {
            Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
            Intrinsics.checkNotNullParameter(starryDevice, "device");
        }

        public static void onRingDisconnected(@NotNull BaseConnectionListener baseConnectionListener, @NotNull String str, @NotNull StarryDevice starryDevice) {
            Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
            Intrinsics.checkNotNullParameter(starryDevice, "device");
        }

        public static void onRingUnbound(@NotNull BaseConnectionListener baseConnectionListener, @NotNull String str, @NotNull StarryDevice starryDevice) {
            Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
            Intrinsics.checkNotNullParameter(starryDevice, "device");
        }

        public static void onSetAllConnectionDisconnected(@NotNull BaseConnectionListener baseConnectionListener) {
        }
    }

    void onGlassBleBinding(@NotNull String str, @NotNull StarryDevice starryDevice);

    void onGlassBleBound(@NotNull String str, @NotNull StarryDevice starryDevice, boolean z);

    void onGlassBleConnected(@NotNull String str, @NotNull StarryDevice starryDevice, boolean z);

    void onGlassBleConnectedDeviceUpdate(@NotNull String str, @NotNull StarryDevice starryDevice, boolean z);

    void onGlassBleDisconnected(@NotNull String str, @NotNull StarryDevice starryDevice, boolean z);

    void onGlassBleUnbound(@NotNull String str, @NotNull StarryDevice starryDevice, boolean z);

    void onGlassBrBound(@NotNull String str, @NotNull StarryDevice starryDevice, boolean z);

    void onGlassBrConnected(@NotNull String str, @NotNull StarryDevice starryDevice, boolean z);

    void onGlassBrDisconnected(@NotNull String str, @NotNull StarryDevice starryDevice, boolean z);

    void onGlassBrUnbound(@NotNull String str, @NotNull StarryDevice starryDevice, boolean z);

    void onRingBinding(@NotNull String str, @NotNull StarryDevice starryDevice);

    void onRingBound(@NotNull String str, @NotNull StarryDevice starryDevice);

    void onRingConnected(@NotNull String str, @NotNull StarryDevice starryDevice);

    void onRingConnectedDeviceUpdate(@NotNull String str, @NotNull StarryDevice starryDevice);

    void onRingDisconnected(@NotNull String str, @NotNull StarryDevice starryDevice);

    void onRingUnbound(@NotNull String str, @NotNull StarryDevice starryDevice);

    void onSetAllConnectionDisconnected();
}
