package com.upuphone.starrynet.strategy.service;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.tencent.mmkv.MMKV;
import com.upuphone.starrynet.api.IStarryNetApiCallback;
import com.upuphone.starrynet.api.IStarryNetConfig;
import com.upuphone.starrynet.api.IStarryService;
import com.upuphone.starrynet.api.StConfiguration;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.api.manager.IStarryConnectManager;
import com.upuphone.starrynet.api.manager.IStarryDiscoveryManager;
import com.upuphone.starrynet.api.manager.IStarryHidManager;
import com.upuphone.starrynet.api.manager.IStarryOperateManager;
import com.upuphone.starrynet.api.manager.IStarryTransferManager;
import com.upuphone.starrynet.common.ReLog;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.strategy.StarryNetController;
import com.upuphone.starrynet.strategy.bean.IDetailInfo;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.connector.IStarryNetConnector;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.discovery.IStarryNetDiscoverer;
import com.upuphone.starrynet.strategy.netstack.XdpLinkManager;
import com.upuphone.starrynet.strategy.operater.StarryNetOperator;
import com.upuphone.starrynet.strategy.receiver.BluetoothStateReceiver;
import com.upuphone.starrynet.third.manager.ThirdStarryNetConnector;
import com.upuphone.starrynet.third.manager.ThirdStarryNetDiscoverer;
import com.upuphone.starrynet.third.manager.ThirdStarryNetOperator;
import com.upuphone.starrynet.third.manager.ThirdStarryNetTransfer;
import java.util.List;

public final class ServiceBinder implements IStarryService {
    private static final String TAG = "ServiceBinder";
    private boolean isStartUp = false;
    /* access modifiers changed from: private */
    public final BluetoothStateReceiver mBtStateReceiver = new BluetoothStateReceiver();
    /* access modifiers changed from: private */
    public StarryNetConfigManager mConfigManager;
    private StarryConnectManager mConnectManager;
    private StarryDiscoveryManager mDiscoveryManager;
    private StarryOperateManager mOperateManager;
    /* access modifiers changed from: private */
    public long mServiceId = -1;
    private IStarryTransferManager mTransferManager;

    private IDetailInfo getDeviceDetail(byte[] bArr) {
        IDetailInfo disDeviceDetail = StarryNetController.getDisDeviceDetail(bArr);
        if (disDeviceDetail != null) {
            return disDeviceDetail;
        }
        ReLog.v(TAG, "getDeviceDetail device is null");
        return StarryNetController.getConnectDeviceDetailInfo(bArr);
    }

    private long getServiceId() {
        return this.mServiceId;
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "getVersionName", e);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void setConnectManager(IStarryNetConnector iStarryNetConnector) {
        this.mConnectManager = new StarryConnectManager(iStarryNetConnector);
    }

    /* access modifiers changed from: private */
    public void setDiscoveryManager(IStarryNetDiscoverer iStarryNetDiscoverer) {
        this.mDiscoveryManager = new StarryDiscoveryManager(iStarryNetDiscoverer);
    }

    /* access modifiers changed from: private */
    public void setOperateManager(StarryNetOperator starryNetOperator) {
        this.mOperateManager = new StarryOperateManager(starryNetOperator);
    }

    /* access modifiers changed from: private */
    public void setTransferManager(IStarryTransferManager iStarryTransferManager) {
        this.mTransferManager = iStarryTransferManager;
    }

    private void startUpSystem(short s) {
        StLog.d(TAG, "startUp");
        StarryDiscoveryManager starryDiscoveryManager = this.mDiscoveryManager;
        if (starryDiscoveryManager != null) {
            starryDiscoveryManager.startUp(s);
        }
    }

    public List<StDevice> getBondedDevices() {
        return StarryNetController.getBondDevices();
    }

    public List<StDevice> getConnectedDevices(int i) {
        return StarryNetController.getConnectedDevices(i);
    }

