package com.upuphone.runasone.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.text.TextUtils;
import com.meizu.common.util.LunarCalendar;
import com.upuphone.runasone.channel.linker.EnumLinker;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.host.core.api.EnumLinkStrategy;
import com.upuphone.runasone.service.StarrynetApiImpl;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.config.CarConfigs;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class Utils {
    @SuppressLint({"StaticFieldLeak"})
    private static Context sContext = null;
    private static String versionName = "none";

    private Utils() {
    }

    public static String bytes2HexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static StarryDevice clone(StarryDevice starryDevice) {
        StarryDevice build = StarryDevice.newBuilder().setSelfId(StarrynetApiImpl.getInstance().getSelfId()).setId(starryDevice.getId()).setName(starryDevice.getName()).setAddress(starryDevice.getAddress()).setPort(starryDevice.getPort()).setSupportAbility(new ArrayList()).setStarryNet(starryDevice.getStarryDevice()).build();
        build.setRssi(starryDevice.getRssi());
        build.setTerminalType(starryDevice.getTerminalType());
        build.setModelName(starryDevice.getModelName());
        return build;
    }

    public static StarryDevice convert(StDevice stDevice) {
        String selfId = StarrynetApiImpl.getInstance().getSelfId();
        if (stDevice.getTerminalType() == 7 && TextUtils.isEmpty(selfId)) {
            selfId = getTempSelfId();
        }
        StarryDevice build = StarryDevice.newBuilder().setSelfId(selfId).setId(bytes2HexString(stDevice.getIdentifier())).setName(stDevice.getDeviceName()).setStarryNet(stDevice).setSupportAbility(new ArrayList()).build();
        build.setRssi(stDevice.getRssi());
        build.setTerminalType(stDevice.getTerminalType());
        build.setModelName(stDevice.getModelName());
        return build;
    }

    public static void copyByStream(InputStream inputStream, OutputStream outputStream) {
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read > 0) {
                    outputStream.write(bArr, 0, read);
                } else {
                    inputStream.close();
                    outputStream.close();
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static EnumLinker getBalanceLinker() {
        return EnumLinker.TYPE_LINK_SPP;
    }

    public static String getCallingPid() {
        return String.valueOf(Binder.getCallingPid());
    }

    public static String getCallingPkgName() {
        return sContext.getPackageManager().getNameForUid(Binder.getCallingUid());
    }

    public static Context getContext() {
        return sContext;
    }

    public static EnumLinker getDefaultLinker() {
        return EnumLinker.TYPE_LINK_BT;
    }

    public static int getDeviceTerminalType(StarryDevice starryDevice) {
        if (starryDevice == null) {
            return -1;
        }
        return starryDevice.getTerminalType();
    }

    public static EnumLinker getHighPerformanceLinker() {
        return EnumLinker.TYPE_LINK_WS;
    }

    public static String getPkgName(int i) {
        String valueOf = String.valueOf(i);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) sContext.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return valueOf;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next != null && next.pid == i) {
                return next.processName;
            }
        }
        return valueOf;
    }

    public static String getSelfId() {
        return StarrynetApiImpl.getInstance().getSelfId();
    }

    public static int getSelfTerminalType() {
        StDevice ownDevice = StarryNetData.getInstance().getOwnDevice();
        if (ownDevice == null) {
            return -1;
        }
        return ownDevice.getTerminalType();
    }

    public static EnumLinker getSimplifiedLinker() {
        return EnumLinker.TYPE_LINK_SIMPLIFIED;
    }

    public static long getSysTime(String str) {
        if (str.contains(Constants.STR_TIMESTAMP)) {
            return Long.valueOf(str.substring(str.substring(0, str.indexOf(LunarCalendar.DATE_SEPARATOR)).length() + 1)).longValue();
        }
        return 0;
    }

    public static String getTempSelfId() {
        return "020000000000";
    }

    public static String getTimestamp() {
        return Constants.STR_TIMESTAMP + System.currentTimeMillis();
    }

    public static String getVersionName() {
        if (!"none".equals(versionName)) {
            return versionName;
        }
        Context context = sContext;
        if (context != null) {
            try {
                versionName = context.getPackageManager().getPackageInfo(sContext.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return versionName;
    }

    private static String getWlanPwd(WifiConfiguration wifiConfiguration) throws Exception {
        Field declaredField = wifiConfiguration.getClass().getDeclaredField("preSharedKey");
        declaredField.setAccessible(true);
        return declaredField.get(wifiConfiguration).toString();
    }

    public static String[] getWlanSSID(Context context) {
        String[] strArr = new String[2];
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            String str = null;
            Method declaredMethod = WifiManager.class.getDeclaredMethod("getPrivilegedConfiguredNetworks", (Class[]) null);
            declaredMethod.setAccessible(true);
            String ssid = wifiManager.getConnectionInfo().getSSID();
            strArr[0] = ssid;
            for (WifiConfiguration wifiConfiguration : (List) declaredMethod.invoke(wifiManager, (Object[]) null)) {
                if (wifiConfiguration.SSID.equals(ssid)) {
                    try {
                        str = getWlanPwd(wifiConfiguration);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            strArr[1] = str;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return strArr;
    }

    public static byte[] hexString2Bytes(String str) {
        if (str == null || str.equals("") || str.length() % 2 != 0) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        char[] charArray = upperCase.toCharArray();
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((charToByte(charArray[i2 + 1]) & 255) | (charToByte(charArray[i2]) << 4));
        }
        return bArr;
    }

    public static void initContext(Context context) {
        sContext = context;
    }

    public static boolean isCar() {
        StDevice ownDevice = StarryNetData.getInstance().getOwnDevice();
        return ownDevice != null && ownDevice.getTerminalType() == 3;
    }

    public static boolean isE371MX() {
        StDevice ownDevice = StarryNetData.getInstance().getOwnDevice();
        if (ownDevice == null) {
            return false;
        }
        return CarConfigs.MODEL_NAME_CAR_E371_MX.equals(ownDevice.getModelName());
    }

    public static boolean isHQ() {
        StDevice ownDevice = StarryNetData.getInstance().getOwnDevice();
        if (ownDevice == null) {
            return false;
        }
        return CarConfigs.MODEL_NAME_CAR_HQ_E009.equals(ownDevice.getModelName()) || CarConfigs.MODEL_NAME_CAR_HQ_E202.equals(ownDevice.getModelName());
    }

    public static boolean isPad() {
        StDevice ownDevice = StarryNetData.getInstance().getOwnDevice();
        return ownDevice != null && ownDevice.getTerminalType() == 9;
    }

    public static boolean isPhone() {
        StDevice ownDevice = StarryNetData.getInstance().getOwnDevice();
        return ownDevice != null && ownDevice.getTerminalType() == 1;
    }

    public static boolean isPhoneOfRemoteDev(StarryDevice starryDevice) {
        return starryDevice != null && starryDevice.getTerminalType() == 1;
    }

    public static boolean isSelfCenterDevice() {
        return false;
    }

    public static boolean isSubDevice() {
        return false;
    }

    public static boolean isSystemApp(Context context, int i) {
        String pkgName = getPkgName(i);
        if (pkgName == null) {
            return false;
        }
        return isSystemApp(context, pkgName);
    }

    public static EnumLinkStrategy mapLinkStrategy(EnumLinker enumLinker) {
        EnumLinkStrategy enumLinkStrategy = EnumLinkStrategy.STRATEGY_DEFAULT;
        if (getSimplifiedLinker() == enumLinker) {
            enumLinkStrategy = EnumLinkStrategy.STRATEGY_SIMPLIFIED;
        }
        if (getHighPerformanceLinker() == enumLinker) {
            enumLinkStrategy = EnumLinkStrategy.STRATEGY_HIGH_PERFORMANCE;
        }
        return getBalanceLinker() == enumLinker ? EnumLinkStrategy.STRATEGY_BALANCE : enumLinkStrategy;
    }

    public static EnumLinker mapLinker(EnumLinkStrategy enumLinkStrategy) {
        return EnumLinkStrategy.STRATEGY_HIGH_PERFORMANCE == enumLinkStrategy ? getHighPerformanceLinker() : EnumLinkStrategy.STRATEGY_BALANCE == enumLinkStrategy ? getBalanceLinker() : getDefaultLinker();
    }

    public static String parserSession(String str) {
        return str == null ? Constants.INVALID_SESSION : str;
    }

    public static boolean isSystemApp(Context context, String str) {
        try {
            if ((context.getPackageManager().getPackageInfo(str, 16384).applicationInfo.flags & 1) != 0) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
