package com.upuphone.starrynet.core.ble.client;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import com.honey.account.t6.c;
import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.core.ble.BluetoothConstants;
import com.upuphone.starrynet.core.ble.BluetoothContextManager;
import com.upuphone.starrynet.core.ble.Constants;
import com.upuphone.starrynet.core.ble.SystemActionObserver;
import com.upuphone.starrynet.core.ble.client.listener.GattResponseListener;
import com.upuphone.starrynet.core.ble.client.listener.ReadCharacterListener;
import com.upuphone.starrynet.core.ble.client.listener.RequestMtuListener;
import com.upuphone.starrynet.core.ble.client.listener.ServiceDiscoverListener;
import com.upuphone.starrynet.core.ble.client.listener.WriteCharacterListener;
import com.upuphone.starrynet.core.ble.client.listener.WriteDescriptorListener;
import com.upuphone.starrynet.core.ble.client.response.BleResponse;
import com.upuphone.starrynet.core.ble.event.BleEventBus;
import com.upuphone.starrynet.core.ble.event.CharacterChangedEvent;
import com.upuphone.starrynet.core.ble.event.ClientConnectChangeEvent;
import com.upuphone.starrynet.core.ble.event.ExternalClientConnectionChangeEvent;
import com.upuphone.starrynet.core.ble.event.MYVURingEvent;
import com.upuphone.starrynet.core.ble.proxy.ProxyBulk;
import com.upuphone.starrynet.core.ble.proxy.ProxyInterceptor;
import com.upuphone.starrynet.core.ble.proxy.ProxyUtils;
import com.upuphone.starrynet.core.ble.utils.BluetoothLog;
import com.upuphone.starrynet.core.ble.utils.BluetoothUtils;
import com.upuphone.starrynet.core.ble.utils.UUIDUtils;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@SuppressLint({"MissingPermission"})
public class BleWorker implements IBleWorker, IBluetoothGattResponse, Handler.Callback, ProxyInterceptor, RuntimeChecker {
    private static final int BALANCE_SPEED_TRANS_MODE = 2;
    private static final int BLE_EVENT_QUIET = 5000;
    private static final int HIGH_SPEED_TRANS_MODE = 0;
    private static final int LOW_SPEED_TRANS_MODE = 1;
    private static final int MSG_DISCONNECT_TIMEOUT = 289;
    private static final int MSG_GATT_RESPONSE = 288;
    private static final String TAG = "BleWorker";
    private boolean isSupportLe2M = true;
    private BluetoothDevice mBluetoothDevice;
    private BluetoothGatt mBluetoothGatt;
    private IBluetoothGattResponse mBluetoothGattResponse;
    private BleConnectConfig mConConfig;
    private volatile int mConnectStatus;
    private Map<UUID, Map<UUID, BluetoothGattCharacteristic>> mDeviceProfile;
    /* access modifiers changed from: private */
    public GattResponseListener mGattResponseListener;
    private long mLastBleEventTime = -1;
    private int mLatencyMode = -1;
    private final Object mLock = new Object();
    private RuntimeChecker mRuntimeChecker;
    SystemActionObserver.SystemActionChangedCallback mSystemActionChangedCallback = new SystemActionObserver.SystemActionChangedCallback() {
        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onScreenStateChange$0() {
            BleWorker.this.log("screen on :set ble high speed mode ", new Object[0]);
            BleWorker.this.invokeSetLeConnectionPriority(0);
        }

        public boolean onBluetoothStateChange(boolean z) {
            BleWorker bleWorker = BleWorker.this;
            bleWorker.log("onBluetoothStateChange enable=" + z, new Object[0]);
            if (z) {
                return true;
            }
            BleWorker.this.mWorkerHandler.postDelayed(new Runnable() {
                public void run() {
                    BleWorker.this.releaseAfterDisconnected(-5);
                }
            }, 600);
            return true;
        }

        public boolean onScreenStateChange(boolean z) {
            BleWorker bleWorker = BleWorker.this;
            bleWorker.log("onScreenStateChange :" + z, new Object[0]);
            if (!z) {
                return true;
            }
            BleWorker.this.mWorkerHandler.post(new a(this));
            return true;
        }
    };
    /* access modifiers changed from: private */
    public Handler mWorkerHandler;

