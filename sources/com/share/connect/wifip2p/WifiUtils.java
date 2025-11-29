package com.share.connect.wifip2p;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import androidx.collection.ArrayMap;
import com.alibaba.fastjson.asm.Opcodes;
import com.easy.logger.EasyLog;
import com.upuphone.starrynet.core.p2p.WiFiP2pBaseManager;
import com.upuphone.starrynet.core.p2p.WiFiP2pGOManager;
import java.util.Map;

public class WifiUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final ArrayMap f9960a = new ArrayMap<Integer, Integer>() {
        {
            put(1, Integer.valueOf(WiFiP2pBaseManager.BAND_24_GHZ_START_FREQ_MHZ));
            put(2, 2417);
            put(3, 2422);
            put(4, 2427);
            put(5, 2432);
            put(6, 2437);
            put(7, 2442);
            put(8, 2447);
            put(9, 2452);
            put(10, 2457);
            put(11, 2462);
            put(12, 2467);
            put(13, 2472);
            put(14, 2484);
            put(36, 5180);
            put(40, 5200);
            put(44, 5220);
            put(48, 5240);
            put(52, 5260);
            put(56, 5280);
            put(60, 5300);
            put(64, 5320);
            put(100, 5500);
            put(104, 5520);
            put(108, 5540);
            put(112, 5560);
            put(116, 5580);
            put(120, 5600);
            put(124, 5620);
            put(128, 5640);
            put(132, 5660);
            put(136, 5680);
            put(140, 5700);
            put(Integer.valueOf(Opcodes.FCMPL), Integer.valueOf(WiFiP2pGOManager.DEFAULT_GO_FREQUENCY));
            put(Integer.valueOf(Opcodes.IFEQ), 5765);
            put(157, 5785);
            put(Integer.valueOf(Opcodes.IF_ICMPLT), 5805);
            put(Integer.valueOf(Opcodes.IF_ACMPEQ), 5825);
        }
    };
    public static final ArrayMap b = new ArrayMap<Integer, Integer>() {
        {
            put(1, Integer.valueOf(WiFiP2pBaseManager.BAND_24_GHZ_START_FREQ_MHZ));
            put(36, 5180);
        }
    };

    public static int a(int i) {
        for (Map.Entry entry : b.entrySet()) {
            if (((Integer) entry.getValue()).intValue() == i) {
                return ((Integer) entry.getKey()).intValue();
            }
        }
        return 0;
    }

    public static int b(WifiManager wifiManager) {
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        int frequency = connectionInfo != null ? connectionInfo.getFrequency() : -1;
        EasyLog.e("WifiUtils", "Current AP frequency: " + frequency);
        return frequency;
    }

    public static int c(int i) {
        ArrayMap arrayMap = f9960a;
        if (arrayMap.containsKey(Integer.valueOf(i))) {
            return ((Integer) arrayMap.get(Integer.valueOf(i))).intValue();
        }
        return 0;
    }

    public static int d(int i, int i2, WifiManager wifiManager) {
        int b2 = b(wifiManager);
        int a2 = (b2 == -1 || ((b2 <= 5000 || i != 1) && (b2 >= 5000 || i != 0))) ? 0 : a(b2);
        if (a2 > 0) {
            EasyLog.e("WifiUtils", "Selected wifi sta channel: " + a2);
            return a2;
        } else if ((i2 >= 36 || i == 0) && b.containsKey(Integer.valueOf(i2))) {
            EasyLog.e("WifiUtils", "Selected wifi phone channel: " + i2);
            return i2;
        } else {
            int i3 = 14;
            int i4 = Opcodes.IF_ACMPEQ;
            for (Integer intValue : b.keySet()) {
                int intValue2 = intValue.intValue();
                if (intValue2 >= 36) {
                    i4 = Math.min(intValue2, i4);
                } else if (intValue2 >= 1) {
                    i3 = Math.min(intValue2, i3);
                }
            }
            if (i == 1) {
                i3 = i4;
            }
            EasyLog.e("WifiUtils", "Selected wifi min channel: " + i3);
            return i3;
        }
    }

    public static void e(int[] iArr) {
        b.clear();
        boolean z = false;
        boolean z2 = false;
        for (int i : iArr) {
            ArrayMap arrayMap = f9960a;
            if (arrayMap.containsKey(Integer.valueOf(i))) {
                b.put(Integer.valueOf(i), (Integer) arrayMap.get(Integer.valueOf(i)));
            }
            if (i >= 36) {
                z2 = true;
            } else {
                z = true;
            }
        }
        if (!z) {
            b.put(1, Integer.valueOf(WiFiP2pBaseManager.BAND_24_GHZ_START_FREQ_MHZ));
        }
        if (!z2) {
            b.put(36, 5180);
        }
        EasyLog.e("WifiUtils", "updateWifiChannelMaps: " + b.toString());
    }
}
