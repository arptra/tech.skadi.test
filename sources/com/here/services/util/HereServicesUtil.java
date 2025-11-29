package com.here.services.util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.os.UserHandle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import com.here.odnp.util.Log;
import com.here.odnp.util.OdnpUserHandle;

public class HereServicesUtil {
    private static final String HERE_NLP_PACKAGE_NAME = "com.here.network.location.provider";
    private static final String TAG = "services.util.HereServicesUtil";

    private HereServicesUtil() {
    }

    public static String getMobileCountryCode(Context context) {
        String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() < 5 || networkOperator.length() > 6) {
            return null;
        }
        return networkOperator.substring(0, 3);
    }

    public static boolean hasBluetoothLe(Context context) {
        return hasSystemFeature(context, "android.hardware.bluetooth_le");
    }

    private static boolean hasBluetoothPermissions(Context context) {
        PackageManager packageManager = context.getPackageManager();
        return packageManager.checkPermission("android.permission.BLUETOOTH", context.getPackageName()) == 0 && packageManager.checkPermission("android.permission.BLUETOOTH_ADMIN", context.getPackageName()) == 0;
    }

    public static boolean hasCdmaPhone(Context context) {
        return hasSystemFeature(context, "android.hardware.telephony.cdma");
    }

    public static boolean hasCell(Context context) {
        return hasPhone(context) || hasCellularData(context);
    }

    public static boolean hasCellularData(Context context) {
        return hasSystemFeature(context, "android.hardware.telephony");
    }

    public static boolean hasExternalWritableStorage() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static boolean hasGps(Context context) {
        return hasSystemFeature(context, "android.hardware.location.gps");
    }

    public static boolean hasGsmPhone(Context context) {
        return hasSystemFeature(context, "android.hardware.telephony.gsm");
    }

    public static boolean hasPhone(Context context) {
        return hasGsmPhone(context) || hasCdmaPhone(context);
    }

    private static boolean hasSystemFeature(Context context, String str) {
        try {
            return context.getPackageManager().hasSystemFeature(str);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean hasWifi(Context context) {
        return hasSystemFeature(context, "android.hardware.wifi");
    }

    public static boolean isAirplaneModeEnabled(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean isBluetoothLeEnabled(Context context) {
        if (!hasBluetoothLe(context)) {
            return false;
        }
        if (!hasBluetoothPermissions(context)) {
            Log.i(TAG, "isBluetoothLeEnabled: Bluetooth permissions are missing", new Object[0]);
            return false;
        }
        BluetoothAdapter adapter = ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter();
        return adapter != null && adapter.getState() == 12;
    }

    public static boolean isCellEnabled(Context context) {
        return hasCell(context) && !isAirplaneModeEnabled(context);
    }

    public static boolean isGpsLocationEnabled(Context context) {
        boolean isLocationEnabled = hasGps(context) ? ((LocationManager) context.getSystemService("location")).isLocationEnabled() : false;
        Log.i(TAG, "isGpsLocationEnabled: %b", Boolean.valueOf(isLocationEnabled));
        return isLocationEnabled;
    }

    @TargetApi(28)
    private static boolean isLocationEnabledForUser(@NonNull Context context, int i) {
        boolean z;
        try {
            z = ((Boolean) LocationManager.class.getDeclaredMethod("isLocationEnabledForUser", new Class[]{UserHandle.class}).invoke((LocationManager) context.getSystemService("location"), new Object[]{OdnpUserHandle.createUserHandle(i)})).booleanValue();
        } catch (Exception unused) {
            z = false;
        }
        Log.i(TAG, "isLocationEnabledForUser: userId: %d, enabled: %b", Integer.valueOf(i), Boolean.valueOf(z));
        return z;
    }

    private static boolean isLocationProviderEnabled(Context context, String str) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        Log.i(TAG, "isLocationProviderEnabled: %s: %b", str, Boolean.valueOf(locationManager.isProviderEnabled(str)));
        return locationManager.isProviderEnabled(str);
    }

    public static boolean isLocationProviderEnabledForUser(@NonNull Context context, String str, int i) {
        return isLocationEnabledForUser(context, i);
    }

    private static boolean isLocationProviderEnabledForUserApi17(@NonNull Context context, String str, int i) {
        boolean z;
        try {
            z = ((Boolean) Settings.Secure.class.getDeclaredMethod("isLocationProviderEnabledForUser", new Class[]{ContentResolver.class, String.class, Integer.TYPE}).invoke((Object) null, new Object[]{context.getContentResolver(), str, Integer.valueOf(i)})).booleanValue();
        } catch (Exception unused) {
            z = false;
        }
        Log.i(TAG, "isLocationProviderEnabledForUserApi17: userId: %d, provider: %s, enabled: %b", Integer.valueOf(i), str, Boolean.valueOf(z));
        return z;
    }

    public static boolean isNetworkLocationEnabled(@NonNull Context context) {
        boolean isLocationEnabled = ((LocationManager) context.getSystemService("location")).isLocationEnabled();
        Log.i(TAG, "isNetworkLocationEnabled: %b", Boolean.valueOf(isLocationEnabled));
        return isLocationEnabled;
    }

    public static boolean isNetworkLocationEnabledForUser(@NonNull Context context, int i) {
        return isLocationProviderEnabledForUser(context, "network", i);
    }

    public static boolean isPhoneEnabled(Context context) {
        return hasPhone(context) && !isAirplaneModeEnabled(context);
    }

    public static boolean isRunningInNlpContext(Context context) {
        boolean equals = HERE_NLP_PACKAGE_NAME.equals(context.getPackageName());
        Log.i(TAG, "isRunningInNlpContext: %b", Boolean.valueOf(equals));
        return equals;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean isWifiScanEnabled(Context context) {
        boolean z = false;
        if (!hasWifi(context)) {
            return false;
        }
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        boolean isWifiEnabled = wifiManager.isWifiEnabled();
        if (isWifiEnabled) {
            return isWifiEnabled;
        }
        if (wifiManager.isScanAlwaysAvailable() && !isAirplaneModeEnabled(context)) {
            z = true;
        }
        return z;
    }
}
