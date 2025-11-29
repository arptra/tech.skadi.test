package com.upuphone.starrynet.core.bredr.profile;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.client.pbap.BluetoothPbapClient;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.Nullable;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.bredr.listener.IBTPbapClientEventCallback;
import java.util.List;

public class BrEdrPbapManager implements IBTPbapClientEventCallback {
    static final String TAG = "BrEdrPbapManager";
    private BluetoothPbapClient mBTPbapClient;
    BluetoothDevice mBluetoothDevice;
    Handler mBrEdrManagerHandler;
    private boolean mDownloading;
    private boolean mNeedDownload;

    public BrEdrPbapManager(Handler handler) {
        this.mBrEdrManagerHandler = handler;
    }

    public void onEvent(int i, int i2, int i3, @Nullable Object obj) {
        StLog.d(TAG, "BluetoothPbapHandler, eventId:" + i + " arg1:" + i2 + " arg2:" + i3 + " object:" + obj);
        if (i != 2) {
            if (i == 202) {
                this.mDownloading = false;
                if (this.mNeedDownload) {
                    pullPhoneBook(this.mBluetoothDevice);
                }
            }
        } else if (obj != null) {
            this.mBTPbapClient.g();
            Message obtainMessage = this.mBrEdrManagerHandler.obtainMessage(5);
            obtainMessage.obj = (List) obj;
            this.mBrEdrManagerHandler.sendMessage(obtainMessage);
        }
    }

    public synchronized boolean pullPhoneBook(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            StLog.w(TAG, "device is null");
            return false;
        } else if (this.mDownloading) {
            StLog.d(TAG, "Downloading, wait");
            this.mNeedDownload = true;
            return false;
        } else {
            this.mDownloading = true;
            this.mNeedDownload = false;
            this.mBluetoothDevice = bluetoothDevice;
            BluetoothPbapClient bluetoothPbapClient = new BluetoothPbapClient(bluetoothDevice, this);
            this.mBTPbapClient = bluetoothPbapClient;
            bluetoothPbapClient.f();
            return this.mBTPbapClient.h("telecom/pb.vcf");
        }
    }

    public void resetPhoneBookRecord() {
        StLog.d(TAG, "resetPhoneBookRecord");
        this.mDownloading = false;
        this.mNeedDownload = false;
    }
}
