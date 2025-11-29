package com.share.connect.ble;

import android.os.ParcelUuid;
import java.util.HashMap;
import java.util.Map;

public class Constants {

    /* renamed from: a  reason: collision with root package name */
    public static Map f9901a = new HashMap();
    public static Map b;

    public static class Keys {
    }

    public static class ServiceInfo {

        /* renamed from: a  reason: collision with root package name */
        public static final ParcelUuid f9902a = ParcelUuid.fromString("00002902-0000-1000-8000-00805F9B34FB");
        public static final ParcelUuid b = ParcelUuid.fromString("0000FCFB-0000-1000-8000-00805F9B34FB");
        public static final ParcelUuid c = ParcelUuid.fromString("00000001-0000-1000-8000-00805F9B34FB");
        public static final ParcelUuid d = ParcelUuid.fromString("00000002-0000-1000-8000-00805F9B34FB");
        public static final ParcelUuid e = ParcelUuid.fromString("00000003-0000-1000-8000-00805F9B34FB");
        public static final ParcelUuid f = ParcelUuid.fromString("2abcc850-9935-4f8a-ba84-123456789100");
        public static final ParcelUuid g = ParcelUuid.fromString("2abcc850-9935-4f8a-ba84-123456789101");
        public static final ParcelUuid h = ParcelUuid.fromString("2abcc850-9935-4f8a-ba84-123456789102");
    }

    static {
        HashMap hashMap = new HashMap();
        b = hashMap;
        hashMap.put("00001801-0000-1000-8000-00805f9b34fb", "Generic Attribute");
        b.put("00001800-0000-1000-8000-00805f9b34fb", "Generic Access");
        f9901a.put("00002a05-0000-1000-8000-00805f9b34fb", "Service Changed");
        f9901a.put("00002a00-0000-1000-8000-00805f9b34fb", "Device Name");
        f9901a.put("00002a01-0000-1000-8000-00805f9b34fb", "Appearance");
        f9901a.put("00002aa6-0000-1000-8000-00805f9b34fb", "Central Address Resolution");
        b.put(ServiceInfo.f.toString(), "UnionShare");
        f9901a.put(ServiceInfo.g.toString(), "Client info");
        f9901a.put(ServiceInfo.h.toString(), "Server connection info");
    }

    public static String a(String str) {
        String str2 = (String) f9901a.get(str);
        return str2 != null ? str2 : str;
    }

    public static String b(String str) {
        String str2 = (String) b.get(str);
        return str2 != null ? str2 : str;
    }
}
