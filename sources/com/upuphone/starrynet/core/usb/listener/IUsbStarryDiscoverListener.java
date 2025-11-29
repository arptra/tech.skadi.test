package com.upuphone.starrynet.core.usb.listener;

import android.hardware.usb.UsbAccessory;

public interface IUsbStarryDiscoverListener {
    void onFound(UsbAccessory usbAccessory);

    void onLoseAll();
}
