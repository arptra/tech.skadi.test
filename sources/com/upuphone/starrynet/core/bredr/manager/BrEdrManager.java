package com.upuphone.starrynet.core.bredr.manager;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.client.pbap.PhonebookPullRequest;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.HandlerThreadUtil;
import com.upuphone.starrynet.core.bredr.BrEdrEventManager;
import com.upuphone.starrynet.core.bredr.listener.IBrEdrActionStateCallback;
import com.upuphone.starrynet.core.bredr.listener.IBrEdrConnectStateCallback;
import java.util.List;
import java.util.Map;

public abstract class BrEdrManager {
    public static final int MSG_A2DP_SERVICE_CONNECTED = 2;
    public static final int MSG_A2DP_SERVICE_DISCONNECTED = 4;
    public static final int MSG_CLEAR_PHONE_BOOK = 6;
    public static final int MSG_HFP_SERVICE_CONNECTED = 1;
    public static final int MSG_HFP_SERVICE_DISCONNECTED = 3;
    public static final int MSG_PULL_PHONE_BOOK_DONE = 5;
    static final String TAG = "BrEdrManager";
    /* access modifiers changed from: private */
    public boolean mA2dpServiceReady = false;
    protected BluetoothAdapter mAdapter;
    protected Context mContext;
    protected Handler mHandler;
    /* access modifiers changed from: private */
    public boolean mHfpServiceReady = false;
    /* access modifiers changed from: private */
    public final PhonebookPullRequest mPhonePullRequest;

    public class BrEdrManagerHandler extends Handler {
        public BrEdrManagerHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(@NonNull Message message) {
            StLog.d(BrEdrManager.TAG, "BrEdrManagerHandler: msg: " + message.what);
            switch (message.what) {
                case 1:
                    boolean unused = BrEdrManager.this.mHfpServiceReady = true;
                    BrEdrManager.this.checkServiceReady();
                    return;
                case 2:
                    boolean unused2 = BrEdrManager.this.mA2dpServiceReady = true;
                    BrEdrManager.this.checkServiceReady();
                    return;
                case 3:
                    boolean unused3 = BrEdrManager.this.mHfpServiceReady = false;
                    BrEdrManager.this.resetPhoneBookRecord();
                    return;
                case 4:
                    boolean unused4 = BrEdrManager.this.mA2dpServiceReady = false;
                    return;
                case 5:
                    BrEdrEventManager.getInstance(BrEdrManager.this.mContext).pullPhoneBookChange(1);
                    BrEdrManager.this.mPhonePullRequest.a((List) message.obj);
                    BrEdrManager.this.mPhonePullRequest.d();
                    return;
                case 6:
                    BrEdrManager.this.mPhonePullRequest.b(BrEdrManager.this.mContext.getContentResolver());
                    return;
                default:
                    return;
            }
        }
    }

    public BrEdrManager(Context context) {
        this.mContext = context;
        this.mHandler = new BrEdrManagerHandler(HandlerThreadUtil.getInstance().getLooper("BrEdrManager Handler"));
        this.mAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mPhonePullRequest = new PhonebookPullRequest(this.mContext);
    }

    public void checkServiceReady() {
        if (this.mHfpServiceReady && this.mA2dpServiceReady) {
            BrEdrEventManager.getInstance(this.mContext).brEdrServiceReady();
        }
    }

    public void clearPhoneBook() {
        Message.obtain(this.mHandler, 6).sendToTarget();
    }

    public void connectBrEdr(BluetoothDevice bluetoothDevice) {
    }

    public void dial(BluetoothDevice bluetoothDevice, String str) {
    }

    public void disconnectBrEdr(BluetoothDevice bluetoothDevice) {
    }

    public BluetoothDevice getActiveDevice() {
        return null;
    }

    public abstract Map<BluetoothDevice, Integer> getBrEdrConnectedDeviceList();

    public Map<String, Integer> getCallList() {
        return BrEdrEventManager.getInstance(this.mContext).getCallList();
    }

    public void operateCallAction(BluetoothDevice bluetoothDevice, int i) {
    }

    public void pullPhoneBook(BluetoothDevice bluetoothDevice) {
    }

    public void registerActionStateListener(IBrEdrActionStateCallback iBrEdrActionStateCallback) {
        BrEdrEventManager.getInstance(this.mContext).registerActionStateListener(iBrEdrActionStateCallback);
    }

    public void registerConnectStateListener(IBrEdrConnectStateCallback iBrEdrConnectStateCallback) {
        BrEdrEventManager.getInstance(this.mContext).registerConnectStateListener(iBrEdrConnectStateCallback);
    }

    public int removeAudioActiveDevice() {
        return 0;
    }

    public void resetPhoneBookRecord() {
    }

    public int switchAudioPlayDevice(BluetoothDevice bluetoothDevice) {
        return 0;
    }
}
