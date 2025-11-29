package com.bun.miitmdid.content;

import android.text.TextUtils;
import com.ucar.vehiclesdk.MDevice;
import com.upuphone.starrynet.common.StarryNetConstant;

public class ProviderList {

    public enum DEVICE_PROVIDER {
        UNSUPPORT(-1, "unsupport"),
        HUA_WEI(0, "HUAWEI"),
        XIAOMI(1, "Xiaomi"),
        VIVO(2, MDevice.MANUFACTURERS_VIVO),
        OPPO(3, MDevice.MANUFACTURERS_OPPO),
        MOTO(4, "motorola"),
        LENOVO(5, "lenovo"),
        ASUS(6, "asus"),
        SAMSUNG(7, "samsung"),
        MEIZU(8, MDevice.MANUFACTURERS_MEIZU),
        NUBIA(10, "nubia"),
        ZTE(11, "ZTE"),
        ONEPLUS(12, StarryNetConstant.DEVICE_NAME_ONE_PLUS),
        BLACKSHARK(13, "blackshark"),
        FREEMEOS(30, "freemeos"),
        SSUIOS(31, "ssui");
        
        private int index;
        private String name;

        private DEVICE_PROVIDER(int i, String str) {
            this.index = i;
            this.name = str;
        }

        public static DEVICE_PROVIDER fromName(String str) {
            if (TextUtils.isEmpty(str)) {
                return UNSUPPORT;
            }
            DEVICE_PROVIDER[] values = values();
            for (int i = 0; i < 16; i++) {
                DEVICE_PROVIDER device_provider = values[i];
                if (device_provider.name.equalsIgnoreCase(str)) {
                    return device_provider;
                }
            }
            return UNSUPPORT;
        }
    }
}
