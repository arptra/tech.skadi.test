package com.upuphone.starrynet.core.ble.client;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.upuphone.starrynet.core.ble.BluetoothContextManager;
import com.upuphone.starrynet.core.ble.client.response.BleConnectResponse;
import com.upuphone.starrynet.core.ble.client.response.BleNotifyResponse;
import com.upuphone.starrynet.core.ble.client.response.BleReadResponse;
import com.upuphone.starrynet.core.ble.client.response.BleRequestMtuResponse;
import com.upuphone.starrynet.core.ble.client.response.BleResponse;
import com.upuphone.starrynet.core.ble.client.response.BleWriteNoRespResponse;
import com.upuphone.starrynet.core.ble.client.response.BleWriteResponse;
import com.upuphone.starrynet.core.ble.proxy.ProxyBulk;
import com.upuphone.starrynet.core.ble.proxy.ProxyInterceptor;
import com.upuphone.starrynet.core.ble.proxy.ProxyUtils;
import com.upuphone.starrynet.core.ble.utils.BluetoothLog;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BleConnectManager implements IBleConnectManager, ProxyInterceptor, Handler.Callback {
    private static final int ALIVE_TIMEOUT = 60000;
    private static final int MAX_CLIENT_SIZE = 3;
    private static final String TAG = "BleConnectManager";
    private static volatile IBleConnectManager sInstance;
    private HashMap<String, Long> mAliveMap = new HashMap<>();
    private HashMap<String, IBleConnectMaster> mBleConnectWorkerMap = new HashMap<>();
    private Handler mHandler = new Handler(BluetoothContextManager.getCoreBleLooper(), this);

    private BleConnectManager() {
    }

    private void checkIfNeedDestroyMaster() {
        Iterator<Map.Entry<String, Long>> it = this.mAliveMap.entrySet().iterator();
        long currentTimeMillis = System.currentTimeMillis();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (currentTimeMillis - ((Long) next.getValue()).longValue() > 60000 && !BleClientCache.getInstance().isClientConnected((String) next.getKey())) {
                BluetoothLog.log(TAG, "checkIfNeedDestroyMaster destroy connectMaster(%s)", next.getKey());
                BleClientCache.getInstance().updateIsClientRequest((String) next.getKey(), false);
                it.remove();
                this.mBleConnectWorkerMap.remove(next.getKey()).destroy();
            }
        }
    }

    private IBleConnectMaster getBleConnectMaster(String str) {
        IBleConnectMaster iBleConnectMaster = this.mBleConnectWorkerMap.get(str);
        if (iBleConnectMaster == null) {
            iBleConnectMaster = BleConnectMaster.newInstance(str);
            this.mBleConnectWorkerMap.put(str, iBleConnectMaster);
            BleClientCache.getInstance().updateIsClientRequest(str, true);
            this.mAliveMap.put(str, Long.valueOf(System.currentTimeMillis()));
            if (this.mBleConnectWorkerMap.size() > 3) {
                checkIfNeedDestroyMaster();
            }
        }
        return iBleConnectMaster;
    }

    public static IBleConnectManager getInstance() {
        if (sInstance == null) {
            synchronized (BleConnectManager.class) {
                try {
                    if (sInstance == null) {
                        BleConnectManager bleConnectManager = new BleConnectManager();
                        sInstance = (IBleConnectManager) ProxyUtils.getUIProxy((Object) bleConnectManager, (Class<?>) IBleConnectManager.class, (ProxyInterceptor) bleConnectManager);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sInstance;
    }

    public void cancelConnecting(String str) {
        if (str != null) {
            getBleConnectMaster(str).cancelConnecting();
        }
    }

    public void connect(BleConnectConfig bleConnectConfig, BleConnectResponse bleConnectResponse) {
        if (bleConnectConfig.getBleMac() != null) {
            getBleConnectMaster(bleConnectConfig.getBleMac()).connect(bleConnectConfig, bleConnectResponse);
        }
    }

    public void disconnect(String str) {
        if (str != null) {
            getBleConnectMaster(str).disconnect();
        }
    }

    public void disconnectAllDevices() {
        for (IBleConnectMaster next : this.mBleConnectWorkerMap.values()) {
            if (next != null) {
                next.disconnect();
            }
        }
    }

    public boolean handleMessage(Message message) {
        ProxyBulk.safeInvoke(message.obj);
        return true;
    }

    public void isCharacterExist(String str, UUID uuid, UUID uuid2, BleResponse<Void> bleResponse) {
        if (str != null && uuid != null && uuid2 != null) {
            getBleConnectMaster(str).isCharacterExist(uuid, uuid2, bleResponse);
        }
    }

    public void notify(String str, UUID uuid, UUID uuid2, BleNotifyResponse bleNotifyResponse) {
        if (str != null && uuid != null && uuid2 != null) {
            getBleConnectMaster(str).notify(uuid, uuid2, bleNotifyResponse);
        }
    }

    public boolean onIntercept(Object obj, Method method, Object[] objArr) {
        this.mHandler.obtainMessage(0, new ProxyBulk(obj, method, objArr)).sendToTarget();
        return true;
    }

    public void read(String str, UUID uuid, UUID uuid2, BleReadResponse bleReadResponse) {
        if (str != null && uuid != null && uuid2 != null) {
            getBleConnectMaster(str).read(uuid, uuid2, bleReadResponse);
        }
    }

    public void requestMtu(String str, int i, BleRequestMtuResponse bleRequestMtuResponse) {
        if (!TextUtils.isEmpty(str)) {
            getBleConnectMaster(str).requestMtu(i, bleRequestMtuResponse);
        }
    }

    public void write(String str, UUID uuid, UUID uuid2, byte[] bArr, BleWriteResponse bleWriteResponse) {
        if (str != null && uuid != null && uuid2 != null && bArr != null) {
            getBleConnectMaster(str).write(uuid, uuid2, bArr, bleWriteResponse);
        }
    }

    public void writeBatchNoRsp(String str, UUID uuid, UUID uuid2, List<byte[]> list, BleWriteNoRespResponse bleWriteNoRespResponse) {
        if (str != null && uuid != null && uuid2 != null && list != null) {
            getBleConnectMaster(str).writeBatchNoRsp(uuid, uuid2, list, bleWriteNoRespResponse);
        }
    }

    public void writeNoRsp(String str, UUID uuid, UUID uuid2, byte[] bArr, BleWriteNoRespResponse bleWriteNoRespResponse) {
        if (str == null || uuid == null || uuid2 == null || bArr == null) {
            BluetoothLog.log(TAG, "writeNoResp fail, mac=" + str + ",service=" + uuid + ",character=" + uuid2, new Object[0]);
            return;
        }
        getBleConnectMaster(str).writeNoRsp(uuid, uuid2, bArr, bleWriteNoRespResponse);
    }

    public void writeNoRspAtOnce(String str, UUID uuid, UUID uuid2, byte[] bArr, BleWriteNoRespResponse bleWriteNoRespResponse) {
        if (str != null && uuid != null && uuid2 != null && bArr != null) {
            getBleConnectMaster(str).writeNoRspAtOnce(uuid, uuid2, bArr, bleWriteNoRespResponse);
        }
    }

    public void connect(String str, BleConnectResponse bleConnectResponse) {
        if (str != null) {
            getBleConnectMaster(str).connect(new BleConnectConfig(str), bleConnectResponse);
        }
    }
}
