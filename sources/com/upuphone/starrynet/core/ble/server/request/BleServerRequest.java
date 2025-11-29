package com.upuphone.starrynet.core.ble.server.request;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.client.RuntimeChecker;
import com.upuphone.starrynet.core.ble.server.BleServerRequestDispatcher;
import com.upuphone.starrynet.core.ble.server.IBleServer;
import com.upuphone.starrynet.core.ble.server.character.IGattCharacterService;
import com.upuphone.starrynet.core.ble.server.listener.GattServerResponseListener;
import com.upuphone.starrynet.core.ble.server.reponse.BleServerResponser;
import com.upuphone.starrynet.core.ble.utils.BluetoothLog;
import java.util.UUID;

public abstract class BleServerRequest implements IBleServer, IBleServerRequest, GattServerResponseListener, Handler.Callback, RuntimeChecker {
    protected static final int MSG_REQUEST_TIMEOUT = 33;
    protected String mBleMac;
    private BleServerRequestDispatcher mDispatcher;
    protected Bundle mExtra = new Bundle();
    protected boolean mFinished;
    protected Handler mHandler;
    protected long mRequestId;
    protected boolean mRequestTimeout;
    protected BleServerResponser mResponse;
    protected RuntimeChecker mRuntimeChecker;
    protected IBleServer mServer;

    public BleServerRequest(String str, BleServerResponser bleServerResponser) {
        this.mBleMac = str;
        this.mResponse = bleServerResponser;
        this.mHandler = new Handler(Looper.myLooper(), this);
    }

    private void log(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        BluetoothLog.log(getClass().getSimpleName(), str, new Object[0]);
    }

    public void addServices(IGattCharacterService iGattCharacterService) {
        IBleServer iBleServer = this.mServer;
        if (iBleServer != null) {
            iBleServer.addServices(iGattCharacterService);
        }
    }

    public void cancel() {
        checkRuntime();
        log("request canceled", new Object[0]);
        this.mHandler.removeCallbacksAndMessages((Object) null);
        clearGattServerResponseListener(this);
        onResponse(-2);
    }

    public void checkRuntime() {
        this.mRuntimeChecker.checkRuntime();
    }

    public void clearGattServerResponseListener(GattServerResponseListener gattServerResponseListener) {
        IBleServer iBleServer = this.mServer;
        if (iBleServer != null) {
            iBleServer.clearGattServerResponseListener(gattServerResponseListener);
        }
    }

    public void disconnect() {
        IBleServer iBleServer = this.mServer;
        if (iBleServer != null) {
            iBleServer.disconnect();
        }
    }

    public long getRequestID() {
        return this.mRequestId;
    }

    public long getTimeoutInMillis() {
        return 3000;
    }

    public boolean handleMessage(Message message) {
        if (message.what == 33) {
            this.mRequestTimeout = true;
            log("handle message :timeout", new Object[0]);
            onRequestCompleted(-7);
        }
        return true;
    }

    public boolean isCharacterNotify(String str, UUID uuid) {
        IBleServer iBleServer = this.mServer;
        if (iBleServer != null) {
            return iBleServer.isCharacterNotify(str, uuid);
        }
        return false;
    }

    public boolean isConnected(String str) {
        IBleServer iBleServer = this.mServer;
        if (iBleServer != null) {
            return iBleServer.isConnected(str);
        }
        return false;
    }

    public boolean isServerOpened() {
        IBleServer iBleServer = this.mServer;
        if (iBleServer != null) {
            return iBleServer.isServerOpened();
        }
        return false;
    }

    public void onConnectStatusChanged(String str, boolean z) {
        log("onConnectStatusChanged ,mBleMac =" + this.mBleMac + ", bleMac=" + str + ",isConnected=" + z, new Object[0]);
        String str2 = this.mBleMac;
        if (str2 != null && !str2.equals(str)) {
            return;
        }
        if ((this.mBleMac != null || str == null) && !z) {
            onRequestCompleted(this.mRequestTimeout ? -7 : -1);
        }
    }

    public void onRequestCompleted(int i) {
        log("request(%d) complete: code = %d", Long.valueOf(this.mRequestId), Integer.valueOf(i));
        this.mHandler.removeCallbacksAndMessages((Object) null);
        clearGattServerResponseListener(this);
        onResponse(i);
        this.mDispatcher.onRequestCompleted(this);
    }

    public void onResponse(int i) {
        if (!this.mFinished) {
            this.mFinished = true;
            try {
                BleServerResponser bleServerResponser = this.mResponse;
                if (bleServerResponser != null) {
                    bleServerResponser.onResponse(i, this.mExtra);
                }
            } catch (Throwable th) {
                StLog.e("BleServerRequest", "onResponse Throwable ", th);
            }
        }
    }

    public void openServer() {
        IBleServer iBleServer = this.mServer;
        if (iBleServer != null) {
            iBleServer.openServer();
        }
    }

    public final void process(BleServerRequestDispatcher bleServerRequestDispatcher) {
        checkRuntime();
        this.mDispatcher = bleServerRequestDispatcher;
        log("start process request（%d)", Long.valueOf(this.mRequestId));
        try {
            registerGattServerResponseListener(this);
            processRequest();
        } catch (Throwable th) {
            BluetoothLog.e(th);
            onRequestCompleted(-15);
        }
    }

    public abstract void processRequest();

    public void registerGattServerResponseListener(GattServerResponseListener gattServerResponseListener) {
        IBleServer iBleServer = this.mServer;
        if (iBleServer != null) {
            iBleServer.registerGattServerResponseListener(gattServerResponseListener);
        }
    }

    public boolean sendNotification(String str, UUID uuid, byte[] bArr) {
        IBleServer iBleServer = this.mServer;
        if (iBleServer != null) {
            return iBleServer.sendNotification(str, uuid, bArr);
        }
        return false;
    }

    public void setBleServer(IBleServer iBleServer) {
        this.mServer = iBleServer;
    }

    public void setRequestID(long j) {
        this.mRequestId = j;
    }

    public void setRuntimeChecker(RuntimeChecker runtimeChecker) {
        this.mRuntimeChecker = runtimeChecker;
    }

    public void startRequestTiming() {
        this.mHandler.sendEmptyMessageDelayed(33, getTimeoutInMillis());
    }

    public void stopRequestTiming() {
        this.mHandler.removeMessages(33);
    }
}