    public String getDeviceDetailInfo(byte[] bArr, int i) {
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(bArr);
        StDevice discoveryDevice = StarryDeviceManager.getInstance().getDiscoveryDevice(bArr);
        if (connectDevice == null && discoveryDevice == null) {
            discoveryDevice = getOwnDevice();
            if (!ByteUtils.equals(bArr, discoveryDevice.getIdentifier())) {
                return null;
            }
        } else if (connectDevice != null && (connectDevice.isBleConnected() || connectDevice.isP2pConnected() || discoveryDevice == null)) {
            discoveryDevice = connectDevice.getDevice();
        }
        IDetailInfo deviceDetail = getDeviceDetail(bArr);
        String str = "";
        switch (i) {
            case 0:
                return discoveryDevice.getDeviceName();
            case 1:
                return discoveryDevice.getCompanyID();
            case 2:
                return discoveryDevice.getCompanyName();
            case 3:
                return discoveryDevice.getCategoryID();
            case 4:
                return discoveryDevice.getCategoryName();
            case 5:
                return discoveryDevice.getModelID();
            case 6:
                return discoveryDevice.getModelName();
            case 7:
                return discoveryDevice.getWifiMac();
            case 8:
                return discoveryDevice.getBrEdrMac();
            case 11:
                return deviceDetail != null ? deviceDetail.getCarVendorData() : str;
            case 12:
                return deviceDetail != null ? deviceDetail.getCarVendorId() : str;
            case 13:
                return deviceDetail != null ? deviceDetail.getCarProductId() : str;
            case 14:
                return deviceDetail != null ? String.valueOf(deviceDetail.getCarProtocolVersion()) : str;
            case 15:
                return deviceDetail != null ? deviceDetail.getCarName() : str;
            case 16:
                if (deviceDetail != null) {
                    str = deviceDetail.getCarPinCode();
                }
                StLog.e(TAG, "pincode is " + str);
                return str;
            case 17:
                return deviceDetail != null ? deviceDetail.getIccoaSerialNum() : str;
            case 18:
                return deviceDetail != null ? String.valueOf(deviceDetail.getConnectVersion()) : str;
            case 19:
                if (deviceDetail == null) {
                    return str;
                }
                return String.valueOf(StConfiguration.getCarWithPadList().contains(discoveryDevice.getModelID()) && deviceDetail.getConnectVersion() >= 3);
            case 20:
                return deviceDetail != null ? String.valueOf(deviceDetail.getICCOAPhoneBtMacCRC16()) : str;
            default:
                return str;
        }
    }

    public int getDeviceState(byte[] bArr, int i) {
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(bArr);
        if (connectDevice == null) {
            return 0;
        }
        if (i == 1) {
            return connectDevice.getBleBondStatus();
        }
        if (i == 2) {
            return connectDevice.getBrEdrBondStatus();
        }
        if (i != 10) {
            return 0;
        }
        return connectDevice.getProtocolStatus();
    }

    public StDevice getOwnDevice() {
        return StarryNetController.getOwnerDevice();
    }

    public StDevice getStDevice(byte[] bArr) {
        return StarryNetController.getStDevice(bArr);
    }

    public IStarryConnectManager getStarryConnectManager() {
        return this.mConnectManager;
    }

    public IStarryDiscoveryManager getStarryDiscoveryManager() {
        return this.mDiscoveryManager;
    }

    public IStarryHidManager getStarryHidManager() {
        return StarryHidManager.getInstance();
    }

    public IStarryNetConfig getStarryNetConfig() {
        return this.mConfigManager;
    }

    public IStarryOperateManager getStarryOperateManager() {
        return this.mOperateManager;
    }

    public IStarryTransferManager getStarryTransferManager() {
        return this.mTransferManager;
    }

    public void init(final Context context, final IStarryNetApiCallback iStarryNetApiCallback) {
        MMKV.y(context);
        try {
            XdpLinkManager.getInstance().init(context);
        } catch (Exception e) {
            StLog.d(TAG, "XdpLinkManager init failed:" + e.toString());
        }
        StarryNetController.init(context, (byte) 4, new StarryNetController.IStarryNetInitCallback() {
            public void onInit() {
                ServiceBinder.this.setDiscoveryManager(new ThirdStarryNetDiscoverer());
                ServiceBinder.this.setConnectManager(new ThirdStarryNetConnector());
                ServiceBinder.this.setTransferManager(new ThirdStarryNetTransfer());
                ServiceBinder.this.setOperateManager(new ThirdStarryNetOperator());
                StarryNetConfigManager unused = ServiceBinder.this.mConfigManager = new StarryNetConfigManager();
                BluetoothStateReceiver.registerReceiver(context, ServiceBinder.this.mBtStateReceiver);
                StarryHidManager.getInstance().init(context);
                long unused2 = ServiceBinder.this.mServiceId = System.currentTimeMillis();
                IStarryNetApiCallback iStarryNetApiCallback = iStarryNetApiCallback;
                if (iStarryNetApiCallback != null) {
                    iStarryNetApiCallback.onInit();
                }
            }
        });
    }

    public long startUp() {
        return startUp(0);
    }

    public long startUp(short s) {
        StLog.d(TAG, "startUp ability " + s);
        if (this.isStartUp) {
            StLog.d(TAG, "start up again");
            return getServiceId();
        }
        this.isStartUp = true;
        long serviceId = getServiceId();
        if (serviceId < 0) {
            StLog.d(TAG, "server is not really");
            return serviceId;
        }
        startUpSystem(s);
        return serviceId;
    }
}
