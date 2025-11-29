package com.upuphone.starrynet.strategy.discovery.scanner;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelUuid;
import android.provider.Settings;
import androidx.annotation.RequiresApi;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.starrynet.api.StConfiguration;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.ReLog;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.Utils;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.SysActionManager;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import com.upuphone.starrynet.strategy.connector.IStarryNetConnector;
import com.upuphone.starrynet.strategy.connector.manager.PhoneStarryNetConnector;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.discovery.advertiser.codec.AdvDecoder;
import com.upuphone.starrynet.strategy.discovery.iccoa.IccoaAdvParser;
import com.upuphone.starrynet.strategy.utils.BleUtil;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SuppressLint({"MissingPermission"})
public class ScanManager {
    private static final String ENHANCED_SERVICE_CARLINK_SWITCHER = "flyme_fake_enhanced_service_com.upuphone.carlink";
    private static final String ENHANCED_SERVICE_FLYME_LINK_SWITCHER = "flyme_fake_enhanced_service_com.flyme.linkUnion";
    private static final int ENHANCED_SERVICE_OPEN = 1;
    private static String MYVU_RING_OTA_NAME = "DFU Ring2";
    private static final String TAG = "ScanManager";
    private final List<ScanFilter> lstRingScanFilter = new ArrayList();
    private final List<ScanFilter> lstScanFilter = new ArrayList();
    private BluetoothAdapter mAdapter;
    /* access modifiers changed from: private */
    public boolean mCarLinkOpened = false;
    private final Context mContext;
    /* access modifiers changed from: private */
    public boolean mFlymeLinkOpened = true;
    private final ScanCallback mHighFreqRingScanCallback;
    private final ScanCallback mHighFreqScanCallback;
    private final ScanSettings mHighFreqScanSettings;
    /* access modifiers changed from: private */
    public boolean mIsMzPhone = false;
    private final ScanCallback mLowPowerScanCallback;
    private final ScanSettings mLowPowerScanSettings;
    private final StarryNetData mParser;
    /* access modifiers changed from: private */
    public int mRestartScanCount;
    private BluetoothLeScanner mScanner;

    public class DiscoveryRingScanCallback extends ScanCallback {
        private DiscoveryRingScanCallback() {
        }

        private byte[] getDFURingManuInfo(ScanResult scanResult, int i) {
            byte[] manufacturerSpecificData = scanResult.getScanRecord().getManufacturerSpecificData(i);
            if (manufacturerSpecificData == null) {
                return null;
            }
            return getRealIdentifier(manufacturerSpecificData);
        }

        private byte[] getRealIdentifier(byte[] bArr) {
            byte[] dealDeviceId = BleUtil.dealDeviceId(bArr);
            dealDeviceId[3] = (byte) (dealDeviceId[3] - 1);
            return dealDeviceId;
        }

        public void onBatchScanResults(List<ScanResult> list) {
            super.onBatchScanResults(list);
            StLog.v(ScanManager.TAG, "onBatchScanResults, not support!");
        }

        public void onScanFailed(int i) {
            super.onScanFailed(i);
            StLog.i(ScanManager.TAG, "onScanFailed : " + i + "restart count: " + ScanManager.this.mRestartScanCount);
            if (i == 2 && ScanManager.this.mRestartScanCount < 2) {
                ScanManager.this.startHighFreqScan(true);
                ScanManager.access$608(ScanManager.this);
            }
        }

