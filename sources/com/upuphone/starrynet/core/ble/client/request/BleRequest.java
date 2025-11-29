package com.upuphone.starrynet.core.ble.client.request;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import com.honey.account.u6.a;
import com.upuphone.starrynet.core.ble.BluetoothConstants;
import com.upuphone.starrynet.core.ble.BluetoothContextManager;
import com.upuphone.starrynet.core.ble.Constants;
import com.upuphone.starrynet.core.ble.client.BleConnectConfig;
import com.upuphone.starrynet.core.ble.client.IBleRequestDispatcher;
import com.upuphone.starrynet.core.ble.client.IBleWorker;
import com.upuphone.starrynet.core.ble.client.RuntimeChecker;
import com.upuphone.starrynet.core.ble.client.listener.GattResponseListener;
import com.upuphone.starrynet.core.ble.client.response.BleResponse;
import com.upuphone.starrynet.core.ble.client.response.BleResponser;
import com.upuphone.starrynet.core.ble.utils.BluetoothLog;
import java.util.UUID;

public abstract class BleRequest implements IBleWorker, IBleRequest, Handler.Callback, GattResponseListener, RuntimeChecker {
    protected static final int MSG_REQUEST_TIMEOUT = 32;
    protected String mAddress;
    protected byte[] mBytes;
    protected UUID mCharacterUUID;
    protected IBleRequestDispatcher mDispatcher;
    protected Bundle mExtra = new Bundle();
    protected boolean mFinished;
    protected Handler mHandler = new Handler(Looper.myLooper(), this);
    protected long mRequestId;
    protected boolean mRequestTimeout;
    protected BleResponser mResponse;
    protected Handler mResponseHandler = new Handler(BluetoothContextManager.getCoreBleLooper());
    protected int mResultCode;
    protected RuntimeChecker mRuntimeChecker;
    protected UUID mServiceUUID;
    protected IBleWorker mWorker;

    public BleRequest(BleResponser bleResponser) {
        this.mResponse = bleResponser;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onResponse$0(int i) {
        try {
            BleResponser bleResponser = this.mResponse;
            if (bleResponser != null) {
                bleResponser.onResponse(i, this.mExtra);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void cancel() {
        checkRuntime();
        log("request canceled");
        this.mHandler.removeCallbacksAndMessages((Object) null);
        clearGattResponseListener(this);
        onResponse(-2);
    }

    public void checkRuntime() {
        this.mRuntimeChecker.checkRuntime();
    }

    public void clearGattResponseListener(GattResponseListener gattResponseListener) {
        this.mWorker.clearGattResponseListener(gattResponseListener);
    }

    public void closeGatt() {
        log("close gatt");
        this.mWorker.closeGatt();
    }

    public void destroy() {
    }

    public boolean discoverService() {
        return this.mWorker.discoverService();
    }

    public String getAddress() {
        return this.mAddress;
    }

    public int getCurrentStatus() {
        return this.mWorker.getCurrentStatus();
    }

    public Bundle getExtra() {
        return this.mExtra;
    }

    public int getIntExtra(String str, int i) {
        return this.mExtra.getInt(str, i);
    }

    public long getRequestID() {
        return this.mRequestId;
    }

    public BleResponser getResponse() {
        return this.mResponse;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public String getStatusText() {
        return Constants.getStatusText(getCurrentStatus());
    }

    public long getTimeoutInMillis() {
        return 30000;
    }

    public boolean handleMessage(Message message) {
        if (message.what == 32) {
            this.mRequestTimeout = true;
            onRequestCompleted(-7);
        }
        return true;
    }

    public void isCharacterExist(UUID uuid, UUID uuid2, BleResponse<Void> bleResponse) {
        this.mWorker.isCharacterExist(uuid, uuid2, bleResponse);
    }

    public void log(String str) {
        BluetoothLog.log(getClass().getSimpleName(), "%s >>> %s", getAddress(), str);
    }

    public boolean onConnectStatusChanged(boolean z) {
        if (z) {
            return true;
        }
        onRequestCompleted(this.mRequestTimeout ? -7 : -1);
        return true;
    }

    public void onRequestCompleted(int i) {
        log(String.format("request(%d) complete: code = %d", new Object[]{Long.valueOf(this.mRequestId), Integer.valueOf(i)}));
        this.mHandler.removeCallbacksAndMessages((Object) null);
        clearGattResponseListener(this);
        onResponse(i);
        this.mDispatcher.onRequestCompleted(this);
    }

    public void onResponse(int i) {
        if (!this.mFinished) {
            this.mFinished = true;
            this.mResponseHandler.post(new a(this, i));
        }
    }

    public boolean openGatt(BleConnectConfig bleConnectConfig) {
        return this.mWorker.openGatt(bleConnectConfig);
    }

    public final void process(IBleRequestDispatcher iBleRequestDispatcher) {
        checkRuntime();
        this.mDispatcher = iBleRequestDispatcher;
        BluetoothLog.log(getClass().getSimpleName(), "start Process request(%d), current status = %s", Long.valueOf(this.mRequestId), getStatusText());
        try {
            registerGattResponseListener(this);
            processRequest();
        } catch (Throwable th) {
            BluetoothLog.e(th);
            onRequestCompleted(-15);
        }
    }

    public abstract void processRequest();

    public void putByteArray(String str, byte[] bArr) {
        this.mExtra.putByteArray(str, bArr);
    }

    public void putIntExtra(String str, int i) {
        this.mExtra.putInt(str, i);
    }

    public void putParcelable(String str, Parcelable parcelable) {
        this.mExtra.putParcelable(str, parcelable);
    }

    public boolean readCharacteristic(UUID uuid, UUID uuid2) {
        return this.mWorker.readCharacteristic(uuid, uuid2);
    }

    public boolean refreshDeviceCache() {
        return this.mWorker.refreshDeviceCache();
    }

    public void registerGattResponseListener(GattResponseListener gattResponseListener) {
        this.mWorker.registerGattResponseListener(gattResponseListener);
    }

    public boolean requestMtu(int i) {
        return this.mWorker.requestMtu(i);
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public boolean setCharacteristicNotification(UUID uuid, UUID uuid2, boolean z) {
        return this.mWorker.setCharacteristicNotification(uuid, uuid2, z);
    }

    public void setRequestID(long j) {
        this.mRequestId = j;
    }

    public void setResponse(BleResponser bleResponser) {
        this.mResponse = bleResponser;
    }

    public void setResultCode(int i) {
        this.mResultCode = i;
        putIntExtra(BluetoothConstants.KEY_CODE, i);
    }

    public void setRuntimeChecker(RuntimeChecker runtimeChecker) {
        this.mRuntimeChecker = runtimeChecker;
    }

    public void setWorker(IBleWorker iBleWorker) {
        this.mWorker = iBleWorker;
    }

    public void startRequestTiming() {
        this.mHandler.sendEmptyMessageDelayed(32, getTimeoutInMillis());
    }

    public void stopRequestTiming() {
        this.mHandler.removeMessages(32);
    }

    public boolean writeCharacteristic(UUID uuid, UUID uuid2, byte[] bArr) {
        return this.mWorker.writeCharacteristic(uuid, uuid2, bArr);
    }

    public boolean writeCharacteristicWithNoRsp(UUID uuid, UUID uuid2, byte[] bArr) {
        return this.mWorker.writeCharacteristicWithNoRsp(uuid, uuid2, bArr);
    }
}
