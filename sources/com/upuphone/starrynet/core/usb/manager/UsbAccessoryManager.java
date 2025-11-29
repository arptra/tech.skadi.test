package com.upuphone.starrynet.core.usb.manager;

import android.content.Context;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbManager;
import android.os.ParcelFileDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsbAccessoryManager extends UsbBaseManager {
    private static final String TAG = "UsbAccessoryManager";
    protected UsbManager mUsbManager;

    public static class Holder {
        /* access modifiers changed from: private */
        public static final UsbAccessoryManager INSTANCE = new UsbAccessoryManager();

        private Holder() {
        }
    }

    public static UsbAccessoryManager getInstance() {
        return Holder.INSTANCE;
    }

    public ParcelFileDescriptor connect(UsbAccessory usbAccessory) {
        return this.mUsbManager.openAccessory(usbAccessory);
    }

    public List<UsbAccessory> getCurrentUsbAccessDeviceList() {
        UsbAccessory[] accessoryList = this.mUsbManager.getAccessoryList();
        return accessoryList == null ? new ArrayList() : Arrays.asList(accessoryList);
    }

    public UsbAccessoryManager init(Context context) {
        this.mUsbManager = (UsbManager) context.getSystemService("usb");
        return Holder.INSTANCE;
    }
}
