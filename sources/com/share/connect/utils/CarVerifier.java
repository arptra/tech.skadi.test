package com.share.connect.utils;

import android.content.Context;
import android.text.TextUtils;
import com.easy.logger.EasyLog;
import com.share.connect.utils.CarVerificationData;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class CarVerifier {

    /* renamed from: a  reason: collision with root package name */
    public Context f9916a;
    public String b;

    public CarVerifier(Context context, String str) {
        this.f9916a = context;
        if (e(str)) {
            this.b = str;
        } else {
            this.b = "ccd.data";
        }
    }

    public final Reader a() {
        return "ccd.data".equals(this.b) ? c() : d();
    }

    public final Reader b() {
        EasyLog.a("CarVerifier", "getDataReader, file: " + this.b);
        if (this.f9916a != null) {
            return a();
        }
        EasyLog.c("CarVerifier", "getDataReader null context");
        return null;
    }

    public final Reader c() {
        EasyLog.a("CarVerifier", "getDefaultReader");
        try {
            return new InputStreamReader(this.f9916a.getResources().getAssets().open("ccd.data"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            EasyLog.c("CarVerifier", "getDefaultReader failed: " + e);
            return null;
        }
    }

    public final Reader d() {
        EasyLog.a("CarVerifier", "getReader, file: " + this.b);
        try {
            return new InputStreamReader(new FileInputStream(this.b), StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            EasyLog.c("CarVerifier", "getReader error: " + e);
            return null;
        }
    }

    public final boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            EasyLog.c("CarVerifier", "ccd file path is empty!");
            return false;
        }
        File file = new File(str);
        if (file.exists() && file.isFile() && file.canRead()) {
            return true;
        }
        EasyLog.c("CarVerifier", "ccd file path is invalid!");
        return false;
    }

    public String f() {
        Reader b2;
        try {
            b2 = b();
            String b3 = new CarVerificationData.Builder().a(b2).b();
            if (b2 != null) {
                b2.close();
            }
            return b3;
        } catch (IOException | IllegalArgumentException e) {
            EasyLog.c("CarVerifier", "readCarData exception: " + e);
            return null;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }
}
