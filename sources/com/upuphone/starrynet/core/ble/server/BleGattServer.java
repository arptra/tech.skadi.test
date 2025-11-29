package com.upuphone.starrynet.core.ble.server;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.core.ble.BluetoothConstants;
import com.upuphone.starrynet.core.ble.BluetoothContextManager;
import com.upuphone.starrynet.core.ble.Code;
import com.upuphone.starrynet.core.ble.SystemActionObserver;
import com.upuphone.starrynet.core.ble.client.RuntimeChecker;
import com.upuphone.starrynet.core.ble.event.BleEventBus;
import com.upuphone.starrynet.core.ble.event.BleOpenNotifyEvent;
import com.upuphone.starrynet.core.ble.event.ServerConnectChangeEvent;
import com.upuphone.starrynet.core.ble.proxy.ProxyBulk;
import com.upuphone.starrynet.core.ble.proxy.ProxyInterceptor;
import com.upuphone.starrynet.core.ble.proxy.ProxyUtils;
import com.upuphone.starrynet.core.ble.server.character.IGattCharacterService;
import com.upuphone.starrynet.core.ble.server.character.IGattCharacteristic;
import com.upuphone.starrynet.core.ble.server.handler.ICharacterHandler;
import com.upuphone.starrynet.core.ble.server.listener.GattServerResponseListener;
import com.upuphone.starrynet.core.ble.server.listener.NotificationListener;
import com.upuphone.starrynet.core.ble.server.listener.OpenServerListener;
import com.upuphone.starrynet.core.ble.utils.BluetoothLog;
import com.upuphone.starrynet.core.ble.utils.UUIDUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;

@SuppressLint({"MissingPermission"})
public class BleGattServer implements IBleServer, RuntimeChecker, IBleGattServerResponse, ProxyInterceptor, Handler.Callback {
    private static final int MSG_GATT_RESPONSE = 290;
    private static final String TAG = "BleGattServer";
    /* access modifiers changed from: private */
    public final List<UUID> mAddedServices = new ArrayList();
    private final GattServerConfig mConfig;
    private final Context mContext;
    /* access modifiers changed from: private */
    public GattServerResponseListener mGattResponseListener;
    private BluetoothGattServer mGattServer;
    /* access modifiers changed from: private */
    public boolean mIsGattServerOpen = false;
    private Map<String, Set<UUID>> mMac2OpenNotifyMap = new HashMap();
    private Map<UUID, BluetoothGattCharacteristic> mNotificationCharacterMap = new HashMap();
    /* access modifiers changed from: private */
    public Map<String, BluetoothDevice> mRemoteDevices = new HashMap();
    private RuntimeChecker mRuntimeChecker;
    private IBleGattServerResponse mServerCallback;
    /* access modifiers changed from: private */
    public Set<String> mValidConnectedDevice = new HashSet();
    private Handler mWorkerHandler;

    public BleGattServer(Context context, GattServerConfig gattServerConfig, RuntimeChecker runtimeChecker) {
        this.mContext = context;
        this.mConfig = gattServerConfig;
        this.mRuntimeChecker = runtimeChecker;
        this.mWorkerHandler = new Handler(Looper.myLooper(), this);
        this.mServerCallback = (IBleGattServerResponse) ProxyUtils.getProxy(this, IBleGattServerResponse.class, this);
        SystemActionObserver.getInstance().registerSystemActionCallback(new SystemActionObserver.SystemActionChangedCallback() {
            public boolean onBluetoothStateChange(final boolean z) {
                BluetoothContextManager.post(new Runnable() {
                    public void run() {
                        BleGattServer bleGattServer = BleGattServer.this;
                        bleGattServer.log("onBluetoothStateChange :" + z, new Object[0]);
                        boolean unused = BleGattServer.this.mIsGattServerOpen = false;
                        BleGattServer.this.mAddedServices.clear();
                        if (!z) {
                            BleGattServer.this.mValidConnectedDevice.clear();
                            if (BleGattServer.this.mRemoteDevices.size() > 0) {
                                for (Map.Entry entry : BleGattServer.this.mRemoteDevices.entrySet()) {
                                    BleGattServer.this.broadcastServerValidConnectStatusChanged(false, (String) entry.getKey());
                                    BleGattServer.this.updatePhysicsConnectedStatus((String) entry.getKey(), false);
                                    if (BleGattServer.this.mGattResponseListener != null) {
                                        BleGattServer.this.mGattResponseListener.onConnectStatusChanged((String) entry.getKey(), false);
                                    }
                                }
                            } else if (BleGattServer.this.mGattResponseListener instanceof OpenServerListener) {
                                BleGattServer.this.mGattResponseListener.onConnectStatusChanged((String) null, false);
                            }
                            BleGattServer.this.mRemoteDevices.clear();
                        } else if (BleGattServer.this.mRemoteDevices.size() > 0) {
                            BleGattServer.this.log("onBluetoothStateChange bt on, clear remoteDevices", new Object[0]);
                            for (Map.Entry key : BleGattServer.this.mRemoteDevices.entrySet()) {
                                BleGattServer.this.updatePhysicsConnectedStatus((String) key.getKey(), false);
                            }
                            BleGattServer.this.mRemoteDevices.clear();
                        }
                    }
                });
                return true;
            }
        });
    }