    public BleWorker(String str, RuntimeChecker runtimeChecker) {
        BluetoothAdapter bluetoothAdapter = BluetoothUtils.getBluetoothAdapter();
        if (bluetoothAdapter != null) {
            this.mBluetoothDevice = bluetoothAdapter.getRemoteDevice(str);
            this.isSupportLe2M = bluetoothAdapter.isLe2MPhySupported();
            this.mRuntimeChecker = runtimeChecker;
            this.mWorkerHandler = new Handler(Looper.myLooper(), this);
            this.mDeviceProfile = new HashMap();
            this.mBluetoothGattResponse = (IBluetoothGattResponse) ProxyUtils.getProxy(this, IBluetoothGattResponse.class, this);
            SystemActionObserver.getInstance().registerSystemActionCallback(this.mSystemActionChangedCallback);
            return;
        }
        throw new IllegalStateException("ble adapter null");
    }

    private void broadcastCharacterChanged(UUID uuid, UUID uuid2, byte[] bArr) {
        BleEventBus.get().post(new CharacterChangedEvent(this.mBluetoothDevice.getAddress(), uuid, uuid2, bArr));
    }

    /* access modifiers changed from: private */
    public void broadcastConnectStatus(int i, int i2) {
        boolean z = i == 16;
        String address = this.mBluetoothDevice.getAddress();
        BleClientCache.getInstance().putClientConnected(address, z);
        BluetoothLog.log(TAG, "ClientConnectChangeEvent changed, isConnect=%s, device mac =%s", String.valueOf(z), address);
        if (BleClientCache.getInstance().isExternalDevice(address)) {
            BleEventBus.get().post(new ExternalClientConnectionChangeEvent(z, address));
        } else {
            BleEventBus.get().post(new ClientConnectChangeEvent(z, address, i2));
        }
    }

