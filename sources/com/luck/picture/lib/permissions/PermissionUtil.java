package com.luck.picture.lib.permissions;

import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.Fragment;

public class PermissionUtil {
    public static void a(Fragment fragment, int i) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", fragment.getActivity().getPackageName(), (String) null));
            fragment.startActivityForResult(intent, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean b(int[] iArr) {
        if (iArr.length <= 0) {
            return false;
        }
        for (int i : iArr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
