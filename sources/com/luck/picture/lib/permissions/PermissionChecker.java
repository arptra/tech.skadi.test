package com.luck.picture.lib.permissions;

import android.content.Context;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.luck.picture.lib.basic.PictureCommonFragment;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.utils.ActivityCompatHelper;
import com.luck.picture.lib.utils.SdkVersionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PermissionChecker {

    /* renamed from: a  reason: collision with root package name */
    public static PermissionChecker f9439a;

    public static boolean a(Context context, String[] strArr) {
        if (strArr != null) {
            for (String checkSelfPermission : strArr) {
                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), checkSelfPermission) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static PermissionChecker b() {
        if (f9439a == null) {
            synchronized (PermissionChecker.class) {
                try {
                    if (f9439a == null) {
                        f9439a = new PermissionChecker();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f9439a;
    }

    public static boolean c(Context context) {
        return a(context, new String[]{"android.permission.CAMERA"});
    }

    public static boolean d(Context context) {
        return a(context, new String[]{"android.permission.READ_MEDIA_AUDIO"});
    }

    public static boolean e(Context context) {
        return a(context, new String[]{"android.permission.READ_EXTERNAL_STORAGE"});
    }

    public static boolean f(Context context) {
        return a(context, new String[]{"android.permission.READ_MEDIA_IMAGES"});
    }

    public static boolean g(int i, Context context) {
        return SdkVersionUtils.h() ? i == SelectMimeType.c() ? f(context) : i == SelectMimeType.d() ? h(context) : i == SelectMimeType.b() ? d(context) : f(context) && h(context) : e(context);
    }

    public static boolean h(Context context) {
        return a(context, new String[]{"android.permission.READ_MEDIA_VIDEO"});
    }

    public static boolean i(Context context, String[] strArr) {
        return a(context, strArr);
    }

    public static boolean j(Context context) {
        return a(context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});
    }

    public void k(int[] iArr, PermissionResultCallback permissionResultCallback) {
        if (PermissionUtil.b(iArr)) {
            permissionResultCallback.a();
        } else {
            permissionResultCallback.b();
        }
    }

    public final void l(Fragment fragment, List list, int i, PermissionResultCallback permissionResultCallback) {
        if (!ActivityCompatHelper.c(fragment.getActivity()) && (fragment instanceof PictureCommonFragment)) {
            FragmentActivity activity = fragment.getActivity();
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                for (String str : (String[]) it.next()) {
                    if (ContextCompat.checkSelfPermission(activity, str) != 0) {
                        arrayList.add(str);
                    }
                }
            }
            if (arrayList.size() > 0) {
                ((PictureCommonFragment) fragment).N1(permissionResultCallback);
                String[] strArr = new String[arrayList.size()];
                arrayList.toArray(strArr);
                fragment.requestPermissions(strArr, i);
                ActivityCompat.e(activity, strArr, i);
            } else if (permissionResultCallback != null) {
                permissionResultCallback.a();
            }
        }
    }

    public void m(Fragment fragment, String[] strArr, PermissionResultCallback permissionResultCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(strArr);
        l(fragment, arrayList, 10086, permissionResultCallback);
    }
}
