package com.upuphone.starrynet.core.ble.server;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.BluetoothContextManager;
import com.upuphone.starrynet.core.ble.proxy.ProxyBulk;
import com.upuphone.starrynet.core.ble.proxy.ProxyInterceptor;
import com.upuphone.starrynet.core.ble.proxy.ProxyUtils;
import com.upuphone.starrynet.core.ble.server.character.IGattCharacterService;
import com.upuphone.starrynet.core.ble.server.reponse.BleNotificationResponse;
import com.upuphone.starrynet.core.ble.server.reponse.OpenServerResponse;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;

public class BleServerManager implements IBleConnectManager, ProxyInterceptor, Handler.Callback {
    private static final String TAG = "BleServerManager";
    private static volatile IBleConnectManager sInstance;
    private BleServerRequestDispatcher mDispatcher;
    private Handler mHandler = new Handler(BluetoothContextManager.getCoreBleLooper(), this);
    private boolean mIsInit = false;

    private BleServerManager() {
    }

    public static IBleConnectManager getInstance() {
        if (sInstance == null) {
            synchronized (BleServerManager.class) {
                try {
                    if (sInstance == null) {
                        BleServerManager bleServerManager = new BleServerManager();
                        sInstance = (IBleConnectManager) ProxyUtils.getUIProxy((Object) bleServerManager, (Class<?>) IBleConnectManager.class, (ProxyInterceptor) bleServerManager);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sInstance;
    }

    public void addServices(IGattCharacterService iGattCharacterService) {
        StLog.d(TAG, "addServices " + iGattCharacterService.getUUID());
        this.mDispatcher.addServices(iGattCharacterService);
    }

    public void disconnect(String str) {
        this.mDispatcher.disconnect(str);
    }

    public boolean handleMessage(@NonNull Message message) {
        ProxyBulk.safeInvoke(message.obj);
        return true;
    }

    public void init(GattServerConfig gattServerConfig) {
        StLog.d(TAG, "do init mIsInit=" + this.mIsInit);
        if (!this.mIsInit) {
            this.mIsInit = true;
            if (gattServerConfig == null) {
                gattServerConfig = new GattServerConfig();
            }
            this.mDispatcher = new BleServerRequestDispatcher(gattServerConfig);
        }
    }

    public void isCharacterNotify(String str, UUID uuid, Consumer<Boolean> consumer) {
        StLog.d(TAG, "isCharacterNotify, uuid = " + uuid + ",consumer =" + consumer);
        if (consumer != null) {
            consumer.accept(Boolean.valueOf(this.mDispatcher.isCharacterNotify(str, uuid)));
        }
    }

    public boolean onIntercept(Object obj, Method method, Object[] objArr) {
        this.mHandler.obtainMessage(0, new ProxyBulk(obj, method, objArr)).sendToTarget();
        return true;
    }

    public void openServer(OpenServerResponse openServerResponse) {
        this.mDispatcher.openServer(openServerResponse);
    }

    public void sendBatchNotifications(String str, UUID uuid, List<byte[]> list, BleNotificationResponse bleNotificationResponse) {
        this.mDispatcher.sendBatchNotification(str, uuid, list, bleNotificationResponse);
    }

    public void sendNotification(String str, UUID uuid, byte[] bArr, BleNotificationResponse bleNotificationResponse) {
        this.mDispatcher.sendNotification(str, uuid, bArr, bleNotificationResponse);
    }

    public void sendNotificationAtOnce(String str, UUID uuid, byte[] bArr, BleNotificationResponse bleNotificationResponse) {
        this.mDispatcher.sendNotificationAtOnce(str, uuid, bArr, bleNotificationResponse);
    }
}
