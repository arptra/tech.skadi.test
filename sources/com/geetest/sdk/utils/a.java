package com.geetest.sdk.utils;

import android.content.Context;
import android.os.Build;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f2957a = {"goldfish"};
    public static final String[] b = {"/dev/socket/qemud", "/dev/qemu_pipe"};

    public static int a(Context context) {
        boolean z;
        try {
            boolean e = e();
            boolean b2 = b();
            if (!c("/proc/tty/drivers")) {
                if (!c("/proc/cpuinfo")) {
                    z = false;
                    return (!d() || e || b2 || z || f()) ? 1 : 0;
                }
            }
            z = true;
            if (!d()) {
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static boolean b() {
        for (String file : b) {
            if (new File(file).exists()) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(String str) {
        File file = new File(str);
        if (file.exists() && file.canRead()) {
            byte[] bArr = new byte[1024];
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                fileInputStream.read(bArr);
                fileInputStream.close();
            } catch (Exception unused) {
            }
            String str2 = new String(bArr);
            for (String contains : f2957a) {
                if (str2.contains(contains)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean d() {
        return s.a("ro.product.cpu.abi").contains("x86") || s.a("ro.product.cpu.abilist").contains("x86") || c.a().c("uname -m").contains("i686");
    }

    public static boolean e() {
        String str = Build.PRODUCT;
        if (str.contains("sdk") || str.contains("sdk_x86") || str.contains("sdk_google") || str.contains("Andy") || str.contains("Droid4X") || str.contains("nox") || str.contains("vbox86p")) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        if (str2.contains("Genymotion") || str2.contains("Andy") || str2.contains("nox") || str2.contains("TiantianVM") || Build.BRAND.contains("Andy")) {
            return true;
        }
        String str3 = Build.DEVICE;
        if (str3.contains("Andy") || str3.contains("Droid4X") || str3.contains("nox") || str3.contains("vbox86p")) {
            return true;
        }
        String str4 = Build.MODEL;
        if (str4.contains("Emulator") || str4.contains("google_sdk") || str4.contains("Droid4X") || str4.contains("TiantianVM") || str4.contains("Andy") || str4.contains("Android SDK built for x86_64") || str4.contains("Android SDK built for x86")) {
            return true;
        }
        String str5 = Build.HARDWARE;
        if (str5.contains("vbox86") || str5.contains("nox") || str5.contains("ttVM_x86")) {
            return true;
        }
        String str6 = Build.FINGERPRINT;
        return str6.contains("generic/sdk/generic") || str6.contains("generic_x86/sdk_x86/generic_x86") || str6.contains("Andy") || str6.contains("ttVM_Hdragon") || str6.contains("generic/google_sdk/generic") || str6.contains("vbox86p") || str6.contains("generic/vbox86p/vbox86p");
    }

    public static boolean f() {
        String str;
        try {
            Process start = new ProcessBuilder(new String[]{"/system/bin/cat", "/proc/cpuinfo"}).start();
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream(), "utf-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            bufferedReader.close();
            str = sb.toString().toLowerCase();
        } catch (Exception unused) {
            str = "$unknown";
        }
        return str.contains("intel") || str.contains("amd");
    }
}
