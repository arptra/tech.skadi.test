package com.share.connect.wifiap;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.easy.logger.EasyLog;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.honey.account.c3.a;
import com.honey.account.c3.b;
import com.honey.account.c3.e;
import java.lang.reflect.Method;

public class WifiApConfigHelper {

    /* renamed from: a  reason: collision with root package name */
    public final Object f9923a;

    public int a() {
        int i = Build.VERSION.SDK_INT;
        if (i < 30) {
            if (!(this.f9923a instanceof WifiConfiguration)) {
                return 0;
            }
            try {
                return ((Integer) WifiConfiguration.class.getDeclaredField("apBand").get(this.f9923a)).intValue();
            } catch (Exception e) {
                EasyLog.d("WifiApConfig", "apBand filed error: ", e);
                return 0;
            }
        } else if (i < 30) {
            EasyLog.c("WifiApConfig", "the version less than Android P don't support");
            return 0;
        } else if (!a.a(this.f9923a)) {
            return 0;
        } else {
            try {
                return ((Integer) e.a().getDeclaredMethod("getBand", (Class[]) null).invoke(this.f9923a, (Object[]) null)).intValue();
            } catch (Exception e2) {
                EasyLog.d("WifiApConfig", "getBand method error: ", e2);
                return 0;
            }
        }
    }

    public int b() {
        int i = Build.VERSION.SDK_INT;
        if (i < 30) {
            if (!(this.f9923a instanceof WifiConfiguration)) {
                return 0;
            }
            try {
                return ((Integer) WifiConfiguration.class.getDeclaredField("apChannel").get(this.f9923a)).intValue();
            } catch (Exception e) {
                EasyLog.d("WifiApConfig", "apChannel filed error: ", e);
                return 0;
            }
        } else if (i < 30) {
            EasyLog.c("WifiApConfig", "the version less than Android P don't support");
            return 0;
        } else if (!a.a(this.f9923a)) {
            return 0;
        } else {
            try {
                return ((Integer) e.a().getDeclaredMethod("getChannel", (Class[]) null).invoke(this.f9923a, (Object[]) null)).intValue();
            } catch (Exception e2) {
                EasyLog.d("WifiApConfig", "apChannel method error: ", e2);
                return 0;
            }
        }
    }

    public Object c() {
        return this.f9923a;
    }

    public String d() {
        int i = Build.VERSION.SDK_INT;
        if (i < 30) {
            Object obj = this.f9923a;
            if (obj instanceof WifiConfiguration) {
                return ((WifiConfiguration) obj).preSharedKey;
            }
            return null;
        } else if (i < 30) {
            EasyLog.c("WifiApConfig", "the version less than Android P don't support");
            return null;
        } else if (a.a(this.f9923a)) {
            return b.a(this.f9923a).getPassphrase();
        } else {
            return null;
        }
    }

    public String e() {
        int i = Build.VERSION.SDK_INT;
        if (i < 30) {
            Object obj = this.f9923a;
            if (obj instanceof WifiConfiguration) {
                return ((WifiConfiguration) obj).SSID;
            }
            return null;
        } else if (i < 30) {
            EasyLog.c("WifiApConfig", "the version less than Android P don't support");
            return null;
        } else if (a.a(this.f9923a)) {
            return b.a(this.f9923a).getSsid();
        } else {
            return null;
        }
    }

    public String toString() {
        return this.f9923a.toString();
    }

    public WifiApConfigHelper(Builder builder) {
        this.f9923a = builder.b;
    }

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public WifiManager f9924a;
        public Object b;
        public Object c;
        public Method d;
        public Method e;
        public Method f;
        public Method g;

