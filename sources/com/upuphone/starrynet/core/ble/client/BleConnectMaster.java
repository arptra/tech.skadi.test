package com.upuphone.starrynet.core.ble.client;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.here.odnp.config.OdnpConfigStatic;
import com.honey.account.t6.a;
import com.honey.account.t6.b;
import com.upuphone.starrynet.core.ble.BluetoothContextManager;
import com.upuphone.starrynet.core.ble.client.response.BleConnectResponse;
import com.upuphone.starrynet.core.ble.client.response.BleNotifyResponse;
import com.upuphone.starrynet.core.ble.client.response.BleReadResponse;
import com.upuphone.starrynet.core.ble.client.response.BleRequestMtuResponse;
import com.upuphone.starrynet.core.ble.client.response.BleResponse;
import com.upuphone.starrynet.core.ble.client.response.BleResponser;
import com.upuphone.starrynet.core.ble.client.response.BleWriteNoRespResponse;
import com.upuphone.starrynet.core.ble.client.response.BleWriteResponse;
import com.upuphone.starrynet.core.ble.proxy.ProxyInterceptor;
import com.upuphone.starrynet.core.ble.proxy.ProxyUtils;
import com.upuphone.starrynet.core.ble.utils.BluetoothLog;
import com.upuphone.starrynet.core.ble.utils.BluetoothUtils;
import com.upuphone.starrynet.core.ble.utils.MessageHandlerThread;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;

public class BleConnectMaster implements IBleConnectMaster, ProxyInterceptor, Handler.Callback {
    private static final int CHECK_ALIVE_CYCLE = 15000;
    private static final int CHECK_ALIVE_LIMIT = 120000;
    private static final int MSG_CHECK_ALIVE = 256;
    private String mAddressMac;
    private BleRequestDispatcher mBleRequestDispatcher;
    private Handler mHandler;
    private Handler mMainHandler = new Handler(BluetoothContextManager.getCoreBleLooper());
    private MessageHandlerThread mThread;
    private long mTimeStamp;

    private BleConnectMaster(String str) {
        this.mAddressMac = str;
    }

    private static void assertCalledInCoreBleThread() {
        if (BluetoothContextManager.getCoreBleLooper() != Looper.myLooper()) {
            throw new IllegalStateException("");
        }
    }

    private void checkAlive() {
        if (System.currentTimeMillis() - this.mTimeStamp <= OdnpConfigStatic.OEM_MAX_HIGH_POWER_INTERVAL || BluetoothUtils.isBleDeviceDisconnected(this.mAddressMac)) {
            prepareCheckAlive();
        } else {
            stopMasterLooper();
        }
    }

    private void initDispatcherIfNeeded() {
        if (this.mBleRequestDispatcher == null) {
            this.mBleRequestDispatcher = BleRequestDispatcher.newInstance(this.mAddressMac);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$prepareCheckAlive$1() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(256, 15000);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$stopMasterLooper$0() {
        assertCalledInCoreBleThread();
        MessageHandlerThread messageHandlerThread = this.mThread;
        if (messageHandlerThread != null) {
            messageHandlerThread.quit();
            this.mThread = null;
            this.mHandler = null;
            this.mBleRequestDispatcher = null;
        }
    }

    public static IBleConnectMaster newInstance(String str) {
        assertCalledInCoreBleThread();
        BleConnectMaster bleConnectMaster = new BleConnectMaster(str);
        return (IBleConnectMaster) ProxyUtils.getProxy(bleConnectMaster, IBleConnectMaster.class, bleConnectMaster);
    }

    private void prepareCheckAlive() {
        this.mMainHandler.post(new a(this));
    }

    private void startMasterLooper() {
        assertCalledInCoreBleThread();
        if (this.mThread == null) {
            MessageHandlerThread messageHandlerThread = new MessageHandlerThread(String.format("BleConnectMaster(%s)", new Object[]{this.mAddressMac}));
            this.mThread = messageHandlerThread;
            messageHandlerThread.start();
            this.mHandler = new Handler(this.mThread.getLooper(), this);
        }
    }

    private void stopMasterLooper() {
        this.mMainHandler.post(new b(this));
    }

    private void updateTimeStamp(long j) {
        this.mTimeStamp = j;
    }

    public void cancelConnecting() {
        this.mBleRequestDispatcher.cancelConnecting();
    }

    public void connect(BleConnectConfig bleConnectConfig, BleConnectResponse bleConnectResponse) {
        this.mBleRequestDispatcher.connect(bleConnectConfig, BleResponser.newInstance(bleConnectResponse));
    }

    public void destroy() {
        this.mBleRequestDispatcher.destroy();
        stopMasterLooper();
    }

    public void disconnect() {
        this.mBleRequestDispatcher.disconnect();
    }

    public Handler getHandler() {
        assertCalledInCoreBleThread();
        if (this.mHandler == null) {
            startMasterLooper();
        }
        return this.mHandler;
    }

    public boolean handleMessage(@NonNull Message message) {
        if (message.what != 256) {
            return true;
        }
        checkAlive();
        return true;
    }

    public void isCharacterExist(UUID uuid, UUID uuid2, BleResponse<Void> bleResponse) {
        this.mBleRequestDispatcher.isCharacterExist(uuid, uuid2, bleResponse);
    }

    public void notify(UUID uuid, UUID uuid2, BleNotifyResponse bleNotifyResponse) {
        this.mBleRequestDispatcher.notify(uuid, uuid2, BleResponser.newInstance(bleNotifyResponse));
    }

    public boolean onIntercept(Object obj, Method method, Object[] objArr) {
        assertCalledInCoreBleThread();
        BleConnectMaster bleConnectMaster = (BleConnectMaster) obj;
        bleConnectMaster.updateTimeStamp(System.currentTimeMillis());
        try {
            bleConnectMaster.initDispatcherIfNeeded();
            method.invoke(obj, objArr);
            return true;
        } catch (Exception e) {
            BluetoothLog.e(e);
            return true;
        }
    }

    public void read(UUID uuid, UUID uuid2, BleReadResponse bleReadResponse) {
        this.mBleRequestDispatcher.read(uuid, uuid2, BleResponser.newInstance(bleReadResponse));
    }

    public void requestMtu(int i, BleRequestMtuResponse bleRequestMtuResponse) {
        this.mBleRequestDispatcher.requestMtu(i, BleResponser.newInstance(bleRequestMtuResponse));
    }

    public void write(UUID uuid, UUID uuid2, byte[] bArr, BleWriteResponse bleWriteResponse) {
        this.mBleRequestDispatcher.write(uuid, uuid2, bArr, BleResponser.newInstance(bleWriteResponse));
    }

    public void writeBatchNoRsp(UUID uuid, UUID uuid2, List<byte[]> list, BleWriteNoRespResponse bleWriteNoRespResponse) {
        this.mBleRequestDispatcher.writeBatchNoRsp(uuid, uuid2, list, BleResponser.newInstance(bleWriteNoRespResponse));
    }

    public void writeNoRsp(UUID uuid, UUID uuid2, byte[] bArr, BleWriteNoRespResponse bleWriteNoRespResponse) {
        this.mBleRequestDispatcher.writeNoRsp(uuid, uuid2, bArr, BleResponser.newInstance(bleWriteNoRespResponse));
    }

    public void writeNoRspAtOnce(UUID uuid, UUID uuid2, byte[] bArr, BleWriteNoRespResponse bleWriteNoRespResponse) {
        this.mBleRequestDispatcher.writeNoRespAtOne(uuid, uuid2, bArr, BleResponser.newInstance(bleWriteNoRespResponse));
    }
}
