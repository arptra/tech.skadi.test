package com.upuphone.starrynet.core.usb.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbAccessory;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.usb.listener.IUsbStarryDiscoverListener;
import com.upuphone.starrynet.core.usb.manager.UsbAccessoryManager;
import java.util.List;

public class UsbAccessoryReceiver extends BroadcastReceiver {
    public static final String ACTION_USB_ACCESSORY_PERMISSION = "com.upuphone.starrynet.core.usb.usb_accessory_permission";
    private static final int FAIL_TIMES = 10;
    private static final int MSG_REFOUND_JOB = 1;
    private static final int MSG_START_REFOUND_JOB = 2;
    private static final int REFOUND_DIVIDER_TIME = 20;
    private static final String TAG = "UsbAccessoryReceiver";
    /* access modifiers changed from: private */
    public int findTimes;
    /* access modifiers changed from: private */
    public final Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i == 2) {
                    UsbAccessoryReceiver.this.mHandler.removeMessages(1);
                    int unused = UsbAccessoryReceiver.this.findTimes = 0;
                    UsbAccessoryReceiver.this.findAccessory();
                }
            } else if (UsbAccessoryReceiver.this.findTimes >= 10) {
                int unused2 = UsbAccessoryReceiver.this.findTimes = 0;
                StLog.i(UsbAccessoryReceiver.TAG, "find accessory device fail");
            } else {
                UsbAccessoryReceiver.this.findAccessory();
            }
        }
    };
    private IUsbStarryDiscoverListener mIUsbAccessoryDeviceDiscoverListener;
    private boolean mIsUsbConnected;

    public UsbAccessoryReceiver(IUsbStarryDiscoverListener iUsbStarryDiscoverListener) {
        this.mIUsbAccessoryDeviceDiscoverListener = iUsbStarryDiscoverListener;
    }

    public void findAccessory() {
        List<UsbAccessory> currentUsbAccessDeviceList = UsbAccessoryManager.getInstance().getCurrentUsbAccessDeviceList();
        StLog.i(TAG, "find accessory device count:" + currentUsbAccessDeviceList.size());
        if (currentUsbAccessDeviceList.size() > 0) {
            for (UsbAccessory onFound : currentUsbAccessDeviceList) {
                this.mIUsbAccessoryDeviceDiscoverListener.onFound(onFound);
            }
            return;
        }
        this.findTimes++;
        this.mHandler.sendEmptyMessageDelayed(1, 20);
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        StLog.i(TAG, "revceive usb broadcast：" + action);
        action.hashCode();
        char c = 65535;
        switch (action.hashCode()) {
            case -494529457:
                if (action.equals("android.hardware.usb.action.USB_STATE")) {
                    c = 0;
                    break;
                }
                break;
            case 276138536:
                if (action.equals("android.hardware.usb.action.USB_ACCESSORY_HANDSHAKE")) {
                    c = 1;
                    break;
                }
                break;
            case 1605365505:
                if (action.equals("android.hardware.usb.action.USB_ACCESSORY_DETACHED")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.mIsUsbConnected = intent.getBooleanExtra("connected", false);
                return;
            case 1:
                boolean booleanExtra = intent.getBooleanExtra("android.hardware.usb.extra.ACCESSORY_START", false);
                StLog.d(TAG, "isFirstChangeToAccessory:" + booleanExtra + " mIsUsbConnected:" + this.mIsUsbConnected);
                if (booleanExtra && this.mIsUsbConnected) {
                    this.mHandler.sendEmptyMessage(2);
                    return;
                }
                return;
            case 2:
                StLog.i(TAG, "usb close accessory model");
                this.mIUsbAccessoryDeviceDiscoverListener.onLoseAll();
                return;
            default:
                return;
        }
    }
}