        public void onScanResult(int i, ScanResult scanResult) {
            String str;
            StDiscoveryDevice stDiscoveryDevice = new StDiscoveryDevice();
            StringBuilder sb = new StringBuilder(scanResult.getDevice().getAddress().replace(AccountConstantKt.CODE_SEPARTOR, "").toUpperCase());
            stDiscoveryDevice.setDeviceName((scanResult.getScanRecord().getDeviceName() + " ") + sb.substring(8, 12));
            stDiscoveryDevice.setTerminalType((byte) 5);
            stDiscoveryDevice.setVersion((byte) 3);
            byte[] dFURingManuInfo = getDFURingManuInfo(scanResult, BleUtil.MANU_OTA_RING);
            if (scanResult.getScanRecord().getManufacturerSpecificData(BleUtil.MANU_OTA_INTL_RING) != null) {
                dFURingManuInfo = scanResult.getScanRecord().getManufacturerSpecificData(BleUtil.MANU_OTA_INTL_RING);
                str = "1202";
            } else {
                str = "1201";
            }
            if (dFURingManuInfo == null) {
                StLog.w(ScanManager.TAG, "invalid dfu device: " + scanResult.getDevice().getName());
                return;
            }
            stDiscoveryDevice.setModelID(str);
            stDiscoveryDevice.setCategoryID("0003");
            stDiscoveryDevice.setCategoryName("Ring");
            stDiscoveryDevice.setCompanyID("0001");
            stDiscoveryDevice.setCompanyName("XINGJI");
            stDiscoveryDevice.setStatus(5);
            stDiscoveryDevice.setIdentifier(dFURingManuInfo);
            stDiscoveryDevice.setBleMac(scanResult.getDevice().getAddress());
            stDiscoveryDevice.setBrEdrMac(scanResult.getDevice().getAddress());
            stDiscoveryDevice.setDeviceType((byte) 1);
            stDiscoveryDevice.setRssi(scanResult.getRssi());
            stDiscoveryDevice.setModelName("MYVURing");
            StLog.d(ScanManager.TAG, "an OTA ring(%s) is found: " + stDiscoveryDevice.getDeviceName(), str);
            StarryDeviceManager.getInstance().discoveryDevice(stDiscoveryDevice);
        }
    }

    public class DiscoveryScanCallback extends ScanCallback {
        private DiscoveryScanCallback() {
        }

        public void onBatchScanResults(List<ScanResult> list) {
            super.onBatchScanResults(list);
            StLog.v(ScanManager.TAG, "onBatchScanResults, not support!");
        }

        public void onScanFailed(int i) {
            super.onScanFailed(i);
            StLog.i(ScanManager.TAG, "onScanFailed : " + i + "restart count: " + ScanManager.this.mRestartScanCount);
            if (i == 2 && ScanManager.this.mRestartScanCount < 2) {
                ScanManager.this.startHighFreqScan(true);
                ScanManager.access$608(ScanManager.this);
            }
        }

