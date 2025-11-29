package com.android.vcard;

import com.here.posclient.PositionEstimate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VCardConfig {

    /* renamed from: a  reason: collision with root package name */
    public static String f2369a = "v21_generic";
    public static int b = -1073741824;
    public static final Map c;
    public static final Set d;

    static {
        HashMap hashMap = new HashMap();
        c = hashMap;
        hashMap.put(f2369a, -1073741824);
        hashMap.put("v30_generic", -1073741823);
        hashMap.put("v21_europe", -1073741820);
        hashMap.put("v30_europe", -1073741819);
        hashMap.put("v21_japanese_utf8", -1073741816);
        hashMap.put("v30_japanese_utf8", -1073741815);
        hashMap.put("v21_japanese_mobile", 402653192);
        hashMap.put("docomo", 939524104);
        HashSet hashSet = new HashSet();
        d = hashSet;
        hashSet.add(-1073741816);
        hashSet.add(-1073741815);
        hashSet.add(402653192);
        hashSet.add(939524104);
    }

    public static int a(int i) {
        return i & 12;
    }

    public static boolean b(int i) {
        return d.contains(Integer.valueOf(i));
    }

    public static boolean c(int i) {
        return (i & 3) == 0;
    }

    public static boolean d(int i) {
        return (i & 3) == 1;
    }

    public static boolean e(int i) {
        return (i & 3) == 2;
    }

    public static boolean f(int i) {
        return (i & PositionEstimate.Value.GNSS_TIME) != 0;
    }

    public static boolean g() {
        return false;
    }
}
