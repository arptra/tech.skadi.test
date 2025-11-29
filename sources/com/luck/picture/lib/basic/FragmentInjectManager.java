package com.luck.picture.lib.basic;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.luck.picture.lib.R;
import com.luck.picture.lib.utils.ActivityCompatHelper;

public class FragmentInjectManager {
    public static void a(FragmentActivity fragmentActivity, String str, Fragment fragment) {
        if (ActivityCompatHelper.b(fragmentActivity, str)) {
            fragmentActivity.getSupportFragmentManager().s().c(R.id.fragment_container, fragment, str).h(str).k();
        }
    }

    public static void b(FragmentManager fragmentManager, String str, Fragment fragment) {
        fragmentManager.s().c(16908290, fragment, str).h(str).k();
    }
}
