package com.upuphone.starrynet.core.spp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.HandlerThreadUtil;
import com.upuphone.starrynet.core.spp.callback.ICommonServerListener;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

class SPPServerListener {
    private static final String TAG = "SPPServerListener";
    public static final String THREAD_NAME = "thread_spp_server";
    private ICommonServerListener mICommonServerListener;
    private boolean mIsListening;
    private final Runnable mServerListenTask = new e(this);
    private UUID mUUIDListening;

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            BluetoothServerSocket listenUsingRfcommWithServiceRecord = defaultAdapter.listenUsingRfcommWithServiceRecord(defaultAdapter.getName(), this.mUUIDListening);
            this.mICommonServerListener.onAdvertiseSuccess(this.mUUIDListening);
            while (this.mIsListening) {
                try {
                    BluetoothSocket accept = listenUsingRfcommWithServiceRecord.accept();
                    this.mICommonServerListener.onConnectionAccepted(accept.getRemoteDevice().getAddress(), accept);
                } catch (IOException e) {
                    String str = TAG;
                    StLog.d(str, "accept error..." + e);
                    this.mIsListening = false;
                }
            }
        } catch (IOException e2) {
            String str2 = TAG;
            StLog.d(str2, "listenUsingRfcommWithServiceRecord error..." + e2);
            this.mICommonServerListener.onAdvertiseFail(this.mUUIDListening);
            this.mIsListening = false;
        }
    }

    public Optional<UUID> fetchUUIDListening() {
        return this.mIsListening ? Optional.ofNullable(this.mUUIDListening) : Optional.empty();
    }

    public void start(UUID uuid, ICommonServerListener iCommonServerListener) {
        if (this.mIsListening) {
            StLog.d(TAG, "current is listening, return...");
            return;
        }
        StLog.d(TAG, "start spp server listen");
        this.mUUIDListening = uuid;
        this.mIsListening = true;
        this.mICommonServerListener = iCommonServerListener;
        new Handler(HandlerThreadUtil.getInstance().getLooper(THREAD_NAME)).post(this.mServerListenTask);
    }

    public void stop() {
        StLog.d(TAG, "stop spp server listen");
        HandlerThreadUtil.getInstance().quitThread(THREAD_NAME);
        this.mIsListening = false;
    }
}
