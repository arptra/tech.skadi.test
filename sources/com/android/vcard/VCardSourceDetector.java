package com.android.vcard;

import android.util.Log;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VCardSourceDetector implements VCardInterpreter {
    public static Set d = new HashSet(Arrays.asList(new String[]{"X-PHONETIC-FIRST-NAME", "X-PHONETIC-MIDDLE-NAME", "X-PHONETIC-LAST-NAME", "X-ABADR", "X-ABUID"}));
    public static Set e = new HashSet(Arrays.asList(new String[]{"X-GNO", "X-GN", "X-REDUCTION"}));
    public static Set f = new HashSet(Arrays.asList(new String[]{"X-MICROSOFT-ASST_TEL", "X-MICROSOFT-ASSISTANT", "X-MICROSOFT-OFFICELOC"}));
    public static Set g = new HashSet(Arrays.asList(new String[]{"X-SD-VERN", "X-SD-FORMAT_VER", "X-SD-CATEGORIES", "X-SD-CLASS", "X-SD-DCREATED", "X-SD-DESCRIPTION"}));
    public static String h = "X-SD-CHAR_CODE";

    /* renamed from: a  reason: collision with root package name */
    public int f2397a;
    public int b;
    public String c;

    public void a(VCardProperty vCardProperty) {
        String d2 = vCardProperty.d();
        List h2 = vCardProperty.h();
        if (d2.equalsIgnoreCase("VERSION") && h2.size() > 0) {
            String str = (String) h2.get(0);
            if (str.equals("2.1")) {
                this.b = 0;
            } else if (str.equals("3.0")) {
                this.b = 1;
            } else if (str.equals("4.0")) {
                this.b = 2;
            } else {
                Log.w("vCard", "Invalid version string: " + str);
            }
        } else if (d2.equalsIgnoreCase(h)) {
            this.f2397a = 3;
            if (h2.size() > 0) {
                this.c = (String) h2.get(0);
            }
        }
        if (this.f2397a == 0) {
            if (f.contains(d2)) {
                this.f2397a = 4;
            } else if (g.contains(d2)) {
                this.f2397a = 3;
            } else if (e.contains(d2)) {
                this.f2397a = 2;
            } else if (d.contains(d2)) {
                this.f2397a = 1;
            }
        }
    }

    public void b() {
    }

    public void c() {
    }

    public void d() {
    }

    public void e() {
    }
}
