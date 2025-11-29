package com.share.connect.ble;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.easy.logger.EasyLog;
import java.util.Objects;

public class CarBluetoothMacRecord {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f9897a;

    public CarBluetoothMacRecord(Context context) {
        this.f9897a = context.getSharedPreferences("car_bluetooth_sha265_config", 0);
    }

    public static String e(String str, Context context) {
        return f("ble_" + str, context);
    }

    public static String f(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            EasyLog.a("CarBluetoothMacRecord", "phoneId empty");
            return null;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("car_bluetooth_sha265_config", 0);
        if (sharedPreferences != null) {
            try {
                return sharedPreferences.getString(str, (String) null);
            } catch (ClassCastException e) {
                EasyLog.d("CarBluetoothMacRecord", "get mac failed: ", e);
            }
        }
        return null;
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            EasyLog.a("CarBluetoothMacRecord", "addAction macInfo is null!");
            return;
        }
        SharedPreferences sharedPreferences = this.f9897a;
        if (sharedPreferences != null) {
            for (String next : sharedPreferences.getAll().keySet()) {
                try {
                    if (str2.equalsIgnoreCase(this.f9897a.getString(next, (String) null)) && g(str, next)) {
                        EasyLog.a("CarBluetoothMacRecord", "delete old key: " + next + ", macInfo: " + str2);
                        d(next, false);
                    }
                } catch (ClassCastException e) {
                    EasyLog.d("CarBluetoothMacRecord", "get mac failed: ", e);
                }
            }
            this.f9897a.edit().putString(str, str2).apply();
            EasyLog.a("CarBluetoothMacRecord", "sav successfully, phoneId:" + str + " macInfo:" + str2);
        }
    }

    public void b(String str, String str2) {
        a("ble_" + str, str2);
    }

    public void c(String str) {
        d(str, true);
    }

    public final void d(String str, boolean z) {
        SharedPreferences sharedPreferences = this.f9897a;
        if (sharedPreferences != null) {
            SharedPreferences.Editor remove = sharedPreferences.edit().remove(str);
            if (z && !TextUtils.isEmpty(str) && !str.startsWith("ble_")) {
                remove.remove("ble_" + str);
            }
            remove.apply();
            EasyLog.a("CarBluetoothMacRecord", "delete successfully, phoneId: " + str);
        }
    }

    public final boolean g(String str, String str2) {
        if (Objects.equals(str, str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str.startsWith("ble_") == str2.startsWith("ble_");
    }
}
