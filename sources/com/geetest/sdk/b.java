package com.geetest.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.geetest.sdk.model.beans.Gt3GeetestText;
import com.geetest.sdk.utils.GT3Protocol;
import com.geetest.sdk.utils.d;
import com.geetest.sdk.utils.l;
import com.geetest.sdk.utils.m;
import com.meizu.common.util.LunarCalendar;
import com.upuphone.starrynet.common.StarryNetConstant;
import java.util.Locale;
import java.util.UUID;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f2911a;
    public GT3ConfigBean b;
    public c c;
    public long d;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f2912a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.geetest.sdk.utils.GT3ServiceNode[] r0 = com.geetest.sdk.utils.GT3ServiceNode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2912a = r0
                com.geetest.sdk.utils.GT3ServiceNode r1 = com.geetest.sdk.utils.GT3ServiceNode.NODE_NORTH_AMERICA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f2912a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.geetest.sdk.utils.GT3ServiceNode r1 = com.geetest.sdk.utils.GT3ServiceNode.NODE_IPV6     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f2912a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.geetest.sdk.utils.GT3ServiceNode r1 = com.geetest.sdk.utils.GT3ServiceNode.NODE_CUSTOM     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f2912a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.geetest.sdk.utils.GT3ServiceNode r1 = com.geetest.sdk.utils.GT3ServiceNode.NODE_CHINA     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.geetest.sdk.b.a.<clinit>():void");
        }
    }

    /* renamed from: com.geetest.sdk.b$b  reason: collision with other inner class name */
    public interface C0012b {
        void a();

        void b();

        void c();

        void d();

        void e(String str, String str2);

        void f();

        void g();

        void h();

        void i();

        void j();
    }

    public b(Context context) {
        this.f2911a = context;
        if (context != null) {
            this.c = new c(context);
            a(context);
            m.b(context);
        }
    }

    public final void a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mydata", 0);
        if (StarryNetConstant.DEVICE_NAME_UNKNOWN.equals(sharedPreferences.getString("uuid", StarryNetConstant.DEVICE_NAME_UNKNOWN))) {
            sharedPreferences.edit().putString("uuid", UUID.randomUUID().toString()).apply();
        }
    }

    public void b(GT3ConfigBean gT3ConfigBean) {
        String str;
        a.b(this.f2911a);
        l.b(gT3ConfigBean.p());
        l.c("GeetestUtilsHolder", "GT3Version-->4.4.2.1");
        this.b = gT3ConfigBean;
        h();
        Locale locale = this.f2911a.getApplicationContext().getResources().getConfiguration().getLocales().get(0);
        StringBuilder sb = new StringBuilder();
        sb.append("Lang-->");
        String str2 = "null";
        sb.append(TextUtils.isEmpty(gT3ConfigBean.g()) ? str2 : gT3ConfigBean.g());
        sb.append(", Default Lang-->");
        sb.append(locale.getLanguage());
        l.c("GeetestUtilsHolder", sb.toString());
        if (TextUtils.isEmpty(gT3ConfigBean.g())) {
            String str3 = "";
            if (TextUtils.equals("in", locale.getLanguage())) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("id");
                if (!TextUtils.isEmpty(locale.getCountry())) {
                    str3 = LunarCalendar.DATE_SEPARATOR + locale.getCountry();
                }
                sb2.append(str3);
                gT3ConfigBean.w(sb2.toString());
            } else {
                if (TextUtils.isEmpty(locale.getLanguage())) {
                    str = "zh";
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(locale.getLanguage());
                    if (!TextUtils.isEmpty(locale.getCountry())) {
                        str3 = LunarCalendar.DATE_SEPARATOR + locale.getCountry();
                    }
                    sb3.append(str3);
                    str = sb3.toString();
                }
                gT3ConfigBean.w(str);
            }
        } else if (gT3ConfigBean.g().equals("in")) {
            gT3ConfigBean.w("id");
        }
        Gt3GeetestText.m(this.f2911a, gT3ConfigBean.g());
        GT3Protocol e = gT3ConfigBean.e();
        if (e != null) {
            if (e == GT3Protocol.HTTP) {
                d.f2960a = "http://";
            } else {
                d.f2960a = "https://";
            }
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Parsed Lang-->");
        if (!TextUtils.isEmpty(gT3ConfigBean.g())) {
            str2 = gT3ConfigBean.g();
        }
        sb4.append(str2);
        l.c("GeetestUtilsHolder", sb4.toString());
        this.c.b(gT3ConfigBean);
        this.c.a(i());
    }

    public void c() {
        this.c.f();
        this.f2911a = null;
    }

    public c d() {
        return this.c;
    }

    public void e() {
        GT3ConfigBean gT3ConfigBean = this.b;
        if (gT3ConfigBean == null || gT3ConfigBean.f() == null) {
            this.c.d("api.geetest.com");
        } else {
            int i = a.f2912a[this.b.f().ordinal()];
            if (i == 1) {
                this.c.d("api-na.geetest.com");
            } else if (i == 2) {
                this.c.d("apiv6.geetest.com");
            } else if (i != 3) {
                this.c.d("api.geetest.com");
                d.b = new String[]{"api.geetest.com", "api.geevisit.com"};
            } else {
                String[] l = this.b.l();
                if (l != null && l.length > 0) {
                    this.c.d(l[0]);
                    d.b = l;
                }
            }
        }
        this.c.o();
    }

    public void f() {
        this.c.m();
    }

    public void g() {
        if (System.currentTimeMillis() - this.d >= 1000) {
            this.d = System.currentTimeMillis();
            GT3ConfigBean gT3ConfigBean = this.b;
            if (gT3ConfigBean == null || gT3ConfigBean.f() == null) {
                this.c.d("api.geetest.com");
            } else {
                int i = a.f2912a[this.b.f().ordinal()];
                if (i == 1) {
                    this.c.d("api-na.geetest.com");
                } else if (i == 2) {
                    this.c.d("apiv6.geetest.com");
                } else if (i != 3) {
                    this.c.d("api.geetest.com");
                    d.b = new String[]{"api.geetest.com", "api.geevisit.com"};
                } else {
                    String[] l = this.b.l();
                    if (l != null && l.length > 0) {
                        this.c.d(l[0]);
                        d.b = l;
                    }
                }
            }
            this.c.n();
        }
    }

    public final void h() {
        GT3ConfigBean gT3ConfigBean = this.b;
        if (gT3ConfigBean == null) {
            l.c("GeetestUtilsHolder", "GT3ConfigBean cannot be null !");
            throw new IllegalArgumentException("GT3ConfigBean cannot be null !");
        } else if (gT3ConfigBean.h() != null) {
            Context context = this.f2911a;
            if (context == null) {
                l.c("GeetestUtilsHolder", "Context cannot be null !");
                throw new IllegalArgumentException("Context cannot be null !");
            } else if (!(context instanceof Activity)) {
                l.c("GeetestUtilsHolder", "Context must be activity type !");
                throw new IllegalArgumentException("Context must be activity type !");
            }
        } else {
            l.c("GeetestUtilsHolder", "Listener cannot be null !");
            throw new IllegalArgumentException("Listener cannot be null !");
        }
    }

    public final int i() {
        if (this.b.j() == 2) {
            return 2;
        }
        this.b.j();
        return 1;
    }
}
