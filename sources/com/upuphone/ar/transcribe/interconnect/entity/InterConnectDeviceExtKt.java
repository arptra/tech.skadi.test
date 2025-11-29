package com.upuphone.ar.transcribe.interconnect.entity;

import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0007\u001a\n\u0010\b\u001a\u00020\t*\u00020\u0007\u001a\n\u0010\n\u001a\u00020\t*\u00020\u0007\u001a\n\u0010\u000b\u001a\u00020\t*\u00020\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"TERMINAL_TYPE_IOS", "", "TERMINAL_TYPE_PHONE", "TERMINAL_TYPE_THIRD", "TERMINAL_TYPE_XR", "append", "Lcom/upuphone/ar/transcribe/interconnect/entity/InterConnectDevice;", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "isPhoneDevice", "", "isThirdPhone", "isXRDevice", "ar-transcribe_intlRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class InterConnectDeviceExtKt {
    public static final byte TERMINAL_TYPE_IOS = 6;
    public static final byte TERMINAL_TYPE_PHONE = 1;
    public static final byte TERMINAL_TYPE_THIRD = 4;
    public static final byte TERMINAL_TYPE_XR = 2;

    @NotNull
    public static final InterConnectDevice append(@NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "<this>");
        InterConnectDevice interConnectDevice = new InterConnectDevice();
        String deviceId = starryNetDevice.getDeviceId();
        String str = "";
        if (deviceId == null) {
            deviceId = str;
        } else {
            Intrinsics.checkNotNull(deviceId);
        }
        interConnectDevice.setDeviceId(deviceId);
        String deviceName = starryNetDevice.getDeviceName();
        if (deviceName == null) {
            deviceName = str;
        } else {
            Intrinsics.checkNotNull(deviceName);
        }
        interConnectDevice.setDeviceName(deviceName);
        String categoryId = starryNetDevice.getCategoryId();
        if (categoryId == null) {
            categoryId = str;
        } else {
            Intrinsics.checkNotNull(categoryId);
        }
        interConnectDevice.setCategoryId(categoryId);
        String categoryName = starryNetDevice.getCategoryName();
        if (categoryName == null) {
            categoryName = str;
        } else {
            Intrinsics.checkNotNull(categoryName);
        }
        interConnectDevice.setCategoryName(categoryName);
        String companyId = starryNetDevice.getCompanyId();
        if (companyId == null) {
            companyId = str;
        } else {
            Intrinsics.checkNotNull(companyId);
        }
        interConnectDevice.setCompanyId(companyId);
        String companyName = starryNetDevice.getCompanyName();
        if (companyName == null) {
            companyName = str;
        } else {
            Intrinsics.checkNotNull(companyName);
        }
        interConnectDevice.setCompanyName(companyName);
        String modelId = starryNetDevice.getModelId();
        if (modelId == null) {
            modelId = str;
        } else {
            Intrinsics.checkNotNull(modelId);
        }
        interConnectDevice.setModelId(modelId);
        String modelName = starryNetDevice.getModelName();
        if (modelName == null) {
            modelName = str;
        } else {
            Intrinsics.checkNotNull(modelName);
        }
        interConnectDevice.setModelName(modelName);
        String brEdrMac = starryNetDevice.getBrEdrMac();
        if (brEdrMac == null) {
            brEdrMac = str;
        } else {
            Intrinsics.checkNotNull(brEdrMac);
        }
        interConnectDevice.setBrEdrMac(brEdrMac);
        String bleMac = starryNetDevice.getBleMac();
        if (bleMac == null) {
            bleMac = str;
        } else {
            Intrinsics.checkNotNull(bleMac);
        }
        interConnectDevice.setBleMac(bleMac);
        String wifiMac = starryNetDevice.getWifiMac();
        if (wifiMac != null) {
            Intrinsics.checkNotNull(wifiMac);
            str = wifiMac;
        }
        interConnectDevice.setWifiMac(str);
        interConnectDevice.setTerminalType(starryNetDevice.getTerminalType());
        interConnectDevice.setStatus(starryNetDevice.getStatus());
        return interConnectDevice;
    }

    public static final boolean isPhoneDevice(@NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "<this>");
        return starryNetDevice.getTerminalType() == 1 || starryNetDevice.getTerminalType() == 4 || starryNetDevice.getTerminalType() == 6;
    }

    public static final boolean isThirdPhone(@NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "<this>");
        return starryNetDevice.getTerminalType() == 4;
    }

    public static final boolean isXRDevice(@NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "<this>");
        return starryNetDevice.getTerminalType() == 2;
    }
}