        public void onScanResult(int i, ScanResult scanResult) {
            byte[] identifier;
            super.onScanResult(i, scanResult);
            if (scanResult == null || scanResult.getScanRecord() == null) {
                StLog.d(ScanManager.TAG, "Result null");
                return;
            }
            ScanRecord scanRecord = scanResult.getScanRecord();
            List<ParcelUuid> serviceUuids = scanRecord.getServiceUuids();
            int i2 = 0;
            boolean z = serviceUuids != null && serviceUuids.contains(BleUtil.ICCOA_ADV_SERVICE_UUID);
            if (ScanManager.this.mIsMzPhone) {
                if (z) {
                    if (!ScanManager.this.mCarLinkOpened) {
                        ReLog.v(ScanManager.TAG, "is iccoa device ,but carlink closed.");
                        return;
                    }
                } else if (!ScanManager.this.mFlymeLinkOpened) {
                    ReLog.v(ScanManager.TAG, "is flymelink device,but flymelink closed");
                    return;
                }
            }
            StDiscoveryDevice stDiscoveryDevice = new StDiscoveryDevice();
            stDiscoveryDevice.setBleMac(scanResult.getDevice().getAddress());
            stDiscoveryDevice.setRssi(scanResult.getRssi());
            stDiscoveryDevice.setCallbackType(i);
            stDiscoveryDevice.setBluetoothDevice(scanResult.getDevice());
            if (serviceUuids != null && serviceUuids.contains(BleUtil.UUP_SHARE_ADV_SERVICE_UUID)) {
                stDiscoveryDevice.setDeviceType((byte) 2);
                try {
                    ScanManager.this.decodeUupShareScanData(stDiscoveryDevice, scanRecord.getServiceData());
                } catch (Exception e) {
                    StLog.e(ScanManager.TAG, "Decode Data Error", (Throwable) e);
                }
                StarryDeviceManager.getInstance().discoveryDevice(stDiscoveryDevice);
            } else if (!z) {
                byte[] manufacturerSpecificData = scanResult.getScanRecord().getManufacturerSpecificData(3025);
                byte[] manufacturerSpecificData2 = scanResult.getScanRecord().getManufacturerSpecificData(BleUtil.MANU_RESPONSE_ID);
                if (manufacturerSpecificData != null && manufacturerSpecificData.length >= 13 && manufacturerSpecificData2 != null) {
                    if (manufacturerSpecificData[0] > StarryNetData.getInstance().getVersionCode()) {
                        StLog.d(ScanManager.TAG, "onScanResult device version is higher, device = " + stDiscoveryDevice);
                        return;
                    }
                    stDiscoveryDevice.setDeviceType((byte) 1);
                    if (AdvDecoder.decodeAdvData(stDiscoveryDevice, manufacturerSpecificData) && (identifier = stDiscoveryDevice.getIdentifier()) != null && identifier.length >= 6 && AdvDecoder.decodeResponseData(stDiscoveryDevice, manufacturerSpecificData2)) {
                        stDiscoveryDevice.setBrEdrMac(Utils.getAddressStringFromByte(identifier));
                        stDiscoveryDevice.setRssi(scanResult.getRssi());
                        if (stDiscoveryDevice.getTerminalType() == 5) {
                            byte terminalType = StarryNetData.getInstance().getOwnDevice().getTerminalType();
                            if (!stDiscoveryDevice.getModelID().equals(StarryNetData.MODEL_ID_RING_1) || !(terminalType == 1 || terminalType == 4)) {
                                byte[] bytes = scanRecord.getBytes();
                                if (bytes != null && scanRecord.getDeviceName() != null) {
                                    while (true) {
                                        int i3 = i2 + 1;
                                        if (i3 >= bytes.length) {
                                            break;
                                        }
                                        byte b = bytes[i2];
                                        if (bytes[i3] == 9 && b >= 1) {
                                            int i4 = i2 + 2;
                                            stDiscoveryDevice.setRingName(Arrays.copyOfRange(bytes, i4, (b + i4) - 1), true);
                                            StLog.d(ScanManager.TAG, "set ring byte name");
                                            break;
                                        }
                                        i2 = i3 + b;
                                    }
                                }
                                if (!stDiscoveryDevice.getRingName().equals("")) {
                                    stDiscoveryDevice.setDeviceName(stDiscoveryDevice.getRingName());
                                } else if (!stDiscoveryDevice.getModelName().equals("Unicron")) {
                                    if (scanRecord.getDeviceName() != null) {
                                        stDiscoveryDevice.setDeviceName(scanRecord.getDeviceName());
                                        StLog.d(ScanManager.TAG, "old version complete ring name: " + stDiscoveryDevice.getDeviceName());
                                        if (stDiscoveryDevice.getTerminalType() == 5) {
                                            stDiscoveryDevice.setIdentifier(Arrays.copyOfRange(manufacturerSpecificData, 7, 13));
                                        }
                                    } else {
                                        int unsignedInt = Byte.toUnsignedInt(stDiscoveryDevice.getAdvType());
                                        if (unsignedInt == 64) {
                                            stDiscoveryDevice.setStatus(3);
                                        } else if (unsignedInt == 160) {
                                            stDiscoveryDevice.setStatus(1);
                                        } else {
                                            StLog.e(ScanManager.TAG, "ring adv mode not defined");
                                        }
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        StarryDeviceManager.getInstance().discoveryDevice(stDiscoveryDevice);
                    }
                }
            } else if (!SysActionManager.getInstance().isBtOn()) {
                StLog.i(ScanManager.TAG, "Only check on bt on");
            } else {
                if (IccoaAdvParser.parseScanRecord(scanResult, stDiscoveryDevice, ScanManager.this.mIsMzPhone ? StConfiguration.getIccoaBlackList() : null)) {
                    stDiscoveryDevice.setDeviceType((byte) 3);
                    stDiscoveryDevice.setDiscType((byte) 1);
                    stDiscoveryDevice.setTerminalType((byte) 3);
                    StarryDeviceManager.getInstance().discoveryDevice(stDiscoveryDevice);
                }
            }
        }
    }

    public ScanManager(Context context) {
        this.mContext = context;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mAdapter = defaultAdapter;
        this.mScanner = defaultAdapter.getBluetoothLeScanner();
        this.mHighFreqScanSettings = new ScanSettings.Builder().setScanMode(1).setCallbackType(1).setMatchMode(1).build();
        this.mLowPowerScanSettings = new ScanSettings.Builder().setScanMode(0).setCallbackType(1).setMatchMode(2).build();
        this.mLowPowerScanCallback = new DiscoveryScanCallback();
        this.mHighFreqScanCallback = new DiscoveryScanCallback();
        this.mHighFreqRingScanCallback = new DiscoveryRingScanCallback();
        this.mParser = StarryNetData.getInstance();
        if (StarryNetData.getInstance().getOwnDevice().getTerminalType() == 1) {
            this.mIsMzPhone = true;
            this.mFlymeLinkOpened = isFlymeLinkOpened();
            this.mCarLinkOpened = isCarLinkOpened();
            startListenEnhanceServiceChange();
        }
    }

    public static /* synthetic */ int access$608(ScanManager scanManager) {
        int i = scanManager.mRestartScanCount;
        scanManager.mRestartScanCount = i + 1;
        return i;
    }

    /* access modifiers changed from: private */
    public void decodeUupShareScanData(StDevice stDevice, Map<ParcelUuid, byte[]> map) throws UnsupportedEncodingException, ArrayIndexOutOfBoundsException {
        char c;
        byte[] bArr;
        StDevice stDevice2 = stDevice;
        if (map == null) {
            StLog.d(TAG, "serviceData null");
            return;
        }
        byte[] bArr2 = new byte[16];
        for (Map.Entry next : map.entrySet()) {
            ParcelUuid parcelUuid = (ParcelUuid) next.getKey();
            byte[] bArr3 = (byte[]) next.getValue();
            if (bArr3.length < 7) {
                long mostSignificantBits = parcelUuid.getUuid().getMostSignificantBits();
                byte[] bArr4 = bArr2;
                stDevice2.setCompanyName(this.mParser.getUupShareCompanyName((byte) ((int) ((mostSignificantBits >> 32) & 255))));
                byte b = (byte) ((int) ((mostSignificantBits >> 40) & 255));
                stDevice2.setSupport5G((b & 1) == 1);
                stDevice2.setSupportBleEncrypt((b & 2) == 2);
                bArr = bArr4;
                System.arraycopy(bArr3, 0, bArr, 0, 6);
                c = 16;
            } else {
                bArr = bArr2;
                long mostSignificantBits2 = parcelUuid.getUuid().getMostSignificantBits();
                stDevice2.setUupShareModelID(new byte[]{(byte) ((int) ((mostSignificantBits2 >> 32) & 255)), (byte) ((int) ((mostSignificantBits2 >> 40) & 255))});
                System.arraycopy(bArr3, 0, bArr, 6, 10);
                stDevice2.setIdentifier(bArr);
                stDevice2.setUupShareDeviceID(bArr);
                byte[] bArr5 = new byte[16];
                c = 16;
                System.arraycopy(bArr3, 10, bArr5, 0, 16);
                stDevice2.setDeviceName(new String(bArr5, StandardCharsets.UTF_8));
                stDevice2.setVersion(bArr3[26]);
            }
            bArr2 = bArr;
            char c2 = c;
        }
    }

    private boolean isBluetoothEnabled() {
        if (this.mAdapter == null) {
            this.mAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        BluetoothAdapter bluetoothAdapter = this.mAdapter;
        return bluetoothAdapter != null && bluetoothAdapter.isEnabled();
    }

    /* access modifiers changed from: private */
    public boolean isCarLinkOpened() {
        return Settings.System.getInt(StarryNetData.getInstance().getApplicationContext().getContentResolver(), ENHANCED_SERVICE_CARLINK_SWITCHER, 1) == 1;
    }

    /* access modifiers changed from: private */
    public boolean isFlymeLinkOpened() {
        return Settings.System.getInt(StarryNetData.getInstance().getApplicationContext().getContentResolver(), ENHANCED_SERVICE_FLYME_LINK_SWITCHER, 1) == 1;
    }

    private void startListenEnhanceServiceChange() {
        AnonymousClass1 r0 = new ContentObserver(new Handler(Looper.getMainLooper())) {
            @RequiresApi
            public void onChange(boolean z) {
                ScanManager scanManager = ScanManager.this;
                boolean unused = scanManager.mFlymeLinkOpened = scanManager.isFlymeLinkOpened();
                StLog.d(ScanManager.TAG, "startListenEnhanceServiceChange ,selfChange=" + z + ",flymeLink isOpen = " + ScanManager.this.mFlymeLinkOpened);
                if (!ScanManager.this.mFlymeLinkOpened) {
                    IStarryNetConnector connectManager = StarryNetData.getInstance().getConnectManager();
                    if (connectManager instanceof PhoneStarryNetConnector) {
                        ((PhoneStarryNetConnector) connectManager).disconnectAllConnection();
                    }
                }
            }
        };
        ContentResolver contentResolver = StarryNetData.getInstance().getApplicationContext().getContentResolver();
        contentResolver.registerContentObserver(Settings.System.getUriFor(ENHANCED_SERVICE_FLYME_LINK_SWITCHER), true, r0);
        contentResolver.registerContentObserver(Settings.System.getUriFor(ENHANCED_SERVICE_CARLINK_SWITCHER), true, new ContentObserver(new Handler()) {
            public void onChange(boolean z) {
                ScanManager scanManager = ScanManager.this;
                boolean unused = scanManager.mCarLinkOpened = scanManager.isCarLinkOpened();
                StLog.d(ScanManager.TAG, "startListenEnhanceServiceChange ,selfChange=" + z + ",carLink isOpen = " + ScanManager.this.mCarLinkOpened);
            }
        });
    }

    public void onBluetoothDisabled() {
    }

    public void onBluetoothEnabled() {
        BluetoothAdapter bluetoothAdapter;
        if (this.mAdapter == null) {
            this.mAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        if (this.mScanner == null && (bluetoothAdapter = this.mAdapter) != null) {
            this.mScanner = bluetoothAdapter.getBluetoothLeScanner();
        }
    }

    public void onUupShareDisabled() {
    }

    public void onUupShareEnabled() {
    }

    public boolean startHighFreqScan() {
        return startHighFreqScan(false);
    }

    public boolean startLowPowerBackgroundScan() {
        stopLowPowerBackgroundScan();
        this.lstScanFilter.clear();
        if (isBluetoothEnabled()) {
            byte terminalType = StarryNetData.getInstance().getOwnDevice().getTerminalType();
            byte[] identifier = StarryNetData.getInstance().getIdentifier();
            if (terminalType != 1 || SysActionManager.getInstance().isScreenOn()) {
                this.lstScanFilter.add(new ScanFilter.Builder().setManufacturerData(3025, BleUtil.TYPE_ALL).build());
            } else {
                ScanFilter.Builder builder = new ScanFilter.Builder();
                this.lstScanFilter.add(builder.setManufacturerData(BleUtil.MANU_RESPONSE_ID, new byte[]{0, identifier[0], identifier[1], identifier[2], identifier[3], identifier[4], identifier[5]}, new byte[]{0, -1, -1, -1, -1, -1, -1}).build());
            }
            if (terminalType == 1) {
                this.lstScanFilter.add(new ScanFilter.Builder().setServiceUuid(BleUtil.ICCOA_ADV_SERVICE_UUID).build());
            }
            if (this.mScanner != null) {
                try {
                    StLog.d(TAG, "startLowPowerBackgroundScan");
                    this.mScanner.startScan(this.lstScanFilter, this.mLowPowerScanSettings, this.mLowPowerScanCallback);
                    return true;
                } catch (IllegalStateException e) {
                    StLog.w(TAG, "startLowPowerBackgroundScan", (Throwable) e);
                }
            }
        }
        return false;
    }

    public void stopHighFreqScan() {
        if (!isBluetoothEnabled()) {
            StLog.d(TAG, "stopHighFreqScan bt off");
            return;
        }
        StLog.d(TAG, "stopHighFreqScan");
        if (this.mScanner != null) {
            byte terminalType = StarryNetData.getInstance().getOwnDevice().getTerminalType();
            try {
                this.mScanner.stopScan(this.mHighFreqScanCallback);
                if (terminalType == 4 || terminalType == 1) {
                    this.mScanner.stopScan(this.mHighFreqRingScanCallback);
                }
            } catch (IllegalStateException e) {
                StLog.w(TAG, "stopHighFreqScan", (Throwable) e);
            }
        }
    }

    public void stopLowPowerBackgroundScan() {
        if (!isBluetoothEnabled()) {
            StLog.d(TAG, "stopLowPowerBackgroundScan bt off");
            return;
        }
        StLog.d(TAG, "stopLowPowerBackgroundScan");
        BluetoothLeScanner bluetoothLeScanner = this.mScanner;
        if (bluetoothLeScanner != null) {
            try {
                bluetoothLeScanner.stopScan(this.mLowPowerScanCallback);
            } catch (IllegalStateException e) {
                StLog.w(TAG, "stopLowPowerBackgroundScan", (Throwable) e);
            }
        }
    }

    public boolean startHighFreqScan(boolean z) {
        if (!z) {
            this.mRestartScanCount = 0;
        }
        stopHighFreqScan();
        StLog.d(TAG, "startHighFreqBackgroundScan, point_ble_scan_start");
        this.lstScanFilter.clear();
        this.lstRingScanFilter.clear();
        if (isBluetoothEnabled()) {
            StLog.d(TAG, "startHighFreqBackgroundScan starry");
            this.lstScanFilter.add(new ScanFilter.Builder().setManufacturerData(3025, BleUtil.TYPE_ALL).build());
            ScanFilter build = new ScanFilter.Builder().setServiceUuid(ParcelUuid.fromString("0000FE59-0000-1000-8000-00805F9B34FB")).setManufacturerData(BleUtil.MANU_OTA_RING, new byte[0]).build();
            ScanFilter build2 = new ScanFilter.Builder().setServiceUuid(ParcelUuid.fromString("0000FE59-0000-1000-8000-00805F9B34FB")).setManufacturerData(BleUtil.MANU_OTA_INTL_RING, new byte[0]).build();
            this.lstRingScanFilter.add(build);
            this.lstRingScanFilter.add(build2);
            if (SysActionManager.getInstance().isUupShareOn()) {
                StLog.d(TAG, "startHighFreqBackgroundScan uup");
                this.lstScanFilter.add(new ScanFilter.Builder().setServiceUuid(BleUtil.UUP_SHARE_ADV_SERVICE_UUID).build());
            }
            if (StarryNetData.getInstance().getOwnDevice().getTerminalType() == 1) {
                this.lstScanFilter.add(new ScanFilter.Builder().setServiceUuid(BleUtil.ICCOA_ADV_SERVICE_UUID).build());
            }
            if (this.mScanner != null) {
                byte terminalType = StarryNetData.getInstance().getOwnDevice().getTerminalType();
                try {
                    this.mScanner.startScan(this.lstScanFilter, this.mHighFreqScanSettings, this.mHighFreqScanCallback);
                    if (terminalType == 4 || terminalType == 1) {
                        this.mScanner.startScan(this.lstRingScanFilter, this.mHighFreqScanSettings, this.mHighFreqRingScanCallback);
                    }
                    return true;
                } catch (IllegalStateException e) {
                    StLog.w(TAG, "startHighFreqScan", (Throwable) e);
                }
            }
        } else {
            StLog.w(TAG, "BT is not on, can not start scan");
        }
        return false;
    }
}
