package com.luck.picture.lib;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.luck.picture.lib.basic.PictureCommonFragment;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnPermissionsInterceptListener;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.luck.picture.lib.permissions.PermissionResultCallback;
import com.luck.picture.lib.utils.SdkVersionUtils;
import com.luck.picture.lib.utils.ToastUtils;

public class PictureOnlyCameraFragment extends PictureCommonFragment {
    public static final String l = "PictureOnlyCameraFragment";

    public static PictureOnlyCameraFragment W1() {
        return new PictureOnlyCameraFragment();
    }

    public void O0(LocalMedia localMedia) {
        if (D0(localMedia, false) == 0) {
            Q0();
        } else {
            s1();
        }
    }

    public int W0() {
        return R.layout.ps_empty;
    }

    public void a1(String[] strArr) {
        boolean z;
        v1(false, (String[]) null);
        OnPermissionsInterceptListener onPermissionsInterceptListener = this.e.d1;
        if (onPermissionsInterceptListener != null) {
            z = onPermissionsInterceptListener.a(this, strArr);
        } else {
            z = PermissionChecker.c(getContext());
            if (!SdkVersionUtils.f()) {
                z = PermissionChecker.j(getContext());
            }
        }
        if (z) {
            D1();
        } else {
            if (!PermissionChecker.c(getContext())) {
                ToastUtils.c(getContext(), getString(R.string.ps_camera));
            } else if (!PermissionChecker.j(getContext())) {
                ToastUtils.c(getContext(), getString(R.string.ps_jurisdiction));
            }
            s1();
        }
        PermissionConfig.f9440a = new String[0];
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 0) {
            s1();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (bundle != null) {
            return;
        }
        if (SdkVersionUtils.f()) {
            D1();
            return;
        }
        final String[] strArr = {"android.permission.WRITE_EXTERNAL_STORAGE"};
        PermissionChecker.b().m(this, strArr, new PermissionResultCallback() {
            public void a() {
                PictureOnlyCameraFragment.this.D1();
            }

            public void b() {
                PictureOnlyCameraFragment.this.Z0(strArr);
            }
        });
    }
}
