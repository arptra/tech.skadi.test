package com.upuphone.starrynet.strategy.data;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.Utils;
import com.upuphone.starrynet.core.ap.WiFiApInfo;
import com.upuphone.starrynet.core.ble.client.BleClientCache;
import com.upuphone.starrynet.core.database.dao.BondInfo;
import com.upuphone.starrynet.core.p2p.bean.GoInfo;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import com.upuphone.starrynet.strategy.discovery.scanner.IDiscoveryListener;
import com.upuphone.starrynet.strategy.utils.BleUtil;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class StarryDeviceManager extends StarryDeviceNotify {
    private static final String TAG = "StarryDeviceManager";
    private final StarryBondManager mBondManager;
    private final Map<String, StConnectDevice> mConnectDeviceMap;
    private final DiscoveryDeviceManager mDiscoveryMgr;

    public static class Holder {
        /* access modifiers changed from: private */
        public static final StarryDeviceManager INSTANCE = new StarryDeviceManager();

        private Holder() {
        }
    }

    private String byte2String(byte[] bArr) {
        return StDevice.bytes2HexString(bArr);
    }

    private boolean checkProfileConnect(final int i) {
        return this.mConnectDeviceMap.values().stream().anyMatch(new Predicate<StConnectDevice>() {
            public boolean test(StConnectDevice stConnectDevice) {
                return stConnectDevice.isProtocolConnected(i);
            }
        });
    }

    @SuppressLint({"MissingPermission"})
    private byte getBluetoothDeviceType(BluetoothDevice bluetoothDevice) {
        BluetoothClass bluetoothClass;
        if (bluetoothDevice == null || (bluetoothClass = bluetoothDevice.getBluetoothClass()) == null) {
            return 0;
        }
        int majorDeviceClass = bluetoothClass.getMajorDeviceClass();
        if (majorDeviceClass == 0) {
            return 33;
        }
        if (majorDeviceClass == 256) {
            return 21;
        }
        if (majorDeviceClass == 512) {
            return 1;
        }
        if (majorDeviceClass == 768) {
            return 22;
        }
        if (majorDeviceClass == 1024) {
            return 23;
        }
        if (majorDeviceClass == 1280) {
            return 24;
        }
        if (majorDeviceClass == 1536) {
            return 25;
        }
        if (majorDeviceClass == 1792) {
            return 26;
        }
        if (majorDeviceClass != 2048) {
            return majorDeviceClass != 2304 ? (byte) 0 : 28;
        }
        return 27;
    }

    public static StarryDeviceManager getInstance() {
        return Holder.INSTANCE;
    }

    /* access modifiers changed from: private */
    public void loadBondInfo() {
        List<BondInfo> bondedInfo = this.mBondManager.getBondedInfo();
        for (BondInfo stConnectDevice : bondedInfo) {
            StConnectDevice stConnectDevice2 = new StConnectDevice(stConnectDevice);
            if (stConnectDevice2.getTerminalType() == 5) {
                BleClientCache.getInstance().markExternalDevice(stConnectDevice2.getBleMac(), true);
            }
            this.mConnectDeviceMap.put(stConnectDevice2.getIdentifier2String(), stConnectDevice2);
        }
        bondedInfo.clear();
        StLog.i(TAG, "loadBondInfo size = " + this.mConnectDeviceMap.size());
    }

    public /* bridge */ /* synthetic */ void addAuthCallback(IAuthCallback iAuthCallback) {
        super.addAuthCallback(iAuthCallback);
    }

    public /* bridge */ /* synthetic */ void addConnectCallback(IConnectCallback iConnectCallback) {
        super.addConnectCallback(iConnectCallback);
    }

    public /* bridge */ /* synthetic */ void addDelayLoseDevice(String str) {
        super.addDelayLoseDevice(str);
    }

    public /* bridge */ /* synthetic */ void addDiscoveryInterceptor(IDiscoveryInterceptor iDiscoveryInterceptor) {
        super.addDiscoveryInterceptor(iDiscoveryInterceptor);
    }

    public /* bridge */ /* synthetic */ void addDiscoveryListener(IDiscoveryListener iDiscoveryListener) {
        super.addDiscoveryListener(iDiscoveryListener);
    }

    public void apClosed() {
        Message.obtain(this.mHandler, 36).sendToTarget();
    }

    public /* bridge */ /* synthetic */ void apCreated(WiFiApInfo wiFiApInfo) {
        super.apCreated(wiFiApInfo);
    }

    public /* bridge */ /* synthetic */ void authDevice(StDevice stDevice) {
        super.authDevice(stDevice);
    }

    public /* bridge */ /* synthetic */ void authDeviceMessage(StDevice stDevice, byte[] bArr) {
        super.authDeviceMessage(stDevice, bArr);
    }

    public /* bridge */ /* synthetic */ void bleConnectForDiscovery(String str, boolean z) {
        super.bleConnectForDiscovery(str, z);
    }

    public boolean clearDiscoveryDevice() {
        StLog.d(TAG, "clearDiscoveryDevice");
        Handler handler = this.mHandler;
        if (handler == null || !handler.hasMessages(10)) {
            return false;
        }
        this.mHandler.removeMessages(10);
        return true;
    }

    public /* bridge */ /* synthetic */ void connectFail(StDevice stDevice, int i, int i2) {
        super.connectFail(stDevice, i, i2);
    }

    public void deviceConnected(StConnectDevice stConnectDevice, int i) {
        if (stConnectDevice != null) {
            synchronized (this) {
                try {
                    stConnectDevice.setProtocolStatus(true, i);
                    StConnectDevice stConnectDevice2 = this.mConnectDeviceMap.get(stConnectDevice.getIdentifier2String());
                    if (stConnectDevice2 == null) {
                        this.mConnectDeviceMap.put(stConnectDevice.getIdentifier2String(), stConnectDevice);
                    } else if (stConnectDevice2 != stConnectDevice) {
                        stConnectDevice2.setDevice(stConnectDevice.getDevice());
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            StarryNetData.getInstance().getOwnDevice().setConnectStatus(true, getConnectProtocol(i));
            Message obtain = Message.obtain(this.mHandler, 30);
            obtain.obj = stConnectDevice;
            obtain.arg1 = i;
            obtain.sendToTarget();
        }
    }

    public void deviceDisconnected(StConnectDevice stConnectDevice, int i) {
        if (stConnectDevice != null) {
            synchronized (this) {
                if (i == 64) {
                    try {
                        stConnectDevice.setProtocolStatus(false, 128);
                        stConnectDevice.setProtocolStatus(false, 256);
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                } else if (i != 2) {
                    if (i != 1) {
                        if (stConnectDevice.getDeviceType() == 3 && (i == 512 || i == 8)) {
                            this.mConnectDeviceMap.remove(stConnectDevice.getIdentifier2String());
                        }
                    }
                }
                stConnectDevice.setProtocolStatus(false, i);
            }
            if (!checkProfileConnect(i)) {
                StarryNetData.getInstance().getOwnDevice().setConnectStatus(false, getConnectProtocol(i));
            }
            Message obtain = Message.obtain(this.mHandler, 31);
            obtain.obj = stConnectDevice;
            obtain.arg1 = i;
            obtain.sendToTarget();
        }
    }

    public void discoveryDevice(StDiscoveryDevice stDiscoveryDevice) {
        StLog.df(TAG, "discoveryDevice " + stDiscoveryDevice);
        putDeviceHitMac(stDiscoveryDevice);
        this.mDiscoveryMgr.addDevice(stDiscoveryDevice);
        Message.obtain(this.mHandler, 10, stDiscoveryDevice).sendToTarget();
    }

    public List<StConnectDevice> getBleConnectedDevices() {
        return (List) this.mConnectDeviceMap.values().stream().filter(new Predicate<StConnectDevice>() {
            public boolean test(StConnectDevice stConnectDevice) {
                return stConnectDevice.isBleConnected();
            }
        }).collect(Collectors.toList());
    }

    public BluetoothDevice getBluetoothDevice(StDevice stDevice) {
        if (stDevice == null) {
            return null;
        }
        return BleUtil.getBluetoothDevice(stDevice.getBrEdrMac());
    }

    public List<StConnectDevice> getBondInfoBySpecialDevice(final String str, final String str2) {
        return (List) this.mConnectDeviceMap.values().stream().filter(new Predicate<StConnectDevice>() {
            public boolean test(StConnectDevice stConnectDevice) {
                return stConnectDevice.getBleBondStatus() == 4;
            }
        }).filter(new Predicate<StConnectDevice>() {
            public boolean test(StConnectDevice stConnectDevice) {
                return str.equals(stConnectDevice.getCategoryID()) && str2.equals(stConnectDevice.getModelID());
            }
        }).collect(Collectors.toList());
    }

    public List<StConnectDevice> getBondInfoByTerminal(final int i) {
        return (List) this.mConnectDeviceMap.values().stream().filter(new Predicate<StConnectDevice>() {
            public boolean test(StConnectDevice stConnectDevice) {
                return stConnectDevice.getBleBondStatus() == 4 && stConnectDevice.getTerminalType() == i;
            }
        }).collect(Collectors.toList());
    }

    public List<StConnectDevice> getBondedInfo() {
        return (List) this.mConnectDeviceMap.values().stream().filter(new Predicate<StConnectDevice>() {
            public boolean test(StConnectDevice stConnectDevice) {
                return stConnectDevice.getBleBondStatus() == 4;
            }
        }).collect(Collectors.toList());
    }

    public List<StConnectDevice> getBondingDeviceByTerminal(final int i) {
        return (List) this.mConnectDeviceMap.values().stream().filter(new Predicate<StConnectDevice>() {
            public boolean test(StConnectDevice stConnectDevice) {
                return stConnectDevice.getTerminalType() == i && stConnectDevice.isBonding();
            }
        }).collect(Collectors.toList());
    }

    public StConnectDevice getConnectDevice(byte[] bArr) {
        String bytes2HexString;
        if (bArr == null || (bytes2HexString = StDevice.bytes2HexString(bArr)) == null) {
            return null;
        }
        return this.mConnectDeviceMap.get(bytes2HexString);
    }

    public StConnectDevice getConnectDeviceByBleMac(final String str) {
        StLog.d(TAG, "getConnectDeviceByBleMac mConnectDeviceMap.size=" + this.mConnectDeviceMap.size() + ",mac=" + str);
        List list = (List) this.mConnectDeviceMap.values().stream().sorted(new Comparator<StConnectDevice>() {
            public int compare(StConnectDevice stConnectDevice, StConnectDevice stConnectDevice2) {
                return Long.compare(stConnectDevice2.getDate(), stConnectDevice.getDate());
            }
        }).filter(new Predicate<StConnectDevice>() {
            public boolean test(StConnectDevice stConnectDevice) {
                return str.equals(stConnectDevice.getBleMac());
            }
        }).collect(Collectors.toList());
        if (list.isEmpty()) {
            return null;
        }
        for (int i = 1; i < list.size(); i++) {
            StConnectDevice stConnectDevice = (StConnectDevice) list.get(i);
            this.mConnectDeviceMap.remove(stConnectDevice.getIdentifier2String());
            this.mBondManager.removeBondInfo2Database(stConnectDevice);
        }
        return (StConnectDevice) list.get(0);
    }

    public StConnectDevice getConnectDeviceByBrEdrMac(final String str) {
        StConnectDevice curBondInfo;
        if (StarryNetData.getInstance().isAR() && (curBondInfo = getCurBondInfo()) != null && curBondInfo.getTerminalType() == 4 && curBondInfo.getBrEdrMac().equals(BleUtil.DEFAULT_ADDRESS)) {
            StLog.d(TAG, "set bredr mac, id = " + curBondInfo.getIdentifier2String() + " , br mac = " + str);
            curBondInfo.setBrEdrMac(str);
        }
        List list = (List) this.mConnectDeviceMap.values().stream().sorted(new Comparator<StConnectDevice>() {
            public int compare(StConnectDevice stConnectDevice, StConnectDevice stConnectDevice2) {
                return Long.compare(stConnectDevice2.getDate(), stConnectDevice.getDate());
            }
        }).filter(new Predicate<StConnectDevice>() {
            public boolean test(StConnectDevice stConnectDevice) {
                return str.equals(stConnectDevice.getBrEdrMac());
            }
        }).collect(Collectors.toList());
        if (list.isEmpty()) {
            return null;
        }
        for (int i = 1; i < list.size(); i++) {
            StConnectDevice stConnectDevice = (StConnectDevice) list.get(i);
            this.mConnectDeviceMap.remove(stConnectDevice.getIdentifier2String());
            this.mBondManager.removeBondInfo2Database(stConnectDevice);
        }
        return (StConnectDevice) list.get(0);
    }

    public List<StConnectDevice> getConnectDeviceByTerminal(final int i) {
        return (List) this.mConnectDeviceMap.values().stream().filter(new Predicate<StConnectDevice>() {
            public boolean test(StConnectDevice stConnectDevice) {
                return stConnectDevice.getTerminalType() == i;
            }
        }).collect(Collectors.toList());
    }

    public List<StConnectDevice> getConnectDeviceByWifiMac(final String str) {
        return (List) this.mConnectDeviceMap.values().stream().filter(new Predicate<StConnectDevice>() {
            public boolean test(StConnectDevice stConnectDevice) {
                return str.equals(stConnectDevice.getWifiMac());
            }
        }).collect(Collectors.toList());
    }

    public int getConnectProtocol(int i) {
        if (i == 1 || i == 2) {
            return 1;
        }
        if (i == 8 || i == 4) {
            return 2;
        }
        if (i == 16 || i == 32) {
            return 4;
        }
        if (i == 64) {
            return 512;
        }
        if (i == 512) {
            return 16;
        }
        return i;
    }

    public List<StConnectDevice> getConnectedDevice() {
        return (List) this.mConnectDeviceMap.values().stream().filter(new Predicate<StConnectDevice>() {
            public boolean test(StConnectDevice stConnectDevice) {
                return stConnectDevice.isBleConnected() || stConnectDevice.isP2pConnected();
            }
        }).collect(Collectors.toList());
    }

    public List<StConnectDevice> getConnectedDeviceByTerminal(final int i) {
        return (List) this.mConnectDeviceMap.values().stream().filter(new Predicate<StConnectDevice>() {
            public boolean test(StConnectDevice stConnectDevice) {
                return stConnectDevice.getTerminalType() == i && (stConnectDevice.isBleConnected() || stConnectDevice.isP2pConnected());
            }
        }).collect(Collectors.toList());
    }

    public List<StConnectDevice> getConnectedDevices() {
        return (List) this.mConnectDeviceMap.values().stream().filter(new Predicate<StConnectDevice>() {
            public boolean test(StConnectDevice stConnectDevice) {
                return stConnectDevice.isConnected();
            }
        }).collect(Collectors.toList());
    }

    public List<StConnectDevice> getConnectedDevicesBySpecialDevice(final String str) {
        return (List) this.mConnectDeviceMap.values().stream().filter(new Predicate<StConnectDevice>() {
            public boolean test(StConnectDevice stConnectDevice) {
                return stConnectDevice.isBleConnected() && str.equals(stConnectDevice.getCategoryID());
            }
        }).collect(Collectors.toList());
    }

    public StConnectDevice getCurBondInfo() {
        return StarryNetData.getInstance().getOwnDevice().getTerminalType() == 3 ? this.mConnectDeviceMap.values().stream().sorted(new Comparator<StConnectDevice>() {
            public int compare(StConnectDevice stConnectDevice, StConnectDevice stConnectDevice2) {
                return Long.compare(stConnectDevice2.getDate(), stConnectDevice.getDate());
            }
        }).filter(new Predicate<StConnectDevice>() {
            public boolean test(StConnectDevice stConnectDevice) {
                if (stConnectDevice.getTerminalType() == 1 && stConnectDevice.getBleBondStatus() == 4) {
                    return true;
                }
                return false;
            }
        }).findFirst().orElse((Object) null) : this.mConnectDeviceMap.values().stream().sorted(new Comparator<StConnectDevice>() {
            public int compare(StConnectDevice stConnectDevice, StConnectDevice stConnectDevice2) {
                return Long.compare(stConnectDevice2.getDate(), stConnectDevice.getDate());
            }
        }).filter(new Predicate<StConnectDevice>() {
            public boolean test(StConnectDevice stConnectDevice) {
                if (stConnectDevice.getTerminalType() != 5 && stConnectDevice.getBleBondStatus() == 4) {
                    return true;
                }
                return false;
            }
        }).findFirst().orElse((Object) null);
    }

    public StConnectDevice getCurIosDevice() {
        return this.mConnectDeviceMap.values().stream().sorted(new Comparator<StConnectDevice>() {
            public int compare(StConnectDevice stConnectDevice, StConnectDevice stConnectDevice2) {
                return Long.compare(stConnectDevice2.getDate(), stConnectDevice.getDate());
            }
        }).filter(new Predicate<StConnectDevice>() {
            public boolean test(StConnectDevice stConnectDevice) {
                return stConnectDevice.getTerminalType() == 6;
            }
        }).findFirst().orElse((Object) null);
    }

    public StDevice getDevice(byte[] bArr) {
        String byte2String = byte2String(bArr);
        if (TextUtils.isEmpty(byte2String)) {
            return null;
        }
        StConnectDevice stConnectDevice = this.mConnectDeviceMap.get(byte2String);
        if (stConnectDevice != null) {
            return stConnectDevice.getDevice();
        }
        StDiscoveryDevice device = this.mDiscoveryMgr.getDevice(bArr);
        if (device != null) {
            return device.clone();
        }
        return null;
    }

    public StDevice getDeviceByBleMac(String str) {
        return this.mDiscoveryMgr.getDeviceByBleMac(str);
    }

    public StDiscoveryDevice getDiscoveryDevice(byte[] bArr) {
        return this.mDiscoveryMgr.getDevice(bArr);
    }

    public List<StDiscoveryDevice> getDiscoveryDevices() {
        return this.mDiscoveryMgr.getDevices();
    }

    public List<StConnectDevice> getP2pConnectedDevices() {
        return (List) this.mConnectDeviceMap.values().stream().filter(new Predicate<StConnectDevice>() {
            public boolean test(StConnectDevice stConnectDevice) {
                return stConnectDevice.isP2pConnected();
            }
        }).collect(Collectors.toList());
    }

    public List<StConnectDevice> getSppConnectedDevices() {
        return (List) this.mConnectDeviceMap.values().stream().filter(new Predicate<StConnectDevice>() {
            public boolean test(StConnectDevice stConnectDevice) {
                return stConnectDevice.isSppConnected();
            }
        }).collect(Collectors.toList());
    }

    public /* bridge */ /* synthetic */ void goCreated(GoInfo goInfo) {
        super.goCreated(goInfo);
    }

    public /* bridge */ /* synthetic */ void goRemoved() {
        super.goRemoved();
    }

    public void init(final IStarryDeviceCallback iStarryDeviceCallback) {
        this.mBondManager.init(new IStarryDeviceCallback() {
            public void onLoadFinish() {
                StarryDeviceManager.this.loadBondInfo();
                IStarryDeviceCallback iStarryDeviceCallback = iStarryDeviceCallback;
                if (iStarryDeviceCallback != null) {
                    iStarryDeviceCallback.onLoadFinish();
                }
            }
        });
    }

    public void insertBondInfo(StConnectDevice stConnectDevice) {
        if (stConnectDevice != null) {
            synchronized (this) {
                try {
                    stConnectDevice.setDate(System.currentTimeMillis());
                    StConnectDevice stConnectDevice2 = this.mConnectDeviceMap.get(stConnectDevice.getIdentifier2String());
                    if (stConnectDevice2 == null) {
                        this.mConnectDeviceMap.put(stConnectDevice.getIdentifier2String(), stConnectDevice);
                    } else if (stConnectDevice2 != stConnectDevice) {
                        stConnectDevice2.setDevice(stConnectDevice.getDevice());
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            this.mBondManager.addBondInfo2Database(stConnectDevice);
        }
    }

    public /* bridge */ /* synthetic */ boolean isBleLinked(String str) {
        return super.isBleLinked(str);
    }

    public void loseDevice(String str) {
        onLose(str);
    }

    public /* bridge */ /* synthetic */ void notifyBondChange(StConnectDevice stConnectDevice, int i, int i2) {
        super.notifyBondChange(stConnectDevice, i, i2);
    }

    public void onLose(String str) {
        StDiscoveryDevice removeDevice = this.mDiscoveryMgr.removeDevice(str);
        if (removeDevice != null) {
            onLose(removeDevice);
        }
    }

    public /* bridge */ /* synthetic */ void p2pConnectForDiscovery(StConnectDevice stConnectDevice, boolean z) {
        super.p2pConnectForDiscovery(stConnectDevice, z);
    }

    public /* bridge */ /* synthetic */ void removeAuthCallback(IAuthCallback iAuthCallback) {
        super.removeAuthCallback(iAuthCallback);
    }

    public /* bridge */ /* synthetic */ void removeConnectCallback(IConnectCallback iConnectCallback) {
        super.removeConnectCallback(iConnectCallback);
    }

    public /* bridge */ /* synthetic */ void removeDelayLoseDevice(String str) {
        super.removeDelayLoseDevice(str);
    }

    public /* bridge */ /* synthetic */ void removeDiscoveryInterceptor(IDiscoveryInterceptor iDiscoveryInterceptor) {
        super.removeDiscoveryInterceptor(iDiscoveryInterceptor);
    }

    public /* bridge */ /* synthetic */ void removeDiscoveryListener(IDiscoveryListener iDiscoveryListener) {
        super.removeDiscoveryListener(iDiscoveryListener);
    }

    public /* bridge */ /* synthetic */ void setDiscoveryConnectCallback(IDiscoveryConnectCallback iDiscoveryConnectCallback) {
        super.setDiscoveryConnectCallback(iDiscoveryConnectCallback);
    }

    public void updateBondInfo(StConnectDevice stConnectDevice) {
        if (stConnectDevice != null) {
            synchronized (this) {
                try {
                    stConnectDevice.setDate(System.currentTimeMillis());
                    StConnectDevice stConnectDevice2 = this.mConnectDeviceMap.get(stConnectDevice.getIdentifier2String());
                    if (stConnectDevice2 == null) {
                        this.mConnectDeviceMap.put(stConnectDevice.getIdentifier2String(), stConnectDevice);
                    } else if (stConnectDevice2 != stConnectDevice) {
                        stConnectDevice2.setDevice(stConnectDevice.getDevice());
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            if (stConnectDevice.getStatus() == 0) {
                this.mBondManager.removeBondInfo2Database(stConnectDevice);
            } else {
                this.mBondManager.updateBondInfo2Database(stConnectDevice);
            }
        }
    }

    public void updateBrEdrBondState(StConnectDevice stConnectDevice, int i, int i2) {
        if (stConnectDevice != null) {
            synchronized (this) {
                try {
                    stConnectDevice.setStatus(i);
                    stConnectDevice.setDate(System.currentTimeMillis());
                    StConnectDevice stConnectDevice2 = this.mConnectDeviceMap.get(stConnectDevice.getIdentifier2String());
                    if (stConnectDevice2 == null) {
                        this.mConnectDeviceMap.put(stConnectDevice.getIdentifier2String(), stConnectDevice);
                    } else if (stConnectDevice2 != stConnectDevice) {
                        stConnectDevice2.setDevice(stConnectDevice.getDevice());
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            if (stConnectDevice.getStatus() == 0) {
                this.mBondManager.removeBondInfo2Database(stConnectDevice);
            } else {
                this.mBondManager.updateBondInfo2Database(stConnectDevice);
            }
            notifyBondChange(stConnectDevice, i, i2);
        }
    }

    private StarryDeviceManager() {
        this.mConnectDeviceMap = new ConcurrentHashMap();
        this.mDiscoveryMgr = new DiscoveryDeviceManager();
        this.mBondManager = new StarryBondManager();
    }

    public StConnectDevice getConnectDevice(String str) {
        return this.mConnectDeviceMap.get(str);
    }

    @SuppressLint({"MissingPermission"})
    public StConnectDevice getConnectDevice(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return null;
        }
        StConnectDevice connectDevice = getConnectDevice(Utils.getBytesFromAddress(bluetoothDevice.getAddress()));
        if (connectDevice != null) {
            return connectDevice;
        }
        for (StConnectDevice next : this.mConnectDeviceMap.values()) {
            if (bluetoothDevice.getAddress().equals(next.getBrEdrMac())) {
                return next;
            }
        }
        byte terminalType = StarryNetData.getInstance().getOwnDevice().getTerminalType();
        if (terminalType != 1 && terminalType != 4) {
            return null;
        }
        StConnectDevice stConnectDevice = new StConnectDevice();
        stConnectDevice.setDeviceName(bluetoothDevice.getName());
        stConnectDevice.setTerminalType(getBluetoothDeviceType(bluetoothDevice));
        stConnectDevice.setBrEdrMac(bluetoothDevice.getAddress());
        stConnectDevice.setIdentifier(Utils.getBytesFromAddress(bluetoothDevice.getAddress()));
        insertBondInfo(stConnectDevice);
        return stConnectDevice;
    }

    public void updateBondInfo(StConnectDevice stConnectDevice, int i) {
        if (stConnectDevice == null || stConnectDevice.getIdentifier2String() == null) {
            StLog.d(TAG, "device or id is null");
            return;
        }
        int bleBondStatus = stConnectDevice.getBleBondStatus();
        synchronized (this) {
            try {
                stConnectDevice.setStatus(i);
                stConnectDevice.setDate(System.currentTimeMillis());
                if (stConnectDevice.getTerminalType() == 5) {
                    stConnectDevice.setBrEdrMac(stConnectDevice.getBleMac());
                }
                StConnectDevice stConnectDevice2 = this.mConnectDeviceMap.get(stConnectDevice.getIdentifier2String());
                if (stConnectDevice2 == null) {
                    this.mConnectDeviceMap.put(stConnectDevice.getIdentifier2String(), stConnectDevice);
                } else if (stConnectDevice2 != stConnectDevice) {
                    stConnectDevice2.setDevice(stConnectDevice.getDevice());
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (stConnectDevice.getStatus() == 0) {
            this.mBondManager.removeBondInfo2Database(stConnectDevice);
        } else {
            this.mBondManager.updateBondInfo2Database(stConnectDevice);
        }
        if (bleBondStatus != i) {
            notifyBondChange(stConnectDevice, i, bleBondStatus);
        }
    }
}
