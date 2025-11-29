package com.upuphone.starrynet.core.usb;

import android.content.Context;
import android.content.IntentFilter;
import android.hardware.usb.UsbAccessory;
import android.os.ParcelFileDescriptor;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.usb.listener.IUsbStarryDiscoverListener;
import com.upuphone.starrynet.core.usb.manager.UsbAccessoryManager;
import com.upuphone.starrynet.core.usb.receiver.UsbAccessoryReceiver;
import java.util.List;

public class UsbStarryManager {
    private static final String TAG = "UsbStarryManager";
    private Context mContext;
    private IUsbStarryDiscoverListener mIUsbStarryDiscoverListener;
    private UsbAccessoryManager mUsbAccessoryManager;
    private UsbAccessoryReceiver mUsbAccessoryReceiver;

    public static class Holder {
        /* access modifiers changed from: private */
        public static final UsbStarryManager INSTANCE = new UsbStarryManager();

        private Holder() {
        }
    }

    public static UsbStarryManager getInstance() {
        return Holder.INSTANCE;
    }

    private void registerBoardcast() {
        if (this.mUsbAccessoryReceiver != null) {
            StLog.i(TAG, "Usb广播已注册，无需重复注册");
            return;
        }
        StLog.d(TAG, "注册UsbAccessory广播");
        this.mUsbAccessoryReceiver = new UsbAccessoryReceiver(this.mIUsbStarryDiscoverListener);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(UsbAccessoryReceiver.ACTION_USB_ACCESSORY_PERMISSION);
        intentFilter.addAction("android.hardware.usb.action.USB_ACCESSORY_HANDSHAKE");
        intentFilter.addAction("android.hardware.usb.action.USB_ACCESSORY_DETACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_STATE");
        this.mContext.registerReceiver(this.mUsbAccessoryReceiver, intentFilter);
    }

    public ParcelFileDescriptor connect(UsbAccessory usbAccessory) {
        return this.mUsbAccessoryManager.connect(usbAccessory);
    }

    public UsbStarryManager init(Context context, IUsbStarryDiscoverListener iUsbStarryDiscoverListener) {
        this.mContext = context;
        this.mUsbAccessoryManager = UsbAccessoryManager.getInstance().init(this.mContext);
        this.mIUsbStarryDiscoverListener = iUsbStarryDiscoverListener;
        registerBoardcast();
        startDiscovery();
        return this;
    }

    public void startDiscovery() {
        List<UsbAccessory> currentUsbAccessDeviceList = this.mUsbAccessoryManager.getCurrentUsbAccessDeviceList();
        if (currentUsbAccessDeviceList.size() > 0) {
            for (UsbAccessory onFound : currentUsbAccessDeviceList) {
                this.mIUsbStarryDiscoverListener.onFound(onFound);
            }
        }
    }
}
