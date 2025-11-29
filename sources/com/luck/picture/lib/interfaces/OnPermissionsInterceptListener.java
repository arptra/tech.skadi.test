package com.luck.picture.lib.interfaces;

import androidx.fragment.app.Fragment;

public interface OnPermissionsInterceptListener {
    boolean a(Fragment fragment, String[] strArr);

    void b(Fragment fragment, String[] strArr, OnRequestPermissionListener onRequestPermissionListener);
}
