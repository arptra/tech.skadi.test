package com.upuphone.starrynet.strategy;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.ucar.vehiclesdk.MDevice;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.StarryNetConstant;
import com.upuphone.starrynet.common.utils.Utils;
import com.upuphone.starrynet.strategy.config.CarConfigs;
import com.upuphone.starrynet.strategy.config.StConfigLoader;
import com.upuphone.starrynet.strategy.connector.IStarryNetConnector;
import com.upuphone.starrynet.strategy.connector.manager.CarStarryNetConnector;
import com.upuphone.starrynet.strategy.connector.manager.PadStarryNetConnector;
import com.upuphone.starrynet.strategy.connector.manager.PhoneStarryNetConnector;
import com.upuphone.starrynet.strategy.connector.manager.XRStarryNetConnector;
import com.upuphone.starrynet.strategy.discovery.CarStarryNetDiscoverer;
import com.upuphone.starrynet.strategy.discovery.IStarryNetDiscoverer;
import com.upuphone.starrynet.strategy.discovery.PadStarryNetDiscoverer;
import com.upuphone.starrynet.strategy.discovery.PhoneStarryNetDiscoverer;
import com.upuphone.starrynet.strategy.discovery.XRStarryNetDiscoverer;
import com.upuphone.starrynet.strategy.netstack.XdpLinkManager;
import com.upuphone.starrynet.strategy.operater.DefStarryNetOperator;
import com.upuphone.starrynet.strategy.operater.PadStarryNetOperator;
import com.upuphone.starrynet.strategy.operater.PhoneStarryNetOperator;
import com.upuphone.starrynet.strategy.operater.StarryNetOperator;
import com.upuphone.starrynet.strategy.operater.XRStarryNetOperator;
import com.upuphone.starrynet.strategy.utils.BleUtil;
import com.upuphone.starrynet.strategy.utils.DeviceUtil;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public final class StarryNetData {
    private static final String LOCAL_FLYME_MODEL = "ro.product.flyme.model";
    private static final String LOCAL_MANU = "ro.product.manufacturer";
    private static final String LOCAL_MODEL = "ro.product.model";
    public static final String MODEL_FLYME_NAME_MEIZU_2431 = "M2431";
    public static final String MODEL_FLYME_NAME_MEIZU_2521 = "M2521";
    public static final String MODEL_ID_RING_1 = "1200";
    private static final String MODEL_NAME_MEIZU_21 = "meizu 21";
    private static final String MODEL_NAME_MEIZU_21_PRO = "meizu 21 Pro";
    public static final String MODEL_NAME_MEIZU_2431 = "m2431";
    private static final String STARRY_NET_SETTING_PROPERTY = "starry_net_setting_property";
    private static final String TAG = "StarryNetData";
    private Context context;
    private boolean isUupShareBusy;
    private StConfigLoader mConfigLoader;
    private IStarryNetConnector mConnectMgr;
    private IStarryNetDiscoverer mDiscoveryMgr;
    private StarryNetOperator mOperateMgr;
    private StDevice mOwnDevice;
    private String mPkgName;
    private byte[] thirdKaiXiangDeviceID;

    public static class Holder {
        /* access modifiers changed from: private */
        public static final StarryNetData INSTANCE = new StarryNetData();

        private Holder() {
        }
    }

    private boolean brEdrMacAvailable(String str) {
        return !TextUtils.isEmpty(str) && !str.equals(BleUtil.ALL_ZERO_ADDRESS) && !str.equals(BleUtil.DEFAULT_ADDRESS);
    }

    private String dealCarModelName(String str) {
        return str.toLowerCase().contains(CarConfigs.MODEL_NAME_CAR_EX11) ? CarConfigs.MODEL_NAME_CAR_EX11 : str;
    }

    private void dealSettingProperty() {
        int i = Settings.Global.getInt(this.context.getContentResolver(), STARRY_NET_SETTING_PROPERTY, 0);
        StLog.d(TAG, "dealSettingProperty " + i);
    }

    private String getAndroidID() {
        return Settings.Secure.getString(this.context.getContentResolver(), "android_id");
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    private String getBtMac() {
        String brEdrMac = this.mOwnDevice.getBrEdrMac();
        return !brEdrMacAvailable(brEdrMac) ? getBtMac(BluetoothAdapter.getDefaultAdapter()) : brEdrMac;
    }

    @NonNull
    private byte[] getIdentifierForNoBt() {
        return Utils.generateUniqueID(getAndroidID());
    }

    public static StarryNetData getInstance() {
        return Holder.INSTANCE;
    }

    public static byte getTerminalType(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 1477633:
                if (str.equals("0001")) {
                    c = 0;
                    break;
                }
                break;
            case 1477634:
                if (str.equals("0002")) {
                    c = 1;
                    break;
                }
                break;
            case 1477635:
                if (str.equals("0003")) {
                    c = 2;
                    break;
                }
                break;
            case 1507424:
                if (str.equals("1001")) {
                    c = 3;
                    break;
                }
                break;
            case 1507425:
                if (str.equals("1002")) {
                    c = 4;
                    break;
                }
                break;
            case 1537215:
                if (str.equals("2001")) {
                    c = 5;
                    break;
                }
                break;
            case 1537216:
                if (str.equals("2002")) {
                    c = 6;
                    break;
                }
                break;
            case 1567006:
                if (str.equals("3001")) {
                    c = 7;
                    break;
                }
                break;
            case 1745751:
                if (str.equals("9000")) {
                    c = 8;
                    break;
                }
                break;
            case 1754688:
                if (str.equals("9999")) {
                    c = 9;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 5:
                return 1;
            case 1:
            case 7:
                return 2;
            case 2:
                return 5;
            case 3:
                return 3;
            case 4:
                return 7;
            case 6:
                return 9;
            case 8:
                return 6;
            case 9:
                return 4;
            default:
                return 0;
        }
    }

    private boolean isCar() {
        StDevice stDevice = this.mOwnDevice;
        return stDevice != null && stDevice.getTerminalType() == 3;
    }

    private boolean isPad() {
        StDevice stDevice = this.mOwnDevice;
        return stDevice != null && stDevice.getTerminalType() == 9;
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    private void setOwnDevice(byte b) {
        String property = getProperty(LOCAL_MODEL, "error");
        String property2 = getProperty(LOCAL_MANU, "error");
        String property3 = getProperty(LOCAL_FLYME_MODEL, "error");
        StLog.d(TAG, "Company : " + property2 + " , model : " + property + " , flyme model : " + property3);
        if (b == 4) {
            StDevice stDevice = new StDevice();
            this.mOwnDevice = stDevice;
            stDevice.setCompanyID("9999");
            this.mOwnDevice.setCompanyName(property2);
            if (DeviceUtil.isHarmonyOs()) {
                this.mOwnDevice.setModelID("A000");
            } else if (DeviceUtil.isVIVOPhone()) {
                this.mOwnDevice.setModelID("A002");
            } else if (DeviceUtil.isOppoPhone()) {
                this.mOwnDevice.setModelID("A003");
            } else if (DeviceUtil.isSamSungPhone()) {
                this.mOwnDevice.setModelID("A001");
            } else if (DeviceUtil.isMotoPhone()) {
                this.mOwnDevice.setModelID("A004");
            } else if (DeviceUtil.isInfinixPhone()) {
                this.mOwnDevice.setModelID("A005");
            } else if (DeviceUtil.isXiaomiPhone()) {
                this.mOwnDevice.setModelID("A006");
            } else {
                this.mOwnDevice.setModelID("9999");
            }
            this.mOwnDevice.setModelName(property);
            this.mOwnDevice.setCategoryID("9999");
            this.mOwnDevice.setCategoryName("3rd");
            this.mOwnDevice.setTerminalType(b);
            StLog.i(TAG, "third device");
        } else {
            String str = "XINGJI";
            String str2 = "XR";
            if ((!str.equals(property2) && !"QUALCOMM".equals(property2)) || (!"Star".equals(property) && !"Star Concept".equals(property))) {
                if (!"QUALCOMM".equals(property2) || !"Monaco for arm".equals(property)) {
                    String str3 = "ECARX";
                    if (CarConfigs.isCarProduct(property2, property)) {
                        property = dealCarModelName(property);
                        str2 = "Car";
                    } else if (!"SiEngine".equals(property2) || (!"se1000_dx11_master".equals(property) && !"se1000_ds11_master".equals(property))) {
                        boolean isPadProduct = isPadProduct(property2, property3);
                        str3 = MDevice.MANUFACTURERS_MEIZU;
                        if (isPadProduct) {
                            str2 = "PAD";
                            property = property3;
                        } else {
                            if (MODEL_NAME_MEIZU_21.equalsIgnoreCase(property)) {
                                property = "m2461";
                            } else if (MODEL_NAME_MEIZU_21_PRO.equalsIgnoreCase(property)) {
                                property = "m2481";
                            }
                            if (MODEL_FLYME_NAME_MEIZU_2431.equals(property3)) {
                                property = MODEL_NAME_MEIZU_2431;
                            }
                            if (MODEL_FLYME_NAME_MEIZU_2521.equals(property3)) {
                                property = "m2521";
                            }
                            this.mOwnDevice = this.mConfigLoader.buildOwnDevice(property, property2);
                            str2 = "PHONE";
                            property = "MEIZU 20 Inf";
                        }
                    } else {
                        str2 = "HUD";
                        property = "Master";
                    }
                    str = str3;
                } else {
                    property = "Star";
                }
            }
            if (this.mOwnDevice == null) {
                this.mOwnDevice = this.mConfigLoader.buildStDevice(str, str2, property);
            }
            dealSettingProperty();
            StLog.d(TAG, "setCompanyName=%s setCompanyID=%s setCategoryID=%s setCategoryName=%s setModelID=%s setModelName=%s", this.mOwnDevice.getCompanyName(), this.mOwnDevice.getCompanyID(), this.mOwnDevice.getCategoryID(), this.mOwnDevice.getCategoryName(), this.mOwnDevice.getModelID(), this.mOwnDevice.getModelName());
            this.mOwnDevice.setTerminalType(getTerminalType(this.mOwnDevice.getCategoryID()));
        }
        this.mOwnDevice.setVersion((byte) 3);
        this.mOwnDevice.setDeviceType((byte) 3);
        this.mOwnDevice.setUupShareDeviceID(Utils.getRandomString(16).getBytes(StandardCharsets.UTF_8));
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        String name = defaultAdapter.getName();
        if (TextUtils.isEmpty(name)) {
            name = StarryNetConstant.EXTRA_STARRY_DEVICE;
        }
        this.mOwnDevice.setDeviceName(name);
        String btMac = getBtMac(defaultAdapter);
        StLog.d(TAG, "terminalType=%s", String.valueOf(this.mOwnDevice.getTerminalType()));
        this.mOwnDevice.setStarryNetStackCap(XdpLinkManager.getInstance().getOwnXdpCapacity());
        if (this.mOwnDevice.getTerminalType() == 7) {
            this.mOwnDevice.setIdentifier(getIdentifierForNoBt());
            StLog.d(TAG, "HUD OwnDevice : " + this.mOwnDevice);
        } else if (!brEdrMacAvailable(btMac)) {
            setOwnerDeviceId(BleUtil.DEFAULT_ADDRESS);
            StLog.d(TAG, "mac is not available, OwnDevice : " + this.mOwnDevice);
        } else {
            setOwnerDeviceId(btMac);
            StLog.d(TAG, "OwnDevice : " + this.mOwnDevice);
        }
    }

    private void setOwnerDeviceId(String str) {
        StLog.d(TAG, "setOwnerDeviceId mac is " + str);
        this.mOwnDevice.setBrEdrMac(str);
        this.mOwnDevice.setIdentifier(getIdentifier(str));
    }

    public Context getApplication() {
        return this.context;
    }

    public Context getApplicationContext() {
        return this.context;
    }

    public String getCategoryID(String str) {
        return this.mConfigLoader.getCategoryID(str);
    }

    public String getCategoryName(String str) {
        return this.mConfigLoader.getCategoryName(str);
    }

    public String getCompanyID(String str) {
        return this.mConfigLoader.getCompanyID(str);
    }

    public String getCompanyName(String str) {
        return this.mConfigLoader.getCompanyName(str);
    }

    public synchronized IStarryNetConnector getConnectManager() {
        try {
            IStarryNetConnector iStarryNetConnector = this.mConnectMgr;
            if (iStarryNetConnector != null) {
                return iStarryNetConnector;
            }
            if (isAR()) {
                this.mConnectMgr = new XRStarryNetConnector();
            } else if (isCar()) {
                this.mConnectMgr = new CarStarryNetConnector();
            } else if (isPad()) {
                this.mConnectMgr = new PadStarryNetConnector();
            } else {
                this.mConnectMgr = new PhoneStarryNetConnector();
            }
            return this.mConnectMgr;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized IStarryNetDiscoverer getDiscoveryManager() {
        try {
            StLog.d(TAG, "getDiscoveryManager : " + isAR());
            IStarryNetDiscoverer iStarryNetDiscoverer = this.mDiscoveryMgr;
            if (iStarryNetDiscoverer != null) {
                return iStarryNetDiscoverer;
            }
            if (isAR()) {
                this.mDiscoveryMgr = new XRStarryNetDiscoverer();
            } else if (isCar()) {
                this.mDiscoveryMgr = new CarStarryNetDiscoverer();
            } else if (isPad()) {
                this.mDiscoveryMgr = new PadStarryNetDiscoverer();
            } else {
                this.mDiscoveryMgr = new PhoneStarryNetDiscoverer();
            }
            return this.mDiscoveryMgr;
        } catch (Throwable th) {
            throw th;
        }
    }

    public byte[] getIdentifier() {
        byte[] identifier = this.mOwnDevice.getIdentifier();
        if (identifier != null && !Arrays.equals(identifier, Utils.getBytesFromAddress(BleUtil.DEFAULT_ADDRESS))) {
            return identifier;
        }
        String btMac = getBtMac();
        if (brEdrMacAvailable(btMac)) {
            setOwnerDeviceId(btMac);
        }
        return this.mOwnDevice.getIdentifier();
    }

    public byte[] getIdentifierForNoBtKaiXiangOTA() {
        if (this.thirdKaiXiangDeviceID == null) {
            this.thirdKaiXiangDeviceID = Utils.generateUniqueIDBySerial(getAndroidID());
        }
        return this.thirdKaiXiangDeviceID;
    }

    public String getModelID(String str) {
        return this.mConfigLoader.getModelID(str);
    }

    public String getModelName(String str) {
        return this.mConfigLoader.getModelName(str);
    }

    public synchronized StarryNetOperator getOperateManager() {
        try {
            StarryNetOperator starryNetOperator = this.mOperateMgr;
            if (starryNetOperator != null) {
                return starryNetOperator;
            }
            if (!isAR()) {
                if (!isCar()) {
                    if (isHUD()) {
                        this.mOperateMgr = new DefStarryNetOperator();
                    } else if (isPad()) {
                        this.mOperateMgr = new PadStarryNetOperator();
                    } else {
                        this.mOperateMgr = new PhoneStarryNetOperator();
                    }
                    return this.mOperateMgr;
                }
            }
            this.mOperateMgr = new XRStarryNetOperator();
            return this.mOperateMgr;
        } catch (Throwable th) {
            throw th;
        }
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public StDevice getOwnDevice() {
        byte[] identifier = this.mOwnDevice.getIdentifier();
        if (identifier == null || Arrays.equals(identifier, Utils.getBytesFromAddress(BleUtil.DEFAULT_ADDRESS))) {
            String btMac = getBtMac();
            if (brEdrMacAvailable(btMac)) {
                setOwnerDeviceId(btMac);
                String name = BluetoothAdapter.getDefaultAdapter().getName();
                if (!TextUtils.isEmpty(name)) {
                    this.mOwnDevice.setDeviceName(name);
                }
                StLog.d(TAG, "getOwnDevice after update deviceID, mOwnDevice=" + this.mOwnDevice);
            }
        }
        return this.mOwnDevice;
    }

    public String getProperty(String str, String str2) {
        Class<String> cls = String.class;
        try {
            Class<?> cls2 = Class.forName("android.os.SystemProperties");
            str2 = (String) cls2.getMethod("get", new Class[]{cls, cls}).invoke(cls2, new Object[]{str, str2});
        } catch (Exception e) {
            StLog.e(TAG, "reflect error", (Throwable) e);
        }
        StLog.d(TAG, "getProperty " + str + " : " + str2);
        return str2;
    }

    public String getUupShareCompanyName(byte b) {
        return b != 10 ? b != 11 ? b != 20 ? b != 21 ? (b == 30 || b == 31) ? StarryNetConstant.DEVICE_NAME_MI : b != 43 ? (b <= 9 || b >= 20) ? (b <= 19 || b >= 30) ? (b <= 29 || b >= 40) ? (b <= 39 || b >= 46) ? StarryNetConstant.DEVICE_NAME_UNKNOWN : StarryNetConstant.DEVICE_NAME_ONE_PLUS : StarryNetConstant.DEVICE_NAME_MI : StarryNetConstant.DEVICE_NAME_VIVO : StarryNetConstant.DEVICE_NAME_OPPO : StarryNetConstant.DEVICE_NAME_ONE_PLUS : StarryNetConstant.DEVICE_NAME_IQOO : StarryNetConstant.DEVICE_NAME_VIVO : StarryNetConstant.DEVICE_NAME_REAL_ME : StarryNetConstant.DEVICE_NAME_OPPO;
    }

    public int getVersionCode() {
        return this.mOwnDevice.getVersion();
    }

    public void init(Context context2) {
        this.context = context2;
        this.mConfigLoader.loadLocalConfig(context2);
        setOwnDevice((byte) 0);
        this.mConfigLoader.requestRemoteStarryNetConfig(context2, 5000);
    }

    public boolean isAR() {
        StDevice stDevice = this.mOwnDevice;
        return stDevice != null && stDevice.getTerminalType() == 2;
    }

    public boolean isBleServer() {
        byte terminalType = this.mOwnDevice.getTerminalType();
        return terminalType == 2 || terminalType == 3;
    }

    public boolean isHUD() {
        StDevice stDevice = this.mOwnDevice;
        return stDevice != null && stDevice.getTerminalType() == 7;
    }

    public boolean isMatchModel(String str) {
        StDevice stDevice = this.mOwnDevice;
        if (stDevice == null) {
            return false;
        }
        return stDevice.getModelName().equals(str);
    }

    public boolean isPadProduct(String str, String str2) {
        return str != null && str2 != null && MDevice.MANUFACTURERS_MEIZU.equals(str) && "T0743".equals(str2);
    }

    public boolean isUupBusy() {
        return this.isUupShareBusy;
    }

    public void setBtMac(String str) {
        this.mOwnDevice.setBrEdrMac(str);
        this.context.getSharedPreferences(TAG, 0).edit().putString(StarryNetConstant.THIRD_BR_EDR_MAC, str).apply();
    }

    public void setConnectMgr(IStarryNetConnector iStarryNetConnector) {
        if (this.mConnectMgr == null) {
            this.mConnectMgr = iStarryNetConnector;
        }
    }

    public void setDiscoveryMgr(IStarryNetDiscoverer iStarryNetDiscoverer) {
        if (this.mDiscoveryMgr == null) {
            this.mDiscoveryMgr = iStarryNetDiscoverer;
        }
    }

    public void setOperateMgr(StarryNetOperator starryNetOperator) {
        if (this.mOperateMgr == null) {
            this.mOperateMgr = starryNetOperator;
        }
    }

    public void setUupShareBusy(boolean z) {
        StLog.d(TAG, "setUupShareBusy : " + z);
        this.isUupShareBusy = z;
    }

    private StarryNetData() {
        this.isUupShareBusy = false;
        this.thirdKaiXiangDeviceID = null;
        this.mConfigLoader = new StConfigLoader();
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    private String getBtMac(BluetoothAdapter bluetoothAdapter) {
        if (this.mOwnDevice.getTerminalType() == 4 || ContextCompat.checkSelfPermission(this.context, "android.permission.LOCAL_MAC_ADDRESS") != 0) {
            return this.context.getSharedPreferences(TAG, 0).getString(StarryNetConstant.THIRD_BR_EDR_MAC, BleUtil.DEFAULT_ADDRESS);
        }
        return bluetoothAdapter.getAddress();
    }

    public void init(Context context2, byte b) {
        this.context = context2;
        this.mConfigLoader.loadAssetsConfigFile(context2);
        setOwnDevice(b);
    }

    private byte[] getIdentifier(String str) {
        if (this.mOwnDevice.getTerminalType() == 4) {
            return getIdentifierForNoBt();
        }
        return Utils.getBytesFromAddress(str);
    }
}
