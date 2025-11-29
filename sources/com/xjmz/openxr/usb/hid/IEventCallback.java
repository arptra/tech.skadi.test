package com.xjmz.openxr.usb.hid;

public interface IEventCallback {
    void a();

    void on7911StatusChanged(int i, int i2, int i3);

    void onBrightnessChanged(int i);

    void onHidChannelConnectionStatusChanged(int i);

    void onKeyEvent(int i, int i2);

    void onLog(String str);

    void onUpgradeProgressChanged(int i, int i2, int i3, int i4);

    void onWearingStatusChanged(boolean z);
}
