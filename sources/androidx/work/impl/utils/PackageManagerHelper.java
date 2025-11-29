package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.Logger;

public class PackageManagerHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2234a = Logger.i("PackageManagerHelper");

    public static int a(Context context, String str) {
        return context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, str));
    }

    public static boolean b(int i, boolean z) {
        return i == 0 ? z : i == 1;
    }

    public static void c(Context context, Class cls, boolean z) {
        String str = "disabled";
        try {
            if (z == b(a(context, cls.getName()), false)) {
                Logger e = Logger.e();
                String str2 = f2234a;
                e.a(str2, "Skipping component enablement for " + cls.getName());
                return;
            }
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z ? 1 : 2, 1);
            Logger e2 = Logger.e();
            String str3 = f2234a;
            StringBuilder sb = new StringBuilder();
            sb.append(cls.getName());
            sb.append(" ");
            sb.append(z ? "enabled" : str);
            e2.a(str3, sb.toString());
        } catch (Exception e3) {
            Logger e4 = Logger.e();
            String str4 = f2234a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls.getName());
            sb2.append("could not be ");
            if (z) {
                str = "enabled";
            }
            sb2.append(str);
            e4.b(str4, sb2.toString(), e3);
        }
    }
}
