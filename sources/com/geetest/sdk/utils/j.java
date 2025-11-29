package com.geetest.sdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.util.ArrayList;
import org.json.JSONObject;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public static String f2962a = "$unknown";

    public static float a(Context context) {
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return 0.0f;
        }
        return (((float) registerReceiver.getIntExtra("level", 0)) * 100.0f) / ((float) registerReceiver.getIntExtra("scale", 100));
    }

    public static String b() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            long longValue = Long.valueOf(bufferedReader.readLine().split("\\s+")[1]).longValue();
            bufferedReader.close();
            double doubleValue = new BigDecimal((((double) longValue) / 1024.0d) / 1024.0d).setScale(2, 4).doubleValue();
            return doubleValue + "GB";
        } catch (Exception unused) {
            return "$unknown";
        }
    }

    public static String c() {
        ArrayList arrayList = new ArrayList();
        if (!"$unknown".equals(f2962a)) {
            return f2962a;
        }
        InetAddress[] inetAddressArr = new InetAddress[0];
        try {
            inetAddressArr = InetAddress.getAllByName("www.geetest.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (InetAddress hostAddress : inetAddressArr) {
            arrayList.add(hostAddress.getHostAddress());
        }
        f2962a = arrayList.toString();
        return arrayList.toString();
    }

    public static JSONObject d(Context context) {
        JSONObject jSONObject = new JSONObject();
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("level", -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            double d = (intExtra == -1 || intExtra2 == -1) ? -1.0d : ((double) intExtra) / ((double) intExtra2);
            int intExtra3 = registerReceiver.getIntExtra("status", -1);
            int intExtra4 = registerReceiver.getIntExtra("plugged", -1);
            int intExtra5 = registerReceiver.getIntExtra("health", -1);
            try {
                jSONObject.put("br", d + "");
                jSONObject.put("bs", intExtra3 + "");
                jSONObject.put("plugState", intExtra4 + "");
                jSONObject.put("health", intExtra5 + "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static boolean e(Context context) {
        String property = System.getProperty("http.proxyHost");
        String property2 = System.getProperty("http.proxyPort");
        if (property2 == null) {
            property2 = "-1";
        }
        return !TextUtils.isEmpty(property) && Integer.parseInt(property2) != -1;
    }
}
