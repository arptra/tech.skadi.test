package com.upuphone.starrynet.strategy.protocol.iccoa;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.honey.account.i7.a;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ap.WiFiApInfo;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.SysActionManager;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import com.upuphone.starrynet.strategy.channel.IConnectChannel;
import com.upuphone.starrynet.strategy.channel.IMessageChannel;
import com.upuphone.starrynet.strategy.channel.IStarryNetChannel;
import com.upuphone.starrynet.strategy.channel.StarryNetChannelManager;
import com.upuphone.starrynet.strategy.channel.ap.StaChannel;
import com.upuphone.starrynet.strategy.channel.iccoa.IccoaChannel;
import com.upuphone.starrynet.strategy.channel.p2p.GcChannel;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.discovery.scanner.IDiscoveryListener;
import com.upuphone.starrynet.strategy.protocol.IProtocol;
import com.upuphone.starrynet.strategy.protocol.IProtocolCallback;
import com.upuphone.starrynet.strategy.utils.AppUtil;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IccoaProtocol implements IProtocol, IccoaProtocolCallback, IDiscoveryListener {
    private static final int COMMUNICATION_TIMEOUT = 20000;
    public static final int DEFAULT_BAND = 0;
    public static final int FIVE_G_BAND = 1;
    private static final String KEY_STARRY_AP_SUPPORT = "starry_ap_support";
    private static final String SUPPORT_STARRY_AP = "1";
    public static final String TAG = "IccoaProtocol";
    private IProtocolCallback mCallback;
    private final CommunicationTimeoutHandler mCommunicationTimeoutHandler;
    private final Context mContext;
    /* access modifiers changed from: private */
    public final IccoaChannel mIccoaChannel;
    private boolean mIsBleAuthCompleted = false;
    private StConnectDevice mStConnectDevice;
    private final HashMap<StDevice, Integer> mWaitConnectWifiDevices = new HashMap<>();
    private final WifiManager mWifiManager;

    public class CommunicationTimeoutHandler extends Handler {
        public CommunicationTimeoutHandler(Looper looper) {
            super(looper);
        }

        @SuppressLint({"MissingPermission"})
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 6 || i == 7) {
                IccoaProtocol.this.mIccoaChannel.disconnect((StDevice) message.obj);
            } else if (i == 8) {
                StarryDeviceManager.getInstance().connectFail((StDevice) message.obj, StErrorCode.CONNECT_STRATEGY_P2P_CONNECT_FAIL, 2);
            }
        }
    }

    @SuppressLint({"NewApi"})
    public IccoaProtocol(Context context) {
        this.mContext = context;
        this.mIccoaChannel = new IccoaChannel(this, context);
        this.mCommunicationTimeoutHandler = new CommunicationTimeoutHandler(Looper.getMainLooper());
        this.mWifiManager = (WifiManager) context.getSystemService("wifi");
        StarryNetChannelManager.getInstance().addProtocol(this);
        StarryDeviceManager.getInstance().addDiscoveryListener(this);
        SysActionManager.getInstance().registerSysAction(new SysActionManager.StateChangeSimpleCallback() {
            public void onWiFiEnabled() {
                IccoaProtocol.this.onWiFiEnabled();
            }
        });
    }

    private int checkWifiBandInfo() {
        return this.mWifiManager.is5GHzBandSupported() ? 1 : 0;
    }

    @SuppressLint({"NewApi"})
    private void connectWifi(StConnectDevice stConnectDevice, int i) {
        if (stConnectDevice == null) {
            StLog.d(TAG, "connectP2p StDevice is null");
            return;
        }
        boolean isWlanOn = SysActionManager.getInstance().isWlanOn();
        boolean isLocServiceEnable = AppUtil.isLocServiceEnable(this.mContext);
        StLog.d(TAG, "connectP2p, wifi open=" + isWlanOn + ",location service open=" + isLocServiceEnable + ",connect type=" + i);
        if (!isLocServiceEnable && Build.VERSION.SDK_INT < 32) {
            return;
        }
        if (!isWlanOn) {
            SysActionManager.getInstance().enableWiFi();
            this.mWaitConnectWifiDevices.put(stConnectDevice.getDevice(), Integer.valueOf(i));
        } else if (i == 1001 || isSupportStarryAp()) {
            GcChannel gcChannel = (GcChannel) StarryNetChannelManager.getInstance().getConnectChannel(11);
            if (gcChannel == null) {
                StLog.d(TAG, "channel is null");
                return;
            }
            StLog.d(TAG, "p2p channel is connecting ...");
            gcChannel.connect(stConnectDevice.getSsid(), stConnectDevice.getPwd(), stConnectDevice.getWifiMac(), stConnectDevice.getFreq(), stConnectDevice.getPort(), stConnectDevice.getIdentifier(), stConnectDevice.getAddress());
        } else {
            StaChannel staChannel = (StaChannel) StarryNetChannelManager.getInstance().getConnectChannel(13);
            if (staChannel == null) {
                StLog.d(TAG, "channel is null");
                return;
            }
            StLog.d(TAG, "sta channel is connecting ...");
            WiFiApInfo wiFiApInfo = new WiFiApInfo(stConnectDevice.getSsid(), stConnectDevice.getPwd(), stConnectDevice.getPort());
            wiFiApInfo.setPeerId(stConnectDevice.getIdentifier());
            staChannel.connect(wiFiApInfo);
        }
    }

    private Map<Integer, String> dealJsonDataFromCar(byte[] bArr) {
        String str = new String(bArr);
        try {
            JsonElement parseString = JsonParser.parseString(str);
            if (parseString == null || !parseString.isJsonObject()) {
                StringBuilder sb = new StringBuilder();
                sb.append("json element is ");
                sb.append(parseString == null ? "null" : parseString.getClass().getSimpleName());
                StLog.d(TAG, sb.toString());
                return null;
            }
            JsonObject asJsonObject = parseString.getAsJsonObject();
            if (asJsonObject == null) {
                StLog.i(TAG, "data error, not json");
                return null;
            }
            HashMap hashMap = new HashMap();
            JsonElement jsonElement = asJsonObject.get("name");
            if (jsonElement == null || jsonElement.isJsonNull()) {
                StLog.i(TAG, "name data error, id element is null");
            } else {
                hashMap.put(0, jsonElement.getAsString());
            }
            JsonElement jsonElement2 = asJsonObject.get("ssid");
            if (jsonElement2 == null || jsonElement2.isJsonNull()) {
                StLog.i(TAG, "ssid data error, id element is null");
                return null;
            }
            hashMap.put(1, jsonElement2.getAsString());
            JsonElement jsonElement3 = asJsonObject.get("psk");
            if (jsonElement3 == null || jsonElement3.isJsonNull()) {
                StLog.i(TAG, "psk data error, id element is null");
                return null;
            }
            hashMap.put(2, jsonElement3.getAsString());
            JsonElement jsonElement4 = asJsonObject.get("mac");
            if (jsonElement4 == null || jsonElement4.isJsonNull()) {
                StLog.i(TAG, "mac data error, id element is null");
                return null;
            }
            hashMap.put(3, jsonElement4.getAsString());
            JsonElement jsonElement5 = asJsonObject.get(RtspHeaders.Values.PORT);
            if (jsonElement5 == null || jsonElement5.isJsonNull()) {
                StLog.i(TAG, "port data error, id element is null");
                return null;
            }
            hashMap.put(5, jsonElement5.getAsString());
            JsonElement jsonElement6 = asJsonObject.get("freq");
            if (jsonElement6 == null || jsonElement6.isJsonNull()) {
                StLog.i(TAG, "freq data error, id element is null");
                return null;
            }
            hashMap.put(4, jsonElement6.getAsString());
            JsonElement jsonElement7 = asJsonObject.get("type");
            String valueOf = String.valueOf(1001);
            if (jsonElement7 == null || jsonElement7.isJsonNull()) {
                StLog.i(TAG, "type data error, type element is null");
            } else {
                valueOf = jsonElement7.getAsString();
            }
            hashMap.put(6, valueOf);
            return hashMap;
        } catch (Exception e) {
            StLog.e(TAG, "receive invalid JSON:" + str + ",detail error:" + e);
            return null;
        }
    }

    private int disconnectUsb(StDevice stDevice) {
        StLog.d(TAG, "disconnectUsb ...");
        if (stDevice == null) {
            StLog.d(TAG, " USB device is null");
            return StErrorCode.CONNECT_CORE_USB_DISCONNECT_FAIL;
        } else if (!stDevice.isUsbConnected()) {
            StLog.d(TAG, " USB device not connected");
            return StErrorCode.CONNECT_CORE_USB_DISCONNECT_FAIL;
        } else {
            StarryDeviceManager.getInstance().deviceDisconnected(this.mStConnectDevice, 512);
            return StErrorCode.CONNECT_CORE_USB_DISCONNECT_SUCCESS;
        }
    }

    private boolean isSupportStarryAp() {
        String string = Settings.Global.getString(StarryNetData.getInstance().getApplicationContext().getContentResolver(), KEY_STARRY_AP_SUPPORT);
        StLog.d(TAG, "isSupportStarryAp(1:support) => " + string);
        return "1".equals(string);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onWiFiEnabled$0(Integer num) {
        connectWifi(this.mStConnectDevice, num.intValue());
    }

    private byte[] sendPhoneJsonData2Car(int i, String str) {
        StDevice ownDevice = StarryNetData.getInstance().getOwnDevice();
        String modelName = StarryNetData.getInstance().getOwnDevice().getModelName();
        String str2 = Build.MODEL;
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", ownDevice.getIdentifier2String());
        jsonObject.addProperty("model", str2);
        jsonObject.addProperty("name", modelName);
        jsonObject.addProperty("band", (Number) Integer.valueOf(i));
        jsonObject.addProperty("mac", str);
        jsonObject.addProperty("type", (Number) 1002);
        return jsonObject.toString().getBytes();
    }

    private void startTimer(int i, int i2, StDevice stDevice) {
        if (this.mCommunicationTimeoutHandler.hasMessages(i)) {
            this.mCommunicationTimeoutHandler.removeMessages(i);
        }
        CommunicationTimeoutHandler communicationTimeoutHandler = this.mCommunicationTimeoutHandler;
        communicationTimeoutHandler.sendMessageDelayed(communicationTimeoutHandler.obtainMessage(i, stDevice), (long) i2);
    }

    private void stopTimer(int i) {
        if (this.mCommunicationTimeoutHandler.hasMessages(i)) {
            this.mCommunicationTimeoutHandler.removeMessages(i);
        }
    }

    @SuppressLint({"NewApi"})
    public int connect(StDevice stDevice, int i) {
        StLog.d(TAG, "connect ... profile " + i);
        StDiscoveryDevice discoveryDevice = StarryDeviceManager.getInstance().getDiscoveryDevice(stDevice.getIdentifier());
        if (discoveryDevice == null) {
            StLog.d(TAG, "connect discoveryDevice is null ");
            return StErrorCode.CONNECT_STRATEGY_BLE_PARAM_ERROR;
        }
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
        this.mStConnectDevice = connectDevice;
        if (connectDevice == null) {
            this.mStConnectDevice = new StConnectDevice();
        }
        this.mStConnectDevice.setDevice(stDevice);
        this.mStConnectDevice.setDeviceType((byte) 3);
        this.mStConnectDevice.setCarId(discoveryDevice.getCarId());
        this.mStConnectDevice.setCarName(discoveryDevice.getCarName());
        this.mStConnectDevice.setCarPinCode(discoveryDevice.getCarPinCode());
        this.mStConnectDevice.setCarProductId(discoveryDevice.getCarProductId());
        this.mStConnectDevice.setCarVendorData(discoveryDevice.getCarVendorData());
        this.mStConnectDevice.setIccoaSerialNum(discoveryDevice.getIccoaSerialNum());
        this.mStConnectDevice.setCarVendorId(discoveryDevice.getCarVendorId());
        this.mStConnectDevice.setCarProtocolVersion(discoveryDevice.getCarProtocolVersion());
        this.mStConnectDevice.setPhoneBtMacCRC16(discoveryDevice.getICCOAPhoneBtMacCRC16());
        if (this.mStConnectDevice.isProtocolConnected(i)) {
            StLog.d(TAG, "already connect");
            return StErrorCode.CONNECT_STRATEGY_BLE_PARAM_ERROR;
        } else if (i == 1 && (this.mStConnectDevice.isProtocolConnected(8) || this.mStConnectDevice.isProtocolConnected(512))) {
            return StErrorCode.CONNECT_STRATEGY_BLE_PARAM_ERROR;
        } else {
            if (i == 3 || i == 4) {
                if (this.mStConnectDevice.isProtocolConnected(8)) {
                    disconnect(this.mStConnectDevice.getDevice(), 11);
                }
                StLog.d(TAG, "usb deviceConnected");
                StarryDeviceManager.getInstance().deviceConnected(this.mStConnectDevice, 512);
                return StErrorCode.CONNECT_CORE_USB_CONNECT_SUCCESS;
            }
            this.mIsBleAuthCompleted = false;
            return this.mIccoaChannel.connect(discoveryDevice);
        }
    }

    @SuppressLint({"NewApi"})
    public int disconnect(StDevice stDevice, int i) {
        if (i == 3 || i == 4) {
            return disconnectUsb(stDevice);
        }
        this.mIccoaChannel.disconnect(stDevice);
        GcChannel gcChannel = (GcChannel) StarryNetChannelManager.getInstance().getConnectChannel(11);
        if (gcChannel == null) {
            StLog.d(TAG, "channel is null");
            return -1;
        }
        gcChannel.disconnect(stDevice);
        return 0;
    }

    public IMessageChannel getMessageChannel(StDevice stDevice) {
        return null;
    }

    public int getProfile() {
        return 3;
    }

    public boolean isBleAuthCompleted() {
        return this.mIsBleAuthCompleted;
    }

    public void onBatchDiscovered(List<StDevice> list) {
    }

    public void onBrEdrBondStateChange(StConnectDevice stConnectDevice, int i, int i2) {
    }

    public void onConnectFail(int i) {
        if (this.mStConnectDevice != null) {
            StarryDeviceManager.getInstance().connectFail(this.mStConnectDevice.getDevice(), StErrorCode.CONNECT_STRATEGY_BLE_CONNECT_FAIL, 1);
        }
    }

    public boolean onConnected(StConnectDevice stConnectDevice, IConnectChannel iConnectChannel) {
        StLog.d(TAG, " onGcConnected " + stConnectDevice);
        int profile = iConnectChannel.getProfile();
        if (stConnectDevice.isProtocolConnected(profile)) {
            StLog.d(TAG, "onConnected connectDevice is connected profile = " + profile);
            return false;
        } else if (profile != 11) {
            return false;
        } else {
            this.mIccoaChannel.disconnect(stConnectDevice.getDevice());
            IProtocolCallback iProtocolCallback = this.mCallback;
            if (iProtocolCallback != null) {
                iProtocolCallback.onConnected(stConnectDevice, 8, this);
            }
            StarryDeviceManager.getInstance().deviceConnected(stConnectDevice, 8);
            return true;
        }
    }

    public void onDisConnected(String str) {
        StLog.d(TAG, "Ble onDisconnected");
        this.mIsBleAuthCompleted = false;
        StDevice deviceByBleMac = StarryDeviceManager.getInstance().getDeviceByBleMac(str);
        if (deviceByBleMac == null || deviceByBleMac.getIdentifier2String().equals(this.mStConnectDevice.getIdentifier2String())) {
            StarryDeviceManager.getInstance().deviceDisconnected(this.mStConnectDevice, 2);
        } else {
            StLog.d(TAG, " it is not a same device");
        }
    }

    public boolean onDisconnected(StConnectDevice stConnectDevice, IConnectChannel iConnectChannel) {
        int profile = iConnectChannel.getProfile();
        StLog.d(TAG, "onGcDisConnected profile: " + profile);
        if (stConnectDevice == null) {
            StLog.d(TAG, "device is null");
            return false;
        } else if (!stConnectDevice.isProtocolConnected(profile)) {
            StLog.d(TAG, "onDisconnected connectDevice is not connected profile = " + profile);
            return false;
        } else if (profile != 11) {
            return false;
        } else {
            IProtocolCallback iProtocolCallback = this.mCallback;
            if (iProtocolCallback != null) {
                iProtocolCallback.onDisconnected(stConnectDevice, 8, this);
            }
            this.mIccoaChannel.disconnect(stConnectDevice.getDevice());
            StarryDeviceManager.getInstance().deviceDisconnected(stConnectDevice, 8);
            return true;
        }
    }

    public void onDiscovered(StDiscoveryDevice stDiscoveryDevice) {
    }

    public void onDiscoveredFail(int i) {
    }

    public void onLost(StDiscoveryDevice stDiscoveryDevice) {
        if (stDiscoveryDevice == null) {
            StLog.d(TAG, "onLost device is null");
        } else if (stDiscoveryDevice.getDeviceType() != 3) {
            StLog.d(TAG, "it is not a iccoa device");
        } else if (stDiscoveryDevice.getDiscoveryType() == 1) {
            StLog.d(TAG, "The discoveryType is : " + stDiscoveryDevice.getDiscoveryType());
        } else {
            StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDiscoveryDevice.getIdentifier());
            StLog.d(TAG, "onlost StConnectDevice " + connectDevice);
            if (connectDevice == null) {
                StLog.d(TAG, "StConnectDevice is null");
            } else if (!connectDevice.isProtocolConnected(512)) {
                StLog.d(TAG, "onDisconnected connectDevice is not connected profile ");
            } else {
                if (connectDevice.getDeviceType() == 3) {
                    this.mCallback.onDisconnected(connectDevice, 512, this);
                }
                StarryDeviceManager.getInstance().deviceDisconnected(connectDevice, 512);
            }
        }
    }

    public void onRecv(StConnectDevice stConnectDevice, byte[] bArr, int i, IStarryNetChannel iStarryNetChannel) {
    }

    public void onWiFiEnabled() {
        Integer remove;
        for (StConnectDevice next : StarryDeviceManager.getInstance().getConnectedDevices()) {
            if (next != null) {
                StDevice device = next.getDevice();
                if (device.isBleConnected() && !device.isP2pConnected() && (remove = this.mWaitConnectWifiDevices.remove(device)) != null && next.getDeviceType() == 3) {
                    if (Build.VERSION.SDK_INT >= 34) {
                        StLog.d(TAG, "onWifiEnabled, wait 3s start connect wifi for iccoa");
                        this.mCommunicationTimeoutHandler.postDelayed(new a(this, remove), 3000);
                    } else {
                        connectWifi(this.mStConnectDevice, remove.intValue());
                    }
                }
            }
        }
        this.mWaitConnectWifiDevices.clear();
    }

    public int sendMsg(StDevice stDevice, byte[] bArr) {
        return 0;
    }

    public void setProtocolCallback(IProtocolCallback iProtocolCallback) {
        this.mCallback = iProtocolCallback;
    }

    public void onRecv(StDevice stDevice, byte[] bArr, int i) {
        StLog.d(TAG, "onRecv device " + stDevice + " data " + Arrays.toString(bArr) + " msgType " + i);
        if (stDevice == null) {
            StLog.d(TAG, "onRecv device is null");
        } else if (bArr == null) {
            StLog.d(TAG, "onRecv data is null");
        } else if (i == 0) {
            stopTimer(8);
            Map<Integer, String> dealJsonDataFromCar = dealJsonDataFromCar(bArr);
            if (dealJsonDataFromCar == null) {
                StLog.e(TAG, "afeter parse json, car map is null");
                return;
            }
            this.mIsBleAuthCompleted = true;
            String str = dealJsonDataFromCar.get(0);
            String str2 = dealJsonDataFromCar.get(1);
            String str3 = dealJsonDataFromCar.get(2);
            String str4 = dealJsonDataFromCar.get(3);
            int parseInt = Integer.parseInt(dealJsonDataFromCar.get(5));
            int parseInt2 = Integer.parseInt(dealJsonDataFromCar.get(4));
            int parseInt3 = Integer.parseInt(dealJsonDataFromCar.get(6));
            byte[] identifier = stDevice.getIdentifier();
            StLog.d(TAG, "name = " + str + ", ssid = " + str2 + ", psk = " + str3 + ", mac = " + str4 + ", port = " + parseInt + ", freq = " + parseInt2 + ", type = " + parseInt3 + ", identifier = " + Arrays.toString(identifier));
            this.mStConnectDevice.setDevice(stDevice);
            this.mStConnectDevice.setDeviceName(str);
            this.mStConnectDevice.setSsid(str2);
            this.mStConnectDevice.setPwd(str3);
            this.mStConnectDevice.setWifiMac(str4);
            this.mStConnectDevice.setPort(parseInt);
            this.mStConnectDevice.setFreq(parseInt2);
            connectWifi(this.mStConnectDevice, parseInt3);
        }
    }

    @SuppressLint({"NewApi"})
    public void onConnected(String str) {
        StLog.d(TAG, "Ble Connected");
        StDevice deviceByBleMac = StarryDeviceManager.getInstance().getDeviceByBleMac(str);
        if (!deviceByBleMac.getIdentifier2String().equals(this.mStConnectDevice.getIdentifier2String())) {
            StLog.d(TAG, " it is not a same device");
            return;
        }
        if (!this.mStConnectDevice.isBleConnected()) {
            StarryDeviceManager.getInstance().deviceConnected(this.mStConnectDevice, 2);
        }
        GcChannel gcChannel = (GcChannel) StarryNetChannelManager.getInstance().getConnectChannel(11);
        if (gcChannel == null) {
            StLog.d(TAG, "channel is null");
            return;
        }
        String p2pMacAddress = gcChannel.getP2pMacAddress();
        startTimer(8, 20000, deviceByBleMac);
        if (!this.mIccoaChannel.sendData(sendPhoneJsonData2Car(checkWifiBandInfo(), p2pMacAddress))) {
            StLog.d(TAG, "send the device p2p info fail");
            stopTimer(8);
            this.mIccoaChannel.disconnect(deviceByBleMac);
        }
    }
}
