package com.upuphone.starrynet.core.spp;

import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import android.text.TextUtils;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.HandlerThreadUtil;
import com.upuphone.starrynet.core.spp.callback.ICommonServerListener;
import com.upuphone.starrynet.core.spp.callback.IConnectionEventListener;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class SPPConnectionManager {
    public static final String CONNECT_THREAD = "spp_connect_thread";
    public static final int DISPATCH_MESSAGE_FAIL = 200;
    public static final int DISPATCH_MESSAGE_SUCCESS = 201;
    public static final int STATE_CONNECTED = 101;
    public static final int STATE_CONNECT_FAIL = 102;
    public static final int STATE_DISCONNECTED = 100;
    /* access modifiers changed from: private */
    public static final String TAG = "SPPConnectionManager";
    private Handler mConnectHandler;
    private final ICommonServerListener mDefaultCommonServerListener;
    /* access modifiers changed from: private */
    public ICommonServerListener mICommonServerListener;
    private final IConnectionEventListener mIConnectionEventListener;
    /* access modifiers changed from: private */
    public final List<IConnectionEventListener> mIConnectionEventListeners;
    private final Map<String, SPPConnection> mSppConnectionList;
    private final SPPServerListener mSppServerListener;

    public static final class Holder {
        static final SPPConnectionManager INSTANCE = new SPPConnectionManager();

        private Holder() {
        }
    }

    public static SPPConnectionManager getInstance() {
        return Holder.INSTANCE;
    }

    public void addConnectionEventListener(IConnectionEventListener iConnectionEventListener) {
        if (!this.mIConnectionEventListeners.contains(iConnectionEventListener)) {
            this.mIConnectionEventListeners.add(iConnectionEventListener);
        }
    }

    public void connect(String str, UUID uuid) {
        String str2 = TAG;
        StLog.d(str2, "start connect: " + str);
        if (this.mSppConnectionList.containsKey(str)) {
            StLog.d(str2, "connect: ignore, current device is connected or connecting.");
            return;
        }
        if (this.mConnectHandler == null) {
            this.mConnectHandler = new Handler(HandlerThreadUtil.getInstance().getLooper(CONNECT_THREAD));
        }
        SPPConnection sPPConnection = new SPPConnection(str, this.mIConnectionEventListener);
        this.mSppConnectionList.put(str, sPPConnection);
        this.mConnectHandler.post(new a(sPPConnection, uuid));
    }

    public void disconnect(String str) {
        String str2 = TAG;
        StLog.d(str2, "start disconnect: " + str);
        SPPConnection remove = this.mSppConnectionList.remove(str);
        if (remove != null) {
            remove.close();
        }
    }

    public Optional<UUID> fetchUUIDListening() {
        return this.mSppServerListener.fetchUUIDListening();
    }

    public boolean isConnected(String str) {
        return !TextUtils.isEmpty(str) && this.mSppConnectionList.containsKey(str);
    }

    public void removeConnectionEventListener(IConnectionEventListener iConnectionEventListener) {
        this.mIConnectionEventListeners.remove(iConnectionEventListener);
    }

    public void sendMessage(String str, byte[] bArr) {
        SPPConnection sPPConnection = this.mSppConnectionList.get(str);
        if (sPPConnection == null) {
            StLog.d(TAG, "sendMessage: ignore, current device is not found.");
        } else {
            sPPConnection.write(bArr);
        }
    }

    public void serverConnect(String str, BluetoothSocket bluetoothSocket) {
        if (this.mSppConnectionList.containsKey(str)) {
            StLog.d(TAG, "server connect: ignore, current device is connected or connecting.");
            return;
        }
        SPPConnection sPPConnection = new SPPConnection(str, this.mIConnectionEventListener);
        this.mSppConnectionList.put(str, sPPConnection);
        sPPConnection.serverOpenConnection(bluetoothSocket);
    }

    public void startServerListen(UUID uuid, ICommonServerListener iCommonServerListener) {
        this.mICommonServerListener = iCommonServerListener;
        this.mSppServerListener.start(uuid, this.mDefaultCommonServerListener);
    }

    public void stopServerListen() {
        this.mICommonServerListener = null;
        this.mSppServerListener.stop();
    }

    private SPPConnectionManager() {
        this.mDefaultCommonServerListener = new ICommonServerListener() {
            public void onAdvertiseFail(UUID uuid) {
                StLog.d(SPPConnectionManager.TAG, "onAdvertiseFail: ");
                if (SPPConnectionManager.this.mICommonServerListener != null) {
                    SPPConnectionManager.this.mICommonServerListener.onAdvertiseFail(uuid);
                }
            }

            public void onAdvertiseSuccess(UUID uuid) {
                String access$100 = SPPConnectionManager.TAG;
                StLog.d(access$100, "onAdvertiseSuccess: " + uuid);
                if (SPPConnectionManager.this.mICommonServerListener != null) {
                    SPPConnectionManager.this.mICommonServerListener.onAdvertiseSuccess(uuid);
                }
            }

            public void onConnectionAccepted(String str, BluetoothSocket bluetoothSocket) {
                String access$100 = SPPConnectionManager.TAG;
                StLog.d(access$100, "onConnectionAccepted: address:" + str + ", socket:" + bluetoothSocket);
                SPPConnectionManager.this.serverConnect(str, bluetoothSocket);
            }
        };
        this.mIConnectionEventListener = new IConnectionEventListener() {
            public void onConnectionStateChanged(String str, int i) {
                String access$100 = SPPConnectionManager.TAG;
                StLog.d(access$100, "onConnectionStateChanged, " + str + ", state = " + i);
                if (i != 101) {
                    SPPConnectionManager.this.disconnect(str);
                }
                SPPConnectionManager.this.mIConnectionEventListeners.forEach(new d(str, i));
            }

            public void onMessageDispatched(String str, byte[] bArr, int i) {
                SPPConnectionManager.this.mIConnectionEventListeners.forEach(new b(str, bArr, i));
            }

            public void onMessageReceived(String str, byte[] bArr) {
                SPPConnectionManager.this.mIConnectionEventListeners.forEach(new c(str, bArr));
            }
        };
        this.mSppConnectionList = new ConcurrentHashMap();
        this.mIConnectionEventListeners = new CopyOnWriteArrayList();
        this.mSppServerListener = new SPPServerListener();
    }
}