    private String bluetoothGattService2String(BluetoothGattService bluetoothGattService) {
        StringBuilder sb = new StringBuilder(32);
        sb.append("service uuid =");
        sb.append(bluetoothGattService.getUuid());
        sb.append(StringUtils.LF);
        for (BluetoothGattCharacteristic uuid : bluetoothGattService.getCharacteristics()) {
            sb.append("characteristic =");
            sb.append(uuid.getUuid());
            sb.append(StringUtils.LF);
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public void broadcastServerValidConnectStatusChanged(boolean z, String str) {
        BleEventBus.get().post(new ServerConnectChangeEvent(str, z));
    }

    private BluetoothGattService buildGattService(IGattCharacterService iGattCharacterService) {
        boolean z;
        BluetoothGattService bluetoothGattService = new BluetoothGattService(iGattCharacterService.getUUID(), iGattCharacterService.getServiceType());
        if (iGattCharacterService.getGattCharacteristic().size() > 0) {
            for (IGattCharacteristic next : iGattCharacterService.getGattCharacteristic()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(next.getUUID(), next.getProperties(), next.getPermissions());
                if ((next.getProperties() & 16) != 0) {
                    bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(BluetoothConstants.CLIENT_CHARACTERISTIC_CONFIG, 16));
                    z = true;
                } else {
                    z = false;
                }
                bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
                if (z) {
                    this.mNotificationCharacterMap.put(next.getUUID(), bluetoothGattCharacteristic);
                }
            }
        }
        return bluetoothGattService;
    }

    private void checkAndNotifyValidConnected(BleOpenNotifyEvent bleOpenNotifyEvent) {
        if (this.mRemoteDevices.get(bleOpenNotifyEvent.getMac()) == null) {
            log("checkAndNotifyValidConnected not exist physics connect device", new Object[0]);
        } else if (!bleOpenNotifyEvent.isEnable()) {
            log("checkAndNotifyValidConnected notify event isEnable = false", new Object[0]);
        } else if (!BluetoothConstants.XR_NOTIFY_UUIDS.contains(bleOpenNotifyEvent.getCharacter())) {
            log("checkAndNotifyValidConnected not expect notify uuid =" + UUIDUtils.getShortUUID(bleOpenNotifyEvent.getCharacter()), new Object[0]);
        } else {
            boolean contains = this.mValidConnectedDevice.contains(bleOpenNotifyEvent.getMac());
            log("checkAndNotifyValidConnected validConnect =" + contains, new Object[0]);
            if (!contains) {
                this.mValidConnectedDevice.add(bleOpenNotifyEvent.getMac());
                log("checkAndNotifyValidConnected onConnectionStateChange  notify server connected", new Object[0]);
                broadcastServerValidConnectStatusChanged(true, bleOpenNotifyEvent.getMac());
            }
        }
    }

    private boolean checkServiceAdded(IGattCharacterService iGattCharacterService) {
        if (this.mAddedServices.isEmpty()) {
            return false;
        }
        for (UUID equals : this.mAddedServices) {
            if (equals.equals(iGattCharacterService.getUUID())) {
                return true;
            }
        }
        return false;
    }

    private void error(String str, Object... objArr) {
        BluetoothLog.error(TAG, str, objArr);
    }

    /* access modifiers changed from: private */
    public void log(String str, Object... objArr) {
        BluetoothLog.log(TAG, str, objArr);
    }

    private void notificationCallback(int i) {
        GattServerResponseListener gattServerResponseListener = this.mGattResponseListener;
        if (gattServerResponseListener instanceof NotificationListener) {
            ((NotificationListener) gattServerResponseListener).onNotificationSent(i);
        } else {
            log("warning =>>>notificationCallback cannot find dest callback, current callback is %s", gattServerResponseListener == null ? "null" : gattServerResponseListener.getClass().getName());
        }
    }

    private IGattCharacteristic queryCharacter(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (this.mConfig == null) {
            log("queryCharacter mConfig is null", new Object[0]);
            return null;
        } else if (!SystemActionObserver.getInstance().isBtOn()) {
            log("queryCharacter bt off", new Object[0]);
            return null;
        } else if (this.mConfig.getGattService().isEmpty()) {
            log("queryCharacter config gatt service is null", new Object[0]);
            return null;
        } else {
            for (IGattCharacterService next : this.mConfig.getGattService()) {
                if (!next.getGattCharacteristic().isEmpty()) {
                    for (IGattCharacteristic next2 : next.getGattCharacteristic()) {
                        if (next2.getUUID().equals(bluetoothGattCharacteristic.getUuid())) {
                            return next2;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
    }

    private void requestPhy(BluetoothDevice bluetoothDevice, int i, int i2, int i3) {
    }

    public void addServices(IGattCharacterService iGattCharacterService) {
        GattServerConfig gattServerConfig = this.mConfig;
        if ((gattServerConfig == null || gattServerConfig.addGattService(iGattCharacterService)) && this.mGattServer != null && !checkServiceAdded(iGattCharacterService)) {
            this.mGattServer.addService(buildGattService(iGattCharacterService));
            this.mAddedServices.add(iGattCharacterService.getUUID());
        }
    }

    public void checkRuntime() {
        RuntimeChecker runtimeChecker = this.mRuntimeChecker;
        if (runtimeChecker != null) {
            runtimeChecker.checkRuntime();
        }
    }

    public void clearGattServerResponseListener(GattServerResponseListener gattServerResponseListener) {
        checkRuntime();
        if (this.mGattResponseListener == gattServerResponseListener) {
            this.mGattResponseListener = null;
        }
    }

    public void disconnect() {
    }

    public boolean handleMessage(@NonNull Message message) {
        if (message.what != MSG_GATT_RESPONSE) {
            return true;
        }
        ProxyBulk.safeInvoke(message.obj);
        return true;
    }

    public boolean isCharacterNotify(String str, UUID uuid) {
        Set set = this.mMac2OpenNotifyMap.get(str);
        if (set != null && !set.isEmpty()) {
            return set.contains(uuid);
        }
        log("isCharacterNotify,bleMac=%s, uuid set is empty.", str);
        return false;
    }

    public boolean isConnected(String str) {
        return this.mRemoteDevices.containsKey(str);
    }

    public boolean isServerOpened() {
        return this.mIsGattServerOpen;
    }

    public void onCharacteristicReadRequest(BluetoothDevice bluetoothDevice, int i, int i2, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        checkRuntime();
        UUID uuid = bluetoothGattCharacteristic.getUuid();
        if (BluetoothLog.isDetailMode()) {
            wf("onCharacteristicReadRequest uuid=" + UUIDUtils.getShortUUID(uuid) + ", value =" + ByteUtils.byteToString(bluetoothGattCharacteristic.getValue()), new Object[0]);
        } else {
            wf("onCharacteristicReadRequest character=" + UUIDUtils.getShortUUID(uuid), new Object[0]);
        }
        IGattCharacteristic queryCharacter = queryCharacter(bluetoothGattCharacteristic);
        if (queryCharacter == null) {
            this.mGattServer.sendResponse(bluetoothDevice, i, 2, 0, ByteUtils.EMPTY_BYTES);
            return;
        }
        byte[] bArr = ByteUtils.EMPTY_BYTES;
        if (queryCharacter.isSupportMultiplePacket()) {
            this.mGattServer.sendResponse(bluetoothDevice, i, 0, 0, bArr);
        }
        ICharacterHandler handler = queryCharacter.getHandler();
        if (handler != null) {
            handler.onCharacteristicReadRequest(this.mGattServer, bluetoothDevice, bluetoothGattCharacteristic.getUuid(), i);
        }
    }

    public void onCharacteristicWriteRequest(BluetoothDevice bluetoothDevice, int i, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, boolean z2, int i2, byte[] bArr) {
        byte[] bArr2 = bArr;
        checkRuntime();
        UUID uuid = bluetoothGattCharacteristic.getUuid();
        if (BluetoothLog.isDetailMode()) {
            wf("onCharacteristicWriteRequest uuid=" + UUIDUtils.getShortUUID(uuid) + ",value length =" + bArr2.length + ", value =" + ByteUtils.byteToString(bArr), new Object[0]);
        } else {
            log("onCharacteristicWriteRequest uuid=" + UUIDUtils.getShortUUID(uuid) + ",value length =" + bArr2.length, new Object[0]);
        }
        IGattCharacteristic queryCharacter = queryCharacter(bluetoothGattCharacteristic);
        if (queryCharacter != null) {
            if (this.mGattServer == null || !z2) {
                int i3 = i;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("send response : ");
                int i4 = i;
                sb.append(i);
                wf(sb.toString(), new Object[0]);
                this.mGattServer.sendResponse(bluetoothDevice, i, 0, 0, ByteUtils.EMPTY_BYTES);
            }
            ICharacterHandler handler = queryCharacter.getHandler();
            if (handler != null) {
                handler.onCharacteristicWriteRequest(this.mGattServer, bluetoothDevice, bluetoothGattCharacteristic.getUuid(), i, bArr);
                return;
            }
            log("onCharacteristicWriteRequest uuid=%s, cannot find handler!", queryCharacter.getUUID());
        } else if (z2) {
            this.mGattServer.sendResponse(bluetoothDevice, i, 3, 0, ByteUtils.EMPTY_BYTES);
        }
    }

    public void onConnectionStateChange(BluetoothDevice bluetoothDevice, int i, int i2) {
        checkRuntime();
        String address = bluetoothDevice.getAddress();
        log("onConnectionStateChange ,remote device mac=%s,status=%d,newState=%d", address, Integer.valueOf(i), Integer.valueOf(i2));
        boolean z = 2 == i2;
        updatePhysicsConnectedStatus(address, z);
        if (z) {
            this.mRemoteDevices.put(address, bluetoothDevice);
            this.mGattServer.readPhy(bluetoothDevice);
            return;
        }
        this.mMac2OpenNotifyMap.remove(address);
        GattServerResponseListener gattServerResponseListener = this.mGattResponseListener;
        if (gattServerResponseListener != null) {
            gattServerResponseListener.onConnectStatusChanged(address, false);
        }
        boolean remove = this.mValidConnectedDevice.remove(address);
        if (this.mRemoteDevices.remove(address) == null) {
            broadcastServerValidConnectStatusChanged(false, address);
        } else if (remove) {
            broadcastServerValidConnectStatusChanged(false, address);
        } else {
            log("onConnectionStateChange validConnect not ture, will not broadcast server disconnect", new Object[0]);
        }
    }

    public void onDescriptorWriteRequest(BluetoothDevice bluetoothDevice, int i, BluetoothGattDescriptor bluetoothGattDescriptor, boolean z, boolean z2, int i2, byte[] bArr) {
        BluetoothGattCharacteristic characteristic = bluetoothGattDescriptor.getCharacteristic();
        byte[] bArr2 = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        String address = bluetoothDevice.getAddress();
        if (bArr != null && bArr.length == 2 && bArr2[0] == bArr[0] && bArr2[1] == bArr[1]) {
            Set set = this.mMac2OpenNotifyMap.get(address);
            if (set == null) {
                set = new HashSet();
                this.mMac2OpenNotifyMap.put(address, set);
            }
            set.add(characteristic.getUuid());
        }
        BleOpenNotifyEvent bleOpenNotifyEvent = new BleOpenNotifyEvent(address, characteristic.getUuid(), bArr);
        checkAndNotifyValidConnected(bleOpenNotifyEvent);
        BleEventBus.get().post(bleOpenNotifyEvent);
        log("onDescriptorWriteRequest and BleOpenNotifyEvent ,character uuid = %s, descriptor uuid =%s, value=%s", characteristic.getUuid().toString(), bluetoothGattDescriptor.getUuid().toString(), ByteUtils.byteToString(bArr));
        BluetoothGattServer bluetoothGattServer = this.mGattServer;
        if (bluetoothGattServer != null && z2) {
            bluetoothGattServer.sendResponse(bluetoothDevice, i, 0, i2, bArr);
        }
    }

    public boolean onIntercept(Object obj, Method method, Object[] objArr) {
        this.mWorkerHandler.obtainMessage(MSG_GATT_RESPONSE, new ProxyBulk(obj, method, objArr)).sendToTarget();
        return true;
    }

    public void onMtuChanged(BluetoothDevice bluetoothDevice, int i) {
        checkRuntime();
        log("onMtuCHanged remote device mac=%s, mtu=%d", bluetoothDevice.getAddress(), Integer.valueOf(i));
        BleServerCache.getInstance().putActualMtu(bluetoothDevice.getAddress(), i);
    }

    public void onNotificationSent(BluetoothDevice bluetoothDevice, int i) {
        checkRuntime();
        if (i == 0) {
            wf("onNotificationSent remote device mac=" + bluetoothDevice.getAddress() + ", status=" + i, new Object[0]);
            notificationCallback(0);
            return;
        }
        log("onNotificationSent remote device mac=" + bluetoothDevice.getAddress() + ", status=" + i, new Object[0]);
        notificationCallback(-1);
    }

    public void onPhyUpdate(BluetoothDevice bluetoothDevice, int i, int i2, int i3) {
        log("onPhyUpdate, txPhy=%d, rxPhy=%d, status=%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        requestPhy(bluetoothDevice, i, i2, i3);
    }

    public void onReadPhy(BluetoothDevice bluetoothDevice, int i, int i2, int i3) {
        log("onReadPhy, txPhy=%d, rxPhy=%d, status=%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        requestPhy(bluetoothDevice, i, i2, i3);
    }

    public void onServiceAdded(int i, BluetoothGattService bluetoothGattService) {
        checkRuntime();
        log("onServiceAdded ,service uuid =%s, status=%d,detail=\n%s", bluetoothGattService.getUuid().toString(), Integer.valueOf(i), bluetoothGattService2String(bluetoothGattService));
        if (i == 0) {
            if (!this.mRemoteDevices.isEmpty()) {
                GattServerResponseListener gattServerResponseListener = this.mGattResponseListener;
                if (gattServerResponseListener instanceof OpenServerListener) {
                    ((OpenServerListener) gattServerResponseListener).onResult(-24);
                }
            } else {
                this.mAddedServices.add(bluetoothGattService.getUuid());
                addServices();
                GattServerResponseListener gattServerResponseListener2 = this.mGattResponseListener;
                if (gattServerResponseListener2 instanceof OpenServerListener) {
                    ((OpenServerListener) gattServerResponseListener2).onResult(0);
                }
            }
            this.mIsGattServerOpen = true;
            return;
        }
        this.mIsGattServerOpen = false;
    }

    public void openServer() {
        this.mGattServer = ((BluetoothManager) this.mContext.getSystemService("bluetooth")).openGattServer(this.mContext, new BluetoothGattServerResponse(this.mServerCallback));
        addServices();
    }

    public void registerGattServerResponseListener(GattServerResponseListener gattServerResponseListener) {
        checkRuntime();
        this.mGattResponseListener = gattServerResponseListener;
    }

    public boolean sendNotification(String str, UUID uuid, byte[] bArr) {
        checkRuntime();
        if (this.mGattServer == null) {
            error("sendNotification : gatt server is null!", new Object[0]);
            notificationCallback(Code.SERVER_IS_NULL);
            return false;
        }
        BluetoothDevice bluetoothDevice = this.mRemoteDevices.get(str);
        if (bluetoothDevice != null) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = uuid != null ? this.mNotificationCharacterMap.get(uuid) : null;
            if (bluetoothGattCharacteristic != null) {
                log("sendNotification ,bleMac =" + str + " character =" + UUIDUtils.getShortUUID(uuid) + " content length =" + bArr.length, new Object[0]);
                if (Build.VERSION.SDK_INT >= 33) {
                    return this.mGattServer.notifyCharacteristicChanged(bluetoothDevice, bluetoothGattCharacteristic, false, bArr) == 0;
                }
                bluetoothGattCharacteristic.setValue(bArr);
                return this.mGattServer.notifyCharacteristicChanged(bluetoothDevice, bluetoothGattCharacteristic, false);
            }
            error("sendNotification ,cannot found characteristic, character=" + UUIDUtils.getShortUUID(uuid), new Object[0]);
            notificationCallback(-100);
        } else {
            notificationCallback(-101);
        }
        return false;
    }

    public void updatePhysicsConnectedStatus(String str, boolean z) {
        BleServerCache.getInstance().updatePhysicsConnectStatus(str, z);
    }

    public void wf(String str, Object... objArr) {
        BluetoothLog.df(TAG, str, objArr);
    }

    private void addServices() {
        if (this.mConfig == null) {
            log("addServices: mConfig is null, return !", new Object[0]);
        } else if (this.mAddedServices.size() == this.mConfig.getGattService().size()) {
            log("addServices: mAddedServices size equal config service size, return ", new Object[0]);
        } else {
            log("addServices: mConfig.getGattService size =" + this.mConfig.getGattService().size(), new Object[0]);
            for (IGattCharacterService next : this.mConfig.getGattService()) {
                if (!checkServiceAdded(next)) {
                    BluetoothGattService buildGattService = buildGattService(next);
                    if (this.mGattServer != null) {
                        log("addServices: service=" + buildGattService.getUuid(), new Object[0]);
                        this.mGattServer.addService(buildGattService);
                        return;
                    }
                    log("addServices: gatt server is null", new Object[0]);
                    return;
                }
                log("addServices: service had added " + next.getUUID(), new Object[0]);
            }
        }
    }
}