    private BluetoothGattCharacteristic cloneCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (Build.VERSION.SDK_INT >= 33) {
            log("sdk int >=33, use origin Characteristic", new Object[0]);
            return bluetoothGattCharacteristic;
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic2 = (BluetoothGattCharacteristic) copy(bluetoothGattCharacteristic);
        for (Field field : bluetoothGattCharacteristic.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if ("mService".equals(field.getName())) {
                try {
                    field.set(bluetoothGattCharacteristic2, bluetoothGattCharacteristic.getService());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    log("cloneCharacteristic fail, use origin Characteristic", new Object[0]);
                    return bluetoothGattCharacteristic;
                }
            }
        }
        return bluetoothGattCharacteristic2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.os.Parcelable copy(android.os.Parcelable r2) {
        /*
            android.os.Parcel r0 = android.os.Parcel.obtain()     // Catch:{ all -> 0x001d }
            r1 = 0
            r0.writeParcelable(r2, r1)     // Catch:{ all -> 0x001b }
            r0.setDataPosition(r1)     // Catch:{ all -> 0x001b }
            java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x001b }
            java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch:{ all -> 0x001b }
            android.os.Parcelable r2 = r0.readParcelable(r2)     // Catch:{ all -> 0x001b }
            r0.recycle()
            return r2
        L_0x001b:
            r2 = move-exception
            goto L_0x001f
        L_0x001d:
            r2 = move-exception
            r0 = 0
        L_0x001f:
            if (r0 == 0) goto L_0x0024
            r0.recycle()
        L_0x0024:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.core.ble.client.BleWorker.copy(android.os.Parcelable):android.os.Parcelable");
    }

    private String getAddress() {
        BluetoothDevice bluetoothDevice = this.mBluetoothDevice;
        return bluetoothDevice != null ? bluetoothDevice.getAddress() : "";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.mDeviceProfile.get(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.bluetooth.BluetoothGattCharacteristic getCharacter(java.util.UUID r2, java.util.UUID r3) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0015
            if (r3 == 0) goto L_0x0015
            java.util.Map<java.util.UUID, java.util.Map<java.util.UUID, android.bluetooth.BluetoothGattCharacteristic>> r0 = r1.mDeviceProfile
            java.lang.Object r0 = r0.get(r2)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 == 0) goto L_0x0015
            java.lang.Object r0 = r0.get(r3)
            android.bluetooth.BluetoothGattCharacteristic r0 = (android.bluetooth.BluetoothGattCharacteristic) r0
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            if (r0 != 0) goto L_0x0026
            android.bluetooth.BluetoothGatt r1 = r1.mBluetoothGatt
            if (r1 == 0) goto L_0x0026
            android.bluetooth.BluetoothGattService r1 = r1.getService(r2)
            if (r1 == 0) goto L_0x0026
            android.bluetooth.BluetoothGattCharacteristic r0 = r1.getCharacteristic(r3)
        L_0x0026:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.core.ble.client.BleWorker.getCharacter(java.util.UUID, java.util.UUID):android.bluetooth.BluetoothGattCharacteristic");
    }

    /* access modifiers changed from: private */
    public void invokeSetLeConnectionPriority(int i) {
        if (this.mBluetoothGatt != null && this.mLatencyMode != i && isSupportHighSpeed()) {
            if (i == 0) {
                this.mBluetoothGatt.requestConnectionPriority(1);
                log("set high speed mode", new Object[0]);
            } else if (i == 1) {
                this.mBluetoothGatt.requestConnectionPriority(2);
                log("set low speed mode", new Object[0]);
            } else if (i == 2) {
                this.mBluetoothGatt.requestConnectionPriority(0);
                log("set balance speed mode", new Object[0]);
            }
            this.mLatencyMode = i;
        }
    }

    private boolean isCharacteristicNoRspWritable(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return (bluetoothGattCharacteristic == null || (bluetoothGattCharacteristic.getProperties() & 4) == 0) ? false : true;
    }

    private boolean isCharacteristicNotifyable(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return (bluetoothGattCharacteristic == null || (bluetoothGattCharacteristic.getProperties() & 16) == 0) ? false : true;
    }

    private boolean isCharacteristicReadable(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return (bluetoothGattCharacteristic == null || (bluetoothGattCharacteristic.getProperties() & 2) == 0) ? false : true;
    }

    private boolean isCharacteristicWritable(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return (bluetoothGattCharacteristic == null || ((bluetoothGattCharacteristic.getProperties() & 8) == 0 && (bluetoothGattCharacteristic.getProperties() & 4) == 0)) ? false : true;
    }

    private boolean isSupportHighSpeed() {
        BleConnectConfig bleConnectConfig = this.mConConfig;
        if (bleConnectConfig != null) {
            return bleConnectConfig.isOpenHighSpeed();
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$releaseAfterDisconnected$0(int i) {
        GattResponseListener gattResponseListener = this.mGattResponseListener;
        if (gattResponseListener != null) {
            boolean onConnectStatusChanged = gattResponseListener.onConnectStatusChanged(false);
            setConnectStatus(0);
            if (onConnectStatusChanged) {
                broadcastConnectStatus(32, i);
                return;
            }
            return;
        }
        int currentStatus = getCurrentStatus();
        log("current connect status =" + currentStatus, new Object[0]);
        if (currentStatus == 2 || currentStatus == 19) {
            setConnectStatus(0);
            broadcastConnectStatus(32, i);
        }
    }

    private void openHighSpeedModeIfNeed() {
        if (this.mLatencyMode != 0 && System.currentTimeMillis() - this.mLastBleEventTime < 5000) {
            invokeSetLeConnectionPriority(0);
        }
    }

    private void refreshServiceProfile(Consumer<Boolean> consumer, UUID uuid) {
        Consumer<Boolean> consumer2 = consumer;
        UUID uuid2 = uuid;
        log("refreshServiceProfile for %s", this.mBluetoothDevice.getAddress());
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        if (bluetoothGatt == null) {
            log("refreshServiceProfile ble gatt null", new Object[0]);
            if (consumer2 != null) {
                consumer2.accept(Boolean.TRUE);
                return;
            }
            return;
        }
        List<BluetoothGattService> services = bluetoothGatt.getServices();
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (BluetoothGattService next : services) {
            UUID uuid3 = next.getUuid();
            Map map = (Map) hashMap.get(uuid3);
            if (map == null) {
                log("Service: " + uuid3, new Object[0]);
                map = new HashMap();
                hashMap.put(next.getUuid(), map);
            }
            for (BluetoothGattCharacteristic next2 : next.getCharacteristics()) {
                UUID uuid4 = next2.getUuid();
                if (uuid4.equals(uuid2)) {
                    z = true;
                }
                if (BluetoothConstants.STARRY_NET_SERVICE_UUID.equals(uuid3)) {
                    BleClientCache.getInstance().updateDiscoveryServiceInfo(getAddress(), uuid4);
                }
                log("character: uuid = " + uuid4 + ",object=" + next2, new Object[0]);
                BluetoothGattCharacteristic cloneCharacteristic = cloneCharacteristic(next2);
                log("after clone, character: uuid = " + uuid4 + ",object=" + cloneCharacteristic, new Object[0]);
                map.put(next2.getUuid(), cloneCharacteristic);
            }
        }
        this.mDeviceProfile.clear();
        this.mDeviceProfile.putAll(hashMap);
        if (consumer2 != null) {
            if (uuid2 == null) {
                z = true;
            }
            consumer2.accept(Boolean.valueOf(z));
        }
    }

    /* access modifiers changed from: private */
    public void releaseAfterDisconnected(int i) {
        long j;
        log("releaseAfterDisconnected for %s", getAddress());
        this.mWorkerHandler.removeMessages(MSG_DISCONNECT_TIMEOUT);
        if (this.mBluetoothGatt != null) {
            refreshDeviceCache();
            if (this.mBluetoothGatt != null) {
                log("Closing...", new Object[0]);
                this.mBluetoothGatt.close();
            }
            this.mBluetoothGatt = null;
            if (!BleClientCache.getInstance().isExternalDevice(this.mBluetoothDevice.getAddress()) || i == 0) {
                j = 600;
            } else {
                log("releaseAfterDisconnected is external device ,delay = 0", new Object[0]);
                j = 0;
            }
            this.mWorkerHandler.postDelayed(new c(this, i), j);
            return;
        }
        BluetoothLog.error(TAG, "releaseAfterDisconnected for %s failed, mBluetoothGatt is null", getAddress());
    }

    private void requestPhy(int i, int i2, int i3) {
        BleConnectConfig bleConnectConfig;
        if (i3 == 0 && (bleConnectConfig = this.mConConfig) != null && bleConnectConfig.isActivelyOpen2MPhy()) {
            log("request setPreferredPhy", new Object[0]);
            if ((i < 2 || i2 < 2) && this.isSupportLe2M && this.mBluetoothGatt != null && getCurrentStatus() == 2) {
                this.mBluetoothGatt.setPreferredPhy(2, 2, 0);
            }
        }
    }

    /* access modifiers changed from: private */
    public void setConnectStatus(int i) {
        log("setConnectStatus status = %s", Constants.getStatusText(i));
        this.mConnectStatus = i;
    }

    private void updateBleEventTime() {
        this.mLastBleEventTime = System.currentTimeMillis();
        openHighSpeedModeIfNeed();
    }

    private boolean useDetailLog() {
        return BluetoothLog.isDetailMode();
    }

    public void checkRuntime() {
        this.mRuntimeChecker.checkRuntime();
    }

    public void clearGattResponseListener(GattResponseListener gattResponseListener) {
        checkRuntime();
        if (this.mGattResponseListener == gattResponseListener) {
            this.mGattResponseListener = null;
        }
    }

    public void closeGatt() {
        checkRuntime();
        log("closeGatt  mBluetoothGatt is %s null", this.mBluetoothGatt == null ? "" : "not");
        if (this.mBluetoothGatt != null) {
            this.mWorkerHandler.sendEmptyMessageDelayed(MSG_DISCONNECT_TIMEOUT, AssistantConstants.TIMEOUT_VAD_MUTE);
            this.mBluetoothGatt.disconnect();
            return;
        }
        GattResponseListener gattResponseListener = this.mGattResponseListener;
        if (gattResponseListener != null) {
            gattResponseListener.onConnectStatusChanged(false);
        }
        setConnectStatus(0);
        broadcastConnectStatus(32, 0);
    }

    public void destroy() {
        SystemActionObserver.getInstance().unregisterSystemActionCallback(this.mSystemActionChangedCallback);
        this.mDeviceProfile.clear();
    }

    public boolean discoverService() {
        checkRuntime();
        log("discoverService for %s", getAddress());
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        if (bluetoothGatt == null) {
            log("discoverService but gatt is null!", new Object[0]);
            return false;
        } else if (bluetoothGatt.discoverServices()) {
            return true;
        } else {
            log("discoverServices failed", new Object[0]);
            return false;
        }
    }

    public int getCurrentStatus() {
        checkRuntime();
        return this.mConnectStatus;
    }

    public boolean handleMessage(@NonNull Message message) {
        int i = message.what;
        if (i == MSG_GATT_RESPONSE) {
            ProxyBulk.safeInvoke(message.obj);
            return true;
        } else if (i != MSG_DISCONNECT_TIMEOUT) {
            return true;
        } else {
            BluetoothLog.error(TAG, "disconnect timeout", new Object[0]);
            releaseAfterDisconnected(0);
            return true;
        }
    }

    public void isCharacterExist(UUID uuid, UUID uuid2, BleResponse<Void> bleResponse) {
        if (bleResponse == null) {
            log("isCharacterExist uuid =%s, response is null", uuid2);
        } else if (this.mBluetoothGatt == null || this.mDeviceProfile == null) {
            log("isCharacterExist uuid =%s, gatt is null or profile is null", uuid2);
            bleResponse.onResponse(-8, null);
        } else if (getCharacter(uuid, uuid2) != null) {
            log("isCharacterExist uuid =%s ,find dest uuid", uuid2);
            bleResponse.onResponse(0, null);
        } else {
            log("isCharacterExist uuid =%s, not find dest uuid", uuid2);
            bleResponse.onResponse(-1, null);
        }
    }

    public void log(String str, Object... objArr) {
        BluetoothLog.log(TAG, str, objArr);
    }

    public void onCharacteristicChanged(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        checkRuntime();
        if (BluetoothLog.isDetailMode()) {
            wf("onCharacteristicChanged for " + this.mBluetoothDevice.getAddress() + ": value = " + ByteUtils.byteToString(bArr) + " service = " + UUIDUtils.getShortUUID(bluetoothGattCharacteristic.getService().getUuid()) + ", character = " + UUIDUtils.getShortUUID(bluetoothGattCharacteristic.getUuid()), new Object[0]);
        } else {
            log("onCharacteristicChanged, character = " + UUIDUtils.getShortUUID(bluetoothGattCharacteristic.getUuid()) + ", value length=" + bArr.length, new Object[0]);
        }
        updateBleEventTime();
        broadcastCharacterChanged(bluetoothGattCharacteristic.getService().getUuid(), bluetoothGattCharacteristic.getUuid(), bArr);
    }

    public void onCharacteristicRead(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, byte[] bArr) {
        checkRuntime();
        if (BluetoothLog.isDetailMode()) {
            wf("onCharacteristicRead for %s: status = %d, service = 0x%s, character = 0x%s, value = %s", this.mBluetoothDevice.getAddress(), Integer.valueOf(i), bluetoothGattCharacteristic.getService().getUuid(), bluetoothGattCharacteristic.getUuid(), ByteUtils.byteToString(bArr));
        } else {
            int length = bArr != null ? bArr.length : 0;
            if (i == 0) {
                wf("onCharacteristicRead character=0x%s, value length=%d", bluetoothGattCharacteristic.getUuid(), Integer.valueOf(length));
            } else {
                log("onCharacteristicRead character=0x%s, value length=%d", bluetoothGattCharacteristic.getUuid(), Integer.valueOf(length));
            }
        }
        GattResponseListener gattResponseListener = this.mGattResponseListener;
        if (gattResponseListener instanceof ReadCharacterListener) {
            ((ReadCharacterListener) gattResponseListener).onCharacteristicRead(bluetoothGattCharacteristic, i, bArr);
        }
    }

    public void onCharacteristicWrite(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, byte[] bArr) {
        checkRuntime();
        if (BluetoothLog.isDetailMode()) {
            wf("onCharacteristicWrite for %s: status = %d, service = 0x%s, character = 0x%s, value length = %d,value = %s", this.mBluetoothDevice.getAddress(), Integer.valueOf(i), bluetoothGattCharacteristic.getService().getUuid(), bluetoothGattCharacteristic.getUuid(), Integer.valueOf(bArr.length), ByteUtils.byteToString(bArr));
        } else if (i == 0) {
            wf("onCharacteristicWrite character = 0x%s, status=%d", bluetoothGattCharacteristic.getUuid(), Integer.valueOf(i));
        } else {
            log("onCharacteristicWrite character = 0x%s, status=%d", bluetoothGattCharacteristic.getUuid(), Integer.valueOf(i));
        }
        GattResponseListener gattResponseListener = this.mGattResponseListener;
        if (gattResponseListener instanceof WriteCharacterListener) {
            ((WriteCharacterListener) gattResponseListener).onCharacteristicWrite(bluetoothGattCharacteristic, i, bArr);
        }
    }

    public void onConnectionStateChange(int i, int i2) {
        checkRuntime();
        BluetoothLog.log(TAG, "onConnectionStateChange status=%d, newState=%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 2) {
            setConnectStatus(2);
            BleEventBus.get().post(new MYVURingEvent(this.mBluetoothDevice.getAddress(), 3, this.mBluetoothDevice));
            GattResponseListener gattResponseListener = this.mGattResponseListener;
            if (gattResponseListener != null) {
                gattResponseListener.onConnectStatusChanged(true);
            }
            this.mBluetoothGatt.readPhy();
            return;
        }
        releaseAfterDisconnected(i);
    }

    public void onConnectionUpdate(int i, int i2) {
        log("onConnectionUpdate interval =" + i2 + ", latency =" + i, new Object[0]);
        if (i != 0) {
            this.mLatencyMode = 1;
            openHighSpeedModeIfNeed();
        }
    }

    public void onDescriptorWrite(BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        checkRuntime();
        wf("onDescriptorWrite for %s: status = %d, service = 0x%s, character = 0x%s, descriptor = 0x%s", this.mBluetoothDevice.getAddress(), Integer.valueOf(i), bluetoothGattDescriptor.getCharacteristic().getService().getUuid(), bluetoothGattDescriptor.getCharacteristic().getUuid(), bluetoothGattDescriptor.getUuid());
        GattResponseListener gattResponseListener = this.mGattResponseListener;
        if (gattResponseListener instanceof WriteDescriptorListener) {
            ((WriteDescriptorListener) gattResponseListener).onDescriptorWrite(bluetoothGattDescriptor, i);
        }
    }

    public boolean onIntercept(Object obj, Method method, Object[] objArr) {
        this.mWorkerHandler.obtainMessage(MSG_GATT_RESPONSE, new ProxyBulk(obj, method, objArr)).sendToTarget();
        return true;
    }

    public void onMtuChanged(int i, int i2) {
        checkRuntime();
        log("onMtuChanged for %s, mtu = %d, status = %d", this.mBluetoothDevice.getAddress(), Integer.valueOf(i), Integer.valueOf(i2));
        GattResponseListener gattResponseListener = this.mGattResponseListener;
        if (gattResponseListener instanceof RequestMtuListener) {
            ((RequestMtuListener) gattResponseListener).onMtuChanged(i, i2);
        }
    }

    public void onPhyRead(int i, int i2, int i3) {
        requestPhy(i, i2, i3);
    }

    public void onPhyUpdate(int i, int i2, int i3) {
        requestPhy(i, i2, i3);
        log("onPhyUpdate: " + i2 + ", " + i, new Object[0]);
    }

    public void onServiceChanged(BluetoothGatt bluetoothGatt) {
        discoverService();
    }

    public void onServicesDiscovered(final int i) {
        checkRuntime();
        log("onServicesDiscovered for %s: status = %d", this.mBluetoothDevice.getAddress(), Integer.valueOf(i));
        if (i == 0) {
            BleConnectConfig bleConnectConfig = this.mConConfig;
            final UUID destCharacterUUID = bleConnectConfig != null ? bleConnectConfig.getDestCharacterUUID() : null;
            refreshServiceProfile(new Consumer<Boolean>() {
                public void accept(Boolean bool) {
                    if (bool.booleanValue()) {
                        BleWorker.this.setConnectStatus(19);
                        BleWorker.this.broadcastConnectStatus(16, 0);
                    } else {
                        BluetoothLog.error(BleWorker.TAG, "onServicesDiscovered=>refreshServiceProfile=>not exist dest character uuid:" + destCharacterUUID, new Object[0]);
                    }
                    if (BleWorker.this.mGattResponseListener instanceof ServiceDiscoverListener) {
                        ((ServiceDiscoverListener) BleWorker.this.mGattResponseListener).onServicesDiscovered(bool.booleanValue() ? i : -1);
                    }
                }
            }, destCharacterUUID);
            return;
        }
        GattResponseListener gattResponseListener = this.mGattResponseListener;
        if (gattResponseListener instanceof ServiceDiscoverListener) {
            ((ServiceDiscoverListener) gattResponseListener).onServicesDiscovered(i);
        }
    }

    public boolean openGatt(BleConnectConfig bleConnectConfig) {
        checkRuntime();
        if (this.mBluetoothGatt != null) {
            BluetoothLog.error(TAG, "openGatt fail,Previous gatt not closed", new Object[0]);
            return true;
        }
        log("start openGatt for connect ble device openGatt for %s", getAddress());
        Context context = BluetoothContextManager.getContext();
        BluetoothGattResponse bluetoothGattResponse = new BluetoothGattResponse(this.mBluetoothGattResponse);
        this.mConConfig = bleConnectConfig;
        BluetoothGatt connectGatt = this.mBluetoothDevice.connectGatt(context, false, bluetoothGattResponse, 2);
        this.mBluetoothGatt = connectGatt;
        if (connectGatt != null) {
            return true;
        }
        BluetoothLog.error(TAG, "openGatt failed: connectGatt return null!", new Object[0]);
        return false;
    }

    public boolean readCharacteristic(UUID uuid, UUID uuid2) {
        log("readCharacteristic for: " + this.mBluetoothDevice.getAddress() + " service = " + UUIDUtils.getShortUUID(uuid) + ", character = " + UUIDUtils.getShortUUID(uuid2), new Object[0]);
        checkRuntime();
        updateBleEventTime();
        BluetoothGattCharacteristic character = getCharacter(uuid, uuid2);
        if (character == null) {
            BluetoothLog.error(TAG, "readCharacteristic characteristic not exist!", new Object[0]);
            return false;
        } else if (!isCharacteristicReadable(character)) {
            BluetoothLog.error(TAG, "readCharacteristic characteristic not readable!", new Object[0]);
            return false;
        } else {
            BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
            if (bluetoothGatt == null) {
                BluetoothLog.error(TAG, "readCharacteristic ble gatt null", new Object[0]);
                return false;
            } else if (bluetoothGatt.readCharacteristic(character)) {
                return true;
            } else {
                BluetoothLog.error(TAG, "readCharacteristic failed", new Object[0]);
                return false;
            }
        }
    }

    public boolean refreshDeviceCache() {
        log("refreshDeviceCache for %s", getAddress());
        checkRuntime();
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        if (bluetoothGatt == null) {
            log("refreshDeviceCache ble gatt null", new Object[0]);
            return false;
        } else if (BluetoothUtils.refreshGattCache(bluetoothGatt)) {
            return true;
        } else {
            log("refreshDeviceCache failed", new Object[0]);
            return false;
        }
    }

    public void registerGattResponseListener(GattResponseListener gattResponseListener) {
        checkRuntime();
        this.mGattResponseListener = gattResponseListener;
    }

    public boolean requestMtu(int i) {
        checkRuntime();
        log("requestMtu for %s, mtu = %d", getAddress(), Integer.valueOf(i));
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        if (bluetoothGatt == null) {
            BluetoothLog.error(TAG, "requestMtu ble gatt null", new Object[0]);
            return false;
        } else if (bluetoothGatt.requestMtu(i)) {
            return true;
        } else {
            BluetoothLog.error(TAG, "requestMtu failed", new Object[0]);
            return false;
        }
    }

    public boolean setCharacteristicNotification(UUID uuid, UUID uuid2, boolean z) {
        checkRuntime();
        log("setCharacteristicNotification for " + getAddress() + ", service = " + UUIDUtils.getShortUUID(uuid) + ", character = " + UUIDUtils.getShortUUID(uuid2) + ", enable = " + z, new Object[0]);
        BluetoothGattCharacteristic character = getCharacter(uuid, uuid2);
        if (character == null) {
            BluetoothLog.error(TAG, "characteristic not exist!", new Object[0]);
            return false;
        } else if (!isCharacteristicNotifyable(character)) {
            BluetoothLog.error(TAG, "characteristic not notifyable!", new Object[0]);
            return false;
        } else {
            BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
            if (bluetoothGatt == null) {
                BluetoothLog.error(TAG, "setCharacteristicNotification ble gatt null", new Object[0]);
                return false;
            } else if (!bluetoothGatt.setCharacteristicNotification(character, z)) {
                BluetoothLog.error(TAG, "setCharacteristicNotification failed", new Object[0]);
                return false;
            } else {
                BluetoothGattDescriptor descriptor = character.getDescriptor(BluetoothConstants.CLIENT_CHARACTERISTIC_CONFIG);
                if (descriptor == null) {
                    BluetoothLog.error(TAG, "getDescriptor for notify null!", new Object[0]);
                    return false;
                }
                byte[] bArr = z ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
                if (Build.VERSION.SDK_INT >= 33) {
                    if (this.mBluetoothGatt.writeDescriptor(descriptor, bArr) == 0) {
                        return true;
                    }
                    BluetoothLog.error(TAG, "writeDescriptor(T) for notify failed", new Object[0]);
                    return false;
                } else if (!descriptor.setValue(bArr)) {
                    BluetoothLog.error(TAG, "setValue for notify descriptor failed!", new Object[0]);
                    return false;
                } else if (this.mBluetoothGatt.writeDescriptor(descriptor)) {
                    return true;
                } else {
                    BluetoothLog.error(TAG, "writeDescriptor(S) for notify failed", new Object[0]);
                    return false;
                }
            }
        }
    }

    public void waitFor(int i) {
        synchronized (this.mLock) {
            try {
                this.mLock.wait((long) i);
            } catch (InterruptedException e) {
                log("Sleeping interrupted,detail=%s", e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }

    public void wf(String str, Object... objArr) {
        BluetoothLog.df(TAG, str, objArr);
    }

    public boolean writeCharacteristic(UUID uuid, UUID uuid2, byte[] bArr) {
        if (BluetoothLog.isDetailMode()) {
            wf("writeCharacteristic for " + this.mBluetoothDevice.getAddress() + ": service = " + UUIDUtils.getShortUUID(uuid) + ", character = " + UUIDUtils.getShortUUID(uuid2) + ", value length=" + bArr.length + ",value = " + ByteUtils.byteToString(bArr), new Object[0]);
        } else {
            log("writeCharacteristic ,character=" + UUIDUtils.getShortUUID(uuid2) + ", value length=" + bArr.length, new Object[0]);
        }
        checkRuntime();
        BleConnectConfig bleConnectConfig = this.mConConfig;
        if (bleConnectConfig == null || !uuid2.equals(bleConnectConfig.getHeartBeatUUID())) {
            updateBleEventTime();
        }
        BluetoothGattCharacteristic character = getCharacter(uuid, uuid2);
        if (character == null) {
            BluetoothLog.error(TAG, "writeCharacteristic characteristic not exist!", new Object[0]);
            return false;
        } else if (!isCharacteristicWritable(character)) {
            BluetoothLog.error(TAG, "characteristic not writable!", new Object[0]);
            return false;
        } else {
            BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
            if (bluetoothGatt == null) {
                BluetoothLog.error(TAG, "writeCharacteristic ble gatt null", new Object[0]);
                return false;
            } else if (Build.VERSION.SDK_INT < 33) {
                character.setValue(bArr);
                if (this.mBluetoothGatt.writeCharacteristic(character)) {
                    return true;
                }
                BluetoothLog.error(TAG, "writeCharacteristic(S) failed", new Object[0]);
                return false;
            } else if (bluetoothGatt.writeCharacteristic(character, bArr, character.getWriteType()) == 0) {
                return true;
            } else {
                BluetoothLog.error(TAG, "writeCharacteristic(T) failed", new Object[0]);
                return false;
            }
        }
    }

    public boolean writeCharacteristicWithNoRsp(UUID uuid, UUID uuid2, byte[] bArr) {
        if (BluetoothLog.isDetailMode()) {
            wf("writeCharacteristicWithNoRsp for " + this.mBluetoothDevice.getAddress() + ": service = " + UUIDUtils.getShortUUID(uuid) + ", character = " + UUIDUtils.getShortUUID(uuid2) + ", value length=" + bArr.length + ",value = " + ByteUtils.byteToString(bArr), new Object[0]);
        } else {
            log("writeCharacteristicWithNoRsp ,character=" + UUIDUtils.getShortUUID(uuid2) + ", value length=" + bArr.length, new Object[0]);
        }
        checkRuntime();
        BleConnectConfig bleConnectConfig = this.mConConfig;
        if (bleConnectConfig == null || !uuid2.equals(bleConnectConfig.getHeartBeatUUID())) {
            updateBleEventTime();
        }
        BluetoothGattCharacteristic character = getCharacter(uuid, uuid2);
        if (character == null) {
            BluetoothLog.error(TAG, "writeCharacteristicWithNoRsp characteristic not exist!", new Object[0]);
            return false;
        } else if (!isCharacteristicNoRspWritable(character)) {
            BluetoothLog.error(TAG, "characteristic not norsp writable!", new Object[0]);
            return false;
        } else {
            BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
            if (bluetoothGatt == null) {
                BluetoothLog.error(TAG, "writeCharacteristicWithNoRsp ble gatt null", new Object[0]);
                return false;
            } else if (Build.VERSION.SDK_INT < 33) {
                character.setValue(bArr);
                if (this.mBluetoothGatt.writeCharacteristic(character)) {
                    return true;
                }
                BluetoothLog.error(TAG, "writeCharacteristicWithNoRsp(S) failed", new Object[0]);
                return false;
            } else if (bluetoothGatt.writeCharacteristic(character, bArr, character.getWriteType()) == 0) {
                return true;
            } else {
                BluetoothLog.error(TAG, "writeCharacteristicWithNoRsp(T) failed", new Object[0]);
                return false;
            }
        }
    }
}
