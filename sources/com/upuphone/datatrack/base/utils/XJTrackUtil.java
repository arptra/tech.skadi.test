package com.upuphone.datatrack.base.utils;

import android.content.Context;
import com.upuphone.datatrack.base.utils.gson.JsonUtil;
import java.util.HashMap;
import java.util.Map;

public class XJTrackUtil {

    /* renamed from: a  reason: collision with root package name */
    public static Map f6404a;

    public static Map a(Context context) {
        if (f6404a == null) {
            f6404a = new HashMap<String, Object>(context) {
                final /* synthetic */ Context val$context;

                {
                    this.val$context = r3;
                    put("_brand_", XJDeviceUtil.b());
                    put("_manufacturer_", XJDeviceUtil.k());
                    put("_device_model_", XJDeviceUtil.e());
                    put("_product_model_", XJDeviceUtil.r());
                    put("_os_type_", "android");
                    put("_os_", XJDeviceUtil.m());
                    put("_os_version_", XJDeviceUtil.n());
                    put("_build_mask_", XJDeviceUtil.c());
                    put("_screen_height_", Integer.valueOf(XJDeviceUtil.t(r3)));
                    put("_screen_width_", Integer.valueOf(XJDeviceUtil.u(r3)));
                    put("_app_key_", XJPackageUtil.a());
                    put("_app_name_", XJPackageUtil.c(r3));
                    put("_app_pkg_name_", XJPackageUtil.d(r3));
                    put("_app_ver_", XJPackageUtil.f(r3));
                    put("_app_model_", XJPackageUtil.b());
                    put("_app_ver_code_", Integer.valueOf(XJPackageUtil.e(r3)));
                    put("_sdk_type_", XJPackageUtil.g());
                    put("_sdk_version_", XJPackageUtil.h());
                    put("_debug_", Boolean.valueOf(XJPackageUtil.j()));
                }
            };
        }
        return f6404a;
    }

    public static String b(Context context, Map map) {
        return c(context, map, (String) null, (String) null, (String) null);
    }

    public static String c(Context context, Map map, String str, String str2, String str3) {
        map.putAll(a(context));
        map.put("_ter_type_", Integer.valueOf(XJDeviceUtil.v()));
        map.put("_sn_", XJDeviceUtil.s());
        map.put("_device_id_", XJDeviceUtil.d(context));
        map.put("_android_id_", XJDeviceUtil.a(context));
        map.put("_oaid_", XJDeviceUtil.l(context));
        map.put("_imei1_", XJDeviceUtil.o(context));
        map.put("_imei2_", XJDeviceUtil.p(context));
        map.put("_imsi1_", XJDeviceUtil.q(context));
        map.put("_imsi2_", XJDeviceUtil.q(context));
        if (!map.containsKey("_iot_device_id_")) {
            if (str == null) {
                str = XJDeviceUtil.f();
            }
            map.put("_iot_device_id_", str);
        }
        if (!map.containsKey("_iot_device_model_")) {
            if (str2 == null) {
                str2 = XJDeviceUtil.g();
            }
            map.put("_iot_device_model_", str2);
        }
        if (!map.containsKey("iot_device_rom")) {
            if (str3 == null) {
                str3 = XJDeviceUtil.h();
            }
            map.put("iot_device_rom", str3);
        }
        map.put("_iot_device_type_", Integer.valueOf(XJDeviceUtil.i()));
        map.put("_mac_address_", NetWorkUtil.a(context));
        map.put("_country_", LocationUtil.a(context));
        map.put("_lang_", XJDeviceUtil.j(context));
        map.put("_user_id_", XJPackageUtil.i());
        map.put("_event_id_", -1);
        if (map.get("_event_time_") == null) {
            map.put("_event_time_", Long.valueOf(System.currentTimeMillis()));
        }
        if (map.get("_page_") == null) {
            map.put("_page_", ActivityUtil.c());
        }
        if (map.get("_referrer_page_") == null) {
            map.put("_referrer_page_", ActivityUtil.e());
        }
        map.put("_network_type_", NetWorkUtil.b(context));
        map.put("_wifi_", Boolean.valueOf(NetWorkUtil.f(context)));
        map.put("_operator_", NetWorkUtil.c(context));
        map.put("_latitude_", LocationUtil.b(context));
        map.put("_longitude_", LocationUtil.c(context));
        map.put("_timezone_offset_", XJDeviceUtil.w());
        return JsonUtil.b(map);
    }
}