        public Builder() {
            Class<String> cls = String.class;
            try {
                int i = Build.VERSION.SDK_INT;
                if (i < 30) {
                    this.b = Class.forName("android.net.wifi.WifiConfiguration").newInstance();
                } else if (i >= 30) {
                    Class<?> cls2 = Class.forName("android.net.wifi.SoftApConfiguration$Builder");
                    this.d = cls2.getMethod("setSsid", new Class[]{cls});
                    Class cls3 = Integer.TYPE;
                    this.e = cls2.getMethod("setPassphrase", new Class[]{cls, cls3});
                    this.f = cls2.getMethod("setChannel", new Class[]{cls3, cls3});
                    this.g = cls2.getMethod("setBand", new Class[]{cls3});
                    this.c = cls2.newInstance();
                } else {
                    throw new IllegalArgumentException("the version less than Android P don't support");
                }
            } catch (Exception e2) {
                EasyLog.d("WifiApConfig", "WifiApConfig constructor method error: ", e2);
            }
        }

        public WifiApConfigHelper b() {
            if (this.b == null && Build.VERSION.SDK_INT >= 30) {
                try {
                    this.b = Class.forName("android.net.wifi.SoftApConfiguration$Builder").getMethod(JsonPOJOBuilder.DEFAULT_BUILD_METHOD, (Class[]) null).invoke(this.c, (Object[]) null);
                } catch (Exception e2) {
                    EasyLog.d("WifiApConfig", "get SoftAp Configuration error: ", e2);
                }
            }
            return new WifiApConfigHelper(this);
        }

        public Builder c(int i) {
            try {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 < 30) {
                    Object obj = this.b;
                    if (obj != null) {
                        WifiConfiguration wifiConfiguration = (WifiConfiguration) obj;
                        wifiConfiguration.getClass().getDeclaredField("apBand").set(wifiConfiguration, Integer.valueOf(i));
                    }
                } else if (i2 >= 30) {
                    this.g.invoke(this.c, new Object[]{Integer.valueOf(i)});
                }
            } catch (Exception e2) {
                EasyLog.d("WifiApConfig", "setSsid error: ", e2);
            }
            return this;
        }

        public Builder d(int i) {
            try {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 < 30) {
                    Object obj = this.b;
                    if (obj != null) {
                        WifiConfiguration wifiConfiguration = (WifiConfiguration) obj;
                        wifiConfiguration.getClass().getDeclaredField("apChannel").set(wifiConfiguration, Integer.valueOf(i));
                    }
                } else if (i2 >= 30) {
                    this.f.invoke(this.c, new Object[]{Integer.valueOf(i), 2});
                }
            } catch (Exception e2) {
                EasyLog.d("WifiApConfig", "setSsid error: ", e2);
            }
            return this;
        }

        public Builder e(String str) {
            int i = Build.VERSION.SDK_INT;
            if (i < 30) {
                Object obj = this.b;
                if (obj != null) {
                    WifiConfiguration wifiConfiguration = (WifiConfiguration) obj;
                    wifiConfiguration.preSharedKey = str;
                    wifiConfiguration.allowedKeyManagement.set(4);
                }
            } else if (i >= 30) {
                try {
                    this.e.invoke(this.c, new Object[]{str, 1});
                } catch (Exception e2) {
                    EasyLog.d("WifiApConfig", "setSsid error: ", e2);
                }
            }
            return this;
        }

        public Builder f(String str) {
            int i = Build.VERSION.SDK_INT;
            if (i < 30) {
                Object obj = this.b;
                if (obj != null) {
                    ((WifiConfiguration) obj).SSID = str;
                }
            } else if (i >= 30) {
                try {
                    this.d.invoke(this.c, new Object[]{str});
                } catch (Exception e2) {
                    EasyLog.d("WifiApConfig", "setSsid error: ", e2);
                }
            }
            return this;
        }

        public Builder(WifiManager wifiManager) {
            this.f9924a = wifiManager;
            try {
                int i = Build.VERSION.SDK_INT;
                Class<WifiManager> cls = WifiManager.class;
                if (i < 30) {
                    this.b = cls.getMethod("getWifiApConfiguration", (Class[]) null).invoke(this.f9924a, (Object[]) null);
                } else if (i >= 30) {
                    this.b = cls.getMethod("getSoftApConfiguration", (Class[]) null).invoke(this.f9924a, (Object[]) null);
                } else {
                    throw new IllegalArgumentException("the version less than Android P don't support");
                }
            } catch (Exception e2) {
                EasyLog.d("WifiApConfig", "WifiApConfig constructor method error: ", e2);
            }
        }
    }
}
