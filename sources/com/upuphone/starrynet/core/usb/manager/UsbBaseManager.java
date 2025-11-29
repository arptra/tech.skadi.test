package com.upuphone.starrynet.core.usb.manager;

public class UsbBaseManager {
    public String getMtpMode() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"sys.usb.config"});
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
