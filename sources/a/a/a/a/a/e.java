package a.a.a.a.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;

public class e {
    public static String a(Context context, String str) {
        Signature[] b = b(context, str);
        if (b == null || b.length == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Signature byteArray : b) {
            stringBuffer.append(d.a(byteArray.toByteArray()));
        }
        return stringBuffer.toString();
    }

    public static Signature[] b(Context context, String str) {
        if (!(str == null || str.length() == 0 || context == null)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
                if (packageInfo == null) {
                    return null;
                }
                return packageInfo.signatures;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }
}
