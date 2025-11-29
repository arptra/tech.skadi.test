package com.ucar.connect.aoa;

import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.system.OsConstants;
import com.easy.logger.EasyLog;

public class UsbNative {

    /* renamed from: a  reason: collision with root package name */
    public static int f9628a = -1;

    static {
        System.loadLibrary("usbio");
    }

    public static int a(UsbDeviceConnection usbDeviceConnection, UsbEndpoint usbEndpoint, byte[] bArr, int i, int i2, long j) {
        int c = c(i2);
        if (usbDeviceConnection == null || bArr == null || usbEndpoint == null || c < 0 || i < 0 || i + c > bArr.length) {
            EasyLog.c("UsbNative", "invalid parameter for bulkRead");
            return -OsConstants.EINVAL;
        } else if (usbEndpoint.getDirection() == 128) {
            return nativeBulkRead(usbDeviceConnection.getFileDescriptor(), usbEndpoint.getAddress(), bArr, i, c, j);
        } else {
            EasyLog.c("UsbNative", "wrong direction of usb endpoint for bulkRead");
            return -OsConstants.EINVAL;
        }
    }

    public static int b(UsbDeviceConnection usbDeviceConnection, UsbEndpoint usbEndpoint, byte[] bArr, int i, int i2, long j) {
        int c = c(i2);
        if (usbDeviceConnection == null || bArr == null || usbEndpoint == null || c < 0 || i < 0 || i + c > bArr.length) {
            EasyLog.c("UsbNative", "invalid parameter for bulkWrite");
            return -OsConstants.EINVAL;
        } else if (usbEndpoint.getDirection() == 0) {
            return nativeBulkWrite(usbDeviceConnection.getFileDescriptor(), usbEndpoint.getAddress(), bArr, i, c, j);
        } else {
            EasyLog.c("UsbNative", "wrong direction of usb endpoint for bulkWrite");
            return -OsConstants.EINVAL;
        }
    }

    public static int c(int i) {
        int i2 = f9628a;
        if (i2 == -1) {
            return -1;
        }
        if (i2 >= 28 || i <= 16384) {
            return i;
        }
        return 16384;
    }

    public static void d(int i) {
        f9628a = i;
    }

    private static native int nativeBulkRead(int i, int i2, byte[] bArr, int i3, int i4, long j);

    private static native int nativeBulkWrite(int i, int i2, byte[] bArr, int i3, int i4, long j);
}
