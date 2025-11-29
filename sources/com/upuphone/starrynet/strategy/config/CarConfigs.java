package com.upuphone.starrynet.strategy.config;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;

public class CarConfigs {
    public static final List<String> ADV_DEFAULT_DISABLE_LIST = Arrays.asList(new String[]{MODEL_NAME_CAR_XE08, MODEL_NAME_CAR_CS11_PLUS, MODEL_NAME_CAR_417, MODEL_NAME_CAR_DX11, MODEL_NAME_CAR_HQ_E009, MODEL_NAME_CAR_L7, MODEL_NAME_CAR_L6});
    public static final String[] CAR_MANU_MODEL_MAP = {MODEL_NAME_CAR_DX11, MODEL_NAME_CAR_DX11, "SiEngine", MODEL_NAME_CAR_DX11, "Volvo", MODEL_NAME_CAR_417, "qti", MODEL_NAME_CAR_171, "SiEngine", MODEL_NAME_CAR_XE08, "999722", MODEL_NAME_CAR_XE08, "QUALCOMM", "EX11_A3", "ECARX", MODEL_NAME_CAR_BX11, "ECARX", MODEL_NAME_CAR_E371, "999722", MODEL_NAME_CAR_E371, "SiEngine", MODEL_NAME_CAR_E245, MODEL_NAME_CAR_E245_INT, MODEL_NAME_CAR_E245_INT, "DesaySV", MODEL_NAME_CAR_CS11_PLUS, "SiEngine", MODEL_NAME_CAR_DS11, "SiEngine", MODEL_NAME_CAR_E335, "jica", MODEL_NAME_CAR_145, "993201", MODEL_NAME_CAR_145, "111003", MODEL_NAME_CAR_E22H, "QUALCOMM", MODEL_NAME_CAR_CX11, "QUALCOMM", MODEL_NAME_CAR_DCY11, "QUALCOMM", MODEL_NAME_CAR_CS11, "999722", MODEL_NAME_CAR_E371_MX, "752003", MODEL_NAME_CAR_L946, "250060", MODEL_NAME_CAR_FS11_A3, "250060", MODEL_NAME_CAR_SX11_A5, "QTI", MODEL_NAME_CAR_HQ_E202, "LVE15", MODEL_NAME_CAR_HQ_E009, "111003", MODEL_NAME_CAR_E02_SX12_A2, "QTI", MODEL_NAME_CAR_L7, "QTI", MODEL_NAME_CAR_L6, "993201", MODEL_NAME_CAR_FS12_A1, "111003", MODEL_NAME_CAR_SS11_A3, "SiEngine", MODEL_NAME_CAR_V446K, "8019724", MODEL_NAME_CAR_P181, "222202", MODEL_NAME_CAR_P181, "8019724", MODEL_NAME_CAR_FX11_A2, "999722", MODEL_NAME_CAR_FX11_A2, "752003", MODEL_NAME_CAR_P177, "999722", MODEL_NAME_CAR_P177};
    public static final List<String> GC_ROLE_MODELS_4_PHONE = Arrays.asList(new String[]{MODEL_NAME_CAR_EX11, MODEL_NAME_CAR_145, MODEL_NAME_CAR_E22H, MODEL_NAME_CAR_CX11, MODEL_NAME_CAR_CS11, MODEL_NAME_CAR_DCY11, MODEL_NAME_CAR_FS11_A3, MODEL_NAME_CAR_SX11_A5, MODEL_NAME_CAR_SS11_A3});
    public static final List<String> GO_ROLE_MODELS_4_CAR = Arrays.asList(new String[]{MODEL_NAME_CAR_EX11, MODEL_NAME_CAR_145, MODEL_NAME_CAR_E22H});
    public static final String MODEL_NAME_CAR_145 = "P145";
    public static final String MODEL_NAME_CAR_171 = "E171";
    public static final String MODEL_NAME_CAR_417 = "PS4";
    public static final String MODEL_NAME_CAR_BX11 = "BX11_A2";
    public static final String MODEL_NAME_CAR_CS11 = "CS11";
    public static final String MODEL_NAME_CAR_CS11_PLUS = "CS11_A4";
    public static final String MODEL_NAME_CAR_CX11 = "CX11";
    public static final String MODEL_NAME_CAR_DCY11 = "DCY11";
    public static final String MODEL_NAME_CAR_DS11 = "se1000_ds11_slave";
    public static final String MODEL_NAME_CAR_DX11 = "se1000_dx11_slave";
    public static final String MODEL_NAME_CAR_E02_SX12_A2 = "SX12A2";
    public static final String MODEL_NAME_CAR_E22H = "E22H";
    public static final String MODEL_NAME_CAR_E245 = "antora1000_e245";
    public static final String MODEL_NAME_CAR_E245_INT = "Geely EX5";
    public static final String MODEL_NAME_CAR_E335 = "se1000_e335_slave";
    public static final String MODEL_NAME_CAR_E371 = "E371";
    public static final String MODEL_NAME_CAR_E371_MX = "E371_MX";
    public static final String MODEL_NAME_CAR_EX11 = "ex11";
    public static final String MODEL_NAME_CAR_FS11_A3 = "IHU623G";
    public static final String MODEL_NAME_CAR_FS12_A1 = "FS12-A1";
    public static final String MODEL_NAME_CAR_FX11_A2 = "FX11-A2";
    public static final String MODEL_NAME_CAR_HQ_E009 = "DHU3013009";
    public static final String MODEL_NAME_CAR_HQ_E202 = "FAW";
    public static final String MODEL_NAME_CAR_L6 = "G733";
    public static final String MODEL_NAME_CAR_L7 = "G636";
    public static final String MODEL_NAME_CAR_L946 = "L946";
    public static final String MODEL_NAME_CAR_P177 = "P177";
    public static final String MODEL_NAME_CAR_P181 = "P181";
    public static final String MODEL_NAME_CAR_SS11_A3 = "SS11-A3";
    public static final String MODEL_NAME_CAR_SX11_A5 = "IHU624G";
    public static final String MODEL_NAME_CAR_V446K = "se1000_v446kcn_slave";
    public static final String MODEL_NAME_CAR_XE08 = "DHU609G";
    public static final List<String> SUPPORT_CONNECTION_PROTOCOL_V3_CARS_LIST = Arrays.asList(new String[]{MODEL_NAME_CAR_EX11, MODEL_NAME_CAR_145, MODEL_NAME_CAR_DS11, MODEL_NAME_CAR_DX11, MODEL_NAME_CAR_E371, MODEL_NAME_CAR_E245, MODEL_NAME_CAR_E245_INT, MODEL_NAME_CAR_HQ_E202, MODEL_NAME_CAR_HQ_E009, MODEL_NAME_CAR_FS11_A3, MODEL_NAME_CAR_SX11_A5, MODEL_NAME_CAR_E22H, MODEL_NAME_CAR_E371_MX, MODEL_NAME_CAR_E02_SX12_A2, MODEL_NAME_CAR_L7, MODEL_NAME_CAR_L6, MODEL_NAME_CAR_FS12_A1, MODEL_NAME_CAR_SS11_A3, MODEL_NAME_CAR_L946, MODEL_NAME_CAR_V446K, MODEL_NAME_CAR_P181, MODEL_NAME_CAR_FX11_A2, MODEL_NAME_CAR_P177});

    public static boolean isCarProduct(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int length = CAR_MANU_MODEL_MAP.length / 2;
            for (int i = 0; i < length; i++) {
                String[] strArr = CAR_MANU_MODEL_MAP;
                int i2 = i * 2;
                String str3 = strArr[i2];
                String str4 = strArr[i2 + 1];
                if (str.equals(str3) && str2.equals(str4)) {
                    return true;
                }
            }
        }
        return false;
    }
}
